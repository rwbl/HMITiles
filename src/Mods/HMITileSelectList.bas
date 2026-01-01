B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileSelectList.bas
' Brief:    	CustomView HMITile to select items from customlistview with primary labels.
' Date:			2025-12-30
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|      Label       |   < Title
'				|+----------------+|   
'				|| Primary Label  ||   < CLV with label items
'				|+----------------+|   
'				|+----------------+|   
'				|| Primary Label  ||   
'				|+----------------+|   
'				+------------------+
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 			DisplayName: Title, FieldType: String, DefaultValue: Select
#DesignerProperty: Key: ShowTitle, 		DisplayName: Show Title, FieldType: Boolean, DefaultValue: True, Description: Show title text.
#DesignerProperty: Key: CompactMode,	DisplayName: Compact Mode, FieldType: Boolean, DefaultValue: False, Description: Show items compact mode.

' Events
#Event: ItemClick (Index As Int, Value As Object)

Sub Class_Globals
	#If B4J
	'Private fx As JFX
	#End If
	
	' Events
	Private mEventName As String	'ignore
	Private mCallBack As Object		'ignore

	' Base Views
	Public mBase As B4XView
	Public mLbl As B4XView
	Public Tag As Object

	' UI
	Private xui As XUI
	Private LabelTitle As B4XView
	Private ClvSelect As CustomListView
	Private PaneSelect As B4XView

	' Properties
	Private mShowTitle As Boolean
	Private mCompactMode As Boolean

	' CLV
	Private mSelectedItemIndex As Int = -1	' Keep track of the command selected
	Private mSelectedItem As String			' Keep the item selected astring
	Private mScrollbar As Boolean			' Flag to show or hide the scrollbar
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)
	' Layout with label & clv
	mBase.LoadLayout("hmitileselectlist")

	' Assign designer properties
	LabelTitle.Text = Props.Get("Title")
	mShowTitle 		= Props.Get("ShowTitle")
	mCompactMode	= Props.Get("CompactMode")
	
	' Set clv transparent
	ApplyStyle

	' Resize properly
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	Dim l,t,w,h As Float
	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	' Ensure b4xviews are initialized
	If Not(LabelTitle.IsInitialized) Or Not(ClvSelect.IsInitialized) Then
		Return
	End If

	PaneSelect.SetLayoutAnimated(0, pad, pad, Width - pad * 2, Height - pad * 2)
	LabelTitle.SetLayoutAnimated(0, 0, 0, PaneSelect.Width, HMITileUtils.LIST_TITLE_HEIGHT)

	' Resize the base panel with CLV.GetBase.SetLayoutAnimated.
	l = pad
	t = pad
	If mShowTitle Then
		t = t + HMITileUtils.LIST_TITLE_HEIGHT
	End If
	w = PaneSelect.Width - pad * 2
	h = PaneSelect.Height - pad * 2
	If mShowTitle Then
		h = h - LabelTitle.Height
	End If
	ClvSelect.GetBase.SetLayoutAnimated(0, l, t, w, h)

	' Call Base_Resize to properly resize the internal scrollview
	ClvSelect.Base_Resize (ClvSelect.GetBase.Width, ClvSelect.GetBase.Height)
End Sub

