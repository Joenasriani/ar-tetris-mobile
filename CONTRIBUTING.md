# Contributing to AR Tetris: Android Edition

Thanks for helping improve the project.

This repository is the native Android edition of the AR Tetris game lineage, built with Kotlin and Jetpack Compose. Contributions should improve gameplay correctness, code quality, accessibility, performance, device compatibility, documentation, or well-scoped new capabilities.

## Before you start

1. Read `README.md` and `DEVELOPMENT.md`.
2. Check existing issues before starting substantial work.
3. For larger changes, open an issue first so the approach can be discussed.
4. Keep pull requests focused. One clear change is easier to review and merge than a large mixed refactor.

## Good contribution areas

- Gameplay correctness and edge cases
- Touch and gesture responsiveness
- Rotation and collision behavior
- Automated tests for game rules
- Accessibility and readable controls
- Performance on lower-end Android devices
- Layout behavior across screen sizes
- Refactoring game logic away from UI code
- Documentation and reproducible build instructions
- New game modes that do not break the core rules

## Development flow

1. Fork the repository.
2. Create a branch from the current default branch.
3. Make the smallest change that solves the issue.
4. Build and test locally.
5. Add or update tests when behavior changes.
6. Open a pull request using the repository PR template.

## Pull request expectations

A strong pull request should include:

- What changed
- Why the change is useful
- How it was tested
- Screenshots or recordings for visible UI changes
- Any known limitations or follow-up work

Avoid unrelated cleanup inside the same pull request.

## Bug reports

Please include:

- Device and Android version
- Exact steps to reproduce
- Expected result
- Actual result
- Whether the issue happens every time
- Screenshot or recording when useful

## License

By contributing, you agree that your contribution may be distributed under the repository's MIT License.

Do not contribute code, media, trademarks, or other material that you do not have the right to submit.
