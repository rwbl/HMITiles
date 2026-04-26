B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:    		HMITileImageIcon.bas
' Brief:   		CustomView HMITile with Image (100%).
' Date:			2026-04-23
' Author:		Robert W.B. Linn (c) 2025-2026 MIT
' Description:	Image must be located in File.DirApp (B4J) or File.DirAssets (B4A).
'				Resize modes: StringItems(Array("FIT", "FILL", "FILL_NO_DISTORTIONS", "FILL_WIDTH", "FILL_HEIGHT", "NONE"))
File.DirAssets
' Layout:
'				+------------------+
'				|                  |
'				|     Image        |  << 100%
'				|                  |
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: ImageName, DisplayName: Image Name, FieldType: String, DefaultValue: , Description: Name of the image located in the app folder (B4J) or assets folder (B4A).
#DesignerProperty: Key: ResizeMode, DisplayName: Resize Mode, FieldType: String, DefaultValue: FIT, List: FIT|FILL|FILL_NO_DISTORTIONS|FILL_WIDTH|FILL_HEIGHT|NONE, Description: Set the resize mode.
#DesignerProperty: Key: Rounded, DisplayName: Rounded, FieldType: Boolean, DefaultValue: False, Description: Set the image rounded.
#DesignerProperty: Key: Status, DisplayName: Status, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

Private Sub Class_Globals
	Private mEventName As String	'ignore
	Private mCallBack As Object		'ignore

	Public mBase As B4XView
	Public mLbl As B4XView

	Private xui As XUI
	#if B4J
	Private fx As JFX
	#end if
	Public Tag As Object

	' Views from HMITileImageIcon.bjl
	Private B4XImageViewHMITile As B4XImageView

	' Properties Designer 
	Private mImageName As String
	Private mResizeMode As String
	Private mRounded As String
	Private mStatus As String

	' Properties Class
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Public Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)
	mBase = Base
	mLbl = Lbl
	Tag = mBase.Tag
	mBase.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	mBase.LoadLayout("hmitileimageicon")
	mImageName 	= Props.Get("ImageName")
	mResizeMode	= Props.Get("ResizeMode")
	mRounded 	= Props.Get("Rounded")
	mStatus	= Props.Get("Status")

	setResizeMode(mResizeMode)
	setRounded(mRounded)

	ApplyStatusStyle(mStatus)
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(B4XImageViewHMITile.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + 4dip
	Dim imageHeight As Float = Height - pad * 2

	' Image area
	B4XImageViewHMITile.mBase.SetLayoutAnimated(0, _
        pad, _
        pad, _
        Width - pad*2, _
        imageHeight)

	' Load image if available
	If mImageName <> "" Then
		setImage(mImageName)
	End If
End Sub

' ===================================================================
' Public API
' ===================================================================

Public Sub setImage(image As String)
	If image = "" Then Return
	mImageName = image
	#if B4A
	Dim folder As String = File.DirAssets	' DirDefaultExternal
	#End If
	#if B4J
	Dim folder As String = File.DirApp		
	#End If
	If File.Exists(folder, mImageName) Then
		Try
			B4XImageViewHMITile.Bitmap = xui.LoadBitmapResize(folder, image, _
            B4XImageViewHMITile.mBase.Width, _
            B4XImageViewHMITile.mBase.Height, _
            True)
			B4XImageViewHMITile.CornersRadius = HMITileUtils.BORDER_RADIUS
			B4XImageViewHMITile.ResizeMode = mResizeMode
			B4XImageViewHMITile.RoundedImage = mRounded
		Catch
			Log($"[HMITileImageIcon.LoadImage][E] Unable to load image '${image}': ${LastException}"$)
		End Try
	Else
		Log($"[HMITileImageIcon][E] Image not found ${folder} ${mImageName}"$)
	End If
End Sub
Public Sub getImage As String
	Return mImageName
End Sub

Public Sub setEnabled(enabled As Boolean)
	mBase.Enabled = enabled
	mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled)
End Sub
Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

' Set the tile status to normal.
Public Sub SetStatusNormal(text As String)
	setStatus(HMITileUtils.STATUS_NORMAL)
End Sub

' Set the tile status to warning.
Public Sub SetStatusWarning(text As String)
	setStatus(HMITileUtils.STATUS_WARNING)
End Sub

' Set the tile status to alarm.
Public Sub SetStatusAlarm(text As String)
	setStatus(HMITileUtils.STATUS_ALARM)
End Sub

' Set the tile status to disabled.
Public Sub SetStatusDisabled(text As String)
	setStatus(HMITileUtils.STATUS_DISABLED)
End Sub

' Applies one of the tile status.
' tilestate - Use STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
' Parameters:
'	value String 
Public Sub setStatus(value As String)
	ApplyStatusStyle(value)
End Sub
Public Sub getStatus As String
	Return mStatus
End Sub

Public Sub setRounded(state As Boolean)
	mRounded = state
	B4XImageViewHMITile.RoundedImage = mRounded
End Sub
Public Sub getRounded As Boolean
	Return mRounded
End Sub

Public Sub setResizeMode(value As String)
	mResizeMode = value
	B4XImageViewHMITile.ResizeMode = value
End Sub
Public Sub getResizeMode As Boolean
	Return mResizeMode
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
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND
		Case HMITileUtils.STATUS_WARNING
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND
		Case HMITileUtils.STATUS_ALARM
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND
		Case HMITileUtils.STATUS_DISABLED
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	End Select

	' Make image view background match HMITile
	B4XImageViewHMITile.mBackgroundColor = mBase.Color
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region
