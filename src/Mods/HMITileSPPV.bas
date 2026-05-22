B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:			HMITileSPPV.bas
' Brief:    	CustomView HMITile with a title, process value (PV) and set point (SP).
' Date:			2026-05-16
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	HMITileSPPV displays PV as the dominant value, SP as a secondary value, and exposes interaction only on demand.
'           	Supports Normal, Warning, Alarm styles.
'				Editmode to set the setpoint by clicking on the tile. Click again turns editmode off.
' 				Deviation:
'				- Informational only.
' 				- Limit:
'					Describes what the number represents (threshold / tolerance for Deviation), not the state of the alarm.
'					Alarms are derived from the limit using logic (If Abs(PV−SP) >= DeviationLimit Then Alarm=True).
'					This separates configuration from runtime state, which is a best practice in HMI / DCS projects.
'				Events: 
'				- ValueChanged and SetPointChanged.
'				Naming:
'				For labels use: Process Value and Set Point
'				For variables use: ProcessValue and SetPoint (CamelCase)
' Layout:
'				+---------------------+
'				│        TITLE        │ < Medium, Normal
'				│                     │
'				│        72.4         │ < Large, Normal, promary
'				│---------------------│ < seperator line
'				│ [-]    75.0    [+]  │	< Medium, Normal, secondary
'				|      Indicator      | < Alarm/Warning indicator
'				│      Δ -2.6         │	< Tiny, Normal, secondary
'				+---------------------+
'
' Color & state behavior (critical)
'				Normal
'					- Tile background: neutral gray
'					- PV & SP text: neutral gray
'					- Controls: neutral gray
'
'				Warning / Alarm
'					- Tile-level indication only
'					- Border, header, Or status bar changes
'					- PV/SP text stays neutral (unless alarm text explicitly required)
'				This preserves: Color = abnormal condition only
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 				DisplayName: Title, FieldType: String, DefaultValue: Setpoint
#DesignerProperty: Key: PV, 				DisplayName: PV, FieldType: Float, DefaultValue: 0, Description: Process value.
#DesignerProperty: Key: SP,					DisplayName: SP, FieldType: Float, DefaultValue: 50, Description: Setpoint value.
#DesignerProperty: Key: StepSize,			DisplayName: Step Size, FieldType: Float, DefaultValue: 0.5, Description: Setpoint step size.
#DesignerProperty: Key: Min, 				DisplayName: Min, FieldType: Float, DefaultValue: 0, Description: Setpoint min value.
#DesignerProperty: Key: Max, 				DisplayName: Max, FieldType: Float, DefaultValue: 100, Description: Setpoint max value.
#DesignerProperty: Key: DeviationWarning,	DisplayName: Deviation Warning,	FieldType: Float,	DefaultValue: 60, Description: Deviation absolute value to show warning (0 = disabled).
#DesignerProperty: Key: DeviationAlarm,		DisplayName: Deviation Alarm,	FieldType: Float,	DefaultValue: 85, Description: Deviation absolute value to show alarm (0 = disabled).
#DesignerProperty: Key: Digits,				DisplayName: Digits, FieldType: Int, DefaultValue: 0, Description: Number of digits for the SP, PV and deviation.
#DesignerProperty: Key: ShowDeviation,		DisplayName: Show Deviation, FieldType: Boolean, DefaultValue: True, Description: Whether to show the deviation value.
#DesignerProperty: Key: EditMode, 			DisplayName: Edit Mode, FieldType: Boolean, DefaultValue: True, Description: Whether to use the plus/minus buttons.

' Events
#Event: ValueChanged (Value As Float)
#Event: SetPointChanged (Value As Float)
' #Event: SetPointClicked

