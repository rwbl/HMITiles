B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileTimer
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileTimers
' Description:	Shows 2 timers count down and count up..
' Date:			2026-04-22
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView

	Private TileTimerDown As HMITileTimer
	Private TileTimerUp As HMITileTimer
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileReadout")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileTimersSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileTimersSetProperties
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileTimerDown_Start
	Log($"[TileTimerDown_Start] startvalue=${TileTimerDown.StartValue} stopvalue=${TileTimerDown.StopValue}"$)
End Sub

Private Sub TileTimerDown_Stop
	Log($"[TileTimerDown_Stop]"$)
End Sub

Private Sub TileTimerDown_Finished
	Log($"[TileTimerDown_Finished]"$)
End Sub

Private Sub TileTimerUp_Start
	Log($"[TileTimerUp_Start] startvalue=${TileTimerUp.StartValue} stopvalue=${TileTimerUp.StopValue}"$)
End Sub

Private Sub TileTimerUp_Stop
	Log($"[TileTimerUp_Stop]"$)
End Sub

Private Sub TileTimerUp_Finished
	Log($"[TileTimerUp_Finished]"$)
End Sub
