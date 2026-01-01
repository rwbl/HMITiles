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
' Date:			2025-12-28
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
'				Layout 120dip x 120dip
' Layout:
'				+-----+
'				|+---+|
'				|| T ||
'				|+---+|
'				+-----+
' ================================================================
#End Region

' Views
#DesignerProperty: Key: LabelText, DisplayName: Text, FieldType: String, DefaultValue: Label
#DesignerProperty: Key: TypeStyle, DisplayName: Type Style, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click

Sub Class_Globals
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

	' Properties (designer)
	Private mTypeStyle As String
	
	' Properties (class)
	Private mState As Boolean = False
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

Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitilelabel")
	LabelText.Text = Props.Get("LabelText")
	mTypeStyle = Props.Get("TypeStyle")
	Base_Resize(mBase.Width, mBase.Height)
	ApplyStyle(mTypeStyle)
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

Public Sub setState(state As Boolean)
	mState = state
	HMITileUtils.ApplyStyleStateOnOff(mBase, LabelText, state)
End Sub
Public Sub getState As Boolean
	Return mState
End Sub

Public Sub SetInfo(text As String)
	setText(text)
	setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)
End Sub

Public Sub SetWarning(text As String)
	setText(text)
	setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)
End Sub

Public Sub SetAlarm(text As String)
	setText(text)
	setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)
End Sub

Public Sub setTypeStyle(value As String)
	mTypeStyle = value
	ApplyStyle(mTypeStyle)
End Sub
Public Sub getTypeStyle As String
	Return mTypeStyle
End Sub

' ================================================================
' HMITile STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply one of the 4 styles Normal, Warning, Alarm, Disabled
' Parameters:
'	tilestate String - Use HMITileUtils constants STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
Public Sub ApplyStyle(tilestate As String)

	Dim state As String = HMITileUtils.StateStyleToState(tilestate)

	' Default text properties
	LabelText.TextSize = HMITileUtils.TEXT_SIZE_TITLE
	LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
	' --- Apply State Colors ---
	Select state
		Case HMITileUtils.STATE_NORMAL
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY

		Case HMITileUtils.STATE_WARNING
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_WARNING

		Case HMITileUtils.STATE_ALARM
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND
			LabelText.TextColor = HMITileUtils.COLOR_TEXT_ERROR

		Case HMITileUtils.STATE_DISABLED
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
		CallSub(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
