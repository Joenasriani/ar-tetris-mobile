[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

Game spatial falling-block open source dengan tiga target aktif:

- **Mobile WebXR AR** — berjalan di browser/perangkat mobile yang mendukung WebXR `immersive-ar`
- **Meta Quest / headset XR** — WebXR imersif dengan tracked controller dan UI di dalam ruang
- **Native Android** — edisi Kotlin + Jetpack Compose yang masih aktif dikembangkan

Proyek ini dimulai sebagai game spatial berbasis browser. Launcher web saat ini memerlukan WebXR `immersive-ar`; targetnya adalah browser mobile AR yang kompatibel dan jalur XR untuk headset, sementara edisi native Android juga sedang dikembangkan.

## Yang tersedia saat ini

### WebXR / mobile AR

Branch `main` berisi edisi spatial berbasis browser.

Terverifikasi di code saat ini:

- rendering 3D Three.js
- pemeriksaan kemampuan WebXR immersive-AR
- floor hit-testing dan placement reticle
- penempatan board di ruang yang terdeteksi
- board 10 × 20
- tujuh jenis tetromino
- movement, rotation, hard drop, locking, dan line clears
- score, level, dan next-piece preview
- touch controls untuk perangkat mobile
- penyimpanan best score lokal
- musik dan gameplay audio
- animasi line-clear yang aman untuk XR
- helper `startFallback3D()` ada di code, tetapi launcher saat ini belum mengeksposnya sebagai mode non-AR normal

### Meta Quest / headset XR

Code WebXR yang sama mencakup behavior khusus headset:

- deteksi headset / browser
- tracked-controller / gamepad handling
- controller input saat placement dan gameplay
- in-world intro UI
- in-world Game Over / replay UI
- haptic feedback
- board placement dan recenter / reset untuk immersive XR

### Native Android

Branch `android` berisi edisi Android native:

- Kotlin
- Jetpack Compose
- Android DataStore
- minSdk 26
- targetSdk / compileSdk 36

Edisi Android saat ini mencakup:

- board 10 × 20
- tujuh tetromino
- line clearing
- scoring dan level
- next-piece preview
- touch controls
- pause dan replay
- penyimpanan best score lokal
- konfigurasi Google Play release bundle

> Branch Android adalah `android`, tetapi isinya source code, bukan APK hasil compile.

## Arah proyek

Tujuannya bukan mengganti satu platform dengan platform lain.

Tujuannya adalah mengembangkan satu game lineage melalui:

**mobile web AR → Meta Quest / immersive XR → native Android**

Kontributor dapat bekerja pada satu platform atau pada konsistensi gameplay antar-edisi.

## Area kontribusi

### WebXR / mobile AR
- stabilitas placement dan floor detection
- kompatibilitas mobile browser
- touch / gesture behavior
- performa Three.js
- XR session lifecycle
- fallback mode
- recording / media
- spatial UI polish

### Meta Quest / XR
- controller mappings
- UX khusus headset
- keterbacaan in-world UI
- replay / recenter flow
- haptics
- performa immersive session
- device-specific testing

### Android
- mengekstrak game engine dari `MainActivity.kt`
- deterministic unit tests
- touch responsiveness
- lifecycle dan persistence QA
- accessibility
- performance dan device coverage
- game mode baru

Lihat `ROADMAP.md`, `ARCHITECTURE.md`, dan `CONTRIBUTING.md`.

## Branch

- `main` — edisi spatial WebXR / mobile AR / Meta Quest
- `android` — edisi native Android
- branch historis dipertahankan sebagai riwayat pengembangan

## Menjalankan edisi WebXR

Immersive AR memerlukan origin HTTPS yang aman.

Entry point utama:

```text
index.html
```

Build menggunakan Three.js melalui import map dan audio lokal di `music/`.

## Build edisi Android

Persyaratan:

- JDK 17
- Android SDK kompatibel dengan API 36
- Gradle yang kompatibel dengan konfigurasi proyek

Debug build:

```bash
gradle :app:assembleDebug
```

Release bundle:

```bash
gradle :app:bundleRelease
```

Lihat `PLAYSTORE_RELEASE.md` untuk signing dan rilis Play.

## Open source

Source code di repository ini dirilis di bawah **MIT License**. Lihat `LICENSE`.

Lisensi berlaku untuk source code repository dan tidak memberikan hak atas trademark, brand name, atau asset pihak ketiga yang memiliki lisensi terpisah.

## Independensi

Ini adalah proyek falling-block puzzle independen dan tidak berafiliasi atau didukung oleh Tetris Holding atau The Tetris Company.

## Creator

Joe Nasr  
https://joe-nasr-signals.vercel.app/
