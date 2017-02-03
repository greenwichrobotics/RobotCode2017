// ******************************************************
// Description: Controls the motors used for driving.
// Year: 2017
package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.RobotMap;
//import org.usfirst.frc.team6484.robot.commands.teleopDrive;

public class DriveSystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static DriveSystem instance;
	public static RobotDrive myDrive;
	private static OI oi = new OI();
	private static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
<<<<<<< HEAD

=======
	
	/*							NOTES / IDEAS
	 * BadRobot only corrects direction of driving if angle is off by 3 or more degrees
	 * 
	 * 
	 * 
	 */
	
	
>>>>>>> 9e242ef2a0bc3b873948faeb3d0b8abd5642180c
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
//		setDefaultCommand(new teleopDrive());
	}

	public static void Drive(double moveValue, double turnValue) {
		myDrive.arcadeDrive(moveValue, turnValue, true);
	}

	public static Boolean Turn(double moveValue, double turnAngle) {
		double setPoint;
		double angle;
		double turningValue;

		// direction = Math.copySign(rotateSpeed, turnAngle);
		setPoint = gyro.getAngle() + turnAngle;
		// do{
		turningValue = turnAngle * RobotMap.kP;
		System.out.println("setPoint = " + setPoint + " | currentAngle = " + gyro.getAngle());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(gyro.getAngle());
		// }while ( gyro.getAngle() < setPoint);

		// System.out.println("turningValue=" + turningValue);
		// double direction = Math.copySign(1, joystick.getY());
		// double compensation = direction * turningValue;

		// if (compensation > 0.1){
		// compensation = 0.1;
		// }
		// else if (compensation < -0.1 ){
		// compensation = -0.1;
		// }
		// System.out.println(compensation);
		// myRobot.drive(joystick.getY(), compensation);

		// do {
		//
		//
		//// myDrive.arcadeDrive(moveValue, direction);
		// }

		if (gyro.getAngle() > setPoint)
			return true;
		return false;

	}
}
