B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' File:         LighthouseSimulator
' Brief:        HMITile example application showing a lighthouse automation console
' Date:         2026-05-23
' Author:       Robert W.B. Linn (c) 2026 MIT
' Description:  A High-Performance Industrial HMI example application simulating a
'               coastal lighthouse station console with automated optic rotation,
'               manual Day/Night console overrides, and foghorn atmospheric triggers.
'               
'               Key features include:
'               - Interlocked automation tracking (OFFLINE -> DAYTIME IDLE -> BEACON ACTIVE).
'               - Smooth motor Variable Frequency Drive (VFD) ramping simulation curve profiles.
'               - Adaptive smart beacon lamp scaling power output up to 100% based on active fog density.
'               - True thermodynamic calculation loops measuring bearing friction temperatures in °C.
'               - Safe lockout failure simulations forcing rapid mechanical heat stress indicators.
'               - Integrated chronological Event Viewer capturing critical alarms and mode changes.
'
' Layout:
'				1. Row 1 (Status & Critical Control):
'				   * STATION STATUS: Displays automated system states (OFFLINE -> DAYTIME IDLE -> BEACON ACTIVE) with adaptive color profiles.
'				   * Main Power: Dual-state FontAwesome switch button To energize Or isolate the master lighthouse automation loops.
'				   * FOGHORN MODE: Tactical control toggle button To alternate between automated acoustic operation And manual silent overrides.
'
'				2. Row 2 (Primary Optical Readouts):
'				   * BEACON SPEED: Digital rotational speed readout tracking the active motorized Fresnel lens assembly in RPM.
'				   * LAMP Power: Live percentage indicator displaying the intermittent illumination pulse sequence (0% To 100%).
'				   * AMBIENT LIGHT: Microprocessor photocell value tracking the environmental daylight Loop in Lux (lx).
'
'				3. Row 3 (Diagnostics & Aux Telemetry Grid):
'				   * FLASH SIGNATURE: Muted constant label tracking the lighthouse's unique maritime flash characteristic (e.g., "Iso 4s").
'				   * BEARING TEMP: Station physical health indicator monitoring internal lens drive temperatures (OK / HOT).
'				   * ACOUSTIC HORN: Reactive state monitor indicating active pneumatic horn blasts during visibility alarms (READY / BLASTING).
'
'				4. Row 4 (Atmospheric Process Input):
'				   * Fog Density: Interactive HMITileSlider simulating variable coastal fog blockages (0% To 100% saturation) To test automated acoustic triggers.

Sub Class_Globals
	Private VERSION As String = "Lighthouse Simulator v20260523"
	
	' UI Lib
	Private xui As XUI
	' UI Base
	Private Root As B4XView
	' UI HMITiles
	Private TileEventViewer As HMITileEventViewer
	Private TileSliderFogDensity As HMITileSlider
	Private TileButtonMainPower As HMITileButton
	Private TileButtonFoghornOverride As HMITileButton
	Private TileReadoutStationStatus As HMITileReadout
	Private TileReadoutLensRPM As HMITileReadout
	Private TileReadoutLampIntensity As HMITileReadout
	Private TileReadoutFlashPattern As HMITileReadout
	Private TileReadoutAmbientLight As HMITileReadout
	Private TileReadoutBearingTemp As HMITileReadout
	Private TileReadoutFoghornState As HMITileReadout
	Private TileButtonDayNightMode As HMITileButton
	
	' Simulator Timer
	Private SimulatorTimer As Timer
	Private SIMULATOR_TIMER_INTERVAL As Long = 250	' 250ms for precise flash loop timing

	' Simple Toggle State Tracking
	Private IsPowerOn As Boolean = False
	Private IsDaylight As Boolean = True
	Private AmbientLux As Float = 850.0
	Private LensSpeedRPM As Float = 0.0
	Private LampPowerPct As Float = 0.0
	Private CalculatedTemp As Float = 24.0
	
	' Flash Sequence Timing
	Private TimingTicks As Long = 0
	Private InAlarmState As Boolean = False
	
	' Math Variables
	Dim TargetRPM As Float = 0.0
	Dim PulseCycle As Int = 0
	Dim BaseTemp As Float = 24.0
	Dim OperationalHeat As Float = 0.0
	Dim TempNoise As Float
	Dim FogBoost As Float
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

	' Setup Default UI Component Values
	TileReadoutStationStatus.ValueWrapText = True

	TileSliderFogDensity.Value = 10 ' 10% Initial Fog (Clear weather)
	
	TileButtonMainPower.OnText = "SHUT DOWN"
	TileButtonMainPower.OffText = "ENGAGE"
	TileButtonMainPower.Value = False
	
	TileButtonFoghornOverride.OnText = "SILENT"
	TileButtonFoghornOverride.OffText = "AUTO"
	TileButtonFoghornOverride.Value = False

	' Define what the button text means
	TileButtonDayNightMode.OnText = "DAY"
	TileButtonDayNightMode.OffText = "NIGHT"
	
	TileReadoutStationStatus.ValueTextSize = TileReadoutStationStatus.ValueTextSize - 2dip
	
	' Start the app in DAY mode
	TileButtonDayNightMode.Value = True
	IsDaylight = True
	AmbientLux = 850.0
	
	InitializeDiagnosticsGrid
	UpdateUIFields

	SimulatorTimer.Initialize("SimulatorTimer", SIMULATOR_TIMER_INTERVAL)
	SimulatorTimer.Enabled = True
