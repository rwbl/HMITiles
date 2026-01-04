B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File: 		HMITileUtils.bas
' Brief:		Common constants and helper subs used by the customview HMITiles.
' Date:			2026-01-04
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	Central styling module for HMITiles library.
'     			- Base colors (neutral blue-green scale)
'     			- Alarm colors (amber/red)
'     			- Text colors & sizes
'     			- HMITile background/text colors per state
'     			- ApplyHMITileStyle() method that styles a HMITile dynamically
'				Important: Tile Background Desaturated blue-green
'				Low chroma > avoids “dashboard glow”
'				Contrast with:
'					white / light gray text
'					alarm yellow / red
'					inactive controls
' Notes:		Colors info, warning, and error/alarm:
'				Colors must indicate process meaning
'				-Not UI behaviour.
'				-Red = High-severity alarm
'				-Yellow/Amber = Warning
'				-Green = Normal process running
'				-Blue/Cyan = Operator action required
'				-Orange = Abnormal condition

'				- Info → Neutral. No color.
'				- Warning → Amber
'				- Error/Alarm → Red
'				| State       | Background      | Text       | Notes         |
'				| ----------- | --------------- | ---------- | ------------- |
'				| **INFO**    | Neutral gray    | Light gray | No color      |
'				| **WARNING** | Amber (#FFD24C) | Black      | Soft contrast |
'				| **ERROR**   | Red (#D32F2F)   | White      | High contrast |
'
'				| HMITile Type      | Width x Height (dp) | Notes                                                              |
'				| ----------------- | ------------------- | ------------------------------------------------------------------ |
'				| **HMITileLabel**  | 120 x 60            | Single text, no state line; small info HMITile                     |
'				| **HMITileSensor** | 120 x 80            | Two lines: title + value; extra padding For numeric sensor display |
'				| **HMITileButton** | 120 x 80            | Two lines: title + state; touch-friendly                           |
'				| **HMITileToggle** | 120 x 80            | Two lines: title + ON/OFF state; border indicates toggle           |
'				| **HMITileLarge**  | 200 x 120           | Important display: alarms, Main sensor, Main button                |
'				| **HMITileWide**   | 200 x 80            | Wide layout For long titles Or sliders                             |
'				| **HMITileSmall**  | 80 x 50             | Secondary info Or indicators (LED-style)                           |
'				Overall used for the HMTTiles project is 120px x 120px except for slider & icons.
' ================================================================
#End Region

