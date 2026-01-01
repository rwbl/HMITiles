B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
' ================================================================
' File:			HMITileSeekBar
' Brief:		Custom SeekBar with optional tickmarks (horizontal/vertical).
' Date:			2025-12-17
' Author:		Robert W.B. Linn (c) 2025 MIT
' Description:	See brief.
' Supports:		See designer properties
'				Important: The bar width/hight and the ticks size/position depens on the thumb radius. Set as required.
' Credits:		Based upon the B4XSeekbar from the XUIViews library. Thanks for sharing.
' ================================================================

' Designer Properties

#DesignerProperty: Key: Title, 			DisplayName: Title, FieldType: String, DefaultValue: Title
#DesignerProperty: Key: Value, 			DisplayName: Value, FieldType: Int, DefaultValue: 50
#DesignerProperty: Key: Min, 			DisplayName: Minimum, FieldType: Int, DefaultValue: 0
#DesignerProperty: Key: Max, 			DisplayName: Maximum, FieldType: Int, DefaultValue: 100
#DesignerProperty: Key: Interval, 		DisplayName: Interval, FieldType: Int, DefaultValue: 1, Description: Interval stepping.
#DesignerProperty: Key: Unit, 			DisplayName: Unit, FieldType: String, DefaultValue: Unit
#DesignerProperty: Key: ColorBar, 		DisplayName: Color Bar, FieldType: Color, DefaultValue: 0xFFD0D0D0, Description: Track left/back.
#DesignerProperty: Key: ColorBarFill, 	DisplayName: Color Bar Fill, FieldType: Color, DefaultValue: 0xFFA8A8A8, Description: Track right/front.
#DesignerProperty: Key: ActiveBarWidth, DisplayName: Active Bar Width, FieldType: Int, DefaultValue: 6
#DesignerProperty: Key: InActiveBarWidth, DisplayName: Inactive Bar Width, FieldType: Int, DefaultValue: 3
#DesignerProperty: Key: ThumbRadius, DisplayName: Thumb Radius, FieldType: Int, DefaultValue: 8, Description: Thumb radius size if not pressed.
#DesignerProperty: Key: ThumbRadiusPressed, DisplayName: Thumb Radius Pressed, FieldType: Int, DefaultValue: 18, Description: Thumb radius size if pressed. This size is also used to set the bar left & right margin. If ticks not fit then increase.
#DesignerProperty: Key: ThumbColor, DisplayName: Thumb Color, FieldType: Color, DefaultValue: 0x58006AFF
#DesignerProperty: Key: ShowThumb, DisplayName: Show Thumb, FieldType: Boolean, DefaultValue: True
#DesignerProperty: Key: ShowTicks, DisplayName: Show Ticks, FieldType: Boolean, DefaultValue: False, Description: Tick marks with labels.
#DesignerProperty: Key: TickCount, DisplayName: Tick Count, FieldType: Int, DefaultValue: 5, Description: Default 5 - Min, 25%, 50%, 75%, Max.
#DesignerProperty: Key: TickValueColor, DisplayName: Tick Value Color, FieldType: Color, DefaultValue: 0xFF1E1E1E
#DesignerProperty: Key: Vertical, DisplayName: Vertical, FieldType: Boolean, DefaultValue: False, Description: Orientation vertical.
#DesignerProperty: Key: TouchStateChanged, DisplayName: Use TouchState, FieldType: Boolean, DefaultValue: False, Description: Use touchstate released to trigger event instead every value change.

' Events
#Event: ValueChanged (Value As Int)
#Event: TouchStateChanged (Pressed As Boolean)

