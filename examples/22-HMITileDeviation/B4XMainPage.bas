B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileDeviation
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileDeviation.
' Description:	Shows level indicator (120x120px).
' Date:			2026-04-27
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileLabel As HMITileLabel
	Private TileButton As HMITileButton
	Private TileDeviation As HMITileDeviation
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileDeviation")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileDeviationSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileDeviationSetProperties
	TileDeviation.Value = 29
	TileLabel.Text = $"Level${CRLF}${TileDeviation.Value}"$
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileButton_Click
	Dim v As Float = Rnd(-100, 101)
	TileDeviation.Value = v
	SetLabel
End Sub

Private Sub TileDeviation_Click (Value As Float, status As String)
	xui.MsgboxAsync($"Value: ${Value}${CRLF}Status: ${status}"$, "Deviation")
End Sub

Private Sub SetLabel
	TileLabel.Text = $"Level${CRLF}${TileDeviation.Value}${CRLF}${TileDeviation.Status}"$
End Sub
