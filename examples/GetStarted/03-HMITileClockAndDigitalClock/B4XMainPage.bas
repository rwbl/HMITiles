B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileClockAndDigitalClock
' Brief:		Get started with HMITileClock, HMITileDigitalClock
' Description:	Shows analog and digital clock.
' Date:			2026-04-24
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileClock As HMITileClock
	Private TileDigitalClock As HMITileDigitalClock
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITileClock and HMITileDigitalClock")

	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileClockAndDigitalClockSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileClockAndDigitalClockSetProperties
	' TileDigitalClock.
	TileDigitalClock.BlinkColon = False
End Sub


' ===================================================
' EVENTS
' ===================================================

Private Sub TileDigitalClock_Click
	Log($"[TileDigitalClock_Click] ticks=${TileDigitalClock.CurrentTime} time=${DateTime.Time(TileDigitalClock.CurrentTime)}"$)
End Sub

Private Sub TileClock_Click
	Log($"[TileClock_Click]  ticks=${TileDigitalClock.CurrentTime}"$)
End Sub