//package org.usfirst.frc.team6484.robot.subsystems;
//
//import org.usfirst.frc.team6484.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class CompressorSystem extends SubsystemBase {
//	private static CompressorSystem instance;
//	Compressor c;
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//   
//    	
//    }
//    public static CompressorSystem getInstance() {
//		if (instance == null) {
//			instance = new CompressorSystem();
//		}
//		return instance;
//	}
//
//	@Override
//	protected void initialize() {
//		// TODO Auto-generated method stub
//		c = new Compressor(RobotMap.CompressorPort);
//	}
//	
//	public void stopCompressor(){
//		c.setClosedLoopControl(false);
//	}
//	public void startCompressor(){
//		c.setClosedLoopControl(true);
//	}
//	@Override
//	public String getConsoleIdentity() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//
