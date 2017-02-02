package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private static DriveTrain instance;
	 private static RobotDrive robotDrive;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static DriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new DriveTrain();
        }
        return instance;
    }
    public void arcadeDrive(double forwardValue, double rotateValue){
    	
    	robotDrive.arcadeDrive(forwardValue, rotateValue);
    	
    }
    protected void initialize(){
    	robotDrive = new RobotDrive(RobotMap.rightMotor1, RobotMap.rightMotor2, RobotMap.leftMotor1, RobotMap.leftMotor2);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

