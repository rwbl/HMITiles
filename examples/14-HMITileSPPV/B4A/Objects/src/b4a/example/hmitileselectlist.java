package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitileselectlist extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitileselectlist");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitileselectlist.class).invoke(this, new Object[] {null});
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
public b4a.example3.customlistview _clvselect = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _paneselect = null;
public boolean _mshowtitle = false;
public boolean _mcompactmode = false;
public int _mselecteditemindex = 0;
public String _mselecteditem = "";
public boolean _mscrollbar = false;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _add(String _primaryitem,Object _value) throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub Add(primaryitem As String, value As Obj";
 //BA.debugLineNum = 215;BA.debugLine="ClvSelect.Add(ClvSelectCreateItem(primaryitem), _";
_clvselect._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clvselectcreateitem(_primaryitem).getObject())),_value);
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public String  _addall(anywheresoftware.b4a.objects.collections.List _items) throws Exception{
String _s = "";
 //BA.debugLineNum = 226;BA.debugLine="Public Sub AddAll(items As List)";
 //BA.debugLineNum = 227;BA.debugLine="For Each s As String In items";
{
final anywheresoftware.b4a.BA.IterableList group1 = _items;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_s = BA.ObjectToString(group1.Get(index1));
 //BA.debugLineNum = 228;BA.debugLine="Add(s,s)";
_add(_s,(Object)(_s));
 }
};
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 74;BA.debugLine="mBase.LoadLayout(\"hmitileselectlist\")";
_mbase.LoadLayout("hmitileselectlist",ba);
 //BA.debugLineNum = 77;BA.debugLine="LabelTitle.Text = Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToCharSequence(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 78;BA.debugLine="mShowTitle 		= Props.Get(\"ShowTitle\")";
_mshowtitle = BA.ObjectToBoolean(_props.Get((Object)("ShowTitle")));
 //BA.debugLineNum = 79;BA.debugLine="mCompactMode	= Props.Get(\"CompactMode\")";
_mcompactmode = BA.ObjectToBoolean(_props.Get((Object)("CompactMode")));
 //BA.debugLineNum = 82;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 85;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Public Sub ApplyStyle";
 //BA.debugLineNum = 195;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 196;BA.debugLine="HMITileUtils.SetCLVBackgroundTransparent(ClvSelec";
_hmitileutils._setclvbackgroundtransparent /*String*/ (ba,_clvselect);
 //BA.debugLineNum = 197;BA.debugLine="ClvSelect.sv.SetColorAndBorder(HMITileUtils.COLOR";
_clvselect._sv.SetColorAndBorder(_hmitileutils._color_background_screen /*int*/ ,__c.DipToCurrent((int) (1)),_hmitileutils._color_status_off_border /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 201;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 203;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _l = 0f;
float _t = 0f;
float _w = 0f;
float _h = 0f;
int _pad = 0;
 //BA.debugLineNum = 88;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 89;BA.debugLine="Dim l,t,w,h As Float";
_l = 0f;
_t = 0f;
_w = 0f;
_h = 0f;
 //BA.debugLineNum = 90;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 93;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(ClvSelect";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_clvselect.IsInitialized())) { 
 //BA.debugLineNum = 94;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 97;BA.debugLine="PaneSelect.SetLayoutAnimated(0, pad, pad, Width -";
_paneselect.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height-_pad*2));
 //BA.debugLineNum = 98;BA.debugLine="LabelTitle.SetLayoutAnimated(0, 0, 0, PaneSelect.";
_labeltitle.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_paneselect.getWidth(),_hmitileutils._list_title_height /*int*/ );
 //BA.debugLineNum = 101;BA.debugLine="l = pad";
_l = (float) (_pad);
 //BA.debugLineNum = 102;BA.debugLine="t = pad";
_t = (float) (_pad);
 //BA.debugLineNum = 103;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 104;BA.debugLine="t = t + HMITileUtils.LIST_TITLE_HEIGHT";
_t = (float) (_t+_hmitileutils._list_title_height /*int*/ );
 };
 //BA.debugLineNum = 106;BA.debugLine="w = PaneSelect.Width - pad * 2";
