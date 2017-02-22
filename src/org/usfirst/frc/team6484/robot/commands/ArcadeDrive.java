package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArcadeDrive extends CommandBase {
	private int direction;
	private double turn;
	boolean climbMode = false;
	private boolean isRunning;
	private boolean transformed;
	private boolean locked;
	private boolean noRun = false;

	public ArcadeDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires((Subsystem) driveTrain);
		requires((Subsystem) climber);
//		requires((Subsystem) Gyro);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		try {
			transformed = false;
			isRunning = false;
			locked = false;
			climber.closeSolenoid();
			climber.unLockPin();
			driveTrain.arcadeDrive(0.0, 0.0);
		} catch (Exception ex) {
			String temp = ex.getMessage();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// driveTrain.arcadeDrive(OI.driveStick.getY(), -OI.driveStick.getX());
		// if (OI.driveStick.getX() == 0.0){
		// direction = (int) Math.copySign(1, OI.driveStick.getTriggerValue());
		// turn = Gyro.getCompensation(0.0, direction);
		// }else{
		// turn = -OI.driveStick.getLeftStickX();
		// }
		if (OI.driveStick.isStartButtonPressed()) {
			if (climber.getClimberMode()) {
				climber.setClimberMode(false);
				Timer.delay(.5);
			} else {
				climber.setClimberMode(true);
				Timer.delay(.5);
			}
		}

		if (!climber.getClimberMode()) {
			driveTrain.arcadeDrive(OI.driveStick.getTriggerValue(), -OI.driveStick.getLeftStickX());
		} else {
			// System.out.println(OI.driveStick.getTriggerValue());

			// Lift Robot Up
			if (OI.driveStick.isAButtonPressed()) {
				if (transformed) {
					climber.closeSolenoid();
					transformed = false;
					Timer.delay(.5);
				} else {
					climber.openSolenoid();
					transformed = true;
					Timer.delay(.5);
				}

			}
			// Start Climbing
			if (OI.driveStick.isBButtonPressed()) {
				if (!isRunning && !noRun) {
					// driveTrain.tankDrive(0.0, 0.5);
					isRunning = true;
					Timer.delay(.5);
				} else {
					// driveTrain.tankDrive(0.0, 0.0);
					isRunning = false;
					Timer.delay(.5);
				}
			}
			if (isRunning && climber.getClimberMode()) {
				driveTrain.tankDrive(0.0, 0.7);
			}
			// Lock Pin
			if (OI.driveStick.isXButtonPressed()) {
				if (locked) {
					climber.unLockPin();
					locked = false;
					noRun = false;
					Timer.delay(.5);
				} else {
					climber.lockPin();
					locked = true;
					isRunning = false;
					noRun = true;
					Timer.delay(.5);
				}
			}
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
