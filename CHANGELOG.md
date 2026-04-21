# Changelog

All notable changes to **HMITiles** are documented in this file.

The project follows semantic versioning where possible.

---

## [1.6.2] - 2026-04-21
* NEW: HMITileEventViewer - Method GetEvents to get list of events with map items Timestamp, Level, Event; Logging with level (int) & event (string); List item value map Timestamp, Level, Event instead string item.
* NEW: HMITileList - Property SelectedItemIndex to set or get the index of the item selected
* NEW: HMITileGauge - Event Click with gauge value (float)
* NEW: Examples GetStarted - HMITileSeekBar, HMITileStatusIndicators, HMITileSelect, HMITileSelectList, HMITileList, HMITileGauge, HMITileTrend, HMITileEventsViewer, HMITileSensor, HMITileReadout
* FIX: HMITileReadout - Get value if set via designer property.
* FIX: HMITileSelect, HMITileSelectList, HMITileList - Textcolor set using CSSUtils to ensure right textcolor on Linux
* UPD: HMITileEventViewer - List item value set map Timestamp, Level, Event instead string item.
* UPD: B4A Examples - Reworked BLEScanner, ESP32BLELED (replaced BLE library rBLEServer to rNimBLEServer)

## [1.6.1] - 2026-04-17
* NEW: HMITileTimer - Counter UP or DOWN
* NEW: HMITileStatusIndicators - 3x3 Responsive HMI Indicator
* NEW: HMITileUtils - Various colors & text constants
* UPD: Replaced all CallSub with CallSubDelayed
* UPD: Various minor updates all HMITiles

## [1.6.0] - 2026-04-15
* NEW: HMITileNavButton -Navigate to sub-page(s) and back to home-page
* NEW: B4J example applications - MultiPages using HMITileNavButtons
* CHG: HMITileButton - Center state text if not title
* CHG: HMITileSelectList - Fixed SelectItem uses String; SelectItemIndex uses Int
* CHG: HMITileSeekbar - Fixed Orientation Vertical thumb tracking, bar size & position
* CHG: HMITileImage - Fixed bitmap size setting to stay within tile with aspect ratio
* UPD: Various minor updates all HMITiles

## [1.5.0] - 2026-01-09
* NEW: HMITileLabel - API SetFontAwesome large or default size, SetFontNormal
* NEW: HMITileEventViewer - API RowHeight to override defaults for compact/normal mode
* NEW: HMITileSeekBar - API ShowValue to hide the value
* NEW: B4A library BleCentral.b4lib based examples - BleScanner, GVH5075Scanner, RuuviTagScanner, Bricks BuWizz2, Lego HUB No.4
* NEW: B4J examples - Get Started HMITileButton, HMITileLabel
* CHG: HMITiles custom views public API aligned
* CHG: Updated all examples
* UPD: Various minor updates all HMITiles

## [1.4.0] - 2025-12-31
* NEW: HMITiles - HMITileSeekBar (replacing Slider); HMITileSelect; HMITileSelectList; HMITileShape tiles (HLine, VLine, Corners)
* NEW: B4A examples - Overview; ESP32BLELED (control ESP32 LED via BLE, ESP32 firmware in B4R)
* CHG: HMITiles custom views reworked and tested with B4A; Exception: HMITileRGB remains B4J-only
* UPD: B4J examples: Overview; Water Tank Simulator; Arduino LED
* REM: Internal custom views: HMISeekbar; HMIPlusMinusNumeric

## [1.3.0] - 2025-12-26
* NEW: HMI Tiles: Trend; SPPV; Gauge; Internal custom views: HMISeekbar; HMIPlusMinusNumeric
* NEW: Examples: Water Tank Simulator; Arduino LED
* CHG: Revised `HMITileUtils` color scheme to a neutral blue–green scale
* UPD: Updated Overview example
* UPD: Various minor updates all HMITiles

## [1.0.0] - 2025-12-17
* NEW: Initial public release of HMITiles; Published on the [B4J forum](https://www.b4x.com/android/forum/threads/hmitiles.169774/)
