package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilereadout extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.hmitilereadout", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.hmitilereadout.class).invoke(this, new Object[] {null});
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
public String _mtypestyle = "";
public boolean _mstate = false;
public String _mvalue = "";
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 66;BA.debugLine="mBase.LoadLayout(\"hmitilereadout\")";
_mbase.LoadLayout("hmitilereadout",ba);
 //BA.debugLineNum = 68;BA.debugLine="LabelTitle.Text = Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 69;BA.debugLine="LabelValue.Text = Props.Get(\"Value\")";
_labelvalue.setText(BA.ObjectToString(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 70;BA.debugLine="LabelUnit.Text 	= Props.Get(\"Unit\")";
_labelunit.setText(BA.ObjectToString(_props.Get((Object)("Unit"))));
 //BA.debugLineNum = 71;BA.debugLine="mTypeStyle		= Props.Get(\"TypeStyle\")";
_mtypestyle = BA.ObjectToString(_props.Get((Object)("TypeStyle")));
 //BA.debugLineNum = 73;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 75;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _tilestate) throws Exception{
int _state = 0;
 //BA.debugLineNum = 164;BA.debugLine="Public Sub ApplyStyle(tilestate As String)";
 //BA.debugLineNum = 165;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 166;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 167;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 169;BA.debugLine="Dim state As Int = HMITileUtils.StateStyleToState";
_state = _hmitileutils._statestyletostate /*int*/ (_tilestate);
 //BA.debugLineNum = 170;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 172;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 173;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 176;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 177;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 180;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 181;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 184;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 185;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 188;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 78;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 79;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(LabelValu";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 81;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 83;BA.debugLine="LabelTitle.SetLayoutAnimated (0, pad, pad,";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 84;BA.debugLine="LabelValue.SetLayoutAnimated (0, pad, Height * 0.";
_labelvalue.SetLayoutAnimated((int) (0),_pad,_height*0.25,_width-_pad*2,_height*0.60);
 //BA.debugLineNum = 85;BA.debugLine="LabelUnit.SetLayoutAnimated  (0, pad, Height * 0.";
_labelunit.SetLayoutAnimated((int) (0),_pad,_height*0.80,_width-_pad*2,_height*0.15);
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 29;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 30;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 33;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 38;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 39;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private mTypeStyle As String";
_mtypestyle = "";
 //BA.debugLineNum = 47;BA.debugLine="Private mState As Boolean = False";
_mstate = __c.False;
 //BA.debugLineNum = 48;BA.debugLine="Private mValue As String";
_mvalue = "";
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
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
 //BA.debugLineNum = 121;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 122;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return false;
}
public boolean  _getstate() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Public Sub getState As Boolean";
 //BA.debugLineNum = 130;BA.debugLine="Return mState";
if (true) return _mstate;
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 94;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public String  _gettypestyle() throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Public Sub getTypeStyle As String";
 //BA.debugLineNum = 153;BA.debugLine="Return mTypeStyle";
if (true) return _mtypestyle;
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 114;BA.debugLine="Return LabelUnit.Text";
if (true) return _labelunit.getText();
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 206;BA.debugLine="Private Sub LabelValue_Click";
 //BA.debugLineNum = 207;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 208;BA.debugLine="CallSub(mCallBack, mEventName & \"_Click\")";
__c.CallSubNew(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public String  _labelvalue_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Private Sub LabelValue_MouseClicked (EventData As";
 //BA.debugLineNum = 195;BA.debugLine="LabelValue_Click";
_labelvalue_click();
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return "";
}
public String  _setalarm(String _text) throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Public Sub SetAlarm(text As String)";
 //BA.debugLineNum = 144;BA.debugLine="setState(text)";
_setstate(BA.ObjectToBoolean(_text));
 //BA.debugLineNum = 145;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)";
_settypestyle(_hmitileutils._typestyle_alarm /*String*/ );
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 118;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 119;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (_mbase.getEnabled()));
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public String  _setinfo(String _text) throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Public Sub SetInfo(text As String)";
 //BA.debugLineNum = 134;BA.debugLine="setState(text)";
_setstate(BA.ObjectToBoolean(_text));
 //BA.debugLineNum = 135;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)";
_settypestyle(_hmitileutils._typestyle_normal /*String*/ );
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public String  _setstate(boolean _state) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Public Sub setState(state As Boolean)";
 //BA.debugLineNum = 126;BA.debugLine="mState = state";
_mstate = _state;
 //BA.debugLineNum = 127;BA.debugLine="HMITileUtils.ApplyStyleStateOnOff(mBase, LabelVal";
_hmitileutils._applystylestateonoff /*String*/ (_mbase,_labelvalue,_state);
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 91;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public String  _settypestyle(String _value) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub setTypeStyle(value As String)";
 //BA.debugLineNum = 149;BA.debugLine="mTypeStyle = value";
_mtypestyle = _value;
 //BA.debugLineNum = 150;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _text) throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Public Sub setUnit(text As String)";
 //BA.debugLineNum = 111;BA.debugLine="LabelUnit.Text = text";
_labelunit.setText(_text);
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(String _value) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Public Sub setValue(value As String)";
 //BA.debugLineNum = 99;BA.debugLine="Try";
try { //BA.debugLineNum = 100;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 101;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(_mvalue);
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 103;BA.debugLine="Log($\"[HMITileReadOut.setValue][E] ${LastExcepti";
__c.LogImpl("926279941",("[HMITileReadOut.setValue][E] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public String  _setwarning(String _text) throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Public Sub SetWarning(text As String)";
 //BA.debugLineNum = 139;BA.debugLine="setState(text)";
_setstate(BA.ObjectToBoolean(_text));
 //BA.debugLineNum = 140;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)";
_settypestyle(_hmitileutils._typestyle_warning /*String*/ );
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
