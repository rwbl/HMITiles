package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class pyerrorhandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.pyerrorhandler", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.pyerrorhandler.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.b4xset _ignoredclasses = null;
public anywheresoftware.b4j.object.JavaObject _threadclass = null;
public b4j.example.pyutils _mutils = null;
public anywheresoftware.b4j.object.JavaObject _baclass = null;
public anywheresoftware.b4a.objects.collections.Map _filescache = null;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.convert _convert = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitileutils _hmitileutils = null;
public String  _adddatatotask(b4j.example.pybridge._pytask _task) throws Exception{
Object[] _elements = null;
int _e = 0;
anywheresoftware.b4j.object.JavaObject _element = null;
String _origcls = "";
int _i = 0;
String _cls = "";
String _method = "";
 //BA.debugLineNum = 18;BA.debugLine="Public Sub AddDataToTask (Task As PyTask)";
 //BA.debugLineNum = 19;BA.debugLine="If mUtils.mOptions.TrackLineNumbers = False Then";
if (_mutils._moptions /*b4j.example.pybridge._pyoptions*/ .TrackLineNumbers /*boolean*/ ==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 20;BA.debugLine="Dim elements() As Object = ThreadClass.RunMethod(";
_elements = (Object[])(_threadclass.RunMethod("getStackTrace",(Object[])(__c.Null)));
 //BA.debugLineNum = 21;BA.debugLine="For e = 8 To elements.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_elements.length-1);
_e = (int) (8) ;
for (;_e <= limit3 ;_e = _e + step3 ) {
 //BA.debugLineNum = 22;BA.debugLine="Dim element As JavaObject = elements(e)";
_element = new anywheresoftware.b4j.object.JavaObject();
_element = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_elements[_e]));
 //BA.debugLineNum = 23;BA.debugLine="Dim origcls As String = element.RunMethod(\"getCl";
_origcls = BA.ObjectToString(_element.RunMethod("getClassName",(Object[])(__c.Null)));
 //BA.debugLineNum = 24;BA.debugLine="If origcls.StartsWith(mUtils.PackageName) Then";
if (_origcls.startsWith(_mutils._packagename /*String*/ )) { 
 //BA.debugLineNum = 25;BA.debugLine="origcls = origcls.SubString(mUtils.PackageName.";
_origcls = _origcls.substring((int) (_mutils._packagename /*String*/ .length()+1));
 //BA.debugLineNum = 26;BA.debugLine="Dim i As Int = origcls.IndexOf(\"$\")";
_i = _origcls.indexOf("$");
 //BA.debugLineNum = 27;BA.debugLine="Dim cls As String = origcls";
_cls = _origcls;
 //BA.debugLineNum = 28;BA.debugLine="If i > -1 Then cls = cls.SubString2(0, i)";
if (_i>-1) { 
_cls = _cls.substring((int) (0),_i);};
 //BA.debugLineNum = 29;BA.debugLine="If IgnoredClasses.Contains(cls) Then Continue";
if (_ignoredclasses._contains /*boolean*/ ((Object)(_cls))) { 
if (true) continue;};
 //BA.debugLineNum = 30;BA.debugLine="Task.Extra.Set(5, cls)";
_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .Set((int) (5),(Object)(_cls));
 //BA.debugLineNum = 31;BA.debugLine="Dim method As String";
_method = "";
 //BA.debugLineNum = 32;BA.debugLine="If i > -1 Then";
if (_i>-1) { 
 //BA.debugLineNum = 33;BA.debugLine="method = origcls.SubString(i + 1)";
_method = _origcls.substring((int) (_i+1));
 //BA.debugLineNum = 34;BA.debugLine="If method.StartsWith(\"ResumableSub\") Then meth";
if (_method.startsWith("ResumableSub")) { 
_method = _method.substring("ResumableSub_".length());};
 }else {
 //BA.debugLineNum = 36;BA.debugLine="method = element.RunMethod(\"getMethodName\", Nu";
_method = BA.ObjectToString(_element.RunMethod("getMethodName",(Object[])(__c.Null)));
 };
 //BA.debugLineNum = 38;BA.debugLine="Task.Extra.Set(6, method)";
_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .Set((int) (6),(Object)(_method));
 //BA.debugLineNum = 39;BA.debugLine="Task.Extra.Set(7, element.RunMethod(\"getLineNum";
_task.Extra /*anywheresoftware.b4a.objects.collections.List*/ .Set((int) (7),_element.RunMethod("getLineNumber",(Object[])(__c.Null)));
 //BA.debugLineNum = 40;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public IgnoredClasses As B4XSet";
_ignoredclasses = new b4j.example.b4xset();
 //BA.debugLineNum = 4;BA.debugLine="Private ThreadClass As JavaObject";
_threadclass = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 5;BA.debugLine="Private mUtils As PyUtils";
_mutils = new b4j.example.pyutils();
 //BA.debugLineNum = 6;BA.debugLine="Private BAClass As JavaObject";
_baclass = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 7;BA.debugLine="Private FilesCache As Map";
_filescache = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,b4j.example.pyutils _utils) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 10;BA.debugLine="Public Sub Initialize (Utils As PyUtils)";
 //BA.debugLineNum = 11;BA.debugLine="BAClass.InitializeStatic(\"anywheresoftware.b4a.BA";
_baclass.InitializeStatic("anywheresoftware.b4a.BA");
 //BA.debugLineNum = 12;BA.debugLine="ThreadClass = ThreadClass.InitializeStatic(\"java.";
_threadclass = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_threadclass.InitializeStatic("java.lang.Thread").RunMethod("currentThread",(Object[])(__c.Null))));
 //BA.debugLineNum = 13;BA.debugLine="mUtils = Utils";
