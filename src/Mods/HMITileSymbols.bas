B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileSymbols.bas
' Brief:		Common symbol constants and helper subs used by the customview HMITiles.
' Date:			2026-04-29
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	Drawing helper (stateless) for symbols.
' Examples:		Various symbol examples.
'				Cvs.ClearRect(Cvs.TargetRect)
'				HMITileSymbols.Triangle(Cvs, 60, 60, 40, xui.Color_Red, True, 0, HMITileSymbols.DIR_NORTH)
'				HMITileSymbols.Arrow(Cvs, 60, 60, 40, xui.Color_Green, True, 0, HMITileSymbols.DIR_EAST)
'				Cvs.Invalidate
' ================================================================
#End Region

Private Sub Process_Globals
	' XUI/FX
	Private xui As XUI

	' ================================================================
	' Directions ----
	' ================================================================

	Public Const DIR_NORTH As Int = 0
	Public Const DIR_EAST  As Int = 1
	Public Const DIR_SOUTH As Int = 2
	Public Const DIR_WEST  As Int = 3
End Sub

' =========================
' PUBLIC DRAW METHODS
' =========================

Public Sub Triangle(Cvs As B4XCanvas, cx As Float, cy As Float, size As Float, _
    color As Int, fill As Boolean, strokewidth As Float, direction As Int)

	DrawShape(Cvs, Shape_Triangle, cx, cy, size, color, fill, strokewidth, direction)
End Sub

Public Sub Diamond(Cvs As B4XCanvas, cx As Float, cy As Float, size As Float, _
    color As Int, fill As Boolean, strokewidth As Float)

	DrawShape(Cvs, Shape_Diamond, cx, cy, size, color, fill, strokewidth, DIR_NORTH)
End Sub

Public Sub Arrow(Cvs As B4XCanvas, cx As Float, cy As Float, size As Float, _
    color As Int, fill As Boolean, strokewidth As Float, direction As Int)

	DrawShape(Cvs, Shape_Arrow, cx, cy, size, color, fill, strokewidth, direction)
End Sub

' =========================
' CORE ENGINE
' =========================

Private Sub DrawShape(Cvs As B4XCanvas, shape() As Float, cx As Float, cy As Float, _
    size As Float, color As Int, fill As Boolean, strokewidth As Float, direction As Int)

	Dim angle As Float = DirToAngle(direction)
	Dim pts() As Float = TransformPoints(shape, cx, cy, size, size, angle)
	DrawPolygon(Cvs, pts, color, fill, strokewidth)
End Sub

Private Sub DrawPolygon(Cvs As B4XCanvas, pts() As Float, color As Int, fill As Boolean, strokewidth As Float)
	If pts.Length < 6 Then Return
	
	Dim p As B4XPath
	p.Initialize(pts(0), pts(1))
	
	For i = 2 To pts.Length - 2 Step 2
		p.LineTo(pts(i), pts(i + 1))
	Next
	
	p.LineTo(pts(0), pts(1))
	
	Cvs.DrawPath(p, color, fill, strokewidth)
End Sub

Private Sub TransformPoints(src() As Float, cx As Float, cy As Float, _
    scaleX As Float, scaleY As Float, angleDeg As Float) As Float()

	Dim dst(src.Length) As Float
	
	Dim rad As Float = angleDeg * cPI / 180
	Dim cosA As Float = Cos(rad)
	Dim sinA As Float = Sin(rad)
	
	For i = 0 To src.Length - 2 Step 2
		Dim x As Float = src(i)
		Dim y As Float = src(i + 1)
		
		x = x * scaleX
		y = y * scaleY
		
		Dim xr As Float = x * cosA - y * sinA
		Dim yr As Float = x * sinA + y * cosA
		
		dst(i)     = cx + xr
		dst(i + 1) = cy + yr
	Next
	
	Return dst
End Sub

Private Sub DirToAngle(dir As Int) As Float
	Select dir
		Case DIR_NORTH : Return 0
		Case DIR_EAST  : Return 90
		Case DIR_SOUTH : Return 180
		Case DIR_WEST  : Return 270
	End Select
	Return 0
End Sub

' =========================
' SHAPES (normalized)
' =========================

Private Sub Shape_Triangle() As Float()
	Return Array As Float( _
		-0.5,  0.5, _
		 0.5,  0.5, _
		 0.0, -0.5)
End Sub

Private Sub Shape_Diamond() As Float()
	Return Array As Float( _
		 0.0, -0.5, _
		 0.5,  0.0, _
		 0.0,  0.5, _
		-0.5,  0.0)
End Sub

Private Sub Shape_Arrow() As Float()
	Return Array As Float( _
		-0.25,  0.5, _
		 0.25,  0.5, _
		 0.25,  0.0, _
		 0.5 ,  0.0, _
		 0.0 , -0.5, _
		-0.5 ,  0.0, _
		-0.25,  0.0)
End Sub