_w = (float) (_paneselect.getWidth()-_pad*2);
 //BA.debugLineNum = 107;BA.debugLine="h = PaneSelect.Height - pad * 2";
_h = (float) (_paneselect.getHeight()-_pad*2);
 //BA.debugLineNum = 108;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 109;BA.debugLine="h = h - LabelTitle.Height";
_h = (float) (_h-_labeltitle.getHeight());
 };
 //BA.debugLineNum = 111;BA.debugLine="ClvSelect.GetBase.SetLayoutAnimated(0, l, t, w, h";
_clvselect._getbase().SetLayoutAnimated((int) (0),(int) (_l),(int) (_t),(int) (_w),(int) (_h));
 //BA.debugLineNum = 114;BA.debugLine="ClvSelect.Base_Resize (ClvSelect.GetBase.Width, C";
_clvselect._base_resize(_clvselect._getbase().getWidth(),_clvselect._getbase().getHeight());
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 34;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 35;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 38;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 43;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 44;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private ClvSelect As CustomListView";
_clvselect = new b4a.example3.customlistview();
 //BA.debugLineNum = 46;BA.debugLine="Private PaneSelect As B4XView";
_paneselect = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private mShowTitle As Boolean";
_mshowtitle = false;
 //BA.debugLineNum = 50;BA.debugLine="Private mCompactMode As Boolean";
_mcompactmode = false;
 //BA.debugLineNum = 53;BA.debugLine="Private mSelectedItemIndex As Int = -1	' Keep tra";
_mselecteditemindex = (int) (-1);
 //BA.debugLineNum = 54;BA.debugLine="Private mSelectedItem As String			' Keep the item";
_mselecteditem = "";
 //BA.debugLineNum = 55;BA.debugLine="Private mScrollbar As Boolean			' Flag to show or";
_mscrollbar = false;
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 260;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 261;BA.debugLine="ClvSelect.Clear";
_clvselect._clear();
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
return "";
}
public String  _clvselect_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 326;BA.debugLine="Private Sub ClvSelect_ItemClick (Index As Int, Val";
 //BA.debugLineNum = 330;BA.debugLine="If mSelectedItemIndex == -1 Then mSelectedItemInd";
if (_mselecteditemindex==-1) { 
_mselecteditemindex = _index;};
 //BA.debugLineNum = 332;BA.debugLine="ClvSelect.GetPanel(mSelectedItemIndex).Color = HM";
_clvselect._getpanel(_mselecteditemindex).setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 334;BA.debugLine="ClvSelect.GetPanel(Index).Color = HMITileUtils.CO";
_clvselect._getpanel(_index).setColor(_hmitileutils._color_background_selected /*int*/ );
 //BA.debugLineNum = 336;BA.debugLine="mSelectedItemIndex = Index";
_mselecteditemindex = _index;
 //BA.debugLineNum = 338;BA.debugLine="mSelectedItem = Value";
_mselecteditem = BA.ObjectToString(_value);
 //BA.debugLineNum = 341;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ItemClick\"";
if (__c.SubExists(ba,_mcallback,_meventname+"_ItemClick")) { 
 //BA.debugLineNum = 342;BA.debugLine="CallSub3(mCallBack, mEventName & \"_ItemClick\", I";
__c.CallSubNew3(ba,_mcallback,_meventname+"_ItemClick",(Object)(_index),_value);
 };
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _clvselectcreateitem(String _primaryitem) throws Exception{
int _rowheight = 0;
int _rowpadding = 0;
float _primarytextsize = 0f;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
int _primaryitemheight = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lblprimaryitem = null;
 //BA.debugLineNum = 281;BA.debugLine="Private Sub ClvSelectCreateItem(primaryitem As Str";
 //BA.debugLineNum = 284;BA.debugLine="Dim rowheight As Int			= IIf(mCompactMode, HMITil";
_rowheight = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_height /*int*/ )) : ((Object)(_hmitileutils._event_normal_height /*int*/ )))));
 //BA.debugLineNum = 285;BA.debugLine="Dim rowpadding As Int			= IIf(mCompactMode, HMITi";
