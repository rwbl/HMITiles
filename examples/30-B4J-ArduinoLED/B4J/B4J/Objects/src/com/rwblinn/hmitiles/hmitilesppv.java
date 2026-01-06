package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilesppv extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.hmitilesppv", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.hmitilesppv.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _deviation_character = "";
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panetile = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelpv = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelsp = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelminus = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelplus = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeldeviation = null;
public String _mtypestyle = "";
public float _mpv = 0f;
public float _msp = 0f;
public float _mstepsize = 0f;
public float _mmin = 0f;
public float _mmax = 0f;
public int _mdigits = 0;
public float _mdeviationlimit = 0f;
public boolean _mshowdeviation = false;
public float _mdeviation = 0f;
public boolean _meditmode = false;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 111;BA.debugLine="mBase.LoadLayout(\"hmitilesppv\")";
_mbase.LoadLayout("hmitilesppv",ba);
 //BA.debugLineNum = 113;BA.debugLine="LabelTitle.Text			= Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 116;BA.debugLine="mMin 					= Props.GetDefault(\"Min\", 0)";
_mmin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Min"),(Object)(0))));
 //BA.debugLineNum = 117;BA.debugLine="mMax 					= Props.GetDefault(\"Max\", 100)";
_mmax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("Max"),(Object)(100))));
 //BA.debugLineNum = 118;BA.debugLine="mStepSize 				= Props.GetDefault(\"StepSize\", 1)";
_mstepsize = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("StepSize"),(Object)(1))));
 //BA.debugLineNum = 121;BA.debugLine="setPV(Props.GetDefault(\"PV\", 0))";
_setpv((float)(BA.ObjectToNumber(_props.GetDefault((Object)("PV"),(Object)(0)))));
 //BA.debugLineNum = 122;BA.debugLine="setSP(Props.GetDefault(\"SP\", 100))";
_setsp((float)(BA.ObjectToNumber(_props.GetDefault((Object)("SP"),(Object)(100)))));
 //BA.debugLineNum = 123;BA.debugLine="UpdateDeviation";
_updatedeviation();
 //BA.debugLineNum = 125;BA.debugLine="mShowDeviation			= Props.GetDefault(\"ShowDeviatio";
_mshowdeviation = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowDeviation"),(Object)(__c.False)));
 //BA.debugLineNum = 126;BA.debugLine="LabelDeviation.Visible 	= mShowDeviation";
_labeldeviation.setVisible(_mshowdeviation);
 //BA.debugLineNum = 127;BA.debugLine="mDeviationLimit			= Props.GetDefault(\"DeviationLi";
_mdeviationlimit = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("DeviationLimit"),(Object)(0))));
 //BA.debugLineNum = 128;BA.debugLine="mDigits					= Props.GetDefault(\"Digits\", 0)";
_mdigits = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("Digits"),(Object)(0))));
 //BA.debugLineNum = 129;BA.debugLine="mEditMode				= Props.GetDefault(\"EditMode\", True)";
_meditmode = BA.ObjectToBoolean(_props.GetDefault((Object)("EditMode"),(Object)(__c.True)));
 //BA.debugLineNum = 130;BA.debugLine="setEditMode(mEditMode)";
_seteditmode(_meditmode);
 //BA.debugLineNum = 131;BA.debugLine="mTypeStyle				= HMITileUtils.STATE_NORMAL";
_mtypestyle = BA.NumberToString(_hmitileutils._state_normal /*int*/ );
 //BA.debugLineNum = 133;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 134;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _tilestate) throws Exception{
int _state = 0;
 //BA.debugLineNum = 334;BA.debugLine="Public Sub ApplyStyle(tilestate As String)";
 //BA.debugLineNum = 335;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 336;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelPV)";
_hmitileutils._applyvaluestyle /*String*/ (_labelpv);
 //BA.debugLineNum = 337;BA.debugLine="HMITileUtils.ApplyLabelStyle(LabelSP)";