Private Sub Process_Globals
	' XUI/FX
	Private xui As XUI
	#if B4J
	Private fx As JFX
	#end if

	' HMITile Grid Helper
	#if B4J
	Private HMITileGrid As HMITileGridHelper
	#end if
	
	' ================================================================
	' TILE SIZE
	' ================================================================
	Public Const TILE_DEFAULT_SIZE As Int = 120								' Minimum tile size: ~120×120 px for tiles with a title.
																			' Smaller tiles are allowed only when:They have NO title or contain a single numeric value only.
	
	' ================================================================
	' BACKGROUND COLORS
	' ================================================================
	Public Const COLOR_BACKGROUND_DEFAULT  		As Int = 0xFF2B5267						' blueish
	Public Const COLOR_BACKGROUND_PANEL        	As Int = 0xFFCCCCCC   					' panel slightly darker
	Public Const COLOR_BACKGROUND_SCREEN       	As Int = 0xFFE6E6E6   					' very light neutral gray
	Public Const COLOR_BORDER_DEFAULT      		As Int = 0xFF5A5A5A
	Public Const COLOR_BORDER_DARK         		As Int = 0xFF707070
	Public Const COLOR_BACKGROUND_HOVER   	 	As Int = 0xFFBBBBBB   					' just a bit lighter on hover
	Public Const COLOR_BACKGROUND_DARK   	 	As Int = 0xFF202020   					' dark
	Public Const COLOR_BACKGROUND_SELECTED   	As Int = 0xFFC8C8C8   					' medium-gray selected item
	Public Const COLOR_BORDER_DEFAULT           As Int = 0xFFC0C0C0						' light neutral border
	Public Const COLOR_BORDER_DARK           	As Int = 0xFF888888						' dark neutral border
		
	' ================================================================
	' STATUS COLORS (ALARM ONLY)
	' ================================================================
	Public Const COLOR_STATUS_WARNING           As Int = 0xFFFFD24C
	Public Const COLOR_STATUS_ALARM_LO          As Int = 0xFFFFA000
	Public Const COLOR_STATUS_ALARM_HI          As Int = 0xFFD32F2F
	Public Const COLOR_STATUS_FORBIDDEN         As Int = 0xFF7F0000

	' ================================================================
	' TILE STATES (NORMAL ON/OFF)
	' ================================================================
	Public Const COLOR_STATE_ON_BACKGROUND      As Int = 0xFF103030						' 20% darker then off state
	Public Const COLOR_STATE_OFF_BACKGROUND     As Int = COLOR_BACKGROUND_DEFAULT   	' same as default tile
	Public Const COLOR_STATE_ON_BORDER          As Int = 0xFF202020
	Public Const COLOR_STATE_OFF_BORDER         As Int = 0xFF888888
	Public Const COLOR_STATE_TEXT               As Int = 0xFF202020   					' dark text for readability
	
	' ================================================================
	' TEXT COLORS
	' ================================================================
	Public Const COLOR_TEXT_PRIMARY    			As Int = 0xFFFFFFFF						' strog white, could also use F2F2F2 off-white
	Public Const COLOR_TEXT_SECONDARY  			As Int = 0xFFDADADA
	Public Const COLOR_TEXT_DISABLED   			As Int = 0xFF7A7A7A
	Public Const COLOR_TEXT_WARNING             As Int = 0xFF000000   					' black (max contrast)	COLOR_STATUS_WARNING
	Public Const COLOR_TEXT_ALARM               As Int = 0xFFFFFFFF   					' white COLOR_STATUS_ALARM_HI
	Public Const COLOR_TEXT_ERROR               As Int = 0xFFFFFFFF   					' white 

	' ================================================================
	' TILE STATES
	' ================================================================
	Public Const STATE_NORMAL              		As Int = 0
	Public Const STATE_WARNING             		As Int = 1
	Public Const STATE_ALARM               		As Int = 2
	Public Const STATE_DISABLED            		As Int = 3
	Public Const TYPESTYLE_NORMAL          		As String = "Normal"
	Public Const TYPESTYLE_WARNING             	As String = "Warning"
	Public Const TYPESTYLE_ALARM               	As String = "Alarm"
	Public Const TYPESTYLE_DISABLED            	As String = "Disabled"

	' ================================================================
	' TILE COLORS PER STATE
	' ================================================================
	Public Const COLOR_TILE_NORMAL_BACKGROUND   As Int = COLOR_BACKGROUND_DEFAULT
	Public Const COLOR_TILE_NORMAL_TEXT         As Int = COLOR_TEXT_PRIMARY

	Public Const COLOR_TILE_WARNING_BACKGROUND  As Int = COLOR_STATUS_WARNING
	Public Const COLOR_TILE_WARNING_TEXT        As Int = 0xFF000000

	Public Const COLOR_TILE_ALARM_BACKGROUND    As Int = COLOR_STATUS_ALARM_HI
	Public Const COLOR_TILE_ALARM_TEXT          As Int = 0xFFFFFFFF

	Public Const COLOR_TILE_DISABLED_BACKGROUND As Int = 0xFFDDDDDD
	Public Const COLOR_TILE_DISABLED_TEXT       As Int = COLOR_TEXT_DISABLED

	Public Const COLOR_TILE_ENABLED_BACKGROUND   As Int = COLOR_BACKGROUND_DARK
	Public Const COLOR_TILE_ENABLED_TEXT         As Int = 0xFFFFFFFF

	' ================================================================
	' TILE BORDER
	' ================================================================
	Public Const BORDER_WIDTH              		As Double = 1
	Public Const BORDER_RADIUS             		As Double = 1
	Public Const BORDER_RADIUS_LARGE            As Double = 12

	' ================================================================
	' LAYOUT GRID GUIDELINES
	' ================================================================
	' 8-point baseline grid (8dip, 16dip, 24dip …)
	Public Const GRID_BASELINE              	As Double = 8
	' 16dip spacing between HMITiles
	Public Const GRID_SPACING              		As Double = 16
	' 32dip margins outer screen edge
	Public Const GRID_OUTER_SCREEN_EDGE			As Double = 32

	' Default padding
	Public Const PADDING 						As Int = 4dip

	' ================================================================
	' TEXT SIZES
	' ================================================================

	' Titles (screen section headers, panel titles)
	Public Const TEXT_SIZE_TITLE        		As Float = 16
	' Label (the top label inside a tile)
	Public Const TEXT_SIZE_LABEL        		As Float = 16
	' State/value text (the main content inside a tile)
	Public Const TEXT_SIZE_STATE        		As Float = 24
	' Small secondary text (units, small info inside a tile)
	Public Const TEXT_SIZE_SMALL        		As Float = 14
	' Tiny text (footnotes, timestamps)
	Public Const TEXT_SIZE_TINY         		As Float = 12
	' Icon size (icon or symbol font)
	Public Const TEXT_SIZE_ICON         		As Float = 32
	' Icon size large (icon or symbol font)
	Public Const TEXT_SIZE_ICON_LARGE         	As Float = 40

	' ================================================================
	' EVENT VIEWER
	' ================================================================
	' - Events (Not logs)
	' - Event Messages
	' - Alarm Events And Warning Events
	' - Event Viewer (Not “Log Viewer”)
	' - Naming must reflect:
	' 	- Concept = Event
	'	- Level = Info / Warning / Alarm
	'	- Component = EventViewer HMITile

	' === EVENT COLORS ===
	' === EVENT BACKGROUNDS ===
	Public Const EVENT_COLOR_BG_BASE        As Int = 0xFF1F1F1F
	Public Const EVENT_COLOR_BG_SELECTED    As Int = 0xFF2B2B2B
	Public Const EVENT_COLOR_BG_HOVER       As Int = 0xFF262626
	Public Const EVENT_COLOR_BG_DISABLED    As Int = 0xFF2F2F2F   ' muted dark
	Public Const EVENT_DIVIDER   			As Int = 0xFF303030

	' === EVENT TEXT COLORS (ACCENTS ONLY) ===
	' Note: Using pure white only:
	' - White text easiest to read across lighting conditions.
	' - Colored text fatiguing during long shifts.
	' - Color should be reserved for rare, high-priority events.
	' - Too many colored items cause “color saturation”, reducing urgency perception.
	Public Const EVENT_COLOR_TEXT			As Int = 0xFFFFFFFF		

	' NOT USED
