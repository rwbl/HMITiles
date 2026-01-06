package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilebutton extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilebutton", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilebutton.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public Object _tag = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelstate = null;
public String _mtypestyle = "";
public boolean _mispressed = false;
public boolean _mstate = false;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 118;BA.debugLine="mBase.LoadLayout(\"hmitilebutton\")";
_mbase.LoadLayout("hmitilebutton",ba);
 //BA.debugLineNum = 119;BA.debugLine="LabelTitle.Text	= Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 120;BA.debugLine="LabelState.Text	= Props.Get(\"State\")";
_labelstate.setText(BA.ObjectToString(_props.Get((Object)("State"))));
 //BA.debugLineNum = 121;BA.debugLine="mTypeStyle 		= Props.Get(\"TypeStyle\")";
_mtypestyle = BA.ObjectToString(_props.Get((Object)("TypeStyle")));
 //BA.debugLineNum = 122;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 123;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _tilestate) throws Exception{
int _textcolor = 0;
int _state = 0;
 //BA.debugLineNum = 228;BA.debugLine="Public Sub ApplyStyle(tilestate As String)";
 //BA.debugLineNum = 229;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 230;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelState)";
_hmitileutils._applyvaluestyle /*String*/ (_labelstate);
 //BA.debugLineNum = 232;BA.debugLine="Dim textcolor As Int = HMITileUtils.COLOR_TILE_NO";
_textcolor = _hmitileutils._color_tile_normal_text /*int*/ ;
 //BA.debugLineNum = 234;BA.debugLine="Dim state As Int = HMITileUtils.StateStyleToState";
_state = _hmitileutils._statestyletostate /*int*/ (_tilestate);
 //BA.debugLineNum = 236;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 239;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_NORMAL_TEXT";
_textcolor = _hmitileutils._color_tile_normal_text /*int*/ ;
 //BA.debugLineNum = 240;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 243;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_WARNING_TEX";
_textcolor = _hmitileutils._color_tile_warning_text /*int*/ ;
 //BA.debugLineNum = 244;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 247;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_ALARM_TEXT";
_textcolor = _hmitileutils._color_tile_alarm_text /*int*/ ;
 //BA.debugLineNum = 248;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 251;BA.debugLine="textcolor = HMITileUtils.COLOR_TILE_DISABLED_TE";
_textcolor = _hmitileutils._color_tile_disabled_text /*int*/ ;
 //BA.debugLineNum = 252;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 254;BA.debugLine="LabelTitle.TextColor = textcolor";
_labeltitle.setTextColor(_textcolor);
 //BA.debugLineNum = 255;BA.debugLine="LabelState.TextColor = textcolor";
_labelstate.setTextColor(_textcolor);
 //BA.debugLineNum = 256;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 126;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 127;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(LabelStat";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_labelstate.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 129;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 131;BA.debugLine="LabelTitle.SetLayoutAnimated(0, pad,  pad,";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_height*0.25);
 //BA.debugLineNum = 132;BA.debugLine="LabelState.SetLayoutAnimated(0, pad,  Height * 0.";
_labelstate.SetLayoutAnimated((int) (0),_pad,_height*0.25,_width-_pad*2,_height*0.60);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 85;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 86;BA.debugLine="Private mLbl As B4XView			'ignore";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 87;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 90;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 91;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 94;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 95;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 96;BA.debugLine="Private LabelState As B4XView";
_labelstate = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 99;BA.debugLine="Private mTypeStyle As String";
_mtypestyle = "";
 //BA.debugLineNum = 100;BA.debugLine="Private mIsPressed As Boolean = False			'ignore";
_mispressed = __c.False;
 //BA.debugLineNum = 101;BA.debugLine="Private mState As Boolean = False";
_mstate = __c.False;
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 110;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 111;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 112;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 113;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 114;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 185;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 186;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return false;
}
public boolean  _getstate() throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Public Sub getState As Boolean";
 //BA.debugLineNum = 162;BA.debugLine="Return mState";
if (true) return _mstate;
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return false;
}
public String  _getstatetext() throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Public Sub getStateText As String";
 //BA.debugLineNum = 153;BA.debugLine="Return LabelState.Text";
