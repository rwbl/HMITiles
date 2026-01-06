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
public static int _color_state_on_background = 0;
public static int _color_state_off_background = 0;
public static int _color_state_on_border = 0;
public static int _color_state_off_border = 0;
public static int _color_state_text = 0;
public static int _color_text_primary = 0;
public static int _color_text_secondary = 0;
public static int _color_text_disabled = 0;
public static int _color_text_warning = 0;
public static int _color_text_alarm = 0;
public static int _color_text_error = 0;
public static int _state_normal = 0;
public static int _state_warning = 0;
public static int _state_alarm = 0;
public static int _state_disabled = 0;
public static String _typestyle_normal = "";
public static String _typestyle_warning = "";
public static String _typestyle_alarm = "";
public static String _typestyle_disabled = "";
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
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _byteconv = null;
public static b4j.example.dateutils _dateutils = null;
public static b4j.example.cssutils _cssutils = null;
public static b4j.example.main _main = null;
public static b4j.example.convert _convert = null;
public static b4j.example.b4xpages _b4xpages = null;
public static b4j.example.b4xcollections _b4xcollections = null;
public static b4j.example.xuiviewsutils _xuiviewsutils = null;
public static String  _applyfontawesomestyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 456;BA.debugLine="Public Sub ApplyFontAwesomeStyle(lbl As B4XView)";
 //BA.debugLineNum = 457;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 459;BA.debugLine="lbl.TextSize = TEXT_SIZE_STATE  ' TEXT_SIZE_ICON";
_lbl.setTextSize(_text_size_state);
 //BA.debugLineNum = 460;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 467;BA.debugLine="End Sub";
return "";
}
public static String  _applyiconstyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 443;BA.debugLine="Public Sub ApplyIconStyle(lbl As B4XView)";
 //BA.debugLineNum = 444;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 446;BA.debugLine="lbl.TextSize = TEXT_SIZE_ICON";
_lbl.setTextSize(_text_size_icon);
 //BA.debugLineNum = 447;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 };
 //BA.debugLineNum = 454;BA.debugLine="End Sub";
return "";
}
public static String  _applylabelstyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 400;BA.debugLine="Public Sub ApplyLabelStyle(lbl As B4XView)";
 //BA.debugLineNum = 401;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 403;BA.debugLine="lbl.TextSize = TEXT_SIZE_LABEL";
_lbl.setTextSize(_text_size_label);
 //BA.debugLineNum = 404;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 405;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 412;BA.debugLine="End Sub";
return "";
}
public static String  _applystylestateonoff(anywheresoftware.b4a.objects.B4XViewWrapper _hmitilepane,anywheresoftware.b4a.objects.B4XViewWrapper _statelabel,boolean _state) throws Exception{
 //BA.debugLineNum = 358;BA.debugLine="Public Sub ApplyStyleStateOnOff(HMITilepane As B4X";
 //BA.debugLineNum = 359;BA.debugLine="If state Then";
if (_state) { 
 //BA.debugLineNum = 360;BA.debugLine="statelabel.TextColor = COLOR_TEXT_PRIMARY";
_statelabel.setTextColor(_color_text_primary);
 //BA.debugLineNum = 361;BA.debugLine="HMITilepane.SetColorAndBorder(COLOR_STATE_ON_BAC";
_hmitilepane.SetColorAndBorder(_color_state_on_background,0,(int) (0),_border_radius);
 }else {
 //BA.debugLineNum = 363;BA.debugLine="statelabel.TextColor = COLOR_TEXT_SECONDARY";
_statelabel.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 364;BA.debugLine="HMITilepane.SetColorAndBorder(COLOR_STATE_OFF_BA";
_hmitilepane.SetColorAndBorder(_color_state_off_background,0,(int) (0),_border_radius);
 };
 //BA.debugLineNum = 366;BA.debugLine="End Sub";
return "";
}
public static String  _applystyletitle(anywheresoftware.b4a.objects.B4XViewWrapper _hmitilepane,anywheresoftware.b4a.objects.B4XViewWrapper _titlelabel,String _hmitilestate) throws Exception{
int _state = 0;
 //BA.debugLineNum = 333;BA.debugLine="Public Sub ApplyStyleTitle(HMITilepane As B4XView,";
 //BA.debugLineNum = 334;BA.debugLine="titlelabel.TextColor = COLOR_TEXT_SECONDARY";
_titlelabel.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 335;BA.debugLine="titlelabel.TextSize = TEXT_SIZE_TITLE";
_titlelabel.setTextSize(_text_size_title);
 //BA.debugLineNum = 337;BA.debugLine="Dim state As Int = StateStyleToState(HMITilestate";
_state = _statestyletostate(_hmitilestate);
 //BA.debugLineNum = 338;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_state_normal,_state_warning,_state_alarm,_state_disabled)) {
case 0: {
 //BA.debugLineNum = 340;BA.debugLine="HMITilepane.Color = COLOR_TILE_NORMAL_BACKGROUN";
_hmitilepane.setColor(_color_tile_normal_background);
 break; }
case 1: {
 //BA.debugLineNum = 343;BA.debugLine="HMITilepane.Color = COLOR_TILE_WARNING_BACKGROU";
_hmitilepane.setColor(_color_tile_warning_background);
 break; }
case 2: {
 //BA.debugLineNum = 346;BA.debugLine="HMITilepane.Color = COLOR_TILE_ALARM_BACKGROUND";
_hmitilepane.setColor(_color_tile_alarm_background);
 break; }
case 3: {
 //BA.debugLineNum = 349;BA.debugLine="HMITilepane.Color = COLOR_TILE_DISABLED_BACKGRO";
_hmitilepane.setColor(_color_tile_disabled_background);
 break; }
}
;
 //BA.debugLineNum = 352;BA.debugLine="HMITilepane.SetColorAndBorder(HMITilepane.Color,";
