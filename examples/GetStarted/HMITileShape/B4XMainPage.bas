B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileShape
' Brief:		Get started with HMITileShape
' Description:	Shows various shapes.
' Date:			2026-04-24
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITileShape")

	LabelLegend.Text = $"HMITiles Get Started"$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
End Sub

' ================================================================
' PROPERTIES
' ================================================================

' ===================================================
' EVENTS
' ===================================================
