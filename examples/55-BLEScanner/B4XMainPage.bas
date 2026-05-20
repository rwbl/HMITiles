B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			BLEScanner
' Project:		HMITiles
' Brief:		Example using the BLE Scanner.
' Date:			2026-05-20
' Author:		Robert W.B. Linn (c) 2026 MIT
' Description:	Scan (AllowDuplicates set to false) for BLE devices and list their name and id (MAC address).
' Based on:		B4A forumm example www.b4x.com/android/forum/threads/b4x-ble-2-bluetooth-low-energy.59937/ (thanks for sharing)
' ================================================================

#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

'Ctrl + click to export as zip: ide://run?File=%B4X%\Zipper.jar&Args=BLEExample.zip

Sub Class_Globals
	Private VERSION As String = "BLEScanner v20260520"
	Private INFO 	As String = "HMITiles (c) 2025-2026 Robert W.B. Linn - MIT"

	' UI
	Private xui As XUI
	Private Root As B4XView
	Private TileReadoutBLEState As HMITileReadout
	Private TileButtonScanning As HMITileButton
	Private TileEventViewer As HMITileEventViewer
	Private LabelInfo As B4XView

	' BLE
	#if B4A
	Private manager As BleManager2
	Private rp As RuntimePermissions
	#else if B4i
	Private manager As BleManager
	#end if
	Private IsScanning As Boolean = False
	Private AllowDuplicates As Boolean = False
	
	' Helper
	Private bc As ByteConverter
End Sub

Public Sub Initialize
'	B4XPages.GetManager.LogEvents = True
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, VERSION)
	manager.Initialize("manager")
	
	LabelInfo.Text = INFO
	' Short sleep for HMITiles init
	Sleep(1)
	' Set and HMITiles properties
	TileEventViewer.RowHeight = 100
End Sub

Private Sub B4XPage_CloseRequest As ResumableSub
	If xui.IsB4A Then
		StopScan
	End If
	Return True
End Sub
Private Sub B4XPage_Pause (UserClosed As Boolean)
	StopScan
End Sub

Sub Manager_StateChanged (State As Int)
	Select State
		Case manager.STATE_POWERED_OFF
			TileReadoutBLEState.Value = "OFF"
		Case manager.STATE_POWERED_ON
			TileReadoutBLEState.Value = "ON"
		Case manager.STATE_UNSUPPORTED
			TileReadoutBLEState.Value = "ERR"
	End Select
	TileEventViewer.Insert($"BLE State changed to ${TileReadoutBLEState.Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

'| Key  | Meaning                               |
'| ---- | ------------------------------------- |
'| `1`  | Flags                                 |
'| `3`  | Complete List of 16-Bit Service UUIDs |
'| `9`  | Complete Local Name                   |
'| `0`  | Unknown / manufacturer-dependent      |
'| `-1` | Manufacturer Specific Data            |
Sub Manager_DeviceFound (Name As String, Id As String, AdvertisingData As Map, RSSI As Double)
	' Log("Found: " & Name & ", " & Id & ", RSSI = " & RSSI & ", " &  'ignore
	Dim sb As StringBuilder
	sb.Initialize
	For Each key As Int In AdvertisingData.Keys
		Dim data() As Byte = AdvertisingData.Get(key)
		sb.Append($"ADV Type=${key};ADV Data=${bc.HexFromBytes(data)}${CRLF}"$)
		' Log("AD Type=" & key & " Data=" & bc.HexFromBytes(data))
	Next
	TileEventViewer.Insert($"Device found: ${Name} ${Id} data=${sb.ToString}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub StartScan
	If manager.State <> manager.STATE_POWERED_ON Then
		TileEventViewer.Insert("BLE not powered on.", HMITileUtils.EVENT_LEVEL_WARNING)
	Else
		' Start scanning
		manager.Scan2(Null, AllowDuplicates)
		IsScanning = True
		TileEventViewer.Insert("Scan started.", HMITileUtils.EVENT_LEVEL_INFO)
	End If
End Sub

Private Sub StopScan
	If IsScanning Then
		manager.StopScan
		TileEventViewer.Insert("Scan stopped.", HMITileUtils.EVENT_LEVEL_INFO)
	End If
End Sub

' --------------------------------------------------------------
' HMITILES
' --------------------------------------------------------------
Private Sub TileButtonScanning_Click
	TileButtonScanning.Value = Not(TileButtonScanning.Value)
	If IsScanning Then 
		StopScan
	Else
		#if B4A
			'Don't forget to add permission to manifest
			Dim Permissions As List
			Dim phone As Phone
			If phone.SdkVersion >= 31 Then
				Permissions = Array("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", rp.PERMISSION_ACCESS_FINE_LOCATION)
			Else
				Permissions = Array(rp.PERMISSION_ACCESS_FINE_LOCATION)
			End If
			For Each per As String In Permissions
				rp.CheckAndRequest(per)
				Wait For B4XPage_PermissionResult (Permission As String, Result As Boolean)
				If Result == False Then
				TileEventViewer.Insert($"No scan permission ${Permission}"$, HMITileUtils.EVENT_LEVEL_WARNING)
					Return
				End If
			Next
		#end if
		StartScan
	End If
End Sub

' Clicking on an item will show messagebox and copies the content to the clipboard.
Private Sub TileEventViewer_ItemClick (Index As Int, Value As Object)
	xui.MsgboxAsync(Value, "Event Item")
	CopyToClipboard(Value)
End Sub

' --------------------------------------------------------------
' HELPERS
' --------------------------------------------------------------
' Utility to convert short UUIDs to long format on Android
Public Sub UUID(id As String) As String 'ignore
#if B4A
	Return "0000" & id.ToLowerCase & "-0000-1000-8000-00805f9b34fb"
#else if B4I
	Return id.ToUpperCase
#End If
End Sub

' CopyToClipboard
' Copy text to the clipboard
Sub CopyToClipboard(Text As String)
	Dim ctxt As JavaObject
	ctxt.InitializeContext
    
	Dim clipboard As JavaObject = ctxt.RunMethod("getSystemService", Array("clipboard"))
    
	Dim clipData As JavaObject
	clipData.InitializeStatic("android.content.ClipData")
    
	Dim clip As JavaObject = clipData.RunMethod("newPlainText", Array("BLE Data", Text))
	clipboard.RunMethod("setPrimaryClip", Array(clip))
End Sub

