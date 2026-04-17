B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:     	HMITileStatusIndicators.bas
' Brief:    	Customview 3x3 Responsive HMI Indicator Tile
' Description:	Display 3x3 matrix with squares.
'				Each square represents the status of an object.
'				The object could like a device, motor, pump, filter etc.
'				Implements industry-standard grayscale coloring for True (Light Gray), False (Dark Gray), and Disabled (Medium Gray) states to reduce operator fatigue.
'				HMITileUtils.TILE_DEFAULT_SIZE constant (120px) it's a critical "Safety Guardrail" that prevents the UI from breaking when the user resizes the window too small.
' Date:			2026-04-17
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Notes:		-Responsive Layout: Uses a Base_Resize logic with Floor calculations and "Edge-Stretching" to eliminate 1-pixel rounding gaps between indicators.
'				-Coordinate Mapping: Converts 1-based Row/Col inputs To 0-based Array indices using the formula: idx = (row - 1) * COLS + (col - 1).
'				-Implements industry-standard grayscale coloring For True (Light Gray), False (Dark Gray), And Disabled (Medium Gray) states To reduce operator fatigue.
'				-Event Delegation: Uses a cross-platform bridge where B4J MouseClicked and B4A Click events both route through a single internal Sub, which then uses CallSub2 to notify the parent module of the specific indicator index.
' ================================================================
#End Region

' Designer Properties
#DesignerProperty: Key: Title, DisplayName: Title, FieldType: String, DefaultValue: Indicators, Description: Title
#DesignerProperty: Key: ColorTrue, DisplayName: Color True, FieldType: Color, DefaultValue: 0xFFE8E8E8, Description: State True color of the indicator.
#DesignerProperty: Key: ColorFalse, DisplayName: Color False, FieldType: Color, DefaultValue: 0xFF323232, Description: State False color of the indicator.

' Events
#Event: Click

Private Sub Class_Globals
	Private xui 					As XUI

	Public mBase 					As B4XView
	Private mLbl 					As B4XView					'ignore
	Public Tag 						As Object

	' Events
	Private mEventName 				As String					'ignore
	Private mCallBack 				As Object					'ignore

	' UI
	Private LabelTitle 				As B4XView
	Private STATUS_INDICATORS_SIZE As Byte  = 9
	Private LabelStatusIndicators(STATUS_INDICATORS_SIZE) As B4XView

	' Dimensions
	Public ROWS 					As Byte = 3
	Public COLS 					As Byte = 3

	' State Type
	Type IndicatorData (Index As Int, State As Int, Text As String, Description As String)

	' States
	Public STATE_TRUE 				As Byte = 0
	Public STATE_FALSE 				As Byte = 1
	Public STATE_DISABLED 			As Byte = 2

	' Properties
	Private mTitle					As String
	Private mColorTrue				As Int
	Private mColorFalse				As Int
	Private mColorDisabled			As Int = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	Private mTextColorTrue			As Int = HMITileUtils.COLOR_TEXT_INDICATOR_TRUE
	Private mTextColorFalse			As Int = HMITileUtils.COLOR_TEXT_INDICATOR_FALSE
	Private mTextColorDisabled		As Int = HMITileUtils.COLOR_TEXT_DISABLED

	' Values
End Sub

Private Sub Initialize(Callback As Object, EventName As String)	'ignore
	mEventName = EventName
	mCallBack = Callback
	Log(mEventName)
End Sub

