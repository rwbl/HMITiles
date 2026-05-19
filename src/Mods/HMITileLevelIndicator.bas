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
' Date:			2026-05-18
' Author:		Robert W.B. Linn (c) 2025 MIT
' Description:	This tile works well for: level tanks, process vessels, analog indicators
'				Style can be set to Normal, Warning, Alarm.
' Layout:
'				+------------------+
'				|       Title      |  	< 25%
'				|       Level      |	< 40%
'				| 	    Value      |	< 35%
'				| 	    Unit       |	< 15%
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,		DisplayName: Title, 	FieldType: String,	DefaultValue: Level
#DesignerProperty: Key: Value, 		DisplayName: Value, 	FieldType: Float, 	DefaultValue: 0
#DesignerProperty: Key: Unit,  		DisplayName: Unit,  	FieldType: String, 	DefaultValue: 
#DesignerProperty: Key: Status, 	DisplayName: Status,	FieldType: String,	List: Normal|Warning|Alarm, DefaultValue: Normal

' Events
#Event: Click (Value As Float)

Private Sub Class_Globals
	Private mEventName As String
	Private mCallBack As Object

	Public BasePane As B4XView
	Public BaseLabel As B4XView

	Private xui As XUI
	Public Tag As Object

	' Views
	Private LabelTitle As B4XView
	Private PaneLevelIndicator As B4XView
	Private CvsLevelIndicator As B4XCanvas
	Private LabelValue As B4XView
	Private LabelUnit As B4XView

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
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Private  Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilelevelindicator")
	
	' Properties Designer
	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mValue			= Props.Get("Value")
	LabelValue.Text = mValue
	mUnit			= Props.Get("Unit")
	LabelUnit.Text 	= mUnit
	mStatus			= Props.Get("Status")

	' Properties Class

	ApplyStyle	
	Base_Resize(BasePane.Width, BasePane.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelValue.IsInitialized) Then Return

	'								 		 d  l  t              	w       h
	LabelTitle.SetLayoutAnimated			(0, 0, 0, 				Width, 	Height * 0.25)
	PaneLevelIndicator.SetLayoutAnimated	(0, 0, Height * 0.25, 	Width, 	Height * 0.40)
	LabelValue.SetLayoutAnimated			(0, 0, Height * 0.55, 	Width, 	Height * 0.35)
	LabelUnit.SetLayoutAnimated				(0, 0, Height * 0.80,	Width,	Height * 0.15)

	mCx 	= PaneLevelIndicator.Width / 2
	mCy 	= PaneLevelIndicator.Height / 2.75 + 5dip
	mRadius	= Min(mCx, mCy) * 0.9

	' Rebind canvas to PaneLevelIndicator
	CvsLevelIndicator.Initialize(PaneLevelIndicator)
End Sub

' ===================================================================
' DRAW
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
	CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, HMITileUtils.COLOR_BORDER_DEFAULT, False, mBorderWidth)

	' Inner circle as base; filled
	CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, HMITileUtils.COLOR_INDICATOR_TRACK, True, 0)

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
	CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, HMITileUtils.COLOR_INDICATOR_LEVEL, True, 0)
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
		LabelValue.Text = NumberFormat(mValue, 1, mDigits)
	End If
End Sub
Public Sub getValue As Float
	Return mValue
End Sub

Public Sub setUnit(unit As String)
	mUnit = unit
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
	HMITileUtils.ApplyValueStyle(LabelValue)
	HMITileUtils.ApplyUnitStyle(LabelUnit)
	HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle, mStatus)
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
