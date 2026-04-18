B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
' Class:        BLECommands
' Brief:        Registry of BLE command definitions.
' Date:         2026-04-18
' Author:       Robert W.B. Linn (c) 2025 MIT
' Description:  Provides TCommand definitions and utilities.
' Note:			B4R uses unsigned bytes (0–255)
'				B4J uses signed bytes (–128 to +127) > use Int for fields Address and Command and NOT Byte.

Private Sub Class_Globals
	' Command definition
	Type TCommand (Name As String, Address As Int, Command As Int, Description As String, Value As Byte)

	' List of commands
	Public ListCommands As List
End Sub

' Initializes the object.
' The list must contain unique command names.
Public Sub Initialize
	' Init the list
	ListCommands.Initialize

	Add("Connect",  	"Connect ESP32", BLEConstants.ADR_SYSTEM, BLEConstants.CMD_SET_STATE,  BLEConstants.VAL_ON)
	Add("Disconnect",	"Disonnect ESP32", BLEConstants.ADR_SYSTEM, BLEConstants.CMD_SET_STATE, BLEConstants.VAL_OFF)

	Add("LED ON",  		"Turn LED ON",  BLEConstants.ADR_LED, BLEConstants.CMD_SET_STATE, BLEConstants.VAL_ON)
	Add("LED OFF", 		"Turn LED OFF",  BLEConstants.ADR_LED, BLEConstants.CMD_SET_STATE, BLEConstants.VAL_OFF)
	Add("LED STATE", 	"Request LED state", BLEConstants.ADR_LED, BLEConstants.CMD_GET_STATE, BLEConstants.VAL_NONE)

	Log($"[BLECommands.Initialize] commands=${ListCommands.Size}"$)
End Sub

#Region CommandList
' Adds a command definition
Public Sub Add(name As String, desc As String, adr As Int, cmd As Int, val As Byte)
	Dim c As TCommand
	c.Initialize
	c.Name = name
	c.Address = adr
	c.Command = cmd
	c.Description = desc
	c.Value = val
	ListCommands.Add(c)
End Sub

' Get a command (must match both Device + Command)
Public Sub Get(address As Byte, command As Byte) As TCommand
	For Each c As TCommand In ListCommands
		If c.address = address And c.Command = command Then
			Return c
		End If
	Next
	Return Null
End Sub

' Find a command by name
Public Sub Find(name As String) As TCommand
	For Each c As TCommand In ListCommands
		If c.Name.ToLowerCase = name.ToLowerCase Then
			Return c
		End If
	Next
	Return Null
End Sub

' BuildPayload
' Build the 5-Byte payload
Public Sub BuildPayload(cmd As TCommand) As Byte()
	If cmd = Null Then Return Null

	Dim payload(5) As Byte
	payload(0) = BLEConstants.FRAME_HDR
	payload(1) = cmd.Address
	payload(2) = cmd.Command
	payload(3) = cmd.Value
	payload(4) = BLEConstants.FRAME_FTR
	Return payload
End Sub
#End Region
