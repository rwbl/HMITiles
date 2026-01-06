package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b4xprogressdialog extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.b4xprogressdialog", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.b4xprogressdialog.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public Object _mtext = null;
public com.rwblinn.hmitiles.b4xloadingindicator _loadingindicator = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _label1 = null;
public com.rwblinn.hmitiles.b4xdialog _mdialog = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 3;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Private mText As Object";
_mtext = new Object();
 //BA.debugLineNum = 5;BA.debugLine="Public LoadingIndicator As B4XLoadingIndicator";
_loadingindicator = new com.rwblinn.hmitiles.b4xloadingindicator();
 //BA.debugLineNum = 6;BA.debugLine="Public Label1 As B4XView";
_label1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Public mDialog As B4XDialog";
_mdialog = new com.rwblinn.hmitiles.b4xdialog();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(int _result) throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Private Sub DialogClosed(Result As Int) 'ignore";
 //BA.debugLineNum = 56;BA.debugLine="LoadingIndicator.Hide";
_loadingindicator._hide /*String*/ ();
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(com.rwblinn.hmitiles.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Public Sub GetPanel (Dialog As B4XDialog) As B4XVi";
 //BA.debugLineNum = 34;BA.debugLine="Return mBase";
if (true) return _mbase;
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return null;
}
public Object  _gettext() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Public Sub getText As Object";
 //BA.debugLineNum = 29;BA.debugLine="Return mText";
if (true) return _mtext;
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return null;
}
public String  _hide() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Public Sub Hide";
 //BA.debugLineNum = 48;BA.debugLine="mDialog.Close(0)";
_mdialog._close /*boolean*/ ((int) (0));
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _parent) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 11;BA.debugLine="Public Sub Initialize (Parent As B4XView)";
 //BA.debugLineNum = 12;BA.debugLine="mBase = xui.CreatePanel(\"mBase\")";
_mbase = _xui.CreatePanel(ba,"mBase");
 //BA.debugLineNum = 13;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, 300dip, 60dip)";
_mbase.SetLayoutAnimated((int) (0),0,0,__c.DipToCurrent((int) (300)),__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 14;BA.debugLine="mBase.LoadLayout(\"XV_ProgressTemplate\")";
_mbase.LoadLayout("XV_ProgressTemplate",ba);
 //BA.debugLineNum = 15;BA.debugLine="mBase.SetColorAndBorder(xui.Color_White, 0, 0, 5d";
_mbase.SetColorAndBorder(_xui.Color_White,0,(int) (0),__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 16;BA.debugLine="LoadingIndicator.Hide";
_loadingindicator._hide /*String*/ ();
 //BA.debugLineNum = 17;BA.debugLine="mDialog.Initialize(Parent)";
_mdialog._initialize /*String*/ (ba,_parent);
 //BA.debugLineNum = 18;BA.debugLine="mDialog.ButtonsHeight = -2dip";
_mdialog._buttonsheight /*int*/  = (int) (-__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 19;BA.debugLine="mDialog.BorderWidth = 0";
_mdialog._borderwidth /*int*/  = (int) (0);
 //BA.debugLineNum = 20;BA.debugLine="mDialog.BorderCornersRadius = 5dip";
_mdialog._bordercornersradius /*int*/  = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _settext(Object _t) throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Public Sub setText(t As Object)";
 //BA.debugLineNum = 25;BA.debugLine="XUIViewsUtils.SetTextOrCSBuilderToLabel(Label1, t";
_xuiviewsutils._settextorcsbuildertolabel /*String*/ (_label1,_t);
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _show(com.rwblinn.hmitiles.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Private Sub Show (Dialog As B4XDialog) 'ignore";
 //BA.debugLineNum = 52;BA.debugLine="LoadingIndicator.Show";
_loadingindicator._show /*String*/ ();
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _showdialog(Object _text) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Public Sub ShowDialog (Text As Object)";
 //BA.debugLineNum = 40;BA.debugLine="setText(Text)";
_settext(_text);
 //BA.debugLineNum = 41;BA.debugLine="If mDialog.Visible = False Then";
if (_mdialog._getvisible /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 42;BA.debugLine="mDialog.ShowTemplate(Me, \"\", \"\", \"\")";
_mdialog._showtemplate /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (this,(Object)(""),(Object)(""),(Object)(""));
 };
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "DIALOGCLOSED"))
	return _dialogclosed(((Number)args[0]).intValue());
if (BA.fastSubCompare(sub, "GETPANEL"))
	return _getpanel((com.rwblinn.hmitiles.b4xdialog) args[0]);
if (BA.fastSubCompare(sub, "SHOW"))
	return _show((com.rwblinn.hmitiles.b4xdialog) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
