B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileLevel
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileLevel.
' Description:	Shows level indicator (120x120px).
' Date:			2026-04-24
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileLabel As HMITileLabel
	Private TileButton As HMITileButton
	Private TileLevelBar As HMITileLevel
	Private TileLevelCircle As HMITileLevel
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileLevel")
	
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
	TileLevelBar.Value = 68
	TileLabel.Text = $"Level${CRLF}${TileLevelBar.Value}"$
	TileLevelCircle.Value = 68
	SetLabel
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileButton_Click
	Dim v As Float = Rnd(0, 101)
	TileLevelBar.Value = v
	If v > 80 Then
		TileLevelBar.StatusAlarm
	Else if v > 70 Then
		TileLevelBar.StatusWarning
	Else 
		TileLevelBar.StatusNormal
	End If
	SetLabel
	Dim v As Float = Rnd(0, 101)
	TileLevelCircle.Value = v
End Sub

Private Sub TileLevelBar_Click (Value As Float)
	SetLabel
End Sub

Private Sub SetLabel
	TileLabel.Text = $"Levels${CRLF}Bar:${NumberFormat(TileLevelBar.Value,0,0)} ${TileLevelBar.Status}${CRLF}Circle:${NumberFormat(TileLevelCircle.Value,0,0)}"$
End Sub
