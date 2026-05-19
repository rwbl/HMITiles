package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hmitilestatusindicators extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.hmitilestatusindicators");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.hmitilestatusindicators.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mlbl = null;
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
public b4a.example.dateutils _dateutils = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.xuiviewsutils _xuiviewsutils = null;
public b4a.example.hmitileutils _hmitileutils = null;
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
 //BA.debugLineNum = 83;BA.debugLine="mBase.LoadLayout(\"hmitilestatusindicators\")";
_mbase.LoadLayout("hmitilestatusindicators",ba);
 //BA.debugLineNum = 86;BA.debugLine="mTitle			= Props.Get(\"Title\")";
_mtitle = BA.ObjectToString(_props.Get((Object)("Title")));
 //BA.debugLineNum = 87;BA.debugLine="LabelTitle.Text	= mTitle";
_labeltitle.setText(BA.ObjectToCharSequence(_mtitle));
 //BA.debugLineNum = 88;BA.debugLine="mColorTrue		= xui.PaintOrColorToColor(Props.Get(\"";
_mcolortrue = _xui.PaintOrColorToColor(_props.Get((Object)("ColorTrue")));
 //BA.debugLineNum = 89;BA.debugLine="mColorFalse		= xui.PaintOrColorToColor(Props.Get(";
_mcolorfalse = _xui.PaintOrColorToColor(_props.Get((Object)("ColorFalse")));
 //BA.debugLineNum = 92;BA.debugLine="CreateStatusIndicators";
_createstatusindicators();
 //BA.debugLineNum = 95;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 98;BA.debugLine="ApplyStyle";
_applystyle();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _applystyle() throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Private Sub ApplyStyle";
 //BA.debugLineNum = 307;BA.debugLine="HMITileUtils.ApplyTitleStyle(LabelTitle)";
_hmitileutils._applytitlestyle /*String*/ (ba,_labeltitle);
 //BA.debugLineNum = 309;BA.debugLine="mBase.Color = HMITileUtils.COLOR_TILE_NORMAL_BACK";
_mbase.setColor(_hmitileutils._color_tile_normal_background /*int*/ );
 //BA.debugLineNum = 311;BA.debugLine="mBase.SetColorAndBorder(mBase.Color, 0, 0, HMITil";
_mbase.SetColorAndBorder(_mbase.getColor(),(int) (0),(int) (0),(int) (_hmitileutils._border_radius /*double*/ ));
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
double _neww = 0;
double _newh = 0;
int _pad = 0;
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
 //BA.debugLineNum = 108;BA.debugLine="mBase.SetLayoutAnimated(0, mBase.Left, mBase.Top";
_mbase.SetLayoutAnimated((int) (0),_mbase.getLeft(),_mbase.getTop(),(int) (_neww),(int) (_newh));
 //BA.debugLineNum = 109;BA.debugLine="Return ' Exit and let the sub re-fire with the n";
if (true) return "";
 };
 //BA.debugLineNum = 113;BA.debugLine="Dim pad As Int = HMITileUtils.BORDER_WIDTH + HMIT";
_pad = (int) (_hmitileutils._border_width /*double*/ +_hmitileutils._padding /*int*/ );
 //BA.debugLineNum = 117;BA.debugLine="LabelTitle.SetLayoutAnimated (0, pad, pad, Width";
_labeltitle.SetLayoutAnimated((int) (0),_pad,_pad,(int) (_width-_pad*2),(int) (_height*0.25));
 //BA.debugLineNum = 119;BA.debugLine="Dim it As Double = LabelTitle.Top + LabelTitle.He";
_it = _labeltitle.getTop()+_labeltitle.getHeight();
 //BA.debugLineNum = 121;BA.debugLine="Dim iw As Int = Floor(Width / 3)";
_iw = (int) (__c.Floor(_width/(double)3));
 //BA.debugLineNum = 122;BA.debugLine="Dim ih As Int = Floor((Height - it) / 3)";
