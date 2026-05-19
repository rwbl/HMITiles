B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileDigitalClock.bas
' Brief:    	Customview digital clock HMITile (HH:MM or HH:MM:SS)
' Description:	Based on the HMITileLabel, but with label update via timer every second.
' Date:			2026-04-24
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: ShowSeconds, DisplayName: Show Seconds, FieldType: Boolean, DefaultValue: False
#DesignerProperty: Key: BlinkColon, DisplayName: Blink Colon, FieldType: Boolean, DefaultValue: False

' Events
#Event: Click

Private Sub Class_Globals
	Private xui As XUI

	Public BasePane As B4XView
	Private BaseLabel As B4XView				'ignore
	Public Tag As Object

	Private mEventName As String
	Private mCallBack As Object

	Private LabelText As B4XView

	' Properties Designer
	Private mShowSeconds As Boolean
	Private mBlinkColon As Boolean

	' Properties Class
	Private mClockTimer As Timer
	Private mClockBlink As Boolean
	Private mCurrentTime As Long
End Sub

Private Sub Initialize(Callback As Object, EventName As String)	'ignore
	mEventName = EventName
	mCallBack = Callback
	mClockTimer.Initialize("TimerClock", 1000)
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
	BasePane.LoadLayout("hmitilelabel")

	LabelText.Text = ""
	
	' Get the designer properties
	mShowSeconds	= Props.Get("ShowSeconds")
	mBlinkColon		= Props.Get("BlinkColon")

	' Resize to get the sizing right
	Base_Resize(BasePane.Width, BasePane.Height)
	ApplyStatusStyle
	
	StartClock
End Sub

Public Sub Base_Resize (Width As Double, Height As Double)
	If Not(LabelText.IsInitialized) Then Return
	'							 d  l  t  w      h
	LabelText.SetLayoutAnimated	(0, 0, 0, Width, Height)
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
' Start the clock.
Public Sub StartClock
	mClockTimer.Enabled = True
End Sub

' Stop the clock.
Public Sub StopClock
	mClockTimer.Enabled = False
End Sub

' Get or set show seconds option.
Public Sub setShowSeconds(state As Boolean)
	mShowSeconds = state
End Sub
Public Sub getShowSeconds As Boolean
	Return mShowSeconds
End Sub

' Get or set the colon blinking every second.
Public Sub setBlinkColon(state As Boolean)
	mBlinkColon = state
End Sub
Public Sub getBlinkColon As Boolean
	Return mBlinkColon
End Sub

' Get the current time as ticks
Public Sub CurrentTime As Long
	Return mCurrentTime
End Sub

' Get or set the clock enabled
Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	HMITileUtils.SetAlpha(BasePane.enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub
#End Region

' ================================================================
' TILE STATUSSTYLE
' ================================================================

#Region StatusStyle
' ApplyStatusStyle
' Apply status style to Normal.
Private Sub ApplyStatusStyle
	HMITileUtils.ApplyValueStyle(LabelText)
	
	BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

#Region Clock
Private Sub TimerClock_Tick
	UpdateClock
End Sub

Private Sub UpdateClock
	Dim now As Long = DateTime.Now
	mCurrentTime = now
	Dim h As Int = DateTime.GetHour(now)
	Dim m As Int = DateTime.GetMinute(now)
	Dim s As Int = DateTime.GetSecond(now)

	Dim colon As String = ":"
	If mBlinkColon Then
		If mClockBlink = False Then colon = " "
		mClockBlink = Not(mClockBlink)
	End If

	Dim txt As String
	If mShowSeconds Then
		txt = NumberFormat2(h, 2, 0, 0, False) & colon & NumberFormat2(m, 2, 0, 0, False) & colon & NumberFormat2(s, 2, 0, 0, False)
	Else
		txt = NumberFormat2(h, 2, 0, 0, False) & colon & NumberFormat2(m, 2, 0, 0, False)
	End If

	' BaseLabel.Text = txt
	LabelText.Text = txt
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
#if B4J
Private Sub LabelText_MouseClicked (EventData As MouseEvent)
	LabelText_Click
End Sub
#End If

Private Sub LabelText_Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region

