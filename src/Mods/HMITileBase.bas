B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileBase.bas
' Brief:		CustomView HMITile with 3 labels title, value, unit.
' Date:			2026-05-18
' Author:		Robert W.B. Linn (c) 2025 MIT
' Description:	Style can be set to Normal, Warning, Alarm.
'				Layout Default 120px x 120px
' Layout:
'				+------------------+
'				|      Title       |   <- h=25%
'				|      Value       |   <- h=60%
'				|      Unit        |   <- h=15%
'				+------------------+
' ================================================================
#End Region

' Views
#DesignerProperty: Key: Title,	DisplayName: Title,		FieldType: String, DefaultValue: Title
#DesignerProperty: Key: Value,	DisplayName: Value,		FieldType: String, DefaultValue: Value
#DesignerProperty: Key: Unit,	DisplayName: Unit,		FieldType: String, DefaultValue: Unit
#DesignerProperty: Key: Status, DisplayName: Status,	FieldType: String, List: Normal|Warning|Alarm, DefaultValue: Normal

' Events
#Event: Click

Private Sub Class_Globals
	' Base
	Public BasePane As B4XView
	Private BaseLabel As B4XView	'ignore
	Public Tag As Object

	' XUI
	Private xui As XUI 'ignore
	Private LabelTitle As B4XView
	Private LabelValue As B4XView
	Private LabelUnit As B4XView

	' Events
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	
	' Properties Designer
	Private mTitle As String
	Private mValue As String
	Private mUnit As String
	Private mStatus As String

	' Properties Class
	Private mValueSize As Double
	Private mValueColor As Int
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

'Base type must be Object
Private Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	' Load the customview layout(s) via CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilebase")

	' Get & assign designer properties	
	mTitle			= Props.Get("Title")
	LabelTitle.Text	= mTitle
	mValue			= Props.Get("Value")
	LabelValue.Text	= mValue
	mValueSize		= LabelValue.TextSize
	mValueColor		= LabelValue.TextColor
	mUnit			= Props.Get("Unit")
	LabelUnit.Text	= mUnit
	mStatus 		= Props.Get("Status")

	ApplyStyle
	Base_Resize(BasePane.Width, BasePane.Height)
	setStatus(mStatus)
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return
	'								 d  l  t              	w       h
	LabelTitle.SetLayoutAnimated	(0, 0, 0,           	Width, 	Height * 0.25)
	LabelValue.SetLayoutAnimated	(0, 0, 0, 				Width, 	Height * 1.00)
	LabelUnit.SetLayoutAnimated  	(0, 0, Height * 0.80, 	Width,	Height * 0.15)
End Sub

' ===================================================================
' Public API
' ===================================================================

Public Sub setTitle(value As String)
	mTitle = value
	LabelTitle.Text = mTitle
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

Public Sub setValue(value As String)
	mValue = value
	LabelValue.Text = mValue
End Sub
Public Sub getValue As String
	Return mValue
End Sub

Public Sub setValueSize(value As Double)
	mValueSize = value
	LabelValue.TextSize = value
End Sub
Public Sub getValueSize As Double
	Return mValueSize
End Sub

Public Sub setValueColor(value As Int)
	mValueColor = value
	LabelValue.TextColor = value
End Sub
Public Sub getValueColor As Int
	Return mValueColor
End Sub

' Set the font of the label Value to fontawesome.
Public Sub SetValueFontAwesome(large As Boolean)
	If large Then
		LabelValue.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON_LARGE)
	Else
		LabelValue.Font = xui.CreateFontAwesome(HMITileUtils.TEXT_SIZE_ICON)
	End If
End Sub

' Set the font of the label Value to default.
Public Sub SetValueFontDefault
	LabelValue.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_STATE)
End Sub

Public Sub setUnit(value As String)
	mUnit = value
	LabelUnit.Text = mUnit
End Sub
Public Sub getUnit As String
	Return mUnit
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

' --- Core property ---
Public Sub setStatus(value As String)
	mStatus = value
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub
Public Sub getStatus As String
	Return mStatus
End Sub

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
	TileClick
End Sub
#End If

' B4A
Private Sub LabelValue_Click
	TileClick
End Sub

Private Sub TileClick
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
