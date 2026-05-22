B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' File:         ColdStorageSimulator
' Brief:        HMITile example application showing a cold storage unit simulator
' Date:         2026-05-22
' Author:       Robert W.B. Linn (c) 2026 MIT
' Description:  A High-Performance Industrial HMI example application simulating an 
'               environmental control chamber / industrial refrigerator loop.
'               
'               Key features include:
'               - Hysteresis thermostat control mapping (IDLE -> COOLING -> DEFROST -> HI-TEMP ALARM).
'               - Dynamic insulation heat leak physics matching door switch states (CLOSED vs OPEN).
'               - Self-terminating evaporator coil defrost timer logic.
'               - Adaptive fan speed mapping based on refrigeration workload states.
'               - High-Performance alert headers triggering on critical food/pharma safety limits (> 8.0°C).
'               - Low-noise variable process drifting to provide authentic HMI data activity.
'               - Dedicated event tracking log recording automated mechanical cycles and manual door trips.
' Layout:
'				Row 1: Status & Core Safety
'				* TILE 1 (Status): COMPRESSOR STATE ("IDLE" -> "COOLING" -> "DEFROST" -> "HI-TEMP ALARM")
'				* TILE 2 (Control Button): DOOR STATE Toggle ("CLOSED" / "OPEN")
'				* TILE 3 (Control Button): DEFROST CYCLE Trigger ("START" push-button)
'
'				Row 2: Process Metrics
'				* TILE 4 (Large Readout): CURRENT TEMP (Digital value tracking simulated internal room temperature)
'				* TILE 5 (Readout): COMPRESSOR LOAD (Percentage Power draw from 0% To 100%)
'				* TILE 6 (Readout): EVAPORATOR FAN SPEED (RPM tracking of the circulation fans)
'
'				Row 3: Process Input
'				* TILE 7 (Slider): TEMPERATURE SETPOINT (Adjustable target slider from -10.0°C To +10.0°C)

#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region
' See the list of page related events in the B4XPagesManager object. The event name is B4XPage.

#Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	Private VERSION As String = "Cold Storage Simulator v20260522"
	
	' UI Lib
	Private xui As XUI
	' UI Base
	Private Root As B4XView
	' UI HMITiles
	Private TileEventViewer As HMITileEventViewer
	Private TileSliderTemperatureSetpoint As HMITileSlider
	Private TileButtonDefrostCycleTrigger As HMITileButton
	Private TileButtonDoorState As HMITileButton
	Private TileReadoutCompressorLoad As HMITileReadout
	Private TileReadoutCompressorState As HMITileReadout
	Private TileReadoutCurrentTemp As HMITileReadout
	Private TileReadoutEvaporatorFanSpeed As HMITileReadout

	' Simulator Timer
	Private SimulatorTimer As Timer
	Private SIMULATOR_TIMER_INTERVAL As Long = 500	' Changed to 500ms for smoother HMI updates

	' Process Variables
	Private CurrentTemp As Float = 4.2             ' Initial cold room temp
	Private IsDoorOpen As Boolean = False
	Private IsDefrosting As Boolean = False
	Private DefrostTicks As Int = 0
	Private InAlarmState As Boolean = False
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	' Root
	Root = Root1
	Root.LoadLayout("MainPage")
	Root.Color = HMITileUtils.COLOR_BACKGROUND_SCREEN

	' B4XPages
	B4XPages.SetTitle(Me, VERSION)
	B4XPages.GetNativeParent(Me).Resizable = False

	' HMITiles Initialization
	Sleep(1)
	TileEventViewer.Insert($"${VERSION} started"$, HMITileUtils.EVENT_LEVEL_INFO)

	' Setup Default UI Component Values
	TileSliderTemperatureSetpoint.Value = 2        ' Target: 2°C
	
	TileButtonDoorState.OnText = "OPEN"
	TileButtonDoorState.OffText = "CLOSED"
	TileButtonDoorState.Value = False
	
	TileButtonDefrostCycleTrigger.OnText = "DEFROST"
	TileButtonDefrostCycleTrigger.OffText = "START DEFROST"
	TileButtonDefrostCycleTrigger.Value = False

	UpdateUIFields

	' Simulator Timer
	SimulatorTimer.Initialize("SimulatorTimer", SIMULATOR_TIMER_INTERVAL)
	SimulatorTimer.Enabled = True                  ' Active on start
