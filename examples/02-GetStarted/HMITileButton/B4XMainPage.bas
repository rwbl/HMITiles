B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileButton
' Brief:		Example B4J program for the HMITiles B4X library.
' Description:	Show usage of the HMITileButton.
' Date:			2025-01-02
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' Button ON OFF state text
	Private BUTTON_STATETEXT_ON As String = "ON"
	Private BUTTON_STATETEXT_OFF As String = "OFF"

	' Button ON OFF or TOGGLE FontAwesome Icons
	Private BUTTON_FA_ICON_ON As String = Chr(0xF205)
	Private BUTTON_FA_ICON_OFF As String = Chr(0xF204)
	
	Private xui As XUI
	Private Root As B4XView
	Private TileButtonOnOff As HMITileButton
	Private TileButtonToggle As HMITileButton
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITiles Library Get Started - HMITileButton")
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)	
	
	' Button On Off
	TileButtonOnOff.State = False
	TileButtonOnOff.StateText = BUTTON_STATETEXT_OFF
	
	' Toggle Button FontAwesome font
	TileButtonToggle.SetStateFontFontAwesome
	TileButtonToggle.State = False
	TileButtonToggle.StateText = BUTTON_FA_ICON_OFF
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileButtonOnOff_Click
	' Reverse the button state
	TileButtonOnOff.SetState(TileButtonOnOff.State)
	' Set the button state text according button state
	TileButtonOnOff.StateText = IIf(TileButtonOnOff.State, _ 
									BUTTON_STATETEXT_ON, _ 
									BUTTON_STATETEXT_OFF)
	' Take action according button state:
	If TileButtonOnOff.State Then
		' Do something
	Else
		' Do something else
	End If
	' Log to the B4J IDE
	Log($"[TileButtonOnOff] state=${TileButtonOnOff.State}, statetext=${TileButtonOnOff.StateText}"$)
	' [TileButtonOnOff] state=true, statetext=ON
End Sub

' Button Click Event
' Button with fontawesome looks like a toggle switch.
' Important to set state
Private Sub TileButtonToggle_Click
	' Reverse the button state
	TileButtonToggle.SetState(TileButtonToggle.State)
	' Set the button state text according button state
	TileButtonToggle.StateText = IIf(TileButtonToggle.State, _
									 BUTTON_FA_ICON_ON, _
									 BUTTON_FA_ICON_OFF)
	' Take action according button state:
	If TileButtonToggle.State Then
		' Do something
	Else
		' Do something else
	End If
	' Log to the B4J IDE
	Log($"[TileButtonToggle] state=${TileButtonToggle.State}"$)
	' [TileButtonToggle] state=true
End Sub
