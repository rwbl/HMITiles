package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilergb extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilergb", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilergb.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _panepreview = null;
public b4j.example.b4xseekbar _b4xseekbarred = null;
public b4j.example.b4xseekbar _b4xseekbargreen = null;
public b4j.example.b4xseekbar _b4xseekbarblue = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvaluered = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvaluegreen = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelvalueblue = null;
public boolean _mvertical = false;
public boolean _mtouchstatechanged = false;
public int _mr = 0;
public int _mg = 0;
public int _mb = 0;
public int _mpad = 0;
public double _mpreviewheight = 0;
public double _mpreviewheightfactor = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 84;BA.debugLine="mBase.LoadLayout(\"hmitilergb\")";
_mbase.LoadLayout("hmitilergb",ba);
 //BA.debugLineNum = 86;BA.debugLine="LabelTitle.Text		= Props.Get(\"Title\")";
_labeltitle.setText(BA.ObjectToString(_props.Get((Object)("Title"))));
 //BA.debugLineNum = 87;BA.debugLine="mVertical 			= Props.Get(\"Vertical\")";
_mvertical = BA.ObjectToBoolean(_props.Get((Object)("Vertical")));
 //BA.debugLineNum = 88;BA.debugLine="mTouchStateChanged 	= Props.Get(\"TouchStateChange";
_mtouchstatechanged = BA.ObjectToBoolean(_props.Get((Object)("TouchStateChanged")));
 //BA.debugLineNum = 89;BA.debugLine="Dim mPad As Int = HMITileUtils.BORDER_WIDTH + HMI";
_mpad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 92;BA.debugLine="B4XSeekBarRed.Value = 0";
_b4xseekbarred._setvalue /*int*/ ((int) (0));
 //BA.debugLineNum = 93;BA.debugLine="B4XSeekBarGreen.Value = 0";
_b4xseekbargreen._setvalue /*int*/ ((int) (0));
 //BA.debugLineNum = 94;BA.debugLine="B4XSeekBarBlue.Value = 0";
_b4xseekbarblue._setvalue /*int*/ ((int) (0));
 //BA.debugLineNum = 96;BA.debugLine="B4XSeekBarRed.Size1 = 5dip";
_b4xseekbarred._size1 /*int*/  = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 97;BA.debugLine="B4XSeekBarRed.Size2 = 5dip";
_b4xseekbarred._size2 /*int*/  = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 98;BA.debugLine="B4XSeekBarGreen.Size1 = 5dip";
_b4xseekbargreen._size1 /*int*/  = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 99;BA.debugLine="B4XSeekBarGreen.Size2 = 5dip";
_b4xseekbargreen._size2 /*int*/  = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 100;BA.debugLine="B4XSeekBarBlue.Size1 = 5dip";
_b4xseekbarblue._size1 /*int*/  = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 101;BA.debugLine="B4XSeekBarBlue.Size2 = 5dip";
_b4xseekbarblue._size2 /*int*/  = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 104;BA.debugLine="LabelValueRed.TextColor = HMITileUtils.COLOR_TEXT";
_labelvaluered.setTextColor(_hmitileutils._color_text_secondary /*int*/ );
 //BA.debugLineNum = 105;BA.debugLine="LabelValueGreen.TextColor = HMITileUtils.COLOR_TE";
_labelvaluegreen.setTextColor(_hmitileutils._color_text_secondary /*int*/ );
 //BA.debugLineNum = 106;BA.debugLine="LabelValueBlue.TextColor = HMITileUtils.COLOR_TEX";
_labelvalueblue.setTextColor(_hmitileutils._color_text_secondary /*int*/ );
 //BA.debugLineNum = 108;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 110;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _applyseekbarcolors() throws Exception{
 //BA.debugLineNum = 277;BA.debugLine="Private Sub ApplySeekbarColors";
 //BA.debugLineNum = 279;BA.debugLine="B4XSeekBarRed.Color1 		= 0xAAFF0000";
_b4xseekbarred._color1 /*int*/  = ((int)0xaaff0000);
 //BA.debugLineNum = 280;BA.debugLine="B4XSeekBarRed.Color2 		= 0x44FF0000";
_b4xseekbarred._color2 /*int*/  = ((int)0x44ff0000);
 //BA.debugLineNum = 281;BA.debugLine="B4XSeekBarRed.ThumbColor 	= 0xFFFF0000";
