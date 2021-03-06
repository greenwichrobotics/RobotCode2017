
package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6484.robot.commands.*;
import org.usfirst.frc.team6484.robot.commands.Autonomous.Baseline;
import org.usfirst.frc.team6484.robot.commands.Autonomous.centerGear;
import org.usfirst.frc.team6484.robot.commands.Autonomous.leftGear;
import org.usfirst.frc.team6484.robot.commands.Autonomous.rightGear;
//import org.usfirst.frc.team6484.robot.commands.teleopDrive;
//import org.usfirst.frc.team6484.robot.subsystems.DriveSystem;
import org.usfirst.frc.team6484.robot.subsystems.ExampleSubsystem;
//import org.usfirst.frc.team6484.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {


	public static OI oi;
//	Compressor c = new Compressor(RobotMap.CompressorPort);

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
//	teleopDrive myTeleopDrive; 
//	Turn myTurn;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CommandBase.init();
		
		// chooser.addObject("My Auto", new MyAutoCommand())
		chooser.addDefault("Nothing", null);
		chooser.addObject("Center Gear", new centerGear());
		chooser.addObject("Left Gear", new leftGear());
		chooser.addObject("Right Gear", new rightGear());
		chooser.addObject("Baseline", new Baseline());
		SmartDashboard.putData("Auto mode", chooser);
		CameraServer.getInstance().startAutomaticCapture();
		// Start Compressor
//		c.setClosedLoopControl(true);
		
//		CameraServer.getInstance().startAutomaticCapture();
		System.out.println("hello");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
//		c.setClosedLoopControl(true);

	}

	@Override
	public void disabledPeriodic() {
//		c.setClosedLoopControl(true);
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			Scheduler.getInstance().add(autonomousCommand);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
//		if (myTeleopDrive != null)
//			myTeleopDrive.start();
//		 Scheduler.getInstance().add(new climber());
		 Scheduler.getInstance().add(new ArcadeDrive());
		 Scheduler.getInstance().add(new shooter());
		 Scheduler.getInstance().add(new intakeToggle());

		 Scheduler.getInstance().add(new Gear());
//		 c.setClosedLoopControl(false);
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
