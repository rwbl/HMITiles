# Changelog

All notable changes to **HMITiles** - are documented in this file.

The project follows semantic versioning where possible.

---

## [2.0.1] - 2026-05-22
- NEW: Example 57-GeneratorSimulator - Demo simulates a standard European 220V/230V @ 50Hz 4-pole industrial diesel generator
- NEW: Example 58-ColdStorageSimulator - Demo simulates an environmental control chamber / industrial refrigerator loop
- NEW: Example 59-ConveyorSortingSimulator - Demo simulates a factory material-handling conveyor belt line driven by a VFD motor
- FIX: HMITileSlider - Handling value < min range or > max range; Tickmarks fixed length instead barheight/width 
- FIX: HMITileEventViewer - Property MaxEvents wrongly initialized as MaxItems (caused eventviewer crash)

## [2.0.0] - 2026-05-19
- NEW: Alarm Concept - Title changes color & indicator added depending state (normal, warning, alarm) and not the full tile anymore (clear visual hierarchy that instantly tells the status without overwhelming the screen)
- NEW: HMITileDeviation - Bidirectional bar to indicate process value deviation from the set point
- NEW: HMITileGauge - Properties Show Needle, Show Range Labels
- NEW: HMITileGaugeSegments - Like HMITileGauge but with additional Warning/Alarm segments and shape indicator
- NEW: HMITileLabelTitle - Tile with title label and centered label (with properties TextSize, TextColor)
- NEW: HMITileUtils - Method MapRange
- NEW: HMITileSlider - Slider control tile for interactive value adjustment
- NEW: HMITileSymbols - Common symbol constants and helper subs for HMITileCustom
- NEW: HMITileTrend - Applied graph smoothing (Chaikin Algorithm); Property GridColor; Event Click
- NEW: HMITiles with Value & Unit - Added label Unit; Stacked labels Value (top) and Unit (bottom)
- NEW: HMITilesX - Library with HMITiles extensions which go beyond the HMI design principles
- NEW: HMITileLevel - Added level type Bar, Circle; Replaced bar & fill panes with b4xcanvas rectangles
- UPD: HMITileSPPV - Seperator line between PV and SP; Warning/Alarm shape indicator below seperator line
- UPD: HMITiles - Renamed mBase to BasePane (Public), mLbl to BaseLabel (Private)
- UPD: Indicator Tiles - Consistent use of background track and active level colors
- UPD: Examples - Folder structure using numeric index; Removed subfolders; Reworked all examples & some renamed
- DEL: Examples - B4A & B4J Overview removed. Use B4A & B4J development app and program instead (folder src)
- DEL: HMITileLevelIndicator - Included level type Circle in HMITileLevel
- DEL: HMITileRGB - Moved to the new HMITilesX library
- DEL: HMITileShape - Moved to the new HMITilesX library
- DEL: HMITileSeekBar - Moved to the new HMITilesX library

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
