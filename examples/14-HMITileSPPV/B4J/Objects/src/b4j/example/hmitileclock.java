package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitileclock extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitileclock", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitileclock.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public int _color_hour_hand = 0;
public int _color_minutes_hand = 0;
public int _color_seconds_hand = 0;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _paneclock = null;
public anywheresoftware.b4a.objects.B4XCanvas _canvasclock = null;
public boolean _mshowseconds = false;
public long _mcurrenttime = 0L;
public anywheresoftware.b4a.objects.Timer _mclocktimer = null;
public int _mlastsec = 0;
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
 //BA.debugLineNum = 57;BA.debugLine="BasePane.LoadLayout(\"hmitileclock\")";
_basepane.LoadLayout("hmitileclock",ba);
 //BA.debugLineNum = 60;BA.debugLine="mShowSeconds 	= Props.Get(\"ShowSeconds\")";
_mshowseconds = BA.ObjectToBoolean(_props.Get((Object)("ShowSeconds")));
 //BA.debugLineNum = 62;BA.debugLine="CanvasClock.Initialize(PaneClock)";
_canvasclock.Initialize(ba,_paneclock);
 //BA.debugLineNum = 63;BA.debugLine="ApplyStatusStyle";
_applystatusstyle();
 //BA.debugLineNum = 65;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 67;BA.debugLine="mClockTimer.Initialize(\"ClockTimer\", 1000)   ' 10";
_mclocktimer.Initialize(ba,"ClockTimer",(long) (1000));
 //BA.debugLineNum = 68;BA.debugLine="mClockTimer.Enabled = True";
