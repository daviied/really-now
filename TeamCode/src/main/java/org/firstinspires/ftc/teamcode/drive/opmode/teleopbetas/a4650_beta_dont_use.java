package org.firstinspires.ftc.teamcode.drive.opmode.teleopbetas;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class a4650_beta_dont_use extends OpMode {
    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    DcMotorEx lift;
    DigitalChannel touch;
    DigitalChannel led;
    Servo a;
    Servo b;
    int po = 0;
    int enc = 0;

    @Override
    public void init() {
        front_left = hardwareMap.get(DcMotor.class, "0");
        front_right = hardwareMap.get(DcMotor.class, "1");
        back_left = hardwareMap.get(DcMotor.class, "2");
        back_right = hardwareMap.get(DcMotor.class, "3");
        lift = hardwareMap.get(DcMotorEx.class, "e0");
        a = hardwareMap.get(Servo.class, "s0");
        b = hardwareMap.get(Servo.class, "s1");
        touch = hardwareMap.get(DigitalChannel.class, "d1");
        led = hardwareMap.get(DigitalChannel.class, "d0");
        led.setMode(DigitalChannel.Mode.OUTPUT);
        touch.setMode(DigitalChannel.Mode.INPUT);
        front_right.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setTargetPosition(0);
    }

    @Override
    public void loop() {
        double speed = gamepad1.left_stick_y;
        double steering = gamepad1.right_stick_x;
        double strafe = gamepad1.left_stick_x;
        boolean pos_1 = gamepad2.a;
        boolean pos_2 = gamepad2.x;
        boolean pos_3 = gamepad2.b;
        boolean pos_4 = gamepad2.y;
        // double serv = gamepad2.right_trigger;
        boolean f = gamepad2.left_bumper;
        boolean g = gamepad2.right_bumper;
        boolean up = gamepad2.dpad_up;
        boolean down = gamepad2.dpad_down;
        double offset = gamepad2.left_trigger;
        double re = gamepad2.right_trigger;



                if (!touch.getState()) {

                    lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    lift.setTargetPosition(0);
                    lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    lift.setPower(0.85);

                }

        if (touch.getState()) {
            led.setState(true);
        } else {
            led.setState(false);
        }

        telemetry.addData("touch>", touch.getState());


        if (lift.getCurrentPosition() > enc +1867) {
            speed = speed / 2.5;
            steering = steering / 2.5;
            strafe = strafe / 2.5;
        } else if (lift.getCurrentPosition() > enc + 1092) {
            speed = speed / 1.5;
            steering = steering / 1.5;
            strafe = strafe / 1.5;
        }




            front_left.setPower((speed - steering) - strafe);
        front_right.setPower((speed + steering) + strafe);
        back_left.setPower((speed - steering) + strafe);
        back_right.setPower((speed + steering) - strafe);





        if (up && offset > 0.5) {
            enc += 2;
        } else if (down && offset > 0.5){
            enc -= 2;
        } else if (up){
            po = po += 2;
        } else if (down){
            po = po -+ 2;
        }

        if (pos_1) {
            po = enc + 0;
        } else if (pos_2) {
            po = enc + 2141;
        } else if (pos_3) {
            po = enc + 3324;
        } else if (pos_4) {
            po = enc + 4440;
        }

        telemetry.addData(">", po);
        telemetry.addData("encoder>", lift.getCurrentPosition());
        telemetry.update();

        lift.setTargetPosition(po);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setPower(0.85);

        if (f) {
            a.setPosition(1);
            b.setPosition(0);
        }
        if (g) {
            a.setPosition(0);
            b.setPosition(1);
        }
        //a.setPosition(serv);
        //b.setPosition(serv);

    }
}
