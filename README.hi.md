[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

तीन सक्रिय लक्ष्यों वाला एक open-source spatial falling-block game:

- **Mobile Web** — mobile browser में सीधे playable, समर्थित devices पर **WebXR AR**
- **Meta Quest / XR headsets** — tracked controllers और in-world UI के साथ immersive WebXR
- **Native Android** — Kotlin + Jetpack Compose edition development में

यह project browser-based spatial game के रूप में शुरू हुआ और अब mobile web, WebXR AR, Meta Quest / XR और native Android तक विकसित हो रहा है।

## वर्तमान implementation

### WebXR / mobile AR
`main` branch में Three.js 3D rendering, immersive-AR capability checks, floor hit-test, spatial placement, 10 × 20 board, सात tetrominoes, movement/rotation/hard drop/locking/line clears, score, levels, next piece, touch controls, local best score, audio, XR-safe animation और 3D fallback शामिल हैं।

### Meta Quest / XR
उसी WebXR code में headset detection, tracked controller/gamepad, placement और gameplay input, in-world UI, replay, haptics और recenter behavior शामिल हैं।

### Native Android
`APK` branch में Kotlin + Jetpack Compose + Android DataStore आधारित Android edition है।

> `APK` में compiled APK नहीं, source code है।

## Project direction
**mobile web AR → Meta Quest / immersive XR → native Android**

## Contributing
`ROADMAP.md`, `ARCHITECTURE.md`, और `CONTRIBUTING.md` देखें।

## Branches
- `main` — WebXR / mobile AR / Meta Quest
- `APK` — native Android

## Open source
Source code **MIT License** के तहत है। `LICENSE` देखें।

## Independence
यह independent project है और Tetris Holding या The Tetris Company से affiliated या endorsed नहीं है।

## Creator
Joe Nasr  
https://joe-nasr-signals.vercel.app/
