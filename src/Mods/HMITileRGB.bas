B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileRGB.bas
' Brief:		CustomView HMITile to select RGB values (0..255), using seekbar with live color preview.
' Date:			2025-12-25
' Author:		Robert W.B. Linn (c) 2025 MIT
' Hints: 		HMITile can not be resized after form loaded.
' Layout:
'				Vertical
'				+-----+
'				|+-T-+|	< Label Title
'				|+---+|
'				|+RGB+|	< B4XSeekbar set color R,G,B
'				|+---+|
'				|+-P-+|	< Pane Preview
'				+-----+
'				Horizontal
'				+-----+
'				|+-T-+|	< Label Title
'				|+---+|
'				|+-R-+|	< B4XSeekbar set color R
'				|+-G-+|	< B4XSeekbar set color G
'				|+-B-+|	< B4XSeekbar set color B
'				|+---+|
'				|+-P-+|	< Pane Preview
'				+-----+
' ================================================================
#End Region

' Properties
#DesignerProperty: Key: Title, DisplayName: Title, FieldType: String, DefaultValue: Title
#DesignerProperty: Key: Vertical, DisplayName: Orientation Vertical, FieldType: Boolean, DefaultValue: False
#DesignerProperty: Key: TouchStateChanged, DisplayName: Use TouchState, FieldType: Boolean, DefaultValue: False, Description: Use touchstate released to trigger event instead every value change.

' Events
#Event: ValueChanged (m As Map)

Private Sub Class_Globals
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base
	Public mBase As B4XView
	Private mLbl As B4XView						'ignore as not used
	Public Tag As Object

	' UI
	Private xui As XUI
	Private LabelTitle As B4XView
	Private PanePreview As B4XView
	Private B4XSeekBarRed As B4XSeekBar
    Private B4XSeekBarGreen As B4XSeekBar
    Private B4XSeekBarBlue As B4XSeekBar
    Private LabelValueRed As B4XView
    Private LabelValueGreen As B4XView
    Private LabelValueBlue As B4XView

	' Designer properties
	Private mVertical As Boolean
	Private mTouchStateChanged As Boolean
	
	' Class locals
	Private mR, mG, mB As Int
	Dim mPad As Int 
	Dim mPreviewHeight As Double
	Dim mPreviewHeightFactor As Double = 0.05
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
    mCallBack = Callback
    mEventName = EventName
End Sub

Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitilergb")

	LabelTitle.Text		= Props.Get("Title")
	mVertical 			= Props.Get("Vertical")
	mTouchStateChanged 	= Props.Get("TouchStateChanged")
	Dim mPad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING
	
	' Default values
	B4XSeekBarRed.Value = 0
	B4XSeekBarGreen.Value = 0
	B4XSeekBarBlue.Value = 0

	B4XSeekBarRed.Size1 = 5dip
	B4XSeekBarRed.Size2 = 5dip
	B4XSeekBarGreen.Size1 = 5dip
	B4XSeekBarGreen.Size2 = 5dip
	B4XSeekBarBlue.Size1 = 5dip
	B4XSeekBarBlue.Size2 = 5dip
	
	' Set the label value text color to gray
	LabelValueRed.TextColor = HMITileUtils.COLOR_TEXT_SECONDARY
	LabelValueGreen.TextColor = HMITileUtils.COLOR_TEXT_SECONDARY
	LabelValueBlue.TextColor = HMITileUtils.COLOR_TEXT_SECONDARY

	ApplyStyle
	
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return
	
	If mVertical Then
		VerticalBaseResize (Width, Height)
	Else
		HorizontalBaseResize (Width, Height)
	End If
End Sub

