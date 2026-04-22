B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileSPPV
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileSPPV
' Description:	Shows several SPPV.
' Date:			2026-04-22
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileSPPV1 As HMITileSPPV
	Private TileSPPV2 As HMITileSPPV
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileSPPV")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: 120x120px. Tile color Yellow=Warning, Red=Alarm."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileSPPVsSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileSPPVsSetProperties
	' SPPV 1
	TileSPPV1.PV = 70

	' SPPV 2 - ReadOnly, set properties via code
	' Set the deviation limit first, so the tile style is set to alarm, because
	' the abs deviation PV-SP = 3 which is > 2 (DeviationLimit)
	TileSPPV2.DeviationLimit = 2
	TileSPPV2.PV = 6
	TileSPPV2.SP = 3
	TileSPPV2.Max = 10
	TileSPPV2.Min = 0
End Sub


' ===================================================
' EVENTS
' ===================================================

Private Sub TileSPPV1_ValueChanged (Value As Float)
	Log($"[TileSPPV1_ValueChanged] value=${Value} deviation=${TileSPPV1.Deviation} deviationlimit=${TileSPPV1.deviationlimit}"$)
End Sub

Private Sub TileSPPV1_SetPointChanged (Value As Float)
	Log($"[TileSPPV1_SetPointChanged] value=${Value} deviation=${TileSPPV1.Deviation} deviationlimit=${TileSPPV1.deviationlimit}"$)
End Sub

Private Sub TileSPPV2_ValueChanged (Value As Float)
	Log($"[TileSPPV2_ValueChanged] value=${Value} deviation=${TileSPPV2.Deviation} deviationlimit=${TileSPPV2.deviationlimit}"$)
End Sub

Private Sub TileSPPV2_SetPointChanged (Value As Float)
	Log($"[TileSPPV2_SetPointChanged] value=${Value} deviation=${TileSPPV2.Deviation} deviationlimit=${TileSPPV2.deviationlimit}"$)
End Sub

