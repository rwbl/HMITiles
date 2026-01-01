B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:			HMITileSPPV.bas
' Brief:    	CustomView HMITile with a title, process value (PV) and setpoint (SP).
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
' Date:			2025-12-24
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+---------------------+
'				│        TITLE        │ < Medium, Normal
'				│                     │
'				│        72.4         │ < Large, Normal, promary
'				│                     │
'				│ [-]    75.0    [+]  │	< Medium, Normal, secondary
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
#DesignerProperty: Key: Digits,				DisplayName: Digits, FieldType: Int, DefaultValue: 0, Description: Number of digits for the SP, PV and deviation.
#DesignerProperty: Key: DeviationLimit,		DisplayName: Deviation Limit, FieldType: Float, DefaultValue: 0, Description: Deviation absolute value to show alarm (0 = disabled).
#DesignerProperty: Key: ShowDeviation,		DisplayName: Show Deviation, FieldType: Boolean, DefaultValue: True, Description: Whether to show the deviation value.
#DesignerProperty: Key: EditMode, 			DisplayName: Edit Mode, FieldType: Boolean, DefaultValue: True, Description: Whether to use the plus/minus buttons.

' Events
#Event: ValueChanged (Value As Float)
#Event: SetPointChanged (Value As Float)
' #Event: SetPointClicked

Private Sub Class_Globals
	' Constants
	Private DEVIATION_CHARACTER As String = "Δ"
	
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base Views
	Public mBase As B4XView
	Private mLbl As B4XView	'ignore
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
	Private mTypeStyle As String
	Private mPV As Float
	Private mSP As Float
	Private mStepSize As Float
	Private mMin As Float
	Private mMax As Float
	Private mDigits As Int
	Private mDeviationLimit As Float
	Private mShowDeviation As Boolean
	Private mDeviation As Float
	Private mEditMode As Boolean
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
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
	mBase.LoadLayout("hmitilesppv")

	LabelTitle.Text			= Props.Get("Title")

	' First get min,max,stepsize as required for updatedeviation
	mMin 					= Props.GetDefault("Min", 0)
	mMax 					= Props.GetDefault("Max", 100)
	mStepSize 				= Props.GetDefault("StepSize", 1)

	' Get the SP, PV and deviation
	setPV(Props.GetDefault("PV", 0))
	setSP(Props.GetDefault("SP", 100))
	UpdateDeviation

	mShowDeviation			= Props.GetDefault("ShowDeviation", False)
	LabelDeviation.Visible 	= mShowDeviation
	mDeviationLimit			= Props.GetDefault("DeviationLimit", 0)
	mDigits					= Props.GetDefault("Digits", 0)
	mEditMode				= Props.GetDefault("EditMode", True)
	setEditMode(mEditMode)
	mTypeStyle				= HMITileUtils.STATE_NORMAL

	ApplyStyle(mTypeStyle)
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return
	
	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	PaneTile.SetLayoutAnimated(0,0,0,Width, Height)
										'd  l                       t              w             h
	LabelTitle.SetLayoutAnimated		(0, 0,                      pad,           Width, 	     Height * 0.25)
	LabelPV.SetLayoutAnimated			(0, 0,                      Height * 0.30, Width, 	     Height*0.25)
	LabelMinus.SetLayoutAnimated		(0, 0,		                Height * 0.60, Width * 0.25, Height*0.20)
	LabelSP.SetLayoutAnimated			(0, Width * 0.25,           Height * 0.55, Width * 0.50, Height*0.25)
	LabelPlus.SetLayoutAnimated			(0, Width - (Width * 0.25), Height * 0.60, Width * 0.25, Height*0.20)
	LabelDeviation.SetLayoutAnimated	(0, 0,                      Height * 0.80, Width,        Height*0.15)
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
Public Sub setTitle(text As String)
	LabelTitle.Text = text
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub setPV(value As Float)
	Try
		mPV = value
		LabelPV.Text = NumberFormat(mPV, 1, mDigits)
		UpdateDeviation
		If SubExists(mCallBack, mEventName & "_ValueChanged") Then
			CallSub2(mCallBack, mEventName & "_ValueChanged", value)
		End If
	Catch
		Log($"[HMITileSPPV.setPV][E] ${LastException}"$)
	End Try
End Sub
Public Sub getPV As Float
	Return mPV
