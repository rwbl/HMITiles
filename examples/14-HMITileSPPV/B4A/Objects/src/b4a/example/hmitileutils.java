package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitileutils {
private static hmitileutils mostCurrent = new hmitileutils();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static int _tile_default_size = 0;
public static int _color_background_default = 0;
public static int _color_background_panel = 0;
public static int _color_background_screen = 0;
public static int _color_border_default = 0;
public static int _color_border_dark = 0;
public static int _color_background_hover = 0;
public static int _color_background_dark = 0;
public static int _color_background_selected = 0;
public static int _color_status_warning = 0;
public static int _color_status_alarm_lo = 0;
public static int _color_status_alarm_hi = 0;
public static int _color_status_forbidden = 0;
public static int _color_status_on_background = 0;
public static int _color_status_off_background = 0;
public static int _color_status_on_border = 0;
public static int _color_status_off_border = 0;
public static int _color_status_text = 0;
public static int _color_text_primary = 0;
public static int _color_text_secondary = 0;
public static int _color_text_disabled = 0;
public static int _color_text_warning = 0;
public static int _color_text_alarm = 0;
public static int _color_text_error = 0;
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
public static double _border_width = 0;
public static double _border_radius = 0;
public static double _border_radius_large = 0;
public static double _grid_baseline = 0;
public static double _grid_spacing = 0;
public static double _grid_outer_screen_edge = 0;
public static int _padding = 0;
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
public static int _color_trend_bg = 0;
public static int _color_trend_border = 0;
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
public static String _icon_on = "";
public static String _icon_off = "";
public static String _icon_refresh = "";
public static String _icon_stop_hand = "";
public static String _icon_stop = "";
public static String _icon_stop_circle = "";
public static String _icon_wait = "";
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _byteconv = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public static String  _applyfontawesomestyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 476;BA.debugLine="Public Sub ApplyFontAwesomeStyle(lbl As B4XView)";
 //BA.debugLineNum = 477;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 483;BA.debugLine="lbl.Font = xui.CreateFontAwesome(TEXT_SIZE_STATE";
_lbl.setFont(_xui.CreateFontAwesome(_text_size_state));
 //BA.debugLineNum = 484;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 487;BA.debugLine="End Sub";
return "";
}
public static String  _applyiconstyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 463;BA.debugLine="Public Sub ApplyIconStyle(lbl As B4XView)";
 //BA.debugLineNum = 464;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 470;BA.debugLine="lbl.Font = xui.CreateDefaultFont(TEXT_SIZE_ICON)";
_lbl.setFont(_xui.CreateDefaultFont(_text_size_icon));
 //BA.debugLineNum = 471;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return "";
}
public static String  _applylabelstyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 420;BA.debugLine="Public Sub ApplyLabelStyle(lbl As B4XView)";
 //BA.debugLineNum = 421;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 428;BA.debugLine="lbl.Font = xui.CreateDefaultFont(TEXT_SIZE_STATE";
_lbl.setFont(_xui.CreateDefaultFont(_text_size_state));
 //BA.debugLineNum = 429;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 432;BA.debugLine="End Sub";
return "";
}
public static String  _applysubinfostyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 448;BA.debugLine="Public Sub ApplySubInfoStyle(lbl As B4XView)";
 //BA.debugLineNum = 449;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 457;BA.debugLine="lbl.Font = xui.CreateDefaultBoldFont(TEXT_SIZE_T";
_lbl.setFont(_xui.CreateDefaultBoldFont(_text_size_tiny));
 //BA.debugLineNum = 458;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 };
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
return "";
}
public static String  _applytilestyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _tilepane,String _status) throws Exception{
 //BA.debugLineNum = 362;BA.debugLine="Public Sub ApplyTileStyle(tilepane As B4XView, sta";
 //BA.debugLineNum = 363;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_status_normal,_status_warning,_status_alarm,_status_disabled)) {
case 0: {
 //BA.debugLineNum = 365;BA.debugLine="tilepane.Color = COLOR_TILE_NORMAL_BACKGROUND";
_tilepane.setColor(_color_tile_normal_background);
 break; }
case 1: {
 //BA.debugLineNum = 368;BA.debugLine="tilepane.Color = COLOR_TILE_WARNING_BACKGROUND";
_tilepane.setColor(_color_tile_warning_background);
 break; }
case 2: {
 //BA.debugLineNum = 371;BA.debugLine="tilepane.Color = COLOR_TILE_ALARM_BACKGROUND";
_tilepane.setColor(_color_tile_alarm_background);
 break; }
case 3: {
 //BA.debugLineNum = 374;BA.debugLine="tilepane.Color = COLOR_TILE_DISABLED_BACKGROUND";
_tilepane.setColor(_color_tile_disabled_background);
 break; }
}
;
 //BA.debugLineNum = 376;BA.debugLine="tilepane.SetColorAndBorder(tilepane.Color, _";
_tilepane.SetColorAndBorder(_tilepane.getColor(),(int) (_border_width),_color_status_on_border,(int) (_border_radius));
 //BA.debugLineNum = 380;BA.debugLine="End Sub";
return "";
}
public static String  _applytitlestyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 382;BA.debugLine="Public Sub ApplyTitleStyle(lbl As B4XView)";
 //BA.debugLineNum = 383;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 390;BA.debugLine="lbl.Font = xui.CreateDefaultBoldFont(TEXT_SIZE_T";
_lbl.setFont(_xui.CreateDefaultBoldFont(_text_size_title));
 //BA.debugLineNum = 391;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return "";
}
public static String  _applyunitstyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 434;BA.debugLine="Public Sub ApplyUnitStyle(lbl As B4XView)";
 //BA.debugLineNum = 435;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 442;BA.debugLine="lbl.Font = xui.CreateDefaultFont(TEXT_SIZE_SMALL";
