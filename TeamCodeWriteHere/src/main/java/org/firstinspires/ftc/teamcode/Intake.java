package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "BioBuzz TeleOp", group = "Linear OpMode")
public class BioBuzzTeleOp extends LinearOpMode {

    // declare intake motor in code
    private DcMotor intakeMotor = null;

    @Override
    public void runOpMode() {
        // Initialize hardware variables
        //  "intake_motor" matches name in robot configuration file pls in the drivers hub, check which cable (#1, #2..) is hooked up to probably have to name in driver hub
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");

        // zero power behavior to BRAKE /FLOAT?
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Game to start (driver presses PLAY)
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Check if Gamepad 1 Left Bumper (Shoulder) is held down
            if (gamepad1.left_bumper) {
                // Spin the intake wheel forward at .9 power
                intakeMotor.setPower(0.90);
            } else {
                // Stop spinning when the button is released
                intakeMotor.setPower(0.0);
            }

            // telemetry to monitor the intake status on the driver station
            telemetry.addData("Intake Power", intakeMotor.getPower());
            telemetry.update();
        }
    }
}

public class Intake {
}
