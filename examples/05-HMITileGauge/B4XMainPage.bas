B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileGauge
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileGauge.
' Description:	Shows a gauge and a button to change the value randomly.
' Date:			2026-04-20
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileLabel As HMITileLabel
	Private TileGauge As HMITileGauge
	Private TileButton As HMITileButton
	Private TileGaugeNeedle As HMITileGauge
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileGauge")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileGaugeSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileGaugeSetProperties
	TileButton_Click
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileGauge_Click (Value As Float)
	TileLabel.Text = $"Gauge${CRLF}Value:${CRLF}${TileGauge.Value}"$
End Sub

Private Sub TileButton_Click
	TileGauge.Value = Rnd(0, 101)
	TileGaugeNeedle.Value = Rnd(0, 181)
	TileLabel.Text = $"New Values:${CRLF}${TileGauge.Value}${CRLF}${TileGaugeNeedle.Value}"$
End Sub