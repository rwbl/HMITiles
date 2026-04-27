B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileImageAndImageIcon
' Brief:		Get started with HMITileImage and HMITileImageIcon
' Description:	Shows image and image icons.
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
	B4XPages.SetTitle(Me, "HMITileImage and HMITileImageIcon")

	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileImageAndImageIconSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileImageAndImageIconSetProperties
End Sub


' ===================================================
' EVENTS
' ===================================================

'Private Sub TileDigitalClock_Click
'	Log($"[TileDigitalClock_Click] ticks=${TileDigitalClock.CurrentTime} time=${DateTime.Time(TileDigitalClock.CurrentTime)}"$)
'End Sub
