[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# Spatial Tetris XR

An open-source spatial falling-block game with two active implementations:

- **WebXR / mobile AR / Meta Quest-class browsers** on `main`
- **Native Android** on `android`

The WebXR implementation requires browser/device support for WebXR `immersive-ar`. The Android edition is built with Kotlin and Jetpack Compose.

## WebXR / spatial edition

The `main` branch contains the browser-based spatial edition.

Verified in the current code:

- Three.js 3D rendering
- WebXR `immersive-ar` capability checks and session startup
- required `hit-test` support with optional `dom-overlay` and `local-floor`
- floor hit-testing and smoothed placement reticle
- physical board placement and recenter/reset behavior
- 10 × 20 board and seven tetromino types
- movement, rotation, hard drop, locking and line clears
- score, levels and next-piece preview
- touch controls for handheld AR-capable devices
- headset/browser detection
- tracked-controller/gamepad input paths
- in-world intro and game-over/replay UI for headset-style XR use
- haptic feedback paths
- local best-score persistence
- music and gameplay audio
- XR-safe line-clear animation
- optional gameplay recording/sharing where `MediaRecorder` and canvas `captureStream()` are supported

The code also contains a non-immersive `startFallback3D()` helper, but the current launch UI does **not** expose it as a normal play mode when `immersive-ar` is unavailable.

## Native Android edition

The `android` branch contains the native Android implementation.

Verified stack and configuration:

- Kotlin
- Jetpack Compose
- Android DataStore
- minSdk 26
- targetSdk / compileSdk 36
- portrait activity
- no declared network or dangerous permissions
- release signing and Android App Bundle configuration for Google Play

Current gameplay includes a 10 × 20 board, seven tetrominoes, line clearing, scoring, levels, next-piece preview, touch controls, pause/replay, and local best-score storage.

## Project direction

The goal is to evolve one game lineage across spatial web/XR and native Android while keeping gameplay behavior consistent where appropriate.

Contributors can work on WebXR, headset XR behavior, Android, or cross-edition gameplay correctness.

Any idea is welcome if it can produce a real improvement, experiment, feature, design, tool, performance gain, accessibility gain, or useful extension. The current game is the starting point, not the ceiling.

## Contributing

Start with:

- [Contributing](CONTRIBUTING.md)
- [Architecture](ARCHITECTURE.md)
- [Development](DEVELOPMENT.md)
- [Roadmap](ROADMAP.md)
- [Issues](https://github.com/Joenasriani/spatial-tetris-xr/issues)

## Branches

- `main` — project landing + WebXR/mobile AR/Meta Quest-class implementation
- `android` — native Android implementation
- older development branches are historical and can be cleaned up after the default-branch switch

## Run the WebXR edition

Use a secure HTTPS origin.

Requirements:

- WebGL
- `navigator.xr`
- WebXR `immersive-ar`
- camera/tracking permission
- `hit-test` support

Entry point:

```text
index.html
```

## Build the Android edition

Switch to the Android branch first:

```bash
git switch android
```

Requirements:

- JDK 17
- Android SDK compatible with API 36
- compatible Gradle installation

Debug build:

```bash
gradle :app:assembleDebug
```

Release bundle:

```bash
gradle :app:bundleRelease
```

See [PLAYSTORE_RELEASE.md](https://github.com/Joenasriani/spatial-tetris-xr/blob/android/PLAYSTORE_RELEASE.md) for signing and Play release notes.

## Open source

Source code is released under the **MIT License**. See `LICENSE`.

The license covers repository source code. It does not grant rights to third-party trademarks, brand names, or separately licensed assets.

## Independence

This is an independent falling-block puzzle project and is not affiliated with or endorsed by Tetris Holding or The Tetris Company.

## Creator

Joe Nasr  
https://joe-nasr-signals.vercel.app/
