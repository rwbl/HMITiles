package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class pywrapper extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.pywrapper", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.pywrapper.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.pybridge._pyobject _internalkey = null;
public b4j.example.pybridge _mbridge = null;
public boolean _mfetched = false;
public boolean _merror = false;
public Object _mvalue = null;
public b4j.example.pybridge._internalpymethodargs _lastargs = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public b4j.example.pywrapper  _afterarg() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Private Sub AfterArg As PyWrapper";
 //BA.debugLineNum = 33;BA.debugLine="mBridge.Utils.Comm.MoveTaskToLast(LastArgs.Task)";
_mbridge._utils /*b4j.example.pyutils*/ ._comm /*b4j.example.pycomm*/ ._movetasktolast /*String*/ (_lastargs.Task /*b4j.example.pybridge._pytask*/ );
 //BA.debugLineNum = 34;BA.debugLine="Return Me";
if (true) return (b4j.example.pywrapper)(this);
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _arg(Object _parameter) throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Public Sub Arg(Parameter As Object) As PyWrapper";
 //BA.debugLineNum = 39;BA.debugLine="LastArgs.Args.Add(Parameter)";
_lastargs.Args /*anywheresoftware.b4a.objects.collections.List*/ .Add(_parameter);
 //BA.debugLineNum = 40;BA.debugLine="Return AfterArg";
if (true) return _afterarg();
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _argnamed(String _name,Object _parameter) throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Public Sub ArgNamed (Name As String, Parameter As";
 //BA.debugLineNum = 44;BA.debugLine="LastArgs.KWArgs.Put(Name, Parameter)";
_lastargs.KWArgs /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(_name),_parameter);
 //BA.debugLineNum = 45;BA.debugLine="Return AfterArg";
if (true) return _afterarg();
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _args(anywheresoftware.b4a.objects.collections.List _parameters) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Public Sub Args(Parameters As List) As PyWrapper";
 //BA.debugLineNum = 28;BA.debugLine="LastArgs.Args.AddAll(Parameters)";
_lastargs.Args /*anywheresoftware.b4a.objects.collections.List*/ .AddAll(_parameters);
 //BA.debugLineNum = 29;BA.debugLine="Return AfterArg";
if (true) return _afterarg();
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _argsnamed(anywheresoftware.b4a.objects.collections.Map _parameters) throws Exception{
String _k = "";
 //BA.debugLineNum = 48;BA.debugLine="Public Sub ArgsNamed (Parameters As Map) As PyWrap";
 //BA.debugLineNum = 49;BA.debugLine="For Each k As String In Parameters.Keys";
{
final anywheresoftware.b4a.BA.IterableList group1 = _parameters.Keys();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_k = BA.ObjectToString(group1.Get(index1));
 //BA.debugLineNum = 50;BA.debugLine="LastArgs.KWArgs.Put(k, Parameters.Get(k))";
_lastargs.KWArgs /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(_k),_parameters.Get((Object)(_k)));
 }
};
 //BA.debugLineNum = 52;BA.debugLine="Return AfterArg";
