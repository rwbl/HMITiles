package b4j.example;


import anywheresoftware.b4a.BA;

public class convert extends Object{
public static convert mostCurrent = new convert();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.convert", null);
		ba.loadHtSubs(convert.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.convert", ba);
		}
	}
    public static Class<?> getObject() {
		return convert.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _byteconv = null;
public static b4j.example.dateutils _dateutils = null;
public static b4j.example.cssutils _cssutils = null;
public static b4j.example.main _main = null;
public static b4j.example.b4xpages _b4xpages = null;
public static b4j.example.b4xcollections _b4xcollections = null;
public static b4j.example.xuiviewsutils _xuiviewsutils = null;
public static b4j.example.hmitileutils _hmitileutils = null;
public static byte  _booltobyte(boolean _b) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Public Sub BoolToByte(b As Boolean) As Byte";
 //BA.debugLineNum = 101;BA.debugLine="Return IIf(b, 1, 0)";
if (true) return (byte)(BA.ObjectToNumber(((_b) ? ((Object)(1)) : ((Object)(0)))));
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return (byte)0;
}
public static String  _booltoonoff(boolean _b) throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub BoolToOnOff(b As Boolean) As String";
 //BA.debugLineNum = 113;BA.debugLine="Return IIf(b, \"ON\", \"OFF\")";
if (true) return BA.ObjectToString(((_b) ? ((Object)("ON")) : ((Object)("OFF"))));
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public static String  _bytesmaptostring(anywheresoftware.b4a.objects.collections.Map _map,String _title) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
Object _key = null;
byte[] _b = null;
 //BA.debugLineNum = 147;BA.debugLine="Public Sub BytesMapToString(map As Map, title As S";
 //BA.debugLineNum = 148;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 149;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 151;BA.debugLine="If map.Size > 0 Then";
if (_map.getSize()>0) { 
 //BA.debugLineNum = 152;BA.debugLine="sb.Append(title).Append(CRLF)";
_sb.Append(_title).Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 154;BA.debugLine="For Each key As Object In map.Keys";
{
final anywheresoftware.b4a.BA.IterableList group5 = _map.Keys();
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_key = group5.Get(index5);
 //BA.debugLineNum = 155;BA.debugLine="Dim b() As Byte = map.Get(key)";
_b = (byte[])(_map.Get(_key));
 //BA.debugLineNum = 156;BA.debugLine="sb.Append($\"${key}: ${BytesToString(b, 0, b.Len";
_sb.Append((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_key)+": "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(anywheresoftware.b4a.keywords.Common.BytesToString(_b,(int) (0),_b.length,"ASCII")))+"")).Append(anywheresoftware.b4a.keywords.Common.CRLF);
 }
};
 };
 //BA.debugLineNum = 160;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public static long  _bytestoint(byte[] _b) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Public Sub BytesToInt(b() As Byte) As Long";
 //BA.debugLineNum = 23;BA.debugLine="If b == Null Or b.Length <> 2 Then Return 0";
if (_b== null || _b.length!=2) { 
if (true) return (long) (0);};
 //BA.debugLineNum = 24;BA.debugLine="Return Bit.Or(Bit.And(b(0), 0xFF), Bit.ShiftLeft(";
if (true) return (long) (anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Bit.And((int) (_b[(int) (0)]),((int)0xff)),anywheresoftware.b4a.keywords.Common.Bit.ShiftLeft(anywheresoftware.b4a.keywords.Common.Bit.And((int) (_b[(int) (1)]),((int)0xff)),(int) (8))));
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return 0L;
}
public static boolean  _bytetobool(byte _b) throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Public Sub ByteToBool(b As Byte) As Boolean";
 //BA.debugLineNum = 89;BA.debugLine="Return IIf(b == 1, True, False)";
if (true) return BA.ObjectToBoolean(((_b==1) ? ((Object)(anywheresoftware.b4a.keywords.Common.True)) : ((Object)(anywheresoftware.b4a.keywords.Common.False))));
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return false;
}
public static String  _bytetohex(byte _b) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Public Sub ByteToHex(b As Byte) As String";
 //BA.debugLineNum = 73;BA.debugLine="Return ByteConv.HexFromBytes(Array As Byte(b))";
if (true) return _byteconv.HexFromBytes(new byte[]{_b});
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static String  _decodebase64(String _base64text) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _decoder = null;
byte[] _bytes = null;
 //BA.debugLineNum = 262;BA.debugLine="Public Sub DecodeBase64(Base64Text As String) As S";
 //BA.debugLineNum = 263;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 264;BA.debugLine="jo.InitializeStatic(\"java.util.Base64\")";
_jo.InitializeStatic("java.util.Base64");
 //BA.debugLineNum = 265;BA.debugLine="Dim decoder As JavaObject = jo.RunMethod(\"getDeco";