_b4xseekbarred._thumbcolor /*int*/  = ((int)0xffff0000);
 //BA.debugLineNum = 284;BA.debugLine="B4XSeekBarGreen.Color1 		= 0xAA00FF00";
_b4xseekbargreen._color1 /*int*/  = ((int)0xaa00ff00);
 //BA.debugLineNum = 285;BA.debugLine="B4XSeekBarGreen.Color2 		= 0x4400FF00";
_b4xseekbargreen._color2 /*int*/  = ((int)0x4400ff00);
 //BA.debugLineNum = 286;BA.debugLine="B4XSeekBarGreen.ThumbColor 	= 0xFF00FF00";
_b4xseekbargreen._thumbcolor /*int*/  = ((int)0xff00ff00);
 //BA.debugLineNum = 289;BA.debugLine="B4XSeekBarBlue.Color1 		= 0xAA0000FF";
_b4xseekbarblue._color1 /*int*/  = ((int)0xaa0000ff);
 //BA.debugLineNum = 290;BA.debugLine="B4XSeekBarBlue.Color2 		= 0x440000FF";
_b4xseekbarblue._color2 /*int*/  = ((int)0x440000ff);
 //BA.debugLineNum = 291;BA.debugLine="B4XSeekBarBlue.ThumbColor 	= 0xFF0000FF";
_b4xseekbarblue._thumbcolor /*int*/  = ((int)0xff0000ff);
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 269;BA.debugLine="Public Sub ApplyStyle";
 //BA.debugLineNum = 270;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 271;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 273;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 274;BA.debugLine="ApplySeekbarColors";
