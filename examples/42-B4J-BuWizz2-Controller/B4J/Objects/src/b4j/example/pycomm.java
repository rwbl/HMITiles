package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class pycomm extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.pycomm", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.pycomm.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper _srvr = null;
public int _state_disconnected = 0;
public int _state_connected = 0;
public int _state_waiting_for_connection = 0;
public int _state = 0;
public int _port = 0;
public b4j.example.pybridge _mbridge = null;
public anywheresoftware.b4a.randomaccessfile.AsyncStreams _astream = null;
public anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
public anywheresoftware.b4a.objects.collections.Map _waitingtasks = null;
public anywheresoftware.b4j.object.JavaObject _jme = null;
public anywheresoftware.b4a.objects.collections.List _bufferedtasks = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _astream_error() throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Private Sub AStream_Error";
 //BA.debugLineNum = 112;BA.debugLine="AStream_Terminated";
_astream_terminated();
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public String  _astream_newdata(byte[] _buffer) throws Exception{
Object[] _o = null;
b4j.example.pybridge._pytask _task = null;
 //BA.debugLineNum = 60;BA.debugLine="Private Sub AStream_NewData (Buffer() As Byte)";
 //BA.debugLineNum = 61;BA.debugLine="Dim o() As Object = ser.ConvertBytesToObject(Buff";
_o = (Object[])(_ser.ConvertBytesToObject(_buffer));
 //BA.debugLineNum = 62;BA.debugLine="Dim Task As PyTask = mBridge.Utils.CreatePyTask(o";
_task = _mbridge._utils /*b4j.example.pyutils*/ ._createpytask /*b4j.example.pybridge._pytask*/ ((int)(BA.ObjectToNumber(_o[(int) (0)])),(int)(BA.ObjectToNumber(_o[(int) (1)])),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_o[(int) (2)])));
 //BA.debugLineNum = 63;BA.debugLine="If WaitingTasks.ContainsKey(Task.TaskId) Then";
if (_waitingtasks.ContainsKey((Object)(_task.TaskId /*int*/ ))) { 
 //BA.debugLineNum = 64;BA.debugLine="jME.RunMethod(\"raiseEventWithSenderFilter\", Arra";
_jme.RunMethod("raiseEventWithSenderFilter",new Object[]{(Object)(_mbridge._utils /*b4j.example.pyutils*/ ),(Object)("asynctask_received"),_waitingtasks.Remove((Object)(_task.TaskId /*int*/ )),(Object)(new Object[]{(Object)(_task)})});
 }else {
 //BA.debugLineNum = 66;BA.debugLine="CallSub2(mBridge, \"Task_Received\", Task)";
__c.CallSubNew2(ba,(Object)(_mbridge),"Task_Received",(Object)(_task));
 };
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _astream_terminated() throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Private Sub AStream_Terminated";
 //BA.debugLineNum = 116;BA.debugLine="ChangeState(STATE_DISCONNECTED)";
_changestate(_state_disconnected);
 //BA.debugLineNum = 117;BA.debugLine="BufferedTasks.Clear";
_bufferedtasks.Clear();
 //BA.debugLineNum = 118;BA.debugLine="srvr.Close";
_srvr.Close();
 //BA.debugLineNum = 119;BA.debugLine="If astream.IsInitialized Then astream.Close";
if (_astream.IsInitialized()) { 
_astream.Close();};
 //BA.debugLineNum = 120;BA.debugLine="mBridge.Utils.PyLog(mBridge.Utils.B4JPrefix, mBri";
