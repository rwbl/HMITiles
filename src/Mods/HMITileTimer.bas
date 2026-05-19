B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileTimer.bas
' Brief:    	Customview HMITile timer (HH:MM:SS, MM:SS, SS)
' Description:	Stopwatch (Counter) with up & down direction.
'				Display formats: HH:MM:SS (Full), HH:MM (Short) or Seconds.
' Date:			2026-04-26
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, DisplayName: Title, FieldType: String, DefaultValue: Timer, Description: Title
#DesignerProperty: Key: DisplayFormat, DisplayName: Display Format, FieldType: String, List: HH:MM:SS|HH:MM|Seconds, DefaultValue: HH:MM:SS, Description: Counter display format
#DesignerProperty: Key: Mode, DisplayName: Mode, FieldType: String, List: UP|DOWN, DefaultValue: DOWN, Description: Mode counting up or down 
#DesignerProperty: Key: StartValue, DisplayName: Start Value, FieldType: Int, DefaultValue: 5, Description: Timer start value in seconds. If count up, start value must be greater stop value.
#DesignerProperty: Key: StopValue, DisplayName: Stop Value, FieldType: Int, DefaultValue: 0, Description: Timer stop value in seconds. If count down, start value must be greater stop value.

' Events
#Event: Start
#Event: Stop
#Event: Finished

Private Sub Class_Globals
	Private xui 					As XUI

	Public BasePane 				As B4XView
	Private BaseLabel 				As B4XView					'ignore
	Public Tag 						As Object

	' Events
	Private mEventName 				As String
	Private mCallBack 				As Object

	' UI
	Private LabelTitle 				As B4XView
	Private LabelTimer 				As B4XView
	Private LabelStatus 			As B4XView

	' Timer
	Private mTimer 					As Timer
	Private TIMER_MODE_COUNTUP 		As Byte = 0
	Private TIMER_MODE_COUNTDOWN 	As Byte = 1

	' Actions
	Private TIMER_STOP 				As Byte = 0
	Private TIMER_START 			As Byte = 1
	Private TIMER_RESET 			As Byte = 2

	' Properties
	Private mTitle					As String
	Private mDisplayFormat 			As String
	Public DISPLAY_FORMAT_HHMMSS 	As String = "HH:MM:SS"
	Public DISPLAY_FORMAT_HHMM 		As String = "HH:MM"
	Public DISPLAY_FORMAT_SECONDS 	As String = "Seconds"
	Private mMode 					As Byte					' Counting Up/Down
	Private mState	 				As Byte					' Start/Stop/Reset
	Private TIMER_STATE_STOP 		As String = "STOP"
	Private TIMER_STATE_START 		As String = "START"
	Private TIMER_STATE_RESET 		As String = "RESET"

	' Values
	Private mCounterValue 			As Long
	Private mStartValue 			As Long
	Private mStopValue 				As Long
End Sub

Private Sub Initialize(Callback As Object, EventName As String)	'ignore
	mEventName = EventName
	mCallBack = Callback
	mTimer.Initialize("Timer", 1000)
End Sub

Private Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me

	' Load the customview layout(s) via CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitiletimer")

	' Get the designer properties
	mTitle			= Props.Get("Title")
	mDisplayFormat	= Props.Get("DisplayFormat")
	mMode 			= IIf(Props.Get("Mode") == "UP", TIMER_MODE_COUNTUP, TIMER_MODE_COUNTDOWN)
	mStartValue  	= Props.Get("StartValue")
	mStopValue  	= Props.Get("StopValue")

	' Set class globals
	mState 			= TIMER_STOP
	mCounterValue 	= mStartValue

	' Set UI
	LabelTitle.Text	= mTitle
	UpdateLabelTimer
	LabelStatus.Text = TIMER_STATE_START   ' means "press to start"
	
	' Resize to get the sizing right
	Base_Resize(BasePane.Width, BasePane.Height)
	ApplyStyle
End Sub