Private Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)	'ignore
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me

	' Load the customview layout(s) via CallSubDelayed.
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)
	mBase.LoadLayout("hmitilestatusindicators")

	' Get & set designer properties
	mTitle			= Props.Get("Title")
	LabelTitle.Text	= mTitle
	mColorTrue		= xui.PaintOrColorToColor(Props.Get("ColorTrue"))
	mColorFalse		= xui.PaintOrColorToColor(Props.Get("ColorFalse"))

	' Create the status indicator with initial color true
	CreateStatusIndicators
	
	' Resize to get the sizing right
	Base_Resize(mBase.Width, mBase.Height)

	' Apply style to UI views	
	ApplyStyle
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return

	' 1. If too small, force the parent container to grow
	If Width < HMITileUtils.TILE_DEFAULT_SIZE Or Height < HMITileUtils.TILE_DEFAULT_SIZE Then
		Dim NewW As Double = Max(Width, HMITileUtils.TILE_DEFAULT_SIZE)
		Dim NewH As Double = Max(Height, HMITileUtils.TILE_DEFAULT_SIZE)
		mBase.SetLayoutAnimated(0, mBase.Left, mBase.Top, NewW, NewH)
		Return ' Exit and let the sub re-fire with the new dimensions
	End If

	' 2. Proceed with layout using the safe dimensions
	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	' Note: Using Width - (pad * 2) here is why it looked "wrong"
	' before—it was wider than the physical screen.
	LabelTitle.SetLayoutAnimated (0, pad, pad, Width - pad * 2, Height * 0.25)
    
	Dim it As Double = LabelTitle.Top + LabelTitle.Height
	' Use Floor to get safe integer-like steps
	Dim iw As Int = Floor(Width / 3)
	Dim ih As Int = Floor((Height - it) / 3)

	For i = 0 To STATUS_INDICATORS_SIZE - 1
		Dim row As Int = i / 3
		Dim col As Int = i Mod 3
    
		Dim l As Int = col * iw
		Dim t As Int = row * ih + it
		Dim w As Int = iw
		Dim h As Int = ih
    
		' STRETCH FIX: If it's the last column or last row,
		' make it span the remaining distance to the edge.
		If col = 2 Then w = Width - l
		If row = 2 Then h = Height - t
    
		LabelStatusIndicators(i).SetLayoutAnimated(0, l, t, w, h)
	Next
End Sub

' Create the 9 status indicators as 3x3 matrix
Private Sub CreateStatusIndicators
	For i = 0 To STATUS_INDICATORS_SIZE - 1 
		Dim lbl As Label
		lbl.Initialize("LabelStatusIndicator")
		mBase.AddView(lbl, 0dip, 0dip, 30dip, 30dip)
		LabelStatusIndicators(i) = lbl
		Dim data As IndicatorData
		data.Initialize
		data.Index = i
		data.State = STATE_DISABLED
		data.Text = ""
		data.Description = ""
		LabelStatusIndicators(i).Tag = data
		LabelStatusIndicators(i).Text = data.Text
		LabelStatusIndicators(i).SetTextAlignment("CENTER", "CENTER")
		LabelStatusIndicators(i).SetColorAndBorder(mColorDisabled, 1dip, HMITileUtils.COLOR_BORDER_DEFAULT, 0)
		LabelStatusIndicators(i).TextColor = mTextColorDisabled
	Next
End Sub

' ================================================================
' PUBLIC API
' ================================================================

#Region API
' Get or set the title
Public Sub setTitle(value As String)
	mTitle = value
End Sub
Public Sub getTitle As String
	Return mTitle
End Sub

' SetData
' Set the typed data Text, Description, State.
Public Sub SetData(row As Byte, col As Byte, text As String, description As String, state As Int, show As Boolean)
	' Check
	If row < 1 Or row > ROWS Or col < 1 Or col > COLS Then Return

	' Corrected calculation for 1-based row/col to 0-based index
	Dim idx As Int = (row - 1) * COLS + (col - 1)

	' Get data from tag	
	Dim data As IndicatorData = LabelStatusIndicators(idx).Tag
	' Set data from parameter
	data.State = state
	data.Text = text
	data.Description = description
	' Update tag
	LabelStatusIndicators(idx).Tag = data

	' Set UI
	If show Then
		SetState(row, col, state)
		SetText(row, col, text)
	End If
End Sub

' SetState
' Set the state of an indicator to false, true, disabled.
' Parameters:
' row - 1-3
' col - 1-3
' state - 0 (false), 1( true), 2 (disabled)
Public Sub SetState(row As Byte, col As Byte, state As Int)
	' Check
	If row < 1 Or row > ROWS Or col < 1 Or col > COLS Then Return

	' Corrected calculation for 1-based row/col to 0-based index
	Dim idx As Int = (row - 1) * COLS + (col - 1)
	
	Dim data As IndicatorData = LabelStatusIndicators(idx).Tag
	data.State = state
	LabelStatusIndicators(idx).Tag = data
	Select state
		Case STATE_FALSE
			LabelStatusIndicators(idx).Color = mColorFalse
			LabelStatusIndicators(idx).TextColor = mTextColorFalse
		Case STATE_TRUE
			LabelStatusIndicators(idx).Color = mColorTrue
			LabelStatusIndicators(idx).TextColor = mTextColorTrue
		Case STATE_DISABLED
			LabelStatusIndicators(idx).Color = mColorDisabled
			LabelStatusIndicators(idx).TextColor = mTextColorDisabled
	End Select
