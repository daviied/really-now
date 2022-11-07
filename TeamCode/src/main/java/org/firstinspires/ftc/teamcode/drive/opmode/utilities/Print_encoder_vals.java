package org.firstinspires.ftc.teamcode.drive.opmode.utilities;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class Print_encoder_vals extends OpMode {

    DcMotorEx front_left;
    DcMotorEx front_right;
    DcMotorEx back_left;
    DcMotorEx back_right;
    DcMotorEx lift;





   

    @Override
    public void init() {
        front_left = hardwareMap.get(DcMotorEx.class, "0");
        front_right = hardwareMap.get(DcMotorEx.class, "1");
        back_left = hardwareMap.get(DcMotorEx.class, "2");
        back_right = hardwareMap.get(DcMotorEx.class, "3");
        lift = hardwareMap.get(DcMotorEx.class, "e0");
        front_right.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        telemetry.addData("front_left>", front_left.getCurrentPosition());
        telemetry.addData("front_right>", front_right.getCurrentPosition());
        telemetry.addData("back_right>", back_right.getCurrentPosition());
        telemetry.addData("back_left>", back_left.getCurrentPosition());
        telemetry.addData("lift>", lift.getCurrentPosition());
        telemetry.update();
    }
}
