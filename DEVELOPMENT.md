# Development

## Editions

AR Tetris XR currently has two implementation branches.

### WebXR / spatial edition

Branch: `main`

Primary files:

- `index.html`
- `music/`
- `vercel.json`

The WebXR edition is a static web application using Three.js and WebXR APIs.

It supports:

- mobile WebXR AR where immersive AR is available
- Meta Quest / headset XR behavior
- a non-immersive `startFallback3D()` helper exists, but the current launcher does not expose it when AR is unavailable

### Native Android edition

Branch: `android`

Stack:

- Kotlin
- Jetpack Compose
- Android DataStore
- minSdk 26
- targetSdk / compileSdk 36

Primary source:

```text
app/src/main/java/com/artetris/mobile/MainActivity.kt
```

## WebXR requirements

- HTTPS for immersive AR outside localhost
- WebGL
- browser support for `navigator.xr`
- `immersive-ar` support for room placement
- camera/tracking permission
- headset browser/controller support for immersive XR paths

## Android requirements

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

The repository currently does not commit a Gradle wrapper; issue #17 tracks that contributor task.

## Manual test matrix

### WebXR / mobile AR

- capability detection
- AR session start
- floor reticle acquisition
- board placement
- touch move/rotate/drop
- line clear
- game over/replay
- reset/recenter
- audio
- best score
- AR-required messaging when `immersive-ar` is unavailable; test fallback behavior only after/if it is wired into the launcher

### Meta Quest / XR

- controller placement/start
- controller movement/rotation/drop
- input debounce
- haptics
- in-world intro
- in-world game over/replay
- reset/recenter
- visibility/session interruption
- frame stability during line-clear animation

### Android

- new game
- movement boundaries
- rotation collision
- hard drop
- line clears
- score/level progression
- pause/resume
- best-score persistence
- multiple screen sizes

## Testing gaps

The Android edition currently has no dedicated `app/src/test` or `app/src/androidTest` source set.

The WebXR edition also lacks a structured automated test harness for the pure gameplay rules.

Both are valid contribution opportunities.
