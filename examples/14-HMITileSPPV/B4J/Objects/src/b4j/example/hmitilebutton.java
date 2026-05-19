package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilebutton extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilebutton", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilebutton.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public String _mtitle = "";
public boolean _mvalue = false;
public String _mstatus = "";
public String _montext = "";
public String _mofftext = "";
public boolean _mispressed = false;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 147;BA.debugLine="BasePane.LoadLayout(\"hmitilebutton\")";
_basepane.LoadLayout("hmitilebutton",ba);
 //BA.debugLineNum = 150;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 151;BA.debugLine="LabelTitle.Text	= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 152;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = BA.ObjectToBoolean(_props.Get((Object)("Value")));
 //BA.debugLineNum = 153;BA.debugLine="mStatus 		= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 154;BA.debugLine="mOnText 		= Props.Get(\"OnText\")";
_montext = BA.ObjectToString(_props.Get((Object)("OnText")));
 //BA.debugLineNum = 155;BA.debugLine="mOffText 		= Props.Get(\"OffText\")";
_mofftext = BA.ObjectToString(_props.Get((Object)("OffText")));
 //BA.debugLineNum = 157;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 159;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 161;BA.debugLine="setValue(mValue)";
_setvalue(_mvalue);
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 292;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 293;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 294;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _l = 0f;
float _t = 0f;
float _w = 0f;
float _h = 0f;
 //BA.debugLineNum = 164;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 165;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(LabelValu";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 166;BA.debugLine="Dim l, t, w, h As Float";
_l = 0f;
_t = 0f;
_w = 0f;
_h = 0f;
 //BA.debugLineNum = 168;BA.debugLine="If LabelTitle.Text.Length > 0 Then";
if (_labeltitle.getText().length()>0) { 
 //BA.debugLineNum = 170;BA.debugLine="l = 0";
_l = (float) (0);
 //BA.debugLineNum = 171;BA.debugLine="t = 0";
_t = (float) (0);
 //BA.debugLineNum = 172;BA.debugLine="w = Width";
_w = (float) (_width);
 //BA.debugLineNum = 173;BA.debugLine="h = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACT";
_h = (float) (_height*_hmitileutils._tile_title_height_factor /*float*/ );
 //BA.debugLineNum = 174;BA.debugLine="LabelTitle.SetLayoutAnimated(0, l, t, w, h)";
_labeltitle.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 176;BA.debugLine="l = 0";
_l = (float) (0);
 //BA.debugLineNum = 177;BA.debugLine="t = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACT";
_t = (float) (_height*_hmitileutils._tile_title_height_factor /*float*/ );
 //BA.debugLineNum = 178;BA.debugLine="w = Width";
_w = (float) (_width);
 //BA.debugLineNum = 179;BA.debugLine="h = Height * HMITileUtils.TILE_VALUE_HEIGHT_FACT";
_h = (float) (_height*_hmitileutils._tile_value_height_factor /*float*/ );
 //BA.debugLineNum = 180;BA.debugLine="LabelValue.SetLayoutAnimated(0, l, t, w, h)";
_labelvalue.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 }else {
 //BA.debugLineNum = 183;BA.debugLine="l = 0";
_l = (float) (0);
 //BA.debugLineNum = 184;BA.debugLine="t = 0";
_t = (float) (0);
 //BA.debugLineNum = 185;BA.debugLine="w = Width";
_w = (float) (_width);
 //BA.debugLineNum = 186;BA.debugLine="h = 0";
_h = (float) (0);
 //BA.debugLineNum = 187;BA.debugLine="LabelTitle.SetLayoutAnimated(0, l, t, w, h)";
_labeltitle.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 189;BA.debugLine="l = 0";
_l = (float) (0);
 //BA.debugLineNum = 190;BA.debugLine="t = 0";
_t = (float) (0);
 //BA.debugLineNum = 191;BA.debugLine="w = Width";
_w = (float) (_width);
 //BA.debugLineNum = 192;BA.debugLine="h = Height";
_h = (float) (_height);
 //BA.debugLineNum = 193;BA.debugLine="LabelValue.SetLayoutAnimated(0, l, t, w, h)";
_labelvalue.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 };
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 109;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 110;BA.debugLine="Private BaseLabel As B4XView			'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 111;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 114;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 115;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 118;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 119;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 120;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 123;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 124;BA.debugLine="Private mValue As Boolean";
_mvalue = false;
 //BA.debugLineNum = 125;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 126;BA.debugLine="Private mOnText As String";
