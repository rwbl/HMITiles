package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitileseekbar extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitileseekbar");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitileseekbar.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
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
public int _mcolorbar = 0;
public int _mcolorbarfill = 0;
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
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 630;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 631;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 632;BA.debugLine="HMITileUtils.ApplyValueStyle(LabelValue)";
_hmitileutils._applyvaluestyle /*String*/ (ba,_labelvalue);
 //BA.debugLineNum = 636;BA.debugLine="HMITileUtils.ApplyUnitStyle(LabelUnit)";
_hmitileutils._applyunitstyle /*String*/ (ba,_labelunit);
 //BA.debugLineNum = 641;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 642;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 643;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
double _newheight = 0;
double _unittop = 0;
 //BA.debugLineNum = 172;BA.debugLine="Public Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 174;BA.debugLine="If Not(LabelTitle.IsInitialized) Then";
if (__c.Not(_labeltitle.IsInitialized())) { 
 //BA.debugLineNum = 175;BA.debugLine="Log($\"[HMITileSeekBar.BaseResize] Seekbar not re";
__c.LogImpl("952822019",("[HMITileSeekBar.BaseResize] Seekbar not ready."),0);
 //BA.debugLineNum = 176;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 178;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 179;BA.debugLine="Dim newheight As Double = Height";
_newheight = _height;
 //BA.debugLineNum = 180;BA.debugLine="Dim unittop As Double	= Height * 0.80";
_unittop = _height*0.80;
 //BA.debugLineNum = 185;BA.debugLine="If Height > HMITileUtils.TILE_DEFAULT_SIZE Then";
if (_height>_hmitileutils._tile_default_size /*int*/ ) { 
 //BA.debugLineNum = 186;BA.debugLine="newheight = HMITileUtils.TILE_DEFAULT_SIZE";
_newheight = _hmitileutils._tile_default_size /*int*/ ;
 //BA.debugLineNum = 187;BA.debugLine="unittop = Height * 0.9";
_unittop = _height*0.9;
 };
 //BA.debugLineNum = 189;BA.debugLine="LabelTitle.SetLayoutAnimated	(0, 0,            pa";
_labeltitle.SetLayoutAnimated((int) (0),(int) (0),_pad,(int) (_width),(int) (_newheight*0.3));
 //BA.debugLineNum = 190;BA.debugLine="LabelValue.SetLayoutAnimated	(0, 0,            ne";
_labelvalue.SetLayoutAnimated((int) (0),(int) (0),(int) (_newheight*0.3),(int) (_width),(int) (_newheight*0.3));
 //BA.debugLineNum = 191;BA.debugLine="LabelUnit.SetLayoutAnimated		(0, 0,            un";
_labelunit.SetLayoutAnimated((int) (0),(int) (0),(int) (_unittop),(int) (_width),(int) (_newheight*0.2));
 //BA.debugLineNum = 205;BA.debugLine="TouchPanel.SetLayoutAnimated(0, 0, 0, Width, Heig";
_touchpanel.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 //BA.debugLineNum = 207;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 42;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 43;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 46;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 47;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private CanvasSeekBar As B4XCanvas";
_canvasseekbar = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 51;BA.debugLine="Private PaneSeekBar As B4XView";
_paneseekbar = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private TouchPanel As B4XView";
_touchpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private mTouchStateChanged As Boolean";
_mtouchstatechanged = false;
 //BA.debugLineNum = 56;BA.debugLine="Private Pressed As Boolean";
_pressed = false;
 //BA.debugLineNum = 59;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private LabelValue As B4XView";
_labelvalue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private mShowValue As Boolean";
_mshowvalue = false;
 //BA.debugLineNum = 62;BA.debugLine="Private LabelUnit As B4XView";
_labelunit = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private mValue As Int";
_mvalue = 0;
 //BA.debugLineNum = 66;BA.debugLine="Private mMinValue As Int";
_mminvalue = 0;
 //BA.debugLineNum = 67;BA.debugLine="Private mMaxValue As Int";
_mmaxvalue = 0;
 //BA.debugLineNum = 68;BA.debugLine="Private mInterval As Int = 1";
_minterval = (int) (1);
 //BA.debugLineNum = 74;BA.debugLine="Private mShowThumb As Boolean";
_mshowthumb = false;
 //BA.debugLineNum = 75;BA.debugLine="Private mThumbRadius As Int = 8dip     		' thumb";
_mthumbradius = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 76;BA.debugLine="Private mThumbRadiusPressed As Int = 18dip	' pres";
_mthumbradiuspressed = __c.DipToCurrent((int) (18));
 //BA.debugLineNum = 77;BA.debugLine="Private mThumbColor As Int					' Thumb color if n";
_mthumbcolor = 0;
 //BA.debugLineNum = 80;BA.debugLine="Private mColorBar As Int					' Base color";
_mcolorbar = 0;
 //BA.debugLineNum = 81;BA.debugLine="Private mColorBarFill As Int				' Color when thum";
_mcolorbarfill = 0;
 //BA.debugLineNum = 82;BA.debugLine="Private mBarTop As Double";
_mbartop = 0;
 //BA.debugLineNum = 83;BA.debugLine="Private mBarBottom As Double";
_mbarbottom = 0;
 //BA.debugLineNum = 86;BA.debugLine="Private mActiveBarWidth As Int";
_mactivebarwidth = 0;
 //BA.debugLineNum = 87;BA.debugLine="Private mInActiveBarWidth As Int";
_minactivebarwidth = 0;
 //BA.debugLineNum = 88;BA.debugLine="Private mVertical As Boolean";
_mvertical = false;
 //BA.debugLineNum = 89;BA.debugLine="Private mSize As Int";
_msize = 0;
 //BA.debugLineNum = 92;BA.debugLine="Private mShowTicks As Boolean";
_mshowticks = false;
 //BA.debugLineNum = 93;BA.debugLine="Private mTickCount As Int";
_mtickcount = 0;
 //BA.debugLineNum = 94;BA.debugLine="Private mTickFontSize As Int";
_mtickfontsize = 0;
 //BA.debugLineNum = 95;BA.debugLine="Private mTickValueColor As Int		' Tick value colo";
_mtickvaluecolor = 0;
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _lblx = null;
 //BA.debugLineNum = 615;BA.debugLine="Private Sub CreateLabel As B4XView";
 //BA.debugLineNum = 616;BA.debugLine="Dim lblx As B4XView = XUIViewsUtils.CreateLabel";
_lblx = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lblx = _xuiviewsutils._createlabel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (ba);
 //BA.debugLineNum = 617;BA.debugLine="lblx.Font = xui.CreateDefaultFont(HMITileUtils.TE";
_lblx.setFont(_xui.CreateDefaultFont(_hmitileutils._text_size_state /*float*/ ));
 //BA.debugLineNum = 618;BA.debugLine="lblx.Text = \"LABEL\"";
_lblx.setText(BA.ObjectToCharSequence("LABEL"));
 //BA.debugLineNum = 619;BA.debugLine="lblx.SetTextAlignment(\"CENTER\", \"CENTER\")";
_lblx.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 620;BA.debugLine="lblx.TextColor = HMITileUtils.COLOR_TEXT_PRIMARY";
_lblx.setTextColor(_hmitileutils._color_text_primary /*int*/ );
 //BA.debugLineNum = 622;BA.debugLine="Return lblx";
if (true) return _lblx;
 //BA.debugLineNum = 623;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 106;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 107;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 110;BA.debugLine="mColorBar 			= xui.PaintOrColorToColor(Props.Get(";
_mcolorbar = _xui.PaintOrColorToColor(_props.Get((Object)("ColorBar")));
 //BA.debugLineNum = 111;BA.debugLine="mColorBarFill 		= xui.PaintOrColorToColor(Props.G";
_mcolorbarfill = _xui.PaintOrColorToColor(_props.Get((Object)("ColorBarFill")));
 //BA.debugLineNum = 112;BA.debugLine="mActiveBarWidth 	= Props.Get(\"ActiveBarWidth\")";
_mactivebarwidth = (int)(BA.ObjectToNumber(_props.Get((Object)("ActiveBarWidth"))));
 //BA.debugLineNum = 113;BA.debugLine="mInActiveBarWidth 	= Props.Get(\"InActiveBarWidth\"";
_minactivebarwidth = (int)(BA.ObjectToNumber(_props.Get((Object)("InActiveBarWidth"))));
 //BA.debugLineNum = 115;BA.debugLine="mTouchStateChanged 	= Props.Get(\"TouchStateChange";
_mtouchstatechanged = BA.ObjectToBoolean(_props.Get((Object)("TouchStateChanged")));
 //BA.debugLineNum = 117;BA.debugLine="mThumbRadius		= Props.Get(\"ThumbRadius\")";
_mthumbradius = (int)(BA.ObjectToNumber(_props.Get((Object)("ThumbRadius"))));
 //BA.debugLineNum = 118;BA.debugLine="mThumbRadiusPressed	= Props.Get(\"ThumbRadiusPress";
_mthumbradiuspressed = (int)(BA.ObjectToNumber(_props.Get((Object)("ThumbRadiusPressed"))));
 //BA.debugLineNum = 119;BA.debugLine="mThumbColor			= xui.PaintOrColorToColor(Props.Get";
_mthumbcolor = _xui.PaintOrColorToColor(_props.Get((Object)("ThumbColor")));
 //BA.debugLineNum = 120;BA.debugLine="mShowThumb			= Props.Get(\"ShowThumb\")";
_mshowthumb = BA.ObjectToBoolean(_props.Get((Object)("ShowThumb")));
 //BA.debugLineNum = 122;BA.debugLine="mShowTicks			= Props.Get(\"ShowTicks\")";
_mshowticks = BA.ObjectToBoolean(_props.Get((Object)("ShowTicks")));
 //BA.debugLineNum = 123;BA.debugLine="mTickCount			= Props.Get(\"TickCount\")";
_mtickcount = (int)(BA.ObjectToNumber(_props.Get((Object)("TickCount"))));
 //BA.debugLineNum = 124;BA.debugLine="mTickValueColor 	= xui.PaintOrColorToColor(Props.";
_mtickvaluecolor = _xui.PaintOrColorToColor(_props.Get((Object)("TickValueColor")));
 //BA.debugLineNum = 126;BA.debugLine="mTickFontSize		= HMITileUtils.TEXT_SIZE_LABEL";
_mtickfontsize = (int) (_hmitileutils._text_size_label /*float*/ );
 //BA.debugLineNum = 131;BA.debugLine="mTickFontSize		= HMITileUtils.TEXT_SIZE_SMALL";
_mtickfontsize = (int) (_hmitileutils._text_size_small /*float*/ );
 //BA.debugLineNum = 132;BA.debugLine="mInterval 			= Max(1, Props.GetDefault(\"Interval\"";
_minterval = (int) (__c.Max(1,(double)(BA.ObjectToNumber(_props.GetDefault((Object)("Interval"),(Object)(1))))));
 //BA.debugLineNum = 134;BA.debugLine="mMinValue 			= Props.Get(\"Min\")";
_mminvalue = (int)(BA.ObjectToNumber(_props.Get((Object)("Min"))));
 //BA.debugLineNum = 135;BA.debugLine="mMaxValue 			= Props.Get(\"Max\")";
_mmaxvalue = (int)(BA.ObjectToNumber(_props.Get((Object)("Max"))));
 //BA.debugLineNum = 136;BA.debugLine="mValue 				= Max(mMinValue, Min(mMaxValue, Props.";
_mvalue = (int) (__c.Max(_mminvalue,__c.Min(_mmaxvalue,(double)(BA.ObjectToNumber(_props.Get((Object)("Value")))))));
 //BA.debugLineNum = 138;BA.debugLine="mVertical			= Props.Get(\"Vertical\")";
_mvertical = BA.ObjectToBoolean(_props.Get((Object)("Vertical")));
 //BA.debugLineNum = 141;BA.debugLine="PaneSeekBar = xui.CreatePanel(\"\")";
_paneseekbar = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 142;BA.debugLine="mBase.AddView(PaneSeekBar, 0, 0, mBase.Width, mBa";
_mbase.AddView((android.view.View)(_paneseekbar.getObject()),(int) (0),(int) (0),_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 143;BA.debugLine="CanvasSeekBar.Initialize(PaneSeekBar)";
_canvasseekbar.Initialize(_paneseekbar);
 //BA.debugLineNum = 145;BA.debugLine="TouchPanel = xui.CreatePanel(\"TouchPanel\")";
_touchpanel = _xui.CreatePanel(ba,"TouchPanel");
 //BA.debugLineNum = 146;BA.debugLine="mBase.AddView(TouchPanel, 0, 0, mBase.Width, mBas";
_mbase.AddView((android.view.View)(_touchpanel.getObject()),(int) (0),(int) (0),_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 151;BA.debugLine="LabelTitle = CreateLabel";
_labeltitle = _createlabel();
 //BA.debugLineNum = 152;BA.debugLine="mBase.AddView(LabelTitle, 0, 0, mBase.Width, mBas";
_mbase.AddView((android.view.View)(_labeltitle.getObject()),(int) (0),(int) (0),_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 153;BA.debugLine="LabelValue = CreateLabel";
_labelvalue = _createlabel();
 //BA.debugLineNum = 154;BA.debugLine="mBase.AddView(LabelValue, 0, 0, mBase.Width, mBas";
_mbase.AddView((android.view.View)(_labelvalue.getObject()),(int) (0),(int) (0),_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 155;BA.debugLine="LabelUnit = CreateLabel";
_labelunit = _createlabel();
 //BA.debugLineNum = 156;BA.debugLine="mBase.AddView(LabelUnit, 0, 0, mBase.Width, mBase";
_mbase.AddView((android.view.View)(_labelunit.getObject()),(int) (0),(int) (0),_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 158;BA.debugLine="LabelTitle.Text		= Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToCharSequence(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 159;BA.debugLine="LabelValue.Text		= Props.Get(\"Value\")";
_labelvalue.setText(BA.ObjectToCharSequence(_props.Get((Object)("Value"))));
 //BA.debugLineNum = 160;BA.debugLine="LabelUnit.Text		= Props.Get(\"Unit\")";
_labelunit.setText(BA.ObjectToCharSequence(_props.Get((Object)("Unit"))));
 //BA.debugLineNum = 162;BA.debugLine="mShowValue			= Props.GetDefault(\"ShowValue\", True";
_mshowvalue = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowValue"),(Object)(__c.True)));
 //BA.debugLineNum = 163;BA.debugLine="LabelValue.Visible	= mShowValue";
_labelvalue.setVisible(_mshowvalue);
 //BA.debugLineNum = 164;BA.debugLine="LabelValue.Enabled	= mShowValue";
_labelvalue.setEnabled(_mshowvalue);
 //BA.debugLineNum = 167;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 168;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public int  _getactivebarwidth() throws Exception{
 //BA.debugLineNum = 432;BA.debugLine="Public Sub getActiveBarWidth As Int";
 //BA.debugLineNum = 433;BA.debugLine="Return mActiveBarWidth";
if (true) return _mactivebarwidth;
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return 0;
}
public int  _getcolorbar() throws Exception{
 //BA.debugLineNum = 408;BA.debugLine="Public Sub getColorBar As Int";
 //BA.debugLineNum = 409;BA.debugLine="Return mColorBar";
if (true) return _mcolorbar;
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return 0;
}
public int  _getcolorbarfill() throws Exception{
 //BA.debugLineNum = 419;BA.debugLine="Public Sub getColorBarFill As Int";
 //BA.debugLineNum = 420;BA.debugLine="Return mColorBar";
if (true) return _mcolorbar;
 //BA.debugLineNum = 421;BA.debugLine="End Sub";
return 0;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 594;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 595;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 596;BA.debugLine="End Sub";
return false;
}
public int  _getinactivebarwidth() throws Exception{
 //BA.debugLineNum = 445;BA.debugLine="Public Sub getInActiveBarWidth As Int";
 //BA.debugLineNum = 446;BA.debugLine="Return mInActiveBarWidth";
if (true) return _minactivebarwidth;
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
return 0;
}
public int  _getinterval() throws Exception{
 //BA.debugLineNum = 538;BA.debugLine="Public Sub getInterval As Int";
 //BA.debugLineNum = 539;BA.debugLine="Return mInterval";
if (true) return _minterval;
 //BA.debugLineNum = 540;BA.debugLine="End Sub";
return 0;
}
public int  _getmaxvalue() throws Exception{
 //BA.debugLineNum = 584;BA.debugLine="Public Sub getMaxValue As Int";
 //BA.debugLineNum = 585;BA.debugLine="Return mMaxValue";
if (true) return _mmaxvalue;
 //BA.debugLineNum = 586;BA.debugLine="End Sub";
return 0;
}
public int  _getminvalue() throws Exception{
 //BA.debugLineNum = 573;BA.debugLine="Public Sub getMinValue As Int";
 //BA.debugLineNum = 574;BA.debugLine="Return mMinValue";
if (true) return _mminvalue;
 //BA.debugLineNum = 575;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowthumb() throws Exception{
 //BA.debugLineNum = 493;BA.debugLine="Public Sub getShowThumb As Boolean";
 //BA.debugLineNum = 494;BA.debugLine="Return mShowThumb";
if (true) return _mshowthumb;
 //BA.debugLineNum = 495;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowticks() throws Exception{
 //BA.debugLineNum = 504;BA.debugLine="Public Sub getShowTicks As Boolean";
 //BA.debugLineNum = 505;BA.debugLine="Return mShowTicks";
if (true) return _mshowticks;
 //BA.debugLineNum = 506;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowvalue() throws Exception{
 //BA.debugLineNum = 562;BA.debugLine="Public Sub getShowValue As Boolean";
 //BA.debugLineNum = 563;BA.debugLine="Return mShowValue";
if (true) return _mshowvalue;
 //BA.debugLineNum = 564;BA.debugLine="End Sub";
return false;
}
public int  _getthumbcolor() throws Exception{
 //BA.debugLineNum = 482;BA.debugLine="Public Sub getThumbColor As Int";
 //BA.debugLineNum = 483;BA.debugLine="Return mThumbColor";
if (true) return _mthumbcolor;
 //BA.debugLineNum = 484;BA.debugLine="End Sub";
return 0;
}
public int  _getthumbradius() throws Exception{
 //BA.debugLineNum = 458;BA.debugLine="Public Sub getThumbRadius As Int";
 //BA.debugLineNum = 459;BA.debugLine="Return mThumbRadius";
if (true) return _mthumbradius;
 //BA.debugLineNum = 460;BA.debugLine="End Sub";
return 0;
}
public int  _getthumbradiuspressed() throws Exception{
 //BA.debugLineNum = 471;BA.debugLine="Public Sub getThumbRadiusPressed As Int";
 //BA.debugLineNum = 472;BA.debugLine="Return mThumbRadiusPressed";
if (true) return _mthumbradiuspressed;
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return 0;
}
public int  _gettickcount() throws Exception{
 //BA.debugLineNum = 516;BA.debugLine="Public Sub getTickCount As Int";
 //BA.debugLineNum = 517;BA.debugLine="Return mTickCount";
if (true) return _mtickcount;
 //BA.debugLineNum = 518;BA.debugLine="End Sub";
return 0;
}
public int  _gettickvaluecolor() throws Exception{
 //BA.debugLineNum = 527;BA.debugLine="Public Sub getTickValueColor As Int";
 //BA.debugLineNum = 528;BA.debugLine="Return mTickValueColor";
if (true) return _mtickvaluecolor;
 //BA.debugLineNum = 529;BA.debugLine="End Sub";
return 0;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 391;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 397;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 398;BA.debugLine="Return LabelUnit.Text";
if (true) return _labelunit.getText();
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return "";
}
public int  _getvalue() throws Exception{
 //BA.debugLineNum = 549;BA.debugLine="Public Sub getValue As Int";
 //BA.debugLineNum = 550;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return 0;
}
public boolean  _getvertical() throws Exception{
 //BA.debugLineNum = 606;BA.debugLine="Public Sub getVertical As Boolean";
 //BA.debugLineNum = 607;BA.debugLine="Return mVertical";
if (true) return _mvertical;
 //BA.debugLineNum = 608;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 99;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 100;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 101;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public String  _raisetouchstateevent() throws Exception{
 //BA.debugLineNum = 671;BA.debugLine="Private Sub RaiseTouchStateEvent";
 //BA.debugLineNum = 672;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_TouchS";
if (_xui.SubExists(ba,_mcallback,_meventname+"_TouchStateChanged",(int) (1))) { 
 //BA.debugLineNum = 673;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_TouchS";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_TouchStateChanged",(Object)(_pressed));
 };
 //BA.debugLineNum = 675;BA.debugLine="End Sub";
return "";
}
public String  _setactivebarwidth(int _width) throws Exception{
 //BA.debugLineNum = 426;BA.debugLine="Public Sub setActiveBarWidth(width As Int)";
 //BA.debugLineNum = 427;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 428;BA.debugLine="If width > mBase.Width Then width = mBase.Width";
if (_width>_mbase.getWidth()) { 
_width = _mbase.getWidth();};
 //BA.debugLineNum = 429;BA.debugLine="mActiveBarWidth = width";
_mactivebarwidth = _width;
 //BA.debugLineNum = 430;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 431;BA.debugLine="End Sub";
return "";
}
public String  _setcolorbar(int _clr) throws Exception{
 //BA.debugLineNum = 404;BA.debugLine="Public Sub setColorBar(clr As Int)";
 //BA.debugLineNum = 405;BA.debugLine="mColorBar = clr";
_mcolorbar = _clr;
 //BA.debugLineNum = 406;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public String  _setcolorbarfill(int _clr) throws Exception{
 //BA.debugLineNum = 415;BA.debugLine="Public Sub setColorBarFill(clr As Int)";
 //BA.debugLineNum = 416;BA.debugLine="mColorBarFill = clr";
_mcolorbarfill = _clr;
 //BA.debugLineNum = 417;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 418;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _state) throws Exception{
 //BA.debugLineNum = 591;BA.debugLine="Public Sub setEnabled(state As Boolean)";
 //BA.debugLineNum = 592;BA.debugLine="mBase.Enabled = state";
_mbase.setEnabled(_state);
 //BA.debugLineNum = 593;BA.debugLine="End Sub";
return "";
}
public String  _setinactivebarwidth(int _width) throws Exception{
 //BA.debugLineNum = 439;BA.debugLine="Public Sub setInActiveBarWidth(width As Int)";
 //BA.debugLineNum = 440;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 441;BA.debugLine="If width > mBase.Width Then width = mBase.Width";
if (_width>_mbase.getWidth()) { 
_width = _mbase.getWidth();};
 //BA.debugLineNum = 442;BA.debugLine="mInActiveBarWidth = width";
_minactivebarwidth = _width;
 //BA.debugLineNum = 443;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 444;BA.debugLine="End Sub";
return "";
}
public String  _setinterval(int _interval) throws Exception{
 //BA.debugLineNum = 534;BA.debugLine="Public Sub setInterval(interval As Int)";
 //BA.debugLineNum = 535;BA.debugLine="mInterval = interval";
_minterval = _interval;
 //BA.debugLineNum = 536;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
return "";
}
public String  _setmaxvalue(int _v) throws Exception{
 //BA.debugLineNum = 580;BA.debugLine="Public Sub setMaxValue(v As Int)";
 //BA.debugLineNum = 581;BA.debugLine="mMaxValue = v";
_mmaxvalue = _v;
 //BA.debugLineNum = 582;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 583;BA.debugLine="End Sub";
return "";
}
public String  _setminvalue(int _v) throws Exception{
 //BA.debugLineNum = 569;BA.debugLine="Public Sub setMinValue(v As Int)";
 //BA.debugLineNum = 570;BA.debugLine="mMinValue = v";
_mminvalue = _v;
 //BA.debugLineNum = 571;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 572;BA.debugLine="End Sub";
return "";
}
public String  _setshowthumb(boolean _state) throws Exception{
 //BA.debugLineNum = 489;BA.debugLine="Public Sub setShowThumb(state As Boolean)";
 //BA.debugLineNum = 490;BA.debugLine="mShowThumb = state";
_mshowthumb = _state;
 //BA.debugLineNum = 491;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 492;BA.debugLine="End Sub";
return "";
}
public String  _setshowticks(boolean _state) throws Exception{
 //BA.debugLineNum = 500;BA.debugLine="Public Sub setShowTicks(state As Boolean)";
 //BA.debugLineNum = 501;BA.debugLine="mShowTicks = state";
_mshowticks = _state;
 //BA.debugLineNum = 502;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 503;BA.debugLine="End Sub";
return "";
}
public String  _setshowvalue(boolean _visible) throws Exception{
 //BA.debugLineNum = 556;BA.debugLine="Public Sub setShowValue(visible As Boolean)";
 //BA.debugLineNum = 557;BA.debugLine="mShowValue = visible";
_mshowvalue = _visible;
 //BA.debugLineNum = 558;BA.debugLine="LabelValue.Visible = mShowValue";
_labelvalue.setVisible(_mshowvalue);
 //BA.debugLineNum = 559;BA.debugLine="LabelValue.Enabled = mShowValue";
_labelvalue.setEnabled(_mshowvalue);
 //BA.debugLineNum = 560;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 561;BA.debugLine="End Sub";
return "";
}
public String  _setthumbcolor(int _clr) throws Exception{
 //BA.debugLineNum = 478;BA.debugLine="Public Sub setThumbColor(clr As Int)";
 //BA.debugLineNum = 479;BA.debugLine="mThumbColor = clr";
_mthumbcolor = _clr;
 //BA.debugLineNum = 480;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
return "";
}
public String  _setthumbradius(int _width) throws Exception{
 //BA.debugLineNum = 452;BA.debugLine="Public Sub setThumbRadius(width As Int)";
 //BA.debugLineNum = 453;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 454;BA.debugLine="If width > mBase.Width Then width = mBase.Width";
if (_width>_mbase.getWidth()) { 
_width = _mbase.getWidth();};
 //BA.debugLineNum = 455;BA.debugLine="mThumbRadius = width";
_mthumbradius = _width;
 //BA.debugLineNum = 456;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 457;BA.debugLine="End Sub";
return "";
}
public String  _setthumbradiuspressed(int _width) throws Exception{
 //BA.debugLineNum = 465;BA.debugLine="Public Sub setThumbRadiusPressed(width As Int)";
 //BA.debugLineNum = 466;BA.debugLine="If width < 0 Then width = 0";
if (_width<0) { 
_width = (int) (0);};
 //BA.debugLineNum = 467;BA.debugLine="If width > mBase.Width Then width = mBase.Width";
if (_width>_mbase.getWidth()) { 
_width = _mbase.getWidth();};
 //BA.debugLineNum = 468;BA.debugLine="mThumbRadiusPressed = width";
_mthumbradiuspressed = _width;
 //BA.debugLineNum = 469;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 470;BA.debugLine="End Sub";
return "";
}
public String  _settickcount(int _count) throws Exception{
 //BA.debugLineNum = 511;BA.debugLine="Public Sub setTickCount(count As Int)";
 //BA.debugLineNum = 512;BA.debugLine="If count < 0 Then count = 0";
if (_count<0) { 
_count = (int) (0);};
 //BA.debugLineNum = 513;BA.debugLine="mTickCount = count";
_mtickcount = _count;
 //BA.debugLineNum = 514;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 515;BA.debugLine="End Sub";
return "";
}
public String  _settickvaluecolor(int _clr) throws Exception{
 //BA.debugLineNum = 523;BA.debugLine="Public Sub setTickValueColor(clr As Int)";
 //BA.debugLineNum = 524;BA.debugLine="mTickValueColor = clr";
_mtickvaluecolor = _clr;
 //BA.debugLineNum = 525;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 526;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _title) throws Exception{
 //BA.debugLineNum = 387;BA.debugLine="Public Sub setTitle(title As String)";
 //BA.debugLineNum = 388;BA.debugLine="LabelTitle.Text = title";
_labeltitle.setText(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 389;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _unit) throws Exception{
 //BA.debugLineNum = 394;BA.debugLine="Public Sub setUnit(unit As String)";
 //BA.debugLineNum = 395;BA.debugLine="LabelUnit.Text = unit";
_labelunit.setText(BA.ObjectToCharSequence(_unit));
 //BA.debugLineNum = 396;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(int _v) throws Exception{
 //BA.debugLineNum = 545;BA.debugLine="Public Sub setValue(v As Int)";
 //BA.debugLineNum = 546;BA.debugLine="mValue = Max(mMinValue, Min(mMaxValue, v))";
_mvalue = (int) (__c.Max(_mminvalue,__c.Min(_mmaxvalue,_v)));
 //BA.debugLineNum = 547;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 548;BA.debugLine="End Sub";
return "";
}
public String  _setvaluebasedontouch(int _x,int _y) throws Exception{
int _v = 0;
int _newvalue = 0;
 //BA.debugLineNum = 677;BA.debugLine="Private Sub SetValueBasedOnTouch(x As Int, y As In";
 //BA.debugLineNum = 678;BA.debugLine="Dim v As Int";
_v = 0;
 //BA.debugLineNum = 679;BA.debugLine="If mVertical Then";
if (_mvertical) { 
 //BA.debugLineNum = 680;BA.debugLine="v = (mBarBottom - y) / mSize * (mMaxValue - mMin";
_v = (int) ((_mbarbottom-_y)/(double)_msize*(_mmaxvalue-_mminvalue)+_mminvalue);
 }else {
 //BA.debugLineNum = 683;BA.debugLine="v = (x - mThumbRadiusPressed) / mSize * (mMaxVal";
_v = (int) ((_x-_mthumbradiuspressed)/(double)_msize*(_mmaxvalue-_mminvalue)+_mminvalue);
 };
 //BA.debugLineNum = 685;BA.debugLine="v = Round(v / mInterval) * mInterval";
_v = (int) (__c.Round(_v/(double)_minterval)*_minterval);
 //BA.debugLineNum = 686;BA.debugLine="Dim NewValue As Int = Max(mMinValue, Min(mMaxValu";
_newvalue = (int) (__c.Max(_mminvalue,__c.Min(_mmaxvalue,_v)));
 //BA.debugLineNum = 687;BA.debugLine="If NewValue <> mValue Then";
if (_newvalue!=_mvalue) { 
 //BA.debugLineNum = 688;BA.debugLine="mValue = NewValue";
_mvalue = _newvalue;
 //BA.debugLineNum = 689;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Value";
if (_xui.SubExists(ba,_mcallback,_meventname+"_ValueChanged",(int) (1))) { 
 //BA.debugLineNum = 690;BA.debugLine="If mTouchStateChanged Then";
if (_mtouchstatechanged) { 
 //BA.debugLineNum = 691;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_Valu";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_ValueChanged",(Object)(_mvalue));
 };
 };
 };
 //BA.debugLineNum = 695;BA.debugLine="End Sub";
return "";
}
public String  _setvertical(boolean _state) throws Exception{
 //BA.debugLineNum = 602;BA.debugLine="Public Sub setVertical(state As Boolean)";
 //BA.debugLineNum = 603;BA.debugLine="mVertical = state";
_mvertical = _state;
 //BA.debugLineNum = 604;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 605;BA.debugLine="End Sub";
return "";
}
public String  _touchpanel_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 649;BA.debugLine="Private Sub TouchPanel_Touch(Action As Int, X As F";
 //BA.debugLineNum = 650;BA.debugLine="If Action = TouchPanel.TOUCH_ACTION_DOWN Then";
if (_action==_touchpanel.TOUCH_ACTION_DOWN) { 
 //BA.debugLineNum = 651;BA.debugLine="Pressed = True";
_pressed = __c.True;
 //BA.debugLineNum = 652;BA.debugLine="RaiseTouchStateEvent";
_raisetouchstateevent();
 //BA.debugLineNum = 653;BA.debugLine="SetValueBasedOnTouch(X, Y)";
_setvaluebasedontouch((int) (_x),(int) (_y));
 }else if(_action==_touchpanel.TOUCH_ACTION_MOVE) { 
 //BA.debugLineNum = 656;BA.debugLine="SetValueBasedOnTouch(X, Y)";
_setvaluebasedontouch((int) (_x),(int) (_y));
 }else if(_action==_touchpanel.TOUCH_ACTION_UP) { 
 //BA.debugLineNum = 659;BA.debugLine="Pressed = False";
_pressed = __c.False;
 //BA.debugLineNum = 660;BA.debugLine="RaiseTouchStateEvent";
_raisetouchstateevent();
 //BA.debugLineNum = 661;BA.debugLine="If Not(mTouchStateChanged) Then";
if (__c.Not(_mtouchstatechanged)) { 
 //BA.debugLineNum = 662;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Valu";
if (_xui.SubExists(ba,_mcallback,_meventname+"_ValueChanged",(int) (1))) { 
 //BA.debugLineNum = 663;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_Valu";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_ValueChanged",(Object)(_mvalue));
 };
 };
 };
 //BA.debugLineNum = 668;BA.debugLine="Update";
_update();
 //BA.debugLineNum = 669;BA.debugLine="End Sub";
return "";
}
public String  _update() throws Exception{
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
 //BA.debugLineNum = 213;BA.debugLine="Public Sub Update";
 //BA.debugLineNum = 214;BA.debugLine="Dim x1,y1,x2,y2 As Float";
_x1 = 0f;
_y1 = 0f;
_x2 = 0f;
_y2 = 0f;
 //BA.debugLineNum = 217;BA.debugLine="CanvasSeekBar.ClearRect(CanvasSeekBar.TargetRect)";
_canvasseekbar.ClearRect(_canvasseekbar.getTargetRect());
 //BA.debugLineNum = 222;BA.debugLine="If Not(mVertical) Then";
if (__c.Not(_mvertical)) { 
 //BA.debugLineNum = 223;BA.debugLine="mSize = mBase.Width - 2 * mThumbRadiusPressed";
_msize = (int) (_mbase.getWidth()-2*_mthumbradiuspressed);
 //BA.debugLineNum = 225;BA.debugLine="mSize = mBase.Width - 4 * mThumbRadiusPressed";
_msize = (int) (_mbase.getWidth()-4*_mthumbradiuspressed);
 //BA.debugLineNum = 228;BA.debugLine="If mSize <= 0 Then Return";
if (_msize<=0) { 
if (true) return "";};
 //BA.debugLineNum = 229;BA.debugLine="If mShowValue Then";
if (_mshowvalue) { 
 //BA.debugLineNum = 230;BA.debugLine="Dim y As Int = (mBase.Height / 2) + (HMITileUti";
_y = (int) ((_mbase.getHeight()/(double)2)+(_hmitileutils._padding /*int*/ *2.5));
 }else {
 //BA.debugLineNum = 232;BA.debugLine="Dim y As Int = (mBase.Height / 2) - (HMITileUti";
_y = (int) ((_mbase.getHeight()/(double)2)-(_hmitileutils._padding /*int*/ ));
 };
 //BA.debugLineNum = 235;BA.debugLine="Dim w As Int = mThumbRadiusPressed + (mValue - m";
_w = (int) (_mthumbradiuspressed+(_mvalue-_mminvalue)/(double)(_mmaxvalue-_mminvalue)*_msize);
 //BA.debugLineNum = 238;BA.debugLine="x1 = mThumbRadiusPressed";
_x1 = (float) (_mthumbradiuspressed);
 //BA.debugLineNum = 242;BA.debugLine="y1 = y";
_y1 = (float) (_y);
 //BA.debugLineNum = 243;BA.debugLine="x2 = w";
_x2 = (float) (_w);
 //BA.debugLineNum = 247;BA.debugLine="y2 = y";
_y2 = (float) (_y);
 //BA.debugLineNum = 248;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorBar";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolorbar,(float) (_mactivebarwidth));
 //BA.debugLineNum = 251;BA.debugLine="x1 = w";
_x1 = (float) (_w);
 //BA.debugLineNum = 252;BA.debugLine="y1 = y";
_y1 = (float) (_y);
 //BA.debugLineNum = 253;BA.debugLine="x2 = mBase.Width - mThumbRadiusPressed";
_x2 = (float) (_mbase.getWidth()-_mthumbradiuspressed);
 //BA.debugLineNum = 254;BA.debugLine="y2 = y";
_y2 = (float) (_y);
 //BA.debugLineNum = 255;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorBar";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolorbarfill,(float) (_minactivebarwidth));
 //BA.debugLineNum = 258;BA.debugLine="If mShowThumb Then";
if (_mshowthumb) { 
 //BA.debugLineNum = 259;BA.debugLine="CanvasSeekBar.DrawCircle(w, y, mThumbRadius, mC";
_canvasseekbar.DrawCircle((float) (_w),(float) (_y),(float) (_mthumbradius),_mcolorbar,__c.True,(float) (0));
 //BA.debugLineNum = 260;BA.debugLine="If Pressed Then CanvasSeekBar.DrawCircle(w, y,";
if (_pressed) { 
_canvasseekbar.DrawCircle((float) (_w),(float) (_y),(float) (_mthumbradiuspressed),_mthumbcolor,__c.True,(float) (0));};
 };
 //BA.debugLineNum = 264;BA.debugLine="If mShowTicks And mTickCount > 1 Then";
if (_mshowticks && _mtickcount>1) { 
 //BA.debugLineNum = 265;BA.debugLine="For i = 0 To mTickCount - 1";
{
final int step28 = 1;
final int limit28 = (int) (_mtickcount-1);
_i = (int) (0) ;
for (;_i <= limit28 ;_i = _i + step28 ) {
 //BA.debugLineNum = 266;BA.debugLine="Dim xTick As Float = mThumbRadiusPressed + i *";
_xtick = (float) (_mthumbradiuspressed+_i*_msize/(double)(_mtickcount-1));
 //BA.debugLineNum = 269;BA.debugLine="x1 = xTick";
_x1 = _xtick;
 //BA.debugLineNum = 270;BA.debugLine="If mShowValue Then";
if (_mshowvalue) { 
 //BA.debugLineNum = 271;BA.debugLine="y1 = (mBase.Height / 2) + (HMITileUtils.PADDI";
_y1 = (float) ((_mbase.getHeight()/(double)2)+(_hmitileutils._padding /*int*/ *2));
 }else {
 //BA.debugLineNum = 273;BA.debugLine="y1 = (mBase.Height / 2) - (HMITileUtils.PADDI";
_y1 = (float) ((_mbase.getHeight()/(double)2)-(_hmitileutils._padding /*int*/ ));
 };
 //BA.debugLineNum = 275;BA.debugLine="x2 = xTick";
_x2 = _xtick;
 //BA.debugLineNum = 276;BA.debugLine="y2 = y1 + mActiveBarWidth";
_y2 = (float) (_y1+_mactivebarwidth);
 //BA.debugLineNum = 277;BA.debugLine="If i = 0 Or i = mTickCount - 1 Then";
if (_i==0 || _i==_mtickcount-1) { 
 //BA.debugLineNum = 278;BA.debugLine="y1 = y1 - (mActiveBarWidth / 2)";
_y1 = (float) (_y1-(_mactivebarwidth/(double)2));
 };
 //BA.debugLineNum = 280;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorB";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolorbar,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 284;BA.debugLine="Dim fnt As B4XFont = xui.CreateDefaultFont(mTi";
_fnt = _xui.CreateDefaultFont((float) (_mtickfontsize+__c.DipToCurrent((int) (4))));
 //BA.debugLineNum = 289;BA.debugLine="Dim tickVal As Int = mMinValue + i * (mMaxValu";
_tickval = (int) (_mminvalue+_i*(_mmaxvalue-_mminvalue)/(double)(_mtickcount-1));
 //BA.debugLineNum = 290;BA.debugLine="x1 = xTick";
_x1 = _xtick;
 //BA.debugLineNum = 292;BA.debugLine="y1 = y2	+ fnt.Size + 6dip";
_y1 = (float) (_y2+_fnt.getSize()+__c.DipToCurrent((int) (6)));
 //BA.debugLineNum = 297;BA.debugLine="CanvasSeekBar.DrawText(tickVal, x1, y1, fnt, m";
_canvasseekbar.DrawText(ba,BA.NumberToString(_tickval),_x1,_y1,_fnt,_mtickvaluecolor,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
 };
 };
 //BA.debugLineNum = 305;BA.debugLine="If mVertical Then";
if (_mvertical) { 
 //BA.debugLineNum = 306;BA.debugLine="Dim x As Int	= mBase.Width / 2";
_x = (int) (_mbase.getWidth()/(double)2);
 //BA.debugLineNum = 307;BA.debugLine="Dim dy As Float";
_dy = 0f;
 //BA.debugLineNum = 308;BA.debugLine="Dim yoffset As Double";
_yoffset = 0;
 //BA.debugLineNum = 310;BA.debugLine="yoffset = LabelTitle.Top + LabelTitle.Height";
_yoffset = _labeltitle.getTop()+_labeltitle.getHeight();
 //BA.debugLineNum = 311;BA.debugLine="If mShowValue Then";
if (_mshowvalue) { 
 //BA.debugLineNum = 312;BA.debugLine="yoffset = yoffset + LabelValue.Height";
_yoffset = _yoffset+_labelvalue.getHeight();
 };
 //BA.debugLineNum = 315;BA.debugLine="yoffset = yoffset + 5dip";
_yoffset = _yoffset+__c.DipToCurrent((int) (5));
 //BA.debugLineNum = 318;BA.debugLine="mBarTop = yoffset";
_mbartop = _yoffset;
 //BA.debugLineNum = 320;BA.debugLine="mBarBottom = LabelUnit.top - 2dip	' mBase.Height";
_mbarbottom = _labelunit.getTop()-__c.DipToCurrent((int) (2));
 //BA.debugLineNum = 321;BA.debugLine="mSize = mBarBottom - mBarTop";
_msize = (int) (_mbarbottom-_mbartop);
 //BA.debugLineNum = 323;BA.debugLine="If mSize <= 0 Then Return";
if (_msize<=0) { 
if (true) return "";};
 //BA.debugLineNum = 325;BA.debugLine="x1 = x";
_x1 = (float) (_x);
 //BA.debugLineNum = 326;BA.debugLine="y1 = mBarTop";
_y1 = (float) (_mbartop);
 //BA.debugLineNum = 327;BA.debugLine="x2 = x1";
_x2 = _x1;
 //BA.debugLineNum = 328;BA.debugLine="y2 = mBarBottom";
_y2 = (float) (_mbarbottom);
 //BA.debugLineNum = 329;BA.debugLine="dy = y2 - y1";
_dy = (float) (_y2-_y1);
 //BA.debugLineNum = 332;BA.debugLine="CanvasSeekBar.DrawLine(x1, y1, x2, y2, mColorBar";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolorbarfill,(float) (_minactivebarwidth));
 //BA.debugLineNum = 338;BA.debugLine="Dim df As Float	= mValue / (mMaxValue - mMinValu";
_df = (float) (_mvalue/(double)(_mmaxvalue-_mminvalue));
 //BA.debugLineNum = 339;BA.debugLine="x1 = x";
_x1 = (float) (_x);
 //BA.debugLineNum = 340;BA.debugLine="y1 = y2 - ((y2 - y1) * df)";
_y1 = (float) (_y2-((_y2-_y1)*_df));
 //BA.debugLineNum = 341;BA.debugLine="x2 = x1";
_x2 = _x1;
 //BA.debugLineNum = 342;BA.debugLine="y2 = y2";
_y2 = _y2;
 //BA.debugLineNum = 343;BA.debugLine="CanvasSeekBar.DrawLine(x1,y1,x2,y2, mColorBar, m";
_canvasseekbar.DrawLine(_x1,_y1,_x2,_y2,_mcolorbar,(float) (_mactivebarwidth));
 //BA.debugLineNum = 348;BA.debugLine="If mShowThumb Then";
if (_mshowthumb) { 
 //BA.debugLineNum = 349;BA.debugLine="CanvasSeekBar.DrawCircle(x, y1, mThumbRadius, m";
_canvasseekbar.DrawCircle((float) (_x),_y1,(float) (_mthumbradius),_mcolorbar,__c.True,(float) (0));
 //BA.debugLineNum = 350;BA.debugLine="If Pressed Then CanvasSeekBar.DrawCircle(x, y1,";
if (_pressed) { 
_canvasseekbar.DrawCircle((float) (_x),_y1,(float) (_mthumbradiuspressed),_mthumbcolor,__c.True,(float) (0));};
 };
 //BA.debugLineNum = 354;BA.debugLine="Dim yTick As Float";
_ytick = 0f;
 //BA.debugLineNum = 355;BA.debugLine="Dim x2Tick As Float";
_x2tick = 0f;
 //BA.debugLineNum = 356;BA.debugLine="Dim dyTick As Float = (dy / (mTickCount - 1))";
_dytick = (float) ((_dy/(double)(_mtickcount-1)));
 //BA.debugLineNum = 359;BA.debugLine="If mShowTicks And mTickCount > 2 Then";
if (_mshowticks && _mtickcount>2) { 
 //BA.debugLineNum = 360;BA.debugLine="For i = 0 To mTickCount - 1";
{
final int step83 = 1;
final int limit83 = (int) (_mtickcount-1);
_i = (int) (0) ;
for (;_i <= limit83 ;_i = _i + step83 ) {
 //BA.debugLineNum = 361;BA.debugLine="yTick = mBarTop + (i * dyTick)";
_ytick = (float) (_mbartop+(_i*_dytick));
 //BA.debugLineNum = 364;BA.debugLine="x2Tick = x - (mInActiveBarWidth / 2)";
_x2tick = (float) (_x-(_minactivebarwidth/(double)2));
 //BA.debugLineNum = 365;BA.debugLine="If i = 0 Or i = mTickCount - 1 Then x2Tick = x";
if (_i==0 || _i==_mtickcount-1) { 
_x2tick = (float) (_x+(_minactivebarwidth/(double)2));};
 //BA.debugLineNum = 366;BA.debugLine="CanvasSeekBar.DrawLine(x - (mInActiveBarWidth/";
_canvasseekbar.DrawLine((float) (_x-(_minactivebarwidth/(double)2)-__c.DipToCurrent((int) (4))),_ytick,_x2tick,_ytick,_mcolorbar,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 369;BA.debugLine="Dim tickVal As Int = mMaxValue - i * (mMaxValu";
_tickval = (int) (_mmaxvalue-_i*(_mmaxvalue-_mminvalue)/(double)(_mtickcount-1));
 //BA.debugLineNum = 370;BA.debugLine="CanvasSeekBar.DrawText(tickVal, x - (mInActive";
_canvasseekbar.DrawText(ba,BA.NumberToString(_tickval),(float) (_x-(_minactivebarwidth/(double)2)-__c.DipToCurrent((int) (8))),(float) (_ytick+__c.DipToCurrent((int) (4))),_xui.CreateDefaultFont((float) (_mtickfontsize)),_mtickvaluecolor,BA.getEnumFromString(android.graphics.Paint.Align.class,"RIGHT"));
 }
};
 };
 };
 //BA.debugLineNum = 378;BA.debugLine="CanvasSeekBar.Invalidate";
_canvasseekbar.Invalidate();
 //BA.debugLineNum = 380;BA.debugLine="LabelValue.Text	= mValue";
_labelvalue.setText(BA.ObjectToCharSequence(_mvalue));
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
