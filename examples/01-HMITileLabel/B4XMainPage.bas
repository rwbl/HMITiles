B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileLabel
' Brief:		Get started with HMITileLabel.
' Description:	Shows various label examples with different states.
' Date:			2026-04-23
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	Private xui As XUI
	Private Root As B4XView
	Private TileLabelAlarm As HMITileLabel
	Private TileLabelNormal As HMITileLabel
	Private TileLabelWarning As HMITileLabel
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITileLabel")
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)	
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileLabelNormal_Click
	Log($"[TileLabelNormal_Click]"$)
End Sub

Private Sub TileLabelWarning_Click
	Log($"[TileLabelWarning_Click]"$)
End Sub

Private Sub TileLabelAlarm_Click
	Log($"[TileLabelAlarm_Click]"$)
End Sub