Sub Class_Globals
	' Events
	Private mEventName As String
	Private mCallBack As Object

	' Base UI
	Private xui As XUI
	Public mBase As B4XView

	' Canvas
	Private CanvasSeekBar As B4XCanvas
	Private PaneSeekBar As B4XView

	' Touch
	Private TouchPanel As B4XView
	Private mTouchStateChanged As Boolean
	Private Pressed As Boolean

	' Title
	Private LabelTitle As B4XView
	Private LabelValue As B4XView
	Private LabelUnit As B4XView

	' Values
	Private mValue As Int
	Private mMinValue As Int
	Private mMaxValue As Int
	Private mInterval As Int = 1

	' Thumb
	' 6dip/3dip		- clean contrast without visual weight.
	' 8dip thumb	- safer For touch HMIs.
	' 18dip Pressed - clear feedback without being too large.
	Private mShowThumb As Boolean
	Private mThumbRadius As Int = 8dip     		' thumb size
	Private mThumbRadiusPressed As Int = 18dip	' pressed thumb
	Private mThumbColor As Int					' Thumb color if not touched

	' Bar
	Private mColorBar As Int					' Base color
	Private mColorBarFill As Int				' Color when thumb is moving

	' Layout
	Private mActiveBarWidth As Int
	Private mInActiveBarWidth As Int
	Private mVertical As Boolean
	Private mSize As Int

	' Tickmarks
	Private mShowTicks As Boolean
	Private mTickCount As Int
	Private mTickFontSize As Int
	Private mTickValueColor As Int		' Tick value color below the bar or left from the bar
End Sub

' ------------------------------------------------
Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

' ------------------------------------------------
Public Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	mBase.Tag = Me

	' Designer Properties
	mColorBar 			= xui.PaintOrColorToColor(Props.Get("ColorBar"))
	mColorBarFill 		= xui.PaintOrColorToColor(Props.Get("ColorBarFill"))
	mActiveBarWidth 	= Props.Get("ActiveBarWidth")
	mInActiveBarWidth 	= Props.Get("InActiveBarWidth")

	mTouchStateChanged 	= Props.Get("TouchStateChanged")

	mThumbRadius		= Props.Get("ThumbRadius")
	mThumbRadiusPressed	= Props.Get("ThumbRadiusPressed")
	mThumbColor			= xui.PaintOrColorToColor(Props.Get("ThumbColor"))
	mShowThumb			= Props.Get("ShowThumb")

	mShowTicks			= Props.Get("ShowTicks")
	mTickCount			= Props.Get("TickCount")
	mTickValueColor 	= xui.PaintOrColorToColor(Props.Get("TickValueColor"))
	#if B4A
	mTickFontSize		= HMITileUtils.TEXT_SIZE_LABEL
	#End If
	#if B4J
	mTickFontSize		= HMITileUtils.TEXT_SIZE_SMALL
	#End If
	mTickFontSize		= HMITileUtils.TEXT_SIZE_SMALL
	mInterval 			= Max(1, Props.GetDefault("Interval", 1))

	mMinValue 			= Props.Get("Min")
	mMaxValue 			= Props.Get("Max")
	mValue 				= Max(mMinValue, Min(mMaxValue, Props.Get("Value")))

	mVertical			= Props.Get("Vertical")

	' Init the canvas	
	PaneSeekBar = xui.CreatePanel("")
	mBase.AddView(PaneSeekBar, 0, 0, mBase.Width, mBase.Height)
	CanvasSeekBar.Initialize(PaneSeekBar)

	TouchPanel = xui.CreatePanel("TouchPanel")
	mBase.AddView(TouchPanel, 0, 0, mBase.Width, mBase.Height)

	If xui.IsB4A Then mThumbRadiusPressed = 20dip
	
	' Labels
	LabelTitle = CreateLabel
	mBase.AddView(LabelTitle, 0, 0, mBase.Width, mBase.Height)
	LabelValue = CreateLabel
	mBase.AddView(LabelValue, 0, 0, mBase.Width, mBase.Height)
	LabelUnit = CreateLabel
	mBase.AddView(LabelUnit, 0, 0, mBase.Width, mBase.Height)

	LabelTitle.Text		= Props.Get("Title")
	LabelValue.Text		= Props.Get("Value")
	LabelUnit.Text		= Props.Get("Unit")

	' First apply the style because used by Update	
	ApplyStyle
	Base_Resize(mBase.Width, mBase.Height)
