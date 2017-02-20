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
	public static Climber climber;
	public static GearSubsystem GearSubsystem;
	public static Gyro Gyro;
	
   

    // Called just before this Command runs the first time
    public static void init() {
    	OI.init();
    	
//    Initialize subsystems here
        driveTrain = DriveTrain.getInstance();
        fuelIntake = FuelIntake.getInstance();
        Shooter = org.usfirst.frc.team6484.robot.subsystems.Shooter.getInstance();
        climber = org.usfirst.frc.team6484.robot.subsystems.Climber.getInstance();
        GearSubsystem = org.usfirst.frc.team6484.robot.subsystems.GearSubsystem.getInstance();
        Gyro = org.usfirst.frc.team6484.robot.subsystems.Gyro.getInstance();
    }
    
    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
    protected abstract void initialize();

}