_lbl.setFont(_xui.CreateDefaultFont(_text_size_small));
 //BA.debugLineNum = 443;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 };
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public static String  _applyvaluestyle(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 396;BA.debugLine="Public Sub ApplyValueStyle(lbl As B4XView)";
 //BA.debugLineNum = 397;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 404;BA.debugLine="lbl.Font = xui.CreateDefaultBoldFont(TEXT_SIZE_S";
_lbl.setFont(_xui.CreateDefaultBoldFont(_text_size_state));
 //BA.debugLineNum = 405;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return "";
}
public static String  _applyvaluestyleonoff(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _hmitilepane,anywheresoftware.b4a.objects.B4XViewWrapper _statuslabel,boolean _status) throws Exception{
 //BA.debugLineNum = 410;BA.debugLine="Public Sub ApplyValueStyleOnOff(HMITilepane As B4X";
 //BA.debugLineNum = 411;BA.debugLine="If status Then";
if (_status) { 
 //BA.debugLineNum = 412;BA.debugLine="statuslabel.TextColor = COLOR_TEXT_PRIMARY";
_statuslabel.setTextColor(_color_text_primary);
 //BA.debugLineNum = 413;BA.debugLine="HMITilepane.SetColorAndBorder(COLOR_STATUS_ON_BA";
_hmitilepane.SetColorAndBorder(_color_status_on_background,(int) (0),(int) (0),(int) (_border_radius));
 }else {
 //BA.debugLineNum = 415;BA.debugLine="statuslabel.TextColor = COLOR_TEXT_SECONDARY";
_statuslabel.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 416;BA.debugLine="HMITilepane.SetColorAndBorder(COLOR_STATUS_OFF_B";
_hmitilepane.SetColorAndBorder(_color_status_off_background,(int) (0),(int) (0),(int) (_border_radius));
 };
 //BA.debugLineNum = 418;BA.debugLine="End Sub";
return "";
}
public static int  _bytetounsigned(anywheresoftware.b4a.BA _ba,byte _b) throws Exception{
 //BA.debugLineNum = 866;BA.debugLine="Public Sub ByteToUnsigned(b As Byte) As Int";
 //BA.debugLineNum = 867;BA.debugLine="Return Bit.And(0xFF, b)";
if (true) return anywheresoftware.b4a.keywords.Common.Bit.And(((int)0xff),(int) (_b));
 //BA.debugLineNum = 868;BA.debugLine="End Sub";
return 0;
}
public static void  _changebuttontextanimated(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _target,String _newtext) throws Exception{
ResumableSub_ChangeButtonTextAnimated rsub = new ResumableSub_ChangeButtonTextAnimated(null,_ba,_target,_newtext);
rsub.resume((_ba.processBA == null ? _ba : _ba.processBA), null);
}
public static class ResumableSub_ChangeButtonTextAnimated extends BA.ResumableSub {
public ResumableSub_ChangeButtonTextAnimated(b4a.example.hmitileutils parent,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _target,String _newtext) {
this.parent = parent;
this._ba = _ba;
this._target = _target;
this._newtext = _newtext;
}
b4a.example.hmitileutils parent;
anywheresoftware.b4a.BA _ba;
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
 //BA.debugLineNum = 850;BA.debugLine="Dim duration As Int = 240";
_duration = (int) (240);
 //BA.debugLineNum = 852;BA.debugLine="target.SetAlphaAnimated(duration, 0) ' duration i";
_target.SetAlphaAnimated(_duration,(float) (0));
 //BA.debugLineNum = 853;BA.debugLine="Sleep(120)";
anywheresoftware.b4a.keywords.Common.Sleep((_ba.processBA == null ? _ba : _ba.processBA),this,(int) (120));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 855;BA.debugLine="target.Text = newText";
_target.setText(BA.ObjectToCharSequence(_newtext));
 //BA.debugLineNum = 857;BA.debugLine="target.SetAlphaAnimated(duration, 1) ' alpha 1 =";
_target.SetAlphaAnimated(_duration,(float) (1));
 //BA.debugLineNum = 858;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _colortohexargb(anywheresoftware.b4a.BA _ba,int _clr) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 804;BA.debugLine="Public Sub ColorToHexARGB(clr As Int) As String";
 //BA.debugLineNum = 805;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 806;BA.debugLine="Return bc.HexFromBytes(bc.IntsToBytes(Array As In";
if (true) return _bc.HexFromBytes(_bc.IntsToBytes(new int[]{_clr}));
 //BA.debugLineNum = 807;BA.debugLine="End Sub";
return "";
}
public static String  _colortohexrgb(anywheresoftware.b4a.BA _ba,int _clr) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
String _hex = "";
 //BA.debugLineNum = 809;BA.debugLine="Public Sub ColorToHexRGB(clr As Int) As String";
 //BA.debugLineNum = 810;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 811;BA.debugLine="Dim hex As String = bc.HexFromBytes(bc.IntsToByte";
_hex = _bc.HexFromBytes(_bc.IntsToBytes(new int[]{_clr}));
 //BA.debugLineNum = 812;BA.debugLine="Return hex.SubString2(2, hex.Length)";
if (true) return _hex.substring((int) (2),_hex.length());
 //BA.debugLineNum = 813;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.B4XViewWrapper  _copylabelprops(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _src,anywheresoftware.b4a.objects.B4XViewWrapper _dest) throws Exception{
 //BA.debugLineNum = 839;BA.debugLine="Public Sub CopyLabelProps(src As B4XView, dest As";
 //BA.debugLineNum = 840;BA.debugLine="dest.Text = src.Text";
_dest.setText(BA.ObjectToCharSequence(_src.getText()));
 //BA.debugLineNum = 841;BA.debugLine="dest.Font = src.Font";
_dest.setFont(_src.getFont());
 //BA.debugLineNum = 842;BA.debugLine="dest.Color = src.Color";