_applyseekbarcolors();
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public String  _b4xseekbarblue_touchstatechanged(boolean _pressed) throws Exception{
 //BA.debugLineNum = 335;BA.debugLine="Private Sub B4XSeekBarBlue_TouchStateChanged (Pres";
 //BA.debugLineNum = 336;BA.debugLine="If mTouchStateChanged Then";
if (_mtouchstatechanged) { 
 //BA.debugLineNum = 337;BA.debugLine="If Not(Pressed) Then";
if (__c.Not(_pressed)) { 
 //BA.debugLineNum = 338;BA.debugLine="ValueChanged(mR, mG, mB)";
_valuechanged(_mr,_mg,_mb);
 };
 };
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return "";
}
public String  _b4xseekbarblue_valuechanged(int _value) throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Private Sub B4XSeekBarBlue_ValueChanged (Value As";
 //BA.debugLineNum = 307;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public String  _b4xseekbargreen_touchstatechanged(boolean _pressed) throws Exception{
 //BA.debugLineNum = 327;BA.debugLine="Private Sub B4XSeekBarGreen_TouchStateChanged (Pre";
 //BA.debugLineNum = 328;BA.debugLine="If mTouchStateChanged Then";
if (_mtouchstatechanged) { 
 //BA.debugLineNum = 329;BA.debugLine="If Not(Pressed) Then";
if (__c.Not(_pressed)) { 
 //BA.debugLineNum = 330;BA.debugLine="ValueChanged(mR, mG, mB)";
_valuechanged(_mr,_mg,_mb);
 };
 };
 //BA.debugLineNum = 333;BA.debugLine="End Sub";
return "";
}
public String  _b4xseekbargreen_valuechanged(int _value) throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Private Sub B4XSeekBarGreen_ValueChanged (Value As";
 //BA.debugLineNum = 303;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
public String  _b4xseekbarred_touchstatechanged(boolean _pressed) throws Exception{
 //BA.debugLineNum = 319;BA.debugLine="Private Sub B4XSeekBarRed_TouchStateChanged (Press";
 //BA.debugLineNum = 320;BA.debugLine="If mTouchStateChanged Then";
if (_mtouchstatechanged) { 
 //BA.debugLineNum = 321;BA.debugLine="If Not(Pressed) Then";
if (__c.Not(_pressed)) { 
 //BA.debugLineNum = 322;BA.debugLine="ValueChanged(mR, mG, mB)";
_valuechanged(_mr,_mg,_mb);
 };
 };
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
return "";
}
public String  _b4xseekbarred_valuechanged(int _value) throws Exception{
 //BA.debugLineNum = 298;BA.debugLine="Private Sub B4XSeekBarRed_ValueChanged (Value As I";
 //BA.debugLineNum = 299;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 300;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 114;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 116;BA.debugLine="If mVertical Then";
if (_mvertical) { 
 //BA.debugLineNum = 117;BA.debugLine="VerticalBaseResize (Width, Height)";
_verticalbaseresize(_width,_height);
 }else {
 //BA.debugLineNum = 119;BA.debugLine="HorizontalBaseResize (Width, Height)";
_horizontalbaseresize(_width,_height);
 };
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public int  _checkcolor(int _value) throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Private Sub CheckColor(value As Int) As Int";
 //BA.debugLineNum = 352;BA.debugLine="Return IIf(value >= 0 And value <= 255, value, 0)";
if (true) return (int)(BA.ObjectToNumber(((_value>=0 && _value<=255) ? ((Object)(_value)) : ((Object)(0)))));
 //BA.debugLineNum = 353;BA.debugLine="End Sub";
return 0;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 40;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 41;BA.debugLine="Private mCallBack As Object";
_mcallback = new Object();
 //BA.debugLineNum = 44;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private mLbl As B4XView						'ignore as not used";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 49;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 50;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private PanePreview As B4XView";
_panepreview = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private B4XSeekBarRed As B4XSeekBar";
_b4xseekbarred = new b4j.example.b4xseekbar();
 //BA.debugLineNum = 53;BA.debugLine="Private B4XSeekBarGreen As B4XSeekBar";
_b4xseekbargreen = new b4j.example.b4xseekbar();
 //BA.debugLineNum = 54;BA.debugLine="Private B4XSeekBarBlue As B4XSeekBar";
_b4xseekbarblue = new b4j.example.b4xseekbar();
 //BA.debugLineNum = 55;BA.debugLine="Private LabelValueRed As B4XView";
_labelvaluered = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private LabelValueGreen As B4XView";
_labelvaluegreen = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private LabelValueBlue As B4XView";
_labelvalueblue = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private mVertical As Boolean";
_mvertical = false;
 //BA.debugLineNum = 61;BA.debugLine="Private mTouchStateChanged As Boolean";
_mtouchstatechanged = false;
 //BA.debugLineNum = 64;BA.debugLine="Private mR, mG, mB As Int";
_mr = 0;
_mg = 0;
_mb = 0;
 //BA.debugLineNum = 65;BA.debugLine="Dim mPad As Int";
_mpad = 0;
 //BA.debugLineNum = 66;BA.debugLine="Dim mPreviewHeight As Double";
_mpreviewheight = 0;
 //BA.debugLineNum = 67;BA.debugLine="Dim mPreviewHeightFactor As Double = 0.05";
_mpreviewheightfactor = 0.05;
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 76;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 77;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 78;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 79;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 80;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public int  _getblue() throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Public Sub getBlue As Int";
 //BA.debugLineNum = 255;BA.debugLine="Return mB";
if (true) return _mb;
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return 0;
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 263;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return false;
}
public int  _getgreen() throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Public Sub getGreen As Int";
 //BA.debugLineNum = 251;BA.debugLine="Return mG";
if (true) return _mg;
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return 0;
}
public int  _getred() throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Public Sub getRed As Int";
 //BA.debugLineNum = 247;BA.debugLine="Return mR";
