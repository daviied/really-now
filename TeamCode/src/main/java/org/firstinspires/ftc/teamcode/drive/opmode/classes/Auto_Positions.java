package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;


import org.firstinspires.ftc.teamcode.drive.opmode.classes.Robot;

@Autonomous
public class Auto_Positions extends LinearOpMode {

    Robot robot = new Robot();
    public void de(DcMotorEx lf, DcMotorEx rf, DcMotorEx bl, DcMotorEx br) {
        robot.define(lf, rf, bl, br);
    }
    public void position_1() {
        robot.drive_forward(5);
        robot.strafe_left(26);
        robot.turn_left(20);
        robot.drive_forward(42);
        robot.strafe_right(2);
    }

    public void position_2() {

        robot.drive_forward(5);
        robot.strafe_left(26);
        robot.drive_forward(50);
        robot.strafe_right(23);
    }

    public void position_3() {
        robot.drive_forward(2);
        robot.strafe_right(30);
        robot.turn_right(20);
        robot.drive_forward(32);
    }

    public void backup() {

        robot.drive_forward(1);
        robot.strafe_left(10);
        robot.drive_forward(20);
    }


    @Override
    public void runOpMode() throws InterruptedException {

    }
}