_rowpadding = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_padding /*int*/ )) : ((Object)(_hmitileutils._event_normal_padding /*int*/ )))));
 //BA.debugLineNum = 288;BA.debugLine="Dim primarytextsize As Float	= IIf(mCompactMode,";
_primarytextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_message_text_size /*float*/ )) : ((Object)(_hmitileutils._event_normal_message_text_size /*float*/ )))));
 //BA.debugLineNum = 291;BA.debugLine="Dim pnl As B4XView				= xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 292;BA.debugLine="pnl.SetLayoutAnimated(0, rowpadding, rowpadding,";
_pnl.SetLayoutAnimated((int) (0),_rowpadding,_rowpadding,(int) (_clvselect._asview().getWidth()-(_rowpadding*2)),_rowheight);
 //BA.debugLineNum = 293;BA.debugLine="Dim primaryitemheight As Int	= pnl.Height";
_primaryitemheight = _pnl.getHeight();
 //BA.debugLineNum = 296;BA.debugLine="pnl.Color 						= HMITileUtils.LIST_COLOR_BG_BASE";
_pnl.setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 299;BA.debugLine="Dim lblprimaryitem As B4XView	= XUIViewsUtils.Cre";
_lblprimaryitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblprimaryitem = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (ba);
 //BA.debugLineNum = 300;BA.debugLine="lblprimaryitem.Font 			= xui.CreateDefaultFont(pr";
_lblprimaryitem.setFont(_xui.CreateDefaultFont(_primarytextsize));
 //BA.debugLineNum = 302;BA.debugLine="lblprimaryitem.Text				= primaryitem						'";
_lblprimaryitem.setText(BA.ObjectToCharSequence(_primaryitem));
 //BA.debugLineNum = 303;BA.debugLine="lblprimaryitem.SetTextAlignment(\"TOP\", \"LEFT\")";
_lblprimaryitem.SetTextAlignment("TOP","LEFT");
 //BA.debugLineNum = 306;BA.debugLine="HMITileUtils.SetTextColorCrossPlatform(lblprimary";
_hmitileutils._settextcolorcrossplatform /*String*/ (ba,_lblprimaryitem,("#"+__c.SmartStringFormatter("",(Object)(_hmitileutils._colortohexrgb /*String*/ (ba,_hmitileutils._list_color_text /*int*/ )))+""));
 //BA.debugLineNum = 314;BA.debugLine="pnl.AddView(lblprimaryitem, rowpadding, 0, pnl.Wi";
_pnl.AddView((android.view.View)(_lblprimaryitem.getObject()),_rowpadding,(int) (0),_pnl.getWidth(),_primaryitemheight);
 //BA.debugLineNum = 315;BA.debugLine="Return pnl";
if (true) return (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_pnl.getObject()));
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
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
public boolean  _getcompactmode() throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub getCompactMode As Boolean";
 //BA.debugLineNum = 141;BA.debugLine="Return mCompactMode";
if (true) return _mcompactmode;
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 134;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return false;
}
public boolean  _getscrollbar() throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Public Sub getScrollbar As Boolean";
 //BA.debugLineNum = 176;BA.debugLine="Return mScrollbar";
if (true) return _mscrollbar;
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return false;
}
public String  _getselecteditem() throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Public Sub getSelectedItem As String";
 //BA.debugLineNum = 156;BA.debugLine="Return mSelectedItem";
if (true) return _mselecteditem;
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public int  _getselecteditemindex() throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub getSelectedItemIndex As Int";
 //BA.debugLineNum = 168;BA.debugLine="Return mSelectedItemIndex";
if (true) return _mselecteditemindex;
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowtitle() throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Public Sub getShowTitle As Boolean";
 //BA.debugLineNum = 184;BA.debugLine="Return mShowTitle";
