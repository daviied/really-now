package org.firstinspires.ftc.teamcode.drive.opmode.utilities;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.drive.opmode.classes.Robot;

@Autonomous
public class Tortis_testing extends LinearOpMode {
    DcMotorEx front_left;
    DcMotorEx front_right;
    DcMotorEx back_left;
    DcMotorEx back_right;
    Robot robot = new Robot();
    @Override

    public void runOpMode() throws InterruptedException {

        front_left = hardwareMap.get(DcMotorEx.class, "0");
        front_right = hardwareMap.get(DcMotorEx.class, "1");
        back_left = hardwareMap.get(DcMotorEx.class, "2");
        back_right = hardwareMap.get(DcMotorEx.class, "3");


        robot.define(front_left, front_right, back_left, back_right);

        robot.strafe_left(24);
    }
}
