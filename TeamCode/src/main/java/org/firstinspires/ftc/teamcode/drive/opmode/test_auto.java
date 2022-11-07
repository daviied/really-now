package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
@Disabled

@Autonomous
public class test_auto extends LinearOpMode {
    DcMotorEx front_left;
    DcMotorEx front_right;
    DcMotorEx back_left;
    DcMotorEx back_right;



    public void runOpMode() throws InterruptedException {
        front_left = hardwareMap.get(DcMotorEx.class, "0");
        front_right = hardwareMap.get(DcMotorEx.class, "1");
        back_left = hardwareMap.get(DcMotorEx.class, "2");
        back_right = hardwareMap.get(DcMotorEx.class, "3");
        Robot robot = new Robot();
        robot.define(front_left, front_right, back_left, back_right);
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        boolean e = false;
        boolean f = false;
        boolean g = false;


        waitForStart();
        robot.set_speed(0.3);
        //on start

        while (b == false) {
            b = robot.drive_forward(48);
        }
        Thread.sleep(3000);
       // wait(250);

        //
       // wait(250);


       // wait(250);


       // wait(250);
        while (f == false) {
          f = robot.strafe_left(24);
        }

       // wait(250);

       // wait(250);
    }
}
