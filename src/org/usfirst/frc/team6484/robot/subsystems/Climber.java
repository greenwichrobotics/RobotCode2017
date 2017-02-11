package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.RobotMap;
import org.usfirst.frc.team6484.robot.control.XboxMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	/*
	 * CLIMBER SYSTEM wait until rope is in position and button is pushed
	 * 
	 * engage pnuematic piston to raise side of robot where drive motor is used
	 *
	 * engage pnuematic piston that pushes rope claw into position
	 *
	 * engage motor that winds robot claw to start climbing
	 *
	 * stop once robots reaches top (time is set)
	 */
	
	private static Climber instance;
	private SpeedController climberMotor1 = new Talon(RobotMap.rightMotor1);
	private SpeedController climberMotor2 = new Talon(RobotMap.rightMotor2);
	Compressor c = new Compressor(RobotMap.CompressorPort);
	DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.solenoidPort1, RobotMap.solenoidPort2);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public static Climber getInstance() {
		if (instance == null) {
			instance = new Climber();
		}
		return instance;
	}

	public void setClimberMotor(double speed) {

		climberMotor1.set(speed);
		climberMotor2.set(speed);
	}

	public boolean getMotor() {
		if (climberMotor1.get() != 0.0 || climberMotor2.get() != 0.0) {
			return true;
		} else {
			return false;
		}
	}
	public void openSolenoid(){
		solenoid.set(DoubleSolenoid.Value.kForward);
		Timer.delay(1);
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	public void closeSolenoid(){
		solenoid.set(DoubleSolenoid.Value.kReverse);
		Timer.delay(1);
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	protected void initialize() {
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public String getConsoleIdentity() {
		// TODO Auto-generated method stub
		return null;
	}

}
