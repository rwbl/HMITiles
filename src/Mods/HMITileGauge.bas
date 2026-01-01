B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileGauge.bas
' Brief:		CustomView HMITile with a gauge.
' Description:	HMITileGauge is intentionally limited to a fixed 180° arc to ensure visual consistency, predictable behavior, and
'				low operator cognitive load.
'				A gauge is defined by three independent things:
'				- Start angle → where the gauge begins
'				- Span (total sweep) → how wide the gauge Is
'				- Value fraction → how much of that span Is filled
'				Style can be set to Normal, Warning, Alarm or Dimmed.
' Date:			2025-12-25
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|       Title      |  	<< 25%
'				|       Gauge      |	<< 50% 
'				|                  |  
'				| 	   Value Unit  |	<< 25%
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,		DisplayName: Title, FieldType: String, DefaultValue: Level
#DesignerProperty: Key: Value, 		DisplayName: Value, FieldType: Float, DefaultValue: 0
#DesignerProperty: Key: Min, 		DisplayName: Min, FieldType: Float, DefaultValue: 0
#DesignerProperty: Key: Max, 		DisplayName: Max, FieldType: Float, DefaultValue: 100
#DesignerProperty: Key: Unit,  		DisplayName: Unit,  FieldType: String, DefaultValue: 
#DesignerProperty: Key: Digits, 	DisplayName: Digits, FieldType: Int, DefaultValue: 0
#DesignerProperty: Key: TypeStyle, 	DisplayName: Tile Style, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click (Value As Float)

Private Sub Class_Globals
	' Events
	Private mEventName As String			'ignore
	Private mCallBack As Object				'ignore

	' Base
	Public mBase As B4XView
	Private mLbl As B4XView					'ignore
	Public Tag As Object

	' UI
	Private xui As XUI
	Private PaneGauge As B4XView
	Private CvsGauge As B4XCanvas

	' Views
	Private LabelTitle As B4XView
	Private LabelValue As B4XView

	' Designer values
	Private mValue As Float
	Private mDigits As Int
	Private mMin As Float
	Private mMax As Float
	Private mUnitText As String
	Private mTypeStyle As String
	
	' Gauge
	Private Cx, Cy As Float
	Private Radius As Float
	Private MaskColor As Int
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Private  Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)	'ignore
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitilegauge")

	' Store designer properties
	LabelTitle.Text = Props.Get("Title")
	mValue			= Props.Get("Value")
	mMin			= Props.GetDefault("Min", 0)
	mMax			= Props.GetDefault("Max", 100)
	mUnitText		= Props.Get("Unit")
	mDigits			= Props.GetDefault("Digits", 0)
	mTypeStyle		= Props.Get("TypeStyle")
	
	' First resize
	Base_Resize(mBase.Width, mBase.Height)
	' Then apply style because the gauge inner circle must be masked based on style (normal,warning,alarm,disabled)
	ApplyStyle(mTypeStyle)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	LabelTitle.SetLayoutAnimated(0, pad, pad, Width - pad * 2, Height * 0.25)

	PaneGauge.SetLayoutAnimated(0, pad, Height * 0.25, Width - pad * 2, Height * 0.5)
	Cx 			= PaneGauge.Width / 2
	Cy 			= PaneGauge.Height * 0.9
	Radius		= Min(Cx, Cy) * 0.8

	' Rebind canvas to PaneGauge
	CvsGauge.Initialize(PaneGauge)
				
	LabelValue.SetLayoutAnimated(0, pad, (Height*0.75) - pad, Width - pad * 2, Height * 0.25)

	setValue(mValue)
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
' Draws a filled arc gauge.
' Draw the gauge: arc full filled > arc value fulled > mask with half circle.
' The gauge always spans 180°, draw a fraction of that span.
' Parameters:
'   value    - current process value
Public Sub DrawGauge(value As Float)

	Dim startAngle As Float = 180	' Always start at 09:00
	Dim totalSweep As Float = 180	' Max span from 09:00 to 03:00
	Dim sweepLength As Float		' How many degrees to draw from the starting point
	Dim gaugeWidth As Int = 14dip
	Dim filled As Boolean = True

	' Clamp value
	value = Max(mMin, Min(mMax, value))

	' Clear canvas
	CvsGauge.ClearRect(CvsGauge.TargetRect)

	' ------------------------------------------------
	' Background track
	' ------------------------------------------------
	' Draw full arc (filled) starting at clock 0900 (angle 180) to clock 0300 (sweep 180)
	Dim track As B4XPath
	track.InitializeArc(Cx, Cy, Radius, startAngle, totalSweep)
	CvsGauge.DrawPath(track, HMITileUtils.COLOR_SLIDER_TRACK, filled, 0)

	' ------------------------------------------------
	' Active value arc
	' ------------------------------------------------
	' Draw value arc (filled) value starting at clock 0900 (angle 180) to clock NNNN (sweep calulated from valie,min,max)
	sweepLength = totalSweep * (value - mMin) / (mMax - mMin)
	Dim valueArc As B4XPath
	valueArc.InitializeArc(Cx, Cy, Radius, startAngle, sweepLength)
	CvsGauge.DrawPath(valueArc, HMITileUtils.COLOR_SLIDER_ACTIVE, filled, 0)

	' ------------------------------------------------
	' Inner mask
	' ------------------------------------------------
	Dim maskArc As B4XPath
	maskArc.InitializeArc(Cx, Cy, Radius - gaugeWidth, startAngle, totalSweep)
	CvsGauge.DrawPath(maskArc, MaskColor, filled, 0)

'	' Draw a half circle (filled) to hide the arc path = masking
'	CvsGauge.DrawCircle(Cx, Cy, Radius - gaugeWidth, xui.color_blue, filled, 0)
'	'CvsGauge.DrawCircle(Cx, Cy, Radius - gaugeWidth, MaskColor, Not(filled), 0)

	' Commit the drawings
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
		LabelValue.Text = $"${NumberFormat(mValue, 1, mDigits)}${IIf(mUnitText.Length > 0, $" ${mUnitText}"$, "")}"$		
	End If
End Sub
Public Sub getValue As Float
	Return mValue
End Sub

Public Sub setUnit(unit As String)
	mUnitText = unit
	LabelValue.Text = $"${mValue}${IIf(mUnitText.Length > 0, $" ${mUnitText}"$, "")}"$
End Sub
Public Sub getUnit As String
	Return LabelValue.Text
End Sub

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

Public Sub SetStyleNormal
	setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)
End Sub

Public Sub SetStyleWarning
	setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)
End Sub

Public Sub SetStyleAlarm
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
' TILE STYLING
' ================================================================
#Region Styling
' ApplyStyle
' Apply one of the 4 styles Normal, Warning, Alarm, Disabled
' Parameters:
'	tilestate String - Use HMITileUtils constants STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
Public Sub ApplyStyle(tilestate As String)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelValue)

	Dim state As Int = HMITileUtils.StateStyleToState(tilestate)
	Select state
		Case HMITileUtils.STATE_NORMAL
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

		Case HMITileUtils.STATE_WARNING
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATE_ALARM
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATE_DISABLED
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND		
	End Select

	' Set the tile base color
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)

	' Redraw the gauge to apply the state color
	MaskColor = mBase.Color
	Redraw
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
'Private Sub Click
'	If SubExists(mCallBack, mEventName & "_Click") Then
'		CallSub2(mCallBack, mEventName & "_Click", mValue)
'	End If
'End Sub
#End Region
