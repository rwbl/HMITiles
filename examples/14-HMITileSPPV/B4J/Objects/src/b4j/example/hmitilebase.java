package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilebase extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilebase", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilebase.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelunit = null;
public String _meventname = "";
public Object _mcallback = null;
public String _mtitle = "";
public String _mvalue = "";
public String _munit = "";
public String _mstatus = "";
public double _mvaluesize = 0;
public int _mvaluecolor = 0;
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
 //BA.debugLineNum = 70;BA.debugLine="BasePane.LoadLayout(\"hmitilebase\")";
_basepane.LoadLayout("hmitilebase",ba);
 //BA.debugLineNum = 73;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 74;BA.debugLine="LabelTitle.Text	= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 75;BA.debugLine="mValue			= Props.Get(\"Value\")";
_mvalue = BA.ObjectToString(_props.Get((Object)("Value")));
 //BA.debugLineNum = 76;BA.debugLine="LabelValue.Text	= mValue";
_labelvalue.setText(_mvalue);
 //BA.debugLineNum = 77;BA.debugLine="mValueSize		= LabelValue.TextSize";
_mvaluesize = _labelvalue.getTextSize();
 //BA.debugLineNum = 78;BA.debugLine="mValueColor		= LabelValue.TextColor";
_mvaluecolor = _labelvalue.getTextColor();
 //BA.debugLineNum = 79;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 80;BA.debugLine="LabelUnit.Text	= mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 81;BA.debugLine="mStatus 		= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 83;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 84;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 85;BA.debugLine="setStatus(mStatus)";
_setstatus(_mstatus);
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 189;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 190;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 191;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 192;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 193;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 89;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 91;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0, 0,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 92;BA.debugLine="LabelValue.SetLayoutAnimated	(0, 0, 0, 				Width,";
_labelvalue.SetLayoutAnimated((int) (0),0,0,_width,_height*1.00);
 //BA.debugLineNum = 93;BA.debugLine="LabelUnit.SetLayoutAnimated  	(0, 0, Height * 0.8";
_labelunit.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 29;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private BaseLabel As B4XView	'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 34;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 35;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
 //BA.debugLineNum = 41;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 44;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 45;BA.debugLine="Private mValue As String";
_mvalue = "";
 //BA.debugLineNum = 46;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 47;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 50;BA.debugLine="Private mValueSize As Double";
_mvaluesize = 0;
 //BA.debugLineNum = 51;BA.debugLine="Private mValueColor As Int";
_mvaluecolor = 0;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 61;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 62;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 63;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 64;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 66;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 158;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 159;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 181;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 105;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 151;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public String  _getvalue() throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub getValue As String";
 //BA.debugLineNum = 113;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public int  _getvaluecolor() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Public Sub getValueColor As Int";
 //BA.debugLineNum = 129;BA.debugLine="Return mValueColor";
if (true) return _mvaluecolor;
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return 0;
}
public double  _getvaluesize() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Public Sub getValueSize As Double";
 //BA.debugLineNum = 121;BA.debugLine="Return mValueSize";
if (true) return _mvaluesize;
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 54;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 55;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 56;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public String  _labelvalue_click() throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Private Sub LabelValue_Click";
 //BA.debugLineNum = 209;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public String  _labelvalue_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Private Sub LabelValue_MouseClicked (EventData As";
 //BA.debugLineNum = 203;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 155;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 156;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 177;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 178;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 101;BA.debugLine="mTitle = value";
_mtitle = _value;
 //BA.debugLineNum = 102;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _value) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub setUnit(value As String)";
 //BA.debugLineNum = 147;BA.debugLine="mUnit = value";
_munit = _value;
 //BA.debugLineNum = 148;BA.debugLine="LabelUnit.Text = mUnit";
_labelunit.setText(_munit);
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(String _value) throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Public Sub setValue(value As String)";
 //BA.debugLineNum = 109;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 110;BA.debugLine="LabelValue.Text = mValue";
_labelvalue.setText(_mvalue);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _setvaluecolor(int _value) throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Public Sub setValueColor(value As Int)";
 //BA.debugLineNum = 125;BA.debugLine="mValueColor = value";
_mvaluecolor = _value;
 //BA.debugLineNum = 126;BA.debugLine="LabelValue.TextColor = value";
_labelvalue.setTextColor(_value);
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _setvaluefontawesome(boolean _large) throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Public Sub SetValueFontAwesome(large As Boolean)";
 //BA.debugLineNum = 134;BA.debugLine="If large Then";
if (_large) { 
 //BA.debugLineNum = 135;BA.debugLine="LabelValue.Font = xui.CreateFontAwesome(HMITileU";
_labelvalue.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon_large /*float*/ ));
 }else {
 //BA.debugLineNum = 137;BA.debugLine="LabelValue.Font = xui.CreateFontAwesome(HMITileU";
_labelvalue.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 };
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public String  _setvaluefontdefault() throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Public Sub SetValueFontDefault";
 //BA.debugLineNum = 143;BA.debugLine="LabelValue.Font = xui.CreateDefaultFont(HMITileUt";
_labelvalue.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public String  _setvaluesize(double _value) throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Public Sub setValueSize(value As Double)";
 //BA.debugLineNum = 117;BA.debugLine="mValueSize = value";
_mvaluesize = _value;
 //BA.debugLineNum = 118;BA.debugLine="LabelValue.TextSize = value";
_labelvalue.setTextSize(_value);
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 172;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 164;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 168;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public String  _tileclick() throws Exception{
 //BA.debugLineNum = 212;BA.debugLine="Private Sub TileClick";
 //BA.debugLineNum = 213;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 214;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