_dest.setColor(_src.getColor());
 //BA.debugLineNum = 843;BA.debugLine="dest.TextColor = src.TextColor";
_dest.setTextColor(_src.getTextColor());
 //BA.debugLineNum = 844;BA.debugLine="dest.TextSize = src.TextSize";
_dest.setTextSize(_src.getTextSize());
 //BA.debugLineNum = 845;BA.debugLine="Return dest";
if (true) return _dest;
 //BA.debugLineNum = 846;BA.debugLine="End Sub";
return null;
}
public static int  _hextocolor(anywheresoftware.b4a.BA _ba,String _hex) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
byte[] _b = null;
int[] _ints = null;
 //BA.debugLineNum = 791;BA.debugLine="Public Sub HexToColor(hex As String) As Int	'ignor";
 //BA.debugLineNum = 792;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 793;BA.debugLine="If hex.StartsWith(\"#\") Then";
if (_hex.startsWith("#")) { 
 //BA.debugLineNum = 794;BA.debugLine="hex = hex.SubString(1)";
_hex = _hex.substring((int) (1));
 }else if(_hex.startsWith("0x")) { 
 //BA.debugLineNum = 796;BA.debugLine="hex = hex.SubString(2)";
_hex = _hex.substring((int) (2));
 };
 //BA.debugLineNum = 798;BA.debugLine="If hex.Length == 6 Then hex = $\"FF${hex}\"$";
if (_hex.length()==6) { 
_hex = ("FF"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_hex))+"");};
 //BA.debugLineNum = 799;BA.debugLine="Dim b() As Byte = bc.HexToBytes(hex)";
_b = _bc.HexToBytes(_hex);
 //BA.debugLineNum = 800;BA.debugLine="Dim ints() As Int = bc.IntsFromBytes(b)";
_ints = _bc.IntsFromBytes(_b);
 //BA.debugLineNum = 801;BA.debugLine="Return ints(0)";
if (true) return _ints[(int) (0)];
 //BA.debugLineNum = 802;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 52;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 65;BA.debugLine="Public Const TILE_DEFAULT_SIZE 				As Int = 120";
_tile_default_size = (int) (120);
 //BA.debugLineNum = 72;BA.debugLine="Public Const COLOR_BACKGROUND_DEFAULT  		As Int =";
_color_background_default = ((int)0xff2b5267);
 //BA.debugLineNum = 73;BA.debugLine="Public Const COLOR_BACKGROUND_PANEL        	As In";
_color_background_panel = ((int)0xffcccccc);
 //BA.debugLineNum = 74;BA.debugLine="Public Const COLOR_BACKGROUND_SCREEN       	As In";
_color_background_screen = ((int)0xffe6e6e6);
 //BA.debugLineNum = 75;BA.debugLine="Public Const COLOR_BORDER_DEFAULT      		As Int =";
_color_border_default = ((int)0xff5a5a5a);
 //BA.debugLineNum = 76;BA.debugLine="Public Const COLOR_BORDER_DARK         		As Int =";
_color_border_dark = ((int)0xff707070);
 //BA.debugLineNum = 77;BA.debugLine="Public Const COLOR_BACKGROUND_HOVER   	 	As Int =";
_color_background_hover = ((int)0xffbbbbbb);
 //BA.debugLineNum = 78;BA.debugLine="Public Const COLOR_BACKGROUND_DARK   	 	As Int =";
_color_background_dark = ((int)0xff202020);
 //BA.debugLineNum = 79;BA.debugLine="Public Const COLOR_BACKGROUND_SELECTED   	As Int";
_color_background_selected = ((int)0xffc8c8c8);
 //BA.debugLineNum = 80;BA.debugLine="Public Const COLOR_BORDER_DEFAULT           As In";
_color_border_default = ((int)0xffc0c0c0);
 //BA.debugLineNum = 81;BA.debugLine="Public Const COLOR_BORDER_DARK           	As Int";
_color_border_dark = ((int)0xff888888);
 //BA.debugLineNum = 86;BA.debugLine="Public Const COLOR_STATUS_WARNING           As In";
_color_status_warning = ((int)0xffffd24c);
 //BA.debugLineNum = 87;BA.debugLine="Public Const COLOR_STATUS_ALARM_LO          As In";
_color_status_alarm_lo = ((int)0xffffa000);
 //BA.debugLineNum = 88;BA.debugLine="Public Const COLOR_STATUS_ALARM_HI          As In";
_color_status_alarm_hi = ((int)0xffd32f2f);
 //BA.debugLineNum = 89;BA.debugLine="Public Const COLOR_STATUS_FORBIDDEN         As In";
_color_status_forbidden = ((int)0xff7f0000);
 //BA.debugLineNum = 94;BA.debugLine="Public Const COLOR_STATUS_ON_BACKGROUND      As I";
_color_status_on_background = ((int)0xff103030);
 //BA.debugLineNum = 95;BA.debugLine="Public Const COLOR_STATUS_OFF_BACKGROUND     As I";
_color_status_off_background = _color_background_default;
 //BA.debugLineNum = 96;BA.debugLine="Public Const COLOR_STATUS_ON_BORDER          As I";
_color_status_on_border = ((int)0xff202020);
 //BA.debugLineNum = 97;BA.debugLine="Public Const COLOR_STATUS_OFF_BORDER         As I";
_color_status_off_border = ((int)0xff888888);
 //BA.debugLineNum = 98;BA.debugLine="Public Const COLOR_STATUS_TEXT               As I";
_color_status_text = ((int)0xff202020);
 //BA.debugLineNum = 103;BA.debugLine="Public Const COLOR_TEXT_PRIMARY    			As Int = 0x";
_color_text_primary = ((int)0xffffffff);
 //BA.debugLineNum = 104;BA.debugLine="Public Const COLOR_TEXT_SECONDARY  			As Int = 0x";
