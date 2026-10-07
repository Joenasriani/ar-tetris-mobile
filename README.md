[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

An open-source spatial falling-block game with three active targets:

- **Mobile Web** — playable directly in a mobile browser, with **WebXR AR** on supported devices
- **Meta Quest / XR headsets** — immersive WebXR with tracked-controller input and in-world UI
- **Native Android** — Kotlin + Jetpack Compose edition under active development

The project began as a browser-based spatial game. It can be played directly on mobile web, enters WebXR AR on supported devices, supports Meta Quest/XR headsets, and now also has a native Android edition in development.

## What exists today

### WebXR / mobile AR

The `main` branch contains the browser-based spatial edition.

Verified in the current code:

- Three.js 3D rendering
- WebXR immersive-AR capability checks
- floor hit-testing and placement reticle
- physical board placement in the detected space
- 10 × 20 board
- seven tetromino types
- movement, rotation, hard drop, locking and line clears
- score, levels and next-piece preview
- touch controls for handheld devices
- local best-score persistence
- music and gameplay audio
- XR-safe line-clear animation
- fallback 3D mode when immersive AR is unavailable

### Meta Quest / headset XR

The same WebXR code includes headset-aware behavior:

- headset/browser detection
- tracked-controller/gamepad handling
- controller input during placement and gameplay
- in-world intro UI
- in-world game-over/replay UI
- haptic feedback paths
- board placement and recenter/reset behavior designed for immersive XR

### Native Android

The current default `APK` branch contains the native Android edition built with:

- Kotlin
- Jetpack Compose
- Android DataStore
- minSdk 26
- targetSdk / compileSdk 36

The Android edition currently includes:

- 10 × 20 board
- seven tetrominoes
- line clearing
- scoring and levels
- next-piece preview
- touch controls
- pause and replay
- local best-score storage
- Google Play release-bundle configuration

> The default branch is named `APK`, but it contains source code, not a compiled APK.

## Project direction

The goal is not to replace one platform with another.

The goal is to evolve one game lineage across:

**mobile web AR → Meta Quest / immersive XR → native Android**

Contributors can work on one platform or on shared gameplay behavior across editions.

## Where contributors can help

### WebXR / mobile AR

- placement stability and floor detection
- mobile browser compatibility
- touch/gesture behavior
- Three.js performance
- XR session lifecycle
- fallback-mode behavior
- recording/media behavior
- spatial UI polish

### Meta Quest / XR

- controller mappings
- headset-specific UX
- in-world UI readability
- replay/recenter flow
- haptics
- performance in immersive sessions
- device-specific testing

### Android

- extracting the game engine from `MainActivity.kt`
- deterministic unit tests
- touch/gesture responsiveness
- lifecycle and persistence QA
- accessibility
- performance and device coverage
- new gameplay modes

See `ROADMAP.md`, `ARCHITECTURE.md`, and `CONTRIBUTING.md`.

## Branches

- `main` — WebXR / mobile AR / Meta Quest spatial edition
- `APK` — native Android edition and current default branch
- historical branches are retained for development history

## Running the WebXR edition

The WebXR build requires a secure HTTPS origin for immersive AR.

Suitable hosts include any static HTTPS host.

The main entry point is:

```text
index.html
```

The build uses Three.js via an import map and local audio assets under `music/`.

## Building the Android edition

Requirements:

- JDK 17
- Android SDK compatible with API 36
- Gradle compatible with the project configuration

Debug build:

```bash
gradle :app:assembleDebug
```

Release bundle:

```bash
gradle :app:bundleRelease
```

See `PLAYSTORE_RELEASE.md` for signing and Play release notes.

## Open source

The source code in this repository is released under the **MIT License**. See `LICENSE`.

The license covers repository source code. It does not grant rights to third-party trademarks, brand names, or assets with separate ownership or licensing terms.

## Independence

This is an independent falling-block puzzle project and is not affiliated with or endorsed by Tetris Holding or The Tetris Company.

## Creator

Joe Nasr  
https://joe-nasr-signals.vercel.app/
