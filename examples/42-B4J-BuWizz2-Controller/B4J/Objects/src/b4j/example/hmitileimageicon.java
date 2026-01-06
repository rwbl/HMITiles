package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitileimageicon extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitileimageicon", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitileimageicon.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4j.objects.JFX _fx = null;
public Object _tag = null;
public b4j.example.b4ximageview _b4ximageviewhmitile = null;
public String _mimagename = "";
public String _mresizemode = "";
public String _mrounded = "";
public String _mtypestyle = "";
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)";
 //BA.debugLineNum = 62;BA.debugLine="mBase.LoadLayout(\"hmitileimageicon\")";
_mbase.LoadLayout("hmitileimageicon",ba);
 //BA.debugLineNum = 63;BA.debugLine="mImageName 	= Props.Get(\"ImageName\")";
_mimagename = BA.ObjectToString(_props.Get((Object)("ImageName")));
 //BA.debugLineNum = 64;BA.debugLine="mResizeMode	= Props.Get(\"ResizeMode\")";
_mresizemode = BA.ObjectToString(_props.Get((Object)("ResizeMode")));
 //BA.debugLineNum = 65;BA.debugLine="mRounded 	= Props.Get(\"Rounded\")";
_mrounded = BA.ObjectToString(_props.Get((Object)("Rounded")));
 //BA.debugLineNum = 66;BA.debugLine="mTypeStyle	= Props.Get(\"TypeStyle\")";
_mtypestyle = BA.ObjectToString(_props.Get((Object)("TypeStyle")));
 //BA.debugLineNum = 68;BA.debugLine="setResizeMode(mResizeMode)";
_setresizemode(_mresizemode);
 //BA.debugLineNum = 69;BA.debugLine="setRounded(mRounded)";
_setrounded(BA.ObjectToBoolean(_mrounded));
 //BA.debugLineNum = 71;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 72;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _hmitilestate) throws Exception{
int _state = 0;
 //BA.debugLineNum = 166;BA.debugLine="Public Sub ApplyStyle(HMITilestate As String)";
 //BA.debugLineNum = 167;BA.debugLine="Dim state As Int = HMITileUtils.StateStyleToState";
_state = _hmitileutils._statestyletostate /*int*/ (_hmitilestate);
 //BA.debugLineNum = 168;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 170;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 172;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 174;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 176;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 180;BA.debugLine="B4XImageViewHMITile.mBackgroundColor = mBase.Colo";
_b4ximageviewhmitile._mbackgroundcolor /*int*/  = _mbase.getColor();
 //BA.debugLineNum = 182;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
float _imageheight = 0f;
 //BA.debugLineNum = 75;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 76;BA.debugLine="If Not(B4XImageViewHMITile.IsInitialized) Then Re";
if (__c.Not(_b4ximageviewhmitile.IsInitialized /*boolean*/ ())) { 
if (true) return "";};
 //BA.debugLineNum = 78;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + 4dip";
_pad = (int) (_hmitileutils._border_width /*double*/ +__c.DipToCurrent((int) (4)));
 //BA.debugLineNum = 79;BA.debugLine="Dim imageHeight As Float = Height - pad * 2";
_imageheight = (float) (_height-_pad*2);
 //BA.debugLineNum = 82;BA.debugLine="B4XImageViewHMITile.mBase.SetLayoutAnimated(0, _";
_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_imageheight);
 //BA.debugLineNum = 89;BA.debugLine="If mImageName <> \"\" Then";
if ((_mimagename).equals("") == false) { 
 //BA.debugLineNum = 90;BA.debugLine="setImage(mImageName)";
_setimage(_mimagename);
 };
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 27;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 29;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 34;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 36;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 39;BA.debugLine="Private B4XImageViewHMITile As B4XImageView";
_b4ximageviewhmitile = new b4j.example.b4ximageview();
 //BA.debugLineNum = 42;BA.debugLine="Private mImageName As String";
_mimagename = "";
 //BA.debugLineNum = 43;BA.debugLine="Private mResizeMode As String";
_mresizemode = "";
 //BA.debugLineNum = 44;BA.debugLine="Private mRounded As String";
_mrounded = "";
 //BA.debugLineNum = 45;BA.debugLine="Private mTypeStyle As String";
_mtypestyle = "";
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Public Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 54;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 55;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 56;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 57;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 58;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 130;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 131;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return false;
}
public String  _getimage() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Public Sub getImage As String";
 //BA.debugLineNum = 123;BA.debugLine="Return mImageName";