if (true) return _mr;
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return 0;
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 225;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 226;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 227;BA.debugLine="End Sub";
return "";
}
public String  _horizontalbaseresize(double _width,double _height) throws Exception{
double _rowh = 0;
double _y = 0;
 //BA.debugLineNum = 164;BA.debugLine="Private Sub HorizontalBaseResize(Width As Double,";
 //BA.debugLineNum = 165;BA.debugLine="If Not(B4XSeekBarRed.IsInitialized) Then Retur";
if (__c.Not(_b4xseekbarred.IsInitialized /*boolean*/ ())) { 
if (true) return "";};
 //BA.debugLineNum = 167;BA.debugLine="mPreviewHeight = Height * mPreviewHeightFactor";
_mpreviewheight = _height*_mpreviewheightfactor;
 //BA.debugLineNum = 168;BA.debugLine="Dim rowH As Double = ((Height - mPreviewHeight) /";
_rowh = ((_height-_mpreviewheight)/(double)3)*0.7;
 //BA.debugLineNum = 171;BA.debugLine="LabelTitle.SetLayoutAnimated(0, mPad, mPad, Width";
_labeltitle.SetLayoutAnimated((int) (0),_mpad,_mpad,_width-_mpad*2,_height*0.25);
 //BA.debugLineNum = 174;BA.debugLine="Dim y As Double = Height - mPreviewHeight - (mPad";
_y = _height-_mpreviewheight-(_mpad*0.75);
 //BA.debugLineNum = 175;BA.debugLine="PanePreview.SetLayoutAnimated(0, mPad * 2, y, Wid";
_panepreview.SetLayoutAnimated((int) (0),_mpad*2,_y,_width-_mpad*4,_mpreviewheight);
 //BA.debugLineNum = 178;BA.debugLine="y = LabelTitle.Height";
_y = _labeltitle.getHeight();
 //BA.debugLineNum = 179;BA.debugLine="HorizontalLayoutSliderRow(B4XSeekBarRed, LabelVal";
_horizontallayoutsliderrow(_b4xseekbarred,_labelvaluered,_y,_rowh,_width);
 //BA.debugLineNum = 180;BA.debugLine="y = y + rowH";
_y = _y+_rowh;
 //BA.debugLineNum = 183;BA.debugLine="HorizontalLayoutSliderRow(B4XSeekBarGreen, LabelV";
_horizontallayoutsliderrow(_b4xseekbargreen,_labelvaluegreen,_y,_rowh,_width);
 //BA.debugLineNum = 184;BA.debugLine="y = y + rowH";
_y = _y+_rowh;
 //BA.debugLineNum = 187;BA.debugLine="HorizontalLayoutSliderRow(B4XSeekBarBlue, LabelVa";
_horizontallayoutsliderrow(_b4xseekbarblue,_labelvalueblue,_y,_rowh,_width);
 //BA.debugLineNum = 189;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public String  _horizontallayoutsliderrow(b4j.example.b4xseekbar _bar,anywheresoftware.b4a.objects.B4XViewWrapper _valuelabel,double _top,double _rowheight,double _width) throws Exception{
int _padding = 0;
int _labelw = 0;
int _barw = 0;
 //BA.debugLineNum = 192;BA.debugLine="Private Sub HorizontalLayoutSliderRow(Bar As B4XSe";
 //BA.debugLineNum = 193;BA.debugLine="Dim padding As Int = 4dip";
_padding = __c.DipToCurrent((int) (4));
 //BA.debugLineNum = 194;BA.debugLine="Dim labelW As Int = 30dip   		' right aligned num";
_labelw = __c.DipToCurrent((int) (30));
 //BA.debugLineNum = 195;BA.debugLine="Dim barW As Int = Width - labelW 	'- padding*2";
_barw = (int) (_width-_labelw);
 //BA.debugLineNum = 197;BA.debugLine="Bar.mBase.SetLayoutAnimated(0, padding, Top + pad";
_bar._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),_padding,_top+_padding,_barw,_rowheight-_padding*2);
 //BA.debugLineNum = 200;BA.debugLine="ValueLabel.TextSize = HMITileUtils.TEXT_SIZE_TINY";
_valuelabel.setTextSize(_hmitileutils._text_size_tiny /*float*/ );
 //BA.debugLineNum = 201;BA.debugLine="ValueLabel.SetLayoutAnimated(0, barW + padding, T";