End Sub

' ------------------------------------------------
Public Sub Base_Resize(Width As Double, Height As Double)

	If Not(LabelTitle.IsInitialized) Then
		Log($"[HMITileSeekBar.HorizontalBaseResize] Seekbar not ready."$)
		Return
	End If
	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	'								 d  l             t              w                h
	#If B4A
	LabelTitle.SetLayoutAnimated	(0, 0,            pad,           Width, Height * 0.25)
	LabelValue.SetLayoutAnimated	(0, 0,            Height * 0.25, Width, Height * 0.25)
	LabelUnit.SetLayoutAnimated		(0, 0,            Height * 0.80, Width, Height * 0.15)
	#End If

	#If B4J
	LabelTitle.SetLayoutAnimated	(0, 0,            pad,           Width, Height * 0.25)
	LabelValue.SetLayoutAnimated	(0, 0,            Height * 0.25, Width, Height * 0.25)
	LabelUnit.SetLayoutAnimated		(0, 0,            Height * 0.80, Width, Height * 0.10)
	#End If

	TouchPanel.SetLayoutAnimated(0, 0, 0, Width, Height)

	Update
End Sub

' ------------------------------------------------
' Redraws slider and tickmarks
'
Public Sub Update
	Dim x1,y1,x2,y2 As Float
	
	If mVertical Then
		mSize = mBase.Height - 2 * mThumbRadiusPressed
	Else
		mSize = mBase.Width - 2 * mThumbRadiusPressed
	End If

	' Clear the canvs rect
	CanvasSeekBar.ClearRect(CanvasSeekBar.TargetRect)

	' Check if size > 0
	If mSize <= 0 Then Return

	' Layout Orientation
	If Not(mVertical) Then 
		' Horizontal
		Dim y As Int = (mBase.Height / 2) + (HMITileUtils.PADDING * 2.5)
		Dim w As Int = mThumbRadiusPressed + (mValue - mMinValue) / (mMaxValue - mMinValue) * mSize

		' Draw left/back track x1,y1,x2,y2,color,strokewidth
		x1 = mThumbRadiusPressed
		y1 = y 
		x2 = w
		y2 = y
		CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorBar, mActiveBarWidth)

		' Draw right/front track
		x1 = w
		y1 = y
		x2 = mBase.Width - mThumbRadiusPressed
		y2 = y
		CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorBarFill, mInActiveBarWidth)
		
		' Draw thumb
		If mShowThumb Then
			CanvasSeekBar.DrawCircle(w, y, mThumbRadius, mColorBar, True, 0)
			If Pressed Then CanvasSeekBar.DrawCircle(w, y, mThumbRadiusPressed, mThumbColor, True, 0)
		End If
		
		' Draw tickmarks if enabled
		If mShowTicks And mTickCount > 1 Then
			For i = 0 To mTickCount - 1
				Dim xTick As Float = mThumbRadiusPressed + i * mSize / (mTickCount - 1)
				
				' Tick line
				x1 = xTick
				y1 = (mBase.Height / 2) + (HMITileUtils.PADDING * 2)
				x2 = xTick
				y2 = y1 + mActiveBarWidth
				If i = 0 Or i = mTickCount - 1 Then
					y1 = y1 - (mActiveBarWidth / 2)
				End If
				CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorBar, 1dip)
				
				' Tick label below tick
				#if B4A
				Dim fnt As B4XFont = xui.CreateDefaultFont(mTickFontSize + 4dip)
				#End If
				#if B4J
				Dim fnt As B4XFont = xui.CreateDefaultFont(mTickFontSize)
				#End If
				Dim tickVal As Int = mMinValue + i * (mMaxValue - mMinValue) / (mTickCount - 1)
				x1 = xTick
				#if B4A
				y1 = y2	+ fnt.Size + 6dip				
				#End If
				#if B4J
				y1 = y2	+ fnt.Size ' y + 16dip + 6dip				
				#End If
				CanvasSeekBar.DrawText(tickVal, x1, y1, fnt, mTickValueColor, "CENTER")
			Next
		End If
	Else 
		' Vertical
		Dim x As Int	= mBase.Width / 2
		Dim s1 As Int	= mThumbRadiusPressed + (mMaxValue - mValue) / (mMaxValue - mMinValue) * mSize	'ignore
		Dim dy As Float

		x1 = x 
		y1 = mBase.Height * 0.5
		x2 = x1
		y2 = mBase.Height * 0.8
		dy = y2 - y1

		' Draw bottom/back track
		CanvasSeekBar.DrawLine(x1,y1,x2,y2, mColorBarFill, mInActiveBarWidth)
		'CanvasSeekBar.DrawLine(x, mThumbRadiusPressed, x, s1, mColorBarFill, mInActiveBarWidth)

		' Draw top/front track
		Dim df As Float	= mValue / (mMaxValue - mMinValue)
		x1 = x 
		y1 = y2 - ((y2 - y1) * df)
		x2 = x1
		y2 = y2
		CanvasSeekBar.DrawLine(x1,y1,x2,y2, mColorBar, mActiveBarWidth)
		' CanvasSeekBar.DrawLine(x, s1, x, mBase.Height - mThumbRadiusPressed, mColorBar, mActiveBarWidth)

		' Draw thumb
		If mShowThumb Then
			CanvasSeekBar.DrawCircle(x, y1, mThumbRadius, mColorBar, True, 0)
			If Pressed Then CanvasSeekBar.DrawCircle(x, y1, mThumbRadiusPressed, mThumbColor, True, 0)
		End If
		
		' Draw tickmarks if enabled
		Dim yTick As Float
		Dim x2Tick As Float
		Dim dyTick As Float = (dy / mTickCount) + 2

		If mShowTicks And mTickCount > 1 Then
			For i = 0 To mTickCount - 1
				yTick = (mBase.Height * 0.5) + i * dyTick
				' yTick = mThumbRadiusPressed + i * mSize / (mTickCount - 1)
				
				' Tick line
				x2Tick = x - (mInActiveBarWidth / 2)
				If i = 0 Or i = mTickCount - 1 Then x2Tick = x + (mInActiveBarWidth / 2)
				CanvasSeekBar.DrawLine(x - (mInActiveBarWidth/2) - 4dip, yTick, x2Tick, yTick, mColorBar, 1dip)
				' CanvasSeekBar.DrawLine(x - mInActiveBarWidth, yTick, x2Tick, yTick, mColorBar, 1dip)

				' Tick label left of tick
				Dim tickVal As Int = mMaxValue - i * (mMaxValue - mMinValue) / (mTickCount - 1)
				CanvasSeekBar.DrawText(tickVal, x - (mInActiveBarWidth/2) - 8dip, yTick + 4dip, xui.CreateDefaultFont(mTickFontSize), mTickValueColor, "RIGHT")
			Next
		End If
	End If

	CanvasSeekBar.Invalidate

	LabelValue.Text	= mValue
