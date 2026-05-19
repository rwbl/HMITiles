B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.3
@EndOfDesignText@
#Region Class Header
' ================================================================
' File:    		HMITileImage.bas
' Brief:   		CustomView HMITile with Title (25%) + Image (75%).
' Description:	Image must be located in File.DirApp (B4J) or File.DirAssets (B4A).
'				Default size set to 120x120px.
' Date:			2026-04-23
' Author:		Robert W.B. Linn (c) 2025 MIT
' Layout:
'				+------------------+
'				|     Title        |  << 25%
'				|------------------|
'				|                  |
'				|     Image        |  << 75%
'				|                  |
'				+------------------+
' ================================================================
#End Region

' Designer properties
#DesignerProperty: Key: Title,		DisplayName: Title, FieldType: String, DefaultValue: Image
#DesignerProperty: Key: ImageName,	DisplayName: Image Name, FieldType: String, DefaultValue: , Description: Name of the image located in the app folder.
#DesignerProperty: Key: Status, 	DisplayName: Status, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

Private Sub Class_Globals
	Private mEventName As String	'ignore
	Private mCallBack As Object		'ignore

	Public BasePane As B4XView
	Public BaseLabel As B4XView

	Private xui As XUI
	Public Tag As Object

	' Views from HMITileImage.bjl
	Private LabelTitle As B4XView
	Private B4XImageViewHMITile As B4XImageView

	' Properties Designer
	Private mTitle As String
	Private mImageName As String
	Private mStatus As String
	
	' Properties Class
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Public Sub DesignerCreateView(Base As Object, Lbl As Label, Props As Map)
	BasePane = Base
	BaseLabel = Lbl
	Tag = BasePane.Tag
	BasePane.Tag = Me
	CallSubDelayed2(Me, "AfterLoadLayout", Props)
End Sub

Private Sub AfterLoadLayout(Props As Map)	'ignore
	BasePane.LoadLayout("hmitileimage")

	mTitle 			= Props.Get("Title")
	LabelTitle.Text = mTitle
	mImageName 		= Props.Get("ImageName")
	mStatus			= Props.Get("Status")

	ApplyStatusStyle(mStatus)
	Base_Resize(BasePane.Width, BasePane.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return

	'											 d  l  t              w         h
	LabelTitle.SetLayoutAnimated				(0, 0, 0,             Width, 	Height * 0.25)
	B4XImageViewHMITile.mBase.SetLayoutAnimated	(0, 0, Height * 0.25, Width, 	Height * 0.70)

	' Load image if available
	If mImageName <> "" Then
		#if B4A
		Dim folder As String = File.DirAssets	' DirDefaultExternal
		#End If
		#if B4J
		Dim folder As String = File.DirApp		
		#End If
		If File.Exists(folder, mImageName) Then
			Try
				' Load image and resize with keeping aspect ratio
				B4XImageViewHMITile.Bitmap = xui.LoadBitmapResize( _ 
					folder, _ 
					mImageName, _
					B4XImageViewHMITile.mBase.Width, _
					B4XImageViewHMITile.mBase.Height, _
					True)
			Catch
				Log($"[HMITileImage.LoadImage][E] Unable to load image '${mImageName}': ${LastException}"$)
			End Try
		Else
			Log($"[HMITileImage][E] Image not found ${folder} ${mImageName}"$)
		End If
	End If
End Sub

' ===================================================================
' Public API
' ===================================================================

Public Sub setTitle(title As String)
	LabelTitle.Text = title
End Sub
Public Sub getTitle As String
	Return LabelTitle.Text
End Sub

Public Sub setImage(image As String)
	If image = "" Then Return
	mImageName = image
	#if B4A
	Dim folder As String = File.DirAssets	' DirDefaultExternal
	#End If
	#if B4J
	Dim folder As String = File.DirApp		
	#End If
	Try
		B4XImageViewHMITile.Bitmap = xui.LoadBitmapResize( _ 
			folder, _ 
			image, _
            B4XImageViewHMITile.mBase.Width, _
            B4XImageViewHMITile.mBase.Height, _
            True)
	Catch
		Log($"[HMITileImage.SetImage][E] Unable to load image '${image}': ${LastException}"$)
	End Try
End Sub
Public Sub getImage As String
	Return mImageName
End Sub

Public Sub setEnabled(enabled As Boolean)
	BasePane.Enabled = enabled
	BasePane.Alpha = IIf(enabled, 1, 0.4)
End Sub

Public Sub getEnabled As Boolean
	Return BasePane.Enabled
End Sub

' Set the tile status to normal.
Public Sub StatusNormal
	setStatus(HMITileUtils.STATUS_NORMAL)
End Sub

' Set the tile status to warning.
Public Sub SetStatusWarning
	setStatus(HMITileUtils.STATUS_WARNING)
End Sub

' Set the tile status to alarm.
Public Sub SetStatusAlarm
	setStatus(HMITileUtils.STATUS_ALARM)
End Sub

' Set the tile status to disabled.
Public Sub SetStatusDisabled
	setStatus(HMITileUtils.STATUS_DISABLED)
End Sub

' Applies one of the tile status.
' tilestate - Use STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
' Parameters:
'	value String 
Private Sub setStatus(value As String)
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

	HMITileUtils.ApplyTitleStyle(LabelTitle)

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

	' Make image view background match HMITile
	B4XImageViewHMITile.mBackgroundColor = BasePane.Color
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	BasePane.SetColorAndBorder(BasePane.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region
