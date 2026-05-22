B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:			HMITileTrend.bas
' Brief:    	CustomView HMITile with a title & mini trend chart (sparkline).
' Date:			2026-05-19
' Author:		Robert W.B. Linn (c) 2025 MIT
' Description:	HMITileTrend displays a mini trend line.
'				Mini trends are used to answer:
'					-Is it rising?
'					-Is it stable?
'					-Is it oscillating?
'					-Did it spike?
'				Numeric values are shown:
'					-Next To the trend
'					-above the trend
'					-in another tile
'					-on selection / faceplate
'					-They are rarely embedded inside a mini-trend.
'				The trend tile Is a rendering component only.
'				Data management (buffering, scaling strategy, persistence) Is intentionally kept outside the tile to maintain separation of concerns.
'				-Separation of: Process data, Presentation, Predictable UI behavior
'				-No hidden state in visual objects
'				-External data + stateless tile = correct
'				Avoid mixing numeric readouts with trends in constrained spaces.
'				- Numbers require precise reading
'				- Trends are For pattern recognition
'				- Combining both in small tiles:
'					-increases cognitive load.
'					-reduces legibility.
'					-encourages "value hunting" instead "trend awareness".
'					-120×120px tile is very constrained.
' Layout:
'				+------------------+
'				|       Title      |  	<< 25%
'				|       Trend      |	<< 70% 
'				|       Graph      |  
'				+------------------+
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 			DisplayName: Title, 		FieldType: String,	DefaultValue: Trend
#DesignerProperty: Key: Unit, 			DisplayName: Unit, 			FieldType: String, 	DefaultValue: Unit
#DesignerProperty: Key: ShowBorder,		DisplayName: Show Border,	FieldType: Boolean, DefaultValue: True, Description: Show the chart with border.
#DesignerProperty: Key: AutoScale,		DisplayName: Auto Scale,	FieldType: Boolean, DefaultValue: True, Description: Wheter to set the scale to frozen or autoscale.
#DesignerProperty: Key: ScaleMin,		DisplayName: Scale Min,		FieldType: Float, 	DefaultValue: 0, 	Description: Min scale for non auto scale mode.
#DesignerProperty: Key: ScaleMax,		DisplayName: Scale Max,		FieldType: Float, 	DefaultValue: 100, 	Description: Max scale for non auto scale mode.
#DesignerProperty: Key: DataPoints,		DisplayName: Datapoints,	FieldType: Int, 	DefaultValue: 0,	Description: Max number of data points (0=no limit).

' Events
#Event: Click

Private Sub Class_Globals
	
	' Events
	Private mEventName As String		'ignore
	Private mCallBack As Object			'ignore

	' Base Views
	Public BasePane As B4XView
	Private BaseLabel As B4XView		'ignore
	Public Tag As Object

	' UI
	Private xui As XUI
	Private LabelTitle As B4XView
	Private PaneChart As B4XView

	' Deisgner Properties
	Private mTitle As String
	Private mUnit As String
	Private mShowBorder As Boolean
	Private mAutoScale As Boolean
	Private mScaleMin As Float
	Private mScaleMax As Float
	Private mDataPoints As Int

	' Designer Class
	Private mStatus As String
	
	' Chart
	Private mChartCanvas As B4XCanvas
	Private mIsChartCanvasInitialized As Boolean = False
	Private mChartRect As B4XRect
	Private mGridLineColor As Int = HMITileUtils.COLOR_TREND_GRID_LINE

	Type PointData (X As Float, Y As Float)
	Private mData As List
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
	mData.Initialize
End Sub

