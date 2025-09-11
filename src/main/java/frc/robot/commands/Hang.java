// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.HangConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HangSubsystem;


public class Hang extends Command {
  HangSubsystem m_hang;

  /** Creates a new Command. */
  public Hang(HangSubsystem hang) {
    m_hang = hang;

    //means this command will take priority over others using same subsystem
    addRequirements(m_hang);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_hang.setSpeed(kHangSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_hang.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use a timeout

    return  (m_hang.limitSwitch.get() == false);
  }
}
