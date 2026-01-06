package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class buwizz2controller extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.buwizz2controller", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.buwizz2controller.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public boolean _logging = false;
public String _ble_mac = "";
public String _ble_device_name = "";
public String _service_uuid = "";
public String _char_uuid_rx = "";
public String _char_uuid_tx = "";
public b4j.example.buwizz2controller._tbuwizz2status _buwizz2status = null;
public byte _port_0 = (byte)0;
public byte _port_1 = (byte)0;
public byte _port_2 = (byte)0;
public byte _port_3 = (byte)0;
public byte _output_level_default = (byte)0;
public byte _cmd_output_level = (byte)0;
public byte _cmd_power_level = (byte)0;
public int _power_level_full_backwards = 0;
public int _power_level_stop = 0;
public int _power_level_full_forwards = 0;
public int _speed_offset = 0;
public int _speed_min = 0;
public int _speed_max = 0;
public int _direction_stp = 0;
public int _direction_fwd = 0;
public int _direction_bck = 0;
public b4j.example.b4xmainpage _mmainpage = null;
public anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public static class _tbuwizz2status{
public boolean IsInitialized;
public byte StatusFlags;
public float BatteryVoltage;
public float OutputVoltage;
public byte Motor1Current;
public byte Motor2Current;
public byte Motor3Current;
public byte Motor4Current;
public byte PowerLevel;
public int Temperature;
public int AccX;
public int AccY;
public int AccZ;
public void Initialize() {
IsInitialized = true;
StatusFlags = (byte)0;
BatteryVoltage = 0f;
OutputVoltage = 0f;
Motor1Current = (byte)0;
Motor2Current = (byte)0;
Motor3Current = (byte)0;
Motor4Current = (byte)0;
PowerLevel = (byte)0;
Temperature = 0;
AccX = 0;
AccY = 0;
AccZ = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Public Logging As Boolean = True";
_logging = __c.True;
 //BA.debugLineNum = 25;BA.debugLine="Public BLE_MAC As String 			= \"50:FA:AB:38:A6:1A\"";
_ble_mac = "50:FA:AB:38:A6:1A";
 //BA.debugLineNum = 26;BA.debugLine="Public BLE_DEVICE_NAME As String 	= \"BuWizz2\"";
_ble_device_name = "BuWizz2";
 //BA.debugLineNum = 29;BA.debugLine="Public SERVICE_UUID As String 		= \"4e050000-74fb-";
_service_uuid = "4e050000-74fb-4481-88b3-9919b1676e93";
 //BA.debugLineNum = 30;BA.debugLine="Public CHAR_UUID_RX  As String		= \"000092d1-0000-";
_char_uuid_rx = "000092d1-0000-1000-8000-00805f9b34fb";
 //BA.debugLineNum = 31;BA.debugLine="Public CHAR_UUID_TX  As String		= \"000092d1-0000-";
_char_uuid_tx = "000092d1-0000-1000-8000-00805f9b34fb";
 //BA.debugLineNum = 35;BA.debugLine="Type TBuWizz2Status (StatusFlags As Byte, _";
;
 //BA.debugLineNum = 45;BA.debugLine="Public BuWizz2Status As TBuWizz2Status";
_buwizz2status = new b4j.example.buwizz2controller._tbuwizz2status();
 //BA.debugLineNum = 48;BA.debugLine="Public PORT_0 As Byte = 0";
_port_0 = (byte) (0);
 //BA.debugLineNum = 49;BA.debugLine="Public PORT_1 As Byte = 1";
_port_1 = (byte) (1);
 //BA.debugLineNum = 50;BA.debugLine="Public PORT_2 As Byte = 2";
_port_2 = (byte) (2);
 //BA.debugLineNum = 51;BA.debugLine="Public PORT_3 As Byte = 3";
_port_3 = (byte) (3);
 //BA.debugLineNum = 55;BA.debugLine="Private OUTPUT_LEVEL_DEFAULT As Byte = 1";
_output_level_default = (byte) (1);
 //BA.debugLineNum = 58;BA.debugLine="Public CMD_OUTPUT_LEVEL As Byte = 0x11";
_cmd_output_level = (byte) (((int)0x11));
 //BA.debugLineNum = 59;BA.debugLine="Public CMD_POWER_LEVEL As Byte = 0x10";
_cmd_power_level = (byte) (((int)0x10));
 //BA.debugLineNum = 62;BA.debugLine="Public POWER_LEVEL_FULL_BACKWARDS As Int = -127";
_power_level_full_backwards = (int) (-127);
 //BA.debugLineNum = 63;BA.debugLine="Public POWER_LEVEL_STOP As Int = 0";
_power_level_stop = (int) (0);
 //BA.debugLineNum = 64;BA.debugLine="Public POWER_LEVEL_FULL_FORWARDS As Int = 127";
_power_level_full_forwards = (int) (127);
 //BA.debugLineNum = 67;BA.debugLine="Public SPEED_OFFSET As Int = 51";
_speed_offset = (int) (51);
 //BA.debugLineNum = 68;BA.debugLine="Public SPEED_MIN As Int = 0	'51";
_speed_min = (int) (0);
 //BA.debugLineNum = 69;BA.debugLine="Public SPEED_MAX As Int = 127	'100";
_speed_max = (int) (127);
 //BA.debugLineNum = 70;BA.debugLine="Public DIRECTION_STP As Int = 0";
_direction_stp = (int) (0);
 //BA.debugLineNum = 71;BA.debugLine="Public DIRECTION_FWD As Int = 1";
_direction_fwd = (int) (1);
 //BA.debugLineNum = 72;BA.debugLine="Public DIRECTION_BCK As Int = 2";
_direction_bck = (int) (2);
 //BA.debugLineNum = 75;BA.debugLine="Private mMainpage As B4XMainPage";
_mmainpage = new b4j.example.b4xmainpage();
 //BA.debugLineNum = 78;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public float  _getbatteryvoltage(byte[] _data) throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Public Sub GetBatteryVoltage(data() As Byte) As Fl";
 //BA.debugLineNum = 134;BA.debugLine="ParseNotification(data)";
_parsenotification(_data);
 //BA.debugLineNum = 135;BA.debugLine="Return BuWizz2Status.BatteryVoltage";
if (true) return _buwizz2status.BatteryVoltage /*float*/ ;
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,b4j.example.b4xmainpage _mainpage) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 82;BA.debugLine="Public Sub Initialize(mainpage As B4XMainPage)";
 //BA.debugLineNum = 83;BA.debugLine="mMainpage = mainpage";
_mmainpage = _mainpage;
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public boolean  _parsenotification(byte[] _data) throws Exception{
 //BA.debugLineNum = 173;BA.debugLine="Public Sub ParseNotification(data() As Byte) As Bo";
 //BA.debugLineNum = 174;BA.debugLine="If Logging Then Log($\"[ParseNotification] Data re";
if (_logging) { 
__c.LogImpl("23080193",("[ParseNotification] Data received bytes="+__c.SmartStringFormatter("",(Object)(_data.length))+",hex="+__c.SmartStringFormatter("",(Object)(_bc.HexFromBytes(_data)))+""),0);};
 //BA.debugLineNum = 177;BA.debugLine="If data.Length <> 20 Then";
if (_data.length!=20) { 
 //BA.debugLineNum = 178;BA.debugLine="Log(\"$[ParseNotification] Invalid data received.";
__c.LogImpl("23080197","$[ParseNotification] Invalid data received. Expected 40 bytes. Got ${data.length}",0);
 //BA.debugLineNum = 179;BA.debugLine="Return False ' Sanity check";
if (true) return __c.False;
 };
 //BA.debugLineNum = 183;BA.debugLine="If data(0) <> 0x00 Then";
if (_data[(int) (0)]!=((int)0x00)) { 
 //BA.debugLineNum = 184;BA.debugLine="Log(\"$[ParseNotification] Unexpected command byt";
__c.LogImpl("23080203","$[ParseNotification] Unexpected command byte: ${bc.HexFromBytes(Array As Byte(data(0)))}",0);
 //BA.debugLineNum = 185;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 190;BA.debugLine="BuWizz2Status.StatusFlags = data(1)";
_buwizz2status.StatusFlags /*byte*/  = _data[(int) (1)];
 //BA.debugLineNum = 193;BA.debugLine="BuWizz2Status.BatteryVoltage = 3 + (data(2).As(In";
_buwizz2status.BatteryVoltage /*float*/  = (float) (3+(((int) (_data[(int) (2)]))*0.01));
 //BA.debugLineNum = 194;BA.debugLine="If Logging Then Log(\"$[ParseNotification] Battery";
if (_logging) { 
__c.LogImpl("23080213","$[ParseNotification] BatteryVoltage=${BuWizz2Status.BatteryVoltage}V,hex=${bc.HexFromBytes(Array As Byte(data(2)))}",0);};
 //BA.debugLineNum = 232;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return false;
}
public String  _setoutputlevel() throws Exception{
byte[] _cmd = null;
 //BA.debugLineNum = 92;BA.debugLine="Public Sub SetOutputLevel";
 //BA.debugLineNum = 93;BA.debugLine="Dim cmd() As Byte = Array As Byte(CMD_OUTPUT_LEVE";
_cmd = new byte[]{_cmd_output_level,_output_level_default};
 //BA.debugLineNum = 94;BA.debugLine="If Logging Then";
if (_logging) { 
 //BA.debugLineNum = 95;BA.debugLine="Log($\"[SetOutputLevel] cmd=${Convert.HexFromByte";
__c.LogImpl("22818051",("[SetOutputLevel] cmd="+__c.SmartStringFormatter("",(Object)(_convert._hexfrombytes /*String*/ (_cmd)))+", level="+__c.SmartStringFormatter("",(Object)(_cmd_output_level))+", leveldefault="+__c.SmartStringFormatter("",(Object)(_output_level_default))+""),0);
 };
 //BA.debugLineNum = 97;BA.debugLine="mMainpage.Write(cmd)";
_mmainpage._write /*String*/ (_cmd);
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public String  _setpowerlevel(byte _port,int _level) throws Exception{
byte[] _cmd = null;
 //BA.debugLineNum = 110;BA.debugLine="Public Sub SetPowerLevel(port As Byte, level As In";
 //BA.debugLineNum = 112;BA.debugLine="SetOutputLevel";
_setoutputlevel();
 //BA.debugLineNum = 115;BA.debugLine="Dim cmd() As Byte = Array As Byte(CMD_POWER_LEVEL";
_cmd = new byte[]{_cmd_power_level,(byte) (0),(byte) (0),(byte) (0),(byte) (0),(byte) (((int)0x00))};
 //BA.debugLineNum = 116;BA.debugLine="If Logging Then";
if (_logging) { 
 //BA.debugLineNum = 117;BA.debugLine="Log($\"[SetPowerLevel] cmd=${Convert.HexFromBytes";
__c.LogImpl("22883591",("[SetPowerLevel] cmd="+__c.SmartStringFormatter("",(Object)(_convert._hexfrombytes /*String*/ (_cmd)))+", port="+__c.SmartStringFormatter("",(Object)(_port))+", level="+__c.SmartStringFormatter("",(Object)(_level))+""),0);
 };
 //BA.debugLineNum = 121;BA.debugLine="cmd(1 + port) = level";
_cmd[(int) (1+_port)] = (byte) (_level);
 //BA.debugLineNum = 123;BA.debugLine="mMainpage.Write(cmd)";
_mmainpage._write /*String*/ (_cmd);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _stop(byte _port) throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub Stop(port As Byte)";
 //BA.debugLineNum = 128;BA.debugLine="SetPowerLevel(port, POWER_LEVEL_STOP)";
_setpowerlevel(_port,_power_level_stop);
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public String  _testparsenotification() throws Exception{
byte[] _testdata = null;
 //BA.debugLineNum = 236;BA.debugLine="Private Sub TestParseNotification	'ignore";
 //BA.debugLineNum = 237;BA.debugLine="Dim testData() As Byte = Array As Byte( _";
_testdata = new byte[]{(byte) (((int)0x00)),(byte) (((int)0x01)),(byte) (((int)0xc8)),(byte) (((int)0x32)),(byte) (((int)0x10)),(byte) (((int)0x11)),(byte) (((int)0x12)),(byte) (((int)0x13)),(byte) (((int)0x64)),(byte) (((int)0x1e)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00)),(byte) (((int)0x00))};
 //BA.debugLineNum = 239;BA.debugLine="ParseNotification(testData)";
_parsenotification(_testdata);
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
