package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitileslider extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitileslider", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitileslider.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XCanvas _canvasseekbar = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _paneseekbar = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _touchpanel = null;
public boolean _mtouchstatechanged = false;
public boolean _pressed = false;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalue = null;
public boolean _mshowvalue = false;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelunit = null;
public int _mvalue = 0;
public int _mminvalue = 0;
public int _mmaxvalue = 0;
public int _minterval = 0;
public boolean _mshowthumb = false;
public int _mthumbradius = 0;
public int _mthumbradiuspressed = 0;
public int _mthumbcolor = 0;
public int _mcolortrack = 0;
public int _mcolorlevel = 0;
public double _mbartop = 0;
public double _mbarbottom = 0;
public int _mactivebarwidth = 0;
public int _minactivebarwidth = 0;
public boolean _mvertical = false;
public int _msize = 0;
public boolean _mshowticks = false;
public int _mtickcount = 0;
public int _mtickfontsize = 0;
public int _mtickvaluecolor = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 577;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 578;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 579;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (_labelvalue);
 //BA.debugLineNum = 581;BA.debugLine="CSSUtils.SetStyleProperty(LabelValue, \"-fx-font-s";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_labelvalue.getObject())),"-fx-font-size",BA.NumberToString(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 583;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (_labelunit);
 //BA.debugLineNum = 585;BA.debugLine="CSSUtils.SetStyleProperty(LabelUnit, \"-fx-font-si";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_labelunit.getObject())),"-fx-font-size",BA.NumberToString(_hmitileutils._text_size_small /*float*/ ));
 //BA.debugLineNum = 588;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 589;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 590;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
double _baseviewheight = 0;
 //BA.debugLineNum = 168;BA.debugLine="Public Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 169;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 172;BA.debugLine="Dim baseviewheight As Double = HMITileUtils.TILE_";
_baseviewheight = _hmitileutils._tile_default_size /*int*/ ;
 //BA.debugLineNum = 182;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0,  0,";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_baseviewheight*0.25);
 //BA.debugLineNum = 183;BA.debugLine="LabelValue.SetLayoutAnimated	(0, 0,	baseviewheigh";
_labelvalue.SetLayoutAnimated((int) (0),0,_baseviewheight*0.15,_width,_baseviewheight*0.25);
 //BA.debugLineNum = 184;BA.debugLine="LabelUnit.SetLayoutAnimated		(0, 0,  Height - (ba";
_labelunit.SetLayoutAnimated((int) (0),0,_height-(_baseviewheight*0.20),_width,_baseviewheight*0.15);
 //BA.debugLineNum = 187;BA.debugLine="TouchPanel.SetLayoutAnimated(0, 0, 0, Width, Heig";
_touchpanel.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 189;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 38;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 39;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 42;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 43;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private CanvasSeekBar As B4XCanvas";
_canvasseekbar = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 47;BA.debugLine="Private PaneSeekBar As B4XView";
_paneseekbar = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private TouchPanel As B4XView";
_touchpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private mTouchStateChanged As Boolean";
_mtouchstatechanged = false;
 //BA.debugLineNum = 52;BA.debugLine="Private Pressed As Boolean";
_pressed = false;
 //BA.debugLineNum = 55;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private mShowValue As Boolean";
_mshowvalue = false;
 //BA.debugLineNum = 58;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private mValue As Int";
_mvalue = 0;
 //BA.debugLineNum = 62;BA.debugLine="Private mMinValue As Int";
_mminvalue = 0;
 //BA.debugLineNum = 63;BA.debugLine="Private mMaxValue As Int";
_mmaxvalue = 0;
 //BA.debugLineNum = 64;BA.debugLine="Private mInterval As Int = 1";
_minterval = (int) (1);
 //BA.debugLineNum = 70;BA.debugLine="Private mShowThumb As Boolean";
_mshowthumb = false;
 //BA.debugLineNum = 71;BA.debugLine="Private mThumbRadius As Int = 8dip     		' thumb";
_mthumbradius = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 72;BA.debugLine="Private mThumbRadiusPressed As Int = 18dip	' pres";
_mthumbradiuspressed = __c.DipToCurrent((int) (18));
 //BA.debugLineNum = 73;BA.debugLine="Private mThumbColor As Int					' Thumb color if n";
_mthumbcolor = 0;
 //BA.debugLineNum = 76;BA.debugLine="Private mColorTrack As Int					' Background";
_mcolortrack = 0;
 //BA.debugLineNum = 77;BA.debugLine="Private mColorLevel As Int					' Actual level";
_mcolorlevel = 0;
 //BA.debugLineNum = 78;BA.debugLine="Private mBarTop As Double";
_mbartop = 0;
 //BA.debugLineNum = 79;BA.debugLine="Private mBarBottom As Double";
_mbarbottom = 0;
 //BA.debugLineNum = 82;BA.debugLine="Private mActiveBarWidth As Int";
_mactivebarwidth = 0;
 //BA.debugLineNum = 83;BA.debugLine="Private mInActiveBarWidth As Int";
_minactivebarwidth = 0;
 //BA.debugLineNum = 84;BA.debugLine="Private mVertical As Boolean";
_mvertical = false;
 //BA.debugLineNum = 85;BA.debugLine="Private mSize As Int";
_msize = 0;
 //BA.debugLineNum = 88;BA.debugLine="Private mShowTicks As Boolean";
_mshowticks = false;
 //BA.debugLineNum = 89;BA.debugLine="Private mTickCount As Int";
_mtickcount = 0;
 //BA.debugLineNum = 90;BA.debugLine="Private mTickFontSize As Int";