'	Public Const EVENT_COLOR_TEXT_INFO      As Int = 0xFFCCCCCC 	' slight opacy, other option E0E0E0 light gray (default)
'	Public Const EVENT_COLOR_TEXT_WARNING   As Int = 0xFFFFC966		' amber accent
'	Public Const EVENT_COLOR_TEXT_ALARM     As Int = 0xFFFF3B30		' strong red, alternative 0xFFFF6666   red/orange accent	
'	Public Const EVENT_COLOR_TEXT_CRITICAL  As Int = 0xFFFF3333		' strong red
'	Public Const EVENT_COLOR_TEXT_DISABLED  As Int = 0xFF777777		' muted gray

	' === EVENT LEVELS ===
	' These map to the existing STATE_* levels
	Public Const EVENT_LEVEL_INFO     				As Int = STATE_NORMAL
	Public Const EVENT_LEVEL_WARNING  				As Int = STATE_WARNING
	Public Const EVENT_LEVEL_ALARM    				As Int = STATE_ALARM

	' === EVENT LEVEL ICONS ===
	' Colors
	Public Const EVENT_COLOR_ICON_INFO      		As Int = COLOR_TEXT_PRIMARY		' white
	Public Const EVENT_COLOR_ICON_WARNING   		As Int = 0xFFFFC000				' amber
	Public Const EVENT_COLOR_ICON_ALARM     		As Int = 0xFFFF0000				' red
	Public Const EVENT_COLOR_ICON_CRITICAL  		As Int = 0xFFFF0000				' strong red
	Public Const EVENT_COLOR_ICON_DISABLED  		As Int = 0xFF777777				' muted gray
	' Fonts Fontawesome Icons
	Public Const EVENT_ICON_INFO 					As String = Chr(0xF05A)
	Public Const EVENT_ICON_WARNING        			As String = Chr(0xF071)
	Public Const EVENT_ICON_ALARM         			As String = "🚨"				' Or set Chr(0xF12A) !
	Public Const EVENT_ICON_DISABLED      			As String = Chr(0xF00D)

	' === EVENT TEXT SIZES NORMAL MODE ===
	Public Const EVENT_NORMAL_TIMESTAMP_TEXT_SIZE	As Float = 13
	Public Const EVENT_NORMAL_MESSAGE_TEXT_SIZE   	As Float = 15
	Public Const EVENT_NORMAL_SOURCE_TEXT_SIZE    	As Float = 16
	#if B4A
	Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As Float = 16
	#End If
	#if B4J
	Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As Float = 24	
	#End If
	Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As Float = 24

	' === EVENT ITEM HEIGHT/PADDING NORMAL ===
	Public Const EVENT_NORMAL_HEIGHT				As Int = 36dip
	Public Const EVENT_NORMAL_HEIGHT_LARGE			As Int = 54dip
	Public Const EVENT_NORMAL_PADDING 				As Int = 6dip

	' === EVENT TEXT SIZES COMPACT MODE ===
	Public Const EVENT_COMPACT_TIMESTAMP_TEXT_SIZE 	As Float = 10
	Public Const EVENT_COMPACT_MESSAGE_TEXT_SIZE   	As Float = 12					' or use 11
	Public Const EVENT_COMPACT_SOURCE_TEXT_SIZE    	As Float = 14
	#if B4A
	Public Const EVENT_COMPACT_ICON_TEXT_SIZE      	As Float = 14
	#End If
	#if B4J
	Public Const EVENT_COMPACT_ICON_TEXT_SIZE      	As Float = 20	
	#End If

	' === EVENT ITEM HEIGHT/PADDING NORMAL ===
	Public Const EVENT_COMPACT_HEIGHT				As Int = 24dip					' range can be 24–28dip
	Public Const EVENT_COMPACT_PADDING 				As Int = 4dip					

	' === EVENT VIEWER TITLE ===
	Public Const EVENT_TITLE_HEIGHT As Int = 32dip

	' ================================================================
	' COMMAND/CONTROL LIST COLORS 
	' ================================================================
	' === LIST BACKGROUNDS ===
	' Base background for list area (neutral light gray)
	Public Const LIST_COLOR_BG_BASE              	As Int = 0xFFF5F5F5   ' light neutral gray
	' Background for each visible list row (unselected)
	Public Const LIST_COLOR_BG_ITEM              	As Int = 0xFFFFFFFF   ' pure white
	' Selected row background — subtle, no strong color
	Public Const LIST_COLOR_BG_SELECTED          	As Int = 0xFFD0D0D0   ' light gray highlight
	' Hover row background — extremely subtle
	Public Const LIST_COLOR_BG_HOVER             	As Int = 0xFFEAEAEA   ' slightly darker white
	' Disabled row background
	Public Const LIST_COLOR_BG_DISABLED          	As Int = 0xFFE0E0E0   ' muted light gray
	' Divider line between items (very thin, subtle)
	Public Const LIST_DIVIDER                    	As Int = 0xFFCCCCCC   ' soft gray divider
	' === LIST TEXT COLORS ===
	Public Const LIST_COLOR_TEXT                 	As Int = 0xFF202020   ' dark gray text
	Public Const LIST_COLOR_TEXT_DISABLED        	As Int = 0xFF909090   ' muted gray for disabled items
	' === LIST TITLE ===
	Public Const LIST_TITLE_HEIGHT As Int = 32dip
	' === LIST ROW MODE NORMAL or COMPACT===
	Public Const LIST_NORMAL_HEIGHT 				As Int = 48dip
	Public Const LIST_NORMAL_PADDING 				As Int = 12dip
	Public Const LIST_NORMAL_PRIMARY_TEXT_SIZE 		As Float = 16
	Public Const LIST_NORMAL_SECONDARY_TEXT_SIZE	As Float = 13
	Public Const LIST_COMPACT_HEIGHT 				As Int = 34dip
	Public Const LIST_COMPACT_PADDING 				As Int = 7dip
	Public Const LIST_COMPACT_PRIMARY_TEXT_SIZE 	As Float = 14
	Public Const LIST_COMPACT_SECONDARY_TEXT_SIZE 	As Float = 11

	' ================================================================
	' SLIDER COLORS
	' ================================================================
	Public Const COLOR_SLIDER_TRACK            As Int = 0xFFFFFFFF								' Track (background / inactive area)
	Public Const COLOR_SLIDER_ACTIVE           As Int = 0xFFB8B8B8								' Active track (portion indicating the set value)
	Public Const COLOR_SLIDER_KNOB             As Int = 0xFF4A4A4A								' Slider knob (handle)
	Public Const COLOR_SLIDER_DISABLED_TRACK   As Int = 0xFFE0E0E0   							' Disabled state track
	Public Const COLOR_SLIDER_DISABLED_KNOB    As Int = 0xFFA8A8A8   							' Disabled knob
	Public Const COLOR_SLIDER_VALUE_TEXT       As Int = 0xFF2A2A2A   							' Value text color (live numeric value)
	Public Const COLOR_SLIDER_LABEL_TEXT       As Int = COLOR_TEXT_SECONDARY   					' Label text color (caption / description)
	Public Const COLOR_SLIDER_UNIT_TEXT        As Int = 0xFF3A3A3A  							' Units text color (optional)
	Public Const COLOR_SLIDER_KNOB_BORDER 		As Int = 0xFF2F2F2F

	' ================================================================
	' TILE TREND
	' ================================================================
	Public Const COLOR_TREND_LINE     As Int = 0xFF404040	' 0xFF707070
	Public Const COLOR_TREND_BG       As Int = 0xFFF5F5F5   ' optional
	Public Const COLOR_TREND_BORDER   As Int = 0xFFB0B0B0   ' optional

	' ================================================================
	' HELPERS
	' ================================================================
	' Byte converter - very useful
	Public ByteConv As ByteConverter
