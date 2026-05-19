package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilelist extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilelist", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilelist.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.objects.JFX _fx = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public b4j.example.customlistview _clvlist = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panelist = null;
public String _mtitle = "";
public boolean _mshowtitle = false;
public boolean _mshowselected = false;
public boolean _mcompactmode = false;
public int _mselecteditemindex = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _add(String _primaryitem,String _secondaryitem,Object _value) throws Exception{
 //BA.debugLineNum = 197;BA.debugLine="Public Sub Add(primaryitem As String, secondaryite";
 //BA.debugLineNum = 198;BA.debugLine="ClvList.Add(ClvListCreateItem(primaryitem, second";
_clvlist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clvlistcreateitem(_primaryitem,_secondaryitem).getObject())),_value);
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 80;BA.debugLine="BasePane.LoadLayout(\"hmitilelist\")";
_basepane.LoadLayout("hmitilelist",ba);
 //BA.debugLineNum = 83;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 84;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 85;BA.debugLine="mShowTitle 		= Props.Get(\"ShowTitle\")";
_mshowtitle = BA.ObjectToBoolean(_props.Get((Object)("ShowTitle")));
 //BA.debugLineNum = 86;BA.debugLine="mShowSelected 	= Props.Get(\"ShowSelected\")";
_mshowselected = BA.ObjectToBoolean(_props.Get((Object)("ShowSelected")));
 //BA.debugLineNum = 87;BA.debugLine="mCompactMode	= Props.Get(\"CompactMode\")";
_mcompactmode = BA.ObjectToBoolean(_props.Get((Object)("CompactMode")));
 //BA.debugLineNum = 90;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 93;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 175;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 176;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 177;BA.debugLine="PaneList.Color = HMITileUtils.COLOR_BACKGROUND_DE";
_panelist.setColor(_hmitileutils._color_background_default /*int*/ );
 //BA.debugLineNum = 178;BA.debugLine="HMITileUtils.SetCLVBackgroundTransparent(ClvList)";
_hmitileutils._setclvbackgroundtransparent /*String*/ (_clvlist);
 //BA.debugLineNum = 179;BA.debugLine="ClvList.sv.SetColorAndBorder(HMITileUtils.COLOR_B";
