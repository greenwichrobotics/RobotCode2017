package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ultrasonic extends SubsystemBase {
	private static Ultrasonic instance;
	private AnalogInput ultrasonic = new AnalogInput(RobotMap.kUltrasonicPort);


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static Ultrasonic getInstance()
	{
		if (instance == null)
		{
			instance = new Ultrasonic();
		}
		return instance;
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
    	public double getcurrentDistance(){
    		return ultrasonic.getValue() * RobotMap.kValueToInches; 
    	}
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			
		}
    	
}