End Sub

' ================================================================
' TILE STYLING
' ================================================================
#Region HMITile Styling
' ApplyHMITileTitleStyle
' For all HMITiles the title style are consistent
' Parameters:
'	view B4XView - Title label
Public Sub ApplyStyleTitle(HMITilepane As B4XView, titlelabel As B4XView, HMITilestate As String)
	titlelabel.TextColor = COLOR_TEXT_SECONDARY
	titlelabel.TextSize = TEXT_SIZE_TITLE

	Dim state As Int = StateStyleToState(HMITilestate)
	Select state
		Case STATE_NORMAL
			HMITilepane.Color = COLOR_TILE_NORMAL_BACKGROUND

		Case STATE_WARNING
			HMITilepane.Color = COLOR_TILE_WARNING_BACKGROUND

		Case STATE_ALARM
			HMITilepane.Color = COLOR_TILE_ALARM_BACKGROUND

		Case STATE_DISABLED
			HMITilepane.Color = COLOR_TILE_DISABLED_BACKGROUND
	End Select
	
	HMITilepane.SetColorAndBorder(HMITilepane.Color, _
								  BORDER_WIDTH, _
								  COLOR_STATE_ON_BORDER, _
								  BORDER_RADIUS)
End Sub

Public Sub ApplyStyleStateOnOff(HMITilepane As B4XView, statelabel As B4XView, state As Boolean)
	If state Then
		statelabel.TextColor = COLOR_TEXT_PRIMARY
		HMITilepane.SetColorAndBorder(COLOR_STATE_ON_BACKGROUND, 0, 0, BORDER_RADIUS)
	Else
		statelabel.TextColor = COLOR_TEXT_SECONDARY
		HMITilepane.SetColorAndBorder(COLOR_STATE_OFF_BACKGROUND, 0, 0, BORDER_RADIUS)
	End If
