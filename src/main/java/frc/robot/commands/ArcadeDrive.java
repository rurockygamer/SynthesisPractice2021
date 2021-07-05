package main.java.frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoDrive extends CommandBase {
private DriveTrain m_DriveTrain;
private XboxController m_xboxController;
private Joystick m_LogitechController;
  public ArcadeDrive(DriveTrain subsystem, XboxController xboxController) {
    m_DriveTrain = subsystem;
    m_xboxController = xboxController;
    addRequirements(subsystem);
  }
  //overloaded constructor for the logitech joystick, but possibly pointless 
  //as the logitech is read as an xbox controller
  public ArcadeDrive(DriveTrain subsystem, Joystick joystick) {
    m_DriveTrain = subsystem;
    m_LogitechController = joystick;
    addRequirements(subsystem);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DriveTrain.differentialDrive(m_xboxController.getRawAxis(Constants.rJoystickXAxis), m_xboxController.getRawAxis(Constants.lJoystickYAxis));
    
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
  }
}