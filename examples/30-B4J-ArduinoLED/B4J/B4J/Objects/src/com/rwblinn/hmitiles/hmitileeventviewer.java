package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitileeventviewer extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.hmitileeventviewer", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.hmitileeventviewer.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _paneeventviewer = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public b4j.example.customlistview _clvevents = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltrash = null;
public boolean _mtimestamp = false;
public int _mmaxevents = 0;
public boolean _mshowtitle = false;
public boolean _mshowtrash = false;
public boolean _mcompactmode = false;
public boolean _mlogging = false;
public anywheresoftware.b4a.objects.collections.List _events = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _add(String _item,int _level) throws Exception{
 //BA.debugLineNum = 260;BA.debugLine="Public Sub Add(item As String, level As Int)";
 //BA.debugLineNum = 261;BA.debugLine="If Not(ClvEvents.IsInitialized) Then Return";
if (__c.Not(_clvevents.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 262;BA.debugLine="If mTimeStamp Then";
if (_mtimestamp) { 
 //BA.debugLineNum = 263;BA.debugLine="item = $\"${FormatTimestamp(DateTime.Now)} - ${it";
_item = (""+__c.SmartStringFormatter("",(Object)(_formattimestamp(__c.DateTime.getNow())))+" - "+__c.SmartStringFormatter("",(Object)(_item))+"");
 };
 //BA.debugLineNum = 265;BA.debugLine="ClvEvents.Add(ClvEventsCreateItem(item, level), i";
_clvevents._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clveventscreateitem(_item,_level).getObject())),(Object)(_item));
 //BA.debugLineNum = 266;BA.debugLine="Events.Add(CreateMap(\"level\":level,\"event\":item))";
_events.Add((Object)(__c.createMap(new Object[] {(Object)("level"),(Object)(_level),(Object)("event"),(Object)(_item)}).getObject()));
 //BA.debugLineNum = 267;BA.debugLine="If ClvEvents.Size > mMaxEvents Then";
if (_clvevents._getsize()>_mmaxevents) { 
 //BA.debugLineNum = 268;BA.debugLine="ClvEvents.RemoveAt(0)";
_clvevents._removeat((int) (0));
 };
 //BA.debugLineNum = 270;BA.debugLine="ClvEvents.JumpToItem(ClvEvents.Size - 1)";
_clvevents._jumptoitem((int) (_clvevents._getsize()-1));
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)";
 //BA.debugLineNum = 89;BA.debugLine="mBase.LoadLayout(\"hmitileeventviewer\")";
_mbase.LoadLayout("hmitileeventviewer",ba);
 //BA.debugLineNum = 92;BA.debugLine="LabelTitle.Text = Props.Get(\"TitleText\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("TitleText"))));
 //BA.debugLineNum = 93;BA.debugLine="mTimeStamp		= Props.Get(\"TimeStamp\")";
_mtimestamp = BA.ObjectToBoolean(_props.Get((Object)("TimeStamp")));
 //BA.debugLineNum = 94;BA.debugLine="mMaxEvents		= Props.Get(\"MaxItems\")";
_mmaxevents = (int)(BA.ObjectToNumber(_props.Get((Object)("MaxItems"))));
 //BA.debugLineNum = 95;BA.debugLine="mShowTitle		= Props.Get(\"ShowTitle\")";
_mshowtitle = BA.ObjectToBoolean(_props.Get((Object)("ShowTitle")));
 //BA.debugLineNum = 96;BA.debugLine="mShowTrash		= Props.Get(\"ShowTrash\")";
_mshowtrash = BA.ObjectToBoolean(_props.Get((Object)("ShowTrash")));
 //BA.debugLineNum = 97;BA.debugLine="mCompactMode	= Props.Get(\"CompactMode\")";
_mcompactmode = BA.ObjectToBoolean(_props.Get((Object)("CompactMode")));
 //BA.debugLineNum = 98;BA.debugLine="mLogging		= Props.GetDefault(\"Logging\", True)";
_mlogging = BA.ObjectToBoolean(_props.GetDefault((Object)("Logging"),(Object)(__c.True)));
 //BA.debugLineNum = 101;BA.debugLine="LabelTrash.TextColor = HMITileUtils.COLOR_TEXT_SE";
_labeltrash.setTextColor(_hmitileutils._color_text_secondary /*int*/ );
 //BA.debugLineNum = 102;BA.debugLine="LabelTrash.Visible = mShowTrash";