_valuelabel.SetLayoutAnimated((int) (0),_barw+_padding,_top,_labelw,_rowheight);
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 70;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 71;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 72;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _setcolor(int _r,int _g,int _b) throws Exception{
 //BA.debugLineNum = 229;BA.debugLine="Public Sub SetColor(r As Int, g As Int, b As Int)";
 //BA.debugLineNum = 230;BA.debugLine="mR = CheckColor(r)";
_mr = _checkcolor(_r);
 //BA.debugLineNum = 231;BA.debugLine="mG = CheckColor(g)";
_mg = _checkcolor(_g);
 //BA.debugLineNum = 232;BA.debugLine="mB = CheckColor(b)";
_mb = _checkcolor(_b);
 //BA.debugLineNum = 233;BA.debugLine="ValueChanged(mR, mG, mB)";
_valuechanged(_mr,_mg,_mb);
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public String  _setcolorfrommap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Public Sub SetColorFromMap(m As Map)";
 //BA.debugLineNum = 237;BA.debugLine="mR = m.Get(\"r\")";
_mr = (int)(BA.ObjectToNumber(_m.Get((Object)("r"))));
 //BA.debugLineNum = 238;BA.debugLine="mG = m.Get(\"g\")";
_mg = (int)(BA.ObjectToNumber(_m.Get((Object)("g"))));
 //BA.debugLineNum = 239;BA.debugLine="mB = m.Get(\"b\")";
_mb = (int)(BA.ObjectToNumber(_m.Get((Object)("b"))));
 //BA.debugLineNum = 240;BA.debugLine="mR = CheckColor(mR)";
_mr = _checkcolor(_mr);
 //BA.debugLineNum = 241;BA.debugLine="mG = CheckColor(mG)";
_mg = _checkcolor(_mg);
 //BA.debugLineNum = 242;BA.debugLine="mB = CheckColor(mB)";
_mb = _checkcolor(_mb);
 //BA.debugLineNum = 243;BA.debugLine="ValueChanged(mR, mG, mB)";
_valuechanged(_mr,_mg,_mb);
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 259;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 260;BA.debugLine="mBase.Alpha = HMITileUtils.SetAlpha(mBase.Enabled";
_mbase.setAlpha(_hmitileutils._setalpha /*float*/ (_mbase.getEnabled()));
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 222;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 223;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return "";
}
public String  _updateui() throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="Private Sub UpdateUI";
 //BA.debugLineNum = 206;BA.debugLine="mR = B4XSeekBarRed.Value";
_mr = _b4xseekbarred._getvalue /*int*/ ();
 //BA.debugLineNum = 207;BA.debugLine="mG = B4XSeekBarGreen.Value";
_mg = _b4xseekbargreen._getvalue /*int*/ ();
 //BA.debugLineNum = 208;BA.debugLine="mB = B4XSeekBarBlue.Value";
_mb = _b4xseekbarblue._getvalue /*int*/ ();
 //BA.debugLineNum = 210;BA.debugLine="LabelValueRed.Text = mR";
_labelvaluered.setText(BA.NumberToString(_mr));
 //BA.debugLineNum = 211;BA.debugLine="LabelValueGreen.Text = mG";
_labelvaluegreen.setText(BA.NumberToString(_mg));
 //BA.debugLineNum = 212;BA.debugLine="LabelValueBlue.Text = mB";
_labelvalueblue.setText(BA.NumberToString(_mb));
 //BA.debugLineNum = 214;BA.debugLine="PanePreview.Color = xui.Color_RGB(mR, mG, mB)";
_panepreview.setColor(_xui.Color_RGB(_mr,_mg,_mb));
 //BA.debugLineNum = 216;BA.debugLine="If Not(mTouchStateChanged) Then";
if (__c.Not(_mtouchstatechanged)) { 
 //BA.debugLineNum = 217;BA.debugLine="ValueChanged(mR, mG, mB)";
_valuechanged(_mr,_mg,_mb);
 };
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public String  _valuechanged(int _r,int _g,int _b) throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 311;BA.debugLine="Private Sub ValueChanged(R As Int, G As Int, B As";
 //BA.debugLineNum = 312;BA.debugLine="Dim m As Map = CreateMap(\"r\":R, \"g\":G, \"b\":B)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = __c.createMap(new Object[] {(Object)("r"),(Object)(_r),(Object)("g"),(Object)(_g),(Object)("b"),(Object)(_b)});
 //BA.debugLineNum = 314;BA.debugLine="If SubExists(mCallBack, mEventName & \"_ValueChang";