if (true) return _mshowtitle;
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 126;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 58;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 59;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 60;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public String  _insert(String _primaryitem,Object _value) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Public Sub Insert(primaryitem As String, value As";
 //BA.debugLineNum = 242;BA.debugLine="ClvSelect.InsertAt(	0, _ 						ClvSelectCreateIte";
_clvselect._insertat((int) (0),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clvselectcreateitem(_primaryitem).getObject())),_value);
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public String  _remove(int _index) throws Exception{
 //BA.debugLineNum = 253;BA.debugLine="Public Sub Remove(index As Int)";
 //BA.debugLineNum = 254;BA.debugLine="If ClvSelect.Size == 0 Then Return";
if (_clvselect._getsize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 255;BA.debugLine="If index < 0 Or index > ClvSelect.Size - 1 Then R";
if (_index<0 || _index>_clvselect._getsize()-1) { 
if (true) return "";};
 //BA.debugLineNum = 256;BA.debugLine="ClvSelect.RemoveAt(index)";
_clvselect._removeat(_index);
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public String  _setcompactmode(boolean _state) throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Public Sub setCompactMode(state As Boolean)";
 //BA.debugLineNum = 138;BA.debugLine="mCompactMode = state";
_mcompactmode = _state;
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 130;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 131;BA.debugLine="HMITileUtils.SetAlpha(mBase.enabled)";
_hmitileutils._setalpha /*float*/ (ba,_mbase.getEnabled());
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public String  _setscrollbar(boolean _state) throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Public Sub setScrollbar(state As Boolean)";
 //BA.debugLineNum = 172;BA.debugLine="mScrollbar = state";
_mscrollbar = _state;
 //BA.debugLineNum = 173;BA.debugLine="HMITileUtils.SetCLVScrollBars(ClvSelect, state)";
_hmitileutils._setclvscrollbars /*String*/ (ba,_clvselect,_state);
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public String  _setselecteditem(String _item) throws Exception{
int _i = 0;
 //BA.debugLineNum = 144;BA.debugLine="Public Sub setSelectedItem(item As String)";
 //BA.debugLineNum = 145;BA.debugLine="mSelectedItem = item";
_mselecteditem = _item;
 //BA.debugLineNum = 146;BA.debugLine="If ClvSelect.Size > 0 Then";
if (_clvselect._getsize()>0) { 
 //BA.debugLineNum = 147;BA.debugLine="For i = 0 To ClvSelect.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_clvselect._getsize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 148;BA.debugLine="If ClvSelect.GetValue(i) == item Then";
if ((_clvselect._getvalue(_i)).equals((Object)(_item))) { 
 //BA.debugLineNum = 149;BA.debugLine="ClvSelect_ItemClick(i, ClvSelect.GetValue(i))";
_clvselect_itemclick(_i,_clvselect._getvalue(_i));
 //BA.debugLineNum = 150;BA.debugLine="ClvSelect.AsView.RequestFocus";
_clvselect._asview().RequestFocus();
 };
 }
};
 };
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _setselecteditemindex(int _index) throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Public Sub setSelectedItemIndex(index As Int)";
 //BA.debugLineNum = 160;BA.debugLine="mSelectedItemIndex = index";
_mselecteditemindex = _index;
 //BA.debugLineNum = 161;BA.debugLine="If ClvSelect.Size > 0 Then";
if (_clvselect._getsize()>0) { 
 //BA.debugLineNum = 162;BA.debugLine="ClvSelect.JumpToItem(index)";
_clvselect._jumptoitem(_index);
 //BA.debugLineNum = 163;BA.debugLine="ClvSelect_ItemClick(index, ClvSelect.GetValue(in";
_clvselect_itemclick(_index,_clvselect._getvalue(_index));
 //BA.debugLineNum = 164;BA.debugLine="ClvSelect.AsView.RequestFocus";
_clvselect._asview().RequestFocus();
 };
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _setshowtitle(boolean _state) throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Public Sub setShowTitle(state As Boolean)";
 //BA.debugLineNum = 180;BA.debugLine="mShowTitle = state";
_mshowtitle = _state;
 //BA.debugLineNum = 181;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 123;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public int  _size() throws Exception{
 //BA.debugLineNum = 265;BA.debugLine="Public Sub Size As Int";
 //BA.debugLineNum = 266;BA.debugLine="Return ClvSelect.Size";
if (true) return _clvselect._getsize();
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return 0;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
