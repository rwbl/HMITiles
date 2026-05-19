package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitileselect extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitileselect");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitileselect.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _paneselect = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelselected = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelup = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeldown = null;
public String _mtitle = "";
public boolean _mshowtitle = false;
public anywheresoftware.b4a.objects.collections.List _mitems = null;
public int _mselectedindex = 0;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _add(Object _item) throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Public Sub Add(item As Object)";
 //BA.debugLineNum = 164;BA.debugLine="mItems.Add(item)";
_mitems.Add(_item);
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public String  _addall(anywheresoftware.b4a.objects.collections.List _items) throws Exception{
Object _item = null;
 //BA.debugLineNum = 173;BA.debugLine="Public Sub AddAll(items As List)";
 //BA.debugLineNum = 174;BA.debugLine="If items.Size == 0 Then Return";
if (_items.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 175;BA.debugLine="For Each item As Object In items";
{
final anywheresoftware.b4a.BA.IterableList group2 = _items;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_item = group2.Get(index2);
 //BA.debugLineNum = 176;BA.debugLine="Add(item)";
_add(_item);
 }
};
 //BA.debugLineNum = 178;BA.debugLine="setSelectedIndex(0)";
_setselectedindex((int) (0));
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 72;BA.debugLine="mBase.LoadLayout(\"hmitileselect\")";
_mbase.LoadLayout("hmitileselect",ba);
 //BA.debugLineNum = 75;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 76;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 77;BA.debugLine="mShowTitle 		= Props.Get(\"ShowTitle\")";
_mshowtitle = BA.ObjectToBoolean(_props.Get((Object)("ShowTitle")));
 //BA.debugLineNum = 80;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 83;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 215;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 216;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelSelected)";
_hmitileutils._applyvaluestyle /*String*/ (ba,_labelselected);
 //BA.debugLineNum = 217;BA.debugLine="HMITileUtils.ApplyFontAwesomeStyle(LabelUp)";
_hmitileutils._applyfontawesomestyle /*String*/ (ba,_labelup);
 //BA.debugLineNum = 218;BA.debugLine="HMITileUtils.ApplyFontAwesomeStyle(LabelDown)";
_hmitileutils._applyfontawesomestyle /*String*/ (ba,_labeldown);
 //BA.debugLineNum = 220;BA.debugLine="PaneSelect.SetColorAndBorder(HMITileUtils.COLOR_T";
_paneselect.SetColorAndBorder(_hmitileutils._color_tile_normal_background /*int*/ ,__c.DipToCurrent((int) (0)),_hmitileutils._color_status_off_border /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 224;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 226;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 227;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 86;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 89;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 92;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(LabelUp.I";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_labelup.IsInitialized()) || __c.Not(_labeldown.IsInitialized())) { 
 //BA.debugLineNum = 94;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 97;BA.debugLine="PaneSelect.SetLayoutAnimated	(0, 0, 0, Width, Hei";
_paneselect.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 //BA.debugLineNum = 98;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, pad, pad, Width";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 99;BA.debugLine="LabelSelected.SetLayoutAnimated	(0, pad, LabelTit";
_labelselected.SetLayoutAnimated((int) (0),_pad,_labeltitle.getHeight(),(int) (_width-_pad*2),(int) (_height*0.50));
 //BA.debugLineNum = 100;BA.debugLine="LabelDown.SetLayoutAnimated		(0, Width * 0.1, Hei";
_labeldown.SetLayoutAnimated((int) (0),(int) (_width*0.1),(int) (_height*0.60),(int) (_width*0.3),(int) (_height*0.25));
 //BA.debugLineNum = 101;BA.debugLine="LabelUp.SetLayoutAnimated		(0, Width * 0.6, Heigh";
_labelup.SetLayoutAnimated((int) (0),(int) (_width*0.6),(int) (_height*0.60),(int) (_width*0.3),(int) (_height*0.25));
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 30;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 31;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 34;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 39;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 40;BA.debugLine="Private PaneSelect As B4XView";
_paneselect = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private LabelSelected As B4XView";
_labelselected = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private LabelUp As B4XView";
_labelup = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private LabelDown As B4XView";
_labeldown = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 48;BA.debugLine="Private mShowTitle As Boolean";
_mshowtitle = false;
 //BA.debugLineNum = 51;BA.debugLine="Private mItems As List";
_mitems = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 52;BA.debugLine="Private mSelectedIndex As Int = -1";
_mselectedindex = (int) (-1);
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 197;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 198;BA.debugLine="mItems.Clear";
_mitems.Clear();
 //BA.debugLineNum = 199;BA.debugLine="LabelSelected.Text = \"\"";
_labelselected.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 62;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 63;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 64;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 65;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 67;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _down() throws Exception{
 //BA.debugLineNum = 281;BA.debugLine="Private Sub Down";
 //BA.debugLineNum = 282;BA.debugLine="If mItems.Size == 0 Then Return";
if (_mitems.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 284;BA.debugLine="mSelectedIndex = mSelectedIndex - 1";
_mselectedindex = (int) (_mselectedindex-1);
 //BA.debugLineNum = 285;BA.debugLine="If mSelectedIndex < 0 Then";
if (_mselectedindex<0) { 
 //BA.debugLineNum = 286;BA.debugLine="mSelectedIndex = mItems.Size - 1";
_mselectedindex = (int) (_mitems.getSize()-1);
 };
 //BA.debugLineNum = 288;BA.debugLine="setSelectedIndex(mSelectedIndex)";
_setselectedindex(_mselectedindex);
 //BA.debugLineNum = 289;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 124;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return false;
}
public String  _getselected() throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="Public Sub getSelected As String";
 //BA.debugLineNum = 146;BA.debugLine="Return LabelSelected.Text";
if (true) return _labelselected.getText();
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public int  _getselectedindex() throws Exception{
 //BA.debugLineNum = 153;BA.debugLine="Public Sub getSelectedIndex As Int";
 //BA.debugLineNum = 154;BA.debugLine="Return mSelectedIndex";
if (true) return _mselectedindex;
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowtitle() throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Public Sub getShowTitle As Boolean";
 //BA.debugLineNum = 132;BA.debugLine="Return mShowTitle";
if (true) return _mshowtitle;
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 116;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 55;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 56;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 57;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 58;BA.debugLine="mItems.Initialize";
_mitems.Initialize();
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public String  _labeldown_click() throws Exception{
 //BA.debugLineNum = 252;BA.debugLine="Private Sub LabelDown_Click";
 //BA.debugLineNum = 253;BA.debugLine="Down";
_down();
 //BA.debugLineNum = 254;BA.debugLine="End Sub";
return "";
}
public String  _labelselected_click() throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Private Sub LabelSelected_Click";
 //BA.debugLineNum = 245;BA.debugLine="ValueChanged";
_valuechanged();
 //BA.debugLineNum = 246;BA.debugLine="End Sub";
return "";
}
public String  _labelup_click() throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Private Sub LabelUp_Click";
 //BA.debugLineNum = 249;BA.debugLine="Up";
_up();
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public String  _plusminusselect_valuechanged(Object _value) throws Exception{
 //BA.debugLineNum = 235;BA.debugLine="Private Sub PlusMinusSelect_ValueChanged (Value As";
 //BA.debugLineNum = 237;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ValueChang";
if (__c.SubExists(ba,_mcallback,_meventname+"_ValueChanged")) { 
 //BA.debugLineNum = 238;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ValueChanged\"";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ValueChanged",_value);
 };
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _remove(Object _item) throws Exception{
int _index = 0;
Object _objitem = null;
 //BA.debugLineNum = 185;BA.debugLine="Public Sub Remove(item As Object)";
 //BA.debugLineNum = 186;BA.debugLine="Dim index As Int = 0";
_index = (int) (0);
 //BA.debugLineNum = 187;BA.debugLine="For Each objitem As Object In mItems";
{
final anywheresoftware.b4a.BA.IterableList group2 = _mitems;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_objitem = group2.Get(index2);
 //BA.debugLineNum = 188;BA.debugLine="If objitem == item Then";
if ((_objitem).equals(_item)) { 
 //BA.debugLineNum = 189;BA.debugLine="mItems.RemoveAt(index)";
_mitems.RemoveAt(_index);
 //BA.debugLineNum = 190;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 192;BA.debugLine="index = index + 1";
_index = (int) (_index+1);
 }
};
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 120;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 121;BA.debugLine="HMITileUtils.SetAlpha(mBase.enabled)";
_hmitileutils._setalpha /*float*/ (ba,_mbase.getEnabled());
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _setselected(String _item) throws Exception{
int _i = 0;
 //BA.debugLineNum = 135;BA.debugLine="Public Sub setSelected(item As String)";
 //BA.debugLineNum = 136;BA.debugLine="For i = 0 To mItems.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (_mitems.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 137;BA.debugLine="If mItems.Get(i) == item Then";
if ((_mitems.Get(_i)).equals((Object)(_item))) { 
 //BA.debugLineNum = 138;BA.debugLine="LabelSelected.Text = item";
_labelselected.setText(BA.ObjectToCharSequence(_item));
 //BA.debugLineNum = 139;BA.debugLine="mSelectedIndex = i";
_mselectedindex = _i;
 //BA.debugLineNum = 140;BA.debugLine="ValueChanged";
_valuechanged();
 //BA.debugLineNum = 141;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public String  _setselectedindex(int _index) throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Public Sub setSelectedIndex(index As Int)";
 //BA.debugLineNum = 150;BA.debugLine="mSelectedIndex = index";
_mselectedindex = _index;
 //BA.debugLineNum = 151;BA.debugLine="setSelected(mItems.Get(mSelectedIndex))";
_setselected(BA.ObjectToString(_mitems.Get(_mselectedindex)));
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public String  _setshowtitle(boolean _state) throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub setShowTitle(state As Boolean)";
 //BA.debugLineNum = 128;BA.debugLine="mShowTitle = state";
_mshowtitle = _state;
 //BA.debugLineNum = 129;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 113;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public int  _size() throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Public Sub Size As Int";
 //BA.debugLineNum = 204;BA.debugLine="Return mItems.Size";
if (true) return _mitems.getSize();
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return 0;
}
public String  _up() throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Private Sub Up";
 //BA.debugLineNum = 272;BA.debugLine="If mItems.Size == 0 Then Return";
if (_mitems.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 274;BA.debugLine="mSelectedIndex = mSelectedIndex + 1";
_mselectedindex = (int) (_mselectedindex+1);
 //BA.debugLineNum = 275;BA.debugLine="If mSelectedIndex > mItems.Size - 1 Then";
if (_mselectedindex>_mitems.getSize()-1) { 
 //BA.debugLineNum = 276;BA.debugLine="mSelectedIndex = 0";
_mselectedindex = (int) (0);
 };
 //BA.debugLineNum = 278;BA.debugLine="setSelectedIndex(mSelectedIndex)";
_setselectedindex(_mselectedindex);
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return "";
}
public String  _valuechanged() throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Private Sub ValueChanged";
 //BA.debugLineNum = 292;BA.debugLine="If mItems.Size == 0 Then Return";
if (_mitems.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 294;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ValueChang";
if (__c.SubExists(ba,_mcallback,_meventname+"_ValueChanged")) { 
 //BA.debugLineNum = 295;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ValueChanged\"";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ValueChanged",_mitems.Get(_mselectedindex));
 };
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
