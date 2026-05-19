#include "B4RDefines.h"

ULong b4r_convert::_version;
Byte b4r_convert::_byte_min;
Byte b4r_convert::_byte_max;
Int b4r_convert::_int16_min;
Int b4r_convert::_int16_max;
ULong b4r_convert::_uint16_min;
ULong b4r_convert::_uint16_max;
ULong b4r_convert::_uint32_min;
ULong b4r_convert::_uint32_max;
Double b4r_convert::_float_min;
Double b4r_convert::_float_max;
Double b4r_convert::_double_min;
Double b4r_convert::_double_max;
ULong b4r_convert::_modbus_polynomial;
bool b4r_convert::_splitallowemptyaszero;
B4R::ByteConverter* b4r_convert::_byteconv;
b4r_main* b4r_convert::_main;
static B4R::ByteConverter be_gann16_3;


 B4R::Array* b4r_convert::_appendxorchecksum(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
B4R::Array be_ann256_8e2;
B4R::Array* _out = NULL;
Byte _checksum = 0;
Int _i = 0;
 //BA.debugLineNum = 709;BA.debugLine="Public Sub AppendXORChecksum(Frame() As Byte) As B";
 //BA.debugLineNum = 710;BA.debugLine="Dim out(Frame.Length + 1) As Byte";
_out =be_ann256_8e2.wrapDynamic((Int) (_frame->length+1), sizeof(Byte));
 //BA.debugLineNum = 711;BA.debugLine="Dim checksum As Byte = XORChecksum(Frame)";
_checksum = _xorchecksum(_frame);
 //BA.debugLineNum = 712;BA.debugLine="For i = 0 To Frame.Length - 1";
{
const int step3 = 1;
const int limit3 = (Int) (_frame->length-1);
_i = 0 ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 713;BA.debugLine="out(i) = Frame(i)";
((Byte*)_out->getData((UInt) (_i)))[B4R::Array::staticIndex] = ((Byte*)_frame->getData((UInt) (_i)))[B4R::Array::staticIndex];
 }
};
 //BA.debugLineNum = 715;BA.debugLine="out(Frame.Length) = checksum";
((Byte*)_out->getData((UInt) (_frame->length)))[B4R::Array::staticIndex] = _checksum;
 //BA.debugLineNum = 716;BA.debugLine="Return out";
B4R::StackMemory::cp = cp;
B4R::Array* res7 = B4R::StackMemory::ReturnArrayOnStack(_out, sizeof(Byte));
if (true) return res7;
 //BA.debugLineNum = 717;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
Int b4r_convert::_asciibuffertoint(B4R::Array* _buffer){
const UInt cp = B4R::StackMemory::cp;
Int _value = 0;
Int _i = 0;
Int _digit = 0;
 //BA.debugLineNum = 964;BA.debugLine="Public Sub AsciiBufferToInt(Buffer() As Byte) As I";
 //BA.debugLineNum = 965;BA.debugLine="Dim value As Int = 0";
_value = 0;
 //BA.debugLineNum = 966;BA.debugLine="For i = 0 To Buffer.Length - 1";
{
const int step2 = 1;
const int limit2 = (Int) (_buffer->length-1);
_i = 0 ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 967;BA.debugLine="Dim digit As Int = Buffer(i) - 48   ' '0' = 48";
_digit = (Int) (((Byte*)_buffer->getData((UInt) (_i)))[B4R::Array::staticIndex]-48);
 //BA.debugLineNum = 968;BA.debugLine="If digit < 0 Or digit > 9 Then";
if (_digit<0 || _digit>9) { 
 //BA.debugLineNum = 969;BA.debugLine="Return -1   ' invalid input";
B4R::StackMemory::cp = cp;
Int res5 = (Int) (-1);
if (true) return res5;
 };
 //BA.debugLineNum = 971;BA.debugLine="value = value * 10 + digit";
_value = (Int) (_value*10+_digit);
 }
};
 //BA.debugLineNum = 973;BA.debugLine="Return value";
B4R::StackMemory::cp = cp;
Int res9 = _value;
if (true) return res9;
 //BA.debugLineNum = 974;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
