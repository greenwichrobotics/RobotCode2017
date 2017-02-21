package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Vision extends SubsystemBase {
	private static Vision instance;
	private NetworkTable table;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		table = NetworkTable.getTable("SmartDashboard");
	}
	
	public static Vision getInstance() {
		if (instance == null) {
			instance = new Vision();
		}
		return instance;
	}
	public double getX(){
		return table.getNumber("cam1cx", 0.0);
	}
	public double getY(){
		return table.getNumber("cam1cy", 0.0);
	}

	@Override
	public String getConsoleIdentity() {
		// TODO Auto-generated method stub
		return null;
	}
}

