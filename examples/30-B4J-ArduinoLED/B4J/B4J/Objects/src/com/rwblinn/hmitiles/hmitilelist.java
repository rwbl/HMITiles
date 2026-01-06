package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilelist extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.hmitilelist", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.hmitilelist.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.objects.JFX _fx = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public b4j.example.customlistview _clvlist = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _panelist = null;
public boolean _mshowtitle = false;
public boolean _mshowselected = false;
public boolean _mcompactmode = false;
public int _mcommandselected = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _add(String _primaryitem,String _secondaryitem,Object _value) throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Public Sub Add(primaryitem As String, secondaryite";
 //BA.debugLineNum = 185;BA.debugLine="ClvList.Add(ClvListCreateItem(primaryitem, second";
_clvlist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clvlistcreateitem(_primaryitem,_secondaryitem).getObject())),_value);
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)";
 //BA.debugLineNum = 76;BA.debugLine="mBase.LoadLayout(\"hmitilelist\")";
_mbase.LoadLayout("hmitilelist",ba);
 //BA.debugLineNum = 79;BA.debugLine="LabelTitle.Text = Props.Get(\"TitleText\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("TitleText"))));
 //BA.debugLineNum = 80;BA.debugLine="mShowTitle 		= Props.Get(\"ShowTitle\")";
_mshowtitle = BA.ObjectToBoolean(_props.Get((Object)("ShowTitle")));
 //BA.debugLineNum = 81;BA.debugLine="mShowSelected 	= Props.Get(\"ShowSelected\")";
_mshowselected = BA.ObjectToBoolean(_props.Get((Object)("ShowSelected")));
 //BA.debugLineNum = 82;BA.debugLine="mCompactMode	= Props.Get(\"CompactMode\")";
_mcompactmode = BA.ObjectToBoolean(_props.Get((Object)("CompactMode")));
 //BA.debugLineNum = 85;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 88;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Public Sub ApplyStyle";
 //BA.debugLineNum = 163;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 164;BA.debugLine="PaneList.Color = HMITileUtils.COLOR_BACKGROUND_DE";
_panelist.setColor(_hmitileutils._color_background_default /*int*/ );
 //BA.debugLineNum = 165;BA.debugLine="HMITileUtils.SetCLVBackgroundTransparent(ClvList)";
_hmitileutils._setclvbackgroundtransparent /*String*/ (_clvlist);
 //BA.debugLineNum = 166;BA.debugLine="ClvList.sv.SetColorAndBorder(HMITileUtils.COLOR_B";
