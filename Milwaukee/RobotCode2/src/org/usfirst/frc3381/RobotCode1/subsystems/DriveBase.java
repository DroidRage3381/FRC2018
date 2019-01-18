// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future

package org.usfirst.frc3381.RobotCode1.subsystems;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc3381.RobotCode1.RobotMap;
import org.usfirst.frc3381.RobotCode1.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveBase extends Subsystem {
	
	public Double distancePlatform = RobotMap.prefs.getDouble( "Distance to Platform", 215.0);
	public Double turn90 = RobotMap.prefs.getDouble( "Turn 90", 88.0);
	public Double distanceOppositeFront = RobotMap.prefs.getDouble( "Distance to Opposite Scale Front", 200.0);
	public Double distanceScaleSide = RobotMap.prefs.getDouble( "Distance to Scale Side", 40.0);
	public Double liftScaleSetpoint = RobotMap.prefs.getDouble( "Lift Scale Setpoint", -39.5);
	public Double distanceScale = RobotMap.prefs.getDouble( "Distance to Middle of Scale", 300.0);
	public Double distanceScaleFront = RobotMap.prefs.getDouble( "Distance to Scale Front", 15.0);
	public Double distanceSwitch = RobotMap.prefs.getDouble( "Distance to Middle of Switch", 160.0);
	public Double distanceSwitchFront = RobotMap.prefs.getDouble( "Distance to Switch Front", 20.0);
	public Double liftSwitchSetpoint = RobotMap.prefs.getDouble( "Lift Switch Setpoint", -13.0);
	public Double distanceEndExchange = RobotMap.prefs.getDouble("Distane to End of the Exchange Zone", 58.2);
	public Double distanceCTPOtoCTPT = RobotMap.prefs.getDouble("Distance from Center Turn Point One to Center Turn Point Two", 89.0);
	public Double distanceCTPTtoSideSwitch = RobotMap.prefs.getDouble("Distance from Center Turn Point Two to Side of the Switch", 24.0);
	public Double turn45 = RobotMap.prefs.getDouble("Turn 45", 43.0);
	public Double distanceBackUp = -20.0;
	public Double liftZero = 0.0;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX talonSRXMasterRight = RobotMap.driveBaseTalonSRXMasterRight;
    private final WPI_VictorSPX victorSPXSlaveRight1 = RobotMap.driveBaseVictorSPXSlaveRight1;
    private final WPI_VictorSPX victorSPXSlaveRight2 = RobotMap.driveBaseVictorSPXSlaveRight2;
    private final WPI_TalonSRX talonSRXMasterLeft = RobotMap.driveBaseTalonSRXMasterLeft;
    private final WPI_VictorSPX victorSPXSlaveLeft1 = RobotMap.driveBaseVictorSPXSlaveLeft1;
    private final WPI_VictorSPX victorSPXSlaveLeft2 = RobotMap.driveBaseVictorSPXSlaveLeft2;
    private final DoubleSolenoid doubleSolenoidGearShift = RobotMap.driveBaseDoubleSolenoidGearShift;
    private final Encoder quadratureEncoderRight = RobotMap.driveBaseQuadratureEncoderRight;
    private final Encoder quadratureEncoderLeft = RobotMap.driveBaseQuadratureEncoderLeft;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    DifferentialDrive drive = new DifferentialDrive(talonSRXMasterRight, talonSRXMasterLeft);

    private final AHRS navx = RobotMap.navx;

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new CommandDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
    }

    // Put methods for controlling this subsystem here. 
    //Call these from Commands.
    
    // Main Drive
    public void arcadeDrive(Joystick stick){
    	double rotate = stick.getX();
    	double move = stick.getY();
    	drive.arcadeDrive(move, rotate * 0.85, true);
    }
    
    // Slaves the VictorSPXs to the TalonSRXs
    public void slave() {
	  // Right Side
	  victorSPXSlaveRight1.follow(talonSRXMasterRight);
	  victorSPXSlaveRight2.follow(talonSRXMasterRight);
	  // Left Side
	  victorSPXSlaveLeft1.follow(talonSRXMasterLeft);
	  victorSPXSlaveLeft2.follow(talonSRXMasterLeft);
   }
    
    // For autonomous driving
    public void tankDrive ( double left , double right ){
    	drive.tankDrive(-left, -right);
    }
    
    // For autonomous turning
    public void driveWithValues ( double moveValue , double rotateValue){
    	drive.arcadeDrive(moveValue, rotateValue);
    }
    
    // Sets the drive motors to open loop ramp, which in return sets the minimum amount of time that the motors require to get to full power
    public void ramp() {
    	double sec = RobotMap.prefs.getDouble("Ramping in Seconds", 0);
    	// The first value is the number of seconds to get to full power
    	talonSRXMasterRight.configOpenloopRamp(sec, 0);
    	talonSRXMasterLeft.configOpenloopRamp(sec, 0);
    	// The slaves will be set to the value of its master
    	victorSPXSlaveRight1.configOpenloopRamp(0, 0);
    	victorSPXSlaveRight2.configOpenloopRamp(0, 0);
  	  	victorSPXSlaveLeft1.configOpenloopRamp(0, 0);
  	  	victorSPXSlaveLeft2.configOpenloopRamp(0, 0);	
    }
    
    // Shit to high gear
    public void shiftFast() {
    	doubleSolenoidGearShift.set(DoubleSolenoid.Value.kForward);
    }
    
    // Shift to low gear
    public void shiftSlow() {
    	doubleSolenoidGearShift.set(DoubleSolenoid.Value.kReverse);
    }
    
    // Sets the drive motors to zero
    public void setToZero(){
    	talonSRXMasterRight.set(0);
    	talonSRXMasterLeft.set(0);
    }
    
    // Enables the TalonSRX braking mode
    public void enableDriveBraking() {
    	talonSRXMasterRight.setNeutralMode(NeutralMode.Coast);
    	talonSRXMasterLeft.setNeutralMode(NeutralMode.Coast);
    }
    
    // Disables the TalonSRX braking mode
    public void disableDriveBraking() {
    	talonSRXMasterRight.setNeutralMode(NeutralMode.Brake);
    	talonSRXMasterLeft.setNeutralMode(NeutralMode.Brake);
    }
    
    // Resets the right and left encoder values
    public void resetEncoder(){
    	// Use this when the encoder is plugged into the Robo-Rio
    	//quadratureEncoderRight.reset();
    	//quadratureEncoderLeft.reset();
    	
    	// Use this if the encoder is plugged into the TalonSRX
    	talonSRXMasterRight.getSensorCollection().setQuadraturePosition(0, 0);
//    	talonSRXMasterLeft.getSensorCollection().setQuadraturePosition(0, 0);
    	
    }
    
    // Resets the angle on the navx board
    public void resetYaw(){
    	navx.reset();
    }
    
    // Gets the right encoder value
    public double getRightEncodeDistance(){
    	// Use this when the encoder is plugged into the Robo-Rio
    	//return quadratureEncoderRight.getDistance();
    	
    	// Use this if the encoder is plugged into the TalonSRX
    	return talonSRXMasterRight.getSelectedSensorPosition(0);
    }
    
//    // Gets the left encoder value
//    public double getLeftEncodeDistance(){
//    	// Use this when the encoder is plugged into the Robo-Rio
//    	//return quadratureEncoderLeft.getDistance();
//    	
//    	// Use this if the encoder is plugged into the TalonSRX
//    	return talonSRXMasterLeft.getSelectedSensorPosition(0);
//    }
    
    // Gets the angle from the navx board
    public double getHeading(){
    	return navx.getAngle();
    }

}

