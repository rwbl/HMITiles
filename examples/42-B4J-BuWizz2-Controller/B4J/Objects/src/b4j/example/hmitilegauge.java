package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilegauge extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilegauge", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilegauge.class).invoke(this, new Object[] {null});
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
public float _mvalue = 0f;
public int _mdigits = 0;
public float _mmin = 0f;
public float _mmax = 0f;
public String _munittext = "";
public String _mtypestyle = "";
public float _cx = 0f;
public float _cy = 0f;
public float _radius = 0f;
public int _maskcolor = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 83;BA.debugLine="mBase.LoadLayout(\"hmitilegauge\")";
_mbase.LoadLayout("hmitilegauge",ba);
 //BA.debugLineNum = 86;BA.debugLine="LabelTitle.Text = Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 87;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 88;BA.debugLine="mMin			= Props.GetDefault(\"Min\", 0)";
_mmin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Min"),(Object)(0))));
 //BA.debugLineNum = 89;BA.debugLine="mMax			= Props.GetDefault(\"Max\", 100)";
_mmax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Max"),(Object)(100))));
 //BA.debugLineNum = 90;BA.debugLine="mUnitText		= Props.Get(\"Unit\")";
_munittext = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 91;BA.debugLine="mDigits			= Props.GetDefault(\"Digits\", 0)";
_mdigits = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("Digits"),(Object)(0))));
 //BA.debugLineNum = 92;BA.debugLine="mTypeStyle		= Props.Get(\"TypeStyle\")";
_mtypestyle = BA.ObjectToString(_props.Get((Object)("TypeStyle")));
 //BA.debugLineNum = 95;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 97;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _tilestate) throws Exception{
int _state = 0;
 //BA.debugLineNum = 250;BA.debugLine="Public Sub ApplyStyle(tilestate As String)";
 //BA.debugLineNum = 251;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 252;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 254;BA.debugLine="Dim state As Int = HMITileUtils.StateStyleToState";
_state = _hmitileutils._statestyletostate /*int*/ (_tilestate);
 //BA.debugLineNum = 255;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 257;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 258;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 259;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 262;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 263;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 264;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 267;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 268;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 269;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 272;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 273;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 274;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 278;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 281;BA.debugLine="MaskColor = mBase.Color";
_maskcolor = _mbase.getColor();
 //BA.debugLineNum = 282;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 100;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 101;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 103;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 105;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad, pad, Width -";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 107;BA.debugLine="PaneGauge.SetLayoutAnimated(0, pad, Height * 0.25";
_panegauge.SetLayoutAnimated((int) (0),_pad,_height*0.25,_width-_pad*2,_height*0.5);
 //BA.debugLineNum = 108;BA.debugLine="Cx 			= PaneGauge.Width / 2";
_cx = (float) (_panegauge.getWidth()/(double)2);
 //BA.debugLineNum = 109;BA.debugLine="Cy 			= PaneGauge.Height * 0.9";
_cy = (float) (_panegauge.getHeight()*0.9);
 //BA.debugLineNum = 110;BA.debugLine="Radius		= Min(Cx, Cy) * 0.8";
_radius = (float) (__c.Min(_cx,_cy)*0.8);
 //BA.debugLineNum = 113;BA.debugLine="CvsGauge.Initialize(PaneGauge)";
_cvsgauge.Initialize(ba,_panegauge);
 //BA.debugLineNum = 115;BA.debugLine="LabelValue.SetLayoutAnimated(0, pad, (Height*0.75";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(_height*0.75)-_pad,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 117;BA.debugLine="setValue(mValue)";
_setvalue(_mvalue);
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 56;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 57;BA.debugLine="Private mDigits As Int";
_mdigits = 0;
 //BA.debugLineNum = 58;BA.debugLine="Private mMin As Float";
_mmin = 0f;
 //BA.debugLineNum = 59;BA.debugLine="Private mMax As Float";
_mmax = 0f;
 //BA.debugLineNum = 60;BA.debugLine="Private mUnitText As String";
_munittext = "";
 //BA.debugLineNum = 61;BA.debugLine="Private mTypeStyle As String";
_mtypestyle = "";
 //BA.debugLineNum = 64;BA.debugLine="Private Cx, Cy As Float";
_cx = 0f;
_cy = 0f;
 //BA.debugLineNum = 65;BA.debugLine="Private Radius As Float";
_radius = 0f;
 //BA.debugLineNum = 66;BA.debugLine="Private MaskColor As Int";
_maskcolor = 0;
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 75;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 76;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 77;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 78;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 79;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 142;BA.debugLine="Public Sub DrawGauge(value As Float)";
 //BA.debugLineNum = 144;BA.debugLine="Dim startAngle As Float = 180	' Always start at 0";
_startangle = (float) (180);
 //BA.debugLineNum = 145;BA.debugLine="Dim totalSweep As Float = 180	' Max span from 09:";
_totalsweep = (float) (180);
 //BA.debugLineNum = 146;BA.debugLine="Dim sweepLength As Float		' How many degrees to d";