_hmitilepane.SetColorAndBorder(_hmitilepane.getColor(),_border_width,_color_state_on_border,_border_radius);
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return "";
}
public static String  _applysubinfostyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 428;BA.debugLine="Public Sub ApplySubInfoStyle(lbl As B4XView)";
 //BA.debugLineNum = 429;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 431;BA.debugLine="CSSUtils.SetStyleProperty(lbl, \"-fx-font-size\",";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),"-fx-font-size",BA.NumberToString(_text_size_tiny));
 //BA.debugLineNum = 433;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 434;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 441;BA.debugLine="End Sub";
return "";
}
public static String  _applytitlestyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 372;BA.debugLine="Public Sub ApplyTitleStyle(lbl As B4XView)";
 //BA.debugLineNum = 373;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 375;BA.debugLine="lbl.TextSize = TEXT_SIZE_TITLE";
_lbl.setTextSize(_text_size_title);
 //BA.debugLineNum = 376;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 //BA.debugLineNum = 377;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 384;BA.debugLine="End Sub";
return "";
}
public static String  _applyunitstyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 414;BA.debugLine="Public Sub ApplyUnitStyle(lbl As B4XView)";
 //BA.debugLineNum = 415;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 417;BA.debugLine="lbl.TextSize = TEXT_SIZE_SMALL";
_lbl.setTextSize(_text_size_small);
 //BA.debugLineNum = 418;BA.debugLine="lbl.TextColor = COLOR_TEXT_SECONDARY";
_lbl.setTextColor(_color_text_secondary);
 //BA.debugLineNum = 419;BA.debugLine="SetStyleBold(lbl, False)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 426;BA.debugLine="End Sub";
return "";
}
public static String  _applyvaluestyle(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 386;BA.debugLine="Public Sub ApplyValueStyle(lbl As B4XView)";
 //BA.debugLineNum = 387;BA.debugLine="If lbl.IsInitialized Then";
if (_lbl.IsInitialized()) { 
 //BA.debugLineNum = 389;BA.debugLine="lbl.TextSize = TEXT_SIZE_STATE";
_lbl.setTextSize(_text_size_state);
 //BA.debugLineNum = 390;BA.debugLine="lbl.TextColor = COLOR_TEXT_PRIMARY";
_lbl.setTextColor(_color_text_primary);
 //BA.debugLineNum = 391;BA.debugLine="SetStyleBold(lbl, True)";
_setstylebold((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 398;BA.debugLine="End Sub";
return "";
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
 //BA.debugLineNum = 549;BA.debugLine="Dim duration As Int = 240";
_duration = (int) (240);
 //BA.debugLineNum = 551;BA.debugLine="target.SetAlphaAnimated(duration, 0) ' duration i";
_target.SetAlphaAnimated(_duration,(float) (0));
 //BA.debugLineNum = 552;BA.debugLine="Sleep(120)";
anywheresoftware.b4a.keywords.Common.Sleep(ba,this,(int) (120));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 554;BA.debugLine="target.Text = newText";
_target.setText(_newtext);
 //BA.debugLineNum = 556;BA.debugLine="target.SetAlphaAnimated(duration, 1) ' alpha 1 =";
_target.SetAlphaAnimated(_duration,(float) (1));
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _colortohexargb(int _clr) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 516;BA.debugLine="Public Sub ColorToHexARGB(clr As Int) As String";
 //BA.debugLineNum = 517;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 518;BA.debugLine="Return bc.HexFromBytes(bc.IntsToBytes(Array As In";
if (true) return _bc.HexFromBytes(_bc.IntsToBytes(new int[]{_clr}));
 //BA.debugLineNum = 519;BA.debugLine="End Sub";
return "";
}
public static String  _colortohexrgb(int _clr) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
String _hex = "";
 //BA.debugLineNum = 521;BA.debugLine="Public Sub ColorToHexRGB(clr As Int) As String";
 //BA.debugLineNum = 522;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 523;BA.debugLine="Dim hex As String = bc.HexFromBytes(bc.IntsToByte";
_hex = _bc.HexFromBytes(_bc.IntsToBytes(new int[]{_clr}));
 //BA.debugLineNum = 524;BA.debugLine="Return hex.SubString2(2, hex.Length)";
if (true) return _hex.substring((int) (2),_hex.length());
 //BA.debugLineNum = 525;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4j.objects.JFX.PaintWrapper  _colorxuitofx(int _value) throws Exception{
 //BA.debugLineNum = 528;BA.debugLine="Public Sub ColorXUIToFX(value As Int) As Paint";
 //BA.debugLineNum = 529;BA.debugLine="Return fx.Colors.From32Bit(xui.Color_White)";
if (true) return (anywheresoftware.b4j.objects.JFX.PaintWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.JFX.PaintWrapper(), (javafx.scene.paint.Paint)(_fx.Colors.From32Bit(_xui.Color_White)));
 //BA.debugLineNum = 530;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.B4XViewWrapper  _copylabelprops(anywheresoftware.b4a.objects.B4XViewWrapper _src,anywheresoftware.b4a.objects.B4XViewWrapper _dest) throws Exception{
 //BA.debugLineNum = 538;BA.debugLine="Public Sub CopyLabelProps(src As B4XView, dest As";
 //BA.debugLineNum = 539;BA.debugLine="dest.Text = src.Text";
_dest.setText(_src.getText());
 //BA.debugLineNum = 540;BA.debugLine="dest.Font = src.Font";
_dest.setFont(_src.getFont());
 //BA.debugLineNum = 541;BA.debugLine="dest.Color = src.Color";
_dest.setColor(_src.getColor());
 //BA.debugLineNum = 542;BA.debugLine="dest.TextColor = src.TextColor";
_dest.setTextColor(_src.getTextColor());
 //BA.debugLineNum = 543;BA.debugLine="dest.TextSize = src.TextSize";
_dest.setTextSize(_src.getTextSize());
 //BA.debugLineNum = 544;BA.debugLine="Return dest";
if (true) return _dest;
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return null;
}
public static String  _disablehmitilegrid() throws Exception{
 //BA.debugLineNum = 645;BA.debugLine="Public Sub DisableHMITileGrid";
 //BA.debugLineNum = 646;BA.debugLine="If Not(HMITileGrid.IsInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_hmitilegrid.IsInitialized /*boolean*/ ())) { 
 //BA.debugLineNum = 647;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 649;BA.debugLine="HMITileGrid.ShowGrid = False";
_hmitilegrid._showgrid /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 650;BA.debugLine="HMITileGrid.Redraw";
_hmitilegrid._redraw /*String*/ ();
 //BA.debugLineNum = 651;BA.debugLine="End Sub";
return "";
}
public static String  _enablehmitilegrid(anywheresoftware.b4a.objects.B4XViewWrapper _parent) throws Exception{
 //BA.debugLineNum = 636;BA.debugLine="Public Sub EnableHMITileGrid(parent As B4XView)";
 //BA.debugLineNum = 637;BA.debugLine="If Not(HMITileGrid.IsInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_hmitilegrid.IsInitialized /*boolean*/ ())) { 
 //BA.debugLineNum = 638;BA.debugLine="HMITileGrid.Initialize(parent)";
_hmitilegrid._initialize /*String*/ (ba,_parent);
 };
 //BA.debugLineNum = 640;BA.debugLine="HMITileGrid.Resize";
_hmitilegrid._resize /*String*/ ();
 //BA.debugLineNum = 641;BA.debugLine="HMITileGrid.ShowGrid = True";
_hmitilegrid._showgrid /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 642;BA.debugLine="HMITileGrid.Redraw";
_hmitilegrid._redraw /*String*/ ();
 //BA.debugLineNum = 643;BA.debugLine="End Sub";
return "";
}
public static boolean  _getstylebold(anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper _node) throws Exception{
String _property = "";
 //BA.debugLineNum = 480;BA.debugLine="Public Sub GetStyleBold(node As Node) As Boolean";
 //BA.debugLineNum = 481;BA.debugLine="Dim property As String = CSSUtils.GetStylePropert";
_property = _cssutils._getstyleproperty(_node,"-fx-font-weight");
 //BA.debugLineNum = 482;BA.debugLine="Return property == \"bold\"";
if (true) return (_property).equals("bold");
 //BA.debugLineNum = 483;BA.debugLine="End Sub";
return false;
}
public static double  _getstyleborderradius(anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper _node) throws Exception{
String _s = "";
 //BA.debugLineNum = 487;BA.debugLine="Public Sub GetStyleBorderRadius(node As Node) As D";
 //BA.debugLineNum = 488;BA.debugLine="Dim s As String = CSSUtils.GetStyleProperty(node,";
_s = _cssutils._getstyleproperty(_node,"-fx-border-radius");
 //BA.debugLineNum = 489;BA.debugLine="If s.Length == 0 Then";
if (_s.length()==0) { 
 //BA.debugLineNum = 490;BA.debugLine="Return BORDER_RADIUS";
if (true) return _border_radius;
 }else {
 //BA.debugLineNum = 492;BA.debugLine="Return s";
if (true) return (double)(Double.parseDouble(_s));
 };
 //BA.debugLineNum = 494;BA.debugLine="End Sub";
return 0;
}
public static int  _hextocolor(String _hex) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
byte[] _b = null;
int[] _ints = null;
 //BA.debugLineNum = 503;BA.debugLine="Public Sub HexToColor(hex As String) As Int	'ignor";
 //BA.debugLineNum = 504;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 505;BA.debugLine="If hex.StartsWith(\"#\") Then";
if (_hex.startsWith("#")) { 
 //BA.debugLineNum = 506;BA.debugLine="hex = hex.SubString(1)";
_hex = _hex.substring((int) (1));
 }else if(_hex.startsWith("0x")) { 
 //BA.debugLineNum = 508;BA.debugLine="hex = hex.SubString(2)";
_hex = _hex.substring((int) (2));
 };
 //BA.debugLineNum = 510;BA.debugLine="If hex.Length == 6 Then hex = $\"FF${hex}\"$";
if (_hex.length()==6) { 
_hex = ("FF"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_hex))+"");};
 //BA.debugLineNum = 511;BA.debugLine="Dim b() As Byte = bc.HexToBytes(hex)";
