[English](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.md) · [Français](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.fr.md) · [العربية](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.ar.md) · [简体中文](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.zh-CN.md) · [日本語](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.ja.md) · [한국어](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.ko.md) · [हिन्दी](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.hi.md) · [Bahasa Indonesia](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.id.md) · [Tiếng Việt](https://github.com/Joenasriani/spatial-tetris-xr/blob/APK/README.vi.md)

# AR Tetris XR — WebXR / Meta Quest Edition

This branch contains the browser edition of **AR Tetris XR**. It is playable directly on mobile web, uses WebXR AR on supported devices, and includes Meta Quest / immersive XR support.

The project spans three targets:

- **Mobile Web** — standard browser play, with WebXR AR on supported devices
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
- fallback 3D mode when immersive AR is unavailable
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

## Mobile controls

- tap left side → move left
- tap center → rotate
- tap right side → move right
- swipe down → hard drop

## Meta Quest / XR

The code includes headset/controller paths for:

- floor placement/start
- movement and rotation input
- hard drop
- replay
- reset/recenter
- in-world UI
- haptics

Hardware/browser behavior still needs ongoing device validation. See the live XR issues in the repository.

## Native Android edition

The Android implementation is maintained on the `APK` branch using Kotlin and Jetpack Compose.

Repository contributor docs:

- [Contributing](https://github.com/Joenasriani/ar-tetris-xr/blob/APK/CONTRIBUTING.md)
- [Architecture](https://github.com/Joenasriani/ar-tetris-xr/blob/APK/ARCHITECTURE.md)
- [Development](https://github.com/Joenasriani/ar-tetris-xr/blob/APK/DEVELOPMENT.md)
- [Roadmap](https://github.com/Joenasriani/ar-tetris-xr/blob/APK/ROADMAP.md)

## Open source

Source code is released under the **MIT License**.

The license does not grant rights to third-party trademarks, brand names, or separately licensed assets.

## Independence

This is an independent falling-block puzzle project and is not affiliated with or endorsed by Tetris Holding or The Tetris Company.
