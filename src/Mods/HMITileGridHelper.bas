B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
' ===================================================================
' File:			HMITileGridHelper.bas
' Brief:		Helper module for drawing a non-intrusive layout grid behind HMITiles
' 				Part of HMITileKit / HMITileUtils family
' Date:			2025-12-17
' Author:		Robert W.B. Linn (c) 2025 MIT
'
' Features:
'  - Draws a grid (minor + major lines) on a panel placed at the back
'  - Toggleable (ShowGrid True/False)
'  - Resizable (call Resize from Page/Activity resize)
'  - Uses its own B4XCanvas -> will NOT interfere with HMITile canvases
'  - Lightweight and safe for runtime or design-time usage
'
' Usage:
'   HMITileGridHelper.Initialize(Root)        ' attach to parent (e.g. page root)
'   HMITileGridHelper.ShowGrid = True
'   HMITileGridHelper.Redraw
'   ' On resize: HMITileGridHelper.Resize
' ===================================================================

Sub Class_Globals
	Private xui As XUI
	Private mParent As B4XView        ' the view the grid is attached to (root)
	Private gridPanel As B4XView     ' panel that hosts the canvas
	Private gridCanvas As B4XCanvas  ' canvas used for drawing the grid

	' Public toggles / settings
	Public ShowGrid As Boolean = False

	' Grid step sizes (8-point friendly defaults)
	Public MinorStep As Int = 8dip    ' minor grid interval (8pt baseline)
	Public MajorStep As Int = 32dip   ' major grid interval (4 * baseline)

	' Colors (transparent grays so it doesn't steal attention)
	' Use low alpha so it is visible in design mode but unobtrusive in run mode.
	Public MinorColor As Int = 0x22000000  ' very light
	Public MajorColor As Int = 0x55000000  ' slightly darker

	' Option: show coordinates at major intersections (useful in design mode)
	Public ShowCoordinates As Boolean = False
	Public CoordTextSize As Float = 10
End Sub

' ------------------------------------------------------------
' Initialize - attach the grid to the parent view (root)
' parent: B4XView (usually the page root or main layout panel)
' This creates a panel and places it at the BACK of the parent.
' ------------------------------------------------------------
Public Sub Initialize(parent As B4XView)
    mParent = parent

    ' Create panel that hosts the canvas. Size to parent.
    gridPanel = xui.CreatePanel("HMITileGridPanel")
    mParent.AddView(gridPanel, 0, 0, mParent.Width, mParent.Height)

    ' Ensure grid panel is behind everything
    gridPanel.SendToBack

    ' Initialize canvas on the panel
    gridCanvas.Initialize(gridPanel)

    ' Initial draw (empty)
    Redraw
End Sub

' ------------------------------------------------------------
' Toggle grid visibility and redraw.
' Call Redraw after changing ShowGrid or other settings.
' ------------------------------------------------------------
Public Sub Redraw
    ' Clear everything
    gridCanvas.ClearRect(gridCanvas.TargetRect)

    If ShowGrid = False Then
        gridCanvas.Invalidate
        Return
    End If

    Dim w As Int = gridPanel.Width
    Dim h As Int = gridPanel.Height

    ' Draw vertical lines
    Dim x As Int = 0
    Do While x <= w
        Dim clr As Int = IIf(x Mod MajorStep = 0, MajorColor, MinorColor)
        gridCanvas.DrawLine(x, 0, x, h, clr, 1dip)
        x = x + MinorStep
    Loop

    ' Draw horizontal lines
    Dim y As Int = 0
    Do While y <= h
        Dim clr2 As Int = IIf(y Mod MajorStep = 0, MajorColor, MinorColor)
        gridCanvas.DrawLine(0, y, w, y, clr2, 1dip)
        y = y + MinorStep
    Loop

    ' Optionally draw coordinates (sparse, only at major intersections)
    If ShowCoordinates Then
        Dim font As B4XFont = xui.CreateDefaultFont(CoordTextSize)
        Dim xi As Int = 0
        Do While xi <= w
            If xi Mod MajorStep = 0 Then
                Dim yi As Int = 0
                Do While yi <= h
                    If yi Mod MajorStep = 0 Then
                        Dim txt As String = $"${xi},${yi}"$
                        gridCanvas.DrawText(txt, xi + 2dip, yi + 12dip, font, MajorColor, "LEFT")
                    End If
                    yi = yi + MajorStep
                Loop
            End If
            xi = xi + MajorStep
        Loop
    End If

    gridCanvas.Invalidate
End Sub

' ------------------------------------------------------------
' Call from Page/Activity Resize so the grid panel and canvas
' are resized and redrawn to match the new layout.
' ------------------------------------------------------------
Public Sub Resize
    gridPanel.SetLayoutAnimated(0, 0, 0, mParent.Width, mParent.Height)
    gridCanvas.Resize(mParent.Width, mParent.Height)
    Redraw
End Sub

' ------------------------------------------------------------
' Optional: removes the grid panel entirely (cleanup)
' ------------------------------------------------------------
Public Sub Remove
    If gridPanel.IsInitialized Then
        gridPanel.RemoveViewFromParent
        ' Reset variables
        gridPanel = Null
        gridCanvas = Null
    End If
End Sub

' ------------------------------------------------------------
' Events (for completeness) - the panel has no events by default,
' but you can hook them here if you want to toggle grid with clicks.
' ------------------------------------------------------------
#if B4J
Private Sub HMITileGridPanel_MouseClicked (EventData As MouseEvent)
    ' Example: toggle grid on middle-click (developer tool)
    ' If EventData.Buttons = MouseButton.MIDDLE Then
    '     ShowGrid = Not(ShowGrid)
    '     Redraw
    ' End If
End Sub
#End If
