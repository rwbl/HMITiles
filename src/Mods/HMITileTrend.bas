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
' Date:			2026-04-23
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
#DesignerProperty: Key: Title, 			DisplayName: Title, FieldType: String, DefaultValue: Trend
#DesignerProperty: Key: Unit, 			DisplayName: Unit, FieldType: String, DefaultValue: Unit
#DesignerProperty: Key: ShowBorder,		DisplayName: Show Border, FieldType: Boolean, DefaultValue: True, Description: Show the chart with border.
#DesignerProperty: Key: AutoScale,		DisplayName: Auto Scale, FieldType: Boolean, DefaultValue: True, Description: Wheter to set the scale to frozen or autoscale.
#DesignerProperty: Key: ScaleMin,		DisplayName: Scale Min, FieldType: Float, DefaultValue: 0, Description: Min scale for non auto scale mode.
#DesignerProperty: Key: ScaleMax,		DisplayName: Scale Max, FieldType: Float, DefaultValue: 100, Description: Max scale for non auto scale mode.

' Events
' #Event: Click

Private Sub Class_Globals
	
	' Events
	Private mEventName As String		'ignore
	Private mCallBack As Object			'ignore

	' Base Views
	Public mBase As B4XView
	Private mLbl As B4XView				'ignore
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

	' Designer Class
	Private mStatus As String
	
	' Chart
	Private mChartCanvas As B4XCanvas
	Private mIsChartCanvasInitialized As Boolean = False
	Private mChartRect As B4XRect
	Private mData As List
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
	mData.Initialize
End Sub

Private Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)	'ignore
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitiletrend")

	mTitle			= Props.Get("Title")
	mUnit			= Props.Get("Unit")
	mShowBorder		= Props.GetDefault("ShowBorder", True)
	mAutoScale		= Props.GetDefault("AutoScale", True)
	mScaleMin		= Props.GetDefault("ScaleMin", 0)
	mScaleMax		= Props.GetDefault("ScaleMax", 100)
	LabelTitle.Text = mTitle

	ApplyStatusStyle(HMITileUtils.STATUS_NORMAL)
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return
	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	'                            d  l  t            w      h
	LabelTitle.SetLayoutAnimated(0, 0, pad,         Width, Height * 0.25)

	PaneChart.SetLayoutAnimated (0, _
								 HMITileUtils.PADDING, _ 
								 (Height * 0.25) + HMITileUtils.PADDING, _
								 Width - (HMITileUtils.PADDING * 2), _
								 (Height * 0.70) - (HMITileUtils.PADDING * 2))

	' Chart
	' Init the canvas holding the chart usig the pane chart - after panechart layout set
	If Not(mIsChartCanvasInitialized) Then
		mChartCanvas.Initialize(PaneChart)
		mIsChartCanvasInitialized = True
	End If
	mChartRect.Initialize(0, 0, PaneChart.Width, PaneChart.Height)
End Sub

' ================================================================
' CHART
' ================================================================

' DrawChart
' Draw the chart using the internal data buffer
' Notes:
' The chart rectangle is set in Base_Resize, like left=4.0, top=34.0, right=116.0, bottom=116.0
Private Sub DrawChart
	If Not(PaneChart.IsInitialized) Then
		Log("[HMITileTrend.DrawChart] Chart not ready yet.")
		Return
	End If
	
	' Ensure the chart width&height are set
	If PaneChart.Width <= 0 Or PaneChart.Height <= 0 Then
		Log("[HMITileTrend.DrawChart] Chart not ready yet.")
		Return
	End If

	' Check data
	If mData.IsInitialized = False Or mData.Size < 2 Then
		Log($"[HMITileTrend.DrawChart] No chart data."$)
		Return
	End If

	' Clear the chart
	mChartCanvas.ClearRect(mChartRect)
	mChartCanvas.DrawRect(mChartRect, HMITileUtils.COLOR_BACKGROUND_SCREEN, True, 0dip)

	' --- Optional border
	If mShowBorder Then
		mChartCanvas.DrawRect(mChartRect, HMITileUtils.COLOR_TREND_BORDER, False, 1dip)
	End If

	Dim vMin As Float
	Dim vMax As Float

	If Not(mAutoScale) Then
		vMin = mScaleMin
		vMax = mScaleMax
	Else
		vMin = mData.Get(0)
		vMax = vMin
		For Each v As Float In mData
			If v < vMin Then vMin = v
			If v > vMax Then vMax = v
		Next
		If vMax = vMin Then vMax = vMin + 1
	End If
	' Log($"[HMITileTrend.DrawChart] autoscale=${mAutoScale}, min=${vMin}, max=${vMax}"$)

	' Prevent flatline divide-by-zero
	If vMax = vMin Then
		vMax = vMin + 1
	End If

	' --- Geometry
	Dim count As Int = mData.Size
	' Clamp the last point to avoid drawing outside the chart
	Dim stepX As Float = (PaneChart.Width - 1) / (count - 1)

	Dim prevX As Float
	Dim prevY As Float

	' --- Draw polyline
	For i = 0 To count - 1
		Dim value As Float = mData.Get(i)
		
		Dim x As Float = i * stepX
		Dim norm As Float = (value - vMin) / (vMax - vMin)
		If norm < 0 Then norm = 0
		If norm > 1 Then norm = 1

		Dim pad As Float = 1dip
		Dim usableH As Float = PaneChart.Height - pad * 2
		Dim y As Float = pad + usableH - (norm * usableH)
		
		If i > 0 Then
			mChartCanvas.DrawLine(prevX, prevY, x, y, HMITileUtils.COLOR_TREND_LINE, 2dip)
			' Log($"[HMITileTrend.DrawChart] i=${i}, value=${value}, prevX=${prevX}, prevY=${prevY}, x=${x}, y=${y}"$)
		End If

		prevX = x
		prevY = y
	Next
	mChartCanvas.Invalidate
End Sub

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

' ===================================================================
' Public API
' ===================================================================

Public Sub setTitle(text As String)
	LabelTitle.Text = text
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub setUnit(text As String)
	mUnit = text
End Sub
Public Sub getUnit As String
	Return mUnit
End Sub

' --- Convenience helpers ---
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

' --- Core property ---
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

	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
	' No events 
#End Region
