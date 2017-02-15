package org.usfirst.frc.team6484.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6484.robot.subsystems.*;
import org.usfirst.frc.team6484.robot.OI;

/**
 *
 */
public abstract class CommandBase extends Command {

//	Declare all Subsystems here
	public static DriveTrain driveTrain;
	public static FuelIntake fuelIntake;
	public static Shooter Shooter;
	public static Climber Climber;
	public static GearSubsystem GearSubsystem;
	
   

    // Called just before this Command runs the first time
    public static void init() {
    	OI.init();
    	
//    Initialize subsystems here
        driveTrain = driveTrain.getInstance();
        fuelIntake = FuelIntake.getInstance();
        Shooter = Shooter.getInstance();
        Climber = Climber.getInstance();
        GearSubsystem = GearSubsystem.getInstance();
    }
    
    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
    protected abstract void initialize();

}
