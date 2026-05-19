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
	Private TileCustomLabels As HMITileCustom
	Private TileCustomTitleAlarm As HMITileCustom
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
	TileCustomLabelsCreate
	TileCustomTitleAlarmCreate
End Sub

' ================================================================
' TileCustom
' ================================================================

' Create customized tile starting with empty pane.
' Added are 4 labels (B4XViews) top-down.
Private Sub TileCustomLabelsCreate
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
		left = HMITileUtils.TILE_PADDING
		top = (i * heightfactor) * TileCustomLabels.BasePane.Height
		width = TileCustomLabels.BasePane.Width - (HMITileUtils.TILE_PADDING * 2)
		height = TileCustomLabels.BasePane.Height * heightfactor
		' Add label to the base
		TileCustomLabels.BasePane.AddView(lbls(i), left, top, width, height)
	Next
End Sub

' Create customized tile starting with empty pane.
' Added are title label (height 0.25%) and value label
Private Sub TileCustomTitleAlarmCreate
	Dim left As Double
	Dim top As Double
	Dim width As Double
	Dim height As Double

	' Create label Title
	Dim titlelabel As B4XView
	titlelabel = XUIViewsUtils.CreateLabel
	titlelabel.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_TITLE)
	titlelabel.SetTextAlignment("CENTER", "CENTER")
	titlelabel.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
	titlelabel.Text = $"TITLE ALARM"$
	left 	= 0
	top 	= 0	' if a band is required, use HMITileUtils.PADDING
	width 	= TileCustomTitleAlarm.BasePane.Width
	height	= TileCustomTitleAlarm.BasePane.Height * 0.25
	titlelabel.Color = HMITileUtils.COLOR_STATUS_ALARM_HI
	TileCustomTitleAlarm.BasePane.AddView(titlelabel, left, top, width, height)

	' Create label Value
	Dim valuelabel As B4XView
	valuelabel = XUIViewsUtils.CreateLabel
	valuelabel.Font = xui.CreateDefaultBoldFont(HMITileUtils.TEXT_SIZE_TITLE)
	valuelabel.SetTextAlignment("CENTER", "CENTER")
	valuelabel.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
	valuelabel.Text = $"VALUE"$
	left 	= 0
	top 	= TileCustomTitleAlarm.BasePane.Height * 0	' if a band is required, use HMITileUtils.PADDING
	width 	= TileCustomTitleAlarm.BasePane.Width
	height	= TileCustomTitleAlarm.BasePane.Height
	TileCustomTitleAlarm.BasePane.AddView(valuelabel, left, top, width, height)
End Sub
