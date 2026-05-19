package b4j.example;


import anywheresoftware.b4a.BA;

public class hmitileutils extends Object{
public static hmitileutils mostCurrent = new hmitileutils();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitileutils", null);
		ba.loadHtSubs(hmitileutils.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.hmitileutils", ba);
		}
	}
    public static Class<?> getObject() {
		return hmitileutils.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static b4j.example.hmitilegridhelper _hmitilegrid = null;
public static int _tile_default_size = 0;
public static int _tile_padding = 0;
public static float _tile_title_height_factor = 0f;
public static float _tile_value_height_factor = 0f;
public static double _border_width = 0;
public static double _border_radius = 0;
public static double _border_radius_large = 0;
public static int _color_background_default = 0;
public static int _color_background_panel = 0;
public static int _color_background_screen = 0;
public static int _color_border_default = 0;
public static int _color_border_dark = 0;
public static int _color_background_hover = 0;
public static int _color_background_dark = 0;
public static int _color_background_selected = 0;
public static int _color_status_off_background = 0;
public static int _color_status_on_background = 0;
public static int _color_status_on_border = 0;
public static int _color_status_off_border = 0;
public static int _color_status_text = 0;
public static int _color_text_muted = 0;
public static int _color_status_warning = 0;
public static int _color_status_alarm_lo = 0;
public static int _color_status_alarm = 0;
public static int _color_status_alarm_hi = 0;
public static int _color_status_forbidden = 0;
public static int _color_text_primary = 0;
public static int _color_text_secondary = 0;
public static int _color_text_disabled = 0;
public static int _color_text_warning = 0;
public static int _color_text_alarm = 0;
public static int _color_text_error = 0;
public static int _color_text_info = 0;
public static int _color_indicator_track = 0;
public static int _color_indicator_level = 0;
public static String _status_normal = "";
public static String _status_warning = "";
public static String _status_alarm = "";
public static String _status_disabled = "";
public static int _color_tile_normal_background = 0;
public static int _color_tile_normal_text = 0;
public static int _color_tile_warning_background = 0;
public static int _color_tile_warning_text = 0;
public static int _color_tile_alarm_background = 0;
public static int _color_tile_alarm_text = 0;
public static int _color_tile_disabled_background = 0;
public static int _color_tile_disabled_text = 0;
public static int _color_tile_enabled_background = 0;
public static int _color_tile_enabled_text = 0;
public static double _grid_baseline = 0;
public static double _grid_spacing = 0;
public static double _grid_outer_screen_edge = 0;
public static float _text_size_title = 0f;
public static float _text_size_label = 0f;
public static float _text_size_state = 0f;
public static float _text_size_small = 0f;
public static float _text_size_tiny = 0f;
public static float _text_size_icon = 0f;
public static float _text_size_icon_large = 0f;
public static int _event_color_bg_base = 0;
public static int _event_color_bg_selected = 0;
public static int _event_color_bg_hover = 0;
public static int _event_color_bg_disabled = 0;
public static int _event_divider = 0;
public static int _event_color_text = 0;
public static int _event_level_info = 0;
public static int _event_level_warning = 0;
public static int _event_level_alarm = 0;
public static int _event_color_icon_info = 0;
public static int _event_color_icon_warning = 0;
public static int _event_color_icon_alarm = 0;
public static int _event_color_icon_critical = 0;
public static int _event_color_icon_disabled = 0;
public static String _event_icon_info = "";
public static String _event_icon_warning = "";
public static String _event_icon_alarm = "";
public static String _event_icon_disabled = "";
public static float _event_normal_timestamp_text_size = 0f;
public static float _event_normal_message_text_size = 0f;
public static float _event_normal_source_text_size = 0f;
public static float _event_normal_icon_text_size = 0f;
public static int _event_normal_height = 0;
public static int _event_normal_height_large = 0;
public static int _event_normal_padding = 0;
public static float _event_compact_timestamp_text_size = 0f;
public static float _event_compact_message_text_size = 0f;
public static float _event_compact_source_text_size = 0f;
public static float _event_compact_icon_text_size = 0f;
public static int _event_compact_height = 0;
public static int _event_compact_padding = 0;
public static int _event_title_height = 0;
public static int _list_color_bg_base = 0;
public static int _list_color_bg_item = 0;
public static int _list_color_bg_selected = 0;
public static int _list_color_bg_hover = 0;
public static int _list_color_bg_disabled = 0;
public static int _list_divider = 0;
public static int _list_color_text = 0;
public static int _list_color_text_disabled = 0;
public static int _list_title_height = 0;
public static int _list_normal_height = 0;
public static int _list_normal_padding = 0;
public static float _list_normal_primary_text_size = 0f;
public static float _list_normal_secondary_text_size = 0f;
public static int _list_compact_height = 0;
public static int _list_compact_padding = 0;
public static float _list_compact_primary_text_size = 0f;
public static float _list_compact_secondary_text_size = 0f;
public static int _color_slider_track = 0;
public static int _color_slider_active = 0;
public static int _color_slider_knob = 0;
public static int _color_slider_disabled_track = 0;
public static int _color_slider_disabled_knob = 0;
public static int _color_slider_value_text = 0;
public static int _color_slider_label_text = 0;
public static int _color_slider_unit_text = 0;
public static int _color_slider_knob_border = 0;
public static int _color_trend_line = 0;
public static int _color_trend_background = 0;
public static int _color_trend_border = 0;
public static int _color_trend_grid_line = 0;
public static String _nav_select_type_page = "";
public static String _nav_select_type_back = "";
public static String _nav_icon_back = "";
public static int _color_indicator_true_default = 0;
public static int _color_indicator_false_default = 0;
public static int _color_indicator_disabled_default = 0;
public static int _color_indicator_true_green = 0;
public static int _color_indicator_false_red = 0;
public static int _color_text_indicator_true = 0;
public static int _color_text_indicator_false = 0;
public static String _text_indicator_true = "";
public static String _text_indicator_false = "";
public static String _text_indicator_disabled = "";
public static int _color_deviation_bar = 0;
public static int _color_deviation_deadband = 0;
public static int _color_deviation_neutral = 0;
public static int _color_deviation_warning = 0;
public static int _color_deviation_alarm = 0;
public static int _color_gaugesegments_normal_active = 0;
public static int _color_gaugesegments_warning_active = 0;
public static int _color_gaugesegments_alarm_active = 0;
public static int _color_gaugesegments_normal_muted = 0;
public static int _color_gaugesegments_warning_muted = 0;
public static int _color_gaugesegments_alarm_muted = 0;
public static String _icon_on = "";
public static String _icon_off = "";
public static String _icon_refresh = "";
public static String _icon_stop_hand = "";
public static String _icon_stop = "";
public static String _icon_stop_circle = "";
public static String _icon_wait = "";
public static double _shape_indicator_size = 0;
public static String _shape_warning_indicator = "";
public static String _shape_alarm_indicator = "";
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _byteconv = null;
public static b4j.example.dateutils _dateutils = null;
public static b4j.example.cssutils _cssutils = null;
public static b4j.example.main _main = null;
public static b4j.example.b4xpages _b4xpages = null;
public static b4j.example.b4xcollections _b4xcollections = null;
public static b4j.example.xuiviewsutils _xuiviewsutils = null;
public static b4j.example.hmitilesymbols _hmitilesymbols = null;
public static String  _applyactionstyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 505;BA.debugLine="Public Sub ApplyActionStyle(lbl As B4XView)";
 //BA.debugLineNum = 506;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 508;BA.debugLine="lbl.TextSize = TEXT_SIZE_SMALL";
_lbl.setTextSize(_text_size_small);
 //BA.debugLineNum = 509;BA.debugLine="SetStyleBold(lbl, True)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 514;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 516;BA.debugLine="End Sub";
return "";
}
public static String  _applyfontawesomestyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 546;BA.debugLine="Public Sub ApplyFontAwesomeStyle(lbl As B4XView)";
 //BA.debugLineNum = 547;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 549;BA.debugLine="lbl.TextSize = TEXT_SIZE_STATE  ' TEXT_SIZE_ICON";
_lbl.setTextSize(_text_size_state);
 //BA.debugLineNum = 550;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
return "";
}
public static String  _applyiconstyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 533;BA.debugLine="Public Sub ApplyIconStyle(lbl As B4XView)";
 //BA.debugLineNum = 534;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 536;BA.debugLine="lbl.TextSize = TEXT_SIZE_ICON";
_lbl.setTextSize(_text_size_icon);
 //BA.debugLineNum = 537;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 544;BA.debugLine="End Sub";
