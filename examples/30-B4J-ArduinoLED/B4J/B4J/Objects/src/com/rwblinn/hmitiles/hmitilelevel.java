package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilelevel extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.hmitilelevel", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.hmitilelevel.class).invoke(this, new Object[] {null});
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
public float _mvalue = 0f;
public String _munittext = "";
public String _mtypestyle = "";
public int _mdigits = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 65;BA.debugLine="mBase.LoadLayout(\"hmitilelevel\")";
_mbase.LoadLayout("hmitilelevel",ba);
 //BA.debugLineNum = 68;BA.debugLine="LabelTitle.Text = Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 69;BA.debugLine="LabelValue.Text = Props.Get(\"Value\")";
_labelvalue.setText(BA.ObjectToString(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 70;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 71;BA.debugLine="mUnitText		= Props.Get(\"Unit\")";
_munittext = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 72;BA.debugLine="mTypeStyle		= Props.Get(\"TypeStyle\")";
_mtypestyle = BA.ObjectToString(_props.Get((Object)("TypeStyle")));
 //BA.debugLineNum = 74;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 75;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _tilestate) throws Exception{
int _state = 0;
 //BA.debugLineNum = 195;BA.debugLine="Public Sub ApplyStyle(tilestate As String)";
 //BA.debugLineNum = 197;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 198;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 200;BA.debugLine="Dim state As Int = HMITileUtils.StateStyleToState";
_state = _hmitileutils._statestyletostate /*int*/ (_tilestate);
 //BA.debugLineNum = 201;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 203;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 204;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 205;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 208;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 209;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 210;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 213;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 214;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 215;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 218;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 219;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 220;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 223;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 226;BA.debugLine="PaneBar.SetColorAndBorder( _         HMITileUtils";
_panebar.SetColorAndBorder(_hmitileutils._color_slider_track /*int*/ ,__c.DipToCurrent((int) (0)),_hmitileutils._color_slider_track /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 233;BA.debugLine="PaneFill.SetColorAndBorder( _         HMITileUtil";
_panefill.SetColorAndBorder(_hmitileutils._color_slider_active /*int*/ ,__c.DipToCurrent((int) (0)),_hmitileutils._color_slider_active /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 78;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 79;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 81;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 83;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad, pad, Width -";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 85;BA.debugLine="UpdateLevel";
_updatelevel();
 //BA.debugLineNum = 87;BA.debugLine="LabelValue.SetLayoutAnimated(0, pad, (Height*0.75";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(_height*0.75)-_pad,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 44;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 45;BA.debugLine="Private mUnitText As String";
_munittext = "";
 //BA.debugLineNum = 46;BA.debugLine="Private mTypeStyle As String";
_mtypestyle = "";
 //BA.debugLineNum = 48;BA.debugLine="Private mDigits As Int = 0";
_mdigits = (int) (0);
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 267;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 268;BA.debugLine="CallSub2(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew2(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue));
 };
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 57;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 58;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 59;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 60;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 61;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 164;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 136;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _gettypestyle() throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Public Sub getTypeStyle As String";
 //BA.debugLineNum = 184;BA.debugLine="Return mTypeStyle";
if (true) return _mtypestyle;
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 156;BA.debugLine="Return LabelValue.Text";
if (true) return _labelvalue.getText();
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 147;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 148;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 51;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 52;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 53;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _panebar_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 243;BA.debugLine="Private Sub PaneBar_MouseClicked (EventData As Mou";
 //BA.debugLineNum = 244;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public String  _panefill_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 247;BA.debugLine="Private Sub PaneFill_MouseClicked (EventData As Mo";
 //BA.debugLineNum = 248;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 160;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 161;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (_mbase.getEnabled()));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public String  _setstylealarm() throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Public Sub SetStyleAlarm";
 //BA.debugLineNum = 176;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)";
_settypestyle(_hmitileutils._typestyle_alarm /*String*/ );
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public String  _setstylenormal() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub SetStyleNormal";
 //BA.debugLineNum = 168;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)";
_settypestyle(_hmitileutils._typestyle_normal /*String*/ );
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public String  _setstylewarning() throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Public Sub SetStyleWarning";
 //BA.debugLineNum = 172;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)";
_settypestyle(_hmitileutils._typestyle_warning /*String*/ );
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 133;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public String  _settypestyle(String _value) throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Public Sub setTypeStyle(value As String)";
 //BA.debugLineNum = 180;BA.debugLine="mTypeStyle = value";
_mtypestyle = _value;
 //BA.debugLineNum = 181;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 152;BA.debugLine="mUnitText = unit";
_munittext = _unit;
 //BA.debugLineNum = 153;BA.debugLine="LabelValue.Text = $\"${mValue}${IIf(mUnitText.Leng";
_labelvalue.setText((""+__c.SmartStringFormatter("",(Object)(_mvalue))+""+__c.SmartStringFormatter("",((_munittext.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munittext))+""))) : ((Object)(""))))+""));
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 141;BA.debugLine="If LabelValue.IsInitialized Then";
if (_labelvalue.IsInitialized()) { 
 //BA.debugLineNum = 142;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 143;BA.debugLine="UpdateLevel";
_updatelevel();
 //BA.debugLineNum = 144;BA.debugLine="LabelValue.Text = $\"${NumberFormat(mValue, 1, mD";
_labelvalue.setText((""+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(_mvalue,(int) (1),_mdigits)))+""+__c.SmartStringFormatter("",((_munittext.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munittext))+""))) : ((Object)(""))))+""));
 };
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public String  _updatelevel() throws Exception{
int _l = 0;
int _t = 0;
int _w = 0;
int _h = 0;
float _pct = 0f;
int _fillheight = 0;
 //BA.debugLineNum = 91;BA.debugLine="Private Sub UpdateLevel";
 //BA.debugLineNum = 92;BA.debugLine="If Not(PaneFill.IsInitialized) Then";
if (__c.Not(_panefill.IsInitialized())) { 
 //BA.debugLineNum = 93;BA.debugLine="Log($\"[HMITileLevel.UpdateLevel] PaneFill not in";
__c.LogImpl("923265282",("[HMITileLevel.UpdateLevel] PaneFill not initialized."),0);
 //BA.debugLineNum = 94;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 97;BA.debugLine="Dim l As Int	= mBase.width / 4";
_l = (int) (_mbase.getWidth()/(double)4);
 //BA.debugLineNum = 98;BA.debugLine="Dim t As Int	= LabelTitle.Top + LabelTitle.Height";
_t = (int) (_labeltitle.getTop()+_labeltitle.getHeight());
 //BA.debugLineNum = 99;BA.debugLine="Dim w As Int	= mBase.width / 2";
_w = (int) (_mbase.getWidth()/(double)2);
 //BA.debugLineNum = 100;BA.debugLine="Dim h As Int	= (mBase.height * 0.50) - HMITileUti";
_h = (int) ((_mbase.getHeight()*0.50)-_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 102;BA.debugLine="Dim pct As Float = 0";
_pct = (float) (0);
 //BA.debugLineNum = 103;BA.debugLine="If mValue < 0 Then";
if (_mvalue<0) { 
 //BA.debugLineNum = 104;BA.debugLine="mValue = 0";
_mvalue = (float) (0);
 };
 //BA.debugLineNum = 106;BA.debugLine="If mValue > 0 Then";
if (_mvalue>0) { 
 //BA.debugLineNum = 107;BA.debugLine="pct = mValue / 100";
_pct = (float) (_mvalue/(double)100);
 };
 //BA.debugLineNum = 109;BA.debugLine="Dim fillheight As Int = (h * pct)";
_fillheight = (int) ((_h*_pct));
 //BA.debugLineNum = 112;BA.debugLine="l 	= l ' + pad";
_l = _l;
 //BA.debugLineNum = 113;BA.debugLine="t 	= t + (h - fillheight)";
_t = (int) (_t+(_h-_fillheight));
 //BA.debugLineNum = 114;BA.debugLine="w 	= w ' - pad * 2";
_w = _w;
 //BA.debugLineNum = 115;BA.debugLine="h 	= IIf(fillheight > 0, fillheight, 0)";
_h = (int)(BA.ObjectToNumber(((_fillheight>0) ? ((Object)(_fillheight)) : ((Object)(0)))));
 //BA.debugLineNum = 116;BA.debugLine="PaneFill.SetLayoutAnimated(0, l, t, w, h)";
_panefill.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 120;BA.debugLine="l	= l";
_l = _l;
 //BA.debugLineNum = 121;BA.debugLine="t	= LabelTitle.Top + LabelTitle.Height";
_t = (int) (_labeltitle.getTop()+_labeltitle.getHeight());
 //BA.debugLineNum = 122;BA.debugLine="w	= w";
_w = _w;
 //BA.debugLineNum = 123;BA.debugLine="h	= (mBase.height * 0.50) - h";
_h = (int) ((_mbase.getHeight()*0.50)-_h);
 //BA.debugLineNum = 124;BA.debugLine="PaneBar.SetLayoutAnimated(0, l, t, w, h)";
_panebar.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
