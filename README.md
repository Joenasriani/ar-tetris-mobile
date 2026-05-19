# AR Tetris

AR Tetris is a browser-based WebXR augmented reality falling-block puzzle game. It is designed for supported mobile AR browsers and Meta Quest Browser.

## How to run

Use a secure HTTPS host. WebXR AR will not work from an insecure HTTP origin except localhost development contexts.

Recommended deployment:

- Vercel
- Netlify
- GitHub Pages with HTTPS
- Any HTTPS static host

## Controls

### Mobile touch

- Tap left side: move piece left exactly one grid cell
- Tap right side: move piece right exactly one grid cell
- Tap middle: rotate once
- Swipe downward: hard drop once

### Quest / XR controller

- Controller button during scanning/placement: lock detected floor and start
- Controller input during gameplay: supported by the game input polling logic

## Audio

The package includes local audio assets in `music/`:

- `music/music.mp3`
- `music/tik.mp3`
- `music/outro.mp3`
- `music/lineclear.mp3`

The background music is set to loop in the HTML and JavaScript.

## WebXR notes

WebXR AR requires:

- HTTPS
- WebGL
- Browser support for `navigator.xr`
- Support for `immersive-ar`
- Device camera/tracking permission

If an embedded platform blocks AR/camera permissions, open the game directly on the hosted URL.

## Validation performed

- JavaScript module syntax checked with Node
- Package includes all referenced local audio files
- VR line-clear animation moved into the WebXR-safe renderer animation loop
