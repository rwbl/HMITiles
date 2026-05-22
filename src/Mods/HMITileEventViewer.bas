B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     HMITileEventViewer.bas
' Brief:    HMITile with a title, customlistview and trash icon (clear all event messages).
'			The customlistview contains an event list with each line being an event (Or "event message")
' Date:		2026-05-22
' Author:	Robert W.B. Linn (c) 2025-2026 MIT
' Layout:
'			+------------------+
'			|      Label       |   
'			|+----------------+|   
'			||   Event Msg    ||   
'			||   Event Msg    ||   
'			|+----------------+|   
'			|    		[CLEAR]|
'			+------------------+
' Notes:	Operator interface elements (HMI displays, alarms, events, etc.) and distinguishes between:
'			Alarm - Something that requires operator action.
'			Event - A system-generated message that does Not require operator action.
'			Message / Event Message - The textual representation of an event.
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 			DisplayName: Title, FieldType: String, DefaultValue: Event Viewer
#DesignerProperty: Key: TimeStamp, 		DisplayName: Timestamp, FieldType: Boolean, DefaultValue: True, Description: Add timestamp as event message prefix. 
#DesignerProperty: Key: MaxEvents, 		DisplayName: Max Events, FieldType: Int, DefaultValue: 50, Description: Maximum number of event messages.
#DesignerProperty: Key: ShowTitle, 		DisplayName: Show Title, FieldType: Boolean, DefaultValue: True, Description: Show title text.
#DesignerProperty: Key: ShowTrash, 		DisplayName: Show Trash Icon, FieldType: Boolean, DefaultValue: True, Description: Show trash icon at bottom right.
#DesignerProperty: Key: CompactMode,	DisplayName: Compact Mode, FieldType: Boolean, DefaultValue: False, Description: Show items compact mode.
#DesignerProperty: Key: Logging, 		DisplayName: Logging, FieldType: Boolean, DefaultValue: False, Description: Log item to the IDE.

' Events
#Event: ItemClick (Index As Int, Value As Object)

Private Sub Class_Globals
	#if B4J
	Private fx As JFX
	#end if
	
	' Events
	Private mEventName As String	'ignore
	Private mCallBack As Object		'ignore

	' Base Views
	Public BasePane As B4XView
	Public BaseLabel As B4XView
	Public Tag As Object

	' UI
	Private xui As XUI
	Private PaneEventViewer As B4XView
	Private LabelTitle As B4XView
	Public ClvEvents As CustomListView		' Can be accesses from object
	Private LabelTrash As B4XView
	
	' Properties Designer
	Private mTitle As String
	Private mTimeStamp As Boolean
	Private mMaxEvents As Int
	Private mShowTitle As Boolean
	Private mShowTrash As Boolean
	Private mCompactMode As Boolean
	Private mLogging As Boolean

	' Properties Class
	Private mRowHeight As Double
	
	Private Events As List
End Sub

Private Sub Initialize (Callback As Object, EventName As String)	'ignore
	mEventName = EventName
	mCallBack = Callback
	Events.Initialize
End Sub