return "";
}
public static String  _applylabelstyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 477;BA.debugLine="Public Sub ApplyLabelStyle(lbl As B4XView)";
 //BA.debugLineNum = 478;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 480;BA.debugLine="lbl.TextSize = TEXT_SIZE_LABEL";
_lbl.setTextSize(_text_size_label);
 //BA.debugLineNum = 481;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 482;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 489;BA.debugLine="End Sub";
return "";
}
public static String  _applystatusstyle(anywheresoftware.b4a.objects.B4XViewWrapper _vw,String _text,String _status) throws Exception{
 //BA.debugLineNum = 418;BA.debugLine="Public Sub ApplyStatusStyle(vw As B4XView, text As";
 //BA.debugLineNum = 419;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_status_normal,_status_warning,_status_alarm)) {
case 0: {
 //BA.debugLineNum = 421;BA.debugLine="vw.Color = COLOR_TILE_NORMAL_BACKGROUND";
_vw.setColor(_color_tile_normal_background);
 //BA.debugLineNum = 422;BA.debugLine="vw.TextColor = COLOR_TILE_NORMAL_TEXT";
_vw.setTextColor(_color_tile_normal_text);
 //BA.debugLineNum = 423;BA.debugLine="vw.Text = text";
_vw.setText(_text);
 break; }
case 1: {
 //BA.debugLineNum = 425;BA.debugLine="vw.Color = COLOR_TILE_WARNING_BACKGROUND";
_vw.setColor(_color_tile_warning_background);
 //BA.debugLineNum = 426;BA.debugLine="vw.TextColor = COLOR_TILE_WARNING_TEXT";
_vw.setTextColor(_color_tile_warning_text);
 //BA.debugLineNum = 427;BA.debugLine="vw.Text = $\"${SHAPE_WARNING_INDICATOR} ${text}\"";
_vw.setText((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_shape_warning_indicator))+" "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_text))+""));
 break; }
case 2: {
 //BA.debugLineNum = 429;BA.debugLine="vw.Color = COLOR_TILE_ALARM_BACKGROUND";
_vw.setColor(_color_tile_alarm_background);
 //BA.debugLineNum = 430;BA.debugLine="vw.TextColor = COLOR_TILE_ALARM_TEXT";
_vw.setTextColor(_color_tile_alarm_text);
 //BA.debugLineNum = 431;BA.debugLine="vw.Text = $\"${SHAPE_ALARM_INDICATOR} ${text}\"$";
_vw.setText((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_shape_alarm_indicator))+" "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_text))+""));
 break; }
default: {
 //BA.debugLineNum = 433;BA.debugLine="vw.Color = COLOR_TILE_NORMAL_BACKGROUND";
_vw.setColor(_color_tile_normal_background);
 //BA.debugLineNum = 434;BA.debugLine="vw.TextColor = COLOR_TEXT_PRIMARY";
_vw.setTextColor(_color_text_primary);
 //BA.debugLineNum = 435;BA.debugLine="vw.Text = text";
_vw.setText(_text);
 break; }
}
;
 //BA.debugLineNum = 437;BA.debugLine="End Sub";
return "";
}
public static String  _applysubinfostyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 518;BA.debugLine="Public Sub ApplySubInfoStyle(lbl As B4XView)";
 //BA.debugLineNum = 519;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 521;BA.debugLine="CSSUtils.SetStyleProperty(lbl, \"-fx-font-size\",";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),"-fx-font-size",BA.NumberToString(_text_size_tiny));
 //BA.debugLineNum = 523;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 524;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 531;BA.debugLine="End Sub";
return "";
}
public static String  _applytilestyle(anywheresoftware.b4a.objects.B4XViewWrapper _basepane) throws Exception{
 //BA.debugLineNum = 403;BA.debugLine="Public Sub ApplyTileStyle(basepane As B4XView)";
 //BA.debugLineNum = 404;BA.debugLine="basepane.SetColorAndBorder( _ 		COLOR_TILE_NORMAL";
_basepane.SetColorAndBorder(_color_tile_normal_background,0,(int) (0),_border_radius);
 //BA.debugLineNum = 409;BA.debugLine="End Sub";
return "";
}
public static String  _applytitlestyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 439;BA.debugLine="Public Sub ApplyTitleStyle(lbl As B4XView)";
 //BA.debugLineNum = 440;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 442;BA.debugLine="lbl.TextSize = TEXT_SIZE_TITLE";
_lbl.setTextSize(_text_size_title);
 //BA.debugLineNum = 443;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 //BA.debugLineNum = 444;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 451;BA.debugLine="End Sub";
return "";
}
public static String  _applyunitstyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 491;BA.debugLine="Public Sub ApplyUnitStyle(lbl As B4XView)";
 //BA.debugLineNum = 492;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 494;BA.debugLine="lbl.TextSize = TEXT_SIZE_SMALL";
_lbl.setTextSize(_text_size_small);
 //BA.debugLineNum = 495;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 496;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 503;BA.debugLine="End Sub";
return "";
}
public static String  _applyvaluestyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 453;BA.debugLine="Public Sub ApplyValueStyle(lbl As B4XView)";
 //BA.debugLineNum = 454;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 456;BA.debugLine="lbl.TextSize = TEXT_SIZE_STATE";
_lbl.setTextSize(_text_size_state);
 //BA.debugLineNum = 457;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 //BA.debugLineNum = 458;BA.debugLine="SetStyleBold(lbl, True)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public static String  _applyvaluestyleonoff(anywheresoftware.b4a.objects.B4XViewWrapper _hmitilepane,anywheresoftware.b4a.objects.B4XViewWrapper _statuslabel,boolean _status) throws Exception{
 //BA.debugLineNum = 467;BA.debugLine="Public Sub ApplyValueStyleOnOff(HMITilepane As B4X";
 //BA.debugLineNum = 468;BA.debugLine="If status Then";
if (_status) { 
 //BA.debugLineNum = 469;BA.debugLine="statuslabel.TextColor = COLOR_TEXT_PRIMARY";
_statuslabel.setTextColor(_color_text_primary);
 //BA.debugLineNum = 470;BA.debugLine="HMITilepane.SetColorAndBorder(COLOR_STATUS_ON_BA";
_hmitilepane.SetColorAndBorder(_color_status_on_background,0,(int) (0),_border_radius);
 }else {
 //BA.debugLineNum = 472;BA.debugLine="statuslabel.TextColor = COLOR_TEXT_SECONDARY";
_statuslabel.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 473;BA.debugLine="HMITilepane.SetColorAndBorder(COLOR_STATUS_OFF_B";
_hmitilepane.SetColorAndBorder(_color_status_off_background,0,(int) (0),_border_radius);
 };
 //BA.debugLineNum = 475;BA.debugLine="End Sub";
return "";
}
public static int  _bytetounsigned(byte _b) throws Exception{
 //BA.debugLineNum = 935;BA.debugLine="Public Sub ByteToUnsigned(b As Byte) As Int";
 //BA.debugLineNum = 936;BA.debugLine="Return Bit.And(0xFF, b)";
if (true) return anywheresoftware.b4a.keywords.Common.Bit.And(((int)0xff),(int) (_b));
 //BA.debugLineNum = 937;BA.debugLine="End Sub";
return 0;
}
public static void  _changebuttontextanimated(anywheresoftware.b4a.objects.B4XViewWrapper _target,String _newtext) throws Exception{
ResumableSub_ChangeButtonTextAnimated rsub = new ResumableSub_ChangeButtonTextAnimated(null,_target,_newtext);
rsub.resume(ba, null);
}
public static class ResumableSub_ChangeButtonTextAnimated extends BA.ResumableSub {
public ResumableSub_ChangeButtonTextAnimated(b4j.example.hmitileutils parent,anywheresoftware.b4a.objects.B4XViewWrapper _target,String _newtext) {
this.parent = parent;
this._target = _target;
this._newtext = _newtext;
}
b4j.example.hmitileutils parent;
anywheresoftware.b4a.objects.B4XViewWrapper _target;
String _newtext;
int _duration = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 919;BA.debugLine="Dim duration As Int = 240";
_duration = (int) (240);
 //BA.debugLineNum = 921;BA.debugLine="target.SetAlphaAnimated(duration, 0) ' duration i";
_target.SetAlphaAnimated(_duration,(float) (0));
 //BA.debugLineNum = 922;BA.debugLine="Sleep(120)";
anywheresoftware.b4a.keywords.Common.Sleep(ba,this,(int) (120));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 924;BA.debugLine="target.Text = newText";
_target.setText(_newtext);
 //BA.debugLineNum = 926;BA.debugLine="target.SetAlphaAnimated(duration, 1) ' alpha 1 =";
_target.SetAlphaAnimated(_duration,(float) (1));
 //BA.debugLineNum = 927;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _colortohexargb(int _clr) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 873;BA.debugLine="Public Sub ColorToHexARGB(clr As Int) As String";
 //BA.debugLineNum = 874;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 875;BA.debugLine="Return bc.HexFromBytes(bc.IntsToBytes(Array As In";
if (true) return _bc.HexFromBytes(_bc.IntsToBytes(new int[]{_clr}));
 //BA.debugLineNum = 876;BA.debugLine="End Sub";
return "";
}
public static String  _colortohexrgb(int _clr) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
String _hex = "";
 //BA.debugLineNum = 878;BA.debugLine="Public Sub ColorToHexRGB(clr As Int) As String";
 //BA.debugLineNum = 879;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 880;BA.debugLine="Dim hex As String = bc.HexFromBytes(bc.IntsToByte";
