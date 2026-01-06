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
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public String _mvaluetext = "";
public String _mvalue = "";
public String _munittext = "";
public String _mtypestyle = "";
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 73;BA.debugLine="mBase.LoadLayout(\"hmitilesensor\")";
_mbase.LoadLayout("hmitilesensor",ba);
 //BA.debugLineNum = 76;BA.debugLine="LabelTitle.Text = Props.Get(\"TitleText\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("TitleText"))));
 //BA.debugLineNum = 77;BA.debugLine="LabelIcon.Text  = Props.Get(\"Icon\")";
_labelicon.setText(BA.ObjectToString(_props.Get((Object)("Icon"))));
 //BA.debugLineNum = 78;BA.debugLine="LabelValue.Text = Props.Get(\"ValueText\")";
_labelvalue.setText(BA.ObjectToString(_props.Get((Object)("ValueText"))));
 //BA.debugLineNum = 79;BA.debugLine="mValueText		= Props.Get(\"ValueText\")";
_mvaluetext = BA.ObjectToString(_props.Get((Object)("ValueText")));
 //BA.debugLineNum = 80;BA.debugLine="mValue = mValueText";
_mvalue = _mvaluetext;
 //BA.debugLineNum = 81;BA.debugLine="mUnitText		= Props.Get(\"UnitText\")";
_munittext = BA.ObjectToString(_props.Get((Object)("UnitText")));
 //BA.debugLineNum = 82;BA.debugLine="mTypeStyle		= Props.Get(\"TypeStyle\")";
_mtypestyle = BA.ObjectToString(_props.Get((Object)("TypeStyle")));
 //BA.debugLineNum = 85;BA.debugLine="setIcon(LabelIcon.Text)";
_seticon(_labelicon.getText());
 //BA.debugLineNum = 87;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 88;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _tilestate) throws Exception{
int _state = 0;
int _clr = 0;
 //BA.debugLineNum = 192;BA.debugLine="Public Sub ApplyStyle(tilestate As String)";
 //BA.debugLineNum = 193;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 194;BA.debugLine="LabelIcon.TextSize = HMITileUtils.TEXT_SIZE_ICON";
_labelicon.setTextSize(_hmitileutils._text_size_icon /*float*/ );
 //BA.debugLineNum = 195;BA.debugLine="LabelIcon.TextColor = HMITileUtils.COLOR_TEXT_PRI";
_labelicon.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 //BA.debugLineNum = 196;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 198;BA.debugLine="Dim state As Int = HMITileUtils.StateStyleToState";
_state = _hmitileutils._statestyletostate /*int*/ (_tilestate);
 //BA.debugLineNum = 199;BA.debugLine="Dim clr As Int = HMITileUtils.COLOR_TEXT_PRIMARY";
_clr = _hmitileutils._color_text_primary /*int*/ ;
 //BA.debugLineNum = 201;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 203;BA.debugLine="clr = HMITileUtils.COLOR_TEXT_PRIMARY";
_clr = _hmitileutils._color_text_primary /*int*/ ;
 //BA.debugLineNum = 204;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 207;BA.debugLine="clr = HMITileUtils.COLOR_TILE_WARNING_TEXT";
_clr = _hmitileutils._color_tile_warning_text /*int*/ ;
 //BA.debugLineNum = 208;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 211;BA.debugLine="clr = HMITileUtils.COLOR_TILE_ALARM_TEXT";
_clr = _hmitileutils._color_tile_alarm_text /*int*/ ;
 //BA.debugLineNum = 212;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 215;BA.debugLine="clr = HMITileUtils.COLOR_TILE_DISABLED_TEXT";
_clr = _hmitileutils._color_tile_disabled_text /*int*/ ;
 //BA.debugLineNum = 216;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 218;BA.debugLine="LabelTitle.TextColor = clr";
_labeltitle.setTextColor(_clr);
 //BA.debugLineNum = 219;BA.debugLine="LabelValue.TextColor = clr";
_labelvalue.setTextColor(_clr);
 //BA.debugLineNum = 220;BA.debugLine="LabelIcon.TextColor = clr";
_labelicon.setTextColor(_clr);
 //BA.debugLineNum = 221;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 91;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 92;BA.debugLine="If Not(LabelValue.IsInitialized) Then Return";
