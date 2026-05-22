### Additional Examples

#### 📦 Conveyor Sorting Simulator (`ConveyorSortingSimulator.b4x`)
A material-handling production simulation tracking discrete manufacturing logistics via a VFD-driven motor.
* VFD Acceleration Curves: Models realistic motor spin-up and emergency deceleration ramp-down behaviors based on frequency (Hz) instead of snapping values instantly.
* Throughput Accumulator: Implements an internal floating-point mathematical accumulator to accurately count and log physical packages and live rates per minute.
* Hierarchical Alarm Levels: Demonstrates dual-state fault tracking where a sorting line jam immediately shifts the primary status tile to critical red, triggers an warning-state amber indicator on the blocked sensor tile, and forces a rapid line deceleration.