_decoder = new anywheresoftware.b4j.object.JavaObject();
_decoder = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("getDecoder",(Object[])(anywheresoftware.b4a.keywords.Common.Null))));
 //BA.debugLineNum = 266;BA.debugLine="Dim bytes() As Byte = decoder.RunMethod(\"decode\",";
_bytes = (byte[])(_decoder.RunMethod("decode",new Object[]{(Object)(_base64text)}));
 //BA.debugLineNum = 267;BA.debugLine="Return BytesToString(bytes, 0, bytes.Length, \"UTF";
if (true) return anywheresoftware.b4a.keywords.Common.BytesToString(_bytes,(int) (0),_bytes.length,"UTF8");
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return "";
}
public static String  _encodebase64(String _data) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _encoder = null;
byte[] _bytes = null;
String _base64 = "";
 //BA.debugLineNum = 252;BA.debugLine="Public Sub EncodeBase64(Data As String) As String";
 //BA.debugLineNum = 253;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 254;BA.debugLine="jo.InitializeStatic(\"java.util.Base64\")";
_jo.InitializeStatic("java.util.Base64");
 //BA.debugLineNum = 255;BA.debugLine="Dim encoder As JavaObject = jo.RunMethod(\"getEnco";
_encoder = new anywheresoftware.b4j.object.JavaObject();
_encoder = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("getEncoder",(Object[])(anywheresoftware.b4a.keywords.Common.Null))));
 //BA.debugLineNum = 256;BA.debugLine="Dim bytes() As Byte = Data.GetBytes(\"UTF8\")";
_bytes = _data.getBytes("UTF8");
 //BA.debugLineNum = 257;BA.debugLine="Dim base64 As String = encoder.RunMethod(\"encodeT";
_base64 = BA.ObjectToString(_encoder.RunMethod("encodeToString",new Object[]{(Object)(_bytes)}));
 //BA.debugLineNum = 258;BA.debugLine="Return base64";
if (true) return _base64;
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return "";
}
public static String  _hexfrombytes(byte[] _b) throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Public Sub HexFromBytes(b() As Byte) As String";
 //BA.debugLineNum = 77;BA.debugLine="Return ByteConv.HexFromBytes(b)";
if (true) return _byteconv.HexFromBytes(_b);
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _iiif(byte _state,String[] _options) throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Public Sub IIIF(state As Byte, options() As String";
 //BA.debugLineNum = 212;BA.debugLine="If state < 0 Or state > options.Length - 1 Then";
if (_state<0 || _state>_options.length-1) { 
 //BA.debugLineNum = 213;BA.debugLine="Return Null";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Null);
 };
 //BA.debugLineNum = 215;BA.debugLine="Return options(state)";
if (true) return _options[(int) (_state)];
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public static int  _intfrombytes(byte _b1,byte _b2) throws Exception{
String _hex = "";
 //BA.debugLineNum = 39;BA.debugLine="Public Sub IntFromBytes(b1 As Byte, b2 As Byte) As";
 //BA.debugLineNum = 40;BA.debugLine="Dim hex As String = ByteConv.HexFromBytes(Array A";
_hex = _byteconv.HexFromBytes(new byte[]{_b1,_b2});
 //BA.debugLineNum = 41;BA.debugLine="Return Bit.ParseInt(hex, 16)";
if (true) return anywheresoftware.b4a.keywords.Common.Bit.ParseInt(_hex,(int) (16));
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return 0;
}
public static byte  _inttobyte(int _value) throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Public Sub IntToByte(value As Int) As Byte";
 //BA.debugLineNum = 56;BA.debugLine="If value >= 0 And value <= 255 Then";
if (_value>=0 && _value<=255) { 
 //BA.debugLineNum = 57;BA.debugLine="Return value";
if (true) return (byte) (_value);
 };
 //BA.debugLineNum = 59;BA.debugLine="Log($\"[HKUtils.IntToByte] int out of range (0–255";
anywheresoftware.b4a.keywords.Common.LogImpl("23407876",("[HKUtils.IntToByte] int out of range (0–255): "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_value))+". Using 0."),0);
 //BA.debugLineNum = 60;BA.debugLine="Return 0";
if (true) return (byte) (0);
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return (byte)0;
}
public static float  _maprange(float _value,float _fromlow,float _fromhigh,float _tolow,float _tohigh) throws Exception{
 //BA.debugLineNum = 275;BA.debugLine="Public Sub MapRange(Value As Float, FromLow As Flo";
 //BA.debugLineNum = 276;BA.debugLine="Return ToLow + (ToHigh - ToLow) * ((Value - FromL";
if (true) return (float) (_tolow+(_tohigh-_tolow)*((_value-_fromlow)/(double)(_fromhigh-_fromlow)));
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return 0f;
}
public static int  _maprangeint(int _value,int _fromlow,int _fromhigh,int _tolow,int _tohigh) throws Exception{
 //BA.debugLineNum = 280;BA.debugLine="Public Sub MapRangeInt(Value As Int, FromLow As In";
 //BA.debugLineNum = 281;BA.debugLine="Return ToLow + (ToHigh - ToLow) * ((Value - FromL";
if (true) return (int) (_tolow+(_tohigh-_tolow)*((_value-_fromlow)/(double)(_fromhigh-_fromlow)));
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return 0;
}
public static String  _parseerrormessage(String _raw) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _m = null;
String _msg = "";
 //BA.debugLineNum = 236;BA.debugLine="Public Sub ParseErrorMessage(Raw As String) As Str";
 //BA.debugLineNum = 237;BA.debugLine="Dim m As Matcher = Regex.Matcher(\"\\(([^)]+)\\) - M";