End Sub
#End Region

' ================================================================
' HELPER: APPLY STYLES
' ================================================================
Public Sub ApplyTitleStyle(lbl As B4XView)
	If lbl.IsInitialized Then
		#if B4J
		lbl.TextSize = TEXT_SIZE_TITLE
		lbl.TextColor = COLOR_TEXT_PRIMARY
		SetStyleBold(lbl, False)
		#end if
		#if B4A
		lbl.Font = xui.CreateDefaultBoldFont(TEXT_SIZE_TITLE)
		lbl.TextColor = COLOR_TEXT_PRIMARY
		#End If
	End If
End Sub

Public Sub ApplyValueStyle(lbl As B4XView)
	If lbl.IsInitialized Then
		#if B4J
		lbl.TextSize = TEXT_SIZE_STATE
		lbl.TextColor = COLOR_TEXT_PRIMARY
		SetStyleBold(lbl, True)
		#end if
		#if B4A
		lbl.Font = xui.CreateDefaultBoldFont(TEXT_SIZE_STATE)
		lbl.TextColor = COLOR_TEXT_PRIMARY
		#End If
	End If
End Sub

Public Sub ApplyLabelStyle(lbl As B4XView)
	If lbl.IsInitialized Then
		#if B4J
		lbl.TextSize = TEXT_SIZE_LABEL
		lbl.TextColor = COLOR_TEXT_SECONDARY
		SetStyleBold(lbl, False)
		#end if
		#if B4A
		lbl.Font = xui.CreateDefaultFont(TEXT_SIZE_STATE)
		lbl.TextColor = COLOR_TEXT_PRIMARY
		#End If
	End If
