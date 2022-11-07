//package org.firstinspires.ftc.teamcode;
package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@TeleOp
public class robotest extends OpMode {
    DcMotor front_left = null;
    DcMotor front_right = null;
    DcMotor back_left = null;
    DcMotor back_right = null;
    DcMotor arm_low = null;
    DcMotor arm_up = null;
    Servo left_servo = null;
    Servo right_servo = null;
    int lower_arm_stop = 0;
    int upper_arm_stop = 0;
    DcMotor spin = null;
    public void init() {
        front_left = hardwareMap.get(DcMotor.class, "0");
        front_right = hardwareMap.get(DcMotor.class, "1");
        back_left = hardwareMap.get(DcMotor.class, "3");
        back_right = hardwareMap.get(DcMotor.class,"2");
        arm_low = hardwareMap.get(DcMotor.class, "e0");
        arm_up = hardwareMap.get(DcMotor.class, "e1");
        front_left.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);
    }
    boolean upper_stop_previous_iteration = false;
    boolean lower_stop_previous_iteration = false;
    boolean other_previous_iteration = false;
    public void loop() {
        double brake = gamepad1.right_trigger;
        double throttle = gamepad1.left_trigger;
        double steering = gamepad1.left_stick_x;
        double arma = gamepad2.left_stick_y;
        double armb = gamepad2.right_stick_y;
        // duck is the triggers
        // hands a open b close
        // set power on motor to go down at .6 and put right before the set power command
        // overrides: bumpers
        // x and y are on/off for the motors, x is left, y is right
        //boolean other = gamepad2.dpad_left;
        //if (gamepad1.dpad_left) other = true;
        front_left.setPower((throttle - brake) - (steering / 2));
        front_right.setPower((throttle - brake) + (steering / 2));
        back_left.setPower((throttle - brake) + (steering / 2));
        back_right.setPower((throttle - brake) - (steering / 2));
        arm_low.setPower(-arma);
        arm_up.setPower(armb);
        telemetry.addData("armb", armb);
        telemetry.addData("arma", arma);
        telemetry.addData("upper stop button prev iteration", upper_stop_previous_iteration);
        telemetry.addData("lower stop button prev iteration", lower_stop_previous_iteration);
        telemetry.addData("lower_arm_stop", lower_arm_stop);
        telemetry.addData("upper_arm_stop", upper_arm_stop);
        telemetry.update();
//to do list use is
        //other_previous_iteration = other;
    }
}