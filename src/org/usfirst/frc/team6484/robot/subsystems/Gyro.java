package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Gyro extends SubsystemBase {
	private static Gyro instance;
	private ADXRS450_Gyro gyro;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static Gyro getInstance()
    {
        if (instance == null)
        {
            instance = new Gyro();
        }
        return instance;
    }
	 protected void initialize(){
	    	gyro = new ADXRS450_Gyro();
	    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	@Override
	public String getConsoleIdentity() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isCorrect(double setPoint){
		if (gyro.getAngle()> (setPoint - 3.0) && gyro.getAngle() < (setPoint + 3.0)){
			return true;
		}else{
			return false;
		}
	}
	public double getCompensation(double setPoint, int direction){
		double compensation = .2;
		double angle = gyro.getAngle();
		System.out.println(angle);
		double turningValue = (setPoint - angle) * RobotMap.kP;
		System.out.println(turningValue);
//		double direction = Math.copySign(1, joystick.getY());
		compensation = direction * turningValue;
//		System.out.println(compensation);
//		myRobot.drive(joystick.getY(), compensation);
		return compensation;
	
	}
}

