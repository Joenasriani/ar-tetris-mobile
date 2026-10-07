[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

3つのターゲットで展開するオープンソースの空間型落ち物パズルゲームです。

- **モバイルWeb** — モバイルブラウザで直接プレイ可能。対応端末では **WebXR AR**
- **Meta Quest / XRヘッドセット** — トラッキングコントローラーと空間UIを備えた没入型WebXR
- **ネイティブAndroid** — Kotlin + Jetpack Compose版を開発中

ブラウザベースの空間ゲームとして始まり、現在はモバイルWeb、対応端末のWebXR AR、Meta Quest / XR、ネイティブAndroidへ展開しています。

## 現在の実装

### WebXR / モバイルAR
`main` ブランチには、Three.js 3Dレンダリング、immersive-AR判定、床hit-test、空間配置、10 × 20ボード、7種類のテトリミノ、移動・回転・ハードドロップ・固定・ライン消去、スコア、レベル、次ピース、タッチ操作、ローカル最高スコア、音声、XR-safeアニメーション、3Dフォールバックが含まれます。

### Meta Quest / XR
同じWebXRコードに、ヘッドセット判定、トラッキングコントローラー/gamepad、配置・ゲーム入力、空間UI、リプレイ、ハプティクス、リセンター処理があります。

### ネイティブAndroid
`APK` ブランチには Kotlin + Jetpack Compose + Android DataStore のAndroid版があります。

> `APK` はコンパイル済みAPKではなくソースコードです。

## プロジェクト方針
**モバイルWeb AR → Meta Quest / 没入型XR → ネイティブAndroid**

## コントリビューション
`ROADMAP.md`、`ARCHITECTURE.md`、`CONTRIBUTING.md` を参照してください。

## ブランチ
- `main` — WebXR / モバイルAR / Meta Quest
- `APK` — ネイティブAndroid

## オープンソース
ソースコードは **MIT License** で公開されています。 `LICENSE` を参照してください。

## 独立性
Tetris Holding または The Tetris Company とは提携・承認関係にない独立プロジェクトです。

## Creator
Joe Nasr  
https://joe-nasr-signals.vercel.app/
