B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileCustom.bas
' Brief:		CustomView HMITile with no views.
'				Use to create custom tiles.
' Date:			2026-04-27
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+-----+
'				|     |
'				|     |
'				|     |
'				+-----+
'				Layout default 120px x 120px.
' Example:
'				' Create customized tile starting with empty pane.
'				' Added are 4 labels (B4XViews) top-down.
'				Private Sub TileCustomCreate
'					Dim left As Double
'					Dim top As Double
'					Dim width As Double
'					Dim height As Double
'					Dim heightfactor As Double = 0.25
'
'					' Create 4 labels
'					Dim lbls(4) As B4XView
'					Dim titles() As String = Array As String("Custom Tile", "Info 1", "Info 2", "Footer")
'					For i = 0 To 3
'						lbls(i)		= XUIViewsUtils.CreateLabel
'						lbls(i).Font = xui.CreateDefaultFont(HMITileUtils.TEXT_SIZE_LABEL)
'						lbls(i).SetTextAlignment("CENTER", "CENTER")
'						lbls(i).TextColor = HMITileUtils.COLOR_TEXT_PRIMARY
'						lbls(i).Text = $"${titles(i)}"$
'						left = HMITileUtils.TILE_PADDING
'						top = (i * heightfactor) * TileCustom.BasePane.Height
'						width = TileCustom.BasePane.Width - (HMITileUtils.TILE_PADDING * 2)
'						height = TileCustom.BasePane.Height * heightfactor
'						' Add label to the base
'						TileCustom.BasePane.AddView(lbls(i), left, top, width, height)
'					Next
'				End Sub
' ================================================================
#End Region

' Views
' No views

' Events
' No events

Private Sub Class_Globals
	' Base
	Public BasePane As B4XView
	Public BaseLabel As B4XView
	Public Tag As Object

	' Events
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	
	' XUI
	Private xui As XUI 'ignore

	' Properties Designer

	' Properties Class
	Private mStatus As String
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

'Base type must be Object
Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	' Load the customview layout(s) via CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitilecustom")

	' Properties
	mStatus = HMITileUtils.STATUS_NORMAL

	Base_Resize(BasePane.Width, BasePane.Height)
	ApplyStatusStyle(mStatus)
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	' No action
End Sub

' ===================================================================
' Public API
' ===================================================================

Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' --- Convenience helpers ---
Public Sub StatusNormal(text As String)
	setStatus(HMITileUtils.STATUS_NORMAL)
End Sub

Public Sub StatusWarning(text As String)
	setStatus(HMITileUtils.STATUS_WARNING)
End Sub

Public Sub StatusAlarm(text As String)
	setStatus(HMITileUtils.STATUS_ALARM)
End Sub

Public Sub StatusDisabled(text As String)
	setStatus(HMITileUtils.STATUS_DISABLED)
End Sub

' --- Core property ---
Public Sub setStatus(value As String)
	ApplyStatusStyle(value)
End Sub
Public Sub getStatus As String
	Return mStatus
End Sub

' ================================================================
' TILE STATUSSTYLE
' ================================================================

#Region StatusStyle
' ApplyStatusStyle
' Set one of the 4 visual status Normal, Warning, Alarm, Disabled
' Parameters:
'	status String - Use HMITileUtils constants STATUS_NORMAL_TEXT ... WARNING, ALARM, DISABLED
Private Sub ApplyStatusStyle(status As String)
	mStatus = status
	Select status
		Case HMITileUtils.STATUS_NORMAL
			BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

		Case HMITileUtils.STATUS_WARNING
			BasePane.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATUS_ALARM
			BasePane.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATUS_DISABLED
			BasePane.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	End Select
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
' B4J - Mouse Events (Button Behavior - uses B4X click)
#if B4J
Private Sub LabelText_MouseClicked (EventData As MouseEvent)
	LabelText_Click
End Sub
#End If

' B4X - use click only
Private Sub LabelText_Click
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed(mCallBack, mEventName & "_Click")
	End If
End Sub
#End Region
