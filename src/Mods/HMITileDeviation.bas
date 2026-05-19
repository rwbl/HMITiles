B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileDeviation.bas
' Brief:		CustomView bidirectional bar showing deviation from a reference.
' Date:			2026-05-17
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	Centered at 0%; Range: -100 … +100
'				Range (Absolute %)	State		Visual Representation (HMI Best Practice)
'				0 – 5%				Deadband	Bar small/invisible or at a fixed "home" color. No action needed.
'				5 – 20%				Normal		Bar visible but stays Neutral Dark Grey. Everything Is within tolerance.
'				20 – 40%			Warning		Bar turns Yellow. Something Is drifting; needs attention soon.
'				40% +				Alarm		Bar turns Red. Critical deviation; requires immediate action.
' 				Unit Side-Alignment because
'				- Maintains Spatial Association: 
'					The target label (0 Unit) is positioned directly next to the black horizontal baseline of the deviation axis. 
'					This clear alignment allows the operator's eye to immediately tie the text definition to the physical center target point. 
'					Stacking it vertically at the bottom would sever that instant physical association.
'				- Separates Process Value from System Target: 
'					On this tile, the large number at the bottom (31) represents the current raw process variable, while the text near the center bar represents 
'					the fixed reference target. Keeping them separate means the operator will never accidentally confuse the target with the active data.
'				- Preserves Crucial Vertical Bar Real Estate: 
'					A vertical deviation indicator needs As much vertical height As possible To clearly animate up-And-down movement. 
'					Moving text To the bottom would compress the vertical space available For the bar graph itself.
' Layout:
'				+------------------+
'				|       Title      |	< 25%
'				|       BAR +      |  	< #
'				|       --- 0 Unit |  	< 50%
'				|       BAR -      |  	< #
'				| 	   Value       |	< 25%
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,         	DisplayName: Title,         	FieldType: String, 	DefaultValue: Title
#DesignerProperty: Key: Value,         	DisplayName: Value,         	FieldType: Float,   DefaultValue: 0
#DesignerProperty: Key: Digits, 		DisplayName: Digits, 			FieldType: Int, 	DefaultValue: 0
#DesignerProperty: Key: Unit,			DisplayName: Unit,         		FieldType: String,	DefaultValue:
#DesignerProperty: Key: Deadband,      	DisplayName: Deadband (+/-),	FieldType: Float,   DefaultValue: 5.0,  		Description: Deadband zone around 0%. Neutral (Normal) zone is between deadband and warning level.
#DesignerProperty: Key: WarningLevel,  	DisplayName: Warning Level, 	FieldType: Float,   DefaultValue: 20.0, 		Description: Deviation where warning starts.
#DesignerProperty: Key: AlarmLevel,    	DisplayName: Alarm Level,   	FieldType: Float,	DefaultValue: 40.0, 		Description: Deviation where alarm starts.
#DesignerProperty: Key: MaxScale,       DisplayName: Max Scale,        	FieldType: Float,   DefaultValue: 100.0,		Description: Max scale.
#DesignerProperty: Key: DevColDeadband, DisplayName: Color Deadband,	FieldType: Color,   DefaultValue: 0xFF555555,	Description: Deviation color deadband.
#DesignerProperty: Key: DevColNeutral, 	DisplayName: Color Neutral,		FieldType: Color,   DefaultValue: 0xFFB0B0B0,	Description: Deviation color neutral.
#DesignerProperty: Key: DevColWarning,	DisplayName: Color Warning,		FieldType: Color,   DefaultValue: 0xFFFFD700, 	Description: Deviation color warning.
#DesignerProperty: Key: DevColAlarm,    DisplayName: Color Alarm,		FieldType: Color,   DefaultValue: 0xFFFF0000, 	Description: Deviation color alarm.

' Events
#Event: Click (Value As Float, Status As String)