_hex = _bc.HexFromBytes(_bc.IntsToBytes(new int[]{_clr}));
 //BA.debugLineNum = 881;BA.debugLine="Return hex.SubString2(2, hex.Length)";
if (true) return _hex.substring((int) (2),_hex.length());
 //BA.debugLineNum = 882;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4j.objects.JFX.PaintWrapper  _colortopaint(int _value) throws Exception{
 //BA.debugLineNum = 885;BA.debugLine="Public Sub ColorToPaint(value As Int) As Paint";
 //BA.debugLineNum = 886;BA.debugLine="Return fx.Colors.From32Bit(xui.Color_White)";
if (true) return (anywheresoftware.b4j.objects.JFX.PaintWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.JFX.PaintWrapper(), (javafx.scene.paint.Paint)(_fx.Colors.From32Bit(_xui.Color_White)));
 //BA.debugLineNum = 887;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.B4XViewWrapper  _copylabelprops(anywheresoftware.b4a.objects.B4XViewWrapper _src,anywheresoftware.b4a.objects.B4XViewWrapper _dest) throws Exception{
 //BA.debugLineNum = 908;BA.debugLine="Public Sub CopyLabelProps(src As B4XView, dest As";
 //BA.debugLineNum = 909;BA.debugLine="dest.Text = src.Text";
_dest.setText(_src.getText());
 //BA.debugLineNum = 910;BA.debugLine="dest.Font = src.Font";
_dest.setFont(_src.getFont());
 //BA.debugLineNum = 911;BA.debugLine="dest.Color = src.Color";
_dest.setColor(_src.getColor());
 //BA.debugLineNum = 912;BA.debugLine="dest.TextColor = src.TextColor";
_dest.setTextColor(_src.getTextColor());
 //BA.debugLineNum = 913;BA.debugLine="dest.TextSize = src.TextSize";
_dest.setTextSize(_src.getTextSize());
 //BA.debugLineNum = 914;BA.debugLine="Return dest";
if (true) return _dest;
 //BA.debugLineNum = 915;BA.debugLine="End Sub";
return null;
}
public static String  _disablehmitilegrid() throws Exception{
 //BA.debugLineNum = 704;BA.debugLine="Public Sub DisableHMITileGrid";
 //BA.debugLineNum = 705;BA.debugLine="If Not(HMITileGrid.IsInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_hmitilegrid.IsInitialized /*boolean*/ ())) { 
 //BA.debugLineNum = 706;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 708;BA.debugLine="HMITileGrid.ShowGrid = False";
_hmitilegrid._showgrid /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 709;BA.debugLine="HMITileGrid.Redraw";
_hmitilegrid._redraw /*String*/ ();
 //BA.debugLineNum = 710;BA.debugLine="End Sub";
return "";
}
public static String  _enablehmitilegrid(anywheresoftware.b4a.objects.B4XViewWrapper _parent) throws Exception{
 //BA.debugLineNum = 695;BA.debugLine="Public Sub EnableHMITileGrid(parent As B4XView)";
 //BA.debugLineNum = 696;BA.debugLine="If Not(HMITileGrid.IsInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_hmitilegrid.IsInitialized /*boolean*/ ())) { 
 //BA.debugLineNum = 697;BA.debugLine="HMITileGrid.Initialize(parent)";
_hmitilegrid._initialize /*String*/ (ba,_parent);
 };
 //BA.debugLineNum = 699;BA.debugLine="HMITileGrid.Resize";
_hmitilegrid._resize /*String*/ ();
 //BA.debugLineNum = 700;BA.debugLine="HMITileGrid.ShowGrid = True";
_hmitilegrid._showgrid /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 701;BA.debugLine="HMITileGrid.Redraw";
_hmitilegrid._redraw /*String*/ ();
 //BA.debugLineNum = 702;BA.debugLine="End Sub";
return "";
}
public static boolean  _getstylebold(anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper _node) throws Exception{
String _property = "";
 //BA.debugLineNum = 570;BA.debugLine="Public Sub GetStyleBold(node As Node) As Boolean";
 //BA.debugLineNum = 571;BA.debugLine="Dim property As String = CSSUtils.GetStylePropert";
_property = _cssutils._getstyleproperty(_node,"-fx-font-weight");
 //BA.debugLineNum = 572;BA.debugLine="Return property == \"bold\"";
if (true) return (_property).equals("bold");
 //BA.debugLineNum = 573;BA.debugLine="End Sub";
return false;
}
public static double  _getstyleborderradius(anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper _node) throws Exception{
String _s = "";
 //BA.debugLineNum = 577;BA.debugLine="Public Sub GetStyleBorderRadius(node As Node) As D";
 //BA.debugLineNum = 578;BA.debugLine="Dim s As String = CSSUtils.GetStyleProperty(node,";
_s = _cssutils._getstyleproperty(_node,"-fx-border-radius");
 //BA.debugLineNum = 579;BA.debugLine="If s.Length == 0 Then";
if (_s.length()==0) { 
 //BA.debugLineNum = 580;BA.debugLine="Return BORDER_RADIUS";
if (true) return _border_radius;
 }else {
 //BA.debugLineNum = 582;BA.debugLine="Return s";
if (true) return (double)(Double.parseDouble(_s));
 };
 //BA.debugLineNum = 584;BA.debugLine="End Sub";
return 0;
}
public static int  _hextocolor(String _hex) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
byte[] _b = null;
int[] _ints = null;
 //BA.debugLineNum = 860;BA.debugLine="Public Sub HexToColor(hex As String) As Int	'ignor";
 //BA.debugLineNum = 861;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 862;BA.debugLine="If hex.StartsWith(\"#\") Then";
if (_hex.startsWith("#")) { 
 //BA.debugLineNum = 863;BA.debugLine="hex = hex.SubString(1)";
_hex = _hex.substring((int) (1));
 }else if(_hex.startsWith("0x")) { 
 //BA.debugLineNum = 865;BA.debugLine="hex = hex.SubString(2)";
_hex = _hex.substring((int) (2));
 };
 //BA.debugLineNum = 867;BA.debugLine="If hex.Length == 6 Then hex = $\"FF${hex}\"$";
if (_hex.length()==6) { 
_hex = ("FF"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_hex))+"");};
 //BA.debugLineNum = 868;BA.debugLine="Dim b() As Byte = bc.HexToBytes(hex)";
_b = _bc.HexToBytes(_hex);
 //BA.debugLineNum = 869;BA.debugLine="Dim ints() As Int = bc.IntsFromBytes(b)";
_ints = _bc.IntsFromBytes(_b);
 //BA.debugLineNum = 870;BA.debugLine="Return ints(0)";
if (true) return _ints[(int) (0)];
 //BA.debugLineNum = 871;BA.debugLine="End Sub";
