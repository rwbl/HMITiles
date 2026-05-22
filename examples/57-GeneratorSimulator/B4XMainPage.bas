B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' File:         GeneratorSimulator
' Brief:        HMITile example application showing a generator simulator
' Date:         2026-05-22
' Author:       Robert W.B. Linn (c) 2026 MIT
' Description:  A High-Performance Industrial HMI example application simulating a
'               standard European 220V/230V @ 50Hz 4-pole industrial diesel generator.
'               
'               Key features include:
'               - Explicit state engine (STANDBY -> CRANKING -> RUNNING -> OVERLOAD).
'               - Governor Droop emulation matching electrical frequency/voltage calculations
'                 proportionally to user-defined load demand metrics.
'               - Live math formulas: Frequency (Hz) = RPM / 30; Voltage = Frequency * 4.6.
'               - Subsystem health matrix tracking maintenance variables with selective alarm behavior.
'               - High-precision clock runtime accumulation (Run Hours tracker).
'               - Integrated historical event logger capturing timestamped process anomalies, 
'                 system status overrides, and user-initiated inputs.
'				- Simulation behaviour example: 
'					- With 63% Load Demand, the engine speed realistically dips to 1,483 RPM, 
'					  which accurately pulls the output down to 227 V And 49.4 Hz. 

#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region
' See the list of page related events in the B4XPagesManager object. The event name is B4XPage.

#Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	Private VERSION As String = "GeneratorSimulator v20260522"
	
	' UI Lib
	Private xui As XUI
	' UI Base
	Private Root As B4XView
	' UI HMITiles
	Private TileReadoutEngineState As HMITileReadout
	' Reused as an Input Slider to simulate connected Electrical Load (0-100%)
	Private TileSliderLoadDemand As HMITileSlider
	Private TileReadoutRPM As HMITileReadout
	Private TileReadoutVoltage As HMITileReadout   ' Added for 220V/230V display
	Private TileReadoutFrequency As HMITileReadout ' Added for 50Hz display
	Private TileButtonStart As HMITileButton
	Private TileButtonStop As HMITileButton
	Private TileReadoutRunHours As HMITileReadout
	Private TileReadoutOilStatus As HMITileReadout
	Private TileReadoutAirFilterStatus As HMITileReadout
	Private TileReadoutSparkPlugStatus As HMITileReadout
	Private TileReadoutBatteryStatus As HMITileReadout
	Private TileEventViewer As HMITileEventViewer
	
	' Engine Timer & Simulation Variables
	Private EngineTimer As Timer
	Private ENGINE_TIMER_INTERVAL As Long = 250    ' 250ms for a responsive HMI feel
	Private EngineTicks As Long = 0                ' Tracks time states
	Private CurrentRPM As Float = 0
	Private InAlarmState As Boolean = False			' Alarm tracking

	' New Simulation Variables for V2
	Private RunHours As Float = 256.0
	Private MaintenanceTicks As Long = 0
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	Root.Color = HMITileUtils.COLOR_BACKGROUND_SCREEN

	B4XPages.SetTitle(Me, VERSION)
	B4XPages.GetNativeParent(Me).Resizable = False

	Sleep(1)
	TileEventViewer.Insert($"${VERSION} started"$, HMITileUtils.EVENT_LEVEL_INFO)
	TileReadoutEngineState.ValueTextSize = TileReadoutEngineState.ValueTextSize - 2
	
	' Initialize Load Slider to 0% demand
	TileSliderLoadDemand.Value = 0

	TileButtonStart.ValueFontFontAwesome
	TileButtonStart.OnText = Chr(0xF0DA)
	TileButtonStart.OffText = Chr(0xF0DA)

	TileButtonStop.ValueFontFontAwesome
	TileButtonStop.OnText = Chr(0xF04D)
	TileButtonStop.OffText = Chr(0xF04D)

	InitializeMaintenanceGrid

	' Initial values
	ResetReadouts
	TileButtonStop.Value = True

	EngineTimer.Initialize("EngineTimer", ENGINE_TIMER_INTERVAL)
	EngineTimer.Enabled = False
End Sub

