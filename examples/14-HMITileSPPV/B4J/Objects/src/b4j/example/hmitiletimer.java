package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitiletimer extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitiletimer", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitiletimer.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltimer = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelstatus = null;
public anywheresoftware.b4a.objects.Timer _mtimer = null;
public byte _timer_mode_countup = (byte)0;
public byte _timer_mode_countdown = (byte)0;
public byte _timer_stop = (byte)0;
public byte _timer_start = (byte)0;
public byte _timer_reset = (byte)0;
public String _mtitle = "";
public String _mdisplayformat = "";
public String _display_format_hhmmss = "";
public String _display_format_hhmm = "";
public String _display_format_seconds = "";
public byte _mmode = (byte)0;
public byte _mstate = (byte)0;
public String _timer_state_stop = "";
public String _timer_state_start = "";
public String _timer_state_reset = "";
public long _mcountervalue = 0L;
public long _mstartvalue = 0L;
public long _mstopvalue = 0L;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 85;BA.debugLine="BasePane.LoadLayout(\"hmitiletimer\")";
_basepane.LoadLayout("hmitiletimer",ba);
 //BA.debugLineNum = 88;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 89;BA.debugLine="mDisplayFormat	= Props.Get(\"DisplayFormat\")";
_mdisplayformat = BA.ObjectToString(_props.Get((Object)("DisplayFormat")));
 //BA.debugLineNum = 90;BA.debugLine="mMode 			= IIf(Props.Get(\"Mode\") == \"UP\", TIMER_M";
_mmode = (byte)(BA.ObjectToNumber((((_props.Get((Object)("Mode"))).equals((Object)("UP"))) ? ((Object)(_timer_mode_countup)) : ((Object)(_timer_mode_countdown)))));
 //BA.debugLineNum = 91;BA.debugLine="mStartValue  	= Props.Get(\"StartValue\")";
_mstartvalue = BA.ObjectToLongNumber(_props.Get((Object)("StartValue")));
 //BA.debugLineNum = 92;BA.debugLine="mStopValue  	= Props.Get(\"StopValue\")";
_mstopvalue = BA.ObjectToLongNumber(_props.Get((Object)("StopValue")));
 //BA.debugLineNum = 95;BA.debugLine="mState 			= TIMER_STOP";
_mstate = _timer_stop;
 //BA.debugLineNum = 96;BA.debugLine="mCounterValue 	= mStartValue";
_mcountervalue = _mstartvalue;
 //BA.debugLineNum = 99;BA.debugLine="LabelTitle.Text	= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 100;BA.debugLine="UpdateLabelTimer";
_updatelabeltimer();
 //BA.debugLineNum = 101;BA.debugLine="LabelStatus.Text = TIMER_STATE_START   ' means \"p";
_labelstatus.setText(_timer_state_start);
 //BA.debugLineNum = 104;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 105;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 194;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 195;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelTimer)";
_hmitileutils._applyvaluestyle /*String*/ (_labeltimer);
 //BA.debugLineNum = 196;BA.debugLine="HMITileUtils.ApplyActionStyle(LabelStatus)";
_hmitileutils._applyactionstyle /*String*/ (_labelstatus);
 //BA.debugLineNum = 198;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 200;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Public Sub Base_Resize (Width As Double, Height As";
 //BA.debugLineNum = 109;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 111;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0, 0,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 112;BA.debugLine="LabelTimer.SetLayoutAnimated 	(0, 0, 0, 				Width";
_labeltimer.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 113;BA.debugLine="LabelStatus.SetLayoutAnimated  	(0, 0, Height * 0";
_labelstatus.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private xui 					As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 27;BA.debugLine="Public BasePane 				As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private BaseLabel 				As B4XView					'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Public Tag 						As Object";
_tag = new Object();
 //BA.debugLineNum = 32;BA.debugLine="Private mEventName 				As String";
_meventname = "";
 //BA.debugLineNum = 33;BA.debugLine="Private mCallBack 				As Object";
_mcallback = new Object();
 //BA.debugLineNum = 36;BA.debugLine="Private LabelTitle 				As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private LabelTimer 				As B4XView";
_labeltimer = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private LabelStatus 			As B4XView";
_labelstatus = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private mTimer 					As Timer";
_mtimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 42;BA.debugLine="Private TIMER_MODE_COUNTUP 		As Byte = 0";
_timer_mode_countup = (byte) (0);
 //BA.debugLineNum = 43;BA.debugLine="Private TIMER_MODE_COUNTDOWN 	As Byte = 1";
_timer_mode_countdown = (byte) (1);
 //BA.debugLineNum = 46;BA.debugLine="Private TIMER_STOP 				As Byte = 0";
_timer_stop = (byte) (0);
 //BA.debugLineNum = 47;BA.debugLine="Private TIMER_START 			As Byte = 1";
