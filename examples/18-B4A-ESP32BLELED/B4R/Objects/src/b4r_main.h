
#ifndef b4r_main_h
#define b4r_main_h
class b4r_commble;
class b4r_devled;
class b4r_convert;

class b4r_main {
public:

static void initializeProcessGlobals();
static void _appstart();
static void _process_globals();
static B4R::B4RString* _app_version;
static B4R::B4RString* _app_name;
static B4R::Serial* _serialline;
static b4r_commble* _commble;
static b4r_devled* _devled;
static b4r_convert* _convert;
};

#endif