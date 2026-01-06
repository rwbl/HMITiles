package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class blemanager extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.blemanager", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.blemanager.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.bleak _mble = null;
public b4j.example.bleak._bleakdevice _mbledevice = null;
public String _mbledevicename = "";
public String _mblemac = "";
public b4j.example.bleakclient _mbleclient = null;
public String _mbleserviceuuid = "";
public String _mblecharrxuuid = "";
public String _mblechartxuuid = "";
public boolean _isconnected = false;
public String _path_to_python = "";
public b4j.example.pybridge _py = null;
public b4j.example.b4xmainpage _mmainpage = null;
public anywheresoftware.b4a.objects.Timer _mblescantimer = null;
public long _ble_scan_timer_interval = 0L;
public long _ble_scan_timer_timeout = 0L;
public long _mblescantimercounter = 0L;
public boolean _isdevicefound = false;
public String _lastmsg = "";
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _ble_charnotify(b4j.example.bleakclient._bleaknotification _notification) throws Exception{
 //BA.debugLineNum = 268;BA.debugLine="Private Sub BLE_CharNotify(Notification As BleakNo";
 //BA.debugLineNum = 270;BA.debugLine="mMainPage.HandleBLENotification(Notification.valu";
_mmainpage._handleblenotification /*String*/ (_notification.Value /*byte[]*/ );
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return "";
}
public String  _ble_devicedisconnected(String _deviceid) throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Private Sub BLE_DeviceDisconnected(DeviceId As Str";
 //BA.debugLineNum = 260;BA.debugLine="IsConnected = False";
_isconnected = __c.False;
 //BA.debugLineNum = 261;BA.debugLine="mMainPage.PyBridgeDisconnected";
_mmainpage._pybridgedisconnected /*String*/ ();
 //BA.debugLineNum = 262;BA.debugLine="LastMsg = $\"[BLEManager.BLE_DeviceDisconnected][I";
_lastmsg = ("[BLEManager.BLE_DeviceDisconnected][I] Device disconnected");
 //BA.debugLineNum = 263;BA.debugLine="Log(LastMsg)";
__c.LogImpl("22293764",_lastmsg,0);
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return "";
}
public String  _ble_devicefound(b4j.example.bleak._bleakdevice _device) throws Exception{
 //BA.debugLineNum = 197;BA.debugLine="Private Sub BLE_DeviceFound(Device As BleakDevice)";
 //BA.debugLineNum = 199;BA.debugLine="If mBle.IsScanning = False Then Return";
if (_mble._getisscanning /*boolean*/ ()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 203;BA.debugLine="If Device.DeviceId.EqualsIgnoreCase(mBleMAC) Then";
if (_device.DeviceId /*String*/ .equalsIgnoreCase(_mblemac)) { 
 //BA.debugLineNum = 205;BA.debugLine="IsDeviceFound = True";
_isdevicefound = __c.True;
 //BA.debugLineNum = 208;BA.debugLine="mBleDevice = Device";
_mbledevice = _device;
 //BA.debugLineNum = 209;BA.debugLine="Log($\"[BLEManager.BLE_DeviceFound][I] id=${mBleD";
__c.LogImpl("22097164",("[BLEManager.BLE_DeviceFound][I] id="+__c.SmartStringFormatter("",(Object)(_mbledevice.DeviceId /*String*/ ))+", name="+__c.SmartStringFormatter("",(Object)(_mbledevice.Name /*String*/ ))+", services="+__c.SmartStringFormatter("",(Object)(_mbledevice.ServiceUUIDS /*anywheresoftware.b4a.objects.collections.List*/ .getObject()))+", servicedata="+__c.SmartStringFormatter("",(Object)(_mbledevice.ServiceData /*anywheresoftware.b4a.objects.collections.Map*/ .getObject()))+""),0);
 //BA.debugLineNum = 212;BA.debugLine="mBle.StopScan";
_mble._stopscan /*String*/ ();
 //BA.debugLineNum = 215;BA.debugLine="Connect";
_connect();
 };
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public String  _blescantimer_tick() throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="Private Sub BleScanTimer_Tick";
 //BA.debugLineNum = 146;BA.debugLine="mBleScanTimerCounter = mBleScanTimerCounter + 1";
_mblescantimercounter = (long) (_mblescantimercounter+1);
 //BA.debugLineNum = 147;BA.debugLine="If mBleScanTimerCounter > Round(BLE_SCAN_TIMER_TI";
if (_mblescantimercounter>__c.Round(_ble_scan_timer_timeout/(double)_ble_scan_timer_interval) && __c.Not(_isdevicefound)) { 
 //BA.debugLineNum = 148;BA.debugLine="mBle.StopScan";
_mble._stopscan /*String*/ ();
 //BA.debugLineNum = 149;BA.debugLine="mBleScanTimer.Enabled = False";
_mblescantimer.setEnabled(__c.False);
 //BA.debugLineNum = 150;BA.debugLine="LastMsg = $\"[BLEManager.BleScanTimer][E] Device";
_lastmsg = ("[BLEManager.BleScanTimer][E] Device "+__c.SmartStringFormatter("",(Object)(_mbledevicename))+" not found. Timeout reached.");
 //BA.debugLineNum = 151;BA.debugLine="Log(LastMsg)";
__c.LogImpl("21966086",_lastmsg,0);
 //BA.debugLineNum = 152;BA.debugLine="mMainPage.HandleBLEConnect(False)";
_mmainpage._handlebleconnect /*String*/ (__c.False);
 };
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 34;BA.debugLine="Private mBle As Bleak					' Bleak Object";
_mble = new b4j.example.bleak();
 //BA.debugLineNum = 35;BA.debugLine="Private mBleDevice As BleakDevice";
_mbledevice = new b4j.example.bleak._bleakdevice();
 //BA.debugLineNum = 36;BA.debugLine="Private mBleDeviceName As String";
_mbledevicename = "";
 //BA.debugLineNum = 37;BA.debugLine="Private mBleMAC As String";
_mblemac = "";
 //BA.debugLineNum = 38;BA.debugLine="Private mBleCLient As BleakClient		' Bleak client";
_mbleclient = new b4j.example.bleakclient();
 //BA.debugLineNum = 39;BA.debugLine="Private mBleServiceUUID As String";
_mbleserviceuuid = "";
 //BA.debugLineNum = 40;BA.debugLine="Private mBleCharRXUUID As String";
_mblecharrxuuid = "";
 //BA.debugLineNum = 41;BA.debugLine="Private mBleCharTXUUID As String";
_mblechartxuuid = "";
 //BA.debugLineNum = 42;BA.debugLine="Public IsConnected As Boolean = False	' Public";
_isconnected = __c.False;
 //BA.debugLineNum = 46;BA.debugLine="Private PATH_TO_PYTHON As String = \"Python/python";
_path_to_python = "Python/python/python.exe";
 //BA.debugLineNum = 51;BA.debugLine="Private Py As PyBridge";
_py = new b4j.example.pybridge();
 //BA.debugLineNum = 54;BA.debugLine="Private mMainPage As B4XMainPage";
_mmainpage = new b4j.example.b4xmainpage();
 //BA.debugLineNum = 57;BA.debugLine="Private mBleScanTimer As Timer";
_mblescantimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 58;BA.debugLine="Private BLE_SCAN_TIMER_INTERVAL As Long = 1000";
_ble_scan_timer_interval = (long) (1000);
 //BA.debugLineNum = 59;BA.debugLine="Private BLE_SCAN_TIMER_TIMEOUT As Long = 10000	'";
_ble_scan_timer_timeout = (long) (10000);
 //BA.debugLineNum = 60;BA.debugLine="Private mBleScanTimerCounter As Long = 0";
_mblescantimercounter = (long) (0);
 //BA.debugLineNum = 61;BA.debugLine="Private IsDeviceFound As Boolean = False";
_isdevicefound = __c.False;
 //BA.debugLineNum = 64;BA.debugLine="Public LastMsg As String";
_lastmsg = "";
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _connect() throws Exception{
ResumableSub_Connect rsub = new ResumableSub_Connect(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Connect extends BA.ResumableSub {
public ResumableSub_Connect(b4j.example.blemanager parent) {
this.parent = parent;
}
b4j.example.blemanager parent;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 222;BA.debugLine="mBleCLient = mBle.CreateClient(mBleDevice)";
parent._mbleclient = parent._mble._createclient /*b4j.example.bleakclient*/ (parent._mbledevice);
 //BA.debugLineNum = 225;BA.debugLine="Log($\"[BLEManager.BLEConnect][I] Connecting to de";
parent.__c.LogImpl("22162693",("[BLEManager.BLEConnect][I] Connecting to deviceid="+parent.__c.SmartStringFormatter("",(Object)(parent._mbledevice.DeviceId /*String*/ ))+""),0);
 //BA.debugLineNum = 226;BA.debugLine="Wait For (mBleCLient.Connect) Complete (Success A";
parent.__c.WaitFor("complete", ba, this, parent._mbleclient._connect /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 227;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_success) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 228;BA.debugLine="IsConnected = True";
parent._isconnected = parent.__c.True;
 //BA.debugLineNum = 229;BA.debugLine="LastMsg = $\"[BLEManager.BLEConnect] Connected\"$";
parent._lastmsg = ("[BLEManager.BLEConnect] Connected");
 //BA.debugLineNum = 230;BA.debugLine="Log(LastMsg)";
parent.__c.LogImpl("22162698",parent._lastmsg,0);
 //BA.debugLineNum = 231;BA.debugLine="Sleep(10)";
parent.__c.Sleep(ba,this,(int) (10));
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
 //BA.debugLineNum = 232;BA.debugLine="SetNotify";
parent._setnotify();
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 234;BA.debugLine="IsConnected = False";
parent._isconnected = parent.__c.False;
 //BA.debugLineNum = 235;BA.debugLine="LastMsg = $\"[BLEManager.BLEConnect][E] ${Convert";
parent._lastmsg = ("[BLEManager.BLEConnect][E] "+parent.__c.SmartStringFormatter("",(Object)(parent._convert._parseerrormessage /*String*/ (parent._py._pylastexception /*String*/ )))+"");
 //BA.debugLineNum = 236;BA.debugLine="LogError(LastMsg)";
parent.__c.LogError(parent._lastmsg);
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 238;BA.debugLine="mMainPage.HandleBLEConnect(IsConnected)";
parent._mmainpage._handlebleconnect /*String*/ (parent._isconnected);
 //BA.debugLineNum = 239;BA.debugLine="Return IsConnected";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._isconnected));return;};
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(boolean _success) throws Exception{
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _disconnect() throws Exception{
ResumableSub_Disconnect rsub = new ResumableSub_Disconnect(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Disconnect extends BA.ResumableSub {
public ResumableSub_Disconnect(b4j.example.blemanager parent) {
this.parent = parent;
}
b4j.example.blemanager parent;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 243;BA.debugLine="Wait For (mBleCLient.Disconnect) Complete (Succes";
parent.__c.WaitFor("complete", ba, this, parent._mbleclient._disconnect /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 244;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_success) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 245;BA.debugLine="IsConnected = False";
parent._isconnected = parent.__c.False;
 //BA.debugLineNum = 246;BA.debugLine="LastMsg = $\"[BLEManager.Disconnect] Disconnected";
parent._lastmsg = ("[BLEManager.Disconnect] Disconnected from deviceid="+parent.__c.SmartStringFormatter("",(Object)(parent._mbledevice.DeviceId /*String*/ ))+"");
 //BA.debugLineNum = 247;BA.debugLine="Sleep(10)";
parent.__c.Sleep(ba,this,(int) (10));
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
 //BA.debugLineNum = 248;BA.debugLine="SetNotify";
parent._setnotify();
 //BA.debugLineNum = 249;BA.debugLine="Log(LastMsg)";
parent.__c.LogImpl("22228231",parent._lastmsg,0);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 251;BA.debugLine="IsConnected = True";
parent._isconnected = parent.__c.True;
 //BA.debugLineNum = 252;BA.debugLine="LastMsg = $\"[BLEManager.Disconnect][E] ${Convert";
parent._lastmsg = ("[BLEManager.Disconnect][E] "+parent.__c.SmartStringFormatter("",(Object)(parent._convert._parseerrormessage /*String*/ (parent._py._pylastexception /*String*/ )))+"");
 //BA.debugLineNum = 253;BA.debugLine="LogError(LastMsg)";
parent.__c.LogError(parent._lastmsg);
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 255;BA.debugLine="Return Success";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_success));return;};
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _initialize(anywheresoftware.b4a.BA _ba,b4j.example.b4xmainpage _mainpage,String _mac,String _serviceuuid,String _charrxuuid,String _chartxuuid) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 74;BA.debugLine="Public Sub Initialize(mainpage As B4XMainPage, mac";
 //BA.debugLineNum = 75;BA.debugLine="mBleMAC = mac";
_mblemac = _mac;
 //BA.debugLineNum = 76;BA.debugLine="mBleServiceUUID = serviceuuid";
_mbleserviceuuid = _serviceuuid;
 //BA.debugLineNum = 77;BA.debugLine="mBleCharRXUUID = charrxuuid";
_mblecharrxuuid = _charrxuuid;
 //BA.debugLineNum = 78;BA.debugLine="mBleCharTXUUID = chartxuuid";
_mblechartxuuid = _chartxuuid;
 //BA.debugLineNum = 80;BA.debugLine="mMainPage = mainpage";
_mmainpage = _mainpage;
 //BA.debugLineNum = 82;BA.debugLine="Log($\"mac As String, serviceuuid As String, charr";
__c.LogImpl("21638408",("mac As String, serviceuuid As String, charrxuuid As String, chartxuuid As String"),0);
 //BA.debugLineNum = 84;BA.debugLine="mBleScanTimer.Initialize(\"BleScanTimer\", BLE_SCAN";
_mblescantimer.Initialize(ba,"BleScanTimer",_ble_scan_timer_interval);
 //BA.debugLineNum = 85;BA.debugLine="mBleScanTimer.Enabled = False";
_mblescantimer.setEnabled(__c.False);
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _py_disconnected() throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Private Sub Py_Disconnected";
 //BA.debugLineNum = 104;BA.debugLine="IsConnected = False";
_isconnected = __c.False;
 //BA.debugLineNum = 105;BA.debugLine="mMainPage.PyBridgeDisconnected";
_mmainpage._pybridgedisconnected /*String*/ ();
 //BA.debugLineNum = 106;BA.debugLine="LastMsg = $\"[BLEManager.Py_Disconnected][W] PyBri";
_lastmsg = ("[BLEManager.Py_Disconnected][W] PyBridge disconnected");
 //BA.debugLineNum = 107;BA.debugLine="Log(LastMsg)";
__c.LogImpl("21769476",_lastmsg,0);
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public String  _pybridgekillprocess() throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Public Sub PyBridgeKillProcess";
 //BA.debugLineNum = 138;BA.debugLine="Py.KillProcess";
_py._killprocess /*String*/ ();
 //BA.debugLineNum = 139;BA.debugLine="LastMsg = $\"[BLEManager.PyBridgeKillProcess][I] O";
_lastmsg = ("[BLEManager.PyBridgeKillProcess][I] OK");
 //BA.debugLineNum = 140;BA.debugLine="Log(LastMsg)";
__c.LogImpl("21900547",_lastmsg,0);
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _pybridgestart() throws Exception{
ResumableSub_PyBridgeStart rsub = new ResumableSub_PyBridgeStart(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_PyBridgeStart extends BA.ResumableSub {
public ResumableSub_PyBridgeStart(b4j.example.blemanager parent) {
this.parent = parent;
}
b4j.example.blemanager parent;
b4j.example.pybridge._pyoptions _opt = null;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 111;BA.debugLine="LastMsg = \"\"";
parent._lastmsg = "";
 //BA.debugLineNum = 114;BA.debugLine="Log($\"[BLEManager.PyBridgeStart] Py.Initialize...";
parent.__c.LogImpl("21835012",("[BLEManager.PyBridgeStart] Py.Initialize..."),0);
 //BA.debugLineNum = 115;BA.debugLine="Py.Initialize(Me, \"Py\")";
parent._py._initialize /*String*/ (ba,parent,"Py");
 //BA.debugLineNum = 118;BA.debugLine="Dim opt As PyOptions = Py.CreateOptions(PATH_TO_P";
_opt = parent._py._createoptions /*b4j.example.pybridge._pyoptions*/ (parent._path_to_python);
 //BA.debugLineNum = 121;BA.debugLine="Py.Start(opt)";
parent._py._start /*String*/ (_opt);
 //BA.debugLineNum = 124;BA.debugLine="Wait For Py_Connected (Success As Boolean)";
parent.__c.WaitFor("py_connected", ba, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 125;BA.debugLine="If Not(Success) Then";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.__c.Not(_success)) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 126;BA.debugLine="LastMsg = $\"[BLEManager.PyBridgeStart][E] Failed";
parent._lastmsg = ("[BLEManager.PyBridgeStart][E] Failed to start Python process.");
 //BA.debugLineNum = 127;BA.debugLine="LogError(LastMsg)";
parent.__c.LogError(parent._lastmsg);
 //BA.debugLineNum = 128;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 130;BA.debugLine="LastMsg = $\"[BLEManager.PyBridgeStart][I] Python";
parent._lastmsg = ("[BLEManager.PyBridgeStart][I] Python process started.");
 //BA.debugLineNum = 131;BA.debugLine="Log(LastMsg)";
parent.__c.LogImpl("21835029",parent._lastmsg,0);
 //BA.debugLineNum = 132;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _py_connected(boolean _success) throws Exception{
}
public void  _read() throws Exception{
ResumableSub_Read rsub = new ResumableSub_Read(this);
rsub.resume(ba, null);
}
public static class ResumableSub_Read extends BA.ResumableSub {
public ResumableSub_Read(b4j.example.blemanager parent) {
this.parent = parent;
}
b4j.example.blemanager parent;
b4j.example.pywrapper _result = null;
byte[] _data = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 275;BA.debugLine="If Not(IsConnected) Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.__c.Not(parent._isconnected)) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 277;BA.debugLine="Wait For (mBleCLient.ReadChar(mBleCharRXUUID)) Co";
parent.__c.WaitFor("complete", ba, this, parent._mbleclient._readchar /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._mblecharrxuuid));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 278;BA.debugLine="If Not(Result.IsSuccess) Then";
if (true) break;

case 7:
//if
this.state = 12;
if (parent.__c.Not(_result._getissuccess /*boolean*/ ())) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 279;BA.debugLine="LastMsg = $\"[BLEManager.Read][E] ${Convert.Parse";
parent._lastmsg = ("[BLEManager.Read][E] "+parent.__c.SmartStringFormatter("",(Object)(parent._convert._parseerrormessage /*String*/ (_result._geterrormessage /*String*/ ())))+"");
 //BA.debugLineNum = 280;BA.debugLine="LogError(LastMsg)";
parent.__c.LogError(parent._lastmsg);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 283;BA.debugLine="Dim data() As Byte = Result.Value";
_data = (byte[])(_result._getvalue /*Object*/ ());
 //BA.debugLineNum = 285;BA.debugLine="LastMsg = $\"[BLEManager.Read][I] data=${Convert.";
parent._lastmsg = ("[BLEManager.Read][I] data="+parent.__c.SmartStringFormatter("",(Object)(parent._convert._byteconv /*anywheresoftware.b4a.agraham.byteconverter.ByteConverter*/ .HexFromBytes(_data)))+"");
 //BA.debugLineNum = 286;BA.debugLine="Log(LastMsg)";
parent.__c.LogImpl("22424844",parent._lastmsg,0);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _scan() throws Exception{
ResumableSub_Scan rsub = new ResumableSub_Scan(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Scan extends BA.ResumableSub {
public ResumableSub_Scan(b4j.example.blemanager parent) {
this.parent = parent;
}
b4j.example.blemanager parent;
boolean _result = false;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 159;BA.debugLine="Dim result As Boolean";
_result = false;
 //BA.debugLineNum = 161;BA.debugLine="If IsConnected Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._isconnected) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 162;BA.debugLine="result = True";
_result = parent.__c.True;
 //BA.debugLineNum = 163;BA.debugLine="Return result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 if (true) break;
;
 //BA.debugLineNum = 167;BA.debugLine="If Not(IsConnected) Then";

case 4:
//if
this.state = 15;
if (parent.__c.Not(parent._isconnected)) { 
this.state = 6;
}else {
this.state = 14;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 169;BA.debugLine="Log($\"[BLEManager.Scan][I] Scanning devices, ser";
parent.__c.LogImpl("22031627",("[BLEManager.Scan][I] Scanning devices, serviceuuid="+parent.__c.SmartStringFormatter("",(Object)(parent._mbleserviceuuid))+""),0);
 //BA.debugLineNum = 173;BA.debugLine="mBleScanTimerCounter = 0";
parent._mblescantimercounter = (long) (0);
 //BA.debugLineNum = 174;BA.debugLine="mBleScanTimer.Enabled = True";
parent._mblescantimer.setEnabled(parent.__c.True);
 //BA.debugLineNum = 175;BA.debugLine="IsDeviceFound = False";
parent._isdevicefound = parent.__c.False;
 //BA.debugLineNum = 176;BA.debugLine="Wait For (mBle.Scan(Array As String(mBleServiceU";
parent.__c.WaitFor("complete", ba, this, parent._mble._scan /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{parent._mbleserviceuuid})));
this.state = 16;
return;
case 16:
//C
this.state = 7;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 178;BA.debugLine="If Success Then";
if (true) break;

case 7:
//if
this.state = 12;
if (_success) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 179;BA.debugLine="LastMsg = $\"[BLEManager.Scan][I] Devices found.";
parent._lastmsg = ("[BLEManager.Scan][I] Devices found.");
 //BA.debugLineNum = 180;BA.debugLine="Log(LastMsg)";
parent.__c.LogImpl("22031638",parent._lastmsg,0);
 //BA.debugLineNum = 181;BA.debugLine="result = True";
_result = parent.__c.True;
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 183;BA.debugLine="LastMsg = $\"[BLEManager.Scan][E] ${Py.PyLastExc";
parent._lastmsg = ("[BLEManager.Scan][E] "+parent.__c.SmartStringFormatter("",(Object)(parent._py._pylastexception /*String*/ ))+"");
 //BA.debugLineNum = 184;BA.debugLine="LogError(LastMsg)";
parent.__c.LogError(parent._lastmsg);
 //BA.debugLineNum = 185;BA.debugLine="result = False";
_result = parent.__c.False;
 if (true) break;

case 12:
//C
this.state = 15;
;
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 188;BA.debugLine="Wait For(mBleCLient.Disconnect) Complete (Succes";
parent.__c.WaitFor("complete", ba, this, parent._mbleclient._disconnect /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 17;
return;
case 17:
//C
this.state = 15;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 189;BA.debugLine="result = Success";
_result = _success;
 if (true) break;

case 15:
//C
this.state = -1;
;
 //BA.debugLineNum = 191;BA.debugLine="Return result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _setnotify() throws Exception{
ResumableSub_SetNotify rsub = new ResumableSub_SetNotify(this);
rsub.resume(ba, null);
}
public static class ResumableSub_SetNotify extends BA.ResumableSub {
public ResumableSub_SetNotify(b4j.example.blemanager parent) {
this.parent = parent;
}
b4j.example.blemanager parent;
b4j.example.pywrapper _result = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 299;BA.debugLine="If Not(IsConnected) Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.__c.Not(parent._isconnected)) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 301;BA.debugLine="Wait For (mBleCLient.SetNotify(mBleCharRXUUID)) C";
parent.__c.WaitFor("complete", ba, this, parent._mbleclient._setnotify /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._mblecharrxuuid));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 302;BA.debugLine="If Not(Result.IsSuccess) Then";
if (true) break;

case 7:
//if
this.state = 12;
if (parent.__c.Not(_result._getissuccess /*boolean*/ ())) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 303;BA.debugLine="LastMsg = $\"[BLEManager.SetNotify][E] ${Convert.";
parent._lastmsg = ("[BLEManager.SetNotify][E] "+parent.__c.SmartStringFormatter("",(Object)(parent._convert._parseerrormessage /*String*/ (_result._geterrormessage /*String*/ ())))+"");
 //BA.debugLineNum = 304;BA.debugLine="LogError(LastMsg)";
parent.__c.LogError(parent._lastmsg);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 306;BA.debugLine="LastMsg = $\"[BLEManager.SetNotify][I] OK. Waitin";
parent._lastmsg = ("[BLEManager.SetNotify][I] OK. Waiting for data...");
 //BA.debugLineNum = 307;BA.debugLine="Log(LastMsg)";
parent.__c.LogImpl("22490377",parent._lastmsg,0);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _start() throws Exception{
ResumableSub_Start rsub = new ResumableSub_Start(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Start extends BA.ResumableSub {
public ResumableSub_Start(b4j.example.blemanager parent) {
this.parent = parent;
}
b4j.example.blemanager parent;
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 92;BA.debugLine="Wait For (PyBridgeStart) complete (result As Bool";
parent.__c.WaitFor("complete", ba, this, parent._pybridgestart());
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (boolean) result[0];
;
 //BA.debugLineNum = 93;BA.debugLine="If result Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 95;BA.debugLine="mBle.Initialize(Me, \"ble\", Py)";
parent._mble._initialize /*String*/ (ba,parent,"ble",parent._py);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 97;BA.debugLine="Return result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _write(byte[] _b) throws Exception{
ResumableSub_Write rsub = new ResumableSub_Write(this,_b);
rsub.resume(ba, null);
}
public static class ResumableSub_Write extends BA.ResumableSub {
public ResumableSub_Write(b4j.example.blemanager parent,byte[] _b) {
this.parent = parent;
this._b = _b;
}
b4j.example.blemanager parent;
byte[] _b;
Object _rs = null;
b4j.example.pywrapper _result2 = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 316;BA.debugLine="If Not(IsConnected) Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.__c.Not(parent._isconnected)) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 318;BA.debugLine="Log($\"[BLEManager.Write] data=${Convert.ByteConv.";
parent.__c.LogImpl("22555907",("[BLEManager.Write] data="+parent.__c.SmartStringFormatter("",(Object)(parent._convert._byteconv /*anywheresoftware.b4a.agraham.byteconverter.ByteConverter*/ .HexFromBytes(_b)))+""),0);
 //BA.debugLineNum = 321;BA.debugLine="Dim rs As Object = mBleCLient.Write(mBleCharTXUUI";
_rs = parent._mbleclient._write /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._mblechartxuuid,_b);
 //BA.debugLineNum = 322;BA.debugLine="Wait For (rs) Complete (Result2 As PyWrapper)";
parent.__c.WaitFor("complete", ba, this, _rs);
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result2 = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 323;BA.debugLine="If Not(Result2.IsSuccess) Then";
if (true) break;

case 7:
//if
this.state = 12;
if (parent.__c.Not(_result2._getissuccess /*boolean*/ ())) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 324;BA.debugLine="LastMsg = $\"[BLEManager.Write][E] ${Convert.Pars";
parent._lastmsg = ("[BLEManager.Write][E] "+parent.__c.SmartStringFormatter("",(Object)(parent._convert._parseerrormessage /*String*/ (_result2._geterrormessage /*String*/ ())))+"");
 //BA.debugLineNum = 325;BA.debugLine="LogError(LastMsg)";
parent.__c.LogError(parent._lastmsg);
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 327;BA.debugLine="LastMsg = $\"[BLEManager.Write][I] OK, data=${Con";
parent._lastmsg = ("[BLEManager.Write][I] OK, data="+parent.__c.SmartStringFormatter("",(Object)(parent._convert._byteconv /*anywheresoftware.b4a.agraham.byteconverter.ByteConverter*/ .HexFromBytes(_b)))+"");
 //BA.debugLineNum = 328;BA.debugLine="Log(LastMsg)";
parent.__c.LogImpl("22555917",parent._lastmsg,0);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 330;BA.debugLine="Sleep(1)";
parent.__c.Sleep(ba,this,(int) (1));
this.state = 14;
return;
case 14:
//C
this.state = -1;
;
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _writedata(String _serviceuuid,String _characteristicuuid,byte[] _b) throws Exception{
 //BA.debugLineNum = 344;BA.debugLine="Public Sub WriteData(serviceuuid As String, _";
 //BA.debugLineNum = 356;BA.debugLine="Write(b)";
_write(_b);
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
