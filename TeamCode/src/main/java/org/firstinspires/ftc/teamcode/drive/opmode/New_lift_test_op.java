package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled

@TeleOp
public class New_lift_test_op extends OpMode {
    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    DcMotor lift;
    Servo a;
    Servo b;

    @Override
    public void init() {
        front_left = hardwareMap.get(DcMotor.class, "0");
        front_right = hardwareMap.get(DcMotor.class, "1");
        back_left = hardwareMap.get(DcMotor.class, "2");
        back_right = hardwareMap.get(DcMotor.class, "3");
        lift = hardwareMap.get(DcMotor.class, "e0");
        a = hardwareMap.get(Servo.class, "s0");
        b = hardwareMap.get(Servo.class, "s1");
        front_right.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double speed = -gamepad1.left_stick_y;
        double steering = -gamepad1. right_stick_x;
        double strafe = -gamepad1.left_stick_x;
        double life = gamepad2.left_stick_y;
        double serv = gamepad2.right_trigger;


        front_left.setPower((speed - steering) - strafe);
        front_right.setPower((speed + steering) + strafe);
        back_left.setPower((speed - steering) + strafe);
        back_right.setPower((speed + steering) - strafe);

        lift.setPower(life);
        a.setPosition(serv);
        b.setPosition(-serv);

    }
}