package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilegaugesegments extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilegaugesegments", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilegaugesegments.class).invoke(this, new Object[] {null});
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
public String _munit = "";
public float _mmin = 0f;
public float _mmax = 0f;
public float _mwarningthreshold = 0f;
public float _malarmthreshold = 0f;
public int _mdigits = 0;
public boolean _mshowneedle = false;
public boolean _mshowrangelabels = false;
public String _mstatus = "";
public float _mcx = 0f;
public float _mcy = 0f;
public float _mradius = 0f;
public int _mmaskcolor = 0;
public anywheresoftware.b4a.objects.B4XCanvas _mcanvasindicator = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 94;BA.debugLine="BasePane.LoadLayout(\"hmitilegaugesegments\")";
_basepane.LoadLayout("hmitilegaugesegments",ba);
 //BA.debugLineNum = 97;BA.debugLine="mCanvasIndicator.Initialize(BasePane)";
_mcanvasindicator.Initialize(ba,_basepane);
 //BA.debugLineNum = 100;BA.debugLine="mTitle				= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 101;BA.debugLine="LabelTitle.Text 	= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 102;BA.debugLine="mValue				= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 103;BA.debugLine="LabelValue.Text 	= mValue";
_labelvalue.setText(BA.NumberToString(_mvalue));
 //BA.debugLineNum = 104;BA.debugLine="mMin				= Props.GetDefault(\"Min\", 0)";
_mmin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Min"),(Object)(0))));
 //BA.debugLineNum = 105;BA.debugLine="mMax				= Props.GetDefault(\"Max\", 100)";
_mmax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Max"),(Object)(100))));
 //BA.debugLineNum = 106;BA.debugLine="mWarningThreshold	= Props.GetDefault(\"WarningThre";
_mwarningthreshold = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("WarningThreshold"),(Object)(60))));
 //BA.debugLineNum = 107;BA.debugLine="mAlarmThreshold		= Props.GetDefault(\"AlarmThresho";
_malarmthreshold = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("AlarmThreshold"),(Object)(85))));
 //BA.debugLineNum = 108;BA.debugLine="mUnit				= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 109;BA.debugLine="LabelUnit.Text 		= mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 110;BA.debugLine="mDigits				= Props.GetDefault(\"Digits\", 0)";
_mdigits = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("Digits"),(Object)(0))));
 //BA.debugLineNum = 111;BA.debugLine="mShowNeedle			= Props.GetDefault(\"ShowNeedle\", Fa";
_mshowneedle = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowNeedle"),(Object)(__c.False)));
 //BA.debugLineNum = 112;BA.debugLine="mShowRangeLabels	= Props.GetDefault(\"ShowRangeLab";
_mshowrangelabels = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowRangeLabels"),(Object)(__c.False)));
 //BA.debugLineNum = 113;BA.debugLine="mStatus				= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 116;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 119;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 406;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 407;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 408;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 409;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 410;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 411;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 413;BA.debugLine="mMaskColor = BasePane.Color";
_mmaskcolor = _basepane.getColor();
 //BA.debugLineNum = 414;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 415;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 123;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 126;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0, 0,				Width,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 127;BA.debugLine="PaneGauge.SetLayoutAnimated		(0, 0, Height * 0.25";
_panegauge.SetLayoutAnimated((int) (0),0,_height*0.25,_width,_height*0.50);
 //BA.debugLineNum = 128;BA.debugLine="LabelValue.SetLayoutAnimated	(0, 0, Height * 0.55";
_labelvalue.SetLayoutAnimated((int) (0),0,_height*0.55,_width,_height*0.35);
 //BA.debugLineNum = 129;BA.debugLine="LabelUnit.SetLayoutAnimated		(0, 0, Height * 0.80";
_labelunit.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 132;BA.debugLine="mCx 	= PaneGauge.Width / 2";
_mcx = (float) (_panegauge.getWidth()/(double)2);
 //BA.debugLineNum = 133;BA.debugLine="mCy 	= PaneGauge.Height * 0.5";
_mcy = (float) (_panegauge.getHeight()*0.5);
 //BA.debugLineNum = 134;BA.debugLine="mRadius	= Min(mCx, mCy) * 0.9";
_mradius = (float) (__c.Min(_mcx,_mcy)*0.9);
 //BA.debugLineNum = 137;BA.debugLine="CvsGauge.Initialize(PaneGauge)";
