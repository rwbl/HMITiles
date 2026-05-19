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
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panegauge = null;
public anywheresoftware.b4a.objects.B4XCanvas _cvsgauge = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelunit = null;
public String _mtitle = "";
public float _mvalue = 0f;
public float _mmin = 0f;
public float _mmax = 0f;
public String _munit = "";
public int _mdigits = 0;
public boolean _mshowneedle = false;
public boolean _mshowrangelabels = false;
public String _mstatus = "";
public float _mcx = 0f;
public float _mcy = 0f;
public float _mradius = 0f;
public int _mmaskcolor = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 89;BA.debugLine="BasePane.LoadLayout(\"hmitilegauge\")";
_basepane.LoadLayout("hmitilegauge",ba);
 //BA.debugLineNum = 92;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 93;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 94;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 95;BA.debugLine="mMin			= Props.GetDefault(\"Min\", 0)";
_mmin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Min"),(Object)(0))));
 //BA.debugLineNum = 96;BA.debugLine="mMax			= Props.GetDefault(\"Max\", 100)";
_mmax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Max"),(Object)(100))));
 //BA.debugLineNum = 97;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 98;BA.debugLine="LabelUnit.Text	= mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 99;BA.debugLine="mDigits			= Props.GetDefault(\"Digits\", 0)";
_mdigits = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("Digits"),(Object)(0))));
 //BA.debugLineNum = 100;BA.debugLine="mShowNeedle		= Props.GetDefault(\"ShowNeedle\", Fal";
_mshowneedle = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowNeedle"),(Object)(__c.False)));
 //BA.debugLineNum = 101;BA.debugLine="mShowRangeLabels= Props.GetDefault(\"ShowRangeLabe";
_mshowrangelabels = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowRangeLabels"),(Object)(__c.False)));
 //BA.debugLineNum = 102;BA.debugLine="mStatus			= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 105;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 108;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 331;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 332;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 333;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 334;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 335;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 336;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 338;BA.debugLine="mMaskColor = BasePane.Color";
_mmaskcolor = _basepane.getColor();
 //BA.debugLineNum = 339;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 340;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 112;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 115;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0, 0,				Width,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 116;BA.debugLine="PaneGauge.SetLayoutAnimated		(0, 0, Height * 0.25";
_panegauge.SetLayoutAnimated((int) (0),0,_height*0.25,_width,_height*0.50);
 //BA.debugLineNum = 117;BA.debugLine="LabelValue.SetLayoutAnimated	(0, 0, Height * 0.55";
_labelvalue.SetLayoutAnimated((int) (0),0,_height*0.55,_width,_height*0.35);
 //BA.debugLineNum = 118;BA.debugLine="LabelUnit.SetLayoutAnimated		(0, 0, Height * 0.80";
_labelunit.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 121;BA.debugLine="mCx 	= PaneGauge.Width / 2";
_mcx = (float) (_panegauge.getWidth()/(double)2);
 //BA.debugLineNum = 122;BA.debugLine="mCy 	= PaneGauge.Height * 0.5";
_mcy = (float) (_panegauge.getHeight()*0.5);
 //BA.debugLineNum = 123;BA.debugLine="mRadius	= Min(mCx, mCy) * 0.9";
_mradius = (float) (__c.Min(_mcx,_mcy)*0.9);
 //BA.debugLineNum = 126;BA.debugLine="CvsGauge.Initialize(PaneGauge)";
_cvsgauge.Initialize(ba,_panegauge);
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 40;BA.debugLine="Private mEventName As String			'ignore";
_meventname = "";
 //BA.debugLineNum = 41;BA.debugLine="Private mCallBack As Object				'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 44;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private BaseLabel As B4XView			'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 49;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 50;BA.debugLine="Private PaneGauge As B4XView";
_panegauge = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private CvsGauge As B4XCanvas";
_cvsgauge = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 54;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 60;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 61;BA.debugLine="Private mMin As Float";
_mmin = 0f;
 //BA.debugLineNum = 62;BA.debugLine="Private mMax As Float";
_mmax = 0f;
 //BA.debugLineNum = 63;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 64;BA.debugLine="Private mDigits As Int";
_mdigits = 0;
 //BA.debugLineNum = 65;BA.debugLine="Private mShowNeedle As Boolean";
_mshowneedle = false;
 //BA.debugLineNum = 66;BA.debugLine="Private mShowRangeLabels As Boolean";
_mshowrangelabels = false;
 //BA.debugLineNum = 67;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 70;BA.debugLine="Private mCx, mCy As Float";
_mcx = 0f;
_mcy = 0f;
 //BA.debugLineNum = 71;BA.debugLine="Private mRadius As Float";
_mradius = 0f;
 //BA.debugLineNum = 72;BA.debugLine="Private mMaskColor As Int";
