package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private boolean toggleStart = true;
	private boolean toggleA;
	private boolean toggleB;
	private boolean toggleX;
	private boolean noRun;
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
			toggleStart = true;
			toggleB = true;
			toggleX = true;
			noRun = false;
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
		if (toggleStart && OI.driveStick.isStartButtonPressed()) {
			toggleStart = false;
			if (climber.getClimberMode()) {
				climber.setClimberMode(false);
			} else {
				climber.setClimberMode(true);
			}
		}else if (!OI.driveStick.isStartButtonPressed()){
			toggleStart = true;
		}

		if (!climber.getClimberMode()) {
			driveTrain.arcadeDrive(OI.driveStick.getTriggerValue(), (-OI.driveStick.getLeftStickX()/1.25));
		} else {
			// System.out.println(OI.driveStick.getTriggerValue());

			// Lift Robot Up
			if (toggleA && OI.driveStick.isAButtonPressed()) {
				toggleA = false;
				if (transformed) {
					climber.closeSolenoid();
					transformed = false;
				} else {
					climber.openSolenoid();
					transformed = true;
				}

			}else if (!OI.driveStick.isAButtonPressed()){
				toggleA = true;
			}
			// Start Climbing
			if (toggleB && OI.driveStick.isBButtonPressed()) {
				toggleB = false;
				if (!isRunning && !noRun) {
					// driveTrain.tankDrive(0.0, 0.5);
					isRunning = true;
				} else {
					// driveTrain.tankDrive(0.0, 0.0);
					isRunning = false;
				}
			}else if (!OI.driveStick.isBButtonPressed()){
				toggleB = true;
			}
			
			if (isRunning && climber.getClimberMode()) {
				driveTrain.tankDrive(0.0, 0.5);
			}
			// Lock Pin
			if (toggleX && OI.driveStick.isXButtonPressed()) {
				toggleX = false;
				if (locked) {
					climber.unLockPin();
					locked = false;
					noRun = false;
				} else {
					climber.lockPin();
					locked = true;
					isRunning = false;
					noRun = true;
				}
			}else if (!OI.driveStick.isXButtonPressed()){
				toggleX = true;
			}
			
		}
		SmartDashboard.putBoolean("ClimberMode", climber.getClimberMode());
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
