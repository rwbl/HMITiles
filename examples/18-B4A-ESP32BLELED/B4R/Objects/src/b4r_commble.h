
#ifndef b4r_commble_h
#define b4r_commble_h
class b4r_main;
class b4r_devled;
class b4r_convert;

class b4r_commble {
public:

static void _bledispatch(B4R::Array* _payload);
static void _bleserver_error(Byte _code);
static void _bleserver_newdata(B4R::Array* _buffer);
static void _bleserver_write(B4R::Array* _data);
static void _initialize();
static void _process_globals();
static Byte _dev_led;
static Byte _dev_system;
static Byte _cmd_set_state;
static Byte _cmd_get_state;
static Byte _cmd_set_color;
static Byte _cmd_get_color;
static Byte _cmd_set_value;
static Byte _cmd_get_value;
static Byte _cmd_custom_action;
static B4R::B4RString* _ble_server_name;
static B4R::B4RBLEServer* _bleserver;
static UInt _mtusize;
static b4r_main* _main;
static b4r_devled* _devled;
static b4r_convert* _convert;
};

#endif