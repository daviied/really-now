package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
@Disabled
public class A5713_encoder_print extends OpMode {



    DcMotorEx lift;


    @Override
    public void init() {

        lift = hardwareMap.get(DcMotorEx.class, "e0");
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    @Override
    public void loop() {

       telemetry.addData(">", lift.getCurrentPosition());
       telemetry.update();





    }
}

