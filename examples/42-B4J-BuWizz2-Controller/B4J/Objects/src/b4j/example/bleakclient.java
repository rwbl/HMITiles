package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class bleakclient extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.bleakclient", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.bleakclient.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.pybridge _py = null;
public b4j.example.bleak._bleakdevice _mdevice = null;
public b4j.example.pywrapper _client = null;
public b4j.example.bleak _mbleak = null;
public anywheresoftware.b4a.objects.collections.Map _mservices = null;
public int _timeoutms = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public static class _bleakservice{
public boolean IsInitialized;
public String Description;
public String UUID;
public anywheresoftware.b4a.objects.collections.List Characteristics;
public int Handle;
public void Initialize() {
IsInitialized = true;
Description = "";
UUID = "";
Characteristics = new anywheresoftware.b4a.objects.collections.List();
Handle = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _bleakcharacteristic{
public boolean IsInitialized;
public String Description;
public String UUID;
public int Handle;
public anywheresoftware.b4a.objects.collections.List Properties;
public void Initialize() {
IsInitialized = true;
Description = "";
UUID = "";
Handle = 0;
Properties = new anywheresoftware.b4a.objects.collections.List();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _bleaknotification{
public boolean IsInitialized;
public String ClientUUID;
public String CharacteristicUUID;
public byte[] Value;
public void Initialize() {
IsInitialized = true;
ClientUUID = "";
CharacteristicUUID = "";
Value = new byte[0];
;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public py As PyBridge 'ignore";
_py = new b4j.example.pybridge();
 //BA.debugLineNum = 3;BA.debugLine="Public mDevice As BleakDevice";
_mdevice = new b4j.example.bleak._bleakdevice();
 //BA.debugLineNum = 4;BA.debugLine="Public client As PyWrapper";
_client = new b4j.example.pywrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private mBleak As Bleak";
_mbleak = new b4j.example.bleak();
 //BA.debugLineNum = 6;BA.debugLine="Type BleakService(Description As String, UUID As";
;
 //BA.debugLineNum = 7;BA.debugLine="Type BleakCharacteristic(Description As String, U";
;
 //BA.debugLineNum = 8;BA.debugLine="Type BleakNotification (ClientUUID As String, Cha";
;
 //BA.debugLineNum = 9;BA.debugLine="Private mServices As Map";
_mservices = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 10;BA.debugLine="Public TimeoutMs As Int = 10000";
_timeoutms = (int) (10000);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _connect() throws Exception{
ResumableSub_Connect rsub = new ResumableSub_Connect(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Connect extends BA.ResumableSub {
public ResumableSub_Connect(b4j.example.bleakclient parent) {
this.parent = parent;
}
b4j.example.bleakclient parent;
String _code = "";
b4j.example.pywrapper _result = null;
b4j.example.pywrapper _rawservices = null;
Object[] _o = null;
int _servicehandle = 0;
String _serviceuuid = "";
String _servicedescription = "";
anywheresoftware.b4a.objects.collections.List _rawchars = null;
b4j.example.bleakclient._bleakservice _service = null;
Object[] _c = null;
anywheresoftware.b4a.BA.IterableList group6;
int index6;
int groupLen6;
anywheresoftware.b4a.BA.IterableList group12;
int index12;
int groupLen12;

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
 //BA.debugLineNum = 30;BA.debugLine="mServices.Clear";
parent._mservices.Clear();
 //BA.debugLineNum = 31;BA.debugLine="Dim code As String = $\" import asyncio async def";
_code = ("\n"+"import asyncio\n"+"async def connect_with_timeout(client, timeout):\n"+"	return await asyncio.wait_for(client.connect(), timeout)\n"+"");
 //BA.debugLineNum = 36;BA.debugLine="Wait For (py.RunCodeAwait(\"connect_with_timeout\",";
parent.__c.WaitFor("complete", ba, this, parent._py._runcodeawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("connect_with_timeout",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(parent._client),(Object)(parent._timeoutms/(double)1000)}),_code));
this.state = 13;
return;
case 13:
//C
this.state = 1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 37;BA.debugLine="If Result.IsSuccess Then";
if (true) break;

case 1:
//if
this.state = 12;
if (_result._getissuccess /*boolean*/ ()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 38;BA.debugLine="Wait For (ExtractServices.Fetch) Complete (RawSe";
parent.__c.WaitFor("complete", ba, this, parent._extractservices()._fetch /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 14;
return;
case 14:
//C
this.state = 4;
_rawservices = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 39;BA.debugLine="For Each o() As Object In RawServices.Value.As(L";
if (true) break;

case 4:
//for
this.state = 11;
group6 = ((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_rawservices._getvalue /*Object*/ ())));
index6 = 0;
groupLen6 = group6.getSize();
this.state = 15;
if (true) break;

case 15:
//C
this.state = 11;
if (index6 < groupLen6) {
this.state = 6;
_o = (Object[])(group6.Get(index6));}
if (true) break;

case 16:
//C
this.state = 15;
index6++;
if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 40;BA.debugLine="Dim ServiceHandle As Int = o(0)";
_servicehandle = (int)(BA.ObjectToNumber(_o[(int) (0)]));
 //BA.debugLineNum = 41;BA.debugLine="Dim ServiceUUID As String = o(1)";
_serviceuuid = BA.ObjectToString(_o[(int) (1)]);
 //BA.debugLineNum = 42;BA.debugLine="Dim ServiceDescription As String = o(2)";
_servicedescription = BA.ObjectToString(_o[(int) (2)]);
 //BA.debugLineNum = 43;BA.debugLine="Dim RawChars As List = o(3)";
_rawchars = new anywheresoftware.b4a.objects.collections.List();
_rawchars = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_o[(int) (3)]));
 //BA.debugLineNum = 44;BA.debugLine="Dim service As BleakService = CreateBleakServic";
_service = parent._createbleakservice(_servicedescription,_serviceuuid,_servicehandle);
 //BA.debugLineNum = 45;BA.debugLine="For Each c() As Object In RawChars";
if (true) break;

case 7:
//for
this.state = 10;
group12 = _rawchars;
index12 = 0;
groupLen12 = group12.getSize();
this.state = 17;
if (true) break;

case 17:
//C
this.state = 10;
if (index12 < groupLen12) {
this.state = 9;
_c = (Object[])(group12.Get(index12));}
if (true) break;

case 18:
//C
this.state = 17;
index12++;
if (true) break;

case 9:
//C
this.state = 18;
 //BA.debugLineNum = 46;BA.debugLine="service.Characteristics.Add(CreateBleakCharact";
_service.Characteristics /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(parent._createbleakcharacteristic(BA.ObjectToString(_c[(int) (1)]),BA.ObjectToString(_c[(int) (2)]),(int)(BA.ObjectToNumber(_c[(int) (0)])),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_c[(int) (3)])))));
 if (true) break;
if (true) break;

case 10:
//C
this.state = 16;
;
 //BA.debugLineNum = 48;BA.debugLine="mServices.Put(service.UUID, service)";
parent._mservices.Put((Object)(_service.UUID /*String*/ ),(Object)(_service));
 if (true) break;
if (true) break;

case 11:
//C
this.state = 12;
;
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 51;BA.debugLine="Return mBleak.InternalReturnSuccessFlag(Result)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._mbleak._internalreturnsuccessflag /*boolean*/ (_result)));return;};
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(b4j.example.pywrapper _result) throws Exception{
}
public b4j.example.bleakclient._bleakcharacteristic  _createbleakcharacteristic(String _description,String _uuid,int _handle,anywheresoftware.b4a.objects.collections.List _properties) throws Exception{
b4j.example.bleakclient._bleakcharacteristic _t1 = null;
 //BA.debugLineNum = 103;BA.debugLine="Private Sub CreateBleakCharacteristic (Description";
 //BA.debugLineNum = 104;BA.debugLine="Dim t1 As BleakCharacteristic";
_t1 = new b4j.example.bleakclient._bleakcharacteristic();
 //BA.debugLineNum = 105;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 106;BA.debugLine="t1.Description = Description";
_t1.Description /*String*/  = _description;
 //BA.debugLineNum = 107;BA.debugLine="t1.UUID = UUID";
_t1.UUID /*String*/  = _uuid;
 //BA.debugLineNum = 108;BA.debugLine="t1.Handle = Handle";
_t1.Handle /*int*/  = _handle;
 //BA.debugLineNum = 109;BA.debugLine="t1.Properties = Properties";
_t1.Properties /*anywheresoftware.b4a.objects.collections.List*/  = _properties;
 //BA.debugLineNum = 110;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return null;
}
public b4j.example.bleakclient._bleakservice  _createbleakservice(String _description,String _uuid,int _handle) throws Exception{
b4j.example.bleakclient._bleakservice _t1 = null;
 //BA.debugLineNum = 113;BA.debugLine="Private Sub CreateBleakService (Description As Str";
 //BA.debugLineNum = 114;BA.debugLine="Dim t1 As BleakService";
_t1 = new b4j.example.bleakclient._bleakservice();
 //BA.debugLineNum = 115;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 116;BA.debugLine="t1.Description = Description";
_t1.Description /*String*/  = _description;
 //BA.debugLineNum = 117;BA.debugLine="t1.UUID = UUID";
_t1.UUID /*String*/  = _uuid;
 //BA.debugLineNum = 118;BA.debugLine="t1.Characteristics.Initialize";
_t1.Characteristics /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
 //BA.debugLineNum = 119;BA.debugLine="t1.Handle = Handle";
_t1.Handle /*int*/  = _handle;
 //BA.debugLineNum = 120;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _disconnect() throws Exception{
ResumableSub_Disconnect rsub = new ResumableSub_Disconnect(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Disconnect extends BA.ResumableSub {
public ResumableSub_Disconnect(b4j.example.bleakclient parent) {
this.parent = parent;
}
b4j.example.bleakclient parent;
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
this.state = -1;
 //BA.debugLineNum = 65;BA.debugLine="Wait For (client.RunAwait(\"disconnect\", Null, Nul";
parent.__c.WaitFor("complete", ba, this, parent._client._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("disconnect",(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent.__c.Null)),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent.__c.Null))));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 66;BA.debugLine="Return mBleak.InternalReturnSuccessFlag(Result)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._mbleak._internalreturnsuccessflag /*boolean*/ (_result)));return;};
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public b4j.example.pywrapper  _extractservices() throws Exception{
String _code = "";
 //BA.debugLineNum = 91;BA.debugLine="Private Sub ExtractServices As PyWrapper";
 //BA.debugLineNum = 92;BA.debugLine="Dim Code As String = $\" def ExtractServices (clie";
_code = ("\n"+"def ExtractServices (client):\n"+"	services = []\n"+"	for service in client.services.services.values():\n"+"		chars = [(c.handle, c.description, c.uuid, c.properties) for c in service.characteristics]\n"+"		services.append((service.handle, service.uuid, service.description, chars))\n"+"	return services\n"+"");
 //BA.debugLineNum = 100;BA.debugLine="Return py.RunCode(\"ExtractServices\", Array(client";
if (true) return _py._runcode /*b4j.example.pywrapper*/ ("ExtractServices",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_client)}),_code);
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.Map  _getservices() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Public Sub getServices As Map";
 //BA.debugLineNum = 24;BA.debugLine="Return mServices";
if (true) return _mservices;
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname,b4j.example.bleak._bleakdevice _device,b4j.example.bleak _bleak1) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 15;BA.debugLine="mDevice = device";
_mdevice = _device;
 //BA.debugLineNum = 16;BA.debugLine="mBleak = Bleak1";
