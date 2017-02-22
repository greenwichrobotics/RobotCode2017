package org.usfirst.frc.team6484.robot.commands.Autonomous;

import org.usfirst.frc.team6484.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class leftGear extends CommandBase {
	Timer time;
	boolean isFinished;
    public leftGear() {
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
			time.start();
			driveTrain.arcadeDrive(0.0, 0.0);
			GearSubsystem.grabGear();
		} catch (Exception ex) {
			String temp = ex.getMessage();
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if (time.get() <= 4.5) {
//			System.out.println("Running");
			driveTrain.tankDrive(-0.55, -0.5);
		} else if (time.get() > 8.0 && time.get() < 10.0){
			driveTrain.tankDrive(0.4, -0.4);
		} else if (time.get() > 13.0 && time.get() < 15.0){
			driveTrain.tankDrive(-0.55, -0.5);
		} else if (time.get() > 16.0 && time.get() < 17.0){
			GearSubsystem.releaseGear();
//		}else if (time.get() > 8.0 && time.get() < 9.0){
//			driveTrain.tankDrive(0.5, 0.55);
		}else{
			driveTrain.tankDrive(0.0, 0.0);
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
