package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitileeventviewer extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitileeventviewer", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitileeventviewer.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _paneeventviewer = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public b4j.example.customlistview _clvevents = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltrash = null;
public String _mtitle = "";
public boolean _mtimestamp = false;
public int _mmaxevents = 0;
public boolean _mshowtitle = false;
public boolean _mshowtrash = false;
public boolean _mcompactmode = false;
public boolean _mlogging = false;
public double _mrowheight = 0;
public anywheresoftware.b4a.objects.collections.List _events = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _add(String _event,int _level) throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 287;BA.debugLine="Public Sub Add(event As String, level As Int)";
 //BA.debugLineNum = 288;BA.debugLine="If Not(ClvEvents.IsInitialized) Then Return";
if (__c.Not(_clvevents.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 290;BA.debugLine="Dim m As Map = CreateMap(\"timestamp\":FormatTimest";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = __c.createMap(new Object[] {(Object)("timestamp"),(Object)(_formattimestamp(__c.DateTime.getNow())),(Object)("level"),(Object)(_level),(Object)("event"),(Object)(_event)});
 //BA.debugLineNum = 291;BA.debugLine="Events.add(m)";
_events.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 292;BA.debugLine="If mTimeStamp Then";
if (_mtimestamp) { 
 //BA.debugLineNum = 293;BA.debugLine="event = $\"${FormatTimestamp(DateTime.Now)} - ${e";
_event = (""+__c.SmartStringFormatter("",(Object)(_formattimestamp(__c.DateTime.getNow())))+" - "+__c.SmartStringFormatter("",(Object)(_event))+"");
 };
 //BA.debugLineNum = 295;BA.debugLine="ClvEvents.add(ClvEventsCreateItem(event, level),";
_clvevents._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clveventscreateitem(_event,_level).getObject())),(Object)(_m.getObject()));
 //BA.debugLineNum = 297;BA.debugLine="If mLogging Then";
if (_mlogging) { 
 //BA.debugLineNum = 298;BA.debugLine="Log($\"m.get(\"timestamp\") level=${m.Get(\"level\")}";
__c.LogImpl("944564491",("m.get(\"timestamp\") level="+__c.SmartStringFormatter("",_m.Get((Object)("level")))+" event="+__c.SmartStringFormatter("",_m.Get((Object)("event")))+""),0);
 };
 //BA.debugLineNum = 301;BA.debugLine="If ClvEvents.Size > mMaxEvents Then";
if (_clvevents._getsize()>_mmaxevents) { 
 //BA.debugLineNum = 302;BA.debugLine="ClvEvents.RemoveAt(0)";
_clvevents._removeat((int) (0));
 //BA.debugLineNum = 303;BA.debugLine="Events.RemoveAt(0)";
_events.RemoveAt((int) (0));
 };
 //BA.debugLineNum = 305;BA.debugLine="ClvEvents.JumpToItem(ClvEvents.Size - 1)";
_clvevents._jumptoitem((int) (_clvevents._getsize()-1));
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 92;BA.debugLine="BasePane.LoadLayout(\"hmitileeventviewer\")";
_basepane.LoadLayout("hmitileeventviewer",ba);
 //BA.debugLineNum = 95;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 96;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 97;BA.debugLine="mTimeStamp		= Props.Get(\"TimeStamp\")";
_mtimestamp = BA.ObjectToBoolean(_props.Get((Object)("TimeStamp")));
 //BA.debugLineNum = 98;BA.debugLine="mMaxEvents		= Props.Get(\"MaxItems\")";
_mmaxevents = (int)(BA.ObjectToNumber(_props.Get((Object)("MaxItems"))));
 //BA.debugLineNum = 99;BA.debugLine="mShowTitle		= Props.GetDefault(\"ShowTitle\", True)";
_mshowtitle = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowTitle"),(Object)(__c.True)));
 //BA.debugLineNum = 100;BA.debugLine="mShowTrash		= Props.GetDefault(\"ShowTrash\", True)";
_mshowtrash = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowTrash"),(Object)(__c.True)));
 //BA.debugLineNum = 101;BA.debugLine="mCompactMode	= Props.GetDefault(\"CompactMode\", Fa";
