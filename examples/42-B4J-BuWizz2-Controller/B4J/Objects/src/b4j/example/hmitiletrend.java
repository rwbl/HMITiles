package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitiletrend extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitiletrend", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitiletrend.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.B4XViewWrapper _panechart = null;
public String _mtitle = "";
public String _munit = "";
public boolean _mshowborder = false;
public boolean _mautoscale = false;
public float _mscalemin = 0f;
public float _mscalemax = 0f;
public anywheresoftware.b4a.objects.B4XCanvas _mchartcanvas = null;
public boolean _mischartcanvasinitialized = false;
public anywheresoftware.b4a.objects.B4XCanvas.B4XRect _mchartrect = null;
public anywheresoftware.b4a.objects.collections.List _mdata = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _add(float _v) throws Exception{
 //BA.debugLineNum = 269;BA.debugLine="Public Sub Add(v As Float)";
 //BA.debugLineNum = 270;BA.debugLine="mData.Add(v)";
_mdata.Add((Object)(_v));
 //BA.debugLineNum = 271;BA.debugLine="DrawChart";
_drawchart();
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public String  _addall(float[] _v) throws Exception{
 //BA.debugLineNum = 278;BA.debugLine="Public Sub AddAll(v() As Float)";
 //BA.debugLineNum = 279;BA.debugLine="mData.AddAll(v)";
_mdata.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(_v));
 //BA.debugLineNum = 280;BA.debugLine="DrawChart";
_drawchart();
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 99;BA.debugLine="mBase.LoadLayout(\"hmitiletrend\")";
_mbase.LoadLayout("hmitiletrend",ba);
 //BA.debugLineNum = 101;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 102;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 103;BA.debugLine="mShowBorder		= Props.GetDefault(\"ShowBorder\", Tru";
_mshowborder = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowBorder"),(Object)(__c.True)));
 //BA.debugLineNum = 104;BA.debugLine="mAutoScale		= Props.GetDefault(\"AutoScale\", True)";
_mautoscale = BA.ObjectToBoolean(_props.GetDefault((Object)("AutoScale"),(Object)(__c.True)));
 //BA.debugLineNum = 105;BA.debugLine="mScaleMin		= Props.GetDefault(\"ScaleMin\", 0)";
_mscalemin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("ScaleMin"),(Object)(0))));
 //BA.debugLineNum = 106;BA.debugLine="mScaleMax		= Props.GetDefault(\"ScaleMax\", 100)";
_mscalemax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("ScaleMax"),(Object)(100))));
 //BA.debugLineNum = 107;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 109;BA.debugLine="ApplyStyle(HMITileUtils.STATE_NORMAL)";
_applystyle(BA.NumberToString(_hmitileutils._state_normal /*int*/ ));
 //BA.debugLineNum = 110;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _applystyle(String _tilestate) throws Exception{
 //BA.debugLineNum = 325;BA.debugLine="Public Sub ApplyStyle(tilestate As String)";
 //BA.debugLineNum = 326;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 328;BA.debugLine="PaneChart.Color = HMITileUtils.COLOR_BACKGROUND_S";
_panechart.setColor(_hmitileutils._color_background_screen /*int*/ );
 //BA.debugLineNum = 330;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 331;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 113;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 114;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 115;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 118;BA.debugLine="LabelTitle.SetLayoutAnimated(0, 0, pad,         W";
_labeltitle.SetLayoutAnimated((int) (0),0,_pad,_width,_height*0.25);
 //BA.debugLineNum = 120;BA.debugLine="PaneChart.SetLayoutAnimated (0, _ 								 HMITil";
_panechart.SetLayoutAnimated((int) (0),_hmitileutils._padding /*int*/ ,(_height*0.25)+_hmitileutils._padding /*int*/ ,_width-(_hmitileutils._padding /*int*/ *2),(_height*0.70)-(_hmitileutils._padding /*int*/ *2));
 //BA.debugLineNum = 128;BA.debugLine="If Not(mIsChartCanvasInitialized) Then";
if (__c.Not(_mischartcanvasinitialized)) { 
 //BA.debugLineNum = 129;BA.debugLine="mChartCanvas.Initialize(PaneChart)";
_mchartcanvas.Initialize(ba,_panechart);
 //BA.debugLineNum = 130;BA.debugLine="mIsChartCanvasInitialized = True";
_mischartcanvasinitialized = __c.True;
 };
 //BA.debugLineNum = 132;BA.debugLine="mChartRect.Initialize(0, 0, PaneChart.Width, Pane";
_mchartrect.Initialize((float) (0),(float) (0),(float) (_panechart.getWidth()),(float) (_panechart.getHeight()));
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 55;BA.debugLine="Private mEventName As String		'ignore";
_meventname = "";
 //BA.debugLineNum = 56;BA.debugLine="Private mCallBack As Object			'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 59;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private mLbl As B4XView				'ignore";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 64;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 65;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private PaneChart As B4XView";
_panechart = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 70;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 71;BA.debugLine="Private mShowBorder As Boolean";
_mshowborder = false;
 //BA.debugLineNum = 72;BA.debugLine="Private mAutoScale As Boolean";
_mautoscale = false;
 //BA.debugLineNum = 73;BA.debugLine="Private mScaleMin As Float";
_mscalemin = 0f;
 //BA.debugLineNum = 74;BA.debugLine="Private mScaleMax As Float";
_mscalemax = 0f;
 //BA.debugLineNum = 77;BA.debugLine="Private mChartCanvas As B4XCanvas";
_mchartcanvas = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 78;BA.debugLine="Private mIsChartCanvasInitialized As Boolean = Fa";
_mischartcanvasinitialized = __c.False;
 //BA.debugLineNum = 79;BA.debugLine="Private mChartRect As B4XRect";
_mchartrect = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 80;BA.debugLine="Private mData As List";
_mdata = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 260;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 261;BA.debugLine="mData.Clear";
_mdata.Clear();
 //BA.debugLineNum = 262;BA.debugLine="ClearChart";
_clearchart();
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return "";
}
public String  _clearchart() throws Exception{
 //BA.debugLineNum = 249;BA.debugLine="Private Sub ClearChart";
 //BA.debugLineNum = 250;BA.debugLine="mChartCanvas.ClearRect(mChartRect)";
_mchartcanvas.ClearRect(_mchartrect);
 //BA.debugLineNum = 253;BA.debugLine="If mShowBorder Then";
if (_mshowborder) { 
 //BA.debugLineNum = 254;BA.debugLine="mChartCanvas.DrawRect(mChartRect, HMITileUtils.C";
_mchartcanvas.DrawRect(_mchartrect,_hmitileutils._color_trend_border /*int*/ ,__c.False,(float) (__c.DipToCurrent((int) (1))));
 };
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _datapoints() throws Exception{
 //BA.debugLineNum = 295;BA.debugLine="Public Sub DataPoints As List";
 //BA.debugLineNum = 296;BA.debugLine="Return mData";
if (true) return _mdata;
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 90;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 91;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 92;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 93;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 95;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _drawchart() throws Exception{
float _vmin = 0f;
float _vmax = 0f;
float _v = 0f;
int _count = 0;
float _stepx = 0f;
float _prevx = 0f;
float _prevy = 0f;
int _i = 0;
float _value = 0f;
float _x = 0f;
float _norm = 0f;
float _pad = 0f;
float _usableh = 0f;
float _y = 0f;
 //BA.debugLineNum = 143;BA.debugLine="Private Sub DrawChart";
 //BA.debugLineNum = 144;BA.debugLine="If Not(PaneChart.IsInitialized) Then";
if (__c.Not(_panechart.IsInitialized())) { 
 //BA.debugLineNum = 145;BA.debugLine="Log(\"[HMITileTrend.DrawChart] Chart not ready ye";
__c.LogImpl("969664770","[HMITileTrend.DrawChart] Chart not ready yet.",0);
 //BA.debugLineNum = 146;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 150;BA.debugLine="If PaneChart.Width <= 0 Or PaneChart.Height <= 0";
if (_panechart.getWidth()<=0 || _panechart.getHeight()<=0) { 
 //BA.debugLineNum = 151;BA.debugLine="Log(\"[HMITileTrend.DrawChart] Chart not ready ye";
__c.LogImpl("969664776","[HMITileTrend.DrawChart] Chart not ready yet.",0);
 //BA.debugLineNum = 152;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 156;BA.debugLine="If mData.IsInitialized = False Or mData.Size < 2";
if (_mdata.IsInitialized()==__c.False || _mdata.getSize()<2) { 
 //BA.debugLineNum = 157;BA.debugLine="Log($\"[HMITileTrend.DrawChart] No chart data.\"$)";
__c.LogImpl("969664782",("[HMITileTrend.DrawChart] No chart data."),0);
 //BA.debugLineNum = 158;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 162;BA.debugLine="mChartCanvas.ClearRect(mChartRect)";
_mchartcanvas.ClearRect(_mchartrect);
 //BA.debugLineNum = 163;BA.debugLine="mChartCanvas.DrawRect(mChartRect, HMITileUtils.CO";
_mchartcanvas.DrawRect(_mchartrect,_hmitileutils._color_background_screen /*int*/ ,__c.True,(float) (__c.DipToCurrent((int) (0))));
 //BA.debugLineNum = 166;BA.debugLine="If mShowBorder Then";
if (_mshowborder) { 
 //BA.debugLineNum = 167;BA.debugLine="mChartCanvas.DrawRect(mChartRect, HMITileUtils.C";
_mchartcanvas.DrawRect(_mchartrect,_hmitileutils._color_trend_border /*int*/ ,__c.False,(float) (__c.DipToCurrent((int) (1))));
 };
 //BA.debugLineNum = 170;BA.debugLine="Dim vMin As Float";
_vmin = 0f;
 //BA.debugLineNum = 171;BA.debugLine="Dim vMax As Float";
_vmax = 0f;
 //BA.debugLineNum = 173;BA.debugLine="If Not(mAutoScale) Then";
if (__c.Not(_mautoscale)) { 
 //BA.debugLineNum = 174;BA.debugLine="vMin = mScaleMin";
_vmin = _mscalemin;
 //BA.debugLineNum = 175;BA.debugLine="vMax = mScaleMax";
_vmax = _mscalemax;
 }else {
 //BA.debugLineNum = 177;BA.debugLine="vMin = mData.Get(0)";
_vmin = (float)(BA.ObjectToNumber(_mdata.Get((int) (0))));
 //BA.debugLineNum = 178;BA.debugLine="vMax = vMin";
_vmax = _vmin;
 //BA.debugLineNum = 179;BA.debugLine="For Each v As Float In mData";
{
final anywheresoftware.b4a.BA.IterableList group26 = _mdata;
final int groupLen26 = group26.getSize()
;int index26 = 0;
;
for (; index26 < groupLen26;index26++){
_v = (float)(BA.ObjectToNumber(group26.Get(index26)));
 //BA.debugLineNum = 180;BA.debugLine="If v < vMin Then vMin = v";
if (_v<_vmin) { 
_vmin = _v;};
 //BA.debugLineNum = 181;BA.debugLine="If v > vMax Then vMax = v";
if (_v>_vmax) { 
_vmax = _v;};
 }
};
 //BA.debugLineNum = 183;BA.debugLine="If vMax = vMin Then vMax = vMin + 1";
if (_vmax==_vmin) { 
_vmax = (float) (_vmin+1);};
 };
 //BA.debugLineNum = 188;BA.debugLine="If vMax = vMin Then";
if (_vmax==_vmin) { 
 //BA.debugLineNum = 189;BA.debugLine="vMax = vMin + 1";
_vmax = (float) (_vmin+1);
 };
 //BA.debugLineNum = 193;BA.debugLine="Dim count As Int = mData.Size";
_count = _mdata.getSize();
 //BA.debugLineNum = 195;BA.debugLine="Dim stepX As Float = (PaneChart.Width - 1) / (cou";
_stepx = (float) ((_panechart.getWidth()-1)/(double)(_count-1));
 //BA.debugLineNum = 197;BA.debugLine="Dim prevX As Float";
_prevx = 0f;
 //BA.debugLineNum = 198;BA.debugLine="Dim prevY As Float";
_prevy = 0f;
 //BA.debugLineNum = 201;BA.debugLine="For i = 0 To count - 1";
{
final int step39 = 1;
final int limit39 = (int) (_count-1);
_i = (int) (0) ;
for (;_i <= limit39 ;_i = _i + step39 ) {
 //BA.debugLineNum = 202;BA.debugLine="Dim value As Float = mData.Get(i)";
_value = (float)(BA.ObjectToNumber(_mdata.Get(_i)));
 //BA.debugLineNum = 204;BA.debugLine="Dim x As Float = i * stepX";
_x = (float) (_i*_stepx);
 //BA.debugLineNum = 205;BA.debugLine="Dim norm As Float = (value - vMin) / (vMax - vMi";
_norm = (float) ((_value-_vmin)/(double)(_vmax-_vmin));
 //BA.debugLineNum = 206;BA.debugLine="If norm < 0 Then norm = 0";
if (_norm<0) { 
_norm = (float) (0);};
 //BA.debugLineNum = 207;BA.debugLine="If norm > 1 Then norm = 1";
if (_norm>1) { 
_norm = (float) (1);};
 //BA.debugLineNum = 209;BA.debugLine="Dim pad As Float = 1dip";
_pad = (float) (__c.DipToCurrent((int) (1)));
 //BA.debugLineNum = 210;BA.debugLine="Dim usableH As Float = PaneChart.Height - pad *";
_usableh = (float) (_panechart.getHeight()-_pad*2);
 //BA.debugLineNum = 211;BA.debugLine="Dim y As Float = pad + usableH - (norm * usableH";
_y = (float) (_pad+_usableh-(_norm*_usableh));
 //BA.debugLineNum = 213;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 214;BA.debugLine="mChartCanvas.DrawLine(prevX, prevY, x, y, HMITi";
_mchartcanvas.DrawLine(_prevx,_prevy,_x,_y,_hmitileutils._color_trend_line /*int*/ ,(float) (__c.DipToCurrent((int) (2))));
 };
 //BA.debugLineNum = 218;BA.debugLine="prevX = x";
_prevx = _x;
 //BA.debugLineNum = 219;BA.debugLine="prevY = y";
_prevy = _y;
 }
};
 //BA.debugLineNum = 221;BA.debugLine="mChartCanvas.Invalidate";
_mchartcanvas.Invalidate();
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 307;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 313;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 314;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 83;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 84;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 85;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 86;BA.debugLine="mData.Initialize";
_mdata.Initialize();
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 303;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 304;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _text) throws Exception{
 //BA.debugLineNum = 310;BA.debugLine="Public Sub setUnit(text As String)";
 //BA.debugLineNum = 311;BA.debugLine="mUnit = text";
_munit = _text;
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public int  _size() throws Exception{
 //BA.debugLineNum = 287;BA.debugLine="Public Sub Size As Int";
 //BA.debugLineNum = 288;BA.debugLine="Return mData.Size";
if (true) return _mdata.getSize();
 //BA.debugLineNum = 289;BA.debugLine="End Sub";
return 0;
}
public String  _updatechart(anywheresoftware.b4a.objects.collections.List _data) throws Exception{
float _v = 0f;
 //BA.debugLineNum = 230;BA.debugLine="Public Sub UpdateChart(data As List)";
 //BA.debugLineNum = 232;BA.debugLine="If data.IsInitialized = False Or data.Size < 2 Th";
if (_data.IsInitialized()==__c.False || _data.getSize()<2) { 
 //BA.debugLineNum = 233;BA.debugLine="Log($\"[HMITileTrend.UpdateChart] No chart data.\"";
__c.LogImpl("969730307",("[HMITileTrend.UpdateChart] No chart data."),0);
 //BA.debugLineNum = 234;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 238;BA.debugLine="mData.clear";
_mdata.Clear();
 //BA.debugLineNum = 239;BA.debugLine="For Each v As Float In data";
{
final anywheresoftware.b4a.BA.IterableList group6 = _data;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_v = (float)(BA.ObjectToNumber(group6.Get(index6)));
 //BA.debugLineNum = 240;BA.debugLine="mData.Add(v)";
_mdata.Add((Object)(_v));
 }
};
 //BA.debugLineNum = 244;BA.debugLine="DrawChart";
_drawchart();
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
