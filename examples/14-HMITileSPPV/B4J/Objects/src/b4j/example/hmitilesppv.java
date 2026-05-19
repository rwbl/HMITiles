package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilesppv extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilesppv", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilesppv.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _panetile = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelpv = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelsp = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelminus = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelplus = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeldeviation = null;
public String _mtitle = "";
public float _mpv = 0f;
public float _msp = 0f;
public float _mstepsize = 0f;
public float _mmin = 0f;
public float _mmax = 0f;
public int _mdigits = 0;
public float _mdeviationwarning = 0f;
public float _mdeviationalarm = 0f;
public boolean _mshowdeviation = false;
public float _mdeviation = 0f;
public boolean _meditmode = false;
public String _mstatus = "";
public anywheresoftware.b4a.objects.B4XCanvas _mcanvasseperator = null;
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
 //BA.debugLineNum = 118;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 119;BA.debugLine="BasePane.LoadLayout(\"hmitilesppv\")";
_basepane.LoadLayout("hmitilesppv",ba);
 //BA.debugLineNum = 121;BA.debugLine="mTitle					= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 122;BA.debugLine="LabelTitle.Text			= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 125;BA.debugLine="mMin 					= Props.GetDefault(\"Min\", 0)";
_mmin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Min"),(Object)(0))));
 //BA.debugLineNum = 126;BA.debugLine="mMax 					= Props.GetDefault(\"Max\", 100)";
_mmax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Max"),(Object)(100))));
 //BA.debugLineNum = 127;BA.debugLine="mStepSize 				= Props.GetDefault(\"StepSize\", 1)";
_mstepsize = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("StepSize"),(Object)(1))));
 //BA.debugLineNum = 128;BA.debugLine="mShowDeviation			= Props.GetDefault(\"ShowDeviatio";
_mshowdeviation = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowDeviation"),(Object)(__c.False)));
 //BA.debugLineNum = 129;BA.debugLine="LabelDeviation.Visible 	= mShowDeviation";
_labeldeviation.setVisible(_mshowdeviation);
 //BA.debugLineNum = 130;BA.debugLine="mDeviationWarning		= Props.GetDefault(\"DeviationW";
_mdeviationwarning = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("DeviationWarning"),(Object)(60))));
 //BA.debugLineNum = 131;BA.debugLine="mDeviationAlarm			= Props.GetDefault(\"DeviationAl";
_mdeviationalarm = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("DeviationAlarm"),(Object)(85))));
 //BA.debugLineNum = 132;BA.debugLine="mDigits					= Props.GetDefault(\"Digits\", 0)";
_mdigits = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("Digits"),(Object)(0))));
 //BA.debugLineNum = 133;BA.debugLine="mEditMode				= Props.GetDefault(\"EditMode\", True)";
_meditmode = BA.ObjectToBoolean(_props.GetDefault((Object)("EditMode"),(Object)(__c.True)));
 //BA.debugLineNum = 134;BA.debugLine="setEditMode(mEditMode)";
_seteditmode(_meditmode);
 //BA.debugLineNum = 135;BA.debugLine="mStatus					= HMITileUtils.STATUS_NORMAL";
_mstatus = _hmitileutils._status_normal /*String*/ ;
 //BA.debugLineNum = 136;BA.debugLine="mPV						= Props.GetDefault(\"PV\", 0)";
_mpv = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("PV"),(Object)(0))));
 //BA.debugLineNum = 137;BA.debugLine="LabelPV.Text 			= NumberFormat(mPV, 0, mDigits)";
_labelpv.setText(__c.NumberFormat(_mpv,(int) (0),_mdigits));
 //BA.debugLineNum = 138;BA.debugLine="mSP						= Props.GetDefault(\"SP\", 100)";
_msp = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("SP"),(Object)(100))));
 //BA.debugLineNum = 141;BA.debugLine="mCanvasSeperator.Initialize(BasePane)";
_mcanvasseperator.Initialize(ba,_basepane);
 //BA.debugLineNum = 142;BA.debugLine="mCanvasIndicator.Initialize(BasePane)";
_mcanvasindicator.Initialize(ba,_basepane);
 //BA.debugLineNum = 144;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 145;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 146;BA.debugLine="UpdateSPPV";
_updatesppv();
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 385;BA.debugLine="Public Sub ApplyStyle";
 //BA.debugLineNum = 386;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 387;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 388;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelPV)";