End Sub

Public Sub ApplyUnitStyle(lbl As B4XView)
    If lbl.IsInitialized Then
		#if B4J
		lbl.TextSize = TEXT_SIZE_SMALL
		lbl.TextColor = COLOR_TEXT_SECONDARY
		SetStyleBold(lbl, False)
		#end if
		#if B4A
		lbl.Font = xui.CreateDefaultFont(TEXT_SIZE_SMALL)
		lbl.TextColor = COLOR_TEXT_SECONDARY
		#End If
	End If
End Sub

Public Sub ApplySubInfoStyle(lbl As B4XView)
	If lbl.IsInitialized Then
		#if B4J
		CSSUtils.SetStyleProperty(lbl, "-fx-font-size", TEXT_SIZE_TINY)
		'lbl.TextSize = TEXT_SIZE_TINY
		lbl.TextColor = COLOR_TEXT_SECONDARY
		SetStyleBold(lbl, False) 
		#end if
		#if B4A
		lbl.Font = xui.CreateDefaultBoldFont(TEXT_SIZE_TINY)
		lbl.TextColor = COLOR_TEXT_SECONDARY
		#End If
	End If
End Sub

Public Sub ApplyIconStyle(lbl As B4XView)
	If lbl.IsInitialized Then
		#if B4J
		lbl.TextSize = TEXT_SIZE_ICON
		lbl.TextColor = COLOR_TEXT_PRIMARY
		#end if
		#if B4A
		lbl.Font = xui.CreateDefaultFont(TEXT_SIZE_ICON)
		lbl.TextColor = COLOR_TEXT_PRIMARY
		#End If
	End If
End Sub

Public Sub ApplyFontAwesomeStyle(lbl As B4XView)
	If lbl.IsInitialized Then
		#if B4J
		lbl.TextSize = TEXT_SIZE_STATE  ' TEXT_SIZE_ICON
		lbl.TextColor = COLOR_TEXT_PRIMARY
		#end if
		#if B4A
		lbl.Font = xui.CreateFontAwesome(TEXT_SIZE_STATE)	'TEXT_SIZE_ICON)
		lbl.TextColor = COLOR_TEXT_PRIMARY
		#End If
	End If
End Sub

#if B4J
Public Sub SetStyleBold(node As Node, value As Boolean)
	If value Then
		CSSUtils.SetStyleProperty(node, "-fx-font-weight", "bold")
	Else
		CSSUtils.SetStyleProperty(node, "-fx-font-weight", "normal")
	End If
