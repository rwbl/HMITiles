
#ifndef b4r_devled_h
#define b4r_devled_h
class b4r_main;
class b4r_commble;
class b4r_convert;

class b4r_devled {
public:

static bool _get();
static void _initialize(Byte _pinnr);
static void _process_globals();
static B4R::Pin* _led;
static b4r_main* _main;
static b4r_commble* _commble;
static b4r_convert* _convert;
static void _processble(B4R::Array* _payload);
static void _set(bool _state);
static void _setpwm(UInt _value);
static void _toggle();
static void _writetoble(Byte _command,Byte _state);
};

#endif