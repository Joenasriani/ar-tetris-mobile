# Spatial Tetris XR — Native Android Edition

This branch contains the native Android implementation of Spatial Tetris XR.

For the project overview, WebXR/mobile AR implementation, Meta Quest/XR paths, translations, contributor guide, architecture and roadmap, see the `main` branch:

https://github.com/Joenasriani/spatial-tetris-xr

## Stack

- Kotlin
- Jetpack Compose
- Android DataStore
- minSdk 26
- targetSdk / compileSdk 36
- portrait activity
- no declared network permission
- no dangerous permissions declared

## Current gameplay

- 10 × 20 board
- seven tetrominoes
- line clearing
- score and level progression
- next-piece preview
- touch controls
- pause and replay
- local best-score persistence

## Build

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

The repository does not currently commit a Gradle wrapper. Issue #17 tracks that contributor task.

See `PLAYSTORE_RELEASE.md` for release signing and Google Play notes.

## Current architecture

Most Android gameplay, UI and persistence logic currently lives in:

```text
app/src/main/java/com/artetris/mobile/MainActivity.kt
```

That compact structure is functional but creates a clear contributor opportunity to extract a pure Kotlin game engine and add deterministic tests.

## Contributing

Use the project-level contributor docs on `main`:

- https://github.com/Joenasriani/spatial-tetris-xr/blob/main/CONTRIBUTING.md
- https://github.com/Joenasriani/spatial-tetris-xr/blob/main/ARCHITECTURE.md
- https://github.com/Joenasriani/spatial-tetris-xr/blob/main/DEVELOPMENT.md
- https://github.com/Joenasriani/spatial-tetris-xr/blob/main/ROADMAP.md

Android contributor tasks are tracked in GitHub Issues with the `[Android]` prefix.

## Open source

Source code is released under the MIT License.

## Independence

This is an independent falling-block puzzle project and is not affiliated with or endorsed by Tetris Holding or The Tetris Company.
