[English](README.md) · [Français](README.fr.md) · [العربية](README.ar.md) · [简体中文](README.zh-CN.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [हिन्दी](README.hi.md) · [Bahasa Indonesia](README.id.md) · [Tiếng Việt](README.vi.md)

# AR Tetris XR

Un jeu spatial de blocs tombants open source avec trois cibles actives :

- **WebXR AR mobile** — fonctionne dans les navigateurs/appareils mobiles compatibles avec WebXR `immersive-ar`
- **Meta Quest / casques XR** — WebXR immersif avec contrôleurs suivis et interface dans l’espace
- **Android natif** — édition Kotlin + Jetpack Compose en développement actif

Le projet a commencé comme un jeu spatial dans le navigateur. Le lanceur web actuel exige WebXR `immersive-ar`; il cible les navigateurs AR mobiles compatibles et inclut des chemins XR adaptés aux casques, tandis qu’une édition Android native est aussi en développement.

## Ce qui existe aujourd’hui

### WebXR / AR mobile
La branche `main` contient l’édition spatiale basée sur le navigateur.

Fonctionnalités vérifiées : rendu 3D Three.js, WebXR immersive-AR, hit testing du sol, placement spatial du plateau, plateau 10 × 20, sept tétriminos, déplacements, rotation, hard drop, verrouillage, suppression de lignes, score, niveaux, aperçu de la prochaine pièce, contrôles tactiles, meilleur score local, audio, animation XR-safe. Un helper `startFallback3D()` existe dans le code, mais le lanceur actuel ne l’expose pas comme mode non-AR.

### Meta Quest / XR
Le même code WebXR gère la détection casque/navigateur, les contrôleurs suivis/gamepad, l’entrée pendant le placement et le gameplay, l’UI dans l’espace, le replay, les haptiques et le recentrage.

### Android natif
La branche `android` contient l’édition Android native avec Kotlin, Jetpack Compose et Android DataStore.

> `android` contient le code source, pas un APK compilé.

## Direction
**web mobile AR → Meta Quest / XR immersif → Android natif**

## Contribuer
Voir `ROADMAP.md`, `ARCHITECTURE.md` et `CONTRIBUTING.md`.

## Branches
- `main` — WebXR / AR mobile / Meta Quest
- `android` — Android natif

## Open source
Code source sous **licence MIT**. Voir `LICENSE`.

## Indépendance
Projet indépendant, sans affiliation ni approbation de Tetris Holding ou The Tetris Company.

## Créateur
Joe Nasr  
https://joe-nasr-signals.vercel.app/
