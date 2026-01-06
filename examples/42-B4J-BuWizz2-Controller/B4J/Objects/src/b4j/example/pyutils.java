package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class pyutils extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.pyutils", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.pyutils.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public int _task_type_run = 0;
public int _task_type_get = 0;
public int _task_type_run_async = 0;
public int _task_type_clean = 0;
public int _task_type_error = 0;
public int _task_type_event = 0;
public int _task_type_ping = 0;
public int _task_type_flush = 0;
public String _pythonbridgecodeversion = "";
public String _pyoutprefix = "";
public String _pyerrprefix = "";
public String _b4jprefix = "";
public b4j.example.pywrapper _evalglobals = null;
public b4j.example.pywrapper _importlib = null;
public b4j.example.pybridge _mbridge = null;
public int _taskidcounter = 0;
public int _pyobjectcounter = 0;
public anywheresoftware.b4j.object.JavaObject _cleanerclass = null;
public int _cleanerindex = 0;
public b4j.example.pycomm _comm = null;
public b4j.example.pybridge._pyoptions _moptions = null;
public anywheresoftware.b4j.object.JavaObject _cleaner = null;
public b4j.example.b4xset _registeredmembers = null;
public double _epsilon = 0;
public anywheresoftware.b4a.objects.collections.List _keysthatneedtoberegistered = null;
public anywheresoftware.b4a.objects.collections.List _objectsthatneedtoberegistered = null;
public anywheresoftware.b4j.object.JavaObject _system = null;
public anywheresoftware.b4a.objects.collections.Map _memoryslots = null;
public int _lastmemorysize = 0;
public int _memory_increase_threshold = 0;
public String _packagename = "";
public b4j.example.pywrapper _io = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _addconverters() throws Exception{
b4j.example.pywrapper _converters = null;
 //BA.debugLineNum = 62;BA.debugLine="Private Sub AddConverters";
 //BA.debugLineNum = 63;BA.debugLine="IO = mBridge.ImportModule(\"io\")";
_io = _mbridge._importmodule /*b4j.example.pywrapper*/ ("io");
 //BA.debugLineNum = 64;BA.debugLine="Dim converters As PyWrapper = mBridge.Bridge.GetF";
_converters = _mbridge._bridge /*b4j.example.pywrapper*/ ._getfield /*b4j.example.pywrapper*/ ("comm")._getfield /*b4j.example.pywrapper*/ ("serializator")._getfield /*b4j.example.pywrapper*/ ("converters");
 //BA.debugLineNum = 65;BA.debugLine="converters.Set(IO.GetField(\"BytesIO\"), mBridge.La";
_converters._set /*String*/ ((Object)(_io._getfield /*b4j.example.pywrapper*/ ("BytesIO")),(Object)(_mbridge._lambda /*b4j.example.pywrapper*/ ("x: x.getvalue()")));
 //BA.debugLineNum = 66;BA.debugLine="mBridge.RunNoArgsCode(\"from b4x_bridge.bridge imp";
_mbridge._runnoargscode /*String*/ ("from b4x_bridge.bridge import bridge_instance");
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public b4j.example.pybridge._internalpytaskasyncresult  _checkforerrorsandreturn(b4j.example.pybridge._pytask _task,b4j.example.pybridge._pyobject _pyobject) throws Exception{
 //BA.debugLineNum = 238;BA.debugLine="Private Sub CheckForErrorsAndReturn (TASK As PyTas";
 //BA.debugLineNum = 240;BA.debugLine="Return CreateInternalPyTaskAsyncResult(PyObject,";
if (true) return _createinternalpytaskasyncresult(_pyobject,_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (0)),_task.TaskType /*int*/ ==_task_type_error);
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return null;
}
public void  _checkkeysneedtobecleaned() throws Exception{
ResumableSub_CheckKeysNeedToBeCleaned rsub = new ResumableSub_CheckKeysNeedToBeCleaned(this);
rsub.resume(ba, null);
}
public static class ResumableSub_CheckKeysNeedToBeCleaned extends BA.ResumableSub {
public ResumableSub_CheckKeysNeedToBeCleaned(b4j.example.pyutils parent) {
this.parent = parent;
}
b4j.example.pyutils parent;
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
 //BA.debugLineNum = 254;BA.debugLine="CleanerClass.RunMethod(\"getKeys\", Null) 'clear an";
parent._cleanerclass.RunMethod("getKeys",(Object[])(parent.__c.Null));
 //BA.debugLineNum = 255;BA.debugLine="CleanerIndex = CleanerIndex + 1";
parent._cleanerindex = (int) (parent._cleanerindex+1);
 //BA.debugLineNum = 256;BA.debugLine="Dim MyIndex As Int = CleanerIndex";
_myindex = parent._cleanerindex;
 //BA.debugLineNum = 257;BA.debugLine="CleanerClass.SetField(\"currentCleanerIndex\", MyIn";
parent._cleanerclass.SetField("currentCleanerIndex",(Object)(_myindex));
 //BA.debugLineNum = 258;BA.debugLine="Do While MyIndex = CleanerIndex";
if (true) break;

case 1:
//do while
this.state = 4;
while (_myindex==parent._cleanerindex) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 1;
 //BA.debugLineNum = 259;BA.debugLine="KeysImpl";
parent._keysimpl();
 //BA.debugLineNum = 260;BA.debugLine="Sleep(200)";
parent.__c.Sleep(ba,this,(int) (200));
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
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public TASK_TYPE_RUN = 1, TASK_TYPE_GET = 2, TASK";
_task_type_run = (int) (1);
_task_type_get = (int) (2);
_task_type_run_async = (int) (3);
_task_type_clean = (int) (4);
_task_type_error = (int) (5);
_task_type_event = (int) (6);
_task_type_ping = (int) (7);
_task_type_flush = (int) (8);
 //BA.debugLineNum = 6;BA.debugLine="Public PythonBridgeCodeVersion As String = \"1.00\"";
_pythonbridgecodeversion = "1.00";
 //BA.debugLineNum = 7;BA.debugLine="Public PyOutPrefix = \"(pyout) \", PyErrPrefix = \"(";
_pyoutprefix = "(pyout) ";
_pyerrprefix = "(pyerr) ";
_b4jprefix = "(b4j) ";
 //BA.debugLineNum = 8;BA.debugLine="Public EvalGlobals As PyWrapper";
_evalglobals = new b4j.example.pywrapper();
 //BA.debugLineNum = 9;BA.debugLine="Public ImportLib As PyWrapper";
_importlib = new b4j.example.pywrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private mBridge As PyBridge";
_mbridge = new b4j.example.pybridge();
 //BA.debugLineNum = 12;BA.debugLine="Public TaskIdCounter, PyObjectCounter As Int";
_taskidcounter = 0;
_pyobjectcounter = 0;
 //BA.debugLineNum = 13;BA.debugLine="Public CleanerClass As JavaObject";
_cleanerclass = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 14;BA.debugLine="Public CleanerIndex As Int";
_cleanerindex = 0;
 //BA.debugLineNum = 15;BA.debugLine="Public Comm As PyComm";
_comm = new b4j.example.pycomm();
 //BA.debugLineNum = 16;BA.debugLine="Public mOptions As PyOptions";
_moptions = new b4j.example.pybridge._pyoptions();
 //BA.debugLineNum = 17;BA.debugLine="Public cleaner As JavaObject";
_cleaner = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 18;BA.debugLine="Public RegisteredMembers As B4XSet";
_registeredmembers = new b4j.example.b4xset();
 //BA.debugLineNum = 19;BA.debugLine="Public Epsilon As Double = 0.0000001";
_epsilon = 0.0000001;
 //BA.debugLineNum = 20;BA.debugLine="Private KeysThatNeedToBeRegistered As List";
_keysthatneedtoberegistered = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 21;BA.debugLine="Private ObjectsThatNeedToBeRegistered As List";
_objectsthatneedtoberegistered = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 22;BA.debugLine="Private System As JavaObject";
_system = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 23;BA.debugLine="Private MemorySlots As Map";
_memoryslots = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 24;BA.debugLine="Private LastMemorySize As Int";
_lastmemorysize = 0;
 //BA.debugLineNum = 25;BA.debugLine="Public MEMORY_INCREASE_THRESHOLD As Int = 500000";
_memory_increase_threshold = (int) (500000);
 //BA.debugLineNum = 26;BA.debugLine="Public PackageName As String";
_packagename = "";
 //BA.debugLineNum = 27;BA.debugLine="Public IO As PyWrapper";
_io = new b4j.example.pywrapper();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _connected(b4j.example.pybridge._pyobject _vimportlib,b4j.example.pybridge._pyoptions _options) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Public Sub Connected (vImportLib As PyObject, opti";
 //BA.debugLineNum = 49;BA.debugLine="mOptions = options";
_moptions = _options;
 //BA.debugLineNum = 50;BA.debugLine="PyObjectCounter = 100";
_pyobjectcounter = (int) (100);
 //BA.debugLineNum = 51;BA.debugLine="ImportLib.Initialize(mBridge, vImportLib)";
_importlib._initialize /*String*/ (ba,_mbridge,_vimportlib);
 //BA.debugLineNum = 52;BA.debugLine="EvalGlobals = mBridge.Builtins.Run(\"dict\")";
_evalglobals = _mbridge._builtins /*b4j.example.pywrapper*/ ._run /*b4j.example.pywrapper*/ ("dict");
 //BA.debugLineNum = 53;BA.debugLine="RegisteredMembers.Initialize";
_registeredmembers._initialize /*String*/ (ba);
 //BA.debugLineNum = 54;BA.debugLine="KeysThatNeedToBeRegistered.Clear";
_keysthatneedtoberegistered.Clear();
 //BA.debugLineNum = 55;BA.debugLine="ObjectsThatNeedToBeRegistered.Clear";
_objectsthatneedtoberegistered.Clear();
 //BA.debugLineNum = 56;BA.debugLine="MemorySlots.Clear";
_memoryslots.Clear();
 //BA.debugLineNum = 57;BA.debugLine="LastMemorySize = 0";
_lastmemorysize = (int) (0);
 //BA.debugLineNum = 58;BA.debugLine="CheckKeysNeedToBeCleaned";
_checkkeysneedtobecleaned();
 //BA.debugLineNum = 59;BA.debugLine="AddConverters";
_addconverters();
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public b4j.example.pywrapper  _convertlambdaifmatch(Object _o) throws Exception{
 //BA.debugLineNum = 299;BA.debugLine="Public Sub ConvertLambdaIfMatch (o As Object) As P";
 //BA.debugLineNum = 300;BA.debugLine="If o Is PyWrapper Then Return o";
if (_o instanceof b4j.example.pywrapper) { 
if (true) return (b4j.example.pywrapper)(_o);};
 //BA.debugLineNum = 301;BA.debugLine="Return mBridge.RunStatement(o)";
if (true) return _mbridge._runstatement /*b4j.example.pywrapper*/ (BA.ObjectToString(_o));
 //BA.debugLineNum = 302;BA.debugLine="End Sub";
return null;
}
public Object  _converttointifmatch(Object _o) throws Exception{
double _d = 0;
int _i = 0;
 //BA.debugLineNum = 290;BA.debugLine="Public Sub ConvertToIntIfMatch (o As Object) As Ob";
 //BA.debugLineNum = 291;BA.debugLine="If o Is Float Or o Is Double Then";
if (_o instanceof Float || _o instanceof Double) { 
 //BA.debugLineNum = 292;BA.debugLine="Dim d As Double = o";
_d = (double)(BA.ObjectToNumber(_o));
 //BA.debugLineNum = 293;BA.debugLine="Dim i As Int = d";
_i = (int) (_d);
 //BA.debugLineNum = 294;BA.debugLine="If Abs(d - i) < Epsilon Then Return i";
if (__c.Abs(_d-_i)<_epsilon) { 
if (true) return (Object)(_i);};
 };
 //BA.debugLineNum = 296;BA.debugLine="Return o";
if (true) return _o;
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return null;
}
public Object[]  _createextra(b4j.example.pybridge._pyobject _target,String _method,b4j.example.pybridge._internalpymethodargs _args,b4j.example.pybridge._pyobject _res) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub CreateExtra(Target As PyObject, Method";
 //BA.debugLineNum = 83;BA.debugLine="If mOptions.TrackLineNumbers Then";
if (_moptions.TrackLineNumbers /*boolean*/ ) { 
 //BA.debugLineNum = 84;BA.debugLine="Return Array(Target.Key, Method, Args.Args, Args";
if (true) return new Object[]{(Object)(_target.Key /*int*/ ),(Object)(_method),(Object)(_args.Args /*anywheresoftware.b4a.objects.collections.List*/ .getObject()),(Object)(_args.KWArgs /*anywheresoftware.b4a.objects.collections.Map*/ .getObject()),(Object)(_res.Key /*int*/ ),(Object)(""),(Object)(""),(Object)(0)};
 }else {
 //BA.debugLineNum = 86;BA.debugLine="Return Array(Target.Key, Method, Args.Args, Args";
if (true) return new Object[]{(Object)(_target.Key /*int*/ ),(Object)(_method),(Object)(_args.Args /*anywheresoftware.b4a.objects.collections.List*/ .getObject()),(Object)(_args.KWArgs /*anywheresoftware.b4a.objects.collections.Map*/ .getObject()),(Object)(_res.Key /*int*/ )};
 };
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return null;
}
public b4j.example.pybridge._internalpytaskasyncresult  _createinternalpytaskasyncresult(b4j.example.pybridge._pyobject _pyobject,Object _value,boolean _error) throws Exception{
b4j.example.pybridge._internalpytaskasyncresult _t1 = null;
 //BA.debugLineNum = 336;BA.debugLine="Private Sub CreateInternalPyTaskAsyncResult (PyObj";
 //BA.debugLineNum = 337;BA.debugLine="Dim t1 As InternalPyTaskAsyncResult";
_t1 = new b4j.example.pybridge._internalpytaskasyncresult();
 //BA.debugLineNum = 338;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 339;BA.debugLine="t1.PyObject = PyObject";
_t1.PyObject /*b4j.example.pybridge._pyobject*/  = _pyobject;
 //BA.debugLineNum = 340;BA.debugLine="t1.Value = Value";
_t1.Value /*Object*/  = _value;
 //BA.debugLineNum = 341;BA.debugLine="t1.Error = Error";
_t1.Error /*boolean*/  = _error;
 //BA.debugLineNum = 342;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return null;
}
public b4j.example.pybridge._pyobject  _createpyobject(int _key) throws Exception{
b4j.example.pybridge._pyobject _t1 = null;
 //BA.debugLineNum = 225;BA.debugLine="Public Sub CreatePyObject (Key As Int) As PyObject";
 //BA.debugLineNum = 226;BA.debugLine="Dim t1 As PyObject";
_t1 = new b4j.example.pybridge._pyobject();
 //BA.debugLineNum = 227;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 228;BA.debugLine="If Key = 0 Then";
if (_key==0) { 
 //BA.debugLineNum = 229;BA.debugLine="PyObjectCounter = PyObjectCounter + 1";
_pyobjectcounter = (int) (_pyobjectcounter+1);
 //BA.debugLineNum = 230;BA.debugLine="Key = PyObjectCounter";
_key = _pyobjectcounter;
 };
 //BA.debugLineNum = 232;BA.debugLine="t1.Key = Key";
_t1.Key /*int*/  = _key;
 //BA.debugLineNum = 233;BA.debugLine="RegisterForCleaning(t1)";
_registerforcleaning(_t1);
 //BA.debugLineNum = 234;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return null;
}
public b4j.example.pybridge._pytask  _createpytask(int _taskid,int _tasktype,anywheresoftware.b4a.objects.collections.List _extra) throws Exception{
b4j.example.pybridge._pytask _t1 = null;
 //BA.debugLineNum = 212;BA.debugLine="Public Sub CreatePyTask (TaskId As Int, TaskType A";
 //BA.debugLineNum = 213;BA.debugLine="Dim t1 As PyTask";
_t1 = new b4j.example.pybridge._pytask();
 //BA.debugLineNum = 214;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 215;BA.debugLine="If TaskId = 0 Then";
if (_taskid==0) { 
 //BA.debugLineNum = 216;BA.debugLine="TaskIdCounter = TaskIdCounter + 1";
_taskidcounter = (int) (_taskidcounter+1);
 //BA.debugLineNum = 217;BA.debugLine="TaskId = TaskIdCounter";
_taskid = _taskidcounter;
 };
 //BA.debugLineNum = 219;BA.debugLine="t1.TaskId = TaskId";
_t1.TaskId /*int*/  = _taskid;
 //BA.debugLineNum = 220;BA.debugLine="t1.TaskType = TaskType";
_t1.TaskType /*int*/  = _tasktype;
 //BA.debugLineNum = 221;BA.debugLine="t1.Extra = Extra";
_t1.Extra /*anywheresoftware.b4a.objects.collections.List*/  = _extra;
 //BA.debugLineNum = 222;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return null;
}
public String  _detectos() throws Exception{
String _os = "";
 //BA.debugLineNum = 345;BA.debugLine="Public Sub DetectOS As String";
 //BA.debugLineNum = 346;BA.debugLine="Dim os As String = GetSystemProperty(\"os.name\", \"";
_os = __c.GetSystemProperty("os.name","").toLowerCase();
 //BA.debugLineNum = 347;BA.debugLine="If os.Contains(\"win\") Then";
if (_os.contains("win")) { 
 //BA.debugLineNum = 348;BA.debugLine="Return \"windows\"";
if (true) return "windows";
 }else if(_os.contains("mac")) { 
 //BA.debugLineNum = 350;BA.debugLine="Return \"mac\"";
if (true) return "mac";
 }else {
 //BA.debugLineNum = 352;BA.debugLine="Return \"linux\"";
if (true) return "linux";
 };
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public String  _disconnected() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Public Sub Disconnected";
 //BA.debugLineNum = 70;BA.debugLine="CleanerIndex = CleanerIndex + 1";
_cleanerindex = (int) (_cleanerindex+1);
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _fetch(b4j.example.pybridge._pyobject _pyobject) throws Exception{
ResumableSub_Fetch rsub = new ResumableSub_Fetch(this,_pyobject);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Fetch extends BA.ResumableSub {
public ResumableSub_Fetch(b4j.example.pyutils parent,b4j.example.pybridge._pyobject _pyobject) {
this.parent = parent;
this._pyobject = _pyobject;
}
b4j.example.pyutils parent;
b4j.example.pybridge._pyobject _pyobject;
b4j.example.pybridge._pytask _task = null;

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
 //BA.debugLineNum = 176;BA.debugLine="Dim TASK As PyTask = CreatePyTask(0, TASK_TYPE_GE";
_task = parent._createpytask((int) (0),parent._task_type_get,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_pyobject.Key /*int*/ )}));
 //BA.debugLineNum = 177;BA.debugLine="Comm.SendTaskAndWait(TASK)";
parent._comm._sendtaskandwait /*String*/ (_task);
 //BA.debugLineNum = 178;BA.debugLine="Wait For (TASK) AsyncTask_Received (TASK As PyTas";
parent.__c.WaitFor("asynctask_received", ba, this, (Object)(_task));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_task = (b4j.example.pybridge._pytask) result[0];
;
 //BA.debugLineNum = 179;BA.debugLine="Return CheckForErrorsAndReturn(TASK, PyObject)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._checkforerrorsandreturn(_task,_pyobject)));return;};
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _asynctask_received(b4j.example.pybridge._pytask _task) throws Exception{
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _flush() throws Exception{
ResumableSub_Flush rsub = new ResumableSub_Flush(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_Flush extends BA.ResumableSub {
public ResumableSub_Flush(b4j.example.pyutils parent) {
this.parent = parent;
}
b4j.example.pyutils parent;
b4j.example.pybridge._pytask _task = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 163;BA.debugLine="Dim task As PyTask = CreatePyTask(0, TASK_TYPE_FL";
_task = parent._createpytask((int) (0),parent._task_type_flush,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{}));
 //BA.debugLineNum = 164;BA.debugLine="Comm.SendTaskAndWait(task)";
parent._comm._sendtaskandwait /*String*/ (_task);
 //BA.debugLineNum = 165;BA.debugLine="Wait For (task) AsyncTask_Received (task As PyTas";
parent.__c.WaitFor("asynctask_received", ba, this, (Object)(_task));
this.state = 7;
return;
case 7:
//C
this.state = 1;
_task = (b4j.example.pybridge._pytask) result[0];
;
 //BA.debugLineNum = 166;BA.debugLine="If task.TaskType = TASK_TYPE_ERROR Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_task.TaskType /*int*/ ==parent._task_type_error) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 167;BA.debugLine="mBridge.PyLastException = task.Extra.Get(0)";
parent._mbridge._pylastexception /*String*/  = BA.ObjectToString(_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (0)));
 //BA.debugLineNum = 168;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 170;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _forcegc() throws Exception{
 //BA.debugLineNum = 276;BA.debugLine="Public Sub ForceGC";
 //BA.debugLineNum = 277;BA.debugLine="LastMemorySize = MemorySlots.Size";
_lastmemorysize = _memoryslots.getSize();
 //BA.debugLineNum = 278;BA.debugLine="PyLog(B4JPrefix, mOptions.B4JColor, \"ForceGC: mem";
_pylog(_b4jprefix,_moptions.B4JColor /*int*/ ,(Object)("ForceGC: memory slots - "+BA.NumberToString(_lastmemorysize)));
 //BA.debugLineNum = 279;BA.debugLine="System.RunMethod(\"gc\", Null)";
_system.RunMethod("gc",(Object[])(__c.Null));
 //BA.debugLineNum = 280;BA.debugLine="KeysImpl";
_keysimpl();
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,b4j.example.pybridge _bridge,b4j.example.pycomm _vcomm) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 31;BA.debugLine="Public Sub Initialize (bridge As PyBridge, vComm A";
 //BA.debugLineNum = 32;BA.debugLine="mBridge = bridge";
_mbridge = _bridge;
 //BA.debugLineNum = 33;BA.debugLine="CleanerClass = CleanerClass.InitializeStatic(GetT";
_cleanerclass = _cleanerclass.InitializeStatic(__c.GetType(this)+"$CleanRunnable");
 //BA.debugLineNum = 34;BA.debugLine="cleaner = cleaner.InitializeStatic(\"java.lang.ref";
_cleaner = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_cleaner.InitializeStatic("java.lang.ref.Cleaner").RunMethod("create",(Object[])(__c.Null))));
 //BA.debugLineNum = 35;BA.debugLine="System.InitializeStatic(\"System\")";
_system.InitializeStatic("System");
 //BA.debugLineNum = 36;BA.debugLine="PackageName = GetType(Me)";
_packagename = __c.GetType(this);
 //BA.debugLineNum = 37;BA.debugLine="PackageName = PackageName.SubString2(0, PackageNa";
_packagename = _packagename.substring((int) (0),(int) (_packagename.length()-".pyutils".length()));
 //BA.debugLineNum = 38;BA.debugLine="KeysThatNeedToBeRegistered.Initialize";
_keysthatneedtoberegistered.Initialize();
 //BA.debugLineNum = 39;BA.debugLine="ObjectsThatNeedToBeRegistered.Initialize";
_objectsthatneedtoberegistered.Initialize();
 //BA.debugLineNum = 40;BA.debugLine="MemorySlots.Initialize";
_memoryslots.Initialize();
 //BA.debugLineNum = 41;BA.debugLine="If GetSystemProperty(\"b4j.ide\", False) = True The";
if ((__c.GetSystemProperty("b4j.ide",BA.ObjectToString(__c.False))).equals(BA.ObjectToString(__c.True))) { 
 //BA.debugLineNum = 42;BA.debugLine="PyErrPrefix = \"\"";
_pyerrprefix = "";
 //BA.debugLineNum = 43;BA.debugLine="PyOutPrefix = \"\"";
_pyoutprefix = "";
 //BA.debugLineNum = 44;BA.debugLine="B4JPrefix = \"\"";
_b4jprefix = "";
 };
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public boolean  _isarray(Object _obj) throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Private Sub IsArray(obj As Object) As Boolean";
 //BA.debugLineNum = 137;BA.debugLine="Return obj <> Null And \"[Ljava.lang.Object;\" = Ge";
if (true) return _obj!= null && ("[Ljava.lang.Object;").equals(__c.GetType(_obj));
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return false;
}
public String  _keysimpl() throws Exception{
anywheresoftware.b4a.objects.collections.List _keys = null;
int _key = 0;
 //BA.debugLineNum = 264;BA.debugLine="Private Sub KeysImpl";
 //BA.debugLineNum = 265;BA.debugLine="Dim keys As List = CleanerClass.RunMethod(\"getKey";
_keys = new anywheresoftware.b4a.objects.collections.List();
_keys = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_cleanerclass.RunMethod("getKeys",(Object[])(__c.Null))));
 //BA.debugLineNum = 266;BA.debugLine="If keys.Size > 0 Then";
