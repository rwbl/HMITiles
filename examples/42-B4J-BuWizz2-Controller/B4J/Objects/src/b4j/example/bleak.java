package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class bleak extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.bleak", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.bleak.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.pybridge _py = null;
public b4j.example.pywrapper _scanner = null;
public Object _mcallback = null;
public String _meventname = "";
public b4j.example.pywrapper _bleakmodule = null;
public anywheresoftware.b4a.objects.collections.List _clients = null;
public boolean _misscanning = false;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public static class _bleakdevice{
public boolean IsInitialized;
public String Name;
public String DeviceId;
public int RSSI;
public anywheresoftware.b4a.objects.collections.List ServiceUUIDS;
public anywheresoftware.b4a.objects.collections.Map ManufacturerData;
public anywheresoftware.b4a.objects.collections.Map ServiceData;
public int TXPower;
public b4j.example.pywrapper BLEDevice;
public void Initialize() {
IsInitialized = true;
Name = "";
DeviceId = "";
RSSI = 0;
ServiceUUIDS = new anywheresoftware.b4a.objects.collections.List();
ManufacturerData = new anywheresoftware.b4a.objects.collections.Map();
ServiceData = new anywheresoftware.b4a.objects.collections.Map();
TXPower = 0;
BLEDevice = new b4j.example.pywrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Public Py As PyBridge";
_py = new b4j.example.pybridge();
 //BA.debugLineNum = 6;BA.debugLine="Private scanner As PyWrapper";
_scanner = new b4j.example.pywrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 8;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 9;BA.debugLine="Type BleakDevice (Name As String, DeviceId As Str";
;
 //BA.debugLineNum = 12;BA.debugLine="Private BleakModule As PyWrapper";
_bleakmodule = new b4j.example.pywrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private Clients As List";
_clients = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 14;BA.debugLine="Private mIsScanning As Boolean";
_misscanning = false;
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public b4j.example.bleak._bleakdevice  _createbleakdevice(anywheresoftware.b4a.objects.collections.Map _args) throws Exception{
b4j.example.bleak._bleakdevice _t1 = null;
 //BA.debugLineNum = 105;BA.debugLine="Private Sub CreateBleakDevice(Args As Map) As Blea";
 //BA.debugLineNum = 106;BA.debugLine="Dim t1 As BleakDevice";
_t1 = new b4j.example.bleak._bleakdevice();
 //BA.debugLineNum = 107;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 108;BA.debugLine="t1.Name = IIFNull(Args.Get(\"name\"), \"\")";
_t1.Name /*String*/  = BA.ObjectToString(_iifnull(_args.Get((Object)("name")),(Object)("")));
 //BA.debugLineNum = 109;BA.debugLine="t1.DeviceId = Args.Get(\"address\")";
_t1.DeviceId /*String*/  = BA.ObjectToString(_args.Get((Object)("address")));
 //BA.debugLineNum = 110;BA.debugLine="t1.RSSI = IIFNull(Args.Get(\"rssi\"), -1)";
_t1.RSSI /*int*/  = (int)(BA.ObjectToNumber(_iifnull(_args.Get((Object)("rssi")),(Object)(-1))));
 //BA.debugLineNum = 111;BA.debugLine="t1.ServiceUUIDS = Args.Get(\"service_uuids\")";
_t1.ServiceUUIDS /*anywheresoftware.b4a.objects.collections.List*/  = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_args.Get((Object)("service_uuids"))));
 //BA.debugLineNum = 112;BA.debugLine="t1.ManufacturerData = Args.Get(\"mfg_data\")";
_t1.ManufacturerData /*anywheresoftware.b4a.objects.collections.Map*/  = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_args.Get((Object)("mfg_data"))));
 //BA.debugLineNum = 113;BA.debugLine="t1.ServiceData = Args.Get(\"service_data\")";
_t1.ServiceData /*anywheresoftware.b4a.objects.collections.Map*/  = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_args.Get((Object)("service_data"))));
 //BA.debugLineNum = 114;BA.debugLine="t1.TXPower = IIFNull(Args.Get(\"tx\"), 0)";
_t1.TXPower /*int*/  = (int)(BA.ObjectToNumber(_iifnull(_args.Get((Object)("tx")),(Object)(0))));
 //BA.debugLineNum = 115;BA.debugLine="t1.BLEDevice = Py.Bridge.Run(\"get_and_remove_obje";
