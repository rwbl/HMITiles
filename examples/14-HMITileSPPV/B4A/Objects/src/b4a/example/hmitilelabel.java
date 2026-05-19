package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitilelabel extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitilelabel");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitilelabel.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltext = null;
public String _mtext = "";
public String _mstatus = "";
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 73;BA.debugLine="mBase.LoadLayout(\"hmitilelabel\")";
_mbase.LoadLayout("hmitilelabel",ba);
 //BA.debugLineNum = 75;BA.debugLine="mText			= Props.Get(\"Text\")";
_mtext = BA.ObjectToString(_props.Get((Object)("Text")));
 //BA.debugLineNum = 76;BA.debugLine="LabelText.Text	= mText";
_labeltext.setText(BA.ObjectToCharSequence(_mtext));
 //BA.debugLineNum = 77;BA.debugLine="mStatus 		= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 78;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 79;BA.debugLine="ApplyStatusStyle(mStatus)";
_applystatusstyle(_mstatus);
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 158;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 161;BA.debugLine="LabelText.TextSize = HMITileUtils.TEXT_SIZE_TITLE";
_labeltext.setTextSize(_hmitileutils._text_size_title /*float*/ );
 //BA.debugLineNum = 162;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_PRI";
_labeltext.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 //BA.debugLineNum = 164;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_hmitileutils._status_normal /*String*/ ,_hmitileutils._status_warning /*String*/ ,_hmitileutils._status_alarm /*String*/ ,_hmitileutils._status_disabled /*String*/ )) {
case 0: {
 //BA.debugLineNum = 166;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BA";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 167;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_P";
_labeltext.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 break; }
case 1: {
 //BA.debugLineNum = 170;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_WARNING_B";
_mbase.setColor(_hmitileutils._color_tile_warning_background /*int*/ );
 //BA.debugLineNum = 171;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_W";
_labeltext.setTextColor(_hmitileutils._color_text_warning /*int*/ );
 break; }
case 2: {
 //BA.debugLineNum = 174;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_ALARM_BAC";
_mbase.setColor(_hmitileutils._color_tile_alarm_background /*int*/ );
 //BA.debugLineNum = 175;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_E";
_labeltext.setTextColor(_hmitileutils._color_text_error /*int*/ );
 break; }
case 3: {
 //BA.debugLineNum = 178;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_DISABLED_";
_mbase.setColor(_hmitileutils._color_tile_disabled_background /*int*/ );
 //BA.debugLineNum = 179;BA.debugLine="LabelText.TextColor = HMITileUtils.COLOR_TEXT_D";
_labeltext.setTextColor(_hmitileutils._color_text_disabled /*int*/ );
 break; }
}
;
 //BA.debugLineNum = 182;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _offset = 0;
 //BA.debugLineNum = 82;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 84;BA.debugLine="If Not(LabelText.IsInitialized) Then Return";
if (__c.Not(_labeltext.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 86;BA.debugLine="Dim offset As Int = HMITileUtils.BORDER_WIDTH";
_offset = (int) (_hmitileutils._border_width /*double*/ );
 //BA.debugLineNum = 87;BA.debugLine="LabelText.SetLayoutAnimated(0, offset, offset, Wi";
_labeltext.SetLayoutAnimated((int) (0),_offset,_offset,(int) (_width-_offset*2),(int) (_height-_offset*2));
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 38;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
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
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 64;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 65;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 66;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 67;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 69;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 106;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 145;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public String  _gettext() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Public Sub getText As String";
 //BA.debugLineNum = 98;BA.debugLine="Return LabelText.Text";
if (true) return _labeltext.getText();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 198;BA.debugLine="Private Sub LabelText_Click";
 //BA.debugLineNum = 199;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 200;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 102;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 103;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (ba,_mbase.getEnabled()));
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public String  _setfontawesome(boolean _large) throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Public Sub SetFontAwesome(large As Boolean)";
 //BA.debugLineNum = 111;BA.debugLine="If large Then";
if (_large) { 
 //BA.debugLineNum = 112;BA.debugLine="LabelText.Font = xui.CreateFontAwesome(HMITileUt";
_labeltext.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon_large /*float*/ ));
 }else {
 //BA.debugLineNum = 114;BA.debugLine="LabelText.Font = xui.CreateFontAwesome(HMITileUt";
_labeltext.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 };
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public String  _setfontdefault() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Public Sub SetFontDefault";
 //BA.debugLineNum = 120;BA.debugLine="LabelText.Font = xui.CreateDefaultFont(HMITileUti";
_labeltext.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 142;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _settext(String _text) throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Public Sub setText(text As String)";
 //BA.debugLineNum = 95;BA.debugLine="LabelText.Text = text";
_labeltext.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm(String _text) throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Public Sub StatusAlarm(text As String)";
 //BA.debugLineNum = 133;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled(String _text) throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Public Sub StatusDisabled(text As String)";
 //BA.debugLineNum = 137;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal(String _text) throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Public Sub StatusNormal(text As String)";
 //BA.debugLineNum = 125;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning(String _text) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Public Sub StatusWarning(text As String)";
 //BA.debugLineNum = 129;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
