B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileSeekBar
' Project:		HMITiles B4X library
' Brief:		Get started with the HMITileSeekBar.
' Description:	Show usage of the HMITileSeekBar.
' Date:			2026-04-19
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private TileSeekBarHor As HMITileSeekBar
	Private TileSeekBarVer As HMITileSeekBar
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITiles Library Get Started - HMITileSeekBar")
	
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

Private Sub TileSeekBarHor_ValueChanged (Value As Int)
	Log($"[TileSeekBarHor_ValueChanged] ${Value}"$)
End Sub

Private Sub TileSeekBarVer_ValueChanged (Value As Int)
	Log($"[TileSeekBarVer_ValueChanged] ${Value}"$)
End Sub
