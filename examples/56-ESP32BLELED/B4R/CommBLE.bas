B4R=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=4
@EndOfDesignText@
' ================================================================
' File:         CommBLE.bas
' Brief:        Handle BLE communication with the client. 
' Description:	The client connects and sends 5-byte frame to set the state of the ESP32 onboard LED.
'				BLE sevice name: ESP32BLELED.
' Date:         2026-04-18
' Author:       Robert W.W. Linn (c) 2025 MIT
' ================================================================

Private Sub Process_Globals
	
	' Frame
	' Header and footer
	Public FRAME_LENGTH 		As Byte	= 5
	Public FRAME_HEADER 		As Byte = 0x19
	Public FRAME_FOOTER 		As Byte = 0x58
	
	' Addresses
	Public ADR_SYSTEM			As Byte = 0x01
	Public ADR_LED				As Byte = 0x60

	' Commands
	Public CMD_SET_STATE 		As Byte = 0x01
	Public CMD_GET_STATE 		As Byte = 0x02
	Public CMD_SET_COLOR 		As Byte = 0x01
	Public CMD_GET_COLOR 		As Byte = 0x02
	Public CMD_SET_VALUE 		As Byte = 0x03
	Public CMD_GET_VALUE 		As Byte = 0x04
	Public CMD_CUSTOM_ACTION	As Byte	= 0x05
	
	' BLE ESP32 Plus BLE Peripheral + GATT Server
	Private BLE_SERVER_NAME		As String = "ESP32BLELED"
	Private BLEServer 			As NimBLEServer
End Sub

' Initialize
' Initializes BLE
Public Sub Initialize
	Log("[CommBLE.Initialize]")

    BLEServer.Initialize( _
        BLE_SERVER_NAME, _
        "12345678-1234-1234-1234-1234567890ab", _
        "abcd1234-5678-1234-5678-1234567890ab", _
        "OnConnected", _
        "OnDisconnected", _
        "OnReceived", _
        True)

	BLEServer.Start
	Log("[CommBLE.Initialize] Done")
End Sub

Sub OnConnected
	Log("[CommBLE.OnConnected] Client connected")
End Sub

Sub OnDisconnected
	Log("[CommBLE.OnDisconnected] Client disconnected")
End Sub

' Handle data received from connected client
Sub OnReceived (frame() As Byte)
	Log("[CommBLE.OnReceived] RX:", frame.Length, " ", Convert.BytesToHex(frame))
	ProcessCommand(frame)
End Sub

Public Sub Write(frame() As Byte)
	Log("[CommBLE.Write] ", Convert.BytesToHex(frame))
	BLEServer.Write(frame)
End Sub

' ProcessCommand
' Process the 5-byte command received from the client.
' Data format: [HDR][ADDR][CMD][VAL][FTR]
' Parameters:
' 	frame - Byte array holding the data send by the client
Private Sub ProcessCommand(frame() As Byte)
	' Commands received
	Private addr, cmd, val As Byte

	If frame.Length < FRAME_LENGTH Then
		Log("[CommBLE.ProcessCommand] Invalid frame length. Expect 5 bytes.")
	End If

	Log("[CommBLE.ProcessCommand] frame=", Convert.BytesToHex(frame))
	
	If frame(0) == FRAME_HEADER And frame(frame.Length - 1) == FRAME_FOOTER Then
		'hdr = frame(0)
		addr = frame(1)
		cmd = frame(2)
		val = frame(3)
		'ftr = frame(4)

		' [ProcessCommand] addr=96 cmd=1 val=0
		Log("[ProcessCommand] addr=", addr, " cmd=", cmd, " val=", val)
		' [ProcessCommand] addr=60 cmd=01 val=00
		Log("[CommBLE.ProcessCommand] addr=", Convert.ByteToHex(addr), " cmd=", Convert.ByteToHex(cmd), " val=", Convert.ByteToHex(val))
		' Select the device address
		Select addr
			Case 0
				' Reserved
			Case ADR_LED
				' Set the LED ON or OFF
				DevLED.ProcesCommand(cmd, val)
			Case Else
				' Do nothing
		End Select
	End If
End Sub