_cvsgauge.Initialize(ba,_panegauge);
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 42;BA.debugLine="Private mEventName As String			'ignore";
_meventname = "";
 //BA.debugLineNum = 43;BA.debugLine="Private mCallBack As Object				'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 46;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private BaseLabel As B4XView			'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 51;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 52;BA.debugLine="Private PaneGauge As B4XView";
_panegauge = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private CvsGauge As B4XCanvas";
_cvsgauge = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 56;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 62;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 63;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 64;BA.debugLine="Private mMin As Float";
_mmin = 0f;
 //BA.debugLineNum = 65;BA.debugLine="Private mMax As Float";
_mmax = 0f;
 //BA.debugLineNum = 66;BA.debugLine="Private mWarningThreshold As Float";
_mwarningthreshold = 0f;
 //BA.debugLineNum = 67;BA.debugLine="Private mAlarmThreshold As Float";
_malarmthreshold = 0f;
 //BA.debugLineNum = 68;BA.debugLine="Private mDigits As Int";
_mdigits = 0;
 //BA.debugLineNum = 69;BA.debugLine="Private mShowNeedle As Boolean";
_mshowneedle = false;
 //BA.debugLineNum = 70;BA.debugLine="Private mShowRangeLabels As Boolean";
_mshowrangelabels = false;
 //BA.debugLineNum = 71;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 74;BA.debugLine="Private mCx, mCy As Float";
_mcx = 0f;
_mcy = 0f;
 //BA.debugLineNum = 75;BA.debugLine="Private mRadius As Float";
_mradius = 0f;
 //BA.debugLineNum = 76;BA.debugLine="Private mMaskColor As Int";
_mmaskcolor = 0;
 //BA.debugLineNum = 77;BA.debugLine="Private mCanvasIndicator As B4XCanvas";
