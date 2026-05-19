B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			B4XMainPage
' Project:		HMITiles
' Brief:		Development program for the B4X HMITiles B4X.
' Description:	This library provides a coherent tile system called HMITiles.
' Date:			See Class_Globals VERSION
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' DependsOn:	XUI Views, ByteConverter, JavaObject
' ================================================================

#Region Shared Files
' Ref: www.b4x.com/android/forum/threads/b4x-codebundle-–-export-projects-as-a-single-json-for-ai-analysis.169835/
#Macro: Title, Code bundle, ide://run?File=%ADDITIONAL%\CodeBundle.jar&Args=%PROJECT_NAME%&vmargs=-DCompactJson%3DFalse
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
#End Region

Private Sub Class_Globals
	Private VERSION As String	= "HMITiles Development v20260519"
	Private ABOUT As String 	= $"HMITiles (c) 2025-2026 Robert W.B. Linn - MIT"$
	
	' UI
	Private xui As XUI
	Private Root As B4XView
	Private LabelAbout As B4XView
	
	' UI HMITiles
	Private TileLabelFontAwesome As HMITileLabel
	Private TileLabelTitle As HMITileLabelTitle
	Private TileLabelTitleAlarm As HMITileLabelTitle
	Private TileNavButtonSecondPage As HMITileNavButton
	Private TileButtonOnOff As HMITileButton
	Private TileButtonToggle As HMITileButton
	Private TileEventViewer As HMITileEventViewer
	Private TileButtonAlarm As HMITileButton
	Private TileLevelBar As HMITileLevel
	Private TileLevelCircle As HMITileLevel
	Private TileList As HMITileList
	Private TileReadOut As HMITileReadout
	Private TileSPPV1 As HMITileSPPV
	Private TileSPPV2 As HMITileSPPV
	Private TileDeviation As HMITileDeviation
	Private TileSelect As HMITileSelect
	Private TileSelectList As HMITileSelectList
	Private TileTrend As HMITileTrend
	Private TileGauge As HMITileGauge
	Private TileGaugeNeedle As HMITileGauge
	Private TileGaugeSegments As HMITileGaugeSegments
	Private TileDigitalClock As HMITileDigitalClock
	Private TileSensor As HMITileSensor
	Private TileButtonFA As HMITileButton
	Private TileButtonFA2 As HMITileButton
	Private TileStatusIndicators As HMITileStatusIndicators
	Private TileTimer As HMITileTimer
	Private TileCustomLabels As HMITileCustom
	Private TileCustomShape As HMITileCustom
	Private TileSliderHor As HMITileSlider
	Private TileSliderIndicator1 As HMITileSlider
	Private TileSliderIndicator2 As HMITileSlider
	Private TileSliderVer As HMITileSlider
		
	' Pages
	Private SecondPage As B4XSecondPage
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")

	' Add pages
	' Sub-Pages
	SecondPage.Initialize
	' Page ID, Page Object (defined in class_globals)
	B4XPages.AddPage("SecondPage", SecondPage)

	' UI  additional settings
	Root.Color = HMITileUtils.COLOR_BACKGROUND_SCREEN
	#if B4A
	B4XPages.SetTitle(Me, $"${VERSION} (B4A)"$)
	#End If
	#if B4J
	B4XPages.SetTitle(Me, $"${VERSION} (B4J)"$)
	B4XPages.GetNativeParent(Me).Resizable = False
	#End If
	#if LINUX
	B4XPages.SetTitle(Me, $"${VERSION} (LINUX)"$)
	B4XPages.GetNativeParent(Me).Resizable = False
	#End If
	LabelAbout.Text = ABOUT
	LabelAbout.TextColor = HMITileUtils.COLOR_TEXT_WARNING

	' Ensure to set sleep prior calling customviews
	Sleep(1)

	' Eventviewer
	TileEventViewer.CompactMode = False
	TileEventViewer.TimeStamp = False
	TileEventViewer.Insert(VERSION, HMITileUtils.EVENT_LEVEL_INFO)

	' Label Fontawesome
	TileLabelFontAwesome.SetFontAwesome(True)
	TileLabelFontAwesome.Text = Chr(0xF256)

	' LabelTitle