End Sub
#end if

#if B4J
Public Sub GetStyleBold(node As Node) As Boolean
	Dim property As String = CSSUtils.GetStyleProperty(node, "-fx-font-weight")
	Return property == "bold"
End Sub
#end if

#if B4J
Public Sub GetStyleBorderRadius(node As Node) As Double
	Dim s As String = CSSUtils.GetStyleProperty(node, "-fx-border-radius")
	If s.Length == 0 Then
		Return BORDER_RADIUS
	Else
		Return s
	End If
End Sub
#end if

' ================================================================
' HELPER CONVERSIONS
' ================================================================

'Convert a color hex string to int.
'The hex string must be 8. If length 6 then FF is set as prefix.
Public Sub HexToColor(hex As String) As Int	'ignore
	Dim bc As ByteConverter
	If hex.StartsWith("#") Then
		hex = hex.SubString(1)
	Else If hex.StartsWith("0x") Then
		hex = hex.SubString(2)
	End If
	If hex.Length == 6 Then hex = $"FF${hex}"$
	Dim b() As Byte = bc.HexToBytes(hex)
	Dim ints() As Int = bc.IntsFromBytes(b)
	Return ints(0)
End Sub

Public Sub ColorToHexARGB(clr As Int) As String
	Dim bc As ByteConverter
	Return bc.HexFromBytes(bc.IntsToBytes(Array As Int(clr)))
End Sub

Public Sub ColorToHexRGB(clr As Int) As String
	Dim bc As ByteConverter
	Dim hex As String = bc.HexFromBytes(bc.IntsToBytes(Array As Int(clr)))
	Return hex.SubString2(2, hex.Length)
End Sub

#if B4J
Public Sub ColorXUIToFX(value As Int) As Paint
	Return fx.Colors.From32Bit(xui.Color_White)
End Sub
#end if

' Set text color safely (null-safe)
Public Sub SetTextColor(lbl As B4XView, col As Int)
	If lbl.IsInitialized Then lbl.TextColor = col
End Sub

Public Sub CopyLabelProps(src As B4XView, dest As B4XView) As B4XView
	dest.Text = src.Text
	dest.Font = src.Font
	dest.Color = src.Color
	dest.TextColor = src.TextColor
	dest.TextSize = src.TextSize
	Return dest
End Sub

' Call like: ChangeButtonTextAnimated(HMITileButton1, newText)
Public Sub ChangeButtonTextAnimated(target As B4XView, newText As String)
	Dim duration As Int = 240
	' Fade out
	target.SetAlphaAnimated(duration, 0) ' duration in ms, alpha 0 = invisible
	Sleep(120)
	' Change text
	target.Text = newText
	' Fade back in
	target.SetAlphaAnimated(duration, 1) ' alpha 1 = fully visible
End Sub

Public Sub StateStyleToState(state As String) As Int
	Dim result As Int
	Select state
		Case "Normal"
			result = STATE_NORMAL
		Case "Warning"
			result = STATE_WARNING
		Case "Error"
			result = STATE_ALARM
		Case "Alarm"
			result = STATE_ALARM
		Case "Dimmed"
			result = STATE_DISABLED
		Case "Disabled"
			result = STATE_DISABLED
		Case Else
			result = STATE_NORMAL
	End Select
	Return result
End Sub

' ================================================================
' HELPER CUSTOMLISTVIEW
' ================================================================

' Set CLV background transparent
' Example: SetCLVBackgroundTransparent(ClvCommands)
Public Sub SetCLVBackgroundTransparent(clv As CustomListView)
#if B4J
	Dim sp As ScrollPane = clv.sv
	CSSUtils.SetStyleProperty(sp, "-fx-background", "transparent")
	CSSUtils.SetStyleProperty(sp, "-fx-background-color", "transparent")
	
	' This targets the internal viewport (the gray area inside)
	CSSUtils.SetStyleProperty(sp, "-fx-control-inner-background", "transparent")
	CSSUtils.SetStyleProperty(sp, "-fx-control-inner-background-alt", "transparent")
