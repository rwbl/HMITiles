package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitilesensor extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitilesensor");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitilesensor.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public String _mtitle = "";
public String _mvalue = "";
public String _munit = "";
public String _mstatus = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 72;BA.debugLine="mBase.LoadLayout(\"hmitilesensor\")";
_mbase.LoadLayout("hmitilesensor",ba);
 //BA.debugLineNum = 75;BA.debugLine="mTitle				= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 76;BA.debugLine="LabelTitle.Text 	= mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 77;BA.debugLine="LabelIcon.Text  	= Props.Get(\"Icon\")";
_labelicon.setText(BA.ObjectToCharSequence(_props.Get((Object)("Icon"))));
 //BA.debugLineNum = 79;BA.debugLine="If LabelIcon.Text.ToLowerCase.Contains(\"0x\") Then";
if (_labelicon.getText().toLowerCase().contains("0x")) { 
 //BA.debugLineNum = 80;BA.debugLine="LabelIcon.Text = LabelIcon.Text.ToLowerCase.Repl";
_labelicon.setText(BA.ObjectToCharSequence(_labelicon.getText().toLowerCase().replace("0x","")));
 };
 //BA.debugLineNum = 82;BA.debugLine="mValue				= Props.Get(\"Value\")";
_mvalue = BA.ObjectToString(_props.Get((Object)("Value")));
 //BA.debugLineNum = 83;BA.debugLine="mUnit				= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 84;BA.debugLine="setValue(mValue)";
_setvalue(_mvalue);
 //BA.debugLineNum = 85;BA.debugLine="mStatus				= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 88;BA.debugLine="setIcon(LabelIcon.Text)";
_seticon(_labelicon.getText());
 //BA.debugLineNum = 90;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 91;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
int _clr = 0;
 //BA.debugLineNum = 200;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 201;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 203;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 204;BA.debugLine="LabelIcon.TextSize = HMITileUtils.TEXT_SIZE_ICON";
_labelicon.setTextSize(_hmitileutils._text_size_icon /*float*/ );
 //BA.debugLineNum = 205;BA.debugLine="LabelIcon.TextColor = HMITileUtils.COLOR_TEXT_PRI";
_labelicon.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 //BA.debugLineNum = 206;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (ba,_labelvalue);
 //BA.debugLineNum = 208;BA.debugLine="Dim clr As Int = HMITileUtils.COLOR_TEXT_PRIMARY";
_clr = _hmitileutils._color_text_primary /*int*/ ;
 //BA.debugLineNum = 209;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 211;BA.debugLine="clr = HMITileUtils.COLOR_TEXT_PRIMARY";
_clr = _hmitileutils._color_text_primary /*int*/ ;
 //BA.debugLineNum = 212;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 215;BA.debugLine="clr = HMITileUtils.COLOR_TILE_WARNING_TEXT";
_clr = _hmitileutils._color_tile_warning_text /*int*/ ;
 //BA.debugLineNum = 216;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 219;BA.debugLine="clr = HMITileUtils.COLOR_TILE_ALARM_TEXT";
_clr = _hmitileutils._color_tile_alarm_text /*int*/ ;
 //BA.debugLineNum = 220;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 223;BA.debugLine="clr = HMITileUtils.COLOR_TILE_DISABLED_TEXT";
_clr = _hmitileutils._color_tile_disabled_text /*int*/ ;
 //BA.debugLineNum = 224;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 226;BA.debugLine="LabelTitle.TextColor = clr";
_labeltitle.setTextColor(_clr);
 //BA.debugLineNum = 227;BA.debugLine="LabelValue.TextColor = clr";
_labelvalue.setTextColor(_clr);
 //BA.debugLineNum = 228;BA.debugLine="LabelIcon.TextColor = clr";
_labelicon.setTextColor(_clr);
 //BA.debugLineNum = 229;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 94;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 95;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 97;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 100;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, pad, pad,";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 101;BA.debugLine="LabelIcon.SetLayoutAnimated		(0, pad, Height * 0.";
_labelicon.SetLayoutAnimated((int) (0),_pad,(int) (_height*0.25),(int) (_width-_pad*2),(int) (_height*0.50));
 //BA.debugLineNum = 102;BA.debugLine="LabelValue.SetLayoutAnimated	(0, pad, Height * 0.";
_labelvalue.SetLayoutAnimated((int) (0),_pad,(int) (_height*0.75),(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 32;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 33;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 36;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private mLbl As B4XView	'ignore";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 41;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 44;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private LabelIcon As B4XView";
_labelicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 50;BA.debugLine="Private mValue As String";
_mvalue = "";
 //BA.debugLineNum = 51;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 52;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 64;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 65;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 66;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 67;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 68;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 57;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 58;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 59;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public String  _labelicon_click() throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Private Sub LabelIcon_Click";
 //BA.debugLineNum = 245;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 246;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _seticon(String _iconhex) throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Public Sub setIcon(iconHex As String)";
 //BA.debugLineNum = 118;BA.debugLine="If iconHex == \"\" Then Return";
if ((_iconhex).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 121;BA.debugLine="Try";
try { //BA.debugLineNum = 122;BA.debugLine="If iconHex.Length > 0 And iconHex.Length <";
if (_iconhex.length()>0 && _iconhex.length()<=6 && _iconhex.toLowerCase().startsWith("f")) { 
 //BA.debugLineNum = 123;BA.debugLine="LabelIcon.Text = Chr(Bit.ParseInt(icon";
_labelicon.setText(BA.ObjectToCharSequence(__c.Chr(__c.Bit.ParseInt(_iconhex,(int) (16)))));
 }else {
 //BA.debugLineNum = 125;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(BA.ObjectToCharSequence(_iconhex));
 };
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 128;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(BA.ObjectToCharSequence(_iconhex));
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
_labelicon.setTextSize((float) (_labeltitle.getTextSize()*_scale));
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public String  _seticonsize(int _size) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub SetIconSize(size As Int)";
 //BA.debugLineNum = 140;BA.debugLine="LabelIcon.TextSize = size";
_labelicon.setTextSize((float) (_size));
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 183;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 184;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 110;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 157;BA.debugLine="mUnit = unit";
_munit = _unit;
 //BA.debugLineNum = 158;BA.debugLine="LabelValue.Text =  mValue & mUnit";
_labelvalue.setText(BA.ObjectToCharSequence(_mvalue+_munit));
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(String _value) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub setValue(value As String)";
 //BA.debugLineNum = 149;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 150;BA.debugLine="LabelValue.Text = mValue & mUnit";
_labelvalue.setText(BA.ObjectToCharSequence(_mvalue+_munit));
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