return 0;
}
public static int  _maprange(int _value,int _fromlow,int _fromhigh,int _tolow,int _tohigh) throws Exception{
 //BA.debugLineNum = 941;BA.debugLine="Public Sub MapRange(Value As Int, FromLow As Int,";
 //BA.debugLineNum = 942;BA.debugLine="Return ToLow + (ToHigh - ToLow) * ((Value - FromL";
if (true) return (int) (_tolow+(_tohigh-_tolow)*((_value-_fromlow)/(double)(_fromhigh-_fromlow)));
 //BA.debugLineNum = 943;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 52;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 54;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 59;BA.debugLine="Private HMITileGrid As HMITileGridHelper";
_hmitilegrid = new b4j.example.hmitilegridhelper();
 //BA.debugLineNum = 65;BA.debugLine="Public Const TILE_DEFAULT_SIZE 				As Int = 120";
_tile_default_size = (int) (120);
 //BA.debugLineNum = 67;BA.debugLine="Public Const TILE_PADDING 					As Int = 0";
_tile_padding = (int) (0);
 //BA.debugLineNum = 68;BA.debugLine="Public Const TILE_TITLE_HEIGHT_FACTOR 		As Float";
_tile_title_height_factor = (float) (0.25);
 //BA.debugLineNum = 69;BA.debugLine="Public Const TILE_VALUE_HEIGHT_FACTOR 		As Float";
_tile_value_height_factor = (float) (0.60);
 //BA.debugLineNum = 71;BA.debugLine="Public Const BORDER_WIDTH              		As Doubl";
_border_width = 1;
 //BA.debugLineNum = 72;BA.debugLine="Public Const BORDER_RADIUS             		As Doubl";
_border_radius = 1;
 //BA.debugLineNum = 73;BA.debugLine="Public Const BORDER_RADIUS_LARGE            As Do";
_border_radius_large = 12;
 //BA.debugLineNum = 79;BA.debugLine="Public Const COLOR_BACKGROUND_DEFAULT       As In";
_color_background_default = ((int)0xff4a5560);
 //BA.debugLineNum = 80;BA.debugLine="Public Const COLOR_BACKGROUND_PANEL         As In";
_color_background_panel = ((int)0xffcccccc);
 //BA.debugLineNum = 81;BA.debugLine="Public Const COLOR_BACKGROUND_SCREEN        As In";
_color_background_screen = ((int)0xffe6e6e6);
 //BA.debugLineNum = 82;BA.debugLine="Public Const COLOR_BORDER_DEFAULT           As In";
_color_border_default = ((int)0xffc0c0c0);
 //BA.debugLineNum = 83;BA.debugLine="Public Const COLOR_BORDER_DARK              As In";
_color_border_dark = ((int)0xff707070);
 //BA.debugLineNum = 84;BA.debugLine="Public Const COLOR_BACKGROUND_HOVER         As In";
_color_background_hover = ((int)0xffbbbbbb);
 //BA.debugLineNum = 85;BA.debugLine="Public Const COLOR_BACKGROUND_DARK          As In";
_color_background_dark = ((int)0xff202020);
 //BA.debugLineNum = 86;BA.debugLine="Public Const COLOR_BACKGROUND_SELECTED      As In";
_color_background_selected = ((int)0xffc8c8c8);
 //BA.debugLineNum = 92;BA.debugLine="Public Const COLOR_STATUS_OFF_BACKGROUND    As In";
_color_status_off_background = _color_background_default;
 //BA.debugLineNum = 93;BA.debugLine="Public Const COLOR_STATUS_ON_BACKGROUND     As In";
_color_status_on_background = ((int)0xff343d46);
 //BA.debugLineNum = 94;BA.debugLine="Public Const COLOR_STATUS_ON_BORDER         As In";
_color_status_on_border = ((int)0xff202020);
 //BA.debugLineNum = 95;BA.debugLine="Public Const COLOR_STATUS_OFF_BORDER        As In";
_color_status_off_border = ((int)0xff888888);
 //BA.debugLineNum = 98;BA.debugLine="Public Const COLOR_STATUS_TEXT              As In";
_color_status_text = ((int)0xffffffff);
 //BA.debugLineNum = 99;BA.debugLine="Public Const COLOR_TEXT_MUTED               As In";
_color_text_muted = ((int)0xffd1d5db);
 //BA.debugLineNum = 105;BA.debugLine="Public Const COLOR_STATUS_WARNING           As In";
_color_status_warning = ((int)0xffe5a93c);
 //BA.debugLineNum = 106;BA.debugLine="Public Const COLOR_STATUS_ALARM_LO          As In";
_color_status_alarm_lo = ((int)0xffe5a93c);
 //BA.debugLineNum = 108;BA.debugLine="Public Const COLOR_STATUS_ALARM             As In";
_color_status_alarm = ((int)0xffd35400);
 //BA.debugLineNum = 110;BA.debugLine="Public Const COLOR_STATUS_ALARM_HI          As In";
_color_status_alarm_hi = ((int)0xffc0392b);
 //BA.debugLineNum = 112;BA.debugLine="Public Const COLOR_STATUS_FORBIDDEN         As In";
_color_status_forbidden = ((int)0xff6b1d16);
 //BA.debugLineNum = 117;BA.debugLine="Public Const COLOR_TEXT_PRIMARY    			As Int = 0x";
_color_text_primary = ((int)0xffffffff);
 //BA.debugLineNum = 118;BA.debugLine="Public Const COLOR_TEXT_SECONDARY  			As Int = 0x";
_color_text_secondary = ((int)0xffdadada);
 //BA.debugLineNum = 119;BA.debugLine="Public Const COLOR_TEXT_DISABLED   			As Int = 0x";
_color_text_disabled = ((int)0xff444444);
 //BA.debugLineNum = 120;BA.debugLine="Public Const COLOR_TEXT_WARNING             As In";
_color_text_warning = ((int)0xff000000);
 //BA.debugLineNum = 121;BA.debugLine="Public Const COLOR_TEXT_ALARM               As In";
_color_text_alarm = ((int)0xffffffff);
 //BA.debugLineNum = 122;BA.debugLine="Public Const COLOR_TEXT_ERROR               As In";
_color_text_error = ((int)0xffffffff);
 //BA.debugLineNum = 123;BA.debugLine="Public Const COLOR_TEXT_INFO               	As In";
_color_text_info = ((int)0xffa9a9a9);
 //BA.debugLineNum = 128;BA.debugLine="Public Const COLOR_INDICATOR_TRACK 			As Int = 0x";
_color_indicator_track = ((int)0xff707070);
 //BA.debugLineNum = 129;BA.debugLine="Public Const COLOR_INDICATOR_LEVEL 			As Int = 0x";
_color_indicator_level = ((int)0xffffffff);
 //BA.debugLineNum = 134;BA.debugLine="Public Const STATUS_NORMAL          		As String =";
_status_normal = "Normal";
 //BA.debugLineNum = 135;BA.debugLine="Public Const STATUS_WARNING             	As Strin";
_status_warning = "Warning";
 //BA.debugLineNum = 136;BA.debugLine="Public Const STATUS_ALARM            		As String";
_status_alarm = "Alarm";
 //BA.debugLineNum = 137;BA.debugLine="Public Const STATUS_DISABLED            	As Strin";
_status_disabled = "Disabled";
 //BA.debugLineNum = 142;BA.debugLine="Public COLOR_TILE_NORMAL_BACKGROUND   		As Int =";
_color_tile_normal_background = _color_background_default;
 //BA.debugLineNum = 143;BA.debugLine="Public Const COLOR_TILE_NORMAL_TEXT         As In";
_color_tile_normal_text = _color_text_primary;
 //BA.debugLineNum = 145;BA.debugLine="Public Const COLOR_TILE_WARNING_BACKGROUND  As In";
_color_tile_warning_background = _color_status_warning;
 //BA.debugLineNum = 146;BA.debugLine="Public Const COLOR_TILE_WARNING_TEXT        As In";
_color_tile_warning_text = ((int)0xff000000);
 //BA.debugLineNum = 148;BA.debugLine="Public Const COLOR_TILE_ALARM_BACKGROUND    As In";
_color_tile_alarm_background = _color_status_alarm_hi;
 //BA.debugLineNum = 149;BA.debugLine="Public Const COLOR_TILE_ALARM_TEXT          As In";
_color_tile_alarm_text = ((int)0xffffffff);
 //BA.debugLineNum = 151;BA.debugLine="Public Const COLOR_TILE_DISABLED_BACKGROUND As In";
_color_tile_disabled_background = ((int)0xff707070);
 //BA.debugLineNum = 152;BA.debugLine="Public Const COLOR_TILE_DISABLED_TEXT       As In";
_color_tile_disabled_text = _color_text_disabled;
 //BA.debugLineNum = 154;BA.debugLine="Public Const COLOR_TILE_ENABLED_BACKGROUND   As I";
_color_tile_enabled_background = _color_background_dark;
 //BA.debugLineNum = 155;BA.debugLine="Public Const COLOR_TILE_ENABLED_TEXT         As I";
_color_tile_enabled_text = ((int)0xffffffff);
 //BA.debugLineNum = 161;BA.debugLine="Public Const GRID_BASELINE              	As Doubl";
_grid_baseline = 8;
 //BA.debugLineNum = 163;BA.debugLine="Public Const GRID_SPACING              		As Doubl";
_grid_spacing = 16;
 //BA.debugLineNum = 165;BA.debugLine="Public Const GRID_OUTER_SCREEN_EDGE			As Double =";
_grid_outer_screen_edge = 32;
 //BA.debugLineNum = 171;BA.debugLine="Public Const TEXT_SIZE_TITLE        		As Float =";
_text_size_title = (float) (16);
 //BA.debugLineNum = 173;BA.debugLine="Public Const TEXT_SIZE_LABEL        		As Float =";
_text_size_label = (float) (16);
 //BA.debugLineNum = 175;BA.debugLine="Public Const TEXT_SIZE_STATE        		As Float =";
_text_size_state = (float) (24);
 //BA.debugLineNum = 177;BA.debugLine="Public Const TEXT_SIZE_SMALL        		As Float =";
_text_size_small = (float) (14);
 //BA.debugLineNum = 179;BA.debugLine="Public Const TEXT_SIZE_TINY         		As Float =";
_text_size_tiny = (float) (12);
 //BA.debugLineNum = 181;BA.debugLine="Public Const TEXT_SIZE_ICON         		As Float =";
_text_size_icon = (float) (32);
 //BA.debugLineNum = 183;BA.debugLine="Public Const TEXT_SIZE_ICON_LARGE         	As Flo";
_text_size_icon_large = (float) (40);
 //BA.debugLineNum = 199;BA.debugLine="Public Const EVENT_COLOR_BG_BASE        As Int =";
_event_color_bg_base = ((int)0xff1f1f1f);
 //BA.debugLineNum = 200;BA.debugLine="Public Const EVENT_COLOR_BG_SELECTED    As Int =";
_event_color_bg_selected = ((int)0xff2b2b2b);
 //BA.debugLineNum = 201;BA.debugLine="Public Const EVENT_COLOR_BG_HOVER       As Int =";
_event_color_bg_hover = ((int)0xff262626);
 //BA.debugLineNum = 202;BA.debugLine="Public Const EVENT_COLOR_BG_DISABLED    As Int =";
_event_color_bg_disabled = ((int)0xff2f2f2f);
 //BA.debugLineNum = 203;BA.debugLine="Public Const EVENT_DIVIDER   			As Int = 0xFF3030";
_event_divider = ((int)0xff303030);
 //BA.debugLineNum = 211;BA.debugLine="Public Const EVENT_COLOR_TEXT			As Int = 0xFFFFFF";
_event_color_text = ((int)0xffffffff);
 //BA.debugLineNum = 222;BA.debugLine="Public Const EVENT_LEVEL_INFO     				As Int = 0";
_event_level_info = (int) (0);
 //BA.debugLineNum = 223;BA.debugLine="Public Const EVENT_LEVEL_WARNING  				As Int = 1";
_event_level_warning = (int) (1);
 //BA.debugLineNum = 224;BA.debugLine="Public Const EVENT_LEVEL_ALARM    				As Int = 2";
_event_level_alarm = (int) (2);
 //BA.debugLineNum = 228;BA.debugLine="Public Const EVENT_COLOR_ICON_INFO      		As Int";
_event_color_icon_info = _color_text_primary;
 //BA.debugLineNum = 229;BA.debugLine="Public Const EVENT_COLOR_ICON_WARNING   		As Int";
_event_color_icon_warning = ((int)0xffffc000);
 //BA.debugLineNum = 230;BA.debugLine="Public Const EVENT_COLOR_ICON_ALARM     		As Int";
_event_color_icon_alarm = ((int)0xffff0000);
 //BA.debugLineNum = 231;BA.debugLine="Public Const EVENT_COLOR_ICON_CRITICAL  		As Int";
_event_color_icon_critical = ((int)0xffff0000);
 //BA.debugLineNum = 232;BA.debugLine="Public Const EVENT_COLOR_ICON_DISABLED  		As Int";
_event_color_icon_disabled = ((int)0xff777777);
 //BA.debugLineNum = 234;BA.debugLine="Public Const EVENT_ICON_INFO 					As String = Chr";
_event_icon_info = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf05a)));
 //BA.debugLineNum = 235;BA.debugLine="Public Const EVENT_ICON_WARNING        			As Stri";
