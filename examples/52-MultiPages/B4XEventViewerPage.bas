B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@

Sub Class_Globals
	Private xui As XUI 'ignore
	Private Root As B4XView 'ignore
	Private TileNavButtonBack As HMITileNavButton
	Private TileNavButtonBack2 As HMITileNavButton
	Private TileEventViewer As HMITileEventViewer
End Sub

Public Sub Initialize As Object
	Return Me
End Sub

Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("EventViewerPage")

	' UI settings
	B4XPages.SetTitle(Me, "EventViewerPage")
	
	' ===================================================
	' HMITiles
	' ===================================================
	' Sleep must be set to enable customviews load designer layouts
	Sleep(1)
	'TileNavButtonBack.BasePane.Width = 96
	'TileNavButtonBack.BasePane.Height = 96
End Sub

Private Sub TileNavButtonBack_Click
	B4XPages.ShowPageAndRemovePreviousPages("MainPage")
End Sub

Private Sub TileNavButtonBack2_Click
	B4XPages.ShowPageAndRemovePreviousPages("MainPage")
End Sub

Private Sub TileEventViewer_ItemClick (Index As Int, Value As Object)
	Log($"]TileEventViewer] index=${Index}, value=${Value}"$)
End Sub

