package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
public class ArmCode extends LinearOpMode {
    DcMotor armBase;
    DcMotor armJoint;
    DcMotor extender;
    Servo intake;
    Servo dumper;
    Servo outtake;
    public void cutPower(){
        armJoint.setPower(0);
        armBase.setPower(0);
        extender.setPower(0);
    }
    public void runOpMode(){
        double position = 0;
        while (opModeIsActive())
            while (gamepad1.left_bumper == true){
                armBase.setPower(-0.6);
                armJoint.setPower(-0.6);
                dumper.setPosition(position+0.1);
            }
            cutPower();
            while (gamepad1.left_trigger == 1){
                armBase.setPower(0.6);
                armJoint.setPower(0.6);
            }
            cutPower();
            while (gamepad1.dpad_down == true){
                intake.setPosition(0.5);
                outtake.setPosition(0.5);
            }
            cutPower();
            while (gamepad1.right_bumper == true){
                extender.setPower(0.7);
            }
            cutPower();
    }
}