_hmitileutils._applylabelstyle /*String*/ (_labelsp);
 //BA.debugLineNum = 338;BA.debugLine="HMITileUtils.ApplyFontAwesomeStyle(LabelMinus)";
_hmitileutils._applyfontawesomestyle /*String*/ (_labelminus);
 //BA.debugLineNum = 339;BA.debugLine="HMITileUtils.ApplyFontAwesomeStyle(LabelPlus)";
_hmitileutils._applyfontawesomestyle /*String*/ (_labelplus);
 //BA.debugLineNum = 340;BA.debugLine="HMITileUtils.ApplySubInfoStyle(LabelDeviation)";
_hmitileutils._applysubinfostyle /*String*/ (_labeldeviation);
 //BA.debugLineNum = 342;BA.debugLine="Dim state As Int = HMITileUtils.StateStyleToState";
_state = _hmitileutils._statestyletostate /*int*/ (_tilestate);
 //BA.debugLineNum = 343;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 345;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 346;BA.debugLine="LabelPV.TextColor = HMITileUtils.COLOR_TILE_NOR";
_labelpv.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 347;BA.debugLine="LabelSP.TextColor = HMITileUtils.COLOR_TILE_NOR";
_labelsp.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 348;BA.debugLine="LabelMinus.TextColor = HMITileUtils.COLOR_TILE_";
_labelminus.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 349;BA.debugLine="LabelPlus.TextColor = HMITileUtils.COLOR_TILE_N";
_labelplus.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 350;BA.debugLine="LabelDeviation.TextColor = HMITileUtils.COLOR_T";
_labeldeviation.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 351;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 354;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 355;BA.debugLine="LabelPV.TextColor = HMITileUtils.COLOR_TILE_WAR";
_labelpv.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 356;BA.debugLine="LabelSP.TextColor = HMITileUtils.COLOR_TILE_WAR";
_labelsp.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 357;BA.debugLine="LabelMinus.TextColor = HMITileUtils.COLOR_TILE_";
_labelminus.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 358;BA.debugLine="LabelPlus.TextColor = HMITileUtils.COLOR_TILE_W";
_labelplus.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 359;BA.debugLine="LabelDeviation.TextColor = HMITileUtils.COLOR_T";
_labeldeviation.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 360;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 363;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 364;BA.debugLine="LabelPV.TextColor = HMITileUtils.COLOR_TILE_ALA";
_labelpv.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 365;BA.debugLine="LabelSP.TextColor = HMITileUtils.COLOR_TILE_ALA";
_labelsp.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 366;BA.debugLine="LabelMinus.TextColor = HMITileUtils.COLOR_TILE_";
_labelminus.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 367;BA.debugLine="LabelPlus.TextColor = HMITileUtils.COLOR_TILE_A";
_labelplus.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 368;BA.debugLine="LabelDeviation.TextColor = HMITileUtils.COLOR_T";
_labeldeviation.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 369;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 372;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 373;BA.debugLine="LabelPV.TextColor = HMITileUtils.COLOR_TILE_DIS";
_labelpv.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 374;BA.debugLine="LabelSP.TextColor = HMITileUtils.COLOR_TILE_DIS";
_labelsp.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 375;BA.debugLine="LabelMinus.TextColor = HMITileUtils.COLOR_TILE_";
_labelminus.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 376;BA.debugLine="LabelPlus.TextColor = HMITileUtils.COLOR_TILE_D";
_labelplus.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 377;BA.debugLine="LabelDeviation.TextColor = HMITileUtils.COLOR_T";
_labeldeviation.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 378;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 382;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 383;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 137;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 138;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 140;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 142;BA.debugLine="PaneTile.SetLayoutAnimated(0,0,0,Width, Height)";
_panetile.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 144;BA.debugLine="LabelTitle.SetLayoutAnimated		(0, 0,";
_labeltitle.SetLayoutAnimated((int) (0),0,_pad,_width,_height*0.25);
 //BA.debugLineNum = 145;BA.debugLine="LabelPV.SetLayoutAnimated			(0, 0,";