_mcanvasindicator = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 435;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 436;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 437;BA.debugLine="CallSub2(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew2(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue));
 };
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 86;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 87;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 88;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 89;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 90;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public String  _drawgauge(float _value) throws Exception{
float _startangle = 0f;
float _totalsweep = 0f;
int _gaugewidth = 0;
boolean _filled = false;
float _angleperunit = 0f;
int _colornormalactive = 0;
int _colorwarningactive = 0;
int _coloralarmactive = 0;
int _colornormalmuted = 0;
int _colorwarningmuted = 0;
int _coloralarmmuted = 0;
float _bgcursor = 0f;
float _sweepbgnormal = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _arcbgnormal = null;
float _sweepbgwarning = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _arcbgwarning = null;
float _sweepbgcritical = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _arcbgcritical = null;
float _activecursor = 0f;
float _normalmax = 0f;
float _sweepnormal = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _arcnormal = null;
float _warningmax = 0f;
float _sweepwarning = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _arcwarning = null;
float _criticalmax = 0f;
float _sweepcritical = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _arccritical = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _labelfont = null;
int _labelcolor = 0;
int _yoffset = 0;
String _minstr = "";
String _maxstr = "";
float _sweeplength = 0f;
float _needleangledeg = 0f;
float _pi = 0f;
float _needleanglerad = 0f;
float _needlelength = 0f;
float _nx2 = 0f;
float _ny2 = 0f;
 //BA.debugLineNum = 161;BA.debugLine="Public Sub DrawGauge(value As Float)";
 //BA.debugLineNum = 163;BA.debugLine="Dim startAngle As Float = 180	' Always start at 0";
_startangle = (float) (180);
 //BA.debugLineNum = 164;BA.debugLine="Dim totalSweep As Float = 180	' Max span from 09:";
_totalsweep = (float) (180);
 //BA.debugLineNum = 165;BA.debugLine="Dim gaugeWidth As Int = 14dip";
_gaugewidth = __c.DipToCurrent((int) (14));
 //BA.debugLineNum = 166;BA.debugLine="Dim filled As Boolean = True";
_filled = __c.True;
 //BA.debugLineNum = 169;BA.debugLine="value = Max(mMin, Min(mMax, value))";
_value = (float) (__c.Max(_mmin,__c.Min(_mmax,_value)));
 //BA.debugLineNum = 172;BA.debugLine="CvsGauge.ClearRect(CvsGauge.TargetRect)";
_cvsgauge.ClearRect(_cvsgauge.getTargetRect());
 //BA.debugLineNum = 175;BA.debugLine="Dim AnglePerUnit As Float = totalSweep / (mMax -";
_angleperunit = (float) (_totalsweep/(double)(_mmax-_mmin));
 //BA.debugLineNum = 178;BA.debugLine="Dim ColorNormalActive As Int	= HMITileUtils.COLOR";
_colornormalactive = _hmitileutils._color_indicator_level /*int*/ ;
 //BA.debugLineNum = 179;BA.debugLine="Dim ColorWarningActive As Int	= HMITileUtils.COLO";
_colorwarningactive = _hmitileutils._color_gaugesegments_warning_active /*int*/ ;
 //BA.debugLineNum = 180;BA.debugLine="Dim ColorAlarmActive As Int		= HMITileUtils.COLOR";
_coloralarmactive = _hmitileutils._color_gaugesegments_alarm_active /*int*/ ;
 //BA.debugLineNum = 183;BA.debugLine="Dim ColorNormalMuted As Int 	= HMITileUtils.COLOR";
_colornormalmuted = _hmitileutils._color_indicator_track /*int*/ ;
 //BA.debugLineNum = 184;BA.debugLine="Dim ColorWarningMuted As Int 	= HMITileUtils.COLO";
_colorwarningmuted = _hmitileutils._color_gaugesegments_warning_muted /*int*/ ;
 //BA.debugLineNum = 185;BA.debugLine="Dim ColorAlarmMuted As Int 		= HMITileUtils.COLOR";
_coloralarmmuted = _hmitileutils._color_gaugesegments_alarm_muted /*int*/ ;
 //BA.debugLineNum = 190;BA.debugLine="Dim BgCursor As Float = startAngle";
_bgcursor = _startangle;
 //BA.debugLineNum = 193;BA.debugLine="Dim SweepBgNormal As Float = (mWarningThreshold -";
_sweepbgnormal = (float) ((_mwarningthreshold-_mmin)*_angleperunit);
 //BA.debugLineNum = 194;BA.debugLine="Dim ArcBgNormal As B4XPath";
_arcbgnormal = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 195;BA.debugLine="ArcBgNormal.InitializeArc(mCx, mCy, mRadius, BgCu";
_arcbgnormal.InitializeArc(_mcx,_mcy,_mradius,_bgcursor,_sweepbgnormal);
 //BA.debugLineNum = 196;BA.debugLine="CvsGauge.DrawPath(ArcBgNormal, ColorNormalMuted,";
_cvsgauge.DrawPath(_arcbgnormal,_colornormalmuted,_filled,(float) (0));
 //BA.debugLineNum = 197;BA.debugLine="BgCursor = BgCursor + SweepBgNormal";
_bgcursor = (float) (_bgcursor+_sweepbgnormal);
 //BA.debugLineNum = 200;BA.debugLine="Dim SweepBgWarning As Float = (mAlarmThreshold -";
_sweepbgwarning = (float) ((_malarmthreshold-_mwarningthreshold)*_angleperunit);
 //BA.debugLineNum = 201;BA.debugLine="Dim ArcBgWarning As B4XPath";
_arcbgwarning = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 202;BA.debugLine="ArcBgWarning.InitializeArc(mCx, mCy, mRadius, BgC";
_arcbgwarning.InitializeArc(_mcx,_mcy,_mradius,_bgcursor,_sweepbgwarning);
 //BA.debugLineNum = 203;BA.debugLine="CvsGauge.DrawPath(ArcBgWarning, ColorWarningMuted";
_cvsgauge.DrawPath(_arcbgwarning,_colorwarningmuted,_filled,(float) (0));
 //BA.debugLineNum = 204;BA.debugLine="BgCursor = BgCursor + SweepBgWarning";
_bgcursor = (float) (_bgcursor+_sweepbgwarning);
 //BA.debugLineNum = 207;BA.debugLine="Dim SweepBgCritical As Float = (mMax - mAlarmThre";
_sweepbgcritical = (float) ((_mmax-_malarmthreshold)*_angleperunit);
 //BA.debugLineNum = 208;BA.debugLine="Dim ArcBgCritical As B4XPath";
_arcbgcritical = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 209;BA.debugLine="ArcBgCritical.InitializeArc(mCx, mCy, mRadius, Bg";
_arcbgcritical.InitializeArc(_mcx,_mcy,_mradius,_bgcursor,_sweepbgcritical);
 //BA.debugLineNum = 210;BA.debugLine="CvsGauge.DrawPath(ArcBgCritical, ColorAlarmMuted,";
_cvsgauge.DrawPath(_arcbgcritical,_coloralarmmuted,_filled,(float) (0));
 //BA.debugLineNum = 215;BA.debugLine="Dim ActiveCursor As Float = startAngle";
_activecursor = _startangle;
 //BA.debugLineNum = 218;BA.debugLine="Dim NormalMax As Float = Min(value, mWarningThres";
_normalmax = (float) (__c.Min(_value,_mwarningthreshold));
 //BA.debugLineNum = 219;BA.debugLine="If NormalMax > mMin Then";
if (_normalmax>_mmin) { 
 //BA.debugLineNum = 220;BA.debugLine="Dim SweepNormal As Float = (NormalMax - mMin) *";
_sweepnormal = (float) ((_normalmax-_mmin)*_angleperunit);
 //BA.debugLineNum = 221;BA.debugLine="Dim ArcNormal As B4XPath";
_arcnormal = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 222;BA.debugLine="ArcNormal.InitializeArc(mCx, mCy, mRadius, Activ";
_arcnormal.InitializeArc(_mcx,_mcy,_mradius,_activecursor,_sweepnormal);
 //BA.debugLineNum = 223;BA.debugLine="CvsGauge.DrawPath(ArcNormal, ColorNormalActive,";
_cvsgauge.DrawPath(_arcnormal,_colornormalactive,_filled,(float) (0));
 //BA.debugLineNum = 224;BA.debugLine="ActiveCursor = ActiveCursor + SweepNormal";
_activecursor = (float) (_activecursor+_sweepnormal);
 //BA.debugLineNum = 225;BA.debugLine="StatusNormal";
_statusnormal();
 };
 //BA.debugLineNum = 229;BA.debugLine="If value > mWarningThreshold Then";
if (_value>_mwarningthreshold) { 
 //BA.debugLineNum = 230;BA.debugLine="Dim WarningMax As Float = Min(value, mAlarmThres";
_warningmax = (float) (__c.Min(_value,_malarmthreshold));
 //BA.debugLineNum = 231;BA.debugLine="Dim SweepWarning As Float = (WarningMax - mWarni";
_sweepwarning = (float) ((_warningmax-_mwarningthreshold)*_angleperunit);
 //BA.debugLineNum = 232;BA.debugLine="Dim ArcWarning As B4XPath";
_arcwarning = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 233;BA.debugLine="ArcWarning.InitializeArc(mCx, mCy, mRadius, Acti";
_arcwarning.InitializeArc(_mcx,_mcy,_mradius,_activecursor,_sweepwarning);
 //BA.debugLineNum = 234;BA.debugLine="CvsGauge.DrawPath(ArcWarning, ColorWarningActive";
_cvsgauge.DrawPath(_arcwarning,_colorwarningactive,_filled,(float) (0));
 //BA.debugLineNum = 235;BA.debugLine="ActiveCursor = ActiveCursor + SweepWarning";
_activecursor = (float) (_activecursor+_sweepwarning);
 //BA.debugLineNum = 236;BA.debugLine="StatusWarning";
_statuswarning();
 };
 //BA.debugLineNum = 240;BA.debugLine="If value > mAlarmThreshold Then";
if (_value>_malarmthreshold) { 
 //BA.debugLineNum = 241;BA.debugLine="Dim CriticalMax As Float = Min(value, mMax)";
_criticalmax = (float) (__c.Min(_value,_mmax));
 //BA.debugLineNum = 242;BA.debugLine="Dim SweepCritical As Float = (CriticalMax - mAla";
_sweepcritical = (float) ((_criticalmax-_malarmthreshold)*_angleperunit);
 //BA.debugLineNum = 243;BA.debugLine="Dim ArcCritical As B4XPath";
_arccritical = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 244;BA.debugLine="ArcCritical.InitializeArc(mCx, mCy, mRadius, Act";
_arccritical.InitializeArc(_mcx,_mcy,_mradius,_activecursor,_sweepcritical);
 //BA.debugLineNum = 245;BA.debugLine="CvsGauge.DrawPath(ArcCritical, ColorAlarmActive,";
_cvsgauge.DrawPath(_arccritical,_coloralarmactive,_filled,(float) (0));
 //BA.debugLineNum = 246;BA.debugLine="StatusAlarm";
_statusalarm();
 };
 //BA.debugLineNum = 253;BA.debugLine="CvsGauge.DrawCircle(mCx, mCy, mRadius - gaugeWidt";
_cvsgauge.DrawCircle(_mcx,_mcy,(float) (_mradius-_gaugewidth),_mmaskcolor,__c.True,(float) (0));
 //BA.debugLineNum = 258;BA.debugLine="If mShowRangeLabels Then";
if (_mshowrangelabels) { 
 //BA.debugLineNum = 259;BA.debugLine="Dim LabelFont As B4XFont	= xui.CreateDefaultFont";
_labelfont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_labelfont = _xui.CreateDefaultFont((float) (9));
 //BA.debugLineNum = 260;BA.debugLine="Dim LabelColor As Int 		= HMITileUtils.COLOR_TEX";
_labelcolor = _hmitileutils._color_text_info /*int*/ ;
 //BA.debugLineNum = 261;BA.debugLine="Dim YOffset As Int 			= 12dip";
_yoffset = __c.DipToCurrent((int) (12));
 //BA.debugLineNum = 263;BA.debugLine="Dim MinStr As String = NumberFormat(mMin, 1, 1)";
_minstr = __c.NumberFormat(_mmin,(int) (1),(int) (1));
 //BA.debugLineNum = 264;BA.debugLine="Dim MaxStr As String = NumberFormat(mMax, 1, 1)";
_maxstr = __c.NumberFormat(_mmax,(int) (1),(int) (1));
 //BA.debugLineNum = 266;BA.debugLine="CvsGauge.DrawText(MinStr, mCx - mRadius + (gauge";
_cvsgauge.DrawText(_minstr,_mcx-_mradius+(_gaugewidth/(double)2),_mcy+_yoffset,_labelfont,_labelcolor,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"CENTER"));
 //BA.debugLineNum = 267;BA.debugLine="CvsGauge.DrawText(MaxStr, mCx + mRadius - (gauge";
_cvsgauge.DrawText(_maxstr,_mcx+_mradius-(_gaugewidth/(double)2),_mcy+_yoffset,_labelfont,_labelcolor,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"CENTER"));
 };
 //BA.debugLineNum = 273;BA.debugLine="If mShowNeedle Then";
