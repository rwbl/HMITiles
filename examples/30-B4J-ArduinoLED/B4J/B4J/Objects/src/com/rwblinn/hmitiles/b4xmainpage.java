package com.rwblinn.hmitiles;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("com.rwblinn.hmitiles", "com.rwblinn.hmitiles.b4xmainpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", com.rwblinn.hmitiles.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _version = "";
public String _about = "";
public byte _cmd_led_off = (byte)0;
public byte _cmd_led_on = (byte)0;
public byte _cmd_led_blink = (byte)0;
public byte _state_led_off = (byte)0;
public byte _state_led_on = (byte)0;
public byte _state_error = (byte)0;
public String[] _commands = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labelabout = null;
public com.rwblinn.hmitiles.hmitilebutton _tilebuttonopenport = null;
public com.rwblinn.hmitiles.hmitileselectlist _tileselectlistports = null;
public com.rwblinn.hmitiles.hmitileselect _tileselectcommand = null;
public com.rwblinn.hmitiles.hmitilebutton _tilebuttonledonoff = null;
public com.rwblinn.hmitiles.hmitilereadout _tilereadoutledstate = null;
public com.rwblinn.hmitiles.hmitileeventviewer _tileevents = null;
public anywheresoftware.b4j.serial.Serial _serialline = null;
public int _baudrate = 0;
public String _portselected = "";
public boolean _isportopen = false;
public anywheresoftware.b4a.randomaccessfile.AsyncStreams _astream = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public com.rwblinn.hmitiles.main _main = null;
public com.rwblinn.hmitiles.b4xpages _b4xpages = null;
public com.rwblinn.hmitiles.b4xcollections _b4xcollections = null;
public com.rwblinn.hmitiles.hmitileutils _hmitileutils = null;
public com.rwblinn.hmitiles.xuiviewsutils _xuiviewsutils = null;
public String  _astream_error() throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Sub AStream_Error";
 //BA.debugLineNum = 239;BA.debugLine="TileEvents.Insert($\"[AStream_Error] \"$, HMITileUt";
_tileevents._insert /*String*/ (("[AStream_Error] "),_hmitileutils._event_level_alarm /*int*/ );
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _astream_newdata(byte[] _buffer) throws Exception{
byte _state = (byte)0;
String _statetext = "";
 //BA.debugLineNum = 219;BA.debugLine="Sub AStream_NewData (Buffer() As Byte)";
 //BA.debugLineNum = 220;BA.debugLine="Dim state As Byte";
_state = (byte)0;
 //BA.debugLineNum = 221;BA.debugLine="Dim statetext As String";
_statetext = "";
 //BA.debugLineNum = 223;BA.debugLine="If Buffer.Length = 1 Then";
if (_buffer.length==1) { 
 //BA.debugLineNum = 224;BA.debugLine="state = Buffer(0)";
_state = _buffer[(int) (0)];
 //BA.debugLineNum = 225;BA.debugLine="TileEvents.Insert($\"[AStream_NewData] data=${HMI";
_tileevents._insert /*String*/ (("[AStream_NewData] data="+__c.SmartStringFormatter("",(Object)(_hmitileutils._byteconv /*anywheresoftware.b4a.agraham.byteconverter.ByteConverter*/ .HexFromBytes(_buffer)))+""),_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 226;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,_state_led_off,_state_led_on,_state_error)) {
case 0: {
 //BA.debugLineNum = 228;BA.debugLine="statetext = \"OFF\"";
_statetext = "OFF";
 break; }
case 1: {
 //BA.debugLineNum = 230;BA.debugLine="statetext = \"ON\"";
_statetext = "ON";
 break; }
case 2: {
 //BA.debugLineNum = 232;BA.debugLine="statetext = \"ERROR\"";
_statetext = "ERROR";
 break; }
}
;
 //BA.debugLineNum = 234;BA.debugLine="TileReadoutLEDState.Value = statetext";
_tilereadoutledstate._setvalue /*String*/ (_statetext);
 };
 //BA.debugLineNum = 236;BA.debugLine="End Sub";
return "";
}
public String  _astream_terminated() throws Exception{
 //BA.debugLineNum = 242;BA.debugLine="Sub AStream_Terminated";
 //BA.debugLineNum = 243;BA.debugLine="TileEvents.Insert($\"[AStream_Terminated] \"$, HMIT";
_tileevents._insert /*String*/ (("[AStream_Terminated] "),_hmitileutils._event_level_warning /*int*/ );
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public String  _astreamwrite(byte[] _data) throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Public Sub AStreamWrite(data() As Byte)";
 //BA.debugLineNum = 247;BA.debugLine="Try";
try { //BA.debugLineNum = 248;BA.debugLine="AStream.Write(data)";
_astream.Write(_data);
 //BA.debugLineNum = 249;BA.debugLine="TileEvents.Insert($\"[AStreamWrite] sending=${HMI";
_tileevents._insert /*String*/ (("[AStreamWrite] sending="+__c.SmartStringFormatter("",(Object)(_hmitileutils._byteconv /*anywheresoftware.b4a.agraham.byteconverter.ByteConverter*/ .HexFromBytes(_data)))+""),_hmitileutils._event_level_info /*int*/ );
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 251;BA.debugLine="TileEvents.Insert($\"[AStreamWrite] failed=${Last";
_tileevents._insert /*String*/ (("[AStreamWrite] failed="+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),_hmitileutils._event_level_alarm /*int*/ );
 };
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public void  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
ResumableSub_B4XPage_Created rsub = new ResumableSub_B4XPage_Created(this,_root1);
rsub.resume(ba, null);
}
public static class ResumableSub_B4XPage_Created extends BA.ResumableSub {
public ResumableSub_B4XPage_Created(com.rwblinn.hmitiles.b4xmainpage parent,anywheresoftware.b4a.objects.B4XViewWrapper _root1) {
this.parent = parent;
this._root1 = _root1;
}
com.rwblinn.hmitiles.b4xmainpage parent;
anywheresoftware.b4a.objects.B4XViewWrapper _root1;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 83;BA.debugLine="Root = Root1";
parent._root = _root1;
 //BA.debugLineNum = 84;BA.debugLine="Root.LoadLayout(\"mainpage\")";
parent._root.LoadLayout("mainpage",ba);
 //BA.debugLineNum = 89;BA.debugLine="SerialLine.Initialize(\"\")";
parent._serialline.Initialize("");
 //BA.debugLineNum = 94;BA.debugLine="Root.Color = HMITileUtils.COLOR_BACKGROUND_SCREEN";
parent._root.setColor(parent._hmitileutils._color_background_screen /*int*/ );
 //BA.debugLineNum = 95;BA.debugLine="B4XPages.SetTitle(Me, VERSION)";
parent._b4xpages._settitle /*String*/ (parent,(Object)(parent._version));
 //BA.debugLineNum = 96;BA.debugLine="B4XPages.GetNativeParent(Me).Resizable = False";
parent._b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (parent).setResizable(parent.__c.False);
 //BA.debugLineNum = 97;BA.debugLine="LabelAbout.Text = ABOUT";
parent._labelabout.setText(parent._about);
 //BA.debugLineNum = 98;BA.debugLine="LabelAbout.TextColor = HMITileUtils.COLOR_TEXT_WA";
parent._labelabout.setTextColor(parent._hmitileutils._color_text_warning /*int*/ );
 //BA.debugLineNum = 101;BA.debugLine="Sleep(1)";
parent.__c.Sleep(ba,this,(int) (1));
this.state = 11;
return;
case 11:
//C
this.state = 1;
;
 //BA.debugLineNum = 106;BA.debugLine="TileEvents.CompactMode = False";
parent._tileevents._setcompactmode /*boolean*/ (parent.__c.False);
 //BA.debugLineNum = 107;BA.debugLine="TileEvents.Insert(VERSION, HMITileUtils.EVENT_LEV";
parent._tileevents._insert /*String*/ (parent._version,parent._hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 112;BA.debugLine="TileButtonOpenPort.StateText = IIf(False, \"Open\",";
parent._tilebuttonopenport._setstatetext /*String*/ (BA.ObjectToString(((parent.__c.False) ? ((Object)("Open")) : ((Object)("Closed")))));
 //BA.debugLineNum = 113;BA.debugLine="TileButtonLEDOnOff.StateText = IIf(False, \"ON\", \"";
parent._tilebuttonledonoff._setstatetext /*String*/ (BA.ObjectToString(((parent.__c.False) ? ((Object)("ON")) : ((Object)("OFF")))));
 //BA.debugLineNum = 118;BA.debugLine="TileSelectListPorts.AddAll(SerialLine.ListPorts)";
parent._tileselectlistports._addall /*String*/ (parent._serialline.ListPorts());
 //BA.debugLineNum = 119;BA.debugLine="If SerialLine.ListPorts.Size < 3 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._serialline.ListPorts().getSize()<3) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 120;BA.debugLine="TileSelectListPorts.Scrollbar = False";
parent._tileselectlistports._setscrollbar /*boolean*/ (parent.__c.False);
 if (true) break;
;
 //BA.debugLineNum = 122;BA.debugLine="If TileSelectListPorts.Size == 1 Then";

case 4:
//if
this.state = 7;
if (parent._tileselectlistports._size /*int*/ ()==1) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 123;BA.debugLine="TileSelectListPorts.SetSelectedItem(0)";
parent._tileselectlistports._setselecteditem /*String*/ ((int) (0));
 //BA.debugLineNum = 124;BA.debugLine="PortSelected = TileSelectListPorts.SelectedItem";
parent._portselected = parent._tileselectlistports._selecteditem /*String*/ ();
 if (true) break;
;
 //BA.debugLineNum = 126;BA.debugLine="If TileSelectListPorts.Size == 0 Then";

case 7:
//if
this.state = 10;
if (parent._tileselectlistports._size /*int*/ ()==0) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 127;BA.debugLine="TileEvents.Insert($\"No port(s) found\"$, HMITileU";
parent._tileevents._insert /*String*/ (("No port(s) found"),parent._hmitileutils._event_level_warning /*int*/ );
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 129;BA.debugLine="TileSelectCommand.AddAll(Commands)";
parent._tileselectcommand._addall /*String*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(parent._commands));
 //BA.debugLineNum = 130;BA.debugLine="TileSelectCommand.Selected = Commands(0)";
parent._tileselectcommand._setselected /*String*/ (parent._commands[(int) (0)]);
 //BA.debugLineNum = 133;BA.debugLine="TileReadoutLEDState.Value = TileButtonLEDOnOff.St";
parent._tilereadoutledstate._setvalue /*String*/ (parent._tilebuttonledonoff._getstatetext /*String*/ ());
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private VERSION As String	= \"HMITiles Example Ard";
_version = "HMITiles Example ArduinoLED v20260104";
 //BA.debugLineNum = 23;BA.debugLine="Private ABOUT As String 	= $\"HMITiles (c) 2025-20";
_about = ("HMITiles (c) 2025-2026 Robert W.B. Linn - MIT");
 //BA.debugLineNum = 28;BA.debugLine="Private CMD_LED_OFF As Byte 	= 0x00";
_cmd_led_off = (byte) (((int)0x00));
 //BA.debugLineNum = 29;BA.debugLine="Private CMD_LED_ON As Byte		= 0x01";
_cmd_led_on = (byte) (((int)0x01));
 //BA.debugLineNum = 30;BA.debugLine="Private CMD_LED_BLINK As Byte 	= 0x02";
_cmd_led_blink = (byte) (((int)0x02));
 //BA.debugLineNum = 32;BA.debugLine="Private STATE_LED_OFF As Byte 	= CMD_LED_OFF";
_state_led_off = _cmd_led_off;
 //BA.debugLineNum = 33;BA.debugLine="Private STATE_LED_ON As Byte	= CMD_LED_ON";
_state_led_on = _cmd_led_on;
 //BA.debugLineNum = 34;BA.debugLine="Private STATE_ERROR As Byte 	= 0xFF";
_state_error = (byte) (((int)0xff));
 //BA.debugLineNum = 36;BA.debugLine="Private Commands() As String	= Array As String(\"O";
_commands = new String[]{"ON","OFF","BLINK"};
 //BA.debugLineNum = 41;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 42;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private LabelAbout As B4XView";
_labelabout = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private TileButtonOpenPort As HMITileButton";
_tilebuttonopenport = new com.rwblinn.hmitiles.hmitilebutton();
 //BA.debugLineNum = 52;BA.debugLine="Private TileSelectListPorts As HMITileSelectList";
_tileselectlistports = new com.rwblinn.hmitiles.hmitileselectlist();
 //BA.debugLineNum = 55;BA.debugLine="Private TileSelectCommand As HMITileSelect";
_tileselectcommand = new com.rwblinn.hmitiles.hmitileselect();
 //BA.debugLineNum = 58;BA.debugLine="Private TileButtonLEDOnOff As HMITileButton";
_tilebuttonledonoff = new com.rwblinn.hmitiles.hmitilebutton();
 //BA.debugLineNum = 61;BA.debugLine="Private TileReadoutLEDState As HMITileReadout";
_tilereadoutledstate = new com.rwblinn.hmitiles.hmitilereadout();
 //BA.debugLineNum = 64;BA.debugLine="Private TileEvents As HMITileEventViewer";
_tileevents = new com.rwblinn.hmitiles.hmitileeventviewer();
 //BA.debugLineNum = 69;BA.debugLine="Private SerialLine As Serial";
_serialline = new anywheresoftware.b4j.serial.Serial();
 //BA.debugLineNum = 70;BA.debugLine="Private const BAUDRATE As Int = 115200";
_baudrate = (int) (115200);
 //BA.debugLineNum = 71;BA.debugLine="Private PortSelected As String = \"\"";
_portselected = "";
 //BA.debugLineNum = 72;BA.debugLine="Private IsPortOpen As Boolean = False";
_isportopen = __c.False;
 //BA.debugLineNum = 73;BA.debugLine="Private AStream As AsyncStreams";
_astream = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 76;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 78;BA.debugLine="B4XPages.GetManager.LogEvents = True";
_b4xpages._getmanager /*com.rwblinn.hmitiles.b4xpagesmanager*/ ()._logevents /*boolean*/  = __c.True;
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public String  _tilebuttonledonoff_click() throws Exception{
byte[] _data = null;
 //BA.debugLineNum = 169;BA.debugLine="Private Sub TileButtonLEDOnOff_Click";
 //BA.debugLineNum = 170;BA.debugLine="If Not(IsPortOpen) Then Return";
if (__c.Not(_isportopen)) { 
if (true) return "";};
 //BA.debugLineNum = 171;BA.debugLine="Dim data(1) As Byte";
_data = new byte[(int) (1)];
;
 //BA.debugLineNum = 173;BA.debugLine="TileButtonLEDOnOff.SetState(TileButtonLEDOnOff.St";
_tilebuttonledonoff._setstate /*String*/ (_tilebuttonledonoff._getstate /*boolean*/ ());
 //BA.debugLineNum = 174;BA.debugLine="TileButtonLEDOnOff.StateText = IIf(TileButtonLEDO";
_tilebuttonledonoff._setstatetext /*String*/ (BA.ObjectToString(((_tilebuttonledonoff._getstate /*boolean*/ ()) ? ((Object)("ON")) : ((Object)("OFF")))));
 //BA.debugLineNum = 175;BA.debugLine="TileEvents.Insert($\"[TileButtonLEDOnOff] state=${";
_tileevents._insert /*String*/ (("[TileButtonLEDOnOff] state="+__c.SmartStringFormatter("",(Object)(_tilebuttonledonoff._getstate /*boolean*/ ()))+""),_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 177;BA.debugLine="If TileButtonLEDOnOff.State Then";
if (_tilebuttonledonoff._getstate /*boolean*/ ()) { 
 //BA.debugLineNum = 178;BA.debugLine="data(0) = CMD_LED_ON";
_data[(int) (0)] = _cmd_led_on;
 }else {
 //BA.debugLineNum = 180;BA.debugLine="data(0) = CMD_LED_OFF";
_data[(int) (0)] = _cmd_led_off;
 };
 //BA.debugLineNum = 182;BA.debugLine="AStreamWrite(data)";
_astreamwrite(_data);
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public String  _tilebuttonopenport_click() throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Private Sub TileButtonOpenPort_Click";
 //BA.debugLineNum = 140;BA.debugLine="If PortSelected.Length == 0 Then";
if (_portselected.length()==0) { 
 //BA.debugLineNum = 141;BA.debugLine="TileEvents.Insert($\"[TileButtonOpenPort_Click] N";
_tileevents._insert /*String*/ (("[TileButtonOpenPort_Click] No port(s) found or selected"),_hmitileutils._event_level_warning /*int*/ );
 //BA.debugLineNum = 142;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 145;BA.debugLine="TileButtonOpenPort.SetState(TileButtonOpenPort.St";
_tilebuttonopenport._setstate /*String*/ (_tilebuttonopenport._getstate /*boolean*/ ());
 //BA.debugLineNum = 146;BA.debugLine="TileButtonOpenPort.StateText = IIf(TileButtonOpen";
_tilebuttonopenport._setstatetext /*String*/ (BA.ObjectToString(((_tilebuttonopenport._getstate /*boolean*/ ()) ? ((Object)("Open")) : ((Object)("Closed")))));
 //BA.debugLineNum = 149;BA.debugLine="If AStream.IsInitialized Then";
if (_astream.IsInitialized()) { 
 //BA.debugLineNum = 150;BA.debugLine="AStream.Close";
_astream.Close();
 //BA.debugLineNum = 151;BA.debugLine="SerialLine.Close";
_serialline.Close();
 //BA.debugLineNum = 152;BA.debugLine="IsPortOpen = False";
_isportopen = __c.False;
 };
 //BA.debugLineNum = 155;BA.debugLine="If TileButtonOpenPort.State Then";
if (_tilebuttonopenport._getstate /*boolean*/ ()) { 
 //BA.debugLineNum = 156;BA.debugLine="Try";
try { //BA.debugLineNum = 157;BA.debugLine="SerialLine.Open(PortSelected)";
_serialline.Open(_portselected);
 //BA.debugLineNum = 158;BA.debugLine="SerialLine.SetParams(BAUDRATE, 8, 1, 0)";
_serialline.SetParams(_baudrate,(int) (8),(int) (1),(int) (0));
 //BA.debugLineNum = 159;BA.debugLine="AStream.Initialize(SerialLine.GetInputStream, S";
_astream.Initialize(ba,_serialline.GetInputStream(),_serialline.GetOutputStream(),"AStream");
 //BA.debugLineNum = 160;BA.debugLine="IsPortOpen = True";
_isportopen = __c.True;
 //BA.debugLineNum = 161;BA.debugLine="TileEvents.Insert($\"[TileButtonOpenPort] port=$";
_tileevents._insert /*String*/ (("[TileButtonOpenPort] port="+__c.SmartStringFormatter("",(Object)(_portselected))+", open="+__c.SmartStringFormatter("",(Object)(_isportopen))+""),_hmitileutils._event_level_info /*int*/ );
 } 
       catch (Exception e20) {
			ba.setLastException(e20); //BA.debugLineNum = 163;BA.debugLine="IsPortOpen = True";
_isportopen = __c.True;
 //BA.debugLineNum = 164;BA.debugLine="TileEvents.Insert($\"[TileButtonOpenPort] ${Last";
_tileevents._insert /*String*/ (("[TileButtonOpenPort] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),_hmitileutils._event_level_alarm /*int*/ );
 };
 };
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public String  _tileevents_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="Private Sub TileEvents_ItemClick (Index As Int, Va";
 //BA.debugLineNum = 206;BA.debugLine="TileEvents.Insert($\"[TileEvents_ItemClick] index=";
_tileevents._insert /*String*/ (("[TileEvents_ItemClick] index="+__c.SmartStringFormatter("",(Object)(_index))+", value="+__c.SmartStringFormatter("",_value)+""),_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public String  _tileselect_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Private Sub TileSelect_ItemClick (Index As Int, Va";
 //BA.debugLineNum = 211;BA.debugLine="TileEvents.Insert($\"[TileSelect_ItemClick] index=";
_tileevents._insert /*String*/ (("[TileSelect_ItemClick] index="+__c.SmartStringFormatter("",(Object)(_index))+", value="+__c.SmartStringFormatter("",_value)+""),_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 213;BA.debugLine="PortSelected = Value.As(String)";
_portselected = (BA.ObjectToString(_value));
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public String  _tileselectcommand_valuechanged(Object _value) throws Exception{
byte[] _data = null;
 //BA.debugLineNum = 185;BA.debugLine="Private Sub TileSelectCommand_ValueChanged (Value";
 //BA.debugLineNum = 186;BA.debugLine="If Not(IsPortOpen) Then Return";
if (__c.Not(_isportopen)) { 
if (true) return "";};
 //BA.debugLineNum = 187;BA.debugLine="Dim data(1) As Byte";
_data = new byte[(int) (1)];
;
 //BA.debugLineNum = 189;BA.debugLine="TileEvents.Insert($\"[TileSelectCommand_ValueChang";
_tileevents._insert /*String*/ (("[TileSelectCommand_ValueChanged] value="+__c.SmartStringFormatter("",_value)+""),_hmitileutils._event_level_info /*int*/ );
 //BA.debugLineNum = 190;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)("ON"),(Object)("OFF"),(Object)("BLINK"))) {
case 0: {
 //BA.debugLineNum = 192;BA.debugLine="data(0) = CMD_LED_ON";
_data[(int) (0)] = _cmd_led_on;
 break; }
case 1: {
 //BA.debugLineNum = 194;BA.debugLine="data(0) = CMD_LED_OFF";
_data[(int) (0)] = _cmd_led_off;
 break; }
case 2: {
 //BA.debugLineNum = 196;BA.debugLine="data(0) = CMD_LED_BLINK";
_data[(int) (0)] = _cmd_led_blink;
 break; }
}
;
 //BA.debugLineNum = 198;BA.debugLine="AStreamWrite(data)";
_astreamwrite(_data);
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
