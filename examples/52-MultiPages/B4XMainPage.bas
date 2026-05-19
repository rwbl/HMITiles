B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			MultiPages
' Brief:		Example B4J program for the HMITiles B4X library.
' Description:	Show usage of B4X multi pages.
'				Concept:
'				The main-page has a sub-page(s) selection toolbar.
'				A sub-page has a single selection button "Overview" to return to the main-page.
'				So Overview > Drill-down > Return.
'				- Navigation buttons default to 96×96 px.
'				- Page-select button color. Use the standard HMITileButton color. No special color.
'				- Page-select button: Icon + short title > 1 word, noun, Capitalized, ≤ 10 characters
'				- Sub-page Back / Home button: 
'					- ONE standard name HMITileButtonBack
'					- Icon + text: Icon = FontAwesome: fa-arrow-left, Text = Overview
' Date:			2026-01-14
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private TileNavButtonEvents As HMITileNavButton
	Private TileNavButtonEvents2 As HMITileNavButton
	
	' B4XPages
	Private EventViewerPage As B4XEventViewerPage
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	' Mainpage Root
	Root = Root1
	Root.LoadLayout("MainPage")

	' Sub-Pages
	EventViewerPage.Initialize
	' Page ID, Page Object (defined in class_globals)
	B4XPages.AddPage("events", EventViewerPage)

	' UI additional settings
	B4XPages.SetTitle(Me, "MultiPages")
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)	
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileNavButtonEvents_Click
	B4XPages.ShowPageAndRemovePreviousPages("events")
End Sub

Private Sub TileNavButtonEvents2_Click
	B4XPages.ShowPageAndRemovePreviousPages("events")
End Sub