_labelpv.SetLayoutAnimated((int) (0),0,_height*0.30,_width,_height*0.25);
 //BA.debugLineNum = 146;BA.debugLine="LabelMinus.SetLayoutAnimated		(0, 0,";
_labelminus.SetLayoutAnimated((int) (0),0,_height*0.60,_width*0.25,_height*0.20);
 //BA.debugLineNum = 147;BA.debugLine="LabelSP.SetLayoutAnimated			(0, Width * 0.25,";
_labelsp.SetLayoutAnimated((int) (0),_width*0.25,_height*0.55,_width*0.50,_height*0.25);
 //BA.debugLineNum = 148;BA.debugLine="LabelPlus.SetLayoutAnimated			(0, Width - (Width";
_labelplus.SetLayoutAnimated((int) (0),_width-(_width*0.25),_height*0.60,_width*0.25,_height*0.20);
 //BA.debugLineNum = 149;BA.debugLine="LabelDeviation.SetLayoutAnimated	(0, 0,";
_labeldeviation.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 61;BA.debugLine="Private DEVIATION_CHARACTER As String = \"Δ\"";
_deviation_character = "Δ";
 //BA.debugLineNum = 64;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 65;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 68;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private mLbl As B4XView	'ignore";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 73;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 74;BA.debugLine="Private PaneTile As B4XView";
_panetile = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private LabelPV As B4XView";
_labelpv = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private LabelSP As B4XView";
_labelsp = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private LabelMinus As B4XView";
_labelminus = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private LabelPlus As B4XView";
_labelplus = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private LabelDeviation As B4XView";
_labeldeviation = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Private mTypeStyle As String";
_mtypestyle = "";
 //BA.debugLineNum = 84;BA.debugLine="Private mPV As Float";
_mpv = 0f;
 //BA.debugLineNum = 85;BA.debugLine="Private mSP As Float";
_msp = 0f;
 //BA.debugLineNum = 86;BA.debugLine="Private mStepSize As Float";
_mstepsize = 0f;
 //BA.debugLineNum = 87;BA.debugLine="Private mMin As Float";
_mmin = 0f;
 //BA.debugLineNum = 88;BA.debugLine="Private mMax As Float";
_mmax = 0f;
 //BA.debugLineNum = 89;BA.debugLine="Private mDigits As Int";
_mdigits = 0;
 //BA.debugLineNum = 90;BA.debugLine="Private mDeviationLimit As Float";
_mdeviationlimit = 0f;
 //BA.debugLineNum = 91;BA.debugLine="Private mShowDeviation As Boolean";
_mshowdeviation = false;
 //BA.debugLineNum = 92;BA.debugLine="Private mDeviation As Float";
_mdeviation = 0f;
 //BA.debugLineNum = 93;BA.debugLine="Private mEditMode As Boolean";
_meditmode = false;
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 102;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 103;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 104;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 105;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 107;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public float  _deviation() throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Public Sub Deviation As Float";
 //BA.debugLineNum = 211;BA.debugLine="mDeviation = 0";
_mdeviation = (float) (0);
 //BA.debugLineNum = 212;BA.debugLine="Try";
