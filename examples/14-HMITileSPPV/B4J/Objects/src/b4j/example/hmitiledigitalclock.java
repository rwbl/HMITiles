package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitiledigitalclock extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitiledigitalclock", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitiledigitalclock.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltext = null;
public boolean _mshowseconds = false;
public boolean _mblinkcolon = false;
public anywheresoftware.b4a.objects.Timer _mclocktimer = null;
public boolean _mclockblink = false;
public long _mcurrenttime = 0L;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 57;BA.debugLine="BasePane.LoadLayout(\"hmitilelabel\")";
_basepane.LoadLayout("hmitilelabel",ba);
 //BA.debugLineNum = 59;BA.debugLine="LabelText.Text = \"\"";
_labeltext.setText("");
 //BA.debugLineNum = 62;BA.debugLine="mShowSeconds	= Props.Get(\"ShowSeconds\")";
_mshowseconds = BA.ObjectToBoolean(_props.Get((Object)("ShowSeconds")));
 //BA.debugLineNum = 63;BA.debugLine="mBlinkColon		= Props.Get(\"BlinkColon\")";
_mblinkcolon = BA.ObjectToBoolean(_props.Get((Object)("BlinkColon")));
 //BA.debugLineNum = 66;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 67;BA.debugLine="ApplyStatusStyle";
_applystatusstyle();
 //BA.debugLineNum = 69;BA.debugLine="StartClock";
_startclock();
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle() throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Private Sub ApplyStatusStyle";
 //BA.debugLineNum = 132;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelText)";
_hmitileutils._applyvaluestyle /*String*/ (_labeltext);
 //BA.debugLineNum = 134;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 136;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Public Sub Base_Resize (Width As Double, Height As";
 //BA.debugLineNum = 73;BA.debugLine="If Not(LabelText.IsInitialized) Then Return";