if (_keys.getSize()>0) { 
 //BA.debugLineNum = 267;BA.debugLine="Comm.SendTask(CreatePyTask(0, TASK_TYPE_CLEAN, k";
_comm._sendtask /*String*/ (_createpytask((int) (0),_task_type_clean,_keys));
 //BA.debugLineNum = 268;BA.debugLine="For Each key As Int In keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _keys;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_key = (int)(BA.ObjectToNumber(group4.Get(index4)));
 //BA.debugLineNum = 269;BA.debugLine="MemorySlots.Remove(key)";
_memoryslots.Remove((Object)(_key));
 }
};
 //BA.debugLineNum = 271;BA.debugLine="LastMemorySize = MemorySlots.Size";
_lastmemorysize = _memoryslots.getSize();
 };
 //BA.debugLineNum = 273;BA.debugLine="RegisterKeys";
_registerkeys();
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public String  _pylog(String _prefix,int _clr,Object _o) throws Exception{
String _s = "";
String[] _lines = null;
String _line = "";
 //BA.debugLineNum = 183;BA.debugLine="Public Sub PyLog(Prefix As String, Clr As Int, O A";
 //BA.debugLineNum = 185;BA.debugLine="If o Is PyWrapper Then";
if (_o instanceof b4j.example.pywrapper) { 
 //BA.debugLineNum = 186;BA.debugLine="mBridge.PrintJoin(Array(o), Clr = mOptions.PyErr";
_mbridge._printjoin /*String*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_o}),_clr==_moptions.PyErrColor /*int*/ );
 }else {
 //BA.debugLineNum = 188;BA.debugLine="Dim s As String = o";
_s = BA.ObjectToString(_o);
 //BA.debugLineNum = 189;BA.debugLine="If s.Length > 3900 Then";
if (_s.length()>3900) { 
 //BA.debugLineNum = 190;BA.debugLine="s = s.SubString2(0, 3900) & CRLF & \"(message tr";
_s = _s.substring((int) (0),(int) (3900))+__c.CRLF+"(message truncated)";
 };
 //BA.debugLineNum = 192;BA.debugLine="s = s.Trim.Replace(Chr(13), \"\")";
_s = _s.trim().replace(BA.ObjectToString(__c.Chr((int) (13))),"");
 //BA.debugLineNum = 193;BA.debugLine="Dim lines() As String = Regex.Split(\"\\n+\", s)";
_lines = __c.Regex.Split("\\n+",_s);
 //BA.debugLineNum = 194;BA.debugLine="For Each line As String In lines";
{
final String[] group10 = _lines;
final int groupLen10 = group10.length
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_line = group10[index10];
 //BA.debugLineNum = 195;BA.debugLine="line = line.Trim";
_line = _line.trim();
 //BA.debugLineNum = 196;BA.debugLine="If line.StartsWith(\"~de:\") Then";
if (_line.startsWith("~de:")) { 
 //BA.debugLineNum = 197;BA.debugLine="mBridge.ErrorHandler.UntangleError(line)";
_mbridge._errorhandler /*b4j.example.pyerrorhandler*/ ._untangleerror /*String*/ (_line);
 }else if(_clr!=0) { 
 //BA.debugLineNum = 199;BA.debugLine="If Comm.State = Comm.STATE_DISCONNECTED And li";
if (_comm._state /*int*/ ==_comm._state_disconnected /*int*/  && _line.startsWith("Unhandled exception in task")) { 
 //BA.debugLineNum = 200;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 202;BA.debugLine="LogColor(Prefix & line, Clr)";
__c.LogImpl("977332499",_prefix+_line,_clr);
 }else {
 //BA.debugLineNum = 204;BA.debugLine="Log(Prefix & line)";
__c.LogImpl("977332501",_prefix+_line,0);
 };
 }
};
 };
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public String  _registerforcleaning(b4j.example.pybridge._pyobject _py) throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Private Sub RegisterForCleaning (Py As PyObject)";
 //BA.debugLineNum = 245;BA.debugLine="ObjectsThatNeedToBeRegistered.Add(Py)";