if (true) return _afterarg();
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _asfloat() throws Exception{
 //BA.debugLineNum = 251;BA.debugLine="Public Sub AsFloat As PyWrapper";
 //BA.debugLineNum = 252;BA.debugLine="Return mBridge.Builtins.Run(\"float\").Arg(Internal";
if (true) return _mbridge._builtins /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("float")._arg /*b4j.example.pywrapper*/ ((Object)(_internalkey));
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _asint() throws Exception{
 //BA.debugLineNum = 256;BA.debugLine="Public Sub AsInt As PyWrapper";
 //BA.debugLineNum = 257;BA.debugLine="Return mBridge.Builtins.Run(\"int\").Arg(Me)";
if (true) return _mbridge._builtins /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("int")._arg /*b4j.example.pywrapper*/ (this);
 //BA.debugLineNum = 258;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _call() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Public Sub Call As PyWrapper";
 //BA.debugLineNum = 23;BA.debugLine="Return Run(\"__call__\")";
if (true) return _run("__call__");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return null;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public InternalKey As PyObject";
_internalkey = new b4j.example.pybridge._pyobject();
 //BA.debugLineNum = 3;BA.debugLine="Private mBridge As PyBridge";
_mbridge = new b4j.example.pybridge();
 //BA.debugLineNum = 4;BA.debugLine="Private mFetched As Boolean";
_mfetched = false;
 //BA.debugLineNum = 5;BA.debugLine="Private mError As Boolean";
_merror = false;
 //BA.debugLineNum = 6;BA.debugLine="Private mValue As Object";
_mvalue = new Object();
 //BA.debugLineNum = 7;BA.debugLine="Private LastArgs As InternalPyMethodArgs";
_lastargs = new b4j.example.pybridge._internalpymethodargs();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _contains(Object _item) throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Public Sub Contains(Item As Object) As PyWrapper";
 //BA.debugLineNum = 202;BA.debugLine="Return Run(\"__contains__\").Arg(mBridge.Utils.Conv";
if (true) return _run("__contains__")._arg /*b4j.example.pywrapper*/ (_mbridge._utils /*b4j.example.pyutils*/ ._converttointifmatch /*Object*/ (_item));
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return null;
}
public String  _delitem(Object _key,Object _value) throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Public Sub DelItem(Key As Object, Value As Object)";
 //BA.debugLineNum = 197;BA.debugLine="Run(\"__detitem__\").Arg(mBridge.Utils.ConvertToInt";
_run("__detitem__")._arg /*b4j.example.pywrapper*/ (_mbridge._utils /*b4j.example.pyutils*/ ._converttointifmatch /*Object*/ (_key))._arg /*b4j.example.pywrapper*/ (_value);
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _fetch() throws Exception{
ResumableSub_Fetch rsub = new ResumableSub_Fetch(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Fetch extends BA.ResumableSub {
public ResumableSub_Fetch(b4j.example.pywrapper parent) {
this.parent = parent;
}
b4j.example.pywrapper parent;
b4j.example.pybridge._internalpytaskasyncresult _result = null;

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
 //BA.debugLineNum = 85;BA.debugLine="Wait For (mBridge.Utils.Fetch(InternalKey)) Compl";
parent.__c.WaitFor("complete", ba, this, parent._mbridge._utils /*b4j.example.pyutils*/ ._fetch /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._internalkey));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pybridge._internalpytaskasyncresult) result[0];
;
 //BA.debugLineNum = 86;BA.debugLine="Return Wrap(Result)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._wrap(_result)));return;};
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(b4j.example.pybridge._internalpytaskasyncresult _result) throws Exception{
}
public b4j.example.pywrapper  _get(Object _key) throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Public Sub Get (Key As Object) As PyWrapper";
 //BA.debugLineNum = 177;BA.debugLine="Return Run(\"__getitem__\").Arg(mBridge.Utils.Conve";
if (true) return _run("__getitem__")._arg /*b4j.example.pywrapper*/ (_mbridge._utils /*b4j.example.pyutils*/ ._converttointifmatch /*Object*/ (_key));
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _get2d(Object _key1,Object _key2) throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Public Sub Get2D (Key1 As Object, Key2 As Object)";
 //BA.debugLineNum = 182;BA.debugLine="Return Get(Array(Key1, Key2))";
if (true) return _get((Object)(new Object[]{_key1,_key2}));
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _get3d(Object _key1,Object _key2,Object _key3) throws Exception{
 //BA.debugLineNum = 186;BA.debugLine="Public Sub Get3D (Key1 As Object, Key2 As Object,";
 //BA.debugLineNum = 187;BA.debugLine="Return Get(Array(Key1, Key2, Key3))";
if (true) return _get((Object)(new Object[]{_key1,_key2,_key3}));
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return null;
}
public String  _geterrormessage() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub getErrorMessage As String";
 //BA.debugLineNum = 152;BA.debugLine="If mError Then Return mValue";
if (_merror) { 
if (true) return BA.ObjectToString(_mvalue);};
 //BA.debugLineNum = 153;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 154;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _getfield(String _field) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Public Sub GetField (Field As String) As PyWrapper";
 //BA.debugLineNum = 91;BA.debugLine="Return mBridge.Builtins.RunArgs(\"getattr\", Array(";
if (true) return _mbridge._builtins /*b4j.example.pywrapper*/ ._runargs /*b4j.example.pywrapper*/ ("getattr",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_internalkey),(Object)(_field)}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return null;
}
public boolean  _getisfetched() throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub getIsFetched As Boolean";
 //BA.debugLineNum = 147;BA.debugLine="Return mFetched";