_event_icon_warning = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf071)));
 //BA.debugLineNum = 236;BA.debugLine="Public Const EVENT_ICON_ALARM         			As Strin";
_event_icon_alarm = "🚨";
 //BA.debugLineNum = 237;BA.debugLine="Public Const EVENT_ICON_DISABLED      			As Strin";
_event_icon_disabled = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf00d)));
 //BA.debugLineNum = 240;BA.debugLine="Public Const EVENT_NORMAL_TIMESTAMP_TEXT_SIZE	As";
_event_normal_timestamp_text_size = (float) (13);
 //BA.debugLineNum = 241;BA.debugLine="Public Const EVENT_NORMAL_MESSAGE_TEXT_SIZE   	As";
_event_normal_message_text_size = (float) (15);
 //BA.debugLineNum = 242;BA.debugLine="Public Const EVENT_NORMAL_SOURCE_TEXT_SIZE    	As";
_event_normal_source_text_size = (float) (16);
 //BA.debugLineNum = 247;BA.debugLine="Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As";
_event_normal_icon_text_size = (float) (24);
 //BA.debugLineNum = 249;BA.debugLine="Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As";
_event_normal_icon_text_size = (float) (24);
 //BA.debugLineNum = 252;BA.debugLine="Public Const EVENT_NORMAL_HEIGHT				As Int = 36di";
_event_normal_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (36));
 //BA.debugLineNum = 253;BA.debugLine="Public Const EVENT_NORMAL_HEIGHT_LARGE			As Int =";
_event_normal_height_large = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (54));
 //BA.debugLineNum = 254;BA.debugLine="Public Const EVENT_NORMAL_PADDING 				As Int = 6d";
_event_normal_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (6));
 //BA.debugLineNum = 257;BA.debugLine="Public Const EVENT_COMPACT_TIMESTAMP_TEXT_SIZE 	A";
_event_compact_timestamp_text_size = (float) (10);
 //BA.debugLineNum = 258;BA.debugLine="Public Const EVENT_COMPACT_MESSAGE_TEXT_SIZE   	A";
_event_compact_message_text_size = (float) (12);
 //BA.debugLineNum = 259;BA.debugLine="Public Const EVENT_COMPACT_SOURCE_TEXT_SIZE    	A";
_event_compact_source_text_size = (float) (14);
 //BA.debugLineNum = 264;BA.debugLine="Public Const EVENT_COMPACT_ICON_TEXT_SIZE      	A";
_event_compact_icon_text_size = (float) (20);
 //BA.debugLineNum = 268;BA.debugLine="Public Const EVENT_COMPACT_HEIGHT				As Int = 24d";
_event_compact_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24));
 //BA.debugLineNum = 269;BA.debugLine="Public Const EVENT_COMPACT_PADDING 				As Int = 4";
_event_compact_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4));
 //BA.debugLineNum = 272;BA.debugLine="Public Const EVENT_TITLE_HEIGHT As Int = 32dip";
_event_title_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32));
 //BA.debugLineNum = 279;BA.debugLine="Public Const LIST_COLOR_BG_BASE              	As";
_list_color_bg_base = ((int)0xfff5f5f5);
 //BA.debugLineNum = 281;BA.debugLine="Public Const LIST_COLOR_BG_ITEM              	As";
_list_color_bg_item = ((int)0xffffffff);
 //BA.debugLineNum = 283;BA.debugLine="Public Const LIST_COLOR_BG_SELECTED          	As";
_list_color_bg_selected = ((int)0xffd0d0d0);
 //BA.debugLineNum = 285;BA.debugLine="Public Const LIST_COLOR_BG_HOVER             	As";
_list_color_bg_hover = ((int)0xffeaeaea);
 //BA.debugLineNum = 287;BA.debugLine="Public Const LIST_COLOR_BG_DISABLED          	As";
_list_color_bg_disabled = ((int)0xffe0e0e0);
 //BA.debugLineNum = 289;BA.debugLine="Public Const LIST_DIVIDER                    	As";
_list_divider = ((int)0xffcccccc);
 //BA.debugLineNum = 291;BA.debugLine="Public Const LIST_COLOR_TEXT                 	As";
_list_color_text = ((int)0xff202020);
 //BA.debugLineNum = 292;BA.debugLine="Public Const LIST_COLOR_TEXT_DISABLED        	As";
_list_color_text_disabled = ((int)0xff909090);
 //BA.debugLineNum = 294;BA.debugLine="Public Const LIST_TITLE_HEIGHT As Int = 32dip";
_list_title_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32));
 //BA.debugLineNum = 296;BA.debugLine="Public Const LIST_NORMAL_HEIGHT 				As Int = 48di";