Private Sub Class_Globals
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base Views
	Public BasePane As B4XView
	Private BaseLabel As B4XView	'ignore
	Public Tag As Object

	' UI
	Private xui As XUI
	Private PaneTile As B4XView
	Private LabelTitle As B4XView
	Private LabelPV As B4XView
	Private LabelSP As B4XView
	Private LabelMinus As B4XView
	Private LabelPlus As B4XView
	Private LabelDeviation As B4XView
	
	' Properties Designer
	Private mTitle As String
	Private mPV As Float
	Private mSP As Float
	Private mStepSize As Float
	Private mMin As Float
	Private mMax As Float
	Private mDigits As Int
	Private mDeviationWarning As Float
	Private mDeviationAlarm As Float
	Private mShowDeviation As Boolean
	Private mDeviation As Float
	Private mEditMode As Boolean
	Private mStatus As String

	' Properties Class
	Private mCanvasSeperator As B4XCanvas
	Private mCanvasIndicator As B4XCanvas
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
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
	BasePane.LoadLayout("hmitilesppv")

	mTitle					= Props.Get("Title")
	LabelTitle.Text			= mTitle

	' First get min,max,stepsize as required for updatedeviation
	mMin 					= Props.GetDefault("Min", 0)
	mMax 					= Props.GetDefault("Max", 100)
	mStepSize 				= Props.GetDefault("StepSize", 1)
	mShowDeviation			= Props.GetDefault("ShowDeviation", False)
	LabelDeviation.Visible 	= mShowDeviation
	mDeviationWarning		= Props.GetDefault("DeviationWarning", 60)
	mDeviationAlarm			= Props.GetDefault("DeviationAlarm", 85)
	mDigits					= Props.GetDefault("Digits", 0)
	mEditMode				= Props.GetDefault("EditMode", True)
	setEditMode(mEditMode)
	mStatus					= HMITileUtils.STATUS_NORMAL
	mPV						= Props.GetDefault("PV", 0)
	LabelPV.Text 			= NumberFormat(mPV, 0, mDigits)
	mSP						= Props.GetDefault("SP", 100)

	' Canvas Shapes
	mCanvasSeperator.Initialize(BasePane)
	mCanvasIndicator.Initialize(BasePane)
	
	Base_Resize(BasePane.Width, BasePane.Height)
	ApplyStyle
	UpdateSPPV
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return
	
	'							  		 d  l    					t             	w      			h
	PaneTile.SetLayoutAnimated			(0, 0, 						0, 				Width, 			Height)
	LabelTitle.SetLayoutAnimated		(0, 0,                      0,           	Width, 	     	Height * 0.25)
	LabelPV.SetLayoutAnimated			(0, 0,                      Height * 0.30,	Width, 	     	Height * 0.25)
	LabelMinus.SetLayoutAnimated		(0, 0,		                Height * 0.60, 	Width * 0.25, 	Height * 0.20)
	LabelSP.SetLayoutAnimated			(0, Width * 0.25,           Height * 0.55, 	Width * 0.50, 	Height * 0.25)
	LabelPlus.SetLayoutAnimated			(0, Width - (Width * 0.25), Height * 0.60, 	Width * 0.25, 	Height * 0.20)
	LabelDeviation.SetLayoutAnimated	(0, 0,                      Height * 0.80, 	Width,        	Height * 0.15)

	' Draw seperator below PV
	Dim h As Double = Height * 0.6
	mCanvasSeperator.DrawLine(0, h, Width, h, xui.Color_White, 1dip)
End Sub

' UpdateSPPV
' Updates values, calculates multi-tier absolute deviations, and sets ISA-101 tile colors.
Public Sub UpdateSPPV
	' Calculate the real Delta and the Absolute Error
	mDeviation = mPV - mSP
	Dim AbsoluteError As Float = Abs(mDeviation)
	
	' Update visual text fields
	LabelPV.Text = NumberFormat(mPV, 1, 1)
	LabelSP.Text = "SP: " & NumberFormat(mSP, 1, 0)
	
	' Use a single clean line. Add a "+" prefix manually only if the value is greater than zero
	Dim SignPrefix As String = ""
	If mDeviation > 0 Then SignPrefix = "+"
	' Format the basic numerical deviation text string
	Dim DeviationStr As String = "Δ " & SignPrefix & NumberFormat(mDeviation, 1, 1)

	LabelDeviation.TextColor = 0xFFFFFFFF	' White Color

	' Evaluate multi-tier deviation logic & set layout states
	If AbsoluteError >= mDeviationAlarm Then
		' CRITICAL ALARM STATE
		mStatus = HMITileUtils.STATUS_ALARM
	Else If AbsoluteError >= mDeviationWarning Then
		' WARNING STATE
		mStatus = HMITileUtils.STATUS_WARNING
	Else
		' NORMAL STATE (Everything is safe)
		mStatus = HMITileUtils.STATUS_NORMAL
	End If
	LabelDeviation.Text = $"${DeviationStr}"$
	
	' Shape Indicator warning or alarm
	' ### HMITileUtils.DrawAlarmWarningIndicator(mCanvasIndicator, BasePane, AbsoluteError, mDeviationWarning, mDeviationAlarm)
	' Log($"[UpdateSPPV] absoluteerror=${AbsoluteError} alarm=${mDeviationAlarm} warning=${mDeviationWarning} status=${mStatus}"$)
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
' Get or set the title
Public Sub setTitle(text As String)
	mTitle = text
	LabelTitle.Text = mTitle
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