Private Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitiletrend")

	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mUnit			= Props.Get("Unit")
	' LabelUnit.Text 	= mUnit
	mShowBorder		= Props.GetDefault("ShowBorder", True)
	mAutoScale		= Props.GetDefault("AutoScale", True)
	mScaleMin		= Props.GetDefault("ScaleMin", 0)
	mScaleMax		= Props.GetDefault("ScaleMax", 100)
	mDataPoints		= Props.GetDefault("DataPoints", 0)

	PaneChart.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	ApplyStatusStyle(HMITileUtils.STATUS_NORMAL)
	Base_Resize(BasePane.Width, BasePane.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return
	'                            d  l  t            w      h
	LabelTitle.SetLayoutAnimated(0, 0, 0,         Width, Height * 0.25)

	Dim pad As Int = 4
	PaneChart.SetLayoutAnimated (0, _
								 pad, _ 
								 (Height * 0.25) + pad, _
								 Width - (pad * 2), _
								 (Height * 0.70) - (pad * 2))

	' Chart
	' Init the canvas holding the chart usig the pane chart - after panechart layout set
	If Not(mIsChartCanvasInitialized) Then
		mChartCanvas.Initialize(PaneChart)
		mIsChartCanvasInitialized = True
	End If
	mChartRect.Initialize(0, 0, PaneChart.Width, PaneChart.Height)
	DrawChart
End Sub

' ================================================================
' CHART
' ================================================================

' DrawChart
' Draw the chart using the internal data buffer
' Notes:
' The chart rectangle is set in Base_Resize, like left=4.0, top=34.0, right=116.0, bottom=116.0
Private Sub DrawChart
	Dim padV As Float		= 4dip
	Dim padH As Float		= 2dip
	Dim usableH As Float	= PaneChart.Height - (padV * 2)
	Dim usableW As Float	= PaneChart.Width - (padH * 2)

	' Validation & Setup
	If Not(PaneChart.IsInitialized) Or PaneChart.Width <= 0 Or PaneChart.Height <= 0 Then Return
	If mData.IsInitialized = False Or mData.Size < 2 Then Return

	' DO NOT USE THIS IN B4A
	#if B4J
	PaneChart.Color = xui.Color_Transparent
	#End If

	' Clear Canvas & Background
	mChartCanvas.ClearRect(mChartRect)
	
	' Chart background 
	' mChartCanvas.DrawRect(mChartRect, HMITileUtils.COLOR_TREND_BACKGROUND, True, 0dip)

	If mShowBorder Then
		mChartCanvas.DrawRect(mChartRect, HMITileUtils.COLOR_BORDER_DARK, False, 1dip)
	End If
	
	Dim gridLevels() As Float = Array As Float(0.33, 0.66)
	
	For Each glevel In gridLevels
		Dim gridY As Float = padV + (usableH * (1 - glevel))
		mChartCanvas.DrawLine(padH, gridY, PaneChart.Width - padH, gridY, mGridLineColor, 1dip)
	Next

	' Scale Calculation
	Dim vMin, vMax As Float
	If Not(mAutoScale) Then
		vMin = mScaleMin
		vMax = mScaleMax
	Else
		vMin = mData.Get(0)
		vMax = vMin
		For Each v As Float In mData
			vMin = Min(vMin, v)
			vMax = Max(vMax, v)
		Next
	End If
    
	' Prevent divide-by-zero
	If vMax = vMin Then vMax = vMin + 1

	' Geometry & Padding
	' padV: Prevents clipping at top/bottom. padH: Prevents clipping at sides.
	Dim count As Int = mData.Size

	' Generate Raw Points
	Dim RawPoints As List
	RawPoints.Initialize
	For i = 0 To count - 1
		Dim value As Float = mData.Get(i)
		Dim norm As Float = (value - vMin) / (vMax - vMin)
		norm = Max(0, Min(1, norm))
        
		Dim p As PointData
		' X is distributed across usable width
		p.X = padH + (i * (usableW / (count - 1)))
		' Y is inverted (B4X 0 is top) and kept within usable height
		p.Y = padV + usableH - (norm * usableH)
		RawPoints.Add(p)
	Next

	' Apply Smoothing (Chaikin Algorithm)
	' Two iterations provide a very high-quality "organic" curve
	Dim FinalPoints As List = SmoothPoints(RawPoints)
	FinalPoints = SmoothPoints(FinalPoints)

	' Final Draw
	For i = 1 To FinalPoints.Size - 1
		Dim pStart As PointData = FinalPoints.Get(i - 1)
		Dim pEnd As PointData = FinalPoints.Get(i)
		mChartCanvas.DrawLine(pStart.X, pStart.Y, pEnd.X, pEnd.Y, HMITileUtils.COLOR_TREND_LINE, 2dip)
	Next

	mChartCanvas.Invalidate
End Sub

' Helper: Smooths out the "Z" sharp corners
Private Sub SmoothPoints(Points As List) As List
	Dim Smoothed As List
	Smoothed.Initialize
	If Points.Size < 3 Then Return Points
    
	Smoothed.Add(Points.Get(0))
	For i = 0 To Points.Size - 2
		Dim p0 As PointData = Points.Get(i)
		Dim p1 As PointData = Points.Get(i + 1)
        
		Dim q, r As PointData
		' Point Q at 25% of segment
		q.X = p0.X * 0.75 + p1.X * 0.25
		q.Y = p0.Y * 0.75 + p1.Y * 0.25
		' Point R at 75% of segment
		r.X = p0.X * 0.25 + p1.X * 0.75
		r.Y = p0.Y * 0.25 + p1.Y * 0.75
        
		Smoothed.Add(q)
		Smoothed.Add(r)
	Next
	Smoothed.Add(Points.Get(Points.Size - 1))
	Return Smoothed
End Sub

' ===================================================================
' Public API
' ===================================================================

' UpdateChart
' Update the chart with data points array.
' Parameters:
' 	data List - Number of datapoints
' Notes:
' The chart rectangle is set in Base_Resize, like left=4.0, top=34.0, right=116.0, bottom=116.0
Public Sub UpdateChart(data As List)
	' Check data
	If data.IsInitialized = False Or data.Size < 2 Then 
		Log($"[HMITileTrend.UpdateChart] No chart data."$)
		Return
	End If

	' Copy data to internal databuffer (classic loop)
	mData.clear
	For Each v As Float In data
		mData.Add(v)
	Next

	' Draw the chart
	DrawChart
End Sub

' ClearChart
' Clear the chart.
Private Sub ClearChart
	mChartCanvas.ClearRect(mChartRect)

	' --- Optional border
	If mShowBorder Then
		mChartCanvas.DrawRect(mChartRect, HMITileUtils.COLOR_TREND_BORDER, False, 1dip)
	End If
End Sub

' Clear
' Clear all datapoints
Public Sub Clear
	mData.Clear
	ClearChart
End Sub

' Add
' Add data point.
' Parameters:
'	v Float
Public Sub Add(v As Float)
	mData.Add(v)
	' Check limit
	If mDataPoints > 0 Then
		' If size exceeds limit then remove first data point
		If mData.Size > mDataPoints Then
			mData.RemoveAt(0)
		End If
	End If
	DrawChart
End Sub

' AddAll
' Add array of data points.
' Parameters:
'	v Float Array
Public Sub AddAll(v() As Float)
	mData.AddAll(v)
	DrawChart
End Sub

' Remove
' Remove data point.
' Parameters:
'	index 
Public Sub Remove(index As Int)
	If index >= 0 And index <= mData.Size - 1 Then
		mData.RemoveAt(index)
		DrawChart		
	End If
End Sub

' Size
' Size of the data buffer.
' Returns:
'	Int 
Public Sub Size As Int
	Return mData.Size
End Sub

' DataPoints
' List of data points (float).
' Returns:
'	List
Public Sub DataPoints As List
	Return mData
End Sub

Public Sub setTitle(text As String)
	LabelTitle.Text = text
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub SetTitleColorInfo
	LabelTitle.TextColor = HMITileUtils.COLOR_TEXT_INFO
End Sub

Public Sub setUnit(text As String)
	mUnit = text
End Sub
Public Sub getUnit As String
	Return mUnit
End Sub

Public Sub setGridLineColor(value As Int)
	mGridLineColor = value
	DrawChart
End Sub
Public Sub getGridLineColor As Int
	Return mGridLineColor
End Sub

' Convenience helpers
Public Sub StatusNormal(text As String)
	setStatus(HMITileUtils.STATUS_NORMAL)
End Sub

Public Sub StatusWarning(text As String)
	setStatus(HMITileUtils.STATUS_WARNING)
End Sub

Public Sub StatusAlarm(text As String)
	setStatus(HMITileUtils.STATUS_ALARM)
End Sub

Public Sub StatusDisabled(text As String)
	setStatus(HMITileUtils.STATUS_DISABLED)
End Sub

' Core property
Public Sub setStatus(value As String)
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
	' Trend
	PaneChart.Color = HMITileUtils.COLOR_BACKGROUND_SCREEN

	BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
#if B4J
Private Sub PaneChart_MouseClicked (EventData As MouseEvent)
	TileClick
End Sub
#End If

' B4A
Private Sub PaneChart_Click
	TileClick
End Sub

Private Sub TileClick
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
