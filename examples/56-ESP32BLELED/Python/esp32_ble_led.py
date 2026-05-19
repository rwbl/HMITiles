"""
File: esp32_ble_led.py
Brief: Set the state on an ESP32 onboard LED.
Date: 2026-04-18
Author:      Robert W.B. Linn (c) 2026 MIT
Description: Connect via BLE to the ESP32.
             Send 5-Byte frame to set the LED state on or off.
             Frame Format 5 Bytes: HDR ADR CMD VAL FTR
             TX ON: 19 60 01 01 58
             TX OFF: 19 60 01 00 58
"""

import sys
import asyncio
import threading

from bleak import BleakClient

from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QPushButton,
    QTextEdit,
    QVBoxLayout,
    QHBoxLayout,
)


# ---------------------------------------------------------------------
# BLE configuration
# ---------------------------------------------------------------------

ADDRESS = "80:F3:DA:4C:36:7A"
CHAR_UUID = "abcd1234-5678-1234-5678-1234567890ab"

FRAME_HEADER = 0x19
FRAME_FOOTER = 0x58

DEVICE_ADDRESS = 0x60
LED_CMD_STATE = 0x01

LED_VAL_ON = 0x01
LED_VAL_OFF = 0x00

CMD_ON = bytes(
    [FRAME_HEADER, DEVICE_ADDRESS, LED_CMD_STATE, LED_VAL_ON, FRAME_FOOTER]
)

CMD_OFF = bytes(
    [FRAME_HEADER, DEVICE_ADDRESS, LED_CMD_STATE, LED_VAL_OFF, FRAME_FOOTER]
)


# ---------------------------------------------------------------------
# Utility
# ---------------------------------------------------------------------

def bytes_to_hex(data: bytes) -> str:
    """Convert bytes to readable hex string."""
    return " ".join(f"{b:02X}" for b in data)


# ---------------------------------------------------------------------
# BLE Worker
# ---------------------------------------------------------------------

class BLEWorker:

    """Background BLE worker running asyncio loop."""

    def __init__(self, log_callback):
        self.log = log_callback
        self.loop = asyncio.new_event_loop()
        self.client = BleakClient(ADDRESS)

        self.thread = threading.Thread(target=self.run_loop, daemon=True)
        self.thread.start()

        asyncio.run_coroutine_threadsafe(self.connect(), self.loop)

    def run_loop(self):
        """Run asyncio loop in background thread."""
        asyncio.set_event_loop(self.loop)
        self.loop.run_forever()

    async def connect(self):
        """Connect to BLE device."""
        self.log("Connecting...")

        await self.client.connect()

        if self.client.is_connected:
            self.log("Connected")

            await self.client.start_notify(
                CHAR_UUID,
                self.notification_handler
            )

    def notification_handler(self, sender, data):
        """Handle BLE notifications."""
        self.log(f"ACK RX: {bytes_to_hex(data)}")

    def send(self, cmd, label):
        """Send command to device."""
        asyncio.run_coroutine_threadsafe(
            self.send_async(cmd, label),
            self.loop
        )

    async def send_async(self, cmd, label):
        """Async command sender."""
        if not self.client.is_connected:
            self.log("Not connected")
            return

        self.log(f"TX {label}: {bytes_to_hex(cmd)}")

        await self.client.write_gatt_char(
            CHAR_UUID,
            cmd
        )


# ---------------------------------------------------------------------
# GUI
# ---------------------------------------------------------------------

class ControlWindow(QWidget):

    """Main GUI window."""

    def __init__(self):
        super().__init__()

        self.setWindowTitle("ESP32BLELED")

        # Log window
        self.log = QTextEdit()
        self.log.setReadOnly(True)

        # Buttons
        self.btn_on = QPushButton("ON")
        self.btn_off = QPushButton("OFF")

        btn_layout = QHBoxLayout()
        btn_layout.addWidget(self.btn_on)
        btn_layout.addWidget(self.btn_off)

        layout = QVBoxLayout(self)
        layout.addLayout(btn_layout)
        layout.addWidget(self.log)

        # BLE worker
        self.ble = BLEWorker(self.log_message)

        # Button actions
        self.btn_on.clicked.connect(
            lambda: self.ble.send(CMD_ON, "ON")
        )

        self.btn_off.clicked.connect(
            lambda: self.ble.send(CMD_OFF, "OFF")
        )

    def log_message(self, msg):
        """Append message to log window."""
        self.log.append(msg)


# ---------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------

def main():
    """Application entry point."""

    app = QApplication(sys.argv)

    window = ControlWindow()
    window.resize(400, 250)
    window.show()

    sys.exit(app.exec())


if __name__ == "__main__":
    main()
    