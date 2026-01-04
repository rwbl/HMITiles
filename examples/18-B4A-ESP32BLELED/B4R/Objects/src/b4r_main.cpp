#include "B4RDefines.h"

B4R::B4RString* b4r_main::_app_version;
B4R::B4RString* b4r_main::_app_name;
B4R::Serial* b4r_main::_serialline;
b4r_commble* b4r_main::_commble;
b4r_devled* b4r_main::_devled;
b4r_convert* b4r_main::_convert;
static B4R::B4RString be_gann1_5;
static B4R::B4RString be_gann2_5;
static B4R::Serial be_gann3_3;


 void b4r_main::_appstart(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 51;BA.debugLine="Private Sub AppStart";
 //BA.debugLineNum = 52;BA.debugLine="SerialLine.Initialize(115200)";
b4r_main::_serialline->Initialize((ULong) (115200));
 //BA.debugLineNum = 53;BA.debugLine="Log(CRLF, \"[Main.AppStart][I]\", APP_NAME, \"][I] S";
B4R::Common::LogHelper(5,102,F(Common_CRLF),102,F("[Main.AppStart][I]"),101,b4r_main::_app_name->data,102,F("][I] Starting "),101,b4r_main::_app_version->data);
 //BA.debugLineNum = 55;BA.debugLine="DevLED.Initialize(0x05)";
b4r_main::_devled->_initialize /*void*/ ((Byte) (((Int)0x05)));
 //BA.debugLineNum = 56;BA.debugLine="DevLED.Set(False)";
b4r_main::_devled->_set /*void*/ (Common_False);
 //BA.debugLineNum = 58;BA.debugLine="Log(CRLF, \"[Main.AppStart][I] Communication backe";
B4R::Common::LogHelper(2,102,F(Common_CRLF),102,F("[Main.AppStart][I] Communication backend: BLE"));
 //BA.debugLineNum = 59;BA.debugLine="CommBLE.Initialize";
b4r_main::_commble->_initialize /*void*/ ();
 //BA.debugLineNum = 61;BA.debugLine="Log(CRLF, \"[Main.AppStart][I] Done\")";
B4R::Common::LogHelper(2,102,F(Common_CRLF),102,F("[Main.AppStart][I] Done"));
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}

void b4r_main::initializeProcessGlobals() {
     B4R::StackMemory::buffer = (byte*)malloc(STACK_BUFFER_SIZE);
     b4r_main::_process_globals();
b4r_commble::_process_globals();
b4r_devled::_process_globals();
b4r_convert::_process_globals();

   
}
void b4r_main::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 41;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 42;BA.debugLine="Private APP_VERSION As String	= \"v20251231\"";
b4r_main::_app_version = be_gann1_5.wrap("v20251231");
 //BA.debugLineNum = 43;BA.debugLine="Private APP_NAME As String		= \"ESP32BLELED\"";
b4r_main::_app_name = be_gann2_5.wrap("ESP32BLELED");
 //BA.debugLineNum = 46;BA.debugLine="Private SerialLine As Serial";
b4r_main::_serialline = &be_gann3_3;
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
}
