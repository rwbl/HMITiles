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
' Date:			2026-01-04
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
' Modes:		This HMITileButton is a single CustomView with multiple behaviors:
'				Normal Button - Set text As normal Label
'					TileButton1.Text = "Start"
'				Toggle Button - Using FA toggle icons
'					TileButton1.Text = IIf(newState, Chr(0xF205), Chr(0xF204))
'				Switch - Use "ON / OFF"
'					TileButton1.Text = IIf(newState, "ON", "OFF")
'				Light Bulb Control
'					TileButton1.Text = IIf(newState, Chr(0xF0EB), Chr(0xF111))
'				Lock/Unlock
'					TileButton1.Text = IIf(locked, Chr(0xF023), Chr(0xF09C)) 
'				Open/Close
'					TileButton1.Text = IIf(isOpen, Chr(0xF2C2), Chr(0xF2C1))
'
' Examples:
'				Toggle Button with FontAwesome font
'					Private ITileButtonToggle As HMITileButton
'						' Set LabelState font, state False And click To set the initial icon off
'						TileButtonToggle.SetStateFontFontAwesome
'						TileButtonToggle.State = False
'						TileButtonToggle_Click
'
'					' Button Click Event
'					' Button with fontawesome looks like a toggle switch.
'					' Important to set state
'					Private Sub HMITileButtonToggle_Click
'						TileButtonToggle.SetState(HMITileButtonToggle.State)
'						TileButtonToggle.StateText = IIf(HMITileButtonToggle.State, Chr(0xF205), Chr(0xF204)) ' FA toggle-on / toggle-off
'						TileEventViewer1.Insert($"[HMITileButtonToggle] state=${HMITileButtonToggle.State}"$, HMITileUtils.EVENT_LEVEL_INFO)
'					End Sub
'
'				Callback: UI follows actual device state
'					Private TileButton1 As HMITileButton
'					' Button with text change
'					Private Sub TileButton1_Click
'						Dim state As Boolean = Not(DevYellowLed.Get)
'						DevYellowLed.Set(state)
'						TileButton1.Text = IIf(state, "ON", "OFF")
'						TileButton1.SetStateColor(state)
'					End Sub		
'
'				Alarm Button with state Normal ("Cleared") and Alarm ("ALARM")
'					Private TileButtonAlarm As HMITileButton
'					Private Sub TileButtonAlarm_Click
'						If TileButtonAlarm.State Then
'							TileButtonAlarm.SetNormal("Cleared")
'						Else
'							TileButtonAlarm.SetAlarm("ALARM")
'						End If
'						TileEventViewer.Insert($"[TileButtonAlarm] state=${TileButtonAlarm.State}"$, HMITileUtils.EVENT_LEVEL_ALARM)
'					End Sub
'
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 		DisplayName: Title, FieldType: String, DefaultValue: Title
#DesignerProperty: Key: State, 		DisplayName: State, FieldType: String, DefaultValue: Button
#DesignerProperty: Key: TypeStyle, 	DisplayName: Button Style, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

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
	Private LabelState As B4XView

	' Fixed properties
	Private mTypeStyle As String
	Private mIsPressed As Boolean = False			'ignore
	Private mState As Boolean
	Private mStateText As String
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
	LabelTitle.Text	= Props.Get("Title")
	LabelState.Text	= Props.Get("State")
	mTypeStyle 		= Props.Get("TypeStyle")
	ApplyStyle(mTypeStyle)
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(LabelState.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING
	
	If LabelTitle.Text.Length > 0 Then
		LabelTitle.SetLayoutAnimated(0, pad,  pad,           Width - pad * 2, Height * 0.25)
		LabelState.SetLayoutAnimated(0, pad,  Height * 0.25, Width - pad * 2, Height * 0.60)
	Else
		LabelTitle.SetLayoutAnimated(0, pad,  pad,           Width - pad * 2, Height * 0)
		LabelState.SetLayoutAnimated(0, pad,  0,        	 Width - pad * 2, Height)
	End If
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
' Get or set the title of the button.
Public Sub setTitle(value As String)
	LabelTitle.Text = value
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

' Get or set the state text of the button.
Public Sub setStateText(value As String)
	mStateText = value
	LabelState.Text = mStateText
End Sub
Public Sub getStateText As String
	Return mStateText
End Sub

' Get or set the state of the button.
Public Sub setState(value As Boolean)
	mState = value
	HMITileUtils.ApplyStyleStateOnOff(mBase, LabelState, mState)
End Sub
Public Sub getState As Boolean
	Return mState
End Sub

Public Sub NewState(value As Boolean)
	mState = value
	HMITileUtils.ApplyStyleStateOnOff(mBase, LabelState, mState)
End Sub

' Set the font of the label state to fontawesome.
Public Sub SetStateFontFontAwesome
	LabelState.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON)
End Sub

' Set the font of the label state to default.
Public Sub SetStateFontDefault
	LabelState.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_STATE)
End Sub

' Set the color of the label state to fontawesome.
Public Sub SetStateColor(success As Boolean)
	HMITileUtils.ApplyStyleStateOnOff(mBase, LabelState, success)
End Sub

' Get or set the tile enabled/disabled..
Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

' Set the typestyle to normal.
Public Sub SetNormal(text As String)
	setStateText(text)
	setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)
End Sub

' Set the typestyle to warning.
Public Sub SetWarning(text As String)
	setStateText(text)
	setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)
End Sub

' Set the typestyle to alarm.
Public Sub SetAlarm(text As String)
	setStateText(text)
	setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)
End Sub

' Applies one of the tile styles.
' tilestate - Use STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
' Parameters:
'	value String 
Public Sub setTypeStyle(value As String)
	mTypeStyle = value
	ApplyStyle(mTypeStyle)
End Sub
Public Sub getTypeStyle As String
	Return mTypeStyle
End Sub
#End Region

' ================================================================
' Tile STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply one of the 4 styles Normal, Warning, Alarm, Disabled
' Parameters:
'	tilestate String - Use HMITileUtils constants STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
Public Sub ApplyStyle(tilestate As String)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelState)

	Dim textcolor As Int = HMITileUtils.COLOR_TILE_NORMAL_TEXT
	' Convert designer string → HMITile state constant
	Dim state As Int = HMITileUtils.StateStyleToState(tilestate)
	' --- Apply State Colors ---
	Select state

		Case HMITileUtils.STATE_NORMAL
			textcolor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

		Case HMITileUtils.STATE_WARNING
			textcolor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATE_ALARM
			textcolor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATE_DISABLED
			textcolor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	End Select
	LabelTitle.TextColor = textcolor
	LabelState.TextColor = textcolor
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
#if B4J
Private Sub LabelState_MouseClicked(EventData As MouseEvent)
	LabelState_Click
End Sub

Private Sub LabelTitle_MouseClicked (EventData As MouseEvent)
	LabelState_Click
End Sub
#End If

' B4X - use click only
Private Sub LabelState_Click
	'mState = Not(mState)
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub

Private Sub LabelTitle_Click
	LabelState_Click	
End Sub
#End Region
