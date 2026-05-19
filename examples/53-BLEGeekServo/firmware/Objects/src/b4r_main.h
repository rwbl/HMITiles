
#ifndef b4r_main_h
#define b4r_main_h
class b4r_convert;

class b4r_main {
public:

static void initializeProcessGlobals();
static void _appstart();
static void _onconnected();
static void _ondisconnected();
static void _onwrite(B4R::Array* _buffer);
static void _process_globals();
static B4R::B4RString* _version;
static B4R::Serial* _serial1;
static B4R::B4RNimBLEServer* _bleserver;
static B4R::B4RESP32Servo* _geekservo;
static B4R::Pin* _geekservopin;
static Byte _geekservopinnr;
static UInt _servoangle;
static UInt _angle_base_pos;
static UInt _angle_open;
static UInt _angle_close;
static B4R::Pin* _onboardled;
static Byte _onboardled_pinnr;
static Byte _frame_length;
static Byte _frame_header;
static Byte _frame_footer;
static Byte _device_address;
static Byte _cmd_set_angle;
static Byte _val_open;
static Byte _val_close;
static b4r_convert* _convert;
static void _processcommand(B4R::Array* _command);
static void _setservoposition(Byte _angle);
};

#endif