_mbridge._utils /*b4j.example.pyutils*/ ._pylog /*String*/ (_mbridge._utils /*b4j.example.pyutils*/ ._b4jprefix /*String*/ ,_mbridge._utils /*b4j.example.pyutils*/ ._moptions /*b4j.example.pybridge._pyoptions*/ .B4JColor /*int*/ ,(Object)("disconnected"));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _changestate(int _newstate) throws Exception{
int _oldstate = 0;
 //BA.debugLineNum = 123;BA.debugLine="Private Sub ChangeState (NewState As Int)";
 //BA.debugLineNum = 124;BA.debugLine="If NewState = State Then Return";
if (_newstate==_state) { 
if (true) return "";};
 //BA.debugLineNum = 125;BA.debugLine="Dim OldState As Int = State";
_oldstate = _state;
 //BA.debugLineNum = 126;BA.debugLine="State = NewState";
_state = _newstate;
 //BA.debugLineNum = 127;BA.debugLine="CallSub3(mBridge, \"state_changed\", OldState, Stat";
__c.CallSubNew3(ba,(Object)(_mbridge),"state_changed",(Object)(_oldstate),(Object)(_state));
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private srvr As ServerSocket";
_srvr = new anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Public const STATE_DISCONNECTED = 1, STATE_CONNEC";
_state_disconnected = (int) (1);
_state_connected = (int) (2);
_state_waiting_for_connection = (int) (3);
 //BA.debugLineNum = 5;BA.debugLine="Public State As Int";
_state = 0;
 //BA.debugLineNum = 6;BA.debugLine="Public Port As Int";
_port = 0;
 //BA.debugLineNum = 7;BA.debugLine="Private mBridge As PyBridge";
_mbridge = new b4j.example.pybridge();
 //BA.debugLineNum = 8;BA.debugLine="Private astream As AsyncStreams";
_astream = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
 //BA.debugLineNum = 9;BA.debugLine="Private ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
 //BA.debugLineNum = 10;BA.debugLine="Private WaitingTasks As Map";
_waitingtasks = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 11;BA.debugLine="Private jME As JavaObject";
_jme = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 12;BA.debugLine="Public BufferedTasks As List";
_bufferedtasks = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public String  _closeserver() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub CloseServer";
 //BA.debugLineNum = 51;BA.debugLine="If State = STATE_CONNECTED Or State = STATE_WAITI";
if (_state==_state_connected || _state==_state_waiting_for_connection) { 
 //BA.debugLineNum = 52;BA.debugLine="If astream.IsInitialized Then";
if (_astream.IsInitialized()) { 
 //BA.debugLineNum = 53;BA.debugLine="astream.Close";
_astream.Close();
 };
 //BA.debugLineNum = 55;BA.debugLine="srvr.Close";
_srvr.Close();
 //BA.debugLineNum = 56;BA.debugLine="ChangeState(STATE_DISCONNECTED)";
_changestate(_state_disconnected);
 };
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _flush() throws Exception{
anywheresoftware.b4a.objects.collections.List _flattasks = null;
b4j.example.pybridge._pytask _task = null;
boolean _res = false;
 //BA.debugLineNum = 84;BA.debugLine="Public Sub Flush";
 //BA.debugLineNum = 85;BA.debugLine="If BufferedTasks.Size > 0 Then";
if (_bufferedtasks.getSize()>0) { 
 //BA.debugLineNum = 86;BA.debugLine="Dim FlatTasks As List";
_flattasks = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 87;BA.debugLine="FlatTasks.Initialize";
_flattasks.Initialize();
 //BA.debugLineNum = 88;BA.debugLine="For Each Task As PyTask In BufferedTasks";
{
final anywheresoftware.b4a.BA.IterableList group4 = _bufferedtasks;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_task = (b4j.example.pybridge._pytask)(group4.Get(index4));
 //BA.debugLineNum = 89;BA.debugLine="If Task.TaskType = mBridge.Utils.TASK_TYPE_RUN";
if (_task.TaskType /*int*/ ==_mbridge._utils /*b4j.example.pyutils*/ ._task_type_run /*int*/  || _task.TaskType /*int*/ ==_mbridge._utils /*b4j.example.pyutils*/ ._task_type_run_async /*int*/ ) { 
 //BA.debugLineNum = 90;BA.debugLine="mBridge.Utils.UnwrapBeforeSerialization(Task.E";
_mbridge._utils /*b4j.example.pyutils*/ ._unwrapbeforeserialization /*String*/ (_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ );
 };
 //BA.debugLineNum = 92;BA.debugLine="FlatTasks.AddAll(Array(Task.TaskId, Task.TaskTy";
_flattasks.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_task.TaskId /*int*/ ),(Object)(_task.TaskType /*int*/ ),(Object)(_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .getObject())}));
 }
};
 //BA.debugLineNum = 94;BA.debugLine="Dim res As Boolean = astream.Write(ser.ConvertOb";
_res = _astream.Write(_ser.ConvertObjectToBytes((Object)(_flattasks.getObject())));
 //BA.debugLineNum = 95;BA.debugLine="If astream.OutputQueueSize > 100 Then";
if (_astream.getOutputQueueSize()>100) { 
 //BA.debugLineNum = 96;BA.debugLine="mBridge.Utils.PyLog(mBridge.Utils.B4JPrefix, mB";
_mbridge._utils /*b4j.example.pyutils*/ ._pylog /*String*/ (_mbridge._utils /*b4j.example.pyutils*/ ._b4jprefix /*String*/ ,_mbridge._utils /*b4j.example.pyutils*/ ._moptions /*b4j.example.pybridge._pyoptions*/ .B4JColor /*int*/ ,(Object)("Output queue size: "+BA.NumberToString(_astream.getOutputQueueSize())));
 };
 //BA.debugLineNum = 98;BA.debugLine="If res = False And astream.OutputQueueSize > 0 T";
