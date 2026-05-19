package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitileimageicon extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitileimageicon");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitileimageicon.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public Object _tag = null;
public b4a.example.b4ximageview _b4ximageviewhmitile = null;
public String _mimagename = "";
public String _mresizemode = "";
public String _mrounded = "";
public String _mstatus = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 64;BA.debugLine="mBase.LoadLayout(\"hmitileimageicon\")";
_mbase.LoadLayout("hmitileimageicon",ba);
 //BA.debugLineNum = 65;BA.debugLine="mImageName 	= Props.Get(\"ImageName\")";
_mimagename = BA.ObjectToString(_props.Get((Object)("ImageName")));
 //BA.debugLineNum = 66;BA.debugLine="mResizeMode	= Props.Get(\"ResizeMode\")";
_mresizemode = BA.ObjectToString(_props.Get((Object)("ResizeMode")));
 //BA.debugLineNum = 67;BA.debugLine="mRounded 	= Props.Get(\"Rounded\")";
_mrounded = BA.ObjectToString(_props.Get((Object)("Rounded")));
 //BA.debugLineNum = 68;BA.debugLine="mStatus	= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 70;BA.debugLine="setResizeMode(mResizeMode)";
_setresizemode(_mresizemode);
 //BA.debugLineNum = 71;BA.debugLine="setRounded(mRounded)";
_setrounded(BA.ObjectToBoolean(_mrounded));
 //BA.debugLineNum = 73;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 74;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 194;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 196;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 198;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 200;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 202;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 204;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 208;BA.debugLine="B4XImageViewHMITile.mBackgroundColor = mBase.Colo";
_b4ximageviewhmitile._mbackgroundcolor /*int*/  = _mbase.getColor();
 //BA.debugLineNum = 210;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
float _imageheight = 0f;
 //BA.debugLineNum = 77;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 78;BA.debugLine="If Not(B4XImageViewHMITile.IsInitialized) Then Re";
if (__c.Not(_b4ximageviewhmitile.IsInitialized /*boolean*/ ())) { 
if (true) return "";};
 //BA.debugLineNum = 80;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + 4dip";
_pad = (int) (_hmitileutils._border_width /*double*/ +__c.DipToCurrent((int) (4)));
 //BA.debugLineNum = 81;BA.debugLine="Dim imageHeight As Float = Height - pad * 2";
_imageheight = (float) (_height-_pad*2);
 //BA.debugLineNum = 84;BA.debugLine="B4XImageViewHMITile.mBase.SetLayoutAnimated(0, _";
_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_imageheight));
 //BA.debugLineNum = 91;BA.debugLine="If mImageName <> \"\" Then";
if ((_mimagename).equals("") == false) { 
 //BA.debugLineNum = 92;BA.debugLine="setImage(mImageName)";
_setimage(_mimagename);
 };
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Private Sub Class_Globals";
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
 //BA.debugLineNum = 36;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 39;BA.debugLine="Private B4XImageViewHMITile As B4XImageView";
_b4ximageviewhmitile = new b4a.example.b4ximageview();
 //BA.debugLineNum = 42;BA.debugLine="Private mImageName As String";
_mimagename = "";
 //BA.debugLineNum = 43;BA.debugLine="Private mResizeMode As String";
_mresizemode = "";
 //BA.debugLineNum = 44;BA.debugLine="Private mRounded As String";
_mrounded = "";
 //BA.debugLineNum = 45;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Public Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 56;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 57;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 58;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 59;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 60;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 134;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return false;
}
public String  _getimage() throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Public Sub getImage As String";
 //BA.debugLineNum = 126;BA.debugLine="Return mImageName";
if (true) return _mimagename;
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public boolean  _getresizemode() throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub getResizeMode As Boolean";
 //BA.debugLineNum = 181;BA.debugLine="Return mResizeMode";
if (true) return BA.ObjectToBoolean(_mresizemode);
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return false;
}
public boolean  _getrounded() throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Public Sub getRounded As Boolean";
 //BA.debugLineNum = 173;BA.debugLine="Return mRounded";
