// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3381.RobotCode1.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3381.RobotCode1.Robot;
import org.usfirst.frc3381.RobotCode1.RobotMap;

/**
 *
 */
public class AutonomousCommandTurnRight extends Command {
	
	Double turnAngle;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    public AutonomousCommandTurnRight(Double turnAngle) {
    	
    	this.turnAngle = turnAngle;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveBase);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.driveBase.enableDriveBraking();
    	Robot.driveBase.slave();
    	Robot.driveBase.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	SmartDashboard.putNumber("Turn Angle", Robot.driveBase.getHeading());
    	SmartDashboard.putNumber("Right Drive Encoder", Robot.driveBase.getRightEncodeDistance());
//    	SmartDashboard.putNumber("Left Drive Encoder", Robot.driveBase.getLeftEncodeDistance());
    	
    	Double turnSpeed = RobotMap.prefs.getDouble( "Turn Speed", 0.5);
    	
    	Robot.driveBase.driveWithValues(0, turnSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	// Returns true when
    	return Robot.driveBase.getHeading() >= turnAngle;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveBase.setToZero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
