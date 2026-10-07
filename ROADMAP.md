# Roadmap

This roadmap is a contribution map, not a promise of release dates.

## Track 1 — Shared gameplay correctness

Goal: keep the game rules reliable across editions.

- document the intended rule set
- verify movement, rotation, locking and line clears
- compare WebXR and Android behavior
- reduce accidental divergence between editions
- add deterministic tests where practical

## Track 2 — WebXR / mobile AR

Goal: make room-scale mobile AR placement stable and usable.

- improve floor-placement robustness
- test hit-test recovery and reticle stability
- test supported mobile AR browsers
- audit touch and gesture conflicts
- verify session start/stop behavior
- decide whether to expose the existing fallback 3D helper as a supported non-AR launch mode
- profile Three.js rendering on mobile hardware

## Track 3 — Meta Quest / immersive XR

Goal: make headset play feel intentional rather than adapted from mobile.

- validate controller mappings
- improve controller repeat/debounce behavior
- test placement with tracked controllers
- improve in-world intro/game-over UI
- verify replay/recenter flow
- test haptics
- profile performance in immersive WebXR sessions
- test headset visibility/session interruptions

## Track 4 — Native Android

Goal: mature the Kotlin/Jetpack Compose edition.

- extract pure game logic from `MainActivity.kt`
- add deterministic unit tests
- add a committed Gradle wrapper
- audit touch controls
- improve accessibility
- verify lifecycle and best-score persistence
- test multiple Android devices and aspect ratios

## Track 5 — Gameplay evolution

Goal: add replay value without destabilizing the core.

Possible areas:

- ghost piece
- hold piece
- alternative speed curves
- challenge modes
- additional scoring modes
- haptics and feedback
- visual/audio polish

Gameplay additions should be proposed through issues with clear acceptance criteria.

## Track 6 — Developer experience

Goal: make outside contribution low-friction.

- reproducible builds
- automated checks
- platform-specific test instructions
- clear release notes
- versioned releases
- screenshots/video showing all three targets
- maintain a small set of `good first issue` tasks

## Live contributor tasks

### Android

- [#15 — Extract the game rules from MainActivity into a pure Kotlin engine](https://github.com/Joenasriani/spatial-tetris-xr/issues/15)
- [#16 — Add deterministic unit tests for movement, rotation, locking and line clears](https://github.com/Joenasriani/spatial-tetris-xr/issues/16)
- [#17 — Add a committed Gradle wrapper for reproducible contributor builds](https://github.com/Joenasriani/spatial-tetris-xr/issues/17)
- [#18 — Audit touch controls and gesture conflicts on real Android devices](https://github.com/Joenasriani/spatial-tetris-xr/issues/18)
- [#19 — Improve accessibility semantics, touch targets and large-text behavior](https://github.com/Joenasriani/spatial-tetris-xr/issues/19)
- [#20 — Audit lifecycle, pause/resume and best-score persistence](https://github.com/Joenasriani/spatial-tetris-xr/issues/20)
- [#21 — Add an optional ghost-piece mode](https://github.com/Joenasriani/spatial-tetris-xr/issues/21)

### WebXR / Meta Quest / XR

- [#23 — Audit floor hit-test stability and board placement recovery](https://github.com/Joenasriani/spatial-tetris-xr/issues/23)
- [#24 — Validate Meta Quest controller mappings, debounce and replay flow](https://github.com/Joenasriani/spatial-tetris-xr/issues/24)
- [#25 — Audit Meta Quest in-world UI readability and comfort](https://github.com/Joenasriani/spatial-tetris-xr/issues/25)
- [#26 — Audit mobile touch controls across AR and fallback modes](https://github.com/Joenasriani/spatial-tetris-xr/issues/26)
- [#27 — Add a lightweight WebXR test harness for shared gameplay rules](https://github.com/Joenasriani/spatial-tetris-xr/issues/27)
- [#28 — Profile Three.js rendering and XR line-clear animation](https://github.com/Joenasriani/spatial-tetris-xr/issues/28)

Issues labeled `help wanted` are deliberately open for outside contributors. Issues #17 and #27 are marked `good first issue`.

## Contribution principle

Prefer **small, reviewable, testable improvements** over large rewrites.
