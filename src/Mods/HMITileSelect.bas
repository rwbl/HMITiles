B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileSelect.bas
' Brief:    	CustomView HMITile to select items by rolling over list of items using up/down.
' Date:			2026-04-23
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|      Label       |   < Title
'				|+----------------+|   
'				||D] Selected [U] ||   < Items
'				|+----------------+|   
'				+------------------+
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, 			DisplayName: Title, FieldType: String, DefaultValue: Select
#DesignerProperty: Key: ShowTitle, 		DisplayName: Show Title, FieldType: Boolean, DefaultValue: True, Description: Show title text.

' Events
#Event: ValueChanged (Value As Object)

Private Sub Class_Globals
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
	Private PaneSelect As B4XView
	Private LabelTitle As B4XView
	Private LabelSelected As B4XView
	Private LabelUp As B4XView
	Private LabelDown As B4XView

	' Properties Designer
	Private mTitle As String
	Private mShowTitle As Boolean

	' Properties Class
	Private mItems As List
	Private mSelectedIndex As Int = -1
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
	mItems.Initialize
End Sub

Public Sub DesignerCreateView (Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me

	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	' Layout with label & clv
	mBase.LoadLayout("hmitileselect")

	' Assign designer properties
	mTitle			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mShowTitle 		= Props.Get("ShowTitle")

	' Resize properly
	Base_Resize(mBase.Width, mBase.Height)

	' Set style to normal only
	ApplyStyle
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	' Log($"[HMITileSelect] w=${Width},h=${Height}"$)

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	' Ensure b4xviews are initialized
	If Not(LabelTitle.IsInitialized) Or Not(LabelUp.IsInitialized) Or Not(LabelDown.IsInitialized) Then
		' Log($"[HMITileSelect.Base_Resize] Views not initialized"$)
		Return
	End If

	PaneSelect.SetLayoutAnimated	(0, 0, 0, Width, Height)
	LabelTitle.SetLayoutAnimated	(0, pad, pad, Width - pad * 2, Height * 0.25)
	LabelSelected.SetLayoutAnimated	(0, pad, LabelTitle.Height, Width - pad * 2, Height * 0.50)
	LabelDown.SetLayoutAnimated		(0, Width * 0.1, Height * 0.60, Width * 0.3, Height * 0.25)
	LabelUp.SetLayoutAnimated		(0, Width * 0.6, Height * 0.60, Width * 0.3, Height * 0.25)
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
	mBase.Enabled = enabled
	HMITileUtils.SetAlpha(mBase.enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

Public Sub setShowTitle(state As Boolean)
	mShowTitle = state
	Base_Resize(mBase.Width, mBase.Height)
End Sub
Public Sub getShowTitle As Boolean
	Return mShowTitle
End Sub

Public Sub setSelected(item As String)
	For i = 0 To mItems.Size - 1
		If mItems.Get(i) == item Then
			LabelSelected.Text = item
			mSelectedIndex = i
			ValueChanged
			Return
		End If
	Next
End Sub
Public Sub getSelected As String
	Return LabelSelected.Text
End Sub

Public Sub setSelectedIndex(index As Int)
	mSelectedIndex = index
	setSelected(mItems.Get(mSelectedIndex))
End Sub
Public Sub getSelectedIndex As Int
	Return mSelectedIndex
End Sub

' Add
' Add new list item at last position and scroll to last position.
' Parameters:
'	primaryitem String 
' Returns:
'	n/a
Public Sub Add(item As Object)
	mItems.Add(item)
End Sub

' AddAll
' Add new list items from a list.
' Parameters:
'	primaryitem String 
' Returns:
'	n/a
Public Sub AddAll(items As List)
	If items.Size == 0 Then Return
	For Each item As Object In items
		Add(item)		
	Next
	setSelectedIndex(0)
End Sub

' Remove
' Remove item from the list.
' Parameters:
'	index Object
Public Sub Remove(item As Object)
	Dim index As Int = 0
	For Each objitem As Object In mItems
		If objitem == item Then
			mItems.RemoveAt(index)
			Return
		End If
		index = index + 1
	Next
End Sub

' Clear all items from the list.
Public Sub Clear
	mItems.Clear
	LabelSelected.Text = ""
End Sub

' Get the number of items
Public Sub Size As Int
	Return mItems.Size
End Sub
#End Region

' ================================================================
' TILE STYLING
' ================================================================
#Region TileStyling
' ApplyStyle
' Apply style Normal.
Private Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)
	HMITileUtils.ApplyValueStyle(LabelSelected)
	HMITileUtils.ApplyFontAwesomeStyle(LabelUp)
	HMITileUtils.ApplyFontAwesomeStyle(LabelDown)

	PaneSelect.SetColorAndBorder(HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND, _
								 0dip, _ 
								 HMITileUtils.COLOR_STATUS_OFF_BORDER, _ 
								 0dip)
	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

#Region Events
' PlusMinusSelect_ValueChanged 
' Call event callback if exists.
' Parameters:
'	value Object - Select item numeric or string
Private Sub PlusMinusSelect_ValueChanged (Value As Object)
	' Call event if exists
	If SubExists(mCallBack, mEventName & "_ValueChanged") Then
		CallSub2(mCallBack, mEventName & "_ValueChanged", Value)
	End If
End Sub
#End Region

#If B4A
Private Sub LabelSelected_Click
	ValueChanged
End Sub

Private Sub LabelUp_Click
	Up		
End Sub

Private Sub LabelDown_Click
	Down
End Sub
#End If

#if B4J
Private Sub LabelSelected_MouseClicked (EventData As MouseEvent)
	ValueChanged
End Sub

Private Sub LabelUp_MouseClicked (EventData As MouseEvent)
	Up
End Sub

Private Sub LabelDown_MouseClicked (EventData As MouseEvent)
	Down	
End Sub
#End If

Private Sub Up
	If mItems.Size == 0 Then Return
	'Log($"[LabelUp_Click] ${mSelectedIndex}"$)
	mSelectedIndex = mSelectedIndex + 1
	If mSelectedIndex > mItems.Size - 1 Then
		mSelectedIndex = 0
	End If
	setSelectedIndex(mSelectedIndex)
End Sub

Private Sub Down
	If mItems.Size == 0 Then Return
	'Log($"[LabelDown_Click] ${mSelectedIndex}"$)
	mSelectedIndex = mSelectedIndex - 1
	If mSelectedIndex < 0 Then
		mSelectedIndex = mItems.Size - 1
	End If
	setSelectedIndex(mSelectedIndex)
End Sub

Private Sub ValueChanged
	If mItems.Size == 0 Then Return
	' Call event if exists
	If SubExists(mCallBack, mEventName & "_ValueChanged") Then
		CallSub2(mCallBack, mEventName & "_ValueChanged", mItems.Get(mSelectedIndex))
	End If
End Sub
