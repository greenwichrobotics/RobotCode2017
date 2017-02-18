package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSubsystem extends SubsystemBase {
	private static GearSubsystem instance;
	private DoubleSolenoid GearLift;
	private DoubleSolenoid GearGrab;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    //
    }
    public static GearSubsystem getInstance() {
		if (instance == null) {
			instance = new GearSubsystem();
		}
		return instance;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		GearLift = new DoubleSolenoid(RobotMap.GearLiftU, RobotMap.GearLiftD);
		GearGrab = new DoubleSolenoid(RobotMap.GearGrabF, RobotMap.GearGrabB);
	}
	
	public void liftUpArm(){
		GearLift.set(DoubleSolenoid.Value.kForward);
	}
	public void putDownArm(){
		GearLift.set(DoubleSolenoid.Value.kReverse);
	}
	public void grabGear(){
		GearGrab.set(DoubleSolenoid.Value.kForward);
	}
	public void releaseGear(){
		GearGrab.set(DoubleSolenoid.Value.kReverse);
	}
	@Override
	public String getConsoleIdentity() {
		// TODO Auto-generated method stub
		return null;
	}
}