Private Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)	'ignore
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	' First resize the base before loading the layout else customlistview not properly shown.
	'Base_Resize(BasePane.Width, BasePane.Height)

	' Layout with label & clv
	BasePane.LoadLayout("hmitileeventviewer")

	' Properties Designer
	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mTimeStamp		= Props.GetDefault("TimeStamp", True)
	mMaxEvents		= Props.GetDefault("MaxEvents", 50)
	mShowTitle		= Props.GetDefault("ShowTitle", True)
	mShowTrash		= Props.GetDefault("ShowTrash", True)
	mCompactMode	= Props.GetDefault("CompactMode", False)
	mLogging		= Props.GetDefault("Logging", True)
	mRowHeight		= IIf(mCompactMode, HMITileUtils.EVENT_COMPACT_HEIGHT, HMITileUtils.EVENT_NORMAL_HEIGHT)

	' UI settings
	LabelTrash.TextColor = HMITileUtils.COLOR_TEXT_SECONDARY
	LabelTrash.Visible = mShowTrash

	' Resize properly
	Base_Resize(BasePane.Width, BasePane.Height)

	' Set clv transparant
	ApplyStyle
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Or Not(ClvEvents.IsInitialized) Then Return
	Dim l,t,w,h As Float
	Dim pad As Int = HMITileUtils.TILE_PADDING

	PaneEventViewer.SetLayoutAnimated(0, pad, pad, Width - pad * 2, Height - pad * 2)

	LabelTitle.Visible = mShowTitle
	If mShowTitle Then
		LabelTitle.SetLayoutAnimated(0, 0, 0, PaneEventViewer.Width, HMITileUtils.EVENT_TITLE_HEIGHT)
	End If

	' Resize the base panel with CLV.GetBase.SetLayoutAnimated.
	l = pad
	t = pad
	w = PaneEventViewer.Width - pad * 2
	h = PaneEventViewer.Height - pad
	If mShowTitle Then
		t = HMITileUtils.EVENT_TITLE_HEIGHT + pad
		h = h - HMITileUtils.EVENT_TITLE_HEIGHT
	End If
	If mShowTrash Then
		h = h - LabelTrash.Height
		LabelTrash.SetLayoutAnimated(0, PaneEventViewer.Width - LabelTrash.Width, PaneEventViewer.Height - LabelTrash.Height + pad , LabelTrash.Width, LabelTrash.Height)
	End If
	ClvEvents.GetBase.SetLayoutAnimated(0, l, t, w, h)
	' Call Base_Resize to properly resize the internal scrollview
	ClvEvents.Base_Resize (ClvEvents.GetBase.Width, ClvEvents.GetBase.Height)
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
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
	BasePane.Enabled = enabled
	HMITileUtils.SetAlpha(BasePane.enabled)
End Sub
Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' MaxItems
' Get/Set number of max event items (default 50).
' Parameters:
'	value Int - Number of max items.
Public Sub setMaxItems(value As Int)
	mMaxEvents = value
	' Remove only if needed
	Do While ClvEvents.Size > mMaxEvents
		ClvEvents.RemoveAt(ClvEvents.Size - 1) ' safely remove last (oldest) item
	Loop
End Sub
Public Sub getMaxItems As Int
	Return mMaxEvents
End Sub

Public Sub setShowTrash(state As Boolean)
	LabelTrash.Visible = state
End Sub
Public Sub getShowTrash As Boolean
	Return LabelTrash.Visible
End Sub

Public Sub setCompactMode(state As Boolean)
	mCompactMode = state
End Sub
Public Sub getCompactMode As Boolean
	Return mCompactMode
End Sub

Public Sub setLogging(enabled As Boolean)
	mLogging = enabled
End Sub
Public Sub getLogging As Boolean
	Return mLogging
End Sub

Public Sub setRowHeight(value As Double)
	mRowHeight = value
End Sub
Public Sub getRowHeight As Double
	Return mRowHeight
End Sub

Public Sub setTimeStamp(enabled As Boolean)
	mTimeStamp = enabled
End Sub
Public Sub getTimeStamp As Boolean
	Return mTimeStamp
End Sub

#End Region

' ================================================================
' TILE STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply style Normal
Private Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	PaneEventViewer.Color = HMITileUtils.COLOR_BACKGROUND_DEFAULT
	HMITileUtils.SetCLVBackgroundTransparent(ClvEvents)
	ClvEvents.sv.SetColorAndBorder(HMITileUtils.COLOR_BACKGROUND_DEFAULT, _
								   1dip, _ 
								   HMITileUtils.COLOR_STATUS_OFF_BORDER, _ 
								   0dip)
	BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' ITEM HANDLING