try { //BA.debugLineNum = 213;BA.debugLine="mDeviation = mPV - mSP";
_mdeviation = (float) (_mpv-_msp);
 //BA.debugLineNum = 214;BA.debugLine="If mDeviationLimit > 0 Then";
if (_mdeviationlimit>0) { 
 //BA.debugLineNum = 215;BA.debugLine="If Abs(mDeviation) >= mDeviationLimit Then";
if (__c.Abs(_mdeviation)>=_mdeviationlimit) { 
 //BA.debugLineNum = 216;BA.debugLine="SetStyleAlarm";
_setstylealarm();
 }else {
 //BA.debugLineNum = 218;BA.debugLine="SetStyleNormal";
_setstylenormal();
 };
 };
 } 
       catch (Exception e12) {
			ba.setLastException(e12); //BA.debugLineNum = 222;BA.debugLine="Log($\"[HMITileSPPV.Deviation][E] ${LastException";
__c.LogImpl("939059468",("[HMITileSPPV.Deviation][E] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 //BA.debugLineNum = 224;BA.debugLine="Return mDeviation";
if (true) return _mdeviation;
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return 0f;
}
public double  _getdeviationalarm() throws Exception{
 //BA.debugLineNum = 242;BA.debugLine="Public Sub getDeviationAlarm As Double";
 //BA.debugLineNum = 243;BA.debugLine="Return mDeviationLimit";
if (true) return _mdeviationlimit;
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return 0;
}
public int  _getdigits() throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Public Sub getDigits As Int";
 //BA.debugLineNum = 251;BA.debugLine="Return mDigits";
if (true) return _mdigits;
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return 0;
}
public boolean  _geteditmode() throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Public Sub getEditMode As Boolean";
 //BA.debugLineNum = 310;BA.debugLine="Return mEditMode";
if (true) return _meditmode;
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 279;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 280;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 257;BA.debugLine="Public Sub getMin As Float";
 //BA.debugLineNum = 258;BA.debugLine="Return mMin";
if (true) return _mmin;
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return 0f;
}
public float  _getpv() throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub getPV As Float";
 //BA.debugLineNum = 177;BA.debugLine="Return mPV";
if (true) return _mpv;
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return 0f;
}
public boolean  _getshowdeviation() throws Exception{
 //BA.debugLineNum = 235;BA.debugLine="Public Sub getShowDeviation As Boolean";
 //BA.debugLineNum = 236;BA.debugLine="Return mShowDeviation";
if (true) return _mshowdeviation;
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return false;
}
public float  _getsp() throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Public Sub getSP As Float";
 //BA.debugLineNum = 195;BA.debugLine="Return mSP";
if (true) return _msp;
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return 0f;
}
public float  _getstepsize() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Public Sub getStepSize As Float";
 //BA.debugLineNum = 272;BA.debugLine="Return mStepSize";
if (true) return _mstepsize;
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return 0f;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 161;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public String  _gettypestyle() throws Exception{
 //BA.debugLineNum = 299;BA.debugLine="Public Sub getTypeStyle As String";
 //BA.debugLineNum = 300;BA.debugLine="Return mTypeStyle";
if (true) return _mtypestyle;
 //BA.debugLineNum = 301;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 96;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 97;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 98;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _labelminus_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 406;BA.debugLine="Private Sub LabelMinus_MouseClicked (EventData As";
 //BA.debugLineNum = 407;BA.debugLine="StepMinus";
_stepminus();
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return "";
}
public String  _labelplus_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 410;BA.debugLine="Private Sub LabelPlus_MouseClicked (EventData As M";
 //BA.debugLineNum = 411;BA.debugLine="StepPlus";
_stepplus();
 //BA.debugLineNum = 412;BA.debugLine="End Sub";
return "";
}
public String  _labelsp_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 414;BA.debugLine="Private Sub LabelSP_MouseClicked (EventData As Mou";
 //BA.debugLineNum = 415;BA.debugLine="setEditMode(Not(mEditMode))";
_seteditmode(__c.Not(_meditmode));
 //BA.debugLineNum = 416;BA.debugLine="End Sub";
return "";
}
public String  _setdeviationlimit(double _value) throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Public Sub setDeviationLimit(value As Double)";
 //BA.debugLineNum = 240;BA.debugLine="mDeviationLimit = value";