_mtickfontsize = 0;
 //BA.debugLineNum = 91;BA.debugLine="Private mTickValueColor As Int 				' Tick value c";
_mtickvaluecolor = 0;
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _lblx = null;
 //BA.debugLineNum = 562;BA.debugLine="Private Sub CreateLabel As B4XView";
 //BA.debugLineNum = 563;BA.debugLine="Dim lblx As B4XView = XUIViewsUtils.CreateLabel";
_lblx = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblx = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ();
 //BA.debugLineNum = 564;BA.debugLine="lblx.Font = xui.CreateDefaultFont(HMITileUtils.TE";
_lblx.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 565;BA.debugLine="lblx.Text = \"LABEL\"";
_lblx.setText("LABEL");
 //BA.debugLineNum = 566;BA.debugLine="lblx.SetTextAlignment(\"CENTER\", \"CENTER\")";
_lblx.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 567;BA.debugLine="lblx.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY";
_lblx.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 //BA.debugLineNum = 569;BA.debugLine="Return lblx";
if (true) return _lblx;
 //BA.debugLineNum = 570;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 102;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 103;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 106;BA.debugLine="mColorTrack 		= HMITileUtils.COLOR_INDICATOR_TRAC";
_mcolortrack = _hmitileutils._color_indicator_track /*int*/ ;
 //BA.debugLineNum = 107;BA.debugLine="mColorLevel 		= HMITileUtils.COLOR_INDICATOR_LEVE";
_mcolorlevel = _hmitileutils._color_indicator_level /*int*/ ;
 //BA.debugLineNum = 108;BA.debugLine="mActiveBarWidth 	= Props.Get(\"ActiveBarWidth\")";
_mactivebarwidth = (int)(BA.ObjectToNumber(_props.Get((Object)("ActiveBarWidth"))));
 //BA.debugLineNum = 109;BA.debugLine="mInActiveBarWidth 	= Props.Get(\"InActiveBarWidth\"";
_minactivebarwidth = (int)(BA.ObjectToNumber(_props.Get((Object)("InActiveBarWidth"))));
 //BA.debugLineNum = 111;BA.debugLine="mTouchStateChanged 	= Props.Get(\"TouchStateChange";
_mtouchstatechanged = BA.ObjectToBoolean(_props.Get((Object)("TouchStateChanged")));
 //BA.debugLineNum = 113;BA.debugLine="mThumbRadius		= Props.Get(\"ThumbRadius\")";
_mthumbradius = (int)(BA.ObjectToNumber(_props.Get((Object)("ThumbRadius"))));
 //BA.debugLineNum = 114;BA.debugLine="mThumbRadiusPressed	= Props.Get(\"ThumbRadiusPress";
_mthumbradiuspressed = (int)(BA.ObjectToNumber(_props.Get((Object)("ThumbRadiusPressed"))));
 //BA.debugLineNum = 115;BA.debugLine="mThumbColor			= HMITileUtils.COLOR_INDICATOR_LEVE";
_mthumbcolor = _hmitileutils._color_indicator_level /*int*/ ;
 //BA.debugLineNum = 116;BA.debugLine="mShowThumb			= Props.Get(\"ShowThumb\")";
_mshowthumb = BA.ObjectToBoolean(_props.Get((Object)("ShowThumb")));
 //BA.debugLineNum = 118;BA.debugLine="mShowTicks			= Props.Get(\"ShowTicks\")";
_mshowticks = BA.ObjectToBoolean(_props.Get((Object)("ShowTicks")));
 //BA.debugLineNum = 119;BA.debugLine="mTickCount			= Props.Get(\"TickCount\")";
_mtickcount = (int)(BA.ObjectToNumber(_props.Get((Object)("TickCount"))));
 //BA.debugLineNum = 120;BA.debugLine="mTickValueColor 	= HMITileUtils.COLOR_TEXT_INFO";
_mtickvaluecolor = _hmitileutils._color_text_info /*int*/ ;
 //BA.debugLineNum = 125;BA.debugLine="mTickFontSize		= HMITileUtils.TEXT_SIZE_SMALL";
_mtickfontsize = (int) (_hmitileutils._text_size_small /*float*/ );
 //BA.debugLineNum = 127;BA.debugLine="mTickFontSize		= HMITileUtils.TEXT_SIZE_SMALL";
_mtickfontsize = (int) (_hmitileutils._text_size_small /*float*/ );
 //BA.debugLineNum = 128;BA.debugLine="mInterval 			= Max(1, Props.GetDefault(\"Interval\"";
_minterval = (int) (__c.Max(1,(double)(BA.ObjectToNumber(_props.GetDefault((Object)("Interval"),(Object)(1))))));
 //BA.debugLineNum = 130;BA.debugLine="mMinValue 			= Props.Get(\"Min\")";
_mminvalue = (int)(BA.ObjectToNumber(_props.Get((Object)("Min"))));
 //BA.debugLineNum = 131;BA.debugLine="mMaxValue 			= Props.Get(\"Max\")";
_mmaxvalue = (int)(BA.ObjectToNumber(_props.Get((Object)("Max"))));
 //BA.debugLineNum = 132;BA.debugLine="mValue 				= Max(mMinValue, Min(mMaxValue, Props.";
_mvalue = (int) (__c.Max(_mminvalue,__c.Min(_mmaxvalue,(double)(BA.ObjectToNumber(_props.Get((Object)("Value")))))));
 //BA.debugLineNum = 134;BA.debugLine="mVertical			= Props.Get(\"Vertical\")";