if (true) return _mfetched;
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return false;
}
public boolean  _getissuccess() throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Public Sub getIsSuccess As Boolean";
 //BA.debugLineNum = 140;BA.debugLine="If mFetched = False Then";
if (_mfetched==__c.False) { 
 //BA.debugLineNum = 141;BA.debugLine="Me.As(JavaObject).RunMethod(\"raiseError\", Array(";
((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this))).RunMethod("raiseError",new Object[]{(Object)("Value not fetched")});
 };
 //BA.debugLineNum = 143;BA.debugLine="Return Not(mError)";
if (true) return __c.Not(_merror);
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return false;
}
public Object  _getvalue() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Public Sub getValue As Object";
 //BA.debugLineNum = 129;BA.debugLine="If mError Then";
if (_merror) { 
 //BA.debugLineNum = 130;BA.debugLine="Me.As(JavaObject).RunMethod(\"raiseError\", Array(";
((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this))).RunMethod("raiseError",new Object[]{_mvalue});
 };
 //BA.debugLineNum = 132;BA.debugLine="If mFetched = False Then";
if (_mfetched==__c.False) { 
 //BA.debugLineNum = 133;BA.debugLine="Me.As(JavaObject).RunMethod(\"raiseError\", Array(";
((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this))).RunMethod("raiseError",new Object[]{(Object)("Value not fetched")});
 };
 //BA.debugLineNum = 135;BA.debugLine="Return mValue";
if (true) return _mvalue;
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,b4j.example.pybridge _bridge,b4j.example.pybridge._pyobject _key) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 11;BA.debugLine="Public Sub Initialize (Bridge As PyBridge, Key As";
 //BA.debugLineNum = 12;BA.debugLine="InternalKey = Key";
_internalkey = _key;
 //BA.debugLineNum = 13;BA.debugLine="mBridge = Bridge";
