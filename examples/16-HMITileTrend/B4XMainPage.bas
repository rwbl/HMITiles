B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileTrend
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileTrend.
' Description:	Shows HMITrend (120x120px).
' Date:			2026-04-20
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileLabel As HMITileLabel
	Private TileButton As HMITileButton
	Private TileTrend As HMITileTrend
	Private TileTrendInfo As HMITileTrend
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileTrend")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileTrendSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileTrendSetProperties
	TileTrend.GridLineColor = HMITileUtils.COLOR_BORDER_DARK
	TileTrend.AddAll(Array As Float(19, 58, 67, 20, 26))
	TileLabel.Text = $"Samples: ${TileTrend.Size}"$
	TileTrendInfo.SetTitleColorInfo
	TileTrendInfo.AddAll(Array As Float(9, 8, 19, 58, 67))
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileButton_Click
	TileTrend.Add(Rnd(0, 101))
	TileTrendInfo.Add(Rnd(0, 101))
	TileLabel.Text = $"Samples: ${TileTrend.Size}"$
End Sub