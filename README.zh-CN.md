[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

一个开源的空间下落方块游戏，目前面向三个平台：

- **移动 WebXR AR** — 在支持 WebXR `immersive-ar` 的移动浏览器/设备上运行
- **Meta Quest / XR 头显** — 支持沉浸式 WebXR、跟踪控制器和空间内 UI
- **原生 Android** — 使用 Kotlin + Jetpack Compose 开发

项目最初是浏览器空间游戏。当前网页启动器要求 WebXR `immersive-ar`；它面向支持 AR 的移动浏览器，并包含头显 XR 路径，同时也在开发原生 Android 版本。

## 当前实现

### WebXR / 移动 AR
`main` 分支包含浏览器空间版本，包括 Three.js 3D 渲染、immersive-AR 能力检测、地面 hit-test、空间放置、10 × 20 游戏板、七种方块、移动/旋转/快速下落/锁定/消行、分数、等级、下一块预览、触控、本地最高分、音频、XR-safe 消行动画。代码中存在 `startFallback3D()` 辅助函数，但当前启动器并未将其作为普通非 AR 模式开放。

### Meta Quest / XR
同一套 WebXR 代码支持头显检测、跟踪控制器/gamepad、放置与游戏输入、空间内 UI、重玩、触觉反馈和重新居中。

### 原生 Android
`android` 分支包含 Kotlin + Jetpack Compose + Android DataStore 的原生 Android 版本。

> `android` 分支包含源码，不是编译后的 APK。

## 项目方向
**移动网页 AR → Meta Quest / 沉浸式 XR → 原生 Android**

## 贡献
请参阅 `ROADMAP.md`、`ARCHITECTURE.md` 和 `CONTRIBUTING.md`。

## 分支
- `main` — WebXR / 移动 AR / Meta Quest
- `android` — 原生 Android

## 开源
源码采用 **MIT License**。见 `LICENSE`。

## 独立性
本项目独立开发，与 Tetris Holding 或 The Tetris Company 无关联，也未获得其认可。

## 创建者
Joe Nasr  
https://joe-nasr-signals.vercel.app/
