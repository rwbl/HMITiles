B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileReadout.bas
' Brief:    	CustomView HMITile with a title, value, unit readout.
'           	Supports Normal, Warning, Alarm, Dimmed styles.
' Date:			2025-12-26
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|      Label       |   <- h=25%
'				|       23         |   <- h=60%
'				|       °C         |   <- h=15%
'				+------------------+
'				Note: Layout aligned with HMITileButton.
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 		DisplayName: Title, FieldType: String, DefaultValue: Sensor
#DesignerProperty: Key: Value, 		DisplayName: Value, FieldType: String, DefaultValue: --
#DesignerProperty: Key: Unit, 		DisplayName: Unit, FieldType: String, DefaultValue: Unit
#DesignerProperty: Key: TypeStyle,	DisplayName: Style, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click

Sub Class_Globals
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
	Private mTypeStyle As String
	
	' Properties (Class)
	Private mState As Boolean = False
	Private mValue As String
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

	LabelTitle.Text = Props.Get("Title")
	LabelValue.Text = Props.Get("Value")
	LabelUnit.Text 	= Props.Get("Unit")
	mTypeStyle		= Props.Get("TypeStyle")

	ApplyStyle(mTypeStyle)

	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(LabelValue.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING
	
	LabelTitle.SetLayoutAnimated (0, pad, pad,           Width - pad * 2, Height * 0.25)
	LabelValue.SetLayoutAnimated (0, pad, Height * 0.25, Width - pad * 2, Height * 0.60)
	LabelUnit.SetLayoutAnimated  (0, pad, Height * 0.80, Width - pad * 2, Height * 0.15)
End Sub

' ========== Getters / Setters ==========

Public Sub setTitle(text As String)
	LabelTitle.Text = text
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

' Value as string
Public Sub setValue(value As String)
	Try
		mValue = value
		LabelValue.Text = mValue
	Catch
		Log($"[HMITileReadOut.setValue][E] ${LastException}"$)
	End Try
End Sub
Public Sub getValue As String
	Return mValue
End Sub

Public Sub setUnit(text As String)
	LabelUnit.Text = text
End Sub
Public Sub getUnit As String
	Return LabelUnit.Text
End Sub

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

Public Sub setState(state As Boolean)
	mState = state
	HMITileUtils.ApplyStyleStateOnOff(mBase, LabelValue, state)
End Sub
Public Sub getState As Boolean
	Return mState
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
' Tile STYLING
' ================================================================
#Region Tile Styling
' ApplyStyle
' Apply one of the 4 styles Normal, Warning, Alarm, Disabled
' Parameters:
'	tilestate String - Use HMITileUtils constants STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
Public Sub ApplyStyle(tilestate As String)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelValue)
	HMITileUtils.ApplyUnitStyle(LabelUnit)

	Dim state As Int = HMITileUtils.StateStyleToState(tilestate)
	Select state
		Case HMITileUtils.STATE_NORMAL
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelUnit.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

		Case HMITileUtils.STATE_WARNING
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelUnit.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATE_ALARM
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelUnit.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATE_DISABLED
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
