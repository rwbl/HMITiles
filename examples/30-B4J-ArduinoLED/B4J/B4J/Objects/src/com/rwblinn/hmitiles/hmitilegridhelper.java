package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilegridhelper extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.hmitilegridhelper", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.hmitilegridhelper.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mparent = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _gridpanel = null;
public anywheresoftware.b4a.objects.B4XCanvas _gridcanvas = null;
public boolean _showgrid = false;
public int _minorstep = 0;
public int _majorstep = 0;
public int _minorcolor = 0;
public int _majorcolor = 0;
public boolean _showcoordinates = false;
public float _coordtextsize = 0f;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 24;BA.debugLine="Private mParent As B4XView        ' the view the";
_mparent = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private gridPanel As B4XView     ' panel that hos";
_gridpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private gridCanvas As B4XCanvas  ' canvas used fo";
_gridcanvas = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 29;BA.debugLine="Public ShowGrid As Boolean = False";
_showgrid = __c.False;
 //BA.debugLineNum = 32;BA.debugLine="Public MinorStep As Int = 8dip    ' minor grid in";
_minorstep = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 33;BA.debugLine="Public MajorStep As Int = 32dip   ' major grid in";
_majorstep = __c.DipToCurrent((int) (32));
 //BA.debugLineNum = 37;BA.debugLine="Public MinorColor As Int = 0x22000000  ' very lig";
_minorcolor = ((int)0x22000000);
 //BA.debugLineNum = 38;BA.debugLine="Public MajorColor As Int = 0x55000000  ' slightly";
_majorcolor = ((int)0x55000000);
 //BA.debugLineNum = 41;BA.debugLine="Public ShowCoordinates As Boolean = False";
_showcoordinates = __c.False;
 //BA.debugLineNum = 42;BA.debugLine="Public CoordTextSize As Float = 10";
_coordtextsize = (float) (10);
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _hmitilegridpanel_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Private Sub HMITileGridPanel_MouseClicked (EventDa";
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _parent) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 50;BA.debugLine="Public Sub Initialize(parent As B4XView)";
 //BA.debugLineNum = 51;BA.debugLine="mParent = parent";
_mparent = _parent;
 //BA.debugLineNum = 54;BA.debugLine="gridPanel = xui.CreatePanel(\"HMITileGridPanel\"";
_gridpanel = _xui.CreatePanel(ba,"HMITileGridPanel");
 //BA.debugLineNum = 55;BA.debugLine="mParent.AddView(gridPanel, 0, 0, mParent.Width";
_mparent.AddView((javafx.scene.Node)(_gridpanel.getObject()),0,0,_mparent.getWidth(),_mparent.getHeight());
 //BA.debugLineNum = 58;BA.debugLine="gridPanel.SendToBack";
_gridpanel.SendToBack();
 //BA.debugLineNum = 61;BA.debugLine="gridCanvas.Initialize(gridPanel)";
_gridcanvas.Initialize(ba,_gridpanel);
 //BA.debugLineNum = 64;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public String  _redraw() throws Exception{
int _w = 0;
int _h = 0;
int _x = 0;
int _clr = 0;
int _y = 0;
int _clr2 = 0;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _font = null;
int _xi = 0;
int _yi = 0;
String _txt = "";
 //BA.debugLineNum = 71;BA.debugLine="Public Sub Redraw";
 //BA.debugLineNum = 73;BA.debugLine="gridCanvas.ClearRect(gridCanvas.TargetRect)";
_gridcanvas.ClearRect(_gridcanvas.getTargetRect());
 //BA.debugLineNum = 75;BA.debugLine="If ShowGrid = False Then";
