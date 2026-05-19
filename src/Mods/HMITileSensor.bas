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
' Date:			2026-01-09
' Author:		Robert W.B. Linn (c) 2025 MIT
' Hints: 		HMITile can not be resized after form loaded.
' Layout:
'				+------------------+
'				|       Label      |  < 25%
'				|       Icon       |  < 20%
'				|       Value      |  < 35% 
'				|       Unit       |  < 15% 
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,	DisplayName: Title, FieldType: String, DefaultValue: Sensor
#DesignerProperty: Key: Value,	DisplayName: Value, FieldType: String, DefaultValue: --
#DesignerProperty: Key: Unit,	DisplayName: Unit,  FieldType: String, DefaultValue: 
#DesignerProperty: Key: Icon,	DisplayName: Icon (FontAwesome), FieldType: String, DefaultValue: , Description: Set "F043" or "f043" (without 0x) or real character.
#DesignerProperty: Key: Status, DisplayName: Status, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click

Private Sub Class_Globals
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base
	Public BasePane As B4XView
	Private BaseLabel As B4XView	'ignore
	Public Tag As Object

	' XUI
	Private xui As XUI

	' Views inside layout HMITileSensor
	Private LabelTitle As B4XView
	Private LabelIcon As B4XView
	Private LabelValue As B4XView
	Private LabelUnit As B4XView

	' Designer Properties
	Private mTitle As String
	Private mValue As String
	Private mUnit As String
	Private mStatus As String
	
	' Class Properties
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub


Private Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilesensor")

	' Store designer properties
	mTitle				= Props.Get("Title")
	LabelTitle.Text 	= mTitle
	LabelIcon.Text  	= Props.Get("Icon")
	' Check to remove 0x in case icon starts with
	If LabelIcon.Text.ToLowerCase.Contains("0x") Then
		LabelIcon.Text = LabelIcon.Text.ToLowerCase.Replace("0x","")
	End If
	' Ensure the font is set to FA
	setIcon(LabelIcon.Text)
	mValue				= Props.Get("Value")
	LabelValue.Text 	= mValue
	mUnit				= Props.Get("Unit")
	LabelUnit.Text		= mUnit
	mStatus				= Props.Get("Status")
	ApplyStyle
	Base_Resize(BasePane.Width, BasePane.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return
	
	'								 d  l    t              w       h
	LabelTitle.SetLayoutAnimated	(0, 0, 0,           	Width, 	Height * 0.25)
	LabelIcon.SetLayoutAnimated		(0, 0, Height * 0.25, 	Width, 	Height * 0.30)
	LabelValue.SetLayoutAnimated	(0, 0, Height * 0.55, 	Width, 	Height * 0.35)
	LabelUnit.SetLayoutAnimated  	(0, 0, Height * 0.80, 	Width,	Height * 0.15)
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
	mValue = value
	LabelValue.Text = mValue
End Sub
Public Sub getValue As String
	Return mValue
End Sub

Public Sub setUnit(unit As String)
	mUnit = unit
	LabelUnit.Text =  mUnit
End Sub
Public Sub getUnit As String
	Return mUnit
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
	mStatus = value
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
End Sub

Public Sub getStatus As String
	Return mStatus
End Sub

' ================================================================
' TILESTYLE
' ================================================================

#Region TileStyle
Private Sub ApplyStyle
	HMITileUtils.ApplyTileStyle(BasePane)
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyFontAwesomeStyle(LabelIcon)
	HMITileUtils.ApplyValueStyle(LabelValue)
	HMITileUtils.ApplyUnitStyle(LabelUnit)
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
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
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