_clvlist._sv.SetColorAndBorder(_hmitileutils._color_background_default /*int*/ ,__c.DipToCurrent((int) (1)),_hmitileutils._color_status_off_border /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 183;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 185;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _l = 0f;
float _t = 0f;
float _w = 0f;
float _h = 0f;
int _pad = 0;
 //BA.debugLineNum = 96;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 97;BA.debugLine="Dim l,t,w,h As Float";
_l = 0f;
_t = 0f;
_w = 0f;
_h = 0f;
 //BA.debugLineNum = 98;BA.debugLine="Dim pad As Int = 4dip";
_pad = __c.DipToCurrent((int) (4));
 //BA.debugLineNum = 101;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(ClvList.I";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_clvlist.IsInitialized())) { 
 //BA.debugLineNum = 102;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 105;BA.debugLine="PaneList.SetLayoutAnimated		(0, 0, 0, Width, Heig";
_panelist.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 108;BA.debugLine="LabelTitle.Visible = mShowTitle";
_labeltitle.setVisible(_mshowtitle);
 //BA.debugLineNum = 109;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 110;BA.debugLine="LabelTitle.SetLayoutAnimated(0, 0, 0, PaneList.W";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_panelist.getWidth(),_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 115;BA.debugLine="l = pad";
_l = (float) (_pad);
 //BA.debugLineNum = 116;BA.debugLine="t = pad";
_t = (float) (_pad);
 //BA.debugLineNum = 117;BA.debugLine="w = PaneList.Width - pad * 2";
_w = (float) (_panelist.getWidth()-_pad*2);
 //BA.debugLineNum = 118;BA.debugLine="h = PaneList.Height - pad * 2";
_h = (float) (_panelist.getHeight()-_pad*2);
 //BA.debugLineNum = 119;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 120;BA.debugLine="t = HMITileUtils.EVENT_TITLE_HEIGHT + pad";
_t = (float) (_hmitileutils._event_title_height /*int*/ +_pad);
 //BA.debugLineNum = 121;BA.debugLine="h = h - HMITileUtils.EVENT_TITLE_HEIGHT";
_h = (float) (_h-_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 123;BA.debugLine="ClvList.GetBase.SetLayoutAnimated(0, l, t, w, h)";
_clvlist._getbase().SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 126;BA.debugLine="ClvList.Base_Resize (ClvList.GetBase.Width, ClvLi";
_clvlist._base_resize(_clvlist._getbase().getWidth(),_clvlist._getbase().getHeight());
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 34;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 38;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 39;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 42;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Public BaseLabel As B4XView";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 47;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 48;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private ClvList As CustomListView";
_clvlist = new b4j.example.customlistview();
 //BA.debugLineNum = 50;BA.debugLine="Private PaneList As B4XView";
_panelist = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 54;BA.debugLine="Private mShowTitle As Boolean";
_mshowtitle = false;
 //BA.debugLineNum = 55;BA.debugLine="Private mShowSelected As Boolean";
_mshowselected = false;
 //BA.debugLineNum = 56;BA.debugLine="Private mCompactMode As Boolean";
_mcompactmode = false;
 //BA.debugLineNum = 61;BA.debugLine="Private mSelectedItemIndex As Int = -1		' Keep tr";
_mselecteditemindex = (int) (-1);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 232;BA.debugLine="ClvList.Clear";
_clvlist._clear();
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public String  _clvlist_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 316;BA.debugLine="Private Sub ClvList_ItemClick (Index As Int, Value";
 //BA.debugLineNum = 319;BA.debugLine="If mShowSelected Then";
if (_mshowselected) { 
 //BA.debugLineNum = 321;BA.debugLine="If mSelectedItemIndex == -1 Then mSelectedItemIn";
if (_mselecteditemindex==-1) { 
_mselecteditemindex = _index;};
 //BA.debugLineNum = 323;BA.debugLine="ClvList.GetPanel(mSelectedItemIndex).Color = HMI";
_clvlist._getpanel(_mselecteditemindex).setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 325;BA.debugLine="ClvList.GetPanel(Index).Color = HMITileUtils.COL";
_clvlist._getpanel(_index).setColor(_hmitileutils._color_background_selected /*int*/ );
 //BA.debugLineNum = 327;BA.debugLine="mSelectedItemIndex = Index";
_mselecteditemindex = _index;
 };
 //BA.debugLineNum = 331;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ItemClick\"";
if (__c.SubExists(ba,_mcallback,_meventname+"_ItemClick")) { 
 //BA.debugLineNum = 332;BA.debugLine="CallSub3(mCallBack, mEventName & \"_ItemClick\", I";
__c.CallSubNew3(ba,_mcallback,_meventname+"_ItemClick",(Object)(_index),_value);
 };
 //BA.debugLineNum = 334;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper  _clvlistcreateitem(String _primaryitem,String _secondaryitem) throws Exception{
int _rowheight = 0;
int _rowpadding = 0;
float _primarytextsize = 0f;
float _secondarytextsize = 0f;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
int _primaryitemheight = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lblprimaryitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lblsecondaryitem = null;
 //BA.debugLineNum = 262;BA.debugLine="Private Sub ClvListCreateItem(primaryitem As Strin";
 //BA.debugLineNum = 268;BA.debugLine="Dim rowheight As Int			= IIf(mCompactMode, HMITil";
_rowheight = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_height /*int*/ )) : ((Object)(_hmitileutils._list_normal_height /*int*/ )))));
 //BA.debugLineNum = 269;BA.debugLine="Dim rowpadding As Int			= IIf(mCompactMode, HMITi";
_rowpadding = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_padding /*int*/ )) : ((Object)(_hmitileutils._list_normal_padding /*int*/ )))));
 //BA.debugLineNum = 272;BA.debugLine="Dim primarytextsize As Float	= IIf(mCompactMode,";
_primarytextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_primary_text_size /*float*/ )) : ((Object)(_hmitileutils._list_normal_primary_text_size /*float*/ )))));
 //BA.debugLineNum = 273;BA.debugLine="Dim secondarytextsize As Float	= IIf(mCompactMode";
_secondarytextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_secondary_text_size /*float*/ )) : ((Object)(_hmitileutils._list_compact_secondary_text_size /*float*/ )))));
 //BA.debugLineNum = 276;BA.debugLine="Dim pnl As B4XView				= xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 277;BA.debugLine="pnl.SetLayoutAnimated(0, rowpadding, rowpadding,";
_pnl.SetLayoutAnimated((int) (0),_rowpadding,_rowpadding,_clvlist._asview().getWidth()-(_rowpadding*2),_rowheight);
 //BA.debugLineNum = 278;BA.debugLine="Dim primaryitemheight As Int	= IIf(secondaryitem.";
_primaryitemheight = (int)(BA.ObjectToNumber(((_secondaryitem.length()>0) ? ((Object)(_pnl.getHeight()/(double)2)) : ((Object)(_pnl.getHeight())))));
 //BA.debugLineNum = 281;BA.debugLine="pnl.Color 						= HMITileUtils.LIST_COLOR_BG_BASE";
_pnl.setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 284;BA.debugLine="Dim lblprimaryitem As B4XView	= XUIViewsUtils.Cre";
_lblprimaryitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblprimaryitem = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 285;BA.debugLine="lblprimaryitem.Font 			= xui.CreateDefaultFont(pr";
_lblprimaryitem.setFont(_xui.CreateDefaultFont(_primarytextsize));
 //BA.debugLineNum = 286;BA.debugLine="lblprimaryitem.Text				= primaryitem";
_lblprimaryitem.setText(_primaryitem);
 //BA.debugLineNum = 287;BA.debugLine="lblprimaryitem.SetTextAlignment(\"TOP\", \"LEFT\")";
_lblprimaryitem.SetTextAlignment("TOP","LEFT");
 //BA.debugLineNum = 288;BA.debugLine="HMITileUtils.SetTextColorCrossPlatform(lblprimary";
_hmitileutils._settextcolorcrossplatform /*String*/ (_lblprimaryitem,("#"+__c.SmartStringFormatter("",(Object)(_hmitileutils._colortohexrgb /*String*/ (_hmitileutils._list_color_text /*int*/ )))+""));
 //BA.debugLineNum = 290;BA.debugLine="pnl.AddView(lblprimaryitem, rowpadding, 0, pnl.Wi";
_pnl.AddView((javafx.scene.Node)(_lblprimaryitem.getObject()),_rowpadding,0,_pnl.getWidth(),_primaryitemheight);
 //BA.debugLineNum = 293;BA.debugLine="If secondaryitem.Length > 0 Then";
if (_secondaryitem.length()>0) { 
 //BA.debugLineNum = 295;BA.debugLine="Dim lblsecondaryitem As B4XView	= XUIViewsUtils.";
_lblsecondaryitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblsecondaryitem = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 296;BA.debugLine="lblsecondaryitem.Font 			= xui.CreateDefaultFont";
_lblsecondaryitem.setFont(_xui.CreateDefaultFont(_secondarytextsize));
 //BA.debugLineNum = 297;BA.debugLine="lblsecondaryitem.Text 			= secondaryitem";
_lblsecondaryitem.setText(_secondaryitem);
 //BA.debugLineNum = 298;BA.debugLine="lblsecondaryitem.SetTextAlignment(\"BOTTOM\", \"LEF";
_lblsecondaryitem.SetTextAlignment("BOTTOM","LEFT");
 //BA.debugLineNum = 301;BA.debugLine="HMITileUtils.SetTextColorCrossPlatform(lblsecond";
_hmitileutils._settextcolorcrossplatform /*String*/ (_lblsecondaryitem,("#"+__c.SmartStringFormatter("",(Object)(_hmitileutils._colortohexrgb /*String*/ (_hmitileutils._list_color_text /*int*/ )))+""));
 //BA.debugLineNum = 302;BA.debugLine="pnl.AddView(lblsecondaryitem, rowpadding, rowhei";
_pnl.AddView((javafx.scene.Node)(_lblsecondaryitem.getObject()),_rowpadding,_rowheight/(double)2,_pnl.getWidth(),_pnl.getHeight()/(double)2);
 };
 //BA.debugLineNum = 305;BA.debugLine="Return pnl";
