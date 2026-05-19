B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileButton.bas
' Brief:    	CustomView HMITile that behaves like a button (clickable).
'           	Supports Normal, Warning, Error, Dimmed styles.
' Date:			2026-01-29
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Layout:
'				+------------------+
'				|      Title       |   <- h=25%
'				|      STATE       |   <- h=60%
'				+------------------+
'				Note: Layout aligned with HMITileReadOut.
' Properties:	All style properties are defined in HMITileUtils.
'				The designer properties are not used.
'				Title - Base properties set from Label property.
'						Text set from designer property TitleText.
'				State - Base properties set from Label property.
'						Text set from designer property Text (Label)

' Hints:		Button On/Off mental mindset example Window button:
'				Rule = Button shows what it will do
'				| Window state (`Value`) | Meaning | Button text (action) |
'				| ---------------------- | ------- | -------------------- |
'				| `False`                | Closed  | **OPEN**             |
'				| `True`                 | Open    | **CLOSE**            |
'				State (Value)	> what it Is right now
'				Button text		> what it will Do when pressed

' Modes:		This HMITileButton is a single CustomView with multiple behaviors:
'				Normal Button - Set text As normal Label; no change if clicked
'					TileButton1.OnText = "Start"
'					TileButton1.OffText = "Start"

'				Toggle Button - Using FA toggle icons
'					TileButtonToggle.ValueFontFontAwesome
'					TileButtonToggle.OnText = Chr(0xF205)
'					TileButtonToggle.OffText = Chr(0xF204)

'				Switch - Use "ON / OFF"
'					TileButton1.OnText = "ON"
'					TileButton1.OffText = "OFF"
'				Light Bulb Control
'					TileButtonToggle.ValueFontFontAwesome
'					TileButtonToggle.OnText = Chr(0xF0EB)
'					TileButtonToggle.OffText = Chr(0xF111)
'				Lock/Unlock
'					TileButtonToggle.ValueFontFontAwesome
'					TileButtonToggle.OnText = Chr(0xF023)
'					TileButtonToggle.OffText = Chr(0xF09C)
'				Open/Close
'					TileButtonToggle.ValueFontFontAwesome
'					TileButtonToggle.OnText = Chr(0xF2C2)
'					TileButtonToggle.OffText = Chr(0xF2C1)
'
' Examples:
'				Toggle Button with FontAwesome font

'					Private TileButtonToggle As HMITileButton
'					TileButtonToggle.ValueFontFontAwesome
'					TileButtonToggle.OnText = Chr(0xF205)
'					TileButtonToggle.OffText = Chr(0xF204)
'					TileButtonToggle.Value = False
'
'					' Button Click Event
'					' Button with fontawesome looks like a toggle switch.
'					' Important to set state
'					Private Sub HMITileButtonToggle_Click
'						TileButtonToggle.Value = Not(HMITileButtonToggle.Value)
'					End Sub
'
'				Callback: UI follows actual device status
'					Private TileButton1 As HMITileButton
'					' Button with text change
'					Private Sub TileButton1_Click
'						Dim state As Boolean = Not(DevYellowLed.Get)
'						DevYellowLed.Set(state)
'						TileButton1.Value = state
'					End Sub		
'
'				Alarm Button with status Normal ("Cleared") and Alarm ("ALARM") set by On/OffText property
'					Private TileButtonAlarm As HMITileButton
'					Private Sub TileButtonAlarm_Click
'						If TileButtonAlarm.Value Then
'							TileButtonAlarm.StatusAlarm
'						Else
'							TileButtonAlarm.StateNormal
'						End If
'						TileEventViewer.Insert($"[TileButtonAlarm] value=${TileButtonAlarm.Value}"$, HMITileUtils.EVENT_LEVEL_ALARM)
'					End Sub
'
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title,  	DisplayName: Title,  FieldType: String, DefaultValue: Title
' Functional state
#DesignerProperty: Key: Value,  	DisplayName: Value,  FieldType: Boolean, DefaultValue: False
' Semantic / visual state
#DesignerProperty: Key: Status, 	DisplayName: Status, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal
#DesignerProperty: Key: OnText, 	DisplayName: On Text, FieldType: String, DefaultValue: On
#DesignerProperty: Key: OffText,	DisplayName: Off Text, FieldType: String, DefaultValue: Off