_b = _bc.HexToBytes(_hex);
 //BA.debugLineNum = 512;BA.debugLine="Dim ints() As Int = bc.IntsFromBytes(b)";
_ints = _bc.IntsFromBytes(_b);
 //BA.debugLineNum = 513;BA.debugLine="Return ints(0)";
if (true) return _ints[(int) (0)];
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 65;BA.debugLine="Public Const TILE_DEFAULT_SIZE As Int = 120";
_tile_default_size = (int) (120);
 //BA.debugLineNum = 71;BA.debugLine="Public Const COLOR_BACKGROUND_DEFAULT  		As Int =";
_color_background_default = ((int)0xff2b5267);
 //BA.debugLineNum = 72;BA.debugLine="Public Const COLOR_BACKGROUND_PANEL        	As In";
_color_background_panel = ((int)0xffcccccc);
 //BA.debugLineNum = 73;BA.debugLine="Public Const COLOR_BACKGROUND_SCREEN       	As In";
_color_background_screen = ((int)0xffe6e6e6);
 //BA.debugLineNum = 74;BA.debugLine="Public Const COLOR_BORDER_DEFAULT      		As Int =";
_color_border_default = ((int)0xff5a5a5a);
 //BA.debugLineNum = 75;BA.debugLine="Public Const COLOR_BORDER_DARK         		As Int =";
_color_border_dark = ((int)0xff707070);
 //BA.debugLineNum = 76;BA.debugLine="Public Const COLOR_BACKGROUND_HOVER   	 	As Int =";
_color_background_hover = ((int)0xffbbbbbb);
 //BA.debugLineNum = 77;BA.debugLine="Public Const COLOR_BACKGROUND_DARK   	 	As Int =";
_color_background_dark = ((int)0xff202020);
 //BA.debugLineNum = 78;BA.debugLine="Public Const COLOR_BACKGROUND_SELECTED   	As Int";
