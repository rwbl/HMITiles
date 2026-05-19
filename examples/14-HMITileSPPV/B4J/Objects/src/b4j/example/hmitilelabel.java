package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilelabel extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilelabel", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilelabel.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltext = null;
public String _mtext = "";
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
 //BA.debugLineNum = 72;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 73;BA.debugLine="BasePane.LoadLayout(\"hmitilelabel\")";
_basepane.LoadLayout("hmitilelabel",ba);
 //BA.debugLineNum = 75;BA.debugLine="mText			= Props.Get(\"Text\")";
_mtext = BA.ObjectToString(_props.Get((Object)("Text")));
 //BA.debugLineNum = 76;BA.debugLine="LabelText.Text	= mText";
_labeltext.setText(_mtext);
 //BA.debugLineNum = 77;BA.debugLine="mStatus 		= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 78;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 79;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 158;BA.debugLine="LabelText.TextSize = HMITileUtils.TEXT_SIZE_TITLE";
_labeltext.setTextSize(_hmitileutils._text_size_title /*float*/ );
 //BA.debugLineNum = 159;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRI";
_labeltext.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 //BA.debugLineNum = 161;BA.debugLine="Select mStatus";
switch (BA.switchObjectToInt(_mstatus,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ )) {
case 0: {
 //BA.debugLineNum = 163;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 164;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_P";
_labeltext.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 167;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_WARNIN";
_basepane.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 //BA.debugLineNum = 168;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_W";
_labeltext.setTextColor(_hmitileutils._color_text_warning /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 171;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_ALARM_";
_basepane.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 //BA.debugLineNum = 172;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_E";
_labeltext.setTextColor(_hmitileutils._color_text_error /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 174;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 83;BA.debugLine="If Not(LabelText.IsInitialized) Then Return";
if (__c.Not(_labeltext.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 85;BA.debugLine="LabelText.SetLayoutAnimated(0, 0, 0, Width, Heigh";
_labeltext.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 38;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Public BaseLabel As B4XView";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 43;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
 //BA.debugLineNum = 44;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 47;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 48;BA.debugLine="Private LabelText As B4XView";
_labeltext = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private mText As String";
_mtext = "";
 //BA.debugLineNum = 52;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 64;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 65;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 66;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 67;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 69;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 104;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 144;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public String  _gettext() throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Public Sub getText As String";
 //BA.debugLineNum = 96;BA.debugLine="Return LabelText.Text";
if (true) return _labeltext.getText();
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 57;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 58;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 59;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_click() throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Private Sub LabelText_Click";
 //BA.debugLineNum = 190;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Private Sub LabelText_MouseClicked (EventData As M";
 //BA.debugLineNum = 184;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 100;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 101;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public String  _setfontawesome(boolean _large) throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Public Sub SetFontAwesome(large As Boolean)";
 //BA.debugLineNum = 109;BA.debugLine="If large Then";
if (_large) { 
 //BA.debugLineNum = 110;BA.debugLine="LabelText.Font = xui.CreateFontAwesome(HMITileUt";
_labeltext.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon_large /*float*/ ));
 }else {
 //BA.debugLineNum = 112;BA.debugLine="LabelText.Font = xui.CreateFontAwesome(HMITileUt";
_labeltext.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 };
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _setfontdefault() throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Public Sub SetFontDefault";
 //BA.debugLineNum = 118;BA.debugLine="LabelText.Font = xui.CreateDefaultFont(HMITileUti";
_labeltext.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 140;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 141;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _settext(String _text) throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Public Sub setText(text As String)";
 //BA.debugLineNum = 93;BA.debugLine="LabelText.Text = text";
_labeltext.setText(_text);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 130;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 131;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled() throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Public Sub StatusDisabled";
 //BA.debugLineNum = 135;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 123;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 127;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public String  _tileclick() throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Private Sub TileClick";
 //BA.debugLineNum = 194;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 195;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
