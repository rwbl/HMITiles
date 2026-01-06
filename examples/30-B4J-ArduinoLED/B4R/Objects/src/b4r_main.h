
#ifndef b4r_main_h
#define b4r_main_h

class b4r_main {
public:

static void initializeProcessGlobals();
static void _appstart();
static void _astream_error();
static void _astream_newdata(B4R::Array* _buffer);
static void _blinktimer_tick();
static void _process_globals();
static Byte _cmd_led_off;
static Byte _cmd_led_on;
static Byte _cmd_led_blink;
static Byte _state_ok;
static Byte _state_error;
static B4R::Serial* _serial1;
static B4R::AsyncStreams* _astream;
static Byte _data_length;
static B4R::Pin* _led1pin;
static Byte _led1pinnumber;
static B4R::Timer* _blinktimer;
static ULong _blinktimerinterval;
};

#endif