_color_background_selected = ((int)0xffc8c8c8);
 //BA.debugLineNum = 79;BA.debugLine="Public Const COLOR_BORDER_DEFAULT           As In";
_color_border_default = ((int)0xffc0c0c0);
 //BA.debugLineNum = 80;BA.debugLine="Public Const COLOR_BORDER_DARK           	As Int";
_color_border_dark = ((int)0xff888888);
 //BA.debugLineNum = 85;BA.debugLine="Public Const COLOR_STATUS_WARNING           As In";
_color_status_warning = ((int)0xffffd24c);
 //BA.debugLineNum = 86;BA.debugLine="Public Const COLOR_STATUS_ALARM_LO          As In";
_color_status_alarm_lo = ((int)0xffffa000);
 //BA.debugLineNum = 87;BA.debugLine="Public Const COLOR_STATUS_ALARM_HI          As In";
_color_status_alarm_hi = ((int)0xffd32f2f);
 //BA.debugLineNum = 88;BA.debugLine="Public Const COLOR_STATUS_FORBIDDEN         As In";
_color_status_forbidden = ((int)0xff7f0000);
 //BA.debugLineNum = 93;BA.debugLine="Public Const COLOR_STATE_ON_BACKGROUND      As In";
_color_state_on_background = ((int)0xff103030);
 //BA.debugLineNum = 94;BA.debugLine="Public Const COLOR_STATE_OFF_BACKGROUND     As In";
_color_state_off_background = _color_background_default;
 //BA.debugLineNum = 95;BA.debugLine="Public Const COLOR_STATE_ON_BORDER          As In";
_color_state_on_border = ((int)0xff202020);
 //BA.debugLineNum = 96;BA.debugLine="Public Const COLOR_STATE_OFF_BORDER         As In";
_color_state_off_border = ((int)0xff888888);
 //BA.debugLineNum = 97;BA.debugLine="Public Const COLOR_STATE_TEXT               As In";
_color_state_text = ((int)0xff202020);
 //BA.debugLineNum = 102;BA.debugLine="Public Const COLOR_TEXT_PRIMARY    			As Int = 0x";
_color_text_primary = ((int)0xffffffff);
 //BA.debugLineNum = 103;BA.debugLine="Public Const COLOR_TEXT_SECONDARY  			As Int = 0x";
_color_text_secondary = ((int)0xffdadada);
 //BA.debugLineNum = 104;BA.debugLine="Public Const COLOR_TEXT_DISABLED   			As Int = 0x";
_color_text_disabled = ((int)0xff7a7a7a);
 //BA.debugLineNum = 105;BA.debugLine="Public Const COLOR_TEXT_WARNING             As In";
_color_text_warning = ((int)0xff000000);
 //BA.debugLineNum = 106;BA.debugLine="Public Const COLOR_TEXT_ALARM               As In";
_color_text_alarm = ((int)0xffffffff);
 //BA.debugLineNum = 107;BA.debugLine="Public Const COLOR_TEXT_ERROR               As In";
_color_text_error = ((int)0xffffffff);
 //BA.debugLineNum = 112;BA.debugLine="Public Const STATE_NORMAL              		As Int =";
_state_normal = (int) (0);
 //BA.debugLineNum = 113;BA.debugLine="Public Const STATE_WARNING             		As Int =";
_state_warning = (int) (1);
 //BA.debugLineNum = 114;BA.debugLine="Public Const STATE_ALARM               		As Int =";
_state_alarm = (int) (2);
 //BA.debugLineNum = 115;BA.debugLine="Public Const STATE_DISABLED            		As Int =";
_state_disabled = (int) (3);
 //BA.debugLineNum = 116;BA.debugLine="Public Const TYPESTYLE_NORMAL          		As Strin";
_typestyle_normal = "Normal";
 //BA.debugLineNum = 117;BA.debugLine="Public Const TYPESTYLE_WARNING             	As St";
_typestyle_warning = "Warning";
 //BA.debugLineNum = 118;BA.debugLine="Public Const TYPESTYLE_ALARM               	As St";
_typestyle_alarm = "Alarm";
 //BA.debugLineNum = 119;BA.debugLine="Public Const TYPESTYLE_DISABLED            	As St";
_typestyle_disabled = "Disabled";
 //BA.debugLineNum = 124;BA.debugLine="Public Const COLOR_TILE_NORMAL_BACKGROUND   As In";
_color_tile_normal_background = _color_background_default;
 //BA.debugLineNum = 125;BA.debugLine="Public Const COLOR_TILE_NORMAL_TEXT         As In";
_color_tile_normal_text = _color_text_primary;
 //BA.debugLineNum = 127;BA.debugLine="Public Const COLOR_TILE_WARNING_BACKGROUND  As In";
_color_tile_warning_background = _color_status_warning;
 //BA.debugLineNum = 128;BA.debugLine="Public Const COLOR_TILE_WARNING_TEXT        As In";
_color_tile_warning_text = ((int)0xff000000);
 //BA.debugLineNum = 130;BA.debugLine="Public Const COLOR_TILE_ALARM_BACKGROUND    As In";
_color_tile_alarm_background = _color_status_alarm_hi;
 //BA.debugLineNum = 131;BA.debugLine="Public Const COLOR_TILE_ALARM_TEXT          As In";
_color_tile_alarm_text = ((int)0xffffffff);
 //BA.debugLineNum = 133;BA.debugLine="Public Const COLOR_TILE_DISABLED_BACKGROUND As In";
_color_tile_disabled_background = ((int)0xffdddddd);
 //BA.debugLineNum = 134;BA.debugLine="Public Const COLOR_TILE_DISABLED_TEXT       As In";
_color_tile_disabled_text = _color_text_disabled;
 //BA.debugLineNum = 136;BA.debugLine="Public Const COLOR_TILE_ENABLED_BACKGROUND   As I";