if (__c.Not(_labelvalue.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 94;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + 4dip";
_pad = (int) (_hmitileutils._border_width /*double*/ +__c.DipToCurrent((int) (4)));
 //BA.debugLineNum = 96;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad, pad, Width -";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 97;BA.debugLine="LabelIcon.SetLayoutAnimated(0, pad, Height*0.25,";
_labelicon.SetLayoutAnimated((int) (0),_pad,_height*0.25,_width-_pad*2,_height*0.50);
 //BA.debugLineNum = 98;BA.debugLine="LabelValue.SetLayoutAnimated(0, pad, Height*0.75,";
_labelvalue.SetLayoutAnimated((int) (0),_pad,_height*0.75,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 33;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 34;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 37;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
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
 //BA.debugLineNum = 50;BA.debugLine="Private mValueText As String";
_mvaluetext = "";
 //BA.debugLineNum = 51;BA.debugLine="Private mValue As String";
_mvalue = "";
 //BA.debugLineNum = 52;BA.debugLine="Private mUnitText As String";
_munittext = "";
 //BA.debugLineNum = 53;BA.debugLine="Private mTypeStyle As String";
_mtypestyle = "";
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Public Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 65;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 66;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 67;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 68;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 69;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _geticon() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub getIcon As String";
 //BA.debugLineNum = 128;BA.debugLine="Return LabelIcon.Text";
if (true) return _labelicon.getText();
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 109;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public String  _gettypestyle() throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub getTypeStyle As String";
 //BA.debugLineNum = 181;BA.debugLine="Return mTypeStyle";
if (true) return _mtypestyle;
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 161;BA.debugLine="Return mUnitText";
if (true) return _munittext;
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
 //BA.debugLineNum = 58;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 59;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 60;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public String  _labelicon_click() throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Private Sub LabelIcon_Click";
 //BA.debugLineNum = 237;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 238;BA.debugLine="CallSub(mCallBack, mEventName & \"_Click\")";
__c.CallSubNew(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _labelicon_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Private Sub LabelIcon_MouseClicked(EventData As Mo";
 //BA.debugLineNum = 231;BA.debugLine="LabelIcon_Click";
_labelicon_click();
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _seticon(String _iconhex) throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Public Sub setIcon(iconHex As String)";
 //BA.debugLineNum = 114;BA.debugLine="If iconHex == \"\" Then Return";
if ((_iconhex).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 117;BA.debugLine="Try";
try { //BA.debugLineNum = 118;BA.debugLine="If iconHex.Length > 0 And iconHex.Length <";
if (_iconhex.length()>0 && _iconhex.length()<=6 && _iconhex.toLowerCase().startsWith("f")) { 
 //BA.debugLineNum = 119;BA.debugLine="LabelIcon.Text = Chr(Bit.ParseInt(icon";
_labelicon.setText(BA.ObjectToString(__c.Chr(__c.Bit.ParseInt(_iconhex,(int) (16)))));
 }else {
 //BA.debugLineNum = 121;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(_iconhex);
 };
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 124;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(_iconhex);
 };
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _seticoncolor(int _clr) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Public Sub SetIconColor(clr As Int)";
 //BA.debugLineNum = 132;BA.debugLine="LabelIcon.TextColor = clr";
_labelicon.setTextColor(_clr);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _seticonscale(float _scale) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub SetIconScale(scale As Float)";
 //BA.debugLineNum = 140;BA.debugLine="LabelIcon.TextSize = LabelTitle.TextSize * scale";
_labelicon.setTextSize(_labeltitle.getTextSize()*_scale);
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _seticonsize(int _size) throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Public Sub SetIconSize(size As Int)";
 //BA.debugLineNum = 136;BA.debugLine="LabelIcon.TextSize = size";
_labelicon.setTextSize(_size);
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _setstylealarm() throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Public Sub SetStyleAlarm";
 //BA.debugLineNum = 173;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)";
_settypestyle(_hmitileutils._typestyle_alarm /*String*/ );
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public String  _setstylenormal() throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Public Sub SetStyleNormal";
 //BA.debugLineNum = 165;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)";
_settypestyle(_hmitileutils._typestyle_normal /*String*/ );
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _setstylewarning() throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Public Sub SetStyleWarning";
 //BA.debugLineNum = 169;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)";
_settypestyle(_hmitileutils._typestyle_warning /*String*/ );
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 106;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _settypestyle(String _value) throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub setTypeStyle(value As String)";
 //BA.debugLineNum = 177;BA.debugLine="mTypeStyle = value";
_mtypestyle = _value;
 //BA.debugLineNum = 178;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 157;BA.debugLine="mUnitText = unit";
_munittext = _unit;
 //BA.debugLineNum = 158;BA.debugLine="LabelValue.Text =  mValueText & unit";
_labelvalue.setText(_mvaluetext+_unit);
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(String _value) throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Public Sub setValue(value As String)";
 //BA.debugLineNum = 145;BA.debugLine="Try";
try { //BA.debugLineNum = 146;BA.debugLine="mValue = value";
_mvalue = _value;
 //BA.debugLineNum = 147;BA.debugLine="LabelValue.Text = value & mUnitText";
_labelvalue.setText(_value+_munittext);
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 149;BA.debugLine="Log($\"[HMITileSensor.setValue][E] ${LastExceptio";
__c.LogImpl("965142789",("[HMITileSensor.setValue][E] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
