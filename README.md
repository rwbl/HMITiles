![Platform](https://img.shields.io/badge/B4J-primary-blue)
![Status](https://img.shields.io/badge/status-active-green)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
# HMITiles
**An Open-Source HMI Tile Library for Industrial Dashboards**

---

## Overview

HMITiles aims to bring structured, industry-inspired HMI design principles into the B4X ecosystem.

HMITiles is an open-source HMI (Human Machine Interface) tile library written in [B4X](http://www.b4x.com), following widely accepted industrial HMI principles.

It provides reusable, professional-grade HMI tiles for:
- Industrial dashboards
- SCADA (Supervisory Control and Data Acquisition) front-ends
- Machine and process HMIs

The focus of this library is **clarity, consistency, and disciplined HMI design** - not visual effects or unnecessary UI decoration.

Use in **industrial or safety-critical environments** is entirely at your **own risk**.

---

## Design Goals

- Based on widely accepted industrial HMI principles
- Alarm-first color discipline
- Clear and consistent state handling
- Touch-friendly layouts
- No animations or visual clutter
- Minimal configuration required

---

## Platform Support

| Platform | Status                                      |
| -------- | ------------------------------------------- |
| **B4J**  | ✅ Primary target (full-screen desktop HMIs) |
| **B4A**  | ⚠️ Partial support (most tiles work)        |
| **B4i**  | ❌ Not currently supported                   |

---

## Implemented Tiles

- Buttons (including ON / OFF logic)
- Numeric and text readouts
- Sensor tiles
- Clocks and time displays
- Event and message viewers
- Sliders and setpoints
- Image tiles
- RGB indicators
- Layout and helper components

All tiles share a **unified styling and state model**.

## HMITiles Overview

| Tile Type                     | Brief                                                                       |
| ----------------------------- | --------------------------------------------------------------------------- |
| **HMITileButton**             | Configurable button tile with styling, icons, and click handling.           |
| **HMITileClock**              | Analog clock tile with customizable hands and appearance.                   |
| **HMITileCustom**             | Create own custom tile with views.                                          |
| **HMITileDigitalClock**       | Digital clock tile with flexible time and date formats.                     |
| **HMITileDeviation**          | Bidirectional bar to indicate process value deviation from the set point.   |
| **HMITileEventViewer**        | Scrollable event/log viewer for real-time messages.                         |
| **HMITileGauge**              | Circular or linear gauge for visualizing numeric values.                    |
| **HMITileGaugeSegments**      | Circular or linear gauge with segments for visualizing numeric values.      |
| **HMITileGridHelper**         | Utility for aligning and arranging tiles in grid layouts.                   |
| **HMITileImage**              | Displays images with scaling and positioning options.                       |
| **HMITileImageIcon**          | Image-based icon tile with basic interaction support.                       |
| **HMITileLabel**              | Text label tile with styling and alignment options.                         |
| **HMITileLabelTitle**         | Title and Text label tile with styling and alignment options.               |
| **HMITileLevel**              | Level indicator showing percentage or value as a bar or circle.             |
| **HMITileList**               | List display tile for dynamic or selectable items.                          |
| **HMITileNavButton**          | Navigation button tile for switching views or pages.                        |
| **HMITileReadout**            | Numeric or text readout tile for process or system values.                  |
| **HMITileSelect**             | Dropdown selection tile for choosing a single option.                       |
| **HMITileSelectList**         | Extended selection list supporting multiple options.                        |
| **HMITileSensor**             | Sensor tile for displaying live values with status indication.              |
| **HMITileSlider**            	| Slider control tile for interactive value adjustment.                       |
| **HMITileSPPV**               | Setpoint vs. process value (SP/PV) visualization tile.                      |
| **HMITileSymbols**   			| Shared helper for canvas symbols (Triangle, Diamond, Arrow).                |
| **HMITileStatusIndicators**   | 3x3 responsive indicator tile.                        					  |
| **HMITileTimer**              | Up or down counter using a seconds-based timer.                             |
| **HMITileTrend**              | Trend/chart tile for plotting time-series data.                             |
| **HMITileUtils**              | Shared helper and utility functions.                                        |
| ----------------------------- | --------------------------------------------------------------------------- |

---

## Screenshots

![Development](images/development_b4j.png "Development Program (B4J)") 

![Vessel Process Simulator](images/vessel_process_simulator_b4j.png "Vessel Process Simulator (B4J)") 

![Solar Info Panel](images/solar_info_panel_b4j.png "Solar Info Panel (B4J)") 

---

## Installation

1. Download the latest release (`HMITiles.b4xlib`) from the `libs` folder.
2. Copy the file to the **B4J** or **B4A Additional Libraries** folder.
3. Restart the B4J/B4A IDE if required or refresh list of libraries in the IDE.

---

## Examples Included

See folder **examples** containing easy-to-follow examples for every HMITile in the library.

In addition some more complete demo applications:

**Solar Info Panel**  
Real-live data from the solar production system.

**Vessel Process Simulator**  
Simulated live process data using setpoints, indicators, and trend tiles.

**B4J-ArduinoLED**  
Control an Arduino onboard LED via serial communication (USB) (B4R firmware).

**B4A-ESP32BLELED**  
Control an ESP32-connected LED via BLE (UART) (B4R firmware).

---

## Quick Start

This example shows how to add and use a simple HMITile ON / OFF button in a B4J project.
HMITiles are standard **B4X CustomViews** and can be placed directly in the Designer.

### 1. Add the Library

- Download `HMITiles.b4xlib`
- Copy it to your **B4J Additional Libraries** folder
- Refresh the libraries list in the IDE

---

### 2. Create a New B4J B4XPages Project

- File > New > **B4XPages Project**
- Save the project

---

### 3. Add a Tile in the Designer

- Open the Designer
- Add a **CustomView**
- Select: `HMITileButton`
- Name it: `HMITileButtonOnOff`
- Set size: e.g. `120 x 120`

---

### 4. Initialize in Code

```
Sub Class_Globals
	Private xui As XUI
	Private Root As B4XView
	Private TileButtonOnOff As HMITileButton
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITileButton")
	
	' HMITiles
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)	
	
	' Button On Off
	TileButtonOnOff.Value = False
End Sub
```

---

### 5. Handle Click Event

```
Private Sub TileButtonOnOff_Click
	' Reverse the button state
	TileButtonOnOff.Value = Not(TileButtonOnOff.Value)
	' Take action according button state:
	If TileButtonOnOff.Value Then
		' Do something
	Else
		' Do something else
	End If
	' Log to the B4J IDE
	Log($"[TileButtonOnOff] value=${TileButtonOnOff.value}"$)
End Sub
```

---

## Versioning

This project does not follow strict semantic versioning.

Updates are published when improvements are available.

---

## Acknowledgments

Special thanks to [Anywhere Software](https://www.b4x.com) for providing the excellent B4X development tools.

This project also benefits greatly from the active and helpful [B4X community forum](https://www.b4x.com/android/forum/), whose shared knowledge, solutions, and ideas have been invaluable.

---

## Disclaimer & Project Scope

This project was created:
- to explore the development of HMI / SCADA-style tile interfaces
- for personal use and experimentation
- to share knowledge and ideas within the B4X community

**This is a hobby project and is provided as-is.**

### Intended Use

This library is not intended for production-critical or safety-related systems.

### Support Policy

- Issues are disabled or not actively monitored
- No support, bug fixes, or feature requests are guaranteed
- You are welcome to fork and adapt the code

### Warranty & Liability

This software is provided **"as is"**, without any warranty.  
Use it at your own risk.

No guarantees are made regarding correctness, reliability, or suitability for any application.

For full legal terms, see the LICENSE file (MIT).

---

## License

- **HMITiles** – MIT License © 2025-2026 Robert W. B. Linn
- See LICENSE for details.

