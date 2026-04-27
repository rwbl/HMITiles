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
' Date:			2026-01-23
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
	Public mBase As B4XView
	Private mLbl As B4XView			'ignore
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
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitilebutton")
	
	' Properties Designer 
	mTitle			= Props.Get("Title")
	LabelTitle.Text	= mTitle
	mValue			= Props.Get("Value")
	mStatus 		= Props.Get("Status")
	mOnText 		= Props.Get("OnText")
	mOffText 		= Props.Get("OffText")

	ApplyStatusStyle(mStatus)

	Base_Resize(mBase.Width, mBase.Height)

	setValue(mValue)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(LabelValue.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING
	
	If LabelTitle.Text.Length > 0 Then
		LabelTitle.SetLayoutAnimated(0, pad,  pad,           Width - pad * 2, Height * 0.25)
		LabelValue.SetLayoutAnimated(0, pad,  Height * 0.25, Width - pad * 2, Height * 0.60)
	Else
		LabelTitle.SetLayoutAnimated(0, pad,  pad,           Width - pad * 2, Height * 0)
		LabelValue.SetLayoutAnimated(0, pad,  0,        	 Width - pad * 2, Height)
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
	HMITileUtils.ApplyValueStyleOnOff(mBase, LabelValue, mValue)
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
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
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
    ApplyStatusStyle(value)
End Sub

Public Sub getStatus As String
    Return mStatus
End Sub
#End Region

' ================================================================
' TILE STATUSSTYLE
' ================================================================

#Region StatusStyle
' ApplyStatustyle
' Set one of the 4 visual status Normal, Warning, Alarm, Disabled
' Parameters:
'	status String - Use HMITileUtils constants STATUS_NORMAL_TEXT ... WARNING, ALARM, DISABLED
Private Sub ApplyStatusStyle(status As String)
    mStatus = status

    HMITileUtils.ApplyTitleStyle(LabelTitle)
    HMITileUtils.ApplyValueStyle(LabelValue)

    Dim textcolor As Int
	Select status
        Case HMITileUtils.STATUS_NORMAL
            textcolor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
            mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

        Case HMITileUtils.STATUS_WARNING
            textcolor = HMITileUtils.COLOR_TILE_WARNING_TEXT
            mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

        Case HMITileUtils.STATUS_ALARM
            textcolor = HMITileUtils.COLOR_TILE_ALARM_TEXT
            mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

        Case HMITileUtils.STATUS_DISABLED
            textcolor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
            mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
    End Select

    LabelTitle.TextColor = textcolor
    LabelValue.TextColor = textcolor
    mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================

#Region Events
#if B4J
Private Sub LabelValue_MouseClicked(EventData As MouseEvent)
	LabelValue_Click
End Sub

Private Sub LabelTitle_MouseClicked (EventData As MouseEvent)
	LabelValue_Click
End Sub
#End If

' B4X - use click only
Private Sub LabelValue_Click
	'mValue = Not(mValue)
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub

Private Sub LabelTitle_Click
	LabelValue_Click	
End Sub
#End Region
