B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITiles
' Brief:		Development program for the HMITiles B4X library.
' Description:	This library provides a coherent tile system, HMITiles.
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
	Private VERSION As String	= "HMITiles Development v20260424"
	Private ABOUT As String 	= $"HMITiles (c) 2025-2026 Robert W.B. Linn - MIT"$
	
	' UI
	Private xui As XUI
	Private Root As B4XView
	Private LabelAbout As B4XView
	
	' UI HMITiles
	Private TileLabelFontAwesome As HMITileLabel
	Private TileNavButtonPage2 As HMITileNavButton
	Private TileButtonOnOff As HMITileButton
	Private TileButtonToggle As HMITileButton
	Private TileEventViewer As HMITileEventViewer
	Private TileButtonAlarm As HMITileButton
	Private TileLevel As HMITileLevel
	Private TileSeekBar As HMITileSeekBar
	Private TileSeekBarIndicator As HMITileSeekBar
	Private TileSeekBarIndicator2 As HMITileSeekBar
	Private TileList As HMITileList
	Private TileReadOut As HMITileReadout
	Private TileSPPV1 As HMITileSPPV
	Private TileSPPV2 As HMITileSPPV
	Private TileSelect As HMITileSelect
	Private TileSelectList As HMITileSelectList
	Private TileTrend As HMITileTrend
	Private TileGauge As HMITileGauge
	Private TileDigitalClock As HMITileDigitalClock
	Private TileSensor As HMITileSensor
	Private TileButtonFA As HMITileButton
	Private TileButtonFA2 As HMITileButton
	Private TileStatusIndicators As HMITileStatusIndicators
	
	' Pages
	Private Page2 As B4XPage2
	Private TileTimer As HMITileTimer
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
	Page2.Initialize
	' Page ID, Page Object (defined in class_globals)
	B4XPages.AddPage("Page2", Page2)

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

	' Ensure to set sleep prior calling customviews
	Sleep(1)

	' Eventviewer
	TileEventViewer.CompactMode = False
	TileEventViewer.TimeStamp = False
	TileEventViewer.Insert(VERSION, HMITileUtils.EVENT_LEVEL_INFO)

	' Label Fontawesome
	TileLabelFontAwesome.SetFontAwesome(True)
	TileLabelFontAwesome.Text = Chr(0xF256)

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
	
	' LevelIndicator
	TileLevel.Value = 25

	' SeekBars 
	TileSeekBarIndicator.Vertical = True
	TileSeekBarIndicator.Value = 25
	TileSeekBarIndicator.ShowTicks = False
	' TileSeekBarIndicator.Enabled = False
	TileSeekBarIndicator.ThumbRadius = 0
	TileSeekBarIndicator.ActiveBarWidth		= TileSeekBarIndicator.mBase.Width * 0.2
	TileSeekBarIndicator.InActiveBarWidth	= TileSeekBarIndicator.mBase.Width * 0.2
	
	' List
	TileListAddItems
	TileList.SelectedItemIndex = 2
	
	' SPPV
	TileSPPV1.DeviationLimit = 10
	TileSPPV1.SP = 25
	TileSPPV1.PV = 20
	TileSPPV1.StepSize = 5
	TileSPPV1.ShowDeviation = True
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
End Sub

' ================================================================
' NAVBUTTONS
' ================================================================
Private Sub TileNavButtonPage2_Click
	B4XPages.ShowPageAndRemovePreviousPages("page2")
End Sub

' ================================================================
' BUTTONS
' ================================================================

Private Sub TileButtonOnOff_Click
	TileButtonOnOff.Value = Not(TileButtonOnOff.Value)
	TileEventViewer.Insert($"[TileButtonOnOff] value=${TileButtonOnOff.Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileEventViewer.Insert($"[TileButtonOnOff] ${TileEventViewer.StatusSummary}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileEventViewer.Insert($"[TileButtonOnOff] slidermax=${TileSeekBarIndicator.MaxValue}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileSeekBar.ShowValue = Not(TileSeekBar.ShowValue)
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
' RGB
' ================================================================

Private Sub TileRGBHorizontal_ValueChanged (m As Map)
	Dim tile As HMITileRGB = Sender
	TileEventViewer.Insert($"[TileRGBHorizontal_ValueChanged] tile=${tile.Title}, value=${m}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' SLIDER
' ================================================================

' Handle slider value changed.
' Set the value and style (Normal, Warning, Alarm) for selected tiles.
Private Sub TileSeekBar_ValueChanged (value As Int)
	Dim level As Int
	TileReadOut.Value = value
	TileLevel.Value = value
	TileGauge.Value = value
	TileSensor.Value = value
	TileSeekBarIndicator.Value = value
	TileSeekBarIndicator2.Value = value
	TileTrend.Add(value)

	If value > 90 Then
		TileReadOut.StatusAlarm
		TileLevel.StatusAlarm
		TileGauge.StatusAlarm
		TileSensor.StatusAlarm
		level = HMITileUtils.EVENT_LEVEL_ALARM
	Else if value > 70 Then
		TileReadOut.StatusWarning
		TileLevel.StatusWarning
		TileGauge.StatusWarning
		TileSensor.StatusWarning
		level = HMITileUtils.EVENT_LEVEL_WARNING
	Else if value == 0 Then
		TileLevel.StatusAlarm
		level = HMITileUtils.EVENT_LEVEL_ALARM
	Else
		TileReadOut.StatusNormal
		TileLevel.StatusNormal
		TileGauge.StatusNormal
		TileSensor.StatusNormal
		level = HMITileUtils.EVENT_LEVEL_INFO
	End If
	
	TileEventViewer.Insert($"[TileSeekBar_ValueChanged] value=${value}"$, level)
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
	data.Initialize2(Array As Int(20, 20, 30, 15, 75))
	TileTrend.UpdateChart(data)
End Sub

' ================================================================
' SETPOINT
' ================================================================

Private Sub TileSPPV1_SetPointChanged(Value As Float)
	TileEventViewer.Insert($"[TileSPPV1_SetPointChanged] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub TileSPPV2_SetPointChanged(Value As Float)
	TileEventViewer.Insert($"[TileSPPV2_SetPointChanged] value=${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileSPPV2.PV = Rnd(TileSPPV2.Min, TileSPPV2.Max * 1.1)
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

' ================================================================
' SELECT
' ================================================================

Private Sub TileSelectListAddAll
	TileSelectList.AddAll(Array As String("Item1", "Item 2", "Item 3"))
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

Private Sub TileGauge_Click(value As Float)
	TileEventViewer.Insert($"[TileGauge] value=${value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

' ================================================================
' READOUT
' ================================================================

Private Sub TileReadOut_Click
	TileEventViewer.Insert($"[TileReadOut] value=${TileReadOut.value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub
