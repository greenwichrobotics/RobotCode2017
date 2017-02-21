package org.usfirst.frc.team6484.robot.commands.Autonomous;

import org.usfirst.frc.team6484.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class centerGear extends CommandBase {
	Timer time;
	boolean isFinished;
	public centerGear() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires((Subsystem) vision);
		requires((Subsystem) driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		try {
			isFinished = false;
			// isRunning = false;
			time = new Timer();
			driveTrain.arcadeDrive(0.0, 0.0);
		} catch (Exception ex) {
			String temp = ex.getMessage();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		time.start();
		if (time.get() <= 2){
//		driveTrain.arcadeDrive(0.2, Gyro.getCompensation(0.0, 1));
		} else{
//			vison.track
//			isFinished = Gyro.isCorrect(0.0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
