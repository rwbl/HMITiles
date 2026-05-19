B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileLabelTitle.bas
' Brief:		CustomView HMITile with a title label and centered label.
'				Style can be set to Normal, Warning, Alarm.
' Date:			2026-05-15
' Author:		Robert W.B. Linn (c) 2025 MIT
' Style:		- High-contrast foreground
'				- Alarm = red background + white text
'				- Warning = amber background + black text
'				- Normal = light background + dark text
'				| State    | Background | Text      | Readability         |
'				| -------- | ---------- | --------- | ------------------- |
'				| Normal   | light gray | dark gray | good                |
'				| Warning  | amber      | black     | high contrast       |
'				| Alarm    | red        | white     | very high contrast  |
'				Layout Default 120px x 120px
' Layout:
'				+------------------+
'				|      Title       |   <- h=25%
'				|      Label       |   <- h=60%
'				+------------------+
' ================================================================
#End Region

' Views
#DesignerProperty: Key: Title,	DisplayName: Title,		FieldType: String, DefaultValue: Title
#DesignerProperty: Key: Text,	DisplayName: Text,		FieldType: String, DefaultValue: Text
#DesignerProperty: Key: Status, DisplayName: Status,	FieldType: String, List: Normal|Warning|Alarm, DefaultValue: Normal

' Events
#Event: Click

Private Sub Class_Globals
	' Base
	Public BasePane As B4XView
	Private BaseLabel As B4XView	'ignore
	Public Tag As Object

	' XUI
	Private xui As XUI 'ignore
	Private LabelTitle As B4XView
	Private LabelText As B4XView

	' Events
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	
	' Properties Designer
	Private mTitle As String
	Private mText As String
	Private mStatus As String

	' Properties Class
	Private mTextSize As Double
	Private mTextColor As Int
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

'Base type must be Object
Private Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	' Load the customview layout(s) via CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilelabeltitle")

	' Get & assign designer properties	
	mTitle			= Props.Get("Title")
	LabelTitle.Text	= mTitle
	mText			= Props.Get("Text")
	LabelText.Text	= mText
	mTextSize		= LabelText.TextSize
	mTextColor		= LabelText.TextColor
	mStatus 		= Props.Get("Status")

	Base_Resize(BasePane.Width, BasePane.Height)
	ApplyStyle
	setStatus(mStatus)
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(LabelText.IsInitialized) Then Return

	Dim l, t, w, h As Float

	' Label Title	
	l = 0
	t = 0
	w = Width
	h = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACTOR
	LabelTitle.SetLayoutAnimated(0, l, t, w, h)

	' Label Text
	l = 0
	t = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACTOR
	w = Width
	h = Height * HMITileUtils.TILE_VALUE_HEIGHT_FACTOR
	LabelText.SetLayoutAnimated(0, l, t, w, h)
End Sub

' ===================================================================
' Public API
' ===================================================================

Public Sub setTitle(value As String)
	mTitle = value
	LabelTitle.Text = mTitle
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

Public Sub setText(value As String)
	mText = value
	LabelText.Text = mText
End Sub
Public Sub getText As String
	Return mText
End Sub

Public Sub setTextSize(value As Double)
	mTextSize = value
	LabelText.TextSize = value
End Sub
Public Sub getTextSize As Double
	Return mTextSize
End Sub

Public Sub setTextColor(value As Int)
	mTextColor = value
	LabelText.TextColor = value
End Sub
Public Sub getTextColor As Int
	Return mTextColor
End Sub

' Set the font of the label text to fontawesome.
Public Sub SetFontAwesome(large As Boolean)
	If large Then
		LabelText.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON_LARGE)
	Else
		LabelText.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON)
	End If
End Sub

' Set the font of the label text to default.
Public Sub SetFontDefault
	LabelText.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_STATE)
End Sub

Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
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

' --- Core property ---
Public Sub setStatus(value As String)
	mStatus = value
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub
Public Sub getStatus As String
	Return mStatus
End Sub

' ================================================================
' TILESTYLE
' ================================================================

#Region TileStyle
Private Sub ApplyStyle
	HMITileUtils.ApplyTileStyle(BasePane)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyTitleStyle(LabelText)
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
