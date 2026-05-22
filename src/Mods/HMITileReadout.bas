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
' Date:			2026-05-22
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
#DesignerProperty: Key: Title, 		DisplayName: Title,		FieldType: String, DefaultValue: Sensor
#DesignerProperty: Key: Value, 		DisplayName: Value, 	FieldType: String, DefaultValue: --
#DesignerProperty: Key: Unit, 		DisplayName: Unit, 		FieldType: String, DefaultValue: Unit
#DesignerProperty: Key: Status,		DisplayName: Status,	FieldType: String, List: Normal|Warning|Alarm, DefaultValue: Normal

' Events
#Event: Click

Private Sub Class_Globals
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base Views
	Public BasePane As B4XView
	Public BaseLabel As B4XView
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
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilereadout")

	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mValue			= Props.Get("Value")
	LabelValue.Text = mValue
	mUnit			= Props.Get("Unit")
	LabelUnit.Text 	= mUnit
	mStatus			= Props.Get("Status")

	ApplyStyle
	Base_Resize(BasePane.Width, BasePane.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(LabelValue.IsInitialized) Then Return

	'							  d  l    t             w      h	
	LabelTitle.SetLayoutAnimated (0, 0, 0,           	Width, Height * 0.25)
	LabelValue.SetLayoutAnimated (0, 0, 0, 				Width, Height)
	LabelUnit.SetLayoutAnimated  (0, 0, Height * 0.80, 	Width, Height * 0.15)
End Sub

' PUBLIC API

' Get or set the title as string
Public Sub setTitle(text As String)
	mTitle = text
	LabelTitle.Text = mTitle
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

' Get or set the value as string
Public Sub setValue(value As String)
	mValue = value
	LabelValue.Text = mValue
End Sub
Public Sub getValue As String
	Return mValue
End Sub

' Get or set the unit as string
Public Sub setUnit(text As String)
	mUnit = text
	LabelUnit.Text = mUnit
End Sub
Public Sub getUnit As String
	Return mUnit
End Sub

' Get or set the tile enabled
Public Sub setEnabled(enabled As Boolean)
	mEnabled = enabled
	BasePane.Enabled = mEnabled
	BasePane.Alpha = HMITileUtils.SetAlpha(mEnabled)
End Sub
Public Sub getEnabled As Boolean
	Return mEnabled
End Sub

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

' Set or get value label text size
' Use for example to reduce size if the value is used as text indicator
Public Sub setValueTextSize(value As Float)
	LabelValue.TextSize = value
End Sub
Public Sub getValueTextSize As Float
	Return LabelValue.TextSize
End Sub


#End Region

#Region TileStyle
' ================================================================
' TILESTYLE
' ================================================================
Private Sub ApplyStyle
	HMITileUtils.ApplyTileStyle(BasePane)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelValue)
	HMITileUtils.ApplyUnitStyle(LabelUnit)
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub
#End Region

#Region Events
' ================================================================
' EVENTS
' ================================================================
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