if (true) return BA.ObjectToBoolean(_mrounded);
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 165;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 50;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 51;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 52;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 130;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 131;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (ba,_mbase.getEnabled()));
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public String  _setimage(String _image) throws Exception{
String _folder = "";
 //BA.debugLineNum = 100;BA.debugLine="Public Sub setImage(image As String)";
 //BA.debugLineNum = 101;BA.debugLine="If image = \"\" Then Return";
if ((_image).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 102;BA.debugLine="mImageName = image";
_mimagename = _image;
 //BA.debugLineNum = 104;BA.debugLine="Dim folder As String = File.DirAssets	' DirDefaul";
_folder = __c.File.getDirAssets();
 //BA.debugLineNum = 109;BA.debugLine="If File.Exists(folder, mImageName) Then";
if (__c.File.Exists(_folder,_mimagename)) { 
 //BA.debugLineNum = 110;BA.debugLine="Try";
try { //BA.debugLineNum = 111;BA.debugLine="B4XImageViewHMITile.Bitmap = xui.LoadBitmapResi";
_b4ximageviewhmitile._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (_xui.LoadBitmapResize(_folder,_image,_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight(),__c.True));
 //BA.debugLineNum = 115;BA.debugLine="B4XImageViewHMITile.CornersRadius = HMITileUtil";
_b4ximageviewhmitile._setcornersradius /*int*/ ((int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 116;BA.debugLine="B4XImageViewHMITile.ResizeMode = mResizeMode";
_b4ximageviewhmitile._setresizemode /*String*/ (_mresizemode);
 //BA.debugLineNum = 117;BA.debugLine="B4XImageViewHMITile.RoundedImage = mRounded";
_b4ximageviewhmitile._setroundedimage /*boolean*/ (BA.ObjectToBoolean(_mrounded));
 } 
       catch (Exception e11) {
			ba.setLastException(e11); //BA.debugLineNum = 119;BA.debugLine="Log($\"[HMITileImageIcon.LoadImage][E] Unable to";
__c.LogImpl("944105747",("[HMITileImageIcon.LoadImage][E] Unable to load image '"+__c.SmartStringFormatter("",(Object)(_image))+"': "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 }else {
 //BA.debugLineNum = 122;BA.debugLine="Log($\"[HMITileImageIcon][E] Image not found ${fo";
__c.LogImpl("944105750",("[HMITileImageIcon][E] Image not found "+__c.SmartStringFormatter("",(Object)(_folder))+" "+__c.SmartStringFormatter("",(Object)(_mimagename))+""),0);
 };
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _setresizemode(String _value) throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub setResizeMode(value As String)";
 //BA.debugLineNum = 177;BA.debugLine="mResizeMode = value";
_mresizemode = _value;
 //BA.debugLineNum = 178;BA.debugLine="B4XImageViewHMITile.ResizeMode = value";
_b4ximageviewhmitile._setresizemode /*String*/ (_value);
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _setrounded(boolean _state) throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Public Sub setRounded(state As Boolean)";
 //BA.debugLineNum = 169;BA.debugLine="mRounded = state";
_mrounded = BA.ObjectToString(_state);
 //BA.debugLineNum = 170;BA.debugLine="B4XImageViewHMITile.RoundedImage = mRounded";
_b4ximageviewhmitile._setroundedimage /*boolean*/ (BA.ObjectToBoolean(_mrounded));
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 162;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public String  _setstatusalarm(String _text) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub SetStatusAlarm(text As String)";
 //BA.debugLineNum = 149;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _setstatusdisabled(String _text) throws Exception{
 //BA.debugLineNum = 153;BA.debugLine="Public Sub SetStatusDisabled(text As String)";
 //BA.debugLineNum = 154;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public String  _setstatusnormal(String _text) throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Public Sub SetStatusNormal(text As String)";
 //BA.debugLineNum = 139;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public String  _setstatuswarning(String _text) throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Public Sub SetStatusWarning(text As String)";
 //BA.debugLineNum = 144;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
