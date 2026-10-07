# Architecture

## Current implementation

The native Android edition is intentionally compact. Most of the current application lives in:

```text
app/src/main/java/com/artetris/mobile/MainActivity.kt
```

That file currently contains:

- Android activity bootstrap
- DataStore-backed best-score persistence
- Game state models
- Tetromino definitions
- Compose UI
- Touch and drag input
- Board rendering
- Piece movement
- Rotation and simple wall kicks
- Collision checks
- Hard drop
- Piece locking
- Line clearing
- Scoring
- Level progression

## Current trade-off

The compact layout makes the project easy to inspect, but game rules, persistence, input and Compose UI are coupled together.

The highest-value architectural improvement is therefore **separation for testability**, not adding framework complexity.

## Suggested evolution

### Game engine

Pure Kotlin with no Compose or Android dependencies.

Responsibilities:

- Board state
- Active piece state
- Movement validation
- Rotation
- Collision
- Locking
- Line clears
- Scoring
- Level progression

### Piece source

A small abstraction for selecting the next piece.

This would allow deterministic tests and future experimentation with randomization strategies without coupling them to the UI.

### Persistence

Keep best-score persistence behind a small interface so the game engine does not depend on DataStore.

### Compose UI

Keep rendering and Android input handling in the UI layer. The UI should translate gestures/buttons into engine actions rather than own game rules.

## What not to do

Avoid turning this small game into an unnecessarily large architecture exercise.

A useful refactor should:

- Make behavior easier to test
- Make bugs easier to isolate
- Preserve existing gameplay unless an issue explicitly changes it
- Keep the code approachable to new contributors
