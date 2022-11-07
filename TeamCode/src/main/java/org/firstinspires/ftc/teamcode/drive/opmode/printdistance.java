package org.firstinspires.ftc.teamcode.drive.opmode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
    public class printdistance extends LinearOpMode {
        DistanceSensor distance;
        DistanceSensor distancea;


        @Override
        public void runOpMode() {
            // Get the distance sensor and motor from hardwareMap
            distance = hardwareMap.get(DistanceSensor.class, "i2c 0");
            distancea = hardwareMap.get(DistanceSensor.class, "i2c 1");


            // Loop while the Op Mode is running
            waitForStart();
            while (opModeIsActive()) {
               telemetry.addData("port 0 >", distance.getDistance(DistanceUnit.MM));
               telemetry.addData("port 1 >", distancea.getDistance(DistanceUnit.MM));
               telemetry.update();

            }
        }
    }