_list_normal_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48));
 //BA.debugLineNum = 297;BA.debugLine="Public Const LIST_NORMAL_PADDING 				As Int = 12d";
_list_normal_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12));
 //BA.debugLineNum = 298;BA.debugLine="Public Const LIST_NORMAL_PRIMARY_TEXT_SIZE 		As F";
_list_normal_primary_text_size = (float) (16);
 //BA.debugLineNum = 299;BA.debugLine="Public Const LIST_NORMAL_SECONDARY_TEXT_SIZE	As F";
_list_normal_secondary_text_size = (float) (13);
 //BA.debugLineNum = 300;BA.debugLine="Public Const LIST_COMPACT_HEIGHT 				As Int = 34d";
_list_compact_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (34));
 //BA.debugLineNum = 301;BA.debugLine="Public Const LIST_COMPACT_PADDING 				As Int = 7d";
_list_compact_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (7));
 //BA.debugLineNum = 302;BA.debugLine="Public Const LIST_COMPACT_PRIMARY_TEXT_SIZE 	As F";
_list_compact_primary_text_size = (float) (14);
 //BA.debugLineNum = 303;BA.debugLine="Public Const LIST_COMPACT_SECONDARY_TEXT_SIZE 	As";
_list_compact_secondary_text_size = (float) (11);
 //BA.debugLineNum = 308;BA.debugLine="Public Const COLOR_SLIDER_TRACK            		As I";
_color_slider_track = ((int)0xffffffff);
 //BA.debugLineNum = 309;BA.debugLine="Public Const COLOR_SLIDER_ACTIVE           		As I";
_color_slider_active = ((int)0xffb8b8b8);
 //BA.debugLineNum = 310;BA.debugLine="Public Const COLOR_SLIDER_KNOB             		As I";
_color_slider_knob = ((int)0xff4a4a4a);
 //BA.debugLineNum = 311;BA.debugLine="Public Const COLOR_SLIDER_DISABLED_TRACK   		As I";
_color_slider_disabled_track = ((int)0xffe0e0e0);
 //BA.debugLineNum = 312;BA.debugLine="Public Const COLOR_SLIDER_DISABLED_KNOB    		As I";
_color_slider_disabled_knob = ((int)0xffa8a8a8);
 //BA.debugLineNum = 313;BA.debugLine="Public Const COLOR_SLIDER_VALUE_TEXT       		As I";
_color_slider_value_text = ((int)0xff2a2a2a);
 //BA.debugLineNum = 314;BA.debugLine="Public Const COLOR_SLIDER_LABEL_TEXT       		As I";
_color_slider_label_text = _color_text_secondary;
 //BA.debugLineNum = 315;BA.debugLine="Public Const COLOR_SLIDER_UNIT_TEXT        		As I";
_color_slider_unit_text = ((int)0xff3a3a3a);
 //BA.debugLineNum = 316;BA.debugLine="Public Const COLOR_SLIDER_KNOB_BORDER			As Int =";
_color_slider_knob_border = ((int)0xff2f2f2f);
 //BA.debugLineNum = 321;BA.debugLine="Public Const COLOR_TREND_LINE     				As Int = 0x";
_color_trend_line = ((int)0xffffffff);
 //BA.debugLineNum = 322;BA.debugLine="Public Const COLOR_TREND_BACKGROUND      		As Int";
_color_trend_background = _color_background_default;
 //BA.debugLineNum = 323;BA.debugLine="Public Const COLOR_TREND_BORDER   				As Int = 0x";
_color_trend_border = ((int)0xffb0b0b0);
 //BA.debugLineNum = 324;BA.debugLine="Public Const COLOR_TREND_GRID_LINE      		As Int";
_color_trend_grid_line = ((int)0xff343d46);
 //BA.debugLineNum = 329;BA.debugLine="Public Const NAV_SELECT_TYPE_PAGE 				As String =";
_nav_select_type_page = "Page";
 //BA.debugLineNum = 330;BA.debugLine="Public Const NAV_SELECT_TYPE_BACK 				As String =";
_nav_select_type_back = "Back";
 //BA.debugLineNum = 331;BA.debugLine="Public Const NAV_ICON_BACK 						As String = Chr(";
_nav_icon_back = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf060)));
 //BA.debugLineNum = 336;BA.debugLine="Public Const COLOR_INDICATOR_TRUE_DEFAULT 		As In";
_color_indicator_true_default = ((int)0xffe8e8e8);
 //BA.debugLineNum = 337;BA.debugLine="Public Const COLOR_INDICATOR_FALSE_DEFAULT 		As I";
_color_indicator_false_default = ((int)0xff323232);
 //BA.debugLineNum = 338;BA.debugLine="Public Const COLOR_INDICATOR_DISABLED_DEFAULT 	As";
_color_indicator_disabled_default = ((int)0xff808080);
 //BA.debugLineNum = 339;BA.debugLine="Public Const COLOR_INDICATOR_TRUE_GREEN 		As Int";
_color_indicator_true_green = ((int)0xff00ff00);
 //BA.debugLineNum = 340;BA.debugLine="Public Const COLOR_INDICATOR_FALSE_RED 			As Int";
_color_indicator_false_red = ((int)0xffff0000);
 //BA.debugLineNum = 341;BA.debugLine="Public Const COLOR_TEXT_INDICATOR_TRUE			As Int =";
_color_text_indicator_true = ((int)0xff000000);
 //BA.debugLineNum = 342;BA.debugLine="Public Const COLOR_TEXT_INDICATOR_FALSE			As Int";
_color_text_indicator_false = ((int)0xffffffff);
 //BA.debugLineNum = 343;BA.debugLine="Public Const TEXT_INDICATOR_TRUE				As String = \"";
_text_indicator_true = "OK";
 //BA.debugLineNum = 344;BA.debugLine="Public Const TEXT_INDICATOR_FALSE				As String =";
_text_indicator_false = "ERROR";
 //BA.debugLineNum = 345;BA.debugLine="Public Const TEXT_INDICATOR_DISABLED			As String";
_text_indicator_disabled = "Disabled";
 //BA.debugLineNum = 350;BA.debugLine="Public Const COLOR_DEVIATION_BAR				As Int = 0xFF";
_color_deviation_bar = ((int)0xffd3d3d3);
 //BA.debugLineNum = 351;BA.debugLine="Public Const COLOR_DEVIATION_DEADBAND			As Int =";
_color_deviation_deadband = ((int)0xff555555);
 //BA.debugLineNum = 352;BA.debugLine="Public Const COLOR_DEVIATION_NEUTRAL			As Int = 0";
_color_deviation_neutral = ((int)0xffb0b0b0);
 //BA.debugLineNum = 353;BA.debugLine="Public Const COLOR_DEVIATION_WARNING			As Int = 0";
_color_deviation_warning = ((int)0xffffd700);
 //BA.debugLineNum = 354;BA.debugLine="Public Const COLOR_DEVIATION_ALARM				As Int = 0x";
_color_deviation_alarm = ((int)0xffff0000);
 //BA.debugLineNum = 360;BA.debugLine="Public Const COLOR_GAUGESEGMENTS_NORMAL_ACTIVE 	A";
_color_gaugesegments_normal_active = _color_slider_active;
 //BA.debugLineNum = 361;BA.debugLine="Public Const COLOR_GAUGESEGMENTS_WARNING_ACTIVE	A";
_color_gaugesegments_warning_active = ((int)0xfff59e0b);
 //BA.debugLineNum = 362;BA.debugLine="Public Const COLOR_GAUGESEGMENTS_ALARM_ACTIVE 	As";
_color_gaugesegments_alarm_active = ((int)0xffef4444);
 //BA.debugLineNum = 365;BA.debugLine="Public Const COLOR_GAUGESEGMENTS_NORMAL_MUTED 	As";
_color_gaugesegments_normal_muted = _color_slider_track;
 //BA.debugLineNum = 366;BA.debugLine="Public Const COLOR_GAUGESEGMENTS_WARNING_MUTED 	A";
_color_gaugesegments_warning_muted = ((int)0x3cf59e0b);
 //BA.debugLineNum = 367;BA.debugLine="Public Const COLOR_GAUGESEGMENTS_ALARM_MUTED 	As";
_color_gaugesegments_alarm_muted = ((int)0x3cef4444);
 //BA.debugLineNum = 372;BA.debugLine="Public ICON_ON 									As String = Chr(0xF205)";
_icon_on = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf205)));
 //BA.debugLineNum = 373;BA.debugLine="Public ICON_OFF 								As String = Chr(0xF204)";