End Sub

' ================================================================
' PUBLIC API
' ================================================================
#Region Public API
Public Sub setTitle(title As String)
	LabelTitle.Text = title
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub setUnit(unit As String)
	LabelUnit.Text = unit
End Sub
Public Sub getUnit As String
	Return LabelUnit.Text
End Sub

' Get / set the bar base color.
' Parameters:
'	clr Int - Bar XUI color.
Public Sub setColorBar(clr As Int)
	mColorBar = clr
	Update
End Sub
Public Sub getColorBar As Int
	Return mColorBar
End Sub

' Get / set the bar color when thumb is moving.
' Parameters:
'	clr Int - Bar XUI color.
Public Sub setColorBarFill(clr As Int)
	mColorBarFill = clr
	Update
End Sub
Public Sub getColorBarFill As Int
	Return mColorBar
End Sub

' Get / set the active bar width.
' Parameters:
'	width Int - Active bar width
Public Sub setActiveBarWidth(width As Int)
	If width < 0 Then width = 0
	If width > mBase.Width Then width = mBase.Width
	mActiveBarWidth = width
	Update
End Sub
Public Sub getActiveBarWidth As Int
	Return mActiveBarWidth
End Sub

' Get / set the inactive bar width.
' Parameters:
'	width Int - Inactive bar width
Public Sub setInActiveBarWidth(width As Int)
	If width < 0 Then width = 0
	If width > mBase.Width Then width = mBase.Width
	mInActiveBarWidth = width
	Update
