package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitiledeviation extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitiledeviation", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitiledeviation.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panebar = null;
public anywheresoftware.b4a.objects.B4XCanvas _cvsbar = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public String _mtitle = "";
public float _mvalue = 0f;
public float _mmaxscale = 0f;
public int _mdigits = 0;
public String _munit = "";
public float _mdeadband = 0f;
public float _mwarninglevel = 0f;
public float _malarmlevel = 0f;
public int _mdevcoldeadband = 0;
public int _mdevcolneutral = 0;
public int _mdevcolwarning = 0;
public int _mdevcolalarm = 0;
public String _mstatus = "";
public int _bar_width = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 103;BA.debugLine="BasePane.LoadLayout(\"hmitiledeviation\")";
_basepane.LoadLayout("hmitiledeviation",ba);
 //BA.debugLineNum = 106;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 107;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 108;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 109;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(BA.NumberToString(_mvalue));
 //BA.debugLineNum = 110;BA.debugLine="mMaxScale		= Props.GetDefault(\"MaxScale\", 100)";
_mmaxscale = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("MaxScale"),(Object)(100))));
 //BA.debugLineNum = 111;BA.debugLine="mDigits			= Props.GetDefault(\"Digits\", 0)";
_mdigits = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("Digits"),(Object)(0))));
 //BA.debugLineNum = 112;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 113;BA.debugLine="mDeadband		= Props.Get(\"Deadband\")";
_mdeadband = (float)(BA.ObjectToNumber(_props.Get((Object)("Deadband"))));
 //BA.debugLineNum = 114;BA.debugLine="mWarningLevel 	= Props.Get(\"WarningLevel\")";
_mwarninglevel = (float)(BA.ObjectToNumber(_props.Get((Object)("WarningLevel"))));
 //BA.debugLineNum = 115;BA.debugLine="mAlarmLevel 	= Props.Get(\"AlarmLevel\")";
_malarmlevel = (float)(BA.ObjectToNumber(_props.Get((Object)("AlarmLevel"))));
 //BA.debugLineNum = 116;BA.debugLine="mDevColDeadband	= xui.PaintOrColorToColor(Props.G";
_mdevcoldeadband = _xui.PaintOrColorToColor(_props.Get((Object)("DevColDeadband")));
 //BA.debugLineNum = 117;BA.debugLine="mDevColNeutral	= xui.PaintOrColorToColor(Props.Ge";
_mdevcolneutral = _xui.PaintOrColorToColor(_props.Get((Object)("DevColNeutral")));
 //BA.debugLineNum = 118;BA.debugLine="mDevColWarning	= xui.PaintOrColorToColor(Props.Ge";
_mdevcolwarning = _xui.PaintOrColorToColor(_props.Get((Object)("DevColWarning")));
 //BA.debugLineNum = 119;BA.debugLine="mDevColAlarm	= xui.PaintOrColorToColor(Props.Get(";
_mdevcolalarm = _xui.PaintOrColorToColor(_props.Get((Object)("DevColAlarm")));
 //BA.debugLineNum = 122;BA.debugLine="mStatus			= HMITileUtils.STATUS_NORMAL";
_mstatus = _hmitileutils._status_normal /*String*/ ;
 //BA.debugLineNum = 124;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 126;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 128;BA.debugLine="setValue(mValue)";
_setvalue(_mvalue);
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Private Sub ApplyStatusStyle(status As String)	'ig";
 //BA.debugLineNum = 370;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 372;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 373;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 375;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 377;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 378;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_normal_text /*int*/ );
 //BA.debugLineNum = 379;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 382;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 383;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_warning_text /*int*/ );
 //BA.debugLineNum = 384;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_WARNIN";
_basepane.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 387;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 388;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_alarm_text /*int*/ );
 //BA.debugLineNum = 389;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_ALARM_";
_basepane.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 392;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TILE_";
_labeltitle.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 393;BA.debugLine="LabelValue.TextColor = HMITileUtils.COLOR_TILE_";
_labelvalue.setTextColor(_hmitileutils._color_tile_disabled_text /*int*/ );
 //BA.debugLineNum = 394;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_DISABL";
_basepane.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 397;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 398;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 358;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 359;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 360;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 361;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 132;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 135;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0, 0, 				Width,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 136;BA.debugLine="PaneBar.SetLayoutAnimated		(0, 0, Height * 0.25,";
_panebar.SetLayoutAnimated((int) (0),0,_height*0.25,_width,_height*0.50);
 //BA.debugLineNum = 137;BA.debugLine="LabelValue.SetLayoutAnimated	(0, 0, Height * 0.75";
_labelvalue.SetLayoutAnimated((int) (0),0,_height*0.75,_width,_height*0.25);
 //BA.debugLineNum = 140;BA.debugLine="CvsBar.Initialize(PaneBar)";