_color_tile_enabled_background = _color_background_dark;
 //BA.debugLineNum = 137;BA.debugLine="Public Const COLOR_TILE_ENABLED_TEXT         As I";
_color_tile_enabled_text = ((int)0xffffffff);
 //BA.debugLineNum = 142;BA.debugLine="Public Const BORDER_WIDTH              		As Doubl";
_border_width = 1;
 //BA.debugLineNum = 143;BA.debugLine="Public Const BORDER_RADIUS             		As Doubl";
_border_radius = 1;
 //BA.debugLineNum = 144;BA.debugLine="Public Const BORDER_RADIUS_LARGE            As Do";
_border_radius_large = 12;
 //BA.debugLineNum = 150;BA.debugLine="Public Const GRID_BASELINE              	As Doubl";
_grid_baseline = 8;
 //BA.debugLineNum = 152;BA.debugLine="Public Const GRID_SPACING              		As Doubl";
_grid_spacing = 16;
 //BA.debugLineNum = 154;BA.debugLine="Public Const GRID_OUTER_SCREEN_EDGE			As Double =";
_grid_outer_screen_edge = 32;
 //BA.debugLineNum = 157;BA.debugLine="Public Const PADDING 						As Int = 4dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4));
 //BA.debugLineNum = 164;BA.debugLine="Public Const TEXT_SIZE_TITLE        		As Float =";
_text_size_title = (float) (16);
 //BA.debugLineNum = 166;BA.debugLine="Public Const TEXT_SIZE_LABEL        		As Float =";
_text_size_label = (float) (16);
 //BA.debugLineNum = 168;BA.debugLine="Public Const TEXT_SIZE_STATE        		As Float =";
_text_size_state = (float) (24);
 //BA.debugLineNum = 170;BA.debugLine="Public Const TEXT_SIZE_SMALL        		As Float =";
_text_size_small = (float) (14);
 //BA.debugLineNum = 172;BA.debugLine="Public Const TEXT_SIZE_TINY         		As Float =";
_text_size_tiny = (float) (12);
 //BA.debugLineNum = 174;BA.debugLine="Public Const TEXT_SIZE_ICON         		As Float =";
_text_size_icon = (float) (32);
 //BA.debugLineNum = 176;BA.debugLine="Public Const TEXT_SIZE_ICON_LARGE         	As Flo";
_text_size_icon_large = (float) (40);
 //BA.debugLineNum = 192;BA.debugLine="Public Const EVENT_COLOR_BG_BASE        As Int =";
_event_color_bg_base = ((int)0xff1f1f1f);
 //BA.debugLineNum = 193;BA.debugLine="Public Const EVENT_COLOR_BG_SELECTED    As Int =";
_event_color_bg_selected = ((int)0xff2b2b2b);
 //BA.debugLineNum = 194;BA.debugLine="Public Const EVENT_COLOR_BG_HOVER       As Int =";
_event_color_bg_hover = ((int)0xff262626);
 //BA.debugLineNum = 195;BA.debugLine="Public Const EVENT_COLOR_BG_DISABLED    As Int =";
_event_color_bg_disabled = ((int)0xff2f2f2f);
 //BA.debugLineNum = 196;BA.debugLine="Public Const EVENT_DIVIDER   			As Int = 0xFF3030";
_event_divider = ((int)0xff303030);
 //BA.debugLineNum = 204;BA.debugLine="Public Const EVENT_COLOR_TEXT			As Int = 0xFFFFFF";
_event_color_text = ((int)0xffffffff);
 //BA.debugLineNum = 215;BA.debugLine="Public Const EVENT_LEVEL_INFO     				As Int = ST";
_event_level_info = _state_normal;
 //BA.debugLineNum = 216;BA.debugLine="Public Const EVENT_LEVEL_WARNING  				As Int = ST";
_event_level_warning = _state_warning;
 //BA.debugLineNum = 217;BA.debugLine="Public Const EVENT_LEVEL_ALARM    				As Int = ST";
_event_level_alarm = _state_alarm;
 //BA.debugLineNum = 221;BA.debugLine="Public Const EVENT_COLOR_ICON_INFO      		As Int";
_event_color_icon_info = _color_text_primary;
 //BA.debugLineNum = 222;BA.debugLine="Public Const EVENT_COLOR_ICON_WARNING   		As Int";
_event_color_icon_warning = ((int)0xffffc000);
 //BA.debugLineNum = 223;BA.debugLine="Public Const EVENT_COLOR_ICON_ALARM     		As Int";
_event_color_icon_alarm = ((int)0xffff0000);
 //BA.debugLineNum = 224;BA.debugLine="Public Const EVENT_COLOR_ICON_CRITICAL  		As Int";
_event_color_icon_critical = ((int)0xffff0000);
 //BA.debugLineNum = 225;BA.debugLine="Public Const EVENT_COLOR_ICON_DISABLED  		As Int";
_event_color_icon_disabled = ((int)0xff777777);
 //BA.debugLineNum = 227;BA.debugLine="Public Const EVENT_ICON_INFO 					As String = Chr";
_event_icon_info = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf05a)));
 //BA.debugLineNum = 228;BA.debugLine="Public Const EVENT_ICON_WARNING        			As Stri";
_event_icon_warning = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf071)));
 //BA.debugLineNum = 229;BA.debugLine="Public Const EVENT_ICON_ALARM         			As Strin";
_event_icon_alarm = "🚨";
 //BA.debugLineNum = 230;BA.debugLine="Public Const EVENT_ICON_DISABLED      			As Strin";
_event_icon_disabled = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr(((int)0xf00d)));
 //BA.debugLineNum = 233;BA.debugLine="Public Const EVENT_NORMAL_TIMESTAMP_TEXT_SIZE	As";
_event_normal_timestamp_text_size = (float) (13);
 //BA.debugLineNum = 234;BA.debugLine="Public Const EVENT_NORMAL_MESSAGE_TEXT_SIZE   	As";
_event_normal_message_text_size = (float) (15);
 //BA.debugLineNum = 235;BA.debugLine="Public Const EVENT_NORMAL_SOURCE_TEXT_SIZE    	As";
