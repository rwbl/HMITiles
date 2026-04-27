B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileLevelIndicatorIndicator.bas
' Brief:		CustomView HMITile generic visual level with a circle showing level percentage 0-100%.
'				Style can be set to Normal, Warning, Alarm or Dimmed.
' Date:			2026-04-26
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|       Title      |  	<< 25%
'				|       Level      |	<< 50%
'				|        CIRCLE       |  
'				| 	  Value Unit   |	<< 25%
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,		DisplayName: Title, 	FieldType: String,	DefaultValue: Level
#DesignerProperty: Key: Value, 		DisplayName: Value, 	FieldType: Float, 	DefaultValue: 0
#DesignerProperty: Key: Unit,  		DisplayName: Unit,  	FieldType: String, 	DefaultValue: 
#DesignerProperty: Key: Status, 	DisplayName: Status,	FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

' Events
#Event: Click (Value As Float)

Private Sub Class_Globals
	Private mEventName As String
	Private mCallBack As Object

	Public mBase As B4XView
	Public mLbl As B4XView

	Private xui As XUI
	Public Tag As Object

	' Views
	Private LabelTitle As B4XView
	Private PaneLevelIndicator As B4XView
	Private CvsLevelIndicator As B4XCanvas
	Private LabelValue As B4XView

	' Properties Designer
	Private mTitle As String
	Private mValue As Float
	Private mUnit As String
	Private mStatus As String

	' Properties Class
	Private mDigits As Int = 0
	Private mCx, mCy As Float
	Private mRadius As Float
	Private mBorderWidth As Int = 4dip
	Private mBorderColor As Int
	Private mBaseColor As Int
	Private mLevelColor As Int
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
	mBase.LoadLayout("hmitilelevelindicator")
	
	' Properties Designer
	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mValue			= Props.Get("Value")
	LabelValue.Text = mValue
	mUnit			= Props.Get("Unit")
	mStatus			= Props.Get("Status")

	' Properties Class
	mBorderColor 	= HMITileUtils.COLOR_BORDER_DEFAULT
	mBaseColor		= HMITileUtils.COLOR_SLIDER_TRACK
	mLevelColor		= HMITileUtils.COLOR_SLIDER_ACTIVE
	
	ApplyStatusStyle(mStatus)
	
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	LabelTitle.SetLayoutAnimated(0, pad, pad, Width - pad * 2, Height * 0.25)

	PaneLevelIndicator.SetLayoutAnimated(0, pad, Height * 0.25, Width - pad * 2, Height * 0.5)
	mCx 	= PaneLevelIndicator.Width / 2
	mCy 	= PaneLevelIndicator.Height / 2
	mRadius	= Min(mCx, mCy) * 0.8

	' Rebind canvas to PaneLevelIndicator
	CvsLevelIndicator.Initialize(PaneLevelIndicator)
				
	LabelValue.SetLayoutAnimated(0, pad, (Height*0.75) - pad, Width - pad * 2, Height * 0.25)
	
	setValue(mValue)
End Sub

' ===================================================================
' HELPER
' ===================================================================

' ReDraw
Private Sub Redraw
	If PaneLevelIndicator.IsInitialized Then
		DrawLevelIndicator
	End If
End Sub

' DrawLevelIndicator
' Draw the level indicator as a circle with level
Private Sub DrawLevelIndicator
	CvsLevelIndicator.ClearRect(CvsLevelIndicator.TargetRect)

	' Outer circle as border; not filled
	CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, mBorderColor, False, mBorderWidth)

	' Inner circle as base; filled
	CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, mBaseColor, True, 0)

	' Level calculation 0-100
	If mValue < 0 Then mValue = 0
	If mValue > 100 Then mValue = 100

	Dim h As Float = (mValue / 100) * (2 * mRadius)
	Dim topY As Float = mCy + mRadius - h

	' Create level rectangle
	Dim p As B4XPath
	p.Initialize(mCx - mRadius, topY)
	p.LineTo(mCx + mRadius, topY)
	p.LineTo(mCx + mRadius, mCy + mRadius)
	p.LineTo(mCx - mRadius, mCy + mRadius)
  
   	' Clip the path and draw the fill circle
	CvsLevelIndicator.ClipPath(p)
	Dim levelcolor As Int = mLevelColor
	If mValue == 0 Then levelcolor = mBaseColor
	CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, levelcolor, True, 0)
	CvsLevelIndicator.RemoveClip
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
		Redraw
		LabelValue.Text = $"${NumberFormat(mValue, 1, mDigits)}${IIf(mUnit.Length > 0, $" ${mUnit}"$, "")}"$
	End If
End Sub
Public Sub getValue As Float
	Return mValue
End Sub

Public Sub setUnit(unit As String)
	mUnit = unit
	LabelValue.Text = $"${mValue}${IIf(mUnit.Length > 0, $" ${mUnit}"$, "")}"$
End Sub
Public Sub getUnit As String
	Return LabelValue.Text
End Sub

' Get or set the base color (circle background)
Public Sub setBaseColor(value As Int)
	mBaseColor = value
	Redraw
End Sub
Public Sub getBaseColor As Int
	Return mBaseColor
End Sub

' Get or set the level color (circle foreground)
Public Sub setLevelColor(value As Int)
	mLevelColor = value
	Redraw
End Sub
Public Sub getLevelColor As Int
	Return mLevelColor
End Sub

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
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
	ApplyStatusStyle(value)
End Sub

Public Sub getStatus As String
	Return mStatus
End Sub

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

	Select status
		Case HMITileUtils.STATUS_NORMAL
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_NORMAL_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
			
		Case HMITileUtils.STATUS_WARNING
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_WARNING_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATUS_ALARM
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_ALARM_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATUS_DISABLED
			LabelTitle.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			LabelValue.TextColor = HMITileUtils.COLOR_TILE_DISABLED_TEXT
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND		
	End Select

	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)

'	' --- Bar ---
'	PaneBar.SetColorAndBorder( _
'        HMITileUtils.COLOR_SLIDER_TRACK, _
'        0dip, _
'        HMITileUtils.COLOR_SLIDER_TRACK, _
'        0dip)
'
'	' --- Fill ---
'	PaneFill.SetColorAndBorder( _
'        HMITileUtils.COLOR_SLIDER_ACTIVE, _
'        0dip, _
'        HMITileUtils.COLOR_SLIDER_ACTIVE, _
'        0dip)
End Sub
#End Region

#Region Events
#if B4J
Private Sub PaneLevelIndicator_MouseClicked (EventData As MouseEvent)
	Click
End Sub
#End If

#If B4A
Private Sub PaneLevelIndicator_Click
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