_color_text_secondary = ((int)0xffdadada);
 //BA.debugLineNum = 105;BA.debugLine="Public Const COLOR_TEXT_DISABLED   			As Int = 0x";
_color_text_disabled = ((int)0xff444444);
 //BA.debugLineNum = 106;BA.debugLine="Public Const COLOR_TEXT_WARNING             As In";
_color_text_warning = ((int)0xff000000);
 //BA.debugLineNum = 107;BA.debugLine="Public Const COLOR_TEXT_ALARM               As In";
_color_text_alarm = ((int)0xffffffff);
 //BA.debugLineNum = 108;BA.debugLine="Public Const COLOR_TEXT_ERROR               As In";
_color_text_error = ((int)0xffffffff);
 //BA.debugLineNum = 113;BA.debugLine="Public Const STATUS_NORMAL          		As String =";
_status_normal = "Normal";
 //BA.debugLineNum = 114;BA.debugLine="Public Const STATUS_WARNING             	As Strin";
_status_warning = "Warning";
 //BA.debugLineNum = 115;BA.debugLine="Public Const STATUS_ALARM            		As String";
_status_alarm = "Alarm";
 //BA.debugLineNum = 116;BA.debugLine="Public Const STATUS_DISABLED            	As Strin";
_status_disabled = "Disabled";
 //BA.debugLineNum = 121;BA.debugLine="Public COLOR_TILE_NORMAL_BACKGROUND   		As Int =";
_color_tile_normal_background = _color_background_default;
 //BA.debugLineNum = 122;BA.debugLine="Public Const COLOR_TILE_NORMAL_TEXT         As In";
_color_tile_normal_text = _color_text_primary;
 //BA.debugLineNum = 124;BA.debugLine="Public Const COLOR_TILE_WARNING_BACKGROUND  As In";
_color_tile_warning_background = _color_status_warning;
 //BA.debugLineNum = 125;BA.debugLine="Public Const COLOR_TILE_WARNING_TEXT        As In";
_color_tile_warning_text = ((int)0xff000000);
 //BA.debugLineNum = 127;BA.debugLine="Public Const COLOR_TILE_ALARM_BACKGROUND    As In";
_color_tile_alarm_background = _color_status_alarm_hi;
 //BA.debugLineNum = 128;BA.debugLine="Public Const COLOR_TILE_ALARM_TEXT          As In";
_color_tile_alarm_text = ((int)0xffffffff);
 //BA.debugLineNum = 130;BA.debugLine="Public Const COLOR_TILE_DISABLED_BACKGROUND As In";
_color_tile_disabled_background = ((int)0xff707070);
 //BA.debugLineNum = 131;BA.debugLine="Public Const COLOR_TILE_DISABLED_TEXT       As In";
_color_tile_disabled_text = _color_text_disabled;
 //BA.debugLineNum = 133;BA.debugLine="Public Const COLOR_TILE_ENABLED_BACKGROUND   As I";
_color_tile_enabled_background = _color_background_dark;
 //BA.debugLineNum = 134;BA.debugLine="Public Const COLOR_TILE_ENABLED_TEXT         As I";
_color_tile_enabled_text = ((int)0xffffffff);
 //BA.debugLineNum = 139;BA.debugLine="Public Const BORDER_WIDTH              		As Doubl";
_border_width = 1;
 //BA.debugLineNum = 140;BA.debugLine="Public Const BORDER_RADIUS             		As Doubl";
_border_radius = 1;
 //BA.debugLineNum = 141;BA.debugLine="Public Const BORDER_RADIUS_LARGE            As Do";
_border_radius_large = 12;
 //BA.debugLineNum = 147;BA.debugLine="Public Const GRID_BASELINE              	As Doubl";
_grid_baseline = 8;
 //BA.debugLineNum = 149;BA.debugLine="Public Const GRID_SPACING              		As Doubl";
_grid_spacing = 16;
 //BA.debugLineNum = 151;BA.debugLine="Public Const GRID_OUTER_SCREEN_EDGE			As Double =";
_grid_outer_screen_edge = 32;
 //BA.debugLineNum = 154;BA.debugLine="Public Const PADDING 						As Int = 4dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4));
 //BA.debugLineNum = 160;BA.debugLine="Public Const TEXT_SIZE_TITLE        		As Float =";
_text_size_title = (float) (16);
 //BA.debugLineNum = 162;BA.debugLine="Public Const TEXT_SIZE_LABEL        		As Float =";
_text_size_label = (float) (16);
 //BA.debugLineNum = 164;BA.debugLine="Public Const TEXT_SIZE_STATE        		As Float =";
_text_size_state = (float) (24);
 //BA.debugLineNum = 166;BA.debugLine="Public Const TEXT_SIZE_SMALL        		As Float =";
_text_size_small = (float) (14);
 //BA.debugLineNum = 168;BA.debugLine="Public Const TEXT_SIZE_TINY         		As Float =";
_text_size_tiny = (float) (12);
 //BA.debugLineNum = 170;BA.debugLine="Public Const TEXT_SIZE_ICON         		As Float =";
_text_size_icon = (float) (32);
 //BA.debugLineNum = 172;BA.debugLine="Public Const TEXT_SIZE_ICON_LARGE         	As Flo";
_text_size_icon_large = (float) (40);
 //BA.debugLineNum = 188;BA.debugLine="Public Const EVENT_COLOR_BG_BASE        As Int =";
_event_color_bg_base = ((int)0xff1f1f1f);
 //BA.debugLineNum = 189;BA.debugLine="Public Const EVENT_COLOR_BG_SELECTED    As Int =";
_event_color_bg_selected = ((int)0xff2b2b2b);
 //BA.debugLineNum = 190;BA.debugLine="Public Const EVENT_COLOR_BG_HOVER       As Int =";