_cvsbar.Initialize(ba,_panebar);
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public float  _calculatedeviation(float _sp,float _pv) throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Public Sub CalculateDeviation(SP As Float, PV As F";
 //BA.debugLineNum = 247;BA.debugLine="Return PV - SP";
if (true) return (float) (_pv-_sp);
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return 0f;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 53;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 54;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 56;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Public BaseLabel As B4XView";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 60;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 63;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private PaneBar As B4XView";
_panebar = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private CvsBar As B4XCanvas";
_cvsbar = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 66;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 70;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 71;BA.debugLine="Private mMaxScale As Float";
_mmaxscale = 0f;
 //BA.debugLineNum = 72;BA.debugLine="Private mDigits As Int = 0";
_mdigits = (int) (0);
 //BA.debugLineNum = 73;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 74;BA.debugLine="Private mDeadband As Float";
_mdeadband = 0f;
 //BA.debugLineNum = 75;BA.debugLine="Private mWarningLevel As Float";
_mwarninglevel = 0f;
 //BA.debugLineNum = 76;BA.debugLine="Private mAlarmLevel As Float		'ignore";
_malarmlevel = 0f;
 //BA.debugLineNum = 77;BA.debugLine="Private mDevColDeadband As Int";
_mdevcoldeadband = 0;
 //BA.debugLineNum = 78;BA.debugLine="Private mDevColNeutral As Int";
_mdevcolneutral = 0;
 //BA.debugLineNum = 79;BA.debugLine="Private mDevColWarning As Int";
_mdevcolwarning = 0;
 //BA.debugLineNum = 80;BA.debugLine="Private mDevColAlarm As Int";
_mdevcolalarm = 0;
 //BA.debugLineNum = 83;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 86;BA.debugLine="Private BAR_WIDTH As Int = 20dip";
_bar_width = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 418;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 419;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 420;BA.debugLine="CallSub3(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew3(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue),(Object)(_mstatus));
 };
 //BA.debugLineNum = 422;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 95;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 96;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 97;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 98;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 99;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public String  _drawbar() throws Exception{
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _rect = null;
float _cx = 0f;
float _cy = 0f;
float _h = 0f;
float _w = 0f;
float _left = 0f;
float _top = 0f;
float _v = 0f;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
float _py = 0f;
 //BA.debugLineNum = 143;BA.debugLine="Private Sub DrawBar";
 //BA.debugLineNum = 145;BA.debugLine="Dim rect As B4XRect";
_rect = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 148;BA.debugLine="CvsBar.ClearRect(CvsBar.TargetRect)";
_cvsbar.ClearRect(_cvsbar.getTargetRect());
 //BA.debugLineNum = 151;BA.debugLine="Dim cx 		As Float = CvsBar.TargetRect.CenterX";
_cx = _cvsbar.getTargetRect().getCenterX();
 //BA.debugLineNum = 152;BA.debugLine="Dim cy 		As Float = CvsBar.TargetRect.CenterY";
_cy = _cvsbar.getTargetRect().getCenterY();
 //BA.debugLineNum = 154;BA.debugLine="Dim h 		As Float = BasePane.Height * 0.5   ' leav";
_h = (float) (_basepane.getHeight()*0.5);
 //BA.debugLineNum = 155;BA.debugLine="Dim w 		As Float = BAR_WIDTH			' bar width";
_w = (float) (_bar_width);
 //BA.debugLineNum = 157;BA.debugLine="Dim left	As Float = cx - w / 2";
_left = (float) (_cx-_w/(double)2);
 //BA.debugLineNum = 158;BA.debugLine="Dim top As Float = cy - h / 2";
_top = (float) (_cy-_h/(double)2);
 //BA.debugLineNum = 162;BA.debugLine="Dim v 		As Float = Max(mMaxScale * -1, Min(mMaxSc";
_v = (float) (__c.Max(_mmaxscale*-1,__c.Min(_mmaxscale,_mvalue)));
 //BA.debugLineNum = 165;BA.debugLine="rect.Initialize(left, top, left + w, top + h)";
_rect.Initialize(_left,_top,(float) (_left+_w),(float) (_top+_h));
 //BA.debugLineNum = 166;BA.debugLine="CvsBar.DrawRect(rect, 0xFF404040, True, 0)";
_cvsbar.DrawRect(_rect,((int)0xff404040),__c.True,(float) (0));
 //BA.debugLineNum = 169;BA.debugLine="rect.Initialize(left, top, left + w, top + h)";
_rect.Initialize(_left,_top,(float) (_left+_w),(float) (_top+_h));
 //BA.debugLineNum = 170;BA.debugLine="CvsBar.DrawRect(rect, HMITileUtils.COLOR_DEVIATIO";
