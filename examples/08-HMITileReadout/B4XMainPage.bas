B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileReadout
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileReadout
' Description:	Shows several readouts.
' Date:			2026-04-21
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileReadout1 As HMITileReadout
	Private TileReadout2 As HMITileReadout
	Private TileReadout3 As HMITileReadout
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileReadout")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: 120x120px. Tile color Yellow=Warning, Red=Alarm."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileReadoutsSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileReadoutsSetProperties
	' Set value & unit
	TileReadout1.Value = 75
	TileReadout1.Unit = "%"
	
	' Set the unit
	TileReadout2.Unit = "°C"

	' Set status to alarm
	TileReadout3.StatusAlarm
End Sub


' ===================================================
' EVENTS
' ===================================================

Private Sub TileReadout1_Click
	Log($"[TileReadout1_Click] value=${TileReadout1.Value}"$)
End Sub

Private Sub TileReadout2_Click
	Log($"[TileReadout2_Click] value=${TileReadout2.Value}"$)
End Sub

Private Sub TileReadout3_Click
	Log($"[TileReadout3_Click] value=${TileReadout3.Value}"$)
End Sub