_mutils = _utils;
 //BA.debugLineNum = 14;BA.debugLine="IgnoredClasses = B4XCollections.CreateSet2(Array(";
_ignoredclasses = _b4xcollections._createset2 /*b4j.example.b4xset*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("pyerrorhandler"),(Object)("pyutils"),(Object)("pywrapper"),(Object)("pybridge"),(Object)("pycomm")}));
 //BA.debugLineNum = 15;BA.debugLine="FilesCache.Initialize";
_filescache.Initialize();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public String  _untangleerror(String _s) throws Exception{
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _m = null;
String _module = "";
int _linenumber = 0;
String _folder = "";
String _ffile = "";
anywheresoftware.b4a.objects.collections.List _lines = null;
int _i = 0;
String _line = "";
 //BA.debugLineNum = 45;BA.debugLine="Public Sub UntangleError (s As String)";
 //BA.debugLineNum = 46;BA.debugLine="Dim m As Matcher = Regex.Matcher(\"~de:([^,]+),(\\d";
_m = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_m = __c.Regex.Matcher("~de:([^,]+),(\\d+)",_s);
 //BA.debugLineNum = 47;BA.debugLine="m.Find";
_m.Find();
 //BA.debugLineNum = 48;BA.debugLine="Dim Module As String = m.Group(1)";
_module = _m.Group((int) (1));
 //BA.debugLineNum = 49;BA.debugLine="Dim LineNumber As Int = m.Group(2) - 1";
_linenumber = (int) ((double)(Double.parseDouble(_m.Group((int) (2))))-1);
 //BA.debugLineNum = 50;BA.debugLine="If FilesCache.ContainsKey(Module) = False Then";
if (_filescache.ContainsKey((Object)(_module))==__c.False) { 
 //BA.debugLineNum = 51;BA.debugLine="Dim folder As String = File.Combine(File.DirApp,";
_folder = __c.File.Combine(__c.File.getDirApp(),"src\\"+_mutils._packagename /*String*/ .replace(".","\\"));
 //BA.debugLineNum = 52;BA.debugLine="Dim ffile As String = Module & \".java\"";
_ffile = _module+".java";
 //BA.debugLineNum = 53;BA.debugLine="If File.Exists(folder, ffile) Then";
if (__c.File.Exists(_folder,_ffile)) { 
 //BA.debugLineNum = 54;BA.debugLine="FilesCache.Put(Module, File.ReadList(folder, ff";
_filescache.Put((Object)(_module),(Object)(__c.File.ReadList(_folder,_ffile).getObject()));
 }else {
 //BA.debugLineNum = 56;BA.debugLine="FilesCache.Put(Module, Null)";
_filescache.Put((Object)(_module),__c.Null);
 };
 };
 //BA.debugLineNum = 59;BA.debugLine="Dim lines As List = FilesCache.Get(Module)";
_lines = new anywheresoftware.b4a.objects.collections.List();
_lines = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_filescache.Get((Object)(_module))));
 //BA.debugLineNum = 60;BA.debugLine="If NotInitialized(lines) Then Return";
if (__c.NotInitialized((Object)(_lines))) { 
if (true) return "";};
 //BA.debugLineNum = 61;BA.debugLine="For i = LineNumber To Max(0, LineNumber - 10) Ste";
{
final int step16 = -1;
final int limit16 = (int) (__c.Max(0,_linenumber-10));
_i = _linenumber ;
for (;_i >= limit16 ;_i = _i + step16 ) {
 //BA.debugLineNum = 62;BA.debugLine="Dim line As String = lines.Get(i)";
_line = BA.ObjectToString(_lines.Get(_i));
 //BA.debugLineNum = 63;BA.debugLine="If line.StartsWith(\" //BA.debugLineNum\") Then";
if (_line.startsWith(" //BA.debugLineNum")) { 
 //BA.debugLineNum = 64;BA.debugLine="m = Regex.Matcher(\"BA\\.debugLineNum\\s*=\\s*(\\d+)";
_m = __c.Regex.Matcher("BA\\.debugLineNum\\s*=\\s*(\\d+);",_line);
 //BA.debugLineNum = 65;BA.debugLine="If m.Find Then";
if (_m.Find()) { 
 //BA.debugLineNum = 66;BA.debugLine="BAClass.RunMethod(\"Log\", Array(\"~de:\" & Module";
_baclass.RunMethod("Log",new Object[]{(Object)("~de:"+_module+","+_m.Group((int) (1)))});
 //BA.debugLineNum = 67;BA.debugLine="Exit";
if (true) break;
 };
 };
 }
};
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
