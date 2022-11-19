package org.firstinspires.ftc.teamcode.drive.opmode.classes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;



public class Robot extends LinearOpMode{


    //circumference = 11.87374
    //516 ticks per rev
    DcMotorEx fl;
    DcMotorEx fr;
    DcMotorEx bl;
    DcMotorEx br;
    double speed = 0.5;


public void define(DcMotorEx front_left, DcMotorEx front_right, DcMotorEx back_left, DcMotorEx back_right) {

    fl = front_left;
    fr = front_right;
    bl = back_left;
    br = back_right;

    fr.setDirection(DcMotor.Direction.REVERSE);
    br.setDirection(DcMotor.Direction.REVERSE);

    fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
}




    public boolean drive_forward(int distance) {


        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        int tpi = 43;
        int total = tpi * distance;
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (a != total && b != total && c != total && d != total) {
            a = fl.getCurrentPosition();
            b = fr.getCurrentPosition();
            c = bl.getCurrentPosition();
            d = br.getCurrentPosition();
            fl.setTargetPosition(total);
            fr.setTargetPosition(total);
            bl.setTargetPosition(total);
            br.setTargetPosition(total);

            fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            fl.setPower(speed);
            fr.setPower(speed);
            bl.setPower(speed);
            br.setPower(speed);
        }

        return true;
    }

    public boolean drive_backward(int distance) {


        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        int tpi = 43;
        int total = -(tpi * distance);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (a != total && b != total && c != total && d != total) {
            a = fl.getCurrentPosition();
            b = fr.getCurrentPosition();
            c = bl.getCurrentPosition();
            d = br.getCurrentPosition();
            fl.setTargetPosition(total);
            fr.setTargetPosition(total);
            bl.setTargetPosition(total);
            br.setTargetPosition(total);

            fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            fl.setPower(speed);
            fr.setPower(speed);
            bl.setPower(speed);
            br.setPower(speed);
        }

        return true;


    }

    public boolean strafe_left(int distance) {



        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        int tpi = 49;
        int total = tpi * distance;
        int opposite = -(tpi * distance);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (a != total && b != total && c != total && d != total) {
            a = fl.getCurrentPosition();
            b = fr.getCurrentPosition();
            c = bl.getCurrentPosition();
            d = br.getCurrentPosition();
            fl.setTargetPosition(opposite);
            fr.setTargetPosition(total);
            bl.setTargetPosition(total);
            br.setTargetPosition(opposite);

            fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            fl.setPower(speed);
            fr.setPower(speed);
            bl.setPower(speed);
            br.setPower(speed);
        }
        return true;

    }

    public boolean strafe_right(int distance) {

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        int tpi = 49;
        int total = tpi * distance;,
        int opposite = -(tpi * distance);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (a != total && b != total && c != total && d != total) {
            a = fl.getCurrentPosition();
            b = fr.getCurrentPosition();
            c = bl.getCurrentPosition();
            d = br.getCurrentPosition();
            fl.setTargetPosition(total);
            fr.setTargetPosition(opposite);
            bl.setTargetPosition(opposite);
            br.setTargetPosition(total);

            fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            fl.setPower(speed);
            fr.setPower(speed);
            bl.setPower(speed);
            br.setPower(speed);
        }

        return true;

    }

    public boolean turn_left(int distance){

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        int tpi = 10;
        int total = (tpi * distance) / 2;
        int opposite = -(tpi * distance) / 2;
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (a != total && b != total && c != total && d != total) {
            a = fl.getCurrentPosition();
            b = fr.getCurrentPosition();
            c = bl.getCurrentPosition();
            d = br.getCurrentPosition();
            fl.setTargetPosition(opposite);
            fr.setTargetPosition(total);
            bl.setTargetPosition(opposite);
            br.setTargetPosition(total);

            fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            fl.setPower(speed);
            fr.setPower(speed);
            bl.setPower(speed);
            br.setPower(speed);
        }

        return true;

    }

    public boolean turn_right(int distance) {

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        int tpi = 10;
        int total = (tpi * distance) / 2;
        int opposite = -(tpi * distance) / 2;
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (a != total && b != total && c != total && d != total) {
            a = fl.getCurrentPosition();
            b = fr.getCurrentPosition();
            c = bl.getCurrentPosition();
            d = br.getCurrentPosition();
            fl.setTargetPosition(total);
            fr.setTargetPosition(opposite);
            bl.setTargetPosition(total);
            br.setTargetPosition(opposite);

            fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            fl.setPower(speed);
            fr.setPower(speed);
            bl.setPower(speed);
            br.setPower(speed);
        }

        return true;

    }

    public void set_speed(double spee) {
        speed = spee;
    }


    @Override
    public void runOpMode() throws InterruptedException {

    }
}
