B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileLevel.bas
' Brief:		CustomView HMITile with a level bar 0-100%.
'				Style can be set to Normal, Warning, Alarm or Dimmed.
' Date:			2025-12-29
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|       Title      |  	<< 25%
'				|       Level      |	<< 50%
'				|        BAR       |  
'				| 	  Value Unit   |	<< 25%
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,		DisplayName: Title, FieldType: String, DefaultValue: Level
#DesignerProperty: Key: Value, 		DisplayName: Value, FieldType: Float, DefaultValue: 0
#DesignerProperty: Key: Unit,  		DisplayName: Unit,  FieldType: String, DefaultValue: 
#DesignerProperty: Key: TypeStyle, 	DisplayName: HMITile Style, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click (Value As Float)

Private Sub Class_Globals
	Private mEventName As String
	Private mCallBack As Object

	Public mBase As B4XView
	Public mLbl As B4XView

	Private xui As XUI
	Public Tag As Object

	' Views inside HMITileSensor.bjl
	Private LabelTitle As B4XView
	Private PaneBar As B4XView
	Private PaneFill As B4XView
	Private LabelValue As B4XView

	' Designer values
	Private mValue As Float
	Private mUnitText As String
	Private mTypeStyle As String

	Private mDigits As Int = 0
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
	mBase.LoadLayout("hmitilelevel")
	
	' Store designer properties
	LabelTitle.Text = Props.Get("Title")
	LabelValue.Text = Props.Get("Value")
	mValue			= Props.Get("Value")
	mUnitText		= Props.Get("Unit")
	mTypeStyle		= Props.Get("TypeStyle")

	ApplyStyle(mTypeStyle)
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	LabelTitle.SetLayoutAnimated(0, pad, pad, Width - pad * 2, Height * 0.25)

	UpdateLevel
				
	LabelValue.SetLayoutAnimated(0, pad, (Height*0.75) - pad, Width - pad * 2, Height * 0.25)
End Sub

' Update level bar with level 0 check.
Private Sub UpdateLevel
	If Not(PaneFill.IsInitialized) Then
		Log($"[HMITileLevel.UpdateLevel] PaneFill not initialized."$)
		Return
	End If

	Dim l As Int	= mBase.width / 4
	Dim t As Int	= LabelTitle.Top + LabelTitle.Height ' + pad
	Dim w As Int	= mBase.width / 2
	Dim h As Int	= (mBase.height * 0.50) - HMITileUtils.PADDING
	
	Dim pct As Float = 0
	If mValue < 0 Then
		mValue = 0
	End If
	If mValue > 0 Then
		pct = mValue / 100
	End If
	Dim fillheight As Int = (h * pct)

	' Fill = Level
	l 	= l ' + pad
	t 	= t + (h - fillheight)
	w 	= w ' - pad * 2
	h 	= IIf(fillheight > 0, fillheight, 0)
	PaneFill.SetLayoutAnimated(0, l, t, w, h)
	'Log($"[HMITileLevel.UpdateLevel] Fill: l=${l},t=${t},w=${w},h=${h},th=${t+h},fh=${fillheight}, "$)

	' Bar = Background
	l	= l
	t	= LabelTitle.Top + LabelTitle.Height
	w	= w
	h	= (mBase.height * 0.50) - h
	PaneBar.SetLayoutAnimated(0, l, t, w, h)
	' Log($"[HMITileLevel.UpdateLevel] Bar: l=${l},t=${t},w=${w},h=${h},th=${t+h},fh=${fillheight}"$)
End Sub

' ===================================================================
' Public API
' ===================================================================

Public Sub setTitle(title As String)
	LabelTitle.Text = title
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

' Value
Public Sub setValue(value As Float)
	If LabelValue.IsInitialized Then
		mValue = value
		UpdateLevel
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
#Region HMITile Styling
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

	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)

	' --- Bar ---
	PaneBar.SetColorAndBorder( _
        HMITileUtils.COLOR_SLIDER_TRACK, _
        0dip, _
        HMITileUtils.COLOR_SLIDER_TRACK, _
        0dip)

	' --- Fill ---
	PaneFill.SetColorAndBorder( _
        HMITileUtils.COLOR_SLIDER_ACTIVE, _
        0dip, _
        HMITileUtils.COLOR_SLIDER_ACTIVE, _
        0dip)
End Sub
#End Region

#Region Events
#if B4J
Private Sub PaneBar_MouseClicked (EventData As MouseEvent)
	Click
End Sub

Private Sub PaneFill_MouseClicked (EventData As MouseEvent)
	Click
End Sub
#End If

#If B4A
Private Sub PaneBar_Click
	Click
End Sub

Private Sub PaneFill_Click
	Click
End Sub
#End If

' ================================================================
' B4X - use click only
' ================================================================

Private Sub Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSub2(mCallBack, mEventName & "_Click", mValue)
	End If
End Sub
#End Region


