B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileClock.bas
' Brief:    	CustomView HMITile showing an analog clock drawn on a B4XCanvas.
' Date:			2025-12-17
' Author:		Robert W.B. Linn (c) 2025 MIT
' Hints:    	HMITile cannot be resized after form loaded.
' ================================================================
#End Region

#Event: Click(EventData As MouseEvent)

#DesignerProperty: Key: ShowSeconds, DisplayName: Show Seconds, FieldType: Boolean, DefaultValue: False

Sub Class_Globals
	Dim COLOR_HOUR_HAND As Int 		= 0xFFFFFFFF
	Dim COLOR_MINUTES_HAND As Int 	= 0xFFFFFFFF
	Dim COLOR_SECONDS_HAND As Int	= 0xFFFF0000

	Private mEventName As String
	Private mCallBack As Object

	Public mBase As B4XView
	Private xui As XUI
	Public Tag As Object

	Private PaneClock As B4XView
	Private CanvasClock As B4XCanvas

	' Clock options
	Private mShowSeconds As Boolean
	
	' Timer
	Private mClockTimer As Timer
	Private mLastSec As Int = -1
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mCallBack = Callback
	mEventName = EventName
End Sub

Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	Tag = mBase.Tag
	mBase.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitileclock")

	' Store designer properties
	mShowSeconds 	= Props.Get("ShowSeconds")

	CanvasClock.Initialize(PaneClock)
	ApplyStyle

	Base_Resize(mBase.Width, mBase.Height)

	mClockTimer.Initialize("ClockTimer", 1000)   ' 1000 ms = 1 second
	mClockTimer.Enabled = True
End Sub

Private Sub ClockTimer_Tick
    Dim now As Long = DateTime.Now
    Dim sec As Int = DateTime.GetSecond(now)
    If sec = mLastSec Then Return    ' avoid double redraw
    mLastSec = sec
	UpdateTime(DateTime.Now)
End Sub

' ApplyStyle
' Apply style Normal.
Private Sub ApplyStyle
	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	If Not(PaneClock.IsInitialized) Then Return
	
	PaneClock.SetLayoutAnimated(0, _ 
								HMITileUtils.BORDER_WIDTH, _
								HMITileUtils.BORDER_WIDTH, _
        						Width - HMITileUtils.BORDER_WIDTH * 2, _ 
								Height - HMITileUtils.BORDER_WIDTH * 2)
	CanvasClock.Resize(PaneClock.Width, PaneClock.Height)
	UpdateTime(DateTime.Now)
End Sub

' =========================
' Public clock interface
' =========================
Public Sub setShowSeconds(b As Boolean)
	mShowSeconds = b
	UpdateTime(DateTime.Now)
End Sub
Public Sub getShowSeconds As Boolean
	Return mShowSeconds
End Sub

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	HMITileUtils.SetAlpha(mBase.enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

Public Sub StartClock
	mClockTimer.Enabled = True
End Sub
Public Sub StopClock
	mClockTimer.Enabled = False
End Sub

Public Sub UpdateTime(T As Long)
	' If CanvasClock.IsInitialized = False Then Return

	CanvasClock.ClearRect(CanvasClock.TargetRect)

	Dim cx As Float = PaneClock.Width / 2
	Dim cy As Float = PaneClock.Height / 2
	Dim r As Float = Min(cx, cy) * 0.80

	DrawClockFace(cx, cy, r)
	DrawHands(cx, cy, r, T)

	CanvasClock.Invalidate
End Sub

' =========================
' Drawing methods
' =========================

Private Sub DrawClockFace(cx As Float, cy As Float, r As Float)
	' Outter circle
	CanvasClock.DrawCircle(cx, cy, r, HMITileUtils.COLOR_TEXT_SECONDARY, False, 3dip)

	For i = 0 To 59
		Dim angle As Double = (i / 60) * 360
		Dim rad As Double = (angle - 90) * cPI / 180

		Dim innerR As Float = IIf(i Mod 5 = 0, r * 0.85, r * 0.92)
		Dim outerR As Float = r

		Dim x1 As Double = cx + Cos(rad) * innerR
		Dim y1 As Double  = cy + Sin(rad) * innerR
		Dim x2 As Double  = cx + Cos(rad) * outerR
		Dim y2 As Double  = cy + Sin(rad) * outerR

		Dim stroke As Int = IIf(i Mod 5 = 0, 3dip, 1dip)
		CanvasClock.DrawLine(x1, y1, x2, y2, HMITileUtils.COLOR_TEXT_SECONDARY, stroke)
	Next
End Sub

Private Sub DrawHands(cx As Float, cy As Float, r As Float, T As Long)
	Dim h As Int = DateTime.GetHour(T)
	Dim m As Int = DateTime.GetMinute(T)
	Dim s As Int = DateTime.GetSecond(T)

	' Hour hand
	Dim hourAngle As Double = (h Mod 12 + m / 60) * 30
	DrawHand(cx, cy, r * 0.55, hourAngle, 4dip, COLOR_HOUR_HAND)

	' Minute hand
	Dim minAngle As Double = (m + s / 60) * 6
	DrawHand(cx, cy, r * 0.75, minAngle, 3dip, COLOR_MINUTES_HAND)

	' Second hand
	If mShowSeconds Then
		Dim secAngle As Double = s * 6
		DrawHand(cx, cy, r * 0.80, secAngle, 2dip, COLOR_SECONDS_HAND)
	End If
End Sub

Private Sub DrawHand(cx As Float, cy As Float, length As Float, angleDeg As Double, stroke As Float, color As Int)
	Dim rad As Double = (angleDeg - 90) * cPI / 180
	Dim x2  As Double = cx + Cos(rad) * length
	Dim y2  As Double = cy + Sin(rad) * length
	CanvasClock.DrawLine(cx, cy, x2, y2, color, stroke)
End Sub

#if B4J
Private Sub PaneClock_MouseClicked (EventData As MouseEvent)
	PaneClock_Click
End Sub
#End If

' ================================================================
' B4X - use click only
' ================================================================

Private Sub PaneClock_Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSub(mCallBack, mEventName & "_Click")
	End If
End Sub

