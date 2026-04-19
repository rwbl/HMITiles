B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileSeekBar
' Project:		HMITiles B4X library
' Brief:		Get started with the HMITileStatusIndicators.
' Description:	Set the state of up-to 9 status indicators.
' Date:			2026-04-19
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private TileStatusIndicatorsPumps As HMITileStatusIndicators
	Private TileStatusIndicatorsFilters As HMITileStatusIndicators
	Private TileButtonFilterChangeState As HMITileButton
	Private LabelLegend As B4XView
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITiles Library Get Started - HMITileStatusIndicators")
	
	LabelLegend.Text = $"Legend${CRLF}White=Ok, Dark Gray=Error, Light Gray=Disabled"$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here	
	TileStatusIndicatorsPumpsSetProperties
	
	TileStatusIndicatorsFiltersSetProperties
End Sub

Private Sub TileStatusIndicatorsPumpsSetProperties
	TileStatusIndicatorsPumps.SetData(1, 1, "P1", "Pump 1 Feed C-1101", TileStatusIndicatorsPumps.STATE_FALSE, True)
	TileStatusIndicatorsPumps.SetData(1, 3, "P3", "Pump 3 Slurry C-1101", TileStatusIndicatorsPumps.STATE_DISABLED, True)
	TileStatusIndicatorsPumps.SetData(2, 1, "P4", "Pump 4 Water Treatment I", TileStatusIndicatorsPumps.STATE_TRUE, True)
	TileStatusIndicatorsPumps.SetData(3, 3, "P9", "Pump 9 Water Treatment II ", TileStatusIndicatorsPumps.STATE_FALSE, True)
End Sub

Private Sub TileStatusIndicatorsFiltersSetProperties
	TileStatusIndicatorsFilters.SetData(1, 1, "F-11", "Filter 1 Water Treatment I", TileStatusIndicatorsPumps.STATE_TRUE, True)
	TileStatusIndicatorsFilters.SetData(1, 2, "F-12", "Filter 2 Water Treatment I", TileStatusIndicatorsPumps.STATE_TRUE, True)
	TileStatusIndicatorsFilters.SetData(1, 3, "F-13", "Filter 3 Water Treatment I", TileStatusIndicatorsPumps.STATE_TRUE, True)
	TileStatusIndicatorsFilters.SetData(2, 1, "F-21", "Filter 1 Water Treatment II", TileStatusIndicatorsPumps.STATE_TRUE, True)
	TileStatusIndicatorsFilters.SetData(2, 2, "F-22", "Filter 2 Water Treatment II", TileStatusIndicatorsPumps.STATE_FALSE, True)
	TileStatusIndicatorsFilters.SetData(2, 3, "F-23", "Filter 3 Water Treatment II", TileStatusIndicatorsPumps.STATE_TRUE, True)
End Sub


Private Sub TileButtonFilterChangeState_Click
	Dim row As Int = Rnd(1,3)	' 1,2
	Dim col As Int = Rnd(1,4)	' 1,2,3
	Dim state As Int = Rnd(0,2)	' 0, 1
	TileStatusIndicatorsFilters.SetState(row, col, state)
	Log($"[TileButtonFilterChangeState] row=${row} col=${col} state=${state} ${TileStatusIndicatorsFilters.GetStateText(state)}"$)
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileStatusIndicatorsPumps_Click(data As IndicatorData)
	If data.State == TileStatusIndicatorsPumps.STATE_DISABLED Then Return
	Dim sf As Object = xui.Msgbox2Async($"${data.description}${CRLF}${TileStatusIndicatorsPumps.GetStateText(data.State)}"$, $"Status ${data.text}"$, "OK", "", "", Null)
	Wait For (sf) Msgbox_Result (Result As Int)
End Sub

Private Sub TileStatusIndicatorsFilters_Click(data As IndicatorData)
	If data.State == TileStatusIndicatorsPumps.STATE_DISABLED Then Return
	Dim sf As Object = xui.Msgbox2Async($"${data.description}${CRLF}${TileStatusIndicatorsFilters.GetStateText(data.State)}"$, $"Status ${data.text}"$, "OK", "", "", Null)
	Wait For (sf) Msgbox_Result (Result As Int)
End Sub