_t1.BLEDevice /*b4j.example.pywrapper*/  = _py._bridge /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("get_and_remove_object")._arg /*b4j.example.pywrapper*/ (_args.Get((Object)("device_slot")));
 //BA.debugLineNum = 116;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return null;
}
public b4j.example.bleakclient  _createclient(b4j.example.bleak._bleakdevice _device) throws Exception{
b4j.example.bleakclient _c = null;
 //BA.debugLineNum = 131;BA.debugLine="Public Sub CreateClient (Device As BleakDevice) As";
 //BA.debugLineNum = 132;BA.debugLine="Dim c As BleakClient";
_c = new b4j.example.bleakclient();
 //BA.debugLineNum = 133;BA.debugLine="c.Initialize(mCallback, mEventName, Device, Me)";
_c._initialize /*String*/ (ba,_mcallback,_meventname,_device,(b4j.example.bleak)(this));
 //BA.debugLineNum = 134;BA.debugLine="Return c";
if (true) return _c;
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _enabledebuglogging() throws Exception{
String _code = "";
 //BA.debugLineNum = 48;BA.debugLine="Public Sub EnableDebugLogging As PyWrapper";
 //BA.debugLineNum = 49;BA.debugLine="Dim Code As String = $\" import logging import ble";
_code = ("\n"+"import logging\n"+"import bleak\n"+"def EnableDebugLogging ():\n"+"	logging.basicConfig(level=logging.DEBUG)\n"+"	bleak_logger = logging.getLogger(\"bleak\")\n"+"	bleak_logger.setLevel(logging.DEBUG)\n"+"");
 //BA.debugLineNum = 57;BA.debugLine="Return Py.RunCode(\"EnableDebugLogging\", Array(),";
if (true) return _py._runcode /*b4j.example.pywrapper*/ ("EnableDebugLogging",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{}),_code);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return null;
}
public boolean  _getisscanning() throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Public Sub getIsScanning As Boolean";
 //BA.debugLineNum = 92;BA.debugLine="Return mIsScanning";
if (true) return _misscanning;
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return false;
}
public Object  _iifnull(Object _o,Object _defaultvalue) throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Private Sub IIFNull (o As Object, Defaultvalue As";
 //BA.debugLineNum = 120;BA.debugLine="If o = Null Then Return Defaultvalue";
if (_o== null) { 
if (true) return _defaultvalue;};
 //BA.debugLineNum = 121;BA.debugLine="Return o";
if (true) return _o;
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname,b4j.example.pybridge _bridge) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 17;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 18;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 19;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 20;BA.debugLine="Py = Bridge";
_py = _bridge;
 //BA.debugLineNum = 21;BA.debugLine="BleakModule = Py.ImportModule(\"bleak\")";
_bleakmodule = _py._importmodule /*b4j.example.pywrapper*/ ("bleak");
 //BA.debugLineNum = 22;BA.debugLine="Clients.Initialize";
_clients.Initialize();
 //BA.debugLineNum = 23;BA.debugLine="Py.RunNoArgsCode($\" import asyncio from bleak imp";
_py._runnoargscode /*String*/ (("\n"+"import asyncio\n"+"from bleak import BleakScanner\n"+"def scanner_callback(device, data):\n"+"	slot = bridge_instance.store_python_object(device)\n"+"	bridge_instance.raise_event(\"DeviceFound\", {\"address\": device.address, \"name\": device.name,\n"+"		\"rssi\": data.rssi,\n"+"		\"service_uuids\": data.service_uuids,\n"+"	 	\"mfg_data\": data.manufacturer_data,\n"+"		\"service_data\": data.service_data, \"tx\": data.tx_power, \"device_slot\": slot})\n"+"def disconnect_callback(client):\n"+"	bridge_instance.raise_event(\"DeviceDisconnected\", {\"device\": client.address})\n"+"\n"+"def create_notify_callback(client_address, char):\n"+"	def callback(_ , data):\n"+"		bridge_instance.raise_event(\"CharNotify\", {\"client\": client_address, \"char_address\": char.uuid, \"data\": data})\n"+"	return callback\n"+"\n"+""));
 //BA.debugLineNum = 42;BA.debugLine="Py.SetEventMapping(\"DeviceFound\", Me, \"Py\")";
_py._seteventmapping /*String*/ ("DeviceFound",this,"Py");
 //BA.debugLineNum = 43;BA.debugLine="Py.SetEventMapping(\"DeviceDisconnected\", Me, \"Py\"";
_py._seteventmapping /*String*/ ("DeviceDisconnected",this,"Py");
 //BA.debugLineNum = 44;BA.debugLine="Py.SetEventMapping(\"CharNotify\", Me, \"Py\")";
