package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labellegend = null;
public b4a.example.hmitilesppv _tilesppv1 = null;
public b4a.example.hmitilesppv _tilesppv2 = null;
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
public void  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
ResumableSub_B4XPage_Created rsub = new ResumableSub_B4XPage_Created(this,_root1);
rsub.resume(ba, null);
}
public static class ResumableSub_B4XPage_Created extends BA.ResumableSub {
public ResumableSub_B4XPage_Created(b4a.example.b4xmainpage parent,anywheresoftware.b4a.objects.B4XViewWrapper _root1) {
this.parent = parent;
this._root1 = _root1;
}
b4a.example.b4xmainpage parent;
anywheresoftware.b4a.objects.B4XViewWrapper _root1;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 24;BA.debugLine="Root = Root1";
parent._root = _root1;
 //BA.debugLineNum = 25;BA.debugLine="Root.LoadLayout(\"mainpage\")";
parent._root.LoadLayout("mainpage",ba);
 //BA.debugLineNum = 26;BA.debugLine="B4XPages.SetTitle(Me, \"HMITileSPPV\")";
parent._b4xpages._settitle /*String*/ (ba,parent,(Object)("HMITileSPPV"));
 //BA.debugLineNum = 28;BA.debugLine="LabelLegend.Text = $\"HMITiles Get Started${CRLF}R";
parent._labellegend.setText(BA.ObjectToCharSequence(("HMITiles Get Started"+parent.__c.SmartStringFormatter("",(Object)(parent.__c.CRLF))+"Recommended tile size: 120x120px. Tile color Yellow=Warning, Red=Alarm.")));
 //BA.debugLineNum = 34;BA.debugLine="Sleep(1)";
parent.__c.Sleep(ba,this,(int) (1));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 36;BA.debugLine="TileSPPVsSetProperties";
parent._tilesppvssetproperties();
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 13;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private LabelLegend As B4XView";
_labellegend = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private TileSPPV1 As HMITileSPPV";
_tilesppv1 = new b4a.example.hmitilesppv();
 //BA.debugLineNum = 16;BA.debugLine="Private TileSPPV2 As HMITileSPPV";
_tilesppv2 = new b4a.example.hmitilesppv();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 19;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 20;BA.debugLine="B4XPages.GetManager.LogEvents = True";
_b4xpages._getmanager /*b4a.example.b4xpagesmanager*/ (ba)._logevents /*boolean*/  = __c.True;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _tilesppv1_setpointchanged(float _value) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Private Sub TileSPPV1_SetPointChanged (Value As Fl";
 //BA.debugLineNum = 67;BA.debugLine="Log($\"[TileSPPV1_SetPointChanged] value=${Value}";
__c.LogImpl("2917505",("[TileSPPV1_SetPointChanged] value="+__c.SmartStringFormatter("",(Object)(_value))+" deviation="+__c.SmartStringFormatter("",(Object)(_tilesppv1._deviation /*float*/ ()))+" deviationlimit="+__c.SmartStringFormatter("",(Object)(_tilesppv1._getdeviationlimit /*double*/ ()))+""),0);
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _tilesppv1_valuechanged(float _value) throws Exception{
 //BA.debugLineNum = 62;BA.debugLine="Private Sub TileSPPV1_ValueChanged (Value As Float";
 //BA.debugLineNum = 63;BA.debugLine="Log($\"[TileSPPV1_ValueChanged] value=${Value} dev";
__c.LogImpl("2851969",("[TileSPPV1_ValueChanged] value="+__c.SmartStringFormatter("",(Object)(_value))+" deviation="+__c.SmartStringFormatter("",(Object)(_tilesppv1._deviation /*float*/ ()))+" deviationlimit="+__c.SmartStringFormatter("",(Object)(_tilesppv1._getdeviationlimit /*double*/ ()))+""),0);
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public String  _tilesppv2_setpointchanged(float _value) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Private Sub TileSPPV2_SetPointChanged (Value As Fl";
 //BA.debugLineNum = 75;BA.debugLine="Log($\"[TileSPPV2_SetPointChanged] value=${Value}";
__c.LogImpl("21048577",("[TileSPPV2_SetPointChanged] value="+__c.SmartStringFormatter("",(Object)(_value))+" deviation="+__c.SmartStringFormatter("",(Object)(_tilesppv2._deviation /*float*/ ()))+" deviationlimit="+__c.SmartStringFormatter("",(Object)(_tilesppv2._getdeviationlimit /*double*/ ()))+""),0);
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public String  _tilesppv2_valuechanged(float _value) throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Private Sub TileSPPV2_ValueChanged (Value As Float";
 //BA.debugLineNum = 71;BA.debugLine="Log($\"[TileSPPV2_ValueChanged] value=${Value} dev";
__c.LogImpl("2983041",("[TileSPPV2_ValueChanged] value="+__c.SmartStringFormatter("",(Object)(_value))+" deviation="+__c.SmartStringFormatter("",(Object)(_tilesppv2._deviation /*float*/ ()))+" deviationlimit="+__c.SmartStringFormatter("",(Object)(_tilesppv2._getdeviationlimit /*double*/ ()))+""),0);
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _tilesppvssetproperties() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Private Sub TileSPPVsSetProperties";
 //BA.debugLineNum = 45;BA.debugLine="TileSPPV1.PV = 70";
_tilesppv1._setpv /*float*/ ((float) (70));
 //BA.debugLineNum = 50;BA.debugLine="TileSPPV2.DeviationLimit = 2";
_tilesppv2._setdeviationlimit /*double*/ (2);
 //BA.debugLineNum = 51;BA.debugLine="TileSPPV2.PV = 6";
_tilesppv2._setpv /*float*/ ((float) (6));
 //BA.debugLineNum = 52;BA.debugLine="TileSPPV2.SP = 3";
_tilesppv2._setsp /*float*/ ((float) (3));
 //BA.debugLineNum = 53;BA.debugLine="TileSPPV2.Max = 10";
_tilesppv2._setmax /*float*/ ((float) (10));
 //BA.debugLineNum = 54;BA.debugLine="TileSPPV2.Min = 0";
_tilesppv2._setmin /*float*/ ((float) (0));
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
