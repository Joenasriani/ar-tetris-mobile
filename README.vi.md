[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

Trò chơi xếp khối không gian mã nguồn mở với ba mục tiêu đang hoạt động:

- **Mobile Web** — chơi trực tiếp trên trình duyệt di động, có **WebXR AR** trên thiết bị được hỗ trợ
- **Meta Quest / headset XR** — WebXR nhập vai với tracked controller và giao diện trong không gian
- **Native Android** — phiên bản Kotlin + Jetpack Compose đang được phát triển

Dự án bắt đầu như một trò chơi không gian chạy trên trình duyệt. Hiện có thể chơi trực tiếp trên mobile web, sử dụng WebXR AR trên thiết bị hỗ trợ, hỗ trợ Meta Quest / XR headset, và đồng thời có phiên bản Android native đang phát triển.

## Hiện có

### WebXR / mobile AR

Nhánh `main` chứa phiên bản không gian chạy trên trình duyệt.

Đã xác minh trong code hiện tại:

- kết xuất 3D bằng Three.js
- kiểm tra khả năng WebXR immersive-AR
- floor hit-testing và placement reticle
- đặt board vào không gian được phát hiện
- board 10 × 20
- bảy loại tetromino
- movement, rotation, hard drop, locking và line clear
- score, level và next-piece preview
- touch control cho thiết bị di động
- lưu best score cục bộ
- music và gameplay audio
- line-clear animation an toàn cho XR
- fallback 3D khi immersive AR không khả dụng

### Meta Quest / headset XR

Cùng code WebXR có các luồng dành cho headset:

- phát hiện headset / browser
- tracked-controller / gamepad handling
- controller input khi placement và gameplay
- in-world intro UI
- in-world Game Over / replay UI
- haptic feedback
- board placement và recenter / reset cho immersive XR

### Native Android

Nhánh mặc định `APK` hiện chứa phiên bản Android native:

- Kotlin
- Jetpack Compose
- Android DataStore
- minSdk 26
- targetSdk / compileSdk 36

Phiên bản Android hiện có:

- board 10 × 20
- bảy tetromino
- line clearing
- scoring và level
- next-piece preview
- touch controls
- pause và replay
- lưu best score cục bộ
- cấu hình Google Play release bundle

> Nhánh mặc định hiện tên là `APK`, nhưng chứa source code chứ không phải file APK đã build.

## Hướng phát triển

Mục tiêu không phải thay thế nền tảng này bằng nền tảng khác.

Mục tiêu là phát triển cùng một game lineage qua:

**mobile web AR → Meta Quest / immersive XR → native Android**

Contributor có thể tập trung vào một nền tảng hoặc tính nhất quán gameplay giữa các phiên bản.

## Khu vực đóng góp

### WebXR / mobile AR
- độ ổn định placement và floor detection
- tương thích mobile browser
- touch / gesture behavior
- hiệu năng Three.js
- XR session lifecycle
- fallback mode
- recording / media
- spatial UI polish

### Meta Quest / XR
- controller mappings
- UX dành cho headset
- khả năng đọc in-world UI
- replay / recenter flow
- haptics
- hiệu năng immersive session
- kiểm thử theo thiết bị

### Android
- tách game engine khỏi `MainActivity.kt`
- deterministic unit tests
- touch responsiveness
- lifecycle và persistence QA
- accessibility
- performance và device coverage
- game mode mới

Xem `ROADMAP.md`, `ARCHITECTURE.md`, và `CONTRIBUTING.md`.

## Branch

- `main` — phiên bản spatial WebXR / mobile AR / Meta Quest
- `APK` — phiên bản native Android và nhánh mặc định hiện tại
- các branch lịch sử được giữ làm lịch sử phát triển

## Chạy bản WebXR

Immersive AR yêu cầu HTTPS origin an toàn.

Entry point chính:

```text
index.html
```

Build dùng Three.js qua import map và audio cục bộ trong `music/`.

## Build bản Android

Yêu cầu:

- JDK 17
- Android SDK tương thích API 36
- Gradle tương thích cấu hình dự án

Debug build:

```bash
gradle :app:assembleDebug
```

Release bundle:

```bash
gradle :app:bundleRelease
```

Xem `PLAYSTORE_RELEASE.md` cho signing và phát hành Play.

## Mã nguồn mở

Source code của repository được phát hành theo **MIT License**. Xem `LICENSE`.

License áp dụng cho source code của repository và không cấp quyền đối với trademark, brand name hoặc asset bên thứ ba có điều khoản riêng.

## Độc lập

Đây là dự án falling-block puzzle độc lập và không liên kết hoặc được chứng thực bởi Tetris Holding hay The Tetris Company.

## Creator

Joe Nasr  
https://joe-nasr-signals.vercel.app/
