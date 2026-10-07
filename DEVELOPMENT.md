# Development

## Project shape

The current Android edition is a single-app Gradle project.

- Language: Kotlin
- UI: Jetpack Compose
- Minimum SDK: 26
- Target SDK: 36
- Compile SDK: 36
- Local persistence: Android DataStore
- Main application source: `app/src/main/java/com/artetris/mobile/MainActivity.kt`

The current implementation keeps the Compose UI, game state, game rules, scoring, piece movement, collision logic and persistence wiring close together. That makes the project easy to read initially, but it also creates a clear refactoring and testing opportunity for contributors.

## Requirements

- JDK 17
- Android SDK compatible with compile SDK 36
- Gradle/Android tooling supported by the project files

## Build

From the repository root:

```bash
gradle :app:assembleDebug
```

For a release bundle:

```bash
gradle :app:bundleRelease
```

Release signing values are described in `PLAYSTORE_RELEASE.md`.

## What to test manually

At minimum, verify:

- New game starts correctly
- Left/right movement respects board bounds
- Rotation does not overlap locked pieces
- Hard drop locks the piece correctly
- Completed rows clear correctly
- Score and level progression remain consistent
- Pause/resume works
- Best score persists after relaunch
- Touch targets remain usable on small and large phones
- Portrait layouts do not clip controls or the board

## Automated testing gap

There is currently no dedicated `app/src/test` or `app/src/androidTest` source set in the repository. Adding deterministic tests for the pure game rules is one of the highest-value contributor opportunities.

A useful direction is to extract game-rule functions and state transitions into testable Kotlin classes that do not depend on Compose or Android framework objects.

## Scope discipline

Prefer changes that are:

- Small enough to review
- Easy to verify
- Backward-compatible with the current game unless an issue explicitly calls for a behavior change
- Documented when they alter architecture or contribution workflow
