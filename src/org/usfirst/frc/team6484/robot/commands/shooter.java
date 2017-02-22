package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class shooter extends CommandBase {
	Timer time = new Timer();
	public shooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires( (Subsystem) Shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try{
    		Shooter.setShooterMotor(0.0);
    		Timer time = new Timer();
			time.start();
    		}catch(Exception ex){
    			String temp = ex.getMessage();
    	}
    }

    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    		Shooter.setShooterMotor(OI.shooterStick.getLeftTrigger());
    		// Feeder motor Code
    		// if (Shooter.getWheelSpeed() >= 100){
//    			Shooter.setFeederMotor(1.0);
//    			Timer.delay(.2);
//    			Shooter.setFeederMotor(0.0);
    		if (OI.shooterStick.getRightTrigger() >= .5){
    			Shooter.setFeederMotor(1.0);
//    			if (time.get() < 0.6)
//    				Shooter.setFeederMotor(1.0);
//    			else if (time.get() > 0.6 && time.get() < 0.8)
//    				Shooter.setFeederMotor(0.0); 
//    			else if(time.get() > 0.8){
//    				Shooter.setFeederMotor(0.0); 
//    				time.reset();
//    			}
    		}else{
    			Shooter.setFeederMotor(0.0);
    		}
//    }
//    		if (OI.shooterStick.getRightTrigger() >= .5){
//    			
//    			Shooter.setFeederMotor(1.0);
//    			Timer.delay(.2);
//    			Shooter.setFeederMotor(0.0);
//    			Timer.delay(.2);
//    		}
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