Private Sub Class_Globals
	Private mEventName As String
	Private mCallBack As Object

	Public BasePane As B4XView
	Public BaseLabel As B4XView

	Private xui As XUI
	Public Tag As Object

	' Views
	Private LabelTitle As B4XView
	Private PaneBar As B4XView
	Private CvsBar As B4XCanvas
	Private LabelValue As B4XView

	' Properties Designer
	Private mTitle As String
	Private mValue As Float
	Private mMaxScale As Float
	Private mDigits As Int = 0
	Private mUnit As String
	Private mDeadband As Float
	Private mWarningLevel As Float
	Private mAlarmLevel As Float		'ignore
	Private mDevColDeadband As Int
	Private mDevColNeutral As Int
	Private mDevColWarning As Int
	Private mDevColAlarm As Int

	' Properties Class
	Private mStatus As String

	' Constants
	Private BAR_WIDTH As Int = 20dip
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
	BasePane.LoadLayout("hmitiledeviation")
	
	' Properties Designer
	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mValue			= Props.Get("Value")
	LabelValue.Text = mValue
	mMaxScale		= Props.GetDefault("MaxScale", 100)
	mDigits			= Props.GetDefault("Digits", 0)
	mUnit			= Props.Get("Unit")
	mDeadband		= Props.Get("Deadband")
	mWarningLevel 	= Props.Get("WarningLevel")
	mAlarmLevel 	= Props.Get("AlarmLevel")
	mDevColDeadband	= xui.PaintOrColorToColor(Props.Get("DevColDeadband"))
	mDevColNeutral	= xui.PaintOrColorToColor(Props.Get("DevColNeutral"))
	mDevColWarning	= xui.PaintOrColorToColor(Props.Get("DevColWarning"))
	mDevColAlarm	= xui.PaintOrColorToColor(Props.Get("DevColAlarm"))

	' Prperties Class
	mStatus			= HMITileUtils.STATUS_NORMAL
	
	ApplyStyle
	
	Base_Resize(BasePane.Width, BasePane.Height)

	setValue(mValue)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return

	'								 d, l  t              	w      h
	LabelTitle.SetLayoutAnimated	(0, 0, 0, 				Width, Height * 0.25)
	PaneBar.SetLayoutAnimated		(0, 0, Height * 0.25, 	Width, Height * 0.50)
	LabelValue.SetLayoutAnimated	(0, 0, Height * 0.75,	Width, Height * 0.25)

	' Rebind canvas to PaneBar
	CvsBar.Initialize(PaneBar)
End Sub

Private Sub DrawBar
	' Rect used for the base bar and the deviation bar
	Dim rect As B4XRect

	' Clear canvas
	CvsBar.ClearRect(CvsBar.TargetRect)

	' --- setup ---
	Dim cx 		As Float = CvsBar.TargetRect.CenterX
	Dim cy 		As Float = CvsBar.TargetRect.CenterY

	Dim h 		As Float = BasePane.Height * 0.5   ' leave padding
	Dim w 		As Float = BAR_WIDTH			' bar width
    
	Dim left	As Float = cx - w / 2
	Dim top As Float = cy - h / 2
	' Dim bottom	As Float = cy + h / 2

	' clamp value
	Dim v 		As Float = Max(mMaxScale * -1, Min(mMaxScale, mValue))

	' Subtle dark gray track
	rect.Initialize(left, top, left + w, top + h)
	CvsBar.DrawRect(rect, 0xFF404040, True, 0)

	' Background bar
	rect.Initialize(left, top, left + w, top + h)
	CvsBar.DrawRect(rect, HMITileUtils.COLOR_DEVIATION_BAR, True, 0)

	' Center line (0%)
	' Draw dotted line left from the bar as indicator
	' DrawDottedLineHorizontal(left - 20, left, cy, 2, 4, HMITileUtils.COLOR_SLIDER_TRACK)
	' Draw center line
	CvsBar.DrawLine(left, cy, left + w, cy, xui.color_black, 2)
	' Draw text 0%
	Dim fnt As B4XFont = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_TINY)
	CvsBar.DrawText($"0${IIf(mUnit.Length > 0, $" ${mUnit}"$, "")}"$, left + w + 5dip, cy + (fnt.Size/2), fnt, HMITileUtils.COLOR_TEXT_INFO, "LEFT")
'	#if B4J
'	CvsBar.DrawText($"0${IIf(mUnit.Length > 0, $" ${mUnit}"$, "")}"$, left + w + 5dip, cy + (fnt.Size/2), fnt, HMITileUtils.COLOR_SLIDER_TRACK, "LEFT")
'	#End If
'	#if B4A
'	CvsBar.DrawText($"0${IIf(mUnit.Length > 0, $" ${mUnit}"$, "")}"$, left + w + 5dip, cy + (fnt.Size/2), fnt, HMITileUtils.COLOR_SLIDER_TRACK, "LEFT")
'	#End If

	' Deviation bar filled between maxscale (+/-)
	Dim py As Float = cy - (v / mMaxScale) * (h / 2)
	If v > 0 Then
		' Positive > upwards
		cy = cy - 1
		rect.Initialize(left, py, left + w, cy)
		CvsBar.DrawRect(rect, GetDeviationColor(v), True, 0)
	Else If v < 0 Then
		' Negative > downwards
		cy = cy + 1
		rect.Initialize(left, cy, left + w, py)
		CvsBar.DrawRect(rect, GetDeviationColor(v), True, 0)
	End If

	' Apply changes to the b4xcanvas
	CvsBar.Invalidate
End Sub