_timer_start = (byte) (1);
 //BA.debugLineNum = 48;BA.debugLine="Private TIMER_RESET 			As Byte = 2";
_timer_reset = (byte) (2);
 //BA.debugLineNum = 51;BA.debugLine="Private mTitle					As String";
_mtitle = "";
 //BA.debugLineNum = 52;BA.debugLine="Private mDisplayFormat 			As String";
_mdisplayformat = "";
 //BA.debugLineNum = 53;BA.debugLine="Public DISPLAY_FORMAT_HHMMSS 	As String = \"HH:MM:";
_display_format_hhmmss = "HH:MM:SS";
 //BA.debugLineNum = 54;BA.debugLine="Public DISPLAY_FORMAT_HHMM 		As String = \"HH:MM\"";
_display_format_hhmm = "HH:MM";
 //BA.debugLineNum = 55;BA.debugLine="Public DISPLAY_FORMAT_SECONDS 	As String = \"Secon";
_display_format_seconds = "Seconds";
 //BA.debugLineNum = 56;BA.debugLine="Private mMode 					As Byte					' Counting Up/Down";
_mmode = (byte)0;
 //BA.debugLineNum = 57;BA.debugLine="Private mState	 				As Byte					' Start/Stop/Rese";
_mstate = (byte)0;
 //BA.debugLineNum = 58;BA.debugLine="Private TIMER_STATE_STOP 		As String = \"STOP\"";
_timer_state_stop = "STOP";
 //BA.debugLineNum = 59;BA.debugLine="Private TIMER_STATE_START 		As String = \"START\"";
_timer_state_start = "START";
 //BA.debugLineNum = 60;BA.debugLine="Private TIMER_STATE_RESET 		As String = \"RESET\"";
_timer_state_reset = "RESET";
 //BA.debugLineNum = 63;BA.debugLine="Private mCounterValue 			As Long";
_mcountervalue = 0L;
 //BA.debugLineNum = 64;BA.debugLine="Private mStartValue 			As Long";
_mstartvalue = 0L;
 //BA.debugLineNum = 65;BA.debugLine="Private mStopValue 				As Long";
_mstopvalue = 0L;
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 75;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 76;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 77;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 78;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 81;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public String  _getdisplayformat() throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Public Sub getDisplayFormat As String";
 //BA.debugLineNum = 175;BA.debugLine="Return mDisplayFormat";
if (true) return _mdisplayformat;
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 166;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return false;
}
public float  _getstartvalue() throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Public Sub getStartValue As Float";
 //BA.debugLineNum = 144;BA.debugLine="Return mStartValue";
if (true) return (float) (_mstartvalue);
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return 0f;
}
public float  _getstopvalue() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub getStopValue As Float";
 //BA.debugLineNum = 152;BA.debugLine="Return mStopValue";
if (true) return (float) (_mstopvalue);
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return 0f;
}
public double  _gettimertextsize() throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub getTimerTextSize As Double";
 //BA.debugLineNum = 183;BA.debugLine="Return LabelTimer.TextSize";
if (true) return _labeltimer.getTextSize();
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return 0;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 136;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _handletimerstate() throws Exception{
 //BA.debugLineNum = 253;BA.debugLine="Private Sub HandleTimerState";
 //BA.debugLineNum = 254;BA.debugLine="Select mState";
switch (BA.switchObjectToInt(_mstate,_timer_stop,_timer_start,_timer_reset)) {
case 0: {
 //BA.debugLineNum = 257;BA.debugLine="mCounterValue = IIf(mMode == TIMER_MODE_COUNTDO";
_mcountervalue = BA.ObjectToLongNumber(((_mmode==_timer_mode_countdown) ? ((Object)(_mstartvalue)) : ((Object)(0))));
 //BA.debugLineNum = 258;BA.debugLine="mTimer.Enabled = True";
_mtimer.setEnabled(__c.True);
 //BA.debugLineNum = 259;BA.debugLine="LabelStatus.Text = TIMER_STATE_STOP";
_labelstatus.setText(_timer_state_stop);
 //BA.debugLineNum = 260;BA.debugLine="mState = TIMER_START";
_mstate = _timer_start;
 //BA.debugLineNum = 261;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Start\")";
if (__c.SubExists(ba,_mcallback,_meventname+"_Start")) { 
 //BA.debugLineNum = 262;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Start";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Start");
 };
 break; }
case 1: {
 //BA.debugLineNum = 267;BA.debugLine="mTimer.Enabled = False";
_mtimer.setEnabled(__c.False);
 //BA.debugLineNum = 268;BA.debugLine="mCounterValue = IIf(mMode == TIMER_MODE_COUNTDO";
_mcountervalue = BA.ObjectToLongNumber(((_mmode==_timer_mode_countdown) ? ((Object)(0)) : ((Object)(_mstopvalue))));
 //BA.debugLineNum = 269;BA.debugLine="LabelStatus.Text = TIMER_STATE_START";
_labelstatus.setText(_timer_state_start);
 //BA.debugLineNum = 270;BA.debugLine="mState = TIMER_STOP";
_mstate = _timer_stop;
 //BA.debugLineNum = 271;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Stop\") T";
if (__c.SubExists(ba,_mcallback,_meventname+"_Stop")) { 
 //BA.debugLineNum = 272;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Stop\"";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Stop");
 };
 break; }
case 2: {
 //BA.debugLineNum = 276;BA.debugLine="mCounterValue = 0";
_mcountervalue = (long) (0);
 //BA.debugLineNum = 277;BA.debugLine="LabelStatus.Text = TIMER_STATE_RESET";
_labelstatus.setText(_timer_state_reset);
 break; }
}
;
 //BA.debugLineNum = 279;BA.debugLine="UpdateLabelTimer";
_updatelabeltimer();
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 68;BA.debugLine="Private Sub Initialize(Callback As Object, EventNa";
 //BA.debugLineNum = 69;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 70;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 71;BA.debugLine="mTimer.Initialize(\"Timer\", 1000)";
_mtimer.Initialize(ba,"Timer",(long) (1000));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _labelstatus_click() throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Private Sub LabelStatus_Click";
 //BA.debugLineNum = 312;BA.debugLine="HandleTimerState";
_handletimerstate();
 //BA.debugLineNum = 313;BA.debugLine="End Sub";
return "";
}
public String  _labelstatus_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 298;BA.debugLine="Private Sub LabelStatus_MouseClicked (EventData As";
 //BA.debugLineNum = 299;BA.debugLine="HandleTimerState";