if (true) return _mimagename;
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public boolean  _getresizemode() throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Public Sub getResizeMode As Boolean";
 //BA.debugLineNum = 155;BA.debugLine="Return mResizeMode";
if (true) return BA.ObjectToBoolean(_mresizemode);
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return false;
}
public boolean  _getrounded() throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub getRounded As Boolean";
 //BA.debugLineNum = 147;BA.debugLine="Return mRounded";
if (true) return BA.ObjectToBoolean(_mrounded);
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return false;
}
public String  _gettypestyle() throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Public Sub getTypeStyle As String";
 //BA.debugLineNum = 139;BA.debugLine="Return mTypeStyle";
if (true) return _mtypestyle;
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 48;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 49;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 50;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 127;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 128;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (_mbase.getEnabled()));
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public String  _setimage(String _image) throws Exception{
String _folder = "";
 //BA.debugLineNum = 97;BA.debugLine="Public Sub setImage(image As String)";
 //BA.debugLineNum = 98;BA.debugLine="If image = \"\" Then Return";
if ((_image).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 99;BA.debugLine="mImageName = image";
_mimagename = _image;
 //BA.debugLineNum = 104;BA.debugLine="Dim folder As String = File.DirApp";
_folder = __c.File.getDirApp();
 //BA.debugLineNum = 106;BA.debugLine="If File.Exists(folder, mImageName) Then";
if (__c.File.Exists(_folder,_mimagename)) { 
 //BA.debugLineNum = 107;BA.debugLine="Try";
try { //BA.debugLineNum = 108;BA.debugLine="B4XImageViewHMITile.Bitmap = xui.LoadBitmapResi";
_b4ximageviewhmitile._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (_xui.LoadBitmapResize(_folder,_image,(int) (_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()),(int) (_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()),__c.True));
 //BA.debugLineNum = 112;BA.debugLine="B4XImageViewHMITile.CornersRadius = HMITileUtil";
_b4ximageviewhmitile._setcornersradius /*int*/ ((int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 113;BA.debugLine="B4XImageViewHMITile.ResizeMode = mResizeMode";
_b4ximageviewhmitile._setresizemode /*String*/ (_mresizemode);
 //BA.debugLineNum = 114;BA.debugLine="B4XImageViewHMITile.RoundedImage = mRounded";
_b4ximageviewhmitile._setroundedimage /*boolean*/ (BA.ObjectToBoolean(_mrounded));
 } 
       catch (Exception e11) {
			ba.setLastException(e11); //BA.debugLineNum = 116;BA.debugLine="Log($\"[HMITileImageIcon.LoadImage][E] Unable to";
__c.LogImpl("949217555",("[HMITileImageIcon.LoadImage][E] Unable to load image '"+__c.SmartStringFormatter("",(Object)(_image))+"': "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 }else {
 //BA.debugLineNum = 119;BA.debugLine="Log($\"[HMITileImageIcon][E] Image not found ${fo";
__c.LogImpl("949217558",("[HMITileImageIcon][E] Image not found "+__c.SmartStringFormatter("",(Object)(_folder))+" "+__c.SmartStringFormatter("",(Object)(_mimagename))+""),0);
 };
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _setresizemode(String _value) throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Public Sub setResizeMode(value As String)";
 //BA.debugLineNum = 151;BA.debugLine="mResizeMode = value";
_mresizemode = _value;
 //BA.debugLineNum = 152;BA.debugLine="B4XImageViewHMITile.ResizeMode = value";
_b4ximageviewhmitile._setresizemode /*String*/ (_value);
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public String  _setrounded(boolean _state) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Public Sub setRounded(state As Boolean)";
 //BA.debugLineNum = 143;BA.debugLine="mRounded = state";
_mrounded = BA.ObjectToString(_state);
 //BA.debugLineNum = 144;BA.debugLine="B4XImageViewHMITile.RoundedImage = mRounded";
_b4ximageviewhmitile._setroundedimage /*boolean*/ (BA.ObjectToBoolean(_mrounded));
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public String  _settypestyle(String _value) throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Public Sub setTypeStyle(value As String)";
 //BA.debugLineNum = 135;BA.debugLine="mTypeStyle = value";
_mtypestyle = _value;
 //BA.debugLineNum = 136;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