_icon_off = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf204)));
 //BA.debugLineNum = 374;BA.debugLine="Public ICON_REFRESH 							As String = Chr(0xF021";
_icon_refresh = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf021)));
 //BA.debugLineNum = 375;BA.debugLine="Public ICON_STOP_HAND							As String = Chr(0xF25";
_icon_stop_hand = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf256)));
 //BA.debugLineNum = 376;BA.debugLine="Public ICON_STOP								As String = Chr(0xF04D)";
_icon_stop = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf04d)));
 //BA.debugLineNum = 377;BA.debugLine="Public ICON_STOP_CIRCLE							As String = Chr(0xF";
_icon_stop_circle = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf28d)));
 //BA.debugLineNum = 378;BA.debugLine="Public ICON_WAIT								As String = Chr(0xF252)";
_icon_wait = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf252)));
 //BA.debugLineNum = 383;BA.debugLine="Public Const SHAPE_INDICATOR_SIZE				As Double =";
_shape_indicator_size = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (14));
 //BA.debugLineNum = 384;BA.debugLine="Public Const SHAPE_WARNING_INDICATOR			As String";
_shape_warning_indicator = "▲";
 //BA.debugLineNum = 385;BA.debugLine="Public Const SHAPE_ALARM_INDICATOR				As String =";
_shape_alarm_indicator = "■";
 //BA.debugLineNum = 391;BA.debugLine="Public ByteConv As ByteConverter";
_byteconv = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public static String  _setalltilesbackgroundcolor(int _clr) throws Exception{
 //BA.debugLineNum = 597;BA.debugLine="Public Sub SetAllTilesBackgroundColor(clr As Int)";
 //BA.debugLineNum = 598;BA.debugLine="COLOR_TILE_NORMAL_BACKGROUND = clr";
_color_tile_normal_background = _clr;
 //BA.debugLineNum = 599;BA.debugLine="End Sub";
return "";
}
public static float  _setalpha(boolean _enabled) throws Exception{
 //BA.debugLineNum = 677;BA.debugLine="Public Sub SetAlpha(enabled As Boolean) As Float";
 //BA.debugLineNum = 678;BA.debugLine="Return IIf(enabled, 1, 0.4)";
if (true) return (float)(BA.ObjectToNumber(((_enabled) ? ((Object)(1)) : ((Object)(0.4)))));
 //BA.debugLineNum = 679;BA.debugLine="End Sub";
return 0f;
}
public static String  _setbatterystateicon(int _value) throws Exception{
String _bat_warn = "";
String _bat_empty = "";
String _bat_quarter = "";
String _bat_half = "";
String _bat_three_quarters = "";
String _bat_full = "";
 //BA.debugLineNum = 778;BA.debugLine="Public Sub SetBatteryStateIcon(value As Int) As St";
 //BA.debugLineNum = 779;BA.debugLine="Private BAT_WARN As String = Chr(0xF071)";
_bat_warn = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf071)));
 //BA.debugLineNum = 780;BA.debugLine="Private BAT_EMPTY As String = Chr(0xF244)";
_bat_empty = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf244)));
 //BA.debugLineNum = 781;BA.debugLine="Private BAT_QUARTER As String = Chr(0xF243)";
_bat_quarter = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf243)));
 //BA.debugLineNum = 782;BA.debugLine="Private BAT_HALF As String = Chr(0xF242)";
_bat_half = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf242)));
 //BA.debugLineNum = 783;BA.debugLine="Private BAT_THREE_QUARTERS As String = Chr(0xF241";
_bat_three_quarters = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf241)));
 //BA.debugLineNum = 784;BA.debugLine="Private BAT_FULL As String = Chr(0xF240)";
_bat_full = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf240)));
 //BA.debugLineNum = 786;BA.debugLine="If value <= 0 Then";
if (_value<=0) { 
 //BA.debugLineNum = 787;BA.debugLine="Return BAT_EMPTY";
if (true) return _bat_empty;
 };
 //BA.debugLineNum = 789;BA.debugLine="If value > 0 And value <= 25 Then";
if (_value>0 && _value<=25) { 
 //BA.debugLineNum = 790;BA.debugLine="Return BAT_QUARTER";
if (true) return _bat_quarter;
 };
 //BA.debugLineNum = 792;BA.debugLine="If value > 25 And value <= 50 Then";
if (_value>25 && _value<=50) { 
 //BA.debugLineNum = 793;BA.debugLine="Return BAT_HALF";
if (true) return _bat_half;
 };
 //BA.debugLineNum = 795;BA.debugLine="If value > 50 And value <= 75 Then";
if (_value>50 && _value<=75) { 
 //BA.debugLineNum = 796;BA.debugLine="Return BAT_THREE_QUARTERS";
if (true) return _bat_three_quarters;
 };
 //BA.debugLineNum = 798;BA.debugLine="If value > 75 Then";
if (_value>75) { 
 //BA.debugLineNum = 799;BA.debugLine="Return BAT_FULL";
if (true) return _bat_full;
 };
 //BA.debugLineNum = 801;BA.debugLine="Return BAT_WARN";
if (true) return _bat_warn;
 //BA.debugLineNum = 802;BA.debugLine="End Sub";