#end if
End Sub

' Set the CLV scrollbar visibility
' Parameters:
'	clv CustomListView
'	visible Bolean
Public Sub SetCLVScrollBars(clv As CustomListView, visible As Boolean)
#If B4J
	Dim nsv As ScrollPane = clv.sv
	If visible Then
		nsv.SetVScrollVisibility("ALWAYS")
	Else
		nsv.SetVScrollVisibility("NEVER")
	End If
	Dim jo As JavaObject = clv 'ignore
	jo.SetField("_scrollbarsvisible", visible)
	clv.Base_Resize(clv.AsView.Width, clv.AsView.Height)
#End If	
End Sub

' Set alpha level for a tile.
' Parameters:
'	enabled Boolean - State of the tile.
Public Sub SetAlpha(enabled As Boolean) As Float
	Return IIf(enabled, 1, 0.4)
End Sub

#Region HMITileGrid
' ================================================================
' TILE GRID - EXPERIMENTAL
' B4J only
' ================================================================
#if B4J
' Implementation details & safety notes
' - Canvas isolation: Grid uses its own B4XCanvas And gridPanel. HMITiles that also use B4XCanvas draw into their own panel Or mBase. Since gridPanel.SendToBack Is used, the grid Is always behind other views And doesn’t intercept touches.
' - Performance: The drawing Is simple lines; even on large screens it Is cheap. Call Redraw only when settings change Or on resize.
' - Design vs runtime: You can leave the grid toggled off For runtime And use it only during development Or layout tuning.
' - Coordinate system: grid draws in device-independent dips (B4X uses dips), matching your HMITile sizes.
' - Customization: Expose MinorStep, MajorStep, MinorColor, MajorColor, And ShowCoordinates from HMITileUtils (Or set them directly on HMITileGridHelper) If you want a single place To tune visual rules.

Public Sub EnableHMITileGrid(parent As B4XView)
	If Not(HMITileGrid.IsInitialized) Then
		HMITileGrid.Initialize(parent)
	End If
	HMITileGrid.Resize
	HMITileGrid.ShowGrid = True
	HMITileGrid.Redraw
End Sub

Public Sub DisableHMITileGrid
	If Not(HMITileGrid.IsInitialized) Then
		Return
	End If
	HMITileGrid.ShowGrid = False
	HMITileGrid.Redraw
End Sub

' ================================================================
' Snap a single coordinate to the nearest grid
' ================================================================
Public Sub SnapCoord(value As Int) As Int
	If Not(HMITileGrid.IsInitialized) Then
		Return 0
	End If
	Dim stepSize As Int = HMITileGrid.MinorStep
	If stepSize <= 0 Then stepSize = 8dip
	Return Round(value / stepSize) * stepSize
End Sub

' ================================================================
' Snap X,Y position of a HMITile to the grid
' ================================================================
Public Sub SnapViewToGrid(v As B4XView)
	If v.IsInitialized = False Then Return
	v.Left = SnapCoord(v.Left)
	v.Top = SnapCoord(v.Top)
End Sub

' ================================================================
' Snap Width/Height (optional)
' ================================================================
Public Sub SnapSizeToGrid(v As B4XView)
	If v.IsInitialized = False Then Return
	v.Width = SnapCoord(v.Width)
	v.Height = SnapCoord(v.Height)
End Sub

' ================================================================
' Snap full bounding box (position + size)
' ================================================================
Public Sub SnapViewFull(v As B4XView)
	SnapViewToGrid(v)
	SnapSizeToGrid(v)
End Sub

Public Sub SnapAllChildrenToGrid(parent As B4XView)
	For Each c As B4XView In parent.GetAllViewsRecursive
		SnapViewToGrid(c)
	Next
End Sub

'Test Private Sub B4XPage_Created (Root1 As B4XView):
'	HMITileUtils.EnableHMITileGrid(Root)
'	Sleep(1)
'	HMITileUtils.SnapAllChildrenToGrid(Root)
'	Sleep(1)
'	HMITileUtils.DisableHMITileGrid
'	Sleep(1)

#End Region

#End If
