package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilelabeltitle extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilelabeltitle", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilelabeltitle.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltext = null;
public String _meventname = "";
public Object _mcallback = null;
public String _mtitle = "";
public String _mtext = "";
public String _mstatus = "";
public double _mtextsize = 0;
public int _mtextcolor = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 75;BA.debugLine="BasePane.LoadLayout(\"hmitilelabeltitle\")";
_basepane.LoadLayout("hmitilelabeltitle",ba);
 //BA.debugLineNum = 78;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 79;BA.debugLine="LabelTitle.Text	= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 80;BA.debugLine="mText			= Props.Get(\"Text\")";
_mtext = BA.ObjectToString(_props.Get((Object)("Text")));
 //BA.debugLineNum = 81;BA.debugLine="LabelText.Text	= mText";
_labeltext.setText(_mtext);
 //BA.debugLineNum = 82;BA.debugLine="mTextSize		= LabelText.TextSize";
_mtextsize = _labeltext.getTextSize();
 //BA.debugLineNum = 83;BA.debugLine="mTextColor		= LabelText.TextColor";
_mtextcolor = _labeltext.getTextColor();
 //BA.debugLineNum = 84;BA.debugLine="mStatus 		= Props.Get(\"Status\")";
_mstatus = BA.ObjectToString(_props.Get((Object)("Status")));
 //BA.debugLineNum = 86;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 87;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 88;BA.debugLine="setStatus(mStatus)";
_setstatus(_mstatus);
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 197;BA.debugLine="HMITileUtils.ApplyTileStyle(BasePane)";
_hmitileutils._applytilestyle /*String*/ (_basepane);
 //BA.debugLineNum = 198;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 199;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelText)";
_hmitileutils._applytitlestyle /*String*/ (_labeltext);
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _l = 0f;
float _t = 0f;
float _w = 0f;
float _h = 0f;
 //BA.debugLineNum = 91;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 92;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(LabelText";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_labeltext.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 94;BA.debugLine="Dim l, t, w, h As Float";
_l = 0f;
_t = 0f;
_w = 0f;
_h = 0f;
 //BA.debugLineNum = 97;BA.debugLine="l = 0";
_l = (float) (0);
 //BA.debugLineNum = 98;BA.debugLine="t = 0";
_t = (float) (0);
 //BA.debugLineNum = 99;BA.debugLine="w = Width";
_w = (float) (_width);
 //BA.debugLineNum = 100;BA.debugLine="h = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACTO";
_h = (float) (_height*_hmitileutils._tile_title_height_factor /*float*/ );
 //BA.debugLineNum = 101;BA.debugLine="LabelTitle.SetLayoutAnimated(0, l, t, w, h)";
_labeltitle.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 104;BA.debugLine="l = 0";
_l = (float) (0);
 //BA.debugLineNum = 105;BA.debugLine="t = Height * HMITileUtils.TILE_TITLE_HEIGHT_FACTO";
_t = (float) (_height*_hmitileutils._tile_title_height_factor /*float*/ );
 //BA.debugLineNum = 106;BA.debugLine="w = Width";
_w = (float) (_width);
 //BA.debugLineNum = 107;BA.debugLine="h = Height * HMITileUtils.TILE_VALUE_HEIGHT_FACTO";
_h = (float) (_height*_hmitileutils._tile_value_height_factor /*float*/ );
 //BA.debugLineNum = 108;BA.debugLine="LabelText.SetLayoutAnimated(0, l, t, w, h)";
_labeltext.SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 36;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private BaseLabel As B4XView	'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 41;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 42;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private LabelText As B4XView";
_labeltext = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
 //BA.debugLineNum = 47;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 50;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 51;BA.debugLine="Private mText As String";
_mtext = "";
 //BA.debugLineNum = 52;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 55;BA.debugLine="Private mTextSize As Double";
_mtextsize = 0;
 //BA.debugLineNum = 56;BA.debugLine="Private mTextColor As Int";
_mtextcolor = 0;
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 66;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 67;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 68;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 69;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 71;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 166;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return false;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 188;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public String  _gettext() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub getText As String";
 //BA.debugLineNum = 128;BA.debugLine="Return mText";
if (true) return _mtext;
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public int  _gettextcolor() throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Public Sub getTextColor As Int";
 //BA.debugLineNum = 144;BA.debugLine="Return mTextColor";
if (true) return _mtextcolor;
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return 0;
}
public double  _gettextsize() throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Public Sub getTextSize As Double";
 //BA.debugLineNum = 136;BA.debugLine="Return mTextSize";
if (true) return _mtextsize;
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return 0;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 120;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 59;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 60;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 61;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_click() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Private Sub LabelText_Click";
 //BA.debugLineNum = 215;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Private Sub LabelText_MouseClicked (EventData As M";
 //BA.debugLineNum = 209;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 162;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 163;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public String  _setfontawesome(boolean _large) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub SetFontAwesome(large As Boolean)";
 //BA.debugLineNum = 149;BA.debugLine="If large Then";
if (_large) { 
 //BA.debugLineNum = 150;BA.debugLine="LabelText.Font = xui.CreateFontAwesome(HMITileUt";
_labeltext.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon_large /*float*/ ));
 }else {
 //BA.debugLineNum = 152;BA.debugLine="LabelText.Font = xui.CreateFontAwesome(HMITileUt";
_labeltext.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 };
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _setfontdefault() throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub SetFontDefault";
 //BA.debugLineNum = 158;BA.debugLine="LabelText.Font = xui.CreateDefaultFont(HMITileUti";
_labeltext.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 184;BA.debugLine="mStatus = value";
_mstatus = _value;
 //BA.debugLineNum = 185;BA.debugLine="HMITileUtils.ApplyStatusStyle(LabelTitle, mTitle,";
_hmitileutils._applystatusstyle /*String*/ (_labeltitle,_mtitle,_mstatus);
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public String  _settext(String _value) throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Public Sub setText(value As String)";
 //BA.debugLineNum = 124;BA.debugLine="mText = value";
_mtext = _value;
 //BA.debugLineNum = 125;BA.debugLine="LabelText.Text = mText";
_labeltext.setText(_mtext);
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _settextcolor(int _value) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub setTextColor(value As Int)";
 //BA.debugLineNum = 140;BA.debugLine="mTextColor = value";
_mtextcolor = _value;
 //BA.debugLineNum = 141;BA.debugLine="LabelText.TextColor = value";
_labeltext.setTextColor(_value);
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _settextsize(double _value) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Public Sub setTextSize(value As Double)";
 //BA.debugLineNum = 132;BA.debugLine="mTextSize = value";
_mtextsize = _value;
 //BA.debugLineNum = 133;BA.debugLine="LabelText.TextSize = value";
_labeltext.setTextSize(_value);
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 116;BA.debugLine="mTitle = value";
_mtitle = _value;
 //BA.debugLineNum = 117;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public String  _statusalarm() throws Exception{
 //BA.debugLineNum = 178;BA.debugLine="Public Sub StatusAlarm";
 //BA.debugLineNum = 179;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal() throws Exception{
 //BA.debugLineNum = 170;BA.debugLine="Public Sub StatusNormal";
 //BA.debugLineNum = 171;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning() throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Public Sub StatusWarning";
 //BA.debugLineNum = 175;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return "";
}
public String  _tileclick() throws Exception{
 //BA.debugLineNum = 218;BA.debugLine="Private Sub TileClick";
 //BA.debugLineNum = 219;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 220;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
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