End Sub

Public Sub setSP(value As Float)
	If value < mMin Then value = mMin
	If value > mMax Then value = mMax
	Try
		mSP = value
		LabelSP.Text = NumberFormat(mSP, 1, mDigits)
		UpdateDeviation
		If SubExists(mCallBack, mEventName & "_SetPointChanged") Then
			CallSub2(mCallBack, mEventName & "_SetPointChanged", value)
		End If
	Catch
		Log($"[HMITileSPPV.setSP][E] ${LastException}"$)
	End Try
End Sub
Public Sub getSP As Float
	Return mSP
End Sub

' Set the values for the SP and PV.
Public Sub SetSPPV(valuesp As Float, valuepv As Float)
	setSP(valuesp)
	setPV(valuepv)
End Sub

' Deviation
' Deviation = PV - SP
' Result:
' 0: On setpoint
' Positive: Process above setpoint
' Negative: Process below setpoint
Public Sub Deviation As Float
	mDeviation = 0
	Try
		mDeviation = mPV - mSP
		If mDeviationLimit > 0 Then
			If Abs(mDeviation) >= mDeviationLimit Then
				SetStyleAlarm
			Else
				SetStyleNormal
			End If
		End If
	Catch
		Log($"[HMITileSPPV.Deviation][E] ${LastException}"$)
	End Try
	Return mDeviation
End Sub

Private Sub UpdateDeviation
	LabelDeviation.Text = $"${DEVIATION_CHARACTER} ${NumberFormat(Deviation, 1, mDigits)}"$
End Sub

Public Sub setShowDeviation(state As Boolean)
	mShowDeviation = state
	LabelDeviation.Visible = mShowDeviation
End Sub
Public Sub getShowDeviation As Boolean
	Return mShowDeviation
End Sub

Public Sub setDeviationLimit(value As Double)
	mDeviationLimit = value
End Sub
Public Sub getDeviationAlarm As Double
	Return mDeviationLimit
End Sub

Public Sub setDigits(value As Int)
	If value < 0 Then value = 0
	mDigits = value
End Sub
Public Sub getDigits As Int
	Return mDigits
End Sub

Public Sub setMin(value As Float)
	mMin = value
End Sub
Public Sub getMin As Float
	Return mMin
End Sub

Public Sub setMax(value As Float)
	mMax = value
End Sub
Public Sub getMax As Float
	Return mMax
End Sub

Public Sub setStepSize(value As Float)
	mStepSize = value
End Sub
Public Sub getStepSize As Float
	Return mStepSize
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

' Option to set edit mode - panels (icons enabled.
Public Sub setEditMode(state As Boolean)
	mEditMode = state
	LabelMinus.Visible 	= mEditMode
	LabelPlus.Visible	= mEditMode
End Sub
Public Sub getEditMode As Boolean
	Return mEditMode
End Sub

Public Sub StepMinus
	Dim v As Float = LabelSP.Text
	v = v - mStepSize
	setSP(v)
End Sub

Public Sub StepPlus
	Dim v As Float = LabelSP.Text
	v = v + mStepSize
	setSP(v)
End Sub
#End Region

' ================================================================
' TILE STYLING
' ================================================================
#Region Tile Styling
' ApplyStyle
' Apply one of the 4 styles Normal, Warning, Alarm, Disabled
' Parameters:
'	tilestate String - Use HMITileUtils constants STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
Public Sub ApplyStyle(tilestate As String)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelPV)
	HMITileUtils.ApplyLabelStyle(LabelSP)
	HMITileUtils.ApplyFontAwesomeStyle(LabelMinus)
	HMITileUtils.ApplyFontAwesomeStyle(LabelPlus)
	HMITileUtils.ApplySubInfoStyle(LabelDeviation)

	Dim state As Int = HMITileUtils.StateStyleToState(tilestate)
	Select state
		Case HMITileUtils.STATE_NORMAL
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelPV.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelSP.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelMinus.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelPlus.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelDeviation.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
			
		Case HMITileUtils.STATE_WARNING
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelPV.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelSP.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelMinus.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelPlus.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelDeviation.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATE_ALARM
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelPV.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelSP.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelMinus.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelPlus.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelDeviation.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATE_DISABLED
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelPV.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelSP.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelMinus.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelPlus.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelDeviation.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	End Select

	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
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


