# Changelog

All notable changes to **HMITiles** are documented in this file.

The project follows semantic versioning where possible.

---

## [1.5.0] – 2026-01-09

### Added
- HMITileUtils
	- API 
- HMITileLabel
	- API SetFontAwesome large or default size, SetFontNormal
- HMITileEventViewer
	- API RowHeight to override defaults for compact/normal mode
- HMITileSeekBar
	- API ShowValue to hide the value
- B4A example applications
	- B4A library BleCentral.b4lib based examples:
		- BleScanner, GVH5075Scanner, RuuviTagScanner
		- Bricks BuWizz2, Lego HUB No.4
- B4J example applications
	- Get Started HMITileButton, HMITileLabel

### Changed
- HMITiles custom views public API aligned
- Updated all examples
- Minor updates

---

## [1.4.0] – 2025-12-31

### Added
- HMI tiles:
  - SeekBar (replacing Slider)
  - Select
  - SelectList
  - Shape tiles (HLine, VLine, Corners)
- New B4A example applications:
  - Overview
  - ESP32BLELED (control ESP32 LED via BLE, ESP32 firmware in B4R)

### Changed
- HMITiles custom views reworked and tested with **B4A**
  - Exception: `HMITileRGB` remains **B4J-only**
- Updated B4J example applications:
  - Overview
  - Water Tank Simulator
  - Arduino LED

### Removed
- Internal custom views:
  - `HMISeekbar`
  - `HMIPlusMinusNumeric`

---

## [1.3.0] – 2025-12-26

### Added
- HMI Tiles:
  - Trend
  - SPPV
  - Gauge
- Internal custom views:
  - `HMISeekbar`
  - `HMIPlusMinusNumeric`
- Example applications:
  - Water Tank Simulator
  - Arduino LED

### Changed
- Various minor updates across HMITiles
- Revised `HMITileUtils` color scheme to a neutral blue–green scale
- Updated Overview example

---

## [1.0.0] – 2025-12-17

### Added
- Initial public release of HMITiles
- Published on the [B4J forum](https://www.b4x.com/android/forum/threads/hmitiles.169774/)
