B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=10.3
@EndOfDesignText@
' Static module:BLEConstants
' Brief:        BLE Constants
' Date:         2026-04-18
' Author:       Robert W.B. Linn (c) 2025 MIT
' Description:  Defines global BLE constants for connection and commands.
' Note:			B4R uses unsigned bytes (0–255)
'				B4J uses signed bytes (–128 to +127) > use Int for fields Address and Command and NOT Byte.
Sub Process_Globals
	
#Region BLE
	' BLE device (ESP32)
	Public BLE_MAC 						As String = "F8:B3:B7:7C:4E:BE"						
	Public BLE_DEVICE_NAME 				As String = "ESP32BLELED"							' Case sensitive, MUST MATCH name defined in B4R

	' BLE Service & Characteristics (see B4R firmware)
	Public SERVICE_UUID 				As String = "12345678-1234-1234-1234-1234567890ab"	 
	Public CHAR_UUID_TX 				As String = "abcd1234-5678-1234-5678-1234567890ab"	 
	Public CHAR_UUID_RX 				As String = "abcd1234-5678-1234-5678-1234567890ab"	
#End Region

#Region FRAME
	Public FRAME_HDR					As Byte = 0x19
	Public FRAME_FTR					As Byte = 0x58
#End Region


#Region Device IDs
	' Addresses for the devices (see B4R firmware)
	Public ADR_SYSTEM 					As Byte = 0x01
	Public ADR_LED 						As Byte = 0x60
#End Region

#Region Command IDs	
	' Commands (see B4R firmware)
	Public CMD_SET_STATE 				As Byte = 0x01
	Public CMD_GET_STATE 				As Byte = 0x02
#End Region

#Region Device States
	Public VAL_OFF 						As Byte = 0x00
	Public VAL_ON 						As Byte = 0x01
	Public VAL_NONE 					As Byte = 0x00
#End Region
	
End Sub