End Sub
Public Sub GetState(row As Byte, col As Byte) As Int
	If row < 1 Or row > ROWS Or col < 1 Or col > COLS Then Return -1

	' Use COLS (3) to jump full rows
	Dim idx As Int = (row - 1) * COLS + (col - 1)
	Return LabelStatusIndicators(idx).Tag
End Sub

' GetStateText
' Get the indicator state text using the defaults defined in HMIUtils.
Public Sub GetStateText(state As Int) As String
	Select state
		Case STATE_FALSE
			Return HMITileUtils.TEXT_INDICATOR_FALSE
		Case STATE_TRUE
			Return HMITileUtils.TEXT_INDICATOR_TRUE
		Case STATE_DISABLED
			Return HMITileUtils.TEXT_INDICATOR_DISABLED
		Case Else
			Return ""
	End Select
End Sub

' SetText
' Set the text of the indicator.
' Recommended to use 1 or 2 characters.
Public Sub SetText(row As Byte, col As Byte, Text As String)
	If row < 1 Or row > ROWS Or col < 1 Or col > COLS Then Return
	
	Dim idx As Int = (row - 1) * COLS + (col - 1)
	Dim lbl As B4XView = LabelStatusIndicators(idx)

	' Update indicator data
	Dim data As IndicatorData = LabelStatusIndicators(idx).Tag
	data.Text= Text
	LabelStatusIndicators(idx).Tag = data

	' Set the text
	lbl.Text = Text
	' Optional: Use this to ensures only one character is set
	' lbl.Text = Text.SubString(0) 

	' Center hor/ver    
	lbl.SetTextAlignment("CENTER", "CENTER")
End Sub

Public Sub SetDescription(row As Byte, col As Byte, text As String)
	' Check
	If row < 1 Or row > ROWS Or col < 1 Or col > COLS Then Return
	' Corrected calculation for 1-based row/col to 0-based index
	Dim idx As Int = (row - 1) * COLS + (col - 1)
	Dim data As IndicatorData = LabelStatusIndicators(idx).Tag
	data.Description = text
	LabelStatusIndicators(idx).Tag = data
End Sub

Public Sub setColorTrue(value As Int)
	mColorTrue = value
End Sub
Public Sub getColorTrue As Int
	Return mColorTrue
End Sub

Public Sub setColorFalse(value As Int)
	mColorFalse = value
End Sub
Public Sub getColorFalse As Int
	Return mColorFalse
End Sub
#End Region

' ================================================================
' Tile STYLING
' ================================================================
#Region Tile Styling
' ApplyStyle
' Apply style Normal.
Private Sub ApplyStyle
	HMITileUtils.ApplyTitleStyle(LabelTitle)

	mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region

' ================================================================
' EVENTS
' ================================================================
#Region Events
#if B4J
Private Sub LabelStatusIndicator_MouseClicked (EventData As MouseEvent)
	LabelStatusIndicator_Click
End Sub
#End If

Private Sub LabelStatusIndicator_Click
	Dim lbl As B4XView = Sender
	' Log($"[LabelStatusIndicator_Click] ${lbl.Tag}"$)
	If SubExists(mCallBack, mEventName & "_Click") Then
		CallSubDelayed2(mCallBack, mEventName & "_Click", lbl.Tag)
	End If
End Sub

' Example:
'Private Sub TileStatusIndicators_Click(data As IndicatorData)
'	Dim indicator As HMITileStatusIndicators = Sender
'	Dim sf As Object = xui.Msgbox2Async($"${indicator.GetStateText(data.State)}${CRLF}${data.description}"$, $"Status ${data.text}"$, "OK", "", "", Null)
'	Wait For (sf) Msgbox_Result (Result As Int)
'End Sub
#End Region

' ================================================================
' HELPER
' ================================================================