_py._seteventmapping /*String*/ ("CharNotify",this,"Py");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public boolean  _internalreturnsuccessflag(b4j.example.pywrapper _result) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Public Sub InternalReturnSuccessFlag (Result As Py";
 //BA.debugLineNum = 126;BA.debugLine="If Result.IsSuccess = False Then Py.PyLastExcepti";
if (_result._getissuccess /*boolean*/ ()==__c.False) { 
_py._pylastexception /*String*/  = _result._geterrormessage /*String*/ ();};
 //BA.debugLineNum = 127;BA.debugLine="Return Result.IsSuccess";
if (true) return _result._getissuccess /*boolean*/ ();
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return false;
}
public String  _py_charnotify(anywheresoftware.b4a.objects.collections.Map _args) throws Exception{
b4j.example.bleakclient._bleaknotification _n = null;
 //BA.debugLineNum = 68;BA.debugLine="Private Sub Py_CharNotify(Args As Map)";
 //BA.debugLineNum = 69;BA.debugLine="Dim n As BleakNotification";
_n = new b4j.example.bleakclient._bleaknotification();
 //BA.debugLineNum = 70;BA.debugLine="n.Initialize";
_n.Initialize();
 //BA.debugLineNum = 71;BA.debugLine="n.CharacteristicUUID = Args.Get(\"char_address\")";
_n.CharacteristicUUID /*String*/  = BA.ObjectToString(_args.Get((Object)("char_address")));
 //BA.debugLineNum = 72;BA.debugLine="n.ClientUUID = Args.Get(\"client\")";
_n.ClientUUID /*String*/  = BA.ObjectToString(_args.Get((Object)("client")));
 //BA.debugLineNum = 73;BA.debugLine="n.Value = Args.Get(\"data\")";
_n.Value /*byte[]*/  = (byte[])(_args.Get((Object)("data")));
 //BA.debugLineNum = 74;BA.debugLine="CallSub2(mCallback, mEventName & \"_CharNotify\", n";
__c.CallSubNew2(ba,_mcallback,_meventname+"_CharNotify",(Object)(_n));
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _py_devicedisconnected(anywheresoftware.b4a.objects.collections.Map _args) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Private Sub Py_DeviceDisconnected (Args As Map)";
 //BA.debugLineNum = 65;BA.debugLine="CallSub2(mCallback, mEventName & \"_devicedisconne";
__c.CallSubNew2(ba,_mcallback,_meventname+"_devicedisconnected",_args.Get((Object)("device")));
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public String  _py_devicefound(anywheresoftware.b4a.objects.collections.Map _args) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Private Sub Py_DeviceFound (Args As Map)";
 //BA.debugLineNum = 61;BA.debugLine="CallSub2(mCallback, mEventName & \"_devicefound\",";
__c.CallSubNew2(ba,_mcallback,_meventname+"_devicefound",(Object)(_createbleakdevice(_args)));
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _scan(anywheresoftware.b4a.objects.collections.List _serviceuuids) throws Exception{
ResumableSub_Scan rsub = new ResumableSub_Scan(this,_serviceuuids);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Scan extends BA.ResumableSub {
public ResumableSub_Scan(b4j.example.bleak parent,anywheresoftware.b4a.objects.collections.List _serviceuuids) {
this.parent = parent;
this._serviceuuids = _serviceuuids;
}
b4j.example.bleak parent;
anywheresoftware.b4a.objects.collections.List _serviceuuids;
b4j.example.pywrapper _result = null;

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
 //BA.debugLineNum = 82;BA.debugLine="StopScan";
parent._stopscan();
 //BA.debugLineNum = 83;BA.debugLine="scanner = BleakModule.Run(\"BleakScanner\").Arg(Py.";
parent._scanner = parent._bleakmodule._run /*b4j.example.pywrapper*/ ("BleakScanner")._arg /*b4j.example.pywrapper*/ ((Object)(parent._py._getmember /*b4j.example.pywrapper*/ ("scanner_callback")));
 //BA.debugLineNum = 84;BA.debugLine="If Initialized(ServiceUUIDs) Then scanner = scann";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.__c.Initialized((Object)(_serviceuuids))) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent._scanner = parent._scanner._arg /*b4j.example.pywrapper*/ ((Object)(_serviceuuids.getObject()));
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 85;BA.debugLine="Wait For (scanner.RunAwait(\"start\", Null, Null))";
parent.__c.WaitFor("complete", ba, this, parent._scanner._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("start",(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent.__c.Null)),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent.__c.Null))));
this.state = 13;
return;
case 13:
//C
this.state = 7;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 86;BA.debugLine="If Result.IsSuccess Then mIsScanning = True";
if (true) break;

case 7:
//if
this.state = 12;
if (_result._getissuccess /*boolean*/ ()) { 
this.state = 9;
;}if (true) break;

case 9:
//C
this.state = 12;
parent._misscanning = parent.__c.True;
if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 87;BA.debugLine="Return InternalReturnSuccessFlag(Result)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._internalreturnsuccessflag(_result)));return;};
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(b4j.example.pywrapper _result) throws Exception{
}
public String  _stopscan() throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Public Sub StopScan";
 //BA.debugLineNum = 97;BA.debugLine="mIsScanning = False";
_misscanning = __c.False;
 //BA.debugLineNum = 98;BA.debugLine="If Initialized(scanner) Then";
if (__c.Initialized((Object)(_scanner))) { 
 //BA.debugLineNum = 99;BA.debugLine="scanner.RunAwait(\"stop\", Null, Null)";
_scanner._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("stop",(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 };
 //BA.debugLineNum = 101;BA.debugLine="scanner = Null";
_scanner = (b4j.example.pywrapper)(__c.Null);
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