_mbridge = _bridge;
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _iter() throws Exception{
 //BA.debugLineNum = 303;BA.debugLine="Public Sub Iter As PyWrapper";
 //BA.debugLineNum = 304;BA.debugLine="Return Run(\"__iter__\")";
if (true) return _run("__iter__");
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _len() throws Exception{
 //BA.debugLineNum = 216;BA.debugLine="Public Sub Len As PyWrapper";
 //BA.debugLineNum = 217;BA.debugLine="Return mBridge.Builtins.Run(\"len\").Arg(InternalKe";
if (true) return _mbridge._builtins /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("len")._arg /*b4j.example.pywrapper*/ ((Object)(_internalkey));
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _opradd(Object _other) throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Public Sub OprAdd (Other As Object) As PyWrapper";
 //BA.debugLineNum = 227;BA.debugLine="Return Run(\"__add__\").Arg(Other)";
if (true) return _run("__add__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprand(Object _other) throws Exception{
 //BA.debugLineNum = 287;BA.debugLine="Public Sub OprAnd (Other As Object) As PyWrapper";
 //BA.debugLineNum = 288;BA.debugLine="Return Run(\"__and__\").Arg(Other)";
if (true) return _run("__and__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 289;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprequal(Object _other) throws Exception{
 //BA.debugLineNum = 261;BA.debugLine="Public Sub OprEqual (Other As Object) As PyWrapper";
 //BA.debugLineNum = 262;BA.debugLine="Return Run(\"__eq__\").Arg(Other)";
if (true) return _run("__eq__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprgreater(Object _other) throws Exception{
 //BA.debugLineNum = 277;BA.debugLine="Public Sub OprGreater (Other As Object) As PyWrapp";
 //BA.debugLineNum = 278;BA.debugLine="Return Run(\"__gt__\").Arg(Other)";
if (true) return _run("__gt__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprgreaterequal(Object _other) throws Exception{
 //BA.debugLineNum = 282;BA.debugLine="Public Sub OprGreaterEqual (Other As Object) As Py";
 //BA.debugLineNum = 283;BA.debugLine="Return Run(\"__ge__\").Arg(Other)";
if (true) return _run("__ge__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprless(Object _other) throws Exception{
 //BA.debugLineNum = 269;BA.debugLine="Public Sub OprLess (Other As Object) As PyWrapper";
 //BA.debugLineNum = 270;BA.debugLine="Return Run(\"__lt__\").Arg(Other)";
if (true) return _run("__lt__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprlessequal(Object _other) throws Exception{
 //BA.debugLineNum = 273;BA.debugLine="Public Sub OprLessEqual (Other As Object) As PyWra";
 //BA.debugLineNum = 274;BA.debugLine="Return Run(\"__le__\").Arg(Other)";
if (true) return _run("__le__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprmod(Object _other) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Public Sub OprMod (Other As Object) As PyWrapper";
 //BA.debugLineNum = 242;BA.debugLine="Return Run(\"__mod__\").Arg(Other)";
if (true) return _run("__mod__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprmul(Object _other) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Public Sub OprMul (Other As Object) As PyWrapper";
 //BA.debugLineNum = 237;BA.debugLine="Return Run(\"__mul__\").Arg(Other)";
if (true) return _run("__mul__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprnot() throws Exception{
 //BA.debugLineNum = 295;BA.debugLine="Public Sub OprNot As PyWrapper";
 //BA.debugLineNum = 296;BA.debugLine="Return Run(\"__invert__\")";
if (true) return _run("__invert__");
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprnotequal(Object _other) throws Exception{
 //BA.debugLineNum = 265;BA.debugLine="Public Sub OprNotEqual (Other As Object) As PyWrap";
 //BA.debugLineNum = 266;BA.debugLine="Return Run(\"__ne__\").Arg(Other)";
if (true) return _run("__ne__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _opror(Object _other) throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Public Sub OprOr (Other As Object) As PyWrapper";
 //BA.debugLineNum = 292;BA.debugLine="Return Run(\"__or__\").Arg(Other)";
if (true) return _run("__or__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprpow(Object _other) throws Exception{
 //BA.debugLineNum = 246;BA.debugLine="Public Sub OprPow (Other As Object) As PyWrapper";
 //BA.debugLineNum = 247;BA.debugLine="Return Run(\"__pow__\").Arg(Other)";
if (true) return _run("__pow__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _oprsub(Object _other) throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Public Sub OprSub (Other As Object) As PyWrapper";
 //BA.debugLineNum = 232;BA.debugLine="Return Run(\"__sub__\").Arg(Other)";
if (true) return _run("__sub__")._arg /*b4j.example.pywrapper*/ (_other);
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return null;
}
public b4j.example.pybridge._internalpymethodargs  _prepareargs(anywheresoftware.b4a.objects.collections.List _args1,anywheresoftware.b4a.objects.collections.Map _kwargs) throws Exception{
b4j.example.pybridge._internalpymethodargs _a = null;
 //BA.debugLineNum = 99;BA.debugLine="Private Sub PrepareArgs (Args1 As List, KWArgs As";
 //BA.debugLineNum = 100;BA.debugLine="Dim a As InternalPyMethodArgs";
_a = new b4j.example.pybridge._internalpymethodargs();
 //BA.debugLineNum = 101;BA.debugLine="a.Initialize";
_a.Initialize();
 //BA.debugLineNum = 102;BA.debugLine="a.Args = B4XCollections.CreateList(Args1)";
_a.Args /*anywheresoftware.b4a.objects.collections.List*/  = _b4xcollections._createlist /*anywheresoftware.b4a.objects.collections.List*/ (_args1);
 //BA.debugLineNum = 103;BA.debugLine="a.KWArgs = B4XCollections.MergeMaps(KWArgs, Null)";
_a.KWArgs /*anywheresoftware.b4a.objects.collections.Map*/  = _b4xcollections._mergemaps /*anywheresoftware.b4a.objects.collections.Map*/ (_kwargs,(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 104;BA.debugLine="Return a";
if (true) return _a;
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return null;
}
public String  _print() throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub Print";
 //BA.debugLineNum = 158;BA.debugLine="Print2(\"\", \"\", False)";
_print2("","",__c.False);
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _print2(String _prefix,String _suffix,boolean _stderr) throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Public Sub Print2 (Prefix As String, Suffix As Str";
 //BA.debugLineNum = 167;BA.debugLine="If mFetched Then";
if (_mfetched) { 
 //BA.debugLineNum = 168;BA.debugLine="Log(mValue)";
__c.LogImpl("979691778",BA.ObjectToString(_mvalue),0);
 }else {
 //BA.debugLineNum = 170;BA.debugLine="mBridge.PrintJoin(Array(Prefix, Me, Suffix), Std";
_mbridge._printjoin /*String*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_prefix),this,(Object)(_suffix)}),_stderr);
 };
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public String  _printerror() throws Exception{
 //BA.debugLineNum = 161;BA.debugLine="Public Sub PrintError";
 //BA.debugLineNum = 162;BA.debugLine="Print2(\"\", \"\", True)";
_print2("","",__c.True);
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _run(String _method) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Public Sub Run(Method As String) As PyWrapper";
 //BA.debugLineNum = 18;BA.debugLine="Return RunArgs(Method, Null, Null)";
if (true) return _runargs(_method,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _runargs(String _method,anywheresoftware.b4a.objects.collections.List _positionalargs,anywheresoftware.b4a.objects.collections.Map _namedargs) throws Exception{
b4j.example.pybridge._internalpymethodargs _a = null;
b4j.example.pybridge._pyobject _py = null;
b4j.example.pywrapper _w = null;
 //BA.debugLineNum = 56;BA.debugLine="Public Sub RunArgs (Method As String, PositionalAr";
 //BA.debugLineNum = 57;BA.debugLine="Dim a As InternalPyMethodArgs = PrepareArgs(Posit";
_a = _prepareargs(_positionalargs,_namedargs);
 //BA.debugLineNum = 58;BA.debugLine="Dim py As PyObject = mBridge.Utils.run(InternalKe";
_py = _mbridge._utils /*b4j.example.pyutils*/ ._run /*b4j.example.pybridge._pyobject*/ (_internalkey,_method,_a);
 //BA.debugLineNum = 59;BA.debugLine="Dim w As PyWrapper";
_w = new b4j.example.pywrapper();
 //BA.debugLineNum = 60;BA.debugLine="w.Initialize(mBridge, py)";
_w._initialize /*String*/ (ba,_mbridge,_py);
 //BA.debugLineNum = 61;BA.debugLine="w.LastArgs = a";
_w._lastargs /*b4j.example.pybridge._internalpymethodargs*/  = _a;
 //BA.debugLineNum = 62;BA.debugLine="a.Task = mBridge.Utils.Comm.BufferedTasks.Get(mBr";
_a.Task /*b4j.example.pybridge._pytask*/  = (b4j.example.pybridge._pytask)(_mbridge._utils /*b4j.example.pyutils*/ ._comm /*b4j.example.pycomm*/ ._bufferedtasks /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (_mbridge._utils /*b4j.example.pyutils*/ ._comm /*b4j.example.pycomm*/ ._bufferedtasks /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1)));
 //BA.debugLineNum = 63;BA.debugLine="Return w";
if (true) return _w;
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _runawait(String _method,anywheresoftware.b4a.objects.collections.List _positionalargs,anywheresoftware.b4a.objects.collections.Map _namedargs) throws Exception{
ResumableSub_RunAwait rsub = new ResumableSub_RunAwait(this,_method,_positionalargs,_namedargs);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_RunAwait extends BA.ResumableSub {
public ResumableSub_RunAwait(b4j.example.pywrapper parent,String _method,anywheresoftware.b4a.objects.collections.List _positionalargs,anywheresoftware.b4a.objects.collections.Map _namedargs) {
this.parent = parent;
this._method = _method;
this._positionalargs = _positionalargs;
this._namedargs = _namedargs;
}
b4j.example.pywrapper parent;
String _method;
anywheresoftware.b4a.objects.collections.List _positionalargs;
anywheresoftware.b4a.objects.collections.Map _namedargs;
b4j.example.pybridge._internalpymethodargs _a = null;
b4j.example.pybridge._internalpytaskasyncresult _result = null;

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
 //BA.debugLineNum = 110;BA.debugLine="Dim a As InternalPyMethodArgs = PrepareArgs(Posit";
_a = parent._prepareargs(_positionalargs,_namedargs);
 //BA.debugLineNum = 111;BA.debugLine="Wait For (mBridge.Utils.RunAsync(InternalKey, Met";
parent.__c.WaitFor("complete", ba, this, parent._mbridge._utils /*b4j.example.pyutils*/ ._runasync /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._internalkey,_method,_a));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pybridge._internalpytaskasyncresult) result[0];
;
 //BA.debugLineNum = 112;BA.debugLine="Return Wrap(Result)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._wrap(_result)));return;};
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _set(Object _key,Object _value) throws Exception{
 //BA.debugLineNum = 191;BA.debugLine="Public Sub Set(Key As Object, Value As Object)";
 //BA.debugLineNum = 192;BA.debugLine="Run(\"__setitem__\").Arg(mBridge.Utils.ConvertToInt";
_run("__setitem__")._arg /*b4j.example.pywrapper*/ (_mbridge._utils /*b4j.example.pyutils*/ ._converttointifmatch /*Object*/ (_key))._arg /*b4j.example.pywrapper*/ (_value);
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _setfield(String _field,Object _value) throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Public Sub SetField(Field As String, Value As Obje";
 //BA.debugLineNum = 96;BA.debugLine="mBridge.Builtins.RunArgs(\"setattr\", Array(Interna";
_mbridge._builtins /*b4j.example.pywrapper*/ ._runargs /*b4j.example.pywrapper*/ ("setattr",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_internalkey),(Object)(_field),_value}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _shape() throws Exception{
 //BA.debugLineNum = 221;BA.debugLine="Public Sub Shape As PyWrapper";
 //BA.debugLineNum = 222;BA.debugLine="Return GetField(\"shape\")";
if (true) return _getfield("shape");
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _str() throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Public Sub Str As PyWrapper";
 //BA.debugLineNum = 207;BA.debugLine="Return mBridge.Builtins.Run(\"str\").Arg(InternalKe";
if (true) return _mbridge._builtins /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("str")._arg /*b4j.example.pywrapper*/ ((Object)(_internalkey));
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper[]  _toarray(int _length) throws Exception{
b4j.example.pywrapper[] _res = null;
int _i = 0;
b4j.example.pywrapper _w = null;
int _start = 0;
b4j.example.pywrapper _p = null;
 //BA.debugLineNum = 67;BA.debugLine="Public Sub ToArray (Length As Int) As PyWrapper()";
 //BA.debugLineNum = 68;BA.debugLine="Dim res(Length) As PyWrapper";
_res = new b4j.example.pywrapper[_length];
{
int d0 = _res.length;
for (int i0 = 0;i0 < d0;i0++) {
_res[i0] = new b4j.example.pywrapper();
}
}
;
 //BA.debugLineNum = 69;BA.debugLine="If Length = 0 Then Return res";
if (_length==0) { 
if (true) return _res;};
 //BA.debugLineNum = 70;BA.debugLine="For i = 0 To Length - 2";
{
final int step3 = 1;
final int limit3 = (int) (_length-2);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 71;BA.debugLine="Dim w As PyWrapper";
_w = new b4j.example.pywrapper();
 //BA.debugLineNum = 72;BA.debugLine="w.Initialize(mBridge, mBridge.Utils.CreatePyObje";
_w._initialize /*String*/ (ba,_mbridge,_mbridge._utils /*b4j.example.pyutils*/ ._createpyobject /*b4j.example.pybridge._pyobject*/ ((int) (0)));
 //BA.debugLineNum = 73;BA.debugLine="res(i) = w";
_res[_i] = _w;
 }
};
 //BA.debugLineNum = 75;BA.debugLine="Dim Start As Int = IIf(Length = 1, mBridge.Utils.";
_start = (int)(BA.ObjectToNumber(((_length==1) ? ((Object)(_mbridge._utils /*b4j.example.pyutils*/ ._pyobjectcounter /*int*/ +1)) : ((Object)(_res[(int) (0)]._internalkey /*b4j.example.pybridge._pyobject*/ .Key /*int*/ )))));
 //BA.debugLineNum = 76;BA.debugLine="Dim p As PyWrapper = mBridge.Bridge.RunArgs(\"to_a";
_p = _mbridge._bridge /*b4j.example.pywrapper*/ ._runargs /*b4j.example.pywrapper*/ ("to_array",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{this,(Object)(_start),(Object)(_length)}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 77;BA.debugLine="res(Length - 1) = p";
_res[(int) (_length-1)] = _p;
 //BA.debugLineNum = 78;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _tolist() throws Exception{
 //BA.debugLineNum = 299;BA.debugLine="Public Sub ToList As PyWrapper";
 //BA.debugLineNum = 300;BA.debugLine="Return mBridge.Builtins.Run(\"list\").Arg(Me)";
if (true) return _mbridge._builtins /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("list")._arg /*b4j.example.pywrapper*/ (this);
 //BA.debugLineNum = 301;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _typeof() throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Public Sub TypeOf As PyWrapper";
 //BA.debugLineNum = 212;BA.debugLine="Return mBridge.Builtins.Run(\"type\").Arg(InternalK";
if (true) return _mbridge._builtins /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("type")._arg /*b4j.example.pywrapper*/ ((Object)(_internalkey));
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _wrap(b4j.example.pybridge._internalpytaskasyncresult _result) throws Exception{
b4j.example.pywrapper _w = null;
b4j.example.pybridge._pyobject _key = null;
boolean _error = false;
Object _value = null;
 //BA.debugLineNum = 115;BA.debugLine="Private Sub Wrap (Result As InternalPyTaskAsyncRes";
 //BA.debugLineNum = 116;BA.debugLine="Dim w As PyWrapper";
_w = new b4j.example.pywrapper();
 //BA.debugLineNum = 117;BA.debugLine="Dim key As PyObject = Result.PyObject";
_key = _result.PyObject /*b4j.example.pybridge._pyobject*/ ;
 //BA.debugLineNum = 118;BA.debugLine="Dim error As Boolean = Result.Error";
_error = _result.Error /*boolean*/ ;
 //BA.debugLineNum = 119;BA.debugLine="Dim value As Object = Result.Value";
_value = _result.Value /*Object*/ ;
 //BA.debugLineNum = 120;BA.debugLine="w.Initialize(mBridge, key)";
_w._initialize /*String*/ (ba,_mbridge,_key);
 //BA.debugLineNum = 121;BA.debugLine="w.mError = error";
_w._merror /*boolean*/  = _error;
 //BA.debugLineNum = 122;BA.debugLine="w.mValue = value";
_w._mvalue /*Object*/  = _value;
 //BA.debugLineNum = 123;BA.debugLine="w.mFetched = True";
_w._mfetched /*boolean*/  = __c.True;
 //BA.debugLineNum = 124;BA.debugLine="Return w";
if (true) return _w;
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
public void raiseError(String desc) {
	throw new RuntimeException (desc);
}
}