Private Sub VerticalBaseResize(Width As Double, Height As Double)
	mPreviewHeight = Height * mPreviewHeightFactor

	' --- Title Label ---
	LabelTitle.SetLayoutAnimated(0, mPad, mPad, Width - mPad*2, Height * 0.25)

	' --- Preview Pane ---
	Dim y As Double = Height - mPreviewHeight - (mPad * 0.75)
	PanePreview.SetLayoutAnimated(0, mPad * 2, y, Width - mPad * 4, mPreviewHeight)

	' --- Sliders area between title and preview ---
	Dim slidersTop As Double = Height * 0.15	
	Dim slidersHeight As Double = Height * 0.75	
	
	' Three equal columns: R G B
	Dim colW As Double = Width / 3

	VerticalLayoutSliderColumn(B4XSeekBarRed,   LabelValueRed,   0 * colW, colW, slidersTop, slidersHeight)
	VerticalLayoutSliderColumn(B4XSeekBarGreen, LabelValueGreen, 1 * colW, colW, slidersTop, slidersHeight)
	VerticalLayoutSliderColumn(B4XSeekBarBlue,  LabelValueBlue,  2 * colW, colW, slidersTop, slidersHeight)

	UpdateUI
End Sub

Private Sub VerticalLayoutSliderColumn(Bar As B4XSeekBar, ValueLabel As B4XView, Left As Double, ColumnWidth As Double, Top As Double, ColumnHeight As Double)
	Dim valueLabelH As Int	= ValueLabel.Height

	' ----- Value Label (numeric) -----
	ValueLabel.TextSize = HMITileUtils.TEXT_SIZE_TINY
	ValueLabel.SetLayoutAnimated(0, Left + mPad, Top + mPad, ColumnWidth - mPad *2, valueLabelH)

	' ----- Vertical Slider -----
	Dim sliderTop As Int = Top + ColumnHeight * 0.35 	' + padding + valueLabelH + padding
	Dim sliderHeight As Int = ColumnHeight * 0.6 		' - valueLabelH + padding

	Bar.mBase.SetLayoutAnimated(0, Left + mPad, sliderTop, ColumnWidth - mPad * 2, sliderHeight)
	Bar.Radius2 = Bar.Radius1 * 1.2
End Sub
#End Region

#Region HorizontalBaseResize
Private Sub HorizontalBaseResize(Width As Double, Height As Double)
    If Not(B4XSeekBarRed.IsInitialized) Then Return

	mPreviewHeight = Height * mPreviewHeightFactor
	Dim rowH As Double = ((Height - mPreviewHeight) / 3) * 0.7

	' --- Title Label ---
	LabelTitle.SetLayoutAnimated(0, mPad, mPad, Width - mPad * 2, Height * 0.25)

	' --- Preview Pane ---
	Dim y As Double = Height - mPreviewHeight - (mPad * 0.75)
	PanePreview.SetLayoutAnimated(0, mPad * 2, y, Width - mPad * 4, mPreviewHeight)

    ' --- Row 1: Red ---
    y = LabelTitle.Height
	HorizontalLayoutSliderRow(B4XSeekBarRed, LabelValueRed, y, rowH, Width)
    y = y + rowH

    ' --- Row 2: Green ---
	HorizontalLayoutSliderRow(B4XSeekBarGreen, LabelValueGreen, y, rowH, Width)
    y = y + rowH

    ' --- Row 3: Blue ---
	HorizontalLayoutSliderRow(B4XSeekBarBlue, LabelValueBlue, y, rowH, Width)

    UpdateUI
End Sub

Private Sub HorizontalLayoutSliderRow(Bar As B4XSeekBar, ValueLabel As B4XView, Top As Double, RowHeight As Double, Width As Double)
	Dim padding As Int = 4dip
	Dim labelW As Int = 30dip   		' right aligned numeric value
	Dim barW As Int = Width - labelW 	'- padding*2

	Bar.mBase.SetLayoutAnimated(0, padding, Top + padding, barW, RowHeight - padding*2)
	
	' Value Label
	ValueLabel.TextSize = HMITileUtils.TEXT_SIZE_TINY
	ValueLabel.SetLayoutAnimated(0, barW + padding, Top, labelW, RowHeight)
End Sub
#End Region

