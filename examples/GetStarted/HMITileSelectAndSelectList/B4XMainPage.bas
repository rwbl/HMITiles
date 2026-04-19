B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileSelectAndSelectList
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileSelect and SelectList
' Description:	Shows HMISelect (120x120px), HMISelectList (120x120px) and HMISelectList (120x240px).
'				The items in the list start with 0.
' Date:			2026-04-19
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileSelect As HMITileSelect
	Private TileSelectList As HMITileSelectList
	Private TileSelectListLong As HMITileSelectList
	Private TileLabelSelected As HMITileLabel
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileSelectAndSelectList")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size 120x120px, Select list long 120x240px. Item index starts with 0."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileSelectSetProperties
	TileSelectListSetProperties
	TileSelectListLongSetProperties
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileSelectSetProperties
	TileSelect.AddAll(Array As String("ON", "OFF", "BLINK"))
	TileSelect.Selected = "ON"
End Sub

Private Sub TileSelectListSetProperties
	TileSelectList.AddAll(Array As String("Item1", "Item 2", "Item 3"))
	TileSelectList.CompactMode = True
	TileSelectList.SelectedItemIndex = 0
End Sub

Private Sub TileSelectListLongSetProperties
	For i = 1 To 10
		TileSelectListLong.Add($"Item ${i}"$, i)
	Next
	TileSelectListLong.CompactMode = False
	TileSelectListLong.SelectedItemIndex = 2
	' Log($"TileSelectListLong=${TileSelectListLong.SelectedItem}"$)	'  = "Item 3"
End Sub

' ===================================================
' EVENTS
' ===================================================

Private Sub TileSelect_ValueChanged (Value As Object)
	Log($"[TileSelect_ValueChanged] value=${Value}"$)
	TileLabelSelected.Text = $"Select:${CRLF}${Value}"$
End Sub

Private Sub TileSelectList_ItemClick (Index As Int, Value As Object)
	Log($"[TileSelectList_ItemClick] index=${Index} value=${Value}"$)
	TileLabelSelected.Text = $"List:${CRLF}${Value}"$
End Sub

Private Sub TileSelectListLong_ItemClick (Index As Int, Value As Object)
	Log($"[TileSelectListLong_ItemClick] index=${Index} value=${Value}"$)
	TileLabelSelected.Text = $"List Long:${CRLF}${Value}"$
End Sub
