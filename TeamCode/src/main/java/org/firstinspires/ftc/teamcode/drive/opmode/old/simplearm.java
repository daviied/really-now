package org.firstinspires.ftc.teamcode.drive.opmode.old;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@TeleOp
public class simplearm extends OpMode {

    //initilizes everything
    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    DcMotor arm_lower;
    DcMotor arm_upper;
    Servo right;
    Servo left;




    public void init() {

        //assign motors
        front_left = hardwareMap.get(DcMotor.class, "0");
        front_right = hardwareMap.get(DcMotor.class, "1");
        back_right = hardwareMap.get(DcMotor.class, "2");
        back_left = hardwareMap.get(DcMotor.class, "3");
        arm_lower = hardwareMap.get(DcMotor.class, "e0");
        arm_upper = hardwareMap.get(DcMotor.class,"e1");

        //assign servos
        right = hardwareMap.get(Servo.class, "s1");
        left = hardwareMap.get(Servo.class, "s2");

        //reverses motors
        front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        back_right. setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {




        //fine drive controls for tools op variables to conver boolean to double
        double fstrafe = 0;
        double fpower = 0;
        double fsteering = 0;


        //fine controls for tools op
        boolean finestrafer = gamepad2.dpad_right;
        boolean finestrafel = gamepad2.dpad_left;
        boolean poweru = gamepad2.dpad_up;
        boolean powerd = gamepad2.dpad_down;
        boolean steeringl = gamepad2.left_bumper;
        boolean steeringr = gamepad2.right_bumper;


        //main drive controls for driver
        double strafe = gamepad1.left_stick_x;
        double power = gamepad1.left_stick_y;
        double steering = gamepad1.right_stick_x;

        //tools
        double arml = gamepad2.left_stick_y; //lower arm joystick
        double armu = gamepad2.right_stick_y; //upper arm joystick
        double trig = gamepad2.right_trigger; //grabber trigger
        boolean swit = gamepad2.back; //switches between analog control of grabber and bianary control
        boolean flag = false; //flag to switch between analog and bianary



        //emergency stop






        // switches the flag for swtiching between analog and bianary control
        if (swit) {
            if (flag == false) {
                flag = true;
            } else {
                flag = false;
            }
        }


        //bianary control

            right.setPosition(1 - trig);
            left.setPosition(trig);




        // this is setting converting the booleans to doubles to then be put into power equations
        if (finestrafel) {
            fstrafe = -0.2;
        } else if (finestrafer) {
            fstrafe = 0.2;
        } else {
            fstrafe = 0;
        }

        if (poweru) {
            fpower = -0.2;
        } else if (powerd) {
            fpower = 0.2;
        } else {
            fpower = 0;
        }

        if (steeringl) {
            fsteering = -0.2;
        } else if (steeringr) {
            fsteering = 0.2;
        } else {
            fsteering = 0;
        }


        //setting power for the arm
        arm_lower.setPower(-(arml / 2));
        arm_upper.setPower(-(armu / 2));

        //setting power to drive motors
        front_left.setPower(((power - steering) - strafe) + ((fpower - fsteering) - fstrafe));
        front_right.setPower(((power + steering) + strafe) + ((fpower + fsteering) + fstrafe));
        back_left.setPower(((power - steering) + strafe) + ((fpower - fsteering) + fstrafe));
        back_right.setPower(((power + steering) - strafe) + ((fpower + fsteering) - fstrafe));
    }






}

