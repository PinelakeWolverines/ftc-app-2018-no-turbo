package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import android.util.Log;

import net.frogbots.ftcopmodetunercommon.opmode.TunableLinearOpMode;

@TeleOp
public class Testing extends TunableLinearOpMode {
    DcMotor leftBack;
    DcMotor rightBack;

@Override
    public void runOpMode(){
        waitForStart();
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        double position = 0;
        while (opModeIsActive()) {
            position = getDouble("power");
            telemetry.addData("Test", position);
            telemetry.update();
            Log.d("power", String.valueOf(position));
            sleep(500);
        }

    }
}
