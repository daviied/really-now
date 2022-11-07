package org.firstinspires.ftc.teamcode.drive.opmode.utilities;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DigitalChannel;


@TeleOp
public class Touch extends OpMode {
    //TouchSensor touch;
    DigitalChannel touch;
    DigitalChannel led;
    @Override
    public void init() {

       // touch = hardwareMap.get(TouchSensor.class, "d0");
        touch = hardwareMap.get(DigitalChannel.class, "d1");
      //  touch = hardwareMap.touchSensor.get("d1");
        led = hardwareMap.get(DigitalChannel.class, "d0");
        led.setMode(DigitalChannel.Mode.OUTPUT);
        touch.setMode(DigitalChannel.Mode.INPUT);


    }

    @Override
    public void loop() {


        if (touch.getState()) {
           // return;
            led.setState(true);
            telemetry.addData("touch", touch.getState());
            telemetry.update();
        } else {
            telemetry.clear();
            telemetry.update();
            led.setState(false);
        }



    }


}
