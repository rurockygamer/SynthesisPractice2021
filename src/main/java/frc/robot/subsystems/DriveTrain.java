// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  //Create 4 motors
  private WPI_TalonSRX primaryLeftDrive;
  private WPI_TalonSRX secondaryLeftDrive;
  private WPI_TalonSRX primaryRightDrive;
  private WPI_TalonSRX secondaryRightDrive;

  //create 2 Speed Controller Groups
  private SpeedControllerGroup leftDrive;
  private SpeedControllerGroup rightDrive;

  //differential drive
  private DifferentialDrive drive;

  public DriveTrain() {
    //Finish Creating our motors and assign Motor Controller IDs
    primaryLeftDrive = new WPI_TalonSRX(Constants.leftDrivePrimary);
    secondaryLeftDrive = new WPI_TalonSRX(Constants.leftDriveSecondary);
    primaryRightDrive = new WPI_TalonSRX(Constants.rightDrivePrimary);
    secondaryRightDrive = new WPI_TalonSRX(Constants.rightDriveSecondary);

    //Finish creating our speed controller groups
    leftDrive = new SpeedControllerGroup(primaryLeftDrive, secondaryLeftDrive);
    rightDrive = new SpeedControllerGroup(primaryRightDrive, secondaryRightDrive);

    //Create our Differential Drive
    drive = new DifferentialDrive(leftDrive, rightDrive);

    //Set the mode of our motor controllers
    primaryLeftDrive.setNeutralMode(NeutralMode.Brake);
    secondaryLeftDrive.setNeutralMode(NeutralMode.Brake);
    primaryRightDrive.setNeutralMode(NeutralMode.Brake);
    primaryLeftDrive.setNeutralMode(NeutralMode.Brake);

    //Set one side inverted
    leftDrive.setInverted(true);

  }

  public void differentialDrive(double angle, double speed){
    drive.arcadeDrive(speed, angle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}