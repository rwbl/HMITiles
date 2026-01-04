# TODO - B4R Library rBLEServer
Actions to complete till next version.
Any ideas to be captured in IDEAS.md.

## NEW: Multiple Clients
Handle multiple clients.
### Status
Not started.

## NEW: Create more examples
Develop examples:
**InputOutput** - Traffic-Light (3 LEDs Red-Green-Blue) [Output] and Push-Button [Input]. Set the traffic-light using push-button or connected client. Connected client receives traffic-light value.
**InputOutputClient** - As previous, but with simple B4A app to control the traffic-light.
### Status
Completed: InputOutput

## 

## NEW: Advertise Data
Example advertising a float temperature.

**Modify Initialize to Set Initial Advertising Data**
```
void B4RBLEServer::Initialize (B4RString* Name, SubVoidArray NewDataSub, SubVoidByte ErrorSub, UInt mtuSize) {
	instance = this;  
	this->NewDataSub = NewDataSub;
	this->ErrorSub = ErrorSub;

	// Ensure fresh start
    BLEDevice::deinit();
	
	// Set server name
    BLEDevice::init(Name->data);

	// Create the server
    pServer = BLEDevice::createServer();

	// Set MTU size (default 23, max 512), ensure MTU is within valid range.
	uint16_t mtu = mtuSize;
	if (mtu < MTU_SIZE_MIN || mtu > MTU_SIZE_MAX) {
		HandleError(WARNING_INVALID_MTU);
		mtu = MTU_SIZE_MIN;
	}	
	BLEDevice::setMTU(mtu);
	
	// Set the server callbacks
    pServer->setCallbacks(new MyServerCallbacks());

    pService = pServer->createService(SERVICE_UUID);
    pCharacteristic = pService->createCharacteristic(
        CHARACTERISTIC_UUID,  
        BLECharacteristic::PROPERTY_READ |
        BLECharacteristic::PROPERTY_WRITE |
        BLECharacteristic::PROPERTY_NOTIFY
    );

    pCharacteristic->setCallbacks(new MyCallbacks());
    pService->start();

    // Set initial advertising data
    UpdateAdvertisingData(25.0);  // Set initial temperature (example 25°C)
}
```

**Function to Update Advertising Data**
This function updates the BLE advertisement data dynamically.
```
void B4RBLEServer::UpdateAdvertisingData(float temperature) {
    if (!pServer) return;

    BLEAdvertisementData advData;
    advData.setName("ESP32_Sensor");  // Set device name
    advData.setManufacturerData(std::string(1, (char)temperature)); // Encode temperature as raw data

    // Get advertising object and update data
    BLEAdvertising *pAdvertising = pServer->getAdvertising();
    pAdvertising->setAdvertisementData(advData);
    pAdvertising->start();
}
```

**Loop to Update Temperature Every 10 Seconds**
```
void loop() {
    float newTemp = readTemperature();  // Replace with real sensor reading
    B4RBLEServer::GetInstance()->UpdateAdvertisingData(newTemp);
    delay(10000);  // Update every 10 seconds
}

// Simulated sensor reading function
float readTemperature() {
    return 20.0 + (rand() % 100) / 10.0; // Random temp between 20.0 - 30.0°C
}
```

**Advanced Manufacturer-specific Data**
To advertise a byte array holding the temperature, encode the temperature data in the advertising payload.
BLE advertising packets have a specific format, and can include a manufacturer-specific data field to send custom byte arrays.
Steps to Advertise a Byte Array (Temperature Data)
- Convert the temperature value into a byte array.
- Add the byte array to the manufacturer-specific data field.
- Call pAdvertising->setAdvertisementData() to update the advertising packet.

**Advertise Temperature as Byte Array**
The temperature is multiplied by 100 and stored as an int16_t (2 bytes). Example: 23.45°C → 2345 → 0x29 0x09
The manufacturer-specific data starts with \xFF\xFF (dummy manufacturer ID, replace with own if needed).
The byte array is appended to the advertising data.
The updated advertising data is sent using pAdvertising->setAdvertisementData().
```
void B4RBLEServer::UpdateAdvertisingData(float temperature) {
    // Convert temperature to byte array (assuming 2-byte int representation)
    int16_t tempInt = (int16_t)(temperature * 100);  // Convert float to int (e.g., 23.45°C -> 2345)
    uint8_t tempData[2];
    tempData[0] = tempInt & 0xFF;       // Lower byte
    tempData[1] = (tempInt >> 8) & 0xFF; // Higher byte

    // Create advertising data
    BLEAdvertisementData advertisementData;
    advertisementData.setName("BLEServer");  // BLE device name

    // Manufacturer data (using 0xFFFF as dummy manufacturer ID)
    std::string manufacturerData = "\xFF\xFF";  // 2-byte Manufacturer ID (replace if needed)
    manufacturerData.append((char*)tempData, 2); // Append temperature data

    advertisementData.setManufacturerData(manufacturerData);

    // Set advertising data
    pAdvertising->setAdvertisementData(advertisementData);
    pAdvertising->start();
}
```

**Periodically Update Temperature**
```
void loop() {
    float temperature = readTemperature();  // Replace with actual sensor reading
    UpdateAdvertisingData(temperature);
    delay(5000);  // Update every 5 seconds
}
```
