B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileCustom
' Project:		HMITiles B4X library
' Brief:		Get started how to custom your own tile.
' Description:	Start with an empty HMITile and add 4 labels top-down.
' Date:			2026-04-26
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileCustom As HMITileCustom
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileCustom")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)

	' Make any HMITile property changes here
	TileCustomCreate
End Sub

' ================================================================
' TileCustom
' ================================================================

' Create customized tile starting with empty pane.
' Added are 4 labels (B4XViews) top-down.
Private Sub TileCustomCreate
	Dim left As Double
	Dim top As Double
	Dim width As Double
	Dim height As Double
	Dim heightfactor As Double = 0.25

	' Create 4 labels
	Dim lbls(4) As B4XView
	Dim titles() As String = Array As String("Custom Tile", "Info 1", "Info 2", "Footer")
	For i = 0 To 3
		lbls(i)		= XUIViewsUtils.CreateLabel
		lbls(i).Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_LABEL)
		lbls(i).SetTextAlignment("CENTER", "CENTER")
		lbls(i).TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
		lbls(i).Text = $"${titles(i)}"$
		left = HMITileUtils.PADDING
		top = (i * heightfactor) * TileCustom.mBase.Height
		width = TileCustom.mBase.Width - (HMITileUtils.PADDING * 2)
		height = TileCustom.mBase.Height * heightfactor
		' Add label to the base
		TileCustom.mBase.AddView(lbls(i), left, top, width, height)
	Next
End Sub
