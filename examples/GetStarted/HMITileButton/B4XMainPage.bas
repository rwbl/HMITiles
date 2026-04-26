B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileButton
' Brief:		Get started with the HMITileButton.
' Description:	Show various button examples
' Date:			2026-01-04
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private TileButtonOnOff As HMITileButton
	Private TileButtonToggle As HMITileButton
	Private TileButtonAlarm As HMITileButton
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITileButton")
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)	
	
	' Button On Off
	TileButtonOnOff.Value = False
	
	' Toggle Button FontAwesome font
	TileButtonToggle.ValueFontFontAwesome
	TileButtonToggle.OnText	= HMITileUtils.ICON_ON
	TileButtonToggle.OffText = HMITileUtils.ICON_OFF
	TileButtonToggle.Value = False

	' Button Alarm
	TileButtonAlarm.StatusAlarm
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileButtonOnOff_Click
	' Reverse the button state
	TileButtonOnOff.Value = Not(TileButtonOnOff.Value)
	' Take action according button state:
	If TileButtonOnOff.Value Then
		' Do something
	Else
		' Do something else
	End If
	' Log to the B4J IDE
	Log($"[TileButtonOnOff] value=${TileButtonOnOff.value}"$)
	' [TileButtonOnOff] state=true, statetext=ON
End Sub

' Button Click Event
' Button with fontawesome looks like a toggle switch.
' Important to set state.
Private Sub TileButtonToggle_Click
	' Reverse the button staus
	TileButtonToggle.Value = Not(TileButtonToggle.Value)
	' Take action according button state:
	If TileButtonToggle.Value Then
		' Do something
	Else
		' Do something else
	End If
	' Log to the B4J IDE
	Log($"[TileButtonToggle] value=${TileButtonToggle.Value}"$)
	' [TileButtonToggle] status=true
End Sub

Private Sub TileButtonAlarm_Click
	' Reverse the button staus
	TileButtonAlarm.Value = Not(TileButtonAlarm.Value)
	' Check state
	If TileButtonAlarm.Value Then
		TileButtonAlarm.StatusAlarm
	Else
		TileButtonAlarm.StatusNormal
	End If
	Log($"[TileButtonAlarm] value=${TileButtonAlarm.Value}"$)
End Sub