End Sub
Public Sub getInActiveBarWidth As Int
	Return mInActiveBarWidth
End Sub

' Get / set the thumb radius.
' Parameters:
'	width Int - Thumb radius
Public Sub setThumbRadius(width As Int)
	If width < 0 Then width = 0
	If width > mBase.Width Then width = mBase.Width
	mThumbRadius = width
	Update
End Sub
Public Sub getThumbRadius As Int
	Return mThumbRadius
End Sub

' Get / set the thumb radius pressed.
' Parameters:
'	width Int - Thumb radius pressed
Public Sub setThumbRadiusPressed(width As Int)
	If width < 0 Then width = 0
	If width > mBase.Width Then width = mBase.Width
	mThumbRadiusPressed = width
	Update
End Sub
Public Sub getThumbRadiusPressed As Int
	Return mThumbRadiusPressed
End Sub

' Get / set the thumb color.
' Parameters:
'	clr Int - Thumb XUI color.
Public Sub setThumbColor(clr As Int)
	mThumbColor = clr
	Update
End Sub
Public Sub getThumbColor As Int
	Return mThumbColor
End Sub

' Get / set the thumb visibility.
' Parameters:
'	state Boolean - Visible (True), Hidden (False)
Public Sub setShowThumb(state As Boolean)
	mShowThumb = state
	Update
End Sub
Public Sub getShowThumb As Boolean
	Return mShowThumb
End Sub

' Get / set the ticks visibility.
' Parameters:
'	state Boolean - Visible (True), Hidden (False)
Public Sub setShowTicks(state As Boolean)
	mShowTicks = state
	Update
End Sub
Public Sub getShowTicks As Boolean
	Return mShowTicks
End Sub

' Get / set the tick count.
' Parameters:
'	count Int - Number of ticks.
Public Sub setTickCount(count As Int)
	If count < 0 Then count = 0
	mTickCount = count
	Update
End Sub
Public Sub getTickCount As Int
	Return mTickCount
End Sub

' Get / set the tick value color.
' Parameters:
'	clr Int - Tick value XUI color.
Public Sub setTickValueColor(clr As Int)
	mTickValueColor = clr
	Update
End Sub
Public Sub getTickValueColor As Int
	Return mTickValueColor
End Sub

' Get / set the interval when bar is moving.
' Parameters:
'	interval Int - Interval.
Public Sub setInterval(interval As Int)
	mInterval = interval
	Update
End Sub
Public Sub getInterval As Int
	Return mInterval
End Sub

' Get / set the bar value.
' Parameters:
'	v Int - Bar value. Must be in min / max range.
Public Sub setValue(v As Int)
	mValue = Max(mMinValue, Min(mMaxValue, v))
	Update
End Sub
Public Sub getValue As Int
	Return mValue
End Sub

' Get / set the bar minvalue.
' Parameters:
'	v Int - Bar min value.
Public Sub setMinValue(v As Int)
	mMinValue = v
	Update
End Sub
Public Sub getMinValue As Int
	Return mMinValue
End Sub

' Get / set the bar maxvalue.
' Parameters:
'	v Int - Bar max value.
Public Sub setMaxValue(v As Int)
	mMaxValue = v
	Update
