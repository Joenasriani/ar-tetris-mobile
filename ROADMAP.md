# Roadmap

This roadmap is a contribution map, not a promise of release dates.

## Track 1 — Correctness and tests

Goal: make the core game rules easy to verify.

- Extract pure game logic from `MainActivity.kt`
- Add deterministic unit tests
- Test piece movement and board boundaries
- Test rotation near walls and locked pieces
- Test hard drop and piece locking
- Test single and multi-line clears
- Test score and level progression
- Test game-over conditions

## Track 2 — Controls and accessibility

Goal: make the game reliable across real Android devices.

- Audit touch target sizes
- Improve gesture conflict handling
- Add clearer control feedback
- Test one-handed play
- Review contrast and text readability
- Add accessibility semantics/content descriptions where appropriate
- Verify behavior with larger font/display settings

## Track 3 — Device quality

Goal: make the game robust across phones.

- Test small and tall aspect ratios
- Test multiple Android versions from minSdk upward
- Profile frame/render performance
- Check lifecycle behavior when backgrounding/resuming
- Verify DataStore persistence
- Audit pause/resume edge cases

## Track 4 — Gameplay evolution

Goal: add replay value without destabilizing the core.

Possible contribution areas:

- Alternative speed curves
- Optional ghost piece
- Hold-piece mechanic
- Additional scoring modes
- Challenge modes
- Visual/audio polish
- Haptic feedback

Each gameplay change should be proposed through an issue first and include clear acceptance criteria.

## Track 5 — Developer experience

Goal: make contribution friction low.

- Reproducible local build
- Automated build checks
- Test execution in CI
- Clear release notes
- Versioned releases
- Contributor documentation
- Maintain a small set of `good first issue` tasks

## Contribution principle

Prefer **small, reviewable, testable improvements** over large rewrites.


## Live contributor tasks

The current contributor queue is tracked in GitHub Issues:

- [#15 — Extract the game rules from MainActivity into a pure Kotlin engine](https://github.com/Joenasriani/ar-tetris-mobile/issues/15)
- [#16 — Add deterministic unit tests for movement, rotation, locking and line clears](https://github.com/Joenasriani/ar-tetris-mobile/issues/16)
- [#17 — Add a committed Gradle wrapper for reproducible contributor builds](https://github.com/Joenasriani/ar-tetris-mobile/issues/17)
- [#18 — Audit touch controls and gesture conflicts on real Android devices](https://github.com/Joenasriani/ar-tetris-mobile/issues/18)
- [#19 — Improve accessibility semantics, touch targets and large-text behavior](https://github.com/Joenasriani/ar-tetris-mobile/issues/19)
- [#20 — Audit lifecycle, pause/resume and best-score persistence](https://github.com/Joenasriani/ar-tetris-mobile/issues/20)
- [#21 — Add an optional ghost-piece mode](https://github.com/Joenasriani/ar-tetris-mobile/issues/21)

Issues labeled `help wanted` are deliberately open for outside contributors. Issue #17 is also marked `good first issue`.
