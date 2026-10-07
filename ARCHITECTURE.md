# Architecture

AR Tetris XR currently has two substantial code paths that implement the same game lineage.

## WebXR / spatial edition

Branch: `main`

Primary entry point:

```text
index.html
```

The current WebXR implementation combines:

- Three.js scene/render setup
- WebXR session capability checks
- immersive-AR startup
- hit-test floor placement
- placement reticle smoothing
- board placement/recenter logic
- headset/mobile UI branching
- tracked-controller/gamepad input
- touch input
- haptics
- media recording
- audio
- game state
- tetromino definitions
- movement/rotation/collision
- line clearing
- scoring and levels
- next-piece preview
- best-score persistence
- in-world headset UI

### WebXR trade-off

The single-file implementation is practical and easy to deploy, but XR platform handling, UI and game rules are tightly coupled.

Useful evolution should separate concerns without destroying the simple static-host deployment model.

## Native Android edition

Branch: `APK`

Primary source:

```text
app/src/main/java/com/artetris/mobile/MainActivity.kt
```

The Android implementation currently contains:

- activity bootstrap
- DataStore persistence
- game state
- tetromino definitions
- Compose UI
- touch/drag input
- board rendering
- movement/rotation/collision
- hard drop and locking
- line clearing
- scoring and levels

### Android trade-off

UI, persistence and game rules are coupled in one Kotlin file.

The highest-value Android architectural improvement is to extract a pure Kotlin engine for testability.

## Cross-platform opportunity

Both editions implement the same core falling-block rules independently.

A useful long-term goal is **behavioral consistency**, not forced code sharing.

Contributors should first document and test the intended rules so WebXR and Android can be compared reliably.

## What not to do

Avoid architecture work that adds complexity without improving:

- testability
- platform reliability
- contributor clarity
- gameplay correctness
- performance

The project should remain approachable to outside contributors.