_hmitileutils._applyvaluestyle /*String*/ (_labelpv);
 //BA.debugLineNum = 389;BA.debugLine="HMITileUtils.ApplyLabelStyle(LabelSP)";
_hmitileutils._applylabelstyle /*String*/ (_labelsp);
 //BA.debugLineNum = 390;BA.debugLine="HMITileUtils.ApplyFontAwesomeStyle(LabelMinus)";
_hmitileutils._applyfontawesomestyle /*String*/ (_labelminus);
 //BA.debugLineNum = 391;BA.debugLine="HMITileUtils.ApplyFontAwesomeStyle(LabelPlus)";
_hmitileutils._applyfontawesomestyle /*String*/ (_labelplus);
 //BA.debugLineNum = 392;BA.debugLine="HMITileUtils.ApplySubInfoStyle(LabelDeviation)";
_hmitileutils._applysubinfostyle /*String*/ (_labeldeviation);
 //BA.debugLineNum = 393;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
double _h = 0;
 //BA.debugLineNum = 149;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 150;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 153;BA.debugLine="PaneTile.SetLayoutAnimated			(0, 0, 						0,";
_panetile.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 154;BA.debugLine="LabelTitle.SetLayoutAnimated		(0, 0,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 155;BA.debugLine="LabelPV.SetLayoutAnimated			(0, 0,";
_labelpv.SetLayoutAnimated((int) (0),0,_height*0.30,_width,_height*0.25);
 //BA.debugLineNum = 156;BA.debugLine="LabelMinus.SetLayoutAnimated		(0, 0,";
_labelminus.SetLayoutAnimated((int) (0),0,_height*0.60,_width*0.25,_height*0.20);
 //BA.debugLineNum = 157;BA.debugLine="LabelSP.SetLayoutAnimated			(0, Width * 0.25,";
_labelsp.SetLayoutAnimated((int) (0),_width*0.25,_height*0.55,_width*0.50,_height*0.25);
 //BA.debugLineNum = 158;BA.debugLine="LabelPlus.SetLayoutAnimated			(0, Width - (Width";
_labelplus.SetLayoutAnimated((int) (0),_width-(_width*0.25),_height*0.60,_width*0.25,_height*0.20);
 //BA.debugLineNum = 159;BA.debugLine="LabelDeviation.SetLayoutAnimated	(0, 0,";
_labeldeviation.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 162;BA.debugLine="Dim h As Double = Height * 0.55";
_h = _height*0.55;
 //BA.debugLineNum = 163;BA.debugLine="mCanvasSeperator.DrawLine(0, h, Width, h, xui.Col";
_mcanvasseperator.DrawLine((float) (0),(float) (_h),(float) (_width),(float) (_h),_xui.Color_White,(float) (2));
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 66;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 67;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 70;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private BaseLabel As B4XView	'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 75;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 76;BA.debugLine="Private PaneTile As B4XView";
_panetile = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private LabelPV As B4XView";
_labelpv = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private LabelSP As B4XView";
_labelsp = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private LabelMinus As B4XView";
_labelminus = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private LabelPlus As B4XView";
_labelplus = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 82;BA.debugLine="Private LabelDeviation As B4XView";
_labeldeviation = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 85;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 86;BA.debugLine="Private mPV As Float";
_mpv = 0f;
 //BA.debugLineNum = 87;BA.debugLine="Private mSP As Float";
_msp = 0f;
 //BA.debugLineNum = 88;BA.debugLine="Private mStepSize As Float";
_mstepsize = 0f;
 //BA.debugLineNum = 89;BA.debugLine="Private mMin As Float";
_mmin = 0f;
 //BA.debugLineNum = 90;BA.debugLine="Private mMax As Float";
_mmax = 0f;
 //BA.debugLineNum = 91;BA.debugLine="Private mDigits As Int";
_mdigits = 0;
 //BA.debugLineNum = 92;BA.debugLine="Private mDeviationWarning As Float";
_mdeviationwarning = 0f;
 //BA.debugLineNum = 93;BA.debugLine="Private mDeviationAlarm As Float";
_mdeviationalarm = 0f;
 //BA.debugLineNum = 94;BA.debugLine="Private mShowDeviation As Boolean";
_mshowdeviation = false;
 //BA.debugLineNum = 95;BA.debugLine="Private mDeviation As Float";
_mdeviation = 0f;
 //BA.debugLineNum = 96;BA.debugLine="Private mEditMode As Boolean";
_meditmode = false;
 //BA.debugLineNum = 97;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 100;BA.debugLine="Private mCanvasSeperator As B4XCanvas";
_mcanvasseperator = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 101;BA.debugLine="Private mCanvasIndicator As B4XCanvas";
_mcanvasindicator = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 110;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 111;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 112;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 113;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 115;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public float  _deviation() throws Exception{
 //BA.debugLineNum = 257;BA.debugLine="Public Sub Deviation As Float";
 //BA.debugLineNum = 258;BA.debugLine="Return mDeviation";
if (true) return _mdeviation;
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return 0f;
}
public double  _getdeviationalarm() throws Exception{
 //BA.debugLineNum = 284;BA.debugLine="Public Sub getDeviationAlarm As Double";
 //BA.debugLineNum = 285;BA.debugLine="Return mDeviationAlarm";
if (true) return _mdeviationalarm;
 //BA.debugLineNum = 286;BA.debugLine="End Sub";
return 0;
}
public double  _getdeviationwarning() throws Exception{
 //BA.debugLineNum = 275;BA.debugLine="Public Sub getDeviationWarning As Double";
 //BA.debugLineNum = 276;BA.debugLine="Return mDeviationWarning";
if (true) return _mdeviationwarning;
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return 0;
}
public int  _getdigits() throws Exception{
 //BA.debugLineNum = 293;BA.debugLine="Public Sub getDigits As Int";
 //BA.debugLineNum = 294;BA.debugLine="Return mDigits";
if (true) return _mdigits;
 //BA.debugLineNum = 295;BA.debugLine="End Sub";
return 0;
}
public boolean  _geteditmode() throws Exception{
 //BA.debugLineNum = 337;BA.debugLine="Public Sub getEditMode As Boolean";
 //BA.debugLineNum = 338;BA.debugLine="Return mEditMode";
if (true) return _meditmode;
 //BA.debugLineNum = 339;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 326;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 327;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return false;
}
public float  _getmax() throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Public Sub getMax As Float";
 //BA.debugLineNum = 310;BA.debugLine="Return mMax";
if (true) return _mmax;
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return 0f;
}
public float  _getmin() throws Exception{
 //BA.debugLineNum = 301;BA.debugLine="Public Sub getMin As Float";
 //BA.debugLineNum = 302;BA.debugLine="Return mMin";
if (true) return _mmin;
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return 0f;
}
public float  _getpv() throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Public Sub getPV As Float";
 //BA.debugLineNum = 227;BA.debugLine="Return mPV";
