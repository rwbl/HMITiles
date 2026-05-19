package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitilegauge extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitilegauge");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitilegauge.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _panegauge = null;
public anywheresoftware.b4a.objects.B4XCanvas _cvsgauge = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public String _mtitle = "";
public float _mvalue = 0f;
public float _mmin = 0f;
public float _mmax = 0f;
public String _munittext = "";
public int _mdigits = 0;
public String _mstatus = "";
public float _cx = 0f;
public float _cy = 0f;
public float _radius = 0f;
public int _maskcolor = 0;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 84;BA.debugLine="mBase.LoadLayout(\"hmitilegauge\")";
_mbase.LoadLayout("hmitilegauge",ba);
 //BA.debugLineNum = 87;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 88;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 89;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 90;BA.debugLine="mMin			= Props.GetDefault(\"Min\", 0)";
_mmin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Min"),(Object)(0))));
 //BA.debugLineNum = 91;BA.debugLine="mMax			= Props.GetDefault(\"Max\", 100)";
_mmax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Max"),(Object)(100))));
 //BA.debugLineNum = 92;BA.debugLine="mUnitText		= Props.Get(\"Unit\")";
_munittext = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 93;BA.debugLine="mDigits			= Props.GetDefault(\"Digits\", 0)";
_mdigits = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("Digits"),(Object)(0))));
 //BA.debugLineNum = 94;BA.debugLine="mStatus			= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 97;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 100;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 260;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 262;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 263;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (ba,_labelvalue);
 //BA.debugLineNum = 265;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 267;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 268;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 269;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 272;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 273;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 274;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 277;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 278;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 279;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 282;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 283;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 284;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 288;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 291;BA.debugLine="MaskColor = mBase.Color";
_maskcolor = _mbase.getColor();
 //BA.debugLineNum = 292;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 103;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 104;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 106;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 108;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad, pad, Width -";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 110;BA.debugLine="PaneGauge.SetLayoutAnimated(0, pad, Height * 0.25";
_panegauge.SetLayoutAnimated((int) (0),_pad,(int) (_height*0.25),(int) (_width-_pad*2),(int) (_height*0.5));
 //BA.debugLineNum = 111;BA.debugLine="Cx 			= PaneGauge.Width / 2";
_cx = (float) (_panegauge.getWidth()/(double)2);
 //BA.debugLineNum = 112;BA.debugLine="Cy 			= PaneGauge.Height * 0.9";
_cy = (float) (_panegauge.getHeight()*0.9);
 //BA.debugLineNum = 113;BA.debugLine="Radius		= Min(Cx, Cy) * 0.8";
_radius = (float) (__c.Min(_cx,_cy)*0.8);
 //BA.debugLineNum = 116;BA.debugLine="CvsGauge.Initialize(PaneGauge)";
_cvsgauge.Initialize(_panegauge);
 //BA.debugLineNum = 118;BA.debugLine="LabelValue.SetLayoutAnimated(0, pad, (Height*0.75";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(int) ((_height*0.75)-_pad),(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 120;BA.debugLine="setValue(mValue)";
_setvalue(_mvalue);
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 38;BA.debugLine="Private mEventName As String			'ignore";
_meventname = "";
 //BA.debugLineNum = 39;BA.debugLine="Private mCallBack As Object				'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 42;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private mLbl As B4XView					'ignore";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 47;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 48;BA.debugLine="Private PaneGauge As B4XView";
_panegauge = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private CvsGauge As B4XCanvas";
_cvsgauge = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 52;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 57;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 58;BA.debugLine="Private mMin As Float";
_mmin = 0f;
 //BA.debugLineNum = 59;BA.debugLine="Private mMax As Float";
_mmax = 0f;
 //BA.debugLineNum = 60;BA.debugLine="Private mUnitText As String";
_munittext = "";
 //BA.debugLineNum = 61;BA.debugLine="Private mDigits As Int";
_mdigits = 0;
 //BA.debugLineNum = 62;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 65;BA.debugLine="Private Cx, Cy As Float";
_cx = 0f;
_cy = 0f;
 //BA.debugLineNum = 66;BA.debugLine="Private Radius As Float";
_radius = 0f;
 //BA.debugLineNum = 67;BA.debugLine="Private MaskColor As Int";