End Sub

Sub SimulatorTimer_Tick
	Dim Setpoint As Float = TileSliderTemperatureSetpoint.Value
	Dim ThermalGain As Float = 0.0
	
	' 1. DEFROST MODE CYCLE
	If IsDefrosting Then
		DefrostTicks = DefrostTicks + 1
		TileReadoutCompressorState.Value = "DEFROST"
		TileReadoutCompressorLoad.Value = "0 %"
		TileReadoutEvaporatorFanSpeed.Value = "0 rpm"
		
		' Defrosting heats up the coils (ambient room increases)
		ThermalGain = 0.15
		
		' Auto-complete defrost cycle after 16 ticks (~8 seconds)
		If DefrostTicks >= 16 Then
			IsDefrosting = False
			TileButtonDefrostCycleTrigger.Value = False
			TileEventViewer.Insert("Defrost cycle completed automatically", HMITileUtils.EVENT_LEVEL_INFO)
		End If
		
		' 2. STANDARD COOLING CYCLE
	Else
		' Calculate natural thermal leak based on door position
		If IsDoorOpen Then
			ThermalGain = 0.45    ' Massive ambient air exchange
		Else
			ThermalGain = 0.03    ' Minor insulation losses
		End If
		
		' Core Thermostat Controller (Deadband / Hysteresis loop)
		' Compressor kicks on if room temperature drifts 0.5°C over setpoint
		If CurrentTemp > (Setpoint + 0.5) Then
			TileReadoutCompressorState.Value = "COOLING"
			TileReadoutCompressorLoad.Value = "100 %"
			TileReadoutEvaporatorFanSpeed.Value = "1450 rpm"
			ThermalGain = ThermalGain - 0.22 ' Cooling power reduces temperature
		Else
			TileReadoutCompressorState.Value = "IDLE"
			TileReadoutCompressorLoad.Value = "0 %"
			TileReadoutEvaporatorFanSpeed.Value = "400 rpm" ' Eco fan speed
		End If
	End If
	
	' Apply process noise (+/- 0.02) and update temperature variable
	Dim ProcessNoise As Float = Rnd(-20, 21) / 1000.0
	CurrentTemp = CurrentTemp + ThermalGain + ProcessNoise
	
	' 3. HIGH-PERFORMANCE HMI ALARM INTERCEPT
	' Trigger alarm if temperature rises past safe threshold (> 8.0°C)
	If CurrentTemp > 8.0 Then
		If Not(InAlarmState) Then
			InAlarmState = True
			TileReadoutCompressorState.Value = "HI-TEMP ALARM"
			TileReadoutCompressorState.StatusAlarm
			TileEventViewer.Insert("Warning: Critical storage temperature exceeded!", HMITileUtils.EVENT_LEVEL_WARNING)
		End If
	Else
		If InAlarmState Then
			InAlarmState = False
			TileReadoutCompressorState.StatusNormal
			TileEventViewer.Insert("Storage temperature recovered to normal parameters", HMITileUtils.EVENT_LEVEL_INFO)
		End If
	End If
	
	' 4. REFRESH READOUT VALUES
	UpdateUIFields
End Sub

Private Sub UpdateUIFields
	TileReadoutCurrentTemp.Value = NumberFormat(CurrentTemp, 1, 1) & " °C"
End Sub

Private Sub TileButtonDoorState_Click
	' Toggle simulated physical door position
	IsDoorOpen = Not(IsDoorOpen)
	TileButtonDoorState.Value = IsDoorOpen
	
	If IsDoorOpen Then
		TileEventViewer.Insert("Cold storage vault room door opened", HMITileUtils.EVENT_LEVEL_WARNING)
	Else
		TileEventViewer.Insert("Cold storage vault room door sealed securely", HMITileUtils.EVENT_LEVEL_INFO)
	End If
End Sub

Private Sub TileButtonDefrostCycleTrigger_Click
	If IsDefrosting Then Return ' Cycle already active
	
	IsDefrosting = True
	DefrostTicks = 0
	TileButtonDefrostCycleTrigger.Value = True
	TileEventViewer.Insert("Manual evaporator coil defrost routine initialized", HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub TileSliderTemperatureSetpoint_ValueChanged (Value As Int)
	TileEventViewer.Insert($"Temperature setpoint adjusted to ${Value} °C"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub
