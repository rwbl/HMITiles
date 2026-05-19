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
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
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
public int _mdatapoints = 0;
public String _mstatus = "";
public anywheresoftware.b4a.objects.B4XCanvas _mchartcanvas = null;
public boolean _mischartcanvasinitialized = false;
public anywheresoftware.b4a.objects.B4XCanvas.B4XRect _mchartrect = null;
public int _mgridlinecolor = 0;
public anywheresoftware.b4a.objects.collections.List _mdata = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public static class _pointdata{
public boolean IsInitialized;
public float X;
public float Y;
public void Initialize() {
IsInitialized = true;
X = 0f;
Y = 0f;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _add(float _v) throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Public Sub Add(v As Float)";
 //BA.debugLineNum = 312;BA.debugLine="mData.Add(v)";
_mdata.Add((Object)(_v));
 //BA.debugLineNum = 314;BA.debugLine="If mDataPoints > 0 Then";
if (_mdatapoints>0) { 
 //BA.debugLineNum = 316;BA.debugLine="If mData.Size > mDataPoints Then";
if (_mdata.getSize()>_mdatapoints) { 
 //BA.debugLineNum = 317;BA.debugLine="mData.RemoveAt(0)";
_mdata.RemoveAt((int) (0));
 };
 };
 //BA.debugLineNum = 320;BA.debugLine="DrawChart";
_drawchart();
 //BA.debugLineNum = 321;BA.debugLine="End Sub";
return "";
}
public String  _addall(float[] _v) throws Exception{
 //BA.debugLineNum = 327;BA.debugLine="Public Sub AddAll(v() As Float)";
 //BA.debugLineNum = 328;BA.debugLine="mData.AddAll(v)";
_mdata.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(_v));
 //BA.debugLineNum = 329;BA.debugLine="DrawChart";
_drawchart();
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
return "";
}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 107;BA.debugLine="BasePane.LoadLayout(\"hmitiletrend\")";
_basepane.LoadLayout("hmitiletrend",ba);
 //BA.debugLineNum = 109;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 110;BA.debugLine="LabelTitle.Text = mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 111;BA.debugLine="mUnit			= Props.Get(\"Unit\")";
_munit = BA.ObjectToString(_props.Get((Object)("Unit")));
 //BA.debugLineNum = 113;BA.debugLine="mShowBorder		= Props.GetDefault(\"ShowBorder\", Tru";
_mshowborder = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowBorder"),(Object)(__c.True)));
 //BA.debugLineNum = 114;BA.debugLine="mAutoScale		= Props.GetDefault(\"AutoScale\", True)";
_mautoscale = BA.ObjectToBoolean(_props.GetDefault((Object)("AutoScale"),(Object)(__c.True)));
 //BA.debugLineNum = 115;BA.debugLine="mScaleMin		= Props.GetDefault(\"ScaleMin\", 0)";
_mscalemin = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("ScaleMin"),(Object)(0))));
 //BA.debugLineNum = 116;BA.debugLine="mScaleMax		= Props.GetDefault(\"ScaleMax\", 100)";
_mscalemax = (float)(BA.ObjectToNumber(_props.GetDefault((Object)("ScaleMax"),(Object)(100))));
 //BA.debugLineNum = 117;BA.debugLine="mDataPoints		= Props.GetDefault(\"DataPoints\", 0)";
_mdatapoints = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("DataPoints"),(Object)(0))));
 //BA.debugLineNum = 119;BA.debugLine="ApplyStatusStyle(HMITileUtils.STATUS_NORMAL)";
