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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.ConditionalCommand;
import org.usfirst.frc3381.RobotCode1.Robot;

/**
 *
 */
public class AutonomousCommandRight extends ConditionalCommand {
	
	String gameData;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCommandRight() {
      super(new AutonomousCommandScaleRight(), new AutonomousCommandRightBackup());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR

    }

    @Override
    protected boolean condition(){

    	// Keeps running until game data is received
    	do {
    		gameData = DriverStation.getInstance().getGameSpecificMessage();
    	} while (gameData.length() == 0);
    	
    	// Double checks to make sure game data was received
    	if(gameData.length() > 0) {
    	}
    	
    	// Checks the game data to see which program to run and then selects the corresponding program
    	if(gameData.charAt(1) == 'R') {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
}