if (true) return (anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper(), (javafx.scene.layout.Pane)(_pnl.getObject()));
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 70;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 71;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 72;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 73;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 75;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public boolean  _getcompactmode() throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Public Sub getCompactMode As Boolean";
 //BA.debugLineNum = 165;BA.debugLine="Return mCompactMode";
if (true) return _mcompactmode;
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 158;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return false;
}
public int  _getselecteditemindex() throws Exception{
 //BA.debugLineNum = 249;BA.debugLine="Public Sub getSelectedItemIndex As Int";
 //BA.debugLineNum = 250;BA.debugLine="Return mSelectedItemIndex";
if (true) return _mselecteditemindex;
 //BA.debugLineNum = 251;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowselected() throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Public Sub getShowSelected As Boolean";
 //BA.debugLineNum = 150;BA.debugLine="Return mShowSelected";
if (true) return _mshowselected;
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 143;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 64;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 65;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 66;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _insert(String _primaryitem,String _secondaryitem,Object _value) throws Exception{
 //BA.debugLineNum = 212;BA.debugLine="Public Sub Insert(primaryitem As String, secondary";
 //BA.debugLineNum = 213;BA.debugLine="ClvList.InsertAt(	0, _ 						ClvListCreateItem(pr";
_clvlist._insertat((int) (0),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clvlistcreateitem(_primaryitem,_secondaryitem).getObject())),_value);
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public String  _labeltrash_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 341;BA.debugLine="Private Sub LabelTrash_MouseClicked (EventData As";
 //BA.debugLineNum = 342;BA.debugLine="Clear";
_clear();
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return "";
}
public String  _remove(int _index) throws Exception{
 //BA.debugLineNum = 224;BA.debugLine="Public Sub Remove(index As Int)";
 //BA.debugLineNum = 225;BA.debugLine="If ClvList.Size == 0 Then Return";
if (_clvlist._getsize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 226;BA.debugLine="If index < 0 Or index > ClvList.Size - 1 Then Ret";
if (_index<0 || _index>_clvlist._getsize()-1) { 
if (true) return "";};
 //BA.debugLineNum = 227;BA.debugLine="ClvList.RemoveAt(index)";
_clvlist._removeat(_index);
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public String  _setcompactmode(boolean _state) throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Public Sub setCompactMode(state As Boolean)";
 //BA.debugLineNum = 162;BA.debugLine="mCompactMode = state";
_mcompactmode = _state;
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 153;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 154;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 155;BA.debugLine="HMITileUtils.SetAlpha(BasePane.enabled)";
_hmitileutils._setalpha /*float*/ (_basepane.getEnabled());
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return "";
}
public String  _setselecteditemindex(int _index) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Public Sub setSelectedItemIndex(index As Int)";
 //BA.debugLineNum = 242;BA.debugLine="mSelectedItemIndex = index";
_mselecteditemindex = _index;
 //BA.debugLineNum = 243;BA.debugLine="If ClvList.Size > 0 Then";
if (_clvlist._getsize()>0) { 
 //BA.debugLineNum = 244;BA.debugLine="ClvList.JumpToItem(index)";
_clvlist._jumptoitem(_index);
 //BA.debugLineNum = 245;BA.debugLine="ClvList_ItemClick(index, ClvList.GetValue(index)";
_clvlist_itemclick(_index,_clvlist._getvalue(_index));
 //BA.debugLineNum = 246;BA.debugLine="ClvList.AsView.RequestFocus";
_clvlist._asview().RequestFocus();
 };
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _setshowselected(boolean _state) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub setShowSelected(state As Boolean)";
 //BA.debugLineNum = 147;BA.debugLine="mShowSelected = state";
_mshowselected = _state;
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 139;BA.debugLine="mTitle = text";
_mtitle = _text;
 //BA.debugLineNum = 140;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
