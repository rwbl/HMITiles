package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilelevelindicator extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilelevelindicator", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilelevelindicator.class).invoke(this, new Object[] {null});
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
public float _mcx = 0f;
public float _mcy = 0f;
public float _mradius = 0f;
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
 //BA.debugLineNum = 71;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 72;BA.debugLine="BasePane.LoadLayout(\"hmitilelevelindicator\")";
_basepane.LoadLayout("hmitilelevelindicator",ba);
 //BA.debugLineNum = 75;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 76;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 77;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = (float)(BA.ObjectToNumber(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 78;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(BA.NumberToString(_mvalue));
 //BA.debugLineNum = 79;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 80;BA.debugLine="LabelUnit.Text 	= mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 81;BA.debugLine="mStatus			= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 85;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 86;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 220;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 221;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 222;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 223;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 224;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 90;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 93;BA.debugLine="LabelTitle.SetLayoutAnimated			(0, 0, 0, 				Widt";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 94;BA.debugLine="PaneLevelIndicator.SetLayoutAnimated	(0, 0, Heigh";
_panelevelindicator.SetLayoutAnimated((int) (0),0,_height*0.25,_width,_height*0.40);
 //BA.debugLineNum = 95;BA.debugLine="LabelValue.SetLayoutAnimated			(0, 0, Height * 0.";
_labelvalue.SetLayoutAnimated((int) (0),0,_height*0.55,_width,_height*0.35);
 //BA.debugLineNum = 96;BA.debugLine="LabelUnit.SetLayoutAnimated				(0, 0, Height * 0.";
_labelunit.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 98;BA.debugLine="mCx 	= PaneLevelIndicator.Width / 2";
_mcx = (float) (_panelevelindicator.getWidth()/(double)2);
 //BA.debugLineNum = 99;BA.debugLine="mCy 	= PaneLevelIndicator.Height / 2.75 + 5dip";
_mcy = (float) (_panelevelindicator.getHeight()/(double)2.75+__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 100;BA.debugLine="mRadius	= Min(mCx, mCy) * 0.9";
_mradius = (float) (__c.Min(_mcx,_mcy)*0.9);
 //BA.debugLineNum = 103;BA.debugLine="CvsLevelIndicator.Initialize(PaneLevelIndicator)";
_cvslevelindicator.Initialize(ba,_panelevelindicator);
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 53;BA.debugLine="Private mCx, mCy As Float";
_mcx = 0f;
_mcy = 0f;
 //BA.debugLineNum = 54;BA.debugLine="Private mRadius As Float";
_mradius = 0f;
 //BA.debugLineNum = 55;BA.debugLine="Private mBorderWidth As Int = 4dip";
_mborderwidth = __c.DipToCurrent((int) (4));
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _click() throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Private Sub Click";
 //BA.debugLineNum = 246;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 247;BA.debugLine="CallSub2(mCallBack, mEventName & \"_Click\", mValu";
__c.CallSubNew2(ba,_mcallback,_meventname+"_Click",(Object)(_mvalue));
 };
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Private  Sub DesignerCreateView(Base As Object, Lb";
 //BA.debugLineNum = 64;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 65;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 66;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 67;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 68;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public String  _drawlevelindicator() throws Exception{
float _h = 0f;
float _topy = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
 //BA.debugLineNum = 119;BA.debugLine="Private Sub DrawLevelIndicator";
 //BA.debugLineNum = 120;BA.debugLine="CvsLevelIndicator.ClearRect(CvsLevelIndicator.Tar";
_cvslevelindicator.ClearRect(_cvslevelindicator.getTargetRect());
 //BA.debugLineNum = 123;BA.debugLine="CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, H";
_cvslevelindicator.DrawCircle(_mcx,_mcy,_mradius,_hmitileutils._color_border_default /*int*/ ,__c.False,(float) (_mborderwidth));
 //BA.debugLineNum = 126;BA.debugLine="CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, H";
_cvslevelindicator.DrawCircle(_mcx,_mcy,_mradius,_hmitileutils._color_indicator_track /*int*/ ,__c.True,(float) (0));
 //BA.debugLineNum = 129;BA.debugLine="If mValue < 0 Then mValue = 0";
if (_mvalue<0) { 
_mvalue = (float) (0);};
 //BA.debugLineNum = 130;BA.debugLine="If mValue > 100 Then mValue = 100";
if (_mvalue>100) { 
_mvalue = (float) (100);};
 //BA.debugLineNum = 132;BA.debugLine="Dim h As Float = (mValue / 100) * (2 * mRadius)";
_h = (float) ((_mvalue/(double)100)*(2*_mradius));
 //BA.debugLineNum = 133;BA.debugLine="Dim topY As Float = mCy + mRadius - h";
_topy = (float) (_mcy+_mradius-_h);
 //BA.debugLineNum = 136;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 137;BA.debugLine="p.Initialize(mCx - mRadius, topY)";
_p.Initialize((float) (_mcx-_mradius),_topy);
 //BA.debugLineNum = 138;BA.debugLine="p.LineTo(mCx + mRadius, topY)";
_p.LineTo((float) (_mcx+_mradius),_topy);
 //BA.debugLineNum = 139;BA.debugLine="p.LineTo(mCx + mRadius, mCy + mRadius)";
_p.LineTo((float) (_mcx+_mradius),(float) (_mcy+_mradius));
 //BA.debugLineNum = 140;BA.debugLine="p.LineTo(mCx - mRadius, mCy + mRadius)";
_p.LineTo((float) (_mcx-_mradius),(float) (_mcy+_mradius));
 //BA.debugLineNum = 143;BA.debugLine="CvsLevelIndicator.ClipPath(p)";
_cvslevelindicator.ClipPath(_p);
 //BA.debugLineNum = 144;BA.debugLine="CvsLevelIndicator.DrawCircle(mCx, mCy, mRadius, H";
_cvslevelindicator.DrawCircle(_mcx,_mcy,_mradius,_hmitileutils._color_indicator_level /*int*/ ,__c.True,(float) (0));
 //BA.debugLineNum = 145;BA.debugLine="CvsLevelIndicator.RemoveClip";
_cvslevelindicator.RemoveClip();
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 184;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 211;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 156;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 176;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public float  _getvalue() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub getValue As Float";
 //BA.debugLineNum = 168;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 58;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 59;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 60;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public String  _panelevelindicator_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Private Sub PaneLevelIndicator_MouseClicked (Event";
 //BA.debugLineNum = 231;BA.debugLine="Click";
_click();
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _redraw() throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Private Sub Redraw";
 //BA.debugLineNum = 112;BA.debugLine="If PaneLevelIndicator.IsInitialized Then";
if (_panelevelindicator.IsInitialized()) { 
 //BA.debugLineNum = 113;BA.debugLine="DrawLevelIndicator";
_drawlevelindicator();
 };
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 180;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 181;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 206;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 207;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 153;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 172;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 173;BA.debugLine="LabelUnit.Text = mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(float _value) throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub setValue(value As Float)";
 //BA.debugLineNum = 161;BA.debugLine="If LabelValue.IsInitialized Then";
if (_labelvalue.IsInitialized()) { 
 //BA.debugLineNum = 162;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 163;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 164;BA.debugLine="LabelValue.Text = NumberFormat(mValue, 1, mDigit";
_labelvalue.setText(__c.NumberFormat(_mvalue,(int) (1),_mdigits));
 };
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 197;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 200;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 201;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 189;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 193;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
