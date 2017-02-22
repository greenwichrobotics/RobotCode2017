package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends CommandBase {
	private boolean isDown;
	private boolean isExtended;
	private boolean toggleB;
	private boolean toggleA;

    public Gear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires((Subsystem) GearSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
    		isExtended = false;
    		isDown = false;
    		toggleB = true;
    		toggleA = true;
    	} catch (Exception ex) {
    		String temp = ex.getMessage();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (toggleB && OI.shooterStick.isBButtonPressed()) {
    		toggleB = false;
    		if (isExtended) {
    			GearSubsystem.releaseGear();
    			isExtended = false;
    		} else {
    			GearSubsystem.grabGear();
    			isExtended = true;
    		}
    	}else if (!OI.shooterStick.isBButtonPressed()){
    		toggleB = false;
    	}
    	if(toggleA && OI.shooterStick.isAButtonPressed()) {
    		if (isDown) {
    			GearSubsystem.liftUpArm();
    			isDown = false;
    		} else {
    			GearSubsystem.putDownArm();
    			isDown = true;
    		}
    	}else if (!OI.shooterStick.isAButtonPressed()){
    		toggleB = true;
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
