B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileSensor
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileSensor.
' Description:	Shows several sensors.
' Date:			2026-04-21
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileSensor1 As HMITileSensor
	Private TileSensor2 As HMITileSensor
	Private TileSensor3 As HMITileSensor
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileSensor")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileSensorsSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileSensorsSetProperties
	' Set the icon selected from the Icon Picker
	' Only set the HEX value
	TileSensor1.Icon = "F241"
	TileSensor1.Value = 75
	TileSensor1.Unit = "%"
	
	' Set the unit
	TileSensor2.Unit = "°C"

	' Set status to alarm
	TileSensor3.StatusAlarm
End Sub


' ===================================================
' EVENTS
' ===================================================

Private Sub TileSensor1_Click
	Log($"[TileSensor1_Click] value=${TileSensor1.Value}"$)
End Sub

Private Sub TileSensor2_Click
	Log($"[TileSensor2_Click] value=${TileSensor2.Value}"$)
End Sub

Private Sub TileSensor3_Click
	Log($"[TileSensor3_Click] value=${TileSensor3.Value}"$)
End Sub
