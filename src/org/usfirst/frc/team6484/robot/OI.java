package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team6484.robot.commands.ExampleCommand;
import org.usfirst.frc.team6484.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
//	 public static Joystick driveStick;
	 public static XboxController driveStick;
	 public double forwardValue;
	 public static boolean isXbox;
	 static Button button;
	 
	 public static void init() {
			
			driveStick = new XboxController(RobotMap.XboxControllerPort);
			button = new JoystickButton(driveStick, 0);
		}
	 public OI(){
//		 driveStick = new Joystick(RobotMap.joystickPort0);
//	 }
	// Button button = new JoystickButton(stick, buttonNumber);

	

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
		 button.whenPressed(new intakeToggle());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
}
