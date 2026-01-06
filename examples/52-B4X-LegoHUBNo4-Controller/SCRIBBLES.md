

#If B4A
Public Sub BuWizzWriteRaw(Data() As Byte)
    ' --- get the gatt object from your BLE manager ---
    Dim jo As JavaObject = mBLEMgr
    Sleep(200)
    Dim gatt As JavaObject = jo.GetFieldJO("gatt")
    If gatt.IsInitialized = False Then
        Log("[BuWizzWriteRaw] ERROR: gatt not initialized")
        Return
    End If

    ' --- convert UUID strings to Java UUID objects ---
    Dim UUID As JavaObject
    UUID.InitializeStatic("java.util.UUID")
    Dim svcUUID As JavaObject = UUID.RunMethod("fromString", Array(SERVICE_UUID))
    Dim chrUUID As JavaObject = UUID.RunMethod("fromString", Array(CHAR_UUID_TX))

    ' --- get the service ---
    Dim serviceObj As JavaObject = gatt.RunMethod("getService", Array(svcUUID))
    If serviceObj.IsInitialized = False Then
        Log("[BuWizzWriteRaw] ERROR: service not found")
        Return
    End If

    ' --- get the characteristic ---
    Dim charObj As JavaObject = serviceObj.RunMethod("getCharacteristic", Array(chrUUID))
    If charObj.IsInitialized = False Then
        Log("[BuWizzWriteRaw] ERROR: characteristic not found")
        Return
    End If

    ' --- set WRITE_TYPE_DEFAULT ---
    Dim BGattChar As JavaObject
    BGattChar.InitializeStatic("android.bluetooth.BluetoothGattCharacteristic")
    charObj.RunMethod("setWriteType", Array(BGattChar.GetField("WRITE_TYPE_DEFAULT")))

    ' --- set the value ---
    charObj.RunMethod("setValue", Array(Data))

    ' --- write characteristic ---
    gatt.RunMethod("writeCharacteristic", Array(charObj))

    Log($"[BuWizzWriteRaw] sent data=${Convert.HexFromBytes(Data)}"$)
End Sub
#End If
