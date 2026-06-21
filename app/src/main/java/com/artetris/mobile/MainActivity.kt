package com.artetris.mobile

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.math.floor
import kotlin.random.Random

private val Context.dataStore by preferencesDataStore("ar_tetris_user_data")
private val BestScoreKey = intPreferencesKey("best_score")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ARTetrisApp(TetrisRepository(this)) }
    }
}

private class TetrisRepository(private val context: Context) {
    val bestScore: Flow<Int> = context.dataStore.data.map { it[BestScoreKey] ?: 0 }
    suspend fun saveBestScore(score: Int) {
        context.dataStore.edit { prefs -> if (score > (prefs[BestScoreKey] ?: 0)) prefs[BestScoreKey] = score }
    }
}

private enum class PlayState { Ready, Playing, GameOver, Paused }
private data class Piece(val type: Int, val rotation: Int, val x: Int, val y: Int)
private data class GameUiState(
    val board: List<List<Int>> = emptyBoard(),
    val piece: Piece? = null,
    val nextType: Int = Random.nextInt(Shapes.size),
    val score: Int = 0,
    val lines: Int = 0,
    val level: Int = 1,
    val state: PlayState = PlayState.Ready
)

private fun emptyBoard() = List(BoardHeight) { List(BoardWidth) { 0 } }
private const val BoardWidth = 10
private const val BoardHeight = 20
private const val MinDropMs = 80L
private val PieceColors = listOf(
    Color.Transparent, Color(0xFF00F0F0), Color(0xFFF0F000), Color(0xFFA000F0),
    Color(0xFF00F000), Color(0xFFF00000), Color(0xFF0000F0), Color(0xFFF0A000)
)
private val Shapes = listOf(
    listOf(listOf(listOf(1, 1, 1, 1)), listOf(listOf(1), listOf(1), listOf(1), listOf(1))),
    listOf(listOf(listOf(1, 1), listOf(1, 1))),
    listOf(listOf(listOf(0, 1, 0), listOf(1, 1, 1)), listOf(listOf(1, 0), listOf(1, 1), listOf(1, 0)), listOf(listOf(1, 1, 1), listOf(0, 1, 0)), listOf(listOf(0, 1), listOf(1, 1), listOf(0, 1))),
    listOf(listOf(listOf(0, 1, 1), listOf(1, 1, 0)), listOf(listOf(1, 0), listOf(1, 1), listOf(0, 1))),
    listOf(listOf(listOf(1, 1, 0), listOf(0, 1, 1)), listOf(listOf(0, 1), listOf(1, 1), listOf(1, 0))),
    listOf(listOf(listOf(1, 0, 0), listOf(1, 1, 1)), listOf(listOf(1, 1), listOf(1, 0), listOf(1, 0)), listOf(listOf(1, 1, 1), listOf(0, 0, 1)), listOf(listOf(0, 1), listOf(0, 1), listOf(1, 1))),
    listOf(listOf(listOf(0, 0, 1), listOf(1, 1, 1)), listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), listOf(listOf(1, 1, 1), listOf(1, 0, 0)), listOf(listOf(1, 1), listOf(0, 1), listOf(0, 1)))
)

@Composable
private fun ARTetrisApp(repository: TetrisRepository) {
    val scope = rememberCoroutineScope()
    val bestScore by repository.bestScore.collectAsState(initial = 0)
    var game by remember { mutableStateOf(GameUiState()) }
    fun start() { game = spawn(GameUiState(state = PlayState.Playing, nextType = Random.nextInt(Shapes.size))) }
    fun commit(newGame: GameUiState) {
        game = newGame
        if (newGame.state == PlayState.GameOver) scope.launch { repository.saveBestScore(newGame.score) }
    }
    val dropMs = (500L * Math.pow(0.82, (game.level - 1).toDouble())).toLong().coerceAtLeast(MinDropMs)
    LaunchedEffect(game.state, game.level, game.piece) {
        while (game.state == PlayState.Playing) {
            delay(dropMs)
            commit(tick(game))
        }
    }
    MaterialTheme { GameScreen(game, bestScore, ::start, { commit(move(game, -1)) }, { commit(move(game, 1)) }, { commit(rotate(game)) }, { commit(hardDrop(game)) }, { game = game.copy(state = if (game.state == PlayState.Paused) PlayState.Playing else PlayState.Paused) }) }
}