_mmaskcolor = 0;
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 361;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 362;BA.debugLine="CallSub2(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew2(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue));
 };
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 81;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 82;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 83;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 84;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 85;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _labelfont = null;
int _labelcolor = 0;
int _yoffset = 0;
String _minstr = "";
String _maxstr = "";
float _needleangledeg = 0f;
float _pi = 0f;
float _needleanglerad = 0f;
float _needlelength = 0f;
float _nx2 = 0f;
float _ny2 = 0f;
 //BA.debugLineNum = 151;BA.debugLine="Public Sub DrawGauge(value As Float)";
 //BA.debugLineNum = 153;BA.debugLine="Dim startAngle As Float = 180	' Always start at 0";
_startangle = (float) (180);
 //BA.debugLineNum = 154;BA.debugLine="Dim totalSweep As Float = 180	' Max span from 09:";
_totalsweep = (float) (180);
 //BA.debugLineNum = 155;BA.debugLine="Dim sweepLength As Float		' How many degrees to d";
_sweeplength = 0f;
 //BA.debugLineNum = 156;BA.debugLine="Dim gaugeWidth As Int = 14dip";
_gaugewidth = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 157;BA.debugLine="Dim filled As Boolean = True";
_filled = __c.True;
 //BA.debugLineNum = 160;BA.debugLine="value = Max(mMin, Min(mMax, value))";
_value = (float) (__c.Max(_mmin,__c.Min(_mmax,_value)));
 //BA.debugLineNum = 163;BA.debugLine="CvsGauge.ClearRect(CvsGauge.TargetRect)";
_cvsgauge.ClearRect(_cvsgauge.getTargetRect());
 //BA.debugLineNum = 168;BA.debugLine="Dim track As B4XPath";
_track = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 169;BA.debugLine="track.InitializeArc(mCx, mCy, mRadius, startAngle";
_track.InitializeArc(_mcx,_mcy,_mradius,_startangle,_totalsweep);
 //BA.debugLineNum = 170;BA.debugLine="CvsGauge.DrawPath(track, HMITileUtils.COLOR_BORDE";
_cvsgauge.DrawPath(_track,_hmitileutils._color_border_dark /*int*/ ,_filled,(float) (0));
 //BA.debugLineNum = 175;BA.debugLine="sweepLength = totalSweep * (value - mMin) / (mMax";
_sweeplength = (float) (_totalsweep*(_value-_mmin)/(double)(_mmax-_mmin));
 //BA.debugLineNum = 176;BA.debugLine="Dim valueArc As B4XPath";
_valuearc = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 177;BA.debugLine="valueArc.InitializeArc(mCx, mCy, mRadius, startAn";
_valuearc.InitializeArc(_mcx,_mcy,_mradius,_startangle,_sweeplength);
 //BA.debugLineNum = 178;BA.debugLine="CvsGauge.DrawPath(valueArc, HMITileUtils.COLOR_TE";
_cvsgauge.DrawPath(_valuearc,_hmitileutils._color_text_primary /*int*/ ,_filled,(float) (0));
 //BA.debugLineNum = 184;BA.debugLine="CvsGauge.DrawCircle(mCx, mCy, mRadius - gaugeWidt";
_cvsgauge.DrawCircle(_mcx,_mcy,(float) (_mradius-_gaugewidth),_mmaskcolor,__c.True,(float) (0));
 //BA.debugLineNum = 189;BA.debugLine="If mShowRangeLabels Then";
if (_mshowrangelabels) { 
 //BA.debugLineNum = 190;BA.debugLine="Dim LabelFont As B4XFont	= xui.CreateDefaultFont";
_labelfont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_labelfont = _xui.CreateDefaultFont((float) (9));
 //BA.debugLineNum = 191;BA.debugLine="Dim LabelColor As Int 		= HMITileUtils.COLOR_TEX";
_labelcolor = _hmitileutils._color_text_info /*int*/ ;
 //BA.debugLineNum = 192;BA.debugLine="Dim YOffset As Int 			= 12dip";
_yoffset = __c.DipToCurrent((int) (12));
 //BA.debugLineNum = 195;BA.debugLine="Dim MinStr As String 		= NumberFormat(mMin, 1, 1";
_minstr = __c.NumberFormat(_mmin,(int) (1),(int) (1));
 //BA.debugLineNum = 196;BA.debugLine="Dim MaxStr As String 		= NumberFormat(mMax, 1, 1";
_maxstr = __c.NumberFormat(_mmax,(int) (1),(int) (1));
 //BA.debugLineNum = 199;BA.debugLine="CvsGauge.DrawText(MinStr, mCx - mRadius + (gauge";
_cvsgauge.DrawText(_minstr,_mcx-_mradius+(_gaugewidth/(double)2),_mcy+_yoffset,_labelfont,_labelcolor,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"CENTER"));
 //BA.debugLineNum = 202;BA.debugLine="CvsGauge.DrawText(MaxStr, mCx + mRadius - (gauge";
_cvsgauge.DrawText(_maxstr,_mcx+_mradius-(_gaugewidth/(double)2),_mcy+_yoffset,_labelfont,_labelcolor,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"CENTER"));
 };
 //BA.debugLineNum = 208;BA.debugLine="If mShowNeedle Then";