_mcompactmode = BA.ObjectToBoolean(_props.GetDefault((Object)("CompactMode"),(Object)(__c.False)));
 //BA.debugLineNum = 102;BA.debugLine="mLogging		= Props.GetDefault(\"Logging\", True)";
_mlogging = BA.ObjectToBoolean(_props.GetDefault((Object)("Logging"),(Object)(__c.True)));
 //BA.debugLineNum = 103;BA.debugLine="mRowHeight		= IIf(mCompactMode, HMITileUtils.EVEN";
_mrowheight = (double)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_height /*int*/ )) : ((Object)(_hmitileutils._event_normal_height /*int*/ )))));
 //BA.debugLineNum = 106;BA.debugLine="LabelTrash.TextColor = HMITileUtils.COLOR_TEXT_SE";
_labeltrash.setTextColor(_hmitileutils._color_text_secondary /*int*/ );
 //BA.debugLineNum = 107;BA.debugLine="LabelTrash.Visible = mShowTrash";
_labeltrash.setVisible(_mshowtrash);
 //BA.debugLineNum = 110;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 113;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 229;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 230;BA.debugLine="PaneEventViewer.Color = HMITileUtils.COLOR_BACKGR";
_paneeventviewer.setColor(_hmitileutils._color_background_default /*int*/ );
 //BA.debugLineNum = 231;BA.debugLine="HMITileUtils.SetCLVBackgroundTransparent(ClvEvent";
_hmitileutils._setclvbackgroundtransparent /*String*/ (_clvevents);
 //BA.debugLineNum = 232;BA.debugLine="ClvEvents.sv.SetColorAndBorder(HMITileUtils.COLOR";