' ================================================================
#Region Items
' Insert
' Insert new event item at first position:
' Newest on top, most relevant information visible without scrolling.
' Event list inserted map at first position with keys timestamp, level event.
' The clvlist item contains the map.
' This is aligned with industrial HMI practice.
' Parameters:
'	item String - Item to create.
'	level Int - Event level
' Returns:
'	n/a
Public Sub Insert(event As String, level As Int)
	If Not(ClvEvents.IsInitialized) Then Return
	' Insert event in the class event list - do this first because of map with keys. Always add timestamp.
	Dim m As Map = CreateMap("timestamp":FormatTimestamp(DateTime.Now), "level":level,"event":event)
	Events.InsertAt(0, m)
	If mTimeStamp Then
		event = $"${FormatTimestamp(DateTime.Now)} - ${event}"$
	End If
	ClvEvents.InsertAt(0, ClvEventsCreateItem(event, level), m)
	' Log the items if property set
	If mLogging Then
		Log($"timestamp=${m.get("timestamp")} level=${m.Get("level")} event=${m.Get("event")}"$)
	End If
	' Check maxevents reached > remove last event
	If ClvEvents.Size > mMaxEvents Then
		ClvEvents.RemoveAt(ClvEvents.Size - 1)
		Events.RemoveAt(ClvEvents.Size - 1)
	End If
End Sub

' Add
' Add new event item at last position and scroll to last position.
' Event list added map with keys timestamp, level event.
' The clvlist item contains the map.
' Not recommended - use Insert.
' Parameters:
'	item String - Item to create.
'	level Int - Eventlevel
' Returns:
'	n/a
Public Sub Add(event As String, level As Int)
	If Not(ClvEvents.IsInitialized) Then Return
	' Insert event in the class event list - do this first because of map with keys. Always add timestamp.
	Dim m As Map = CreateMap("timestamp":FormatTimestamp(DateTime.Now), "level":level,"event":event)
	Events.add(m)
	If mTimeStamp Then
		event = $"${FormatTimestamp(DateTime.Now)} - ${event}"$
	End If
	ClvEvents.add(ClvEventsCreateItem(event, level), m)
	' Log the items if property set
	If mLogging Then
		Log($"m.get("timestamp") level=${m.Get("level")} event=${m.Get("event")}"$)
	End If
	' Check maxevents reached > remover first event
	If ClvEvents.Size > mMaxEvents Then
		ClvEvents.RemoveAt(0)
		Events.RemoveAt(0)
	End If
	ClvEvents.JumpToItem(ClvEvents.Size - 1)
End Sub

' Clear all events from the list.
Public Sub Clear
	If Not(ClvEvents.IsInitialized) Then Return
	ClvEvents.Clear
End Sub

' StatusSummary
' Map with event status summary:
' {"normal": 2, "warning": 1, "alarm": 3 }
' Returns
'	map 
Public Sub StatusSummary As Map
	Dim result As Map
	result.Initialize
	Dim normalcount As Int = 0
	Dim warningcount As Int = 0
	Dim alarmcount As Int = 0
	
	For Each event As Map In Events
		Dim level As Int = event.Get("level")
		Select level 
			Case HMITileUtils.EVENT_LEVEL_INFO
				normalcount = normalcount + 1
			Case HMITileUtils.EVENT_LEVEL_WARNING
				warningcount = warningcount + 1
			Case HMITileUtils.EVENT_LEVEL_ALARM
				alarmcount = alarmcount + 1
		End Select
	Next
	result = CreateMap( "normal": normalcount, _
						"warning": warningcount, _
						"alarm": alarmcount) 
	Return result
End Sub

' GetEvents
' Get the list of events.
' List entry is a map with keys "level":int,"event":string.
' Returns
'	list
Public Sub GetEvents As List
	Return Events
End Sub
#End Region

' ================================================================
' CLV
' ================================================================