if (_mshowneedle) { 
 //BA.debugLineNum = 210;BA.debugLine="Dim needleAngleDeg As Float = startAngle + sweep";
_needleangledeg = (float) (_startangle+_sweeplength);
 //BA.debugLineNum = 213;BA.debugLine="Dim PI As Float = ACos(-1)";
_pi = (float) (__c.ACos(-1));
 //BA.debugLineNum = 214;BA.debugLine="Dim needleAngleRad As Float = needleAngleDeg * P";
_needleanglerad = (float) (_needleangledeg*_pi/(double)180);
 //BA.debugLineNum = 217;BA.debugLine="Dim needleLength As Float = mRadius + 2dip";
_needlelength = (float) (_mradius+__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 220;BA.debugLine="Dim nX2 As Float = mCx + (needleLength * Cos(nee";
_nx2 = (float) (_mcx+(_needlelength*__c.Cos(_needleanglerad)));
 //BA.debugLineNum = 221;BA.debugLine="Dim nY2 As Float = mCy + (needleLength * Sin(nee";
_ny2 = (float) (_mcy+(_needlelength*__c.Sin(_needleanglerad)));
 //BA.debugLineNum = 224;BA.debugLine="CvsGauge.DrawLine(mCx, mCy, nX2, nY2, xui.Color_";
_cvsgauge.DrawLine(_mcx,_mcy,_nx2,_ny2,_xui.Color_White,(float) (__c.DipToCurrent((int) (3))));
 };
 //BA.debugLineNum = 231;BA.debugLine="CvsGauge.Invalidate";
_cvsgauge.Invalidate();
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 296;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 297;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return false;
}
public float  _getmax() throws Exception{
 //BA.debugLineNum = 264;BA.debugLine="Public Sub getMax As Float";
 //BA.debugLineNum = 265;BA.debugLine="Return mMax";
if (true) return _mmax;
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return 0f;
}
public float  _getmin() throws Exception{
 //BA.debugLineNum = 256;BA.debugLine="Public Sub getMin As Float";
 //BA.debugLineNum = 257;BA.debugLine="Return mMin";
if (true) return _mmin;
 //BA.debugLineNum = 258;BA.debugLine="End Sub";
return 0f;
}
public boolean  _getshowneedle() throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Public Sub getShowNeedle As Boolean";
 //BA.debugLineNum = 281;BA.debugLine="Return mShowNeedle";
if (true) return _mshowneedle;
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowrangelabels() throws Exception{
 //BA.debugLineNum = 288;BA.debugLine="Public Sub getShowRangeLabels As Boolean";
 //BA.debugLineNum = 289;BA.debugLine="Return mShowRangeLabels";
if (true) return _mshowrangelabels;
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 322;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 323;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 324;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 238;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 272;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 273;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 249;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 75;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 76;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 77;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public String  _panegauge_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 349;BA.debugLine="Private Sub PaneGauge_MouseClicked (EventData As M";
 //BA.debugLineNum = 350;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public String  _redraw() throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Private Sub Redraw";
 //BA.debugLineNum = 136;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 137;BA.debugLine="DrawGauge(mValue)";
_drawgauge(_mvalue);
 };
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 292;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 293;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 294;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public String  _setmax(float _value) throws Exception{
 //BA.debugLineNum = 260;BA.debugLine="Public Sub setMax(value As Float)";
 //BA.debugLineNum = 261;BA.debugLine="mMax = value";
_mmax = _value;
 //BA.debugLineNum = 262;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return "";
}
public String  _setmin(float _value) throws Exception{
 //BA.debugLineNum = 252;BA.debugLine="Public Sub setMin(value As Float)";
 //BA.debugLineNum = 253;BA.debugLine="mMin = value";
_mmin = _value;
 //BA.debugLineNum = 254;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return "";
}
public String  _setshowneedle(boolean _value) throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Public Sub setShowNeedle(value As Boolean)";
 //BA.debugLineNum = 277;BA.debugLine="mShowNeedle = value";
_mshowneedle = _value;
 //BA.debugLineNum = 278;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return "";
}
public String  _setshowrangelabels(boolean _value) throws Exception{
 //BA.debugLineNum = 284;BA.debugLine="Public Sub setShowRangeLabels(value As Boolean)";
 //BA.debugLineNum = 285;BA.debugLine="mShowRangeLabels = value";
_mshowrangelabels = _value;
 //BA.debugLineNum = 286;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 318;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 319;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 320;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 321;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 234;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 235;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 236;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 268;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 269;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 270;BA.debugLine="LabelUnit.Text = mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 242;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 243;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 244;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 245;BA.debugLine="LabelValue.Text = NumberFormat2(mValue, 0, mDigi";
_labelvalue.setText(__c.NumberFormat2(_mvalue,(int) (0),_mdigits,(int) (0),__c.False));
 };
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 310;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 313;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 314;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 301;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 302;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 305;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 306;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