_clvevents._sv.SetColorAndBorder(_hmitileutils._color_background_default /*int*/ ,__c.DipToCurrent((int) (1)),_hmitileutils._color_status_off_border /*int*/ ,__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 236;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 238;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _l = 0f;
float _t = 0f;
float _w = 0f;
float _h = 0f;
int _pad = 0;
 //BA.debugLineNum = 116;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 117;BA.debugLine="If Not(LabelTitle.IsInitialized) Or Not(ClvEvents";
if (__c.Not(_labeltitle.IsInitialized()) || __c.Not(_clvevents.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 118;BA.debugLine="Dim l,t,w,h As Float";
_l = 0f;
_t = 0f;
_w = 0f;
_h = 0f;
 //BA.debugLineNum = 119;BA.debugLine="Dim pad As Int = HMITileUtils.TILE_PADDING";
_pad = _hmitileutils._tile_padding /*int*/ ;
 //BA.debugLineNum = 121;BA.debugLine="PaneEventViewer.SetLayoutAnimated(0, pad, pad, Wi";
_paneeventviewer.SetLayoutAnimated((int) (0),_pad,_pad,_width-_pad*2,_height-_pad*2);
 //BA.debugLineNum = 123;BA.debugLine="LabelTitle.Visible = mShowTitle";
_labeltitle.setVisible(_mshowtitle);
 //BA.debugLineNum = 124;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 125;BA.debugLine="LabelTitle.SetLayoutAnimated(0, 0, 0, PaneEventV";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_paneeventviewer.getWidth(),_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 129;BA.debugLine="l = pad";
_l = (float) (_pad);
 //BA.debugLineNum = 130;BA.debugLine="t = pad";
_t = (float) (_pad);
 //BA.debugLineNum = 131;BA.debugLine="w = PaneEventViewer.Width - pad * 2";
_w = (float) (_paneeventviewer.getWidth()-_pad*2);
 //BA.debugLineNum = 132;BA.debugLine="h = PaneEventViewer.Height - pad";
_h = (float) (_paneeventviewer.getHeight()-_pad);
 //BA.debugLineNum = 133;BA.debugLine="If mShowTitle Then";
if (_mshowtitle) { 
 //BA.debugLineNum = 134;BA.debugLine="t = HMITileUtils.EVENT_TITLE_HEIGHT + pad";
_t = (float) (_hmitileutils._event_title_height /*int*/ +_pad);
 //BA.debugLineNum = 135;BA.debugLine="h = h - HMITileUtils.EVENT_TITLE_HEIGHT";
_h = (float) (_h-_hmitileutils._event_title_height /*int*/ );
 };
 //BA.debugLineNum = 137;BA.debugLine="If mShowTrash Then";
if (_mshowtrash) { 
 //BA.debugLineNum = 138;BA.debugLine="h = h - LabelTrash.Height";
_h = (float) (_h-_labeltrash.getHeight());
 //BA.debugLineNum = 139;BA.debugLine="LabelTrash.SetLayoutAnimated(0, PaneEventViewer.";
_labeltrash.SetLayoutAnimated((int) (0),_paneeventviewer.getWidth()-_labeltrash.getWidth(),_paneeventviewer.getHeight()-_labeltrash.getHeight()+_pad,_labeltrash.getWidth(),_labeltrash.getHeight());
 };
 //BA.debugLineNum = 141;BA.debugLine="ClvEvents.GetBase.SetLayoutAnimated(0, l, t, w, h";
_clvevents._getbase().SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 //BA.debugLineNum = 143;BA.debugLine="ClvEvents.Base_Resize (ClvEvents.GetBase.Width, C";
_clvevents._base_resize(_clvevents._getbase().getWidth(),_clvevents._getbase().getHeight());
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 46;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Public BaseLabel As B4XView";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
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
 //BA.debugLineNum = 58;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 59;BA.debugLine="Private mTimeStamp As Boolean";
_mtimestamp = false;
 //BA.debugLineNum = 60;BA.debugLine="Private mMaxEvents As Int";
_mmaxevents = 0;
 //BA.debugLineNum = 61;BA.debugLine="Private mShowTitle As Boolean";
_mshowtitle = false;
 //BA.debugLineNum = 62;BA.debugLine="Private mShowTrash As Boolean";
_mshowtrash = false;
 //BA.debugLineNum = 63;BA.debugLine="Private mCompactMode As Boolean";
_mcompactmode = false;
 //BA.debugLineNum = 64;BA.debugLine="Private mLogging As Boolean";
_mlogging = false;
 //BA.debugLineNum = 67;BA.debugLine="Private mRowHeight As Double";
_mrowheight = 0;
 //BA.debugLineNum = 69;BA.debugLine="Private Events As List";
_events = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 310;BA.debugLine="If Not(ClvEvents.IsInitialized) Then Return";
if (__c.Not(_clvevents.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 311;BA.debugLine="ClvEvents.Clear";
_clvevents._clear();
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public String  _clvevents_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 454;BA.debugLine="Private Sub ClvEvents_ItemClick (index As Int, val";
 //BA.debugLineNum = 455;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ItemClick\"";
if (__c.SubExists(ba,_mcallback,_meventname+"_ItemClick")) { 
 //BA.debugLineNum = 456;BA.debugLine="CallSubDelayed3(mCallBack, mEventName & \"_ItemCl";
__c.CallSubDelayed3(ba,_mcallback,_meventname+"_ItemClick",(Object)(_index),_value);
 };
 //BA.debugLineNum = 458;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper  _clveventscreateitem(String _item,int _level) throws Exception{
double _rowheight = 0;
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
 //BA.debugLineNum = 365;BA.debugLine="Private Sub ClvEventsCreateItem(item As String, le";
 //BA.debugLineNum = 371;BA.debugLine="Dim rowheight As Double	= mRowHeight";
_rowheight = _mrowheight;
 //BA.debugLineNum = 372;BA.debugLine="Dim rowpadding As Int	= IIf(mCompactMode, HMITile";
_rowpadding = (int)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_padding /*int*/ )) : ((Object)(_hmitileutils._event_normal_padding /*int*/ )))));
 //BA.debugLineNum = 375;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 376;BA.debugLine="pnl.SetLayoutAnimated(0, rowpadding, rowpadding,";
_pnl.SetLayoutAnimated((int) (0),_rowpadding,_rowpadding,_clvevents._asview().getWidth()-(_rowpadding*2),_rowheight);
 //BA.debugLineNum = 379;BA.debugLine="Dim bgColor As Int 		= HMITileUtils.EVENT_COLOR_B";
