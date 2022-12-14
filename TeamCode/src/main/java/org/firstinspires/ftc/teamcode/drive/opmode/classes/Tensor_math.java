package org.firstinspires.ftc.teamcode.drive.opmode.classes;

import com.qualcomm.robotcore.hardware.DcMotorEx;



public class Tensor_math extends regular_math{

    int bolt = 0;
    int bulb = 1;
    int panel = 0;
    Auto_Positions vision = new Auto_Positions();
    public void def(DcMotorEx lf, DcMotorEx rf, DcMotorEx bl, DcMotorEx br) {
        vision.de(lf, rf, bl, br);
    }




    public void adding(String name) {
        if (name.equals("1 red")) {
            bolt++;
        } else if (name.equals("2 green")) {
            bulb++;
        } else if (name.equals("3 blue")) {
            panel++;
        }
    }

    public String detected() {
        if (bolt > bulb) {
            if (bolt > panel) {
                return "1 red";
            } else {
                return "3 blue";
            }
        } else if (bulb > bolt) {
            if (bulb > panel) {
                return "2 green";
            } else {
                return "3 blue";
            }
        } else if (panel > bulb && panel > bolt) {
            return "3 blue";
        } else {
            return "No objects detected OR no object detected most";

        }
    }

    public void find_position() {
        if (bolt > bulb) {
            if (bolt > panel) {
                vision.position_1();
            } else {
               vision.position_3();
            }
        } else if (bulb > bolt) {
            if (bulb > panel) {
                vision.position_2();
            } else {
                vision.position_3();
            }
        } else if (panel > bulb && panel > bolt) {
            vision.position_3();
        } else {
            vision.backup();
        }
    }
    public String toString() {

        return "1 bolt: " + bolt + "2 bulb: " + bulb + "3 panel: " + panel;
    }

}