if (true) return _mpv;
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return 0f;
}
public boolean  _getshowdeviation() throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Public Sub getShowDeviation As Boolean";
 //BA.debugLineNum = 267;BA.debugLine="Return mShowDeviation";
if (true) return _mshowdeviation;
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return false;
}
public float  _getsp() throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Public Sub getSP As Float";
 //BA.debugLineNum = 242;BA.debugLine="Return mSP";
if (true) return _msp;
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return 0f;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 374;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 375;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
return "";
}
public float  _getstepsize() throws Exception{
 //BA.debugLineNum = 317;BA.debugLine="Public Sub getStepSize As Float";
 //BA.debugLineNum = 318;BA.debugLine="Return mStepSize";
if (true) return _mstepsize;
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return 0f;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 215;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 104;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 105;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 106;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _labelminus_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 418;BA.debugLine="Private Sub LabelMinus_MouseClicked (EventData As";
 //BA.debugLineNum = 419;BA.debugLine="StepMinus";
_stepminus();
 //BA.debugLineNum = 420;BA.debugLine="End Sub";
return "";
}
public String  _labelplus_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 422;BA.debugLine="Private Sub LabelPlus_MouseClicked (EventData As M";
 //BA.debugLineNum = 423;BA.debugLine="StepPlus";
_stepplus();
 //BA.debugLineNum = 424;BA.debugLine="End Sub";
return "";
}
public String  _labelsp_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 426;BA.debugLine="Private Sub LabelSP_MouseClicked (EventData As Mou";
 //BA.debugLineNum = 427;BA.debugLine="setEditMode(Not(mEditMode))";
_seteditmode(__c.Not(_meditmode));
 //BA.debugLineNum = 428;BA.debugLine="End Sub";
return "";
}
public String  _setdeviationalarm(double _value) throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Public Sub setDeviationAlarm(value As Double)";
 //BA.debugLineNum = 281;BA.debugLine="mDeviationAlarm = value";
