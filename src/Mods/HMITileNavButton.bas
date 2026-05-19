B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileNavButton.bas
' Brief:    	CustomView HMITile that behaves like a navigation button (clickable).
' Date:			2026-05-17
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	Page-Select Tile (navigation tile) should:
'				-Be instantly recognizable
'				-Be readable at a glance
'				-Never compete with process values
'				-Remain visually stable
'				-Icon dominates, text confirms.
' Layout:		Default 96x96px, Compact/secondary 72×72px
'				+------+
'				| Icon |   <- h=70%  Normal 24–28px
'				| Text |   <- h=30%  Normal 12–14px
'				+------+
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Icon, 		DisplayName: Icon (fontawesome), FieldType: String, DefaultValue: F060, Description: Icon indicating page type. Example: "F060" or "f060" (without 0x) or real character.
#DesignerProperty: Key: Text, 		DisplayName: Text, FieldType: String, DefaultValue: Page
#DesignerProperty: Key: SelectType, DisplayName: Select Type, FieldType: String, List: Page|Back, DefaultValue: Page, Description: Wether select a sub-page or go back to the main-page.

' Events
#Event: Click

Private Sub Class_Globals
	' Base
	Public BasePane As B4XView
	Private BaseLabel As B4XView					'ignore
	Public Tag As Object

	' Events
	Private mEventName As String					'ignore
	Private mCallBack As Object						'ignore

	' UI
	Private xui As XUI
	Private LabelIcon As B4XView
	Private LabelText As B4XView

	' Fixed properties
	Private mSelectType As String					'ignore
	Private mIsPressed As Boolean = False			'ignore
End Sub

Private Sub Initialize (Callback As Object, EventName As String)	'ignore
	mEventName = EventName
	mCallBack = Callback
End Sub

Private Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilenavbutton")

	' Get properties
	LabelIcon.Text  = Props.Get("Icon")
	' Check to remove 0x tn case icon starts with
	If LabelIcon.Text.ToLowerCase.Contains("0x") Then
		LabelIcon.Text = LabelIcon.Text.ToLowerCase.Replace("0x","")
	End If
	setIcon(LabelIcon.Text)
	LabelText.Text	= Props.Get("Text")
	mSelectType 	= Props.Get("SelectType")

	ApplyStyle
	Base_Resize(BasePane.Width, BasePane.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelIcon.IsInitialized) Or Not(LabelText.IsInitialized) Then Return

	' 							 d  l   t              	w      h
	LabelIcon.SetLayoutAnimated	(0, 0,  0, 				Width, Height)
	LabelText.SetLayoutAnimated	(0, 0,  Height * 0.80, 	Width, Height * 0.15)
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
' Icon
' Get or set the icon of the button.
' Example: "F060" or "f060" (without 0x) or real character.
Public Sub setIcon(iconHex As String)
	If iconHex == "" Then Return
	' Log($"[SetIcon] iconHex=${iconHex}, ${Bit.ParseInt(iconHex, 16)}"$)
	' expects "F043" or "f043" or real character
	Try
		If iconHex.Length > 0 And iconHex.Length <= 6 And iconHex.ToLowerCase.StartsWith("f") Then
			LabelIcon.Text = Chr(Bit.ParseInt(iconHex, 16))
		Else
			LabelIcon.Text = iconHex
		End If
	Catch
		LabelIcon.Text = iconHex
	End Try
End Sub
Public Sub getIcon As String
	Return LabelIcon.Text
End Sub

' Set the font of the label icon to fontawesome.
Public Sub SetIconFontFontAwesome
	LabelIcon.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON)
End Sub

' Get or set the text of the button.
Public Sub setText(value As String)
	LabelText.Text = value
End Sub
Public Sub getText As String
	Return LabelText.Text
End Sub

' SetSelectTypePage
' Set the nav button to select a sub-page.
' Parameters:
'	icon String - Fontawesome icon character, like Chr(0xF060) for fa-arrow-left
Public Sub SetSelectTypePage(icon As String, text As String)
	mSelectType = "Page"
	setIcon(icon)
	LabelText.Text = text
End Sub

' SetSelectTypeBack
' Set the nav button to select the home-page.
' The default fontawesome icon fa-arrow-left is set.
Public Sub SetSelectTypeBack
	mSelectType = "Back"
	setIcon(HMITileUtils.NAV_ICON_BACK)
	LabelText.Text = mSelectType
End Sub

' Get or set the tile enabled/disabled..
Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' ================================================================
' Tile STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply default stype Normal
' Parameters:
'	tilestate String - HMITileUtils.TYPESTYLE_NORMAL
Private Sub ApplyStyle
	' Do not use HMITileUtils.ApplyIconStyle(LabelIcon)
	LabelIcon.TextSize = HMITileUtils.TEXT_SIZE_ICON
	LabelIcon.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
	HMITileUtils.ApplyUnitStyle(LabelText)
	BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
#if B4J
Private Sub LabelText_MouseClicked(EventData As MouseEvent)
	LabelIcon_Click
End Sub

Private Sub LabelIcon_MouseClicked(EventData As MouseEvent)
	LabelIcon_Click
End Sub
#End If

' B4X - use click only
Private Sub LabelText_Click
	LabelIcon_Click
End Sub

Private Sub LabelIcon_Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