_mbleak = _bleak1;
 //BA.debugLineNum = 17;BA.debugLine="py = mBleak.Py";
_py = _mbleak._py /*b4j.example.pybridge*/ ;
 //BA.debugLineNum = 18;BA.debugLine="client = py.ImportModule(\"bleak\").Run(\"BleakClien";
_client = _py._importmodule /*b4j.example.pywrapper*/ ("bleak")._run /*b4j.example.pywrapper*/ ("BleakClient")._arg /*b4j.example.pywrapper*/ ((Object)(_device.BLEDevice /*b4j.example.pywrapper*/ ))._arg /*b4j.example.pywrapper*/ ((Object)(_py._getmember /*b4j.example.pywrapper*/ ("disconnect_callback")));
 //BA.debugLineNum = 19;BA.debugLine="mServices.Initialize";
_mservices.Initialize();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _readchar(String _characteristicaddress) throws Exception{
ResumableSub_ReadChar rsub = new ResumableSub_ReadChar(this,_characteristicaddress);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_ReadChar extends BA.ResumableSub {
public ResumableSub_ReadChar(b4j.example.bleakclient parent,String _characteristicaddress) {
this.parent = parent;
this._characteristicaddress = _characteristicaddress;
}
b4j.example.bleakclient parent;
String _characteristicaddress;
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
this.state = -1;
 //BA.debugLineNum = 59;BA.debugLine="Wait For (client.RunAwait(\"read_gatt_char\", Array";
parent.__c.WaitFor("complete", ba, this, parent._client._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("read_gatt_char",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_characteristicaddress)}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent.__c.Null))));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 60;BA.debugLine="Return Result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _setnotify(String _characteristicaddress) throws Exception{
ResumableSub_SetNotify rsub = new ResumableSub_SetNotify(this,_characteristicaddress);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_SetNotify extends BA.ResumableSub {
public ResumableSub_SetNotify(b4j.example.bleakclient parent,String _characteristicaddress) {
this.parent = parent;
this._characteristicaddress = _characteristicaddress;
}
b4j.example.bleakclient parent;
String _characteristicaddress;
b4j.example.pywrapper _chara = null;
b4j.example.pywrapper _callback = null;
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
this.state = -1;
 //BA.debugLineNum = 72;BA.debugLine="Dim chara As PyWrapper = client.GetField(\"service";
_chara = parent._client._getfield /*b4j.example.pywrapper*/ ("services")._run /*b4j.example.pywrapper*/ ("get_characteristic")._arg /*b4j.example.pywrapper*/ ((Object)(_characteristicaddress));
 //BA.debugLineNum = 73;BA.debugLine="Dim callback As PyWrapper = py.GetMember(\"create_";
_callback = parent._py._getmember /*b4j.example.pywrapper*/ ("create_notify_callback")._call /*b4j.example.pywrapper*/ ()._arg /*b4j.example.pywrapper*/ ((Object)(parent._mdevice.DeviceId /*String*/ ))._arg /*b4j.example.pywrapper*/ ((Object)(_chara));
 //BA.debugLineNum = 74;BA.debugLine="Wait For (client.RunAwait(\"start_notify\", Array(c";
parent.__c.WaitFor("complete", ba, this, parent._client._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("start_notify",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_chara),(Object)(_callback)}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent.__c.Null))));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 75;BA.debugLine="Return Result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _write(String _characteristicaddress,byte[] _data) throws Exception{
ResumableSub_Write rsub = new ResumableSub_Write(this,_characteristicaddress,_data);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Write extends BA.ResumableSub {
public ResumableSub_Write(b4j.example.bleakclient parent,String _characteristicaddress,byte[] _data) {
this.parent = parent;
this._characteristicaddress = _characteristicaddress;
this._data = _data;
}
b4j.example.bleakclient parent;
String _characteristicaddress;
byte[] _data;
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
this.state = -1;
 //BA.debugLineNum = 82;BA.debugLine="Wait For (client.RunAwait(\"write_gatt_char\", Arra";
parent.__c.WaitFor("complete", ba, this, parent._client._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("write_gatt_char",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_characteristicaddress),(Object)(_data)}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent.__c.Null))));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 83;BA.debugLine="Return Result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _writewithresponse(String _characteristicaddress,byte[] _data,boolean _withresponse) throws Exception{
ResumableSub_WriteWithResponse rsub = new ResumableSub_WriteWithResponse(this,_characteristicaddress,_data,_withresponse);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_WriteWithResponse extends BA.ResumableSub {
public ResumableSub_WriteWithResponse(b4j.example.bleakclient parent,String _characteristicaddress,byte[] _data,boolean _withresponse) {
this.parent = parent;
this._characteristicaddress = _characteristicaddress;
this._data = _data;
this._withresponse = _withresponse;
}
b4j.example.bleakclient parent;
String _characteristicaddress;
byte[] _data;
boolean _withresponse;
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
this.state = -1;
 //BA.debugLineNum = 87;BA.debugLine="Wait For (client.RunAwait(\"write_gatt_char\", Arra";
parent.__c.WaitFor("complete", ba, this, parent._client._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("write_gatt_char",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_characteristicaddress),(Object)(_data),(Object)(_withresponse)}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent.__c.Null))));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 88;BA.debugLine="Return Result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
