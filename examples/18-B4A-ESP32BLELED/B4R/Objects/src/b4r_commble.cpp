#include "B4RDefines.h"

Byte b4r_commble::_dev_led;
Byte b4r_commble::_dev_system;
Byte b4r_commble::_cmd_set_state;
Byte b4r_commble::_cmd_get_state;
Byte b4r_commble::_cmd_set_color;
Byte b4r_commble::_cmd_get_color;
Byte b4r_commble::_cmd_set_value;
Byte b4r_commble::_cmd_get_value;
Byte b4r_commble::_cmd_custom_action;
B4R::B4RString* b4r_commble::_ble_server_name;
B4R::B4RBLEServer* b4r_commble::_bleserver;
UInt b4r_commble::_mtusize;
b4r_main* b4r_commble::_main;
b4r_devled* b4r_commble::_devled;
b4r_convert* b4r_commble::_convert;
static B4R::B4RString be_gann10_5;
static B4R::B4RBLEServer be_gann11_3;


 void b4r_commble::_bledispatch(B4R::Array* _payload){
const UInt cp = B4R::StackMemory::cp;
Byte _deviceid = 0;
B4R::Object be_ann46_1;
B4R::Object be_ann47_1;
B4R::Object be_ann48_1;
B4R::Object be_ann50_1;
 //BA.debugLineNum = 91;BA.debugLine="Private Sub BLEDispatch(payload() As Byte)";
 //BA.debugLineNum = 93;BA.debugLine="Dim deviceid As Byte = payload(0)";
_deviceid = ((Byte*)_payload->getData((UInt) (0)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 95;BA.debugLine="Log(\"[CommBLE.BLEDispatch] deviceid=\",deviceid)";
B4R::Common::LogHelper(2,102,F("[CommBLE.BLEDispatch] deviceid="),1,_deviceid);
 //BA.debugLineNum = 96;BA.debugLine="Select deviceid";
switch (B4R::BR::switchObjectToInt(4,be_ann46_1.wrapNumber((Long)_deviceid),be_ann47_1.wrapNumber((Long)0),be_ann48_1.wrapNumber((Long)b4r_commble::_dev_led),be_ann50_1.wrapNumber((Long)b4r_commble::_dev_system))) {
case 0: {
 break; }
case 1: {
 //BA.debugLineNum = 100;BA.debugLine="DevLED.ProcessBLE(payload)";
b4r_commble::_devled->_processble /*void*/ (_payload);
 break; }
case 2: {
 break; }
default: {
 break; }
}
;
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commble::_bleserver_error(Byte _code){
const UInt cp = B4R::StackMemory::cp;
B4R::Object be_ann26_1;
B4R::Object be_ann27_3;
B4R::Object be_ann29_3;
B4R::Object be_ann31_3;
 //BA.debugLineNum = 61;BA.debugLine="Private Sub BLEServer_Error(code As Byte)";
 //BA.debugLineNum = 62;BA.debugLine="Log(\"[CommBLE.BLEServer_Error] code=\",code)";
B4R::Common::LogHelper(2,102,F("[CommBLE.BLEServer_Error] code="),1,_code);
 //BA.debugLineNum = 63;BA.debugLine="Select code";
switch (B4R::BR::switchObjectToInt(4,be_ann26_1.wrapNumber((Long)_code),be_ann27_3.wrapNumber((Long)b4r_commble::_bleserver->WARNING_INVALID_MTU),be_ann29_3.wrapNumber((Long)b4r_commble::_bleserver->ERROR_INVALID_CHARACTERISTIC),be_ann31_3.wrapNumber((Long)b4r_commble::_bleserver->ERROR_EMPTY_DATA))) {
case 0: {
 //BA.debugLineNum = 65;BA.debugLine="Log(\"[CommBLE.BLEServer_Error][WARNING] Initial";
B4R::Common::LogHelper(1,102,F("[CommBLE.BLEServer_Error][WARNING] Initialize MTU out of range 23-512, default is set (23)."));
 break; }
case 1: {
 //BA.debugLineNum = 67;BA.debugLine="Log(\"[CommBLE.BLEServer_Error][ERROR] Write fai";
B4R::Common::LogHelper(1,102,F("[CommBLE.BLEServer_Error][ERROR] Write failed: No valid characteristic."));
 break; }
case 2: {
 //BA.debugLineNum = 69;BA.debugLine="Log(\"[CommBLE.BLEServer_Error][ERROR] Write fai";
B4R::Common::LogHelper(1,102,F("[CommBLE.BLEServer_Error][ERROR] Write failed: No data."));
 break; }
}
;
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commble::_bleserver_newdata(B4R::Array* _buffer){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 47;BA.debugLine="Private Sub BLEServer_NewData(buffer() As Byte)";
 //BA.debugLineNum = 48;BA.debugLine="Log(\"[CommBLE.BLEServer_NewData] buffer HEX=\", Co";
B4R::Common::LogHelper(2,102,F("[CommBLE.BLEServer_NewData] buffer HEX="),101,b4r_commble::_convert->_bytestohex /*B4R::B4RString**/ (_buffer)->data);
 //BA.debugLineNum = 51;BA.debugLine="If buffer.Length < 2 Then Return";
if (_buffer->length<2) { 
B4R::StackMemory::cp = cp;
if (true) return ;};
 //BA.debugLineNum = 54;BA.debugLine="BLEDispatch(buffer)";
_bledispatch(_buffer);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commble::_bleserver_write(B4R::Array* _data){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 76;BA.debugLine="Public Sub BLEServer_Write(data() As Byte)";
 //BA.debugLineNum = 77;BA.debugLine="If data == Null Then";
if (_data== NULL) { 
 //BA.debugLineNum = 78;BA.debugLine="Log(\"[ERROR][CommBLE.BLEServer_Write] No data.\")";
B4R::Common::LogHelper(1,102,F("[ERROR][CommBLE.BLEServer_Write] No data."));
 //BA.debugLineNum = 79;BA.debugLine="Return";
B4R::StackMemory::cp = cp;
if (true) return ;
 };
 //BA.debugLineNum = 81;BA.debugLine="Log(\"[CommBLE.BLEServer_Write] data=\", Convert.By";
B4R::Common::LogHelper(2,102,F("[CommBLE.BLEServer_Write] data="),101,b4r_commble::_convert->_byteconv /*B4R::ByteConverter**/ ->HexFromBytes(_data)->data);
 //BA.debugLineNum = 82;BA.debugLine="BLEServer.Write(data)";
b4r_commble::_bleserver->Write(_data);
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commble::_initialize(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 37;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 38;BA.debugLine="Log(\"[CommBLE.Initialize]\")";
B4R::Common::LogHelper(1,102,F("[CommBLE.Initialize]"));
 //BA.debugLineNum = 39;BA.debugLine="BLEServer.Initialize(BLE_SERVER_NAME, \"BLEServer_";
b4r_commble::_bleserver->Initialize(b4r_commble::_ble_server_name,_bleserver_newdata,_bleserver_error,b4r_commble::_mtusize);
 //BA.debugLineNum = 40;BA.debugLine="Log(\"[CommBLE.Initialize] Done, mtusize=\", MTUSiz";
B4R::Common::LogHelper(2,102,F("[CommBLE.Initialize] Done, mtusize="),4,b4r_commble::_mtusize);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commble::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 14;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 17;BA.debugLine="Public DEV_LED As Byte 				= 0x01";
b4r_commble::_dev_led = (Byte) (((Int)0x01));
 //BA.debugLineNum = 18;BA.debugLine="Public DEV_SYSTEM As Byte			= 0xFF";
b4r_commble::_dev_system = (Byte) (((Int)0xff));
 //BA.debugLineNum = 21;BA.debugLine="Public CMD_SET_STATE As Byte 		= 0x01";
b4r_commble::_cmd_set_state = (Byte) (((Int)0x01));
 //BA.debugLineNum = 22;BA.debugLine="Public CMD_GET_STATE As Byte 		= 0x02";
b4r_commble::_cmd_get_state = (Byte) (((Int)0x02));
 //BA.debugLineNum = 23;BA.debugLine="Public CMD_SET_COLOR As Byte 		= 0x01";
b4r_commble::_cmd_set_color = (Byte) (((Int)0x01));
 //BA.debugLineNum = 24;BA.debugLine="Public CMD_GET_COLOR As Byte 		= 0x02";
b4r_commble::_cmd_get_color = (Byte) (((Int)0x02));
 //BA.debugLineNum = 25;BA.debugLine="Public CMD_SET_VALUE As Byte 		= 0x03";
b4r_commble::_cmd_set_value = (Byte) (((Int)0x03));
 //BA.debugLineNum = 26;BA.debugLine="Public CMD_GET_VALUE As Byte 		= 0x04";
b4r_commble::_cmd_get_value = (Byte) (((Int)0x04));
 //BA.debugLineNum = 27;BA.debugLine="Public CMD_CUSTOM_ACTION As Byte	= 0x05";
b4r_commble::_cmd_custom_action = (Byte) (((Int)0x05));
 //BA.debugLineNum = 30;BA.debugLine="Private BLE_SERVER_NAME As String 	= \"ESP32BLELED";
b4r_commble::_ble_server_name = be_gann10_5.wrap("ESP32BLELED");
 //BA.debugLineNum = 31;BA.debugLine="Private BLEServer As BLEServer						'ignore";
b4r_commble::_bleserver = &be_gann11_3;
 //BA.debugLineNum = 32;BA.debugLine="Private MTUSize As UInt = BLEServer.MTU_SIZE_MIN";
b4r_commble::_mtusize = b4r_commble::_bleserver->MTU_SIZE_MIN;
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
}