_labeltrash.setVisible(_mshowtrash);
 //BA.debugLineNum = 105;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 108;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 212;BA.debugLine="Public Sub ApplyStyle";
 //BA.debugLineNum = 213;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 214;BA.debugLine="PaneEventViewer.Color = HMITileUtils.COLOR_BACKGR";
_paneeventviewer.setColor(_hmitileutils._color_background_default /*int*/ );
 //BA.debugLineNum = 215;BA.debugLine="HMITileUtils.SetCLVBackgroundTransparent(ClvEvent";
_hmitileutils._setclvbackgroundtransparent /*String*/ (_clvevents);
 //BA.debugLineNum = 216;BA.debugLine="ClvEvents.sv.SetColorAndBorder(HMITileUtils.COLOR";
_clvevents._sv.SetColorAndBorder(_hmitileutils._color_background_default /*int*/ ,__c.DipToCurrent((int) (1)),_hmitileutils._color_state_off_border /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 220;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 222;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _l = 0f;
float _t = 0f;
float _w = 0f;
float _h = 0f;
int _pad = 0;
 //BA.debugLineNum = 111;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 112;BA.debugLine="Dim l,t,w,h As Float";
_l = 0f;
_t = 0f;
_w = 0f;
_h = 0f;
 //BA.debugLineNum = 113;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 116;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(ClvEvents";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_clvevents.IsInitialized())) { 
 //BA.debugLineNum = 117;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 120;BA.debugLine="PaneEventViewer.SetLayoutAnimated(0, pad, pad, Wi";
_paneeventviewer.SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_height-_pad*2);
 //BA.debugLineNum = 122;BA.debugLine="LabelTitle.Visible = mShowTitle";
_labeltitle.setVisible(_mshowtitle);
 //BA.debugLineNum = 123;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 124;BA.debugLine="LabelTitle.SetLayoutAnimated(0, 0, 0, PaneEventV";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_paneeventviewer.getWidth(),_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 128;BA.debugLine="l = pad";
_l = (float) (_pad);
 //BA.debugLineNum = 129;BA.debugLine="t = pad";
_t = (float) (_pad);
 //BA.debugLineNum = 130;BA.debugLine="w = PaneEventViewer.Width - pad * 2";
_w = (float) (_paneeventviewer.getWidth()-_pad*2);
 //BA.debugLineNum = 131;BA.debugLine="h = PaneEventViewer.Height - pad";
_h = (float) (_paneeventviewer.getHeight()-_pad);
 //BA.debugLineNum = 132;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 133;BA.debugLine="t = HMITileUtils.EVENT_TITLE_HEIGHT + pad";
_t = (float) (_hmitileutils._event_title_height /*int*/ +_pad);
 //BA.debugLineNum = 134;BA.debugLine="h = h - HMITileUtils.EVENT_TITLE_HEIGHT";
