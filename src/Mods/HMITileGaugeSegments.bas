B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileGaugeSegments.bas
' Brief:		CustomView HMITile with a gauge having warning & alarm segments.
' Date:			2026-05-16
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	HMITileGauge is intentionally limited to a fixed 180° arc to ensure visual consistency, predictable behavior, and
'				low operator cognitive load.
'				A gauge is defined by three independent things:
'				- Start angle → where the gauge begins
'				- Span (total sweep) → how wide the gauge Is
'				- Value fraction → how much of that span Is filled
'				Style can be set to Normal, Warning, Alarm.
' Layout:
'				+------------------+
'				|       Title      |  < 25%
'				|       Gauge      |  < 50% 
'				| 	    Value      |  < 25%
'				|       Unit       |  < 15% 
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,				DisplayName: Title,				FieldType: String, 	DefaultValue: Gauge
#DesignerProperty: Key: Value, 				DisplayName: Value,				FieldType: Float, 	DefaultValue: 0
#DesignerProperty: Key: Min, 				DisplayName: Min,				FieldType: Float, 	DefaultValue: 0
#DesignerProperty: Key: Max, 				DisplayName: Max,				FieldType: Float, 	DefaultValue: 100
#DesignerProperty: Key: WarningThreshold,	DisplayName: Warning Threshold,	FieldType: Float,	DefaultValue: 60
#DesignerProperty: Key: AlarmThreshold,		DisplayName: Alarm Threshold,	FieldType: Float,	DefaultValue: 85
#DesignerProperty: Key: Unit,  				DisplayName: Unit,				FieldType: String, 	DefaultValue: 
#DesignerProperty: Key: Digits, 			DisplayName: Digits,			FieldType: Int, 	DefaultValue: 0
#DesignerProperty: Key: ShowNeedle, 		DisplayName: Needle,			FieldType: Boolean, DefaultValue: False
#DesignerProperty: Key: ShowRangeLabels,	DisplayName: Range Labels,		FieldType: Boolean, DefaultValue: False
#DesignerProperty: Key: Status, 			DisplayName: Status,			FieldType: String,	List: Normal|Warning|Alarm, DefaultValue: Normal

' Events
#Event: Click (Value As Float)

Private Sub Class_Globals
	' Events
	Private mEventName As String			'ignore
	Private mCallBack As Object				'ignore

	' Base
	Public BasePane As B4XView
	Private BaseLabel As B4XView			'ignore
	Public Tag As Object

	' UI
	Private xui As XUI
	Private PaneGauge As B4XView
	Private CvsGauge As B4XCanvas

	' Views
	Private LabelTitle As B4XView
	Private LabelValue As B4XView
	Private LabelUnit As B4XView

	' Designer Properties
	Private mTitle As String
	Private mValue As Float
	Private mUnit As String
	Private mMin As Float
	Private mMax As Float
	Private mWarningThreshold As Float
	Private mAlarmThreshold As Float
	Private mDigits As Int
	Private mShowNeedle As Boolean
	Private mShowRangeLabels As Boolean
	Private mStatus As String

	' Class Properties
	Private mCx, mCy As Float
	Private mRadius As Float
	Private mMaskColor As Int
	Private mCanvasIndicator As B4XCanvas
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Private  Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilegaugesegments")

	' Class
	mCanvasIndicator.Initialize(BasePane)

	' Properties Designer
	mTitle				= Props.Get("Title")
	LabelTitle.Text 	= mTitle
	mValue				= Props.Get("Value")
	LabelValue.Text 	= mValue
	mMin				= Props.GetDefault("Min", 0)
	mMax				= Props.GetDefault("Max", 100)
	mWarningThreshold	= Props.GetDefault("WarningThreshold", 60)	' Yellow zone starts at 60%
	mAlarmThreshold		= Props.GetDefault("AlarmThreshold", 85)	' Red zone starts at 85%
	mUnit				= Props.Get("Unit")
	LabelUnit.Text 		= mUnit
	mDigits				= Props.GetDefault("Digits", 0)
	mShowNeedle			= Props.GetDefault("ShowNeedle", False)
	mShowRangeLabels	= Props.GetDefault("ShowRangeLabels", False)
	mStatus				= Props.Get("Status")
	
	' First resize
	Base_Resize(BasePane.Width, BasePane.Height)

	' Then apply style because the gauge inner circle must be masked based on style
	ApplyStyle
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return
	
	'								 d  l    t    			w       h
	LabelTitle.SetLayoutAnimated	(0, 0, 0,				Width, 	Height * 0.25)
	PaneGauge.SetLayoutAnimated		(0, 0, Height * 0.25, 	Width, 	Height * 0.50)
	LabelValue.SetLayoutAnimated	(0, 0, Height * 0.55, 	Width, 	Height * 0.35)
	LabelUnit.SetLayoutAnimated		(0, 0, Height * 0.80,	Width,	Height * 0.15)

	' Set gauge properties
	mCx 	= PaneGauge.Width / 2
	mCy 	= PaneGauge.Height * 0.5
	mRadius	= Min(mCx, mCy) * 0.9	

	' Rebind canvas to PaneGauge
	CvsGauge.Initialize(PaneGauge)