_event_color_bg_hover = ((int)0xff262626);
 //BA.debugLineNum = 191;BA.debugLine="Public Const EVENT_COLOR_BG_DISABLED    As Int =";
_event_color_bg_disabled = ((int)0xff2f2f2f);
 //BA.debugLineNum = 192;BA.debugLine="Public Const EVENT_DIVIDER   			As Int = 0xFF3030";
_event_divider = ((int)0xff303030);
 //BA.debugLineNum = 200;BA.debugLine="Public Const EVENT_COLOR_TEXT			As Int = 0xFFFFFF";
_event_color_text = ((int)0xffffffff);
 //BA.debugLineNum = 211;BA.debugLine="Public Const EVENT_LEVEL_INFO     				As Int = 0";
_event_level_info = (int) (0);
 //BA.debugLineNum = 212;BA.debugLine="Public Const EVENT_LEVEL_WARNING  				As Int = 1";
_event_level_warning = (int) (1);
 //BA.debugLineNum = 213;BA.debugLine="Public Const EVENT_LEVEL_ALARM    				As Int = 2";
_event_level_alarm = (int) (2);
 //BA.debugLineNum = 217;BA.debugLine="Public Const EVENT_COLOR_ICON_INFO      		As Int";
_event_color_icon_info = _color_text_primary;
 //BA.debugLineNum = 218;BA.debugLine="Public Const EVENT_COLOR_ICON_WARNING   		As Int";
_event_color_icon_warning = ((int)0xffffc000);
 //BA.debugLineNum = 219;BA.debugLine="Public Const EVENT_COLOR_ICON_ALARM     		As Int";
_event_color_icon_alarm = ((int)0xffff0000);
 //BA.debugLineNum = 220;BA.debugLine="Public Const EVENT_COLOR_ICON_CRITICAL  		As Int";
_event_color_icon_critical = ((int)0xffff0000);
 //BA.debugLineNum = 221;BA.debugLine="Public Const EVENT_COLOR_ICON_DISABLED  		As Int";
_event_color_icon_disabled = ((int)0xff777777);
 //BA.debugLineNum = 223;BA.debugLine="Public Const EVENT_ICON_INFO 					As String = Chr";
_event_icon_info = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf05a)));
 //BA.debugLineNum = 224;BA.debugLine="Public Const EVENT_ICON_WARNING        			As Stri";
_event_icon_warning = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf071)));
 //BA.debugLineNum = 225;BA.debugLine="Public Const EVENT_ICON_ALARM         			As Strin";
_event_icon_alarm = "🚨";
 //BA.debugLineNum = 226;BA.debugLine="Public Const EVENT_ICON_DISABLED      			As Strin";
_event_icon_disabled = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf00d)));
 //BA.debugLineNum = 229;BA.debugLine="Public Const EVENT_NORMAL_TIMESTAMP_TEXT_SIZE	As";
_event_normal_timestamp_text_size = (float) (13);
 //BA.debugLineNum = 230;BA.debugLine="Public Const EVENT_NORMAL_MESSAGE_TEXT_SIZE   	As";
_event_normal_message_text_size = (float) (15);
 //BA.debugLineNum = 231;BA.debugLine="Public Const EVENT_NORMAL_SOURCE_TEXT_SIZE    	As";
_event_normal_source_text_size = (float) (16);
 //BA.debugLineNum = 233;BA.debugLine="Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As";
_event_normal_icon_text_size = (float) (16);
 //BA.debugLineNum = 238;BA.debugLine="Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As";
_event_normal_icon_text_size = (float) (24);
 //BA.debugLineNum = 241;BA.debugLine="Public Const EVENT_NORMAL_HEIGHT				As Int = 36di";
_event_normal_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (36));
 //BA.debugLineNum = 242;BA.debugLine="Public Const EVENT_NORMAL_HEIGHT_LARGE			As Int =";
_event_normal_height_large = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (54));
 //BA.debugLineNum = 243;BA.debugLine="Public Const EVENT_NORMAL_PADDING 				As Int = 6d";
_event_normal_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (6));
 //BA.debugLineNum = 246;BA.debugLine="Public Const EVENT_COMPACT_TIMESTAMP_TEXT_SIZE 	A";
_event_compact_timestamp_text_size = (float) (10);
 //BA.debugLineNum = 247;BA.debugLine="Public Const EVENT_COMPACT_MESSAGE_TEXT_SIZE   	A";
_event_compact_message_text_size = (float) (12);
 //BA.debugLineNum = 248;BA.debugLine="Public Const EVENT_COMPACT_SOURCE_TEXT_SIZE    	A";
_event_compact_source_text_size = (float) (14);
 //BA.debugLineNum = 250;BA.debugLine="Public Const EVENT_COMPACT_ICON_TEXT_SIZE      	A";
_event_compact_icon_text_size = (float) (14);
 //BA.debugLineNum = 257;BA.debugLine="Public Const EVENT_COMPACT_HEIGHT				As Int = 24d";
_event_compact_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24));
 //BA.debugLineNum = 258;BA.debugLine="Public Const EVENT_COMPACT_PADDING 				As Int = 4";
_event_compact_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4));
 //BA.debugLineNum = 261;BA.debugLine="Public Const EVENT_TITLE_HEIGHT As Int = 32dip";
_event_title_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32));
 //BA.debugLineNum = 268;BA.debugLine="Public Const LIST_COLOR_BG_BASE              	As";
_list_color_bg_base = ((int)0xfff5f5f5);
 //BA.debugLineNum = 270;BA.debugLine="Public Const LIST_COLOR_BG_ITEM              	As";
_list_color_bg_item = ((int)0xffffffff);
 //BA.debugLineNum = 272;BA.debugLine="Public Const LIST_COLOR_BG_SELECTED          	As";