if (_res==__c.False && _astream.getOutputQueueSize()>0) { 
 //BA.debugLineNum = 99;BA.debugLine="LogError(\"Queue is full!\")";
__c.LogError("Queue is full!");
 };
 //BA.debugLineNum = 101;BA.debugLine="BufferedTasks.Clear";
_bufferedtasks.Clear();
 };
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,b4j.example.pybridge _bridge,int _localport) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.objects.collections.Map _correctclassesnames = null;
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize (Bridge As PyBridge, LocalPo";
 //BA.debugLineNum = 16;BA.debugLine="InitializeWithLoopback(srvr, \"srvr\", LocalPort)";
_initializewithloopback(_srvr,"srvr",_localport);
 //BA.debugLineNum = 17;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 18;BA.debugLine="Dim correctClassesNames As Map = jo.InitializeSta";
_correctclassesnames = new anywheresoftware.b4a.objects.collections.Map();
_correctclassesnames = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_jo.InitializeStatic("anywheresoftware.b4a.randomaccessfile.RandomAccessFile").GetField("correctedClasses")));
 //BA.debugLineNum = 19;BA.debugLine="correctClassesNames.Put(\"_pyobject\", GetType(Brid";
_correctclassesnames.Put((Object)("_pyobject"),(Object)(__c.GetType((Object)(_bridge))+"$_pyobject"));
 //BA.debugLineNum = 20;BA.debugLine="jME = Me";
_jme = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this));
 //BA.debugLineNum = 21;BA.debugLine="WaitingTasks.Initialize";
_waitingtasks.Initialize();
 //BA.debugLineNum = 22;BA.debugLine="Port = srvr.As(JavaObject).GetFieldJO(\"ssocket\").";
_port = (int)(BA.ObjectToNumber(((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_srvr))).GetFieldJO("ssocket").RunMethod("getLocalPort",(Object[])(__c.Null))));
 //BA.debugLineNum = 23;BA.debugLine="mBridge = Bridge";
_mbridge = _bridge;
 //BA.debugLineNum = 24;BA.debugLine="mBridge.Utils.PyLog(mBridge.Utils.B4JPrefix, mBri";
_mbridge._utils /*b4j.example.pyutils*/ ._pylog /*String*/ (_mbridge._utils /*b4j.example.pyutils*/ ._b4jprefix /*String*/ ,_mbridge._utils /*b4j.example.pyutils*/ ._moptions /*b4j.example.pybridge._pyoptions*/ .B4JColor /*int*/ ,(Object)("Server is listening on port: "+BA.NumberToString(_port)));
 //BA.debugLineNum = 25;BA.debugLine="srvr.Listen";
_srvr.Listen();
 //BA.debugLineNum = 26;BA.debugLine="BufferedTasks.Initialize";
_bufferedtasks.Initialize();
 //BA.debugLineNum = 27;BA.debugLine="State = STATE_WAITING_FOR_CONNECTION";
_state = _state_waiting_for_connection;
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _initializewithloopback(anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper _server,String _eventname,int _vport) throws Exception{
anywheresoftware.b4j.object.JavaObject _ia = null;
anywheresoftware.b4j.object.JavaObject _s = null;
anywheresoftware.b4j.object.JavaObject _socket = null;
 //BA.debugLineNum = 30;BA.debugLine="Private Sub InitializeWithLoopback(Server As Serve";
 //BA.debugLineNum = 31;BA.debugLine="Server.Initialize(-1, EventName)";
_server.Initialize(ba,(int) (-1),_eventname);
 //BA.debugLineNum = 32;BA.debugLine="Dim ia As JavaObject";
_ia = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 33;BA.debugLine="ia = ia.InitializeStatic(\"java.net.InetAddress\").";
_ia = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_ia.InitializeStatic("java.net.InetAddress").RunMethod("getLoopbackAddress",(Object[])(__c.Null))));
 //BA.debugLineNum = 34;BA.debugLine="Dim s As JavaObject = Server";
_s = new anywheresoftware.b4j.object.JavaObject();
_s = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_server));
 //BA.debugLineNum = 35;BA.debugLine="Dim socket As JavaObject";
