B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileList.bas
' Brief:    	CustomView HMITile with a title, customlistview with primary & secondary label.
' Date:			2025-12-30
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|      Label       |   
'				|+----------------+|   
'				|| Primary Label  ||   
'				|| Secondary Label||   
'				|+----------------+|   
'				|+----------------+|   
'				|| Primary Label  ||   
'				|| Secondary Label||   
'				|+----------------+|   
'				+------------------+
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: TitleText,		DisplayName: Title, FieldType: String, DefaultValue: List
#DesignerProperty: Key: ShowTitle, 		DisplayName: Show Title, FieldType: Boolean, DefaultValue: True, Description: Show title text.
#DesignerProperty: Key: ShowSelected, 	DisplayName: Show Selected, FieldType: Boolean, DefaultValue: False, Description: Highlight selected row.
#DesignerProperty: Key: CompactMode,	DisplayName: Compact Mode, FieldType: Boolean, DefaultValue: False, Description: Show items compact mode.

' Events
#Event: ItemClick (Index As Int, Value As Object)

Sub Class_Globals
	#If B4J
	Private fx As JFX
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
	Private ClvList As CustomListView
	Private PaneList As B4XView

	' Properties
	Private mShowTitle As Boolean
	Private mShowSelected As Boolean
	Private mCompactMode As Boolean

	' CLV
	Private mCommandSelected As Int = -1		' Keep track of the command selected
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
	mBase.LoadLayout("hmitilelist")

	' Assign designer properties
	LabelTitle.Text = Props.Get("TitleText")
	mShowTitle 		= Props.Get("ShowTitle")
	mShowSelected 	= Props.Get("ShowSelected")
	mCompactMode	= Props.Get("CompactMode")
	
	' Set clv transparent
	ApplyStyle

	' Resize properly
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	Dim l,t,w,h As Float
	Dim pad As Int = HMITileUtils.BORDER_WIDTH + 4dip

	' Ensure b4xviews are initialized
	If Not(LabelTitle.IsInitialized) Or Not(ClvList.IsInitialized) Then
		Return
	End If

	PaneList.SetLayoutAnimated		(0, 0, 0, Width, Height)
	LabelTitle.Visible = mShowTitle
	If mShowTitle Then
		LabelTitle.SetLayoutAnimated(0, 0, 0, PaneList.Width, HMITileUtils.EVENT_TITLE_HEIGHT)
	End If

	' Resize the base panel with CLV.GetBase.SetLayoutAnimated.
	l = pad
	t = pad
	w = PaneList.Width - pad * 2
	h = PaneList.Height - pad * 2
	If mShowTitle Then
		t = HMITileUtils.EVENT_TITLE_HEIGHT + pad
		h = h - HMITileUtils.EVENT_TITLE_HEIGHT
	End If
	ClvList.GetBase.SetLayoutAnimated(0, l, t, w, h)

	' Call Base_Resize to properly resize the internal scrollview
	ClvList.Base_Resize (ClvList.GetBase.Width, ClvList.GetBase.Height)
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

Public Sub setShowSelected(state As Boolean)
	mShowSelected = state
End Sub
Public Sub getShowSelected As Boolean
	Return mShowSelected
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
#End Region

' ================================================================
' HMITile STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply style Normal
Public Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	PaneList.Color = HMITileUtils.COLOR_BACKGROUND_DEFAULT
	HMITileUtils.SetCLVBackgroundTransparent(ClvList)
	ClvList.sv.SetColorAndBorder(HMITileUtils.COLOR_BACKGROUND_DEFAULT, _
								 1dip, _ 
								 HMITileUtils.COLOR_STATE_OFF_BORDER, _ 
								 0dip)
	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

#Region ListCommands
' Add
' Add new list item at last position and scroll to last position.
' Parameters:
'	primaryitem String 
'	secondaryitem String
' Returns:
'	n/a
Public Sub Add(primaryitem As String, secondaryitem As String, value As Object)
	ClvList.Add(ClvListCreateItem(primaryitem, secondaryitem), _
			    value)
	' ClvList.JumpToItem(ClvList.Size - 1)
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
Public Sub Insert(primaryitem As String, secondaryitem As String, value As Object)
	ClvList.InsertAt(	0, _
						ClvListCreateItem(primaryitem, secondaryitem), _
			        	value )
End Sub

