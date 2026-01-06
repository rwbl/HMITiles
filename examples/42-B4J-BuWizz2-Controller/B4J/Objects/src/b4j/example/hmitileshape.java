package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitileshape extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitileshape", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitileshape.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _shape_hline = "";
public String _shape_vline = "";
public String _shape_cross = "";
public String _shape_cornerleftup = "";
public String _shape_cornerleftdown = "";
public String _shape_cornerrightup = "";
public String _shape_cornerrightdown = "";
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _paneshape = null;
public anywheresoftware.b4a.objects.B4XCanvas _canvasshape = null;
public String _mshapetype = "";
public int _mstrokewidth = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 60;BA.debugLine="mBase.LoadLayout(\"hmitileshape\")";
_mbase.LoadLayout("hmitileshape",ba);
 //BA.debugLineNum = 63;BA.debugLine="mShapeType		= Props.GetDefault(\"ShapeType\", SHAPE";
_mshapetype = BA.ObjectToString(_props.GetDefault((Object)("ShapeType"),(Object)(_shape_hline)));
 //BA.debugLineNum = 64;BA.debugLine="mStrokeWidth	= Props.GetDefault(\"StrokeWidth\", 2)";
_mstrokewidth = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("StrokeWidth"),(Object)(2))));
 //BA.debugLineNum = 67;BA.debugLine="CanvasShape.Initialize(PaneShape)";
_canvasshape.Initialize(ba,_paneshape);
 //BA.debugLineNum = 69;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 71;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 81;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 82;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, 0)";