return "";
}
public static String  _setclvbackgroundtransparent(b4j.example.customlistview _clv) throws Exception{
anywheresoftware.b4j.objects.ScrollPaneWrapper _sp = null;
 //BA.debugLineNum = 632;BA.debugLine="Public Sub SetCLVBackgroundTransparent(clv As Cust";
 //BA.debugLineNum = 634;BA.debugLine="Dim sp As ScrollPane = clv.sv";
_sp = new anywheresoftware.b4j.objects.ScrollPaneWrapper();
_sp = (anywheresoftware.b4j.objects.ScrollPaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.ScrollPaneWrapper(), (javafx.scene.control.ScrollPane)(_clv._sv.getObject()));
 //BA.debugLineNum = 635;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-background\", \"";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-background","transparent");
 //BA.debugLineNum = 636;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-background-col";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-background-color","transparent");
 //BA.debugLineNum = 639;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-control-inner-";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-control-inner-background","transparent");
 //BA.debugLineNum = 640;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-control-inner-";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-control-inner-background-alt","transparent");
 //BA.debugLineNum = 642;BA.debugLine="End Sub";
return "";
}
public static String  _setclvscrollbars(b4j.example.customlistview _clv,boolean _visible) throws Exception{
anywheresoftware.b4j.objects.ScrollPaneWrapper _nsv = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 655;BA.debugLine="Public Sub SetCLVScrollBars(clv As CustomListView,";
 //BA.debugLineNum = 657;BA.debugLine="Dim nsv As ScrollPane = clv.sv";
_nsv = new anywheresoftware.b4j.objects.ScrollPaneWrapper();
_nsv = (anywheresoftware.b4j.objects.ScrollPaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.ScrollPaneWrapper(), (javafx.scene.control.ScrollPane)(_clv._sv.getObject()));
 //BA.debugLineNum = 658;BA.debugLine="If visible Then";
if (_visible) { 
 //BA.debugLineNum = 659;BA.debugLine="nsv.SetVScrollVisibility(\"ALWAYS\")";
_nsv.SetVScrollVisibility(BA.getEnumFromString(javafx.scene.control.ScrollPane.ScrollBarPolicy.class,"ALWAYS"));
 }else {
 //BA.debugLineNum = 661;BA.debugLine="nsv.SetVScrollVisibility(\"NEVER\")";
_nsv.SetVScrollVisibility(BA.getEnumFromString(javafx.scene.control.ScrollPane.ScrollBarPolicy.class,"NEVER"));
 };
 //BA.debugLineNum = 663;BA.debugLine="Dim jo As JavaObject = clv 'ignore";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_clv));
 //BA.debugLineNum = 664;BA.debugLine="jo.SetField(\"_scrollbarsvisible\", visible)";
_jo.SetField("_scrollbarsvisible",(Object)(_visible));
 //BA.debugLineNum = 665;BA.debugLine="clv.Base_Resize(clv.AsView.Width, clv.AsView.Heig";
_clv._base_resize(_clv._asview().getWidth(),_clv._asview().getHeight());
 //BA.debugLineNum = 667;BA.debugLine="End Sub";
return "";
}
public static String  _setcomfortstate(double _t,int _h) throws Exception{
 //BA.debugLineNum = 821;BA.debugLine="Public Sub SetComfortState(t As Double, h As Int)";
 //BA.debugLineNum = 826;BA.debugLine="If h < 30 Then Return \"Very Dry\"";
if (_h<30) { 
if (true) return "Very Dry";};
 //BA.debugLineNum = 827;BA.debugLine="If h > 70 Then Return \"Very Humid\"";
if (_h>70) { 
if (true) return "Very Humid";};
 //BA.debugLineNum = 830;BA.debugLine="If t < 18 Then Return \"Too Cold\"";
if (_t<18) { 
if (true) return "Too Cold";};
 //BA.debugLineNum = 831;BA.debugLine="If t > 26 Then Return \"Too Hot\"";
if (_t>26) { 
if (true) return "Too Hot";};
 //BA.debugLineNum = 834;BA.debugLine="If t >= 20 And t <= 24 And h >= 40 And h <= 60 Th";
if (_t>=20 && _t<=24 && _h>=40 && _h<=60) { 
 //BA.debugLineNum = 835;BA.debugLine="Return \"Comfortable\"";
if (true) return "Comfortable";
 };
 //BA.debugLineNum = 838;BA.debugLine="If t < 20 Then";
if (_t<20) { 
 //BA.debugLineNum = 839;BA.debugLine="If h < 40 Then Return \"Cold & Dry\"";
if (_h<40) { 
if (true) return "Cold & Dry";};
 //BA.debugLineNum = 840;BA.debugLine="If h > 60 Then Return \"Cold & Humid\"";
if (_h>60) { 
if (true) return "Cold & Humid";};
 };
 //BA.debugLineNum = 843;BA.debugLine="If t > 24 Then";
if (_t>24) { 
 //BA.debugLineNum = 844;BA.debugLine="If h < 40 Then Return \"Hot & Dry\"";
if (_h<40) { 
if (true) return "Hot & Dry";};
 //BA.debugLineNum = 845;BA.debugLine="If h > 60 Then Return \"Hot & Humid\"";
if (_h>60) { 
if (true) return "Hot & Humid";};
 };
 //BA.debugLineNum = 848;BA.debugLine="Return \"Moderate\"";
if (true) return "Moderate";
 //BA.debugLineNum = 849;BA.debugLine="End Sub";
return "";
}
public static String  _setstylebold(anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper _node,boolean _value) throws Exception{
 //BA.debugLineNum = 560;BA.debugLine="Public Sub SetStyleBold(node As Node, value As Boo";
 //BA.debugLineNum = 561;BA.debugLine="If value Then";
if (_value) { 
 //BA.debugLineNum = 562;BA.debugLine="CSSUtils.SetStyleProperty(node, \"-fx-font-weight";
_cssutils._setstyleproperty(_node,"-fx-font-weight","bold");
 }else {
 //BA.debugLineNum = 564;BA.debugLine="CSSUtils.SetStyleProperty(node, \"-fx-font-weight";
_cssutils._setstyleproperty(_node,"-fx-font-weight","normal");
 };
 //BA.debugLineNum = 566;BA.debugLine="End Sub";
return "";
}
public static String  _settextcolor(anywheresoftware.b4a.objects.B4XViewWrapper _lbl,int _col) throws Exception{
 //BA.debugLineNum = 904;BA.debugLine="Public Sub SetTextColor(lbl As B4XView, col As Int";
 //BA.debugLineNum = 905;BA.debugLine="If lbl.IsInitialized Then lbl.TextColor = col";
if (_lbl.IsInitialized()) { 
_lbl.setTextColor(_col);};
 //BA.debugLineNum = 906;BA.debugLine="End Sub";
return "";
}
public static String  _settextcolorcrossplatform(anywheresoftware.b4a.objects.B4XViewWrapper _v,String _colorhex) throws Exception{
 //BA.debugLineNum = 895;BA.debugLine="Public Sub SetTextColorCrossPlatform(v As B4XView,";
 //BA.debugLineNum = 897;BA.debugLine="CSSUtils.SetStyleProperty(v, \"-fx-text-fill\", col";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_v.getObject())),"-fx-text-fill",_colorhex);
 //BA.debugLineNum = 901;BA.debugLine="End Sub";
return "";
}
public static String  _snapallchildrentogrid(anywheresoftware.b4a.objects.B4XViewWrapper _parent) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _c = null;
 //BA.debugLineNum = 751;BA.debugLine="Public Sub SnapAllChildrenToGrid(parent As B4XView";
 //BA.debugLineNum = 752;BA.debugLine="For Each c As B4XView In parent.GetAllViewsRecurs";
_c = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group1 = _parent.GetAllViewsRecursive();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_c = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group1.Get(index1)));
 //BA.debugLineNum = 753;BA.debugLine="SnapViewToGrid(c)";
_snapviewtogrid(_c);
 }
};
 //BA.debugLineNum = 755;BA.debugLine="End Sub";
return "";
}
public static int  _snapcoord(int _value) throws Exception{
int _stepsize = 0;
 //BA.debugLineNum = 715;BA.debugLine="Public Sub SnapCoord(value As Int) As Int";
 //BA.debugLineNum = 716;BA.debugLine="If Not(HMITileGrid.IsInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_hmitilegrid.IsInitialized /*boolean*/ ())) { 
 //BA.debugLineNum = 717;BA.debugLine="Return 0";
if (true) return (int) (0);
 };
 //BA.debugLineNum = 719;BA.debugLine="Dim stepSize As Int = HMITileGrid.MinorStep";
_stepsize = _hmitilegrid._minorstep /*int*/ ;
 //BA.debugLineNum = 720;BA.debugLine="If stepSize <= 0 Then stepSize = 8dip";
if (_stepsize<=0) { 
_stepsize = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8));};
 //BA.debugLineNum = 721;BA.debugLine="Return Round(value / stepSize) * stepSize";
if (true) return (int) (anywheresoftware.b4a.keywords.Common.Round(_value/(double)_stepsize)*_stepsize);
 //BA.debugLineNum = 722;BA.debugLine="End Sub";
return 0;
}
public static String  _snapsizetogrid(anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
 //BA.debugLineNum = 736;BA.debugLine="Public Sub SnapSizeToGrid(v As B4XView)";
 //BA.debugLineNum = 737;BA.debugLine="If v.IsInitialized = False Then Return";
if (_v.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 738;BA.debugLine="v.Width = SnapCoord(v.Width)";
_v.setWidth(_snapcoord((int) (_v.getWidth())));
 //BA.debugLineNum = 739;BA.debugLine="v.Height = SnapCoord(v.Height)";
_v.setHeight(_snapcoord((int) (_v.getHeight())));
 //BA.debugLineNum = 740;BA.debugLine="End Sub";
return "";
}
public static String  _snapviewfull(anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
 //BA.debugLineNum = 746;BA.debugLine="Public Sub SnapViewFull(v As B4XView)";
 //BA.debugLineNum = 747;BA.debugLine="SnapViewToGrid(v)";
_snapviewtogrid(_v);
 //BA.debugLineNum = 748;BA.debugLine="SnapSizeToGrid(v)";
_snapsizetogrid(_v);
 //BA.debugLineNum = 749;BA.debugLine="End Sub";
return "";
}
public static String  _snapviewtogrid(anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
 //BA.debugLineNum = 727;BA.debugLine="Public Sub SnapViewToGrid(v As B4XView)";
 //BA.debugLineNum = 728;BA.debugLine="If v.IsInitialized = False Then Return";
if (_v.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 729;BA.debugLine="v.Left = SnapCoord(v.Left)";
_v.setLeft(_snapcoord((int) (_v.getLeft())));
 //BA.debugLineNum = 730;BA.debugLine="v.Top = SnapCoord(v.Top)";
_v.setTop(_snapcoord((int) (_v.getTop())));
 //BA.debugLineNum = 731;BA.debugLine="End Sub";
return "";
}
public static int  _statustoint(String _status) throws Exception{
int _result = 0;
 //BA.debugLineNum = 607;BA.debugLine="Public Sub StatusToInt(status As String) As Int";
 //BA.debugLineNum = 608;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 609;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_status_normal,_status_warning,_status_alarm,_status_disabled)) {
case 0: {
 //BA.debugLineNum = 611;BA.debugLine="result = 0";
_result = (int) (0);
 break; }
case 1: {
 //BA.debugLineNum = 613;BA.debugLine="result = 1";
_result = (int) (1);
 break; }
case 2: {
 //BA.debugLineNum = 615;BA.debugLine="result = 2";
_result = (int) (2);
 break; }
case 3: {
 //BA.debugLineNum = 617;BA.debugLine="result = 3";
_result = (int) (3);
 break; }
default: {
 //BA.debugLineNum = 619;BA.debugLine="result = -1";
_result = (int) (-1);
 break; }
}
;
 //BA.debugLineNum = 621;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 622;BA.debugLine="End Sub";
return 0;
}
}
