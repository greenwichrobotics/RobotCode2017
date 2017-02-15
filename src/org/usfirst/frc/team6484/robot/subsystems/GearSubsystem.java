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
	private DoubleSolenoid armSolenoid;
	private DoubleSolenoid pickupSolenoid;
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
		armSolenoid = new DoubleSolenoid(RobotMap.armSolenoidPort1, RobotMap.armSolenoidPort2);
		pickupSolenoid = new DoubleSolenoid(RobotMap.pickupSolenoidPort1, RobotMap.pickupSolenoidPort2);
	}
	
	public void liftUpArm(){
		armSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void putDownArm(){
		armSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void grabGear(){
		pickupSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void releaseGear(){
		pickupSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	@Override
	public String getConsoleIdentity() {
		// TODO Auto-generated method stub
		return null;
	}
}