_event_normal_source_text_size = (float) (16);
 //BA.debugLineNum = 240;BA.debugLine="Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As";
_event_normal_icon_text_size = (float) (24);
 //BA.debugLineNum = 242;BA.debugLine="Public Const EVENT_NORMAL_ICON_TEXT_SIZE      	As";
_event_normal_icon_text_size = (float) (24);
 //BA.debugLineNum = 245;BA.debugLine="Public Const EVENT_NORMAL_HEIGHT				As Int = 36di";
_event_normal_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (36));
 //BA.debugLineNum = 246;BA.debugLine="Public Const EVENT_NORMAL_HEIGHT_LARGE			As Int =";
_event_normal_height_large = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (54));
 //BA.debugLineNum = 247;BA.debugLine="Public Const EVENT_NORMAL_PADDING 				As Int = 6d";
_event_normal_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (6));
 //BA.debugLineNum = 250;BA.debugLine="Public Const EVENT_COMPACT_TIMESTAMP_TEXT_SIZE 	A";
_event_compact_timestamp_text_size = (float) (10);
 //BA.debugLineNum = 251;BA.debugLine="Public Const EVENT_COMPACT_MESSAGE_TEXT_SIZE   	A";
_event_compact_message_text_size = (float) (12);
 //BA.debugLineNum = 252;BA.debugLine="Public Const EVENT_COMPACT_SOURCE_TEXT_SIZE    	A";
_event_compact_source_text_size = (float) (14);
 //BA.debugLineNum = 257;BA.debugLine="Public Const EVENT_COMPACT_ICON_TEXT_SIZE      	A";
_event_compact_icon_text_size = (float) (20);
 //BA.debugLineNum = 261;BA.debugLine="Public Const EVENT_COMPACT_HEIGHT				As Int = 24d";
_event_compact_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24));
 //BA.debugLineNum = 262;BA.debugLine="Public Const EVENT_COMPACT_PADDING 				As Int = 4";
_event_compact_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4));
 //BA.debugLineNum = 265;BA.debugLine="Public Const EVENT_TITLE_HEIGHT As Int = 32dip";
_event_title_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32));
 //BA.debugLineNum = 272;BA.debugLine="Public Const LIST_COLOR_BG_BASE              	As";
_list_color_bg_base = ((int)0xfff5f5f5);
 //BA.debugLineNum = 274;BA.debugLine="Public Const LIST_COLOR_BG_ITEM              	As";
_list_color_bg_item = ((int)0xffffffff);
 //BA.debugLineNum = 276;BA.debugLine="Public Const LIST_COLOR_BG_SELECTED          	As";
_list_color_bg_selected = ((int)0xffd0d0d0);
 //BA.debugLineNum = 278;BA.debugLine="Public Const LIST_COLOR_BG_HOVER             	As";
_list_color_bg_hover = ((int)0xffeaeaea);
 //BA.debugLineNum = 280;BA.debugLine="Public Const LIST_COLOR_BG_DISABLED          	As";
_list_color_bg_disabled = ((int)0xffe0e0e0);
 //BA.debugLineNum = 282;BA.debugLine="Public Const LIST_DIVIDER                    	As";
_list_divider = ((int)0xffcccccc);
 //BA.debugLineNum = 284;BA.debugLine="Public Const LIST_COLOR_TEXT                 	As";
_list_color_text = ((int)0xff202020);
 //BA.debugLineNum = 285;BA.debugLine="Public Const LIST_COLOR_TEXT_DISABLED        	As";
_list_color_text_disabled = ((int)0xff909090);
 //BA.debugLineNum = 287;BA.debugLine="Public Const LIST_TITLE_HEIGHT As Int = 32dip";
_list_title_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32));
 //BA.debugLineNum = 289;BA.debugLine="Public Const LIST_NORMAL_HEIGHT 				As Int = 48di";
_list_normal_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48));
 //BA.debugLineNum = 290;BA.debugLine="Public Const LIST_NORMAL_PADDING 				As Int = 12d";
_list_normal_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12));
 //BA.debugLineNum = 291;BA.debugLine="Public Const LIST_NORMAL_PRIMARY_TEXT_SIZE 		As F";
_list_normal_primary_text_size = (float) (16);
 //BA.debugLineNum = 292;BA.debugLine="Public Const LIST_NORMAL_SECONDARY_TEXT_SIZE	As F";
_list_normal_secondary_text_size = (float) (13);
 //BA.debugLineNum = 293;BA.debugLine="Public Const LIST_COMPACT_HEIGHT 				As Int = 34d";
_list_compact_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (34));
 //BA.debugLineNum = 294;BA.debugLine="Public Const LIST_COMPACT_PADDING 				As Int = 7d";
_list_compact_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (7));
 //BA.debugLineNum = 295;BA.debugLine="Public Const LIST_COMPACT_PRIMARY_TEXT_SIZE 	As F";
_list_compact_primary_text_size = (float) (14);
 //BA.debugLineNum = 296;BA.debugLine="Public Const LIST_COMPACT_SECONDARY_TEXT_SIZE 	As";
_list_compact_secondary_text_size = (float) (11);
 //BA.debugLineNum = 301;BA.debugLine="Public Const COLOR_SLIDER_TRACK            As Int";
_color_slider_track = ((int)0xffffffff);
 //BA.debugLineNum = 302;BA.debugLine="Public Const COLOR_SLIDER_ACTIVE           As Int";
_color_slider_active = ((int)0xffb8b8b8);
 //BA.debugLineNum = 303;BA.debugLine="Public Const COLOR_SLIDER_KNOB             As Int";
_color_slider_knob = ((int)0xff4a4a4a);
 //BA.debugLineNum = 304;BA.debugLine="Public Const COLOR_SLIDER_DISABLED_TRACK   As Int";
_color_slider_disabled_track = ((int)0xffe0e0e0);
 //BA.debugLineNum = 305;BA.debugLine="Public Const COLOR_SLIDER_DISABLED_KNOB    As Int";