if (__c.Not(_labeltext.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 75;BA.debugLine="LabelText.SetLayoutAnimated	(0, 0, 0, Width, Heig";
_labeltext.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 21;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private BaseLabel As B4XView				'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 25;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 26;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 28;BA.debugLine="Private LabelText As B4XView";
_labeltext = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private mShowSeconds As Boolean";
_mshowseconds = false;
 //BA.debugLineNum = 32;BA.debugLine="Private mBlinkColon As Boolean";
_mblinkcolon = false;
 //BA.debugLineNum = 35;BA.debugLine="Private mClockTimer As Timer";
_mclocktimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 36;BA.debugLine="Private mClockBlink As Boolean";
_mclockblink = false;
 //BA.debugLineNum = 37;BA.debugLine="Private mCurrentTime As Long";
_mcurrenttime = 0L;
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public long  _currenttime() throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Public Sub CurrentTime As Long";
 //BA.debugLineNum = 111;BA.debugLine="Return mCurrentTime";
if (true) return _mcurrenttime;
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return 0L;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 47;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 48;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 49;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 50;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 53;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public boolean  _getblinkcolon() throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Public Sub getBlinkColon As Boolean";
 //BA.debugLineNum = 106;BA.debugLine="Return mBlinkColon";
if (true) return _mblinkcolon;
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 120;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowseconds() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Public Sub getShowSeconds As Boolean";
 //BA.debugLineNum = 98;BA.debugLine="Return mShowSeconds";
if (true) return _mshowseconds;
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 40;BA.debugLine="Private Sub Initialize(Callback As Object, EventNa";
 //BA.debugLineNum = 41;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 42;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 43;BA.debugLine="mClockTimer.Initialize(\"TimerClock\", 1000)";
_mclocktimer.Initialize(ba,"TimerClock",(long) (1000));
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_click() throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Private Sub LabelText_Click";
 //BA.debugLineNum = 181;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 182;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Private Sub LabelText_MouseClicked (EventData As M";
 //BA.debugLineNum = 176;BA.debugLine="LabelText_Click";
_labeltext_click();
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public String  _setblinkcolon(boolean _state) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Public Sub setBlinkColon(state As Boolean)";
 //BA.debugLineNum = 103;BA.debugLine="mBlinkColon = state";
_mblinkcolon = _state;
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 116;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 117;BA.debugLine="HMITileUtils.SetAlpha(BasePane.enabled)";
_hmitileutils._setalpha /*float*/ (_basepane.getEnabled());
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public String  _setshowseconds(boolean _state) throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Public Sub setShowSeconds(state As Boolean)";
 //BA.debugLineNum = 95;BA.debugLine="mShowSeconds = state";
_mshowseconds = _state;
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _startclock() throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Public Sub StartClock";
 //BA.debugLineNum = 85;BA.debugLine="mClockTimer.Enabled = True";
_mclocktimer.setEnabled(__c.True);
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _stopclock() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Public Sub StopClock";
 //BA.debugLineNum = 90;BA.debugLine="mClockTimer.Enabled = False";
_mclocktimer.setEnabled(__c.False);
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public String  _timerclock_tick() throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Private Sub TimerClock_Tick";
 //BA.debugLineNum = 142;BA.debugLine="UpdateClock";
_updateclock();
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _updateclock() throws Exception{
long _now = 0L;
int _h = 0;
int _m = 0;
int _s = 0;
String _colon = "";
String _txt = "";
 //BA.debugLineNum = 145;BA.debugLine="Private Sub UpdateClock";
 //BA.debugLineNum = 146;BA.debugLine="Dim now As Long = DateTime.Now";
_now = __c.DateTime.getNow();
 //BA.debugLineNum = 147;BA.debugLine="mCurrentTime = now";
_mcurrenttime = _now;
 //BA.debugLineNum = 148;BA.debugLine="Dim h As Int = DateTime.GetHour(now)";
_h = __c.DateTime.GetHour(_now);
 //BA.debugLineNum = 149;BA.debugLine="Dim m As Int = DateTime.GetMinute(now)";
_m = __c.DateTime.GetMinute(_now);
 //BA.debugLineNum = 150;BA.debugLine="Dim s As Int = DateTime.GetSecond(now)";
_s = __c.DateTime.GetSecond(_now);
 //BA.debugLineNum = 152;BA.debugLine="Dim colon As String = \":\"";
_colon = ":";
 //BA.debugLineNum = 153;BA.debugLine="If mBlinkColon Then";
if (_mblinkcolon) { 
 //BA.debugLineNum = 154;BA.debugLine="If mClockBlink = False Then colon = \" \"";
if (_mclockblink==__c.False) { 
_colon = " ";};
 //BA.debugLineNum = 155;BA.debugLine="mClockBlink = Not(mClockBlink)";
_mclockblink = __c.Not(_mclockblink);
 };
 //BA.debugLineNum = 158;BA.debugLine="Dim txt As String";
_txt = "";
 //BA.debugLineNum = 159;BA.debugLine="If mShowSeconds Then";
if (_mshowseconds) { 
 //BA.debugLineNum = 160;BA.debugLine="txt = NumberFormat2(h, 2, 0, 0, False) & colon &";
_txt = __c.NumberFormat2(_h,(int) (2),(int) (0),(int) (0),__c.False)+_colon+__c.NumberFormat2(_m,(int) (2),(int) (0),(int) (0),__c.False)+_colon+__c.NumberFormat2(_s,(int) (2),(int) (0),(int) (0),__c.False);
 }else {
 //BA.debugLineNum = 162;BA.debugLine="txt = NumberFormat2(h, 2, 0, 0, False) & colon &";
_txt = __c.NumberFormat2(_h,(int) (2),(int) (0),(int) (0),__c.False)+_colon+__c.NumberFormat2(_m,(int) (2),(int) (0),(int) (0),__c.False);
 };
 //BA.debugLineNum = 166;BA.debugLine="LabelText.Text = txt";
_labeltext.setText(_txt);
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
