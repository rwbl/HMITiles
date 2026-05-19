#include "B4RDefines.h"

B4R::B4RString* b4r_main::_version;
B4R::Serial* b4r_main::_serial1;
B4R::B4RNimBLEServer* b4r_main::_bleserver;
B4R::B4RESP32Servo* b4r_main::_geekservo;
B4R::Pin* b4r_main::_geekservopin;
Byte b4r_main::_geekservopinnr;
UInt b4r_main::_servoangle;
UInt b4r_main::_angle_base_pos;
UInt b4r_main::_angle_open;
UInt b4r_main::_angle_close;
B4R::Pin* b4r_main::_onboardled;
Byte b4r_main::_onboardled_pinnr;
Byte b4r_main::_frame_length;
Byte b4r_main::_frame_header;
Byte b4r_main::_frame_footer;
Byte b4r_main::_device_address;
Byte b4r_main::_cmd_set_angle;
Byte b4r_main::_val_open;
Byte b4r_main::_val_close;
b4r_convert* b4r_main::_convert;
static B4R::B4RString be_gann1_5;
static B4R::Serial be_gann2_3;
static B4R::B4RNimBLEServer be_gann3_3;
static B4R::B4RESP32Servo be_gann4_3;
static B4R::Pin be_gann5_3;
static B4R::Pin be_gann11_3;


 void b4r_main::_appstart(){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString be_ann31_4;
B4R::B4RString be_ann31_6;
B4R::B4RString be_ann31_8;
 //BA.debugLineNum = 71;BA.debugLine="Sub AppStart";
 //BA.debugLineNum = 72;BA.debugLine="Serial1.Initialize(115200)";
b4r_main::_serial1->Initialize((ULong) (115200));
 //BA.debugLineNum = 73;BA.debugLine="Log(\"[AppStart][I \", VERSION)";
B4R::Common::LogHelper(2,102,F("[AppStart][I "),101,b4r_main::_version->data);
 //BA.debugLineNum = 76;BA.debugLine="OnboardLED.Initialize(ONBOARDLED_PINNR, OnboardLE";
b4r_main::_onboardled->Initialize(b4r_main::_onboardled_pinnr,Pin_MODE_OUTPUT);
 //BA.debugLineNum = 80;BA.debugLine="GeekServoPin.Initialize (GeekServoPinNr, GeekServ";
b4r_main::_geekservopin->Initialize(b4r_main::_geekservopinnr,Pin_MODE_OUTPUT);
 //BA.debugLineNum = 82;BA.debugLine="GeekServo.Attach(GeekServoPin.PinNumber)";
b4r_main::_geekservo->Attach((Int) (b4r_main::_geekservopin->PinNumber));
 //BA.debugLineNum = 83;BA.debugLine="Delay(50)";
Common_Delay((ULong) (50));
 //BA.debugLineNum = 85;BA.debugLine="SetServoPosition(ANGLE_BASE_POS)";
_setservoposition((Byte) (b4r_main::_angle_base_pos));
 //BA.debugLineNum = 87;BA.debugLine="ServoAngle = GeekServo.Read / 100";
b4r_main::_servoangle = (UInt) (b4r_main::_geekservo->Read()/(Double)100);
 //BA.debugLineNum = 88;BA.debugLine="Log(\"[Main.AppStart][I] Init servo angle=\", Servo";
B4R::Common::LogHelper(2,102,F("[Main.AppStart][I] Init servo angle="),4,b4r_main::_servoangle);
 //BA.debugLineNum = 91;BA.debugLine="BleServer.Initialize( _         \"BLEGeekServo\"";
b4r_main::_bleserver->Initialize(be_ann31_4.wrap("BLEGeekServo"),be_ann31_6.wrap("12345678-1234-1234-1234-1234567890ab"),be_ann31_8.wrap("abcd1234-5678-1234-5678-1234567890ab"),_onconnected,_ondisconnected,_onwrite,Common_True);
 //BA.debugLineNum = 100;BA.debugLine="BleServer.Start";
b4r_main::_bleserver->Start();
 //BA.debugLineNum = 101;BA.debugLine="Log(\"[AppStart][I] Start BLE Server, waiting clie";
B4R::Common::LogHelper(1,102,F("[AppStart][I] Start BLE Server, waiting clients..."));
 //BA.debugLineNum = 102;BA.debugLine="Log(\"[AppStart][I] Done\")";
B4R::Common::LogHelper(1,102,F("[AppStart][I] Done"));
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_onconnected(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 105;BA.debugLine="Sub OnConnected";
 //BA.debugLineNum = 106;BA.debugLine="Log(\"[OnConnected][I] Client connected\")";
B4R::Common::LogHelper(1,102,F("[OnConnected][I] Client connected"));
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_ondisconnected(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 109;BA.debugLine="Sub OnDisconnected";
 //BA.debugLineNum = 110;BA.debugLine="Log(\"[OnDisconnected][W] Client disconnected\")";
B4R::Common::LogHelper(1,102,F("[OnDisconnected][W] Client disconnected"));
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_onwrite(B4R::Array* _buffer){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 114;BA.debugLine="Sub OnWrite (Buffer() As Byte)";
 //BA.debugLineNum = 115;BA.debugLine="Log(\"[OnWrite][I] RX:\", Buffer.Length, \" \", Co";
B4R::Common::LogHelper(4,102,F("[OnWrite][I] RX:"),3,_buffer->length,102,F(" "),101,b4r_main::_convert->_bytestohex /*B4R::B4RString**/ (_buffer)->data);
 //BA.debugLineNum = 116;BA.debugLine="ProcessCommand(Buffer)";
_processcommand(_buffer);
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}

void b4r_main::initializeProcessGlobals() {
     B4R::StackMemory::buffer = (byte*)malloc(STACK_BUFFER_SIZE);
     b4r_main::_process_globals();
b4r_convert::_process_globals();

   
}
void b4r_main::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 37;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 38;BA.debugLine="Private VERSION 						As String = \"BLE GeekServo";
b4r_main::_version = be_gann1_5.wrap("BLE GeekServo v2026-04-13");
 //BA.debugLineNum = 41;BA.debugLine="Public Serial1 							As Serial";
b4r_main::_serial1 = &be_gann2_3;
 //BA.debugLineNum = 42;BA.debugLine="Private BleServer 						As NimBLEServer";
b4r_main::_bleserver = &be_gann3_3;
 //BA.debugLineNum = 45;BA.debugLine="Private GeekServo 						As ESP32Servo";
b4r_main::_geekservo = &be_gann4_3;
 //BA.debugLineNum = 46;BA.debugLine="Private GeekServoPin 					As Pin";
b4r_main::_geekservopin = &be_gann5_3;
 //BA.debugLineNum = 47;BA.debugLine="Private GeekServoPinNr 					As Byte = 4";
b4r_main::_geekservopinnr = (Byte) (4);
 //BA.debugLineNum = 48;BA.debugLine="Private ServoAngle 						As UInt";
b4r_main::_servoangle = 0;
 //BA.debugLineNum = 49;BA.debugLine="Private ANGLE_BASE_POS					As UInt = 90";
b4r_main::_angle_base_pos = (UInt) (90);
 //BA.debugLineNum = 50;BA.debugLine="Private ANGLE_OPEN						As UInt = 90";
b4r_main::_angle_open = (UInt) (90);
 //BA.debugLineNum = 51;BA.debugLine="Private ANGLE_CLOSE						As UInt = 135";
b4r_main::_angle_close = (UInt) (135);
 //BA.debugLineNum = 54;BA.debugLine="Private OnboardLED 						As Pin";
b4r_main::_onboardled = &be_gann11_3;
 //BA.debugLineNum = 55;BA.debugLine="Private ONBOARDLED_PINNR 				As Byte = 2";
b4r_main::_onboardled_pinnr = (Byte) (2);
 //BA.debugLineNum = 59;BA.debugLine="Public FRAME_LENGTH 					As Byte	= 5";
b4r_main::_frame_length = (Byte) (5);
 //BA.debugLineNum = 60;BA.debugLine="Public FRAME_HEADER 					As Byte = 0x19";
b4r_main::_frame_header = (Byte) (((Int)0x19));
 //BA.debugLineNum = 61;BA.debugLine="Public FRAME_FOOTER 					As Byte = 0x58";
b4r_main::_frame_footer = (Byte) (((Int)0x58));
 //BA.debugLineNum = 63;BA.debugLine="Public DEVICE_ADDRESS					As Byte = 0x12";
b4r_main::_device_address = (Byte) (((Int)0x12));
 //BA.debugLineNum = 65;BA.debugLine="Public Const CMD_SET_ANGLE				As Byte = 0x05";
b4r_main::_cmd_set_angle = (Byte) (((Int)0x05));
 //BA.debugLineNum = 67;BA.debugLine="Public Const VAL_OPEN       			As Byte = 0x00";
b4r_main::_val_open = (Byte) (((Int)0x00));
 //BA.debugLineNum = 68;BA.debugLine="Public Const VAL_CLOSE  				As Byte = 0x01";
b4r_main::_val_close = (Byte) (((Int)0x01));
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
}
void b4r_main::_processcommand(B4R::Array* _command){
const UInt cp = B4R::StackMemory::cp;
Byte _addr = 0;
Byte _cmd = 0;
Byte _val = 0;
B4R::Object be_ann58_1;
B4R::Object be_ann59_1;
B4R::Object be_ann61_1;
 //BA.debugLineNum = 120;BA.debugLine="Private Sub ProcessCommand(command() As Byte)";
 //BA.debugLineNum = 122;BA.debugLine="Private addr, cmd, val As Byte";
_addr = 0;
_cmd = 0;
_val = 0;
 //BA.debugLineNum = 125;BA.debugLine="If command.Length < FRAME_LENGTH Then";
if (_command->length<b4r_main::_frame_length) { 
 //BA.debugLineNum = 126;BA.debugLine="Log(\"[ProcessCommand][E] Invalid frame length. E";
B4R::Common::LogHelper(1,102,F("[ProcessCommand][E] Invalid frame length. Expect 5 bytes."));
 };
 //BA.debugLineNum = 130;BA.debugLine="If command(0) == FRAME_HEADER And command(command";
if (((Byte*)_command->getData((UInt) (0)))[B4R::Array::staticIndex]==b4r_main::_frame_header && ((Byte*)_command->getData((UInt) (_command->length-1)))[B4R::Array::staticIndex]==b4r_main::_frame_footer) { 
 //BA.debugLineNum = 132;BA.debugLine="addr = command(1)";
_addr = ((Byte*)_command->getData((UInt) (1)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 133;BA.debugLine="cmd = command(2)";
_cmd = ((Byte*)_command->getData((UInt) (2)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 134;BA.debugLine="val = command(3)";
_val = ((Byte*)_command->getData((UInt) (3)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 136;BA.debugLine="Log(\"[ProcessCommand][I] addr=\", Convert.ByteToH";
B4R::Common::LogHelper(6,102,F("[ProcessCommand][I] addr="),101,b4r_main::_convert->_bytetohex /*B4R::B4RString**/ (_addr)->data,102,F(" cmd="),101,b4r_main::_convert->_bytetohex /*B4R::B4RString**/ (_cmd)->data,102,F(" val="),101,b4r_main::_convert->_bytetohex /*B4R::B4RString**/ (_val)->data);
 //BA.debugLineNum = 139;BA.debugLine="If addr == DEVICE_ADDRESS Then";
if (_addr==b4r_main::_device_address) { 
 //BA.debugLineNum = 141;BA.debugLine="If cmd == CMD_SET_ANGLE Then";
if (_cmd==b4r_main::_cmd_set_angle) { 
 //BA.debugLineNum = 143;BA.debugLine="Select val";
switch (B4R::BR::switchObjectToInt(3,be_ann58_1.wrapNumber((Long)_val),be_ann59_1.wrapNumber((Long)b4r_main::_val_open),be_ann61_1.wrapNumber((Long)b4r_main::_val_close))) {
case 0: {
 //BA.debugLineNum = 145;BA.debugLine="SetServoPosition(ANGLE_OPEN)";
_setservoposition((Byte) (b4r_main::_angle_open));
 break; }
case 1: {
 //BA.debugLineNum = 147;BA.debugLine="SetServoPosition(ANGLE_CLOSE)";
_setservoposition((Byte) (b4r_main::_angle_close));
 break; }
default: {
 //BA.debugLineNum = 149;BA.debugLine="If val >= ANGLE_OPEN And val <= ANGLE_CLOSE";
if (_val>=b4r_main::_angle_open && _val<=b4r_main::_angle_close) { 
 //BA.debugLineNum = 150;BA.debugLine="SetServoPosition(val)";
_setservoposition(_val);
 };
 break; }
}
;
 };
 }else {
 //BA.debugLineNum = 155;BA.debugLine="Log(\"[ProcessCommand][E] Address not found \", C";
B4R::Common::LogHelper(4,102,F("[ProcessCommand][E] Address not found "),101,b4r_main::_convert->_bytetohex /*B4R::B4RString**/ (_addr)->data,102,F(" expect "),1,b4r_main::_device_address);
 };
 };
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_setservoposition(Byte _angle){
const UInt cp = B4R::StackMemory::cp;
B4R::Object be_ann77_13;
B4R::Object be_ann77_17;
 //BA.debugLineNum = 163;BA.debugLine="Public Sub SetServoPosition(angle As Byte)";
 //BA.debugLineNum = 164;BA.debugLine="Log(\"[SetServoPosition][I] angle=\", angle)";
B4R::Common::LogHelper(2,102,F("[SetServoPosition][I] angle="),1,_angle);
 //BA.debugLineNum = 165;BA.debugLine="GeekServo.Write(angle.As(UInt))";
b4r_main::_geekservo->Write((Int) (((UInt) (_angle))));
 //BA.debugLineNum = 166;BA.debugLine="OnboardLED.DigitalWrite(IIf(angle <= ANGLE_OPEN,";
b4r_main::_onboardled->DigitalWrite((bool)(((_angle<=b4r_main::_angle_open) ? (be_ann77_13.wrapNumber((Long)Common_False)) : (be_ann77_17.wrapNumber((Long)Common_True)))->toLong()));
 //BA.debugLineNum = 167;BA.debugLine="Delay(50)";
Common_Delay((ULong) (50));
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
