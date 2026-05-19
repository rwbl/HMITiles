package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitilebutton extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitilebutton");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitilebutton.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
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
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 127;BA.debugLine="mBase.LoadLayout(\"hmitilebutton\")";
_mbase.LoadLayout("hmitilebutton",ba);
 //BA.debugLineNum = 130;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 131;BA.debugLine="LabelTitle.Text	= mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 132;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = BA.ObjectToBoolean(_props.Get((Object)("Value")));
 //BA.debugLineNum = 133;BA.debugLine="mStatus 		= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 134;BA.debugLine="mOnText 		= Props.Get(\"OnText\")";
_montext = BA.ObjectToString(_props.Get((Object)("OnText")));
 //BA.debugLineNum = 135;BA.debugLine="mOffText 		= Props.Get(\"OffText\")";
_mofftext = BA.ObjectToString(_props.Get((Object)("OffText")));
 //BA.debugLineNum = 137;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 138;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 140;BA.debugLine="setValue(mValue)";
_setvalue(_mvalue);
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
int _textcolor = 0;
 //BA.debugLineNum = 255;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 256;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 258;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 259;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (ba,_labelvalue);
 //BA.debugLineNum = 261;BA.debugLine="Dim textcolor As Int";
_textcolor = 0;
 //BA.debugLineNum = 262;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 264;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_NO";
_textcolor = _hmitileutils._color_tile_normal_text /*int*/ ;
 //BA.debugLineNum = 265;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 268;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_WA";
_textcolor = _hmitileutils._color_tile_warning_text /*int*/ ;
 //BA.debugLineNum = 269;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 272;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_AL";
_textcolor = _hmitileutils._color_tile_alarm_text /*int*/ ;
 //BA.debugLineNum = 273;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 276;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_DI";
_textcolor = _hmitileutils._color_tile_disabled_text /*int*/ ;
 //BA.debugLineNum = 277;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 280;BA.debugLine="LabelTitle.TextColor = textcolor";
_labeltitle.setTextColor(_textcolor);
 //BA.debugLineNum = 281;BA.debugLine="LabelValue.TextColor = textcolor";
_labelvalue.setTextColor(_textcolor);
 //BA.debugLineNum = 282;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMI";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 143;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 144;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(LabelValu";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 146;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 148;BA.debugLine="If LabelTitle.Text.Length > 0 Then";
if (_labeltitle.getText().length()>0) { 
 //BA.debugLineNum = 149;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad,  pad,";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 150;BA.debugLine="LabelValue.SetLayoutAnimated(0, pad,  Height * 0";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(int) (_height*0.25),(int) (_width-_pad*2),(int) (_height*0.60));
 }else {
 //BA.debugLineNum = 152;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad,  pad,";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0));
 //BA.debugLineNum = 153;BA.debugLine="LabelValue.SetLayoutAnimated(0, pad,  0,";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(int) (0),(int) (_width-_pad*2),(int) (_height));
 };
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 89;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 90;BA.debugLine="Private mLbl As B4XView			'ignore";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 91;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 94;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 95;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 98;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 99;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 100;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 103;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 104;BA.debugLine="Private mValue As Boolean";
_mvalue = false;
 //BA.debugLineNum = 105;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 106;BA.debugLine="Private mOnText As String";
_montext = "";
 //BA.debugLineNum = 107;BA.debugLine="Private mOffText As String";
_mofftext = "";
 //BA.debugLineNum = 110;BA.debugLine="Private mIsPressed As Boolean = False			'ignore";
_mispressed = __c.False;
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 119;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 120;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 121;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 122;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 123;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 215;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return false;
}
public String  _getofftext() throws Exception{
 //BA.debugLineNum = 195;BA.debugLine="Public Sub getOffText As String";
 //BA.debugLineNum = 196;BA.debugLine="Return mOffText";
if (true) return _mofftext;
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public String  _getontext() throws Exception{
 //BA.debugLineNum = 186;BA.debugLine="Public Sub getOnText As String";
 //BA.debugLineNum = 187;BA.debugLine="Return mOnText";
if (true) return _montext;
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return "";
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 242;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 168;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public boolean  _getvalue() throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Public Sub getValue As Boolean";
 //BA.debugLineNum = 178;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 113;BA.debugLine="Private Sub Initialize (Callback As Object, EventN";
 //BA.debugLineNum = 114;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 115;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public String  _labeltitle_click() throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Private Sub LabelTitle_Click";
 //BA.debugLineNum = 310;BA.debugLine="LabelValue_Click";
_labelvalue_click();
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return "";
}
public String  _labelvalue_click() throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Private Sub LabelValue_Click";
 //BA.debugLineNum = 304;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 305;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 211;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 212;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (ba,_mbase.getEnabled()));
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public String  _setofftext(String _value) throws Exception{
 //BA.debugLineNum = 191;BA.debugLine="Public Sub setOffText(value As String)";
 //BA.debugLineNum = 192;BA.debugLine="mOffText = value";
_mofftext = _value;
 //BA.debugLineNum = 193;BA.debugLine="LabelValue.Text = mOffText";
_labelvalue.setText(BA.ObjectToCharSequence(_mofftext));
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _setontext(String _value) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub setOnText(value As String)";
 //BA.debugLineNum = 183;BA.debugLine="mOnText = value";
_montext = _value;
 //BA.debugLineNum = 184;BA.debugLine="LabelValue.Text = mOnText";
_labelvalue.setText(BA.ObjectToCharSequence(_montext));
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 237;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 238;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 164;BA.debugLine="mTitle = value";
_mtitle = _value;
 //BA.debugLineNum = 165;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(boolean _value) throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Public Sub setValue(value As Boolean)";
 //BA.debugLineNum = 173;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 174;BA.debugLine="LabelValue.Text = IIf(mValue, mOnText, mOffText)";
_labelvalue.setText(BA.ObjectToCharSequence(((_mvalue) ? ((Object)(_montext)) : ((Object)(_mofftext)))));
 //BA.debugLineNum = 175;BA.debugLine="HMITileUtils.ApplyValueStyleOnOff(mBase, LabelVal";
_hmitileutils._applyvaluestyleonoff /*String*/ (ba,_mbase,_labelvalue,_mvalue);
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 227;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 228;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 232;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 220;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 223;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 224;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public String  _valuefontdefault() throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="Public Sub ValueFontDefault";
 //BA.debugLineNum = 206;BA.debugLine="LabelValue.Font = xui.CreateDefaultFont(HMITileUt";
_labelvalue.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public String  _valuefontfontawesome() throws Exception{
 //BA.debugLineNum = 200;BA.debugLine="Public Sub ValueFontFontAwesome";
 //BA.debugLineNum = 201;BA.debugLine="LabelValue.Font = xui.CreateFontAwesome(HMITileUt";
_labelvalue.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
