[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

세 가지 타깃을 가진 오픈소스 공간형 낙하 블록 게임입니다.

- **모바일 WebXR AR** — WebXR `immersive-ar`를 지원하는 모바일 브라우저/기기에서 실행
- **Meta Quest / XR 헤드셋** — 추적 컨트롤러와 공간 UI를 사용하는 몰입형 WebXR
- **네이티브 Android** — Kotlin + Jetpack Compose 버전 개발 중

브라우저 기반 공간 게임으로 시작했습니다. 현재 웹 런처는 WebXR `immersive-ar`를 요구하며, 지원되는 모바일 AR 브라우저와 헤드셋 XR 경로를 대상으로 합니다. 네이티브 Android 버전도 개발 중입니다.

## 현재 구현

### WebXR / 모바일 AR
`main` 브랜치에는 Three.js 3D 렌더링, immersive-AR 감지, 바닥 hit-test, 공간 배치, 10 × 20 보드, 7개 테트리미노, 이동/회전/하드 드롭/잠금/라인 제거, 점수, 레벨, 다음 블록, 터치 조작, 로컬 최고 점수, 오디오, XR-safe 애니메이션이 포함됩니다. `startFallback3D()` 헬퍼는 존재하지만 현재 런처에서 일반 비AR 모드로 노출되지 않습니다.

### Meta Quest / XR
같은 WebXR 코드에는 헤드셋 감지, tracked controller/gamepad, 배치와 게임 입력, 공간 UI, 재시작, 햅틱, recenter 동작이 포함됩니다.

### 네이티브 Android
`android` 브랜치에는 Kotlin + Jetpack Compose + Android DataStore 기반 Android 버전이 있습니다.

> `android`는 컴파일된 APK가 아니라 소스 코드입니다.

## 프로젝트 방향
**모바일 웹 AR → Meta Quest / 몰입형 XR → 네이티브 Android**

## 기여
`ROADMAP.md`, `ARCHITECTURE.md`, `CONTRIBUTING.md`를 참고하세요.

## 브랜치
- `main` — WebXR / 모바일 AR / Meta Quest
- `android` — 네이티브 Android

## 오픈소스
소스 코드는 **MIT License**로 공개됩니다. `LICENSE` 참고.

## 독립성
Tetris Holding 또는 The Tetris Company와 제휴하거나 승인을 받은 프로젝트가 아닙니다.

## 제작자
Joe Nasr  
https://joe-nasr-signals.vercel.app/