bool b4r_convert::_asciibytestobool(B4R::Array* _bytes){
const UInt cp = B4R::StackMemory::cp;
B4R::Object be_ann26_13;
B4R::Object be_ann26_17;
 //BA.debugLineNum = 214;BA.debugLine="Public Sub AsciiBytesToBool(bytes() As Byte) As Bo";
 //BA.debugLineNum = 215;BA.debugLine="If bytes == Null Or bytes.Length == 0 Then Return";
if (_bytes== NULL || _bytes->length==0) { 
B4R::StackMemory::cp = cp;
bool res1 = Common_False;
if (true) return res1;};
 //BA.debugLineNum = 216;BA.debugLine="Return IIf(bytes(0) == 49, True, False)";
B4R::StackMemory::cp = cp;
bool res2 = (bool)(((((Byte*)_bytes->getData((UInt) (0)))[B4R::Array::staticIndex]==49) ? (be_ann26_13.wrapNumber((Long)Common_True)) : (be_ann26_17.wrapNumber((Long)Common_False)))->toLong());
if (true) return res2;
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
bool b4r_convert::_asciibytetobool(Byte _b){
const UInt cp = B4R::StackMemory::cp;
B4R::Object be_ann22_10;
B4R::Object be_ann22_14;
 //BA.debugLineNum = 204;BA.debugLine="Public Sub AsciiByteToBool(b As Byte) As Boolean";
 //BA.debugLineNum = 205;BA.debugLine="Return IIf(b == 49, True, False)";
B4R::StackMemory::cp = cp;
bool res1 = (bool)(((_b==49) ? (be_ann22_10.wrapNumber((Long)Common_True)) : (be_ann22_14.wrapNumber((Long)Common_False)))->toLong());
if (true) return res1;
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
Int b4r_convert::_asciibytetoint(B4R::Array* _bytes){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString be_ann29_10;
 //BA.debugLineNum = 223;BA.debugLine="Public Sub AsciiByteToInt(bytes() As Byte) As Int";
 //BA.debugLineNum = 224;BA.debugLine="Return bytes(0) - Asc(\"0\")";
B4R::StackMemory::cp = cp;
Int res1 = (Int) (((Byte*)_bytes->getData((UInt) (0)))[B4R::Array::staticIndex]-Common_Asc(be_ann29_10.wrap("0")));
if (true) return res1;
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
UInt b4r_convert::_bcdarraytouint(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 683;BA.debugLine="Public Sub BCDArrayToUInt(b() As Byte) As UInt";
 //BA.debugLineNum = 684;BA.debugLine="If b.Length < 2 Then Return 0";
if (_b->length<2) { 
B4R::StackMemory::cp = cp;
UInt res1 = (UInt) (0);
if (true) return res1;};
 //BA.debugLineNum = 685;BA.debugLine="Return BCDToByte(b(0)) * 100 + BCDToByte(b(1))";
B4R::StackMemory::cp = cp;
UInt res2 = (UInt) (_bcdtobyte(((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex])*100+_bcdtobyte(((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]));
if (true) return res2;
 //BA.debugLineNum = 686;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
UInt b4r_convert::_bcdtobyte(Byte _b){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 661;BA.debugLine="Public Sub BCDToByte(b As Byte) As UInt";
 //BA.debugLineNum = 662;BA.debugLine="Return Bit.ShiftRight(b, 4) * 10 + Bit.And(b,";
B4R::StackMemory::cp = cp;
UInt res1 = (UInt) (BitClass_ShiftRight((UInt) (_b),(Byte) (4))*10+BitClass_And((UInt) (_b),(UInt) (((Int)0x0f))));
if (true) return res1;
 //BA.debugLineNum = 663;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
UInt b4r_convert::_bintodec(B4R::B4RString* _binstr){
const UInt cp = B4R::StackMemory::cp;
UInt _result = 0;
Int _i = 0;
B4R::Array* _b = NULL;
Byte _c = 0;
B4R::B4RString be_ann217_8;
 //BA.debugLineNum = 605;BA.debugLine="Public Sub BinToDec(binstr As String) As UInt";
 //BA.debugLineNum = 606;BA.debugLine="Dim result As UInt = 0";
_result = (UInt) (0);
 //BA.debugLineNum = 607;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 608;BA.debugLine="Dim b() As Byte = binstr.GetBytes";
_b = _binstr->GetBytes();
 //BA.debugLineNum = 609;BA.debugLine="For i = 0 To binstr.Length - 1";
{
const int step4 = 1;
const int limit4 = (Int) (_binstr->getLength()-1);
_i = 0 ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 610;BA.debugLine="Dim c As Byte = b(i)";
_c = ((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 611;BA.debugLine="result = result * 2";
_result = (UInt) (_result*2);
 //BA.debugLineNum = 612;BA.debugLine="If c = Asc(\"1\") Then result = result + 1";
if (_c==Common_Asc(be_ann217_8.wrap("1"))) { 
_result = (UInt) (_result+1);};
 }
};
 //BA.debugLineNum = 614;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
UInt res9 = _result;
if (true) return res9;
 //BA.debugLineNum = 615;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
Byte b4r_convert::_booltobyte(bool _state){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 322;BA.debugLine="Public Sub BoolToByte(state As Boolean) As Byte";
 //BA.debugLineNum = 323;BA.debugLine="If state Then";
if (_state) { 
 //BA.debugLineNum = 324;BA.debugLine="Return 1";
B4R::StackMemory::cp = cp;
Byte res2 = (Byte) (1);
if (true) return res2;
 }else {
 //BA.debugLineNum = 326;BA.debugLine="Return 0";
B4R::StackMemory::cp = cp;
Byte res4 = (Byte) (0);
if (true) return res4;
 };
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::B4RString* b4r_convert::_booltoonoff(bool _state){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString be_ann60_1;
B4R::B4RString be_ann62_1;
 //BA.debugLineNum = 292;BA.debugLine="Public Sub BoolToOnOff(state As Boolean) As String";
 //BA.debugLineNum = 293;BA.debugLine="If state Then";
if (_state) { 
 //BA.debugLineNum = 294;BA.debugLine="Return \"ON\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res2 = B4R::StackMemory::ReturnStringOnStack(be_ann60_1.wrap("ON"));
if (true) return res2;
 }else {
 //BA.debugLineNum = 296;BA.debugLine="Return \"OFF\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res4 = B4R::StackMemory::ReturnStringOnStack(be_ann62_1.wrap("OFF"));
if (true) return res4;
 };
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::B4RString* b4r_convert::_booltostring(bool _state){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString be_ann53_1;
B4R::B4RString be_ann55_1;
 //BA.debugLineNum = 280;BA.debugLine="Public Sub BoolToString(state As Boolean) As Strin";
 //BA.debugLineNum = 281;BA.debugLine="If state Then";
if (_state) { 
 //BA.debugLineNum = 282;BA.debugLine="Return \"1\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res2 = B4R::StackMemory::ReturnStringOnStack(be_ann53_1.wrap("1"));
if (true) return res2;
 }else {
 //BA.debugLineNum = 284;BA.debugLine="Return \"0\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res4 = B4R::StackMemory::ReturnStringOnStack(be_ann55_1.wrap("0"));
if (true) return res4;
 };
 //BA.debugLineNum = 286;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::Array* b4r_convert::_bytestobin(B4R::Array* _bytes){
const UInt cp = B4R::StackMemory::cp;
UInt _nrofbytes = 0;
UInt _bitsarraylen = 0;
B4R::Array be_ann193_4e2;
B4R::Array* _bits = NULL;
Int _j = 0;
Byte _b = 0;
Int _i = 0;
 //BA.debugLineNum = 566;BA.debugLine="Public Sub BytesToBin(bytes() As Byte) As Byte()";
 //BA.debugLineNum = 568;BA.debugLine="Dim nrofbytes As UInt = bytes.Length";
_nrofbytes = (UInt) (_bytes->length);
 //BA.debugLineNum = 571;BA.debugLine="Dim bitsarraylen As UInt = nrofbytes * 8";
_bitsarraylen = (UInt) (_nrofbytes*8);
 //BA.debugLineNum = 574;BA.debugLine="Dim bits(bitsarraylen) As Byte";
_bits =be_ann193_4e2.wrapDynamic((Int) (_bitsarraylen), sizeof(Byte));
 //BA.debugLineNum = 577;BA.debugLine="For j = 0 To nrofbytes - 1";
{
const int step4 = 1;
const int limit4 = (Int) (_nrofbytes-1);
_j = 0 ;
for (;_j <= limit4 ;_j = _j + step4 ) {
 //BA.debugLineNum = 578;BA.debugLine="Dim b As Byte = bytes(j)";
_b = ((Byte*)_bytes->getData((UInt) (_j)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 579;BA.debugLine="For i = 0 To 7";
{
const int step6 = 1;
const int limit6 = 7;
_i = 0 ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 580;BA.debugLine="bits(j * 8 + i) = 48 + Bit.And(Bit.ShiftRight(b";
((Byte*)_bits->getData((UInt) (_j*8+_i)))[B4R::Array::staticIndex] = (Byte) (48+BitClass_And(BitClass_ShiftRight((UInt) (_b),(Byte) (7-_i)),(UInt) (1)));
 }
};
 }
};
 //BA.debugLineNum = 583;BA.debugLine="Return bits";
B4R::StackMemory::cp = cp;
B4R::Array* res10 = B4R::StackMemory::ReturnArrayOnStack(_bits, sizeof(Byte));
if (true) return res10;
 //BA.debugLineNum = 584;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_bytestobitsstring(B4R::Array* _bytes){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 1135;BA.debugLine="Public Sub BytesToBitsString(bytes() As Byte) As B";
 //BA.debugLineNum = 1136;BA.debugLine="Return BytesToBin(bytes)";
B4R::StackMemory::cp = cp;
B4R::Array* res1 = B4R::StackMemory::ReturnArrayOnStack(_bytestobin(_bytes), sizeof(Byte));
if (true) return res1;
 //BA.debugLineNum = 1137;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
Double b4r_convert::_bytestofloat(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _d = NULL;
 //BA.debugLineNum = 518;BA.debugLine="Public Sub BytesToFloat(b() As Byte) As Float";
 //BA.debugLineNum = 519;BA.debugLine="Dim d() As Double = ByteConv.DoublesFromBytes(b)";
_d = ByteConverter_DoublesFromBytes(_b);
 //BA.debugLineNum = 520;BA.debugLine="If d.Length > 0 Then";
if (_d->length>0) { 
 //BA.debugLineNum = 521;BA.debugLine="Return d(0)";
B4R::StackMemory::cp = cp;
Double res3 = (Double) (((Double*)_d->getData((UInt) (0)))[B4R::Array::staticIndex]);
if (true) return res3;
 }else {
 //BA.debugLineNum = 523;BA.debugLine="Return -1";
B4R::StackMemory::cp = cp;
Double res5 = (Double) (-1);
if (true) return res5;
 };
 //BA.debugLineNum = 525;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
Double b4r_convert::_bytestofloatscaled(B4R::Array* _b,Byte _fractions){
const UInt cp = B4R::StackMemory::cp;
Double _f = 0;
 //BA.debugLineNum = 530;BA.debugLine="Public Sub BytesToFloatScaled(b() As Byte, fractio";
 //BA.debugLineNum = 531;BA.debugLine="Dim f As Float = BytesToFloat(b)";
_f = _bytestofloat(_b);
 //BA.debugLineNum = 532;BA.debugLine="Return round(f * 10.0)/10.0";
B4R::StackMemory::cp = cp;
Double res2 = (Double) (Common_Round(_f*10.0)/(Double)10.0);
if (true) return res2;
 //BA.debugLineNum = 540;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::B4RString* b4r_convert::_bytestohex(B4R::Array* _bytes){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 232;BA.debugLine="Public Sub BytesToHex(bytes() As Byte) As String";
 //BA.debugLineNum = 233;BA.debugLine="Return ByteConv.HexFromBytes(bytes)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res1 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->HexFromBytes(_bytes));
if (true) return res1;
 //BA.debugLineNum = 234;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::B4RString* b4r_convert::_bytestostring(B4R::Array* _bytes){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 270;BA.debugLine="Public Sub BytesToString(bytes() As Byte) As Strin";
 //BA.debugLineNum = 271;BA.debugLine="Return ByteConv.StringFromBytes(bytes)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res1 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->StringFromBytes(_bytes));
if (true) return res1;
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
ULong b4r_convert::_bytestouint(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 402;BA.debugLine="Public Sub BytesToUInt(b() As Byte) As ULong";
 //BA.debugLineNum = 403;BA.debugLine="If b == Null Or b.Length <> 2 Then Return 0";
if (_b== NULL || _b->length!=2) { 
B4R::StackMemory::cp = cp;
ULong res1 = (ULong) (0);
if (true) return res1;};
 //BA.debugLineNum = 404;BA.debugLine="Return Bit.Or(Bit.And(b(0), 0xFF), Bit.ShiftLeft(";
B4R::StackMemory::cp = cp;
ULong res2 = (ULong) (BitClass_Or(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (8))));
if (true) return res2;
 //BA.debugLineNum = 405;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0L;
}
UInt b4r_convert::_bytestouint16swapped(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 775;BA.debugLine="Public Sub BytesToUInt16Swapped(b() As Byte) As UI";
 //BA.debugLineNum = 776;BA.debugLine="If b.Length <> 2 Then Return 0";
if (_b->length!=2) { 
B4R::StackMemory::cp = cp;
UInt res1 = (UInt) (0);
if (true) return res1;};
 //BA.debugLineNum = 777;BA.debugLine="Return Bit.Or(Bit.And(b(0), 0xFF), Bit.ShiftLeft(";
B4R::StackMemory::cp = cp;
UInt res2 = BitClass_Or(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (8)));
if (true) return res2;
 //BA.debugLineNum = 778;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
ULong b4r_convert::_bytestouint32swapped(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
ULong _result = 0L;
 //BA.debugLineNum = 797;BA.debugLine="Public Sub BytesToUInt32Swapped(b() As Byte) As UL";
 //BA.debugLineNum = 798;BA.debugLine="If b.Length <> 4 Then Return 0";
if (_b->length!=4) { 
B4R::StackMemory::cp = cp;
ULong res1 = (ULong) (0);
if (true) return res1;};
 //BA.debugLineNum = 799;BA.debugLine="Dim result As ULong = 0";
_result = (ULong) (0);
 //BA.debugLineNum = 800;BA.debugLine="result = Bit.Or(result, Bit.And(b(0), 0xFF))";
_result = (ULong) (BitClass_Or((UInt) (_result),BitClass_And((UInt) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff)))));
 //BA.debugLineNum = 801;BA.debugLine="result = Bit.Or(result, Bit.ShiftLeft(Bit.And(b(1";
_result = (ULong) (BitClass_Or((UInt) (_result),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (8))));
 //BA.debugLineNum = 802;BA.debugLine="result = Bit.Or(result, Bit.ShiftLeft(Bit.And(b(2";
_result = (ULong) (BitClass_Or((UInt) (_result),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (2)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (16))));
 //BA.debugLineNum = 803;BA.debugLine="result = Bit.Or(result, Bit.ShiftLeft(Bit.And(b(3";
_result = (ULong) (BitClass_Or((UInt) (_result),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (3)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (24))));
 //BA.debugLineNum = 804;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
ULong res7 = _result;
if (true) return res7;
 //BA.debugLineNum = 805;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0L;
}
ULong b4r_convert::_bytestoulong(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
ULong _result = 0L;
 //BA.debugLineNum = 471;BA.debugLine="Public Sub BytesToULong(b() As Byte) As ULong";
 //BA.debugLineNum = 472;BA.debugLine="If b == Null Or b.Length <> 4 Then Return 0";
if (_b== NULL || _b->length!=4) { 
B4R::StackMemory::cp = cp;
ULong res1 = (ULong) (0);
if (true) return res1;};
 //BA.debugLineNum = 473;BA.debugLine="Dim result As ULong = Bit.And(b(0), 0xFF)";
_result = (ULong) (BitClass_And((UInt) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 474;BA.debugLine="result = Bit.Or(result, Bit.ShiftLeft(Bit.And(b(1";
_result = (ULong) (BitClass_Or((UInt) (_result),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (8))));
 //BA.debugLineNum = 475;BA.debugLine="result = Bit.Or(result, Bit.ShiftLeft(Bit.And(b(2";
_result = (ULong) (BitClass_Or((UInt) (_result),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (2)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (16))));
 //BA.debugLineNum = 476;BA.debugLine="result = Bit.Or(result, Bit.ShiftLeft(Bit.And(b(3";
_result = (ULong) (BitClass_Or((UInt) (_result),BitClass_ShiftLeft(BitClass_And((UInt) (((Byte*)_b->getData((UInt) (3)))[B4R::Array::staticIndex]),(UInt) (((Int)0xff))),(Byte) (24))));
 //BA.debugLineNum = 477;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
ULong res6 = _result;
if (true) return res6;
 //BA.debugLineNum = 478;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0L;
}
UInt b4r_convert::_bytetobcd(Byte _value){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 634;BA.debugLine="Public Sub ByteToBCD(value As Byte) As UInt";
 //BA.debugLineNum = 635;BA.debugLine="If value > 99 Then Return 0xFF";
if (_value>99) { 
B4R::StackMemory::cp = cp;
UInt res1 = (UInt) (((Int)0xff));
if (true) return res1;};
 //BA.debugLineNum = 636;BA.debugLine="Return Bit.Or(Bit.ShiftLeft(value / 10, 4), va";
B4R::StackMemory::cp = cp;
UInt res2 = BitClass_Or(BitClass_ShiftLeft((UInt) (_value/(Double)10),(Byte) (4)),(UInt) (_value%10));
if (true) return res2;
 //BA.debugLineNum = 637;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::B4RString* b4r_convert::_bytetobcdbin(Byte _value){
const UInt cp = B4R::StackMemory::cp;
Byte _bcd = 0;
B4R::B4RString be_ann227_7;
Byte be_ann228_4e1[8];
B4R::Array be_ann228_4e2;
B4R::Array* _bits = NULL;
Int _i = 0;
 //BA.debugLineNum = 644;BA.debugLine="Public Sub ByteToBCDBin(value As Byte) As String";
 //BA.debugLineNum = 645;BA.debugLine="Dim bcd As Byte = ByteToBCD(value)";
_bcd = (Byte) (_bytetobcd(_value));
 //BA.debugLineNum = 646;BA.debugLine="If bcd = 0xFF Then Return \"Invalid\"";
if (_bcd==((Int)0xff)) { 
B4R::StackMemory::cp = cp;
B4R::B4RString* res2 = B4R::StackMemory::ReturnStringOnStack(be_ann227_7.wrap("Invalid"));
if (true) return res2;};
 //BA.debugLineNum = 648;BA.debugLine="Dim bits(8) As Byte";
_bits =be_ann228_4e2.wrap(be_ann228_4e1,8);
 //BA.debugLineNum = 650;BA.debugLine="For i = 0 To 7";
{
const int step4 = 1;
const int limit4 = 7;
_i = 0 ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 652;BA.debugLine="bits(i) = 48 + Bit.And(Bit.ShiftRight(bcd, 7 - i";
((Byte*)_bits->getData((UInt) (_i)))[B4R::Array::staticIndex] = (Byte) (48+BitClass_And(BitClass_ShiftRight((UInt) (_bcd),(Byte) (7-_i)),(UInt) (1)));
 }
};
 //BA.debugLineNum = 654;BA.debugLine="Return ByteConv.StringFromBytes(bits)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res7 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->StringFromBytes(_bits));
if (true) return res7;
 //BA.debugLineNum = 655;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::Array* b4r_convert::_bytetobin(Byte _b){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann184_4e1[8];
B4R::Array be_ann184_4e2;
B4R::Array* _bits = NULL;
Int _i = 0;
 //BA.debugLineNum = 551;BA.debugLine="Public Sub ByteToBin(b As Byte) As Byte()";
 //BA.debugLineNum = 552;BA.debugLine="Dim bits(8) As Byte";
_bits =be_ann184_4e2.wrap(be_ann184_4e1,8);
 //BA.debugLineNum = 553;BA.debugLine="For i = 0 To 7";
{
const int step2 = 1;
const int limit2 = 7;
_i = 0 ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 554;BA.debugLine="bits(i) = 48 + Bit.And(Bit.ShiftRight(b, 7 - i),";
((Byte*)_bits->getData((UInt) (_i)))[B4R::Array::staticIndex] = (Byte) (48+BitClass_And(BitClass_ShiftRight((UInt) (_b),(Byte) (7-_i)),(UInt) (1)));
 }
};
 //BA.debugLineNum = 556;BA.debugLine="Return bits";
B4R::StackMemory::cp = cp;
B4R::Array* res5 = B4R::StackMemory::ReturnArrayOnStack(_bits, sizeof(Byte));
if (true) return res5;
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_bytetobitsstring(Byte _b){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 1124;BA.debugLine="Public Sub ByteToBitsString(b As Byte) As Byte()";
 //BA.debugLineNum = 1125;BA.debugLine="Return ByteToBin(b)";
B4R::StackMemory::cp = cp;
B4R::Array* res1 = B4R::StackMemory::ReturnArrayOnStack(_bytetobin(_b), sizeof(Byte));
if (true) return res1;
 //BA.debugLineNum = 1126;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
bool b4r_convert::_bytetobool(Byte _b){
const UInt cp = B4R::StackMemory::cp;
B4R::Object be_ann19_10;
B4R::Object be_ann19_14;
 //BA.debugLineNum = 194;BA.debugLine="Public Sub ByteToBool(b As Byte) As Boolean";
 //BA.debugLineNum = 195;BA.debugLine="Return IIf(b == 1, True, False)";
B4R::StackMemory::cp = cp;
bool res1 = (bool)(((_b==1) ? (be_ann19_10.wrapNumber((Long)Common_True)) : (be_ann19_14.wrapNumber((Long)Common_False)))->toLong());
if (true) return res1;
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
B4R::B4RString* b4r_convert::_bytetohex(Byte _b){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann35_10e1[1];
B4R::Array be_ann35_10e2;
 //BA.debugLineNum = 240;BA.debugLine="Public Sub ByteToHex(b As Byte) As String";
 //BA.debugLineNum = 241;BA.debugLine="Return ByteConv.HexFromBytes(Array As Byte(b))";
B4R::StackMemory::cp = cp;
B4R::B4RString* res1 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->HexFromBytes(be_ann35_10e2.create(be_ann35_10e1,1,1,_b)));
if (true) return res1;
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::Array* b4r_convert::_colortorgb(ULong _color){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann597_4e1[3];
B4R::Array be_ann597_4e2;
B4R::Array* _rgb = NULL;
 //BA.debugLineNum = 1346;BA.debugLine="Public Sub ColorToRGB(color As ULong) As Byte()";
 //BA.debugLineNum = 1347;BA.debugLine="Dim rgb(3) As Byte";
_rgb =be_ann597_4e2.wrap(be_ann597_4e1,3);
 //BA.debugLineNum = 1348;BA.debugLine="rgb(0) = Bit.And(Bit.ShiftRight(color, 16), 0xFF)";
((Byte*)_rgb->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_color),(Byte) (16)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 1349;BA.debugLine="rgb(1) = Bit.And(Bit.ShiftRight(color, 8), 0xFF)";
((Byte*)_rgb->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_color),(Byte) (8)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 1350;BA.debugLine="rgb(2) = Bit.And(color, 0xFF)";
((Byte*)_rgb->getData((UInt) (2)))[B4R::Array::staticIndex] = (Byte) (BitClass_And((UInt) (_color),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 1351;BA.debugLine="Return rgb";
B4R::StackMemory::cp = cp;
B4R::Array* res5 = B4R::StackMemory::ReturnArrayOnStack(_rgb, sizeof(Byte));
if (true) return res5;
 //BA.debugLineNum = 1352;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::B4RString* b4r_convert::_csvcheckvalue(B4R::Array* _item,Int _index,B4R::B4RString* _tag){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString* _str = B4R::B4RString::EMPTY;
B4R::B4RString be_ann480_1;
B4R::B4RString be_ann483_1;
 //BA.debugLineNum = 1161;BA.debugLine="Private Sub CSVCheckValue(item() As Byte, index As";
 //BA.debugLineNum = 1162;BA.debugLine="Dim str As String = ByteConv.StringFromBytes(item";
_str = b4r_convert::_byteconv->StringFromBytes(_item);
 //BA.debugLineNum = 1163;BA.debugLine="str = StringTrim(str)";
_str = _stringtrim(_str);
 //BA.debugLineNum = 1165;BA.debugLine="If str.Length = 0 Then";
if (_str->getLength()==0) { 
 //BA.debugLineNum = 1166;BA.debugLine="If SplitAllowEmptyAsZero Then";
if (b4r_convert::_splitallowemptyaszero) { 
 //BA.debugLineNum = 1167;BA.debugLine="Return \"0\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res5 = B4R::StackMemory::ReturnStringOnStack(be_ann480_1.wrap("0"));
if (true) return res5;
 }else {
 //BA.debugLineNum = 1169;BA.debugLine="Log(\"[\", tag, \"][E] Empty item at index \", inde";
B4R::Common::LogHelper(5,102,F("["),101,_tag->data,102,F("][E] Empty item at index "),3,_index,102,F(" not allowed."));
 //BA.debugLineNum = 1170;BA.debugLine="Return \"\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res8 = B4R::StackMemory::ReturnStringOnStack(be_ann483_1.wrap(""));
if (true) return res8;
 };
 };
 //BA.debugLineNum = 1173;BA.debugLine="Return str";
B4R::StackMemory::cp = cp;
B4R::B4RString* res11 = B4R::StackMemory::ReturnStringOnStack(_str);
if (true) return res11;
 //BA.debugLineNum = 1174;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
Int b4r_convert::_csvcountitems(B4R::Array* _buffer,B4R::B4RString* _separator){
const UInt cp = B4R::StackMemory::cp;
Int _count = 0;
B4R::Array* _item = NULL;
 //BA.debugLineNum = 1148;BA.debugLine="Public Sub CSVCountItems(buffer() As Byte, separat";
 //BA.debugLineNum = 1149;BA.debugLine="Dim count As Int";
_count = 0;
 //BA.debugLineNum = 1150;BA.debugLine="For Each item() As Byte In ByteConv.Split(buffer,";
B4R::Iterator* group2 = b4r_convert::_byteconv->Split(_buffer,(_separator)->GetBytes());
while (group2->MoveNext()) {
_item = (B4R::Array*)B4R::Object::toPointer(group2->Get());
 //BA.debugLineNum = 1151;BA.debugLine="count = count + 1";
_count = (Int) (_count+1);
 }
;
 //BA.debugLineNum = 1153;BA.debugLine="Return count";
B4R::StackMemory::cp = cp;
Int res5 = _count;
if (true) return res5;
 //BA.debugLineNum = 1154;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::Array* b4r_convert::_csvtobytes(B4R::Array* _buffer,B4R::B4RString* _separator){
const UInt cp = B4R::StackMemory::cp;
Int _count = 0;
B4R::Array be_ann490_4e2;
B4R::Array* _result = NULL;
Byte be_ann491_4e1[0];
B4R::Array be_ann491_4e2;
B4R::Array* _error = NULL;
Int _counter = 0;
B4R::Array* _item = NULL;
B4R::B4RString be_ann494_11;
B4R::B4RString* _str = B4R::B4RString::EMPTY;
B4R::B4RString be_ann495_4;
Int _num = 0;
 //BA.debugLineNum = 1180;BA.debugLine="Public Sub CSVToBytes(buffer() As Byte, separator";
 //BA.debugLineNum = 1181;BA.debugLine="Dim count As Int = CSVCountItems(buffer, separato";
_count = _csvcountitems(_buffer,_separator);
 //BA.debugLineNum = 1182;BA.debugLine="Dim result(count) As Byte";
_result =be_ann490_4e2.wrapDynamic(_count, sizeof(Byte));
 //BA.debugLineNum = 1183;BA.debugLine="Dim error() As Byte";
_error =be_ann491_4e2.wrap(be_ann491_4e1,0);
 //BA.debugLineNum = 1184;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 1186;BA.debugLine="For Each item() As Byte In ByteConv.Split(buffer,";
B4R::Iterator* group5 = b4r_convert::_byteconv->Split(_buffer,(_separator)->GetBytes());
while (group5->MoveNext()) {
_item = (B4R::Array*)B4R::Object::toPointer(group5->Get());
 //BA.debugLineNum = 1187;BA.debugLine="Dim str As String = CSVCheckValue(item, counter,";
_str = _csvcheckvalue(_item,_counter,be_ann494_11.wrap("CSVToBytes"));
 //BA.debugLineNum = 1188;BA.debugLine="If str = \"\" Then Return error";
if ((_str)->equals(be_ann495_4.wrap(""))) { 
B4R::StackMemory::cp = cp;
B4R::Array* res7 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Byte));
if (true) return res7;};
 //BA.debugLineNum = 1190;BA.debugLine="If IsNumber(str) Then";
if (B4R::__c->IsNumber(_str)) { 
 //BA.debugLineNum = 1191;BA.debugLine="Dim num As Int = str";
_num = (Int)(atof(_str->data));
 //BA.debugLineNum = 1192;BA.debugLine="If num < BYTE_MIN Or num > BYTE_MAX Then";
if (_num<b4r_convert::_byte_min || _num>b4r_convert::_byte_max) { 
 //BA.debugLineNum = 1193;BA.debugLine="Log(\"[CSVToBytes][E] Item \", str, \" (index \",";
B4R::Common::LogHelper(9,102,F("[CSVToBytes][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") out of range "),1,b4r_convert::_byte_min,102,F("–"),1,b4r_convert::_byte_max,102,F("."));
 //BA.debugLineNum = 1195;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res12 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Byte));
if (true) return res12;
 };
 //BA.debugLineNum = 1197;BA.debugLine="result(counter) = num";
((Byte*)_result->getData((UInt) (_counter)))[B4R::Array::staticIndex] = (Byte) (_num);
 }else {
 //BA.debugLineNum = 1199;BA.debugLine="Log(\"[CSVToBytes][E] Item \", str, \" (index \", c";
B4R::Common::LogHelper(5,102,F("[CSVToBytes][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") is not a number."));
 //BA.debugLineNum = 1200;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res17 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Byte));
if (true) return res17;
 };
 //BA.debugLineNum = 1202;BA.debugLine="counter = counter + 1";
_counter = (Int) (_counter+1);
 }
;
 //BA.debugLineNum = 1204;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
B4R::Array* res21 = B4R::StackMemory::ReturnArrayOnStack(_result, sizeof(Byte));
if (true) return res21;
 //BA.debugLineNum = 1205;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_csvtofloats(B4R::Array* _buffer,B4R::B4RString* _separator){
const UInt cp = B4R::StackMemory::cp;
Int _count = 0;
B4R::Array be_ann577_4e2;
B4R::Array* _result = NULL;
Double be_ann578_4e1[0];
B4R::Array be_ann578_4e2;
B4R::Array* _error = NULL;
Int _counter = 0;
B4R::Array* _item = NULL;
B4R::B4RString be_ann581_11;
B4R::B4RString* _str = B4R::B4RString::EMPTY;
B4R::B4RString be_ann582_4;
 //BA.debugLineNum = 1298;BA.debugLine="Public Sub CSVToFloats(buffer() As Byte, separator";
 //BA.debugLineNum = 1299;BA.debugLine="Dim count As Int = CSVCountItems(buffer, separato";
_count = _csvcountitems(_buffer,_separator);
 //BA.debugLineNum = 1300;BA.debugLine="Dim result(count) As Float";
_result =be_ann577_4e2.wrapDynamic(_count, sizeof(Double));
 //BA.debugLineNum = 1301;BA.debugLine="Dim error() As Float";
_error =be_ann578_4e2.wrap(be_ann578_4e1,0);
 //BA.debugLineNum = 1302;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 1304;BA.debugLine="For Each item() As Byte In ByteConv.Split(buffer,";
B4R::Iterator* group5 = b4r_convert::_byteconv->Split(_buffer,(_separator)->GetBytes());
while (group5->MoveNext()) {
_item = (B4R::Array*)B4R::Object::toPointer(group5->Get());
 //BA.debugLineNum = 1305;BA.debugLine="Dim str As String = CSVCheckValue(item, counter,";
_str = _csvcheckvalue(_item,_counter,be_ann581_11.wrap("CSVToFloats"));
 //BA.debugLineNum = 1306;BA.debugLine="If str = \"\" Then Return error";
if ((_str)->equals(be_ann582_4.wrap(""))) { 
B4R::StackMemory::cp = cp;
B4R::Array* res7 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Double));
if (true) return res7;};
 //BA.debugLineNum = 1308;BA.debugLine="If IsNumber(str) Then";
if (B4R::__c->IsNumber(_str)) { 
 //BA.debugLineNum = 1309;BA.debugLine="result(counter) = str";
((Double*)_result->getData((UInt) (_counter)))[B4R::Array::staticIndex] = (Double)(atof(_str->data));
 }else {
 //BA.debugLineNum = 1311;BA.debugLine="Log(\"[CSVToFloats][E] Item \", str, \" (index \",";
B4R::Common::LogHelper(5,102,F("[CSVToFloats][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") is not a number."));
 //BA.debugLineNum = 1312;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res12 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Double));
if (true) return res12;
 };
 //BA.debugLineNum = 1314;BA.debugLine="counter = counter + 1";
_counter = (Int) (_counter+1);
 }
;
 //BA.debugLineNum = 1316;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
B4R::Array* res16 = B4R::StackMemory::ReturnArrayOnStack(_result, sizeof(Double));
if (true) return res16;
 //BA.debugLineNum = 1317;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_csvtoints(B4R::Array* _buffer,B4R::B4RString* _separator){
const UInt cp = B4R::StackMemory::cp;
Int _count = 0;
B4R::Array be_ann513_4e2;
B4R::Array* _result = NULL;
Int be_ann514_4e1[0];
B4R::Array be_ann514_4e2;
B4R::Array* _error = NULL;
Int _counter = 0;
B4R::Array* _item = NULL;
B4R::B4RString be_ann517_11;
B4R::B4RString* _str = B4R::B4RString::EMPTY;
B4R::B4RString be_ann518_4;
Int _num = 0;
 //BA.debugLineNum = 1211;BA.debugLine="Public Sub CSVToInts(buffer() As Byte, separator A";
 //BA.debugLineNum = 1212;BA.debugLine="Dim count As Int = CSVCountItems(buffer, separato";
_count = _csvcountitems(_buffer,_separator);
 //BA.debugLineNum = 1213;BA.debugLine="Dim result(count) As Int";
_result =be_ann513_4e2.wrapDynamic(_count, sizeof(Int));
 //BA.debugLineNum = 1214;BA.debugLine="Dim error() As Int";
_error =be_ann514_4e2.wrap(be_ann514_4e1,0);
 //BA.debugLineNum = 1215;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 1217;BA.debugLine="For Each item() As Byte In ByteConv.Split(buffer,";
B4R::Iterator* group5 = b4r_convert::_byteconv->Split(_buffer,(_separator)->GetBytes());
while (group5->MoveNext()) {
_item = (B4R::Array*)B4R::Object::toPointer(group5->Get());
 //BA.debugLineNum = 1218;BA.debugLine="Dim str As String = CSVCheckValue(item, counter,";
_str = _csvcheckvalue(_item,_counter,be_ann517_11.wrap("CSVToInts"));
 //BA.debugLineNum = 1219;BA.debugLine="If str = \"\" Then Return error";
if ((_str)->equals(be_ann518_4.wrap(""))) { 
B4R::StackMemory::cp = cp;
B4R::Array* res7 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Int));
if (true) return res7;};
 //BA.debugLineNum = 1221;BA.debugLine="If IsNumber(str) Then";
if (B4R::__c->IsNumber(_str)) { 
 //BA.debugLineNum = 1222;BA.debugLine="Dim num As Int = str";
_num = (Int)(atof(_str->data));
 //BA.debugLineNum = 1223;BA.debugLine="If num < INT16_MIN Or num > INT16_MAX Then";
if (_num<b4r_convert::_int16_min || _num>b4r_convert::_int16_max) { 
 //BA.debugLineNum = 1224;BA.debugLine="Log(\"[CSVToInts][E] Item \", str, \" (index \", c";
B4R::Common::LogHelper(9,102,F("[CSVToInts][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") out of range "),3,b4r_convert::_int16_min,102,F("–"),3,b4r_convert::_int16_max,102,F("."));
 //BA.debugLineNum = 1226;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res12 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Int));
if (true) return res12;
 };
 //BA.debugLineNum = 1228;BA.debugLine="result(counter) = num";
((Int*)_result->getData((UInt) (_counter)))[B4R::Array::staticIndex] = _num;
 }else {
 //BA.debugLineNum = 1230;BA.debugLine="Log(\"[CSVToInts][E] Item \", str, \" (index \", co";
B4R::Common::LogHelper(5,102,F("[CSVToInts][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") is not a number."));
 //BA.debugLineNum = 1231;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res17 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(Int));
if (true) return res17;
 };
 //BA.debugLineNum = 1233;BA.debugLine="counter = counter + 1";
_counter = (Int) (_counter+1);
 }
;
 //BA.debugLineNum = 1235;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
B4R::Array* res21 = B4R::StackMemory::ReturnArrayOnStack(_result, sizeof(Int));
if (true) return res21;
 //BA.debugLineNum = 1236;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_csvtouints(B4R::Array* _buffer,B4R::B4RString* _separator){
const UInt cp = B4R::StackMemory::cp;
Int _count = 0;
B4R::Array be_ann536_4e2;
B4R::Array* _result = NULL;
UInt be_ann537_4e1[0];
B4R::Array be_ann537_4e2;
B4R::Array* _error = NULL;
Int _counter = 0;
B4R::Array* _item = NULL;
B4R::B4RString be_ann540_11;
B4R::B4RString* _str = B4R::B4RString::EMPTY;
B4R::B4RString be_ann541_4;
Double _num = 0;
 //BA.debugLineNum = 1242;BA.debugLine="Public Sub CSVToUInts(buffer() As Byte, separator";
 //BA.debugLineNum = 1243;BA.debugLine="Dim count As Int = CSVCountItems(buffer, separato";
_count = _csvcountitems(_buffer,_separator);
 //BA.debugLineNum = 1244;BA.debugLine="Dim result(count) As UInt";
_result =be_ann536_4e2.wrapDynamic(_count, sizeof(UInt));
 //BA.debugLineNum = 1245;BA.debugLine="Dim error() As UInt";
_error =be_ann537_4e2.wrap(be_ann537_4e1,0);
 //BA.debugLineNum = 1246;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 1248;BA.debugLine="For Each item() As Byte In ByteConv.Split(buffer,";
B4R::Iterator* group5 = b4r_convert::_byteconv->Split(_buffer,(_separator)->GetBytes());
while (group5->MoveNext()) {
_item = (B4R::Array*)B4R::Object::toPointer(group5->Get());
 //BA.debugLineNum = 1249;BA.debugLine="Dim str As String = CSVCheckValue(item, counter,";
_str = _csvcheckvalue(_item,_counter,be_ann540_11.wrap("CSVToUInts"));
 //BA.debugLineNum = 1250;BA.debugLine="If str = \"\" Then Return error";
if ((_str)->equals(be_ann541_4.wrap(""))) { 
B4R::StackMemory::cp = cp;
B4R::Array* res7 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(UInt));
if (true) return res7;};
 //BA.debugLineNum = 1252;BA.debugLine="If IsNumber(str) Then";
if (B4R::__c->IsNumber(_str)) { 
 //BA.debugLineNum = 1253;BA.debugLine="Dim num As Float = str";
_num = (Double)(atof(_str->data));
 //BA.debugLineNum = 1254;BA.debugLine="If num < 0 Or num > UINT16_MAX Then";
if (_num<0 || _num>b4r_convert::_uint16_max) { 
 //BA.debugLineNum = 1255;BA.debugLine="Log(\"[CSVToUInts][E] Item \", str, \" (index \",";
B4R::Common::LogHelper(7,102,F("[CSVToUInts][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") out of range 0–"),6,b4r_convert::_uint16_max,102,F("."));
 //BA.debugLineNum = 1257;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res12 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(UInt));
if (true) return res12;
 };
 //BA.debugLineNum = 1259;BA.debugLine="result(counter) = num";
((UInt*)_result->getData((UInt) (_counter)))[B4R::Array::staticIndex] = (UInt) (_num);
 }else {
 //BA.debugLineNum = 1261;BA.debugLine="Log(\"[CSVToUInts][E] Item \", str, \" (index \", c";
B4R::Common::LogHelper(5,102,F("[CSVToUInts][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") is not a number."));
 //BA.debugLineNum = 1262;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res17 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(UInt));
if (true) return res17;
 };
 //BA.debugLineNum = 1264;BA.debugLine="counter = counter + 1";
_counter = (Int) (_counter+1);
 }
;
 //BA.debugLineNum = 1266;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
B4R::Array* res21 = B4R::StackMemory::ReturnArrayOnStack(_result, sizeof(UInt));
if (true) return res21;
 //BA.debugLineNum = 1267;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_csvtoulongs(B4R::Array* _buffer,B4R::B4RString* _separator){
const UInt cp = B4R::StackMemory::cp;
Int _count = 0;
B4R::Array be_ann559_4e2;
B4R::Array* _result = NULL;
ULong be_ann560_4e1[0];
B4R::Array be_ann560_4e2;
B4R::Array* _error = NULL;
Int _counter = 0;
B4R::Array* _item = NULL;
B4R::B4RString be_ann563_11;
B4R::B4RString* _str = B4R::B4RString::EMPTY;
B4R::B4RString be_ann564_4;
 //BA.debugLineNum = 1273;BA.debugLine="Public Sub CSVToULongs(buffer() As Byte, separator";
 //BA.debugLineNum = 1274;BA.debugLine="Dim count As Int = CSVCountItems(buffer, separato";
_count = _csvcountitems(_buffer,_separator);
 //BA.debugLineNum = 1275;BA.debugLine="Dim result(count) As ULong";
_result =be_ann559_4e2.wrapDynamic(_count, sizeof(ULong));
 //BA.debugLineNum = 1276;BA.debugLine="Dim error() As ULong";
_error =be_ann560_4e2.wrap(be_ann560_4e1,0);
 //BA.debugLineNum = 1277;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 1279;BA.debugLine="For Each item() As Byte In ByteConv.Split(buffer,";
B4R::Iterator* group5 = b4r_convert::_byteconv->Split(_buffer,(_separator)->GetBytes());
while (group5->MoveNext()) {
_item = (B4R::Array*)B4R::Object::toPointer(group5->Get());
 //BA.debugLineNum = 1280;BA.debugLine="Dim str As String = CSVCheckValue(item, counter,";
_str = _csvcheckvalue(_item,_counter,be_ann563_11.wrap("CSVToULongs"));
 //BA.debugLineNum = 1281;BA.debugLine="If str = \"\" Then Return error";
if ((_str)->equals(be_ann564_4.wrap(""))) { 
B4R::StackMemory::cp = cp;
B4R::Array* res7 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(ULong));
if (true) return res7;};
 //BA.debugLineNum = 1283;BA.debugLine="If IsNumber(str) Then";
if (B4R::__c->IsNumber(_str)) { 
 //BA.debugLineNum = 1284;BA.debugLine="result(counter) = str";
((ULong*)_result->getData((UInt) (_counter)))[B4R::Array::staticIndex] = (ULong)(atof(_str->data));
 }else {
 //BA.debugLineNum = 1286;BA.debugLine="Log(\"[CSVToULongs][E] Item \", str, \" (index \",";
B4R::Common::LogHelper(5,102,F("[CSVToULongs][E] Item "),101,_str->data,102,F(" (index "),3,_counter,102,F(") is not a number."));
 //BA.debugLineNum = 1287;BA.debugLine="Return error";
B4R::StackMemory::cp = cp;
B4R::Array* res12 = B4R::StackMemory::ReturnArrayOnStack(_error, sizeof(ULong));
if (true) return res12;
 };
 //BA.debugLineNum = 1289;BA.debugLine="counter = counter + 1";
_counter = (Int) (_counter+1);
 }
;
 //BA.debugLineNum = 1291;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
B4R::Array* res16 = B4R::StackMemory::ReturnArrayOnStack(_result, sizeof(ULong));
if (true) return res16;
 //BA.debugLineNum = 1292;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::B4RString* b4r_convert::_directiontostring(Byte _direction){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString be_ann622_1;
B4R::B4RString be_ann624_1;
B4R::B4RString be_ann626_1;
B4R::B4RString be_ann628_1;
B4R::B4RString be_ann630_1;
 //BA.debugLineNum = 1400;BA.debugLine="Public Sub DirectionToString(direction As Byte) As";
 //BA.debugLineNum = 1401;BA.debugLine="Select direction";
switch ((Int) (_direction)) {
case 0: {
 //BA.debugLineNum = 1402;BA.debugLine="Case 0: Return \"RIGHT\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res3 = B4R::StackMemory::ReturnStringOnStack(be_ann622_1.wrap("RIGHT"));
if (true) return res3;
 break; }
case 1: {
 //BA.debugLineNum = 1403;BA.debugLine="Case 1: Return \"LEFT\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res5 = B4R::StackMemory::ReturnStringOnStack(be_ann624_1.wrap("LEFT"));
if (true) return res5;
 break; }
case 2: {
 //BA.debugLineNum = 1404;BA.debugLine="Case 2: Return \"UP\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res7 = B4R::StackMemory::ReturnStringOnStack(be_ann626_1.wrap("UP"));
if (true) return res7;
 break; }
case 3: {
 //BA.debugLineNum = 1405;BA.debugLine="Case 3: Return \"DOWN\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res9 = B4R::StackMemory::ReturnStringOnStack(be_ann628_1.wrap("DOWN"));
if (true) return res9;
 break; }
default: {
 //BA.debugLineNum = 1407;BA.debugLine="Return \"\"";
B4R::StackMemory::cp = cp;
B4R::B4RString* res11 = B4R::StackMemory::ReturnStringOnStack(be_ann630_1.wrap(""));
if (true) return res11;
 break; }
}
;
 //BA.debugLineNum = 1409;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
bool b4r_convert::_equalsignorecase(B4R::B4RString* _s1,B4R::B4RString* _s2){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _b1 = NULL;
B4R::Array* _b2 = NULL;
Int _i = 0;
Byte _c1 = 0;
Byte _c2 = 0;
 //BA.debugLineNum = 906;BA.debugLine="Public Sub EqualsIgnoreCase(s1 As String, s2 As St";
 //BA.debugLineNum = 907;BA.debugLine="Dim b1() As Byte = s1.GetBytes";
_b1 = _s1->GetBytes();
 //BA.debugLineNum = 908;BA.debugLine="Dim b2() As Byte = s2.GetBytes";
_b2 = _s2->GetBytes();
 //BA.debugLineNum = 909;BA.debugLine="If b1.Length <> b2.Length Then Return False";
if (_b1->length!=_b2->length) { 
B4R::StackMemory::cp = cp;
bool res3 = Common_False;
if (true) return res3;};
 //BA.debugLineNum = 911;BA.debugLine="For i = 0 To b1.Length - 1";
{
const int step4 = 1;
const int limit4 = (Int) (_b1->length-1);
_i = 0 ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 912;BA.debugLine="Dim c1 As Byte = b1(i)";
_c1 = ((Byte*)_b1->getData((UInt) (_i)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 913;BA.debugLine="Dim c2 As Byte = b2(i)";
_c2 = ((Byte*)_b2->getData((UInt) (_i)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 915;BA.debugLine="If c1 >= 65 And c1 <= 90 Then c1 = c1 + 32 ' A-Z";
if (_c1>=65 && _c1<=90) { 
_c1 = (Byte) (_c1+32);};
 //BA.debugLineNum = 916;BA.debugLine="If c2 >= 65 And c2 <= 90 Then c2 = c2 + 32";
if (_c2>=65 && _c2<=90) { 
_c2 = (Byte) (_c2+32);};
 //BA.debugLineNum = 918;BA.debugLine="If c1 <> c2 Then Return False";
if (_c1!=_c2) { 
B4R::StackMemory::cp = cp;
bool res9 = Common_False;
if (true) return res9;};
 }
};
 //BA.debugLineNum = 921;BA.debugLine="Return True";
B4R::StackMemory::cp = cp;
bool res11 = Common_True;
if (true) return res11;
 //BA.debugLineNum = 922;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
B4R::Array* b4r_convert::_floattobytes(Double _f){
const UInt cp = B4R::StackMemory::cp;
Double be_ann168_17e1[1];
B4R::Array be_ann168_17e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 509;BA.debugLine="Public Sub FloatToBytes(f As Float) As Byte()";
 //BA.debugLineNum = 510;BA.debugLine="Dim b(4) As Byte = ByteConv.DoublesToBytes(Array";
_b = ByteConverter_DoublesToBytes(be_ann168_17e2.create(be_ann168_17e1,1,7,_f));
 //BA.debugLineNum = 511;BA.debugLine="Return b";
B4R::StackMemory::cp = cp;
B4R::Array* res2 = B4R::StackMemory::ReturnArrayOnStack(_b, sizeof(Byte));
if (true) return res2;
 //BA.debugLineNum = 512;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
bool b4r_convert::_getbit(Byte _b,Int _index){
const UInt cp = B4R::StackMemory::cp;
Byte _mask = 0;
 //BA.debugLineNum = 1113;BA.debugLine="Public Sub GetBit(b As Byte, index As Int) As Bool";
 //BA.debugLineNum = 1114;BA.debugLine="Dim mask As Byte = Bit.ShiftLeft(1, index)";
_mask = (Byte) (BitClass_ShiftLeft((UInt) (1),(Byte) (_index)));
 //BA.debugLineNum = 1115;BA.debugLine="Return Bit.And(b, mask) = mask";
B4R::StackMemory::cp = cp;
bool res2 = BitClass_And((UInt) (_b),(UInt) (_mask))==_mask;
if (true) return res2;
 //BA.debugLineNum = 1116;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
bool b4r_convert::_inttobool(Int _value){
const UInt cp = B4R::StackMemory::cp;
B4R::Object be_ann70_10;
B4R::Object be_ann70_14;
 //BA.debugLineNum = 314;BA.debugLine="Public Sub IntToBool(value As Int) As Boolean";
 //BA.debugLineNum = 315;BA.debugLine="Return IIf(value == 0, False, True)";
B4R::StackMemory::cp = cp;
bool res1 = (bool)(((_value==0) ? (be_ann70_10.wrapNumber((Long)Common_False)) : (be_ann70_14.wrapNumber((Long)Common_True)))->toLong());
if (true) return res1;
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
B4R::B4RString* b4r_convert::_millistobytes(Long _ms){
const UInt cp = B4R::StackMemory::cp;
Long _totalsec = 0L;
Int _hours = 0;
Int _minutes = 0;
Int _seconds = 0;
Byte be_ann608_4e1[8];
B4R::Array be_ann608_4e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 1366;BA.debugLine="Public Sub MillisToBytes(ms As Long) As String";
 //BA.debugLineNum = 1367;BA.debugLine="Dim totalSec	As Long = ms / 1000";
_totalsec = (Long) (_ms/(Double)1000);
 //BA.debugLineNum = 1368;BA.debugLine="Dim hours 		As Int = totalSec / 3600";
_hours = (Int) (_totalsec/(Double)3600);
 //BA.debugLineNum = 1369;BA.debugLine="Dim minutes 	As Int = (totalSec Mod 3600) / 60";
_minutes = (Int) ((_totalsec%3600)/(Double)60);
 //BA.debugLineNum = 1370;BA.debugLine="Dim seconds 	As Int = totalSec Mod 60";
_seconds = (Int) (_totalsec%60);
 //BA.debugLineNum = 1373;BA.debugLine="Dim b(8) As Byte				' byte range 0-7 for 8 bytes";
_b =be_ann608_4e2.wrap(be_ann608_4e1,8);
 //BA.debugLineNum = 1376;BA.debugLine="b(0) = 48 + hours / 10      	' tens digit";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (48+_hours/(Double)10);
 //BA.debugLineNum = 1377;BA.debugLine="b(1) = 48 + hours Mod 10    	' units digit";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (48+_hours%10);
 //BA.debugLineNum = 1378;BA.debugLine="b(2) = 58                    	' colon \":\"";
((Byte*)_b->getData((UInt) (2)))[B4R::Array::staticIndex] = (Byte) (58);
 //BA.debugLineNum = 1381;BA.debugLine="b(3) = 48 + minutes / 10";
((Byte*)_b->getData((UInt) (3)))[B4R::Array::staticIndex] = (Byte) (48+_minutes/(Double)10);
 //BA.debugLineNum = 1382;BA.debugLine="b(4) = 48 + minutes Mod 10";
((Byte*)_b->getData((UInt) (4)))[B4R::Array::staticIndex] = (Byte) (48+_minutes%10);
 //BA.debugLineNum = 1383;BA.debugLine="b(5) = 58";
((Byte*)_b->getData((UInt) (5)))[B4R::Array::staticIndex] = (Byte) (58);
 //BA.debugLineNum = 1386;BA.debugLine="b(6) = 48 + seconds / 10";
((Byte*)_b->getData((UInt) (6)))[B4R::Array::staticIndex] = (Byte) (48+_seconds/(Double)10);
 //BA.debugLineNum = 1387;BA.debugLine="b(7) = 48 + seconds Mod 10";
((Byte*)_b->getData((UInt) (7)))[B4R::Array::staticIndex] = (Byte) (48+_seconds%10);
 //BA.debugLineNum = 1390;BA.debugLine="Return BytesToString(b)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res14 = B4R::StackMemory::ReturnStringOnStack(_bytestostring(_b));
if (true) return res14;
 //BA.debugLineNum = 1391;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::Array* b4r_convert::_modbuscrc16(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
UInt _crc = 0;
Int _i = 0;
Int _j = 0;
Byte be_ann416_4e1[2];
B4R::Array be_ann416_4e2;
B4R::Array* _result = NULL;
 //BA.debugLineNum = 999;BA.debugLine="Public Sub ModbusCRC16(frame() As Byte) As Byte()";
 //BA.debugLineNum = 1000;BA.debugLine="Dim CRC As UInt = 0xFFFF";
_crc = (UInt) (((Int)0xffff));
 //BA.debugLineNum = 1002;BA.debugLine="For i = 0 To frame.Length - 1";
{
const int step2 = 1;
const int limit2 = (Int) (_frame->length-1);
_i = 0 ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 1003;BA.debugLine="CRC = Bit.Xor(CRC, frame(i))";
_crc = BitClass_Xor(_crc,(UInt) (((Byte*)_frame->getData((UInt) (_i)))[B4R::Array::staticIndex]));
 //BA.debugLineNum = 1004;BA.debugLine="For j = 0 To 7";
{
const int step4 = 1;
const int limit4 = 7;
_j = 0 ;
for (;_j <= limit4 ;_j = _j + step4 ) {
 //BA.debugLineNum = 1005;BA.debugLine="If Bit.And(CRC, 1) <> 0 Then";
if (BitClass_And(_crc,(UInt) (1))!=0) { 
 //BA.debugLineNum = 1006;BA.debugLine="CRC = Bit.ShiftRight(CRC, 1)";
_crc = BitClass_ShiftRight(_crc,(Byte) (1));
 //BA.debugLineNum = 1007;BA.debugLine="CRC = Bit.Xor(CRC, MODBUS_POLYNOMIAL)";
_crc = BitClass_Xor(_crc,(UInt) (b4r_convert::_modbus_polynomial));
 }else {
 //BA.debugLineNum = 1009;BA.debugLine="CRC = Bit.ShiftRight(CRC, 1)";
_crc = BitClass_ShiftRight(_crc,(Byte) (1));
 };
 }
};
 }
};
 //BA.debugLineNum = 1014;BA.debugLine="Dim result(2) As Byte";
_result =be_ann416_4e2.wrap(be_ann416_4e1,2);
 //BA.debugLineNum = 1015;BA.debugLine="result(0) = Bit.And(CRC, 0xFF)                  '";
((Byte*)_result->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(_crc,(UInt) (((Int)0xff))));
 //BA.debugLineNum = 1016;BA.debugLine="result(1) = Bit.And(Bit.ShiftRight(CRC, 8), 0xFF)";
((Byte*)_result->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight(_crc,(Byte) (8)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 1017;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
B4R::Array* res16 = B4R::StackMemory::ReturnArrayOnStack(_result, sizeof(Byte));
if (true) return res16;
 //BA.debugLineNum = 1018;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
bool b4r_convert::_modbuscrc16check(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
B4R::Array be_ann438_8e2;
B4R::Array* _data = NULL;
B4R::Array* _expected = NULL;
 //BA.debugLineNum = 1055;BA.debugLine="Public Sub ModbusCRC16Check(frame() As Byte) As Bo";
 //BA.debugLineNum = 1056;BA.debugLine="If frame = Null Or frame.Length < 3 Then Return F";
if (_frame== NULL || _frame->length<3) { 
B4R::StackMemory::cp = cp;
bool res1 = Common_False;
if (true) return res1;};
 //BA.debugLineNum = 1058;BA.debugLine="Dim data(frame.Length - 2) As Byte";
_data =be_ann438_8e2.wrapDynamic((Int) (_frame->length-2), sizeof(Byte));
 //BA.debugLineNum = 1059;BA.debugLine="ByteConv.ArrayCopy2(frame, 0, data, 0, frame.Leng";
b4r_convert::_byteconv->ArrayCopy2(_frame,(UInt) (0),_data,(UInt) (0),(UInt) (_frame->length-2));
 //BA.debugLineNum = 1061;BA.debugLine="Dim expected() As Byte = ModbusCRC16(data)";
_expected = _modbuscrc16(_data);
 //BA.debugLineNum = 1062;BA.debugLine="Return expected(0) = frame(frame.Length - 2) And";
B4R::StackMemory::cp = cp;
bool res5 = ((Byte*)_expected->getData((UInt) (0)))[B4R::Array::staticIndex]==((Byte*)_frame->getData((UInt) (_frame->length-2)))[B4R::Array::staticIndex] && ((Byte*)_expected->getData((UInt) (1)))[B4R::Array::staticIndex]==((Byte*)_frame->getData((UInt) (_frame->length-1)))[B4R::Array::staticIndex];
if (true) return res5;
 //BA.debugLineNum = 1064;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
B4R::Array* b4r_convert::_modbuscrc16transmittedframe(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _crcbytes = NULL;
B4R::Array be_ann430_8e2;
B4R::Array* _out = NULL;
 //BA.debugLineNum = 1041;BA.debugLine="Public Sub ModbusCRC16TransmittedFrame(frame() As";
 //BA.debugLineNum = 1042;BA.debugLine="Dim crcBytes() As Byte = ModbusCRC16(frame)";
_crcbytes = _modbuscrc16(_frame);
 //BA.debugLineNum = 1043;BA.debugLine="Dim out(frame.Length + 2) As Byte";
_out =be_ann430_8e2.wrapDynamic((Int) (_frame->length+2), sizeof(Byte));
 //BA.debugLineNum = 1044;BA.debugLine="ByteConv.ArrayCopy2(frame, 0, out, 0, frame.Lengt";
b4r_convert::_byteconv->ArrayCopy2(_frame,(UInt) (0),_out,(UInt) (0),(UInt) (_frame->length));
 //BA.debugLineNum = 1045;BA.debugLine="out(frame.Length)     = crcBytes(0)   ' Low byte";
((Byte*)_out->getData((UInt) (_frame->length)))[B4R::Array::staticIndex] = ((Byte*)_crcbytes->getData((UInt) (0)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 1046;BA.debugLine="out(frame.Length + 1) = crcBytes(1)   ' High byte";
((Byte*)_out->getData((UInt) (_frame->length+1)))[B4R::Array::staticIndex] = ((Byte*)_crcbytes->getData((UInt) (1)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 1047;BA.debugLine="Return out";
B4R::StackMemory::cp = cp;
B4R::Array* res6 = B4R::StackMemory::ReturnArrayOnStack(_out, sizeof(Byte));
if (true) return res6;
 //BA.debugLineNum = 1048;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
ULong b4r_convert::_modbuscrc16uint(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _crcbytes = NULL;
ULong _low = 0L;
ULong _high = 0L;
ULong _result = 0L;
 //BA.debugLineNum = 1027;BA.debugLine="Public Sub ModbusCRC16UInt(frame() As Byte) As ULo";
 //BA.debugLineNum = 1028;BA.debugLine="Dim crcBytes() As Byte = ModbusCRC16(frame)   ' [";
_crcbytes = _modbuscrc16(_frame);
 //BA.debugLineNum = 1029;BA.debugLine="Dim low As ULong  = crcBytes(0)";
_low = (ULong) (((Byte*)_crcbytes->getData((UInt) (0)))[B4R::Array::staticIndex]);
 //BA.debugLineNum = 1030;BA.debugLine="Dim high As ULong = crcBytes(1)";
_high = (ULong) (((Byte*)_crcbytes->getData((UInt) (1)))[B4R::Array::staticIndex]);
 //BA.debugLineNum = 1032;BA.debugLine="Dim result As ULong = Bit.Or(Bit.ShiftLeft(high,";
_result = (ULong) (BitClass_Or(BitClass_ShiftLeft((UInt) (_high),(Byte) (8)),(UInt) (_low)));
 //BA.debugLineNum = 1033;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
ULong res5 = _result;
if (true) return res5;
 //BA.debugLineNum = 1034;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0L;
}
B4R::B4RString* b4r_convert::_nibbletobin(Byte _nibble){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString be_ann203_7;
Byte be_ann204_4e1[4];
B4R::Array be_ann204_4e2;
B4R::Array* _bits = NULL;
Int _i = 0;
 //BA.debugLineNum = 590;BA.debugLine="Public Sub NibbleToBin(nibble As Byte) As String";
 //BA.debugLineNum = 591;BA.debugLine="If nibble > 15 Then Return \"Invalid\"";
if (_nibble>15) { 
B4R::StackMemory::cp = cp;
B4R::B4RString* res1 = B4R::StackMemory::ReturnStringOnStack(be_ann203_7.wrap("Invalid"));
if (true) return res1;};
 //BA.debugLineNum = 593;BA.debugLine="Dim bits(4) As Byte";
_bits =be_ann204_4e2.wrap(be_ann204_4e1,4);
 //BA.debugLineNum = 594;BA.debugLine="For i = 0 To 3";
{
const int step3 = 1;
const int limit3 = 3;
_i = 0 ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 595;BA.debugLine="bits(i) = 48 + Bit.And(Bit.ShiftRight(nibble, 3";
((Byte*)_bits->getData((UInt) (_i)))[B4R::Array::staticIndex] = (Byte) (48+BitClass_And(BitClass_ShiftRight((UInt) (_nibble),(Byte) (3-_i)),(UInt) (1)));
 }
};
 //BA.debugLineNum = 597;BA.debugLine="Return ByteConv.StringFromBytes(bits)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res6 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->StringFromBytes(_bits));
if (true) return res6;
 //BA.debugLineNum = 598;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
bool b4r_convert::_onofftobool(B4R::B4RString* _value){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString be_ann66_5;
B4R::B4RString be_ann66_10;
B4R::B4RString be_ann66_15;
B4R::B4RString be_ann66_20;
 //BA.debugLineNum = 305;BA.debugLine="Public Sub OnOffToBool(value As String) As Boolean";
 //BA.debugLineNum = 306;BA.debugLine="If value == \"ON\" Or value == \"On\" Or value == \"on";
if ((_value)->equals(be_ann66_5.wrap("ON")) || (_value)->equals(be_ann66_10.wrap("On")) || (_value)->equals(be_ann66_15.wrap("on")) || (_value)->equals(be_ann66_20.wrap("oN"))) { 
B4R::StackMemory::cp = cp;
bool res1 = Common_True;
if (true) return res1;};
 //BA.debugLineNum = 307;BA.debugLine="Return False";
B4R::StackMemory::cp = cp;
bool res2 = Common_False;
if (true) return res2;
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
void b4r_convert::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 130;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 132;BA.debugLine="Public VERSION As ULong = 20260414";
b4r_convert::_version = (ULong) (20260414);
 //BA.debugLineNum = 141;BA.debugLine="Public Const BYTE_MIN 			As Byte = 0";
b4r_convert::_byte_min = (Byte) (0);
 //BA.debugLineNum = 142;BA.debugLine="Public Const BYTE_MAX 			As Byte = 255";
b4r_convert::_byte_max = (Byte) (255);
 //BA.debugLineNum = 145;BA.debugLine="Public Const INT16_MIN 			As Int = -32768";
b4r_convert::_int16_min = (Int) (-32768);
 //BA.debugLineNum = 146;BA.debugLine="Public Const INT16_MAX 			As Int = 32767";
b4r_convert::_int16_max = 32767;
 //BA.debugLineNum = 149;BA.debugLine="Public Const UINT16_MIN 		As ULong = 0";
b4r_convert::_uint16_min = (ULong) (0);
 //BA.debugLineNum = 150;BA.debugLine="Public Const UINT16_MAX 		As ULong = 65535";
b4r_convert::_uint16_max = (ULong) (65535);
 //BA.debugLineNum = 153;BA.debugLine="Public Const UINT32_MIN 		As ULong = 0";
b4r_convert::_uint32_min = (ULong) (0);
 //BA.debugLineNum = 154;BA.debugLine="Public Const UINT32_MAX			As ULong = 429496729";
b4r_convert::_uint32_max = (ULong) (4294967295L);
 //BA.debugLineNum = 160;BA.debugLine="Public Const FLOAT_MIN 			As Float = -3.402823";
b4r_convert::_float_min = (Double) (-3.4028235e38);
 //BA.debugLineNum = 161;BA.debugLine="Public Const FLOAT_MAX			As Float = 3.4028235E";
b4r_convert::_float_max = (Double) (3.4028235e38);
 //BA.debugLineNum = 170;BA.debugLine="Public Const DOUBLE_MIN		As Double = -3.40";
b4r_convert::_double_min = -3.4028235e38;
 //BA.debugLineNum = 171;BA.debugLine="Public Const DOUBLE_MAX		As Double = 3.402";
b4r_convert::_double_max = 3.4028235e38;
 //BA.debugLineNum = 175;BA.debugLine="Private Const MODBUS_POLYNOMIAL	As ULong = 0xA001";
b4r_convert::_modbus_polynomial = (ULong) (((Int)0xa001));
 //BA.debugLineNum = 178;BA.debugLine="Public SplitAllowEmptyAsZero 	As Boolean = True";
b4r_convert::_splitallowemptyaszero = Common_True;
 //BA.debugLineNum = 182;BA.debugLine="Public ByteConv 				As ByteConverter";
b4r_convert::_byteconv = &be_gann16_3;
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
}
B4R::Array* b4r_convert::_replacestring(B4R::Array* _original,B4R::Array* _searchfor,B4R::Array* _replacewith){
const UInt cp = B4R::StackMemory::cp;
B4R::ByteConverter be_ann365_3;
B4R::ByteConverter* _bc2 = NULL;
Int _c = 0;
Int _i = 0;
B4R::Array be_ann375_18e2;
B4R::Array* _result = NULL;
Int _previndex = 0;
Int _targetindex = 0;
 //BA.debugLineNum = 930;BA.debugLine="Public Sub ReplaceString(Original() As Byte, Searc";
 //BA.debugLineNum = 931;BA.debugLine="Dim bc2 As ByteConverter";
_bc2 = &be_ann365_3;
 //BA.debugLineNum = 932;BA.debugLine="Dim c As Int = 0";
_c = 0;
 //BA.debugLineNum = 933;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 934;BA.debugLine="If SearchFor.Length <> ReplaceWith.Length Then";
if (_searchfor->length!=_replacewith->length) { 
 //BA.debugLineNum = 935;BA.debugLine="i = bc2.IndexOf(Original, SearchFor)";
_i = _bc2->IndexOf(_original,_searchfor);
 //BA.debugLineNum = 936;BA.debugLine="Do While i > -1";
while (_i>-1) {
 //BA.debugLineNum = 937;BA.debugLine="c = c + 1";
_c = (Int) (_c+1);
 //BA.debugLineNum = 938;BA.debugLine="i = bc2.IndexOf2(Original, SearchFor, i + Searc";
_i = _bc2->IndexOf2(_original,_searchfor,(UInt) (_i+_searchfor->length));
 }
;
 };
 //BA.debugLineNum = 941;BA.debugLine="Dim result(Original.Length + c * (ReplaceWith.Len";
_result =be_ann375_18e2.wrapDynamic((Int) (_original->length+_c*(_replacewith->length-_searchfor->length)), sizeof(Byte));
 //BA.debugLineNum = 942;BA.debugLine="Dim prevIndex As Int = 0";
_previndex = 0;
 //BA.debugLineNum = 943;BA.debugLine="Dim targetIndex As Int = 0";
_targetindex = 0;
 //BA.debugLineNum = 944;BA.debugLine="i = bc2.IndexOf(Original, SearchFor)";
_i = _bc2->IndexOf(_original,_searchfor);
 //BA.debugLineNum = 945;BA.debugLine="Do While i > -1";
while (_i>-1) {
 //BA.debugLineNum = 946;BA.debugLine="bc2.ArrayCopy2(Original, prevIndex, result, targ";
_bc2->ArrayCopy2(_original,(UInt) (_previndex),_result,(UInt) (_targetindex),(UInt) (_i-_previndex));
 //BA.debugLineNum = 947;BA.debugLine="targetIndex = targetIndex + i - prevIndex";
_targetindex = (Int) (_targetindex+_i-_previndex);
 //BA.debugLineNum = 948;BA.debugLine="bc2.ArrayCopy2(ReplaceWith, 0, result, targetInd";
_bc2->ArrayCopy2(_replacewith,(UInt) (0),_result,(UInt) (_targetindex),(UInt) (_replacewith->length));
 //BA.debugLineNum = 949;BA.debugLine="targetIndex = targetIndex + ReplaceWith.Length";
_targetindex = (Int) (_targetindex+_replacewith->length);
 //BA.debugLineNum = 950;BA.debugLine="prevIndex = i + SearchFor.Length";
_previndex = (Int) (_i+_searchfor->length);
 //BA.debugLineNum = 951;BA.debugLine="i = bc2.IndexOf2(Original, SearchFor, prevIndex)";
_i = _bc2->IndexOf2(_original,_searchfor,(UInt) (_previndex));
 }
;
 //BA.debugLineNum = 953;BA.debugLine="If prevIndex < Original.Length Then";
if (_previndex<_original->length) { 
 //BA.debugLineNum = 954;BA.debugLine="bc2.ArrayCopy2(Original, prevIndex, result, targ";
_bc2->ArrayCopy2(_original,(UInt) (_previndex),_result,(UInt) (_targetindex),(UInt) (_original->length-_previndex));
 };
 //BA.debugLineNum = 956;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
B4R::Array* res26 = B4R::StackMemory::ReturnArrayOnStack(_result, sizeof(Byte));
if (true) return res26;
 //BA.debugLineNum = 957;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_reversebytes(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
Int _n = 0;
B4R::Array be_ann42_4e2;
B4R::Array* _r = NULL;
Int _i = 0;
 //BA.debugLineNum = 257;BA.debugLine="Public Sub ReverseBytes(b() As Byte) As Byte()";
 //BA.debugLineNum = 258;BA.debugLine="Dim n As Int = b.Length";
_n = _b->length;
 //BA.debugLineNum = 259;BA.debugLine="Dim r(n) As Byte";
_r =be_ann42_4e2.wrapDynamic(_n, sizeof(Byte));
 //BA.debugLineNum = 260;BA.debugLine="For i = 0 To n - 1";
{
const int step3 = 1;
const int limit3 = (Int) (_n-1);
_i = 0 ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 261;BA.debugLine="r(i) = b(n - 1 - i)";
((Byte*)_r->getData((UInt) (_i)))[B4R::Array::staticIndex] = ((Byte*)_b->getData((UInt) (_n-1-_i)))[B4R::Array::staticIndex];
 }
};
 //BA.debugLineNum = 263;BA.debugLine="Return r";
B4R::StackMemory::cp = cp;
B4R::Array* res6 = B4R::StackMemory::ReturnArrayOnStack(_r, sizeof(Byte));
if (true) return res6;
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
ULong b4r_convert::_rgbtocolor(Byte _r,Byte _g,Byte _b){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 1334;BA.debugLine="Public Sub RGBToColor(r As Byte, g As Byte, b As B";
 //BA.debugLineNum = 1335;BA.debugLine="Return Bit.Or(Bit.ShiftLeft(r, 16), Bit.Or(Bit.Sh";
B4R::StackMemory::cp = cp;
ULong res1 = (ULong) (BitClass_Or(BitClass_ShiftLeft((UInt) (_r),(Byte) (16)),BitClass_Or(BitClass_ShiftLeft((UInt) (_g),(Byte) (8)),(UInt) (_b))));
if (true) return res1;
 //BA.debugLineNum = 1336;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0L;
}
Byte b4r_convert::_setbit(Byte _b,Int _index,bool _on){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 1080;BA.debugLine="Public Sub SetBit(b As Byte, index As Int, on As B";
 //BA.debugLineNum = 1081;BA.debugLine="If on Then";
if (_on) { 
 //BA.debugLineNum = 1082;BA.debugLine="Return Bit.Or(b, Bit.ShiftLeft(1, index))";
B4R::StackMemory::cp = cp;
Byte res2 = (Byte) (BitClass_Or((UInt) (_b),BitClass_ShiftLeft((UInt) (1),(Byte) (_index))));
if (true) return res2;
 }else {
 //BA.debugLineNum = 1084;BA.debugLine="Return Bit.And(b, Bit.Not(Bit.ShiftLeft(1, index";
B4R::StackMemory::cp = cp;
Byte res4 = (Byte) (BitClass_And((UInt) (_b),BitClass_Not(BitClass_ShiftLeft((UInt) (1),(Byte) (_index)))));
if (true) return res4;
 };
 //BA.debugLineNum = 1086;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::B4RString* b4r_convert::_stringtrim(B4R::B4RString* _s){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _b = NULL;
Int _startindex = 0;
Int _endindex = 0;
B4R::B4RString be_ann307_7;
Int _trimmedlength = 0;
B4R::Array be_ann309_4e2;
B4R::Array* _result = NULL;
Int _i = 0;
 //BA.debugLineNum = 818;BA.debugLine="Public Sub StringTrim(s As String) As String";
 //BA.debugLineNum = 819;BA.debugLine="Dim b() As Byte = s.GetBytes";
_b = _s->GetBytes();
 //BA.debugLineNum = 820;BA.debugLine="Dim startIndex As Int = 0";
_startindex = 0;
 //BA.debugLineNum = 821;BA.debugLine="Dim endIndex As Int = b.Length - 1";
_endindex = (Int) (_b->length-1);
 //BA.debugLineNum = 823;BA.debugLine="Do While startIndex <= endIndex And (b(startIndex";
while (_startindex<=_endindex && (((Byte*)_b->getData((UInt) (_startindex)))[B4R::Array::staticIndex]==32 || ((Byte*)_b->getData((UInt) (_startindex)))[B4R::Array::staticIndex]==9)) {
 //BA.debugLineNum = 824;BA.debugLine="startIndex = startIndex + 1";
_startindex = (Int) (_startindex+1);
 }
;
 //BA.debugLineNum = 827;BA.debugLine="Do While endIndex >= startIndex And (b(endIndex)";
while (_endindex>=_startindex && (((Byte*)_b->getData((UInt) (_endindex)))[B4R::Array::staticIndex]==32 || ((Byte*)_b->getData((UInt) (_endindex)))[B4R::Array::staticIndex]==9)) {
 //BA.debugLineNum = 828;BA.debugLine="endIndex = endIndex - 1";
_endindex = (Int) (_endindex-1);
 }
;
 //BA.debugLineNum = 831;BA.debugLine="If startIndex > endIndex Then Return \"\"";
if (_startindex>_endindex) { 
B4R::StackMemory::cp = cp;
B4R::B4RString* res10 = B4R::StackMemory::ReturnStringOnStack(be_ann307_7.wrap(""));
if (true) return res10;};
 //BA.debugLineNum = 833;BA.debugLine="Dim trimmedLength As Int = endIndex - startIndex";
_trimmedlength = (Int) (_endindex-_startindex+1);
 //BA.debugLineNum = 834;BA.debugLine="Dim result(trimmedLength) As Byte";
_result =be_ann309_4e2.wrapDynamic(_trimmedlength, sizeof(Byte));
 //BA.debugLineNum = 835;BA.debugLine="For i = 0 To trimmedLength - 1";
{
const int step13 = 1;
const int limit13 = (Int) (_trimmedlength-1);
_i = 0 ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 836;BA.debugLine="result(i) = b(startIndex + i)";
((Byte*)_result->getData((UInt) (_i)))[B4R::Array::staticIndex] = ((Byte*)_b->getData((UInt) (_startindex+_i)))[B4R::Array::staticIndex];
 }
};
 //BA.debugLineNum = 838;BA.debugLine="Return ByteConv.StringFromBytes(result)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res16 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->StringFromBytes(_result));
if (true) return res16;
 //BA.debugLineNum = 839;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::B4RString* b4r_convert::_stringtrimcrlf(B4R::B4RString* _s){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _b = NULL;
Int _startindex = 0;
Int _endindex = 0;
B4R::B4RString be_ann325_7;
Int _trimmedlength = 0;
B4R::Array be_ann327_4e2;
B4R::Array* _result = NULL;
Int _i = 0;
 //BA.debugLineNum = 850;BA.debugLine="Public Sub StringTrimCRLF(s As String) As String";
 //BA.debugLineNum = 851;BA.debugLine="Dim b() As Byte = s.GetBytes";
_b = _s->GetBytes();
 //BA.debugLineNum = 852;BA.debugLine="Dim startIndex As Int = 0";
_startindex = 0;
 //BA.debugLineNum = 853;BA.debugLine="Dim endIndex As Int = b.Length - 1";
_endindex = (Int) (_b->length-1);
 //BA.debugLineNum = 855;BA.debugLine="Do While startIndex <= endIndex And (b(startIndex";
while (_startindex<=_endindex && (((Byte*)_b->getData((UInt) (_startindex)))[B4R::Array::staticIndex]==32 || ((Byte*)_b->getData((UInt) (_startindex)))[B4R::Array::staticIndex]==9 || ((Byte*)_b->getData((UInt) (_startindex)))[B4R::Array::staticIndex]==13 || ((Byte*)_b->getData((UInt) (_startindex)))[B4R::Array::staticIndex]==10)) {
 //BA.debugLineNum = 856;BA.debugLine="startIndex = startIndex + 1";
_startindex = (Int) (_startindex+1);
 }
;
 //BA.debugLineNum = 859;BA.debugLine="Do While endIndex >= startIndex And (b(endIndex)";
while (_endindex>=_startindex && (((Byte*)_b->getData((UInt) (_endindex)))[B4R::Array::staticIndex]==32 || ((Byte*)_b->getData((UInt) (_endindex)))[B4R::Array::staticIndex]==9 || ((Byte*)_b->getData((UInt) (_endindex)))[B4R::Array::staticIndex]==13 || ((Byte*)_b->getData((UInt) (_endindex)))[B4R::Array::staticIndex]==10)) {
 //BA.debugLineNum = 860;BA.debugLine="endIndex = endIndex - 1";
_endindex = (Int) (_endindex-1);
 }
;
 //BA.debugLineNum = 863;BA.debugLine="If startIndex > endIndex Then Return \"\"";
if (_startindex>_endindex) { 
B4R::StackMemory::cp = cp;
B4R::B4RString* res10 = B4R::StackMemory::ReturnStringOnStack(be_ann325_7.wrap(""));
if (true) return res10;};
 //BA.debugLineNum = 865;BA.debugLine="Dim trimmedLength As Int = endIndex - startIndex";
_trimmedlength = (Int) (_endindex-_startindex+1);
 //BA.debugLineNum = 866;BA.debugLine="Dim result(trimmedLength) As Byte";
_result =be_ann327_4e2.wrapDynamic(_trimmedlength, sizeof(Byte));
 //BA.debugLineNum = 867;BA.debugLine="For i = 0 To trimmedLength - 1";
{
const int step13 = 1;
const int limit13 = (Int) (_trimmedlength-1);
_i = 0 ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 868;BA.debugLine="result(i) = b(startIndex + i)";
((Byte*)_result->getData((UInt) (_i)))[B4R::Array::staticIndex] = ((Byte*)_b->getData((UInt) (_startindex+_i)))[B4R::Array::staticIndex];
 }
};
 //BA.debugLineNum = 870;BA.debugLine="Return ByteConv.StringFromBytes(result)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res16 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->StringFromBytes(_result));
if (true) return res16;
 //BA.debugLineNum = 871;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
UInt b4r_convert::_swapuint16(UInt _value){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 745;BA.debugLine="Public Sub SwapUInt16(value As UInt) As UInt";
 //BA.debugLineNum = 746;BA.debugLine="Return Bit.Or(Bit.ShiftLeft(Bit.And(value, 0xF";
B4R::StackMemory::cp = cp;
UInt res1 = BitClass_Or(BitClass_ShiftLeft(BitClass_And(_value,(UInt) (((Int)0xff))),(Byte) (8)),BitClass_ShiftRight(BitClass_And(_value,(UInt) (((Int)0xff00))),(Byte) (8)));
if (true) return res1;
 //BA.debugLineNum = 747;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::Array* b4r_convert::_swapuint16tobytes(UInt _value){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann271_4e1[2];
B4R::Array be_ann271_4e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 764;BA.debugLine="Public Sub SwapUInt16ToBytes(value As UInt) As Byt";
 //BA.debugLineNum = 765;BA.debugLine="Dim b(2) As Byte";
_b =be_ann271_4e2.wrap(be_ann271_4e1,2);
 //BA.debugLineNum = 766;BA.debugLine="b(0) = Bit.And(Bit.ShiftRight(value, 8), 0xFF)";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight(_value,(Byte) (8)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 767;BA.debugLine="b(1) = Bit.And(value, 0xFF)";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(_value,(UInt) (((Int)0xff))));
 //BA.debugLineNum = 768;BA.debugLine="Return b";
B4R::StackMemory::cp = cp;
B4R::Array* res4 = B4R::StackMemory::ReturnArrayOnStack(_b, sizeof(Byte));
if (true) return res4;
 //BA.debugLineNum = 769;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
ULong b4r_convert::_swapuint32(ULong _value){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 753;BA.debugLine="Public Sub SwapUInt32(value As ULong) As ULong";
 //BA.debugLineNum = 754;BA.debugLine="Return Bit.Or(Bit.ShiftLeft(Bit.And(value, 0xF";
B4R::StackMemory::cp = cp;
ULong res1 = (ULong) (BitClass_Or(BitClass_ShiftLeft(BitClass_And((UInt) (_value),(UInt) (((Int)0xff))),(Byte) (24)),BitClass_Or(BitClass_ShiftLeft(BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (8)),(UInt) (((Int)0xff))),(Byte) (16)),BitClass_Or(BitClass_ShiftLeft(BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (16)),(UInt) (((Int)0xff))),(Byte) (8)),BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (24)),(UInt) (((Int)0xff)))))));
if (true) return res1;
 //BA.debugLineNum = 758;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0L;
}
B4R::Array* b4r_convert::_swapuint32tobytes(ULong _value){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann281_4e1[4];
B4R::Array be_ann281_4e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 784;BA.debugLine="Public Sub SwapUInt32ToBytes(value As ULong) As By";
 //BA.debugLineNum = 785;BA.debugLine="Dim b(4) As Byte";
_b =be_ann281_4e2.wrap(be_ann281_4e1,4);
 //BA.debugLineNum = 786;BA.debugLine="b(0) = Bit.And(Bit.ShiftRight(value, 24), 0xFF)";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (24)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 787;BA.debugLine="b(1) = Bit.And(Bit.ShiftRight(value, 16), 0xFF)";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (16)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 788;BA.debugLine="b(2) = Bit.And(Bit.ShiftRight(value, 8), 0xFF)";
((Byte*)_b->getData((UInt) (2)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (8)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 789;BA.debugLine="b(3) = Bit.And(value, 0xFF)";
((Byte*)_b->getData((UInt) (3)))[B4R::Array::staticIndex] = (Byte) (BitClass_And((UInt) (_value),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 790;BA.debugLine="Return b";
B4R::StackMemory::cp = cp;
B4R::Array* res6 = B4R::StackMemory::ReturnArrayOnStack(_b, sizeof(Byte));
if (true) return res6;
 //BA.debugLineNum = 791;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
Byte b4r_convert::_togglebit(Byte _b,Int _index){
const UInt cp = B4R::StackMemory::cp;
Byte _mask = 0;
 //BA.debugLineNum = 1096;BA.debugLine="Public Sub ToggleBit(b As Byte, index As Int) As B";
 //BA.debugLineNum = 1097;BA.debugLine="Dim mask As Byte = Bit.ShiftLeft(1, index)";
_mask = (Byte) (BitClass_ShiftLeft((UInt) (1),(Byte) (_index)));
 //BA.debugLineNum = 1098;BA.debugLine="If Bit.And(b, mask) = 0 Then";
if (BitClass_And((UInt) (_b),(UInt) (_mask))==0) { 
 //BA.debugLineNum = 1099;BA.debugLine="Return Bit.Or(b, mask)";
B4R::StackMemory::cp = cp;
Byte res3 = (Byte) (BitClass_Or((UInt) (_b),(UInt) (_mask)));
if (true) return res3;
 }else {
 //BA.debugLineNum = 1101;BA.debugLine="Return Bit.And(b, Bit.Not(mask))";
B4R::StackMemory::cp = cp;
Byte res5 = (Byte) (BitClass_And((UInt) (_b),BitClass_Not((UInt) (_mask))));
if (true) return res5;
 };
 //BA.debugLineNum = 1103;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::B4RString* b4r_convert::_tolowercase(B4R::B4RString* _s){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _b = NULL;
Int _i = 0;
B4R::B4RString be_ann345_11;
B4R::B4RString be_ann345_24;
 //BA.debugLineNum = 891;BA.debugLine="Public Sub ToLowerCase(s As String) As String";
 //BA.debugLineNum = 892;BA.debugLine="Dim b() As Byte = s.GetBytes";
_b = _s->GetBytes();
 //BA.debugLineNum = 893;BA.debugLine="For i = 0 To b.Length - 1";
{
const int step2 = 1;
const int limit2 = (Int) (_b->length-1);
_i = 0 ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 894;BA.debugLine="If b(i) >= Asc(\"A\") And b(i) <= Asc(\"Z\") Then";
if (((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex]>=Common_Asc(be_ann345_11.wrap("A")) && ((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex]<=Common_Asc(be_ann345_24.wrap("Z"))) { 
 //BA.debugLineNum = 895;BA.debugLine="b(i) = b(i) + 32";
((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex] = (Byte) (((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex]+32);
 };
 }
};
 //BA.debugLineNum = 898;BA.debugLine="Return ByteConv.StringFromBytes(b)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res7 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->StringFromBytes(_b));
if (true) return res7;
 //BA.debugLineNum = 899;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::B4RString* b4r_convert::_touppercase(B4R::B4RString* _s){
const UInt cp = B4R::StackMemory::cp;
B4R::Array* _b = NULL;
Int _i = 0;
B4R::B4RString be_ann336_11;
B4R::B4RString be_ann336_24;
 //BA.debugLineNum = 877;BA.debugLine="Public Sub ToUpperCase(s As String) As String";
 //BA.debugLineNum = 878;BA.debugLine="Dim b() As Byte = s.GetBytes";
_b = _s->GetBytes();
 //BA.debugLineNum = 879;BA.debugLine="For i = 0 To b.Length - 1";
{
const int step2 = 1;
const int limit2 = (Int) (_b->length-1);
_i = 0 ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 880;BA.debugLine="If b(i) >= Asc(\"a\") And b(i) <= Asc(\"z\") Then";
if (((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex]>=Common_Asc(be_ann336_11.wrap("a")) && ((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex]<=Common_Asc(be_ann336_24.wrap("z"))) { 
 //BA.debugLineNum = 881;BA.debugLine="b(i) = b(i) - 32";
((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex] = (Byte) (((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex]-32);
 };
 }
};
 //BA.debugLineNum = 884;BA.debugLine="Return ByteConv.StringFromBytes(b)";
B4R::StackMemory::cp = cp;
B4R::B4RString* res7 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->StringFromBytes(_b));
if (true) return res7;
 //BA.debugLineNum = 885;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
B4R::B4RString* b4r_convert::_twobytestohex(Byte _b1,Byte _b2){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann38_12e1[2];
B4R::Array be_ann38_12e2;
 //BA.debugLineNum = 248;BA.debugLine="Public Sub TwoBytesToHex(b1 As Byte, b2 As Byte) A";
 //BA.debugLineNum = 249;BA.debugLine="Return ByteConv.HexFromBytes(Array As Byte(b1, b2";
B4R::StackMemory::cp = cp;
B4R::B4RString* res1 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->HexFromBytes(be_ann38_12e2.create(be_ann38_12e1,2,1,_b1,_b2)));
if (true) return res1;
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
Int b4r_convert::_twobytestoint(B4R::Array* _b,bool _littleendian){
const UInt cp = B4R::StackMemory::cp;
Int _hi = 0;
Int _lo = 0;
Int _result = 0;
 //BA.debugLineNum = 339;BA.debugLine="Public Sub TwoBytesToInt(b() As Byte, littleendian";
 //BA.debugLineNum = 340;BA.debugLine="If b.Length < 2 Then";
if (_b->length<2) { 
 //BA.debugLineNum = 341;BA.debugLine="Log(\"[TwoBytesToInt][E] Expect 2 Bytes\")";
B4R::Common::LogHelper(1,102,F("[TwoBytesToInt][E] Expect 2 Bytes"));
 //BA.debugLineNum = 342;BA.debugLine="Return 0";
B4R::StackMemory::cp = cp;
Int res3 = 0;
if (true) return res3;
 };
 //BA.debugLineNum = 345;BA.debugLine="Dim hi As Int";
_hi = 0;
 //BA.debugLineNum = 346;BA.debugLine="Dim lo As Int";
_lo = 0;
 //BA.debugLineNum = 348;BA.debugLine="If littleendian Then";
if (_littleendian) { 
 //BA.debugLineNum = 349;BA.debugLine="lo = b(0)   ' LSB first";
_lo = (Int) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]);
 //BA.debugLineNum = 350;BA.debugLine="hi = b(1)";
_hi = (Int) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]);
 }else {
 //BA.debugLineNum = 352;BA.debugLine="hi = b(0)   ' MSB first";
_hi = (Int) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]);
 //BA.debugLineNum = 353;BA.debugLine="lo = b(1)";
_lo = (Int) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]);
 };
 //BA.debugLineNum = 356;BA.debugLine="Dim result As Int = Bit.Or(Bit.ShiftLeft(Bit.And(";
_result = (Int) (BitClass_Or(BitClass_ShiftLeft(BitClass_And((UInt) (_hi),(UInt) (((Int)0xff))),(Byte) (8)),BitClass_And((UInt) (_lo),(UInt) (((Int)0xff)))));
 //BA.debugLineNum = 359;BA.debugLine="If result > 32767 Then result = result - 65536";
if (_result>32767) { 
_result = (Int) (_result-65536);};
 //BA.debugLineNum = 361;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
Int res16 = _result;
if (true) return res16;
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
UInt b4r_convert::_twobytestouint(B4R::Array* _b,bool _littleendian){
const UInt cp = B4R::StackMemory::cp;
Int _hi = 0;
Int _lo = 0;
 //BA.debugLineNum = 411;BA.debugLine="Public Sub TwoBytesToUInt(b() As Byte, littleendia";
 //BA.debugLineNum = 412;BA.debugLine="If b.Length < 2 Then";
if (_b->length<2) { 
 //BA.debugLineNum = 413;BA.debugLine="Log(\"[TwoBytesToUInt][E] Expect 2 Bytes\")";
B4R::Common::LogHelper(1,102,F("[TwoBytesToUInt][E] Expect 2 Bytes"));
 //BA.debugLineNum = 414;BA.debugLine="Return 0";
B4R::StackMemory::cp = cp;
UInt res3 = (UInt) (0);
if (true) return res3;
 };
 //BA.debugLineNum = 417;BA.debugLine="Dim hi As Int";
_hi = 0;
 //BA.debugLineNum = 418;BA.debugLine="Dim lo As Int";
_lo = 0;
 //BA.debugLineNum = 420;BA.debugLine="If littleendian Then";
if (_littleendian) { 
 //BA.debugLineNum = 421;BA.debugLine="lo = b(0)   ' LSB first";
_lo = (Int) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]);
 //BA.debugLineNum = 422;BA.debugLine="hi = b(1)";
_hi = (Int) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]);
 }else {
 //BA.debugLineNum = 424;BA.debugLine="hi = b(0)   ' MSB first";
_hi = (Int) (((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex]);
 //BA.debugLineNum = 425;BA.debugLine="lo = b(1)";
_lo = (Int) (((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex]);
 };
 //BA.debugLineNum = 428;BA.debugLine="Return Bit.Or(Bit.ShiftLeft(Bit.And(hi, 0xFF), 8)";
B4R::StackMemory::cp = cp;
UInt res14 = BitClass_Or(BitClass_ShiftLeft(BitClass_And((UInt) (_hi),(UInt) (((Int)0xff))),(Byte) (8)),BitClass_And((UInt) (_lo),(UInt) (((Int)0xff))));
if (true) return res14;
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
UInt b4r_convert::_uintfromstring(B4R::Array* _s){
const UInt cp = B4R::StackMemory::cp;
B4R::B4RString* _str = B4R::B4RString::EMPTY;
UInt _result = 0;
 //BA.debugLineNum = 442;BA.debugLine="Public Sub UIntFromString(s() As Byte) As UInt";
 //BA.debugLineNum = 443;BA.debugLine="Dim str As String = ByteConv.StringFromBytes(s)";
_str = b4r_convert::_byteconv->StringFromBytes(_s);
 //BA.debugLineNum = 444;BA.debugLine="If IsNumber(str) = False Then Return 0";
if (B4R::__c->IsNumber(_str)==Common_False) { 
B4R::StackMemory::cp = cp;
UInt res2 = (UInt) (0);
if (true) return res2;};
 //BA.debugLineNum = 445;BA.debugLine="Dim result As UInt = str";
_result = (UInt)(atof(_str->data));
 //BA.debugLineNum = 446;BA.debugLine="Return result";
B4R::StackMemory::cp = cp;
UInt res4 = _result;
if (true) return res4;
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::Array* b4r_convert::_uinttobcdarray(ULong _value){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann239_4e1[2];
B4R::Array be_ann239_4e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 671;BA.debugLine="Public Sub UIntToBCDArray(value As ULong) As Byte(";
 //BA.debugLineNum = 672;BA.debugLine="If value > 9999 Then Return Null";
if (_value>9999) { 
B4R::StackMemory::cp = cp;
B4R::Array* res1 = B4R::StackMemory::ReturnArrayOnStack((B4R::Array*)B4R::Object::toPointer(Common_Null), sizeof(Byte));
if (true) return res1;};
 //BA.debugLineNum = 673;BA.debugLine="Dim b(2) As Byte   ' 2 bytes = 4 digits";
_b =be_ann239_4e2.wrap(be_ann239_4e1,2);
 //BA.debugLineNum = 674;BA.debugLine="b(0) = ByteToBCD(value / 100)      ' high two";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (_bytetobcd((Byte) (_value/(Double)100)));
 //BA.debugLineNum = 675;BA.debugLine="b(1) = ByteToBCD(value Mod 100)    ' low two d";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (_bytetobcd((Byte) (_value%100)));
 //BA.debugLineNum = 676;BA.debugLine="Return b";
B4R::StackMemory::cp = cp;
B4R::Array* res5 = B4R::StackMemory::ReturnArrayOnStack(_b, sizeof(Byte));
if (true) return res5;
 //BA.debugLineNum = 677;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_uinttobytes(ULong _value){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann98_4e1[2];
B4R::Array be_ann98_4e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 374;BA.debugLine="Public Sub UIntToBytes(value As ULong) As Byte()";
 //BA.debugLineNum = 375;BA.debugLine="Dim b(2) As Byte";
_b =be_ann98_4e2.wrap(be_ann98_4e1,2);
 //BA.debugLineNum = 376;BA.debugLine="b(0) = Bit.And(value, 0xFF)                     '";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And((UInt) (_value),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 377;BA.debugLine="b(1) = Bit.And(Bit.ShiftRight(value, 8), 0xFF)  '";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (8)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 378;BA.debugLine="Return b";
B4R::StackMemory::cp = cp;
B4R::Array* res4 = B4R::StackMemory::ReturnArrayOnStack(_b, sizeof(Byte));
if (true) return res4;
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::Array* b4r_convert::_uinttobytesendian(ULong _value,bool _littleendian){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann104_4e1[2];
B4R::Array be_ann104_4e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 386;BA.debugLine="Public Sub UIntToBytesEndian(value As ULong, littl";
 //BA.debugLineNum = 387;BA.debugLine="Dim b(2) As Byte";
_b =be_ann104_4e2.wrap(be_ann104_4e1,2);
 //BA.debugLineNum = 388;BA.debugLine="If littleendian Then";
if (_littleendian) { 
 //BA.debugLineNum = 389;BA.debugLine="b(0) = Bit.And(value, 0xFF)";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And((UInt) (_value),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 390;BA.debugLine="b(1) = Bit.And(Bit.ShiftRight(value, 8), 0xFF)";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (8)),(UInt) (((Int)0xff))));
 }else {
 //BA.debugLineNum = 392;BA.debugLine="b(0) = Bit.And(Bit.ShiftRight(value, 8), 0xFF)";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (8)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 393;BA.debugLine="b(1) = Bit.And(value, 0xFF)";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And((UInt) (_value),(UInt) (((Int)0xff))));
 };
 //BA.debugLineNum = 395;BA.debugLine="Return b";
B4R::StackMemory::cp = cp;
B4R::Array* res9 = B4R::StackMemory::ReturnArrayOnStack(_b, sizeof(Byte));
if (true) return res9;
 //BA.debugLineNum = 396;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::B4RString* b4r_convert::_uinttohex(UInt _value){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 434;BA.debugLine="Public Sub UIntToHex(value As UInt) As String";
 //BA.debugLineNum = 435;BA.debugLine="Return ByteConv.HexFromBytes(UIntToBytes(value))";
B4R::StackMemory::cp = cp;
B4R::B4RString* res1 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->HexFromBytes(_uinttobytes((ULong) (_value))));
if (true) return res1;
 //BA.debugLineNum = 436;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
UInt b4r_convert::_ulongfromstring(B4R::Array* _s){
const UInt cp = B4R::StackMemory::cp;
ULong _value = 0L;
 //BA.debugLineNum = 492;BA.debugLine="Public Sub ULongFromString(s() As Byte) As UInt";
 //BA.debugLineNum = 493;BA.debugLine="If s == Null Or s.Length == 0 Then Return 0";
if (_s== NULL || _s->length==0) { 
B4R::StackMemory::cp = cp;
UInt res1 = (UInt) (0);
if (true) return res1;};
 //BA.debugLineNum = 494;BA.debugLine="Dim value As ULong = ByteConv.StringFromBytes(s)";
_value = (ULong)(atof(b4r_convert::_byteconv->StringFromBytes(_s)->data));
 //BA.debugLineNum = 495;BA.debugLine="Return value";
B4R::StackMemory::cp = cp;
UInt res3 = (UInt) (_value);
if (true) return res3;
 //BA.debugLineNum = 496;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
B4R::Array* b4r_convert::_ulongtobytes(ULong _value){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann144_4e1[4];
B4R::Array be_ann144_4e2;
B4R::Array* _b = NULL;
 //BA.debugLineNum = 458;BA.debugLine="Public Sub ULongToBytes(value As ULong) As Byte()";
 //BA.debugLineNum = 459;BA.debugLine="Dim b(4) As Byte";
_b =be_ann144_4e2.wrap(be_ann144_4e1,4);
 //BA.debugLineNum = 460;BA.debugLine="b(0) = Bit.And(value, 0xFF)";
((Byte*)_b->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (BitClass_And((UInt) (_value),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 461;BA.debugLine="b(1) = Bit.And(Bit.ShiftRight(value, 8), 0xFF)";
((Byte*)_b->getData((UInt) (1)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (8)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 462;BA.debugLine="b(2) = Bit.And(Bit.ShiftRight(value, 16), 0xFF)";
((Byte*)_b->getData((UInt) (2)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (16)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 463;BA.debugLine="b(3) = Bit.And(Bit.ShiftRight(value, 24), 0xFF)";
((Byte*)_b->getData((UInt) (3)))[B4R::Array::staticIndex] = (Byte) (BitClass_And(BitClass_ShiftRight((UInt) (_value),(Byte) (24)),(UInt) (((Int)0xff))));
 //BA.debugLineNum = 464;BA.debugLine="Return b";
B4R::StackMemory::cp = cp;
B4R::Array* res6 = B4R::StackMemory::ReturnArrayOnStack(_b, sizeof(Byte));
if (true) return res6;
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
B4R::B4RString* b4r_convert::_ulongtohex(ULong _value){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 484;BA.debugLine="Public Sub ULongToHex(value As ULong) As String";
 //BA.debugLineNum = 485;BA.debugLine="Return ByteConv.HexFromBytes(ULongToBytes(value))";
B4R::StackMemory::cp = cp;
B4R::B4RString* res1 = B4R::StackMemory::ReturnStringOnStack(b4r_convert::_byteconv->HexFromBytes(_ulongtobytes(_value)));
if (true) return res1;
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return B4R::B4RString::EMPTY;
}
Byte b4r_convert::_xorchecksum(B4R::Array* _b){
const UInt cp = B4R::StackMemory::cp;
Byte _c = 0;
Int _i = 0;
 //BA.debugLineNum = 699;BA.debugLine="Public Sub XORChecksum(b() As Byte) As Byte";
 //BA.debugLineNum = 700;BA.debugLine="Dim c As Byte = 0";
_c = (Byte) (0);
 //BA.debugLineNum = 701;BA.debugLine="For i = 0 To b.Length - 1";
{
const int step2 = 1;
const int limit2 = (Int) (_b->length-1);
_i = 0 ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 702;BA.debugLine="c = Bit.Xor(c, b(i))";
_c = (Byte) (BitClass_Xor((UInt) (_c),(UInt) (((Byte*)_b->getData((UInt) (_i)))[B4R::Array::staticIndex])));
 }
};
 //BA.debugLineNum = 704;BA.debugLine="Return c";
B4R::StackMemory::cp = cp;
Byte res5 = _c;
if (true) return res5;
 //BA.debugLineNum = 705;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