_sweeplength = 0f;
 //BA.debugLineNum = 147;BA.debugLine="Dim gaugeWidth As Int = 14dip";
_gaugewidth = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 148;BA.debugLine="Dim filled As Boolean = True";
_filled = __c.True;
 //BA.debugLineNum = 151;BA.debugLine="value = Max(mMin, Min(mMax, value))";
_value = (float) (__c.Max(_mmin,__c.Min(_mmax,_value)));
 //BA.debugLineNum = 154;BA.debugLine="CvsGauge.ClearRect(CvsGauge.TargetRect)";
_cvsgauge.ClearRect(_cvsgauge.getTargetRect());
 //BA.debugLineNum = 160;BA.debugLine="Dim track As B4XPath";
_track = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 161;BA.debugLine="track.InitializeArc(Cx, Cy, Radius, startAngle, t";
_track.InitializeArc(_cx,_cy,_radius,_startangle,_totalsweep);
 //BA.debugLineNum = 162;BA.debugLine="CvsGauge.DrawPath(track, HMITileUtils.COLOR_SLIDE";
_cvsgauge.DrawPath(_track,_hmitileutils._color_slider_track /*int*/ ,_filled,(float) (0));
 //BA.debugLineNum = 168;BA.debugLine="sweepLength = totalSweep * (value - mMin) / (mMax";
_sweeplength = (float) (_totalsweep*(_value-_mmin)/(double)(_mmax-_mmin));
 //BA.debugLineNum = 169;BA.debugLine="Dim valueArc As B4XPath";
_valuearc = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 170;BA.debugLine="valueArc.InitializeArc(Cx, Cy, Radius, startAngle";
_valuearc.InitializeArc(_cx,_cy,_radius,_startangle,_sweeplength);
 //BA.debugLineNum = 171;BA.debugLine="CvsGauge.DrawPath(valueArc, HMITileUtils.COLOR_SL";
_cvsgauge.DrawPath(_valuearc,_hmitileutils._color_slider_active /*int*/ ,_filled,(float) (0));
 //BA.debugLineNum = 176;BA.debugLine="Dim maskArc As B4XPath";
_maskarc = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 177;BA.debugLine="maskArc.InitializeArc(Cx, Cy, Radius - gaugeWidth";
_maskarc.InitializeArc(_cx,_cy,(float) (_radius-_gaugewidth),_startangle,_totalsweep);
 //BA.debugLineNum = 178;BA.debugLine="CvsGauge.DrawPath(maskArc, MaskColor, filled, 0)";
_cvsgauge.DrawPath(_maskarc,_maskcolor,_filled,(float) (0));
 //BA.debugLineNum = 185;BA.debugLine="CvsGauge.Invalidate";
_cvsgauge.Invalidate();
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 218;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 219;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 220;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 191;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 192;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _gettypestyle() throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Public Sub getTypeStyle As String";
 //BA.debugLineNum = 239;BA.debugLine="Return mTypeStyle";
if (true) return _mtypestyle;
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 211;BA.debugLine="Return LabelValue.Text";
if (true) return _labelvalue.getText();
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 203;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 69;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 70;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 71;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _redraw() throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Private Sub Redraw";
 //BA.debugLineNum = 127;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 128;BA.debugLine="DrawGauge(mValue)";
_drawgauge(_mvalue);
 };
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 215;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 216;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (_mbase.getEnabled()));
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public String  _setstylealarm() throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Public Sub SetStyleAlarm";
 //BA.debugLineNum = 231;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)";
_settypestyle(_hmitileutils._typestyle_alarm /*String*/ );
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _setstylenormal() throws Exception{
 //BA.debugLineNum = 222;BA.debugLine="Public Sub SetStyleNormal";
 //BA.debugLineNum = 223;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)";
_settypestyle(_hmitileutils._typestyle_normal /*String*/ );
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return "";
}
public String  _setstylewarning() throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Public Sub SetStyleWarning";
 //BA.debugLineNum = 227;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)";
_settypestyle(_hmitileutils._typestyle_warning /*String*/ );
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 189;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public String  _settypestyle(String _value) throws Exception{
 //BA.debugLineNum = 234;BA.debugLine="Public Sub setTypeStyle(value As String)";
 //BA.debugLineNum = 235;BA.debugLine="mTypeStyle = value";
_mtypestyle = _value;
 //BA.debugLineNum = 236;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 207;BA.debugLine="mUnitText = unit";
_munittext = _unit;
 //BA.debugLineNum = 208;BA.debugLine="LabelValue.Text = $\"${mValue}${IIf(mUnitText.Leng";
_labelvalue.setText((""+__c.SmartStringFormatter("",(Object)(_mvalue))+""+__c.SmartStringFormatter("",((_munittext.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munittext))+""))) : ((Object)(""))))+""));
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 195;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 196;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 197;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 198;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 199;BA.debugLine="LabelValue.Text = $\"${NumberFormat(mValue, 1, mD";
_labelvalue.setText((""+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(_mvalue,(int) (1),_mdigits)))+""+__c.SmartStringFormatter("",((_munittext.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munittext))+""))) : ((Object)(""))))+""));
 };
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
