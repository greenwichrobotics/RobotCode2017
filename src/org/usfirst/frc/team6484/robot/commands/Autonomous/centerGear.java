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
		requires((Subsystem) GearSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		try {
			isFinished = false;
			// isRunning = false;
			time = new Timer();
			driveTrain.tankDrive(0.0, 0.0);
			GearSubsystem.grabGear();
			time.start();
		} catch (Exception ex) {
			String temp = ex.getMessage();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

//		System.out.println(time.get());
		if (time.get() <= 4.5) {
//			System.out.println("Running");
			driveTrain.tankDrive(-0.55, -0.5);
		} else if (time.get() > 5.0 && time.get() < 6.0){
			GearSubsystem.releaseGear();
		}else if (time.get() > 6.0 && time.get() < 8.0){
			driveTrain.tankDrive(0.5, 0.55);
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
