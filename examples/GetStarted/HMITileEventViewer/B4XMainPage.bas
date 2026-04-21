B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			HMITileEventViewer
' Project:		HMITiles B4X library
' Brief:		Get started with HMITileEventViewer.
' Description:	Shows several event viewers.
' Date:			2026-04-21
' Author:		Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Class_Globals
	' UI	
	Private xui As XUI
	Private Root As B4XView
	Private LabelLegend As B4XView
	Private TileEventViewer As HMITileEventViewer
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("mainpage")
	B4XPages.SetTitle(Me, "HMITileEventViewer")
	
	LabelLegend.Text = $"HMITiles Get Started${CRLF}Recommended tile size: Use horizontal and vertical anchors."$
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	' Make any HMITile property changes here
	TileEventViewerSetProperties
	TileEventViewerAddItems
End Sub

' ================================================================
' PROPERTIES
' ================================================================

Private Sub TileEventViewerSetProperties
	TileEventViewer.CompactMode = False		' Full info
	TileEventViewer.Logging = True			' Log entry B4X IDE
	TileEventViewer.ShowTrash = True		' Trash button to clear entries
End Sub

' ================================================================
' DATA
' ================================================================

' Add items with random level
' Levels are EVENT_LEVEL_INFO (0), EVENT_LEVEL_WARNING (1), EVENT_LEVEL_ALARM (2)
Private Sub TileEventViewerAddItems
	Dim item As String
	Dim level As Int
	
	item = $"Log event info level"$
	level = HMITileUtils.EVENT_LEVEL_INFO
	TileEventViewer.Add(item, level)

	item = $"Log event warning level"$
	level = HMITileUtils.EVENT_LEVEL_WARNING
	TileEventViewer.Add(item, level)

	item = $"Log event alarm level"$
	level = HMITileUtils.EVENT_LEVEL_ALARM
	TileEventViewer.Add(item, level)
	
	
'	For i = 1 To 5
'		item = $"Log event ${i}"$
'		level = Rnd(0, 3)
'		TileEventViewer.Add(item, level)
'	Next
End Sub

' Log all events as maps
Private Sub TileEventViewerLogEvents
	Dim events As List = TileEventViewer.GetEvents
	For Each event As Map In events
		Log($"Event timestamp=${event.Get("timestamp")} level=${event.Get("level")} event=${event.Get("event")}"$)
	Next
End Sub

' ===================================================
' EVENTS
' ===================================================

' Show selected event in messagebox.
' Log all items.
Private Sub TileEventViewer_ItemClick (Index As Int, Value As Object)
	TileEventViewerLogEvents
	Dim sf As Object = xui.Msgbox2Async(Value, "TileEventViewer", "OK", "", "", Null)
	Wait For (sf) Msgbox_Result (Result As Int)
End Sub