Public Sub Base_Resize (Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return
	'								 d  l  t                w      h
	LabelTitle.SetLayoutAnimated	(0, 0, 0,           	Width, Height * 0.25)
	LabelTimer.SetLayoutAnimated 	(0, 0, 0, 				Width, Height)
	LabelStatus.SetLayoutAnimated  	(0, 0, Height * 0.80, 	Width, Height * 0.15)
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
' Start the timer.
Public Sub StartTimer
	mTimer.Enabled = True
End Sub

' Stop the timer
Public Sub StopTimer
	mTimer.Enabled = False
End Sub

' Get or set the title
Public Sub setTitle(value As String)
	mTitle = value
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

' Get or set the start value
Public Sub setStartValue(value As Float)
	mStartValue = value
End Sub
Public Sub getStartValue As Float
	Return mStartValue
End Sub

' Get or set the stop value
Public Sub setStopValue(value As Float)
	mStopValue = value
End Sub
Public Sub getStopValue As Float
	Return mStopValue
End Sub

' Reset countvalue and update label
Public Sub Reset
	mCounterValue = IIf(mMode == TIMER_MODE_COUNTDOWN, mStartValue, 0)
	UpdateLabelTimer
End Sub
' Get or set the timer enabled
Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	HMITileUtils.SetAlpha(BasePane.enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' Get or set the display format HHMMSS|HHMM|SS
Public Sub setDisplayFormat(format As String)
	mDisplayFormat = format.ToUpperCase
	UpdateLabelTimer
End Sub
Public Sub getDisplayFormat As String
	Return mDisplayFormat
End Sub

' Get or set the label timer text size
Public Sub setTimerTextSize(value As Double)
	LabelTimer.TextSize = value
End Sub
Public Sub getTimerTextSize As Double
	Return LabelTimer.TextSize
End Sub
#End Region

' ================================================================
' Tile STYLING
' ================================================================
#Region Tile Styling
' ApplyStyle
' Apply style Normal.
Private Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelTimer)
	HMITileUtils.ApplyActionStyle(LabelStatus)

	BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

#Region Timer
Private Sub Timer_Tick
	UpdateTimer
End Sub

Private Sub UpdateTimer
	' Update counter
	If mMode == TIMER_MODE_COUNTDOWN Then
		mCounterValue = mCounterValue - 1
	Else
		mCounterValue = mCounterValue + 1
	End If
	' Log($"[UpdateTimer] mode=${mMode} (0=UP/1=DOWN) countervalue=${mCounterValue} startvalue=${mStartValue} stopvalue=${mStopValue}"$)

	' Timer stop value reached (=finished)
	If (mMode == TIMER_MODE_COUNTDOWN And mCounterValue <= mStopValue) Or _
   	   (mMode == TIMER_MODE_COUNTUP And mCounterValue >= mStopValue) Then
		HandleTimerState
		If SubExists(mCallBack, mEventName & "_Finished") Then
			CallSubDelayed(mCallBack, mEventName & "_Finished")
		End If
	Else
		UpdateLabelTimer
	End If
End Sub

' Update label timer using the display format.
' If seconds then display unformatted number else datetime format.
Private Sub UpdateLabelTimer
	' Clap if counter > 0
	If mCounterValue < 0 Then mCounterValue = 0
	' Convert counter to time
	Dim t As Long	= mCounterValue * DateTime.TicksPerSecond
	Dim h As Int	= t / DateTime.TicksPerHour
	Dim m As Int	= (t Mod DateTime.TicksPerHour) / DateTime.TicksPerMinute
	Dim s As Int	= (t Mod DateTime.TicksPerMinute) / DateTime.TicksPerSecond
	
	' Set display depending mode
	Select mDisplayFormat
		Case DISPLAY_FORMAT_HHMMSS
			LabelTimer.Text = $"${NumberFormat2(h, 2, 0, 0, False)}:${NumberFormat2(m, 2, 0, 0, False)}:${NumberFormat2(s, 2, 0, 0, False)}"$
		Case DISPLAY_FORMAT_HHMM
			LabelTimer.Text = $"${NumberFormat2(h, 2, 0, 0, False)}:${NumberFormat2(m, 2, 0, 0, False)}"$
		Case DISPLAY_FORMAT_SECONDS
			LabelTimer.Text = $"${mCounterValue}"$
	End Select
End Sub
#End Region

Private Sub HandleTimerState
	Select mState
		Case TIMER_STOP
			' Set state to start
			mCounterValue = IIf(mMode == TIMER_MODE_COUNTDOWN, mStartValue, 0)
			mTimer.Enabled = True
			LabelStatus.Text = TIMER_STATE_STOP
			mState = TIMER_START
			If SubExists(mCallBack, mEventName & "_Start") Then
				CallSubDelayed(mCallBack, mEventName & "_Start")
			End If

		Case TIMER_START
			' Set state to stop
			mTimer.Enabled = False
			mCounterValue = IIf(mMode == TIMER_MODE_COUNTDOWN, 0, mStopValue)
			LabelStatus.Text = TIMER_STATE_START
			mState = TIMER_STOP
			If SubExists(mCallBack, mEventName & "_Stop") Then
				CallSubDelayed(mCallBack, mEventName & "_Stop")
			End If

		Case TIMER_RESET
			mCounterValue = 0
			LabelStatus.Text = TIMER_STATE_RESET
	End Select
	UpdateLabelTimer
	' Log($"[HandleTimerState] state=${mState} (0=stop, 1=start)"$)
End Sub

' ================================================================
' EVENTS
' ================================================================
#Region Events
' Start / Stop events are handled in HandleTimerState.

#if B4J
Private Sub LabelTitle_MouseClicked (EventData As MouseEvent)
	HandleTimerState
End Sub

Private Sub LabelTimer_MouseClicked (EventData As MouseEvent)
	HandleTimerState
End Sub

Private Sub LabelStatus_MouseClicked (EventData As MouseEvent)
	HandleTimerState
End Sub
#End If

Private Sub LabelTitle_Click
	HandleTimerState
End Sub

Private Sub LabelTimer_Click
	HandleTimerState
End Sub

Private Sub LabelStatus_Click
	HandleTimerState
End Sub
#End Region