End Sub
Public Sub getMaxValue As Int
	Return mMaxValue
End Sub

' Get / set the bar enabled.
' Parameters:
'	state Boolean - Enabled (True), Disabled (False)
Public Sub setEnabled(state As Boolean)
	mBase.Enabled = state
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

' NOT USED = mus be set in the designer properties
' Get / set the bar orientation.
' Parameters:
'	state Boolean - Vertical (True), Horizontal (False)
Public Sub setVertical(state As Boolean)
	mVertical = state
	Update
End Sub
Public Sub getVertical As Boolean
	Return mVertical
End Sub
#End Region

' ================================================================
' UI VIEWS
' ================================================================

Private Sub CreateLabel As B4XView
	Dim lblx As B4XView = XUIViewsUtils.CreateLabel
	lblx.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_STATE)
	lblx.Text = "LABEL"
	lblx.SetTextAlignment("CENTER", "CENTER")
	lblx.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY

	Return lblx
End Sub

' ================================================================
' TILE STYLING
' ================================================================
' ApplyStyle
' Apply style Normal.
Private Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelValue)
	#if B4J
	CSSUtils.SetStyleProperty(LabelValue, "-fx-font-size", HMITileUtils.TEXT_SIZE_STATE)
	#end if
	HMITileUtils.ApplyUnitStyle(LabelUnit)
	#if B4J
	CSSUtils.SetStyleProperty(LabelUnit, "-fx-font-size", HMITileUtils.TEXT_SIZE_SMALL)
	#end if
	
	mColorBar 		= HMITileUtils.COLOR_SLIDER_ACTIVE
	mColorBarFill 	= HMITileUtils.COLOR_SLIDER_TRACK
	mThumbColor 	= HMITileUtils.COLOR_SLIDER_KNOB
	mTickValueColor	= HMITileUtils.COLOR_SLIDER_LABEL_TEXT

	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub

' ================================================================
' EVENTS
' ================================================================
#Region Events
Private Sub TouchPanel_Touch(Action As Int, X As Float, Y As Float)
	If Action = TouchPanel.TOUCH_ACTION_DOWN Then
		Pressed = True
		RaiseTouchStateEvent
		SetValueBasedOnTouch(X, Y)
	Else If Action = TouchPanel.TOUCH_ACTION_MOVE Then
		SetValueBasedOnTouch(X, Y)
	Else If Action = TouchPanel.TOUCH_ACTION_UP Then
		Pressed = False
		RaiseTouchStateEvent
		If Not(mTouchStateChanged) Then
			If xui.SubExists(mCallBack, mEventName & "_ValueChanged", 1) Then
				CallSubDelayed2(mCallBack, mEventName & "_ValueChanged", mValue)
			End If
		End If
	End If
	Update
End Sub

Private Sub RaiseTouchStateEvent
	If xui.SubExists(mCallBack, mEventName & "_TouchStateChanged", 1) Then
		CallSubDelayed2(mCallBack, mEventName & "_TouchStateChanged", Pressed)
	End If
End Sub

Private Sub SetValueBasedOnTouch(x As Int, y As Int)
	Dim v As Int
	If mVertical Then
		v = (mBase.Height - mThumbRadiusPressed - y) / mSize * (mMaxValue - mMinValue) + mMinValue
	Else
		v = (x - mThumbRadiusPressed) / mSize * (mMaxValue - mMinValue) + mMinValue
	End If
	v = Round(v / mInterval) * mInterval
	Dim NewValue As Int = Max(mMinValue, Min(mMaxValue, v))
	If NewValue <> mValue Then
		mValue = NewValue
		If xui.SubExists(mCallBack, mEventName & "_ValueChanged", 1) Then
			If mTouchStateChanged Then
				CallSubDelayed2(mCallBack, mEventName & "_ValueChanged", mValue)
			End If
		End If
	End If
End Sub
#End Region