' Remove
' Remove item from the list.
' Parameters:
'	index Int - Index of the item 0 - list.size - 1
' Returns:
'	n/a
Public Sub Remove(index As Int)
	If ClvList.Size == 0 Then Return
	If index < 0 Or index > ClvList.Size - 1 Then Return
	ClvList.RemoveAt(index)
End Sub

' Clear all items from the list.
Public Sub Clear
	ClvList.Clear
End Sub
#End Region

#Region ClvListCreateItem
' Create list item.
' Parameters:
'	item String - Item to create.
'	level Int - Event level
' Returns:
'	Pane
#If B4J
Private Sub ClvListCreateItem(primaryitem As String, secondaryitem As String) As Pane
#End If
#If B4A
Private Sub ClvListCreateItem(primaryitem As String, secondaryitem As String) As Panel
#End If
	' Item height and padding
	Dim rowheight As Int			= IIf(mCompactMode, HMITileUtils.LIST_COMPACT_HEIGHT, HMITileUtils.LIST_NORMAL_HEIGHT)
	Dim rowpadding As Int			= IIf(mCompactMode, HMITileUtils.LIST_COMPACT_PADDING, HMITileUtils.LIST_NORMAL_PADDING)

	' Font sizes
	Dim primarytextsize As Float	= IIf(mCompactMode, HMITileUtils.LIST_COMPACT_PRIMARY_TEXT_SIZE, HMITileUtils.LIST_NORMAL_PRIMARY_TEXT_SIZE)
	Dim secondarytextsize As Float	= IIf(mCompactMode, HMITileUtils.LIST_COMPACT_SECONDARY_TEXT_SIZE, HMITileUtils.LIST_COMPACT_SECONDARY_TEXT_SIZE)

	' Create panel to hold the item
	Dim pnl As B4XView				= xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, rowpadding, rowpadding, ClvList.AsView.Width - (rowpadding * 2), rowheight)
	Dim primaryitemheight As Int	= IIf(secondaryitem.Length > 0, pnl.Height/2, pnl.Height)

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
	'pnl.AddView(lblprimaryitem, rowpadding, 0, pnl.Width - (rowpadding * 2), primaryitemheight)

	' Check if there is a secondary item
	If secondaryitem.Length > 0 Then
		' Create secondary item (bottom)
		Dim lblsecondaryitem As B4XView	= XUIViewsUtils.CreateLabel
		lblsecondaryitem.Font 			= xui.CreateDefaultFont(secondarytextsize)
		lblsecondaryitem.Color 			= HMITileUtils.LIST_COLOR_BG_BASE
		lblsecondaryitem.Text 			= secondaryitem
		lblsecondaryitem.TextColor 		= HMITileUtils.LIST_COLOR_TEXT
		lblsecondaryitem.SetTextAlignment("BOTTOM", "LEFT")
		pnl.AddView(lblsecondaryitem, rowpadding, rowheight/2, pnl.Width, pnl.height/2)
		' pnl.AddView(lblsecondaryitem, rowpadding, rowheight/2, pnl.Width - (rowpadding * 2), pnl.height/2)
	End If

	Return pnl
End Sub
#End Region

#Region Events
' ClvList_ItemClick
' Call event callback if exists.
' Parameters:
'	index Int - List item index
'	value String - Item content
'	level Int - Event level
Private Sub ClvList_ItemClick (Index As Int, Value As Object)
	'Log($"[ClvList_ItemClick ] index=${Index}, value=${Value}"$)

	If mShowSelected Then
		' Check if already a command is selected
		If mCommandSelected == -1 Then mCommandSelected = Index
		' Reset background color for selected command
		ClvList.GetPanel(mCommandSelected).Color = HMITileUtils.LIST_COLOR_BG_BASE
		' Set command selected color
		ClvList.GetPanel(Index).Color = HMITileUtils.COLOR_BACKGROUND_SELECTED
		' Update selected command index
		mCommandSelected = Index
	End If
	
	' Call event if exists
	If SubExists(mCallBack, mEventName & "_ItemClick") Then
		CallSub3(mCallBack, mEventName & "_ItemClick", Index, Value)
	End If
End Sub

#If B4J
' LabelTrash_MouseClicked 
' Clear all events from the list.
' Parameters:
'	Eventdata - MouseEvent - Not used
Private Sub LabelTrash_MouseClicked (EventData As MouseEvent)
	Clear
End Sub
#End Region
#End If
