B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
' ================================================================
' File:     	HMITileReadout.bas
' Brief:    	CustomView HMITile with a title, value, unit readout.
'           	Supports Normal, Warning, Alarm, Dimmed styles.
' Date:			2026-04-23
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Layout:
'				+------------------+
'				|      Label       |   <- h=25%
'				|       23         |   <- h=60%
'				|       °C         |   <- h=15%
'				+------------------+
'				Note: Layout aligned with HMITileButton.
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 		DisplayName: Title, FieldType: String, DefaultValue: Sensor
#DesignerProperty: Key: Value, 		DisplayName: Value, FieldType: String, DefaultValue: --
#DesignerProperty: Key: Unit, 		DisplayName: Unit, FieldType: String, DefaultValue: Unit
#DesignerProperty: Key: Status,		DisplayName: Status, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click

Private Sub Class_Globals
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base Views
	Public mBase As B4XView
	Public mLbl As B4XView
	Public Tag As Object

	' UI
	Private xui As XUI
	Private LabelTitle As B4XView
	Private LabelValue As B4XView
	Private LabelUnit As B4XView
	
	' Properties Designer
	Private mTitle As String
	Private mValue As String
	Private mUnit As String
	Private mStatus As String
	
	' Properties (Class)
	Private mEnabled As Boolean = True
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitilereadout")

	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mValue			= Props.Get("Value")
	LabelValue.Text = mValue
	mUnit			= Props.Get("Unit")
	LabelUnit.Text 	= mUnit
	mStatus		= Props.Get("Status")

	ApplyStatusStyle(mStatus)

	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(LabelValue.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING
								 'd  l    t              w                h	
	LabelTitle.SetLayoutAnimated (0, pad, pad,           Width - pad * 2, Height * 0.25)
	LabelValue.SetLayoutAnimated (0, pad, Height * 0.25, Width - pad * 2, Height * 0.60)
	LabelUnit.SetLayoutAnimated  (0, pad, Height * 0.80, Width - pad * 2, Height * 0.15)
End Sub

' PUBLIC API

Public Sub setTitle(text As String)
	mTitle = text
	LabelTitle.Text = mTitle
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

' Value as string
Public Sub setValue(value As String)
	mValue = value
	LabelValue.Text = mValue
End Sub
Public Sub getValue As String
	Return mValue
End Sub

Public Sub setUnit(text As String)
	mUnit = text
	LabelUnit.Text = mUnit
End Sub
Public Sub getUnit As String
	Return mUnit
End Sub

Public Sub setEnabled(enabled As Boolean)
	mEnabled = enabled
	mBase.Enabled = mEnabled
	mBase.Alpha = HMITileUtils.SetAlpha(mEnabled)
End Sub
Public Sub getEnabled As Boolean
	Return mEnabled
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
	HMITileUtils.ApplyUnitStyle(LabelUnit)

	Select status
		Case HMITileUtils.STATUS_NORMAL
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelUnit.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

		Case HMITileUtils.STATUS_WARNING
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelUnit.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATUS_ALARM
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelUnit.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATUS_DISABLED
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelUnit.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	End Select
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

#Region Events
#if B4J
Private Sub LabelValue_MouseClicked (EventData As MouseEvent)
	LabelValue_Click
End Sub
#end if

' ================================================================
' B4X - use click only
' ================================================================

' LabelValue_Click
' Supports B4A, B4J
' Call event.
Private Sub LabelValue_Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
