B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
Sub Class_Globals
	Private Root As B4XView 'ignore
	Private xui As XUI 'ignore
	Private TileNavButtonBack As HMITileNavButton
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("page2")
	#if B4J
	B4XPages.SetTitle(Me, $"Page 2 (B4J)"$)
	B4XPages.GetNativeParent(Me).Resizable = False
	#End If
End Sub

Private Sub TileNavButtonBack_Click
	B4XPages.ShowPageAndRemovePreviousPages("mainpage")
End Sub