if (_mshowneedle) { 
 //BA.debugLineNum = 274;BA.debugLine="Dim sweepLength As Float = totalSweep * (value -";
_sweeplength = (float) (_totalsweep*(_value-_mmin)/(double)(_mmax-_mmin));
 //BA.debugLineNum = 275;BA.debugLine="Dim needleAngleDeg As Float = startAngle + sweep";
_needleangledeg = (float) (_startangle+_sweeplength);
 //BA.debugLineNum = 277;BA.debugLine="Dim PI As Float = ACos(-1)";
_pi = (float) (__c.ACos(-1));
 //BA.debugLineNum = 278;BA.debugLine="Dim needleAngleRad As Float = needleAngleDeg * P";
_needleanglerad = (float) (_needleangledeg*_pi/(double)180);
 //BA.debugLineNum = 280;BA.debugLine="Dim needleLength As Float = mRadius + 2dip";
_needlelength = (float) (_mradius+__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 282;BA.debugLine="Dim nX2 As Float = mCx + (needleLength * Cos(nee";
_nx2 = (float) (_mcx+(_needlelength*__c.Cos(_needleanglerad)));
 //BA.debugLineNum = 283;BA.debugLine="Dim nY2 As Float = mCy + (needleLength * Sin(nee";
_ny2 = (float) (_mcy+(_needlelength*__c.Sin(_needleanglerad)));
 //BA.debugLineNum = 286;BA.debugLine="CvsGauge.DrawLine(mCx, mCy, nX2, nY2, xui.Color_";
_cvsgauge.DrawLine(_mcx,_mcy,_nx2,_ny2,_xui.Color_White,(float) (__c.DipToCurrent((int) (3))));
 };
 //BA.debugLineNum = 290;BA.debugLine="CvsGauge.Invalidate";
_cvsgauge.Invalidate();
 //BA.debugLineNum = 291;BA.debugLine="End Sub";
return "";
}
public float  _getalarmthreshold() throws Exception{
 //BA.debugLineNum = 339;BA.debugLine="Public Sub getAlarmThreshold As Float";
 //BA.debugLineNum = 340;BA.debugLine="Return mAlarmThreshold";
if (true) return _malarmthreshold;
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return 0f;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 372;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return false;
}
public float  _getmax() throws Exception{
 //BA.debugLineNum = 323;BA.debugLine="Public Sub getMax As Float";
 //BA.debugLineNum = 324;BA.debugLine="Return mMax";
if (true) return _mmax;
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
return 0f;
}
public float  _getmin() throws Exception{
 //BA.debugLineNum = 315;BA.debugLine="Public Sub getMin As Float";
 //BA.debugLineNum = 316;BA.debugLine="Return mMin";
if (true) return _mmin;
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return 0f;
}
public boolean  _getshowneedle() throws Exception{
 //BA.debugLineNum = 355;BA.debugLine="Public Sub getShowNeedle As Boolean";
 //BA.debugLineNum = 356;BA.debugLine="Return mShowNeedle";
if (true) return _mshowneedle;
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowrangelabels() throws Exception{
 //BA.debugLineNum = 363;BA.debugLine="Public Sub getShowRangeLabels As Boolean";
 //BA.debugLineNum = 364;BA.debugLine="Return mShowRangeLabels";
if (true) return _mshowrangelabels;
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 397;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 398;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 296;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 297;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 347;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 348;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 307;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 308;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return 0f;
}
public float  _getwarningthreshold() throws Exception{
 //BA.debugLineNum = 331;BA.debugLine="Public Sub getWarningThreshold As Float";
 //BA.debugLineNum = 332;BA.debugLine="Return mWarningThreshold";
if (true) return _mwarningthreshold;
 //BA.debugLineNum = 333;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 80;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 81;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 82;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public String  _panegauge_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 424;BA.debugLine="Private Sub PaneGauge_MouseClicked (EventData As M";
 //BA.debugLineNum = 425;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 426;BA.debugLine="End Sub";
return "";
}
public String  _redraw() throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Private Sub Redraw";
 //BA.debugLineNum = 147;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 148;BA.debugLine="DrawGauge(mValue)";
_drawgauge(_mvalue);
 };
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _setalarmthreshold(float _value) throws Exception{
 //BA.debugLineNum = 335;BA.debugLine="Public Sub setAlarmThreshold(value As Float)";
 //BA.debugLineNum = 336;BA.debugLine="mAlarmThreshold = value";
_malarmthreshold = _value;
 //BA.debugLineNum = 337;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 338;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 367;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 368;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 369;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 370;BA.debugLine="End Sub";
return "";
}
public String  _setmax(float _value) throws Exception{
 //BA.debugLineNum = 319;BA.debugLine="Public Sub setMax(value As Float)";
 //BA.debugLineNum = 320;BA.debugLine="mMax = value";
_mmax = _value;
 //BA.debugLineNum = 321;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public String  _setmin(float _value) throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Public Sub setMin(value As Float)";
 //BA.debugLineNum = 312;BA.debugLine="mMin = value";
_mmin = _value;
 //BA.debugLineNum = 313;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return "";
}
public String  _setshowneedle(boolean _value) throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Public Sub setShowNeedle(value As Boolean)";
 //BA.debugLineNum = 352;BA.debugLine="mShowNeedle = value";