_applystatusstyle(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 120;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _applystatusstyle(String _status) throws Exception{
 //BA.debugLineNum = 420;BA.debugLine="Private Sub ApplyStatusStyle(status As String)";
 //BA.debugLineNum = 421;BA.debugLine="mStatus = status";
_mstatus = _status;
 //BA.debugLineNum = 423;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 425;BA.debugLine="PaneChart.Color = HMITileUtils.COLOR_BACKGROUND_S";
_panechart.setColor(_hmitileutils._color_background_screen /*int*/ );
 //BA.debugLineNum = 427;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 428;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _pad = 0;
 //BA.debugLineNum = 123;BA.debugLine="Private Sub Base_Resize(Width As Double, Height As";
 //BA.debugLineNum = 124;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 126;BA.debugLine="LabelTitle.SetLayoutAnimated(0, 0, 0,         Wid";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 128;BA.debugLine="Dim pad As Int = 4";
_pad = (int) (4);
 //BA.debugLineNum = 129;BA.debugLine="PaneChart.SetLayoutAnimated (0, _ 								 pad, _";
_panechart.SetLayoutAnimated((int) (0),_pad,(_height*0.25)+_pad,_width-(_pad*2),(_height*0.70)-(_pad*2));
 //BA.debugLineNum = 137;BA.debugLine="If Not(mIsChartCanvasInitialized) Then";
if (__c.Not(_mischartcanvasinitialized)) { 
 //BA.debugLineNum = 138;BA.debugLine="mChartCanvas.Initialize(PaneChart)";
_mchartcanvas.Initialize(ba,_panechart);
 //BA.debugLineNum = 139;BA.debugLine="mIsChartCanvasInitialized = True";
_mischartcanvasinitialized = __c.True;
 };
 //BA.debugLineNum = 141;BA.debugLine="mChartRect.Initialize(0, 0, PaneChart.Width, Pane";
_mchartrect.Initialize((float) (0),(float) (0),(float) (_panechart.getWidth()),(float) (_panechart.getHeight()));
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 56;BA.debugLine="Private mEventName As String		'ignore";
_meventname = "";
 //BA.debugLineNum = 57;BA.debugLine="Private mCallBack As Object			'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 60;BA.debugLine="Public BasePane As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private BaseLabel As B4XView		'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 65;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 66;BA.debugLine="Private LabelTitle As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private PaneChart As B4XView";
_panechart = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private mTitle As String";
_mtitle = "";
 //BA.debugLineNum = 71;BA.debugLine="Private mUnit As String";
_munit = "";
 //BA.debugLineNum = 72;BA.debugLine="Private mShowBorder As Boolean";
_mshowborder = false;
 //BA.debugLineNum = 73;BA.debugLine="Private mAutoScale As Boolean";
_mautoscale = false;
 //BA.debugLineNum = 74;BA.debugLine="Private mScaleMin As Float";
_mscalemin = 0f;
 //BA.debugLineNum = 75;BA.debugLine="Private mScaleMax As Float";
_mscalemax = 0f;
 //BA.debugLineNum = 76;BA.debugLine="Private mDataPoints As Int";
_mdatapoints = 0;
 //BA.debugLineNum = 79;BA.debugLine="Private mStatus As String";
_mstatus = "";
 //BA.debugLineNum = 82;BA.debugLine="Private mChartCanvas As B4XCanvas";
_mchartcanvas = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 83;BA.debugLine="Private mIsChartCanvasInitialized As Boolean = Fa";
_mischartcanvasinitialized = __c.False;
 //BA.debugLineNum = 84;BA.debugLine="Private mChartRect As B4XRect";
_mchartrect = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 85;BA.debugLine="Private mGridLineColor As Int = HMITileUtils.COLO";
_mgridlinecolor = _hmitileutils._color_trend_grid_line /*int*/ ;
 //BA.debugLineNum = 87;BA.debugLine="Type PointData (X As Float, Y As Float)";
;
 //BA.debugLineNum = 88;BA.debugLine="Private mData As List";
_mdata = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 303;BA.debugLine="mData.Clear";
_mdata.Clear();
 //BA.debugLineNum = 304;BA.debugLine="ClearChart";
_clearchart();
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public String  _clearchart() throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Private Sub ClearChart";
 //BA.debugLineNum = 292;BA.debugLine="mChartCanvas.ClearRect(mChartRect)";
_mchartcanvas.ClearRect(_mchartrect);
 //BA.debugLineNum = 295;BA.debugLine="If mShowBorder Then";
if (_mshowborder) { 
 //BA.debugLineNum = 296;BA.debugLine="mChartCanvas.DrawRect(mChartRect, HMITileUtils.C";
_mchartcanvas.DrawRect(_mchartrect,_hmitileutils._color_trend_border /*int*/ ,__c.False,(float) (__c.DipToCurrent((int) (1))));
 };
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _datapoints() throws Exception{
 //BA.debugLineNum = 355;BA.debugLine="Public Sub DataPoints As List";
 //BA.debugLineNum = 356;BA.debugLine="Return mData";
if (true) return _mdata;
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
 //BA.debugLineNum = 98;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 99;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 100;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 101;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 103;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public String  _drawchart() throws Exception{
float _padv = 0f;
float _padh = 0f;
float _usableh = 0f;
float _usablew = 0f;
float[] _gridlevels = null;
Object _glevel = null;
float _gridy = 0f;
float _vmin = 0f;
float _vmax = 0f;
float _v = 0f;
int _count = 0;
anywheresoftware.b4a.objects.collections.List _rawpoints = null;
int _i = 0;
float _value = 0f;
float _norm = 0f;
b4j.example.hmitiletrend._pointdata _p = null;
anywheresoftware.b4a.objects.collections.List _finalpoints = null;
b4j.example.hmitiletrend._pointdata _pstart = null;
b4j.example.hmitiletrend._pointdata _pend = null;
 //BA.debugLineNum = 152;BA.debugLine="Private Sub DrawChart";
 //BA.debugLineNum = 153;BA.debugLine="Dim padV As Float		= 4dip";
_padv = (float) (__c.DipToCurrent((int) (4)));
 //BA.debugLineNum = 154;BA.debugLine="Dim padH As Float		= 2dip";
_padh = (float) (__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 155;BA.debugLine="Dim usableH As Float	= PaneChart.Height - (padV *";
_usableh = (float) (_panechart.getHeight()-(_padv*2));
 //BA.debugLineNum = 156;BA.debugLine="Dim usableW As Float	= PaneChart.Width - (padH *";
_usablew = (float) (_panechart.getWidth()-(_padh*2));
 //BA.debugLineNum = 159;BA.debugLine="If Not(PaneChart.IsInitialized) Or PaneChart.Widt";
if (__c.Not(_panechart.IsInitialized()) || _panechart.getWidth()<=0 || _panechart.getHeight()<=0) { 
if (true) return "";};
 //BA.debugLineNum = 160;BA.debugLine="If mData.IsInitialized = False Or mData.Size < 2";
if (_mdata.IsInitialized()==__c.False || _mdata.getSize()<2) { 
if (true) return "";};
 //BA.debugLineNum = 164;BA.debugLine="PaneChart.Color = xui.Color_Transparent";
_panechart.setColor(_xui.Color_Transparent);
 //BA.debugLineNum = 168;BA.debugLine="mChartCanvas.ClearRect(mChartRect)";
_mchartcanvas.ClearRect(_mchartrect);
 //BA.debugLineNum = 173;BA.debugLine="If mShowBorder Then";
if (_mshowborder) { 
 //BA.debugLineNum = 174;BA.debugLine="mChartCanvas.DrawRect(mChartRect, HMITileUtils.C";
_mchartcanvas.DrawRect(_mchartrect,_hmitileutils._color_border_dark /*int*/ ,__c.False,(float) (__c.DipToCurrent((int) (1))));
 };
 //BA.debugLineNum = 177;BA.debugLine="Dim gridLevels() As Float = Array As Float(0.33,";
_gridlevels = new float[]{(float) (0.33),(float) (0.66)};
 //BA.debugLineNum = 179;BA.debugLine="For Each glevel In gridLevels";
{
final float[] group13 = _gridlevels;
final int groupLen13 = group13.length
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_glevel = (Object)(group13[index13]);
 //BA.debugLineNum = 180;BA.debugLine="Dim gridY As Float = padV + (usableH * (1 - glev";
_gridy = (float) (_padv+(_usableh*(1-(double)(BA.ObjectToNumber(_glevel)))));
 //BA.debugLineNum = 181;BA.debugLine="mChartCanvas.DrawLine(padH, gridY, PaneChart.Wid";
_mchartcanvas.DrawLine(_padh,_gridy,(float) (_panechart.getWidth()-_padh),_gridy,_mgridlinecolor,(float) (__c.DipToCurrent((int) (1))));
 }
};
 //BA.debugLineNum = 185;BA.debugLine="Dim vMin, vMax As Float";
_vmin = 0f;
_vmax = 0f;
 //BA.debugLineNum = 186;BA.debugLine="If Not(mAutoScale) Then";
if (__c.Not(_mautoscale)) { 
 //BA.debugLineNum = 187;BA.debugLine="vMin = mScaleMin";
_vmin = _mscalemin;
 //BA.debugLineNum = 188;BA.debugLine="vMax = mScaleMax";
_vmax = _mscalemax;
 }else {
 //BA.debugLineNum = 190;BA.debugLine="vMin = mData.Get(0)";
_vmin = (float)(BA.ObjectToNumber(_mdata.Get((int) (0))));
 //BA.debugLineNum = 191;BA.debugLine="vMax = vMin";
_vmax = _vmin;
 //BA.debugLineNum = 192;BA.debugLine="For Each v As Float In mData";
{
final anywheresoftware.b4a.BA.IterableList group24 = _mdata;
final int groupLen24 = group24.getSize()
;int index24 = 0;
;
for (; index24 < groupLen24;index24++){
_v = (float)(BA.ObjectToNumber(group24.Get(index24)));
 //BA.debugLineNum = 193;BA.debugLine="vMin = Min(vMin, v)";
_vmin = (float) (__c.Min(_vmin,_v));
 //BA.debugLineNum = 194;BA.debugLine="vMax = Max(vMax, v)";
_vmax = (float) (__c.Max(_vmax,_v));
 }
};
 };
 //BA.debugLineNum = 199;BA.debugLine="If vMax = vMin Then vMax = vMin + 1";
if (_vmax==_vmin) { 
_vmax = (float) (_vmin+1);};
 //BA.debugLineNum = 203;BA.debugLine="Dim count As Int = mData.Size";
_count = _mdata.getSize();
 //BA.debugLineNum = 206;BA.debugLine="Dim RawPoints As List";
_rawpoints = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 207;BA.debugLine="RawPoints.Initialize";
_rawpoints.Initialize();
 //BA.debugLineNum = 208;BA.debugLine="For i = 0 To count - 1";
{
final int step33 = 1;
final int limit33 = (int) (_count-1);
_i = (int) (0) ;
for (;_i <= limit33 ;_i = _i + step33 ) {
 //BA.debugLineNum = 209;BA.debugLine="Dim value As Float = mData.Get(i)";
_value = (float)(BA.ObjectToNumber(_mdata.Get(_i)));
 //BA.debugLineNum = 210;BA.debugLine="Dim norm As Float = (value - vMin) / (vMax - vMi";
_norm = (float) ((_value-_vmin)/(double)(_vmax-_vmin));
 //BA.debugLineNum = 211;BA.debugLine="norm = Max(0, Min(1, norm))";
_norm = (float) (__c.Max(0,__c.Min(1,_norm)));
 //BA.debugLineNum = 213;BA.debugLine="Dim p As PointData";
_p = new b4j.example.hmitiletrend._pointdata();
 //BA.debugLineNum = 215;BA.debugLine="p.X = padH + (i * (usableW / (count - 1)))";
_p.X /*float*/  = (float) (_padh+(_i*(_usablew/(double)(_count-1))));
 //BA.debugLineNum = 217;BA.debugLine="p.Y = padV + usableH - (norm * usableH)";
_p.Y /*float*/  = (float) (_padv+_usableh-(_norm*_usableh));
 //BA.debugLineNum = 218;BA.debugLine="RawPoints.Add(p)";
_rawpoints.Add((Object)(_p));
 }
};
 //BA.debugLineNum = 223;BA.debugLine="Dim FinalPoints As List = SmoothPoints(RawPoints)";
_finalpoints = new anywheresoftware.b4a.objects.collections.List();
_finalpoints = _smoothpoints(_rawpoints);
 //BA.debugLineNum = 224;BA.debugLine="FinalPoints = SmoothPoints(FinalPoints)";
_finalpoints = _smoothpoints(_finalpoints);
 //BA.debugLineNum = 227;BA.debugLine="For i = 1 To FinalPoints.Size - 1";
{
final int step44 = 1;
final int limit44 = (int) (_finalpoints.getSize()-1);
_i = (int) (1) ;
for (;_i <= limit44 ;_i = _i + step44 ) {
 //BA.debugLineNum = 228;BA.debugLine="Dim pStart As PointData = FinalPoints.Get(i - 1)";
_pstart = (b4j.example.hmitiletrend._pointdata)(_finalpoints.Get((int) (_i-1)));
 //BA.debugLineNum = 229;BA.debugLine="Dim pEnd As PointData = FinalPoints.Get(i)";
_pend = (b4j.example.hmitiletrend._pointdata)(_finalpoints.Get(_i));
 //BA.debugLineNum = 230;BA.debugLine="mChartCanvas.DrawLine(pStart.X, pStart.Y, pEnd.X";
_mchartcanvas.DrawLine(_pstart.X /*float*/ ,_pstart.Y /*float*/ ,_pend.X /*float*/ ,_pend.Y /*float*/ ,_hmitileutils._color_trend_line /*int*/ ,(float) (__c.DipToCurrent((int) (2))));
 }
};
 //BA.debugLineNum = 233;BA.debugLine="mChartCanvas.Invalidate";
_mchartcanvas.Invalidate();
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
return "";
}
public int  _getgridlinecolor() throws Exception{
 //BA.debugLineNum = 381;BA.debugLine="Public Sub getGridLineColor As Int";
 //BA.debugLineNum = 382;BA.debugLine="Return mGridLineColor";
if (true) return _mgridlinecolor;
 //BA.debugLineNum = 383;BA.debugLine="End Sub";
return 0;
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 406;BA.debugLine="Public Sub getStatus As String";
 //BA.debugLineNum = 407;BA.debugLine="Return mStatus";
if (true) return _mstatus;
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 362;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 363;BA.debugLine="Return LabelTitle.Text";
if (true) return _labeltitle.getText();
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return "";
}
public String  _getunit() throws Exception{
 //BA.debugLineNum = 373;BA.debugLine="Public Sub getUnit As String";
 //BA.debugLineNum = 374;BA.debugLine="Return mUnit";
if (true) return _munit;
 //BA.debugLineNum = 375;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 91;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 92;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 93;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 94;BA.debugLine="mData.Initialize";
_mdata.Initialize();
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public String  _panechart_click() throws Exception{
 //BA.debugLineNum = 443;BA.debugLine="Private Sub PaneChart_Click";
 //BA.debugLineNum = 444;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 445;BA.debugLine="End Sub";
return "";
}
public String  _panechart_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 437;BA.debugLine="Private Sub PaneChart_MouseClicked (EventData As M";
 //BA.debugLineNum = 438;BA.debugLine="TileClick";
_tileclick();
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public String  _remove(int _index) throws Exception{
 //BA.debugLineNum = 336;BA.debugLine="Public Sub Remove(index As Int)";
 //BA.debugLineNum = 337;BA.debugLine="If index >= 0 And index <= mData.Size - 1 Then";
if (_index>=0 && _index<=_mdata.getSize()-1) { 
 //BA.debugLineNum = 338;BA.debugLine="mData.RemoveAt(index)";
_mdata.RemoveAt(_index);
 //BA.debugLineNum = 339;BA.debugLine="DrawChart";
_drawchart();
 };
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return "";
}
public String  _setgridlinecolor(int _value) throws Exception{
 //BA.debugLineNum = 377;BA.debugLine="Public Sub setGridLineColor(value As Int)";
 //BA.debugLineNum = 378;BA.debugLine="mGridLineColor = value";
_mgridlinecolor = _value;
 //BA.debugLineNum = 379;BA.debugLine="DrawChart";
_drawchart();
 //BA.debugLineNum = 380;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(String _value) throws Exception{
 //BA.debugLineNum = 403;BA.debugLine="Public Sub setStatus(value As String)";
 //BA.debugLineNum = 404;BA.debugLine="ApplyStatusStyle(value)";
_applystatusstyle(_value);
 //BA.debugLineNum = 405;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _text) throws Exception{
 //BA.debugLineNum = 359;BA.debugLine="Public Sub setTitle(text As String)";
 //BA.debugLineNum = 360;BA.debugLine="LabelTitle.Text = text";
_labeltitle.setText(_text);
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return "";
}
public String  _settitlecolorinfo() throws Exception{
 //BA.debugLineNum = 366;BA.debugLine="Public Sub SetTitleColorInfo";
 //BA.debugLineNum = 367;BA.debugLine="LabelTitle.TextColor = HMITileUtils.COLOR_TEXT_IN";
_labeltitle.setTextColor(_hmitileutils._color_text_info /*int*/ );
 //BA.debugLineNum = 368;BA.debugLine="End Sub";
return "";
}
public String  _setunit(String _text) throws Exception{
 //BA.debugLineNum = 370;BA.debugLine="Public Sub setUnit(text As String)";
 //BA.debugLineNum = 371;BA.debugLine="mUnit = text";
_munit = _text;
 //BA.debugLineNum = 372;BA.debugLine="End Sub";
return "";
}
public int  _size() throws Exception{
 //BA.debugLineNum = 347;BA.debugLine="Public Sub Size As Int";
 //BA.debugLineNum = 348;BA.debugLine="Return mData.Size";
if (true) return _mdata.getSize();
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.collections.List  _smoothpoints(anywheresoftware.b4a.objects.collections.List _points) throws Exception{
anywheresoftware.b4a.objects.collections.List _smoothed = null;
int _i = 0;
b4j.example.hmitiletrend._pointdata _p0 = null;
b4j.example.hmitiletrend._pointdata _p1 = null;
b4j.example.hmitiletrend._pointdata _q = null;
b4j.example.hmitiletrend._pointdata _r = null;
 //BA.debugLineNum = 237;BA.debugLine="Private Sub SmoothPoints(Points As List) As List";
 //BA.debugLineNum = 238;BA.debugLine="Dim Smoothed As List";
_smoothed = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 239;BA.debugLine="Smoothed.Initialize";
_smoothed.Initialize();
 //BA.debugLineNum = 240;BA.debugLine="If Points.Size < 3 Then Return Points";
if (_points.getSize()<3) { 
if (true) return _points;};
 //BA.debugLineNum = 242;BA.debugLine="Smoothed.Add(Points.Get(0))";
_smoothed.Add(_points.Get((int) (0)));
 //BA.debugLineNum = 243;BA.debugLine="For i = 0 To Points.Size - 2";
{
final int step5 = 1;
final int limit5 = (int) (_points.getSize()-2);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 244;BA.debugLine="Dim p0 As PointData = Points.Get(i)";
_p0 = (b4j.example.hmitiletrend._pointdata)(_points.Get(_i));
 //BA.debugLineNum = 245;BA.debugLine="Dim p1 As PointData = Points.Get(i + 1)";
_p1 = (b4j.example.hmitiletrend._pointdata)(_points.Get((int) (_i+1)));
 //BA.debugLineNum = 247;BA.debugLine="Dim q, r As PointData";
_q = new b4j.example.hmitiletrend._pointdata();
_r = new b4j.example.hmitiletrend._pointdata();
 //BA.debugLineNum = 249;BA.debugLine="q.X = p0.X * 0.75 + p1.X * 0.25";
_q.X /*float*/  = (float) (_p0.X /*float*/ *0.75+_p1.X /*float*/ *0.25);
 //BA.debugLineNum = 250;BA.debugLine="q.Y = p0.Y * 0.75 + p1.Y * 0.25";
_q.Y /*float*/  = (float) (_p0.Y /*float*/ *0.75+_p1.Y /*float*/ *0.25);
 //BA.debugLineNum = 252;BA.debugLine="r.X = p0.X * 0.25 + p1.X * 0.75";
_r.X /*float*/  = (float) (_p0.X /*float*/ *0.25+_p1.X /*float*/ *0.75);
 //BA.debugLineNum = 253;BA.debugLine="r.Y = p0.Y * 0.25 + p1.Y * 0.75";
_r.Y /*float*/  = (float) (_p0.Y /*float*/ *0.25+_p1.Y /*float*/ *0.75);
 //BA.debugLineNum = 255;BA.debugLine="Smoothed.Add(q)";
_smoothed.Add((Object)(_q));
 //BA.debugLineNum = 256;BA.debugLine="Smoothed.Add(r)";
_smoothed.Add((Object)(_r));
 }
};
 //BA.debugLineNum = 258;BA.debugLine="Smoothed.Add(Points.Get(Points.Size - 1))";
_smoothed.Add(_points.Get((int) (_points.getSize()-1)));
 //BA.debugLineNum = 259;BA.debugLine="Return Smoothed";
if (true) return _smoothed;
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return null;
}
public String  _statusalarm(String _text) throws Exception{
 //BA.debugLineNum = 394;BA.debugLine="Public Sub StatusAlarm(text As String)";
 //BA.debugLineNum = 395;BA.debugLine="setStatus(HMITileUtils.STATUS_ALARM)";
_setstatus(_hmitileutils._status_alarm /*String*/ );
 //BA.debugLineNum = 396;BA.debugLine="End Sub";
return "";
}
public String  _statusdisabled(String _text) throws Exception{
 //BA.debugLineNum = 398;BA.debugLine="Public Sub StatusDisabled(text As String)";
 //BA.debugLineNum = 399;BA.debugLine="setStatus(HMITileUtils.STATUS_DISABLED)";
_setstatus(_hmitileutils._status_disabled /*String*/ );
 //BA.debugLineNum = 400;BA.debugLine="End Sub";
return "";
}
public String  _statusnormal(String _text) throws Exception{
 //BA.debugLineNum = 386;BA.debugLine="Public Sub StatusNormal(text As String)";
 //BA.debugLineNum = 387;BA.debugLine="setStatus(HMITileUtils.STATUS_NORMAL)";
_setstatus(_hmitileutils._status_normal /*String*/ );
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return "";
}
public String  _statuswarning(String _text) throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Public Sub StatusWarning(text As String)";
 //BA.debugLineNum = 391;BA.debugLine="setStatus(HMITileUtils.STATUS_WARNING)";
_setstatus(_hmitileutils._status_warning /*String*/ );
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public String  _tileclick() throws Exception{
 //BA.debugLineNum = 447;BA.debugLine="Private Sub TileClick";
 //BA.debugLineNum = 448;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 449;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click\")";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_Click");
 };
 //BA.debugLineNum = 451;BA.debugLine="End Sub";
return "";
}
public String  _updatechart(anywheresoftware.b4a.objects.collections.List _data) throws Exception{
float _v = 0f;
 //BA.debugLineNum = 272;BA.debugLine="Public Sub UpdateChart(data As List)";
 //BA.debugLineNum = 274;BA.debugLine="If data.IsInitialized = False Or data.Size < 2 Th";
if (_data.IsInitialized()==__c.False || _data.getSize()<2) { 
 //BA.debugLineNum = 275;BA.debugLine="Log($\"[HMITileTrend.UpdateChart] No chart data.\"";
__c.LogImpl("978708739",("[HMITileTrend.UpdateChart] No chart data."),0);
 //BA.debugLineNum = 276;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 280;BA.debugLine="mData.clear";
_mdata.Clear();
 //BA.debugLineNum = 281;BA.debugLine="For Each v As Float In data";
{
final anywheresoftware.b4a.BA.IterableList group6 = _data;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_v = (float)(BA.ObjectToNumber(group6.Get(index6)));
 //BA.debugLineNum = 282;BA.debugLine="mData.Add(v)";
_mdata.Add((Object)(_v));
 }
};
 //BA.debugLineNum = 286;BA.debugLine="DrawChart";
_drawchart();
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
