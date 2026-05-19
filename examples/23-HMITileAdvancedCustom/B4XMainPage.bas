B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileAdvancedCustom
' Project:		HMITiles B4X library
' Brief:		Get started how to custom change HMITiles
' Description:	Shows several customized tiles.
'				This is an advanced user example.
' Date:			2026-05-18
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileLabel As HMITileLabel
	Private TileLabelIcon As HMITileLabel
	Private TileReadout As HMITileReadout
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileAdvancedCustom")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: 120x120px. Tile color Yellow=Warning, Red=Alarm."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileCustomLabel
	TileCustomLabelIcon
	TileCustomReadOut
End Sub

' ================================================================
' PROPERTIES
' ================================================================

' Notes:
' - Use Log(v) to log the full property, i.e. (Label) Label@34f23208[styleClass=label]'Label'

' TileCustomLabel
' HMITile B4XViews:
'	Index 0 - Label
Private Sub TileCustomLabel
	LogLine
	Dim idx As Int = 0
	' Label
	For Each v As B4XView In TileLabel.BasePane.GetAllViewsRecursive
		Log($"[TileCustomLabel] index=${idx} type=${GetType(v)}"$)
		' [TileCustomLabel] index=0 type=javafx.scene.control.Label
		idx = idx + 1
	Next
	Log($"[TileCustomLabel] views=${idx}"$)
	' [TileCustomLabel] views=1

	' Get b4xview
	Dim vw0 As B4XView = TileLabel.BasePane.GetView(0)
	' Change properties
	Try
		vw0.TextSize = 48
		vw0.Color = xui.color_blue
	Catch
		Log($"[TileCustomLabel][E] ${LastException}"$)
	End Try
	LogLine
End Sub

' TileCustomLabelIcon
' HMITile B4XViews:
'	Index 0 - Label
Private Sub TileCustomLabelIcon
	LogLine
	Dim idx As Int = 0
	' Label
	For Each v As B4XView In TileLabelIcon.BasePane.GetAllViewsRecursive
		Log($"[TileCustomLabelIcon] index=${idx} type=${GetType(v)}"$)
		' [TileCustomLabelIcon] index=0 type=javafx.scene.control.Label
		idx = idx + 1
	Next
	Log($"[TileCustomLabelIcon] views=${idx}"$)
	' [TileCustomLabelIcon] views=1

	' Get b4xview
	Dim vw0 As B4XView = TileLabelIcon.BasePane.GetView(0)
	' Change properties
	Try
		Dim size As Float = vw0.Font.Size * 2
		vw0.Font = xui.CreateFontAwesome(size)
		Dim icon As String = Chr(0xF241)
		vw0.SetColorAndBorder(xui.Color_Transparent, 0, xui.Color_Transparent, 0)
		vw0.Text = icon
		vw0.TextColor = xui.color_white
		Log($"[TileCustomLabelIcon] size=${vw0.Font.size} / ${TileLabelIcon.BasePane.Width}"$)
	Catch
		Log($"[TileCustomLabelIcon][E] ${LastException}"$)
	End Try
	LogLine
End Sub


' TileCustomReadOut
' HMITile B4XViews:
'	Index 0 - Title
'	Index 1 - Value
'	Index 2 - Unit
Private Sub TileCustomReadOut
	LogLine
	Dim idx As Int = 0
	' Label
	For Each v As B4XView In TileReadout.BasePane.GetAllViewsRecursive
		Log($"[TileCustomReadOut] index=${idx} type=${GetType(v)}"$)
		idx = idx + 1
	Next
	Log($"[TileCustomReadOut] views=${idx}"$)
	' [TileCustomReadOut] views=3

	' Get b4xviews
	Dim vw0 As B4XView = TileReadout.BasePane.GetView(0)
	Dim vw1 As B4XView = TileReadout.BasePane.GetView(1)
	Dim vw2 As B4XView = TileReadout.BasePane.GetView(2)
	' Change properties
	Try
		vw0.color = xui.color_red
		vw1.TextSize = 48
		vw2.Visible  = False
	Catch
		Log($"[TileCustomReadOut][E] ${LastException}"$)
	End Try
	LogLine
End Sub

' ===================================================
' HELPER
' ===================================================

Private Sub LogLine
	Dim sb As StringBuilder
	sb.Initialize
	For i = 1 To 50
		sb.Append("=")
	Next
	Log($"${sb.ToString}"$)
End Sub
