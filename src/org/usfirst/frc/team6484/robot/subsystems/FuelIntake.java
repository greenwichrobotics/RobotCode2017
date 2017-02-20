package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelIntake extends SubsystemBase {
	private static FuelIntake instance;
	private SpeedController intakeMotor1 = new Talon(RobotMap.intakeMotor1);
	private SpeedController intakeMotor2 = new Talon(RobotMap.intakeMotor2);
	// private static RobotDrive robotDrive;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public static FuelIntake getInstance() {
		if (instance == null) {
			instance = new FuelIntake();
		}
		return instance;
	}

	public void setMotor(double speed) {

		intakeMotor1.set(-speed);
		intakeMotor2.set(speed);

	}

	public boolean getMotor() {
		if (intakeMotor1.get() != 0.0 || intakeMotor2.get() != 0.0) {
			return true;
		} else {
			return false;
		}

	}

	protected void initialize() {
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public String getConsoleIdentity() {
		// TODO Auto-generated method stub
		return null;
	}
}