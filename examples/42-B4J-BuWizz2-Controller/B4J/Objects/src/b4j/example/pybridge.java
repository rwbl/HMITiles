package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class pybridge extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.pybridge", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.pybridge.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.pycomm _comm = null;
public Object _mcallback = null;
public String _meventname = "";
public b4j.example.pyutils _utils = null;
public b4j.example.pywrapper _builtins = null;
public b4j.example.pywrapper _bridge = null;
public b4j.example.pywrapper _itertools = null;
public b4j.example.pywrapper _sys = null;
public anywheresoftware.b4j.objects.Shell _shl = null;
public b4j.example.pybridge._pyoptions _moptions = null;
public int _shlreadloopindex = 0;
public b4j.example.pyerrorhandler _errorhandler = null;
public String _pylastexception = "";
public anywheresoftware.b4a.objects.collections.Map _eventmapper = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public static class _pyobject{
public boolean IsInitialized;
public int Key;
public void Initialize() {
IsInitialized = true;
Key = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _pytask{
public boolean IsInitialized;
public int TaskId;
public int TaskType;
public anywheresoftware.b4a.objects.collections.List Extra;
public void Initialize() {
IsInitialized = true;
TaskId = 0;
TaskType = 0;
Extra = new anywheresoftware.b4a.objects.collections.List();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _internalpytaskasyncresult{
public boolean IsInitialized;
public b4j.example.pybridge._pyobject PyObject;
public Object Value;
public boolean Error;
public void Initialize() {
IsInitialized = true;
PyObject = new b4j.example.pybridge._pyobject();
Value = new Object();
Error = false;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _pyoptions{
public boolean IsInitialized;
public String PythonExecutable;
public int LocalPort;
public String PyBridgePath;
public int PyOutColor;
public int PyErrColor;
public int B4JColor;
public boolean ForceCopyBridgeSrc;
public int WatchDogSeconds;
public String PyCacheFolder;
public anywheresoftware.b4a.objects.collections.Map EnvironmentVars;
public boolean TrackLineNumbers;
public String PythonPath;
public void Initialize() {
IsInitialized = true;
PythonExecutable = "";
LocalPort = 0;
PyBridgePath = "";
PyOutColor = 0;
PyErrColor = 0;
B4JColor = 0;
ForceCopyBridgeSrc = false;
WatchDogSeconds = 0;
PyCacheFolder = "";
EnvironmentVars = new anywheresoftware.b4a.objects.collections.Map();
TrackLineNumbers = false;
PythonPath = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _internalpymethodargs{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.collections.List Args;
public anywheresoftware.b4a.objects.collections.Map KWArgs;
public b4j.example.pybridge._pytask Task;
public void Initialize() {
IsInitialized = true;
Args = new anywheresoftware.b4a.objects.collections.List();
KWArgs = new anywheresoftware.b4a.objects.collections.Map();
Task = new b4j.example.pybridge._pytask();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _afterconnection() throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Private Sub AfterConnection";
 //BA.debugLineNum = 144;BA.debugLine="Bridge.Initialize(Me, Utils.CreatePyObject(1))";
_bridge._initialize /*String*/ (ba,(b4j.example.pybridge)(this),_utils._createpyobject /*b4j.example.pybridge._pyobject*/ ((int) (1)));
 //BA.debugLineNum = 145;BA.debugLine="Builtins.Initialize(Me, Utils.CreatePyObject(3))";
_builtins._initialize /*String*/ (ba,(b4j.example.pybridge)(this),_utils._createpyobject /*b4j.example.pybridge._pyobject*/ ((int) (3)));
 //BA.debugLineNum = 146;BA.debugLine="Utils.Connected(Utils.CreatePyObject(2), mOptions";
_utils._connected /*String*/ (_utils._createpyobject /*b4j.example.pybridge._pyobject*/ ((int) (2)),_moptions);
 //BA.debugLineNum = 147;BA.debugLine="Sys = ImportModule(\"sys\")";
_sys = _importmodule("sys");
 //BA.debugLineNum = 148;BA.debugLine="Itertools = ImportModule(\"itertools\")";
_itertools = _importmodule("itertools");
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _asfloat(Object _o) throws Exception{
 //BA.debugLineNum = 307;BA.debugLine="Public Sub AsFloat (o As Object) As PyWrapper";
 //BA.debugLineNum = 308;BA.debugLine="Return Builtins.Run(\"float\").Arg(o)";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("float")._arg /*b4j.example.pywrapper*/ (_o);
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _asint(Object _o) throws Exception{
 //BA.debugLineNum = 297;BA.debugLine="Public Sub AsInt (o As Object) As PyWrapper";
 //BA.debugLineNum = 298;BA.debugLine="Return Builtins.Run(\"int\").Arg(o)";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("int")._arg /*b4j.example.pywrapper*/ (_o);
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _asstr(Object _o) throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Public Sub AsStr (o As Object) As PyWrapper";
 //BA.debugLineNum = 303;BA.debugLine="Return Builtins.Run(\"str\").Arg(o)";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("str")._arg /*b4j.example.pywrapper*/ (_o);
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return null;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Type PyObject (Key As Int)";
;
 //BA.debugLineNum = 6;BA.debugLine="Type PyTask (TaskId As Int, TaskType As Int, Extr";
;
 //BA.debugLineNum = 7;BA.debugLine="Type InternalPyTaskAsyncResult (PyObject As PyObj";
;
 //BA.debugLineNum = 8;BA.debugLine="Type PyOptions (PythonExecutable As String, Local";
;
 //BA.debugLineNum = 12;BA.debugLine="Type InternalPyMethodArgs (Args As List, KWArgs A";
;
 //BA.debugLineNum = 13;BA.debugLine="Private comm As PyComm";
_comm = new b4j.example.pycomm();
 //BA.debugLineNum = 14;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 15;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 16;BA.debugLine="Public Utils As PyUtils";
_utils = new b4j.example.pyutils();
 //BA.debugLineNum = 17;BA.debugLine="Public Builtins As PyWrapper";
_builtins = new b4j.example.pywrapper();
 //BA.debugLineNum = 18;BA.debugLine="Public Bridge As PyWrapper";
_bridge = new b4j.example.pywrapper();
 //BA.debugLineNum = 19;BA.debugLine="Public Itertools As PyWrapper";
_itertools = new b4j.example.pywrapper();
 //BA.debugLineNum = 20;BA.debugLine="Public Sys As PyWrapper";
_sys = new b4j.example.pywrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private Shl As Shell";
_shl = new anywheresoftware.b4j.objects.Shell();
 //BA.debugLineNum = 22;BA.debugLine="Private mOptions As PyOptions";
_moptions = new b4j.example.pybridge._pyoptions();
 //BA.debugLineNum = 23;BA.debugLine="Private ShlReadLoopIndex As Int";
_shlreadloopindex = 0;
 //BA.debugLineNum = 24;BA.debugLine="Public ErrorHandler As PyErrorHandler";
_errorhandler = new b4j.example.pyerrorhandler();
 //BA.debugLineNum = 25;BA.debugLine="Public PyLastException As String";
_pylastexception = "";
 //BA.debugLineNum = 26;BA.debugLine="Private EventMapper As Map";
_eventmapper = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _convertunserializable(Object _list) throws Exception{
String _code = "";
 //BA.debugLineNum = 366;BA.debugLine="Private Sub ConvertUnserializable (List As Object)";
 //BA.debugLineNum = 367;BA.debugLine="Dim Code As String = $\" def ConvertUnserializable";
_code = ("\n"+"def ConvertUnserializable (bridge, list1):\n"+"	l = map(lambda x: bridge.comm.serializator.is_serializable(x), list1)\n"+"	return [x if y is None else str(y)[:100] for x, y in zip(list1, l)]\n"+"");
 //BA.debugLineNum = 372;BA.debugLine="Return RunCode(\"ConvertUnserializable\", Array(Bri";
if (true) return _runcode("ConvertUnserializable",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_bridge),_list}),_code);
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return null;
}
public b4j.example.pybridge._pyoptions  _createoptions(String _pythonexecutable) throws Exception{
b4j.example.pybridge._pyoptions _opt = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.objects.collections.Map _allenvvars = null;
String _key = "";
 //BA.debugLineNum = 106;BA.debugLine="Public Sub CreateOptions (PythonExecutable As Stri";
 //BA.debugLineNum = 107;BA.debugLine="Dim opt As PyOptions";
_opt = new b4j.example.pybridge._pyoptions();
 //BA.debugLineNum = 108;BA.debugLine="opt.Initialize";
_opt.Initialize();
 //BA.debugLineNum = 109;BA.debugLine="opt.PythonExecutable = PythonExecutable";
_opt.PythonExecutable /*String*/  = _pythonexecutable;
 //BA.debugLineNum = 110;BA.debugLine="opt.PyBridgePath = File.Combine(File.DirData(\"pyb";
_opt.PyBridgePath /*String*/  = __c.File.Combine(__c.File.DirData("pybridge"),("b4x_bridge_"+__c.SmartStringFormatter("",(Object)(_utils._pythonbridgecodeversion /*String*/ ))+".zip"));
 //BA.debugLineNum = 111;BA.debugLine="opt.B4JColor = 0xFF727272";
_opt.B4JColor /*int*/  = ((int)0xff727272);
 //BA.debugLineNum = 112;BA.debugLine="opt.PyErrColor = 0xFFF74479";
_opt.PyErrColor /*int*/  = ((int)0xfff74479);
 //BA.debugLineNum = 113;BA.debugLine="opt.PyOutColor = 0xFF446EF7";
_opt.PyOutColor /*int*/  = ((int)0xff446ef7);
 //BA.debugLineNum = 114;BA.debugLine="opt.WatchDogSeconds = 30";
_opt.WatchDogSeconds /*int*/  = (int) (30);
 //BA.debugLineNum = 115;BA.debugLine="opt.PyCacheFolder = File.DirData(\"pybridge\")";
_opt.PyCacheFolder /*String*/  = __c.File.DirData("pybridge");
 //BA.debugLineNum = 116;BA.debugLine="opt.EnvironmentVars =  CreateMap(\"PYTHONUTF8\": 1)";
_opt.EnvironmentVars /*anywheresoftware.b4a.objects.collections.Map*/  = __c.createMap(new Object[] {(Object)("PYTHONUTF8"),(Object)(1)});
 //BA.debugLineNum = 117;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 118;BA.debugLine="jo.InitializeStatic(\"java.lang.System\")";
_jo.InitializeStatic("java.lang.System");
 //BA.debugLineNum = 119;BA.debugLine="Dim AllEnvVars As Map = jo.RunMethod(\"getenv\", Nu";
_allenvvars = new anywheresoftware.b4a.objects.collections.Map();
_allenvvars = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_jo.RunMethod("getenv",(Object[])(__c.Null))));
 //BA.debugLineNum = 120;BA.debugLine="For Each key As String In AllEnvVars.Keys";
{
final anywheresoftware.b4a.BA.IterableList group14 = _allenvvars.Keys();
final int groupLen14 = group14.getSize()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_key = BA.ObjectToString(group14.Get(index14));
 //BA.debugLineNum = 121;BA.debugLine="opt.EnvironmentVars.Put(key, AllEnvVars.Get(key)";
_opt.EnvironmentVars /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(_key),_allenvvars.Get((Object)(_key)));
 }
};
 //BA.debugLineNum = 123;BA.debugLine="opt.PythonPath = \"\"";
_opt.PythonPath /*String*/  = "";
 //BA.debugLineNum = 124;BA.debugLine="opt.TrackLineNumbers = True";
_opt.TrackLineNumbers /*boolean*/  = __c.True;
 //BA.debugLineNum = 125;BA.debugLine="If Utils.DetectOS = \"windows\" Then opt.Environmen";
if ((_utils._detectos /*String*/ ()).equals("windows")) { 
_opt.EnvironmentVars /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("MPLCONFIGDIR"),(Object)(__c.GetEnvironmentVariable("USERPROFILE","")));};
 //BA.debugLineNum = 126;BA.debugLine="Return opt";
if (true) return _opt;
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _fetchobjects(Object _objects) throws Exception{
ResumableSub_FetchObjects rsub = new ResumableSub_FetchObjects(this,_objects);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_FetchObjects extends BA.ResumableSub {
public ResumableSub_FetchObjects(b4j.example.pybridge parent,Object _objects) {
this.parent = parent;
this._objects = _objects;
}
b4j.example.pybridge parent;
Object _objects;
b4j.example.pywrapper _list = null;
b4j.example.pywrapper _result = null;

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
 //BA.debugLineNum = 356;BA.debugLine="Dim List As PyWrapper = IIf(Objects Is PyWrapper,";
_list = (b4j.example.pywrapper)(((_objects instanceof b4j.example.pywrapper) ? (_objects) : ((Object)(parent._wrapobject(_objects)))));
 //BA.debugLineNum = 357;BA.debugLine="Wait For (ConvertUnserializable(List).Fetch) Comp";
parent.__c.WaitFor("complete", ba, this, parent._convertunserializable((Object)(_list))._fetch /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 358;BA.debugLine="Return Result.Value.As(List)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_result._getvalue /*Object*/ ())))));return;};
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(b4j.example.pywrapper _result) throws Exception{
}
public b4j.example.pywrapper  _filter(Object _predicate,Object _iterable) throws Exception{
 //BA.debugLineNum = 327;BA.debugLine="Public Sub Filter (Predicate As Object, Iterable A";
 //BA.debugLineNum = 328;BA.debugLine="Return Builtins.Run(\"filter\").Arg(Utils.ConvertLa";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("filter")._arg /*b4j.example.pywrapper*/ ((Object)(_utils._convertlambdaifmatch /*b4j.example.pywrapper*/ (_predicate)))._arg /*b4j.example.pywrapper*/ (_iterable);
 //BA.debugLineNum = 329;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _flush() throws Exception{
ResumableSub_Flush rsub = new ResumableSub_Flush(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Flush extends BA.ResumableSub {
public ResumableSub_Flush(b4j.example.pybridge parent) {
this.parent = parent;
}
b4j.example.pybridge parent;
boolean _success = false;

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
 //BA.debugLineNum = 155;BA.debugLine="Wait For (Utils.Flush) Complete (Success As Boole";
parent.__c.WaitFor("complete", ba, this, parent._utils._flush /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ());
this.state = 1;
return;
case 1:
//C
this.state = -1;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 156;BA.debugLine="Return Success";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_success));return;};
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public b4j.example.pywrapper  _getmember(String _member) throws Exception{
 //BA.debugLineNum = 268;BA.debugLine="Public Sub GetMember(Member As String) As PyWrappe";
 //BA.debugLineNum = 269;BA.debugLine="Return Utils.EvalGlobals.Get(Member)";
if (true) return _utils._evalglobals /*b4j.example.pywrapper*/ ._get /*b4j.example.pywrapper*/ ((Object)(_member));
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return null;
}
public String  _handleoutanderr(String _out,String _err) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Private Sub HandleOutAndErr (out As String, Err As";
 //BA.debugLineNum = 85;BA.debugLine="If out.Length > 0 Then Utils.PyLog(Utils.PyOutPre";
if (_out.length()>0) { 
_utils._pylog /*String*/ (_utils._pyoutprefix /*String*/ ,_moptions.PyOutColor /*int*/ ,(Object)(_out));};
 //BA.debugLineNum = 86;BA.debugLine="If Err.Length > 0 Then Utils.PyLog(Utils.PyErrPre";
if (_err.length()>0) { 
_utils._pylog /*String*/ (_utils._pyerrprefix /*String*/ ,_moptions.PyErrColor /*int*/ ,(Object)(_err));};
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _imagefrombytes(byte[] _bytes) throws Exception{
anywheresoftware.b4j.objects.ImageViewWrapper.ImageWrapper _image = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
 //BA.debugLineNum = 403;BA.debugLine="Public Sub ImageFromBytes(Bytes() As Byte) As B4XB";
 //BA.debugLineNum = 404;BA.debugLine="Dim Image As Image";
_image = new anywheresoftware.b4j.objects.ImageViewWrapper.ImageWrapper();
 //BA.debugLineNum = 405;BA.debugLine="Dim in As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 406;BA.debugLine="in.InitializeFromBytesArray(Bytes, 0, Bytes.Lengt";
_in.InitializeFromBytesArray(_bytes,(int) (0),_bytes.length);
 //BA.debugLineNum = 407;BA.debugLine="Image.Initialize2(in)";
_image.Initialize2((java.io.InputStream)(_in.getObject()));
 //BA.debugLineNum = 408;BA.debugLine="in.Close";
_in.Close();
 //BA.debugLineNum = 409;BA.debugLine="Return Image";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (javafx.scene.image.Image)(_image.getObject()));
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return null;
}
public byte[]  _imagetobytes(anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _image) throws Exception{
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 413;BA.debugLine="Public Sub ImageToBytes (Image As B4XBitmap) As By";
 //BA.debugLineNum = 414;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 415;BA.debugLine="out.InitializeToBytesArray(0)";
_out.InitializeToBytesArray((int) (0));
 //BA.debugLineNum = 416;BA.debugLine="Image.WriteToStream(out, 100, \"PNG\")";
_image.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),"PNG");
 //BA.debugLineNum = 417;BA.debugLine="Return out.ToBytesArray";
if (true) return _out.ToBytesArray();
 //BA.debugLineNum = 418;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _importmodule(String _module) throws Exception{
b4j.example.pywrapper _res = null;
 //BA.debugLineNum = 273;BA.debugLine="Public Sub ImportModule (Module As String) As PyWr";
 //BA.debugLineNum = 274;BA.debugLine="RunNoArgsCode(\"import \" & Module)";
_runnoargscode("import "+_module);
 //BA.debugLineNum = 275;BA.debugLine="Dim res As PyWrapper = Utils.ImportLib.Run(\"impor";
_res = _utils._importlib /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("import_module")._arg /*b4j.example.pywrapper*/ ((Object)(_module));
 //BA.debugLineNum = 276;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _importmodulefrom(String _frommodule,String _importmember) throws Exception{
b4j.example.pywrapper _res = null;
 //BA.debugLineNum = 280;BA.debugLine="Public Sub ImportModuleFrom(FromModule As String,";
 //BA.debugLineNum = 281;BA.debugLine="RunNoArgsCode(\"from \" & FromModule & \" import \" &";
_runnoargscode("from "+_frommodule+" import "+_importmember);
 //BA.debugLineNum = 282;BA.debugLine="Dim res As PyWrapper = ImportModule(FromModule).G";
_res = _importmodule(_frommodule)._getfield /*b4j.example.pywrapper*/ (_importmember);
 //BA.debugLineNum = 283;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 30;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 31;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 32;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 33;BA.debugLine="mOptions.Initialize";
_moptions.Initialize();
 //BA.debugLineNum = 34;BA.debugLine="ErrorHandler.Initialize(Utils)";
_errorhandler._initialize /*String*/ (ba,_utils);
 //BA.debugLineNum = 35;BA.debugLine="Utils.Initialize(Me, comm)";
_utils._initialize /*String*/ (ba,(b4j.example.pybridge)(this),_comm);
 //BA.debugLineNum = 36;BA.debugLine="EventMapper.Initialize";
_eventmapper.Initialize();
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public String  _killprocess() throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Public Sub KillProcess";
 //BA.debugLineNum = 185;BA.debugLine="Try";
try { //BA.debugLineNum = 186;BA.debugLine="ShlReadLoopIndex = ShlReadLoopIndex + 1";
_shlreadloopindex = (int) (_shlreadloopindex+1);
 //BA.debugLineNum = 187;BA.debugLine="If Initialized(comm) Then";
if (__c.Initialized((Object)(_comm))) { 
 //BA.debugLineNum = 188;BA.debugLine="comm.CloseServer";
_comm._closeserver /*String*/ ();
 };
 //BA.debugLineNum = 190;BA.debugLine="If mOptions.PythonExecutable <> \"\" And Initializ";
if ((_moptions.PythonExecutable /*String*/ ).equals("") == false && __c.Initialized((Object)(_shl))) { 
 //BA.debugLineNum = 191;BA.debugLine="Shl.KillProcess";
_shl.KillProcess();
 };
 } 
       catch (Exception e10) {
			ba.setLastException(e10); //BA.debugLineNum = 194;BA.debugLine="Log(LastException)";
__c.LogImpl("973334794",BA.ObjectToString(__c.LastException(ba)),0);
 };
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _lambda(String _code) throws Exception{
 //BA.debugLineNum = 337;BA.debugLine="Public Sub Lambda(Code As String) As PyWrapper";
 //BA.debugLineNum = 338;BA.debugLine="Return RunStatement(\"lambda \" & Code)";
if (true) return _runstatement("lambda "+_code);
 //BA.debugLineNum = 339;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _map_(Object _function,Object _iterable) throws Exception{
 //BA.debugLineNum = 317;BA.debugLine="Public Sub Map_(Function As Object, Iterable As Ob";
 //BA.debugLineNum = 318;BA.debugLine="Return Builtins.Run(\"map\").Arg(Utils.ConvertLambd";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("map")._arg /*b4j.example.pywrapper*/ ((Object)(_utils._convertlambdaifmatch /*b4j.example.pywrapper*/ (_function)))._arg /*b4j.example.pywrapper*/ (_iterable);
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _open(Object _filepath,Object _mode) throws Exception{
 //BA.debugLineNum = 397;BA.debugLine="Public Sub Open (FilePath As Object, Mode As Objec";
 //BA.debugLineNum = 398;BA.debugLine="Return Builtins.Run(\"open\").Arg(FilePath).Arg(Mod";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("open")._arg /*b4j.example.pywrapper*/ (_filepath)._arg /*b4j.example.pywrapper*/ (_mode);
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return null;
}
public String  _print(Object _obj) throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Public Sub Print(Obj As Object)";
 //BA.debugLineNum = 200;BA.debugLine="PrintJoin(Array(Obj), False)";
_printjoin(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_obj}),__c.False);
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public String  _printjoin(anywheresoftware.b4a.objects.collections.List _objects,boolean _stderr) throws Exception{
String _code = "";
 //BA.debugLineNum = 204;BA.debugLine="Public Sub PrintJoin (Objects As List, StdErr As B";
 //BA.debugLineNum = 205;BA.debugLine="Dim Code As String = $\" def _print(obj, StdErr):";
_code = ("\n"+"def _print(obj, StdErr):\n"+"	print(*obj, file=sys.stderr if StdErr else sys.stdout)\n"+"");
 //BA.debugLineNum = 209;BA.debugLine="RunCode(\"_print\", Array(Objects, StdErr), Code)";
_runcode("_print",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_objects.getObject()),(Object)(_stderr)}),_code);
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _pyiif(Object _condition,Object _truevalue,Object _falsevalue) throws Exception{
 //BA.debugLineNum = 376;BA.debugLine="Public Sub PyIIf (Condition As Object, TrueValue A";
 //BA.debugLineNum = 377;BA.debugLine="Return RunCode(\"PyIIF\", Array(Condition, TrueValu";
if (true) return _runcode("PyIIF",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_condition,_truevalue,_falsevalue}),("\n"+"def PyIIF(condition, TrueValue, FalseValue):\n"+"	res = TrueValue if condition else FalseValue\n"+"	if callable(res):\n"+"		return res()\n"+"	else:\n"+"		return res\n"+""));
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _pynext(b4j.example.pywrapper _iter) throws Exception{
 //BA.debugLineNum = 349;BA.debugLine="Public Sub PyNext(Iter As PyWrapper) As PyWrapper";
 //BA.debugLineNum = 350;BA.debugLine="Return Builtins.Run(\"next\").Arg(Iter)";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("next")._arg /*b4j.example.pywrapper*/ ((Object)(_iter));
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _range(Object _firstparam) throws Exception{
 //BA.debugLineNum = 362;BA.debugLine="Public Sub Range (FirstParam As Object) As PyWrapp";
 //BA.debugLineNum = 363;BA.debugLine="Return Builtins.Run(\"range\").Arg(FirstParam)";
if (true) return _builtins._run /*b4j.example.pywrapper*/ ("range")._arg /*b4j.example.pywrapper*/ (_firstparam);
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return null;
}
public String  _registermember(String _keyname,String _classcode,boolean _overwrite) throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Private Sub RegisterMember (KeyName As String, Cla";
 //BA.debugLineNum = 214;BA.debugLine="If Utils.RegisteredMembers.Contains(KeyName) = Fa";
if (_utils._registeredmembers /*b4j.example.b4xset*/ ._contains /*boolean*/ ((Object)(_keyname))==__c.False || _overwrite) { 
 //BA.debugLineNum = 215;BA.debugLine="RunNoArgsCode(ClassCode)";
_runnoargscode(_classcode);
 //BA.debugLineNum = 216;BA.debugLine="Utils.RegisteredMembers.Add(KeyName)";
_utils._registeredmembers /*b4j.example.b4xset*/ ._add /*String*/ ((Object)(_keyname));
 };
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _runcode(String _membername,anywheresoftware.b4a.objects.collections.List _args,String _functioncode) throws Exception{
 //BA.debugLineNum = 222;BA.debugLine="Public Sub RunCode (MemberName As String, Args As";
 //BA.debugLineNum = 223;BA.debugLine="RegisterMember(MemberName, FunctionCode, False)";
_registermember(_membername,_functioncode,__c.False);
 //BA.debugLineNum = 224;BA.debugLine="Return GetMember(MemberName).Call.Args(Args)";
if (true) return _getmember(_membername)._call /*b4j.example.pywrapper*/ ()._args /*b4j.example.pywrapper*/ (_args);
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _runcodeawait(String _membername,anywheresoftware.b4a.objects.collections.List _args,String _functioncode) throws Exception{
ResumableSub_RunCodeAwait rsub = new ResumableSub_RunCodeAwait(this,_membername,_args,_functioncode);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_RunCodeAwait extends BA.ResumableSub {
public ResumableSub_RunCodeAwait(b4j.example.pybridge parent,String _membername,anywheresoftware.b4a.objects.collections.List _args,String _functioncode) {
this.parent = parent;
this._membername = _membername;
this._args = _args;
this._functioncode = _functioncode;
}
b4j.example.pybridge parent;
String _membername;
anywheresoftware.b4a.objects.collections.List _args;
String _functioncode;
b4j.example.pywrapper _result = null;

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
 //BA.debugLineNum = 244;BA.debugLine="RegisterMember(MemberName, FunctionCode, False)";
parent._registermember(_membername,_functioncode,parent.__c.False);
 //BA.debugLineNum = 245;BA.debugLine="Wait For (GetMember(MemberName).RunAwait(\"__call_";
parent.__c.WaitFor("complete", ba, this, parent._getmember(_membername)._runawait /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ("__call__",_args,(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(parent.__c.Null))));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_result = (b4j.example.pywrapper) result[0];
;
 //BA.debugLineNum = 246;BA.debugLine="Return Result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _runnoargscode(String _code) throws Exception{
 //BA.debugLineNum = 250;BA.debugLine="Public Sub RunNoArgsCode (Code As String)";
 //BA.debugLineNum = 251;BA.debugLine="Builtins.RunArgs(\"exec\", Array(Code, Utils.EvalGl";
_builtins._runargs /*b4j.example.pywrapper*/ ("exec",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_code),(Object)(_utils._evalglobals /*b4j.example.pywrapper*/ ),__c.Null}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _runstatement(String _code) throws Exception{
 //BA.debugLineNum = 256;BA.debugLine="Public Sub RunStatement (Code As String) As PyWrap";
 //BA.debugLineNum = 257;BA.debugLine="Return RunStatement2(Code, Null)";
if (true) return _runstatement2(_code,(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 258;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _runstatement2(String _code,anywheresoftware.b4a.objects.collections.Map _locals) throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Public Sub RunStatement2 (Code As String, Locals A";
 //BA.debugLineNum = 263;BA.debugLine="If NotInitialized(Locals) Then Locals = B4XCollec";
if (__c.NotInitialized((Object)(_locals))) { 
_locals = _b4xcollections._getemptymap /*anywheresoftware.b4a.objects.collections.Map*/ ();};
 //BA.debugLineNum = 264;BA.debugLine="Return Builtins.RunArgs (\"eval\", Array(Code, Util";
if (true) return _builtins._runargs /*b4j.example.pywrapper*/ ("eval",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_code),(Object)(_utils._evalglobals /*b4j.example.pywrapper*/ ),(Object)(_locals.getObject())}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return null;
}
public String  _seteventmapping(String _pythoneventname,Object _callback,String _b4xeventname) throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Public Sub SetEventMapping(PythonEventName As Stri";
 //BA.debugLineNum = 180;BA.debugLine="EventMapper.Put(PythonEventName, Array(Callback,";
_eventmapper.Put((Object)(_pythoneventname),(Object)(new Object[]{_callback,(Object)(_b4xeventname)}));
 //BA.debugLineNum = 181;BA.debugLine="End Sub";
return "";
}
public String  _shl_processcompleted(boolean _success,int _exitcode,String _stdout,String _stderr) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Private Sub shl_ProcessCompleted (Success As Boole";
 //BA.debugLineNum = 92;BA.debugLine="HandleOutAndErr(StdOut, StdErr)";
_handleoutanderr(_stdout,_stderr);
 //BA.debugLineNum = 93;BA.debugLine="Utils.PyLog(Utils.B4JPrefix, mOptions.B4JColor, $";
_utils._pylog /*String*/ (_utils._b4jprefix /*String*/ ,_moptions.B4JColor /*int*/ ,(Object)(("Process completed. ExitCode: "+__c.SmartStringFormatter("",(Object)(_exitcode))+"")));
 //BA.debugLineNum = 94;BA.debugLine="Dim Shl As Shell";
_shl = new anywheresoftware.b4j.objects.Shell();
 //BA.debugLineNum = 95;BA.debugLine="comm.CloseServer";
_comm._closeserver /*String*/ ();
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public void  _shlreadloop() throws Exception{
ResumableSub_ShlReadLoop rsub = new ResumableSub_ShlReadLoop(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ShlReadLoop extends BA.ResumableSub {
public ResumableSub_ShlReadLoop(b4j.example.pybridge parent) {
this.parent = parent;
}
b4j.example.pybridge parent;
int _myindex = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 76;BA.debugLine="ShlReadLoopIndex = ShlReadLoopIndex + 1";
parent._shlreadloopindex = (int) (parent._shlreadloopindex+1);
 //BA.debugLineNum = 77;BA.debugLine="Dim MyIndex As Int = ShlReadLoopIndex";
_myindex = parent._shlreadloopindex;
 //BA.debugLineNum = 78;BA.debugLine="Do While MyIndex = ShlReadLoopIndex And Initializ";
if (true) break;

case 1:
//do while
this.state = 4;
while (_myindex==parent._shlreadloopindex && parent.__c.Initialized((Object)(parent._shl))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 79;BA.debugLine="HandleOutAndErr(Shl.GetTempOut2(True), Shl.GetTe";
parent._handleoutanderr(parent._shl.GetTempOut2(parent.__c.True),parent._shl.GetTempErr2(parent.__c.True));
 //BA.debugLineNum = 80;BA.debugLine="Sleep(50)";
parent.__c.Sleep(ba,this,(int) (50));
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public b4j.example.pywrapper  _slice(Object _startvalue,Object _stopvalue) throws Exception{
 //BA.debugLineNum = 287;BA.debugLine="Public Sub Slice (StartValue As Object, StopValue";
 //BA.debugLineNum = 288;BA.debugLine="Return Builtins.RunArgs(\"slice\", Array(Utils.Conv";
if (true) return _builtins._runargs /*b4j.example.pywrapper*/ ("slice",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_utils._converttointifmatch /*Object*/ (_startvalue),_utils._converttointifmatch /*Object*/ (_stopvalue)}),(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(__c.Null)));
 //BA.debugLineNum = 289;BA.debugLine="End Sub";
return null;
}
public b4j.example.pywrapper  _sliceall() throws Exception{
 //BA.debugLineNum = 292;BA.debugLine="Public Sub SliceAll As PyWrapper";
 //BA.debugLineNum = 293;BA.debugLine="Return Slice(Null, Null)";
if (true) return _slice(__c.Null,__c.Null);
 //BA.debugLineNum = 294;BA.debugLine="End Sub";
return null;
}
public String  _start(b4j.example.pybridge._pyoptions _options) throws Exception{
String _exe = "";
String _globalpath = "";
String _path = "";
 //BA.debugLineNum = 41;BA.debugLine="Public Sub Start (Options As PyOptions)";
 //BA.debugLineNum = 42;BA.debugLine="KillProcess";
_killprocess();
 //BA.debugLineNum = 43;BA.debugLine="mOptions = Options";
_moptions = _options;
 //BA.debugLineNum = 44;BA.debugLine="comm.Initialize(Me, Options.LocalPort)";
_comm._initialize /*String*/ (ba,(b4j.example.pybridge)(this),_options.LocalPort /*int*/ );
 //BA.debugLineNum = 45;BA.debugLine="Utils.Comm = comm";
_utils._comm /*b4j.example.pycomm*/  = _comm;
 //BA.debugLineNum = 46;BA.debugLine="If Options.PythonExecutable <> \"\" Then";
if ((_options.PythonExecutable /*String*/ ).equals("") == false) { 
 //BA.debugLineNum = 47;BA.debugLine="If File.Exists(Options.PyBridgePath, \"\") = False";
if (__c.File.Exists(_options.PyBridgePath /*String*/ ,"")==__c.False || _moptions.ForceCopyBridgeSrc /*boolean*/ ) { 
 //BA.debugLineNum = 48;BA.debugLine="File.Copy(File.DirAssets, \"b4x_bridge.zip\", Opt";
__c.File.Copy(__c.File.getDirAssets(),"b4x_bridge.zip",_options.PyBridgePath /*String*/ ,"");
 //BA.debugLineNum = 49;BA.debugLine="Utils.PyLog(Utils.B4JPrefix, mOptions.B4JColor,";
_utils._pylog /*String*/ (_utils._b4jprefix /*String*/ ,_moptions.B4JColor /*int*/ ,(Object)("Python package copied to: "+_options.PyBridgePath /*String*/ ));
 };
 //BA.debugLineNum = 51;BA.debugLine="Dim exe As String = Options.PythonExecutable";
_exe = _options.PythonExecutable /*String*/ ;
 //BA.debugLineNum = 52;BA.debugLine="If File.Exists(exe, \"\") = False Then";
if (__c.File.Exists(_exe,"")==__c.False) { 
 //BA.debugLineNum = 53;BA.debugLine="Dim GlobalPath As String = File.Combine(GetEnvi";
_globalpath = __c.File.Combine(__c.GetEnvironmentVariable("B4J_PYTHON",""),"python.exe");
 //BA.debugLineNum = 54;BA.debugLine="If File.Exists(GlobalPath, \"\") Then";
if (__c.File.Exists(_globalpath,"")) { 
 //BA.debugLineNum = 55;BA.debugLine="exe = GlobalPath";
_exe = _globalpath;
 }else {
 //BA.debugLineNum = 57;BA.debugLine="LogError(\"Python executable not found!\")";
__c.LogError("Python executable not found!");
 //BA.debugLineNum = 58;BA.debugLine="comm.CloseServer";
_comm._closeserver /*String*/ ();
 //BA.debugLineNum = 59;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 62;BA.debugLine="Log($\"Python path: ${exe}\"$)";
__c.LogImpl("972679445",("Python path: "+__c.SmartStringFormatter("",(Object)(_exe))+""),0);
 //BA.debugLineNum = 63;BA.debugLine="Dim Shl As Shell";
_shl = new anywheresoftware.b4j.objects.Shell();
 //BA.debugLineNum = 64;BA.debugLine="Shl.Initialize(\"shl\", exe, Array As String(\"-u\",";
_shl.Initialize("shl",_exe,anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"-u","-m","b4x_bridge",BA.NumberToString(_comm._port /*int*/ ),BA.NumberToString(_moptions.WatchDogSeconds /*int*/ )}));
 //BA.debugLineNum = 65;BA.debugLine="Dim path As String = IIf(Options.PythonPath = \"\"";
_path = BA.ObjectToString((((_options.PythonPath /*String*/ ).equals("")) ? ((Object)(_options.PyBridgePath /*String*/ )) : ((Object)(_options.PythonPath /*String*/ +";"+_options.PyBridgePath /*String*/ ))));
 //BA.debugLineNum = 66;BA.debugLine="Options.EnvironmentVars.Put(\"PYTHONPATH\", path)";
_options.EnvironmentVars /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("PYTHONPATH"),(Object)(_path));
 //BA.debugLineNum = 67;BA.debugLine="If Options.PyCacheFolder <> \"\" Then Options.Envi";
if ((_options.PyCacheFolder /*String*/ ).equals("") == false) { 
_options.EnvironmentVars /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("PYTHONPYCACHEPREFIX"),(Object)(_options.PyCacheFolder /*String*/ ));};
 //BA.debugLineNum = 68;BA.debugLine="Shl.SetEnvironmentVariables(Options.EnvironmentV";
_shl.SetEnvironmentVariables(_options.EnvironmentVars /*anywheresoftware.b4a.objects.collections.Map*/ );
 //BA.debugLineNum = 69;BA.debugLine="Shl.Run(-1)";
_shl.Run(ba,(long) (-1));
 //BA.debugLineNum = 70;BA.debugLine="ShlReadLoop";
_shlreadloop();
 };
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _state_changed(int _oldstate,int _newstate) throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Private Sub State_Changed (OldState As Int, NewSta";
 //BA.debugLineNum = 130;BA.debugLine="If NewState = comm.STATE_CONNECTED Then";
if (_newstate==_comm._state_connected /*int*/ ) { 
 //BA.debugLineNum = 131;BA.debugLine="AfterConnection";
_afterconnection();
 }else {
 //BA.debugLineNum = 133;BA.debugLine="Utils.Disconnected";
_utils._disconnected /*String*/ ();
 //BA.debugLineNum = 134;BA.debugLine="KillProcess";
_killprocess();
 };
 //BA.debugLineNum = 136;BA.debugLine="If NewState = comm.STATE_CONNECTED Or (OldState =";
if (_newstate==_comm._state_connected /*int*/  || (_oldstate==_comm._state_waiting_for_connection /*int*/  && _newstate==_comm._state_disconnected /*int*/ )) { 
 //BA.debugLineNum = 137;BA.debugLine="CallSubDelayed2(mCallback, mEventName & \"_connec";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_connected",(Object)(_newstate==_comm._state_connected /*int*/ ));
 }else if(__c.SubExists(ba,_mcallback,_meventname+"_disconnected")) { 
 //BA.debugLineNum = 139;BA.debugLine="CallSubDelayed(mCallback, mEventName & \"_disconn";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_disconnected");
 };
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public String  _task_received(b4j.example.pybridge._pytask _task) throws Exception{
String _eventname = "";
anywheresoftware.b4a.objects.collections.Map _params = null;
Object[] _cc = null;
 //BA.debugLineNum = 159;BA.debugLine="Private Sub Task_Received(TASK As PyTask)";
 //BA.debugLineNum = 160;BA.debugLine="If TASK.TaskType = Utils.TASK_TYPE_PING Then";
if (_task.TaskType /*int*/ ==_utils._task_type_ping /*int*/ ) { 
 //BA.debugLineNum = 161;BA.debugLine="comm.SendTask(Utils.CreatePyTask(0, Utils.TASK_T";
_comm._sendtask /*String*/ (_utils._createpytask /*b4j.example.pybridge._pytask*/ ((int) (0),_utils._task_type_ping /*int*/ ,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{})));
 }else if(_task.TaskType /*int*/ !=_utils._task_type_event /*int*/ ) { 
 //BA.debugLineNum = 163;BA.debugLine="LogError(\"Unexpected message: \" & TASK)";
__c.LogError("Unexpected message: "+BA.ObjectToString(_task));
 }else {
 //BA.debugLineNum = 165;BA.debugLine="Dim EventName As String = TASK.Extra.Get(0)";
_eventname = BA.ObjectToString(_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (0)));
 //BA.debugLineNum = 166;BA.debugLine="Dim Params As Map = TASK.Extra.Get(1)";
_params = new anywheresoftware.b4a.objects.collections.Map();
_params = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (1))));
 //BA.debugLineNum = 167;BA.debugLine="If EventMapper.ContainsKey(EventName) Then";
if (_eventmapper.ContainsKey((Object)(_eventname))) { 
 //BA.debugLineNum = 168;BA.debugLine="Dim cc() As Object = EventMapper.Get(EventName)";
_cc = (Object[])(_eventmapper.Get((Object)(_eventname)));
 //BA.debugLineNum = 169;BA.debugLine="CallSubDelayed2(cc(0), cc(1).As(String) & \"_\" &";
__c.CallSubDelayed2(ba,_cc[(int) (0)],(BA.ObjectToString(_cc[(int) (1)]))+"_"+_eventname,(Object)(_params));
 }else {
 //BA.debugLineNum = 171;BA.debugLine="CallSubDelayed2(mCallback, mEventName & \"_\" & E";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_"+_eventname,(Object)(_params));
 };
 };
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _wrapobject(Object _obj) throws Exception{
String _code = "";
 //BA.debugLineNum = 388;BA.debugLine="Public Sub WrapObject (Obj As Object) As PyWrapper";
 //BA.debugLineNum = 389;BA.debugLine="Dim Code As String = $\" def WrapObject(obj): 	ret";
_code = ("\n"+"def WrapObject(obj):\n"+"	return obj\n"+"");
 //BA.debugLineNum = 393;BA.debugLine="Return RunCode(\"WrapObject\", Array(Obj), Code)";
if (true) return _runcode("WrapObject",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_obj}),_code);
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "STATE_CHANGED"))
	return _state_changed(((Number)args[0]).intValue(), ((Number)args[1]).intValue());
if (BA.fastSubCompare(sub, "TASK_RECEIVED"))
	return _task_received((b4j.example.pybridge._pytask) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
