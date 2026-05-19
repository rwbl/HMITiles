B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			SolarInfoPanel
' Brief:		HMITile example application showing solar info panel
' Date:			2026-05-17
' Author:		Robert W.B. Linn (c) 2026 MIT
' Description:	Show data from the solar unit:
'				"powerfromsolar", "powerfromgrid", "powertogrid", "powertohouse", "powertobattery", "powerfrombattery", "batterychargestate", "powerdatestamp", "powertimestamp"
'				The data is retrieved via HTTP GET request to Home Assistant Addon Node-Red every NN minutes.
'				"http://homeassistant.local:1880/endpoint/solarinfo?data=all"
'				which response is a CSV string:
'				5088,0,4864,224,0,0,100,20260429,1612
'				and parsed into values used by HMITileGauge & Trend.
'				Display:
'				SOLAR	HOUSE
'				GRID	BATTERY
' HMITiles: 	HMITileGauge, HMITileTrend
' ================================================================

Sub Class_Globals
	Private Const VERSION	As String = "SolarInfoPanel v20260517"
	Private ABOUT			As String = $"HMITiles (c) 2026 Robert W.B. Linn - MIT"$

	' Core
	Private xui As XUI
	Private Root As B4XView

	' HMITiles
	Private TileButtonTimer As HMITileButton
	Private TileGaugeBatteryChargeState As HMITileGauge
	Private TileGaugePowerFromBattery As HMITileGauge
	Private TileGaugePowerFromGrid As HMITileGauge
	Private TileGaugePowerFromSolar As HMITileGauge
	Private TileGaugePowerToBattery As HMITileGauge
	Private TileGaugePowerToGrid As HMITileGauge
	Private TileGaugePowerToHouse As HMITileGauge
	Private TileTrendBatteryChargeState As HMITileTrend
	Private TileTrendPowerFromBattery As HMITileTrend
	Private TileTrendPowerFromGrid As HMITileTrend
	Private TileTrendPowerFromSolar As HMITileTrend
	Private TileTrendPowerToGrid As HMITileTrend
	Private TileTrendPowerToHouse As HMITileTrend
	Private TileTrendPowerToBattery As HMITileTrend
	Private TileLabelSampleTime As HMITileLabelTitle
	Private LabelAbout As B4XView

	' Datarequest
	' B4A: To avoid CLEARTEXT communication to IP not permitted by network security policy annd to manifest:
	' CreateResourceFromFile(Macro, Core.NetworkClearText)
	Private URL_SOLAR_DATA_REQUEST As String = "http://homeassistant.local:1880/endpoint/solarinfo?data=all"
	Private DataRequestTimer As Timer
	Private DATA_REQUEST_INTERVAL As Long = 1000 * 60	' Every 60 seconds
	' Private DATA_REQUEST_INTERVAL As Long = 1000 * 10	' Every 10 seconds for tests
	
	' Thesholds
	Private THRESHOLD_POWER_FROM_SOLAR_WARNING 		As Int = 500	' If lessequal then set tile status warning
	Private THRESHOLD_POWER_FROM_SOLAR_ALARM 		As Int = 1		' If equal then set tile status alarm
	Private THRESHOLD_POWER_FROM_GRID_WARNING 		As Int = 0		' If greater 0 then set tile status warning
	Private THRESHOLD_BATTERY_CHARGE_STATE_WARNING	As Int = 10		' if lessequal 10 then set tile status warning
	Private THRESHOLD_BATTERY_CHARGE_STATE_ALARM	As Int = 1		' if lessequalthen set tile status alarm
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	
	' B4XPages
	B4XPages.SetTitle(Me, VERSION)
	#If B4J
	B4XPages.GetNativeParent(Me).Resizable = False	
	#End If
	Root.Color = HMITileUtils.COLOR_BACKGROUND_SCREEN
	' Labels
	LabelAbout.Text = ABOUT

	' Timer
	DataRequestTimer.Initialize("DataRequestTimer", DATA_REQUEST_INTERVAL)
	DataRequestTimer.Enabled = False
	
	' HMITiles
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Set text size of the label using custom property with index 0 (label)
	TileLabelSampleTime.TextSize = 48
	' Trend title text to info
	TileTrendBatteryChargeState.SetTitleColorInfo
	TileTrendPowerFromBattery.SetTitleColorInfo
	TileTrendPowerFromGrid.SetTitleColorInfo
	TileTrendPowerFromSolar.SetTitleColorInfo
	TileTrendPowerToGrid.SetTitleColorInfo
	TileTrendPowerToHouse.SetTitleColorInfo
	TileTrendPowerToBattery.SetTitleColorInfo

	' Start Timer
	TileButtonTimer_Click
End Sub

' ===================================================
' DATAREQUEST
' ===================================================

Private Sub DataRequestTimer_Tick
	CallSub(Me, "GetData")	
End Sub

Private Sub GetData As ResumableSub
	Dim result As Boolean
	Dim request As HttpJob

	Try
		request.Initialize("", Me)
		request.Download(URL_SOLAR_DATA_REQUEST)
		Wait For (request) JobDone(request As HttpJob)
		If request.Success Then
			Log($"[GetData][I] ${request.GetString}"$)
			' [GetData][I] 5088,0,4864,224,0,0,100,20260429,1612
			UpdateTiles(request.GetString)
			result = True
		Else
			Log($"[GetData][E] ${LastException}"$)
			result = False
		End If
		request.Release		
	Catch
		Log($"[GetData][E] ${LastException}"$)
		result = False
	End Try
	Return result