if (__c.SubExists(ba,_mcallback,_meventname+"_ValueChanged")) { 
 //BA.debugLineNum = 315;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ValueChanged\"";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ValueChanged",(Object)(_m));
 };
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public String  _verticalbaseresize(double _width,double _height) throws Exception{
double _y = 0;
double _sliderstop = 0;
double _slidersheight = 0;
double _colw = 0;
 //BA.debugLineNum = 123;BA.debugLine="Private Sub VerticalBaseResize(Width As Double, He";
 //BA.debugLineNum = 124;BA.debugLine="mPreviewHeight = Height * mPreviewHeightFactor";
_mpreviewheight = _height*_mpreviewheightfactor;
 //BA.debugLineNum = 127;BA.debugLine="LabelTitle.SetLayoutAnimated(0, mPad, mPad, Width";
_labeltitle.SetLayoutAnimated((int) (0),_mpad,_mpad,_width-_mpad*2,_height*0.25);
 //BA.debugLineNum = 130;BA.debugLine="Dim y As Double = Height - mPreviewHeight - (mPad";
_y = _height-_mpreviewheight-(_mpad*0.75);
 //BA.debugLineNum = 131;BA.debugLine="PanePreview.SetLayoutAnimated(0, mPad * 2, y, Wid";
_panepreview.SetLayoutAnimated((int) (0),_mpad*2,_y,_width-_mpad*4,_mpreviewheight);
 //BA.debugLineNum = 134;BA.debugLine="Dim slidersTop As Double = Height * 0.15";
_sliderstop = _height*0.15;
 //BA.debugLineNum = 135;BA.debugLine="Dim slidersHeight As Double = Height * 0.75";
_slidersheight = _height*0.75;
 //BA.debugLineNum = 138;BA.debugLine="Dim colW As Double = Width / 3";
_colw = _width/(double)3;
 //BA.debugLineNum = 140;BA.debugLine="VerticalLayoutSliderColumn(B4XSeekBarRed,   Label";
_verticallayoutslidercolumn(_b4xseekbarred,_labelvaluered,0*_colw,_colw,_sliderstop,_slidersheight);
 //BA.debugLineNum = 141;BA.debugLine="VerticalLayoutSliderColumn(B4XSeekBarGreen, Label";
_verticallayoutslidercolumn(_b4xseekbargreen,_labelvaluegreen,1*_colw,_colw,_sliderstop,_slidersheight);
 //BA.debugLineNum = 142;BA.debugLine="VerticalLayoutSliderColumn(B4XSeekBarBlue,  Label";
_verticallayoutslidercolumn(_b4xseekbarblue,_labelvalueblue,2*_colw,_colw,_sliderstop,_slidersheight);
 //BA.debugLineNum = 144;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public String  _verticallayoutslidercolumn(b4j.example.b4xseekbar _bar,anywheresoftware.b4a.objects.B4XViewWrapper _valuelabel,double _left,double _columnwidth,double _top,double _columnheight) throws Exception{
int _valuelabelh = 0;
int _slidertop = 0;
int _sliderheight = 0;
 //BA.debugLineNum = 147;BA.debugLine="Private Sub VerticalLayoutSliderColumn(Bar As B4XS";
 //BA.debugLineNum = 148;BA.debugLine="Dim valueLabelH As Int	= ValueLabel.Height";
_valuelabelh = (int) (_valuelabel.getHeight());
 //BA.debugLineNum = 151;BA.debugLine="ValueLabel.TextSize = HMITileUtils.TEXT_SIZE_TINY";
_valuelabel.setTextSize(_hmitileutils._text_size_tiny /*float*/ );
 //BA.debugLineNum = 152;BA.debugLine="ValueLabel.SetLayoutAnimated(0, Left + mPad, Top";
_valuelabel.SetLayoutAnimated((int) (0),_left+_mpad,_top+_mpad,_columnwidth-_mpad*2,_valuelabelh);
 //BA.debugLineNum = 155;BA.debugLine="Dim sliderTop As Int = Top + ColumnHeight * 0.35";
_slidertop = (int) (_top+_columnheight*0.35);
 //BA.debugLineNum = 156;BA.debugLine="Dim sliderHeight As Int = ColumnHeight * 0.6 		'";
_sliderheight = (int) (_columnheight*0.6);
 //BA.debugLineNum = 158;BA.debugLine="Bar.mBase.SetLayoutAnimated(0, Left + mPad, slide";
_bar._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),_left+_mpad,_slidertop,_columnwidth-_mpad*2,_sliderheight);
 //BA.debugLineNum = 159;BA.debugLine="Bar.Radius2 = Bar.Radius1 * 1.2";
_bar._radius2 /*int*/  = (int) (_bar._radius1 /*int*/ *1.2);
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
