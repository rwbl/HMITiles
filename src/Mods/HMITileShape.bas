B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileShape.bas
' Brief:    	CustomView HMITile with several shapes drawn on a B4XCanvas.
' Date:			2025-12-28
' Author:		Robert W.B. Linn (c) 2025 MIT
' Hints:    	HMITile cannot be resized after form loaded.
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: ShapeType, DisplayName: Shape Type, FieldType: String, DefaultValue: HLine, List: HLine|VLine|Cross|CornerLeftUp|CornerLeftDown|CornerRightUp|CornerRightDown
#DesignerProperty: Key: StrokeWidth, DisplayName: Stroke Width, FieldType: Int, DefaultValue: 2

' Events
' No events

Private Sub Class_Globals
	' Constants
	Private SHAPE_HLINE As String 			= "HLine"
	Private SHAPE_VLINE As String 			= "VLine"
	Private SHAPE_CROSS As String 			= "Cross"
	Private SHAPE_CORNERLEFTUP As String 	= "CornerLeftUp"
	Private SHAPE_CORNERLEFTDOWN As String 	= "CornerLeftDown"
	Private SHAPE_CORNERRIGHTUP As String 	= "CornerRightUp"
	Private SHAPE_CORNERRIGHTDOWN As String	= "CornerRightDown"
	
	' Events
	Private mEventName As String	'ignore
	Private mCallBack As Object		'ignore

	' Base
	Public mBase As B4XView
	Private xui As XUI
	Public Tag As Object

	' UI
	Private PaneShape As B4XView
	Private CanvasShape As B4XCanvas
	
	' Properties
	Private mShapeType As String
	Private mStrokeWidth As Int
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mCallBack = Callback
	mEventName = EventName
End Sub

Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	Tag = mBase.Tag
	mBase.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitileshape")

	' Store designer properties
	mShapeType		= Props.GetDefault("ShapeType", SHAPE_HLINE)
	mStrokeWidth	= Props.GetDefault("StrokeWidth", 2)

	' Init the shape
	CanvasShape.Initialize(PaneShape)
	
	ApplyStyle

	Base_Resize(mBase.Width, mBase.Height)
End Sub

' =========================
' TILE STYLE
' =========================

' ApplyStyle
' Apply style Normal with border styling borderless.
Private Sub ApplyStyle
	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	mBase.SetColorAndBorder(mBase.Color, 0, 0, 0)	
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	If Not(PaneShape.IsInitialized) Then Return
	
	PaneShape.SetLayoutAnimated(0, 0, 0, Width, Height)

	DrawShape
End Sub

' =========================
' Public API
' =========================

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	HMITileUtils.SetAlpha(mBase.enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

' =========================
' Drawing methods
' =========================
Public Sub DrawShape

	CanvasShape.ClearRect(CanvasShape.TargetRect)

	Select mShapeType
		Case SHAPE_HLINE
			DrawLine(False)
		Case SHAPE_VLINE
			DrawLine(True)
		Case SHAPE_CROSS
			DrawLine(False)
			DrawLine(True)
		Case SHAPE_CORNERLEFTUP
			DrawCorner(PaneShape.Width, PaneShape.Height, 180)
		Case SHAPE_CORNERLEFTDOWN
			DrawCorner(PaneShape.Width, 0, 90)
		Case SHAPE_CORNERRIGHTUP
			DrawCorner(0, 0, 0)
		Case SHAPE_CORNERRIGHTDOWN
			DrawCorner(0, PaneShape.Height, 270)
	End Select
End Sub

Private Sub DrawLine(vertical As Boolean)
	Dim x1 As Float
	Dim y1 As Float
	Dim x2 As Float
	Dim y2 As Float
	Dim cx As Float	= PaneShape.Width / 2
	Dim cy As Float = PaneShape.Height / 2

	If Not(vertical) Then
		x1 = 0
		y1 = cy 
		x2 = PaneShape.Width
		y2 = cy 
		CanvasShape.DrawLine(x1,y1,x2,y2,HMITileUtils.COLOR_BORDER_DEFAULT, mStrokeWidth)
		CanvasShape.Invalidate
	Else
		x1 = cx 
		y1 = 0
		x2 = cx 
		y2 = PaneShape.Height
		CanvasShape.DrawLine(x1,y1,x2,y2,HMITileUtils.COLOR_BORDER_DEFAULT, mStrokeWidth)
		CanvasShape.Invalidate
	End If
End Sub

' DrawCorner
' Arcs clock 0300 (angle 0), 0600 (angle 90), 0900 (angle 180), 1200 (angle 270)
' Example:
' Draw corner left up = 0900 (180) - 1200 (90)
' DrawCorner(PaneShape.Width, PaneShape.Height, 180)
Private Sub DrawCorner(cx As Float, cy As Float, startangle As Int)
	Dim r As Float = PaneShape.Width / 2 + mStrokeWidth / 2
	Dim sweepLength As Float = 90
	Dim shapeArc As B4XPath
	shapeArc.InitializeArc(cx, cy, r, startangle, sweepLength)
	CanvasShape.DrawPath(shapeArc, HMITileUtils.COLOR_BORDER_DEFAULT, False, mStrokeWidth)
	Dim maskArc As B4XPath
	maskArc.InitializeArc(cx, cy, r - mStrokeWidth, startangle, 180)
	CanvasShape.DrawPath(maskArc, HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND, True, 0)
	CanvasShape.Invalidate
End Sub