End Sub

' ===================================================================
' HELPER
' ===================================================================

' ReDraw
' ReDraw the gauge to apply state color.
Private Sub Redraw
	If PaneGauge.IsInitialized Then
		DrawGauge(mValue)
	End If
End Sub

' ===================================================================
' Public API
' ===================================================================

' DrawGauge
' Draws a filled arc gauge with permanent multi-segment color bands.
' Draw order: full background track -> conditional color segments -> center mask -> labels & needle
' Parameters:
'   value    - current process value
Public Sub DrawGauge(value As Float)

	Dim startAngle As Float = 180	' Always start at 09:00
	Dim totalSweep As Float = 180	' Max span from 09:00 to 03:00
	Dim gaugeWidth As Int = 14dip
	Dim filled As Boolean = True

	' Clamp value
	value = Max(mMin, Min(mMax, value))

	' Clear canvas
	CvsGauge.ClearRect(CvsGauge.TargetRect)

	' Calculate scale factors
	Dim AnglePerUnit As Float = totalSweep / (mMax - mMin)

	' Color Definitions (Bright active colors)
	Dim ColorNormalActive As Int	= HMITileUtils.COLOR_INDICATOR_LEVEL	' COLOR_SLIDER_ACTIVE
	Dim ColorWarningActive As Int	= HMITileUtils.COLOR_GAUGESEGMENTS_WARNING_ACTIVE
	Dim ColorAlarmActive As Int		= HMITileUtils.COLOR_GAUGESEGMENTS_ALARM_ACTIVE

	' Muted Background Colors (Using Alpha/Transparency for the permanent background zones)
	Dim ColorNormalMuted As Int 	= HMITileUtils.COLOR_INDICATOR_TRACK	' COLOR_SLIDER_TRACK	
	Dim ColorWarningMuted As Int 	= HMITileUtils.COLOR_GAUGESEGMENTS_WARNING_MUTED
	Dim ColorAlarmMuted As Int 		= HMITileUtils.COLOR_GAUGESEGMENTS_ALARM_MUTED

	' ------------------------------------------------
	' PHASE 1: Draw the Permanent Background Track Zones
	' ------------------------------------------------
	Dim BgCursor As Float = startAngle

	' 1. Normal track background
	Dim SweepBgNormal As Float = (mWarningThreshold - mMin) * AnglePerUnit
	Dim ArcBgNormal As B4XPath
	ArcBgNormal.InitializeArc(mCx, mCy, mRadius, BgCursor, SweepBgNormal)
	CvsGauge.DrawPath(ArcBgNormal, ColorNormalMuted, filled, 0)
	BgCursor = BgCursor + SweepBgNormal

	' 2. Warning track background
	Dim SweepBgWarning As Float = (mAlarmThreshold - mWarningThreshold) * AnglePerUnit
	Dim ArcBgWarning As B4XPath
	ArcBgWarning.InitializeArc(mCx, mCy, mRadius, BgCursor, SweepBgWarning)
	CvsGauge.DrawPath(ArcBgWarning, ColorWarningMuted, filled, 0)
	BgCursor = BgCursor + SweepBgWarning

	' 3. Critical track background
	Dim SweepBgCritical As Float = (mMax - mAlarmThreshold) * AnglePerUnit
	Dim ArcBgCritical As B4XPath
	ArcBgCritical.InitializeArc(mCx, mCy, mRadius, BgCursor, SweepBgCritical)
	CvsGauge.DrawPath(ArcBgCritical, ColorAlarmMuted, filled, 0)

	' ------------------------------------------------
	' PHASE 2: Draw the Active Value Fills Over the Background
	' ------------------------------------------------
	Dim ActiveCursor As Float = startAngle

	' --- SEGMENT 1: Active Normal Fill ---
	Dim NormalMax As Float = Min(value, mWarningThreshold)
	If NormalMax > mMin Then
		Dim SweepNormal As Float = (NormalMax - mMin) * AnglePerUnit
		Dim ArcNormal As B4XPath
		ArcNormal.InitializeArc(mCx, mCy, mRadius, ActiveCursor, SweepNormal)
		CvsGauge.DrawPath(ArcNormal, ColorNormalActive, filled, 0)
		ActiveCursor = ActiveCursor + SweepNormal
		StatusNormal
	End If

	' --- SEGMENT 2: Active Warning Fill ---
	If value > mWarningThreshold Then
		Dim WarningMax As Float = Min(value, mAlarmThreshold)
		Dim SweepWarning As Float = (WarningMax - mWarningThreshold) * AnglePerUnit
		Dim ArcWarning As B4XPath
		ArcWarning.InitializeArc(mCx, mCy, mRadius, ActiveCursor, SweepWarning)
		CvsGauge.DrawPath(ArcWarning, ColorWarningActive, filled, 0)
		ActiveCursor = ActiveCursor + SweepWarning
		StatusWarning
	End If

	' --- SEGMENT 3: Active Alarm Fill ---
	If value > mAlarmThreshold Then
		Dim CriticalMax As Float = Min(value, mMax)
		Dim SweepCritical As Float = (CriticalMax - mAlarmThreshold) * AnglePerUnit
		Dim ArcCritical As B4XPath
		ArcCritical.InitializeArc(mCx, mCy, mRadius, ActiveCursor, SweepCritical)
		CvsGauge.DrawPath(ArcCritical, ColorAlarmActive, filled, 0)
		StatusAlarm
	End If

	' ------------------------------------------------
	' PHASE 3: Masking & Overlays
	' ------------------------------------------------
	' Inner mask cutout to keep the donut ring layout perfectly crisp
	CvsGauge.DrawCircle(mCx, mCy, mRadius - gaugeWidth, mMaskColor, True, 0)

	' ------------------------------------------------
	' Range Labels (Min/Max)
	' ------------------------------------------------
	If mShowRangeLabels Then
		Dim LabelFont As B4XFont	= xui.CreateDefaultFont(9)
		Dim LabelColor As Int 		= HMITileUtils.COLOR_TEXT_INFO
		Dim YOffset As Int 			= 12dip
		
		Dim MinStr As String = NumberFormat(mMin, 1, 1)
		Dim MaxStr As String = NumberFormat(mMax, 1, 1)
	
		CvsGauge.DrawText(MinStr, mCx - mRadius + (gaugeWidth / 2), mCy + YOffset, LabelFont, LabelColor, "CENTER")
		CvsGauge.DrawText(MaxStr, mCx + mRadius - (gaugeWidth / 2), mCy + YOffset, LabelFont, LabelColor, "CENTER")
	End If

	' ------------------------------------------------
	' Needle Logic (Locked to Solid White)
	' ------------------------------------------------
	If mShowNeedle Then
		Dim sweepLength As Float = totalSweep * (value - mMin) / (mMax - mMin)
		Dim needleAngleDeg As Float = startAngle + sweepLength
	
		Dim PI As Float = ACos(-1)
		Dim needleAngleRad As Float = needleAngleDeg * PI / 180
	
		Dim needleLength As Float = mRadius + 2dip
	
		Dim nX2 As Float = mCx + (needleLength * Cos(needleAngleRad))
		Dim nY2 As Float = mCy + (needleLength * Sin(needleAngleRad))
	
		' Render pure white pointer line
		CvsGauge.DrawLine(mCx, mCy, nX2, nY2, xui.Color_White, 3dip)
	End If

	' Commit layouts to screen
	CvsGauge.Invalidate
