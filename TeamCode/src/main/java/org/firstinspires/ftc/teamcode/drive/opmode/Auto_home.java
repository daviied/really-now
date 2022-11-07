package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Auto_home extends LinearOpMode {

    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;
    DistanceSensor x;
    DistanceSensor y;
    public void define(DcMotor front_left, DcMotor front_right, DcMotor back_left, DcMotor back_right, DistanceSensor a, DistanceSensor b) {

        fl = front_left;
        fr = front_right;
        bl = back_left;
        br = back_right;
        x = a;
        y = b;

        fl.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.REVERSE);


    }

    public boolean home() {


        while (x.getDistance(DistanceUnit.MM) >= 200) {

            fl.setPower(0.2);
            fr.setPower(-0.2);
            bl.setPower(0.2);
            br.setPower(-0.2);

        }

        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);




        return true;
    }

    public boolean homeb() {

        if (x.getDistance(DistanceUnit.MM) < 140) {
            while (y.getDistance(DistanceUnit.MM) >= 150) {

                fl.setPower(0.2);
                fr.setPower(0.2);
                bl.setPower(0.2);
                br.setPower(0.2);

            }

            fl.setPower(0);
            fr.setPower(0);
            bl.setPower(0);
            br.setPower(0);
        } else if (x.getDistance(DistanceUnit.MM) > 140) {
            while (y.getDistance(DistanceUnit.MM) >= 150) {

                fl.setPower(-0.2);
                fr.setPower(-0.2);
                bl.setPower(-0.2);
                br.setPower(-0.2);

            }

            fl.setPower(0);
            fr.setPower(0);
            bl.setPower(0);
            br.setPower(0);
        }





        return true;
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
