package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
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
    public void initEncoder(){
        armBase.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armJoint.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armBase.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armJoint.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runOpMode(){
        armBase = hardwareMap.dcMotor.get("armBase");
        armJoint = hardwareMap.dcMotor.get("armBase");
        extender = hardwareMap.dcMotor.get("extender");
        intake = hardwareMap.servo.get("intake");
        outtake = hardwareMap.servo.get("outtake");
        dumper = hardwareMap.servo.get("dumper");
        double position = 0;
        while (opModeIsActive())
            while (gamepad1.left_bumper == true){
                initEncoder();
                double armBaseCurrPosition = armBase.getCurrentPosition();
                double armJointCurrPosition = armJoint.getCurrentPosition();
                armBase.setPower(-0.8);
                armJoint.setPower(-0.4);
                dumper.setPosition(position+0.01);
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
