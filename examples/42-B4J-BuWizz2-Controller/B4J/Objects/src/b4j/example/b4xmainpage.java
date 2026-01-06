package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.b4xmainpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _version = "";
public String _about = "";
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public b4j.example.hmitilebutton _tilebuttonconnect = null;
public b4j.example.hmitileeventviewer _tileeventviewer = null;
public b4j.example.hmitileseekbar _tileseekbarspeed = null;
public b4j.example.hmitilereadout _tilereadoutspeed = null;
public b4j.example.hmitileselect _tileselectdirection = null;
public anywheresoftware.b4j.objects.LabelWrapper _labelabout = null;
public b4j.example.blemanager _blemgr = null;
public boolean _isconnected = false;
public b4j.example.buwizz2controller _buwizz = null;
public byte _port = (byte)0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _b4xpage_background() throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Private Sub B4XPage_Background";
 //BA.debugLineNum = 153;BA.debugLine="BLEMgr.PyBridgeKillProcess";
_blemgr._pybridgekillprocess /*String*/ ();
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public void  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
ResumableSub_B4XPage_Created rsub = new ResumableSub_B4XPage_Created(this,_root1);
rsub.resume(ba, null);
}
public static class ResumableSub_B4XPage_Created extends BA.ResumableSub {
public ResumableSub_B4XPage_Created(b4j.example.b4xmainpage parent,anywheresoftware.b4a.objects.B4XViewWrapper _root1) {
this.parent = parent;
this._root1 = _root1;
}
b4j.example.b4xmainpage parent;
anywheresoftware.b4a.objects.B4XViewWrapper _root1;
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 90;BA.debugLine="Root = Root1";
parent._root = _root1;
 //BA.debugLineNum = 92;BA.debugLine="Root.LoadLayout(\"MainPage\")";
parent._root.LoadLayout("MainPage",ba);
 //BA.debugLineNum = 96;BA.debugLine="Root.Color = HMITileUtils.COLOR_BACKGROUND_SCREEN";
parent._root.setColor(parent._hmitileutils._color_background_screen /*int*/ );
 //BA.debugLineNum = 101;BA.debugLine="B4XPages.SetTitle(Me, $\"${VERSION} (B4J)\"$)";
parent._b4xpages._settitle /*String*/ (parent,(Object)((""+parent.__c.SmartStringFormatter("",(Object)(parent._version))+" (B4J)")));
 //BA.debugLineNum = 102;BA.debugLine="B4XPages.GetNativeParent(Me).Resizable = False";
parent._b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (parent).setResizable(parent.__c.False);
 //BA.debugLineNum = 104;BA.debugLine="LabelAbout.Text = ABOUT";
parent._labelabout.setText(parent._about);
 //BA.debugLineNum = 107;BA.debugLine="Sleep(1)";
parent.__c.Sleep(ba,this,(int) (1));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
 //BA.debugLineNum = 109;BA.debugLine="SetTilesInitialState";
parent._settilesinitialstate();
 //BA.debugLineNum = 112;BA.debugLine="TileEventViewer.Insert($\"[B4XPage_Created] ${VERS";
parent._tileeventviewer._insert /*String*/ (("[B4XPage_Created] "+parent.__c.SmartStringFormatter("",(Object)(parent._version))+""),parent._hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 113;BA.debugLine="TileEventViewer.Insert($\"[B4XPage_Created] BLE di";
parent._tileeventviewer._insert /*String*/ (("[B4XPage_Created] BLE disconnected"),parent._hmitileutils._event_level_warning /*int*/ );
 //BA.debugLineNum = 116;BA.debugLine="BuWizz.Initialize(B4XPages.GetPage(\"Mainpage\"))";
parent._buwizz._initialize /*String*/ (ba,(b4j.example.b4xmainpage)(parent._b4xpages._getpage /*Object*/ ("Mainpage")));
 //BA.debugLineNum = 133;BA.debugLine="BLEMgr.Initialize(B4XPages.GetPage(\"MainPage\"), _";
parent._blemgr._initialize /*String*/ (ba,(b4j.example.b4xmainpage)(parent._b4xpages._getpage /*Object*/ ("MainPage")),parent._buwizz._ble_mac /*String*/ ,parent._buwizz._service_uuid /*String*/ ,parent._buwizz._char_uuid_rx /*String*/ ,parent._buwizz._char_uuid_tx /*String*/ );
 //BA.debugLineNum = 138;BA.debugLine="Wait For (BLEMgr.Start) complete (result As Boole";
parent.__c.WaitFor("complete", ba, this, parent._blemgr._start /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 8;
return;
case 8:
//C
this.state = 1;
_result = (boolean) result[0];
;
 //BA.debugLineNum = 139;BA.debugLine="If result Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_result) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 140;BA.debugLine="TileEventViewer.Insert($\"[B4XPage_Created] PyBri";
parent._tileeventviewer._insert /*String*/ (("[B4XPage_Created] PyBridge started, BLE initialized"),parent._hmitileutils._event_level_info /*int*/ );
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 142;BA.debugLine="TileEventViewer.Insert($\"[B4XPage_Created] Faile";
parent._tileeventviewer._insert /*String*/ (("[B4XPage_Created] Failed to start the PyBridge initialize BLE"),parent._hmitileutils._event_level_alarm /*int*/ );
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(boolean _result) throws Exception{
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 47;BA.debugLine="Private Const VERSION As String = \"BuWizz2Control";
_version = "BuWizz2Controller v20260105";
 //BA.debugLineNum = 48;BA.debugLine="Private ABOUT As String 	= $\"${VERSION} (c) 2025-";
_about = (""+__c.SmartStringFormatter("",(Object)(_version))+" (c) 2025-2026 Robert W.B. Linn - MIT");
 //BA.debugLineNum = 51;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 55;BA.debugLine="Private TileButtonConnect As HMITileButton";
_tilebuttonconnect = new b4j.example.hmitilebutton();
 //BA.debugLineNum = 56;BA.debugLine="Private TileEventViewer As HMITileEventViewer";
_tileeventviewer = new b4j.example.hmitileeventviewer();
 //BA.debugLineNum = 57;BA.debugLine="Private TileSeekBarSpeed As HMITileSeekBar";
_tileseekbarspeed = new b4j.example.hmitileseekbar();
 //BA.debugLineNum = 58;BA.debugLine="Private TileReadoutSpeed As HMITileReadout";
_tilereadoutspeed = new b4j.example.hmitilereadout();
 //BA.debugLineNum = 59;BA.debugLine="Private TileSelectDirection As HMITileSelect";
_tileselectdirection = new b4j.example.hmitileselect();
 //BA.debugLineNum = 60;BA.debugLine="Private LabelAbout As Label";
_labelabout = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Public BLEMgr As BLEManager";
_blemgr = new b4j.example.blemanager();
 //BA.debugLineNum = 76;BA.debugLine="Private IsConnected As Boolean = False";
_isconnected = __c.False;
 //BA.debugLineNum = 79;BA.debugLine="Private BuWizz As BuWizz2Controller";
_buwizz = new b4j.example.buwizz2controller();
 //BA.debugLineNum = 80;BA.debugLine="Private Port As Byte = 0";
_port = (byte) (0);
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public String  _handlebleconnect(boolean _state) throws Exception{
 //BA.debugLineNum = 314;BA.debugLine="Public Sub HandleBLEConnect(state As Boolean)";
 //BA.debugLineNum = 315;BA.debugLine="If state Then";
if (_state) { 
 //BA.debugLineNum = 316;BA.debugLine="TileEventViewer.Insert($\"[HandleBLEConnect] ${\"C";
_tileeventviewer._insert /*String*/ (("[HandleBLEConnect] "+__c.SmartStringFormatter("",(Object)("Connected"))+" to "+__c.SmartStringFormatter("",(Object)(_buwizz._ble_device_name /*String*/ ))+""),_hmitileutils._event_level_info /*int*/ );
 }else {
 //BA.debugLineNum = 318;BA.debugLine="TileEventViewer.Insert($\"[HandleBLEConnect] ${\"D";
_tileeventviewer._insert /*String*/ (("[HandleBLEConnect] "+__c.SmartStringFormatter("",(Object)("Disconnected"))+" from "+__c.SmartStringFormatter("",(Object)(_buwizz._ble_device_name /*String*/ ))+""),_hmitileutils._event_level_alarm /*int*/ );
 };
 //BA.debugLineNum = 320;BA.debugLine="IsConnected = state";
_isconnected = _state;
 //BA.debugLineNum = 321;BA.debugLine="TileButtonConnectUpdate(IsConnected)";
_tilebuttonconnectupdate(_isconnected);
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public String  _handleblenotification(byte[] _payload) throws Exception{
 //BA.debugLineNum = 329;BA.debugLine="Public Sub HandleBLENotification(payload() As Byte";
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 84;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 85;BA.debugLine="B4XPages.GetManager.LogEvents = True";
_b4xpages._getmanager /*b4j.example.b4xpagesmanager*/ ()._logevents /*boolean*/  = __c.True;
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _processble(byte[] _payload) throws Exception{
 //BA.debugLineNum = 348;BA.debugLine="Private Sub ProcessBLE(payload() As Byte)	'ignore";
 //BA.debugLineNum = 349;BA.debugLine="TileEventViewer.Insert($\"[ProcessBLE] ${Convert.H";
_tileeventviewer._insert /*String*/ (("[ProcessBLE] "+__c.SmartStringFormatter("",(Object)(_convert._hexfrombytes /*String*/ (_payload)))+""),_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public String  _pybridgedisconnected() throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Public Sub PyBridgeDisconnected";
 //BA.debugLineNum = 160;BA.debugLine="IsConnected = False";
_isconnected = __c.False;
 //BA.debugLineNum = 161;BA.debugLine="TileEventViewer.Insert($\"[PyBridgeDisconnected] $";
_tileeventviewer._insert /*String*/ (("[PyBridgeDisconnected] "+__c.SmartStringFormatter("",(Object)("Disconnected"))+""),_hmitileutils._event_level_warning /*int*/ );
 //BA.debugLineNum = 162;BA.debugLine="TileButtonConnectUpdate(IsConnected)";
_tilebuttonconnectupdate(_isconnected);
 //BA.debugLineNum = 163;BA.debugLine="SetTilesInitialState";
_settilesinitialstate();
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public String  _setspeed() throws Exception{
float _speed = 0f;
String _msg = "";
 //BA.debugLineNum = 449;BA.debugLine="Private Sub SetSpeed";
 //BA.debugLineNum = 450;BA.debugLine="Dim speed As Float = 0";
_speed = (float) (0);
 //BA.debugLineNum = 453;BA.debugLine="Select TileSelectDirection.SelectedIndex";
switch (BA.switchObjectToInt(_tileselectdirection._getselectedindex /*int*/ (),_buwizz._direction_stp /*int*/ ,_buwizz._direction_fwd /*int*/ ,_buwizz._direction_bck /*int*/ )) {
case 0: {
 //BA.debugLineNum = 455;BA.debugLine="speed = 0";
_speed = (float) (0);
 //BA.debugLineNum = 456;BA.debugLine="TileSeekBarSpeed.Value = 0";
_tileseekbarspeed._setvalue /*int*/ ((int) (0));
 //BA.debugLineNum = 457;BA.debugLine="TileReadoutSpeed.Value = NumberFormat(speed, 0,";
_tilereadoutspeed._setvalue /*String*/ (__c.NumberFormat(_speed,(int) (0),(int) (0)));
 break; }
case 1: {
 //BA.debugLineNum = 459;BA.debugLine="If TileSeekBarSpeed.Value > 0 Then";
if (_tileseekbarspeed._getvalue /*int*/ ()>0) { 
 //BA.debugLineNum = 460;BA.debugLine="speed = Convert.MapRange(TileSeekBarSpeed.Valu";
_speed = _convert._maprange /*float*/ ((float) (_tileseekbarspeed._getvalue /*int*/ ()+_buwizz._speed_offset /*int*/ ),(float) (0),(float) (100+_buwizz._speed_offset /*int*/ ),(float) (_buwizz._speed_min /*int*/ ),(float) (_buwizz._speed_max /*int*/ ));
 }else {
 //BA.debugLineNum = 462;BA.debugLine="speed = 0";
_speed = (float) (0);
 };
 //BA.debugLineNum = 464;BA.debugLine="TileReadoutSpeed.Value = NumberFormat(TileSeekB";
_tilereadoutspeed._setvalue /*String*/ (__c.NumberFormat(_tileseekbarspeed._getvalue /*int*/ (),(int) (0),(int) (0)));
 break; }
case 2: {
 //BA.debugLineNum = 466;BA.debugLine="If TileSeekBarSpeed.Value > 0 Then";
if (_tileseekbarspeed._getvalue /*int*/ ()>0) { 
 //BA.debugLineNum = 467;BA.debugLine="speed = Convert.MapRange(TileSeekBarSpeed.Valu";
_speed = _convert._maprange /*float*/ ((float) (_tileseekbarspeed._getvalue /*int*/ ()+_buwizz._speed_offset /*int*/ ),(float) (0),(float) (100+_buwizz._speed_offset /*int*/ ),(float) (_buwizz._speed_min /*int*/ ),(float) (_buwizz._speed_max /*int*/ ));
 //BA.debugLineNum = 468;BA.debugLine="speed = speed * -1";
_speed = (float) (_speed*-1);
 }else {
 //BA.debugLineNum = 470;BA.debugLine="speed = 0";
_speed = (float) (0);
 };
 //BA.debugLineNum = 472;BA.debugLine="TileReadoutSpeed.Value = NumberFormat(TileSeekB";
_tilereadoutspeed._setvalue /*String*/ (__c.NumberFormat(_tileseekbarspeed._getvalue /*int*/ (),(int) (0),(int) (0)));
 break; }
}
;
 //BA.debugLineNum = 476;BA.debugLine="BuWizz.SetPowerLevel(Port, speed)";
_buwizz._setpowerlevel /*String*/ (_port,(int) (_speed));
 //BA.debugLineNum = 479;BA.debugLine="If TileReadoutSpeed.Value > 90 Then";
if ((double)(Double.parseDouble(_tilereadoutspeed._getvalue /*String*/ ()))>90) { 
 }else if((double)(Double.parseDouble(_tilereadoutspeed._getvalue /*String*/ ()))>70) { 
 }else {
 };
 //BA.debugLineNum = 488;BA.debugLine="Dim msg As String = $\"[SetSpeed] sliderspeed=${Nu";
_msg = ("[SetSpeed] sliderspeed="+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(_tileseekbarspeed._getvalue /*int*/ (),(int) (0),(int) (0))))+",speed="+__c.SmartStringFormatter("",(Object)(__c.NumberFormat(__c.Abs(_speed),(int) (0),(int) (0))))+",dir="+__c.SmartStringFormatter("",(Object)(_tileselectdirection._getselected /*String*/ ()))+"");
 //BA.debugLineNum = 489;BA.debugLine="TileEventViewer.Insert(msg, HMITileUtils.EVENT_LE";
_tileeventviewer._insert /*String*/ (_msg,_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 490;BA.debugLine="Log(msg)";
__c.LogImpl("21441833",_msg,0);
 //BA.debugLineNum = 491;BA.debugLine="End Sub";
return "";
}
public String  _settilesinitialstate() throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Private Sub SetTilesInitialState";
 //BA.debugLineNum = 361;BA.debugLine="TileButtonConnect.SetStateFontFontAwesome";
_tilebuttonconnect._setstatefontfontawesome /*String*/ ();
 //BA.debugLineNum = 362;BA.debugLine="TileButtonConnectUpdate(IsConnected)";
_tilebuttonconnectupdate(_isconnected);
 //BA.debugLineNum = 364;BA.debugLine="TileSelectDirection.AddAll(Array As String(\"STP\",";
_tileselectdirection._addall /*String*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"STP","FWD","BCK"}));
 //BA.debugLineNum = 365;BA.debugLine="TileSelectDirection.SelectedIndex = 0";
_tileselectdirection._setselectedindex /*int*/ ((int) (0));
 //BA.debugLineNum = 367;BA.debugLine="TileSeekBarSpeed.Value = 0";
_tileseekbarspeed._setvalue /*int*/ ((int) (0));
 //BA.debugLineNum = 368;BA.debugLine="TileReadoutSpeed.Value = 0";
_tilereadoutspeed._setvalue /*String*/ (BA.NumberToString(0));
 //BA.debugLineNum = 369;BA.debugLine="End Sub";
return "";
}
public void  _tilebuttonconnect_click() throws Exception{
ResumableSub_TileButtonConnect_Click rsub = new ResumableSub_TileButtonConnect_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_TileButtonConnect_Click extends BA.ResumableSub {
public ResumableSub_TileButtonConnect_Click(b4j.example.b4xmainpage parent) {
this.parent = parent;
}
b4j.example.b4xmainpage parent;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 376;BA.debugLine="If Not(IsConnected) Then";
if (true) break;

case 1:
//if
this.state = 8;
if (parent.__c.Not(parent._isconnected)) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 377;BA.debugLine="TileButtonConnect.StateText = Chr(0xF252)";
parent._tilebuttonconnect._setstatetext /*String*/ (BA.ObjectToString(parent.__c.Chr(((int)0xf252))));
 //BA.debugLineNum = 378;BA.debugLine="TileEventViewer.Insert($\"[TileButtonConnect_Clic";
parent._tileeventviewer._insert /*String*/ (("[TileButtonConnect_Click] Connecting to "+parent.__c.SmartStringFormatter("",(Object)(parent._buwizz._ble_device_name /*String*/ ))+""),parent._hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 387;BA.debugLine="Wait For (BLEMgr.Scan) Complete (Success As Bool";
parent.__c.WaitFor("complete", ba, this, parent._blemgr._scan /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 16;
return;
case 16:
//C
this.state = 4;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 388;BA.debugLine="If Not(Success) Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent.__c.Not(_success)) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 389;BA.debugLine="TileEventViewer.Insert(BLEMgr.LastMsg, HMITileU";
parent._tileeventviewer._insert /*String*/ (parent._blemgr._lastmsg /*String*/ ,parent._hmitileutils._event_level_alarm /*int*/ );
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 392;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 396;BA.debugLine="If IsConnected Then";

case 8:
//if
this.state = 15;
if (parent._isconnected) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 397;BA.debugLine="TileButtonConnect.StateText = Chr(0xF252)";
parent._tilebuttonconnect._setstatetext /*String*/ (BA.ObjectToString(parent.__c.Chr(((int)0xf252))));
 //BA.debugLineNum = 398;BA.debugLine="TileEventViewer.Insert($\"[TileButtonConnect_Clic";
parent._tileeventviewer._insert /*String*/ (("[TileButtonConnect_Click] Disconnecting from "+parent.__c.SmartStringFormatter("",(Object)(parent._buwizz._ble_device_name /*String*/ ))+""),parent._hmitileutils._event_level_warning /*int*/ );
 //BA.debugLineNum = 406;BA.debugLine="Wait For(BLEMgr.Disconnect) Complete (Success As";
parent.__c.WaitFor("complete", ba, this, parent._blemgr._disconnect /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 17;
return;
case 17:
//C
this.state = 11;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 407;BA.debugLine="If Not(Success) Then";
if (true) break;

case 11:
//if
this.state = 14;
if (parent.__c.Not(_success)) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 408;BA.debugLine="TileEventViewer.Insert(BLEMgr.LastMsg, HMITileU";
parent._tileeventviewer._insert /*String*/ (parent._blemgr._lastmsg /*String*/ ,parent._hmitileutils._event_level_alarm /*int*/ );
 if (true) break;

case 14:
//C
this.state = 15;
;
 //BA.debugLineNum = 411;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 15:
//C
this.state = -1;
;
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _tilebuttonconnectupdate(boolean _state) throws Exception{
 //BA.debugLineNum = 416;BA.debugLine="Private Sub TileButtonConnectUpdate(state As Boole";
 //BA.debugLineNum = 417;BA.debugLine="If Not(TileButtonConnect.IsInitialized) Then Retu";
if (__c.Not(_tilebuttonconnect.IsInitialized /*boolean*/ ())) { 
if (true) return "";};
 //BA.debugLineNum = 418;BA.debugLine="TileButtonConnect.State = state";
_tilebuttonconnect._setstate /*boolean*/ (_state);
 //BA.debugLineNum = 419;BA.debugLine="TileButtonConnect.StateText = IIf(state, Chr(0xF0";
_tilebuttonconnect._setstatetext /*String*/ (BA.ObjectToString(((_state) ? ((Object)(__c.Chr(((int)0xf0c1)))) : ((Object)(__c.Chr(((int)0xf127)))))));
 //BA.debugLineNum = 420;BA.debugLine="End Sub";
return "";
}
public String  _tileeventviewer_click(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 435;BA.debugLine="Private Sub TileEventViewer_Click(EventData As Mou";
 //BA.debugLineNum = 436;BA.debugLine="Log(BLEMgr.LastMsg)";
__c.LogImpl("21310721",_blemgr._lastmsg /*String*/ ,0);
 //BA.debugLineNum = 437;BA.debugLine="End Sub";
return "";
}
public String  _tileeventviewer_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 440;BA.debugLine="Private Sub TileEventViewer_ItemClick (Index As In";
 //BA.debugLineNum = 442;BA.debugLine="End Sub";
return "";
}
public String  _tileseekbarspeed_valuechanged(int _value) throws Exception{
 //BA.debugLineNum = 424;BA.debugLine="Private Sub TileSeekBarSpeed_ValueChanged (Value A";
 //BA.debugLineNum = 425;BA.debugLine="If Value > 0 And TileSelectDirection.SelectedInde";
if (_value>0 && _tileselectdirection._getselectedindex /*int*/ ()==_buwizz._direction_stp /*int*/ ) { 
 //BA.debugLineNum = 426;BA.debugLine="TileSelectDirection.SelectedIndex = BuWizz.DIREC";
_tileselectdirection._setselectedindex /*int*/ (_buwizz._direction_fwd /*int*/ );
 };
 //BA.debugLineNum = 428;BA.debugLine="SetSpeed";
_setspeed();
 //BA.debugLineNum = 429;BA.debugLine="TileEventViewer.Insert($\"[TileSeekBarSpeed_ValueC";
_tileeventviewer._insert /*String*/ (("[TileSeekBarSpeed_ValueChanged] speed="+__c.SmartStringFormatter("",(Object)(_value))+""),_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 430;BA.debugLine="End Sub";
return "";
}
public String  _tileselectdirection_valuechanged(Object _value) throws Exception{
 //BA.debugLineNum = 494;BA.debugLine="Private Sub TileSelectDirection_ValueChanged (Valu";
 //BA.debugLineNum = 495;BA.debugLine="If IsConnected Then";
if (_isconnected) { 
 //BA.debugLineNum = 497;BA.debugLine="BuWizz.SetPowerLevel(Port, 0)";
_buwizz._setpowerlevel /*String*/ (_port,(int) (0));
 //BA.debugLineNum = 499;BA.debugLine="SetSpeed";
_setspeed();
 };
 //BA.debugLineNum = 501;BA.debugLine="End Sub";
return "";
}
public String  _write(byte[] _data) throws Exception{
 //BA.debugLineNum = 338;BA.debugLine="Public Sub Write(data() As Byte)";
 //BA.debugLineNum = 339;BA.debugLine="BLEMgr.Write(data)";
_blemgr._write /*void*/ (_data);
 //BA.debugLineNum = 340;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