_objectsthatneedtoberegistered.Add((Object)(_py));
 //BA.debugLineNum = 246;BA.debugLine="KeysThatNeedToBeRegistered.Add(Py.Key)";
_keysthatneedtoberegistered.Add((Object)(_py.Key /*int*/ ));
 //BA.debugLineNum = 247;BA.debugLine="MemorySlots.Put(Py.Key, Null)";
_memoryslots.Put((Object)(_py.Key /*int*/ ),__c.Null);
 //BA.debugLineNum = 248;BA.debugLine="If MemorySlots.Size - LastMemorySize > MEMORY_INC";
if (_memoryslots.getSize()-_lastmemorysize>_memory_increase_threshold) { 
 //BA.debugLineNum = 249;BA.debugLine="ForceGC";
_forcegc();
 };
 //BA.debugLineNum = 251;BA.debugLine="End Sub";
return "";
}
public String  _registerkeys() throws Exception{
 //BA.debugLineNum = 283;BA.debugLine="Private Sub RegisterKeys";
 //BA.debugLineNum = 284;BA.debugLine="CleanerClass.RunMethod(\"registerMultipleKeys\", Ar";
_cleanerclass.RunMethod("registerMultipleKeys",new Object[]{(Object)(_objectsthatneedtoberegistered.getObject()),(Object)(_keysthatneedtoberegistered.getObject()),(Object)(_cleaner.getObject())});
 //BA.debugLineNum = 285;BA.debugLine="ObjectsThatNeedToBeRegistered.Clear";
_objectsthatneedtoberegistered.Clear();
 //BA.debugLineNum = 286;BA.debugLine="KeysThatNeedToBeRegistered.Clear";
_keysthatneedtoberegistered.Clear();
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public b4j.example.pybridge._pyobject  _run(b4j.example.pybridge._pyobject _target,String _method,b4j.example.pybridge._internalpymethodargs _args) throws Exception{
b4j.example.pybridge._pyobject _res = null;
b4j.example.pybridge._pytask _task = null;
 //BA.debugLineNum = 74;BA.debugLine="Public Sub Run (Target As PyObject, Method As Stri";
 //BA.debugLineNum = 75;BA.debugLine="Dim res As PyObject = CreatePyObject(0)";
_res = _createpyobject((int) (0));
 //BA.debugLineNum = 76;BA.debugLine="Dim TASK As PyTask = CreatePyTask(0, TASK_TYPE_RU";
_task = _createpytask((int) (0),_task_type_run,anywheresoftware.b4a.keywords.Common.ArrayToList(_createextra(_target,_method,_args,_res)));
 //BA.debugLineNum = 77;BA.debugLine="mBridge.ErrorHandler.AddDataToTask(TASK)";
_mbridge._errorhandler /*b4j.example.pyerrorhandler*/ ._adddatatotask /*String*/ (_task);
 //BA.debugLineNum = 78;BA.debugLine="Comm.SendTask(TASK)";
_comm._sendtask /*String*/ (_task);
 //BA.debugLineNum = 79;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _runasync(b4j.example.pybridge._pyobject _target,String _method,b4j.example.pybridge._internalpymethodargs _args) throws Exception{
ResumableSub_RunAsync rsub = new ResumableSub_RunAsync(this,_target,_method,_args);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_RunAsync extends BA.ResumableSub {
public ResumableSub_RunAsync(b4j.example.pyutils parent,b4j.example.pybridge._pyobject _target,String _method,b4j.example.pybridge._internalpymethodargs _args) {
this.parent = parent;
this._target = _target;
this._method = _method;
this._args = _args;
}
b4j.example.pyutils parent;
b4j.example.pybridge._pyobject _target;
String _method;
b4j.example.pybridge._internalpymethodargs _args;
b4j.example.pybridge._pyobject _res = null;
b4j.example.pybridge._pytask _task = null;

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
 //BA.debugLineNum = 92;BA.debugLine="Dim res As PyObject = CreatePyObject(0)";
_res = parent._createpyobject((int) (0));
 //BA.debugLineNum = 93;BA.debugLine="Dim TASK As PyTask = CreatePyTask(0, TASK_TYPE_RU";
_task = parent._createpytask((int) (0),parent._task_type_run_async,anywheresoftware.b4a.keywords.Common.ArrayToList(parent._createextra(_target,_method,_args,_res)));
 //BA.debugLineNum = 94;BA.debugLine="mBridge.ErrorHandler.AddDataToTask(TASK)";
parent._mbridge._errorhandler /*b4j.example.pyerrorhandler*/ ._adddatatotask /*String*/ (_task);
 //BA.debugLineNum = 95;BA.debugLine="Comm.SendTaskAndWait(TASK)";
parent._comm._sendtaskandwait /*String*/ (_task);
 //BA.debugLineNum = 96;BA.debugLine="Wait For (TASK) AsyncTask_Received (TASK As PyTas";
parent.__c.WaitFor("asynctask_received", ba, this, (Object)(_task));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_task = (b4j.example.pybridge._pytask) result[0];
;
 //BA.debugLineNum = 97;BA.debugLine="Return CheckForErrorsAndReturn(TASK, res)";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent._checkforerrorsandreturn(_task,_res)));return;};
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _unwrapbeforeserialization(anywheresoftware.b4a.objects.collections.List _extra) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Public Sub UnwrapBeforeSerialization (Extra As Lis";
 //BA.debugLineNum = 101;BA.debugLine="UnwrapList(Extra.Get(2))";
_unwraplist((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_extra.Get((int) (2)))));
 //BA.debugLineNum = 102;BA.debugLine="UnwrapMap(Extra.Get(3))";
_unwrapmap((anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_extra.Get((int) (3)))));
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _unwraplist(anywheresoftware.b4a.objects.collections.List _lst) throws Exception{
int _i = 0;
Object _v = null;
 //BA.debugLineNum = 105;BA.debugLine="Private Sub UnwrapList (Lst As List)";
 //BA.debugLineNum = 106;BA.debugLine="If NotInitialized(Lst) Then Return";
if (__c.NotInitialized((Object)(_lst))) { 
if (true) return "";};
 //BA.debugLineNum = 107;BA.debugLine="For i = 0 To Lst.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_lst.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 108;BA.debugLine="Dim v As Object = Lst.Get(i)";
_v = _lst.Get(_i);
 //BA.debugLineNum = 109;BA.debugLine="If v Is PyWrapper Then";
if (_v instanceof b4j.example.pywrapper) { 
 //BA.debugLineNum = 110;BA.debugLine="Lst.Set(i, v.As(PyWrapper).InternalKey)";
_lst.Set(_i,(Object)(((b4j.example.pywrapper)(_v))._internalkey /*b4j.example.pybridge._pyobject*/ ));
 }else if(_v instanceof java.util.List) { 
 //BA.debugLineNum = 112;BA.debugLine="UnwrapList(v)";
_unwraplist((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_v)));
 }else if(_v instanceof java.util.Map) { 
 //BA.debugLineNum = 114;BA.debugLine="UnwrapMap(v)";
_unwrapmap((anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_v)));
 }else if(_isarray(_v)) { 
 //BA.debugLineNum = 116;BA.debugLine="UnwrapTuple(v)";
_unwraptuple((Object[])(_v));
 };
 }
};
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public String  _unwrapmap(anywheresoftware.b4a.objects.collections.Map _map) throws Exception{
anywheresoftware.b4a.objects.collections.List _keysthatneedtobeunwrapped = null;
Object _key = null;
Object _value = null;
 //BA.debugLineNum = 140;BA.debugLine="Private Sub UnwrapMap (Map As Map)";
 //BA.debugLineNum = 141;BA.debugLine="If NotInitialized(Map) Then Return";
if (__c.NotInitialized((Object)(_map))) { 
if (true) return "";};
 //BA.debugLineNum = 142;BA.debugLine="Dim KeysThatNeedToBeUnwrapped As List";
_keysthatneedtobeunwrapped = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 143;BA.debugLine="KeysThatNeedToBeUnwrapped.Initialize";
_keysthatneedtobeunwrapped.Initialize();
 //BA.debugLineNum = 144;BA.debugLine="For Each key As Object In Map.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _map.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_key = group4.Get(index4);
 //BA.debugLineNum = 145;BA.debugLine="Dim value As Object = Map.Get(key)";
_value = _map.Get(_key);
 //BA.debugLineNum = 146;BA.debugLine="If value Is PyWrapper Then";
if (_value instanceof b4j.example.pywrapper) { 
 //BA.debugLineNum = 147;BA.debugLine="KeysThatNeedToBeUnwrapped.Add(key)";
_keysthatneedtobeunwrapped.Add(_key);
 }else if(_value instanceof java.util.List) { 
 //BA.debugLineNum = 149;BA.debugLine="UnwrapList(value)";
_unwraplist((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_value)));
 }else if(_value instanceof java.util.Map) { 
 //BA.debugLineNum = 151;BA.debugLine="UnwrapMap(value)";
_unwrapmap((anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_value)));
 }else if(_isarray(_value)) { 
 //BA.debugLineNum = 153;BA.debugLine="UnwrapTuple(value)";
_unwraptuple((Object[])(_value));
 };
 }
};
 //BA.debugLineNum = 156;BA.debugLine="For Each key As Object In KeysThatNeedToBeUnwrapp";
{
final anywheresoftware.b4a.BA.IterableList group16 = _keysthatneedtobeunwrapped;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_key = group16.Get(index16);
 //BA.debugLineNum = 157;BA.debugLine="Dim value As Object = Map.Get(key)";
_value = _map.Get(_key);
 //BA.debugLineNum = 158;BA.debugLine="Map.Put(key, value.As(PyWrapper).InternalKey)";
_map.Put(_key,(Object)(((b4j.example.pywrapper)(_value))._internalkey /*b4j.example.pybridge._pyobject*/ ));
 }
};
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public String  _unwraptuple(Object[] _obj) throws Exception{
int _i = 0;
Object _o = null;
 //BA.debugLineNum = 121;BA.debugLine="Private Sub UnwrapTuple (Obj() As Object)";
 //BA.debugLineNum = 122;BA.debugLine="For i = 0 To Obj.Length - 1";
{
final int step1 = 1;
final int limit1 = (int) (_obj.length-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 123;BA.debugLine="Dim o As Object = Obj(i)";
_o = _obj[_i];
 //BA.debugLineNum = 124;BA.debugLine="If o Is PyWrapper Then";
if (_o instanceof b4j.example.pywrapper) { 
 //BA.debugLineNum = 125;BA.debugLine="Obj(i) = o.As(PyWrapper).InternalKey";
_obj[_i] = (Object)(((b4j.example.pywrapper)(_o))._internalkey /*b4j.example.pybridge._pyobject*/ );
 }else if(_o instanceof java.util.List) { 
 //BA.debugLineNum = 127;BA.debugLine="UnwrapList(o)";
_unwraplist((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_o)));
 }else if(_o instanceof java.util.Map) { 
 //BA.debugLineNum = 129;BA.debugLine="UnwrapMap(o)";
_unwrapmap((anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_o)));
 }else if(_isarray(_o)) { 
 //BA.debugLineNum = 131;BA.debugLine="UnwrapTuple(o)";
_unwraptuple((Object[])(_o));
 };
 }
};
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
public static class CleanRunnable implements Runnable {
	private final int key;
	private final int cleanerIndex;
	private final static java.util.List<Object> listOfKeys = java.util.Collections.synchronizedList(new java.util.ArrayList<Object>());
	public static volatile int currentCleanerIndex;
	public CleanRunnable(int key, int cleanerIndex) {
		this.key = key;
		this.cleanerIndex = cleanerIndex;
	}
	public void run() {
		if (this.cleanerIndex == currentCleanerIndex)
			listOfKeys.add(key);
	}
	public static java.util.List<Object> getKeys() {
		synchronized(listOfKeys) {
			java.util.ArrayList<Object> res = new java.util.ArrayList<Object>(listOfKeys);
			listOfKeys.clear();
			return res;
		}
	}
	public static void registerMultipleKeys(java.util.List<Object> objects, java.util.List<Integer> keys, java.lang.ref.Cleaner cleaner) {
		for (int i = 0;i < objects.size();i++) {
			Object object = objects.get(i);
			int key = keys.get(i);
			cleaner.register(object, new CleanRunnable(key, currentCleanerIndex));
		}
	}
}

}