_bgcolor = _hmitileutils._event_color_bg_base /*int*/ ;
 //BA.debugLineNum = 380;BA.debugLine="Dim txtColor As Int 	= HMITileUtils.EVENT_COLOR_T";
_txtcolor = _hmitileutils._event_color_text /*int*/ ;
 //BA.debugLineNum = 381;BA.debugLine="Dim iconColor As Int 	= HMITileUtils.EVENT_COLOR_";
_iconcolor = _hmitileutils._event_color_icon_info /*int*/ ;
 //BA.debugLineNum = 382;BA.debugLine="Dim icontext As String";
_icontext = "";
 //BA.debugLineNum = 384;BA.debugLine="Select level";
switch (BA.switchObjectToInt(_level,_hmitileutils._event_level_info /*int*/ ,_hmitileutils._event_level_warning /*int*/ ,_hmitileutils._event_level_alarm /*int*/ )) {
case 0: {
 //BA.debugLineNum = 386;BA.debugLine="iconColor = HMITileUtils.EVENT_COLOR_TEXT";
_iconcolor = _hmitileutils._event_color_text /*int*/ ;
 //BA.debugLineNum = 387;BA.debugLine="icontext = HMITileUtils.EVENT_ICON_INFO";
_icontext = _hmitileutils._event_icon_info /*String*/ ;
 break; }
case 1: {
 //BA.debugLineNum = 390;BA.debugLine="iconColor = HMITileUtils.EVENT_COLOR_ICON_WARNI";
_iconcolor = _hmitileutils._event_color_icon_warning /*int*/ ;
 //BA.debugLineNum = 391;BA.debugLine="icontext = HMITileUtils.EVENT_ICON_WARNING";
_icontext = _hmitileutils._event_icon_warning /*String*/ ;
 break; }
case 2: {
 //BA.debugLineNum = 394;BA.debugLine="iconColor = HMITileUtils.EVENT_COLOR_ICON_ALARM";
_iconcolor = _hmitileutils._event_color_icon_alarm /*int*/ ;
 //BA.debugLineNum = 395;BA.debugLine="icontext = HMITileUtils.EVENT_ICON_ALARM";
_icontext = _hmitileutils._event_icon_alarm /*String*/ ;
 break; }
}
;
 //BA.debugLineNum = 397;BA.debugLine="pnl.Color = bgColor";
_pnl.setColor(_bgcolor);
 //BA.debugLineNum = 399;BA.debugLine="Dim l, t, w, h As Double";
_l = 0;
_t = 0;
_w = 0;
_h = 0;
 //BA.debugLineNum = 400;BA.debugLine="Dim lblicon As B4XView = XUIViewsUtils.CreateLabe";
_lblicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblicon = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 401;BA.debugLine="Dim lblicontextsize As Float = IIf(mCompactMode,";
_lblicontextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_icon_text_size /*float*/ )) : ((Object)(_hmitileutils._event_normal_icon_text_size /*float*/ )))));
 //BA.debugLineNum = 402;BA.debugLine="lblicon.Font = xui.CreateFontAwesome(lblicontexts";
_lblicon.setFont(_xui.CreateFontAwesome(_lblicontextsize));
 //BA.debugLineNum = 403;BA.debugLine="lblicon.Text = icontext";
_lblicon.setText(_icontext);
 //BA.debugLineNum = 404;BA.debugLine="lblicon.SetTextAlignment(\"CENTER\", \"LEFT\")";
_lblicon.SetTextAlignment("CENTER","LEFT");
 //BA.debugLineNum = 405;BA.debugLine="lblicon.TextColor = iconColor";
_lblicon.setTextColor(_iconcolor);
 //BA.debugLineNum = 406;BA.debugLine="l = rowpadding";
_l = _rowpadding;
 //BA.debugLineNum = 407;BA.debugLine="t = 0";
_t = 0;
 //BA.debugLineNum = 408;BA.debugLine="w = lblicontextsize + (rowpadding * 2)";
_w = _lblicontextsize+(_rowpadding*2);
 //BA.debugLineNum = 409;BA.debugLine="h = pnl.Height";