_h = (float) (_h-_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 136;BA.debugLine="If mShowTrash Then";
if (_mshowtrash) { 
 //BA.debugLineNum = 137;BA.debugLine="h = h - LabelTrash.Height";
_h = (float) (_h-_labeltrash.getHeight());
 //BA.debugLineNum = 138;BA.debugLine="LabelTrash.SetLayoutAnimated(0, PaneEventViewer.";
_labeltrash.SetLayoutAnimated((int) (0),_paneeventviewer.getWidth()-_labeltrash.getWidth(),_paneeventviewer.getHeight()-_labeltrash.getHeight()+_pad,_labeltrash.getWidth(),_labeltrash.getHeight());
 };
 //BA.debugLineNum = 140;BA.debugLine="ClvEvents.GetBase.SetLayoutAnimated(0, l, t, w, h";
_clvevents._getbase().SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 142;BA.debugLine="ClvEvents.Base_Resize (ClvEvents.GetBase.Width, C";
_clvevents._base_resize(_clvevents._getbase().getWidth(),_clvevents._getbase().getHeight());
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 38;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 42;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 43;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 46;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Public mLbl As B4XView";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 51;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 52;BA.debugLine="Private PaneEventViewer As B4XView";
_paneeventviewer = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Public ClvEvents As CustomListView		' Can be acce";
_clvevents = new b4j.example.customlistview();
 //BA.debugLineNum = 55;BA.debugLine="Private LabelTrash As B4XView";
_labeltrash = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private mTimeStamp As Boolean";
_mtimestamp = false;
 //BA.debugLineNum = 59;BA.debugLine="Private mMaxEvents As Int";
_mmaxevents = 0;
 //BA.debugLineNum = 60;BA.debugLine="Private mShowTitle As Boolean";
_mshowtitle = false;
 //BA.debugLineNum = 61;BA.debugLine="Private mShowTrash As Boolean";
_mshowtrash = false;
 //BA.debugLineNum = 62;BA.debugLine="Private mCompactMode As Boolean";
_mcompactmode = false;
 //BA.debugLineNum = 63;BA.debugLine="Private mLogging As Boolean";
_mlogging = false;
 //BA.debugLineNum = 66;BA.debugLine="Private Events As List";
_events = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 274;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 275;BA.debugLine="If Not(ClvEvents.IsInitialized) Then Return";
if (__c.Not(_clvevents.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 276;BA.debugLine="ClvEvents.Clear";
_clvevents._clear();
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return "";
}
public String  _clvevents_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 413;BA.debugLine="Private Sub ClvEvents_ItemClick (index As Int, val";
 //BA.debugLineNum = 414;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ItemClick\"";
if (__c.SubExists(ba,_mcallback,_meventname+"_ItemClick")) { 
 //BA.debugLineNum = 415;BA.debugLine="CallSub3(mCallBack, mEventName & \"_ItemClick\", i";
__c.CallSubNew3(ba,_mcallback,_meventname+"_ItemClick",(Object)(_index),_value);
 };
 //BA.debugLineNum = 417;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper  _clveventscreateitem(String _item,int _level) throws Exception{
int _rowheight = 0;
int _rowpadding = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
int _bgcolor = 0;
int _txtcolor = 0;
int _iconcolor = 0;
String _icontext = "";
double _l = 0;
double _t = 0;
double _w = 0;
double _h = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lblicon = null;
float _lblicontextsize = 0f;
anywheresoftware.b4a.objects.B4XViewWrapper _lblitem = null;
float _lblitemtextsize = 0f;
 //BA.debugLineNum = 320;BA.debugLine="Private Sub ClvEventsCreateItem(item As String, le";
 //BA.debugLineNum = 326;BA.debugLine="Dim rowheight As Int	= IIf(mCompactMode, HMITileU";
_rowheight = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_height /*int*/ )) : ((Object)(_hmitileutils._event_normal_height /*int*/ )))));
 //BA.debugLineNum = 327;BA.debugLine="Dim rowpadding As Int	= IIf(mCompactMode, HMITile";
_rowpadding = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_padding /*int*/ )) : ((Object)(_hmitileutils._event_normal_padding /*int*/ )))));
 //BA.debugLineNum = 330;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 331;BA.debugLine="pnl.SetLayoutAnimated(0, rowpadding, rowpadding,";
_pnl.SetLayoutAnimated((int) (0),_rowpadding,_rowpadding,_clvevents._asview().getWidth()-(_rowpadding*2),_rowheight);
 //BA.debugLineNum = 334;BA.debugLine="Dim bgColor As Int 		= HMITileUtils.EVENT_COLOR_B";
_bgcolor = _hmitileutils._event_color_bg_base /*int*/ ;
 //BA.debugLineNum = 335;BA.debugLine="Dim txtColor As Int 	= HMITileUtils.EVENT_COLOR_T";
_txtcolor = _hmitileutils._event_color_text /*int*/ ;
 //BA.debugLineNum = 336;BA.debugLine="Dim iconColor As Int 	= HMITileUtils.EVENT_COLOR_";
_iconcolor = _hmitileutils._event_color_icon_info /*int*/ ;
 //BA.debugLineNum = 337;BA.debugLine="Dim icontext As String";
_icontext = "";
 //BA.debugLineNum = 339;BA.debugLine="Select level";