_color_slider_disabled_knob = ((int)0xffa8a8a8);
 //BA.debugLineNum = 306;BA.debugLine="Public Const COLOR_SLIDER_VALUE_TEXT       As Int";
_color_slider_value_text = ((int)0xff2a2a2a);
 //BA.debugLineNum = 307;BA.debugLine="Public Const COLOR_SLIDER_LABEL_TEXT       As Int";
_color_slider_label_text = _color_text_secondary;
 //BA.debugLineNum = 308;BA.debugLine="Public Const COLOR_SLIDER_UNIT_TEXT        As Int";
_color_slider_unit_text = ((int)0xff3a3a3a);
 //BA.debugLineNum = 309;BA.debugLine="Public Const COLOR_SLIDER_KNOB_BORDER 		As Int =";
_color_slider_knob_border = ((int)0xff2f2f2f);
 //BA.debugLineNum = 314;BA.debugLine="Public Const COLOR_TREND_LINE     As Int = 0xFF40";
_color_trend_line = ((int)0xff404040);
 //BA.debugLineNum = 315;BA.debugLine="Public Const COLOR_TREND_BG       As Int = 0xFFF5";
_color_trend_bg = ((int)0xfff5f5f5);
 //BA.debugLineNum = 316;BA.debugLine="Public Const COLOR_TREND_BORDER   As Int = 0xFFB0";
_color_trend_border = ((int)0xffb0b0b0);
 //BA.debugLineNum = 322;BA.debugLine="Public ByteConv As ByteConverter";
_byteconv = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public static float  _setalpha(boolean _enabled) throws Exception{
 //BA.debugLineNum = 619;BA.debugLine="Public Sub SetAlpha(enabled As Boolean) As Float";
 //BA.debugLineNum = 620;BA.debugLine="Return IIf(enabled, 1, 0.4)";
if (true) return (float)(BA.ObjectToNumber(((_enabled) ? ((Object)(1)) : ((Object)(0.4)))));
 //BA.debugLineNum = 621;BA.debugLine="End Sub";
return 0f;
}
public static String  _setclvbackgroundtransparent(b4j.example.customlistview _clv) throws Exception{
anywheresoftware.b4j.objects.ScrollPaneWrapper _sp = null;
 //BA.debugLineNum = 586;BA.debugLine="Public Sub SetCLVBackgroundTransparent(clv As Cust";
 //BA.debugLineNum = 588;BA.debugLine="Dim sp As ScrollPane = clv.sv";
_sp = new anywheresoftware.b4j.objects.ScrollPaneWrapper();
_sp = (anywheresoftware.b4j.objects.ScrollPaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.ScrollPaneWrapper(), (javafx.scene.control.ScrollPane)(_clv._sv.getObject()));
 //BA.debugLineNum = 589;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-background\", \"";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-background","transparent");
 //BA.debugLineNum = 590;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-background-col";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-background-color","transparent");
 //BA.debugLineNum = 593;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-control-inner-";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-control-inner-background","transparent");
 //BA.debugLineNum = 594;BA.debugLine="CSSUtils.SetStyleProperty(sp, \"-fx-control-inner-";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_sp.getObject())),"-fx-control-inner-background-alt","transparent");
 //BA.debugLineNum = 596;BA.debugLine="End Sub";
return "";
}
public static String  _setclvscrollbars(b4j.example.customlistview _clv,boolean _visible) throws Exception{
anywheresoftware.b4j.objects.ScrollPaneWrapper _nsv = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 602;BA.debugLine="Public Sub SetCLVScrollBars(clv As CustomListView,";
 //BA.debugLineNum = 604;BA.debugLine="Dim nsv As ScrollPane = clv.sv";
_nsv = new anywheresoftware.b4j.objects.ScrollPaneWrapper();
_nsv = (anywheresoftware.b4j.objects.ScrollPaneWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.ScrollPaneWrapper(), (javafx.scene.control.ScrollPane)(_clv._sv.getObject()));
 //BA.debugLineNum = 605;BA.debugLine="If visible Then";
if (_visible) { 
 //BA.debugLineNum = 606;BA.debugLine="nsv.SetVScrollVisibility(\"ALWAYS\")";
_nsv.SetVScrollVisibility(BA.getEnumFromString(javafx.scene.control.ScrollPane.ScrollBarPolicy.class,"ALWAYS"));
 }else {
 //BA.debugLineNum = 608;BA.debugLine="nsv.SetVScrollVisibility(\"NEVER\")";
_nsv.SetVScrollVisibility(BA.getEnumFromString(javafx.scene.control.ScrollPane.ScrollBarPolicy.class,"NEVER"));
 };
 //BA.debugLineNum = 610;BA.debugLine="Dim jo As JavaObject = clv 'ignore";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_clv));
 //BA.debugLineNum = 611;BA.debugLine="jo.SetField(\"_scrollbarsvisible\", visible)";
_jo.SetField("_scrollbarsvisible",(Object)(_visible));
 //BA.debugLineNum = 612;BA.debugLine="clv.Base_Resize(clv.AsView.Width, clv.AsView.Heig";
_clv._base_resize(_clv._asview().getWidth(),_clv._asview().getHeight());
 //BA.debugLineNum = 614;BA.debugLine="End Sub";
return "";
}
public static String  _setstylebold(anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper _node,boolean _value) throws Exception{
 //BA.debugLineNum = 470;BA.debugLine="Public Sub SetStyleBold(node As Node, value As Boo";
 //BA.debugLineNum = 471;BA.debugLine="If value Then";
if (_value) { 
 //BA.debugLineNum = 472;BA.debugLine="CSSUtils.SetStyleProperty(node, \"-fx-font-weight";
_cssutils._setstyleproperty(_node,"-fx-font-weight","bold");
 }else {
 //BA.debugLineNum = 474;BA.debugLine="CSSUtils.SetStyleProperty(node, \"-fx-font-weight";
_cssutils._setstyleproperty(_node,"-fx-font-weight","normal");
 };
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public static String  _settextcolor(anywheresoftware.b4a.objects.B4XViewWrapper _lbl,int _col) throws Exception{
 //BA.debugLineNum = 534;BA.debugLine="Public Sub SetTextColor(lbl As B4XView, col As Int";
 //BA.debugLineNum = 535;BA.debugLine="If lbl.IsInitialized Then lbl.TextColor = col";
if (_lbl.IsInitialized()) { 
_lbl.setTextColor(_col);};
 //BA.debugLineNum = 536;BA.debugLine="End Sub";
return "";
}
public static String  _snapallchildrentogrid(anywheresoftware.b4a.objects.B4XViewWrapper _parent) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _c = null;
 //BA.debugLineNum = 691;BA.debugLine="Public Sub SnapAllChildrenToGrid(parent As B4XView";
 //BA.debugLineNum = 692;BA.debugLine="For Each c As B4XView In parent.GetAllViewsRecurs";
_c = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group1 = _parent.GetAllViewsRecursive();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_c = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group1.Get(index1)));
 //BA.debugLineNum = 693;BA.debugLine="SnapViewToGrid(c)";