_clvlist._sv.SetColorAndBorder(_hmitileutils._color_background_default /*int*/ ,__c.DipToCurrent((int) (1)),_hmitileutils._color_state_off_border /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 170;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 172;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _l = 0f;
float _t = 0f;
float _w = 0f;
float _h = 0f;
int _pad = 0;
 //BA.debugLineNum = 91;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 92;BA.debugLine="Dim l,t,w,h As Float";
_l = 0f;
_t = 0f;
_w = 0f;
_h = 0f;
 //BA.debugLineNum = 93;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + 4dip";
_pad = (int) (_hmitileutils._border_width /*double*/ +__c.DipToCurrent((int) (4)));
 //BA.debugLineNum = 96;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(ClvList.I";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_clvlist.IsInitialized())) { 
 //BA.debugLineNum = 97;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 100;BA.debugLine="PaneList.SetLayoutAnimated		(0, 0, 0, Width, Heig";
_panelist.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 101;BA.debugLine="LabelTitle.Visible = mShowTitle";
_labeltitle.setVisible(_mshowtitle);
 //BA.debugLineNum = 102;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 103;BA.debugLine="LabelTitle.SetLayoutAnimated(0, 0, 0, PaneList.W";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_panelist.getWidth(),_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 107;BA.debugLine="l = pad";
_l = (float) (_pad);
 //BA.debugLineNum = 108;BA.debugLine="t = pad";
_t = (float) (_pad);
 //BA.debugLineNum = 109;BA.debugLine="w = PaneList.Width - pad * 2";
_w = (float) (_panelist.getWidth()-_pad*2);
 //BA.debugLineNum = 110;BA.debugLine="h = PaneList.Height - pad * 2";
_h = (float) (_panelist.getHeight()-_pad*2);
 //BA.debugLineNum = 111;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 112;BA.debugLine="t = HMITileUtils.EVENT_TITLE_HEIGHT + pad";
_t = (float) (_hmitileutils._event_title_height /*int*/ +_pad);
 //BA.debugLineNum = 113;BA.debugLine="h = h - HMITileUtils.EVENT_TITLE_HEIGHT";
_h = (float) (_h-_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 115;BA.debugLine="ClvList.GetBase.SetLayoutAnimated(0, l, t, w, h)";
_clvlist._getbase().SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 118;BA.debugLine="ClvList.Base_Resize (ClvList.GetBase.Width, ClvLi";
_clvlist._base_resize(_clvlist._getbase().getWidth(),_clvlist._getbase().getHeight());
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 33;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 37;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 38;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 41;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 46;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 47;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private ClvList As CustomListView";
_clvlist = new b4j.example.customlistview();
 //BA.debugLineNum = 49;BA.debugLine="Private PaneList As B4XView";
_panelist = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private mShowTitle As Boolean";
_mshowtitle = false;
 //BA.debugLineNum = 53;BA.debugLine="Private mShowSelected As Boolean";
_mshowselected = false;
 //BA.debugLineNum = 54;BA.debugLine="Private mCompactMode As Boolean";
_mcompactmode = false;
 //BA.debugLineNum = 57;BA.debugLine="Private mCommandSelected As Int = -1		' Keep trac";
_mcommandselected = (int) (-1);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 218;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 219;BA.debugLine="ClvList.Clear";
_clvlist._clear();
 //BA.debugLineNum = 220;BA.debugLine="End Sub";
return "";
}
public String  _clvlist_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 286;BA.debugLine="Private Sub ClvList_ItemClick (Index As Int, Value";
 //BA.debugLineNum = 289;BA.debugLine="If mShowSelected Then";
if (_mshowselected) { 
 //BA.debugLineNum = 291;BA.debugLine="If mCommandSelected == -1 Then mCommandSelected";
if (_mcommandselected==-1) { 
_mcommandselected = _index;};
 //BA.debugLineNum = 293;BA.debugLine="ClvList.GetPanel(mCommandSelected).Color = HMITi";
_clvlist._getpanel(_mcommandselected).setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 295;BA.debugLine="ClvList.GetPanel(Index).Color = HMITileUtils.COL";
_clvlist._getpanel(_index).setColor(_hmitileutils._color_background_selected /*int*/ );
 //BA.debugLineNum = 297;BA.debugLine="mCommandSelected = Index";
_mcommandselected = _index;
 };
 //BA.debugLineNum = 301;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ItemClick\"";
if (__c.SubExists(ba,_mcallback,_meventname+"_ItemClick")) { 
 //BA.debugLineNum = 302;BA.debugLine="CallSub3(mCallBack, mEventName & \"_ItemClick\", I";
__c.CallSubNew3(ba,_mcallback,_meventname+"_ItemClick",(Object)(_index),_value);
 };
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 231;BA.debugLine="Private Sub ClvListCreateItem(primaryitem As Strin";
 //BA.debugLineNum = 237;BA.debugLine="Dim rowheight As Int			= IIf(mCompactMode, HMITil";
_rowheight = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_height /*int*/ )) : ((Object)(_hmitileutils._list_normal_height /*int*/ )))));
 //BA.debugLineNum = 238;BA.debugLine="Dim rowpadding As Int			= IIf(mCompactMode, HMITi";
_rowpadding = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_padding /*int*/ )) : ((Object)(_hmitileutils._list_normal_padding /*int*/ )))));
 //BA.debugLineNum = 241;BA.debugLine="Dim primarytextsize As Float	= IIf(mCompactMode,";
_primarytextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_primary_text_size /*float*/ )) : ((Object)(_hmitileutils._list_normal_primary_text_size /*float*/ )))));
 //BA.debugLineNum = 242;BA.debugLine="Dim secondarytextsize As Float	= IIf(mCompactMode";
_secondarytextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._list_compact_secondary_text_size /*float*/ )) : ((Object)(_hmitileutils._list_compact_secondary_text_size /*float*/ )))));
 //BA.debugLineNum = 245;BA.debugLine="Dim pnl As B4XView				= xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 246;BA.debugLine="pnl.SetLayoutAnimated(0, rowpadding, rowpadding,";
_pnl.SetLayoutAnimated((int) (0),_rowpadding,_rowpadding,_clvlist._asview().getWidth()-(_rowpadding*2),_rowheight);
 //BA.debugLineNum = 247;BA.debugLine="Dim primaryitemheight As Int	= IIf(secondaryitem.";
_primaryitemheight = (int)(BA.ObjectToNumber(((_secondaryitem.length()>0) ? ((Object)(_pnl.getHeight()/(double)2)) : ((Object)(_pnl.getHeight())))));
 //BA.debugLineNum = 250;BA.debugLine="pnl.Color = HMITileUtils.LIST_COLOR_BG_BASE";
_pnl.setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 253;BA.debugLine="Dim lblprimaryitem As B4XView	= XUIViewsUtils.Cre";
_lblprimaryitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblprimaryitem = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 254;BA.debugLine="lblprimaryitem.Font 			= xui.CreateDefaultFont(pr";
_lblprimaryitem.setFont(_xui.CreateDefaultFont(_primarytextsize));
 //BA.debugLineNum = 255;BA.debugLine="lblprimaryitem.Color			= HMITileUtils.LIST_COLOR_";