_mdeviationlimit = (float) (_value);
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return "";
}
public String  _setdigits(int _value) throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Public Sub setDigits(value As Int)";
 //BA.debugLineNum = 247;BA.debugLine="If value < 0 Then value = 0";
if (_value<0) { 
_value = (int) (0);};
 //BA.debugLineNum = 248;BA.debugLine="mDigits = value";
_mdigits = _value;
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public String  _seteditmode(boolean _state) throws Exception{
 //BA.debugLineNum = 304;BA.debugLine="Public Sub setEditMode(state As Boolean)";
 //BA.debugLineNum = 305;BA.debugLine="mEditMode = state";
_meditmode = _state;
 //BA.debugLineNum = 306;BA.debugLine="LabelMinus.Visible 	= mEditMode";
_labelminus.setVisible(_meditmode);
 //BA.debugLineNum = 307;BA.debugLine="LabelPlus.Visible	= mEditMode";
_labelplus.setVisible(_meditmode);
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 275;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 276;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 277;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (_mbase.getEnabled()));
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public String  _setmax(float _value) throws Exception{
 //BA.debugLineNum = 261;BA.debugLine="Public Sub setMax(value As Float)";
 //BA.debugLineNum = 262;BA.debugLine="mMax = value";
_mmax = _value;
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return "";
}
public String  _setmin(float _value) throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Public Sub setMin(value As Float)";
 //BA.debugLineNum = 255;BA.debugLine="mMin = value";
_mmin = _value;
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public String  _setpv(float _value) throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Public Sub setPV(value As Float)";
 //BA.debugLineNum = 165;BA.debugLine="Try";