End Sub

Public Sub setTitle(title As String)
	LabelTitle.Text = title
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub setValue(value As Float)
	If PaneGauge.IsInitialized Then
		mValue = value
		Redraw
		LabelValue.Text = NumberFormat2(mValue, 0, mDigits, 0, False)
	End If
End Sub
Public Sub getValue As Float
	Return mValue
End Sub

Public Sub setMin(value As Float)
	mMin = value
	Redraw
End Sub
Public Sub getMin As Float
	Return mMin
End Sub

Public Sub setMax(value As Float)
	mMax = value
	Redraw
End Sub
Public Sub getMax As Float
	Return mMax
End Sub

Public Sub setWarningThreshold(value As Float)
	mWarningThreshold = value
	Redraw
End Sub
Public Sub getWarningThreshold As Float
	Return mWarningThreshold
End Sub

Public Sub setAlarmThreshold(value As Float)
	mAlarmThreshold = value
	Redraw
End Sub
Public Sub getAlarmThreshold As Float
	Return mAlarmThreshold
End Sub

Public Sub setUnit(unit As String)
	mUnit = unit
	LabelUnit.Text = mUnit
End Sub
Public Sub getUnit As String
	Return mUnit
End Sub

Public Sub setShowNeedle(value As Boolean)
	mShowNeedle = value
	Redraw
End Sub
Public Sub getShowNeedle As Boolean
	Return mShowNeedle
End Sub

Public Sub setShowRangeLabels(value As Boolean)
	mShowRangeLabels = value
	Redraw
End Sub
Public Sub getShowRangeLabels As Boolean
	Return mShowRangeLabels
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

' ================================================================
' TILESTYLE
' ================================================================

#Region TileStyle
Private Sub ApplyStyle
	HMITileUtils.ApplyTileStyle(BasePane)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelValue)
	HMITileUtils.ApplyUnitStyle(LabelUnit)
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
	' Redraw the gauge to apply the state color
	mMaskColor = BasePane.Color
	Redraw
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================

#Region Events
#If B4J
Private Sub PaneGauge_MouseClicked (EventData As MouseEvent)
	Click
End Sub
#End If

#if B4A
Private Sub PaneGauge_Click
	Click	
End Sub
#End If

Private Sub Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSub2(mCallBack, mEventName & "_Click", mValue)
	End If
End Sub
#End Region


