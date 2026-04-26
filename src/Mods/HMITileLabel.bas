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
#DesignerProperty: Key: Text, DisplayName: Text, FieldType: String, DefaultValue: Label
#DesignerProperty: Key: Status, DisplayName: Status, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click

Private Sub Class_Globals
	' Base
	Public mBase As B4XView
	Public mLbl As B4XView
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
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me
	' Load the customview layout(s) via CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitilelabel")
	
	mText			= Props.Get("Text")
	LabelText.Text	= mText
	mStatus 		= Props.Get("Status")
	Base_Resize(mBase.Width, mBase.Height)
	ApplyStatusStyle(mStatus)
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	' Only resize if view is initialized
	If Not(LabelText.IsInitialized) Then Return

	Dim offset As Int = HMITileUtils.BORDER_WIDTH
	LabelText.SetLayoutAnimated(0, offset, offset, Width - offset*2, Height - offset*2)
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
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
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
Public Sub StatusNormal(text As String)
	setStatus(HMITileUtils.STATUS_NORMAL)
End Sub

Public Sub StatusWarning(text As String)
	setStatus(HMITileUtils.STATUS_WARNING)
End Sub

Public Sub StatusAlarm(text As String)
	setStatus(HMITileUtils.STATUS_ALARM)
End Sub

Public Sub StatusDisabled(text As String)
	setStatus(HMITileUtils.STATUS_DISABLED)
End Sub

' --- Core property ---
Public Sub setStatus(value As String)
	ApplyStatusStyle(value)
End Sub
Public Sub getStatus As String
	Return mStatus
End Sub

' ================================================================
' TILE STATUSSTYLE
' ================================================================

#Region StatusStyle
' ApplyStatusStyle
' Set one of the 4 visual status Normal, Warning, Alarm, Disabled
' Parameters:
'	status String - Use HMITileUtils constants STATUS_NORMAL_TEXT ... WARNING, ALARM, DISABLED
Private Sub ApplyStatusStyle(status As String)
	mStatus = status
	
	' Default text properties
	LabelText.TextSize = HMITileUtils.TEXT_SIZE_TITLE
	LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY

	Select status
		Case HMITileUtils.STATUS_NORMAL
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY

		Case HMITileUtils.STATUS_WARNING
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_WARNING

		Case HMITileUtils.STATUS_ALARM
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_ERROR

		Case HMITileUtils.STATUS_DISABLED
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_DISABLED
	End Select
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
' B4J - Mouse Events (Button Behavior - uses B4X click)
#if B4J
Private Sub LabelText_MouseClicked (EventData As MouseEvent)
	LabelText_Click
End Sub
#End If

' B4X - use click only
Private Sub LabelText_Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