_mclocktimer.setEnabled(__c.True);
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle() throws Exception{
 //BA.debugLineNum = 158;BA.debugLine="Private Sub ApplyStatusStyle";
 //BA.debugLineNum = 159;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 162;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 72;BA.debugLine="If Not(PaneClock.IsInitialized) Then Return";
if (__c.Not(_paneclock.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 74;BA.debugLine="PaneClock.SetLayoutAnimated(0, _ 								HMITileU";
_paneclock.SetLayoutAnimated((int) (0),_hmitileutils._border_width /*double*/ ,_hmitileutils._border_width /*double*/ ,_width-_hmitileutils._border_width /*double*/ *2,_height-_hmitileutils._border_width /*double*/ *2);
 //BA.debugLineNum = 79;BA.debugLine="CanvasClock.Resize(PaneClock.Width, PaneClock.Hei";
_canvasclock.Resize(_paneclock.getWidth(),_paneclock.getHeight());
 //BA.debugLineNum = 80;BA.debugLine="UpdateTime(DateTime.Now)";
_updatetime(__c.DateTime.getNow());
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim COLOR_HOUR_HAND As Int 		= 0xFFFFFFFF";
_color_hour_hand = ((int)0xffffffff);
 //BA.debugLineNum = 19;BA.debugLine="Dim COLOR_MINUTES_HAND As Int 	= 0xFFFFFFFF";
_color_minutes_hand = ((int)0xffffffff);
 //BA.debugLineNum = 20;BA.debugLine="Dim COLOR_SECONDS_HAND As Int	= 0xFFFF0000";
_color_seconds_hand = ((int)0xffff0000);
 //BA.debugLineNum = 22;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 23;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 25;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 28;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 29;BA.debugLine="Private PaneClock As B4XView";
_paneclock = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private CanvasClock As B4XCanvas";
_canvasclock = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 33;BA.debugLine="Private mShowSeconds As Boolean";
_mshowseconds = false;
 //BA.debugLineNum = 36;BA.debugLine="Private mCurrentTime As Long";
_mcurrenttime = 0L;
 //BA.debugLineNum = 39;BA.debugLine="Private mClockTimer As Timer";
_mclocktimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 40;BA.debugLine="Private mLastSec As Int = -1";
_mlastsec = (int) (-1);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public String  _clocktimer_tick() throws Exception{
long _now = 0L;
int _sec = 0;
 //BA.debugLineNum = 84;BA.debugLine="Private Sub ClockTimer_Tick";
 //BA.debugLineNum = 85;BA.debugLine="Dim now As Long = DateTime.Now";
_now = __c.DateTime.getNow();
 //BA.debugLineNum = 86;BA.debugLine="mCurrentTime = now";
_mcurrenttime = _now;
 //BA.debugLineNum = 87;BA.debugLine="Dim sec As Int = DateTime.GetSecond(now)";
_sec = __c.DateTime.GetSecond(_now);
 //BA.debugLineNum = 88;BA.debugLine="If sec = mLastSec Then Return    ' avoid doubl";
if (_sec==_mlastsec) { 
if (true) return "";};
 //BA.debugLineNum = 89;BA.debugLine="mLastSec = sec";
_mlastsec = _sec;
 //BA.debugLineNum = 90;BA.debugLine="UpdateTime(DateTime.Now)";
_updatetime(__c.DateTime.getNow());
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public long  _currenttime() throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub CurrentTime As Long";
 //BA.debugLineNum = 147;BA.debugLine="Return mCurrentTime";
if (true) return _mcurrenttime;
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return 0L;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 49;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 50;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 51;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 53;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _drawclockface(float _cx,float _cy,float _r) throws Exception{
int _facecolor = 0;
int _i = 0;
double _angle = 0;
double _rad = 0;
float _innerr = 0f;
float _outerr = 0f;
double _x1 = 0;
double _y1 = 0;
double _x2 = 0;
double _y2 = 0;
int _stroke = 0;
 //BA.debugLineNum = 171;BA.debugLine="Private Sub DrawClockFace(cx As Float, cy As Float";
 //BA.debugLineNum = 173;BA.debugLine="Dim FaceColor As Int = HMITileUtils.COLOR_BORDER_";
_facecolor = _hmitileutils._color_border_dark /*int*/ ;
 //BA.debugLineNum = 176;BA.debugLine="CanvasClock.DrawCircle(cx, cy, r, FaceColor, Fals";
_canvasclock.DrawCircle(_cx,_cy,_r,_facecolor,__c.False,(float) (__c.DipToCurrent((int) (3))));
 //BA.debugLineNum = 178;BA.debugLine="For i = 0 To 59";
{
final int step3 = 1;
final int limit3 = (int) (59);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 179;BA.debugLine="Dim angle As Double = (i / 60) * 360";
_angle = (_i/(double)60)*360;
 //BA.debugLineNum = 180;BA.debugLine="Dim rad As Double = (angle - 90) * cPI / 180";
_rad = (_angle-90)*__c.cPI/(double)180;
 //BA.debugLineNum = 182;BA.debugLine="Dim innerR As Float = IIf(i Mod 5 = 0, r * 0.85,";
_innerr = (float)(BA.ObjectToNumber(((_i%5==0) ? ((Object)(_r*0.85)) : ((Object)(_r*0.92)))));
 //BA.debugLineNum = 183;BA.debugLine="Dim outerR As Float = r";
_outerr = _r;
 //BA.debugLineNum = 185;BA.debugLine="Dim x1 As Double = cx + Cos(rad) * innerR";
_x1 = _cx+__c.Cos(_rad)*_innerr;
 //BA.debugLineNum = 186;BA.debugLine="Dim y1 As Double  = cy + Sin(rad) * innerR";
_y1 = _cy+__c.Sin(_rad)*_innerr;
 //BA.debugLineNum = 187;BA.debugLine="Dim x2 As Double  = cx + Cos(rad) * outerR";
_x2 = _cx+__c.Cos(_rad)*_outerr;
 //BA.debugLineNum = 188;BA.debugLine="Dim y2 As Double  = cy + Sin(rad) * outerR";
_y2 = _cy+__c.Sin(_rad)*_outerr;
 //BA.debugLineNum = 190;BA.debugLine="Dim stroke As Int = IIf(i Mod 5 = 0, 3dip, 1dip)";
_stroke = (int)(BA.ObjectToNumber(((_i%5==0) ? ((Object)(__c.DipToCurrent((int) (3)))) : ((Object)(__c.DipToCurrent((int) (1)))))));
 //BA.debugLineNum = 193;BA.debugLine="CanvasClock.DrawLine(x1, y1, x2, y2, FaceColor,";
_canvasclock.DrawLine((float) (_x1),(float) (_y1),(float) (_x2),(float) (_y2),_facecolor,(float) (_stroke));
 }
};
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public String  _drawhand(float _cx,float _cy,float _length,double _angledeg,float _stroke,int _color) throws Exception{
double _rad = 0;
double _x2 = 0;
double _y2 = 0;
 //BA.debugLineNum = 217;BA.debugLine="Private Sub DrawHand(cx As Float, cy As Float, len";
 //BA.debugLineNum = 218;BA.debugLine="Dim rad As Double = (angleDeg - 90) * cPI / 180";
_rad = (_angledeg-90)*__c.cPI/(double)180;
 //BA.debugLineNum = 219;BA.debugLine="Dim x2  As Double = cx + Cos(rad) * length";
_x2 = _cx+__c.Cos(_rad)*_length;
 //BA.debugLineNum = 220;BA.debugLine="Dim y2  As Double = cy + Sin(rad) * length";
_y2 = _cy+__c.Sin(_rad)*_length;
 //BA.debugLineNum = 221;BA.debugLine="CanvasClock.DrawLine(cx, cy, x2, y2, color, strok";
_canvasclock.DrawLine(_cx,_cy,(float) (_x2),(float) (_y2),_color,_stroke);
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public String  _drawhands(float _cx,float _cy,float _r,long _t) throws Exception{
int _h = 0;
int _m = 0;
int _s = 0;
double _hourangle = 0;
double _minangle = 0;
double _secangle = 0;
 //BA.debugLineNum = 197;BA.debugLine="Private Sub DrawHands(cx As Float, cy As Float, r";
 //BA.debugLineNum = 198;BA.debugLine="Dim h As Int = DateTime.GetHour(T)";
_h = __c.DateTime.GetHour(_t);
 //BA.debugLineNum = 199;BA.debugLine="Dim m As Int = DateTime.GetMinute(T)";
_m = __c.DateTime.GetMinute(_t);
 //BA.debugLineNum = 200;BA.debugLine="Dim s As Int = DateTime.GetSecond(T)";
_s = __c.DateTime.GetSecond(_t);
 //BA.debugLineNum = 203;BA.debugLine="Dim hourAngle As Double = (h Mod 12 + m / 60) * 3";
_hourangle = (_h%12+_m/(double)60)*30;
 //BA.debugLineNum = 204;BA.debugLine="DrawHand(cx, cy, r * 0.55, hourAngle, 4dip, COLOR";
_drawhand(_cx,_cy,(float) (_r*0.55),_hourangle,(float) (__c.DipToCurrent((int) (4))),_color_hour_hand);
 //BA.debugLineNum = 207;BA.debugLine="Dim minAngle As Double = (m + s / 60) * 6";
_minangle = (_m+_s/(double)60)*6;
 //BA.debugLineNum = 208;BA.debugLine="DrawHand(cx, cy, r * 0.75, minAngle, 3dip, COLOR_";
_drawhand(_cx,_cy,(float) (_r*0.75),_minangle,(float) (__c.DipToCurrent((int) (3))),_color_minutes_hand);
 //BA.debugLineNum = 211;BA.debugLine="If mShowSeconds Then";
if (_mshowseconds) { 
 //BA.debugLineNum = 212;BA.debugLine="Dim secAngle As Double = s * 6";
_secangle = _s*6;
 //BA.debugLineNum = 213;BA.debugLine="DrawHand(cx, cy, r * 0.80, secAngle, 2dip, COLOR";
_drawhand(_cx,_cy,(float) (_r*0.80),_secangle,(float) (__c.DipToCurrent((int) (2))),_color_seconds_hand);
 };
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 114;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowseconds() throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Public Sub getShowSeconds As Boolean";
 //BA.debugLineNum = 105;BA.debugLine="Return mShowSeconds";
if (true) return _mshowseconds;
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 43;BA.debugLine="Private Sub Initialize (Callback As Object, EventN";
 //BA.debugLineNum = 44;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 45;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public String  _paneclock_click() throws Exception{
 //BA.debugLineNum = 235;BA.debugLine="Private Sub PaneClock_Click";
 //BA.debugLineNum = 236;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 237;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _paneclock_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Private Sub PaneClock_MouseClicked (EventData As M";
 //BA.debugLineNum = 231;BA.debugLine="PaneClock_Click";
_paneclock_click();
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 110;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 111;BA.debugLine="HMITileUtils.SetAlpha(BasePane.enabled)";
_hmitileutils._setalpha /*float*/ (_basepane.getEnabled());
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public String  _setshowseconds(boolean _b) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Public Sub setShowSeconds(b As Boolean)";
 //BA.debugLineNum = 101;BA.debugLine="mShowSeconds = b";
_mshowseconds = _b;
 //BA.debugLineNum = 102;BA.debugLine="UpdateTime(DateTime.Now)";
_updatetime(__c.DateTime.getNow());
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _startclock() throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Public Sub StartClock";
 //BA.debugLineNum = 119;BA.debugLine="mClockTimer.Enabled = True";
_mclocktimer.setEnabled(__c.True);
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public String  _stopclock() throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Public Sub StopClock";
 //BA.debugLineNum = 124;BA.debugLine="mClockTimer.Enabled = False";
_mclocktimer.setEnabled(__c.False);
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _updatetime(long _newtime) throws Exception{
float _cx = 0f;
float _cy = 0f;
float _r = 0f;
 //BA.debugLineNum = 130;BA.debugLine="Public Sub UpdateTime(newtime As Long)";
 //BA.debugLineNum = 133;BA.debugLine="CanvasClock.ClearRect(CanvasClock.TargetRect)";
_canvasclock.ClearRect(_canvasclock.getTargetRect());
 //BA.debugLineNum = 135;BA.debugLine="Dim cx As Float = PaneClock.Width / 2";
_cx = (float) (_paneclock.getWidth()/(double)2);
 //BA.debugLineNum = 136;BA.debugLine="Dim cy As Float = PaneClock.Height / 2";
_cy = (float) (_paneclock.getHeight()/(double)2);
 //BA.debugLineNum = 137;BA.debugLine="Dim r As Float = Min(cx, cy) * 0.80";
_r = (float) (__c.Min(_cx,_cy)*0.80);
 //BA.debugLineNum = 139;BA.debugLine="DrawClockFace(cx, cy, r)";
_drawclockface(_cx,_cy,_r);
 //BA.debugLineNum = 140;BA.debugLine="DrawHands(cx, cy, r, newtime)";
_drawhands(_cx,_cy,_r,_newtime);
 //BA.debugLineNum = 142;BA.debugLine="CanvasClock.Invalidate";
_canvasclock.Invalidate();
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
