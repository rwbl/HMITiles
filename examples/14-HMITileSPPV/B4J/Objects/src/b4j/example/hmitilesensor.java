package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilesensor extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilesensor", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilesensor.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelunit = null;
public String _mtitle = "";
public String _mvalue = "";
public String _munit = "";
public String _mstatus = "";
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 74;BA.debugLine="BasePane.LoadLayout(\"hmitilesensor\")";
_basepane.LoadLayout("hmitilesensor",ba);
 //BA.debugLineNum = 77;BA.debugLine="mTitle				= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 78;BA.debugLine="LabelTitle.Text 	= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 79;BA.debugLine="LabelIcon.Text  	= Props.Get(\"Icon\")";
_labelicon.setText(BA.ObjectToString(_props.Get((Object)("Icon"))));
 //BA.debugLineNum = 81;BA.debugLine="If LabelIcon.Text.ToLowerCase.Contains(\"0x\") Then";
if (_labelicon.getText().toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale).contains("0x")) { 
 //BA.debugLineNum = 82;BA.debugLine="LabelIcon.Text = LabelIcon.Text.ToLowerCase.Repl";
_labelicon.setText(_labelicon.getText().toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale).replace("0x",""));
 };
 //BA.debugLineNum = 84;BA.debugLine="mValue				= Props.Get(\"Value\")";
_mvalue = BA.ObjectToString(_props.Get((Object)("Value")));
 //BA.debugLineNum = 85;BA.debugLine="LabelValue.Text 	= mValue";
_labelvalue.setText(_mvalue);
 //BA.debugLineNum = 86;BA.debugLine="mUnit				= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 87;BA.debugLine="LabelUnit.Text		= mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 88;BA.debugLine="mStatus				= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 90;BA.debugLine="setIcon(LabelIcon.Text)";
_seticon(_labelicon.getText());
 //BA.debugLineNum = 91;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 92;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 197;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 198;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 199;BA.debugLine="HMITileUtils.ApplyIconStyle(LabelIcon)";
_hmitileutils._applyiconstyle /*String*/ (_labelicon);
 //BA.debugLineNum = 200;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 201;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 202;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 96;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 99;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0, 0,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 100;BA.debugLine="LabelIcon.SetLayoutAnimated		(0, 0, Height * 0.25";
_labelicon.SetLayoutAnimated((int) (0),0,_height*0.25,_width,_height*0.30);
 //BA.debugLineNum = 101;BA.debugLine="LabelValue.SetLayoutAnimated	(0, 0, Height * 0.55";
_labelvalue.SetLayoutAnimated((int) (0),0,_height*0.55,_width,_height*0.35);
 //BA.debugLineNum = 102;BA.debugLine="LabelUnit.SetLayoutAnimated  	(0, 0, Height * 0.8";
_labelunit.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 33;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 34;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 37;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private BaseLabel As B4XView	'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 42;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 45;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private LabelIcon As B4XView";
_labelicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 52;BA.debugLine="Private mValue As String";
_mvalue = "";
 //BA.debugLineNum = 53;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 54;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 66;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 67;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 68;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 69;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 70;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public String  _geticon() throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Public Sub getIcon As String";
 //BA.debugLineNum = 132;BA.debugLine="Return LabelIcon.Text";
if (true) return _labelicon.getText();
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 188;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 113;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 161;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public String  _getvalue() throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Public Sub getValue As String";
 //BA.debugLineNum = 153;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 59;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 60;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 61;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _labelicon_click() throws Exception{
 //BA.debugLineNum = 217;BA.debugLine="Private Sub LabelIcon_Click";
 //BA.debugLineNum = 218;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 219;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
return "";
}
public String  _labelicon_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Private Sub LabelIcon_MouseClicked(EventData As Mo";
 //BA.debugLineNum = 212;BA.debugLine="LabelIcon_Click";
_labelicon_click();
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public String  _seticon(String _iconhex) throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Public Sub setIcon(iconHex As String)";
 //BA.debugLineNum = 118;BA.debugLine="If iconHex == \"\" Then Return";
if ((_iconhex).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 121;BA.debugLine="Try";
try { //BA.debugLineNum = 122;BA.debugLine="If iconHex.Length > 0 And iconHex.Length <";
if (_iconhex.length()>0 && _iconhex.length()<=6 && _iconhex.toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale).startsWith("f")) { 
 //BA.debugLineNum = 123;BA.debugLine="LabelIcon.Text = Chr(Bit.ParseInt(icon";
_labelicon.setText(BA.ObjectToString(__c.Chr(__c.Bit.ParseInt(_iconhex,(int) (16)))));
 }else {
 //BA.debugLineNum = 125;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(_iconhex);
 };
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 128;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(_iconhex);
 };
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public String  _seticoncolor(int _clr) throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Public Sub SetIconColor(clr As Int)";
 //BA.debugLineNum = 136;BA.debugLine="LabelIcon.TextColor = clr";
_labelicon.setTextColor(_clr);
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _seticonscale(float _scale) throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Public Sub SetIconScale(scale As Float)";
 //BA.debugLineNum = 144;BA.debugLine="LabelIcon.TextSize = LabelTitle.TextSize * scale";
_labelicon.setTextSize(_labeltitle.getTextSize()*_scale);
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public String  _seticonsize(int _size) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub SetIconSize(size As Int)";
 //BA.debugLineNum = 140;BA.debugLine="LabelIcon.TextSize = size";
_labelicon.setTextSize(_size);
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 183;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 184;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 110;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 157;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 158;BA.debugLine="LabelUnit.Text =  mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(String _value) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub setValue(value As String)";
 //BA.debugLineNum = 149;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 150;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(_mvalue);
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 173;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 174;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 178;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 166;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 170;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