@Composable
private fun GameScreen(game: GameUiState, bestScore: Int, onStart: () -> Unit, onLeft: () -> Unit, onRight: () -> Unit, onRotate: () -> Unit, onDrop: () -> Unit, onPause: () -> Unit) {
    var dragY by remember { mutableFloatStateOf(0f) }
    Box(Modifier.fillMaxSize().background(Brush.radialGradient(listOf(Color(0xFF202040), Color(0xFF07070C)))).statusBarsPadding().navigationBarsPadding().pointerInput(game.state) {
        detectTapGestures { offset ->
            if (game.state != PlayState.Playing) return@detectTapGestures
            when { offset.x < size.width * .33f -> onLeft(); offset.x > size.width * .66f -> onRight(); else -> onRotate() }
        }
    }.pointerInput(game.state) {
        detectDragGestures(onDragStart = { dragY = 0f }, onDrag = { _, drag -> dragY += drag.y }, onDragEnd = { if (game.state == PlayState.Playing && dragY > 90f) onDrop() })
    }) {
        Hud(game, bestScore, Modifier.align(Alignment.TopStart).padding(16.dp))
        NextPreview(game.nextType, Modifier.align(Alignment.TopEnd).padding(16.dp))
        TetrisBoard(game, Modifier.align(Alignment.Center).padding(horizontal = 20.dp).fillMaxWidth().aspectRatio(.5f))
        Controls(game, onLeft, onRight, onRotate, onDrop, onPause, Modifier.align(Alignment.BottomCenter).padding(16.dp))
        if (game.state != PlayState.Playing) Overlay(game, bestScore, onStart)
    }
}

@Composable private fun Hud(game: GameUiState, best: Int, modifier: Modifier) = Glass(modifier) { Column { Text("SCORE ${game.score}", color = Color(0xFFFFDC00), fontWeight = FontWeight.Bold); Text("LINES ${game.lines}", color = Color.White); Text("LEVEL ${game.level}", color = Color.Cyan); Text("BEST $best", color = Color.LightGray, fontSize = 12.sp) } }
@Composable private fun NextPreview(type: Int, modifier: Modifier) = Glass(modifier.width(78.dp)) { Column(horizontalAlignment = Alignment.CenterHorizontally) { Text("NEXT", color = Color.Cyan, fontWeight = FontWeight.Black, fontSize = 12.sp); MiniPiece(type) } }
@Composable private fun Glass(modifier: Modifier = Modifier, content: @Composable PaddingValues.() -> Unit) = Box(modifier.background(Color(0xCC141414), RoundedCornerShape(16.dp)).border(1.dp, Color.White.copy(.13f), RoundedCornerShape(16.dp)).padding(12.dp)) { PaddingValues().content() }

@Composable private fun TetrisBoard(game: GameUiState, modifier: Modifier) {
    val flash by animateFloatAsState(if (game.state == PlayState.GameOver) .35f else 0f, label = "flash")
    Canvas(modifier) {
        val cell = size.width / BoardWidth
        val left = 0f; val top = (size.height - cell * BoardHeight) / 2f
        drawRoundRect(Color.Black.copy(.55f), Offset(left, top), Size(cell * BoardWidth, cell * BoardHeight))
        val merged = mergedBoard(game)
        for (y in 0 until BoardHeight) for (x in 0 until BoardWidth) drawCell(x, y, merged[y][x], cell, top)
        for (x in 0..BoardWidth) drawLine(Color.White.copy(.10f), Offset(x * cell, top), Offset(x * cell, top + cell * BoardHeight))
        for (y in 0..BoardHeight) drawLine(Color.White.copy(.10f), Offset(0f, top + y * cell), Offset(cell * BoardWidth, top + y * cell))
        if (flash > 0f) drawRect(Color.Red.copy(flash))
    }
}
private fun DrawScope.drawCell(x: Int, y: Int, value: Int, cell: Float, top: Float) { if (value <= 0) return; val inset = cell * .08f; drawRoundRect(PieceColors[value], Offset(x * cell + inset, top + y * cell + inset), Size(cell - inset * 2, cell - inset * 2)); drawRoundRect(Color.White.copy(.22f), Offset(x * cell + inset, top + y * cell + inset), Size(cell - inset * 2, (cell - inset * 2) * .28f)) }
@Composable private fun MiniPiece(type: Int) { Canvas(Modifier.size(44.dp)) { val shape = Shapes[type][0]; val cell = size.width / 4.5f; val ox = (size.width - shape[0].size * cell) / 2; val oy = (size.height - shape.size * cell) / 2; for (y in shape.indices) for (x in shape[y].indices) if (shape[y][x] == 1) drawRoundRect(PieceColors[type + 1], Offset(ox + x * cell, oy + y * cell), Size(cell * .85f, cell * .85f)) } }