_list_color_bg_selected = ((int)0xffd0d0d0);
 //BA.debugLineNum = 274;BA.debugLine="Public Const LIST_COLOR_BG_HOVER             	As";
_list_color_bg_hover = ((int)0xffeaeaea);
 //BA.debugLineNum = 276;BA.debugLine="Public Const LIST_COLOR_BG_DISABLED          	As";
_list_color_bg_disabled = ((int)0xffe0e0e0);
 //BA.debugLineNum = 278;BA.debugLine="Public Const LIST_DIVIDER                    	As";
_list_divider = ((int)0xffcccccc);
 //BA.debugLineNum = 280;BA.debugLine="Public Const LIST_COLOR_TEXT                 	As";
_list_color_text = ((int)0xff202020);
 //BA.debugLineNum = 281;BA.debugLine="Public Const LIST_COLOR_TEXT_DISABLED        	As";
_list_color_text_disabled = ((int)0xff909090);
 //BA.debugLineNum = 283;BA.debugLine="Public Const LIST_TITLE_HEIGHT As Int = 32dip";
_list_title_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32));
 //BA.debugLineNum = 285;BA.debugLine="Public Const LIST_NORMAL_HEIGHT 				As Int = 48di";
_list_normal_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48));
 //BA.debugLineNum = 286;BA.debugLine="Public Const LIST_NORMAL_PADDING 				As Int = 12d";
_list_normal_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12));
 //BA.debugLineNum = 287;BA.debugLine="Public Const LIST_NORMAL_PRIMARY_TEXT_SIZE 		As F";
_list_normal_primary_text_size = (float) (16);
 //BA.debugLineNum = 288;BA.debugLine="Public Const LIST_NORMAL_SECONDARY_TEXT_SIZE	As F";
_list_normal_secondary_text_size = (float) (13);
 //BA.debugLineNum = 289;BA.debugLine="Public Const LIST_COMPACT_HEIGHT 				As Int = 34d";
_list_compact_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (34));
 //BA.debugLineNum = 290;BA.debugLine="Public Const LIST_COMPACT_PADDING 				As Int = 7d";
_list_compact_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (7));
 //BA.debugLineNum = 291;BA.debugLine="Public Const LIST_COMPACT_PRIMARY_TEXT_SIZE 	As F";
_list_compact_primary_text_size = (float) (14);
 //BA.debugLineNum = 292;BA.debugLine="Public Const LIST_COMPACT_SECONDARY_TEXT_SIZE 	As";
_list_compact_secondary_text_size = (float) (11);
 //BA.debugLineNum = 297;BA.debugLine="Public Const COLOR_SLIDER_TRACK            		As I";
_color_slider_track = ((int)0xffffffff);
 //BA.debugLineNum = 298;BA.debugLine="Public Const COLOR_SLIDER_ACTIVE           		As I";
_color_slider_active = ((int)0xffb8b8b8);
 //BA.debugLineNum = 299;BA.debugLine="Public Const COLOR_SLIDER_KNOB             		As I";
_color_slider_knob = ((int)0xff4a4a4a);
 //BA.debugLineNum = 300;BA.debugLine="Public Const COLOR_SLIDER_DISABLED_TRACK   		As I";
_color_slider_disabled_track = ((int)0xffe0e0e0);
 //BA.debugLineNum = 301;BA.debugLine="Public Const COLOR_SLIDER_DISABLED_KNOB    		As I";
_color_slider_disabled_knob = ((int)0xffa8a8a8);
 //BA.debugLineNum = 302;BA.debugLine="Public Const COLOR_SLIDER_VALUE_TEXT       		As I";
_color_slider_value_text = ((int)0xff2a2a2a);
 //BA.debugLineNum = 303;BA.debugLine="Public Const COLOR_SLIDER_LABEL_TEXT       		As I";
_color_slider_label_text = _color_text_secondary;
 //BA.debugLineNum = 304;BA.debugLine="Public Const COLOR_SLIDER_UNIT_TEXT        		As I";
_color_slider_unit_text = ((int)0xff3a3a3a);
 //BA.debugLineNum = 305;BA.debugLine="Public Const COLOR_SLIDER_KNOB_BORDER			As Int =";
_color_slider_knob_border = ((int)0xff2f2f2f);
 //BA.debugLineNum = 310;BA.debugLine="Public Const COLOR_TREND_LINE     				As Int = 0x";
_color_trend_line = ((int)0xff404040);
 //BA.debugLineNum = 311;BA.debugLine="Public Const COLOR_TREND_BG       				As Int = 0x";
_color_trend_bg = ((int)0xfff5f5f5);
 //BA.debugLineNum = 312;BA.debugLine="Public Const COLOR_TREND_BORDER   				As Int = 0x";
_color_trend_border = ((int)0xffb0b0b0);
 //BA.debugLineNum = 317;BA.debugLine="Public Const NAV_SELECT_TYPE_PAGE 				As String =";
_nav_select_type_page = "Page";
 //BA.debugLineNum = 318;BA.debugLine="Public Const NAV_SELECT_TYPE_BACK 				As String =";
_nav_select_type_back = "Back";
 //BA.debugLineNum = 319;BA.debugLine="Public Const NAV_ICON_BACK 						As String = Chr(";
_nav_icon_back = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf060)));
 //BA.debugLineNum = 324;BA.debugLine="Public Const COLOR_INDICATOR_TRUE_DEFAULT 		As In";
_color_indicator_true_default = ((int)0xffe8e8e8);
 //BA.debugLineNum = 325;BA.debugLine="Public Const COLOR_INDICATOR_FALSE_DEFAULT 		As I";
_color_indicator_false_default = ((int)0xff323232);
 //BA.debugLineNum = 326;BA.debugLine="Public Const COLOR_INDICATOR_DISABLED_DEFAULT 	As";