try { //BA.debugLineNum = 166;BA.debugLine="mPV = value";
_mpv = _value;
 //BA.debugLineNum = 167;BA.debugLine="LabelPV.Text = NumberFormat(mPV, 1, mDigits)";
_labelpv.setText(__c.NumberFormat(_mpv,(int) (1),_mdigits));
 //BA.debugLineNum = 168;BA.debugLine="UpdateDeviation";
_updatedeviation();
 //BA.debugLineNum = 169;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ValueChan";
if (__c.SubExists(ba,_mcallback,_meventname+"_ValueChanged")) { 
 //BA.debugLineNum = 170;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ValueChanged";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ValueChanged",(Object)(_value));
 };
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 173;BA.debugLine="Log($\"[HMITileSPPV.setPV][E] ${LastException}\"$)";
__c.LogImpl("938731785",("[HMITileSPPV.setPV][E] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _setshowdeviation(boolean _state) throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Public Sub setShowDeviation(state As Boolean)";
 //BA.debugLineNum = 232;BA.debugLine="mShowDeviation = state";
_mshowdeviation = _state;
 //BA.debugLineNum = 233;BA.debugLine="LabelDeviation.Visible = mShowDeviation";
_labeldeviation.setVisible(_mshowdeviation);
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public String  _setsp(float _value) throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub setSP(value As Float)";
 //BA.debugLineNum = 181;BA.debugLine="If value < mMin Then value = mMin";
if (_value<_mmin) { 
_value = _mmin;};
 //BA.debugLineNum = 182;BA.debugLine="If value > mMax Then value = mMax";
if (_value>_mmax) { 
_value = _mmax;};
 //BA.debugLineNum = 183;BA.debugLine="Try";
try { //BA.debugLineNum = 184;BA.debugLine="mSP = value";
_msp = _value;
 //BA.debugLineNum = 185;BA.debugLine="LabelSP.Text = NumberFormat(mSP, 1, mDigits)";
_labelsp.setText(__c.NumberFormat(_msp,(int) (1),_mdigits));
 //BA.debugLineNum = 186;BA.debugLine="UpdateDeviation";
_updatedeviation();
 //BA.debugLineNum = 187;BA.debugLine="If SubExists(mCallBack, mEventName & \"_SetPointC";
if (__c.SubExists(ba,_mcallback,_meventname+"_SetPointChanged")) { 
 //BA.debugLineNum = 188;BA.debugLine="CallSub2(mCallBack, mEventName & \"_SetPointChan";
__c.CallSubNew2(ba,_mcallback,_meventname+"_SetPointChanged",(Object)(_value));
 };
 } 
       catch (Exception e11) {
			ba.setLastException(e11); //BA.debugLineNum = 191;BA.debugLine="Log($\"[HMITileSPPV.setSP][E] ${LastException}\"$)";
__c.LogImpl("938862859",("[HMITileSPPV.setSP][E] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _setsppv(float _valuesp,float _valuepv) throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Public Sub SetSPPV(valuesp As Float, valuepv As Fl";
 //BA.debugLineNum = 200;BA.debugLine="setSP(valuesp)";
_setsp(_valuesp);
 //BA.debugLineNum = 201;BA.debugLine="setPV(valuepv)";
_setpv(_valuepv);
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public String  _setstepsize(float _value) throws Exception{
 //BA.debugLineNum = 268;BA.debugLine="Public Sub setStepSize(value As Float)";
 //BA.debugLineNum = 269;BA.debugLine="mStepSize = value";
_mstepsize = _value;
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}
public String  _setstylealarm() throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Public Sub SetStyleAlarm";
 //BA.debugLineNum = 292;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)";
_settypestyle(_hmitileutils._typestyle_alarm /*String*/ );
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public String  _setstylenormal() throws Exception{
 //BA.debugLineNum = 283;BA.debugLine="Public Sub SetStyleNormal";
 //BA.debugLineNum = 284;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)";
_settypestyle(_hmitileutils._typestyle_normal /*String*/ );
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return "";
}
public String  _setstylewarning() throws Exception{
 //BA.debugLineNum = 287;BA.debugLine="Public Sub SetStyleWarning";
 //BA.debugLineNum = 288;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)";
_settypestyle(_hmitileutils._typestyle_warning /*String*/ );
 //BA.debugLineNum = 289;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 158;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _settypestyle(String _value) throws Exception{
 //BA.debugLineNum = 295;BA.debugLine="Public Sub setTypeStyle(value As String)";
 //BA.debugLineNum = 296;BA.debugLine="mTypeStyle = value";
_mtypestyle = _value;
 //BA.debugLineNum = 297;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public String  _stepminus() throws Exception{
float _v = 0f;
 //BA.debugLineNum = 313;BA.debugLine="Public Sub StepMinus";
 //BA.debugLineNum = 314;BA.debugLine="Dim v As Float = LabelSP.Text";
_v = (float)(Double.parseDouble(_labelsp.getText()));
 //BA.debugLineNum = 315;BA.debugLine="v = v - mStepSize";
_v = (float) (_v-_mstepsize);
 //BA.debugLineNum = 316;BA.debugLine="setSP(v)";
_setsp(_v);
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public String  _stepplus() throws Exception{
float _v = 0f;
 //BA.debugLineNum = 319;BA.debugLine="Public Sub StepPlus";
 //BA.debugLineNum = 320;BA.debugLine="Dim v As Float = LabelSP.Text";
_v = (float)(Double.parseDouble(_labelsp.getText()));
 //BA.debugLineNum = 321;BA.debugLine="v = v + mStepSize";
_v = (float) (_v+_mstepsize);
 //BA.debugLineNum = 322;BA.debugLine="setSP(v)";
_setsp(_v);
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public String  _updatedeviation() throws Exception{
 //BA.debugLineNum = 227;BA.debugLine="Private Sub UpdateDeviation";
 //BA.debugLineNum = 228;BA.debugLine="LabelDeviation.Text = $\"${DEVIATION_CHARACTER} ${";
_labeldeviation.setText((""+__c.SmartStringFormatter("",(Object)(_deviation_character))+" "+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(_deviation(),(int) (1),_mdigits)))+""));
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
