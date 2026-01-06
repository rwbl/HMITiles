#include "B4RDefines.h"

Byte b4r_main::_cmd_led_off;
Byte b4r_main::_cmd_led_on;
Byte b4r_main::_cmd_led_blink;
Byte b4r_main::_state_ok;
Byte b4r_main::_state_error;
B4R::Serial* b4r_main::_serial1;
B4R::AsyncStreams* b4r_main::_astream;
Byte b4r_main::_data_length;
B4R::Pin* b4r_main::_led1pin;
Byte b4r_main::_led1pinnumber;
B4R::Timer* b4r_main::_blinktimer;
ULong b4r_main::_blinktimerinterval;
static B4R::Serial be_gann6_3;
static B4R::AsyncStreams be_gann7_3;
static B4R::Pin be_gann9_3;
static B4R::Timer be_gann11_3;


 void b4r_main::_appstart(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 43;BA.debugLine="Private Sub AppStart";
 //BA.debugLineNum = 44;BA.debugLine="Serial1.Initialize(115200)";
b4r_main::_serial1->Initialize((ULong) (115200));
 //BA.debugLineNum = 45;BA.debugLine="AStream.Initialize(Serial1.Stream, \"AStream_NewDa";
b4r_main::_astream->Initialize(b4r_main::_serial1->getStream(),_astream_newdata,_astream_error);
 //BA.debugLineNum = 46;BA.debugLine="LED1Pin.Initialize(LED1PinNumber, LED1Pin.MODE_OU";
b4r_main::_led1pin->Initialize(b4r_main::_led1pinnumber,Pin_MODE_OUTPUT);
 //BA.debugLineNum = 47;BA.debugLine="BlinkTimer.Initialize(\"BlinkTimer_Tick\", BlinkTim";
b4r_main::_blinktimer->Initialize(_blinktimer_tick,(ULong) (b4r_main::_blinktimerinterval*1000));
 //BA.debugLineNum = 48;BA.debugLine="BlinkTimer.Enabled = False";
b4r_main::_blinktimer->setEnabled(Common_False);
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_astream_error(){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann54_9e1[1];
B4R::Array be_ann54_9e2;
 //BA.debugLineNum = 99;BA.debugLine="Private Sub AStream_Error";
 //BA.debugLineNum = 100;BA.debugLine="AStream.Write(Array As Byte(STATE_ERROR))";
b4r_main::_astream->Write(be_ann54_9e2.create(be_ann54_9e1,1,1,b4r_main::_state_error));
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_astream_newdata(B4R::Array* _buffer){
const UInt cp = B4R::StackMemory::cp;
Byte _cmd = 0;
B4R::Object be_ann37_1;
B4R::Object be_ann38_1;
B4R::Object be_ann41_1;
B4R::Object be_ann44_1;
Byte be_ann48_9e1[1];
B4R::Array be_ann48_9e2;
Byte be_ann50_9e1[1];
B4R::Array be_ann50_9e2;
 //BA.debugLineNum = 73;BA.debugLine="Private Sub AStream_NewData(Buffer() As Byte)";
 //BA.debugLineNum = 75;BA.debugLine="Dim cmd As Byte";
_cmd = 0;
 //BA.debugLineNum = 77;BA.debugLine="If Buffer.Length == DATA_LENGTH Then";
if (_buffer->length==b4r_main::_data_length) { 
 //BA.debugLineNum = 78;BA.debugLine="cmd = Buffer(0)";
_cmd = ((Byte*)_buffer->getData((UInt) (0)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 79;BA.debugLine="Select cmd";
switch (B4R::BR::switchObjectToInt(4,be_ann37_1.wrapNumber((Long)_cmd),be_ann38_1.wrapNumber((Long)b4r_main::_cmd_led_off),be_ann41_1.wrapNumber((Long)b4r_main::_cmd_led_on),be_ann44_1.wrapNumber((Long)b4r_main::_cmd_led_blink))) {
case 0: {
 //BA.debugLineNum = 81;BA.debugLine="BlinkTimer.Enabled = False";
b4r_main::_blinktimer->setEnabled(Common_False);
 //BA.debugLineNum = 82;BA.debugLine="LED1Pin.DigitalWrite(False)";
b4r_main::_led1pin->DigitalWrite(Common_False);
 break; }
case 1: {
 //BA.debugLineNum = 84;BA.debugLine="BlinkTimer.Enabled = False";
b4r_main::_blinktimer->setEnabled(Common_False);
 //BA.debugLineNum = 85;BA.debugLine="LED1Pin.DigitalWrite(True)";
b4r_main::_led1pin->DigitalWrite(Common_True);
 break; }
case 2: {
 //BA.debugLineNum = 87;BA.debugLine="BlinkTimer.Enabled = True";
b4r_main::_blinktimer->setEnabled(Common_True);
 //BA.debugLineNum = 88;BA.debugLine="LED1Pin.DigitalWrite(False)";
b4r_main::_led1pin->DigitalWrite(Common_False);
 break; }
}
;
 //BA.debugLineNum = 90;BA.debugLine="AStream.Write(Array As Byte(cmd))";
b4r_main::_astream->Write(be_ann48_9e2.create(be_ann48_9e1,1,1,_cmd));
 }else {
 //BA.debugLineNum = 93;BA.debugLine="AStream.Write(Array As Byte(STATE_ERROR))";
b4r_main::_astream->Write(be_ann50_9e2.create(be_ann50_9e1,1,1,b4r_main::_state_error));
 };
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_blinktimer_tick(){
const UInt cp = B4R::StackMemory::cp;
bool _currentstate = false;
bool _newstate = false;
Byte _state = 0;
Byte be_ann31_9e1[1];
B4R::Array be_ann31_9e2;
 //BA.debugLineNum = 52;BA.debugLine="Private Sub BlinkTimer_Tick";
 //BA.debugLineNum = 54;BA.debugLine="Dim currentState As Boolean = LED1Pin.DigitalRead";
_currentstate = b4r_main::_led1pin->DigitalRead();
 //BA.debugLineNum = 56;BA.debugLine="Dim NewState As Boolean = Not(currentState)";
_newstate = Common_Not(_currentstate);
 //BA.debugLineNum = 58;BA.debugLine="LED1Pin.DigitalWrite(Not(LED1Pin.DigitalRead))";
b4r_main::_led1pin->DigitalWrite(Common_Not(b4r_main::_led1pin->DigitalRead()));
 //BA.debugLineNum = 60;BA.debugLine="Dim state As Byte";
_state = 0;
 //BA.debugLineNum = 61;BA.debugLine="If LED1Pin.DigitalRead Then";
if (b4r_main::_led1pin->DigitalRead()) { 
 //BA.debugLineNum = 62;BA.debugLine="state = CMD_LED_ON";
_state = b4r_main::_cmd_led_on;
 }else {
 //BA.debugLineNum = 64;BA.debugLine="state = CMD_LED_OFF";
_state = b4r_main::_cmd_led_off;
 };
 //BA.debugLineNum = 66;BA.debugLine="AStream.Write(Array As Byte(state))";
b4r_main::_astream->Write(be_ann31_9e2.create(be_ann31_9e1,1,1,_state));
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}

void b4r_main::initializeProcessGlobals() {
     B4R::StackMemory::buffer = (byte*)malloc(STACK_BUFFER_SIZE);
     b4r_main::_process_globals();

   
}
void b4r_main::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 26;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 27;BA.debugLine="Private CMD_LED_OFF As Byte 	= 0x00";
b4r_main::_cmd_led_off = (Byte) (((Int)0x00));
 //BA.debugLineNum = 28;BA.debugLine="Private CMD_LED_ON As Byte		= 0x01";
b4r_main::_cmd_led_on = (Byte) (((Int)0x01));
 //BA.debugLineNum = 29;BA.debugLine="Private CMD_LED_BLINK As Byte 	= 0x02";
b4r_main::_cmd_led_blink = (Byte) (((Int)0x02));
 //BA.debugLineNum = 30;BA.debugLine="Private STATE_OK As Byte 		= 0x00		'ignore";
b4r_main::_state_ok = (Byte) (((Int)0x00));
 //BA.debugLineNum = 31;BA.debugLine="Private STATE_ERROR As Byte 	= 0xFF";
b4r_main::_state_error = (Byte) (((Int)0xff));
 //BA.debugLineNum = 33;BA.debugLine="Public Serial1 As Serial					' Serial line 1 conn";
b4r_main::_serial1 = &be_gann6_3;
 //BA.debugLineNum = 34;BA.debugLine="Private AStream As AsyncStreams				' ASyncstream";
b4r_main::_astream = &be_gann7_3;
 //BA.debugLineNum = 35;BA.debugLine="Private DATA_LENGTH As Byte = 1				' Received dat";
b4r_main::_data_length = (Byte) (1);
 //BA.debugLineNum = 36;BA.debugLine="Private LED1Pin As Pin						' Output pin which ha";
b4r_main::_led1pin = &be_gann9_3;
 //BA.debugLineNum = 37;BA.debugLine="Private LED1PinNumber As Byte = 0x0D		' Pin numbe";
b4r_main::_led1pinnumber = (Byte) (((Int)0x0d));
 //BA.debugLineNum = 39;BA.debugLine="Private BlinkTimer As Timer					' Timer for th";
b4r_main::_blinktimer = &be_gann11_3;
 //BA.debugLineNum = 40;BA.debugLine="Private BlinkTimerInterval As ULong	= 1		' Tim";
b4r_main::_blinktimerinterval = (ULong) (1);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
}