_cvsbar.DrawRect(_rect,_hmitileutils._color_deviation_bar /*int*/ ,__c.True,(float) (0));
 //BA.debugLineNum = 176;BA.debugLine="CvsBar.DrawLine(left, cy, left + w, cy, xui.color";
_cvsbar.DrawLine(_left,_cy,(float) (_left+_w),_cy,_xui.Color_Black,(float) (2));
 //BA.debugLineNum = 178;BA.debugLine="Dim fnt As B4XFont = xui.CreateDefaultFont(HMITil";
_fnt = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_fnt = _xui.CreateDefaultFont(_hmitileutils._text_size_tiny /*float*/ );
 //BA.debugLineNum = 179;BA.debugLine="CvsBar.DrawText($\"0${IIf(mUnit.Length > 0, $\" ${m";
_cvsbar.DrawText(("0"+__c.SmartStringFormatter("",((_munit.length()>0) ? ((Object)((" "+__c.SmartStringFormatter("",(Object)(_munit))+""))) : ((Object)(""))))+""),_left+_w+__c.DipToCurrent((int) (5)),_cy+(_fnt.getSize()/(double)2),_fnt,_hmitileutils._color_text_info /*int*/ ,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"LEFT"));
 //BA.debugLineNum = 188;BA.debugLine="Dim py As Float = cy - (v / mMaxScale) * (h / 2)";
_py = (float) (_cy-(_v/(double)_mmaxscale)*(_h/(double)2));
 //BA.debugLineNum = 189;BA.debugLine="If v > 0 Then";
if (_v>0) { 
 //BA.debugLineNum = 191;BA.debugLine="cy = cy - 1";
_cy = (float) (_cy-1);
 //BA.debugLineNum = 192;BA.debugLine="rect.Initialize(left, py, left + w, cy)";
_rect.Initialize(_left,_py,(float) (_left+_w),_cy);
 //BA.debugLineNum = 193;BA.debugLine="CvsBar.DrawRect(rect, GetDeviationColor(v), True";
_cvsbar.DrawRect(_rect,_getdeviationcolor(_v),__c.True,(float) (0));
 }else if(_v<0) { 
 //BA.debugLineNum = 196;BA.debugLine="cy = cy + 1";
_cy = (float) (_cy+1);
 //BA.debugLineNum = 197;BA.debugLine="rect.Initialize(left, cy, left + w, py)";
_rect.Initialize(_left,_cy,(float) (_left+_w),_py);
 //BA.debugLineNum = 198;BA.debugLine="CvsBar.DrawRect(rect, GetDeviationColor(v), True";
_cvsbar.DrawRect(_rect,_getdeviationcolor(_v),__c.True,(float) (0));
 };
 //BA.debugLineNum = 202;BA.debugLine="CvsBar.Invalidate";