' Get or set the Process Value (PV)
Public Sub setPV(value As Float)
	mPV = value
	UpdateSPPV
	If SubExists(mCallBack, mEventName & "_ValueChanged") Then
		CallSub2(mCallBack, mEventName & "_ValueChanged", value)
	End If
End Sub
Public Sub getPV As Float
	Return mPV
End Sub

' Get or set the Set Point (SP).
' If SP < Min then SP = min. If SP > Max then SP = Max.
Public Sub setSP(value As Float)
	If value < mMin Then value = mMin
	If value > mMax Then value = mMax
	mSP = value
	UpdateSPPV
	If SubExists(mCallBack, mEventName & "_SetPointChanged") Then
		CallSub2(mCallBack, mEventName & "_SetPointChanged", value)
	End If
End Sub
Public Sub getSP As Float
	Return mSP
End Sub

' Set the values for the Set Point (SP) and Process Value (PV).
Public Sub SetSPPV(valuesp As Float, valuepv As Float)
	setSP(valuesp)
	setPV(valuepv)
End Sub

' Deviation
' Deviation = PV - SP
' Result:
' 0: No deviation Process Value  is On Set Point Value
' Positive: Process Value above Set Point
' Negative: Process Value below Set Point
Public Sub Deviation As Float
	Return mDeviation
End Sub

' Get or set the option to show the deviation label
Public Sub setShowDeviation(state As Boolean)
	mShowDeviation = state
	LabelDeviation.Visible = mShowDeviation
End Sub
Public Sub getShowDeviation As Boolean
	Return mShowDeviation
End Sub

' Get or set the deviation warning limit
Public Sub setDeviationWarning(value As Double)
	mDeviationWarning = value
	UpdateSPPV
End Sub
Public Sub getDeviationWarning As Double
	Return mDeviationWarning
End Sub

' Get or set the deviation alarm limit
Public Sub setDeviationAlarm(value As Double)
	mDeviationAlarm = value
	UpdateSPPV
End Sub
Public Sub getDeviationAlarm As Double
	Return mDeviationAlarm
End Sub

' Get or set the value number of digits
Public Sub setDigits(value As Int)
	If value < 0 Then value = 0
	mDigits = value
End Sub
Public Sub getDigits As Int
	Return mDigits
End Sub

' Get or set the min Set Point value
Public Sub setMin(value As Float)
	mMin = value
End Sub
Public Sub getMin As Float
	Return mMin
End Sub

' Get or set the max Set Point value
Public Sub setMax(value As Float)
	mMax = value
End Sub
Public Sub getMax As Float
	Return mMax
End Sub

' Get or set the Set Point step size
Public Sub setStepSize(value As Float)
	mStepSize = value
End Sub
Public Sub getStepSize As Float
	Return mStepSize
End Sub

' Get or set the tile to enabled
Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' Get or set the Set Point edit mode.
' If edit mode, the Set Point can be changed and the plus/minus icons are visible.
Public Sub setEditMode(state As Boolean)
	mEditMode = state
	LabelMinus.Visible 	= mEditMode
	LabelPlus.Visible	= mEditMode
End Sub
Public Sub getEditMode As Boolean
	Return mEditMode
End Sub

' Decrease the Set Point with the step size value.
Public Sub StepMinus
	Dim v As Float = mSP
	v = v - mStepSize
	setSP(v)
End Sub

' Increasethe Set Point with the step size value.
Public Sub StepPlus
	Dim v As Float = mSP
	v = v + mStepSize
	setSP(v)
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

#End Region

' ================================================================
' TILESTYLE
' ================================================================

#Region TileStyle
Public Sub ApplyStyle
	HMITileUtils.ApplyTileStyle(BasePane)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelPV)
	HMITileUtils.ApplyLabelStyle(LabelSP)
	HMITileUtils.ApplyFontAwesomeStyle(LabelMinus)
	HMITileUtils.ApplyFontAwesomeStyle(LabelPlus)
	HMITileUtils.ApplySubInfoStyle(LabelDeviation)
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================

#Region Events

#If B4A
Private Sub LabelMinus_Click
	StepMinus
End Sub

Private Sub LabelPlus_Click
	StepPlus
End Sub

Private Sub LabelSP_Click
	setEditMode(Not(mEditMode))
End Sub
#End If

#if B4J
Private Sub LabelMinus_MouseClicked (EventData As MouseEvent)
	StepMinus
End Sub

Private Sub LabelPlus_MouseClicked (EventData As MouseEvent)
	StepPlus
End Sub

Private Sub LabelSP_MouseClicked (EventData As MouseEvent)
	setEditMode(Not(mEditMode))
End Sub
#end if
#End Region


