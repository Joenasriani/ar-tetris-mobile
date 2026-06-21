# Rockin' Tetris Android

This repository now contains a self-contained Kotlin + Jetpack Compose Android implementation of the original AR / VR Tetris core loop. The mobile app is designed for a premium, upfront-paid Google Play listing and intentionally contains no onboarding paywall, Stripe integration, subscription flow, or subscription scripts.

## App architecture

- Native Android app in `app/`.
- UI built entirely with Jetpack Compose.
- User data is persisted locally with Jetpack DataStore Preferences.
- Current local data: best score.
- Gameplay is implemented in Kotlin: 10 × 20 board, all seven tetrominoes, next-piece preview, line clears, scoring, levels, speed scaling, tap controls, swipe hard-drop, pause, replay, and local best-score saving.

## Controls

- Tap left third: move left one grid cell.
- Tap right third: move right one grid cell.
- Tap center: rotate once with simple wall kicks.
- Swipe downward: hard drop.
- On-screen buttons provide the same actions plus pause/resume.

## Monetization policy

Do not add paywalls, subscriptions, Stripe packages, subscription scripts, or in-app checkout logic. Premium purchase entitlement is expected to be handled by the Google Play Developer Console as an upfront paid download.

## Build

Use a JDK version supported by the Android Gradle Plugin, for example Java 17:

```bash
JAVA_HOME=/root/.local/share/mise/installs/java/17.0.2 gradle :app:assembleDebug
```
