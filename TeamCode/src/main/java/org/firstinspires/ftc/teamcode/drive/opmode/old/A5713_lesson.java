package org.firstinspires.ftc.teamcode.drive.opmode.old;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
public class A5713_lesson extends OpMode {

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
        lift = hardwareMap.get(DcMotorEx.class, "e0");
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
        boolean pos_up = gamepad2.y;
        boolean pos_down = gamepad2.a;

        if (pos_down) {
            lift.setTargetPosition(0);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(0.25);
        } else if (pos_up) {
            lift.setTargetPosition(100);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(0.25);
        }

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


    }


}