_mshowneedle = _value;
 //BA.debugLineNum = 353;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public String  _setshowrangelabels(boolean _value) throws Exception{
 //BA.debugLineNum = 359;BA.debugLine="Public Sub setShowRangeLabels(value As Boolean)";
 //BA.debugLineNum = 360;BA.debugLine="mShowRangeLabels = value";
_mshowrangelabels = _value;
 //BA.debugLineNum = 361;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 393;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 394;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 395;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 396;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 293;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 294;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 343;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 344;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 345;BA.debugLine="LabelUnit.Text = mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 300;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 301;BA.debugLine="If PaneGauge.IsInitialized Then";
if (_panegauge.IsInitialized()) { 
 //BA.debugLineNum = 302;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 303;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 304;BA.debugLine="LabelValue.Text = NumberFormat2(mValue, 0, mDigi";
_labelvalue.setText(__c.NumberFormat2(_mvalue,(int) (0),_mdigits,(int) (0),__c.False));
 };
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return "";
}
public String  _setwarningthreshold(float _value) throws Exception{
 //BA.debugLineNum = 327;BA.debugLine="Public Sub setWarningThreshold(value As Float)";
 //BA.debugLineNum = 328;BA.debugLine="mWarningThreshold = value";
_mwarningthreshold = _value;
 //BA.debugLineNum = 329;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 384;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 385;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 386;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 388;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 389;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 390;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 376;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 377;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 381;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
