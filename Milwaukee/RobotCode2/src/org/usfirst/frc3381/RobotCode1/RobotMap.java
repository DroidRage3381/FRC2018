// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3381.RobotCode1;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveBaseTalonSRXMasterRight;
    public static WPI_VictorSPX driveBaseVictorSPXSlaveRight1;
    public static WPI_VictorSPX driveBaseVictorSPXSlaveRight2;
    public static WPI_TalonSRX driveBaseTalonSRXMasterLeft;
    public static WPI_VictorSPX driveBaseVictorSPXSlaveLeft1;
    public static WPI_VictorSPX driveBaseVictorSPXSlaveLeft2;
    public static DoubleSolenoid driveBaseDoubleSolenoidGearShift;
    public static Encoder driveBaseQuadratureEncoderRight;
    public static Encoder driveBaseQuadratureEncoderLeft;
    public static SpeedController wheelBlockGrabberSparkBlockGrabberRight;
    public static SpeedController wheelBlockGrabberSparkBlockGrabberLeft;
    public static SpeedController liftSparkLift;
    public static Encoder liftQuadratureEncoderLift;
    public static CANifier lEDCANifierLED;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static AHRS navx;
    public static Preferences prefs;

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveBaseTalonSRXMasterRight = new WPI_TalonSRX(0);
        
        
        driveBaseVictorSPXSlaveRight1 = new WPI_VictorSPX(1);
        
        
        driveBaseVictorSPXSlaveRight2 = new WPI_VictorSPX(2);
        
        
        driveBaseTalonSRXMasterLeft = new WPI_TalonSRX(3);
        
        
        driveBaseVictorSPXSlaveLeft1 = new WPI_VictorSPX(4);
        
        
        driveBaseVictorSPXSlaveLeft2 = new WPI_VictorSPX(5);
        
        
        driveBaseDoubleSolenoidGearShift = new DoubleSolenoid(6, 0, 1);
        LiveWindow.addActuator("DriveBase", "Double Solenoid Gear Shift", driveBaseDoubleSolenoidGearShift);
        
        driveBaseQuadratureEncoderRight = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveBase", "Quadrature Encoder Right", driveBaseQuadratureEncoderRight);
        driveBaseQuadratureEncoderRight.setDistancePerPulse(0.016362461736979167);
        driveBaseQuadratureEncoderRight.setPIDSourceType(PIDSourceType.kRate);
        driveBaseQuadratureEncoderLeft = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveBase", "Quadrature Encoder Left", driveBaseQuadratureEncoderLeft);
        driveBaseQuadratureEncoderLeft.setDistancePerPulse(0.016362461736979167);
        driveBaseQuadratureEncoderLeft.setPIDSourceType(PIDSourceType.kRate);
        wheelBlockGrabberSparkBlockGrabberRight = new Spark(1);
        LiveWindow.addActuator("WheelBlockGrabber", "Spark Block Grabber Right", (Spark) wheelBlockGrabberSparkBlockGrabberRight);
        wheelBlockGrabberSparkBlockGrabberRight.setInverted(true);
        wheelBlockGrabberSparkBlockGrabberLeft = new Spark(2);
        LiveWindow.addActuator("WheelBlockGrabber", "Spark Block Grabber Left", (Spark) wheelBlockGrabberSparkBlockGrabberLeft);
        wheelBlockGrabberSparkBlockGrabberLeft.setInverted(false);
        liftSparkLift = new Spark(0);
        LiveWindow.addActuator("Lift", "Spark Lift", (Spark) liftSparkLift);
        liftSparkLift.setInverted(false);
        liftQuadratureEncoderLift = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Lift", "Quadrature Encoder Lift", liftQuadratureEncoderLift);
        liftQuadratureEncoderLift.setDistancePerPulse(0.0409);
        liftQuadratureEncoderLift.setPIDSourceType(PIDSourceType.kDisplacement);
        lEDCANifierLED = new CANifier(8);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        navx = new AHRS (SPI.Port.kMXP);
        prefs = Preferences.getInstance();
        
    }
}