End Sub

Sub SimulatorTimer_Tick
	TimingTicks = TimingTicks + 1
	
	' --- BULLETPROOF DAY/NIGHT SYNCHRONIZATION ---
	' If the button is ON (True), it displays "DAY", so we force daylight variables.
	' If the button is OFF (False), it displays "NIGHT", so we force night variables.
	IsDaylight = TileButtonDayNightMode.Value
	
	If IsDaylight Then
		AmbientLux = 850.0
	Else
		AmbientLux = 25.0
	End If
	' ---------------------------------------------

	' 1. STATION AUTOMATION STATE MACHINE INTERLOCKS
	If Not(IsPowerOn) Then
		' --- SYSTEM OFFLINE ---
		TargetRPM = 0.0
		LampPowerPct = 0.0
        
		TileReadoutStationStatus.Value = "OFFLINE"
		TileReadoutStationStatus.StatusNormal
		TileReadoutFoghornState.Value = "OFF"
		TileReadoutFoghornState.StatusNormal
		TileReadoutLampIntensity.Unit = "%"
	Else
		' --- SYSTEM ONLINE ---
		If IsDaylight Then
			TargetRPM = 0.0
			LampPowerPct = 0.0
            
			TileReadoutStationStatus.Value = "DAYTIME IDLE"
			TileReadoutStationStatus.StatusNormal
			TileReadoutLampIntensity.Unit = "% (DAY LOCK)"
		Else
			' Nighttime Operation
			If TileSliderFogDensity.Value > 80 Then
				TargetRPM = 1.95
			Else
				TargetRPM = 2.0
			End If
			
			FogBoost = (TileSliderFogDensity.Value / 100.0) * 30.0
			Dim PeakIntensity As Float = Min(100.0, 70.0 + FogBoost)
			
			PulseCycle = TimingTicks Mod 16
			If PulseCycle < 8 Then
				LampPowerPct = PeakIntensity
				TileReadoutLampIntensity.Unit = "% (ACTIVE)"
			Else
				LampPowerPct = 0.0
				TileReadoutLampIntensity.Unit = "% (ECLIPSE)"
			End If
			
			TileReadoutStationStatus.Value = "BEACON ACTIVE"
			TileReadoutStationStatus.StatusNormal
		End If

		' 2. AUTOMATED FOGHORN TRIGGER LOGIC
		If TileSliderFogDensity.Value > 65 And Not(TileButtonFoghornOverride.Value) Then
			If (TimingTicks Mod 16) < 4 Then
				TileReadoutFoghornState.Value = "BLASTING"
				TileReadoutFoghornState.StatusWarning
			Else
				TileReadoutFoghornState.Value = "STANDBY"
				TileReadoutFoghornState.StatusNormal
			End If
		Else
			TileReadoutFoghornState.Value = "READY"
			TileReadoutFoghornState.StatusNormal
		End If
	End If

	' 3. SMOOTH MOTOR VARIABLE SPEED DRIVE RAMP CURVES
	If LensSpeedRPM < TargetRPM Then
		LensSpeedRPM = Min(TargetRPM, LensSpeedRPM + 0.1)
	Else If LensSpeedRPM > TargetRPM Then
		LensSpeedRPM = Max(TargetRPM, LensSpeedRPM - 0.1)
	End If

	' 4. DYNAMIC BEARING TEMPERATURE MODEL
	BaseTemp = 24.0
	OperationalHeat = 0.0
	If LensSpeedRPM > 0.05 Then
		OperationalHeat = LensSpeedRPM * 12.0
		If IsDaylight Then OperationalHeat = OperationalHeat + 35.0
	End If
	TempNoise = (Rnd(-40, 41) / 100.0)
	CalculatedTemp = BaseTemp + OperationalHeat + TempNoise

	' 5. HIGH-PERFORMANCE HMI ALARM INTERCEPT
	If CalculatedTemp > 65.0 Then
		If Not(InAlarmState) Then
			InAlarmState = True
			TileReadoutBearingTemp.StatusAlarm
			TileEventViewer.Insert($"CRITICAL: Drive bearing overheating! (${NumberFormat(CalculatedTemp, 1, 1)}°C)"$, HMITileUtils.EVENT_LEVEL_ALARM)
		End If
	Else
		If InAlarmState And CalculatedTemp < 55.0 Then
			InAlarmState = False
			TileReadoutBearingTemp.StatusNormal
			TileEventViewer.Insert("Drive bearing temperatures returned to safe cooling boundaries", HMITileUtils.EVENT_LEVEL_INFO)
		End If
	End If

	' 6. REFRESH ALL READOUT TILES
	TileReadoutLensRPM.Value = NumberFormat(LensSpeedRPM, 1, 2)
	TileReadoutLampIntensity.Value = NumberFormat(LampPowerPct, 1, 0)
	TileReadoutBearingTemp.Value = NumberFormat(CalculatedTemp, 1, 1)
	
	UpdateUIFields
