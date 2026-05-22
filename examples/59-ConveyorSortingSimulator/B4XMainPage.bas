B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' File:         ConveyorSortingSimulator
' Brief:        HMITile example application showing a conveyor sorting simulator
' Date:         2026-05-22
' Author:       Robert W.B. Linn (c) 2026 MIT
' Description:  A High-Performance Industrial HMI example application simulating a 
'               factory material-handling conveyor belt line driven by a VFD motor.
'               
'               Key features include:
'               - Main processing state flow tracking (IDLE -> RUNNING -> JAMMED).
'               - Integrated Variable Frequency Drive (VFD) motor ramp curve modeling.
'               - Live discrete production metrics tracking item throughput totals and rates.
'               - Material handling safety diagnostics tracking photo-eye bottlenecks and part checks.
'               - Clean 4-row high-performance design scheme emphasizing muted status tracking.
'               - Live historical events feed monitoring operators' actions and fault injections.
'
' Layout:
'				Row 1: Line Control & Status (Inputs & Critical State)
'				* TILE 1 (Status): LINE STATUS ("IDLE" -> "RUNNING" -> "JAMMED" -> "MAINTENANCE")
'				* TILE 2 (Control Button): CONVEYOR Power Toggle ("START" / "STOP")
'				* TILE 3 (Control Button): JAM SIMULATOR Latch ("CLEAR" / "SIMULATE JAM")
'
'				Row 2: Process Telemetry (VFD Motor Outputs)
'				* TILE 4 (Readout): TOTAL COUNT (Total processed packages count)
'				* TILE 5 (Readout): THROUGHPUT RATE (Live packages processed per minute)
'				* TILE 6 (Readout): MOTOR FREQUENCY (VFD output tracking from 0.0 Hz To 60.0 Hz)
'
'				Row 3: Maintenance Status Grid (Component Wear Tracking)
'				* TILE 7 (Readout): BELT ALIGNMENT ("OK" / "MISALIGNED")
'				* TILE 8 (Readout): BEARING TEMP ("OK" / "HOT")
'				* TILE 9 (Readout): PHOTO-EYE SENSOR ("CLEAR" / "BLOCKED")
'
'				Row 4: Operational Speed Input
'				* TILE 10 (Slider): TARGET MOTOR SPEED (Conveyor speed setting from 0% To 100%)

#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region
' See the list of page related events in the B4XPagesManager object. The event name is B4XPage.

#Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	Private VERSION As String = "Conveyor Sorting Simulator v20260522"
	
	' UI Lib
	Private xui As XUI
	' UI Base
	Private Root As B4XView
	' UI HMITiles
	Private TileEventViewer As HMITileEventViewer
	Private TileSliderTargetSpeed As HMITileSlider
	Private TileButtonConveyorPower As HMITileButton
	Private TileButtonJamSimulator As HMITileButton
	Private TileReadoutLineStatus As HMITileReadout
	Private TileReadoutTotalCount As HMITileReadout
	Private TileReadoutThroughputRate As HMITileReadout
	Private TileReadoutMotorFrequency As HMITileReadout
	Private TileReadoutBeltAlignment As HMITileReadout
	Private TileReadoutBearingTemp As HMITileReadout
	Private TileReadoutPhotoEye As HMITileReadout

	' Simulator Timer
	Private SimulatorTimer As Timer
	Private SIMULATOR_TIMER_INTERVAL As Long = 500	' 500ms

	' Process Variables
	Private IsPowerOn As Boolean = False
	Private IsJammed As Boolean = False
	Private InAlarmState As Boolean = False
	
	Private CurrentFrequency As Float = 0.0
	Private ItemCounter As Long = 0
	Private PackagesPerMin As Float = 0.0
	Private AccumulatorFraction As Float = 0.0
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

	' Setup Default UI Values
	TileSliderTargetSpeed.Value = 75 ' 75% Speed Default
	
	TileButtonConveyorPower.OnText = "STOP"
	TileButtonConveyorPower.OffText = "START"
	TileButtonConveyorPower.Value = False
	
	TileButtonJamSimulator.OnText = "CLEAR"
	TileButtonJamSimulator.OffText = "SIMULATE"
	TileButtonJamSimulator.Value = False

	InitializeMaintenanceGrid
	UpdateUIFields

	SimulatorTimer.Initialize("SimulatorTimer", SIMULATOR_TIMER_INTERVAL)
	SimulatorTimer.Enabled = True
End Sub

