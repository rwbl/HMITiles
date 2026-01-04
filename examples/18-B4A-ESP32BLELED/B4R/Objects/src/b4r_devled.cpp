#include "B4RDefines.h"

B4R::Pin* b4r_devled::_led;
b4r_main* b4r_devled::_main;
b4r_commble* b4r_devled::_commble;
b4r_convert* b4r_devled::_convert;
static B4R::Pin be_gann1_3;


 bool b4r_devled::_get(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 37;BA.debugLine="Public Sub Get As Boolean";
 //BA.debugLineNum = 38;BA.debugLine="Return Led.DigitalRead";
B4R::StackMemory::cp = cp;
bool res1 = b4r_devled::_led->DigitalRead();
if (true) return res1;
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
void b4r_devled::_initialize(Byte _pinnr){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize(pinnr As Byte)";
 //BA.debugLineNum = 22;BA.debugLine="Led.Initialize(pinnr, Led.MODE_OUTPUT)";
b4r_devled::_led->Initialize(_pinnr,Pin_MODE_OUTPUT);
 //BA.debugLineNum = 23;BA.debugLine="Led.DigitalWrite(False)";
b4r_devled::_led->DigitalWrite(Common_False);
 //BA.debugLineNum = 24;BA.debugLine="Log(\"[DevLED.Initialize][I] OK, pin=\", pinnr)";
B4R::Common::LogHelper(2,102,F("[DevLED.Initialize][I] OK, pin="),1,_pinnr);
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_devled::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 13;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 14;BA.debugLine="Private Led As Pin";
b4r_devled::_led = &be_gann1_3;
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
}
void b4r_devled::_processble(B4R::Array* _payload){
const UInt cp = B4R::StackMemory::cp;
Byte _command = 0;
B4R::Object be_ann25_1;
B4R::Object be_ann26_3;
B4R::Object be_ann30_3;
Byte _value = 0;
B4R::Object be_ann28_11;
B4R::Object be_ann28_15;
B4R::Object be_ann31_9;
B4R::Object be_ann31_11;
Byte _state = 0;
 //BA.debugLineNum = 88;BA.debugLine="Public Sub ProcessBLE(payload() As Byte)";
 //BA.debugLineNum = 89;BA.debugLine="Log(\"[DevLED.ProcessBLE] payload=\", Convert.Bytes";
B4R::Common::LogHelper(2,102,F("[DevLED.ProcessBLE] payload="),101,b4r_devled::_convert->_bytestohex /*B4R::B4RString**/ (_payload)->data);
 //BA.debugLineNum = 91;BA.debugLine="Dim command As Byte = payload(1)";
_command = ((Byte*)_payload->getData((UInt) (1)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 92;BA.debugLine="Select command";
switch (B4R::BR::switchObjectToInt(3,be_ann25_1.wrapNumber((Long)_command),be_ann26_3.wrapNumber((Long)b4r_devled::_commble->_cmd_set_state /*Byte*/ ),be_ann30_3.wrapNumber((Long)b4r_devled::_commble->_cmd_get_state /*Byte*/ ))) {
case 0: {
 //BA.debugLineNum = 94;BA.debugLine="Dim value As Byte = payload(2)";
_value = ((Byte*)_payload->getData((UInt) (2)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 95;BA.debugLine="Set(IIf(value == 1, True, False))";
_set((bool)(((_value==1) ? (be_ann28_11.wrapNumber((Long)Common_True)) : (be_ann28_15.wrapNumber((Long)Common_False)))->toLong()));
 //BA.debugLineNum = 96;BA.debugLine="WriteToBLE(command, value)";
_writetoble(_command,_value);
 break; }
case 1: {
 //BA.debugLineNum = 98;BA.debugLine="Dim state As Byte = IIf(Get, 1, 0)";
_state = (Byte)(((_get()) ? (be_ann31_9.wrapNumber((Long)1)) : (be_ann31_11.wrapNumber((Long)0)))->toLong());
 //BA.debugLineNum = 99;BA.debugLine="WriteToBLE(command, state)";
_writetoble(_command,_state);
 break; }
}
;
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_devled::_set(bool _state){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 45;BA.debugLine="Public Sub Set(state As Boolean)";
 //BA.debugLineNum = 46;BA.debugLine="Led.DigitalWrite(state)";
b4r_devled::_led->DigitalWrite(_state);
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_devled::_setpwm(UInt _value){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 53;BA.debugLine="Public Sub SetPWM(value As UInt)";
 //BA.debugLineNum = 54;BA.debugLine="Led.AnalogWrite(value)";
b4r_devled::_led->AnalogWrite(_value);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_devled::_toggle(){
const UInt cp = B4R::StackMemory::cp;
bool _newstate = false;
 //BA.debugLineNum = 59;BA.debugLine="Public Sub Toggle()";
 //BA.debugLineNum = 60;BA.debugLine="Dim newstate As Boolean = Not(Get)";
_newstate = Common_Not(_get());
 //BA.debugLineNum = 61;BA.debugLine="Set(newstate)";
_set(_newstate);
 //BA.debugLineNum = 62;BA.debugLine="Log(\"[DevLED.Toggle][I] newstate=\", newstate)";
B4R::Common::LogHelper(2,102,F("[DevLED.Toggle][I] newstate="),8,_newstate);
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_devled::_writetoble(Byte _command,Byte _state){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann36_19e1[3];
B4R::Array be_ann36_19e2;
B4R::Array* _payload = NULL;
 //BA.debugLineNum = 107;BA.debugLine="Public Sub WriteToBLE(command As Byte, state As By";
 //BA.debugLineNum = 108;BA.debugLine="Dim payload() As Byte = Array As Byte(CommBLE.DEV";
_payload = be_ann36_19e2.create(be_ann36_19e1,3,1,b4r_devled::_commble->_dev_led /*Byte*/ ,_command,_state);
 //BA.debugLineNum = 109;BA.debugLine="CommBLE.BLEServer_Write(payload)";
b4r_devled::_commble->_bleserver_write /*void*/ (_payload);
 //BA.debugLineNum = 110;BA.debugLine="Log(\"[DevLED.WriteToBLE] payload=\", Convert.Bytes";
B4R::Common::LogHelper(2,102,F("[DevLED.WriteToBLE] payload="),101,b4r_devled::_convert->_bytestohex /*B4R::B4RString**/ (_payload)->data);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
