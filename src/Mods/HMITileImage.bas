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
' Date:			2025-12-30
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
#DesignerProperty: Key: TitleText, DisplayName: Title, FieldType: String, DefaultValue: Image
#DesignerProperty: Key: ImageName, DisplayName: Image Name, FieldType: String, DefaultValue: , Description: Name of the image located in the app folder.
#DesignerProperty: Key: TypeStyle, DisplayName: Style, FieldType: String, List: Normal|Warning|Alarm|Dimmed, DefaultValue: Normal

Sub Class_Globals
	Private mEventName As String	'ignore
	Private mCallBack As Object		'ignore

	Public mBase As B4XView
	Public mLbl As B4XView

	Private xui As XUI
	Public Tag As Object

	' Views from HMITileImage.bjl
	Private LabelTitle As B4XView
	Private B4XImageViewHMITile As B4XImageView

	' Designer value
	Private mImageName As String
	Private mTypeStyle As String
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

Private Sub AfterLoadLayout(Props As Map)
	mBase.LoadLayout("hmitileimage")

	LabelTitle.Text = Props.Get("TitleText")
	mImageName 	= Props.Get("ImageName")
	mTypeStyle	= Props.Get("TypeStyle")

	ApplyStyle(mTypeStyle)
	Base_Resize(mBase.Width, mBase.Height)
End Sub

Private Sub Base_Resize(Width As Double, Height As Double)
	If Not(LabelTitle.IsInitialized) Then Return

	Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMITileUtils.PADDING

	'											 d  l    t                    w              h
	LabelTitle.SetLayoutAnimated				(0, pad, pad,                 Width, Height * 0.25)
	B4XImageViewHMITile.mBase.SetLayoutAnimated	(0, pad, Height * 0.25 + pad, Width - (pad * 2), Height * 0.70)

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
				B4XImageViewHMITile.Bitmap = xui.LoadBitmapResize(folder, mImageName, _
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
		B4XImageViewHMITile.Bitmap = xui.LoadBitmapResize(folder, image, _
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
	mBase.Enabled = enabled
	mBase.Alpha = IIf(enabled, 1, 0.4)
End Sub

Public Sub getEnabled As Boolean
	Return mBase.Enabled
End Sub

Public Sub setTypeStyle(value As String)
	mTypeStyle = value
	ApplyStyle(mTypeStyle)
End Sub
Public Sub getTypeStyle As String
	Return mTypeStyle
End Sub

' ================================================================
' HMITile STYLING
' ================================================================
#Region HMITile Styling
' ApplyStyle
' Apply one of the 4 styles Normal, Warning, Alarm, Disabled
' Parameters:
'	tilestate String - Use HMITileUtils constants STATE_NORMAL, STATE_WARNING, STATE_ALARM, STATE_DISABLED
Public Sub ApplyStyle(tilestate As String)
	HMITileUtils.ApplyTitleStyle(LabelTitle)

	Dim state As Int = HMITileUtils.StateStyleToState(tilestate)
	Select state
		Case HMITileUtils.STATE_NORMAL
			mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACKGROUND

		Case HMITileUtils.STATE_WARNING
			mBase.Color = HMITileUtils.COLOR_TILE_WARNING_BACKGROUND

		Case HMITileUtils.STATE_ALARM
			mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BACKGROUND

		Case HMITileUtils.STATE_DISABLED
			mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_BACKGROUND
	End Select

	' Make image view background match HMITile
	B4XImageViewHMITile.mBackgroundColor = mBase.Color
	' Border styling - All non-buttons clean, borderless tile with border-radius.
	mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITileUtils.BORDER_RADIUS)
End Sub
#End Region
