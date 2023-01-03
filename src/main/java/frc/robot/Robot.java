// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private PWMSparkMax frontLeft = new PWMSparkMax(0);
  private PWMSparkMax rearLeft = new PWMSparkMax(1);
  private PWMSparkMax frontRight = new PWMSparkMax(4);
  private PWMSparkMax rearRight = new PWMSparkMax(3);

  private MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

  private XboxController controller = new XboxController(0);

  private PWMSparkMax intakeLift = new PWMSparkMax(5);
  private PWMSparkMax bunnyIntake = new PWMSparkMax(6);
  private PWMSparkMax tubeIntake = new PWMSparkMax(2);

  // private PWMSparkMax motor5 = new PWMSparkMax(5);
  // private PWMSparkMax motor6 = new PWMSparkMax(6);

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    drive.setDeadband(0.25);
    frontRight.setInverted(true);
    rearRight.setInverted(true);
    SmartDashboard.putNumber("Front Left", frontLeft.get());
    SmartDashboard.putNumber("Rear Left", rearLeft.get());
    SmartDashboard.putNumber("Front Right", frontRight.get());
    SmartDashboard.putNumber("Rear Right", rearRight.get());

    
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items
   * like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different
   * autonomous modes using the dashboard. The sendable chooser code works with
   * the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
   * chooser code and
   * uncomment the getString line to get the auto name from the text box below the
   * Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure
   * below with additional strings. If using the SendableChooser make sure to add
   * them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    drive.driveCartesian(controller.getLeftY(), controller.getLeftX(), -controller.getRightX());

    if (controller.getLeftBumperPressed()) {
      intakeLift.set(.1);
    } else {
      intakeLift.set(0);
    }
    if (controller.getRightBumperPressed()) {
      intakeLift.set(-.1);
    } else {
      intakeLift.set(0);
    }
    if (controller.getAButtonPressed()) {
      bunnyIntake.set(1);
    } else {
      bunnyIntake.set(0);
    }
    if (controller.getBButtonPressed()) {
      bunnyIntake.set(-1);
    } else {
      bunnyIntake.set(0);
    }
    if (controller.getXButtonPressed()) {
      tubeIntake.set(.1);
    } else {
      tubeIntake.set(0);
    }
    if (controller.getYButtonPressed()) {
      tubeIntake.set(-.15);
    } else {
      tubeIntake.set(0);
    }
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    drive.driveCartesian(0, 0, 0.25);
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
  }
}
