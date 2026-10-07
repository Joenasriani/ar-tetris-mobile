[English](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.md) · [Français](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.fr.md) · [العربية](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.ar.md) · [简体中文](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.zh-CN.md) · [日本語](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.ja.md) · [한국어](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.ko.md) · [हिन्दी](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.hi.md) · [Bahasa Indonesia](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.id.md) · [Tiếng Việt](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.vi.md)

# AR Tetris XR — WebXR / Meta Quest Edition

This branch contains the browser edition of **AR Tetris XR**. The current launcher requires WebXR `immersive-ar`; it targets compatible mobile AR browsers/devices and includes headset-aware XR paths for Meta Quest-class browsers.

The project spans three targets:

- **Mobile WebXR AR** — requires WebXR `immersive-ar` support
- **Meta Quest / immersive XR**
- **Native Android** on the `APK` branch

## What this branch implements

The current WebXR code includes:

- Three.js 3D rendering
- WebXR immersive-AR capability detection
- floor hit testing
- smoothed placement reticle
- physical board placement
- mobile touch controls
- tracked-controller/gamepad handling
- Meta Quest/headset-aware UI behavior
- in-world intro and game-over/replay UI
- haptic paths
- optional gameplay recording/sharing where `MediaRecorder` and canvas `captureStream()` are supported
- score, levels and next-piece preview
- local best-score persistence
- XR-safe line-clear animation
- local audio assets

## Run

Use a secure HTTPS origin.

Immersive AR requires:

- WebGL
- `navigator.xr`
- `immersive-ar`
- camera/tracking permission

The entry point is:

```text
index.html
```

A `startFallback3D()` helper exists in the code, but the current launch UI does not expose it as a normal non-AR play mode.

## Mobile controls

- tap left side → move left
- tap center → rotate
- tap right side → move right
- swipe down → hard drop

## Meta Quest / XR

The code includes headset/controller paths inside an `immersive-ar` session. It does **not** currently request a separate `immersive-vr` session. Hardware/browser behavior still needs ongoing device validation.

Implemented paths include:

- floor placement/start
- movement and rotation input
- hard drop
- replay
- reset/recenter
- in-world UI
- haptics

See the live XR issues in the repository.

## Native Android edition

The Android implementation is maintained on the `APK` branch using Kotlin and Jetpack Compose.

Repository contributor docs:

- [Contributing](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/CONTRIBUTING.md)
- [Architecture](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/ARCHITECTURE.md)
- [Development](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/DEVELOPMENT.md)
- [Roadmap](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/ROADMAP.md)

## Open source

Source code is released under the **MIT License**.

The license does not grant rights to third-party trademarks, brand names, or separately licensed assets.

## Independence

This is an independent falling-block puzzle project and is not affiliated with or endorsed by Tetris Holding or The Tetris Company.
