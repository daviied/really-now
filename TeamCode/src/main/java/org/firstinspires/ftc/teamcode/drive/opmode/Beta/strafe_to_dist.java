package org.firstinspires.ftc.teamcode.drive.opmode.Beta;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class strafe_to_dist extends LinearOpMode {

    DistanceSensor distance;
    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;



    @Override
    public void runOpMode() {
        // Get the distance sensor and motor from hardwareMap
        distance = hardwareMap.get(DistanceSensor.class, "i2c 3");
        front_left = hardwareMap.get(DcMotor.class, "0");
        front_right = hardwareMap.get(DcMotor.class, "1");
        back_left = hardwareMap.get(DcMotor.class, "2");
        back_right = hardwareMap.get(DcMotor.class, "3");


        // Loop while the Op Mode is running
        waitForStart();
        while (opModeIsActive()) {
            while (distance.getDistance(DistanceUnit.MM) > 100) {
                telemetry.addData("port 0 >", distance.getDistance(DistanceUnit.MM));
                telemetry.update();
                front_left.setPower(0.5);
                front_right.setPower(0.5);
                back_left.setPower(0.5);
                back_right.setPower(0.5);
            }

            front_left.setPower(0);
            front_right.setPower(0);
            back_left.setPower(0);
            back_right.setPower(0);

        }
    }
}