Private Sub UpdateUI
    mR = B4XSeekBarRed.Value
    mG = B4XSeekBarGreen.Value
    mB = B4XSeekBarBlue.Value

    LabelValueRed.Text = mR
    LabelValueGreen.Text = mG
    LabelValueBlue.Text = mB

    PanePreview.Color = xui.Color_RGB(mR, mG, mB)

	If Not(mTouchStateChanged) Then
		ValueChanged(mR, mG, mB)
	End If
End Sub

' Setters/getters
Public Sub setTitle(text As String)
	LabelTitle.Text = text
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub SetColor(r As Int, g As Int, b As Int)
	mR = CheckColor(r)
	mG = CheckColor(g)
	mB = CheckColor(b)
	ValueChanged(mR, mG, mB)
End Sub

Public Sub SetColorFromMap(m As Map)
	mR = m.Get("r")
	mG = m.Get("g")
	mB = m.Get("b")
	mR = CheckColor(mR)
	mG = CheckColor(mG)
	mB = CheckColor(mB)
	ValueChanged(mR, mG, mB)
End Sub

Public Sub getRed As Int
    Return mR
End Sub

Public Sub getGreen As Int
    Return mG
End Sub

Public Sub getBlue As Int
	Return mB
End Sub

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

#Region Styling
' ApplyStyle
' Apply style Normal.
Public Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
	ApplySeekbarColors
End Sub

Private Sub ApplySeekbarColors
	' RED
	B4XSeekBarRed.Color1 		= 0xAAFF0000
	B4XSeekBarRed.Color2 		= 0x44FF0000
	B4XSeekBarRed.ThumbColor 	= 0xFFFF0000

	' GREEN
	B4XSeekBarGreen.Color1 		= 0xAA00FF00
	B4XSeekBarGreen.Color2 		= 0x4400FF00
	B4XSeekBarGreen.ThumbColor 	= 0xFF00FF00

	' BLUE
	B4XSeekBarBlue.Color1 		= 0xAA0000FF
	B4XSeekBarBlue.Color2 		= 0x440000FF
	B4XSeekBarBlue.ThumbColor 	= 0xFF0000FF
End Sub
#End Region

#Region Events
' Seekbar value changes
' Update UI and trigger event.
Private Sub B4XSeekBarRed_ValueChanged (Value As Int)
	UpdateUI
End Sub

Private Sub B4XSeekBarGreen_ValueChanged (Value As Int)
	UpdateUI
End Sub

Private Sub B4XSeekBarBlue_ValueChanged (Value As Int)
	UpdateUI
End Sub

' Event triggered by seekbar value changes
Private Sub ValueChanged(R As Int, G As Int, B As Int)
	Dim m As Map = CreateMap("r":R, "g":G, "b":B)
	' Log($"[HMITileRGB.ValueChanged] ${m}, callback=${mCallBack}, eventname=${mEventName}"$)
	If SubExists(mCallBack, mEventName & "_ValueChanged") Then
		CallSub2(mCallBack, mEventName & "_ValueChanged", m)
	End If
End Sub

Private Sub B4XSeekBarRed_TouchStateChanged (Pressed As Boolean)
	If mTouchStateChanged Then
		If Not(Pressed) Then
			ValueChanged(mR, mG, mB)
		End If
	End If
End Sub

Private Sub B4XSeekBarGreen_TouchStateChanged (Pressed As Boolean)
	If mTouchStateChanged Then
		If Not(Pressed) Then
			ValueChanged(mR, mG, mB)
		End If
	End If
End Sub

Private Sub B4XSeekBarBlue_TouchStateChanged (Pressed As Boolean)
	If mTouchStateChanged Then
		If Not(Pressed) Then
			ValueChanged(mR, mG, mB)
		End If		
	End If
End Sub
#End Region

#Region Helper
' CheckColor
' Checks if a color is in range 0-255.
' Parameters:
'	value Int - Color value 0-255
' Returns
'	Int - value or 0 is out of range
Private Sub CheckColor(value As Int) As Int
	Return IIf(value >= 0 And value <= 255, value, 0)
End Sub

#End Region