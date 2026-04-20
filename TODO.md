# TODO HMITiles.b4xlib

---

### NEW: ShortList
- HMITileTrafficLight - Title (25%) + padding + LabelR (20%) + padding + Y (20%) + padding + B (20%) + padding + Label Unit (5%).
- HMITileEventViewer - Option hide the icon at beginning of the row: EVENT_LEVEL_NONE.
- HMITileIcon - API to change icon.
- All classes update private/public subs, align docs.
- Additional Get Started examples.
- Short developers documentation (how-to's, concept).
- Plugin external HMITiles without changing core.
- Test on Linux.
- Test on Raspberry Pi with TouchScreen.

## FIX: ShortList
- HMITileSelectList - Compact mode customlistview item height same as default mode.

---

### NEW: Tiles
| Tile Type                        | Alarm Allowed?  | Reason                               | State | Notes                    |
| -------------------------------- | --------------- | ------------------------------------ | ----- | ------------------------ |
| **TileBarGraph**                 | YES             | Displays monitored variables         | Open  |                          |
| **TileButton**                   | CONDITIONAL     | Only for alarm acknowledgement/reset | Done  |                          |
| **TileEvents**                   | YES             | Event/alarm viewer                   | Done  |                          |
| **TileFormHeader**               | NO              | Navigation/layout                    | Open  |                          |
| **TileGauge**                    | YES             | Displays monitored variables         | Done  |                          |
| **TileGrid**                     | NO              | Layout                               | Done  |                          |
| **TileImage**                    | NO              | Decorative                           | Done  |                          |
| **TileLabel**                    | YES             | Status indicator                     | Done  |                          |
| **TileLevel**                    | YES             | Displays monitored level             | Done  |                          |
| **TileMenuButton**               | NO              | Navigation only                      | Open  |                          |
| **TileRGB**                      | NO              | RGB Color control                    | Done  |                          |
| **TileReadOut**                  | YES             | Process values can be in alarm       | Done  |                          |
| **TileSensor**                   | YES             | Process values can be in alarm       | Done  |                          |
| **TileSeparator**                | NO              | Layout                               | Open  |                          |
| **TileSlider**                   | NO              | Process value set			        | Done  |                          |
| **TileStateIndicator**           | YES             | Represents safety/equipment state    | Open  |                          |
| **TileTrend**                    | YES             | Displays monitored variables         | Done  |                          |
| **TileValue (numeric, analog)**  | YES             | Process values can be in alarm       | Done  | Use TileLabel            |

#### Status
In progress.

### NEW: FarmKit32
Control the FarmKit32. 
Similar to HomeKit32 but then using the Keyestudio Smart Farm Kit [KS0567](docs.keyestudio.com/projects/KS0567/en/latest/wiki/index.html)
#### Status
In progress.

### UPD: HMITileImage Resize
Improve resize mode as bit of blur.
#### Status
In progress.

---
