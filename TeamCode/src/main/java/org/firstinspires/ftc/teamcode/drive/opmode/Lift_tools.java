package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;

public class Lift_tools extends LinearOpMode {

    DcMotorEx lift;
    DigitalChannel button;
    int i;
    int x = 0;

    public boolean define(DcMotorEx l, DigitalChannel a) {
        lift = l;
        button = a;
        return true;
    }

    public boolean reset_encoder() {
        i = 1;
        while (i == 1) {
            lift.setTargetPosition(-100);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(0.85);
            if (!button.getState()) {
                i = 2;
                lift.setMode((DcMotor.RunMode.STOP_AND_RESET_ENCODER));
                lift.setTargetPosition(0);
                lift.setPower(0.85);

            }
        }

        while (i == 2) {
            lift.setTargetPosition(x);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(0.2);
            x++;
            if (button.getState()) {
                i = 3;
                lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }

        while (i == 3) {
            x = 0;
            lift.setTargetPosition(x);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(0.1);
            x--;
            if (!button.getState()) {
                i = 0;
                lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }


    return true;
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }
}
