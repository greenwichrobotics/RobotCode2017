package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class intakeToggle extends CommandBase {
	private boolean isRunning;
	private boolean toggleY;

	public intakeToggle() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires((Subsystem) fuelIntake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		try {
			isRunning = false;
			fuelIntake.setMotor(0.0);
			toggleY = true;
		} catch (Exception ex) {
			String temp = ex.getMessage();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (toggleY && OI.shooterStick.isYButtonPressed()) {
			toggleY = false;
			if (!isRunning) {
				fuelIntake.setMotor(1.0);
				isRunning = true;
			} else {
				fuelIntake.setMotor(0.0);
				isRunning = false;
			}
		}else if (!OI.shooterStick.isYButtonPressed()){
			toggleY = true;
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
