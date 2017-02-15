package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.OI;

import org.usfirst.frc.team6484.robot.RobotMap;
import org.usfirst.frc.team6484.robot.control.XboxMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends SubsystemBase {
	private static Shooter instance;
	private SpeedController shooterMotor = new Talon(RobotMap.shooterMotor);
	private SpeedController feederMotor = new Talon(RobotMap.feederMotor);
	Encoder encoder = new Encoder(RobotMap.encoderPortA, RobotMap.encoderPortB, false, Encoder.EncodingType.k4X);
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
    //when lt is pressed shooter wheel spins up to speed
    //when rt is pressed feed balls into shooter
    //feeds balls in at 2 balls per 1 sec
    //press x for speed cycle between 1000-500

	public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
		}
		return instance;
	}

	public void setShooterMotor(double speed) {

		shooterMotor.set(speed);
	}
	
	public void setFeederMotor(double speed) {

		feederMotor.set(speed);
	}

	public boolean getMotor() {
		if (shooterMotor.get() != 0.0) {
			return true;
		} else {
			return false;
		}
		
	}
	public double getWheelSpeed(){
		return encoder.getRate();
	}
	
	protected void initialize() {
	}
	
	public void initDefaultCommand(){
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
		@Override
	public String getConsoleIdentity() {
		// TODO Auto-generated method stub
		return null;
	}
}
