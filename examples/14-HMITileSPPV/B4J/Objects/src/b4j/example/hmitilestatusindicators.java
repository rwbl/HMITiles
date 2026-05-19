package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class hmitilestatusindicators extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.hmitilestatusindicators", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.hmitilestatusindicators.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _basepane = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _baselabel = null;
public Object _tag = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _labeltitle = null;
public byte _status_indicators_size = (byte)0;
public anywheresoftware.b4a.objects.B4XViewWrapper[] _labelstatusindicators = null;
public byte _rows = (byte)0;
public byte _cols = (byte)0;
public byte _status_true = (byte)0;
public byte _status_false = (byte)0;
public byte _status_disabled = (byte)0;
public String _mtitle = "";
public int _mcolortrue = 0;
public int _mcolorfalse = 0;
public int _mcolordisabled = 0;
public int _mtextcolortrue = 0;
public int _mtextcolorfalse = 0;
public int _mtextcolordisabled = 0;
public b4j.example.dateutils _dateutils = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public b4j.example.xuiviewsutils _xuiviewsutils = null;
public b4j.example.hmitilesymbols _hmitilesymbols = null;
public b4j.example.hmitileutils _hmitileutils = null;
public static class _indicatordata{
public boolean IsInitialized;
public int Index;
public int Status;
public String Text;
public String Description;
public void Initialize() {
IsInitialized = true;
Index = 0;
Status = 0;
Text = "";
Description = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _afterloadlayout(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub AfterLoadLayout(Props As Map)	'ignore";
 //BA.debugLineNum = 83;BA.debugLine="BasePane.LoadLayout(\"hmitilestatusindicators\")";
_basepane.LoadLayout("hmitilestatusindicators",ba);
 //BA.debugLineNum = 86;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 87;BA.debugLine="LabelTitle.Text	= mTitle";
_labeltitle.setText(_mtitle);
 //BA.debugLineNum = 88;BA.debugLine="mColorTrue		= xui.PaintOrColorToColor(Props.Get(\"";
_mcolortrue = _xui.PaintOrColorToColor(_props.Get((Object)("ColorTrue")));
 //BA.debugLineNum = 89;BA.debugLine="mColorFalse		= xui.PaintOrColorToColor(Props.Get(";
_mcolorfalse = _xui.PaintOrColorToColor(_props.Get((Object)("ColorFalse")));
 //BA.debugLineNum = 92;BA.debugLine="CreateStatusIndicators";
_createstatusindicators();
 //BA.debugLineNum = 95;BA.debugLine="Base_Resize(BasePane.Width, BasePane.Height)";
_base_resize(_basepane.getWidth(),_basepane.getHeight());
 //BA.debugLineNum = 98;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 303;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 304;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (_labeltitle);
 //BA.debugLineNum = 306;BA.debugLine="BasePane.Color = HMITileUtils.COLOR_TILE_NORMAL_B";
_basepane.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 309;BA.debugLine="BasePane.SetColorAndBorder(BasePane.Color, 0, 0,";
_basepane.SetColorAndBorder(_basepane.getColor(),0,(int) (0),_hmitileutils._border_radius /*double*/ );
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
double _neww = 0;
double _newh = 0;
double _it = 0;
int _iw = 0;
int _ih = 0;
int _i = 0;
int _row = 0;
int _col = 0;
int _l = 0;
int _t = 0;
int _w = 0;
int _h = 0;
 //BA.debugLineNum = 101;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 102;BA.debugLine="If Not(LabelTitle.IsInitialized) Then Return";
if (__c.Not(_labeltitle.IsInitialized())) { 
if (true) return "";};
 //BA.debugLineNum = 105;BA.debugLine="If Width < HMITileUtils.TILE_DEFAULT_SIZE Or Heig";
if (_width<_hmitileutils._tile_default_size /*int*/  || _height<_hmitileutils._tile_default_size /*int*/ ) { 
 //BA.debugLineNum = 106;BA.debugLine="Dim NewW As Double = Max(Width, HMITileUtils.TIL";
_neww = __c.Max(_width,_hmitileutils._tile_default_size /*int*/ );
 //BA.debugLineNum = 107;BA.debugLine="Dim NewH As Double = Max(Height, HMITileUtils.TI";
_newh = __c.Max(_height,_hmitileutils._tile_default_size /*int*/ );
 //BA.debugLineNum = 108;BA.debugLine="BasePane.SetLayoutAnimated(0, BasePane.Left, Bas";
_basepane.SetLayoutAnimated((int) (0),_basepane.getLeft(),_basepane.getTop(),_neww,_newh);
 //BA.debugLineNum = 109;BA.debugLine="Return ' Exit and let the sub re-fire with the n";
if (true) return "";
 };
 //BA.debugLineNum = 112;BA.debugLine="LabelTitle.SetLayoutAnimated (0, 0, 0, Width, Hei";
_labeltitle.SetLayoutAnimated((int) (0),0,0,_width,_height*0.25);
 //BA.debugLineNum = 114;BA.debugLine="Dim it As Double = LabelTitle.Top + LabelTitle.He";
_it = _labeltitle.getTop()+_labeltitle.getHeight();
 //BA.debugLineNum = 116;BA.debugLine="Dim iw As Int = Floor(Width / 3)";
_iw = (int) (__c.Floor(_width/(double)3));
 //BA.debugLineNum = 117;BA.debugLine="Dim ih As Int = Floor((Height - it) / 3)";
_ih = (int) (__c.Floor((_height-_it)/(double)3));
 //BA.debugLineNum = 119;BA.debugLine="For i = 0 To STATUS_INDICATORS_SIZE - 1";
{
final int step12 = 1;
final int limit12 = (int) (_status_indicators_size-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
 //BA.debugLineNum = 120;BA.debugLine="Dim row As Int = i / 3";
_row = (int) (_i/(double)3);
 //BA.debugLineNum = 121;BA.debugLine="Dim col As Int = i Mod 3";
_col = (int) (_i%3);
 //BA.debugLineNum = 123;BA.debugLine="Dim l As Int = col * iw";
_l = (int) (_col*_iw);
 //BA.debugLineNum = 124;BA.debugLine="Dim t As Int = row * ih + it";
_t = (int) (_row*_ih+_it);
 //BA.debugLineNum = 125;BA.debugLine="Dim w As Int = iw";
_w = _iw;
 //BA.debugLineNum = 126;BA.debugLine="Dim h As Int = ih";
_h = _ih;
 //BA.debugLineNum = 130;BA.debugLine="If col = 2 Then w = Width - l";
if (_col==2) { 
_w = (int) (_width-_l);};
 //BA.debugLineNum = 131;BA.debugLine="If row = 2 Then h = Height - t";
if (_row==2) { 
_h = (int) (_height-_t);};
 //BA.debugLineNum = 133;BA.debugLine="LabelStatusIndicators(i).SetLayoutAnimated(0, l,";
_labelstatusindicators[_i].SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 }
};
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private xui 					As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 30;BA.debugLine="Public BasePane 					As B4XView";
_basepane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private BaseLabel 					As B4XView					'ignore";
_baselabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Public Tag 						As Object";
_tag = new Object();
 //BA.debugLineNum = 35;BA.debugLine="Private mEventName 				As String					'ignore";
_meventname = "";
 //BA.debugLineNum = 36;BA.debugLine="Private mCallBack 				As Object					'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 39;BA.debugLine="Private LabelTitle 				As B4XView";
_labeltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private STATUS_INDICATORS_SIZE As Byte  = 9";
_status_indicators_size = (byte) (9);
 //BA.debugLineNum = 41;BA.debugLine="Private LabelStatusIndicators(STATUS_INDICATORS_S";
_labelstatusindicators = new anywheresoftware.b4a.objects.B4XViewWrapper[(int) (_status_indicators_size)];
{
int d0 = _labelstatusindicators.length;
for (int i0 = 0;i0 < d0;i0++) {
_labelstatusindicators[i0] = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
}
;
 //BA.debugLineNum = 44;BA.debugLine="Public ROWS 					As Byte = 3";
_rows = (byte) (3);
 //BA.debugLineNum = 45;BA.debugLine="Public COLS 					As Byte = 3";
_cols = (byte) (3);
 //BA.debugLineNum = 48;BA.debugLine="Type IndicatorData (Index As Int, Status As Int,";
;
 //BA.debugLineNum = 51;BA.debugLine="Public STATUS_TRUE 				As Byte = 0";
_status_true = (byte) (0);
 //BA.debugLineNum = 52;BA.debugLine="Public STATUS_FALSE 			As Byte = 1";
_status_false = (byte) (1);
 //BA.debugLineNum = 53;BA.debugLine="Public STATUS_DISABLED 			As Byte = 2";
_status_disabled = (byte) (2);
 //BA.debugLineNum = 56;BA.debugLine="Private mTitle					As String";
_mtitle = "";
 //BA.debugLineNum = 57;BA.debugLine="Private mColorTrue				As Int";
_mcolortrue = 0;
 //BA.debugLineNum = 58;BA.debugLine="Private mColorFalse				As Int";
_mcolorfalse = 0;
 //BA.debugLineNum = 59;BA.debugLine="Private mColorDisabled			As Int = HMITileUtils.CO";
_mcolordisabled = _hmitileutils._color_tile_disabled_background /*int*/ ;
 //BA.debugLineNum = 60;BA.debugLine="Private mTextColorTrue			As Int = HMITileUtils.CO";
_mtextcolortrue = _hmitileutils._color_text_indicator_true /*int*/ ;
 //BA.debugLineNum = 61;BA.debugLine="Private mTextColorFalse			As Int = HMITileUtils.C";
_mtextcolorfalse = _hmitileutils._color_text_indicator_false /*int*/ ;
 //BA.debugLineNum = 62;BA.debugLine="Private mTextColorDisabled		As Int = HMITileUtils";
_mtextcolordisabled = _hmitileutils._color_text_disabled /*int*/ ;
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public String  _createstatusindicators() throws Exception{
int _i = 0;
anywheresoftware.b4j.objects.LabelWrapper _lbl = null;
b4j.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 138;BA.debugLine="Private Sub CreateStatusIndicators";
 //BA.debugLineNum = 139;BA.debugLine="For i = 0 To STATUS_INDICATORS_SIZE - 1";
{
final int step1 = 1;
final int limit1 = (int) (_status_indicators_size-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 140;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 141;BA.debugLine="lbl.Initialize(\"LabelStatusIndicator\")";
_lbl.Initialize(ba,"LabelStatusIndicator");
 //BA.debugLineNum = 142;BA.debugLine="BasePane.AddView(lbl, 0dip, 0dip, 30dip, 30dip)";
_basepane.AddView((javafx.scene.Node)(_lbl.getObject()),__c.DipToCurrent((int) (0)),__c.DipToCurrent((int) (0)),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 143;BA.debugLine="LabelStatusIndicators(i) = lbl";
_labelstatusindicators[_i] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 144;BA.debugLine="Dim data As IndicatorData";
_data = new b4j.example.hmitilestatusindicators._indicatordata();
 //BA.debugLineNum = 145;BA.debugLine="data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 146;BA.debugLine="data.Index = i";
_data.Index /*int*/  = _i;
 //BA.debugLineNum = 147;BA.debugLine="data.Status = STATUS_DISABLED";
_data.Status /*int*/  = (int) (_status_disabled);
 //BA.debugLineNum = 148;BA.debugLine="data.Text = \"\"";
_data.Text /*String*/  = "";
 //BA.debugLineNum = 149;BA.debugLine="data.Description = \"\"";
_data.Description /*String*/  = "";
 //BA.debugLineNum = 150;BA.debugLine="LabelStatusIndicators(i).Tag = data";
_labelstatusindicators[_i].setTag((Object)(_data));
 //BA.debugLineNum = 151;BA.debugLine="LabelStatusIndicators(i).Text = data.Text";
_labelstatusindicators[_i].setText(_data.Text /*String*/ );
 //BA.debugLineNum = 152;BA.debugLine="LabelStatusIndicators(i).SetTextAlignment(\"CENTE";
_labelstatusindicators[_i].SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 153;BA.debugLine="LabelStatusIndicators(i).SetColorAndBorder(mColo";
_labelstatusindicators[_i].SetColorAndBorder(_mcolordisabled,__c.DipToCurrent((int) (1)),_hmitileutils._color_tile_normal_background /*int*/ ,0);
 //BA.debugLineNum = 155;BA.debugLine="LabelStatusIndicators(i).TextColor = mTextColorD";
_labelstatusindicators[_i].setTextColor(_mtextcolordisabled);
 }
};
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4j.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 73;BA.debugLine="BasePane = Base";
_basepane = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 74;BA.debugLine="BaseLabel = Lbl";
_baselabel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 75;BA.debugLine="Tag = BasePane.Tag";
_tag = _basepane.getTag();
 //BA.debugLineNum = 76;BA.debugLine="BasePane.Tag = Me";
_basepane.setTag(this);
 //BA.debugLineNum = 79;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public int  _getcolorfalse() throws Exception{
 //BA.debugLineNum = 291;BA.debugLine="Public Sub getColorFalse As Int";
 //BA.debugLineNum = 292;BA.debugLine="Return mColorFalse";
if (true) return _mcolorfalse;
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return 0;
}
public int  _getcolortrue() throws Exception{
 //BA.debugLineNum = 284;BA.debugLine="Public Sub getColorTrue As Int";
 //BA.debugLineNum = 285;BA.debugLine="Return mColorTrue";
if (true) return _mcolortrue;
 //BA.debugLineNum = 286;BA.debugLine="End Sub";
return 0;
}
public int  _getstatus(byte _row,byte _col) throws Exception{
int _idx = 0;
 //BA.debugLineNum = 225;BA.debugLine="Public Sub GetStatus(row As Byte, col As Byte) As";
 //BA.debugLineNum = 226;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return (int) (-1);};
 //BA.debugLineNum = 229;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 230;BA.debugLine="Return LabelStatusIndicators(idx).Tag";
if (true) return (int)(BA.ObjectToNumber(_labelstatusindicators[_idx].getTag()));
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return 0;
}
public String  _getstatustext(int _state) throws Exception{
 //BA.debugLineNum = 235;BA.debugLine="Public Sub GetStatusText(state As Int) As String";
 //BA.debugLineNum = 236;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,(int) (_status_false),(int) (_status_true),(int) (_status_disabled))) {
case 0: {
 //BA.debugLineNum = 238;BA.debugLine="Return HMITileUtils.TEXT_INDICATOR_FALSE";
if (true) return _hmitileutils._text_indicator_false /*String*/ ;
 break; }
case 1: {
 //BA.debugLineNum = 240;BA.debugLine="Return HMITileUtils.TEXT_INDICATOR_TRUE";
if (true) return _hmitileutils._text_indicator_true /*String*/ ;
 break; }
case 2: {
 //BA.debugLineNum = 242;BA.debugLine="Return HMITileUtils.TEXT_INDICATOR_DISABLED";
if (true) return _hmitileutils._text_indicator_disabled /*String*/ ;
 break; }
default: {
 //BA.debugLineNum = 244;BA.debugLine="Return \"\"";
if (true) return "";
 break; }
}
;
 //BA.debugLineNum = 246;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 169;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 67;BA.debugLine="Private Sub Initialize(Callback As Object, EventNa";
 //BA.debugLineNum = 68;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 69;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _labelstatusindicator_click() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 323;BA.debugLine="Private Sub LabelStatusIndicator_Click";
 //BA.debugLineNum = 324;BA.debugLine="Dim lbl As B4XView = Sender";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba)));
 //BA.debugLineNum = 326;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 327;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_Click\"";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_Click",_lbl.getTag());
 };
 //BA.debugLineNum = 329;BA.debugLine="End Sub";
return "";
}
public String  _labelstatusindicator_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 318;BA.debugLine="Private Sub LabelStatusIndicator_MouseClicked (Eve";
 //BA.debugLineNum = 319;BA.debugLine="LabelStatusIndicator_Click";
_labelstatusindicator_click();
 //BA.debugLineNum = 320;BA.debugLine="End Sub";
return "";
}
public String  _setcolorfalse(int _value) throws Exception{
 //BA.debugLineNum = 288;BA.debugLine="Public Sub setColorFalse(value As Int)";
 //BA.debugLineNum = 289;BA.debugLine="mColorFalse = value";
_mcolorfalse = _value;
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return "";
}
public String  _setcolortrue(int _value) throws Exception{
 //BA.debugLineNum = 281;BA.debugLine="Public Sub setColorTrue(value As Int)";
 //BA.debugLineNum = 282;BA.debugLine="mColorTrue = value";
_mcolortrue = _value;
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}
public String  _setdata(byte _row,byte _col,String _text,String _description,int _status,boolean _show) throws Exception{
int _idx = 0;
b4j.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 174;BA.debugLine="Public Sub SetData(row As Byte, col As Byte, text";
 //BA.debugLineNum = 176;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 179;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 182;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4j.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 184;BA.debugLine="data.Status = status";
_data.Status /*int*/  = _status;
 //BA.debugLineNum = 185;BA.debugLine="data.Text = text";
_data.Text /*String*/  = _text;
 //BA.debugLineNum = 186;BA.debugLine="data.Description = description";
_data.Description /*String*/  = _description;
 //BA.debugLineNum = 188;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 191;BA.debugLine="If show Then";
if (_show) { 
 //BA.debugLineNum = 192;BA.debugLine="SetStatus(row, col, status)";
_setstatus(_row,_col,_status);
 //BA.debugLineNum = 193;BA.debugLine="SetText(row, col, text)";
_settext(_row,_col,_text);
 };
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public String  _setdescription(byte _row,byte _col,String _text) throws Exception{
int _idx = 0;
b4j.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 271;BA.debugLine="Public Sub SetDescription(row As Byte, col As Byte";
 //BA.debugLineNum = 273;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 275;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 276;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4j.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 277;BA.debugLine="data.Description = text";
_data.Description /*String*/  = _text;
 //BA.debugLineNum = 278;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(byte _row,byte _col,int _status) throws Exception{
int _idx = 0;
b4j.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 203;BA.debugLine="Public Sub SetStatus(row As Byte, col As Byte, sta";
 //BA.debugLineNum = 205;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 208;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 210;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4j.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 211;BA.debugLine="data.Status = status";
_data.Status /*int*/  = _status;
 //BA.debugLineNum = 212;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 213;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,(int) (_status_false),(int) (_status_true),(int) (_status_disabled))) {
case 0: {
 //BA.debugLineNum = 215;BA.debugLine="LabelStatusIndicators(idx).Color = mColorFalse";
_labelstatusindicators[_idx].setColor(_mcolorfalse);
 //BA.debugLineNum = 216;BA.debugLine="LabelStatusIndicators(idx).TextColor = mTextCol";
_labelstatusindicators[_idx].setTextColor(_mtextcolorfalse);
 break; }
case 1: {
 //BA.debugLineNum = 218;BA.debugLine="LabelStatusIndicators(idx).Color = mColorTrue";
_labelstatusindicators[_idx].setColor(_mcolortrue);
 //BA.debugLineNum = 219;BA.debugLine="LabelStatusIndicators(idx).TextColor = mTextCol";
_labelstatusindicators[_idx].setTextColor(_mtextcolortrue);
 break; }
case 2: {
 //BA.debugLineNum = 221;BA.debugLine="LabelStatusIndicators(idx).Color = mColorDisabl";
_labelstatusindicators[_idx].setColor(_mcolordisabled);
 //BA.debugLineNum = 222;BA.debugLine="LabelStatusIndicators(idx).TextColor = mTextCol";
_labelstatusindicators[_idx].setTextColor(_mtextcolordisabled);
 break; }
}
;
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return "";
}
public String  _settext(byte _row,byte _col,String _text) throws Exception{
int _idx = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
b4j.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 251;BA.debugLine="Public Sub SetText(row As Byte, col As Byte, Text";
 //BA.debugLineNum = 252;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 254;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 255;BA.debugLine="Dim lbl As B4XView = LabelStatusIndicators(idx)";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _labelstatusindicators[_idx];
 //BA.debugLineNum = 258;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4j.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 259;BA.debugLine="data.Text= Text";
_data.Text /*String*/  = _text;
 //BA.debugLineNum = 260;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 263;BA.debugLine="lbl.Text = Text";
_lbl.setText(_text);
 //BA.debugLineNum = 268;BA.debugLine="lbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_lbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 165;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 166;BA.debugLine="mTitle = value";
_mtitle = _value;
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