_h = _pnl.getHeight();
 //BA.debugLineNum = 410;BA.debugLine="pnl.AddView(lblicon, l, t, w, h)";
_pnl.AddView((javafx.scene.Node)(_lblicon.getObject()),_l,_t,_w,_h);
 //BA.debugLineNum = 412;BA.debugLine="Dim lblitem As B4XView = XUIViewsUtils.CreateLabe";
_lblitem = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblitem = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 413;BA.debugLine="Dim lblitemtextsize As Float = IIf(mCompactMode,";
_lblitemtextsize = (float)(BA.ObjectToNumber(((_mcompactmode) ? ((Object)(_hmitileutils._event_compact_message_text_size /*float*/ )) : ((Object)(_hmitileutils._event_normal_message_text_size /*float*/ )))));
 //BA.debugLineNum = 415;BA.debugLine="lblitem.Font = xui.CreateDefaultFont(lblitemtexts";
_lblitem.setFont(_xui.CreateDefaultFont(_lblitemtextsize));
 //BA.debugLineNum = 417;BA.debugLine="lblitem.Text = item";
_lblitem.setText(_item);
 //BA.debugLineNum = 418;BA.debugLine="lblitem.SetTextAlignment(\"CENTER\", \"LEFT\")";
_lblitem.SetTextAlignment("CENTER","LEFT");
 //BA.debugLineNum = 419;BA.debugLine="lblitem.TextColor = txtColor";
_lblitem.setTextColor(_txtcolor);
 //BA.debugLineNum = 425;BA.debugLine="l = lblicontextsize + (rowpadding * 2)";
_l = _lblicontextsize+(_rowpadding*2);
 //BA.debugLineNum = 427;BA.debugLine="t = 0";
_t = 0;
 //BA.debugLineNum = 428;BA.debugLine="w = pnl.Width - l";
_w = _pnl.getWidth()-_l;
 //BA.debugLineNum = 429;BA.debugLine="h = pnl.Height";
_h = _pnl.getHeight();
 //BA.debugLineNum = 430;BA.debugLine="pnl.AddView(lblitem, l, t, w, h)";
_pnl.AddView((javafx.scene.Node)(_lblitem.getObject()),_l,_t,_w,_h);
 //BA.debugLineNum = 432;BA.debugLine="Return pnl";
if (true) return (anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.PaneWrapper.ConcretePaneWrapper(), (javafx.scene.layout.Pane)(_pnl.getObject()));
 //BA.debugLineNum = 433;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 79;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 80;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 81;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 82;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 84;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _formattimestamp(long _ts) throws Exception{
 //BA.debugLineNum = 438;BA.debugLine="Private Sub FormatTimestamp(ts As Long) As String";
 //BA.debugLineNum = 439;BA.debugLine="Return DateTime.Time(ts)";
if (true) return __c.DateTime.Time(_ts);
 //BA.debugLineNum = 440;BA.debugLine="End Sub";
return "";
}
public boolean  _getcompactmode() throws Exception{
 //BA.debugLineNum = 195;BA.debugLine="Public Sub getCompactMode As Boolean";
 //BA.debugLineNum = 196;BA.debugLine="Return mCompactMode";
if (true) return _mcompactmode;
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return false;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 167;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.collections.List  _getevents() throws Exception{
 //BA.debugLineNum = 348;BA.debugLine="Public Sub GetEvents As List";
 //BA.debugLineNum = 349;BA.debugLine="Return Events";
if (true) return _events;
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return null;
}
public boolean  _getlogging() throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Public Sub getLogging As Boolean";
 //BA.debugLineNum = 203;BA.debugLine="Return mLogging";
if (true) return _mlogging;
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return false;
}
public int  _getmaxitems() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Public Sub getMaxItems As Int";
 //BA.debugLineNum = 182;BA.debugLine="Return mMaxEvents";
if (true) return _mmaxevents;
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return 0;
}
public double  _getrowheight() throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Public Sub getRowHeight As Double";
 //BA.debugLineNum = 210;BA.debugLine="Return mRowHeight";
if (true) return _mrowheight;
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowtrash() throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Public Sub getShowTrash As Boolean";
 //BA.debugLineNum = 189;BA.debugLine="Return LabelTrash.Visible";