_handletimerstate();
 //BA.debugLineNum = 300;BA.debugLine="End Sub";
return "";
}
public String  _labeltimer_click() throws Exception{
 //BA.debugLineNum = 307;BA.debugLine="Private Sub LabelTimer_Click";
 //BA.debugLineNum = 308;BA.debugLine="HandleTimerState";
_handletimerstate();
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return "";
}
public String  _labeltimer_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 294;BA.debugLine="Private Sub LabelTimer_MouseClicked (EventData As";
 //BA.debugLineNum = 295;BA.debugLine="HandleTimerState";
_handletimerstate();
 //BA.debugLineNum = 296;BA.debugLine="End Sub";
return "";
}
public String  _labeltitle_click() throws Exception{
 //BA.debugLineNum = 303;BA.debugLine="Private Sub LabelTitle_Click";
 //BA.debugLineNum = 304;BA.debugLine="HandleTimerState";
_handletimerstate();
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public String  _labeltitle_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 290;BA.debugLine="Private Sub LabelTitle_MouseClicked (EventData As";
 //BA.debugLineNum = 291;BA.debugLine="HandleTimerState";
_handletimerstate();
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public String  _reset() throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Public Sub Reset";
 //BA.debugLineNum = 157;BA.debugLine="mCounterValue = IIf(mMode == TIMER_MODE_COUNTDOWN";
_mcountervalue = BA.ObjectToLongNumber(((_mmode==_timer_mode_countdown) ? ((Object)(_mstartvalue)) : ((Object)(0))));
 //BA.debugLineNum = 158;BA.debugLine="UpdateLabelTimer";
_updatelabeltimer();
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _setdisplayformat(String _format) throws Exception{
 //BA.debugLineNum = 170;BA.debugLine="Public Sub setDisplayFormat(format As String)";
 //BA.debugLineNum = 171;BA.debugLine="mDisplayFormat = format.ToUpperCase";
_mdisplayformat = _format.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 172;BA.debugLine="UpdateLabelTimer";
_updatelabeltimer();
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 162;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 163;BA.debugLine="HMITileUtils.SetAlpha(BasePane.enabled)";
_hmitileutils._setalpha /*float*/ (_basepane.getEnabled());
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public String  _setstartvalue(float _value) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub setStartValue(value As Float)";
 //BA.debugLineNum = 141;BA.debugLine="mStartValue = value";
_mstartvalue = (long) (_value);
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _setstopvalue(float _value) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub setStopValue(value As Float)";
 //BA.debugLineNum = 149;BA.debugLine="mStopValue = value";
_mstopvalue = (long) (_value);
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _settimertextsize(double _value) throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Public Sub setTimerTextSize(value As Double)";
 //BA.debugLineNum = 180;BA.debugLine="LabelTimer.TextSize = value";
_labeltimer.setTextSize(_value);
 //BA.debugLineNum = 181;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 133;BA.debugLine="mTitle = value";
_mtitle = _value;
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public String  _starttimer() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Public Sub StartTimer";
 //BA.debugLineNum = 123;BA.debugLine="mTimer.Enabled = True";
_mtimer.setEnabled(__c.True);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _stoptimer() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub StopTimer";
 //BA.debugLineNum = 128;BA.debugLine="mTimer.Enabled = False";
_mtimer.setEnabled(__c.False);
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public String  _timer_tick() throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="Private Sub Timer_Tick";
 //BA.debugLineNum = 206;BA.debugLine="UpdateTimer";
_updatetimer();
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public String  _updatelabeltimer() throws Exception{
long _t = 0L;
int _h = 0;
int _m = 0;
int _s = 0;
 //BA.debugLineNum = 232;BA.debugLine="Private Sub UpdateLabelTimer";
 //BA.debugLineNum = 234;BA.debugLine="If mCounterValue < 0 Then mCounterValue = 0";
if (_mcountervalue<0) { 
_mcountervalue = (long) (0);};
 //BA.debugLineNum = 236;BA.debugLine="Dim t As Long	= mCounterValue * DateTime.TicksPer";
_t = (long) (_mcountervalue*__c.DateTime.TicksPerSecond);
 //BA.debugLineNum = 237;BA.debugLine="Dim h As Int	= t / DateTime.TicksPerHour";
_h = (int) (_t/(double)__c.DateTime.TicksPerHour);
 //BA.debugLineNum = 238;BA.debugLine="Dim m As Int	= (t Mod DateTime.TicksPerHour) / Da";
_m = (int) ((_t%__c.DateTime.TicksPerHour)/(double)__c.DateTime.TicksPerMinute);
 //BA.debugLineNum = 239;BA.debugLine="Dim s As Int	= (t Mod DateTime.TicksPerMinute) /";
_s = (int) ((_t%__c.DateTime.TicksPerMinute)/(double)__c.DateTime.TicksPerSecond);
 //BA.debugLineNum = 242;BA.debugLine="Select mDisplayFormat";
switch (BA.switchObjectToInt(_mdisplayformat,_display_format_hhmmss,_display_format_hhmm,_display_format_seconds)) {
case 0: {
 //BA.debugLineNum = 244;BA.debugLine="LabelTimer.Text = $\"${NumberFormat2(h, 2, 0, 0,";
_labeltimer.setText((""+__c.SmartStringFormatter("",(Object)(__c.NumberFormat2(_h,(int) (2),(int) (0),(int) (0),__c.False)))+":"+__c.SmartStringFormatter("",(Object)(__c.NumberFormat2(_m,(int) (2),(int) (0),(int) (0),__c.False)))+":"+__c.SmartStringFormatter("",(Object)(__c.NumberFormat2(_s,(int) (2),(int) (0),(int) (0),__c.False)))+""));
 break; }
case 1: {
 //BA.debugLineNum = 246;BA.debugLine="LabelTimer.Text = $\"${NumberFormat2(h, 2, 0, 0,";
_labeltimer.setText((""+__c.SmartStringFormatter("",(Object)(__c.NumberFormat2(_h,(int) (2),(int) (0),(int) (0),__c.False)))+":"+__c.SmartStringFormatter("",(Object)(__c.NumberFormat2(_m,(int) (2),(int) (0),(int) (0),__c.False)))+""));
 break; }
case 2: {
 //BA.debugLineNum = 248;BA.debugLine="LabelTimer.Text = $\"${mCounterValue}\"$";
_labeltimer.setText((""+__c.SmartStringFormatter("",(Object)(_mcountervalue))+""));
 break; }
}
;
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public String  _updatetimer() throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Private Sub UpdateTimer";
 //BA.debugLineNum = 211;BA.debugLine="If mMode == TIMER_MODE_COUNTDOWN Then";
if (_mmode==_timer_mode_countdown) { 
 //BA.debugLineNum = 212;BA.debugLine="mCounterValue = mCounterValue - 1";
_mcountervalue = (long) (_mcountervalue-1);
 }else {
 //BA.debugLineNum = 214;BA.debugLine="mCounterValue = mCounterValue + 1";
_mcountervalue = (long) (_mcountervalue+1);
 };
 //BA.debugLineNum = 219;BA.debugLine="If (mMode == TIMER_MODE_COUNTDOWN And mCounterVal";
if ((_mmode==_timer_mode_countdown && _mcountervalue<=_mstopvalue) || (_mmode==_timer_mode_countup && _mcountervalue>=_mstopvalue)) { 
 //BA.debugLineNum = 221;BA.debugLine="HandleTimerState";
_handletimerstate();
 //BA.debugLineNum = 222;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Finished\"";
if (__c.SubExists(ba,_mcallback,_meventname+"_Finished")) { 
 //BA.debugLineNum = 223;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Finish";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Finished");
 };
 }else {
 //BA.debugLineNum = 226;BA.debugLine="UpdateLabelTimer";
_updatelabeltimer();
 };
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