@Composable private fun Controls(game: GameUiState, onLeft: () -> Unit, onRight: () -> Unit, onRotate: () -> Unit, onDrop: () -> Unit, onPause: () -> Unit, modifier: Modifier) = Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) { listOf("◀" to onLeft, "⟳" to onRotate, "▼" to onDrop, "▶" to onRight, if (game.state == PlayState.Paused) "PLAY" to onPause else "Ⅱ" to onPause).forEach { (label, action) -> Button(onClick = action, enabled = game.state == PlayState.Playing || label == "PLAY", colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2D2D44))) { Text(label) } } }
@Composable private fun Overlay(game: GameUiState, bestScore: Int, onStart: () -> Unit) = Box(Modifier.fillMaxSize().background(Color.Black.copy(.58f)), contentAlignment = Alignment.Center) { Glass(Modifier.padding(28.dp).fillMaxWidth()) { Column(horizontalAlignment = Alignment.CenterHorizontally) { Text(if (game.state == PlayState.GameOver) "GAME OVER" else "ROCKIN'\nTETRIS", color = if (game.state == PlayState.GameOver) Color(0xFFFF4136) else Color(0xFF8A2BE2), fontWeight = FontWeight.Black, fontSize = 38.sp, textAlign = TextAlign.Center); Spacer(Modifier.height(12.dp)); Text("Score ${game.score}  •  Lines ${game.lines}  •  Level ${game.level}\nBest $bestScore", color = Color.White, textAlign = TextAlign.Center); Spacer(Modifier.height(20.dp)); Button(onClick = onStart) { Text(if (game.state == PlayState.GameOver) "REPLAY" else "START GAME") }; Text("Tap left/right to move, center to rotate, swipe down to hard drop.", color = Color.LightGray, fontSize = 12.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 12.dp)) } } }

private fun mergedBoard(game: GameUiState): List<List<Int>> { val mutable = game.board.map { it.toMutableList() }; game.piece?.let { p -> shapeOf(p).forEachIndexed { y, row -> row.forEachIndexed { x, v -> if (v == 1) { val bx = p.x + x; val by = p.y + y; if (by in 0 until BoardHeight && bx in 0 until BoardWidth) mutable[by][bx] = p.type + 1 } } } }; return mutable }
private fun shapeOf(piece: Piece) = Shapes[piece.type][piece.rotation]
private fun spawn(game: GameUiState): GameUiState { val type = game.nextType; val shape = Shapes[type][0]; val piece = Piece(type, 0, (BoardWidth - shape[0].size) / 2, 0); return if (isValid(game.board, piece)) game.copy(piece = piece, nextType = Random.nextInt(Shapes.size), state = PlayState.Playing) else game.copy(state = PlayState.GameOver, piece = null) }
private fun tick(game: GameUiState): GameUiState { if (game.state != PlayState.Playing) return game; val p = game.piece ?: return spawn(game); val down = p.copy(y = p.y + 1); return if (isValid(game.board, down)) game.copy(piece = down) else spawn(lock(game)) }
private fun move(game: GameUiState, dx: Int): GameUiState { val p = game.piece ?: return game; val moved = p.copy(x = p.x + dx); return if (game.state == PlayState.Playing && isValid(game.board, moved)) game.copy(piece = moved) else game }
private fun rotate(game: GameUiState): GameUiState { val p = game.piece ?: return game; val next = (p.rotation + 1) % Shapes[p.type].size; for (kick in listOf(0, 1, -1, 2, -2)) { val rotated = p.copy(rotation = next, x = p.x + kick); if (game.state == PlayState.Playing && isValid(game.board, rotated)) return game.copy(piece = rotated) }; return game }
private fun hardDrop(game: GameUiState): GameUiState { var g = game; while (g.state == PlayState.Playing && g.piece != null && isValid(g.board, g.piece!!.copy(y = g.piece!!.y + 1))) g = g.copy(piece = g.piece!!.copy(y = g.piece!!.y + 1)); return if (g.state == PlayState.Playing) spawn(lock(g)) else g }
private fun isValid(board: List<List<Int>>, piece: Piece): Boolean { shapeOf(piece).forEachIndexed { y, row -> row.forEachIndexed { x, v -> if (v == 1) { val bx = piece.x + x; val by = piece.y + y; if (bx !in 0 until BoardWidth || by >= BoardHeight || (by >= 0 && board[by][bx] > 0)) return false } } }; return true }
private fun lock(game: GameUiState): GameUiState { val p = game.piece ?: return game; val board = game.board.map { it.toMutableList() }; shapeOf(p).forEachIndexed { y, row -> row.forEachIndexed { x, v -> if (v == 1) { val by = p.y + y; val bx = p.x + x; if (by in 0 until BoardHeight && bx in 0 until BoardWidth) board[by][bx] = p.type + 1 } } }; val kept = board.filter { row -> row.any { it == 0 } }; val cleared = BoardHeight - kept.size; val newBoard = List(cleared) { MutableList(BoardWidth) { 0 } } + kept; val points = mapOf(1 to 100, 2 to 300, 3 to 500, 4 to 800)[cleared] ?: 0; val lines = game.lines + cleared; return game.copy(board = newBoard, piece = null, score = game.score + points, lines = lines, level = floor(lines / 5.0).toInt() + 1) }
