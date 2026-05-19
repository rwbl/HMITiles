package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilelevel extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilelevel", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilelevel.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _panelevelindicator = null;
public anywheresoftware.b4a.objects.B4XCanvas _cvslevelindicator = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelunit = null;
public String _mtitle = "";
public float _mvalue = 0f;
public String _munit = "";
public String _mstatus = "";
public int _mdigits = 0;
public int _mborderwidth = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 70;BA.debugLine="BasePane.LoadLayout(\"hmitilelevel\")";
_basepane.LoadLayout("hmitilelevel",ba);
 //BA.debugLineNum = 73;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 74;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 75;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 76;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(BA.NumberToString(_mvalue));
 //BA.debugLineNum = 77;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 78;BA.debugLine="LabelUnit.Text 	= mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 79;BA.debugLine="mStatus			= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 81;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 83;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 247;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 248;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 249;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 250;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 251;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 252;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 87;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 90;BA.debugLine="LabelTitle.SetLayoutAnimated			(0, 0, 0, 				Widt";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 91;BA.debugLine="PaneLevelIndicator.SetLayoutAnimated	(0, Width /";
_panelevelindicator.SetLayoutAnimated((int) (0),_width/(double)4,_height*0.25,_width/(double)2,_height*0.40);
 //BA.debugLineNum = 92;BA.debugLine="LabelValue.SetLayoutAnimated			(0, 0, Height * 0.";
_labelvalue.SetLayoutAnimated((int) (0),0,_height*0.55,_width,_height*0.35);
 //BA.debugLineNum = 93;BA.debugLine="LabelUnit.SetLayoutAnimated				(0, 0, Height * 0.";
_labelunit.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 96;BA.debugLine="CvsLevelIndicator.Initialize(PaneLevelIndicator)";
_cvslevelindicator.Initialize(ba,_panelevelindicator);
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 29;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 30;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 32;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Public BaseLabel As B4XView";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 36;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 39;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private PaneLevelIndicator As B4XView";
_panelevelindicator = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private CvsLevelIndicator As B4XCanvas";
_cvslevelindicator = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 42;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 47;BA.debugLine="Private mValue As Float";
_mvalue = 0f;
 //BA.debugLineNum = 48;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 49;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 52;BA.debugLine="Private mDigits As Int = 0";
_mdigits = (int) (0);
 //BA.debugLineNum = 53;BA.debugLine="Private mBorderWidth As Int = 2dip";
_mborderwidth = __c.DipToCurrent((int) (2));
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 281;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 282;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 283;BA.debugLine="CallSub2(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew2(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue));
 };
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 62;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 63;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 64;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 65;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 66;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _drawlevelindicator() throws Exception{
float _margin = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _router = null;
float _innermargin = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _rinner = null;
float _fillheight = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _fillrect = null;
 //BA.debugLineNum = 114;BA.debugLine="Private Sub DrawLevelIndicator";
 //BA.debugLineNum = 116;BA.debugLine="CvsLevelIndicator.ClearRect(CvsLevelIndicator.Tar";
_cvslevelindicator.ClearRect(_cvslevelindicator.getTargetRect());
 //BA.debugLineNum = 119;BA.debugLine="Dim margin As Float = 2dip";
_margin = (float) (__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 121;BA.debugLine="Dim rOuter As B4XRect";
_router = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 122;BA.debugLine="rOuter.Initialize( _         margin, _         ma";
_router.Initialize(_margin,_margin,(float) (_panelevelindicator.getWidth()-_margin),(float) (_panelevelindicator.getHeight()-_margin));
 //BA.debugLineNum = 129;BA.debugLine="CvsLevelIndicator.DrawRect(rOuter, _         HMIT";
_cvslevelindicator.DrawRect(_router,_hmitileutils._color_border_default /*int*/ ,__c.False,(float) (_mborderwidth));
 //BA.debugLineNum = 138;BA.debugLine="Dim innerMargin As Float = 1dip";
_innermargin = (float) (__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 140;BA.debugLine="Dim rInner As B4XRect";
_rinner = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 141;BA.debugLine="rInner.Initialize( _         rOuter.Left + innerM";
_rinner.Initialize((float) (_router.getLeft()+_innermargin),(float) (_router.getTop()+_innermargin),(float) (_router.getRight()-_innermargin),(float) (_router.getBottom()-_innermargin));
 //BA.debugLineNum = 148;BA.debugLine="CvsLevelIndicator.DrawRect(rInner, _         HMIT";
_cvslevelindicator.DrawRect(_rinner,_hmitileutils._color_indicator_track /*int*/ ,__c.True,(float) (0));
 //BA.debugLineNum = 154;BA.debugLine="If mValue < 0 Then mValue = 0";
if (_mvalue<0) { 
_mvalue = (float) (0);};
 //BA.debugLineNum = 155;BA.debugLine="If mValue > 100 Then mValue = 100";
if (_mvalue>100) { 
_mvalue = (float) (100);};
 //BA.debugLineNum = 158;BA.debugLine="Dim fillHeight As Float = (mValue / 100) * rInner";
_fillheight = (float) ((_mvalue/(double)100)*_rinner.getHeight());
 //BA.debugLineNum = 161;BA.debugLine="Dim fillRect As B4XRect";
_fillrect = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 162;BA.debugLine="fillRect.Initialize( _         rInner.Left, _";
_fillrect.Initialize(_rinner.getLeft(),(float) (_rinner.getBottom()-_fillheight),_rinner.getRight(),_rinner.getBottom());
 //BA.debugLineNum = 169;BA.debugLine="CvsLevelIndicator.DrawRect(fillRect, _         HM";
_cvslevelindicator.DrawRect(_fillrect,_hmitileutils._color_indicator_level /*int*/ ,__c.True,(float) (0));
 //BA.debugLineNum = 174;BA.debugLine="CvsLevelIndicator.Invalidate";
_cvslevelindicator.Invalidate();
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 212;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 239;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 184;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 204;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 195;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 196;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 56;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 57;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 58;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public String  _panebar_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="Private Sub PaneBar_MouseClicked (EventData As Mou";
 //BA.debugLineNum = 259;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return "";
}
public String  _panefill_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Private Sub PaneFill_MouseClicked (EventData As Mo";
 //BA.debugLineNum = 263;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return "";
}
public String  _redraw() throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Private Sub Redraw";
 //BA.debugLineNum = 105;BA.debugLine="If PaneLevelIndicator.IsInitialized Then";
if (_panelevelindicator.IsInitialized()) { 
 //BA.debugLineNum = 106;BA.debugLine="DrawLevelIndicator";
_drawlevelindicator();
 };
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 207;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 208;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 209;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 233;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 234;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 235;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 236;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 181;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 200;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 201;BA.debugLine="LabelUnit = mUnit";
_labelunit = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_munit));
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 189;BA.debugLine="If LabelValue.IsInitialized Then";
if (_labelvalue.IsInitialized()) { 
 //BA.debugLineNum = 190;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 191;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 192;BA.debugLine="LabelValue.Text = NumberFormat(mValue, 1, mDigit";
_labelvalue.setText(__c.NumberFormat(_mvalue,(int) (1),_mdigits));
 };
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 224;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 225;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 226;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 229;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 216;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 217;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 220;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 221;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
