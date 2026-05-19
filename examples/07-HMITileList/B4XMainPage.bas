B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileList
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileList
' Description:	Shows HMIList (120x240px).
'				The items in the list start with 0.
' Date:			2026-04-20
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileLabelSelected As HMITileLabel
	Private TileList As HMITileList
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileList")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px, List long 120x240px, 120x360px. Item index starts with 0."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileListSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileListSetProperties
	' Add items
	TileList.Add("Item 1", "Info", 1)
	TileList.Add("Item 2", "Info", 2)
	TileList.Add("Item 3", "Info", 3)
	TileList.Add("Item 4", "Info", 4)
	TileList.Add("Item 5", "Info", 5)
	
	' Select item as default
	TileList.SelectedItemIndex = 2
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileList_ItemClick (Index As Int, Value As Object)
	Log($"[TileList_ItemClick] index=${Index} value=${Value}"$)
	TileLabelSelected.Text = $"List:${CRLF}${Value}"$
End Sub