' DrawDottedLineHorizontal
' Example: DrawDottedLineHorizontal(left - 20, left, cy, 2, 4, HMITileUtils.COLOR_SLIDER_TRACK)
Private Sub DrawDottedLineHorizontal(x1 As Float, x2 As Float, y As Float, dotSize As Float, gap As Float, clr As Int)	'ignore
	Dim x As Float = x1
	Do While x < x2
		CvsBar.DrawLine(x, y, Min(x + dotSize, x2), y, clr, 1dip)
		x = x + dotSize + gap
	Loop
End Sub

Private Sub GetDeviationColor(value As Float) As Int
	Dim AbsValue As Int = Abs(value)

	If AbsValue <= mDeadband Then
		' Use Neutral color, or perhaps draw a very thin line
		mStatus = HMITileUtils.STATUS_NORMAL
		Return mDevColDeadband
	Else If AbsValue < mWarningLevel Then
		' This is your "Normal" range - still use Neutral color
		mStatus = HMITileUtils.STATUS_NORMAL
		Return mDevColNeutral
	Else If AbsValue < mAlarmLevel Then
		' Warning state
		mStatus = HMITileUtils.STATUS_WARNING
		Return mDevColWarning
	Else
		' Alarm state
		mStatus = HMITileUtils.STATUS_ALARM
		Return mDevColAlarm
	End If
End Sub

' ===================================================================
' Public API
' ===================================================================

' Calculate the deviation from the Set Point (SP) and the Process Value (PV)
' Deviation is "How much of total sensor range is off?" (Standard for HMIs and Gauges).
' Parameters:
'	SP - Set Point (target)
'	PV = Process Value (actual value)
Public Sub CalculateDeviation(SP As Float, PV As Float) As Float
	Return PV - SP
End Sub

' Get or set the title
Public Sub setTitle(title As String)
	LabelTitle.Text = title
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

' Get or set the deviation value and redraw
Public Sub setValue(value As Float)
	If LabelValue.IsInitialized Then
		mValue = value
		DrawBar
		LabelValue.Text = NumberFormat(mValue, 1, mDigits)
		HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
	End If
End Sub
Public Sub getValue As Float
	Return mValue
End Sub

' Get or set the unit and update value label
Public Sub setUnit(unit As String)
	mUnit = unit
	DrawBar
End Sub
Public Sub getUnit As String
	Return LabelValue.Text
End Sub

' Get or set the deviation color deadband
Public Sub setDevColDeadband(value As Int)
	mDevColDeadband = value
	DrawBar
End Sub
Public Sub getDevColDeadband As Int
	Return mDevColDeadband
End Sub

' Get or set the deviation color neutral (normal)
Public Sub setDevColNeutral(value As Int)
	mDevColNeutral = value
	DrawBar
End Sub
Public Sub getDevColNeutral As Int
	Return mDevColNeutral
End Sub

' Get or set the deviation color warning
Public Sub setDevColWarning(value As Int)
	mDevColWarning = value
	DrawBar
End Sub
Public Sub getDevColWarning As Int
	Return mDevColWarning
End Sub

' Get or set the deviation color alarm
Public Sub setDevColAlarm(value As Int)
	mDevColAlarm = value
	DrawBar
End Sub
Public Sub getDevColAlarm As Int
	Return mDevColAlarm
End Sub

' Get or set the state enabled
Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' Get or set the status Normal, Warning, Alarm, Disabled
Public Sub setStatus(value As String)
	mStatus = value
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub
Public Sub getStatus As String
	Return mStatus
End Sub

' Convenience helpers for the status

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

' ================================================================
' TILESTYLE
' ================================================================

#Region TileStyle
' ApplyStyle
Private Sub ApplyStyle
	HMITileUtils.ApplyTileStyle(BasePane)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelValue)
End Sub

' ApplyStatuStyle
' NOT USED FOR NOW as covered by the deviation bar color
' Set one of the 4 visual status Normal, Warning, Alarm, Disabled
' Parameters:
'	status String - Use HMITileUtils constants STATUS_NORMAL_TEXT ... WARNING, ALARM, DISABLED
Private Sub ApplyStatusStyle(status As String)	'ignore
	mStatus = status

	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelValue)

	Select status
		Case HMITileUtils.STATUS_NORMAL
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
			
		Case HMITileUtils.STATUS_WARNING
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			BasePane.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATUS_ALARM
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			BasePane.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATUS_DISABLED
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			BasePane.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND		
	End Select

	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

#Region Events
#if B4J
Private Sub PaneBar_MouseClicked (EventData As MouseEvent)
	Click
End Sub
#End If

#If B4A
Private Sub PaneBar_Click
	Click
End Sub
#End If

' ================================================================
' B4X - use click only
' ================================================================

Private Sub Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSub3(mCallBack, mEventName & "_Click", mValue, mStatus)
	End If
End Sub
#End Region


