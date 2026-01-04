# TODO HMITiles.b4xlib

---

### ShortList
- All classes upadet private/public subs, align docs.

---

### NEW: Tiles
| Tile Type                        | Alarm Allowed?  | Reason                               | State | Notes                    |
| -------------------------------- | --------------- | ------------------------------------ | ----- | ------------------------ |
| **TileLabel**                    | YES             | Status indicator                     | Done  |                          |
| **TileButton**                   | CONDITIONAL     | Only for alarm acknowledgement/reset | Done  |                          |
| **TileEvents**                   | YES             | Event/alarm viewer                   | Done  |                          |
| **TileSensor**                   | YES             | Process values can be in alarm       | Done  |                          |
| **TileReadOut**                  | YES             | Process values can be in alarm       | Done  |                          |
| **TileValue (numeric, analog)**  | YES             | Process values can be in alarm       | Done  | Use TileLabel            |
| **TileLevel**                    | YES             | Displays monitored level             | Done  |                          |
| **TileGauge**                    | YES             | Displays monitored variables         | Done  |                          |
| **TileBarGraph**                 | YES             | Displays monitored variables         | Open  |                          |
| **TileTrend**                    | YES             | Displays monitored variables         | Done  |                          |
| **TileStateIndicator**           | YES             | Represents safety/equipment state    | Open  |                          |
| **TileFormHeader**               | NO              | Navigation/layout                    | Open  |                          |
| **TileMenuButton**               | NO              | Navigation only                      | Open  |                          |
| **TileImage**                    | NO              | Decorative                           | Done  |                          |
| **TileGrid**                     | NO              | Layout                               | Done  |                          |
| **TileSeparator**                | NO              | Layout                               | Open  |                          |
| **TileRGB**                      | NO              | RGB Color control                    | Done  |                          |
| **TileSlider**                   | NO              | Process value set			        | Done  |                          |
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