switch (BA.switchObjectToInt(_level,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ ,_hmitileutils._state_disabled /*int*/ )) {
case 0: {
 //BA.debugLineNum = 341;BA.debugLine="iconColor = HMITileUtils.EVENT_COLOR_TEXT";
_iconcolor = _hmitileutils._event_color_text /*int*/ ;
 //BA.debugLineNum = 342;BA.debugLine="icontext = HMITileUtils.EVENT_ICON_INFO";
_icontext = _hmitileutils._event_icon_info /*String*/ ;
 break; }
case 1: {
 //BA.debugLineNum = 344;BA.debugLine="iconColor = HMITileUtils.EVENT_COLOR_ICON_WARNI";
_iconcolor = _hmitileutils._event_color_icon_warning /*int*/ ;
 //BA.debugLineNum = 345;BA.debugLine="icontext = HMITileUtils.EVENT_ICON_WARNING";
_icontext = _hmitileutils._event_icon_warning /*String*/ ;
 break; }
case 2: {
 //BA.debugLineNum = 347;BA.debugLine="iconColor = HMITileUtils.EVENT_COLOR_ICON_ALARM";
_iconcolor = _hmitileutils._event_color_icon_alarm /*int*/ ;
 //BA.debugLineNum = 348;BA.debugLine="icontext = HMITileUtils.EVENT_ICON_ALARM";
_icontext = _hmitileutils._event_icon_alarm /*String*/ ;
 break; }
case 3: {
 //BA.debugLineNum = 350;BA.debugLine="bgColor = HMITileUtils.EVENT_COLOR_BG_DISABLED";
_bgcolor = _hmitileutils._event_color_bg_disabled /*int*/ ;
 //BA.debugLineNum = 351;BA.debugLine="txtColor = HMITileUtils.EVENT_COLOR_ICON_DISABL";
_txtcolor = _hmitileutils._event_color_icon_disabled /*int*/ ;
 //BA.debugLineNum = 352;BA.debugLine="icontext = HMITileUtils.EVENT_ICON_DISABLED";
_icontext = _hmitileutils._event_icon_disabled /*String*/ ;
 break; }
}
;
 //BA.debugLineNum = 354;BA.debugLine="pnl.Color = bgColor";
_pnl.setColor(_bgcolor);
 //BA.debugLineNum = 356;BA.debugLine="Dim l, t, w, h As Double";
_l = 0;
_t = 0;
_w = 0;
_h = 0;
 //BA.debugLineNum = 357;BA.debugLine="Dim lblicon As B4XView = XUIViewsUtils.CreateLabe";
_lblicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblicon = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 358;BA.debugLine="Dim lblicontextsize As Float = IIf(mCompactMode,";
_lblicontextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_icon_text_size /*float*/ )) : ((Object)(_hmitileutils._event_normal_icon_text_size /*float*/ )))));
 //BA.debugLineNum = 359;BA.debugLine="lblicon.Font = xui.CreateFontAwesome(lblicontexts";
_lblicon.setFont(_xui.CreateFontAwesome(_lblicontextsize));
 //BA.debugLineNum = 360;BA.debugLine="lblicon.Text = icontext";
_lblicon.setText(_icontext);
 //BA.debugLineNum = 361;BA.debugLine="lblicon.SetTextAlignment(\"CENTER\", \"LEFT\")";
_lblicon.SetTextAlignment("CENTER","LEFT");
 //BA.debugLineNum = 362;BA.debugLine="lblicon.TextColor = iconColor";
_lblicon.setTextColor(_iconcolor);
 //BA.debugLineNum = 363;BA.debugLine="l = rowpadding";
_l = _rowpadding;
 //BA.debugLineNum = 364;BA.debugLine="t = 0";
_t = 0;
 //BA.debugLineNum = 365;BA.debugLine="w = lblicontextsize + (rowpadding * 2)";
_w = _lblicontextsize+(_rowpadding*2);
 //BA.debugLineNum = 366;BA.debugLine="h = pnl.Height";
_h = _pnl.getHeight();
 //BA.debugLineNum = 367;BA.debugLine="pnl.AddView(lblicon, l, t, w, h)";
_pnl.AddView((javafx.scene.Node)(_lblicon.getObject()),_l,_t,_w,_h);
 //BA.debugLineNum = 369;BA.debugLine="Dim lblitem As B4XView = XUIViewsUtils.CreateLabe";
_lblitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblitem = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 370;BA.debugLine="Dim lblitemtextsize As Float = IIf(mCompactMode,";
_lblitemtextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_message_text_size /*float*/ )) : ((Object)(_hmitileutils._event_normal_message_text_size /*float*/ )))));
 //BA.debugLineNum = 372;BA.debugLine="lblitem.Font = xui.CreateDefaultFont(lblitemtexts";
_lblitem.setFont(_xui.CreateDefaultFont(_lblitemtextsize));
 //BA.debugLineNum = 374;BA.debugLine="lblitem.Text = item";
_lblitem.setText(_item);
 //BA.debugLineNum = 375;BA.debugLine="lblitem.SetTextAlignment(\"CENTER\", \"LEFT\")";
_lblitem.SetTextAlignment("CENTER","LEFT");
 //BA.debugLineNum = 376;BA.debugLine="lblitem.TextColor = txtColor";
_lblitem.setTextColor(_txtcolor);
 //BA.debugLineNum = 377;BA.debugLine="If mLogging Then";
