B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
' ================================================================
' File:			B4XSecondPage
' Project:		HMITiles
' Brief:		Development program for the B4X HMITiles library.
' Date:			See Class_Globals VERSION
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	This pages is used to develop .
' DependsOn:	XUI Views, ByteConverter, JavaObject
' ================================================================

Private Sub Class_Globals
	' Core
	Private Root As B4XView 'ignore
	Private xui As XUI 'ignore
	
	' HMITiles
	Private TileNavButtonBack As HMITileNavButton
	Private TileLabelSecondPage As HMITileLabel
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("secondpage")
	
	#if B4J
	B4XPages.SetTitle(Me, $"SecondPage (B4J)"$)
	B4XPages.GetNativeParent(Me).Resizable = False
	#End If
End Sub

Private Sub TileNavButtonBack_Click
	B4XPages.ShowPageAndRemovePreviousPages("mainpage")
End Sub


