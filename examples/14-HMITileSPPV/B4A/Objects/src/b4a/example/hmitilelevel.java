package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitilelevel extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitilelevel");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitilelevel.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panebar = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panefill = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public String _mtitle = "";
public float _mvalue = 0f;
public String _munit = "";
public String _mstatus = "";
public int _mdigits = 0;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 67;BA.debugLine="mBase.LoadLayout(\"hmitilelevel\")";
_mbase.LoadLayout("hmitilelevel",ba);
 //BA.debugLineNum = 70;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 71;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 72;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 73;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(BA.ObjectToCharSequence(_mvalue));
 //BA.debugLineNum = 74;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 75;BA.debugLine="mStatus			= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 77;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 79;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 207;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 208;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 210;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 211;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (ba,_labelvalue);
 //BA.debugLineNum = 213;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 215;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 216;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 217;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 220;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 221;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 222;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 225;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 226;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 227;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 230;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 231;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 232;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 235;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 238;BA.debugLine="PaneBar.SetColorAndBorder( _         HMITileUtils";
_panebar.SetColorAndBorder(_hmitileutils._color_slider_track /*int*/ ,__c.DipToCurrent((int) (0)),_hmitileutils._color_slider_track /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 245;BA.debugLine="PaneFill.SetColorAndBorder( _         HMITileUtil";
_panefill.SetColorAndBorder(_hmitileutils._color_slider_active /*int*/ ,__c.DipToCurrent((int) (0)),_hmitileutils._color_slider_active /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 82;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 83;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 85;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 87;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad, pad, Width -";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 89;BA.debugLine="UpdateLevel";
_updatelevel();
 //BA.debugLineNum = 91;BA.debugLine="LabelValue.SetLayoutAnimated(0, pad, (Height*0.75";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(int) ((_height*0.75)-_pad),(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 29;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 31;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 35;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 38;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private PaneBar As B4XView";
_panebar = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private PaneFill As B4XView";
_panefill = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 45;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 46;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 47;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 50;BA.debugLine="Private mDigits As Int = 0";
_mdigits = (int) (0);
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 278;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 279;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 280;BA.debugLine="CallSub2(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew2(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue));
 };
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 59;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 60;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 61;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 62;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 63;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 168;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 195;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 140;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 160;BA.debugLine="Return LabelValue.Text";
if (true) return _labelvalue.getText();
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 152;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 53;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 54;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 55;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _panebar_click() throws Exception{
 //BA.debugLineNum = 265;BA.debugLine="Private Sub PaneBar_Click";
 //BA.debugLineNum = 266;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return "";
}
public String  _panefill_click() throws Exception{
 //BA.debugLineNum = 269;BA.debugLine="Private Sub PaneFill_Click";
 //BA.debugLineNum = 270;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 164;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 165;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (ba,_mbase.getEnabled()));
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 190;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 191;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 137;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 156;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 157;BA.debugLine="LabelValue.Text = $\"${mValue}${IIf(mUnit.Length >";
_labelvalue.setText(BA.ObjectToCharSequence((""+__c.SmartStringFormatter("",(Object)(_mvalue))+""+__c.SmartStringFormatter("",((_munit.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munit))+""))) : ((Object)(""))))+"")));
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 145;BA.debugLine="If LabelValue.IsInitialized Then";
if (_labelvalue.IsInitialized()) { 
 //BA.debugLineNum = 146;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 147;BA.debugLine="UpdateLevel";
_updatelevel();
 //BA.debugLineNum = 148;BA.debugLine="LabelValue.Text = $\"${NumberFormat(mValue, 1, mD";
_labelvalue.setText(BA.ObjectToCharSequence((""+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(_mvalue,(int) (1),_mdigits)))+""+__c.SmartStringFormatter("",((_munit.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munit))+""))) : ((Object)(""))))+"")));
 };
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 181;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 185;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 173;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 177;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public String  _updatelevel() throws Exception{
int _l = 0;
int _t = 0;
int _w = 0;
int _h = 0;
float _pct = 0f;
int _fillheight = 0;
 //BA.debugLineNum = 95;BA.debugLine="Private Sub UpdateLevel";
 //BA.debugLineNum = 96;BA.debugLine="If Not(PaneFill.IsInitialized) Then";
if (__c.Not(_panefill.IsInitialized())) { 
 //BA.debugLineNum = 97;BA.debugLine="Log($\"[HMITileLevel.UpdateLevel] PaneFill not in";
__c.LogImpl("946661634",("[HMITileLevel.UpdateLevel] PaneFill not initialized."),0);
 //BA.debugLineNum = 98;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 101;BA.debugLine="Dim l As Int	= mBase.width / 4";
_l = (int) (_mbase.getWidth()/(double)4);
 //BA.debugLineNum = 102;BA.debugLine="Dim t As Int	= LabelTitle.Top + LabelTitle.Height";
_t = (int) (_labeltitle.getTop()+_labeltitle.getHeight());
 //BA.debugLineNum = 103;BA.debugLine="Dim w As Int	= mBase.width / 2";
_w = (int) (_mbase.getWidth()/(double)2);
 //BA.debugLineNum = 104;BA.debugLine="Dim h As Int	= (mBase.height * 0.50) - HMITileUti";
_h = (int) ((_mbase.getHeight()*0.50)-_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 106;BA.debugLine="Dim pct As Float = 0";
_pct = (float) (0);
 //BA.debugLineNum = 107;BA.debugLine="If mValue < 0 Then";
if (_mvalue<0) { 
 //BA.debugLineNum = 108;BA.debugLine="mValue = 0";
_mvalue = (float) (0);
 };
 //BA.debugLineNum = 110;BA.debugLine="If mValue > 0 Then";
if (_mvalue>0) { 
 //BA.debugLineNum = 111;BA.debugLine="pct = mValue / 100";
_pct = (float) (_mvalue/(double)100);
 };
 //BA.debugLineNum = 113;BA.debugLine="Dim fillheight As Int = (h * pct)";
_fillheight = (int) ((_h*_pct));
 //BA.debugLineNum = 116;BA.debugLine="l 	= l ' + pad";
_l = _l;
 //BA.debugLineNum = 117;BA.debugLine="t 	= t + (h - fillheight)";
_t = (int) (_t+(_h-_fillheight));
 //BA.debugLineNum = 118;BA.debugLine="w 	= w ' - pad * 2";
_w = _w;
 //BA.debugLineNum = 119;BA.debugLine="h 	= IIf(fillheight > 0, fillheight, 0)";
_h = (int)(BA.ObjectToNumber(((_fillheight>0) ? ((Object)(_fillheight)) : ((Object)(0)))));
 //BA.debugLineNum = 120;BA.debugLine="PaneFill.SetLayoutAnimated(0, l, t, w, h)";
_panefill.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 124;BA.debugLine="l	= l";
_l = _l;
 //BA.debugLineNum = 125;BA.debugLine="t	= LabelTitle.Top + LabelTitle.Height";
_t = (int) (_labeltitle.getTop()+_labeltitle.getHeight());
 //BA.debugLineNum = 126;BA.debugLine="w	= w";
_w = _w;
 //BA.debugLineNum = 127;BA.debugLine="h	= (mBase.height * 0.50) - h";
_h = (int) ((_mbase.getHeight()*0.50)-_h);
 //BA.debugLineNum = 128;BA.debugLine="PaneBar.SetLayoutAnimated(0, l, t, w, h)";
_panebar.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