End Sub

Private Sub UpdateUIFields
	TileReadoutLensRPM.Value = NumberFormat(LensSpeedRPM, 1, 2)
	TileReadoutLampIntensity.Value = NumberFormat(LampPowerPct, 1, 0)
	TileReadoutBearingTemp.Value = NumberFormat(CalculatedTemp, 1, 1)
	
	If IsDaylight Then
		TileReadoutAmbientLight.Value = NumberFormat(AmbientLux, 1, 0)
		TileReadoutAmbientLight.Unit = "lx (DAY)"
	Else
		TileReadoutAmbientLight.Value = NumberFormat(AmbientLux, 1, 0)
		TileReadoutAmbientLight.Unit = "lx (NIGHT)"
	End If
End Sub

Private Sub TileButtonMainPower_Click
	IsPowerOn = Not(IsPowerOn)
	TileButtonMainPower.Value = IsPowerOn
	TimingTicks = 0
	
	If IsPowerOn Then
		TileEventViewer.Insert("Station main automation loop energized", HMITileUtils.EVENT_LEVEL_INFO)
	Else
		TileEventViewer.Insert("Station main automation loop cut to storage isolation", HMITileUtils.EVENT_LEVEL_WARNING)
	End If
End Sub

Private Sub TileButtonFoghornOverride_Click
	Dim OverrideActive As Boolean = Not(TileButtonFoghornOverride.Value)
	TileButtonFoghornOverride.Value = OverrideActive
	
	If OverrideActive Then
		TileEventViewer.Insert("Acoustic foghorn compressed-air valves bypassed (SILENT)", HMITileUtils.EVENT_LEVEL_WARNING)
	Else
		TileEventViewer.Insert("Acoustic foghorn safety loops restored to automatic mode", HMITileUtils.EVENT_LEVEL_INFO)
	End If
End Sub

Private Sub TileSliderFogDensity_ValueChanged (Value As Int)
	If Value > 65 Then
		TileEventViewer.Insert($"Meteorological Alert: Heavy marine fog detected (${Value}%)"$, HMITileUtils.EVENT_LEVEL_WARNING)
	End If
End Sub

Private Sub InitializeDiagnosticsGrid
	TileReadoutFlashPattern.Value = "Iso 4s" ' Isophase 4-second total interval signature
	TileReadoutBearingTemp.Value = "OK"
	TileReadoutBearingTemp.StatusNormal
End Sub

' TileButtonDayNightMode
' Toggle between day and night mode.
' NOTE:
' On a standard industrial button, the text should always represent the ACTUAL active state, not the future action.
' If a button says DAY, it must mean it is currently daytime.
' If button shows NIGHT:
' - Ambient Light indicator accurately displays 25 lx (NIGHT).
' - Because night and Power Is active, the system has successfully moved out of idle mode: 
' -		the lens spinning smoothly at 2 rpm, the lamp actively pulsing at 73% (ACTIVE).
' If button shows DAY:
' - Ambient Light indicator correctly reports 850 lx (DAY), the light intensity reads 0 % (DAY LOCK).
' - Automatic Day Lockout: Even though the Main Power Is still set To SHUTDOWN (meaning the automation Loop Is actively engaged), 
' - the photocell lock has automatically cut Power To the lamp And stopped the lens drive (0 rpm).
' - Interlock Verification: Looking at your historical timeline Log, we can see that when you toggled the system, 
' - the temperature briefly spiked To 82.1°C (triggering the critical alarm), but As soon As the motor stopped spinning during the day, 
' - the bearing cooled down safely To 24.2°C And resolved the fault.
Private Sub TileButtonDayNightMode_Click
	TileButtonDayNightMode.Value = Not(TileButtonDayNightMode.Value)
End Sub