_mvertical = BA.ObjectToBoolean(_props.Get((Object)("Vertical")));
 //BA.debugLineNum = 137;BA.debugLine="PaneSeekBar = xui.CreatePanel(\"\")";
_paneseekbar = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 138;BA.debugLine="BasePane.AddView(PaneSeekBar, 0, 0, BasePane.Widt";
_basepane.AddView((javafx.scene.Node)(_paneseekbar.getObject()),0,0,_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 139;BA.debugLine="CanvasSeekBar.Initialize(PaneSeekBar)";
_canvasseekbar.Initialize(ba,_paneseekbar);
 //BA.debugLineNum = 141;BA.debugLine="TouchPanel = xui.CreatePanel(\"TouchPanel\")";
_touchpanel = _xui.CreatePanel(ba,"TouchPanel");
 //BA.debugLineNum = 142;BA.debugLine="BasePane.AddView(TouchPanel, 0, 0, BasePane.Width";
_basepane.AddView((javafx.scene.Node)(_touchpanel.getObject()),0,0,_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 147;BA.debugLine="LabelTitle = CreateLabel";
_labeltitle = _createlabel();
 //BA.debugLineNum = 148;BA.debugLine="BasePane.AddView(LabelTitle, 0, 0, BasePane.Width";
_basepane.AddView((javafx.scene.Node)(_labeltitle.getObject()),0,0,_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 149;BA.debugLine="LabelValue = CreateLabel";
_labelvalue = _createlabel();
 //BA.debugLineNum = 150;BA.debugLine="BasePane.AddView(LabelValue, 0, 0, BasePane.Width";
_basepane.AddView((javafx.scene.Node)(_labelvalue.getObject()),0,0,_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 151;BA.debugLine="LabelUnit = CreateLabel";
_labelunit = _createlabel();
 //BA.debugLineNum = 152;BA.debugLine="BasePane.AddView(LabelUnit, 0, 0, BasePane.Width,";
_basepane.AddView((javafx.scene.Node)(_labelunit.getObject()),0,0,_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 154;BA.debugLine="LabelTitle.Text		= Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 155;BA.debugLine="LabelValue.Text		= Props.Get(\"Value\")";
_labelvalue.setText(BA.ObjectToString(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 156;BA.debugLine="LabelUnit.Text		= Props.Get(\"Unit\")";
_labelunit.setText(BA.ObjectToString(_props.Get((Object)("Unit"))));
 //BA.debugLineNum = 158;BA.debugLine="mShowValue			= Props.GetDefault(\"ShowValue\", True";
_mshowvalue = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowValue"),(Object)(__c.True)));
 //BA.debugLineNum = 159;BA.debugLine="LabelValue.Visible	= mShowValue";
_labelvalue.setVisible(_mshowvalue);
 //BA.debugLineNum = 160;BA.debugLine="LabelValue.Enabled	= mShowValue";
_labelvalue.setEnabled(_mshowvalue);
 //BA.debugLineNum = 163;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 164;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public String  _drawsliders() throws Exception{
float _x1 = 0f;
float _y1 = 0f;
float _x2 = 0f;
float _y2 = 0f;
int _y = 0;
int _w = 0;
int _i = 0;
float _xtick = 0f;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
int _tickval = 0;
int _x = 0;
float _dy = 0f;
double _yoffset = 0;
float _df = 0f;
float _ytick = 0f;
float _x2tick = 0f;
float _dytick = 0f;
 //BA.debugLineNum = 195;BA.debugLine="Public Sub DrawSliders";
 //BA.debugLineNum = 196;BA.debugLine="Dim x1,y1,x2,y2 As Float";
_x1 = 0f;
_y1 = 0f;
_x2 = 0f;
_y2 = 0f;
 //BA.debugLineNum = 199;BA.debugLine="CanvasSeekBar.ClearRect(CanvasSeekBar.TargetRect)";
_canvasseekbar.ClearRect(_canvasseekbar.getTargetRect());
 //BA.debugLineNum = 204;BA.debugLine="If Not(mVertical) Then";
if (__c.Not(_mvertical)) { 
 //BA.debugLineNum = 205;BA.debugLine="mSize = BasePane.Width - 2 * mThumbRadiusPressed";
_msize = (int) (_basepane.getWidth()-2*_mthumbradiuspressed);
 //BA.debugLineNum = 208;BA.debugLine="If mSize <= 0 Then Return";
if (_msize<=0) { 
if (true) return "";};
 //BA.debugLineNum = 209;BA.debugLine="Dim y As Int = (BasePane.Height / 2)";
_y = (int) ((_basepane.getHeight()/(double)2));
 //BA.debugLineNum = 210;BA.debugLine="Dim w As Int = mThumbRadiusPressed + (mValue - m";
_w = (int) (_mthumbradiuspressed+(_mvalue-_mminvalue)/(double)(_mmaxvalue-_mminvalue)*_msize);
 //BA.debugLineNum = 213;BA.debugLine="x1 = mThumbRadiusPressed";
_x1 = (float) (_mthumbradiuspressed);
 //BA.debugLineNum = 214;BA.debugLine="y1 = y";
_y1 = (float) (_y);
 //BA.debugLineNum = 215;BA.debugLine="x2 = w";
_x2 = (float) (_w);
 //BA.debugLineNum = 216;BA.debugLine="y2 = y";
_y2 = (float) (_y);
 //BA.debugLineNum = 217;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorLev";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolorlevel,(float) (_mactivebarwidth));
 //BA.debugLineNum = 220;BA.debugLine="x1 = w";
_x1 = (float) (_w);
 //BA.debugLineNum = 221;BA.debugLine="y1 = y";
_y1 = (float) (_y);
 //BA.debugLineNum = 222;BA.debugLine="x2 = BasePane.Width - mThumbRadiusPressed";
_x2 = (float) (_basepane.getWidth()-_mthumbradiuspressed);
 //BA.debugLineNum = 223;BA.debugLine="y2 = y";
_y2 = (float) (_y);
 //BA.debugLineNum = 224;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorTra";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolortrack,(float) (_minactivebarwidth));
 //BA.debugLineNum = 227;BA.debugLine="If mShowThumb Then";
if (_mshowthumb) { 
 //BA.debugLineNum = 228;BA.debugLine="CanvasSeekBar.DrawCircle(w, y, mThumbRadius, mT";
_canvasseekbar.DrawCircle((float) (_w),(float) (_y),(float) (_mthumbradius),_mthumbcolor,__c.True,(float) (0));
 //BA.debugLineNum = 229;BA.debugLine="If Pressed Then CanvasSeekBar.DrawCircle(w, y,";
if (_pressed) { 
_canvasseekbar.DrawCircle((float) (_w),(float) (_y),(float) (_mthumbradiuspressed),_mthumbcolor,__c.True,(float) (0));};
 };
 //BA.debugLineNum = 233;BA.debugLine="If mShowTicks And mTickCount > 1 Then";
if (_mshowticks && _mtickcount>1) { 
 //BA.debugLineNum = 234;BA.debugLine="For i = 0 To mTickCount - 1";
{
final int step23 = 1;
final int limit23 = (int) (_mtickcount-1);
_i = (int) (0) ;
for (;_i <= limit23 ;_i = _i + step23 ) {
 //BA.debugLineNum = 235;BA.debugLine="Dim xTick As Float = mThumbRadiusPressed + i *";
_xtick = (float) (_mthumbradiuspressed+_i*_msize/(double)(_mtickcount-1));
 //BA.debugLineNum = 238;BA.debugLine="x1 = xTick";
_x1 = _xtick;
 //BA.debugLineNum = 239;BA.debugLine="y1 = (BasePane.Height / 2) + (mActiveBarWidth";
_y1 = (float) ((_basepane.getHeight()/(double)2)+(_mactivebarwidth/(double)2));
 //BA.debugLineNum = 240;BA.debugLine="x2 = xTick";
_x2 = _xtick;
 //BA.debugLineNum = 241;BA.debugLine="y2 = y1 + mActiveBarWidth";
_y2 = (float) (_y1+_mactivebarwidth);
 //BA.debugLineNum = 246;BA.debugLine="If i = 0 Or i = mTickCount - 1 Then";
if (_i==0 || _i==_mtickcount-1) { 
 //BA.debugLineNum = 247;BA.debugLine="y1 = y1 - (mActiveBarWidth / 2)";
_y1 = (float) (_y1-(_mactivebarwidth/(double)2));
 };
 //BA.debugLineNum = 249;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mTickVa";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mtickvaluecolor,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 256;BA.debugLine="Dim fnt As B4XFont = xui.CreateDefaultFont(mTi";
_fnt = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_fnt = _xui.CreateDefaultFont((float) (_mtickfontsize));
 //BA.debugLineNum = 258;BA.debugLine="Dim tickVal As Int = mMinValue + i * (mMaxValu";
_tickval = (int) (_mminvalue+_i*(_mmaxvalue-_mminvalue)/(double)(_mtickcount-1));
 //BA.debugLineNum = 259;BA.debugLine="x1 = xTick";
_x1 = _xtick;
 //BA.debugLineNum = 260;BA.debugLine="y1 = y2	+ mThumbRadius * 2";
_y1 = (float) (_y2+_mthumbradius*2);
 //BA.debugLineNum = 266;BA.debugLine="CanvasSeekBar.DrawText(tickVal, x1, y1, fnt, m";
_canvasseekbar.DrawText(BA.NumberToString(_tickval),_x1,_y1,_fnt,_mtickvaluecolor,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"CENTER"));
 }
};
 };
 };
 //BA.debugLineNum = 274;BA.debugLine="If mVertical Then";
if (_mvertical) { 
 //BA.debugLineNum = 275;BA.debugLine="Dim x As Int	= BasePane.Width / 2";
_x = (int) (_basepane.getWidth()/(double)2);
 //BA.debugLineNum = 276;BA.debugLine="Dim dy As Float";
_dy = 0f;
 //BA.debugLineNum = 277;BA.debugLine="Dim yoffset As Double";
_yoffset = 0;
 //BA.debugLineNum = 279;BA.debugLine="yoffset = LabelTitle.Top + LabelTitle.Height";
_yoffset = _labeltitle.getTop()+_labeltitle.getHeight();
 //BA.debugLineNum = 280;BA.debugLine="If mShowValue Then";
if (_mshowvalue) { 
 //BA.debugLineNum = 281;BA.debugLine="yoffset = yoffset + LabelValue.Height";
_yoffset = _yoffset+_labelvalue.getHeight();
 };
 //BA.debugLineNum = 287;BA.debugLine="mBarTop = yoffset";
_mbartop = _yoffset;
 //BA.debugLineNum = 289;BA.debugLine="mBarBottom = LabelUnit.top - 2dip	' BasePane.Hei";
_mbarbottom = _labelunit.getTop()-__c.DipToCurrent((int) (2));
 //BA.debugLineNum = 290;BA.debugLine="mSize = mBarBottom - mBarTop";
_msize = (int) (_mbarbottom-_mbartop);
 //BA.debugLineNum = 292;BA.debugLine="If mSize <= 0 Then Return";
if (_msize<=0) { 
if (true) return "";};
 //BA.debugLineNum = 294;BA.debugLine="x1 = x";
_x1 = (float) (_x);
 //BA.debugLineNum = 295;BA.debugLine="y1 = mBarTop";
_y1 = (float) (_mbartop);
 //BA.debugLineNum = 296;BA.debugLine="x2 = x1";
_x2 = _x1;
 //BA.debugLineNum = 297;BA.debugLine="y2 = mBarBottom";
_y2 = (float) (_mbarbottom);
 //BA.debugLineNum = 298;BA.debugLine="dy = y2 - y1";
_dy = (float) (_y2-_y1);
 //BA.debugLineNum = 301;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorTra";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolortrack,(float) (_minactivebarwidth));
 //BA.debugLineNum = 307;BA.debugLine="Dim df As Float	= mValue / (mMaxValue - mMinValu";
_df = (float) (_mvalue/(double)(_mmaxvalue-_mminvalue));
 //BA.debugLineNum = 308;BA.debugLine="x1 = x";
_x1 = (float) (_x);
 //BA.debugLineNum = 309;BA.debugLine="y1 = y2 - ((y2 - y1) * df)";
_y1 = (float) (_y2-((_y2-_y1)*_df));
 //BA.debugLineNum = 310;BA.debugLine="x2 = x1";
_x2 = _x1;
 //BA.debugLineNum = 311;BA.debugLine="y2 = y2";
_y2 = _y2;
 //BA.debugLineNum = 312;BA.debugLine="CanvasSeekBar.DrawLine(x1,y1,x2,y2, mColorLevel,";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolorlevel,(float) (_mactivebarwidth));
 //BA.debugLineNum = 317;BA.debugLine="If mShowThumb Then";
if (_mshowthumb) { 
 //BA.debugLineNum = 318;BA.debugLine="CanvasSeekBar.DrawCircle(x, y1, mThumbRadius, m";
_canvasseekbar.DrawCircle((float) (_x),_y1,(float) (_mthumbradius),_mthumbcolor,__c.True,(float) (0));
 //BA.debugLineNum = 319;BA.debugLine="If Pressed Then CanvasSeekBar.DrawCircle(x, y1,";
if (_pressed) { 
_canvasseekbar.DrawCircle((float) (_x),_y1,(float) (_mthumbradiuspressed),_mthumbcolor,__c.True,(float) (0));};
 };
 //BA.debugLineNum = 323;BA.debugLine="Dim yTick As Float";
_ytick = 0f;
 //BA.debugLineNum = 324;BA.debugLine="Dim x2Tick As Float";
_x2tick = 0f;
 //BA.debugLineNum = 325;BA.debugLine="Dim dyTick As Float = (dy / (mTickCount - 1))";
_dytick = (float) ((_dy/(double)(_mtickcount-1)));
 //BA.debugLineNum = 328;BA.debugLine="If mShowTicks And mTickCount > 2 Then";
if (_mshowticks && _mtickcount>2) { 
 //BA.debugLineNum = 329;BA.debugLine="For i = 0 To mTickCount - 1";
{
final int step73 = 1;
final int limit73 = (int) (_mtickcount-1);
_i = (int) (0) ;
for (;_i <= limit73 ;_i = _i + step73 ) {
 //BA.debugLineNum = 330;BA.debugLine="yTick = mBarTop + (i * dyTick)";
_ytick = (float) (_mbartop+(_i*_dytick));
 //BA.debugLineNum = 333;BA.debugLine="x2Tick = x - (mInActiveBarWidth / 2)";
_x2tick = (float) (_x-(_minactivebarwidth/(double)2));
 //BA.debugLineNum = 334;BA.debugLine="If i = 0 Or i = mTickCount - 1 Then x2Tick = x";
if (_i==0 || _i==_mtickcount-1) { 
_x2tick = (float) (_x+(_minactivebarwidth/(double)2));};
 //BA.debugLineNum = 335;BA.debugLine="CanvasSeekBar.DrawLine(x - (mInActiveBarWidth/";
_canvasseekbar.DrawLine((float) (_x-(_minactivebarwidth/(double)2)-__c.DipToCurrent((int) (4))),_ytick,_x2tick,_ytick,_mtickvaluecolor,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 338;BA.debugLine="Dim tickVal As Int = mMaxValue - i * (mMaxValu";
_tickval = (int) (_mmaxvalue-_i*(_mmaxvalue-_mminvalue)/(double)(_mtickcount-1));
 //BA.debugLineNum = 339;BA.debugLine="CanvasSeekBar.DrawText(tickVal, x - (mInActive";
_canvasseekbar.DrawText(BA.NumberToString(_tickval),_x-(_minactivebarwidth/(double)2)-__c.DipToCurrent((int) (8)),_ytick+__c.DipToCurrent((int) (4)),_xui.CreateDefaultFont((float) (_mtickfontsize)),_mtickvaluecolor,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"RIGHT"));
 }
};
 };
 };
 //BA.debugLineNum = 347;BA.debugLine="CanvasSeekBar.Invalidate";
_canvasseekbar.Invalidate();
 //BA.debugLineNum = 349;BA.debugLine="LabelValue.Text	= mValue";
_labelvalue.setText(BA.NumberToString(_mvalue));
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public int  _getactivebarwidth() throws Exception{
 //BA.debugLineNum = 379;BA.debugLine="Public Sub getActiveBarWidth As Int";
 //BA.debugLineNum = 380;BA.debugLine="Return mActiveBarWidth";
if (true) return _mactivebarwidth;
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return 0;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 541;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 542;BA.debugLine="Return BasePane.Enabled";
if (true) return _basepane.getEnabled();
 //BA.debugLineNum = 543;BA.debugLine="End Sub";
return false;
}
public int  _getinactivebarwidth() throws Exception{
 //BA.debugLineNum = 392;BA.debugLine="Public Sub getInActiveBarWidth As Int";
 //BA.debugLineNum = 393;BA.debugLine="Return mInActiveBarWidth";
if (true) return _minactivebarwidth;
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return 0;
}
public int  _getinterval() throws Exception{
 //BA.debugLineNum = 485;BA.debugLine="Public Sub getInterval As Int";
 //BA.debugLineNum = 486;BA.debugLine="Return mInterval";
if (true) return _minterval;
 //BA.debugLineNum = 487;BA.debugLine="End Sub";
return 0;
}
public int  _getmaxvalue() throws Exception{
 //BA.debugLineNum = 531;BA.debugLine="Public Sub getMaxValue As Int";
 //BA.debugLineNum = 532;BA.debugLine="Return mMaxValue";
if (true) return _mmaxvalue;
 //BA.debugLineNum = 533;BA.debugLine="End Sub";
return 0;
}
public int  _getminvalue() throws Exception{
 //BA.debugLineNum = 520;BA.debugLine="Public Sub getMinValue As Int";
 //BA.debugLineNum = 521;BA.debugLine="Return mMinValue";
if (true) return _mminvalue;
 //BA.debugLineNum = 522;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowthumb() throws Exception{
 //BA.debugLineNum = 440;BA.debugLine="Public Sub getShowThumb As Boolean";
 //BA.debugLineNum = 441;BA.debugLine="Return mShowThumb";
if (true) return _mshowthumb;
 //BA.debugLineNum = 442;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowticks() throws Exception{
 //BA.debugLineNum = 451;BA.debugLine="Public Sub getShowTicks As Boolean";
 //BA.debugLineNum = 452;BA.debugLine="Return mShowTicks";
if (true) return _mshowticks;
 //BA.debugLineNum = 453;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowvalue() throws Exception{
 //BA.debugLineNum = 509;BA.debugLine="Public Sub getShowValue As Boolean";
 //BA.debugLineNum = 510;BA.debugLine="Return mShowValue";
if (true) return _mshowvalue;
 //BA.debugLineNum = 511;BA.debugLine="End Sub";
return false;
}
public int  _getthumbcolor() throws Exception{
 //BA.debugLineNum = 429;BA.debugLine="Public Sub getThumbColor As Int";
 //BA.debugLineNum = 430;BA.debugLine="Return mThumbColor";
if (true) return _mthumbcolor;
 //BA.debugLineNum = 431;BA.debugLine="End Sub";
return 0;
}
public int  _getthumbradius() throws Exception{
 //BA.debugLineNum = 405;BA.debugLine="Public Sub getThumbRadius As Int";
 //BA.debugLineNum = 406;BA.debugLine="Return mThumbRadius";
if (true) return _mthumbradius;
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return 0;
}
public int  _getthumbradiuspressed() throws Exception{
 //BA.debugLineNum = 418;BA.debugLine="Public Sub getThumbRadiusPressed As Int";
 //BA.debugLineNum = 419;BA.debugLine="Return mThumbRadiusPressed";
if (true) return _mthumbradiuspressed;
 //BA.debugLineNum = 420;BA.debugLine="End Sub";
return 0;
}
public int  _gettickcount() throws Exception{
 //BA.debugLineNum = 463;BA.debugLine="Public Sub getTickCount As Int";
 //BA.debugLineNum = 464;BA.debugLine="Return mTickCount";
if (true) return _mtickcount;
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return 0;
}
public int  _gettickvaluecolor() throws Exception{
 //BA.debugLineNum = 474;BA.debugLine="Public Sub getTickValueColor As Int";
 //BA.debugLineNum = 475;BA.debugLine="Return mTickValueColor";
if (true) return _mtickvaluecolor;
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return 0;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 359;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 360;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 366;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 367;BA.debugLine="Return LabelUnit.Text";
if (true) return _labelunit.getText();
 //BA.debugLineNum = 368;BA.debugLine="End Sub";
return "";
}
public int  _getvalue() throws Exception{
 //BA.debugLineNum = 496;BA.debugLine="Public Sub getValue As Int";
 //BA.debugLineNum = 497;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 498;BA.debugLine="End Sub";
return 0;
}
public boolean  _getvertical() throws Exception{
 //BA.debugLineNum = 553;BA.debugLine="Public Sub getVertical As Boolean";
 //BA.debugLineNum = 554;BA.debugLine="Return mVertical";
if (true) return _mvertical;
 //BA.debugLineNum = 555;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 95;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 96;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 97;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public String  _raisetouchstateevent() throws Exception{
 //BA.debugLineNum = 618;BA.debugLine="Private Sub RaiseTouchStateEvent";
 //BA.debugLineNum = 619;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_TouchS";
if (_xui.SubExists(ba,_mcallback,_meventname+"_TouchStateChanged",(int) (1))) { 
 //BA.debugLineNum = 620;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_TouchS";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_TouchStateChanged",(Object)(_pressed));
 };
 //BA.debugLineNum = 622;BA.debugLine="End Sub";
return "";
}
public String  _setactivebarwidth(int _width) throws Exception{
 //BA.debugLineNum = 373;BA.debugLine="Public Sub setActiveBarWidth(width As Int)";
 //BA.debugLineNum = 374;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 375;BA.debugLine="If width > BasePane.Width Then width = BasePane.W";
if (_width>_basepane.getWidth()) { 
_width = (int) (_basepane.getWidth());};
 //BA.debugLineNum = 376;BA.debugLine="mActiveBarWidth = width";
_mactivebarwidth = _width;
 //BA.debugLineNum = 377;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _state) throws Exception{
 //BA.debugLineNum = 538;BA.debugLine="Public Sub setEnabled(state As Boolean)";
 //BA.debugLineNum = 539;BA.debugLine="BasePane.Enabled = state";
_basepane.setEnabled(_state);
 //BA.debugLineNum = 540;BA.debugLine="End Sub";
return "";
}
public String  _setinactivebarwidth(int _width) throws Exception{
 //BA.debugLineNum = 386;BA.debugLine="Public Sub setInActiveBarWidth(width As Int)";
 //BA.debugLineNum = 387;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 388;BA.debugLine="If width > BasePane.Width Then width = BasePane.W";
if (_width>_basepane.getWidth()) { 
_width = (int) (_basepane.getWidth());};
 //BA.debugLineNum = 389;BA.debugLine="mInActiveBarWidth = width";
_minactivebarwidth = _width;
 //BA.debugLineNum = 390;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 391;BA.debugLine="End Sub";
return "";
}
public String  _setinterval(int _interval) throws Exception{
 //BA.debugLineNum = 481;BA.debugLine="Public Sub setInterval(interval As Int)";
 //BA.debugLineNum = 482;BA.debugLine="mInterval = interval";
_minterval = _interval;
 //BA.debugLineNum = 483;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 484;BA.debugLine="End Sub";
return "";
}
public String  _setmaxvalue(int _v) throws Exception{
 //BA.debugLineNum = 527;BA.debugLine="Public Sub setMaxValue(v As Int)";
 //BA.debugLineNum = 528;BA.debugLine="mMaxValue = v";
_mmaxvalue = _v;
 //BA.debugLineNum = 529;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 530;BA.debugLine="End Sub";
return "";
}
public String  _setminvalue(int _v) throws Exception{
 //BA.debugLineNum = 516;BA.debugLine="Public Sub setMinValue(v As Int)";
 //BA.debugLineNum = 517;BA.debugLine="mMinValue = v";
_mminvalue = _v;
 //BA.debugLineNum = 518;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 519;BA.debugLine="End Sub";
return "";
}
public String  _setshowthumb(boolean _state) throws Exception{
 //BA.debugLineNum = 436;BA.debugLine="Public Sub setShowThumb(state As Boolean)";
 //BA.debugLineNum = 437;BA.debugLine="mShowThumb = state";
_mshowthumb = _state;
 //BA.debugLineNum = 438;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public String  _setshowticks(boolean _state) throws Exception{
 //BA.debugLineNum = 447;BA.debugLine="Public Sub setShowTicks(state As Boolean)";
 //BA.debugLineNum = 448;BA.debugLine="mShowTicks = state";
_mshowticks = _state;
 //BA.debugLineNum = 449;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 450;BA.debugLine="End Sub";
return "";
}
public String  _setshowvalue(boolean _visible) throws Exception{
 //BA.debugLineNum = 503;BA.debugLine="Public Sub setShowValue(visible As Boolean)";
 //BA.debugLineNum = 504;BA.debugLine="mShowValue = visible";
_mshowvalue = _visible;
 //BA.debugLineNum = 505;BA.debugLine="LabelValue.Visible = mShowValue";
_labelvalue.setVisible(_mshowvalue);
 //BA.debugLineNum = 506;BA.debugLine="LabelValue.Enabled = mShowValue";
_labelvalue.setEnabled(_mshowvalue);
 //BA.debugLineNum = 507;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 508;BA.debugLine="End Sub";
return "";
}
public String  _setthumbcolor(int _clr) throws Exception{
 //BA.debugLineNum = 425;BA.debugLine="Public Sub setThumbColor(clr As Int)";
 //BA.debugLineNum = 426;BA.debugLine="mThumbColor = clr";
_mthumbcolor = _clr;
 //BA.debugLineNum = 427;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 428;BA.debugLine="End Sub";
return "";
}
public String  _setthumbradius(int _width) throws Exception{
 //BA.debugLineNum = 399;BA.debugLine="Public Sub setThumbRadius(width As Int)";
 //BA.debugLineNum = 400;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 401;BA.debugLine="If width > BasePane.Width Then width = BasePane.W";
if (_width>_basepane.getWidth()) { 
_width = (int) (_basepane.getWidth());};
 //BA.debugLineNum = 402;BA.debugLine="mThumbRadius = width";
_mthumbradius = _width;
 //BA.debugLineNum = 403;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 404;BA.debugLine="End Sub";
return "";
}
public String  _setthumbradiuspressed(int _width) throws Exception{
 //BA.debugLineNum = 412;BA.debugLine="Public Sub setThumbRadiusPressed(width As Int)";
 //BA.debugLineNum = 413;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 414;BA.debugLine="If width > BasePane.Width Then width = BasePane.W";
if (_width>_basepane.getWidth()) { 
_width = (int) (_basepane.getWidth());};
 //BA.debugLineNum = 415;BA.debugLine="mThumbRadiusPressed = width";
_mthumbradiuspressed = _width;
 //BA.debugLineNum = 416;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 417;BA.debugLine="End Sub";
return "";
}
public String  _settickcount(int _count) throws Exception{
 //BA.debugLineNum = 458;BA.debugLine="Public Sub setTickCount(count As Int)";
 //BA.debugLineNum = 459;BA.debugLine="If count < 0 Then count = 0";
if (_count<0) { 
_count = (int) (0);};
 //BA.debugLineNum = 460;BA.debugLine="mTickCount = count";
_mtickcount = _count;
 //BA.debugLineNum = 461;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 462;BA.debugLine="End Sub";
return "";
}
public String  _settickvaluecolor(int _clr) throws Exception{
 //BA.debugLineNum = 470;BA.debugLine="Public Sub setTickValueColor(clr As Int)";
 //BA.debugLineNum = 471;BA.debugLine="mTickValueColor = clr";
_mtickvaluecolor = _clr;
 //BA.debugLineNum = 472;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 357;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(_title);
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 363;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 364;BA.debugLine="LabelUnit.Text = unit";
_labelunit.setText(_unit);
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(int _v) throws Exception{
 //BA.debugLineNum = 492;BA.debugLine="Public Sub setValue(v As Int)";
 //BA.debugLineNum = 493;BA.debugLine="mValue = Max(mMinValue, Min(mMaxValue, v))";
_mvalue = (int) (__c.Max(_mminvalue,__c.Min(_mmaxvalue,_v)));
 //BA.debugLineNum = 494;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 495;BA.debugLine="End Sub";
return "";
}
public String  _setvaluebasedontouch(int _x,int _y) throws Exception{
int _v = 0;
int _newvalue = 0;
 //BA.debugLineNum = 624;BA.debugLine="Private Sub SetValueBasedOnTouch(x As Int, y As In";
 //BA.debugLineNum = 625;BA.debugLine="Dim v As Int";
_v = 0;
 //BA.debugLineNum = 626;BA.debugLine="If mVertical Then";
if (_mvertical) { 
 //BA.debugLineNum = 627;BA.debugLine="v = (mBarBottom - y) / mSize * (mMaxValue - mMin";
_v = (int) ((_mbarbottom-_y)/(double)_msize*(_mmaxvalue-_mminvalue)+_mminvalue);
 }else {
 //BA.debugLineNum = 630;BA.debugLine="v = (x - mThumbRadiusPressed) / mSize * (mMaxVal";
_v = (int) ((_x-_mthumbradiuspressed)/(double)_msize*(_mmaxvalue-_mminvalue)+_mminvalue);
 };
 //BA.debugLineNum = 632;BA.debugLine="v = Round(v / mInterval) * mInterval";
_v = (int) (__c.Round(_v/(double)_minterval)*_minterval);
 //BA.debugLineNum = 633;BA.debugLine="Dim NewValue As Int = Max(mMinValue, Min(mMaxValu";
_newvalue = (int) (__c.Max(_mminvalue,__c.Min(_mmaxvalue,_v)));
 //BA.debugLineNum = 634;BA.debugLine="If NewValue <> mValue Then";
if (_newvalue!=_mvalue) { 
 //BA.debugLineNum = 635;BA.debugLine="mValue = NewValue";
_mvalue = _newvalue;
 //BA.debugLineNum = 636;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Value";
if (_xui.SubExists(ba,_mcallback,_meventname+"_ValueChanged",(int) (1))) { 
 //BA.debugLineNum = 637;BA.debugLine="If mTouchStateChanged Then";
if (_mtouchstatechanged) { 
 //BA.debugLineNum = 638;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_Valu";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_ValueChanged",(Object)(_mvalue));
 };
 };
 };
 //BA.debugLineNum = 642;BA.debugLine="End Sub";
return "";
}
public String  _setvertical(boolean _state) throws Exception{
 //BA.debugLineNum = 549;BA.debugLine="Public Sub setVertical(state As Boolean)";
 //BA.debugLineNum = 550;BA.debugLine="mVertical = state";
_mvertical = _state;
 //BA.debugLineNum = 551;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 552;BA.debugLine="End Sub";
return "";
}
public String  _touchpanel_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 596;BA.debugLine="Private Sub TouchPanel_Touch(Action As Int, X As F";
 //BA.debugLineNum = 597;BA.debugLine="If Action = TouchPanel.TOUCH_ACTION_DOWN Then";
if (_action==_touchpanel.TOUCH_ACTION_DOWN) { 
 //BA.debugLineNum = 598;BA.debugLine="Pressed = True";
_pressed = __c.True;
 //BA.debugLineNum = 599;BA.debugLine="RaiseTouchStateEvent";
_raisetouchstateevent();
 //BA.debugLineNum = 600;BA.debugLine="SetValueBasedOnTouch(X, Y)";
_setvaluebasedontouch((int) (_x),(int) (_y));
 }else if(_action==_touchpanel.TOUCH_ACTION_MOVE) { 
 //BA.debugLineNum = 603;BA.debugLine="SetValueBasedOnTouch(X, Y)";
_setvaluebasedontouch((int) (_x),(int) (_y));
 }else if(_action==_touchpanel.TOUCH_ACTION_UP) { 
 //BA.debugLineNum = 606;BA.debugLine="Pressed = False";
_pressed = __c.False;
 //BA.debugLineNum = 607;BA.debugLine="RaiseTouchStateEvent";
_raisetouchstateevent();
 //BA.debugLineNum = 608;BA.debugLine="If Not(mTouchStateChanged) Then";
if (__c.Not(_mtouchstatechanged)) { 
 //BA.debugLineNum = 609;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Valu";
if (_xui.SubExists(ba,_mcallback,_meventname+"_ValueChanged",(int) (1))) { 
 //BA.debugLineNum = 610;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_Valu";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_ValueChanged",(Object)(_mvalue));
 };
 };
 };
 //BA.debugLineNum = 615;BA.debugLine="DrawSliders";
_drawsliders();
 //BA.debugLineNum = 616;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