_snapviewtogrid(_c);
 }
};
 //BA.debugLineNum = 695;BA.debugLine="End Sub";
return "";
}
public static int  _snapcoord(int _value) throws Exception{
int _stepsize = 0;
 //BA.debugLineNum = 656;BA.debugLine="Public Sub SnapCoord(value As Int) As Int";
 //BA.debugLineNum = 657;BA.debugLine="If Not(HMITileGrid.IsInitialized) Then";
if (anywheresoftware.b4a.keywords.Common.Not(_hmitilegrid.IsInitialized /*boolean*/ ())) { 
 //BA.debugLineNum = 658;BA.debugLine="Return 0";
if (true) return (int) (0);
 };
 //BA.debugLineNum = 660;BA.debugLine="Dim stepSize As Int = HMITileGrid.MinorStep";
_stepsize = _hmitilegrid._minorstep /*int*/ ;
 //BA.debugLineNum = 661;BA.debugLine="If stepSize <= 0 Then stepSize = 8dip";
if (_stepsize<=0) { 
_stepsize = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8));};
 //BA.debugLineNum = 662;BA.debugLine="Return Round(value / stepSize) * stepSize";
if (true) return (int) (anywheresoftware.b4a.keywords.Common.Round(_value/(double)_stepsize)*_stepsize);
 //BA.debugLineNum = 663;BA.debugLine="End Sub";
return 0;
}
public static String  _snapsizetogrid(anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
 //BA.debugLineNum = 677;BA.debugLine="Public Sub SnapSizeToGrid(v As B4XView)";
 //BA.debugLineNum = 678;BA.debugLine="If v.IsInitialized = False Then Return";
if (_v.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 679;BA.debugLine="v.Width = SnapCoord(v.Width)";
_v.setWidth(_snapcoord((int) (_v.getWidth())));
 //BA.debugLineNum = 680;BA.debugLine="v.Height = SnapCoord(v.Height)";
_v.setHeight(_snapcoord((int) (_v.getHeight())));
 //BA.debugLineNum = 681;BA.debugLine="End Sub";
return "";
}
public static String  _snapviewfull(anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
 //BA.debugLineNum = 686;BA.debugLine="Public Sub SnapViewFull(v As B4XView)";
 //BA.debugLineNum = 687;BA.debugLine="SnapViewToGrid(v)";
_snapviewtogrid(_v);
 //BA.debugLineNum = 688;BA.debugLine="SnapSizeToGrid(v)";
_snapsizetogrid(_v);
 //BA.debugLineNum = 689;BA.debugLine="End Sub";
return "";
}
public static String  _snapviewtogrid(anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
 //BA.debugLineNum = 668;BA.debugLine="Public Sub SnapViewToGrid(v As B4XView)";
 //BA.debugLineNum = 669;BA.debugLine="If v.IsInitialized = False Then Return";
if (_v.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 670;BA.debugLine="v.Left = SnapCoord(v.Left)";
_v.setLeft(_snapcoord((int) (_v.getLeft())));
 //BA.debugLineNum = 671;BA.debugLine="v.Top = SnapCoord(v.Top)";
_v.setTop(_snapcoord((int) (_v.getTop())));
 //BA.debugLineNum = 672;BA.debugLine="End Sub";
return "";
}
public static int  _statestyletostate(String _state) throws Exception{
int _result = 0;
 //BA.debugLineNum = 559;BA.debugLine="Public Sub StateStyleToState(state As String) As I";
 //BA.debugLineNum = 560;BA.debugLine="Dim result As Int";
_result = 0;
 //BA.debugLineNum = 561;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,"Normal","Warning","Error","Alarm","Dimmed","Disabled")) {
case 0: {
 //BA.debugLineNum = 563;BA.debugLine="result = STATE_NORMAL";
_result = _state_normal;
 break; }
case 1: {
 //BA.debugLineNum = 565;BA.debugLine="result = STATE_WARNING";
_result = _state_warning;
 break; }
case 2: {
 //BA.debugLineNum = 567;BA.debugLine="result = STATE_ALARM";
_result = _state_alarm;
 break; }
case 3: {
 //BA.debugLineNum = 569;BA.debugLine="result = STATE_ALARM";
_result = _state_alarm;
 break; }
case 4: {
 //BA.debugLineNum = 571;BA.debugLine="result = STATE_DISABLED";
_result = _state_disabled;
 break; }
case 5: {
 //BA.debugLineNum = 573;BA.debugLine="result = STATE_DISABLED";
_result = _state_disabled;
 break; }
default: {
 //BA.debugLineNum = 575;BA.debugLine="result = STATE_NORMAL";
_result = _state_normal;
 break; }
}
;
 //BA.debugLineNum = 577;BA.debugLine="Return result";
if (true) return _result;
 //BA.debugLineNum = 578;BA.debugLine="End Sub";
return 0;
}
}