Sub SimulatorTimer_Tick
	Dim TargetSpeed As Float = TileSliderTargetSpeed.Value ' 0 to 100
	Dim MaxFrequency As Float = 60.0 ' 60Hz Max Motor Speed
	Dim TargetFreq As Float = (TargetSpeed / 100.0) * MaxFrequency
	
	' 1. STATE MACHINE & VFD MOTOR RAMP LOGIC
	If IsJammed Then
		' Jammed: Instantly kill motor speed and zero out rates
		CurrentFrequency = Max(0, CurrentFrequency - 15.0) ' Rapid emergency deceleration
		PackagesPerMin = 0.0
		
		TileReadoutLineStatus.Value = "JAMMED"
		TileReadoutPhotoEye.Value = "BLOCKED"
		TileReadoutPhotoEye.StatusWarning
		
		If Not(InAlarmState) Then
			InAlarmState = True
			TileReadoutLineStatus.StatusAlarm
			TileEventViewer.Insert("ALARM: Sorting sorting photo-eye sensor blocked!", HMITileUtils.EVENT_LEVEL_ALARM)
		End If
		
	Else If IsPowerOn Then
		' Running: Smoothly ramp frequency to target speed (VFD Accel Curve)
		CurrentFrequency = CurrentFrequency + (TargetFreq - CurrentFrequency) * 0.2
		
		TileReadoutLineStatus.Value = "RUNNING"
		TileReadoutLineStatus.StatusNormal
		TileReadoutPhotoEye.Value = "CLEAR"
		TileReadoutPhotoEye.StatusNormal
		InAlarmState = False
		
		' Calculate sorting throughput proportional to belt frequency
		Dim MaxPackagesPerMin As Float = 45.0
		PackagesPerMin = (CurrentFrequency / MaxFrequency) * MaxPackagesPerMin
		
		' Add package counting noise simulation
		If CurrentFrequency > 5.0 Then
			Dim Noise As Float = Rnd(-4, 5)
			PackagesPerMin = Max(0, PackagesPerMin + Noise)
			
			' Accumulate floating fraction into whole integers
			' 500ms is 1/120th of a minute
			AccumulatorFraction = AccumulatorFraction + (PackagesPerMin / 120.0)
			If AccumulatorFraction >= 1.0 Then
				Dim NewItems As Int = Floor(AccumulatorFraction)
				ItemCounter = ItemCounter + NewItems
				AccumulatorFraction = AccumulatorFraction - NewItems
			End If
		Else
			PackagesPerMin = 0.0
		End If
	Else
		' Idle: Ramp down smoothly to zero (Decel Curve)
		CurrentFrequency = Max(0, CurrentFrequency - 5.0)
		PackagesPerMin = 0.0
		TileReadoutLineStatus.Value = "IDLE"
		TileReadoutLineStatus.StatusNormal
	End If
	
	' 2. REFRESH ALL HMI TILES
	UpdateUIFields
End Sub

Private Sub UpdateUIFields
	TileReadoutMotorFrequency.Value = NumberFormat(CurrentFrequency, 1, 1)
	TileReadoutTotalCount.Value = NumberFormat(ItemCounter, 1, 0)
	TileReadoutThroughputRate.Value = NumberFormat(PackagesPerMin, 1, 0)
End Sub

Private Sub TileButtonConveyorPower_Click
	IsPowerOn = Not(IsPowerOn)
	TileButtonConveyorPower.Value = IsPowerOn
	
	If IsPowerOn Then
		TileEventViewer.Insert("Conveyor mainline motor system energized", HMITileUtils.EVENT_LEVEL_INFO)
	Else
		TileEventViewer.Insert("Conveyor mainline motor ordered to standard stop", HMITileUtils.EVENT_LEVEL_INFO)
	End If
End Sub

Private Sub TileButtonJamSimulator_Click
	IsJammed = Not(IsJammed)
	TileButtonJamSimulator.Value = IsJammed
	
	If IsJammed Then
		TileEventViewer.Insert("User injection: Simulating box blockage on sort line", HMITileUtils.EVENT_LEVEL_WARNING)
	Else
		TileEventViewer.Insert("Sorting lane blockage removed. System fault cleared.", HMITileUtils.EVENT_LEVEL_INFO)
	End If
End Sub

Private Sub TileSliderTargetSpeed_ValueChanged (Value As Int)
	TileEventViewer.Insert($"Conveyor VFD target speed speed set to ${Value}%"$, HMITileUtils.EVENT_LEVEL_INFO)
End Sub

Private Sub InitializeMaintenanceGrid
	TileReadoutBeltAlignment.Value = "OK"
	TileReadoutBeltAlignment.StatusNormal
	
	TileReadoutBearingTemp.Value = "OK"
	TileReadoutBearingTemp.StatusNormal
	
	TileReadoutPhotoEye.Value = "CLEAR"
	TileReadoutPhotoEye.StatusNormal
End Sub
