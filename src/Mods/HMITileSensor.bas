B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileSensor.bas
' Brief:		CustomView HMITile with at the 
'				- top an icon/label centered
'				- bottom a label with value
'				Style can be set to Normal, Warning, Alarm or Dimmed.
' Date:			2025-12-28
' Author:		Robert W.B. Linn (c) 2025 MIT
' Hints: 		HMITile can not be resized after form loaded.
' 				DesignerProperty FieldType - One of the following values (case insensitive): String, Int, Float, Boolean or Color.
' Layout:
'				+------------------+
'				|       Label      |  < 25%
'				|       Icon       |  < 50%
'				|       Value      |  < 25% 
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: TitleText, DisplayName: Title, FieldType: String, DefaultValue: Sensor
#DesignerProperty: Key: ValueText, DisplayName: Value, FieldType: String, DefaultValue: --
#DesignerProperty: Key: UnitText,  DisplayName: Unit,  FieldType: String, DefaultValue: 
#DesignerProperty: Key: Icon,      DisplayName: Icon (FontAwesome), FieldType: String, DefaultValue: , Description: Set "F043" or "f043" (without 0x) or real character.
#DesignerProperty: Key: TypeStyle, DisplayName: Style, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click

Sub Class_Globals
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base
	Public mBase As B4XView
	Public mLbl As B4XView
	Public Tag As Object

	' XUI
	Private xui As XUI

	' Views inside layout HMITileSensor
	Private LabelTitle As B4XView
	Private LabelIcon As B4XView
	Private LabelValue As B4XView

	' Properties Designer
	Private mValueText As String
	Private mValue As String
	Private mUnitText As String
	Private mTypeStyle As String
	
	' Properties (Class)
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub


Public Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitilesensor")

	' Store designer properties
	LabelTitle.Text = Props.Get("TitleText")
	LabelIcon.Text  = Props.Get("Icon")
	LabelValue.Text = Props.Get("ValueText")
	mValueText		= Props.Get("ValueText")
	mValue = mValueText
	mUnitText		= Props.Get("UnitText")
	mTypeStyle		= Props.Get("TypeStyle")

	' Ensure the font is set to FA
	setIcon(LabelIcon.Text)

	ApplyStyle(mTypeStyle)
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + 4dip

	LabelTitle.SetLayoutAnimated(0, pad, pad, Width - pad*2, Height * 0.25)
	LabelIcon.SetLayoutAnimated(0, pad, Height*0.25, Width - pad*2, Height*0.50)
	LabelValue.SetLayoutAnimated(0, pad, Height*0.75, Width - pad*2, Height*0.25)
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

' Icon
Public Sub setIcon(iconHex As String)
	If iconHex == "" Then Return
	' Log($"[SetIcon] iconHex=${iconHex}, ${Bit.ParseInt(iconHex, 16)}"$)
    ' expects "F043" or "f043" or real character
    Try
        If iconHex.Length > 0 And iconHex.Length <= 6 And iconHex.ToLowerCase.StartsWith("f") Then
            LabelIcon.Text = Chr(Bit.ParseInt(iconHex, 16))
        Else
            LabelIcon.Text = iconHex
        End If
    Catch
        LabelIcon.Text = iconHex
    End Try
End Sub
Public Sub getIcon As String
	Return LabelIcon.Text
End Sub

Public Sub SetIconColor(clr As Int)
    LabelIcon.TextColor = clr
End Sub

Public Sub SetIconSize(size As Int)
    LabelIcon.TextSize = size
End Sub

Public Sub SetIconScale(scale As Float)
	LabelIcon.TextSize = LabelTitle.TextSize * scale
End Sub

' Value
Public Sub setValue(value As String)
	Try
		mValue = value
		LabelValue.Text = value & mUnitText
	Catch
		Log($"[HMITileSensor.setValue][E] ${LastException}"$)
	End Try
End Sub
Public Sub getValue As String
	Return mValue
End Sub

Public Sub setUnit(unit As String)
	mUnitText = unit
	LabelValue.Text =  mValueText & unit
End Sub
Public Sub getUnit As String
	Return mUnitText
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
' HMITile STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply one of the 4 styles Normal, Warning, Alarm, Disabled
' Parameters:
'	tilestate String - Use HMITileUtils constants STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
Public Sub ApplyStyle(tilestate As String)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	LabelIcon.TextSize = HMITileUtils.TEXT_SIZE_ICON
	LabelIcon.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
	HMITileUtils.ApplyValueStyle(LabelValue)

	Dim state As Int = HMITileUtils.StateStyleToState(tilestate)
	Dim clr As Int = HMITileUtils.COLOR_TEXT_PRIMARY
	' --- Apply State Colors ---
	Select state
		Case HMITileUtils.STATE_NORMAL
			clr = HMITileUtils.COLOR_TEXT_PRIMARY
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

		Case HMITileUtils.STATE_WARNING
			clr = HMITileUtils.COLOR_TILE_WARNING_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATE_ALARM
			clr = HMITileUtils.COLOR_TILE_ALARM_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATE_DISABLED
			clr = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	End Select
	LabelTitle.TextColor = clr
	LabelValue.TextColor = clr
	LabelIcon.TextColor = clr
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
#if B4J
Private Sub LabelIcon_MouseClicked(EventData As MouseEvent)
	LabelIcon_Click
End Sub
#End If

' B4X - use click only
Private Sub LabelIcon_Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSub(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