_lblprimaryitem.setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 256;BA.debugLine="lblprimaryitem.Text				= primaryitem";
_lblprimaryitem.setText(_primaryitem);
 //BA.debugLineNum = 257;BA.debugLine="lblprimaryitem.TextColor		= HMITileUtils.LIST_COL";
_lblprimaryitem.setTextColor(_hmitileutils._list_color_text /*int*/ );
 //BA.debugLineNum = 258;BA.debugLine="lblprimaryitem.SetTextAlignment(\"TOP\", \"LEFT\")";
_lblprimaryitem.SetTextAlignment("TOP","LEFT");
 //BA.debugLineNum = 259;BA.debugLine="pnl.AddView(lblprimaryitem, rowpadding, 0, pnl.Wi";
_pnl.AddView((javafx.scene.Node)(_lblprimaryitem.getObject()),_rowpadding,0,_pnl.getWidth(),_primaryitemheight);
 //BA.debugLineNum = 263;BA.debugLine="If secondaryitem.Length > 0 Then";
if (_secondaryitem.length()>0) { 
 //BA.debugLineNum = 265;BA.debugLine="Dim lblsecondaryitem As B4XView	= XUIViewsUtils.";
_lblsecondaryitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblsecondaryitem = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 266;BA.debugLine="lblsecondaryitem.Font 			= xui.CreateDefaultFont";
_lblsecondaryitem.setFont(_xui.CreateDefaultFont(_secondarytextsize));
 //BA.debugLineNum = 267;BA.debugLine="lblsecondaryitem.Color 			= HMITileUtils.LIST_CO";
_lblsecondaryitem.setColor(_hmitileutils._list_color_bg_base /*int*/ );
 //BA.debugLineNum = 268;BA.debugLine="lblsecondaryitem.Text 			= secondaryitem";
_lblsecondaryitem.setText(_secondaryitem);
 //BA.debugLineNum = 269;BA.debugLine="lblsecondaryitem.TextColor 		= HMITileUtils.LIST";
_lblsecondaryitem.setTextColor(_hmitileutils._list_color_text /*int*/ );
 //BA.debugLineNum = 270;BA.debugLine="lblsecondaryitem.SetTextAlignment(\"BOTTOM\", \"LEF";
_lblsecondaryitem.SetTextAlignment("BOTTOM","LEFT");
 //BA.debugLineNum = 271;BA.debugLine="pnl.AddView(lblsecondaryitem, rowpadding, rowhei";
_pnl.AddView((javafx.scene.Node)(_lblsecondaryitem.getObject()),_rowpadding,_rowheight/(double)2,_pnl.getWidth(),_pnl.getHeight()/(double)2);
 };
 //BA.debugLineNum = 275;BA.debugLine="Return pnl";
if (true) return (anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper(), (javafx.scene.layout.Pane)(_pnl.getObject()));
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 66;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 67;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 68;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 69;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 71;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public boolean  _getcompactmode() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub getCompactMode As Boolean";
 //BA.debugLineNum = 152;BA.debugLine="Return mCompactMode";
if (true) return _mcompactmode;
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 145;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowselected() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Public Sub getShowSelected As Boolean";
 //BA.debugLineNum = 137;BA.debugLine="Return mShowSelected";
if (true) return _mshowselected;
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 130;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 60;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 61;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 62;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _insert(String _primaryitem,String _secondaryitem,Object _value) throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Public Sub Insert(primaryitem As String, secondary";
 //BA.debugLineNum = 200;BA.debugLine="ClvList.InsertAt(	0, _ 						ClvListCreateItem(pr";
_clvlist._insertat((int) (0),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clvlistcreateitem(_primaryitem,_secondaryitem).getObject())),_value);
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public String  _labeltrash_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Private Sub LabelTrash_MouseClicked (EventData As";
 //BA.debugLineNum = 312;BA.debugLine="Clear";
_clear();
 //BA.debugLineNum = 313;BA.debugLine="End Sub";
return "";
}
public String  _remove(int _index) throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Public Sub Remove(index As Int)";
 //BA.debugLineNum = 212;BA.debugLine="If ClvList.Size == 0 Then Return";
if (_clvlist._getsize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 213;BA.debugLine="If index < 0 Or index > ClvList.Size - 1 Then Ret";
if (_index<0 || _index>_clvlist._getsize()-1) { 
if (true) return "";};
 //BA.debugLineNum = 214;BA.debugLine="ClvList.RemoveAt(index)";
_clvlist._removeat(_index);
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public String  _setcompactmode(boolean _state) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub setCompactMode(state As Boolean)";
 //BA.debugLineNum = 149;BA.debugLine="mCompactMode = state";
_mcompactmode = _state;
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 141;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 142;BA.debugLine="HMITileUtils.SetAlpha(mBase.enabled)";
_hmitileutils._setalpha /*float*/ (_mbase.getEnabled());
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _setshowselected(boolean _state) throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Public Sub setShowSelected(state As Boolean)";
 //BA.debugLineNum = 134;BA.debugLine="mShowSelected = state";
_mshowselected = _state;
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 127;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
