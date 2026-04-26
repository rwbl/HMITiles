B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileRGB
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileRGB.
' Description:	Shows horizontl RGB and vertical RGB.
' NOTE:			Not working properly on B4A.
' Date:			2026-04-24
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileRGBHor As HMITileRGB
	Private TileRGBVer As HMITileRGB
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileRGB")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: 120x120px. Tile color Yellow=Warning, Red=Alarm."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileRGBSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileRGBSetProperties

End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileRGBHor_ValueChanged (m As Map)
	Log($"[TileRGBHor_ValueChanged] value=${m}"$)
End Sub

Private Sub TileRGBVer_ValueChanged (m As Map)
	Log($"[TileRGBVer_ValueChanged] value=${m}"$)
End Sub