if (_mlogging) { 
 //BA.debugLineNum = 378;BA.debugLine="Log(item)";
__c.LogImpl("917629242",_item,0);
 };
 //BA.debugLineNum = 385;BA.debugLine="l = lblicontextsize + (rowpadding * 2)";
_l = _lblicontextsize+(_rowpadding*2);
 //BA.debugLineNum = 387;BA.debugLine="t = 0";
_t = 0;
 //BA.debugLineNum = 388;BA.debugLine="w = pnl.Width - l";
_w = _pnl.getWidth()-_l;
 //BA.debugLineNum = 389;BA.debugLine="h = pnl.Height";
_h = _pnl.getHeight();
 //BA.debugLineNum = 390;BA.debugLine="pnl.AddView(lblitem, l, t, w, h)";
_pnl.AddView((javafx.scene.Node)(_lblitem.getObject()),_l,_t,_w,_h);
 //BA.debugLineNum = 392;BA.debugLine="Return pnl";
if (true) return (anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper(), (javafx.scene.layout.Pane)(_pnl.getObject()));
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 76;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 77;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 78;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 79;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 81;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public String  _formattimestamp(long _ts) throws Exception{
 //BA.debugLineNum = 398;BA.debugLine="Private Sub FormatTimestamp(ts As Long) As String";
 //BA.debugLineNum = 399;BA.debugLine="Return DateTime.Time(ts)";
if (true) return __c.DateTime.Time(_ts);
 //BA.debugLineNum = 400;BA.debugLine="End Sub";
return "";
}
public boolean  _getcompactmode() throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Public Sub getCompactMode As Boolean";
 //BA.debugLineNum = 195;BA.debugLine="Return mCompactMode";
if (true) return _mcompactmode;
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 166;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return false;
}
public boolean  _getlogging() throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Public Sub getLogging As Boolean";
 //BA.debugLineNum = 202;BA.debugLine="Return mLogging";
