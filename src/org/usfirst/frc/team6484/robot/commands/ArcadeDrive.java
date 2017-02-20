package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArcadeDrive extends CommandBase {
	private int direction;
	private double turn;
    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires((Subsystem) driveTrain);
    	requires((Subsystem) Gyro);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try{
    	driveTrain.arcadeDrive(0.0,0.0);
    	}catch(Exception ex){
    		String temp = ex.getMessage();
    		}
    	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	driveTrain.arcadeDrive(OI.driveStick.getY(), -OI.driveStick.getX());
//    	if (OI.driveStick.getX() == 0.0){
//    		direction = (int) Math.copySign(1, OI.driveStick.getTriggerValue());
//    		turn = Gyro.getCompensation(0.0, direction);
//    	}else{
//    		turn = -OI.driveStick.getLeftStickX();
//    	}
	    driveTrain.arcadeDrive(OI.driveStick.getTriggerValue(), -OI.driveStick.getLeftStickX());	
//    	System.out.println(OI.driveStick.getTriggerValue());
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
