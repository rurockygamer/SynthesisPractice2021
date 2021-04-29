// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoDrive extends CommandBase {
  DriveTrain a_drive;
  double distance;
  double direction;
  //double int_angle;
  boolean flag;
  int counter = 0;

  public AutoDrive(DriveTrain subsystem, double dist) {
    flag = false;
    a_drive = subsystem;
    distance = dist;
    direction = distance/Math.abs(distance);
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    for(int i =0; i < 500; i++){

      a_drive.differentialDrive(0, 0.75);
      counter++; 

    }
    if(counter == 500){
      flag = true;
    }
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    a_drive.differentialDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return flag;
  }
}