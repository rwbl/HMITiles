package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilenavbutton extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilenavbutton", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilenavbutton.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _labelicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltext = null;
public String _mselecttype = "";
public boolean _mispressed = false;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 63;BA.debugLine="BasePane.LoadLayout(\"hmitilenavbutton\")";
_basepane.LoadLayout("hmitilenavbutton",ba);
 //BA.debugLineNum = 66;BA.debugLine="LabelIcon.Text  = Props.Get(\"Icon\")";
_labelicon.setText(BA.ObjectToString(_props.Get((Object)("Icon"))));
 //BA.debugLineNum = 68;BA.debugLine="If LabelIcon.Text.ToLowerCase.Contains(\"0x\") Then";
if (_labelicon.getText().toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale).contains("0x")) { 
 //BA.debugLineNum = 69;BA.debugLine="LabelIcon.Text = LabelIcon.Text.ToLowerCase.Repl";
_labelicon.setText(_labelicon.getText().toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale).replace("0x",""));
 };
 //BA.debugLineNum = 71;BA.debugLine="setIcon(LabelIcon.Text)";
_seticon(_labelicon.getText());
 //BA.debugLineNum = 72;BA.debugLine="LabelText.Text	= Props.Get(\"Text\")";
_labeltext.setText(BA.ObjectToString(_props.Get((Object)("Text"))));
 //BA.debugLineNum = 73;BA.debugLine="mSelectType 	= Props.Get(\"SelectType\")";
_mselecttype = BA.ObjectToString(_props.Get((Object)("SelectType")));
 //BA.debugLineNum = 75;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 76;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 164;BA.debugLine="LabelIcon.TextSize = HMITileUtils.TEXT_SIZE_ICON";
_labelicon.setTextSize(_hmitileutils._text_size_icon /*float*/ );
 //BA.debugLineNum = 165;BA.debugLine="LabelIcon.TextColor = HMITileUtils.COLOR_TEXT_PRI";
_labelicon.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 //BA.debugLineNum = 166;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelText)";
_hmitileutils._applyunitstyle /*String*/ (_labeltext);
 //BA.debugLineNum = 167;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 168;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 80;BA.debugLine="If Not(LabelIcon.IsInitialized) Or Not(LabelText.";
if (__c.Not(_labelicon.IsInitialized()) || __c.Not(_labeltext.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 83;BA.debugLine="LabelIcon.SetLayoutAnimated	(0, 0,  0, 				Width,";
_labelicon.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 84;BA.debugLine="LabelText.SetLayoutAnimated	(0, 0,  Height * 0.80";
_labeltext.SetLayoutAnimated((int) (0),0,_height*0.80,_width,_height*0.15);
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 31;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private BaseLabel As B4XView					'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 36;BA.debugLine="Private mEventName As String					'ignore";
_meventname = "";
 //BA.debugLineNum = 37;BA.debugLine="Private mCallBack As Object						'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 40;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 41;BA.debugLine="Private LabelIcon As B4XView";
_labelicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private LabelText As B4XView";
_labeltext = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private mSelectType As String					'ignore";
_mselecttype = "";
 //BA.debugLineNum = 46;BA.debugLine="Private mIsPressed As Boolean = False			'ignore";
_mispressed = __c.False;
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 55;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 56;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 57;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 58;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 59;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 151;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return false;
}
public String  _geticon() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Public Sub getIcon As String";
 //BA.debugLineNum = 110;BA.debugLine="Return LabelIcon.Text";
if (true) return _labelicon.getText();
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _gettext() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Public Sub getText As String";
 //BA.debugLineNum = 123;BA.debugLine="Return LabelText.Text";
if (true) return _labeltext.getText();
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 49;BA.debugLine="Private Sub Initialize (Callback As Object, EventN";
 //BA.debugLineNum = 50;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 51;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _labelicon_click() throws Exception{
 //BA.debugLineNum = 191;BA.debugLine="Private Sub LabelIcon_Click";
 //BA.debugLineNum = 192;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 193;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public String  _labelicon_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Private Sub LabelIcon_MouseClicked(EventData As Mo";
 //BA.debugLineNum = 182;BA.debugLine="LabelIcon_Click";
_labelicon_click();
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_click() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Private Sub LabelText_Click";
 //BA.debugLineNum = 188;BA.debugLine="LabelIcon_Click";
_labelicon_click();
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public String  _labeltext_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Private Sub LabelText_MouseClicked(EventData As Mo";
 //BA.debugLineNum = 178;BA.debugLine="LabelIcon_Click";
_labelicon_click();
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 147;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 148;BA.debugLine="BasePane.Alpha = HMITileUtils.SetAlpha(BasePane.E";
_basepane.setAlpha(_hmitileutils._setalpha /*float*/ (_basepane.getEnabled()));
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public String  _seticon(String _iconhex) throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Public Sub setIcon(iconHex As String)";
 //BA.debugLineNum = 96;BA.debugLine="If iconHex == \"\" Then Return";
if ((_iconhex).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 99;BA.debugLine="Try";
try { //BA.debugLineNum = 100;BA.debugLine="If iconHex.Length > 0 And iconHex.Length <= 6 An";
if (_iconhex.length()>0 && _iconhex.length()<=6 && _iconhex.toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale).startsWith("f")) { 
 //BA.debugLineNum = 101;BA.debugLine="LabelIcon.Text = Chr(Bit.ParseInt(iconHex, 16))";
_labelicon.setText(BA.ObjectToString(__c.Chr(__c.Bit.ParseInt(_iconhex,(int) (16)))));
 }else {
 //BA.debugLineNum = 103;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(_iconhex);
 };
 } 
       catch (Exception e9) {
			ba.setLastException(e9); //BA.debugLineNum = 106;BA.debugLine="LabelIcon.Text = iconHex";
_labelicon.setText(_iconhex);
 };
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public String  _seticonfontfontawesome() throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Public Sub SetIconFontFontAwesome";
 //BA.debugLineNum = 115;BA.debugLine="LabelIcon.Font = xui.CreateFontAwesome(HMITileUti";
_labelicon.setFont(_xui.CreateFontAwesome(_hmitileutils._text_size_icon /*float*/ ));
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public String  _setselecttypeback() throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub SetSelectTypeBack";
 //BA.debugLineNum = 140;BA.debugLine="mSelectType = \"Back\"";
_mselecttype = "Back";
 //BA.debugLineNum = 141;BA.debugLine="setIcon(HMITileUtils.NAV_ICON_BACK)";
_seticon(_hmitileutils._nav_icon_back /*String*/ );
 //BA.debugLineNum = 142;BA.debugLine="LabelText.Text = mSelectType";
_labeltext.setText(_mselecttype);
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _setselecttypepage(String _icon,String _text) throws Exception{
 //BA.debugLineNum = 130;BA.debugLine="Public Sub SetSelectTypePage(icon As String, text";
 //BA.debugLineNum = 131;BA.debugLine="mSelectType = \"Page\"";
_mselecttype = "Page";
 //BA.debugLineNum = 132;BA.debugLine="setIcon(icon)";
_seticon(_icon);
 //BA.debugLineNum = 133;BA.debugLine="LabelText.Text = text";
_labeltext.setText(_text);
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public String  _settext(String _value) throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Public Sub setText(value As String)";
 //BA.debugLineNum = 120;BA.debugLine="LabelText.Text = value";
_labeltext.setText(_value);
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
