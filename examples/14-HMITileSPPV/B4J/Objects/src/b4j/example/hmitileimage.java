package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitileimage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitileimage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitileimage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public b4j.example.b4ximageview _b4ximageviewhmitile = null;
public String _mtitle = "";
public String _mimagename = "";
public String _mstatus = "";
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 61;BA.debugLine="BasePane.LoadLayout(\"hmitileimage\")";
_basepane.LoadLayout("hmitileimage",ba);
 //BA.debugLineNum = 63;BA.debugLine="mTitle 			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 64;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 65;BA.debugLine="mImageName 		= Props.Get(\"ImageName\")";
_mimagename = BA.ObjectToString(_props.Get((Object)("ImageName")));
 //BA.debugLineNum = 66;BA.debugLine="mStatus			= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 68;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 69;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 190;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 192;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 194;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 196;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 199;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_WARNIN";
_basepane.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 202;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_ALARM_";
_basepane.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 205;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_DISABL";
_basepane.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 209;BA.debugLine="B4XImageViewHMITile.mBackgroundColor = BasePane.C";
_b4ximageviewhmitile._mbackgroundcolor /*int*/  = _basepane.getColor();
 //BA.debugLineNum = 211;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
String _folder = "";
 //BA.debugLineNum = 72;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 73;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 76;BA.debugLine="LabelTitle.SetLayoutAnimated				(0, 0, 0,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 77;BA.debugLine="B4XImageViewHMITile.mBase.SetLayoutAnimated	(0, 0";
_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),0,_height*0.25,_width,_height*0.70);
 //BA.debugLineNum = 80;BA.debugLine="If mImageName <> \"\" Then";
if ((_mimagename).equals("") == false) { 
 //BA.debugLineNum = 85;BA.debugLine="Dim folder As String = File.DirApp";
_folder = __c.File.getDirApp();
 //BA.debugLineNum = 87;BA.debugLine="If File.Exists(folder, mImageName) Then";
if (__c.File.Exists(_folder,_mimagename)) { 
 //BA.debugLineNum = 88;BA.debugLine="Try";
try { //BA.debugLineNum = 90;BA.debugLine="B4XImageViewHMITile.Bitmap = xui.LoadBitmapRes";
_b4ximageviewhmitile._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (_xui.LoadBitmapResize(_folder,_mimagename,(int) (_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()),(int) (_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()),__c.True));
 } 
       catch (Exception e10) {
			ba.setLastException(e10); //BA.debugLineNum = 97;BA.debugLine="Log($\"[HMITileImage.LoadImage][E] Unable to lo";
__c.LogImpl("950266137",("[HMITileImage.LoadImage][E] Unable to load image '"+__c.SmartStringFormatter("",(Object)(_mimagename))+"': "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 }else {
 //BA.debugLineNum = 100;BA.debugLine="Log($\"[HMITileImage][E] Image not found ${folde";
__c.LogImpl("950266140",("[HMITileImage][E] Image not found "+__c.SmartStringFormatter("",(Object)(_folder))+" "+__c.SmartStringFormatter("",(Object)(_mimagename))+""),0);
 };
 };
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 27;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 29;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Public BaseLabel As B4XView";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 33;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 36;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private B4XImageViewHMITile As B4XImageView";
_b4ximageviewhmitile = new b4j.example.b4ximageview();
 //BA.debugLineNum = 40;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 41;BA.debugLine="Private mImageName As String";
_mimagename = "";
 //BA.debugLineNum = 42;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Public Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 53;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 54;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 55;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 56;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 57;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 146;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return false;
}
public String  _getimage() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Public Sub getImage As String";
 //BA.debugLineNum = 137;BA.debugLine="Return mImageName";
if (true) return _mimagename;
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 177;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 113;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 47;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 48;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 49;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 141;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 142;BA.debugLine="BasePane.Alpha = IIf(enabled, 1, 0.4)";
_basepane.setAlpha((float)(BA.ObjectToNumber(((_enabled) ? ((Object)(1)) : ((Object)(0.4))))));
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _setimage(String _image) throws Exception{
String _folder = "";
 //BA.debugLineNum = 116;BA.debugLine="Public Sub setImage(image As String)";
 //BA.debugLineNum = 117;BA.debugLine="If image = \"\" Then Return";
if ((_image).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 118;BA.debugLine="mImageName = image";
_mimagename = _image;
 //BA.debugLineNum = 123;BA.debugLine="Dim folder As String = File.DirApp";
_folder = __c.File.getDirApp();
 //BA.debugLineNum = 125;BA.debugLine="Try";
try { //BA.debugLineNum = 126;BA.debugLine="B4XImageViewHMITile.Bitmap = xui.LoadBitmapResiz";
_b4ximageviewhmitile._setbitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ (_xui.LoadBitmapResize(_folder,_image,(int) (_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()),(int) (_b4ximageviewhmitile._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()),__c.True));
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 133;BA.debugLine="Log($\"[HMITileImage.SetImage][E] Unable to load";
__c.LogImpl("950462737",("[HMITileImage.SetImage][E] Unable to load image '"+__c.SmartStringFormatter("",(Object)(_image))+"': "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 173;BA.debugLine="Private Sub setStatus(value As String)";
 //BA.debugLineNum = 174;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _setstatusalarm() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub SetStatusAlarm";
 //BA.debugLineNum = 161;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public String  _setstatusdisabled() throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Public Sub SetStatusDisabled";
 //BA.debugLineNum = 166;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public String  _setstatuswarning() throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Public Sub SetStatusWarning";
 //BA.debugLineNum = 156;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 110;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 151;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