if (true) return _labelstate.getText();
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 145;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public String  _gettypestyle() throws Exception{
 //BA.debugLineNum = 215;BA.debugLine="Public Sub getTypeStyle As String";
 //BA.debugLineNum = 216;BA.debugLine="Return mTypeStyle";
if (true) return _mtypestyle;
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 104;BA.debugLine="Private Sub Initialize (Callback As Object, EventN";
 //BA.debugLineNum = 105;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 106;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _labelstate_click() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Private Sub LabelState_Click";
 //BA.debugLineNum = 272;BA.debugLine="mState = Not(mState)";
_mstate = __c.Not(_mstate);
 //BA.debugLineNum = 273;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 274;BA.debugLine="CallSub(mCallBack, mEventName & \"_Click\")";
__c.CallSubNew(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
public String  _labelstate_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 265;BA.debugLine="Private Sub LabelState_MouseClicked(EventData As M";
 //BA.debugLineNum = 266;BA.debugLine="LabelState_Click";
_labelstate_click();
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return "";
}
public String  _labeltitle_click() throws Exception{
 //BA.debugLineNum = 278;BA.debugLine="Private Sub LabelTitle_Click";
 //BA.debugLineNum = 279;BA.debugLine="LabelState_Click";
_labelstate_click();
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return "";
}
public String  _setalarm(String _text) throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Public Sub SetAlarm(text As String)";
 //BA.debugLineNum = 203;BA.debugLine="setStateText(text)";
_setstatetext(_text);
 //BA.debugLineNum = 204;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_ALARM)";
_settypestyle(_hmitileutils._typestyle_alarm /*String*/ );
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 182;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 183;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (_mbase.getEnabled()));
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public String  _setnormal(String _text) throws Exception{
 //BA.debugLineNum = 190;BA.debugLine="Public Sub SetNormal(text As String)";
 //BA.debugLineNum = 191;BA.debugLine="setStateText(text)";
_setstatetext(_text);
 //BA.debugLineNum = 192;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_NORMAL)";
_settypestyle(_hmitileutils._typestyle_normal /*String*/ );
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _setstate(boolean _state) throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub setState(state As Boolean)";
 //BA.debugLineNum = 158;BA.debugLine="mState = state";
_mstate = _state;
 //BA.debugLineNum = 159;BA.debugLine="HMITileUtils.ApplyStyleStateOnOff(mBase, LabelSta";
_hmitileutils._applystylestateonoff /*String*/ (_mbase,_labelstate,_state);
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public String  _setstatecolor(boolean _success) throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub SetStateColor(success As Boolean)";
 //BA.debugLineNum = 177;BA.debugLine="HMITileUtils.ApplyStyleStateOnOff(mBase, LabelSta";
_hmitileutils._applystylestateonoff /*String*/ (_mbase,_labelstate,_success);
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public String  _setstatefontdefault() throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Public Sub SetStateFontDefault";
 //BA.debugLineNum = 172;BA.debugLine="LabelState.Font = xui.CreateDefaultFont(HMITileUt";
_labelstate.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public String  _setstatefontfontawesome() throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Public Sub SetStateFontFontAwesome";
 //BA.debugLineNum = 167;BA.debugLine="LabelState.Font = xui.CreateFontAwesome(HMITileUt";
_labelstate.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return "";
}
public String  _setstatetext(String _value) throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Public Sub setStateText(value As String)";
 //BA.debugLineNum = 150;BA.debugLine="LabelState.Text = value";
_labelstate.setText(_value);
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 142;BA.debugLine="LabelTitle.Text = value";
_labeltitle.setText(_value);
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _settypestyle(String _value) throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Public Sub setTypeStyle(value As String)";
 //BA.debugLineNum = 212;BA.debugLine="mTypeStyle = value";
_mtypestyle = _value;
 //BA.debugLineNum = 213;BA.debugLine="ApplyStyle(mTypeStyle)";
_applystyle(_mtypestyle);
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public String  _setwarning(String _text) throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Public Sub SetWarning(text As String)";
 //BA.debugLineNum = 197;BA.debugLine="setStateText(text)";
_setstatetext(_text);
 //BA.debugLineNum = 198;BA.debugLine="setTypeStyle(HMITileUtils.TYPESTYLE_WARNING)";
_settypestyle(_hmitileutils._typestyle_warning /*String*/ );
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
