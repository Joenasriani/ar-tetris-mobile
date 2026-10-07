# AR Tetris: Android Edition

A native Android falling-block puzzle game built with **Kotlin** and **Jetpack Compose**.

This repository is the current Android edition of Joe Nasr's AR Tetris game lineage. The project is open source and intended to be easy to inspect, fork, improve and contribute to.

> The default branch is currently named `APK`, but it contains source code — not a compiled APK.

## Current game

The Android edition currently includes:

- 10 × 20 board
- Seven tetromino types
- Line clearing
- Score and level progression
- Next-piece preview
- Touch controls
- Pause and replay
- Local best-score storage with Android DataStore
- Release-bundle configuration for Google Play

## Tech

- Kotlin
- Jetpack Compose
- Android Gradle Plugin
- DataStore
- minSdk 26
- targetSdk / compileSdk 36

## Run it

Requirements:

- JDK 17
- Android SDK compatible with API 36

Build a debug APK:

```bash
./gradlew assembleDebug
```

Build the release bundle:

```bash
./gradlew bundleRelease
```

For release-signing details, see `PLAYSTORE_RELEASE.md`.

## Where contributors can help

The current implementation keeps much of the UI, game state and game rules in `MainActivity.kt`. That makes the project approachable, but it also creates useful engineering work.

High-value areas include:

- Extracting the game engine into testable Kotlin classes
- Adding deterministic unit tests for movement, rotation, locking, line clears, scoring and level progression
- Improving touch and gesture behavior
- Testing layouts across more Android screen sizes
- Accessibility improvements
- Performance profiling on lower-end devices
- New game modes that preserve the core game
- Documentation and build reproducibility

See `ROADMAP.md` for contribution tracks and `CONTRIBUTING.md` before opening a pull request.

## Project structure

The current Android entry point is:

```text
app/src/main/java/com/artetris/mobile/MainActivity.kt
```

Additional implementation notes are in `ARCHITECTURE.md`.

## Historical lineage

Historical names for this project include:

- Rockin' Tetris
- Tetris MR
- AR Tetris Mobile Quest

Earlier browser and spatial builds explored AR and VR presentation. The current default branch focuses on the native Android edition.

## Distribution model

The Android edition is prepared for an upfront paid Google Play listing. It does not contain subscriptions, ads or in-app checkout.

## Open-source license

The source code in this repository is released under the **MIT License**. See `LICENSE`.

The license covers the repository's source code. It does not grant rights to third-party trademarks, brand names, or assets that may have separate ownership or licensing terms.

## Independence

This is an independent falling-block puzzle project and is not affiliated with or endorsed by Tetris Holding or The Tetris Company.

## Creator

Joe Nasr  
https://joe-nasr-signals.vercel.app/