if (_showgrid==__c.False) { 
 //BA.debugLineNum = 76;BA.debugLine="gridCanvas.Invalidate";
_gridcanvas.Invalidate();
 //BA.debugLineNum = 77;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 80;BA.debugLine="Dim w As Int = gridPanel.Width";
_w = (int) (_gridpanel.getWidth());
 //BA.debugLineNum = 81;BA.debugLine="Dim h As Int = gridPanel.Height";
_h = (int) (_gridpanel.getHeight());
 //BA.debugLineNum = 84;BA.debugLine="Dim x As Int = 0";
_x = (int) (0);
 //BA.debugLineNum = 85;BA.debugLine="Do While x <= w";
while (_x<=_w) {
 //BA.debugLineNum = 86;BA.debugLine="Dim clr As Int = IIf(x Mod MajorStep = 0,";
_clr = (int)(BA.ObjectToNumber(((_x%_majorstep==0) ? ((Object)(_majorcolor)) : ((Object)(_minorcolor)))));
 //BA.debugLineNum = 87;BA.debugLine="gridCanvas.DrawLine(x, 0, x, h, clr, 1dip)";
_gridcanvas.DrawLine((float) (_x),(float) (0),(float) (_x),(float) (_h),_clr,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 88;BA.debugLine="x = x + MinorStep";
_x = (int) (_x+_minorstep);
 }
;
 //BA.debugLineNum = 92;BA.debugLine="Dim y As Int = 0";
_y = (int) (0);
 //BA.debugLineNum = 93;BA.debugLine="Do While y <= h";
while (_y<=_h) {
 //BA.debugLineNum = 94;BA.debugLine="Dim clr2 As Int = IIf(y Mod MajorStep = 0,";
_clr2 = (int)(BA.ObjectToNumber(((_y%_majorstep==0) ? ((Object)(_majorcolor)) : ((Object)(_minorcolor)))));
 //BA.debugLineNum = 95;BA.debugLine="gridCanvas.DrawLine(0, y, w, y, clr2, 1dip";
_gridcanvas.DrawLine((float) (0),(float) (_y),(float) (_w),(float) (_y),_clr2,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 96;BA.debugLine="y = y + MinorStep";
_y = (int) (_y+_minorstep);
 }
;
 //BA.debugLineNum = 100;BA.debugLine="If ShowCoordinates Then";
if (_showcoordinates) { 
 //BA.debugLineNum = 101;BA.debugLine="Dim font As B4XFont = xui.CreateDefaultFon";
_font = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_font = _xui.CreateDefaultFont(_coordtextsize);
 //BA.debugLineNum = 102;BA.debugLine="Dim xi As Int = 0";
_xi = (int) (0);
 //BA.debugLineNum = 103;BA.debugLine="Do While xi <= w";
while (_xi<=_w) {
 //BA.debugLineNum = 104;BA.debugLine="If xi Mod MajorStep = 0 Then";
if (_xi%_majorstep==0) { 
 //BA.debugLineNum = 105;BA.debugLine="Dim yi As Int = 0";
_yi = (int) (0);
 //BA.debugLineNum = 106;BA.debugLine="Do While yi <= h";
while (_yi<=_h) {
 //BA.debugLineNum = 107;BA.debugLine="If yi Mod MajorStep = 0 Then";
if (_yi%_majorstep==0) { 
 //BA.debugLineNum = 108;BA.debugLine="Dim txt As String = $\"${xi";
_txt = (""+__c.SmartStringFormatter("",(Object)(_xi))+","+__c.SmartStringFormatter("",(Object)(_yi))+"");
 //BA.debugLineNum = 109;BA.debugLine="gridCanvas.DrawText(txt, x";
_gridcanvas.DrawText(_txt,_xi+__c.DipToCurrent((int) (2)),_yi+__c.DipToCurrent((int) (12)),_font,_majorcolor,BA.getEnumFromString(javafx.scene.text.TextAlignment.class,"LEFT"));
 };
 //BA.debugLineNum = 111;BA.debugLine="yi = yi + MajorStep";
_yi = (int) (_yi+_majorstep);
 }
;
 };
 //BA.debugLineNum = 114;BA.debugLine="xi = xi + MajorStep";
_xi = (int) (_xi+_majorstep);
 }
;
 };
 //BA.debugLineNum = 118;BA.debugLine="gridCanvas.Invalidate";
_gridcanvas.Invalidate();
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public String  _remove() throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Public Sub Remove";
 //BA.debugLineNum = 135;BA.debugLine="If gridPanel.IsInitialized Then";
if (_gridpanel.IsInitialized()) { 
 //BA.debugLineNum = 136;BA.debugLine="gridPanel.RemoveViewFromParent";
_gridpanel.RemoveViewFromParent();
 //BA.debugLineNum = 138;BA.debugLine="gridPanel = Null";
_gridpanel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Null));
 //BA.debugLineNum = 139;BA.debugLine="gridCanvas = Null";
_gridcanvas = (anywheresoftware.b4a.objects.B4XCanvas)(__c.Null);
 };
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _resize() throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Public Sub Resize";
 //BA.debugLineNum = 126;BA.debugLine="gridPanel.SetLayoutAnimated(0, 0, 0, mParent.W";
_gridpanel.SetLayoutAnimated((int) (0),0,0,_mparent.getWidth(),_mparent.getHeight());
 //BA.debugLineNum = 127;BA.debugLine="gridCanvas.Resize(mParent.Width, mParent.Heigh";
_gridcanvas.Resize(_mparent.getWidth(),_mparent.getHeight());
 //BA.debugLineNum = 128;BA.debugLine="Redraw";
_redraw();
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
