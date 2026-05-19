package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitilereadout extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitilereadout");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitilereadout.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelunit = null;
public String _mtitle = "";
public String _mvalue = "";
public String _munit = "";
public String _mstatus = "";
public boolean _menabled = false;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 66;BA.debugLine="mBase.LoadLayout(\"hmitilereadout\")";
_mbase.LoadLayout("hmitilereadout",ba);
 //BA.debugLineNum = 68;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 69;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 70;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = BA.ObjectToString(_props.Get((Object)("Value")));
 //BA.debugLineNum = 71;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(BA.ObjectToCharSequence(_mvalue));
 //BA.debugLineNum = 72;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 73;BA.debugLine="LabelUnit.Text 	= mUnit";
_labelunit.setText(BA.ObjectToCharSequence(_munit));
 //BA.debugLineNum = 74;BA.debugLine="mStatus		= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 76;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 78;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 164;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 166;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 167;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (ba,_labelvalue);
 //BA.debugLineNum = 168;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (ba,_labelunit);
 //BA.debugLineNum = 170;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 172;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 173;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 174;BA.debugLine="LabelUnit.TextColor = HMITileUtils.COLOR_TILE_N";
_labelunit.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 175;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 178;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 179;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 180;BA.debugLine="LabelUnit.TextColor = HMITileUtils.COLOR_TILE_W";
_labelunit.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 181;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 184;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 185;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 186;BA.debugLine="LabelUnit.TextColor = HMITileUtils.COLOR_TILE_A";
_labelunit.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 187;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 190;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 191;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 192;BA.debugLine="LabelUnit.TextColor = HMITileUtils.COLOR_TILE_D";
_labelunit.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 193;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 196;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 81;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 82;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(LabelValu";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 84;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 86;BA.debugLine="LabelTitle.SetLayoutAnimated (0, pad, pad,";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 87;BA.debugLine="LabelValue.SetLayoutAnimated (0, pad, Height * 0.";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(int) (_height*0.25),(int) (_width-_pad*2),(int) (_height*0.60));
 //BA.debugLineNum = 88;BA.debugLine="LabelUnit.SetLayoutAnimated  (0, pad, Height * 0.";
_labelunit.SetLayoutAnimated((int) (0),_pad,(int) (_height*0.80),(int) (_width-_pad*2),(int) (_height*0.15));
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 27;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 28;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 31;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 36;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 37;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 43;BA.debugLine="Private mValue As String";
_mvalue = "";
 //BA.debugLineNum = 44;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 45;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 48;BA.debugLine="Private mEnabled As Boolean = True";
_menabled = __c.True;
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 57;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 58;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 59;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 60;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 62;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 124;BA.debugLine="Return mEnabled";
if (true) return _menabled;
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 150;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 98;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 115;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public String  _getvalue() throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Public Sub getValue As String";
 //BA.debugLineNum = 107;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 51;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 52;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 53;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _labelvalue_click() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Private Sub LabelValue_Click";
 //BA.debugLineNum = 215;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 216;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 119;BA.debugLine="mEnabled = enabled";
_menabled = _enabled;
 //BA.debugLineNum = 120;BA.debugLine="mBase.Enabled = mEnabled";
_mbase.setEnabled(_menabled);
 //BA.debugLineNum = 121;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mEnabled)";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (ba,_menabled));
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 146;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 94;BA.debugLine="mTitle = text";
_mtitle = _text;
 //BA.debugLineNum = 95;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _text) throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Public Sub setUnit(text As String)";
 //BA.debugLineNum = 111;BA.debugLine="mUnit = text";
_munit = _text;
 //BA.debugLineNum = 112;BA.debugLine="LabelUnit.Text = mUnit";
_labelunit.setText(BA.ObjectToCharSequence(_munit));
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(String _value) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Public Sub setValue(value As String)";
 //BA.debugLineNum = 103;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 104;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(BA.ObjectToCharSequence(_mvalue));
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 137;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 141;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 129;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 133;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
