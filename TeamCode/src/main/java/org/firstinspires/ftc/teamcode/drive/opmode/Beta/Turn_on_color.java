package org.firstinspires.ftc.teamcode.drive.opmode.Beta;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Turn_on_color extends LinearOpMode {
    DistanceSensor distance;
    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    RevColorSensorV3 a;


    @Override
    public void runOpMode() {
        // Get the distance sensor and motor from hardwareMap
        distance = hardwareMap.get(DistanceSensor.class, "i2c 0");
        front_left = hardwareMap.get(DcMotor.class, "0");
        front_right = hardwareMap.get(DcMotor.class, "1");
        back_left = hardwareMap.get(DcMotor.class, "2");
        back_right = hardwareMap.get(DcMotor.class, "3");


        // Loop while the Op Mode is running
        waitForStart();
        while (opModeIsActive()) {

            telemetry.addData("> ", a.getLightDetected());


        }
    }
}
