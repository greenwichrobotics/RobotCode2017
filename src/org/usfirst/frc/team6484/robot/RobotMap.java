package org.usfirst.frc.team6484.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// *********************************************************
	// Drive Motors
	public static int rightMotor1 = 0;
	public static int rightMotor2 = 1;
	public static int leftMotor1 = 2;
	public static int leftMotor2 = 3;
	
	// *********************************************************
	// Intake Motors
	public static int intakeMotor1 = 5;
	public static int intakeMotor2 = 6;
	
	// *********************************************************
	// Joystick
	
	public static int joystickPort0 = 0;
	
	// *********************************************************
	// Xbox Controller
	public static int XboxControllerPort = 1;
	
	// *********************************************************
	// Gyro
	 public static final double kP = 0.007;
	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