_ih = (int) (__c.Floor((_height-_it)/(double)3));
 //BA.debugLineNum = 124;BA.debugLine="For i = 0 To STATUS_INDICATORS_SIZE - 1";
{
final int step13 = 1;
final int limit13 = (int) (_status_indicators_size-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 125;BA.debugLine="Dim row As Int = i / 3";
_row = (int) (_i/(double)3);
 //BA.debugLineNum = 126;BA.debugLine="Dim col As Int = i Mod 3";
_col = (int) (_i%3);
 //BA.debugLineNum = 128;BA.debugLine="Dim l As Int = col * iw";
_l = (int) (_col*_iw);
 //BA.debugLineNum = 129;BA.debugLine="Dim t As Int = row * ih + it";
_t = (int) (_row*_ih+_it);
 //BA.debugLineNum = 130;BA.debugLine="Dim w As Int = iw";
_w = _iw;
 //BA.debugLineNum = 131;BA.debugLine="Dim h As Int = ih";
_h = _ih;
 //BA.debugLineNum = 135;BA.debugLine="If col = 2 Then w = Width - l";
if (_col==2) { 
_w = (int) (_width-_l);};
 //BA.debugLineNum = 136;BA.debugLine="If row = 2 Then h = Height - t";
if (_row==2) { 
_h = (int) (_height-_t);};
 //BA.debugLineNum = 138;BA.debugLine="LabelStatusIndicators(i).SetLayoutAnimated(0, l,";
_labelstatusindicators[_i].SetLayoutAnimated((int) (0),_l,_t,_w,_h);
 }
};
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private xui 					As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 30;BA.debugLine="Public mBase 					As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private mLbl 					As B4XView					'ignore";
_mlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
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
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
b4a.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 143;BA.debugLine="Private Sub CreateStatusIndicators";
 //BA.debugLineNum = 144;BA.debugLine="For i = 0 To STATUS_INDICATORS_SIZE - 1";
{
final int step1 = 1;
final int limit1 = (int) (_status_indicators_size-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 145;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 146;BA.debugLine="lbl.Initialize(\"LabelStatusIndicator\")";
_lbl.Initialize(ba,"LabelStatusIndicator");
 //BA.debugLineNum = 147;BA.debugLine="mBase.AddView(lbl, 0dip, 0dip, 30dip, 30dip)";
_mbase.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (0)),__c.DipToCurrent((int) (0)),__c.DipToCurrent((int) (30)),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 148;BA.debugLine="LabelStatusIndicators(i) = lbl";
_labelstatusindicators[_i] = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 149;BA.debugLine="Dim data As IndicatorData";
_data = new b4a.example.hmitilestatusindicators._indicatordata();
 //BA.debugLineNum = 150;BA.debugLine="data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 151;BA.debugLine="data.Index = i";
_data.Index /*int*/  = _i;
 //BA.debugLineNum = 152;BA.debugLine="data.Status = STATUS_DISABLED";
_data.Status /*int*/  = (int) (_status_disabled);
 //BA.debugLineNum = 153;BA.debugLine="data.Text = \"\"";
_data.Text /*String*/  = "";
 //BA.debugLineNum = 154;BA.debugLine="data.Description = \"\"";
_data.Description /*String*/  = "";
 //BA.debugLineNum = 155;BA.debugLine="LabelStatusIndicators(i).Tag = data";
_labelstatusindicators[_i].setTag((Object)(_data));
 //BA.debugLineNum = 156;BA.debugLine="LabelStatusIndicators(i).Text = data.Text";
_labelstatusindicators[_i].setText(BA.ObjectToCharSequence(_data.Text /*String*/ ));
 //BA.debugLineNum = 157;BA.debugLine="LabelStatusIndicators(i).SetTextAlignment(\"CENTE";
_labelstatusindicators[_i].SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 158;BA.debugLine="LabelStatusIndicators(i).SetColorAndBorder(mColo";
_labelstatusindicators[_i].SetColorAndBorder(_mcolordisabled,__c.DipToCurrent((int) (1)),_hmitileutils._color_border_default /*int*/ ,(int) (0));
 //BA.debugLineNum = 159;BA.debugLine="LabelStatusIndicators(i).TextColor = mTextColorD";
_labelstatusindicators[_i].setTextColor(_mtextcolordisabled);
 }
};
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub DesignerCreateView(Base As Object, Lbl";
 //BA.debugLineNum = 73;BA.debugLine="mBase = Base";
_mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 74;BA.debugLine="mLbl = Lbl";
_mlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 75;BA.debugLine="Tag = mBase.Tag";
_tag = _mbase.getTag();
 //BA.debugLineNum = 76;BA.debugLine="mBase.Tag = Me";
_mbase.setTag(this);
 //BA.debugLineNum = 79;BA.debugLine="CallSubDelayed2(Me, \"AfterLoadLayout\", Props)";
__c.CallSubDelayed2(ba,this,"AfterLoadLayout",(Object)(_props));
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public int  _getcolorfalse() throws Exception{
 //BA.debugLineNum = 295;BA.debugLine="Public Sub getColorFalse As Int";
 //BA.debugLineNum = 296;BA.debugLine="Return mColorFalse";
if (true) return _mcolorfalse;
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return 0;
}
public int  _getcolortrue() throws Exception{
 //BA.debugLineNum = 288;BA.debugLine="Public Sub getColorTrue As Int";
 //BA.debugLineNum = 289;BA.debugLine="Return mColorTrue";
if (true) return _mcolortrue;
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return 0;
}
public int  _getstatus(byte _row,byte _col) throws Exception{
int _idx = 0;
 //BA.debugLineNum = 229;BA.debugLine="Public Sub GetStatus(row As Byte, col As Byte) As";
 //BA.debugLineNum = 230;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return (int) (-1);};
 //BA.debugLineNum = 233;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 234;BA.debugLine="Return LabelStatusIndicators(idx).Tag";
if (true) return (int)(BA.ObjectToNumber(_labelstatusindicators[_idx].getTag()));
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return 0;
}
public String  _getstatustext(int _state) throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Public Sub GetStatusText(state As Int) As String";
 //BA.debugLineNum = 240;BA.debugLine="Select state";
switch (BA.switchObjectToInt(_state,(int) (_status_false),(int) (_status_true),(int) (_status_disabled))) {
case 0: {
 //BA.debugLineNum = 242;BA.debugLine="Return HMITileUtils.TEXT_INDICATOR_FALSE";
if (true) return _hmitileutils._text_indicator_false /*String*/ ;
 break; }
case 1: {
 //BA.debugLineNum = 244;BA.debugLine="Return HMITileUtils.TEXT_INDICATOR_TRUE";
if (true) return _hmitileutils._text_indicator_true /*String*/ ;
 break; }
case 2: {
 //BA.debugLineNum = 246;BA.debugLine="Return HMITileUtils.TEXT_INDICATOR_DISABLED";
if (true) return _hmitileutils._text_indicator_disabled /*String*/ ;
 break; }
default: {
 //BA.debugLineNum = 248;BA.debugLine="Return \"\"";
if (true) return "";
 break; }
}
;
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public String  _gettitle() throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Public Sub getTitle As String";
 //BA.debugLineNum = 173;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 325;BA.debugLine="Private Sub LabelStatusIndicator_Click";
 //BA.debugLineNum = 326;BA.debugLine="Dim lbl As B4XView = Sender";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba)));
 //BA.debugLineNum = 328;BA.debugLine="If SubExists(mCallBack, mEventName & \"_Click\") Th";
if (__c.SubExists(ba,_mcallback,_meventname+"_Click")) { 
 //BA.debugLineNum = 329;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_Click\"";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_Click",_lbl.getTag());
 };
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
return "";
}
public String  _setcolorfalse(int _value) throws Exception{
 //BA.debugLineNum = 292;BA.debugLine="Public Sub setColorFalse(value As Int)";
 //BA.debugLineNum = 293;BA.debugLine="mColorFalse = value";
_mcolorfalse = _value;
 //BA.debugLineNum = 294;BA.debugLine="End Sub";
return "";
}
public String  _setcolortrue(int _value) throws Exception{
 //BA.debugLineNum = 285;BA.debugLine="Public Sub setColorTrue(value As Int)";
 //BA.debugLineNum = 286;BA.debugLine="mColorTrue = value";
_mcolortrue = _value;
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public String  _setdata(byte _row,byte _col,String _text,String _description,int _status,boolean _show) throws Exception{
int _idx = 0;
b4a.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 178;BA.debugLine="Public Sub SetData(row As Byte, col As Byte, text";
 //BA.debugLineNum = 180;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 183;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 186;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4a.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 188;BA.debugLine="data.Status = status";
_data.Status /*int*/  = _status;
 //BA.debugLineNum = 189;BA.debugLine="data.Text = text";
_data.Text /*String*/  = _text;
 //BA.debugLineNum = 190;BA.debugLine="data.Description = description";
_data.Description /*String*/  = _description;
 //BA.debugLineNum = 192;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 195;BA.debugLine="If show Then";
if (_show) { 
 //BA.debugLineNum = 196;BA.debugLine="SetStatus(row, col, status)";
_setstatus(_row,_col,_status);
 //BA.debugLineNum = 197;BA.debugLine="SetText(row, col, text)";
_settext(_row,_col,_text);
 };
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public String  _setdescription(byte _row,byte _col,String _text) throws Exception{
int _idx = 0;
b4a.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 275;BA.debugLine="Public Sub SetDescription(row As Byte, col As Byte";
 //BA.debugLineNum = 277;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 279;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 280;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4a.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 281;BA.debugLine="data.Description = text";
_data.Description /*String*/  = _text;
 //BA.debugLineNum = 282;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
return "";
}
public String  _setstatus(byte _row,byte _col,int _status) throws Exception{
int _idx = 0;
b4a.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 207;BA.debugLine="Public Sub SetStatus(row As Byte, col As Byte, sta";
 //BA.debugLineNum = 209;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 212;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 214;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4a.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 215;BA.debugLine="data.Status = status";
_data.Status /*int*/  = _status;
 //BA.debugLineNum = 216;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 217;BA.debugLine="Select status";
switch (BA.switchObjectToInt(_status,(int) (_status_false),(int) (_status_true),(int) (_status_disabled))) {
case 0: {
 //BA.debugLineNum = 219;BA.debugLine="LabelStatusIndicators(idx).Color = mColorFalse";
_labelstatusindicators[_idx].setColor(_mcolorfalse);
 //BA.debugLineNum = 220;BA.debugLine="LabelStatusIndicators(idx).TextColor = mTextCol";
_labelstatusindicators[_idx].setTextColor(_mtextcolorfalse);
 break; }
case 1: {
 //BA.debugLineNum = 222;BA.debugLine="LabelStatusIndicators(idx).Color = mColorTrue";
_labelstatusindicators[_idx].setColor(_mcolortrue);
 //BA.debugLineNum = 223;BA.debugLine="LabelStatusIndicators(idx).TextColor = mTextCol";
_labelstatusindicators[_idx].setTextColor(_mtextcolortrue);
 break; }
case 2: {
 //BA.debugLineNum = 225;BA.debugLine="LabelStatusIndicators(idx).Color = mColorDisabl";
_labelstatusindicators[_idx].setColor(_mcolordisabled);
 //BA.debugLineNum = 226;BA.debugLine="LabelStatusIndicators(idx).TextColor = mTextCol";
_labelstatusindicators[_idx].setTextColor(_mtextcolordisabled);
 break; }
}
;
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public String  _settext(byte _row,byte _col,String _text) throws Exception{
int _idx = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
b4a.example.hmitilestatusindicators._indicatordata _data = null;
 //BA.debugLineNum = 255;BA.debugLine="Public Sub SetText(row As Byte, col As Byte, Text";
 //BA.debugLineNum = 256;BA.debugLine="If row < 1 Or row > ROWS Or col < 1 Or col > COLS";
if (_row<1 || _row>_rows || _col<1 || _col>_cols) { 
if (true) return "";};
 //BA.debugLineNum = 258;BA.debugLine="Dim idx As Int = (row - 1) * COLS + (col - 1)";
_idx = (int) ((_row-1)*_cols+(_col-1));
 //BA.debugLineNum = 259;BA.debugLine="Dim lbl As B4XView = LabelStatusIndicators(idx)";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _labelstatusindicators[_idx];
 //BA.debugLineNum = 262;BA.debugLine="Dim data As IndicatorData = LabelStatusIndicators";
_data = (b4a.example.hmitilestatusindicators._indicatordata)(_labelstatusindicators[_idx].getTag());
 //BA.debugLineNum = 263;BA.debugLine="data.Text= Text";
_data.Text /*String*/  = _text;
 //BA.debugLineNum = 264;BA.debugLine="LabelStatusIndicators(idx).Tag = data";
_labelstatusindicators[_idx].setTag((Object)(_data));
 //BA.debugLineNum = 267;BA.debugLine="lbl.Text = Text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 272;BA.debugLine="lbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_lbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}
public String  _settitle(String _value) throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Public Sub setTitle(value As String)";
 //BA.debugLineNum = 170;BA.debugLine="mTitle = value";
_mtitle = _value;
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "AFTERLOADLAYOUT"))
	return _afterloadlayout((anywheresoftware.b4a.objects.collections.Map) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
