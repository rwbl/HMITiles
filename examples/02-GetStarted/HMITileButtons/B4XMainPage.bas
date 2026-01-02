B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
'Ctrl + click to export as zip: ide://run?File=%B4X%\Zipper.jar&Args=Project.zip
#End Region

Sub Class_Globals
	Private Root As B4XView
	Private xui As XUI
	Private TileButtonOnOff As HMITileButton
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	B4XPages.SetTitle(Me, "HMITiles Library Get Started")
	
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)	
	' Set initial properties
	TileButtonOnOff.State = False
	TileButtonOnOff.StateText = "OFF"
End Sub

Private Sub TileButtonOnOff_Click
	' Reverse the button state
	TileButtonOnOff.SetState(TileButtonOnOff.State)
	' Set the button state text according button state
	TileButtonOnOff.StateText = IIf(TileButtonOnOff.State, "ON", "OFF")
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