_color_indicator_disabled_default = ((int)0xff808080);
 //BA.debugLineNum = 327;BA.debugLine="Public Const COLOR_INDICATOR_TRUE_GREEN 		As Int";
_color_indicator_true_green = ((int)0xff00ff00);
 //BA.debugLineNum = 328;BA.debugLine="Public Const COLOR_INDICATOR_FALSE_RED 			As Int";
_color_indicator_false_red = ((int)0xffff0000);
 //BA.debugLineNum = 329;BA.debugLine="Public Const COLOR_TEXT_INDICATOR_TRUE			As Int =";
_color_text_indicator_true = ((int)0xff000000);
 //BA.debugLineNum = 330;BA.debugLine="Public Const COLOR_TEXT_INDICATOR_FALSE			As Int";
_color_text_indicator_false = ((int)0xffffffff);
 //BA.debugLineNum = 331;BA.debugLine="Public Const TEXT_INDICATOR_TRUE				As String = \"";
_text_indicator_true = "OK";
 //BA.debugLineNum = 332;BA.debugLine="Public Const TEXT_INDICATOR_FALSE				As String =";
_text_indicator_false = "ERROR";
 //BA.debugLineNum = 333;BA.debugLine="Public Const TEXT_INDICATOR_DISABLED			As String";
_text_indicator_disabled = "Disabled";
 //BA.debugLineNum = 338;BA.debugLine="Public ICON_ON 									As String = Chr(0xF205)";
_icon_on = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf205)));
 //BA.debugLineNum = 339;BA.debugLine="Public ICON_OFF 								As String = Chr(0xF204)";
_icon_off = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf204)));
 //BA.debugLineNum = 340;BA.debugLine="Public ICON_REFRESH 							As String = Chr(0xF021";
_icon_refresh = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf021)));
 //BA.debugLineNum = 341;BA.debugLine="Public ICON_STOP_HAND							As String = Chr(0xF25";
_icon_stop_hand = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf256)));
 //BA.debugLineNum = 342;BA.debugLine="Public ICON_STOP								As String = Chr(0xF04D)";
_icon_stop = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf04d)));
 //BA.debugLineNum = 343;BA.debugLine="Public ICON_STOP_CIRCLE							As String = Chr(0xF";
_icon_stop_circle = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf28d)));
 //BA.debugLineNum = 344;BA.debugLine="Public ICON_WAIT								As String = Chr(0xF252)";
_icon_wait = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf252)));
 //BA.debugLineNum = 350;BA.debugLine="Public ByteConv As ByteConverter";
_byteconv = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public static String  _setalltilesbackgroundcolor(anywheresoftware.b4a.BA _ba,int _clr) throws Exception{
 //BA.debugLineNum = 527;BA.debugLine="Public Sub SetAllTilesBackgroundColor(clr As Int)";
 //BA.debugLineNum = 528;BA.debugLine="COLOR_TILE_NORMAL_BACKGROUND = clr";
_color_tile_normal_background = _clr;
 //BA.debugLineNum = 529;BA.debugLine="End Sub";
return "";
}
public static float  _setalpha(anywheresoftware.b4a.BA _ba,boolean _enabled) throws Exception{
 //BA.debugLineNum = 608;BA.debugLine="Public Sub SetAlpha(enabled As Boolean) As Float";
 //BA.debugLineNum = 609;BA.debugLine="Return IIf(enabled, 1, 0.4)";
if (true) return (float)(BA.ObjectToNumber(((_enabled) ? ((Object)(1)) : ((Object)(0.4)))));
 //BA.debugLineNum = 610;BA.debugLine="End Sub";
return 0f;
}
public static String  _setbatterystateicon(anywheresoftware.b4a.BA _ba,int _value) throws Exception{
String _bat_warn = "";
String _bat_empty = "";
String _bat_quarter = "";
String _bat_half = "";
String _bat_three_quarters = "";
String _bat_full = "";
 //BA.debugLineNum = 709;BA.debugLine="Public Sub SetBatteryStateIcon(value As Int) As St";
 //BA.debugLineNum = 710;BA.debugLine="Private BAT_WARN As String = Chr(0xF071)";
_bat_warn = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf071)));
 //BA.debugLineNum = 711;BA.debugLine="Private BAT_EMPTY As String = Chr(0xF244)";
_bat_empty = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf244)));
 //BA.debugLineNum = 712;BA.debugLine="Private BAT_QUARTER As String = Chr(0xF243)";
_bat_quarter = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf243)));
 //BA.debugLineNum = 713;BA.debugLine="Private BAT_HALF As String = Chr(0xF242)";
_bat_half = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf242)));
 //BA.debugLineNum = 714;BA.debugLine="Private BAT_THREE_QUARTERS As String = Chr(0xF241";
_bat_three_quarters = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf241)));
 //BA.debugLineNum = 715;BA.debugLine="Private BAT_FULL As String = Chr(0xF240)";
_bat_full = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf240)));
 //BA.debugLineNum = 717;BA.debugLine="If value <= 0 Then";
if (_value<=0) { 
 //BA.debugLineNum = 718;BA.debugLine="Return BAT_EMPTY";
if (true) return _bat_empty;
 };
 //BA.debugLineNum = 720;BA.debugLine="If value > 0 And value <= 25 Then";
if (_value>0 && _value<=25) { 
 //BA.debugLineNum = 721;BA.debugLine="Return BAT_QUARTER";
if (true) return _bat_quarter;
 };
 //BA.debugLineNum = 723;BA.debugLine="If value > 25 And value <= 50 Then";
if (_value>25 && _value<=50) { 
 //BA.debugLineNum = 724;BA.debugLine="Return BAT_HALF";
if (true) return _bat_half;
 };
 //BA.debugLineNum = 726;BA.debugLine="If value > 50 And value <= 75 Then";