'	TileLabelTitle.Title = "LabelTitle"
'	TileLabelTitle.Text = "Alarm State"
'	TileLabelTitle.StatusAlarm
	TileLabelTitleAlarm.TextSize = 32
	
	' Digital Clock
	TileDigitalClock.ShowSeconds = True
	
	' OnOff Button
	TileButtonOnOff.Value = True
	TileButtonOnOff_Click
	
	' Toggle Button
	TileButtonToggle.ValueFontFontAwesome
	TileButtonToggle.OnText = HMITileUtils.ICON_ON
	TileButtonToggle.OffText = HMITileUtils.ICON_OFF
	TileButtonToggle.Value = False
	TileButtonToggle_Click

	' Toggle Button Alarm
	TileButtonAlarm.Value = False	
	TileButtonAlarm_Click

	' Button FA
	TileButtonFA.ValueFontFontAwesome
	TileButtonFA.OnText = Chr(0xF061)
	TileButtonFA.OffText = Chr(0xF061)
	TileButtonFA.Value = True

	TileButtonFA2.ValueFontFontAwesome
	TileButtonFA2.OnText = HMITileUtils.ICON_REFRESH
	TileButtonFA2.OffText = HMITileUtils.ICON_REFRESH
	TileButtonFA2.Value = True

	' Readout
	TileReadOut.Value = 67
	
	' Gauge
	TileGauge.Value = 67
	TileGauge.Min = 0
	TileGauge.Max = 100
	TileGaugeNeedle.Value = 90
	TileGaugeNeedle.Min = 0
	TileGaugeNeedle.Max = 180
	TileGaugeSegments.Value = 67
	
	' Level Indicators
	TileLevelBar.Value = 25
	TileLevelCircle.Value = 67

	' Slider
	TileSliderIndicator1.Vertical = True
	TileSliderIndicator1.Value = 25
	TileSliderIndicator1.ShowTicks = False
	TileSliderIndicator1.ThumbRadius = 0
	TileSliderIndicator1.ActiveBarWidth = TileSliderIndicator1.BasePane.Width * 0.2
	TileSliderIndicator1.InActiveBarWidth = TileSliderIndicator1.BasePane.Width * 0.2
	
	' List
	TileListAddItems
	TileList.SelectedItemIndex = 2
	
	' SPPV
	TileSPPV1.Title = "FlowRate"
	TileSPPV1.ShowDeviation = True
	TileSPPV1.DeviationWarning = 30	'Value SP 50 +/- 
	TileSPPV1.DeviationAlarm = 40
	TileSPPV1.StepSize = 5
	TileSPPV1.EditMode = True

	' Trend
	TileTrendAddData

	' SelectList
	TileSelectList.CompactMode = True
	TileSelectListAddAll
	TileSelectList.SelectedItemIndex = 1
	TileSelectList.SelectedItem = "Item 3"
	TileSelect.AddAll(Array As String("ON", "OFF", "BLINK"))
	TileSelect.Selected = "ON"
	
	' StatusIndicators
	' Total 9 status indicators - 
	TileStatusIndicators.SetData(1, 1, "P1", "Pump 1 Feed C-1101", TileStatusIndicators.Status_FALSE, True)
	TileStatusIndicators.SetData(1, 3, "P3", "Pump 3 Slurry C-1101", TileStatusIndicators.Status_DISABLED, True)
	TileStatusIndicators.SetData(2, 1, "F4", "Filter 4 Water Treatment I", TileStatusIndicators.Status_TRUE, True)
	TileStatusIndicators.SetData(3, 3, "F9", "Filter 9 Water Treatment II ", TileStatusIndicators.Status_FALSE, True)
	
	' Timer
	TileTimer.TimerTextSize = 22
	
	' Custom Tiles
	TileCustomCreateLabels
	TileCustomCreateShape
End Sub

' ================================================================
' TileLabelTitle
' ================================================================

Private Sub TileLabelTitle_Click
	
End Sub

' ================================================================
' NAVBUTTONS
' ================================================================

Private Sub TileNavButtonSecondPage_Click
	B4XPages.ShowPageAndRemovePreviousPages("SecondPage")
End Sub

' ================================================================
' BUTTONS
' ================================================================

