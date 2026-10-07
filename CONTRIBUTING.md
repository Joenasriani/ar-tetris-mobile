# Contributing to AR Tetris XR

Thanks for helping improve the project.

AR Tetris XR spans three current targets:

- mobile WebXR AR
- Meta Quest / immersive XR
- native Android

Contributions may focus on one platform or on gameplay consistency across editions.

## Before you start

1. Read `README.md`, `ROADMAP.md`, and `ARCHITECTURE.md`.
2. Check existing issues before starting substantial work.
3. For larger changes, open an issue first.
4. Keep pull requests focused and platform-specific where possible.

## Good contribution areas

### WebXR / mobile AR

- floor placement and hit-test stability
- WebXR session lifecycle
- touch controls
- mobile browser compatibility
- Three.js performance
- spatial UI
- fallback mode

### Meta Quest / XR

- controller input
- replay/recenter behavior
- in-world UI
- haptics
- immersive-session performance
- headset-specific QA

### Android

- game-engine extraction
- automated tests
- Gradle reproducibility
- touch and lifecycle QA
- accessibility
- performance

### Shared gameplay

- documenting intended rules
- identifying divergence between editions
- scoring/level consistency
- rotation/collision correctness

## Development flow

1. Fork the repository.
2. Start from the branch for the edition you are changing:
   - `main` for WebXR / mobile AR / Meta Quest
   - `APK` for native Android
3. Make the smallest change that solves the issue.
4. Test on the relevant target.
5. Add or update tests where practical.
6. Open a pull request using the repository template.

## Pull request expectations

Include:

- platform/edition affected
- what changed
- why it is useful
- exact testing performed
- device/browser/headset details when relevant
- screenshots or recordings for visible changes
- known limitations

Avoid unrelated cleanup in the same PR.

## Bug reports

For WebXR/XR reports include:

- browser
- device/headset
- XR mode used
- reproduction steps
- expected vs actual result

For Android reports include:

- device
- Android version
- reproduction steps
- expected vs actual result

## License

By contributing, you agree that your contribution may be distributed under the repository's MIT License.

Do not contribute code, media, trademarks, or other material that you do not have the right to submit.
