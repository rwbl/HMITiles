package b4j.example;


import anywheresoftware.b4a.BA;

public class hmitilesymbols extends Object{
public static hmitilesymbols mostCurrent = new hmitilesymbols();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilesymbols", null);
		ba.loadHtSubs(hmitilesymbols.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.hmitilesymbols", ba);
		}
	}
    public static Class<?> getObject() {
		return hmitilesymbols.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static int _dir_north = 0;
public static int _dir_east = 0;
public static int _dir_south = 0;
public static int _dir_west = 0;
public static b4j.example.dateutils _dateutils = null;
public static b4j.example.cssutils _cssutils = null;
public static b4j.example.main _main = null;
public static b4j.example.b4xpages _b4xpages = null;
public static b4j.example.b4xcollections _b4xcollections = null;
public static b4j.example.xuiviewsutils _xuiviewsutils = null;
public static b4j.example.hmitileutils _hmitileutils = null;
public static String  _arrow(anywheresoftware.b4a.objects.B4XCanvas _cvs,float _cx,float _cy,float _size,int _color,boolean _fill,float _strokewidth,int _direction) throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Public Sub Arrow(Cvs As B4XCanvas, cx As Float, cy";
 //BA.debugLineNum = 49;BA.debugLine="DrawShape(Cvs, Shape_Arrow, cx, cy, size, color,";
_drawshape(_cvs,_shape_arrow(),_cx,_cy,_size,_color,_fill,_strokewidth,_direction);
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _diamond(anywheresoftware.b4a.objects.B4XCanvas _cvs,float _cx,float _cy,float _size,int _color,boolean _fill,float _strokewidth) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Public Sub Diamond(Cvs As B4XCanvas, cx As Float,";
 //BA.debugLineNum = 43;BA.debugLine="DrawShape(Cvs, Shape_Diamond, cx, cy, size, color";
_drawshape(_cvs,_shape_diamond(),_cx,_cy,_size,_color,_fill,_strokewidth,_dir_north);
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static float  _dirtoangle(int _dir) throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Private Sub DirToAngle(dir As Int) As Float";
 //BA.debugLineNum = 106;BA.debugLine="Select dir";
switch (BA.switchObjectToInt(_dir,_dir_north,_dir_east,_dir_south,_dir_west)) {
case 0: {
 //BA.debugLineNum = 107;BA.debugLine="Case DIR_NORTH : Return 0";
if (true) return (float) (0);
 break; }
case 1: {
 //BA.debugLineNum = 108;BA.debugLine="Case DIR_EAST  : Return 90";
if (true) return (float) (90);
 break; }
case 2: {
 //BA.debugLineNum = 109;BA.debugLine="Case DIR_SOUTH : Return 180";
if (true) return (float) (180);
 break; }
case 3: {
 //BA.debugLineNum = 110;BA.debugLine="Case DIR_WEST  : Return 270";
if (true) return (float) (270);
 break; }
}
;
 //BA.debugLineNum = 112;BA.debugLine="Return 0";
if (true) return (float) (0);
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return 0f;
}
public static String  _drawpolygon(anywheresoftware.b4a.objects.B4XCanvas _cvs,float[] _pts,int _color,boolean _fill,float _strokewidth) throws Exception{
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
int _i = 0;
 //BA.debugLineNum = 64;BA.debugLine="Private Sub DrawPolygon(Cvs As B4XCanvas, pts() As";
 //BA.debugLineNum = 65;BA.debugLine="If pts.Length < 6 Then Return";
if (_pts.length<6) { 
if (true) return "";};
 //BA.debugLineNum = 67;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 68;BA.debugLine="p.Initialize(pts(0), pts(1))";
_p.Initialize(_pts[(int) (0)],_pts[(int) (1)]);
 //BA.debugLineNum = 70;BA.debugLine="For i = 2 To pts.Length - 2 Step 2";
{
final int step4 = 2;
final int limit4 = (int) (_pts.length-2);
_i = (int) (2) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 71;BA.debugLine="p.LineTo(pts(i), pts(i + 1))";
_p.LineTo(_pts[_i],_pts[(int) (_i+1)]);
 }
};
 //BA.debugLineNum = 74;BA.debugLine="p.LineTo(pts(0), pts(1))";
_p.LineTo(_pts[(int) (0)],_pts[(int) (1)]);
 //BA.debugLineNum = 76;BA.debugLine="Cvs.DrawPath(p, color, fill, strokewidth)";
_cvs.DrawPath(_p,_color,_fill,_strokewidth);
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _drawshape(anywheresoftware.b4a.objects.B4XCanvas _cvs,float[] _shape,float _cx,float _cy,float _size,int _color,boolean _fill,float _strokewidth,int _direction) throws Exception{
float _angle = 0f;
float[] _pts = null;
 //BA.debugLineNum = 56;BA.debugLine="Private Sub DrawShape(Cvs As B4XCanvas, shape() As";
 //BA.debugLineNum = 59;BA.debugLine="Dim angle As Float = DirToAngle(direction)";
_angle = _dirtoangle(_direction);
 //BA.debugLineNum = 60;BA.debugLine="Dim pts() As Float = TransformPoints(shape, cx, c";
_pts = _transformpoints(_shape,_cx,_cy,_size,_size,_angle);
 //BA.debugLineNum = 61;BA.debugLine="DrawPolygon(Cvs, pts, color, fill, strokewidth)";
_drawpolygon(_cvs,_pts,_color,_fill,_strokewidth);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 24;BA.debugLine="Public Const DIR_NORTH As Int = 0";
_dir_north = (int) (0);
 //BA.debugLineNum = 25;BA.debugLine="Public Const DIR_EAST  As Int = 1";
_dir_east = (int) (1);
 //BA.debugLineNum = 26;BA.debugLine="Public Const DIR_SOUTH As Int = 2";
_dir_south = (int) (2);
 //BA.debugLineNum = 27;BA.debugLine="Public Const DIR_WEST  As Int = 3";
_dir_west = (int) (3);
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static float[]  _shape_arrow() throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Private Sub Shape_Arrow() As Float()";
 //BA.debugLineNum = 135;BA.debugLine="Return Array As Float( _ 		-0.25,  0.5, _ 		 0.25";
if (true) return new float[]{(float) (-0.25),(float) (0.5),(float) (0.25),(float) (0.5),(float) (0.25),(float) (0.0),(float) (0.5),(float) (0.0),(float) (0.0),(float) (-0.5),(float) (-0.5),(float) (0.0),(float) (-0.25),(float) (0.0)};
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return null;
}
public static float[]  _shape_diamond() throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Private Sub Shape_Diamond() As Float()";
 //BA.debugLineNum = 127;BA.debugLine="Return Array As Float( _ 		 0.0, -0.5, _ 		 0.5,";
if (true) return new float[]{(float) (0.0),(float) (-0.5),(float) (0.5),(float) (0.0),(float) (0.0),(float) (0.5),(float) (-0.5),(float) (0.0)};
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return null;
}
public static float[]  _shape_triangle() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Private Sub Shape_Triangle() As Float()";
 //BA.debugLineNum = 120;BA.debugLine="Return Array As Float( _ 		-0.5,  0.5, _ 		 0.5,";
if (true) return new float[]{(float) (-0.5),(float) (0.5),(float) (0.5),(float) (0.5),(float) (0.0),(float) (-0.5)};
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return null;
}
public static float[]  _transformpoints(float[] _src,float _cx,float _cy,float _scalex,float _scaley,float _angledeg) throws Exception{
float[] _dst = null;
float _rad = 0f;
float _cosa = 0f;
float _sina = 0f;
int _i = 0;
float _x = 0f;
float _y = 0f;
float _xr = 0f;
float _yr = 0f;
 //BA.debugLineNum = 79;BA.debugLine="Private Sub TransformPoints(src() As Float, cx As";
 //BA.debugLineNum = 82;BA.debugLine="Dim dst(src.Length) As Float";
_dst = new float[_src.length];
;
 //BA.debugLineNum = 84;BA.debugLine="Dim rad As Float = angleDeg * cPI / 180";
_rad = (float) (_angledeg*anywheresoftware.b4a.keywords.Common.cPI/(double)180);
 //BA.debugLineNum = 85;BA.debugLine="Dim cosA As Float = Cos(rad)";
_cosa = (float) (anywheresoftware.b4a.keywords.Common.Cos(_rad));
 //BA.debugLineNum = 86;BA.debugLine="Dim sinA As Float = Sin(rad)";
_sina = (float) (anywheresoftware.b4a.keywords.Common.Sin(_rad));
 //BA.debugLineNum = 88;BA.debugLine="For i = 0 To src.Length - 2 Step 2";
{
final int step5 = 2;
final int limit5 = (int) (_src.length-2);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 89;BA.debugLine="Dim x As Float = src(i)";
_x = _src[_i];
 //BA.debugLineNum = 90;BA.debugLine="Dim y As Float = src(i + 1)";
_y = _src[(int) (_i+1)];
 //BA.debugLineNum = 92;BA.debugLine="x = x * scaleX";
_x = (float) (_x*_scalex);
 //BA.debugLineNum = 93;BA.debugLine="y = y * scaleY";
_y = (float) (_y*_scaley);
 //BA.debugLineNum = 95;BA.debugLine="Dim xr As Float = x * cosA - y * sinA";
_xr = (float) (_x*_cosa-_y*_sina);
 //BA.debugLineNum = 96;BA.debugLine="Dim yr As Float = x * sinA + y * cosA";
_yr = (float) (_x*_sina+_y*_cosa);
 //BA.debugLineNum = 98;BA.debugLine="dst(i)     = cx + xr";
_dst[_i] = (float) (_cx+_xr);
 //BA.debugLineNum = 99;BA.debugLine="dst(i + 1) = cy + yr";
_dst[(int) (_i+1)] = (float) (_cy+_yr);
 }
};
 //BA.debugLineNum = 102;BA.debugLine="Return dst";
if (true) return _dst;
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return null;
}
public static String  _triangle(anywheresoftware.b4a.objects.B4XCanvas _cvs,float _cx,float _cy,float _size,int _color,boolean _fill,float _strokewidth,int _direction) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Public Sub Triangle(Cvs As B4XCanvas, cx As Float,";
 //BA.debugLineNum = 37;BA.debugLine="DrawShape(Cvs, Shape_Triangle, cx, cy, size, colo";
_drawshape(_cvs,_shape_triangle(),_cx,_cy,_size,_color,_fill,_strokewidth,_direction);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
}
