# Changelog

All notable changes to **HMITiles** - are documented in this file.

The project follows semantic versioning where possible.

---

## [1.8.0] - 2026-04-27
- NEW: HMITileCustom - Create custom tile by adding views to an empty tile
- NEW: HMITileLevelIndicator - Generic visual level indicator (circle) 0-100%
- NEW: Examples GetStarted - HMITileCustom (create own tile); Advanced Customization (first example; in progress)
- UPD: HMITileStatusIndicators - Border color set to HMITile background color
- UPD: Examples - Minor changes.

## [1.7.0] - 2026-04-26
- NEW: Examples GetStarted - Examples created for all HMITiles components
- NEW: HMITileEventViewer - Method `GetEvents` returns a list of events (Map: Timestamp, Level, Event); logging supports level (Int) and event (String)
- NEW: HMITileList - Property `SelectedItemIndex` to set and get the selected item index
- NEW: HMITileGauge - Click event with gauge value (Float)
- NEW: HMITileTimer - Property `TimerTextSize` to set and get the timer label text size (useful for Linux rendering differences)
- UPD: All HMITiles - Reworked property model:  
  `Value` = functional (ON/OFF, number, text)  
  `Status` = semantic/visual (Normal, Warning, Alarm, Disabled)
- UPD: All HMITiles - Various bug fixes and API improvements
- UPD: All Examples - Updated to use `Value` and `Status` properties
- UPD: B4A Examples - Reworked BLEScanner and ESP32BLELED (replaced BLE library `rBLEServer` with `rNimBLEServer`)
- UPD: HMITileEventViewer - List item values now stored as Map (Timestamp, Level, Event) instead of String
- UPD: HMITileImage - Improved resize mode (reduced blur)
- FIX: HMITileReadout - Correctly returns value when set via Designer property
- FIX: HMITileSelect, HMITileSelectList, HMITileList - Text color set using CSSUtils to ensure correct rendering on Linux

## [1.6.1] - 2026-04-17
- NEW: HMITileTimer - Counter UP or DOWN
- NEW: HMITileStatusIndicators - 3x3 Responsive HMI Indicator
- NEW: HMITileUtils - Various colors & text constants
- UPD: Replaced all CallSub with CallSubDelayed
- UPD: Various minor updates all HMITiles

## [1.6.0] - 2026-04-15
- NEW: HMITileNavButton -Navigate to sub-page(s) and back to home-page
- NEW: B4J example applications - MultiPages using HMITileNavButtons
- CHG: HMITileButton - Center state text if not title
- CHG: HMITileSelectList - Fixed SelectItem uses String; SelectItemIndex uses Int
- CHG: HMITileSeekbar - Fixed Orientation Vertical thumb tracking, bar size & position
- CHG: HMITileImage - Fixed bitmap size setting to stay within tile with aspect ratio
- UPD: Various minor updates all HMITiles

## [1.5.0] - 2026-01-09
- NEW: HMITileLabel - API SetFontAwesome large or default size, SetFontNormal
- NEW: HMITileEventViewer - API RowHeight to override defaults for compact/normal mode
- NEW: HMITileSeekBar - API ShowValue to hide the value
- NEW: B4A library BleCentral.b4lib based examples - BleScanner, GVH5075Scanner, RuuviTagScanner, Bricks BuWizz2, Lego HUB No.4
- NEW: B4J examples - Get Started HMITileButton, HMITileLabel
- CHG: HMITiles custom views public API aligned
- CHG: Updated all examples
- UPD: Various minor updates all HMITiles

## [1.4.0] - 2025-12-31
- NEW: HMITiles - HMITileSeekBar (replacing Slider); HMITileSelect; HMITileSelectList; HMITileShape tiles (HLine, VLine, Corners)
- NEW: B4A examples - Overview; ESP32BLELED (control ESP32 LED via BLE, ESP32 firmware in B4R)
- CHG: HMITiles custom views reworked and tested with B4A; Exception: HMITileRGB remains B4J-only
- UPD: B4J examples: Overview; Water Tank Simulator; Arduino LED
- REM: Internal custom views: HMISeekbar; HMIPlusMinusNumeric

## [1.3.0] - 2025-12-26
- NEW: HMI Tiles: Trend; SPPV; Gauge; Internal custom views: HMISeekbar; HMIPlusMinusNumeric
- NEW: Examples: Water Tank Simulator; Arduino LED
- CHG: Revised `HMITileUtils` color scheme to a neutral blue–green scale
- UPD: Updated Overview example
- UPD: Various minor updates all HMITiles

## [1.0.0] - 2025-12-17
- NEW: Initial public release of HMITiles; Published on the [B4J forum](https://www.b4x.com/android/forum/threads/hmitiles.169774/)
