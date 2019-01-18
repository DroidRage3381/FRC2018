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
import org.usfirst.frc3381.RobotCode1.Robot;

/**
 *
 */
public class CommandLightLED extends Command {
	
	Double flashRate;
	Double redValue;
	Double blueValue;
	Double yellowValue;
	Boolean redFullOn;
	Boolean blueFullOn;
	Boolean yellowFullOn;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public CommandLightLED() {
        setRunWhenDisabled(true);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lED);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	flashRate = 0.005;
    	redValue = 1.0;
    	blueValue = 0.0;
    	yellowValue = 0.0;
    	redFullOn = false;
    	blueFullOn = false;
    	yellowFullOn = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	
    	if(redValue <= 1.0 && !redFullOn) {
    		redValue = redValue + flashRate;
    		Robot.lED.setRed(redValue);
    	}
    	else if(redValue <= 0.0 && redFullOn) {
    		redFullOn = false;
    	}
    	else {
    		redFullOn = true;
    		redValue = redValue - flashRate;
    		Robot.lED.setRed(redValue);
    	}
    	
    	if(blueValue <= 1.0 && !blueFullOn) {
    		blueValue = blueValue + flashRate;
    		Robot.lED.setBlue(blueValue);
    	}
    	else if(blueValue <= 0.0 && blueFullOn) {
    		blueFullOn = false;
    	}
    	else {
    		blueFullOn = true;
    		blueValue = blueValue - flashRate;
    		Robot.lED.setBlue(blueValue);
    	}
    	
    	if(yellowValue <= 1.0 && !yellowFullOn) {
    		yellowValue = yellowValue + flashRate;
    		Robot.lED.setYellow(yellowValue);
    	}
    	else if(yellowValue <= 0.0 && yellowFullOn) {
    		yellowFullOn = false;
    	}
    	else {
    		yellowFullOn = true;
    		yellowValue = yellowValue - flashRate;
    		Robot.lED.setYellow(yellowValue);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}