_socket = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 36;BA.debugLine="socket.InitializeNewInstance(\"java.net.ServerSock";
_socket.InitializeNewInstance("java.net.ServerSocket",new Object[]{(Object)(_vport),(Object)(50),(Object)(_ia.getObject())});
 //BA.debugLineNum = 37;BA.debugLine="s.SetField(\"ssocket\", socket)";
_s.SetField("ssocket",(Object)(_socket.getObject()));
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public String  _movetasktolast(b4j.example.pybridge._pytask _task) throws Exception{
int _i = 0;
 //BA.debugLineNum = 75;BA.debugLine="Public Sub MoveTaskToLast(Task As PyTask)";
 //BA.debugLineNum = 76;BA.debugLine="If BufferedTasks.Get(BufferedTasks.Size - 1) = Ta";
if ((_bufferedtasks.Get((int) (_bufferedtasks.getSize()-1))).equals((Object)(_task))) { 
 //BA.debugLineNum = 77;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 79;BA.debugLine="Dim i As Int = BufferedTasks.IndexOf(Task)";
_i = _bufferedtasks.IndexOf((Object)(_task));
 //BA.debugLineNum = 80;BA.debugLine="BufferedTasks.RemoveAt(i)";
_bufferedtasks.RemoveAt(_i);
 //BA.debugLineNum = 81;BA.debugLine="BufferedTasks.Add(Task)";
_bufferedtasks.Add((Object)(_task));
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public String  _sendtask(b4j.example.pybridge._pytask _task) throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Public Sub SendTask (Task As PyTask)";
 //BA.debugLineNum = 71;BA.debugLine="If BufferedTasks.Size = 0 Then CallSubDelayed(Me,";
if (_bufferedtasks.getSize()==0) { 
__c.CallSubDelayed(ba,this,"Flush");};
 //BA.debugLineNum = 72;BA.debugLine="BufferedTasks.Add(Task)";
_bufferedtasks.Add((Object)(_task));
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _sendtaskandwait(b4j.example.pybridge._pytask _task) throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Public Sub SendTaskAndWait (Task As PyTask)";
 //BA.debugLineNum = 106;BA.debugLine="WaitingTasks.Put(Task.TaskId, Task)";
_waitingtasks.Put((Object)(_task.TaskId /*int*/ ),(Object)(_task));
 //BA.debugLineNum = 107;BA.debugLine="SendTask(Task)";
_sendtask(_task);
 //BA.debugLineNum = 108;BA.debugLine="Flush";
_flush();
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public void  _srvr_newconnection(boolean _successful,anywheresoftware.b4a.objects.SocketWrapper _newsocket) throws Exception{
ResumableSub_Srvr_NewConnection rsub = new ResumableSub_Srvr_NewConnection(this,_successful,_newsocket);
rsub.resume(ba, null);
}
public static class ResumableSub_Srvr_NewConnection extends BA.ResumableSub {
public ResumableSub_Srvr_NewConnection(b4j.example.pycomm parent,boolean _successful,anywheresoftware.b4a.objects.SocketWrapper _newsocket) {
this.parent = parent;
this._successful = _successful;
this._newsocket = _newsocket;
}
b4j.example.pycomm parent;
boolean _successful;
anywheresoftware.b4a.objects.SocketWrapper _newsocket;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 41;BA.debugLine="If Successful Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_successful) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 42;BA.debugLine="mBridge.Utils.PyLog(mBridge.Utils.B4JPrefix, mBr";
parent._mbridge._utils /*b4j.example.pyutils*/ ._pylog /*String*/ (parent._mbridge._utils /*b4j.example.pyutils*/ ._b4jprefix /*String*/ ,parent._mbridge._utils /*b4j.example.pyutils*/ ._moptions /*b4j.example.pybridge._pyoptions*/ .B4JColor /*int*/ ,(Object)("connected"));
 //BA.debugLineNum = 44;BA.debugLine="astream.InitializePrefix(NewSocket.InputStream,";
parent._astream.InitializePrefix(ba,_newsocket.getInputStream(),parent.__c.True,_newsocket.getOutputStream(),"astream");
 //BA.debugLineNum = 45;BA.debugLine="Sleep(100)";
parent.__c.Sleep(ba,this,(int) (100));
this.state = 5;
return;
case 5:
//C
this.state = 4;
;
 //BA.debugLineNum = 46;BA.debugLine="ChangeState(STATE_CONNECTED)";
parent._changestate(parent._state_connected);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "FLUSH"))
	return _flush();
return BA.SubDelegator.SubNotFound;
}
public void raiseEventWithSenderFilter(B4AClass target, String eventName, Object senderFilter, Object[] params) {
	target.getBA().raiseEventFromUI(senderFilter, eventName, params);
}
}
