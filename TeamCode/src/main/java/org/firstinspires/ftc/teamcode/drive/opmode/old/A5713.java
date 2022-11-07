package org.firstinspires.ftc.teamcode.drive.opmode.old;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@TeleOp

public class A5713 extends OpMode {


    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    DcMotorEx lift;
    Servo a;
    Servo b;
    boolean flag = false;

    @Override
    public void init() {
        front_left = hardwareMap.get(DcMotor.class, "0");
        front_right = hardwareMap.get(DcMotor.class, "1");
        back_left = hardwareMap.get(DcMotor.class, "2");
        back_right = hardwareMap.get(DcMotor.class, "3");
        lift= hardwareMap.get(DcMotorEx.class, "e0");
        a = hardwareMap.get(Servo.class, "s0");
        b = hardwareMap.get(Servo.class, "s1");

        front_right.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    @Override
    public void loop() {

        double speed = -gamepad1.left_stick_y;
        double steering = -gamepad1. right_stick_x;
        double strafe = -gamepad1.left_stick_x;
        boolean serv = gamepad2.right_bumper;
        boolean pos_1 = gamepad2.a;
        boolean pos_2 = gamepad2.y;


        front_left.setPower((speed - steering) - strafe);
        front_right.setPower((speed + steering) + strafe);
        back_left.setPower((speed - steering) + strafe);
        back_right.setPower((speed + steering) - strafe);

        if  (serv) {
            if (flag) {
                a.setPosition(0);
                b.setPosition(1);
                flag = false;
            } else {
                a.setPosition(1);
                b.setPosition(0);
                flag = true;
            }
        }

        if (pos_1) {
            lift.setTargetPosition(0);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(0.5);
        } else if (pos_2) {
            lift.setTargetPosition(75);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(0.5);
        }



    }
}
