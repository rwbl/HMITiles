B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileLabel.bas
' Brief:		CustomView HMITile with a single label centered.
'				Style can be set to Normal, Warning, Alarm or Dimmed.
' Date:			2026-01-05
' Author:		Robert W.B. Linn (c) 2025 MIT
' Style:		- High-contrast foreground
'				- Alarm = red background + white text
'				- Warning = amber background + black text
'				- Normal = light background + dark text
'				- Dimmed = reduced contrast but still readable
'				| State    | Background | Text      | Readability         |
'				| -------- | ---------- | --------- | ------------------- |
'				| Normal   | light gray | dark gray | good                |
'				| Warning  | amber      | black     | high contrast       |
'				| Alarm    | red        | white     | very high contrast  |
'				| Disabled | gray       | soft gray | subtle but readable |
'				Layout Default 120px x 120px
' Layout:
'				+-----+
'				|+---+|
'				|| T ||
'				|+---+|
'				+-----+
' ================================================================
#End Region

' Views
#DesignerProperty: Key: Text,	DisplayName: Text,		FieldType: String, DefaultValue: Label
#DesignerProperty: Key: Status, DisplayName: Status,	FieldType: String, List: Normal|Warning|Alarm, DefaultValue: Normal

' Events
#Event: Click

Private Sub Class_Globals
	' Base
	Public BasePane As B4XView
	Public BaseLabel As B4XView
	Public Tag As Object

	' Events
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	
	' XUI
	Private xui As XUI 'ignore
	Private LabelText As B4XView

	' Properties Designer
	Private mText As String
	Private mStatus As String

	' properties Class
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

'Base type must be Object
Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	' Load the customview layout(s) via CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilelabel")
	
	mText			= Props.Get("Text")
	LabelText.Text	= mText
	mStatus 		= Props.Get("Status")
	Base_Resize(BasePane.Width, BasePane.Height)
	ApplyStyle
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	If Not(LabelText.IsInitialized) Then Return

	LabelText.SetLayoutAnimated(0, 0, 0, Width, Height)
End Sub

' ===================================================================
' Public API
' ===================================================================

Public Sub setText(text As String)
	LabelText.Text = text
End Sub
Public Sub getText As String
	Return LabelText.Text
End Sub

Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' Set the font of the label to fontawesome.
Public Sub SetFontAwesome(large As Boolean)
	If large Then
		LabelText.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON_LARGE)
	Else
		LabelText.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON)
	End If
End Sub

' Set the font of the label to default.
Public Sub SetFontDefault
	LabelText.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_STATE)
End Sub

' --- Convenience helpers ---
Public Sub StatusNormal
	setStatus(HMITileUtils.STATUS_NORMAL)
End Sub

Public Sub StatusWarning
	setStatus(HMITileUtils.STATUS_WARNING)
End Sub

Public Sub StatusAlarm
	setStatus(HMITileUtils.STATUS_ALARM)
End Sub

Public Sub StatusDisabled
	setStatus(HMITileUtils.STATUS_DISABLED)
End Sub

' --- Core property ---
Public Sub setStatus(value As String)
	mStatus = value
	ApplyStyle
End Sub
Public Sub getStatus As String
	Return mStatus
End Sub

' ================================================================
' TILESTYLE
' ================================================================

#Region TileStyle
' ApplyStyle
' Set one of the 4 visual status Normal, Warning, Alarm, Disabled
' Parameters:
'	status String - Use HMITileUtils constants STATUS_NORMAL_TEXT ... WARNING, ALARM
Private Sub ApplyStyle
	' Default text properties
	LabelText.TextSize = HMITileUtils.TEXT_SIZE_TITLE
	LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY

	Select mStatus
		Case HMITileUtils.STATUS_NORMAL
			BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY

		Case HMITileUtils.STATUS_WARNING
			BasePane.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_WARNING

		Case HMITileUtils.STATUS_ALARM
			BasePane.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_ERROR
	End Select
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
#if B4J
Private Sub LabelText_MouseClicked (EventData As MouseEvent)
	TileClick
End Sub
#End If

' B4X
Private Sub LabelText_Click
	TileClick
End Sub

Private Sub TileClick
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