Sub EngineTimer_Tick
	EngineTicks = EngineTicks + 1
	
	' 1. EXISTING STATE MACHINE LOGIC
	If EngineTicks < 8 Then
		TileReadoutEngineState.Value = "CRANKING"
		CurrentRPM = Min(400, CurrentRPM + 80)
	Else
		Dim TargetRPM As Float = 1500
		Dim LoadFactor As Float = TileSliderLoadDemand.Value / 100.0
		Dim Droop As Float = LoadFactor * 25.0
		Dim Noise As Float = Rnd(-3, 4)
		CurrentRPM = CurrentRPM + (TargetRPM - Droop + Noise - CurrentRPM) * 0.4
		
		' RUN HOURS TRACKER ---
		' Accumulate runtime fraction per tick (e.g., 250ms = 0.25 seconds)
		Dim SecondsPerTick As Float = ENGINE_TIMER_INTERVAL / 1000.0
		Dim HoursPerTick As Float = SecondsPerTick / 3600.0
		RunHours = RunHours + HoursPerTick
	End If
	
	' 2. EXISTING ELECTRICAL CALCULATIONS
	Dim CurrentFrequency As Float = CurrentRPM / 30.0
	Dim CurrentVoltage As Float = CurrentFrequency * 4.6
	
	' 3. EXISTING ALARM COLOR LOGIC
	If EngineTicks >= 8 Then
		If CurrentFrequency < 48.5 Or TileSliderLoadDemand.Value > 100 Then
			If Not(InAlarmState) Then
				InAlarmState = True
				TileReadoutEngineState.Value = "OVERLOAD"
				TileReadoutEngineState.StatusAlarm
				TileEventViewer.Insert($"Engine state overload"$, HMITileUtils.EVENT_LEVEL_ALARM)
			End If
		Else
			If InAlarmState Then
				InAlarmState = False
				TileReadoutEngineState.Value = "RUNNING"
				TileReadoutEngineState.StatusNormal
				TileEventViewer.Insert($"Engine state running"$, HMITileUtils.EVENT_LEVEL_INFO)
			End If
		End If
	End If
	
	' 4. MAINTENANCE STATUS LOGIC ---
	' Simulate occasional part degradation over time
	MaintenanceTicks = MaintenanceTicks + 1
	If MaintenanceTicks > 120 Then ' Triggers a temporary warning check
		TileReadoutAirFilterStatus.Value = "CHECK"
		If TileReadoutAirFilterStatus.Status <> HMITileUtils.STATUS_WARNING Then
			TileReadoutAirFilterStatus.StatusWarning
			TileEventViewer.Insert($"Air Filter requires check"$, HMITileUtils.EVENT_LEVEL_WARNING)			
		End If
	End If
	
	' 5. UPDATE ALL HMI TILES
	TileReadoutRPM.Value = NumberFormat(CurrentRPM, 1, 0)
	TileReadoutFrequency.Value = NumberFormat(CurrentFrequency, 1, 1)
	TileReadoutVoltage.Value = NumberFormat(CurrentVoltage, 1, 0)
	TileReadoutRunHours.Value = NumberFormat(RunHours, 1, 1)
End Sub

Private Sub TileButtonStart_Click
	If EngineTimer.Enabled Then Return ' Already trying to run
	
	TileButtonStart.Value = True
	TileButtonStop.Value = False
	EngineTicks = 0
	EngineTimer.Enabled = True
End Sub

Private Sub TileButtonStop_Click
	TileButtonStart.Value = False
	TileButtonStop.Value = True
	EngineTimer.Enabled = False
	
	' Instant cooldown reset for simplicity
	ResetReadouts
End Sub

Private Sub TileSliderLoadDemand_ValueChanged (Value As Int)
	TileEventViewer.Insert($"Load demand changed to ${Value}"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub ResetReadouts
	EngineTicks = 0
	CurrentRPM = 0
	InAlarmState = False
	
	TileReadoutEngineState.Value = "STANDBY"
	TileReadoutEngineState.StatusNormal
	
	TileReadoutRPM.Value = 0
	TileReadoutFrequency.Value = 0.0
	TileReadoutVoltage.Value = 0
	
	' Keep RunHours visible even when stopped (Standard industrial rule)
	TileReadoutRunHours.Value = NumberFormat(RunHours, 1, 1)
End Sub

' Call this helper sub inside your B4XPage_Created to set up default health grid states
Private Sub InitializeMaintenanceGrid
	MaintenanceTicks = 0
	
	TileReadoutOilStatus.Value = "OK"
	TileReadoutOilStatus.StatusNormal
	
	TileReadoutAirFilterStatus.Value = "OK"
	TileReadoutAirFilterStatus.StatusNormal
	
	TileReadoutSparkPlugStatus.Value = "OK"
	TileReadoutSparkPlugStatus.StatusNormal
	
	TileReadoutBatteryStatus.Value = "OK"
	TileReadoutBatteryStatus.StatusNormal
End Sub
