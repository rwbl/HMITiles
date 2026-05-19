B4R=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=4
@EndOfDesignText@
' ================================================================
' File:        	DevLED.bas
' Brief:       	Set/Get the state of the led ON or OFF.
' Date:        	2026-04-18
' Author:      	Robert W.B. Linn (c) 2025 MIT
' Description:	Handle LED set or get state commands
' Example Frame:
'				Address: 0x60
'				Set LED state ON/OFF (Command 0x01).
'				Length: 5 Bytes
'				Byte 0 Header:	0x19 (fixed)
'				Byte 1 Address:	0x60
'				Byte 2 Command:	0x01 > Set
'				Byte 3 Value:	0x01 > ON Or 0x00 > OFF
'				Byte 4 Footer:	0x58 (fixed)
'				Example: Set ON = 1960010158
'
'				Get the state (Command 0x02)
'				Length: 5 Bytes
'				Byte 0 Header:	0x19 (fixed)
'				Byte 1 Address:	0x60
'				Byte 2 Command:	0x02 > Get
'				Byte 3 Value:	0x00
'				Byte 4 Footer:	0x58 (fixed)
'				Returns Byte 0=ON, 1=ON
'				Example Get State = 1060010200 which returns like 1960020158 (last byte holds Led state 0 (OFF), 1 (ON).
' ================================================================
#End Region

Private Sub Process_Globals
	Private Led As Pin
End Sub

' Initialize
' Initializes the module.
' Parameters:
'   pinnr - GPIO pin number
Public Sub Initialize(pinnr As Byte)
	Led.Initialize(pinnr, Led.MODE_OUTPUT)
	Led.DigitalWrite(False)
	Log("[DevLED.Initialize][I] OK, pin=", pinnr)
End Sub

' ------------------------------------------------
' Core hardware control (always compiled)
' ------------------------------------------------
#Region Device Control
' GetState
' Reads the current digital value.
' Parameters:
'   storeindex - Index in the global store buffer
' Returns:
'   Boolean - True if on, False otherwise
Public Sub Get As Boolean
	Return Led.DigitalRead
End Sub

' SetState
' Sets the state to on or off.
' Parameters:
'   state - Boolean.
Public Sub Set(state As Boolean)
	Led.DigitalWrite(state)
End Sub

' SetPWM
' Sets the PWM value (analog).
' Parameters:
'   value - UInt 0-255
Public Sub SetPWM(value As UInt)
	Led.AnalogWrite(value)
End Sub

' Toggle
' Toggle button state to on or off.
Public Sub Toggle()
	Dim newstate As Boolean = Not(Get)
	Set(newstate)
	Log("[DevLED.Toggle][I] newstate=", newstate)
End Sub
#End Region

' ------------------------------------------------
' BLE integration 
' ------------------------------------------------
#Region BLE Control
' ProcessCommand
' Parameters:
'   payload() - Payload array byte buffer.
Public Sub ProcesCommand(cmd As Byte, val As Byte)
	Log("[DevLED.ProcessCommand] cmd=", Convert.ByteToHex(cmd), " val=", Convert.ByteToHex(val))
		
	Select cmd
		Case CommBLE.CMD_SET_STATE
			Set(IIf(val == 1, True, False))
			WriteToBLE(cmd, val)
		Case CommBLE.CMD_GET_STATE
			Dim state As Byte = IIf(Get, 1, 0)
			WriteToBLE(cmd, state)
	End Select
End Sub

' WriteToBLE
' Write to BLE the command & value (connected client).
' Parameters:
'	cmd - Byte
'	val - Byte
Public Sub WriteToBLE(cmd As Byte, val As Byte)
	Dim payload(5) As Byte = Array As Byte( _
		CommBLE.FRAME_HEADER, _ 
		CommBLE.ADR_LED, _ 
		cmd, _ 
		val, _
		CommBLE.FRAME_FOOTER)
	Log("[DevLED.WriteToBLE] payload=", Convert.BytesToHex(payload))
	CommBLE.Write(payload)
End Sub
#End Region