if (_value>50 && _value<=75) { 
 //BA.debugLineNum = 727;BA.debugLine="Return BAT_THREE_QUARTERS";
if (true) return _bat_three_quarters;
 };
 //BA.debugLineNum = 729;BA.debugLine="If value > 75 Then";
if (_value>75) { 
 //BA.debugLineNum = 730;BA.debugLine="Return BAT_FULL";
if (true) return _bat_full;
 };
 //BA.debugLineNum = 732;BA.debugLine="Return BAT_WARN";
if (true) return _bat_warn;
 //BA.debugLineNum = 733;BA.debugLine="End Sub";
return "";
}
public static String  _setclvbackgroundtransparent(anywheresoftware.b4a.BA _ba,b4a.example3.customlistview _clv) throws Exception{
 //BA.debugLineNum = 563;BA.debugLine="Public Sub SetCLVBackgroundTransparent(clv As Cust";
 //BA.debugLineNum = 573;BA.debugLine="End Sub";
return "";
}
public static String  _setclvscrollbars(anywheresoftware.b4a.BA _ba,b4a.example3.customlistview _clv,boolean _visible) throws Exception{
 //BA.debugLineNum = 586;BA.debugLine="Public Sub SetCLVScrollBars(clv As CustomListView,";
 //BA.debugLineNum = 598;BA.debugLine="End Sub";
return "";
}
public static String  _setcomfortstate(anywheresoftware.b4a.BA _ba,double _t,int _h) throws Exception{
 //BA.debugLineNum = 752;BA.debugLine="Public Sub SetComfortState(t As Double, h As Int)";
 //BA.debugLineNum = 757;BA.debugLine="If h < 30 Then Return \"Very Dry\"";
if (_h<30) { 
if (true) return "Very Dry";};
 //BA.debugLineNum = 758;BA.debugLine="If h > 70 Then Return \"Very Humid\"";
if (_h>70) { 
if (true) return "Very Humid";};
 //BA.debugLineNum = 761;BA.debugLine="If t < 18 Then Return \"Too Cold\"";
if (_t<18) { 
if (true) return "Too Cold";};
 //BA.debugLineNum = 762;BA.debugLine="If t > 26 Then Return \"Too Hot\"";
if (_t>26) { 
if (true) return "Too Hot";};
 //BA.debugLineNum = 765;BA.debugLine="If t >= 20 And t <= 24 And h >= 40 And h <= 60 Th";
if (_t>=20 && _t<=24 && _h>=40 && _h<=60) { 
 //BA.debugLineNum = 766;BA.debugLine="Return \"Comfortable\"";
if (true) return "Comfortable";
 };
 //BA.debugLineNum = 769;BA.debugLine="If t < 20 Then";
if (_t<20) { 
 //BA.debugLineNum = 770;BA.debugLine="If h < 40 Then Return \"Cold & Dry\"";
if (_h<40) { 
if (true) return "Cold & Dry";};
 //BA.debugLineNum = 771;BA.debugLine="If h > 60 Then Return \"Cold & Humid\"";
if (_h>60) { 
if (true) return "Cold & Humid";};
 };
 //BA.debugLineNum = 774;BA.debugLine="If t > 24 Then";
if (_t>24) { 
 //BA.debugLineNum = 775;BA.debugLine="If h < 40 Then Return \"Hot & Dry\"";
if (_h<40) { 
if (true) return "Hot & Dry";};
 //BA.debugLineNum = 776;BA.debugLine="If h > 60 Then Return \"Hot & Humid\"";
if (_h>60) { 
if (true) return "Hot & Humid";};
 };
 //BA.debugLineNum = 779;BA.debugLine="Return \"Moderate\"";
if (true) return "Moderate";
 //BA.debugLineNum = 780;BA.debugLine="End Sub";
return "";
}
public static String  _settextcolor(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _lbl,int _col) throws Exception{
 //BA.debugLineNum = 835;BA.debugLine="Public Sub SetTextColor(lbl As B4XView, col As Int";
 //BA.debugLineNum = 836;BA.debugLine="If lbl.IsInitialized Then lbl.TextColor = col";
if (_lbl.IsInitialized()) { 
_lbl.setTextColor(_col);};
 //BA.debugLineNum = 837;BA.debugLine="End Sub";
return "";
}
public static String  _settextcolorcrossplatform(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _v,String _colorhex) throws Exception{
 //BA.debugLineNum = 826;BA.debugLine="Public Sub SetTextColorCrossPlatform(v As B4XView,";
 //BA.debugLineNum = 830;BA.debugLine="v.TextColor = HexToColor(colorHex)";
_v.setTextColor(_hextocolor(_ba,_colorhex));
 //BA.debugLineNum = 832;BA.debugLine="End Sub";
return "";
}
public static int  _statustoint(anywheresoftware.b4a.BA _ba,String _status) throws Exception{
int _result = 0;
 //BA.debugLineNum = 537;BA.debugLine="Public Sub StatusToInt(status As String) As Int";
 //BA.debugLineNum = 538;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 539;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,_status_normal,_status_warning,_status_alarm,_status_disabled)) {
case 0: {
 //BA.debugLineNum = 541;BA.debugLine="result = 0";
_result = (int) (0);
 break; }
case 1: {
 //BA.debugLineNum = 543;BA.debugLine="result = 1";
_result = (int) (1);
 break; }
case 2: {
 //BA.debugLineNum = 545;BA.debugLine="result = 2";
_result = (int) (2);
 break; }
case 3: {
 //BA.debugLineNum = 547;BA.debugLine="result = 3";
_result = (int) (3);
 break; }
default: {
 //BA.debugLineNum = 549;BA.debugLine="result = -1";
_result = (int) (-1);
 break; }
}
;
 //BA.debugLineNum = 551;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 552;BA.debugLine="End Sub";
return 0;
}
}
