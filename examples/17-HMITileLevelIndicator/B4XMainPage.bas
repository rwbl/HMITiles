B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileLevelIndicator
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileLevelIndicator.
' Description:	Shows level indicator (120x120px).
' Date:			2026-04-26
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileLabel As HMITileLabel
	Private TileButton As HMITileButton
	Private TileLevelIndicator As HMITileLevelIndicator
	Private TileLevelIndicatorCustom As HMITileLevelIndicator
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileLevelIndicator")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileLevelSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileLevelSetProperties
	TileLevelIndicator.Value = 68
	TileLabel.Text = $"Level${CRLF}${TileLevelIndicator.Value}"$

	TileLevelIndicatorCustom.Value = 29
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileButton_Click
	Dim v As Float = Rnd(0, 101)
	TileLevelIndicator.Value = v
	If v > 90 Then
		TileLevelIndicator.StatusAlarm
	Else if v > 80 Then
		TileLevelIndicator.StatusWarning
	Else 
		TileLevelIndicator.StatusNormal
	End If
	SetLabel

	TileLevelIndicatorCustom.Value = v
End Sub

Private Sub TileLevelIndicator_Click (Value As Float)
	SetLabel
End Sub

Private Sub SetLabel
	TileLabel.Text = $"Level${CRLF}${TileLevelIndicator.Value}${CRLF}${TileLevelIndicator.Status}"$
End Sub