_cvsbar.Invalidate();
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public String  _drawdottedlinehorizontal(float _x1,float _x2,float _y,float _dotsize,float _gap,int _clr) throws Exception{
float _x = 0f;
 //BA.debugLineNum = 207;BA.debugLine="Private Sub DrawDottedLineHorizontal(x1 As Float,";
 //BA.debugLineNum = 208;BA.debugLine="Dim x As Float = x1";
_x = _x1;
 //BA.debugLineNum = 209;BA.debugLine="Do While x < x2";
while (_x<_x2) {
 //BA.debugLineNum = 210;BA.debugLine="CvsBar.DrawLine(x, y, Min(x + dotSize, x2), y, c";
_cvsbar.DrawLine(_x,_y,(float) (__c.Min(_x+_dotsize,_x2)),_y,_clr,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 211;BA.debugLine="x = x + dotSize + gap";
_x = (float) (_x+_dotsize+_gap);
 }
;
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public int  _getdevcolalarm() throws Exception{
 //BA.debugLineNum = 312;BA.debugLine="Public Sub getDevColAlarm As Int";
 //BA.debugLineNum = 313;BA.debugLine="Return mDevColAlarm";
if (true) return _mdevcolalarm;
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return 0;
}
public int  _getdevcoldeadband() throws Exception{
 //BA.debugLineNum = 285;BA.debugLine="Public Sub getDevColDeadband As Int";
 //BA.debugLineNum = 286;BA.debugLine="Return mDevColDeadband";
if (true) return _mdevcoldeadband;
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return 0;
}
public int  _getdevcolneutral() throws Exception{
 //BA.debugLineNum = 294;BA.debugLine="Public Sub getDevColNeutral As Int";
 //BA.debugLineNum = 295;BA.debugLine="Return mDevColNeutral";
if (true) return _mdevcolneutral;
 //BA.debugLineNum = 296;BA.debugLine="End Sub";
return 0;
}
public int  _getdevcolwarning() throws Exception{
 //BA.debugLineNum = 303;BA.debugLine="Public Sub getDevColWarning As Int";
 //BA.debugLineNum = 304;BA.debugLine="Return mDevColWarning";
if (true) return _mdevcolwarning;
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return 0;
}
public int  _getdeviationcolor(float _value) throws Exception{
int _absvalue = 0;
 //BA.debugLineNum = 215;BA.debugLine="Private Sub GetDeviationColor(value As Float) As I";
 //BA.debugLineNum = 216;BA.debugLine="Dim AbsValue As Int = Abs(value)";
_absvalue = (int) (__c.Abs(_value));
 //BA.debugLineNum = 218;BA.debugLine="If AbsValue <= mDeadband Then";
if (_absvalue<=_mdeadband) { 
 //BA.debugLineNum = 220;BA.debugLine="mStatus = HMITileUtils.STATUS_NORMAL";
_mstatus = _hmitileutils._status_normal /*String*/ ;
 //BA.debugLineNum = 221;BA.debugLine="Return mDevColDeadband";
if (true) return _mdevcoldeadband;
 }else if(_absvalue<_mwarninglevel) { 
 //BA.debugLineNum = 224;BA.debugLine="mStatus = HMITileUtils.STATUS_NORMAL";
_mstatus = _hmitileutils._status_normal /*String*/ ;
 //BA.debugLineNum = 225;BA.debugLine="Return mDevColNeutral";
if (true) return _mdevcolneutral;
 }else if(_absvalue<_malarmlevel) { 
 //BA.debugLineNum = 228;BA.debugLine="mStatus = HMITileUtils.STATUS_WARNING";
_mstatus = _hmitileutils._status_warning /*String*/ ;
 //BA.debugLineNum = 229;BA.debugLine="Return mDevColWarning";
if (true) return _mdevcolwarning;
 }else {
 //BA.debugLineNum = 232;BA.debugLine="mStatus = HMITileUtils.STATUS_ALARM";
_mstatus = _hmitileutils._status_alarm /*String*/ ;
 //BA.debugLineNum = 233;BA.debugLine="Return mDevColAlarm";
if (true) return _mdevcolalarm;
 };
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return 0;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 321;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 322;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 330;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 331;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 255;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 277;BA.debugLine="Return LabelValue.Text";
if (true) return _labelvalue.getText();
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 267;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 268;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 89;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 90;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 91;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public String  _panebar_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 403;BA.debugLine="Private Sub PaneBar_MouseClicked (EventData As Mou";
 //BA.debugLineNum = 404;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 405;BA.debugLine="End Sub";
return "";
}
public String  _setdevcolalarm(int _value) throws Exception{
 //BA.debugLineNum = 308;BA.debugLine="Public Sub setDevColAlarm(value As Int)";
 //BA.debugLineNum = 309;BA.debugLine="mDevColAlarm = value";
_mdevcolalarm = _value;
 //BA.debugLineNum = 310;BA.debugLine="DrawBar";
_drawbar();
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return "";
}
public String  _setdevcoldeadband(int _value) throws Exception{
 //BA.debugLineNum = 281;BA.debugLine="Public Sub setDevColDeadband(value As Int)";
 //BA.debugLineNum = 282;BA.debugLine="mDevColDeadband = value";
_mdevcoldeadband = _value;
 //BA.debugLineNum = 283;BA.debugLine="DrawBar";
_drawbar();
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
public String  _setdevcolneutral(int _value) throws Exception{
 //BA.debugLineNum = 290;BA.debugLine="Public Sub setDevColNeutral(value As Int)";
 //BA.debugLineNum = 291;BA.debugLine="mDevColNeutral = value";
_mdevcolneutral = _value;
 //BA.debugLineNum = 292;BA.debugLine="DrawBar";
_drawbar();
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public String  _setdevcolwarning(int _value) throws Exception{
 //BA.debugLineNum = 299;BA.debugLine="Public Sub setDevColWarning(value As Int)";
 //BA.debugLineNum = 300;BA.debugLine="mDevColWarning = value";
_mdevcolwarning = _value;
 //BA.debugLineNum = 301;BA.debugLine="DrawBar";
_drawbar();
 //BA.debugLineNum = 302;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 317;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 318;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 319;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 320;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 326;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 327;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 328;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 329;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 251;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 252;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 272;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 273;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 274;BA.debugLine="DrawBar";
_drawbar();
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 260;BA.debugLine="If LabelValue.IsInitialized Then";
if (_labelvalue.IsInitialized()) { 
 //BA.debugLineNum = 261;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 262;BA.debugLine="DrawBar";
_drawbar();
 //BA.debugLineNum = 263;BA.debugLine="LabelValue.Text = NumberFormat(mValue, 1, mDigit";
_labelvalue.setText(__c.NumberFormat(_mvalue,(int) (1),_mdigits));
 //BA.debugLineNum = 264;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 };
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 344;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 345;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 348;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 349;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 336;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 337;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 338;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 340;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 341;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 342;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