Private Sub TileButtonOnOff_Click
	TileButtonOnOff.Value = Not(TileButtonOnOff.Value)
	TileEventViewer.Insert($"[TileButtonOnOff] value=${TileButtonOnOff.Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileEventViewer.Insert($"[TileButtonOnOff] ${TileEventViewer.StatusSummary}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileEventViewer.Insert($"[TileButtonOnOff] slidermax=${TileSliderIndicator1.MaxValue}"$, HMITileUtils.EVENT_LEVEL_INFO)
	' TileSliderIndicator1.ShowValue = Not(TileSliderIndicator1.ShowValue)
End Sub

' Button with fontawesome looks like a toggle switch.
Private Sub TileButtonToggle_Click
	TileButtonToggle.Value = Not(TileButtonToggle.Value)
	TileEventViewer.Insert($"[TileButtonToggle] value=${TileButtonToggle.value}"$, HMITileUtils.EVENT_LEVEL_INFO)
	
	If TileButtonToggle.Value Then
		TileTrend.Clear
		TileEventViewer.Insert($"[TileButtonToggle] TileTrend cleared (#${TileTrend.Size})"$, HMITileUtils.EVENT_LEVEL_WARNING)
	End If
End Sub

Private Sub TileButtonAlarm_Click
	TileButtonAlarm.Value = Not(TileButtonAlarm.Value)
	If TileButtonAlarm.Value Then
		TileButtonAlarm.StatusAlarm
	Else
		TileButtonAlarm.StatusNormal
	End If
	TileEventViewer.Insert($"[TileButtonAlarm] value=${TileButtonAlarm.Value}"$, HMITileUtils.EVENT_LEVEL_ALARM)
End Sub

Private Sub TileButtonFA_Click
	TileEventViewer.Insert($"[TileButtonFA] Clicked"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' SLIDER
' ================================================================

' Handle slider value changed.
' Set the value and style (Normal, Warning, Alarm) for selected tiles.
Private Sub TileSliderHor_ValueChanged (Value As Int)
	Dim level As Int
	TileReadOut.Value = Value
	TileLevelBar.Value = Value
	TileLevelCircle.Value = Value
	TileGauge.Value = Value
	TileGaugeNeedle.Value = HMITileUtils.MapRange(Value, 0, 100, 0, 180)
	TileGaugeSegments.Value = Value
	TileSensor.Value = Value
	TileSliderIndicator1.Value = Value
	TileSliderIndicator2.Value = Value
	TileTrend.Add(Value)
	TileSPPV1.PV = Value
	TileSPPV2.PV = Round(Value / 10)
	
	If Value > 90 Then
		TileReadOut.StatusAlarm
		TileLevelBar.StatusAlarm
		TileLevelCircle.StatusAlarm
		TileGauge.StatusAlarm
		TileSensor.StatusAlarm
		level = HMITileUtils.EVENT_LEVEL_ALARM
	Else if Value > 70 Then
		TileReadOut.StatusWarning
		TileLevelBar.StatusWarning
		TileLevelCircle.StatusWarning
		TileGauge.StatusWarning
		TileSensor.StatusWarning
		level = HMITileUtils.EVENT_LEVEL_WARNING
	Else if Value == 0 Then
		TileLevelBar.StatusAlarm
		TileLevelCircle.StatusAlarm
		level = HMITileUtils.EVENT_LEVEL_ALARM
	Else
		TileReadOut.StatusNormal
		TileLevelBar.StatusNormal
		TileLevelCircle.StatusNormal
		TileGauge.StatusNormal
		TileSensor.StatusNormal
		level = HMITileUtils.EVENT_LEVEL_INFO
	End If
	
	TileEventViewer.Insert($"[TileSeekBar_ValueChanged] value=${Value}"$, level)
End Sub

Private Sub TileSliderVer_ValueChanged (Value As Int)
	
End Sub

Private Sub TileSliderIndicator2_ValueChanged (Value As Int)
	
End Sub

Private Sub TileSliderIndicator1_ValueChanged (Value As Int)
	
End Sub

' ================================================================
' EVENTVIEWER
' ================================================================

Private Sub TileEventViewer_ItemClick (Index As Int, Value As Object)
	Log($"[TileEventViewer_ItemClick] index=${Index}, value=${Value}"$)
	' Log(TileEventViewer.GetEvents)
End Sub

' ================================================================
' LIST
' ================================================================

Private Sub TileListAddItems
	' Items with secondary information
	For i = 0 To 2
		TileList.Add($"${"item"} ${i}"$, i, $"${"item"} ${i}"$)
	Next

	' Items without secondary information
	i = 10
	TileList.Add($"${"item"} ${i}"$, "", i)
	i = 11
	TileList.Add($"${"item"} ${i}"$, "", i)
End Sub

Private Sub TileList_ItemClick (Index As Int, Value As Object)
	TileEventViewer.Insert($"[TileList_ItemClick] index=${Index}, value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' TREND
' ================================================================

Private Sub TileTrendAddData
	Dim data As List
	data.Initialize2(Array As Int(20, 20, 30, 15))
	TileTrend.UpdateChart(data)
End Sub

Private Sub TileTrend_Click
	TileEventViewer.Insert($"[TileTrend_Click] datapoints=${TileTrend.DataPoints}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' SPPV
' ================================================================

Private Sub TileSPPV1_ValueChanged(Value As Float)
	TileEventViewer.Insert($"[TileSPPV1_ValueChanged] value=${Value}, setpoint=${TileSPPV1.SP}, deviation=${TileSPPV1.Deviation}"$, HMITileUtils.EVENT_LEVEL_INFO)
	' Set alarm depending deviaton
	If Abs(TileSPPV1.Deviation) > 30 Then
		TileSPPV1.StatusAlarm
	Else If Abs(TileSPPV1.Deviation) > 20 Then
		TileSPPV1.StatusWarning
	Else
		TileSPPV1.StatusNormal
	End If
	TileDeviation.Value = TileDeviation.CalculateDeviation(TileSPPV1.SP, TileSPPV1.PV)	' , TileSPPV1.max - TileSPPV1.Min
End Sub

Private Sub TileSPPV1_SetPointChanged(Value As Float)
	TileEventViewer.Insert($"[TileSPPV1_SetPointChanged] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileDeviation.Value = TileDeviation.CalculateDeviation(TileSPPV1.SP, TileSPPV1.PV)
End Sub

Private Sub TileSPPV2_ValueChanged(Value As Float)
	TileEventViewer.Insert($"[TileSPPV2_ValueChanged] value=${Value}, setpoint=${TileSPPV2.SP}, deviation=${TileSPPV2.Deviation}"$, HMITileUtils.EVENT_LEVEL_INFO)
	' Set alarm depending deviaton
	If Abs(TileSPPV2.Deviation) > 3 Then
		TileSPPV2.StatusAlarm
	Else If Abs(TileSPPV2.Deviation) > 1.5 Then
		TileSPPV2.StatusWarning
	Else
		TileSPPV2.StatusNormal
	End If
End Sub

Private Sub TileSPPV2_SetPointChanged(Value As Float)
	TileEventViewer.Insert($"[TileSPPV2_SetPointChanged] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileSPPV2.PV = Rnd(TileSPPV2.Min, TileSPPV2.Max * 1.1)
End Sub

' ================================================================
' SELECT
' ================================================================

Private Sub TileSelectListAddAll
	TileSelectList.AddAll(Array As String("Item1", "Item 2", "Item 3", "Item 4"))
End Sub

Private Sub TileSelectList_ItemClick (Index As Int, Value As Object)
	TileEventViewer.Insert($"[TileSelectList_ItemClick] index=${Index}, value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub TileSelect_ValueChanged (Value As Object)
	TileEventViewer.Insert($"[TileSelect_ValueChanged] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' TIMER
' ================================================================

Private Sub TileTimer_Start
	TileEventViewer.Insert($"[TileTimer] Started"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub TileTimer_Stop
	TileEventViewer.Insert($"[TileTimer] Stopped"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub TileTimer_Finished
	TileEventViewer.Insert($"[TileTimer] Finished"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub


' ================================================================
' STATUSINDICATORS
' ================================================================

Private Sub TileStatusIndicators_Click(data As IndicatorData)
	Dim indicator As HMITileStatusIndicators = Sender
	TileEventViewer.Insert($"[TileStatusIndicators] ${data}"$, HMITileUtils.EVENT_LEVEL_INFO)
	Dim sf As Object = xui.Msgbox2Async( _ 
		$"${data.description}${CRLF}Status:${CRLF}${indicator.GetStatusText(data.Status)}"$, $"Indicator ${data.text}"$, "OK", "", "", Null)
	Wait For (sf) Msgbox_Result (Result As Int)
End Sub

' ================================================================
' GAUGE
' ================================================================

Private Sub TileGauge_Click (Value As Float)
	TileEventViewer.Insert($"[TileGauge] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' READOUT
' ================================================================

Private Sub TileReadOut_Click
	TileEventViewer.Insert($"[TileReadOut] value=${TileReadOut.value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' LEVEL
' ================================================================

Private Sub TileLevelBar_Click (Value As Float)
	TileEventViewer.Insert($"[TileLevelBar] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub TileLevelCircle_Click (Value As Float)
	TileEventViewer.Insert($"[TileLevelCircle] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' TileCustom
' ================================================================

Private Sub TileDeviation_Click (Value As Float, Status As String)
	TileEventViewer.Insert($"[TileDeviation] value=${Value} status=${Status}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' TileCustom
' ================================================================

' Create customized tile starting with empty pane.
' Added are 4 labels (B4XViews) top-down.
Private Sub TileCustomCreateLabels
	Dim left As Double 
	Dim top As Double
	Dim width As Double
	Dim height As Double
	Dim heightfactor As Double = HMITileUtils.TILE_TITLE_HEIGHT_FACTOR

	' Create 4 labels
	Dim lbls(4) As B4XView
	Dim titles() As String = Array As String("Custom Tile", "Info 1", "Info 2", "Footer")
	For i = 0 To 3
		lbls(i)		= XUIViewsUtils.CreateLabel
		lbls(i).Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_LABEL)
		lbls(i).SetTextAlignment("CENTER", "CENTER")
		lbls(i).TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
		lbls(i).Text = $"${titles(i)}"$
		left = HMITileUtils.TILE_PADDING
		top = (i * heightfactor) * TileCustomLabels.BasePane.Height
		width = TileCustomLabels.BasePane.Width - (HMITileUtils.TILE_PADDING * 2)
		height = TileCustomLabels.BasePane.Height * heightfactor
		' Add label to the base
		TileCustomLabels.BasePane.AddView(lbls(i), left, top, width, height)
	Next
End Sub

' Create customized tile starting with empty pane.
' Add are a title and a triangle shape
Private Sub TileCustomCreateShape
	Dim left As Double
	Dim top As Double
	Dim width As Double
	Dim height As Double
	Dim heightfactor As Double = HMITileUtils.TILE_TITLE_HEIGHT_FACTOR

	Dim titlelabel As B4XView
	Dim footerlabel As B4XView
	Dim cvs As B4XCanvas
	
	' Title
	titlelabel = XUIViewsUtils.CreateLabel
	titlelabel.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_LABEL)
	titlelabel.SetTextAlignment("CENTER", "CENTER")
	titlelabel.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
	titlelabel.Text = $"Custom Tile"$
	left 	= HMITileUtils.TILE_PADDING
	top 	= 0
	width 	= TileCustomShape.BasePane.Width - (HMITileUtils.TILE_PADDING * 2)
	height 	= TileCustomShape.BasePane.Height * heightfactor
	' Add label to the base
	TileCustomShape.BasePane.AddView(titlelabel, left, top, width, height)

	' Shape
	cvs.Initialize(TileCustomShape.BasePane)
	Dim cx As Float 	= TileCustomShape.BasePane.Width / 2
	Dim cy As Float 	= TileCustomShape.BasePane.Height / 2
	Dim size As Float 	= 40
	HMITileSymbols.Triangle(cvs, cx, cy, size, HMITileUtils.COLOR_STATUS_ALARM, True, 0, HMITileSymbols.DIR_NORTH)

	' footer
	footerlabel = XUIViewsUtils.CreateLabel
	footerlabel.Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_LABEL)
	footerlabel.SetTextAlignment("CENTER", "CENTER")
	footerlabel.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
	footerlabel.Text = $"Triangle North"$
	left 	= HMITileUtils.TILE_PADDING
	top 	= TileCustomShape.BasePane.Height * (1 - heightfactor)
	width 	= TileCustomShape.BasePane.Width - (HMITileUtils.TILE_PADDING * 2)
	height	= TileCustomShape.BasePane.Height * heightfactor
	' Add label to the base
	TileCustomShape.BasePane.AddView(footerlabel, left, top, width, height)
End Sub