End Sub

' ===================================================
' HMITILES
' ===================================================

'// Create values Array with 9 items
'var values = flow.get(["powerfromsolar", "powerfromgrid", "powertogrid", "powertohouse", "powertobattery", "powerfrombattery", "batterychargestate", "powerdatestamp", "powertimestamp"]);
'**Example CSV string returned As message**
'2352,0,2071,281,0,0,100,20250414,1156
'5088,0,4864,224,0,0,100,20260429,1612
Private Sub UpdateTiles(data As String)
	Dim values() As String = Regex.Split(",", data)

	' Check value array size
	If values.Length < 9 Then
		TileLabelSampleTime.Text = $"Sample data incorrect"$
		TileLabelSampleTime.StatusAlarm
		Return
	Else
		TileLabelSampleTime.StatusNormal
	End If

	TileGaugePowerFromSolar.Value		= values(0)
	TileTrendPowerFromSolar.Add(TileGaugePowerFromSolar.Value)
	TileGaugePowerFromGrid.Value 		= values(1)
	TileTrendPowerFromGrid.Add(TileGaugePowerFromGrid.Value)
	TileGaugePowerToGrid.Value 			= values(2)
	TileTrendPowerToGrid.Add(TileGaugePowerToGrid.Value)
	TileGaugePowerToHouse.Value 		= values(3)
	TileTrendPowerToHouse.Add(TileGaugePowerToHouse.Value)
	TileGaugePowerToBattery.Value 		= values(4)
	TileTrendPowerToBattery.Add(TileGaugePowerToBattery.Value)
	TileGaugePowerFromBattery.Value		= values(5)
	TileTrendPowerFromBattery.Add(TileGaugePowerFromBattery.Value)
	TileGaugeBatteryChargeState.Value	= values(6)
	TileTrendBatteryChargeState.Add(TileGaugeBatteryChargeState.Value)
	TileLabelSampleTime.Text			= $"${ConvertTimeToTimeString(values(8))}"$
	
	CheckThresholds
End Sub

' Check the thresholds and set the tile status.
Private Sub CheckThresholds

	'TileGaugePowerFromSolar.Value = THRESHOLD_POWER_FROM_SOLAR_ALARM - 1
	If TileGaugePowerFromSolar.Value < THRESHOLD_POWER_FROM_SOLAR_ALARM Then
		TileGaugePowerFromSolar.StatusAlarm
	Else If TileGaugePowerFromSolar.Value < THRESHOLD_POWER_FROM_SOLAR_WARNING Then
		TileGaugePowerFromSolar.StatusWarning
	Else
		TileGaugePowerFromSolar.StatusNormal
	End If

	'TileGaugePowerFromGrid.Value = THRESHOLD_POWER_FROM_GRID_WARNING + 1
	If TileGaugePowerFromGrid.Value > THRESHOLD_POWER_FROM_GRID_WARNING Then
		TileGaugePowerFromGrid.StatusWarning
	Else
		TileGaugePowerFromGrid.StatusNormal
	End If
	
	'TileGaugeBatteryChargeState.Value = THRESHOLD_BATTERY_CHARGE_STATE_WARNING -1
	If TileGaugeBatteryChargeState.Value < THRESHOLD_BATTERY_CHARGE_STATE_ALARM Then
		TileGaugeBatteryChargeState.StatusAlarm
	Else If TileGaugeBatteryChargeState.Value < THRESHOLD_BATTERY_CHARGE_STATE_WARNING Then
		TileGaugeBatteryChargeState.StatusWarning
	Else
		TileGaugeBatteryChargeState.StatusNormal
	End If
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileButtonTimer_Click
	TileButtonTimer.Value = Not(TileButtonTimer.Value)
	DataRequestTimer.Enabled = TileButtonTimer.Value
	DataRequestTimer_Tick
End Sub

' HELPER

'Convert Ticks as Long to time string HH:mm:ss
'Example with number of seconds as parameter:               
'Dim d As Long = 60
'$"Duration ${ConvertTicksToTimeString(d * DateTime.TicksPerSecond)}"$
'Result: 00:01:00
Sub ConvertTicksToTimeString(t As Long, showsecs As Boolean) As String
	Dim result As String
	Dim  hours, minutes, seconds As Int
	hours = t / DateTime.TicksPerHour
	minutes = (t Mod DateTime.TicksPerHour) / DateTime.TicksPerMinute
	If showsecs Then
		seconds = (t Mod DateTime.TicksPerMinute) / DateTime.TicksPerSecond
		result = $"${NumberFormat(hours, 2, 0)}:${NumberFormat(minutes, 2, 0)}:${NumberFormat(seconds, 2, 0)}"$
	Else
		result = $"${NumberFormat(hours, 2, 0)}:${NumberFormat(minutes, 2, 0)}"$
	End If
	Return result
End Sub

'Convert HHMM string to time string HH:mm
'Log($"${ConvertTimeToTimeString(1120)}"$)
'Output: 11:20
Sub ConvertTimeToTimeString(t As String) As String
	Dim h As Int = t.SubString2(0,2)
	Dim m As Int = t.SubString2(2,4)
	Dim s As Long = (h * 3600) + (m * 60)
	Return ConvertTicksToTimeString(s* DateTime.TicksPerSecond, False)
End Sub

