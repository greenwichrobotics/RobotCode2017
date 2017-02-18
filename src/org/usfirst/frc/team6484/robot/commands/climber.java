package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class climber extends CommandBase {
	private boolean isRunning;
	private boolean transformed;
	private boolean locked;

	public climber() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires((Subsystem) Climber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		try {
			transformed = false;
			isRunning = false;
			locked = false;
			Climber.setClimberMotor(0.0);
		} catch (Exception ex) {
			String temp = ex.getMessage();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// Lift Robot Up 
		if (OI.driveStick.isAButtonPressed()) {
			if (transformed) {
				Climber.closeSolenoid();
				transformed = false;
				Timer.delay(.5);
			} else {
				Climber.openSolenoid();
				transformed = true;
				Timer.delay(.5);
			}
		}
		if (OI.driveStick.isBButtonPressed()) {
			if (!isRunning) {
				Climber.setClimberMotor(1.0);
				isRunning = true;
				Timer.delay(.5);
			} else {
				Climber.setClimberMotor(0.0);
				isRunning = false;
				Timer.delay(.5);
			}
		}
		if(OI.driveStick.isXButtonPressed()){
			if (Climber.getClimberMode()){
				if (locked){
					Climber.unLockPin();
				}else{
					Climber.lockPin();
				}
			}
		}
		if(OI.driveStick.isStartButtonPressed()){
			boolean isTrue = Climber.getClimberMode();
			Climber.setClimberMode(!isTrue);
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
