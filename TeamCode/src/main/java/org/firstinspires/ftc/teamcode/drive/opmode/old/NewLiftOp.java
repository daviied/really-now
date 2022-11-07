package org.firstinspires.ftc.teamcode.drive.opmode.old;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@Disabled
@TeleOp
public class NewLiftOp extends OpMode{
   DcMotor lift = null;

    public void init() {
    lift = hardwareMap.get(DcMotor.class, "0");
    }

    @Override
    public void loop() {
    lift.setPower(gamepad1.left_stick_y);




    }


}