_m = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_m = anywheresoftware.b4a.keywords.Common.Regex.Matcher("\\(([^)]+)\\) - Method: [^.]+\\.[^:]+:(.*)$",_raw);
 //BA.debugLineNum = 238;BA.debugLine="If m.Find Then";
if (_m.Find()) { 
 //BA.debugLineNum = 239;BA.debugLine="Dim msg As String = m.Group(1)";
_msg = _m.Group((int) (1));
 //BA.debugLineNum = 240;BA.debugLine="If m.Group(2).Trim <> \"\" Then msg = msg & \" - \"";
if ((_m.Group((int) (2)).trim()).equals("") == false) { 
_msg = _msg+" - "+_m.Group((int) (2));};
 //BA.debugLineNum = 241;BA.debugLine="Return msg";
if (true) return _msg;
 };
 //BA.debugLineNum = 243;BA.debugLine="Return Raw";
if (true) return _raw;
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public static String  _printmap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
String _key = "";
 //BA.debugLineNum = 129;BA.debugLine="Public Sub PrintMap(m As Map)";
 //BA.debugLineNum = 130;BA.debugLine="For Each key As String In m.Keys";
{
final anywheresoftware.b4a.BA.IterableList group1 = _m.Keys();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_key = BA.ObjectToString(group1.Get(index1));
 //BA.debugLineNum = 131;BA.debugLine="Log($\"[HKUtils.PrintMap] key=${key}, value=${m.G";
anywheresoftware.b4a.keywords.Common.LogImpl("23801090",("[HKUtils.PrintMap] key="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_key))+", value="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_m.Get((Object)(_key)))+""),0);
 }
};
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Public ByteConv As ByteConverter";
_byteconv = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static int  _valuetopercent(int _value,int _maxvalue) throws Exception{
int _pct = 0;
 //BA.debugLineNum = 172;BA.debugLine="Public Sub ValueToPercent(value As Int, maxvalue A";
 //BA.debugLineNum = 174;BA.debugLine="Dim pct As Int";
_pct = 0;
 //BA.debugLineNum = 175;BA.debugLine="pct = value * 100 / maxvalue";
_pct = (int) (_value*100/(double)_maxvalue);
 //BA.debugLineNum = 176;BA.debugLine="If pct > 100 Then pct = 100";
if (_pct>100) { 
_pct = (int) (100);};
 //BA.debugLineNum = 177;BA.debugLine="If pct < 0 Then pct = 0";
if (_pct<0) { 
_pct = (int) (0);};
 //BA.debugLineNum = 179;BA.debugLine="Return pct";
if (true) return _pct;
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return 0;
}
public static int  _valuetopercentfrombytes(byte[] _b,int _maxvalue) throws Exception{
int _raw = 0;
int _pct = 0;
 //BA.debugLineNum = 191;BA.debugLine="Public Sub ValueToPercentFromBytes(b() As Byte, ma";
 //BA.debugLineNum = 192;BA.debugLine="If b = Null Or b.Length <> 2 Then Return 0";
if (_b== null || _b.length!=2) { 
if (true) return (int) (0);};
 //BA.debugLineNum = 195;BA.debugLine="Dim raw As Int";
_raw = 0;
 //BA.debugLineNum = 196;BA.debugLine="raw = b(0) + b(1) * 256  ' or b(0) + Bit.ShiftLef";
_raw = (int) (_b[(int) (0)]+_b[(int) (1)]*256);
 //BA.debugLineNum = 199;BA.debugLine="Dim pct As Int";
_pct = 0;
 //BA.debugLineNum = 200;BA.debugLine="pct = raw * 100 / maxvalue";
_pct = (int) (_raw*100/(double)_maxvalue);
 //BA.debugLineNum = 201;BA.debugLine="If pct > 100 Then pct = 100";
if (_pct>100) { 
_pct = (int) (100);};
 //BA.debugLineNum = 202;BA.debugLine="If pct < 0 Then pct = 0";
if (_pct<0) { 
_pct = (int) (0);};
 //BA.debugLineNum = 204;BA.debugLine="Return pct";
if (true) return _pct;
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return 0;
}
}