_maskcolor = 0;
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 312;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 313;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 314;BA.debugLine="CallSub2(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew2(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue));
 };
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 76;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 77;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 78;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 79;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 80;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public String  _drawgauge(float _value) throws Exception{
float _startangle = 0f;
float _totalsweep = 0f;
float _sweeplength = 0f;
int _gaugewidth = 0;
boolean _filled = false;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _track = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _valuearc = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _maskarc = null;
 //BA.debugLineNum = 145;BA.debugLine="Public Sub DrawGauge(value As Float)";
 //BA.debugLineNum = 147;BA.debugLine="Dim startAngle As Float = 180	' Always start at 0";
_startangle = (float) (180);
 //BA.debugLineNum = 148;BA.debugLine="Dim totalSweep As Float = 180	' Max span from 09:";
_totalsweep = (float) (180);
 //BA.debugLineNum = 149;BA.debugLine="Dim sweepLength As Float		' How many degrees to d";
_sweeplength = 0f;
 //BA.debugLineNum = 150;BA.debugLine="Dim gaugeWidth As Int = 14dip";
_gaugewidth = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 151;BA.debugLine="Dim filled As Boolean = True";
_filled = __c.True;
 //BA.debugLineNum = 154;BA.debugLine="value = Max(mMin, Min(mMax, value))";
_value = (float) (__c.Max(_mmin,__c.Min(_mmax,_value)));
 //BA.debugLineNum = 157;BA.debugLine="CvsGauge.ClearRect(CvsGauge.TargetRect)";
_cvsgauge.ClearRect(_cvsgauge.getTargetRect());
 //BA.debugLineNum = 163;BA.debugLine="Dim track As B4XPath";
_track = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 164;BA.debugLine="track.InitializeArc(Cx, Cy, Radius, startAngle, t";
_track.InitializeArc(_cx,_cy,_radius,_startangle,_totalsweep);
 //BA.debugLineNum = 165;BA.debugLine="CvsGauge.DrawPath(track, HMITileUtils.COLOR_SLIDE";
_cvsgauge.DrawPath(_track,_hmitileutils._color_slider_track /*int*/ ,_filled,(float) (0));
 //BA.debugLineNum = 171;BA.debugLine="sweepLength = totalSweep * (value - mMin) / (mMax";
_sweeplength = (float) (_totalsweep*(_value-_mmin)/(double)(_mmax-_mmin));
 //BA.debugLineNum = 172;BA.debugLine="Dim valueArc As B4XPath";
_valuearc = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 173;BA.debugLine="valueArc.InitializeArc(Cx, Cy, Radius, startAngle";
_valuearc.InitializeArc(_cx,_cy,_radius,_startangle,_sweeplength);
 //BA.debugLineNum = 174;BA.debugLine="CvsGauge.DrawPath(valueArc, HMITileUtils.COLOR_SL";
_cvsgauge.DrawPath(_valuearc,_hmitileutils._color_slider_active /*int*/ ,_filled,(float) (0));
 //BA.debugLineNum = 179;BA.debugLine="Dim maskArc As B4XPath";
_maskarc = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 180;BA.debugLine="maskArc.InitializeArc(Cx, Cy, Radius - gaugeWidth";
_maskarc.InitializeArc(_cx,_cy,(float) (_radius-_gaugewidth),_startangle,_totalsweep);
 //BA.debugLineNum = 181;BA.debugLine="CvsGauge.DrawPath(maskArc, MaskColor, filled, 0)";
_cvsgauge.DrawPath(_maskarc,_maskcolor,_filled,(float) (0));
 //BA.debugLineNum = 188;BA.debugLine="CvsGauge.Invalidate";
_cvsgauge.Invalidate();
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 221;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 222;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 247;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 195;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 214;BA.debugLine="Return LabelValue.Text";
if (true) return _labelvalue.getText();
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 206;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 70;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 71;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 72;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _panegauge_click() throws Exception{
 //BA.debugLineNum = 307;BA.debugLine="Private Sub PaneGauge_Click";
 //BA.debugLineNum = 308;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return "";
}
public String  _redraw() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Private Sub Redraw";
 //BA.debugLineNum = 130;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 131;BA.debugLine="DrawGauge(mValue)";
_drawgauge(_mvalue);
 };
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 217;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 218;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 219;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (ba,_mbase.getEnabled()));
 //BA.debugLineNum = 220;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 243;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 244;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 191;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 192;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 210;BA.debugLine="mUnitText = unit";
_munittext = _unit;
 //BA.debugLineNum = 211;BA.debugLine="LabelValue.Text = $\"${mValue}${IIf(mUnitText.Leng";
_labelvalue.setText(BA.ObjectToCharSequence((""+__c.SmartStringFormatter("",(Object)(_mvalue))+""+__c.SmartStringFormatter("",((_munittext.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munittext))+""))) : ((Object)(""))))+"")));
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 198;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 199;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 200;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 201;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 202;BA.debugLine="LabelValue.Text = $\"${NumberFormat(mValue, 1, mD";
_labelvalue.setText(BA.ObjectToCharSequence((""+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(_mvalue,(int) (1),_mdigits)))+""+__c.SmartStringFormatter("",((_munittext.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munittext))+""))) : ((Object)(""))))+"")));
 };
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 234;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 235;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 236;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 239;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 227;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 231;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
