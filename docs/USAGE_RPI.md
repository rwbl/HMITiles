# HMITiles on Raspberry Pi 5 (Bookworm)

Abbreviations
RPi = Raspberry Pi

---

## Purpose
Test the BuWizz2Controller example from HMITiles on a Raspberry Pi 5 running Raspberry Pi OS Bookworm, 
using Bleak via B4J PyBridge.

---

## RPi Python & Bleak Setup (Bookworm)
Bookworm enforces PEP 668, so Bleak must be installed in a virtual environment.

### Install required packages

```
sudo apt update
sudo apt install -y python3-venv python3-pip
```

### Create and activate virtual environment

```
python3 -m venv ~/bleak-env
source ~/bleak-env/bin/activate
```

### Install Bleak

```
pip install bleak
```

### Verify installation

```
python -c "import bleak; print('bleak import OK')"
```

**Expected output**
```
bleak import OK
```

### Verify Python path

```
which python
```

Example:
```
/home/rwbl/bleak-env/bin/python
```

**Note**
This exact path must be used by PyBridge.

---

## RPi Bluetooth
Ensure to turn on Bluetooth on the RPi.
```
systemctl status bluetooth
```

If needed:
```
sudo systemctl enable bluetooth
sudo systemctl start bluetooth
```

(Optional, recommended)
```
sudo usermod -aG bluetooth rwbl
```

Log out / log in afterward.

---

## B4J Source Configuration

### Build Configuration

In B4J IDE:
```
Menu Project > Build Configurations > Conditional Symbols
```

Add:
```
rpi
```

---

## PyBridge Python Path (BLEManager)

In source BLEManager:
Set path to Python for the PyBridge for the conditional `rpi`.
```
	' PyBridge
	Private PATH_TO_PYTHON As String = "Python/python/python.exe"
	' Set the path using Linux with f.e. B4JBridge
	#if linux
	Private PATH_TO_PYTHON As String = "/usr/bin/python3.12"
	#end if
	#if rpi
	Private PATH_TO_PYTHON As String = "/home/rwbl/bleak-env/bin/python"
	#end if
```

- PyBridge must point to the virtual-environment Python
- Shell activation (source activate) is irrelevant for PyBridge

---

## B4J Bridge

Start B4JBridge on the Raspberry Pi.

---

## B4J HMITiles
Run the test application from the B4J IDE.

---

### Example B4J IDE Log Output

```
*** mainpage: B4XPage_Created 
*** mainpage: B4XPage_Appear 
*** mainpage: B4XPage_Resize [mainpage]
17:50:48 - [B4XPage_Created] BuWizz2Controller v20260105
17:50:48 - [B4XPage_Created] BLE disconnected
[Initialize] MAC=50:FA:AB:38:A6:1A, UUID service=4e050000-74fb-4481-88b3-9919b1676e93, rx=000092d1-0000-1000-8000-00805f9b34fb, tx=000092d1-0000-1000-8000-00805f9b34fb
[BLEManager.PyBridgeStart] Py.Initialize...
Server is listening on port: 38789
Python path: /home/rwbl/bleak-env/bin/python
starting PyBridge v1.00
watchdog set to 30 seconds
Connecting to port: 38789
connected
[BLEManager.PyBridgeStart][I] Python process started.
17:50:49 - [B4XPage_Created] PyBridge started, BLE initialized
17:51:04 - [TileButtonConnect_Click] Connecting to BuWizz2
[BLEManager.Scan][I] Scanning devices, serviceuuid=4e050000-74fb-4481-88b3-9919b1676e93
[BLEManager.Scan][I] Devices found.
[BLEManager.BLE_DeviceFound][I] id=50:FA:AB:38:A6:1A, name=, services=[4e050000-74fb-4481-88b3-9919b1676e93], servicedata={}
[BLEManager.BLEConnect][I] Connecting to deviceid=50:FA:AB:38:A6:1A
[BLEManager.BLEConnect] Connected
17:51:05 - [HandleBLEConnect] Connected to BuWizz2
[BLEManager.SetNotify][I] OK. Waiting for data...
[SetOutputLevel] cmd=1101, level=17, leveldefault=1
...
17:51:19 - [TileButtonConnect_Click] Disconnecting from BuWizz2
17:51:21 - [PyBridgeDisconnected] Disconnected
[BLEManager.BLE_DeviceDisconnected][I] Device disconnected
[BLEManager.Disconnect] Disconnected from deviceid=50:FA:AB:38:A6:1A
```

---

## Key Takeaways
- Bookworm requires virtual environments for pip packages
- PyBridge must point to the venv Python
- Shell activation does not affect PyBridge
- Bleak + PyBridge works reliably on Raspberry Pi 5
- This setup is suitable for long-running BLE control apps

---