_montext = "";
 //BA.debugLineNum = 127;BA.debugLine="Private mOffText As String";
_mofftext = "";
 //BA.debugLineNum = 130;BA.debugLine="Private mIsPressed As Boolean = False			'ignore";
_mispressed = __c.False;
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 139;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 140;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 141;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 142;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 143;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 255;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return false;
}
public String  _getofftext() throws Exception{
 //BA.debugLineNum = 235;BA.debugLine="Public Sub getOffText As String";
 //BA.debugLineNum = 236;BA.debugLine="Return mOffText";
if (true) return _mofftext;
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return "";
}
public String  _getontext() throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Public Sub getOnText As String";
 //BA.debugLineNum = 227;BA.debugLine="Return mOnText";
if (true) return _montext;
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 281;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 282;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 207;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 208;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public boolean  _getvalue() throws Exception{
 //BA.debugLineNum = 217;BA.debugLine="Public Sub getValue As Boolean";
 //BA.debugLineNum = 218;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 133;BA.debugLine="Private Sub Initialize (Callback As Object, EventN";
 //BA.debugLineNum = 134;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 135;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public String  _labeltitle_click() throws Exception{
 //BA.debugLineNum = 319;BA.debugLine="Private Sub LabelTitle_Click";
 //BA.debugLineNum = 320;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 321;BA.debugLine="End Sub";
return "";
}
public String  _labeltitle_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 304;BA.debugLine="Private Sub LabelTitle_MouseClicked(EventData As M";
 //BA.debugLineNum = 305;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return "";
}
public String  _labelvalue_click() throws Exception{
 //BA.debugLineNum = 315;BA.debugLine="Private Sub LabelValue_Click";
 //BA.debugLineNum = 316;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public String  _labelvalue_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 308;BA.debugLine="Private Sub LabelValue_MouseClicked (EventData As";
 //BA.debugLineNum = 309;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 251;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 252;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public String  _setofftext(String _value) throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Public Sub setOffText(value As String)";
 //BA.debugLineNum = 232;BA.debugLine="mOffText = value";
_mofftext = _value;
 //BA.debugLineNum = 233;BA.debugLine="LabelValue.Text = mOffText";
_labelvalue.setText(_mofftext);
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public String  _setontext(String _value) throws Exception{
 //BA.debugLineNum = 222;BA.debugLine="Public Sub setOnText(value As String)";
 //BA.debugLineNum = 223;BA.debugLine="mOnText = value";
_montext = _value;
 //BA.debugLineNum = 224;BA.debugLine="LabelValue.Text = mOnText";
_labelvalue.setText(_montext);
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 277;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 278;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 204;BA.debugLine="mTitle = value";
_mtitle = _value;
 //BA.debugLineNum = 205;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(boolean _value) throws Exception{
 //BA.debugLineNum = 212;BA.debugLine="Public Sub setValue(value As Boolean)";
 //BA.debugLineNum = 213;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 214;BA.debugLine="LabelValue.Text = IIf(mValue, mOnText, mOffText)";
_labelvalue.setText(BA.ObjectToString(((_mvalue) ? ((Object)(_montext)) : ((Object)(_mofftext)))));
 //BA.debugLineNum = 215;BA.debugLine="HMITileUtils.ApplyValueStyleOnOff(BasePane, Label";
_hmitileutils._applyvaluestyleonoff /*String*/ (_basepane,_labelvalue,_mvalue);
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 268;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 272;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 260;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 263;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 264;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return "";
}
public String  _tileclick() throws Exception{
 //BA.debugLineNum = 323;BA.debugLine="Private Sub TileClick";
 //BA.debugLineNum = 324;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 325;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public String  _valuefontdefault() throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Public Sub ValueFontDefault";
 //BA.debugLineNum = 246;BA.debugLine="LabelValue.Font = xui.CreateDefaultFont(HMITileUt";
_labelvalue.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return "";
}
public String  _valuefontfontawesome() throws Exception{
 //BA.debugLineNum = 240;BA.debugLine="Public Sub ValueFontFontAwesome";
 //BA.debugLineNum = 241;BA.debugLine="LabelValue.Font = xui.CreateFontAwesome(HMITileUt";
_labelvalue.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