#Region ClvEventsCreateItem
' Create event item.
' Parameters:
'	item String - Item to create.
'	level Int - Event level
' Returns:
'	Pane with a single Label (B4XView)
#if B4J
Private Sub ClvEventsCreateItem(item As String, level As Int) As Pane
#End If
#if B4A
Private Sub ClvEventsCreateItem(item As String, level As Int) As Panel
#end if
	' Item height and padding
	Dim rowheight As Double	= mRowHeight
	Dim rowpadding As Int	= IIf(mCompactMode, HMITileUtils.EVENT_COMPACT_PADDING, HMITileUtils.EVENT_NORMAL_PADDING)

	' Create panel to hold the item
	Dim pnl As B4XView = xui.CreatePanel("")
	pnl.SetLayoutAnimated(0, rowpadding, rowpadding, ClvEvents.AsView.Width - (rowpadding * 2), rowheight)

	' Set colors
	Dim bgColor As Int 		= HMITileUtils.EVENT_COLOR_BG_BASE
	Dim txtColor As Int 	= HMITileUtils.EVENT_COLOR_TEXT
	Dim iconColor As Int 	= HMITileUtils.EVENT_COLOR_ICON_INFO
	Dim icontext As String

	Select level
		Case HMITileUtils.EVENT_LEVEL_INFO
			iconColor = HMITileUtils.EVENT_COLOR_TEXT
			icontext = HMITileUtils.EVENT_ICON_INFO

		Case HMITileUtils.EVENT_LEVEL_WARNING        
			iconColor = HMITileUtils.EVENT_COLOR_ICON_WARNING
			icontext = HMITileUtils.EVENT_ICON_WARNING

		Case HMITileUtils.EVENT_LEVEL_ALARM          
			iconColor = HMITileUtils.EVENT_COLOR_ICON_ALARM
			icontext = HMITileUtils.EVENT_ICON_ALARM
	End Select
	pnl.Color = bgColor
	
	Dim l, t, w, h As Double
	Dim lblicon As B4XView = XUIViewsUtils.CreateLabel
	Dim lblicontextsize As Float = IIf(mCompactMode, HMITileUtils.EVENT_COMPACT_ICON_TEXT_SIZE, HMITileUtils.EVENT_NORMAL_ICON_TEXT_SIZE)
	lblicon.Font = xui.CreateFontAwesome(lblicontextsize)
	lblicon.Text = icontext
	lblicon.SetTextAlignment("CENTER", "LEFT")
	lblicon.TextColor = iconColor
	l = rowpadding
	t = 0
	w = lblicontextsize + (rowpadding * 2)
	h = pnl.Height	
	pnl.AddView(lblicon, l, t, w, h)

	Dim lblitem As B4XView = XUIViewsUtils.CreateLabel
	Dim lblitemtextsize As Float = IIf(mCompactMode, HMITileUtils.EVENT_COMPACT_MESSAGE_TEXT_SIZE, HMITileUtils.EVENT_NORMAL_MESSAGE_TEXT_SIZE)
	' Set font normal or bold
	lblitem.Font = xui.CreateDefaultFont(lblitemtextsize)
	'lblitem.Font = xui.CreateDefaultBoldFont(lblitemtextsize)
	lblitem.Text = item
	lblitem.SetTextAlignment("CENTER", "LEFT")
	lblitem.TextColor = txtColor

	#if B4A
	l = lblicontextsize + (rowpadding * 4)	
	#End If
	#if B4J
	l = lblicontextsize + (rowpadding * 2)	
	#End If
	t = 0
	w = pnl.Width - l
	h = pnl.Height
	pnl.AddView(lblitem, l, t, w, h)

	Return pnl
End Sub

' Option to format the event item timestamp.
' Parameters:
'	ts String - Timestamp
Private Sub FormatTimestamp(ts As Long) As String
	Return DateTime.Time(ts)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================

#Region Events
' ClvEvents_ItemClick
' Call event callback if exists.
' Applies for B4A, B4J.
' Parameters:
'	index Int - List item index
'	value String - Item content
Private Sub ClvEvents_ItemClick (index As Int, value As Object)
	If SubExists(mCallBack, mEventName & "_ItemClick") Then
		CallSubDelayed3(mCallBack, mEventName & "_ItemClick", index, value)
	End If
End Sub

#if B4A
Private Sub ClvEvents_ItemLongClick (Index As Int, Value As Object)
	Clear
End Sub
#End If
#End Region

#Region LabelTrash
#if B4J
' LabelTrash_MouseClicked 
' Clear all events from the list.
' Parameters:
'	Eventdata - MouseEvent - Not used
Private Sub LabelTrash_MouseClicked (EventData As MouseEvent)
	LabelTrash_Click
End Sub
#end if

' ================================================================
' B4X - use click only
' ================================================================

' LabelTrash_MouseClicked 
' Clear all events from the list.
Private Sub LabelTrash_Click
	Clear
End Sub
#End Region