_mdeviationalarm = (float) (_value);
 //BA.debugLineNum = 282;BA.debugLine="UpdateSPPV";
_updatesppv();
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}
public String  _setdeviationwarning(double _value) throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Public Sub setDeviationWarning(value As Double)";
 //BA.debugLineNum = 272;BA.debugLine="mDeviationWarning = value";
_mdeviationwarning = (float) (_value);
 //BA.debugLineNum = 273;BA.debugLine="UpdateSPPV";
_updatesppv();
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public String  _setdigits(int _value) throws Exception{
 //BA.debugLineNum = 289;BA.debugLine="Public Sub setDigits(value As Int)";
 //BA.debugLineNum = 290;BA.debugLine="If value < 0 Then value = 0";
if (_value<0) { 
_value = (int) (0);};
 //BA.debugLineNum = 291;BA.debugLine="mDigits = value";
_mdigits = _value;
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public String  _seteditmode(boolean _state) throws Exception{
 //BA.debugLineNum = 332;BA.debugLine="Public Sub setEditMode(state As Boolean)";
 //BA.debugLineNum = 333;BA.debugLine="mEditMode = state";
_meditmode = _state;
 //BA.debugLineNum = 334;BA.debugLine="LabelMinus.Visible 	= mEditMode";
_labelminus.setVisible(_meditmode);
 //BA.debugLineNum = 335;BA.debugLine="LabelPlus.Visible	= mEditMode";
_labelplus.setVisible(_meditmode);
 //BA.debugLineNum = 336;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 322;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 323;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 324;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
return "";
}
public String  _setmax(float _value) throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Public Sub setMax(value As Float)";
 //BA.debugLineNum = 307;BA.debugLine="mMax = value";
_mmax = _value;
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public String  _setmin(float _value) throws Exception{
 //BA.debugLineNum = 298;BA.debugLine="Public Sub setMin(value As Float)";
 //BA.debugLineNum = 299;BA.debugLine="mMin = value";
_mmin = _value;
 //BA.debugLineNum = 300;BA.debugLine="End Sub";
return "";
}
public String  _setpv(float _value) throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Public Sub setPV(value As Float)";
 //BA.debugLineNum = 220;BA.debugLine="mPV = value";
_mpv = _value;
 //BA.debugLineNum = 221;BA.debugLine="UpdateSPPV";
_updatesppv();
 //BA.debugLineNum = 222;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ValueChang";
if (__c.SubExists(ba,_mcallback,_meventname+"_ValueChanged")) { 
 //BA.debugLineNum = 223;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ValueChanged\"";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ValueChanged",(Object)(_value));
 };
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public String  _setshowdeviation(boolean _state) throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Public Sub setShowDeviation(state As Boolean)";
 //BA.debugLineNum = 263;BA.debugLine="mShowDeviation = state";
_mshowdeviation = _state;
 //BA.debugLineNum = 264;BA.debugLine="LabelDeviation.Visible = mShowDeviation";
_labeldeviation.setVisible(_mshowdeviation);
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return "";
}
public String  _setsp(float _value) throws Exception{
 //BA.debugLineNum = 232;BA.debugLine="Public Sub setSP(value As Float)";
 //BA.debugLineNum = 233;BA.debugLine="If value < mMin Then value = mMin";
if (_value<_mmin) { 
_value = _mmin;};
 //BA.debugLineNum = 234;BA.debugLine="If value > mMax Then value = mMax";
if (_value>_mmax) { 
_value = _mmax;};
 //BA.debugLineNum = 235;BA.debugLine="mSP = value";
_msp = _value;
 //BA.debugLineNum = 236;BA.debugLine="UpdateSPPV";
_updatesppv();
 //BA.debugLineNum = 237;BA.debugLine="If SubExists(mCallBack, mEventName & \"_SetPointCh";
if (__c.SubExists(ba,_mcallback,_meventname+"_SetPointChanged")) { 
 //BA.debugLineNum = 238;BA.debugLine="CallSub2(mCallBack, mEventName & \"_SetPointChang";
__c.CallSubNew2(ba,_mcallback,_meventname+"_SetPointChanged",(Object)(_value));
 };
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _setsppv(float _valuesp,float _valuepv) throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Public Sub SetSPPV(valuesp As Float, valuepv As Fl";
 //BA.debugLineNum = 247;BA.debugLine="setSP(valuesp)";
_setsp(_valuesp);
 //BA.debugLineNum = 248;BA.debugLine="setPV(valuepv)";
_setpv(_valuepv);
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 370;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 371;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 372;BA.debugLine="End Sub";
return "";
}
public String  _setstepsize(float _value) throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Public Sub setStepSize(value As Float)";
 //BA.debugLineNum = 315;BA.debugLine="mStepSize = value";
_mstepsize = _value;
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 211;BA.debugLine="mTitle = text";
_mtitle = _text;
 //BA.debugLineNum = 212;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 364;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 365;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 366;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 357;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 361;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public String  _stepminus() throws Exception{
float _v = 0f;
 //BA.debugLineNum = 342;BA.debugLine="Public Sub StepMinus";
 //BA.debugLineNum = 343;BA.debugLine="Dim v As Float = mSP";
_v = _msp;
 //BA.debugLineNum = 344;BA.debugLine="v = v - mStepSize";
_v = (float) (_v-_mstepsize);
 //BA.debugLineNum = 345;BA.debugLine="setSP(v)";
_setsp(_v);
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
return "";
}
public String  _stepplus() throws Exception{
float _v = 0f;
 //BA.debugLineNum = 349;BA.debugLine="Public Sub StepPlus";
 //BA.debugLineNum = 350;BA.debugLine="Dim v As Float = mSP";
_v = _msp;
 //BA.debugLineNum = 351;BA.debugLine="v = v + mStepSize";
_v = (float) (_v+_mstepsize);
 //BA.debugLineNum = 352;BA.debugLine="setSP(v)";
_setsp(_v);
 //BA.debugLineNum = 353;BA.debugLine="End Sub";
return "";
}
public String  _updatesppv() throws Exception{
float _absoluteerror = 0f;
String _signprefix = "";
String _deviationstr = "";
 //BA.debugLineNum = 168;BA.debugLine="Public Sub UpdateSPPV";
 //BA.debugLineNum = 170;BA.debugLine="mDeviation = mPV - mSP";
_mdeviation = (float) (_mpv-_msp);
 //BA.debugLineNum = 171;BA.debugLine="Dim AbsoluteError As Float = Abs(mDeviation)";
_absoluteerror = (float) (__c.Abs(_mdeviation));
 //BA.debugLineNum = 174;BA.debugLine="LabelPV.Text = NumberFormat(mPV, 1, 1)";
_labelpv.setText(__c.NumberFormat(_mpv,(int) (1),(int) (1)));
 //BA.debugLineNum = 175;BA.debugLine="LabelSP.Text = \"SP: \" & NumberFormat(mSP, 1, 0)";
_labelsp.setText("SP: "+__c.NumberFormat(_msp,(int) (1),(int) (0)));
 //BA.debugLineNum = 178;BA.debugLine="Dim SignPrefix As String = \"\"";
_signprefix = "";
 //BA.debugLineNum = 179;BA.debugLine="If mDeviation > 0 Then SignPrefix = \"+\"";
if (_mdeviation>0) { 
_signprefix = "+";};
 //BA.debugLineNum = 181;BA.debugLine="Dim DeviationStr As String = \"Δ \" & SignPrefix &";
_deviationstr = "Δ "+_signprefix+__c.NumberFormat(_mdeviation,(int) (1),(int) (1));
 //BA.debugLineNum = 183;BA.debugLine="LabelDeviation.TextColor = 0xFFFFFFFF	' White Col";
_labeldeviation.setTextColor(((int)0xffffffff));
 //BA.debugLineNum = 186;BA.debugLine="If AbsoluteError >= mDeviationAlarm Then";
if (_absoluteerror>=_mdeviationalarm) { 
 //BA.debugLineNum = 188;BA.debugLine="mStatus = HMITileUtils.STATUS_ALARM";
_mstatus = _hmitileutils._status_alarm /*String*/ ;
 }else if(_absoluteerror>=_mdeviationwarning) { 
 //BA.debugLineNum = 191;BA.debugLine="mStatus = HMITileUtils.STATUS_WARNING";
_mstatus = _hmitileutils._status_warning /*String*/ ;
 }else {
 //BA.debugLineNum = 194;BA.debugLine="mStatus = HMITileUtils.STATUS_NORMAL";
_mstatus = _hmitileutils._status_normal /*String*/ ;
 };
 //BA.debugLineNum = 196;BA.debugLine="LabelDeviation.Text = $\"${DeviationStr}\"$";
_labeldeviation.setText((""+__c.SmartStringFormatter("",(Object)(_deviationstr))+""));
 //BA.debugLineNum = 201;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