#Region Properties
' Title
' Get/Set HMITile title.
' Parameters:
'	text String - HMITile title.
Public Sub setTitle(text As String)
	LabelTitle.Text = text
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	HMITileUtils.SetAlpha(mBase.enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

Public Sub setCompactMode(state As Boolean)
	mCompactMode = state
End Sub
Public Sub getCompactMode As Boolean
	Return mCompactMode
End Sub

Public Sub SetSelectedItem(index As Int)
	mSelectedItem = index
	If ClvSelect.Size > 0 Then
		ClvSelect_ItemClick(index, ClvSelect.GetValue(index))
		ClvSelect.AsView.RequestFocus
	End If
End Sub
Public Sub SelectedItem As String
	Return mSelectedItem
End Sub

Public Sub SelectedItemIndex As Int
	Return mSelectedItemIndex
End Sub

Public Sub setScrollbar(state As Boolean)
	mScrollbar = state
	HMITileUtils.SetCLVScrollBars(ClvSelect, state)
End Sub
Public Sub getScrollbar As Boolean
	Return mScrollbar
End Sub

Public Sub setShowTitle(state As Boolean)
	mShowTitle = state
	Base_Resize(mBase.Width, mBase.Height)
End Sub
Public Sub getShowTitle As Boolean
	Return mShowTitle
End Sub
#End Region

' ================================================================
' HMITile STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply style Normal.
Public Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.SetCLVBackgroundTransparent(ClvSelect)
	ClvSelect.sv.SetColorAndBorder(HMITileUtils.COLOR_BACKGROUND_SCREEN, _
								 1dip, _ 
								 HMITileUtils.COLOR_STATE_OFF_BORDER, _ 
								 0dip)
	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

#Region ListItems
' Add
' Add new list item at last position and scroll to last position.
' Parameters:
'	primaryitem String 
' Returns:
'	n/a
Public Sub Add(primaryitem As String, value As Object)
	ClvSelect.Add(ClvSelectCreateItem(primaryitem), _
			    value)
	' ClvSelect.JumpToItem(ClvSelect.Size - 1)
End Sub

' AddAll
' Add new list items from a list.
' Parameters:
'	primaryitem String 
' Returns:
'	n/a
Public Sub AddAll(items As List)
	For Each s As String In items
		Add(s,s)
	Next
End Sub

' Insert
' Insert new list item at first position:
' Newest on top, Most relevant information visible without scrolling.
' This is aligned with industrial HMI practice.
' Parameters:
'	primaryitem String 
'	secondaryitem String
' Returns:
'	n/a
Public Sub Insert(primaryitem As String, value As Object)
	ClvSelect.InsertAt(	0, _
						ClvSelectCreateItem(primaryitem), _
			        	value )
End Sub

' Remove
' Remove item from the list.
' Parameters:
'	index Int - Index of the item 0 - list.size - 1
' Returns:
'	n/a
Public Sub Remove(index As Int)
	If ClvSelect.Size == 0 Then Return
	If index < 0 Or index > ClvSelect.Size - 1 Then Return
	ClvSelect.RemoveAt(index)
End Sub

' Clear all items from the list.
Public Sub Clear
	ClvSelect.Clear
End Sub

' Get the number of items
Public Sub Size As Int
	Return ClvSelect.Size
End Sub
#End Region


#Region ClvSelectCreateItem
' Create list item.
' Parameters:
'	item String - Item to create.
'	level Int - Event level
' Returns:
'	Pane
#If B4J
Private Sub ClvSelectCreateItem(primaryitem As String) As Pane
#End If
#If B4A
Private Sub ClvSelectCreateItem(primaryitem As String) As Panel
#End If
	' Item height and padding
	Dim rowheight As Int			= IIf(mCompactMode, HMITileUtils.EVENT_COMPACT_HEIGHT, HMITileUtils.EVENT_NORMAL_HEIGHT)
	Dim rowpadding As Int			= IIf(mCompactMode, HMITileUtils.EVENT_COMPACT_PADDING, HMITileUtils.EVENT_NORMAL_PADDING)

	' Font sizes
	Dim primarytextsize As Float	= IIf(mCompactMode, HMITileUtils.EVENT_COMPACT_MESSAGE_TEXT_SIZE, HMITileUtils.EVENT_NORMAL_MESSAGE_TEXT_SIZE)

	' Create panel to hold the item
	Dim pnl As B4XView				= xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, rowpadding, rowpadding, ClvSelect.AsView.Width - (rowpadding * 2), rowheight)
	Dim primaryitemheight As Int	= pnl.Height

	' Set colors
	pnl.Color = HMITileUtils.LIST_COLOR_BG_BASE

	' Create primary item (top)
	Dim lblprimaryitem As B4XView	= XUIViewsUtils.CreateLabel
	lblprimaryitem.Font 			= xui.CreateDefaultFont(primarytextsize)
	lblprimaryitem.Color			= HMITileUtils.LIST_COLOR_BG_BASE
	lblprimaryitem.Text				= primaryitem
	lblprimaryitem.TextColor		= HMITileUtils.LIST_COLOR_TEXT
	lblprimaryitem.SetTextAlignment("TOP", "LEFT")
	pnl.AddView(lblprimaryitem, rowpadding, 0, pnl.Width, primaryitemheight)
	Return pnl
End Sub
#End Region

#Region Events
' ClvSelect_ItemClick
' Call event callback if exists.
' Parameters:
'	index Int - List item index
'	value String - Item content
'	level Int - Event level
Private Sub ClvSelect_ItemClick (Index As Int, Value As Object)
	'Log($"[ClvSelect_ItemClick ] index=${Index}, value=${Value}"$)

	' Check if already an item is selected
	If mSelectedItemIndex == -1 Then mSelectedItemIndex = Index
	' Reset background color for selected command
	ClvSelect.GetPanel(mSelectedItemIndex).Color = HMITileUtils.LIST_COLOR_BG_BASE
	' Set command selected color
	ClvSelect.GetPanel(Index).Color = HMITileUtils.COLOR_BACKGROUND_SELECTED
	' Update selected item index
	mSelectedItemIndex = Index
	' Set the item selected
	mSelectedItem = Value
	
	' Call event if exists
	If SubExists(mCallBack, mEventName & "_ItemClick") Then
		CallSub3(mCallBack, mEventName & "_ItemClick", Index, Value)
	End If
End Sub
#End Region
