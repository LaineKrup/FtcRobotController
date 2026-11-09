package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
public class BioBuzzShooterTeleOp {


@TeleOp(name = "BioBuzz Shooter TeleOp", group = "Linear OpMode")
public class BioBuzzShooterTeleOp extends LinearOpMode {

    // Declare the shooter pitching motor
    private DcMotor shooterMotor = null;

    @Override
    public void runOpMode() {
        // Initialize the shooter motor.
        // Make sure "shooter_motor" is the exact name typed into your Driver Station configuration.
        shooterMotor = hardwareMap.get(DcMotor.class, "shooter_motor");

        // CRITICAL: Set to FLOAT so the high-speed pitching wheel coasts to a stop safely
        // instead of instantly braking, which can strip motor gears.
        shooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Check if Gamepad 1 Left Bumper (Shoulder) is held down
            if (gamepad1.left_bumper) {
                // Spin the shooter wheel forward at full power
                shooterMotor.setPower(1.0);
            } else {
                // Let the wheel coast down when the button is released
                shooterMotor.setPower(0.0);
            }

            // Monitor the shooter status on the driver station screen
            telemetry.addData("Shooter Power", shooterMotor.getPower());
            telemetry.update();
        }
    }
}