if (true) return _mlogging;
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return false;
}
public int  _getmaxitems() throws Exception{
 //BA.debugLineNum = 180;BA.debugLine="Public Sub getMaxItems As Int";
 //BA.debugLineNum = 181;BA.debugLine="Return mMaxEvents";
if (true) return _mmaxevents;
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowtrash() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Public Sub getShowTrash As Boolean";
 //BA.debugLineNum = 188;BA.debugLine="Return LabelTrash.Visible";
if (true) return _labeltrash.getVisible();
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 158;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 69;BA.debugLine="Private Sub Initialize (Callback As Object, EventN";
 //BA.debugLineNum = 70;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 71;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 72;BA.debugLine="Events.Initialize";
_events.Initialize();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _insert(String _item,int _level) throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Public Sub Insert(item As String, level As Int)";
 //BA.debugLineNum = 240;BA.debugLine="If Not(ClvEvents.IsInitialized) Then Return";
if (__c.Not(_clvevents.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 241;BA.debugLine="If mTimeStamp Then";
if (_mtimestamp) { 
 //BA.debugLineNum = 242;BA.debugLine="item = $\"${FormatTimestamp(DateTime.Now)} - ${it";
_item = (""+__c.SmartStringFormatter("",(Object)(_formattimestamp(__c.DateTime.getNow())))+" - "+__c.SmartStringFormatter("",(Object)(_item))+"");
 };
 //BA.debugLineNum = 244;BA.debugLine="ClvEvents.InsertAt(0, ClvEventsCreateItem(item, l";
_clvevents._insertat((int) (0),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clveventscreateitem(_item,_level).getObject())),(Object)(_item));
 //BA.debugLineNum = 245;BA.debugLine="Events.InsertAt(0, CreateMap(\"level\":level,\"event";
_events.InsertAt((int) (0),(Object)(__c.createMap(new Object[] {(Object)("level"),(Object)(_level),(Object)("event"),(Object)(_item)}).getObject()));
 //BA.debugLineNum = 246;BA.debugLine="If ClvEvents.Size > mMaxEvents Then";
if (_clvevents._getsize()>_mmaxevents) { 
 //BA.debugLineNum = 247;BA.debugLine="ClvEvents.RemoveAt(ClvEvents.Size - 1)";
_clvevents._removeat((int) (_clvevents._getsize()-1));
 //BA.debugLineNum = 248;BA.debugLine="Events.RemoveAt(ClvEvents.Size - 1)";
_events.RemoveAt((int) (_clvevents._getsize()-1));
 };
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public String  _labeltrash_click() throws Exception{
 //BA.debugLineNum = 442;BA.debugLine="Private Sub LabelTrash_Click";
 //BA.debugLineNum = 443;BA.debugLine="Clear";
_clear();
 //BA.debugLineNum = 444;BA.debugLine="End Sub";
return "";
}
public String  _labeltrash_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 432;BA.debugLine="Private Sub LabelTrash_MouseClicked (EventData As";
 //BA.debugLineNum = 433;BA.debugLine="LabelTrash_Click";
_labeltrash_click();
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public String  _setcompactmode(boolean _state) throws Exception{
 //BA.debugLineNum = 191;BA.debugLine="Public Sub setCompactMode(state As Boolean)";
 //BA.debugLineNum = 192;BA.debugLine="mCompactMode = state";
_mcompactmode = _state;
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 162;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 163;BA.debugLine="HMITileUtils.SetAlpha(mBase.enabled)";
_hmitileutils._setalpha /*float*/ (_mbase.getEnabled());
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public String  _setlogging(boolean _enabled) throws Exception{
 //BA.debugLineNum = 198;BA.debugLine="Public Sub setLogging(enabled As Boolean)";
 //BA.debugLineNum = 199;BA.debugLine="mLogging = enabled";
_mlogging = _enabled;
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public String  _setmaxitems(int _value) throws Exception{
 //BA.debugLineNum = 173;BA.debugLine="Public Sub setMaxItems(value As Int)";
 //BA.debugLineNum = 174;BA.debugLine="mMaxEvents = value";
_mmaxevents = _value;
 //BA.debugLineNum = 176;BA.debugLine="Do While ClvEvents.Size > mMaxEvents";
while (_clvevents._getsize()>_mmaxevents) {
 //BA.debugLineNum = 177;BA.debugLine="ClvEvents.RemoveAt(ClvEvents.Size - 1) ' safely";
_clvevents._removeat((int) (_clvevents._getsize()-1));
 }
;
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public String  _setshowtrash(boolean _state) throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Public Sub setShowTrash(state As Boolean)";
 //BA.debugLineNum = 185;BA.debugLine="LabelTrash.Visible = state";
_labeltrash.setVisible(_state);
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 155;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.Map  _statesummary() throws Exception{
anywheresoftware.b4a.objects.collections.Map _result = null;
int _normalcount = 0;
int _warningcount = 0;
int _alarmcount = 0;
anywheresoftware.b4a.objects.collections.Map _event = null;
int _level = 0;
 //BA.debugLineNum = 284;BA.debugLine="Public Sub StateSummary As Map";
 //BA.debugLineNum = 285;BA.debugLine="Dim result As Map";
_result = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 286;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 287;BA.debugLine="Dim normalcount As Int = 0";
_normalcount = (int) (0);
 //BA.debugLineNum = 288;BA.debugLine="Dim warningcount As Int = 0";
_warningcount = (int) (0);
 //BA.debugLineNum = 289;BA.debugLine="Dim alarmcount As Int = 0";
_alarmcount = (int) (0);
 //BA.debugLineNum = 291;BA.debugLine="For Each event As Map In Events";
_event = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group6 = _events;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_event = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group6.Get(index6)));
 //BA.debugLineNum = 292;BA.debugLine="Dim level As Int = event.Get(\"level\")";
_level = (int)(BA.ObjectToNumber(_event.Get((Object)("level"))));
 //BA.debugLineNum = 293;BA.debugLine="Select level";
switch (BA.switchObjectToInt(_level,_hmitileutils._state_normal /*int*/ ,_hmitileutils._state_warning /*int*/ ,_hmitileutils._state_alarm /*int*/ )) {
case 0: {
 //BA.debugLineNum = 295;BA.debugLine="normalcount = normalcount + 1";
_normalcount = (int) (_normalcount+1);
 break; }
case 1: {
 //BA.debugLineNum = 297;BA.debugLine="warningcount = warningcount + 1";
_warningcount = (int) (_warningcount+1);
 break; }
case 2: {
 //BA.debugLineNum = 299;BA.debugLine="alarmcount = alarmcount + 1";
_alarmcount = (int) (_alarmcount+1);
 break; }
}
;
 }
};
 //BA.debugLineNum = 302;BA.debugLine="result = CreateMap( \"normal\": normalcount, _";
_result = __c.createMap(new Object[] {(Object)("normal"),(Object)(_normalcount),(Object)("warning"),(Object)(_warningcount),(Object)("alarm"),(Object)(_alarmcount)});
 //BA.debugLineNum = 305;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
