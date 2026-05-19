B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileSeekBar
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileSeekBar.
' Description:	Show usage of the HMITileSeekBar.
' Date:			2026-04-24
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView

	Private TileSliderHor As HMITileSlider
	Private TileSliderVer As HMITileSlider
	Private TileSliderVerInd As HMITileSlider
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITileSlider")
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here	
	
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileSliderHor_ValueChanged (Value As Int)
	Log($"[TileSliderHor_ValueChanged] ${Value}"$)
	TileSliderVerInd.Value = Value
End Sub

Private Sub TileSliderVer_ValueChanged (Value As Int)
	Log($"[TileSliderVer_ValueChanged] ${Value}"$)
	TileSliderVerInd.Value = Value
End Sub