' Events
#Event: Click

Private Sub Class_Globals
	' Base
	Public BasePane As B4XView
	Private BaseLabel As B4XView			'ignore
	Public Tag As Object

	' Events
	Private mEventName As String	'ignore
	Private mCallBack As Object		'ignore

	' UI
	Private xui As XUI
	Private LabelTitle As B4XView
	Private LabelValue As B4XView

	' Properties Designer
	Private mTitle As String
	Private mValue As Boolean
	Private mStatus As String
	Private mOnText As String
	Private mOffText As String

	' Properties Class
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
	BasePane.LoadLayout("hmitilebutton")
	
	' Properties Designer 
	mTitle			= Props.Get("Title")
	LabelTitle.Text	= mTitle
	mValue			= Props.Get("Value")
	mStatus 		= Props.Get("Status")
	mOnText 		= Props.Get("OnText")
	mOffText 		= Props.Get("OffText")

	ApplyStyle

	Base_Resize(BasePane.Width, BasePane.Height)

	setValue(mValue)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(LabelValue.IsInitialized) Then Return
	Dim l, t, w, h As Float
	
	If LabelTitle.Text.Length > 0 Then
		' Title
		l = 0
		t = 0
		w = Width
		h = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACTOR
		LabelTitle.SetLayoutAnimated(0, l, t, w, h)
		' Value
		l = 0
		t = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACTOR
		w = Width
		h = Height * HMITileUtils.TILE_VALUE_HEIGHT_FACTOR
		LabelValue.SetLayoutAnimated(0, l, t, w, h)
	Else
		' Title
		l = 0
		t = 0
		w = Width
		h = 0
		LabelTitle.SetLayoutAnimated(0, l, t, w, h)
		' Value
		l = 0
		t = 0
		w = Width
		h = Height
		LabelValue.SetLayoutAnimated(0, l, t, w, h)
	End If
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
' Get or set the title of the button.
Public Sub setTitle(value As String)
	mTitle = value
	LabelTitle.Text = mTitle
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

' Get or set the value of the button true or false.
Public Sub setValue(value As Boolean)
	mValue = value
	LabelValue.Text = IIf(mValue, mOnText, mOffText)
	HMITileUtils.ApplyValueStyleOnOff(BasePane, LabelValue, mValue)
End Sub
Public Sub getValue As Boolean
	Return mValue
End Sub

' Get or set the on text of the button.
Public Sub setOnText(value As String)
	mOnText = value
	LabelValue.Text = mOnText
End Sub
Public Sub getOnText As String
	Return mOnText
End Sub

' Get or set the off text of the button.
Public Sub setOffText(value As String)
	mOffText = value
	LabelValue.Text = mOffText
End Sub
Public Sub getOffText As String
	Return mOffText
End Sub

' Set the font of the label value to fontawesome.
Public Sub ValueFontFontAwesome
	LabelValue.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON)
End Sub

' Set the font of the label value to default.
Public Sub ValueFontDefault
	LabelValue.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_STATE)
End Sub

' Get or set the tile enabled/disabled..
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

Public Sub StatusDisabled
    setStatus(HMITileUtils.STATUS_DISABLED)
End Sub

' --- Core property ---
Public Sub setStatus(value As String)
	mStatus = value
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub

Public Sub getStatus As String
    Return mStatus
End Sub
#End Region

' ================================================================
' TILESTYLE
' ================================================================

#Region TileStyle
Private Sub ApplyStyle
	HMITileUtils.ApplyTileStyle(BasePane)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
    HMITileUtils.ApplyValueStyle(LabelValue)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================

#Region Events
#if B4J
Private Sub LabelTitle_MouseClicked(EventData As MouseEvent)
	TileClick
End Sub

Private Sub LabelValue_MouseClicked (EventData As MouseEvent)
	TileClick
End Sub
#End If

' B4X

Private Sub LabelValue_Click
	TileClick
End Sub

Private Sub LabelTitle_Click
	TileClick
End Sub

Private Sub TileClick
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