if (true) return _labeltrash.getVisible();
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return false;
}
public boolean  _gettimestamp() throws Exception{
 //BA.debugLineNum = 216;BA.debugLine="Public Sub getTimeStamp As Boolean";
 //BA.debugLineNum = 217;BA.debugLine="Return mTimeStamp";
if (true) return _mtimestamp;
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return false;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 158;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 159;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 72;BA.debugLine="Private Sub Initialize (Callback As Object, EventN";
 //BA.debugLineNum = 73;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 74;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 75;BA.debugLine="Events.Initialize";
_events.Initialize();
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public String  _insert(String _event,int _level) throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 257;BA.debugLine="Public Sub Insert(event As String, level As Int)";
 //BA.debugLineNum = 258;BA.debugLine="If Not(ClvEvents.IsInitialized) Then Return";
if (__c.Not(_clvevents.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 260;BA.debugLine="Dim m As Map = CreateMap(\"timestamp\":FormatTimest";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = __c.createMap(new Object[] {(Object)("timestamp"),(Object)(_formattimestamp(__c.DateTime.getNow())),(Object)("level"),(Object)(_level),(Object)("event"),(Object)(_event)});
 //BA.debugLineNum = 261;BA.debugLine="Events.InsertAt(0, m)";
_events.InsertAt((int) (0),(Object)(_m.getObject()));
 //BA.debugLineNum = 262;BA.debugLine="If mTimeStamp Then";
if (_mtimestamp) { 
 //BA.debugLineNum = 263;BA.debugLine="event = $\"${FormatTimestamp(DateTime.Now)} - ${e";
_event = (""+__c.SmartStringFormatter("",(Object)(_formattimestamp(__c.DateTime.getNow())))+" - "+__c.SmartStringFormatter("",(Object)(_event))+"");
 };
 //BA.debugLineNum = 265;BA.debugLine="ClvEvents.InsertAt(0, ClvEventsCreateItem(event,";
_clvevents._insertat((int) (0),(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_clveventscreateitem(_event,_level).getObject())),(Object)(_m.getObject()));
 //BA.debugLineNum = 267;BA.debugLine="If mLogging Then";
if (_mlogging) { 
 //BA.debugLineNum = 268;BA.debugLine="Log($\"timestamp=${m.get(\"timestamp\")} level=${m.";
__c.LogImpl("944498955",("timestamp="+__c.SmartStringFormatter("",_m.Get((Object)("timestamp")))+" level="+__c.SmartStringFormatter("",_m.Get((Object)("level")))+" event="+__c.SmartStringFormatter("",_m.Get((Object)("event")))+""),0);
 };
 //BA.debugLineNum = 271;BA.debugLine="If ClvEvents.Size > mMaxEvents Then";
if (_clvevents._getsize()>_mmaxevents) { 
 //BA.debugLineNum = 272;BA.debugLine="ClvEvents.RemoveAt(ClvEvents.Size - 1)";
_clvevents._removeat((int) (_clvevents._getsize()-1));
 //BA.debugLineNum = 273;BA.debugLine="Events.RemoveAt(ClvEvents.Size - 1)";
_events.RemoveAt((int) (_clvevents._getsize()-1));
 };
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public String  _labeltrash_click() throws Exception{
 //BA.debugLineNum = 484;BA.debugLine="Private Sub LabelTrash_Click";
 //BA.debugLineNum = 485;BA.debugLine="Clear";
_clear();
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return "";
}
public String  _labeltrash_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 473;BA.debugLine="Private Sub LabelTrash_MouseClicked (EventData As";
 //BA.debugLineNum = 474;BA.debugLine="LabelTrash_Click";
_labeltrash_click();
 //BA.debugLineNum = 475;BA.debugLine="End Sub";
return "";
}
public String  _setcompactmode(boolean _state) throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Public Sub setCompactMode(state As Boolean)";
 //BA.debugLineNum = 193;BA.debugLine="mCompactMode = state";
_mcompactmode = _state;
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 163;BA.debugLine="BasePane.Enabled = enabled";
_basepane.setEnabled(_enabled);
 //BA.debugLineNum = 164;BA.debugLine="HMITileUtils.SetAlpha(BasePane.enabled)";
_hmitileutils._setalpha /*float*/ (_basepane.getEnabled());
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public String  _setlogging(boolean _enabled) throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Public Sub setLogging(enabled As Boolean)";
 //BA.debugLineNum = 200;BA.debugLine="mLogging = enabled";
_mlogging = _enabled;
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public String  _setmaxitems(int _value) throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Public Sub setMaxItems(value As Int)";
 //BA.debugLineNum = 175;BA.debugLine="mMaxEvents = value";
_mmaxevents = _value;
 //BA.debugLineNum = 177;BA.debugLine="Do While ClvEvents.Size > mMaxEvents";
while (_clvevents._getsize()>_mmaxevents) {
 //BA.debugLineNum = 178;BA.debugLine="ClvEvents.RemoveAt(ClvEvents.Size - 1) ' safely";
_clvevents._removeat((int) (_clvevents._getsize()-1));
 }
;
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public String  _setrowheight(double _value) throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Public Sub setRowHeight(value As Double)";
 //BA.debugLineNum = 207;BA.debugLine="mRowHeight = value";
_mrowheight = _value;
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public String  _setshowtrash(boolean _state) throws Exception{
 //BA.debugLineNum = 185;BA.debugLine="Public Sub setShowTrash(state As Boolean)";
 //BA.debugLineNum = 186;BA.debugLine="LabelTrash.Visible = state";
_labeltrash.setVisible(_state);
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public String  _settimestamp(boolean _enabled) throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Public Sub setTimeStamp(enabled As Boolean)";
 //BA.debugLineNum = 214;BA.debugLine="mTimeStamp = enabled";
_mtimestamp = _enabled;
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 156;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.Map  _statussummary() throws Exception{
anywheresoftware.b4a.objects.collections.Map _result = null;
int _normalcount = 0;
int _warningcount = 0;
int _alarmcount = 0;
anywheresoftware.b4a.objects.collections.Map _event = null;
int _level = 0;
 //BA.debugLineNum = 319;BA.debugLine="Public Sub StatusSummary As Map";
 //BA.debugLineNum = 320;BA.debugLine="Dim result As Map";
_result = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 321;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 322;BA.debugLine="Dim normalcount As Int = 0";
_normalcount = (int) (0);
 //BA.debugLineNum = 323;BA.debugLine="Dim warningcount As Int = 0";
_warningcount = (int) (0);
 //BA.debugLineNum = 324;BA.debugLine="Dim alarmcount As Int = 0";
_alarmcount = (int) (0);
 //BA.debugLineNum = 326;BA.debugLine="For Each event As Map In Events";
_event = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group6 = _events;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_event = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group6.Get(index6)));
 //BA.debugLineNum = 327;BA.debugLine="Dim level As Int = event.Get(\"level\")";
_level = (int)(BA.ObjectToNumber(_event.Get((Object)("level"))));
 //BA.debugLineNum = 328;BA.debugLine="Select level";
switch (BA.switchObjectToInt(_level,_hmitileutils._event_level_info /*int*/ ,_hmitileutils._event_level_warning /*int*/ ,_hmitileutils._event_level_alarm /*int*/ )) {
case 0: {
 //BA.debugLineNum = 330;BA.debugLine="normalcount = normalcount + 1";
_normalcount = (int) (_normalcount+1);
 break; }
case 1: {
 //BA.debugLineNum = 332;BA.debugLine="warningcount = warningcount + 1";
_warningcount = (int) (_warningcount+1);
 break; }
case 2: {
 //BA.debugLineNum = 334;BA.debugLine="alarmcount = alarmcount + 1";
_alarmcount = (int) (_alarmcount+1);
 break; }
}
;
 }
};
 //BA.debugLineNum = 337;BA.debugLine="result = CreateMap( \"normal\": normalcount, _";
_result = __c.createMap(new Object[] {(Object)("normal"),(Object)(_normalcount),(Object)("warning"),(Object)(_warningcount),(Object)("alarm"),(Object)(_alarmcount)});
 //BA.debugLineNum = 340;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