_mbase.SetColorAndBorder(_mbase.getColor(),0,(int) (0),0);
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 86;BA.debugLine="If Not(PaneShape.IsInitialized) Then Return";
if (__c.Not(_paneshape.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 88;BA.debugLine="PaneShape.SetLayoutAnimated(0, 0, 0, Width, Heigh";
_paneshape.SetLayoutAnimated((int) (0),0,0,_width,_height);
 //BA.debugLineNum = 90;BA.debugLine="DrawShape";
_drawshape();
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private SHAPE_HLINE As String 			= \"HLine\"";
_shape_hline = "HLine";
 //BA.debugLineNum = 21;BA.debugLine="Private SHAPE_VLINE As String 			= \"VLine\"";
_shape_vline = "VLine";
 //BA.debugLineNum = 22;BA.debugLine="Private SHAPE_CROSS As String 			= \"Cross\"";
_shape_cross = "Cross";
 //BA.debugLineNum = 23;BA.debugLine="Private SHAPE_CORNERLEFTUP As String 	= \"CornerLe";
_shape_cornerleftup = "CornerLeftUp";
 //BA.debugLineNum = 24;BA.debugLine="Private SHAPE_CORNERLEFTDOWN As String 	= \"Corner";
_shape_cornerleftdown = "CornerLeftDown";
 //BA.debugLineNum = 25;BA.debugLine="Private SHAPE_CORNERRIGHTUP As String 	= \"CornerR";
_shape_cornerrightup = "CornerRightUp";
 //BA.debugLineNum = 26;BA.debugLine="Private SHAPE_CORNERRIGHTDOWN As String	= \"Corner";
_shape_cornerrightdown = "CornerRightDown";
 //BA.debugLineNum = 29;BA.debugLine="Private mEventName As String	'ignore";
_meventname = "";
 //BA.debugLineNum = 30;BA.debugLine="Private mCallBack As Object		'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 33;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 35;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 38;BA.debugLine="Private PaneShape As B4XView";
_paneshape = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private CanvasShape As B4XCanvas";
_canvasshape = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 42;BA.debugLine="Private mShapeType As String";
_mshapetype = "";
 //BA.debugLineNum = 43;BA.debugLine="Private mStrokeWidth As Int";
_mstrokewidth = 0;
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 52;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 53;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 54;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 56;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public String  _drawcorner(float _cx,float _cy,int _startangle) throws Exception{
float _r = 0f;
float _sweeplength = 0f;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _shapearc = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _maskarc = null;
 //BA.debugLineNum = 160;BA.debugLine="Private Sub DrawCorner(cx As Float, cy As Float, s";
 //BA.debugLineNum = 161;BA.debugLine="Dim r As Float = PaneShape.Width / 2 + mStrokeWid";
_r = (float) (_paneshape.getWidth()/(double)2+_mstrokewidth/(double)2);
 //BA.debugLineNum = 162;BA.debugLine="Dim sweepLength As Float = 90";
_sweeplength = (float) (90);
 //BA.debugLineNum = 163;BA.debugLine="Dim shapeArc As B4XPath";
_shapearc = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 164;BA.debugLine="shapeArc.InitializeArc(cx, cy, r, startangle, swe";
_shapearc.InitializeArc(_cx,_cy,_r,(float) (_startangle),_sweeplength);
 //BA.debugLineNum = 165;BA.debugLine="CanvasShape.DrawPath(shapeArc, HMITileUtils.COLOR";
_canvasshape.DrawPath(_shapearc,_hmitileutils._color_border_default /*int*/ ,__c.False,(float) (_mstrokewidth));
 //BA.debugLineNum = 166;BA.debugLine="Dim maskArc As B4XPath";
_maskarc = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 167;BA.debugLine="maskArc.InitializeArc(cx, cy, r - mStrokeWidth, s";
_maskarc.InitializeArc(_cx,_cy,(float) (_r-_mstrokewidth),(float) (_startangle),(float) (180));
 //BA.debugLineNum = 168;BA.debugLine="CanvasShape.DrawPath(maskArc, HMITileUtils.COLOR_";
_canvasshape.DrawPath(_maskarc,_hmitileutils._color_tile_normal_background /*int*/ ,__c.True,(float) (0));
 //BA.debugLineNum = 169;BA.debugLine="CanvasShape.Invalidate";
_canvasshape.Invalidate();
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public String  _drawline(boolean _vertical) throws Exception{
float _x1 = 0f;
float _y1 = 0f;
float _x2 = 0f;
float _y2 = 0f;
float _cx = 0f;
float _cy = 0f;
 //BA.debugLineNum = 130;BA.debugLine="Private Sub DrawLine(vertical As Boolean)";
 //BA.debugLineNum = 131;BA.debugLine="Dim x1 As Float";
_x1 = 0f;
 //BA.debugLineNum = 132;BA.debugLine="Dim y1 As Float";
_y1 = 0f;
 //BA.debugLineNum = 133;BA.debugLine="Dim x2 As Float";
_x2 = 0f;
 //BA.debugLineNum = 134;BA.debugLine="Dim y2 As Float";
_y2 = 0f;
 //BA.debugLineNum = 135;BA.debugLine="Dim cx As Float	= PaneShape.Width / 2";
_cx = (float) (_paneshape.getWidth()/(double)2);
 //BA.debugLineNum = 136;BA.debugLine="Dim cy As Float = PaneShape.Height / 2";
_cy = (float) (_paneshape.getHeight()/(double)2);
 //BA.debugLineNum = 138;BA.debugLine="If Not(vertical) Then";
if (__c.Not(_vertical)) { 
 //BA.debugLineNum = 139;BA.debugLine="x1 = 0";
_x1 = (float) (0);
 //BA.debugLineNum = 140;BA.debugLine="y1 = cy";
_y1 = _cy;
 //BA.debugLineNum = 141;BA.debugLine="x2 = PaneShape.Width";
_x2 = (float) (_paneshape.getWidth());
 //BA.debugLineNum = 142;BA.debugLine="y2 = cy";
_y2 = _cy;
 //BA.debugLineNum = 143;BA.debugLine="CanvasShape.DrawLine(x1,y1,x2,y2,HMITileUtils.CO";
_canvasshape.DrawLine(_x1,_y1,_x2,_y2,_hmitileutils._color_border_default /*int*/ ,(float) (_mstrokewidth));
 //BA.debugLineNum = 144;BA.debugLine="CanvasShape.Invalidate";
_canvasshape.Invalidate();
 }else {
 //BA.debugLineNum = 146;BA.debugLine="x1 = cx";
_x1 = _cx;
 //BA.debugLineNum = 147;BA.debugLine="y1 = 0";
_y1 = (float) (0);
 //BA.debugLineNum = 148;BA.debugLine="x2 = cx";
_x2 = _cx;
 //BA.debugLineNum = 149;BA.debugLine="y2 = PaneShape.Height";
_y2 = (float) (_paneshape.getHeight());
 //BA.debugLineNum = 150;BA.debugLine="CanvasShape.DrawLine(x1,y1,x2,y2,HMITileUtils.CO";
_canvasshape.DrawLine(_x1,_y1,_x2,_y2,_hmitileutils._color_border_default /*int*/ ,(float) (_mstrokewidth));
 //BA.debugLineNum = 151;BA.debugLine="CanvasShape.Invalidate";
_canvasshape.Invalidate();
 };
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public String  _drawshape() throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Public Sub DrawShape";
 //BA.debugLineNum = 109;BA.debugLine="CanvasShape.ClearRect(CanvasShape.TargetRect)";
_canvasshape.ClearRect(_canvasshape.getTargetRect());
 //BA.debugLineNum = 111;BA.debugLine="Select mShapeType";
switch (BA.switchObjectToInt(_mshapetype,_shape_hline,_shape_vline,_shape_cross,_shape_cornerleftup,_shape_cornerleftdown,_shape_cornerrightup,_shape_cornerrightdown)) {
case 0: {
 //BA.debugLineNum = 113;BA.debugLine="DrawLine(False)";
_drawline(__c.False);
 break; }
case 1: {
 //BA.debugLineNum = 115;BA.debugLine="DrawLine(True)";
_drawline(__c.True);
 break; }
case 2: {
 //BA.debugLineNum = 117;BA.debugLine="DrawLine(False)";
_drawline(__c.False);
 //BA.debugLineNum = 118;BA.debugLine="DrawLine(True)";
_drawline(__c.True);
 break; }
case 3: {
 //BA.debugLineNum = 120;BA.debugLine="DrawCorner(PaneShape.Width, PaneShape.Height, 1";
_drawcorner((float) (_paneshape.getWidth()),(float) (_paneshape.getHeight()),(int) (180));
 break; }
case 4: {
 //BA.debugLineNum = 122;BA.debugLine="DrawCorner(PaneShape.Width, 0, 90)";
_drawcorner((float) (_paneshape.getWidth()),(float) (0),(int) (90));
 break; }
case 5: {
 //BA.debugLineNum = 124;BA.debugLine="DrawCorner(0, 0, 0)";
_drawcorner((float) (0),(float) (0),(int) (0));
 break; }
case 6: {
 //BA.debugLineNum = 126;BA.debugLine="DrawCorner(0, PaneShape.Height, 270)";
_drawcorner((float) (0),(float) (_paneshape.getHeight()),(int) (270));
 break; }
}
;
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public boolean  _getenabled() throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 101;BA.debugLine="Return mBase.Enabled";
if (true) return _mbase.getEnabled();
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 46;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 47;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 48;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _setenabled(boolean _enabled) throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Public Sub setEnabled(enabled As Boolean)";
 //BA.debugLineNum = 97;BA.debugLine="mBase.Enabled = enabled";
_mbase.setEnabled(_enabled);
 //BA.debugLineNum = 98;BA.debugLine="HMITileUtils.SetAlpha(mBase.enabled)";
_hmitileutils._setalpha /*float*/ (_mbase.getEnabled());
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
