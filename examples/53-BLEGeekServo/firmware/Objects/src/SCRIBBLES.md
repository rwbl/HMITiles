# SCRIBBLES - B4R Library rESP32Servo


## Links
www.waveshare.com/wiki/General_Driver_for_Robots
https://botland.de/servotreiber/21964-esp32-servotreiber-erweiterungskarte-uart-servotreiber-wifi-bluetooth-waveshare-21593.html

' Two Test Method
' Which is better?
' If testing smooth travel and holding torque → TestServo is better.
' If testing absolute positions (Min/Max) without continuous holding → TestServo2 is better.
' For typical servo test code, TestServo is the standard practice because it simulates real use (servo stays attached during movement).

' TestServo
' Attaches once at the beginning.
' Moves To ANGLE_MIN_POS, waits, Then moves To ANGLE_MAX_POS.
' Detaches once at the End.
' Pros:
' - Cleaner, faster (only one attach/detach cycle).
' - Servo remains powered/held between moves → smooth movement.
' Cons:
' - Servo is always “energized” between Min/Max test, so it will resist movement (draws current).
Private Sub TestServo(Tag As Byte)
	Log("[TestServo] Start")

	' Assign servo to device on pin servo
	Servo1.Attach(PinServo.PinNumber)
	Delay(20)

	Servo1.Write(ANGLE_MIN_POS)
	Delay(20)
	Log("[TestServo] Min pos angle=", Servo1.Read)

	Delay(2000)

	Servo1.Write(ANGLE_MAX_POS)
	Delay(20)
	Log("[TestServo] Max pos angle=", Servo1.Read)

	Servo1.Detach
	Log("[TestServo] Done")
End Sub

' TestServo2
' Attaches → moves To Min → detaches.
' Waits.
' Attaches → moves To Max → detaches again.
' Pros:
' - Servo is only powered when actually moving.
' - If goal is testing absolute positioning only, this reduces heat/current draw.
' Cons:
' - Servo will “relax” between Min/Max test (Not holding torque).
' - If there is load or gravity, the servo might drift before the second attach.
Private Sub TestServo2(Tag As Byte)
	Log("[TestServo2] Start")
	' Assign servo to device on pin servo
	Servo1.Attach(PinServo.PinNumber)
	Delay(20)
	Servo1.Write(ANGLE_MIN_POS)
	Delay(20)
	Log("[TestServo2] Min pos angle=", Servo1.Read)
	Servo1.Detach

	Delay(2000)

	Servo1.Attach(PinServo.PinNumber)
	Delay(20)
	Servo1.Write(ANGLE_MAX_POS)
	Delay(20)
	Log("[TestServo2] Max pos angle=", Servo1.Read)
	Servo1.Detach
	Log("[TestServo2] Done")
End Sub

