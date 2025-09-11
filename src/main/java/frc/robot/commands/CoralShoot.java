// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.ClawConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ClawWheelSubsystem;


public class CoralShoot extends Command {
  ClawSubsystem m_claw;
  ClawWheelSubsystem m_clawWheel;
  double setpoint;

  /** Creates a new Command. */
  public CoralShoot(ClawSubsystem claw) {
    m_claw = claw;

    //means this command will take priority over others using same subsystem
    addRequirements(m_claw);
   // addRequirements(m_clawWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_clawWheel.m_WheelMotor.set(-kWheelSpeed);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // fluctuate between +- 0.005 from kCoralDist
    System.out.println(m_claw.m_coralDist.getDistance().getValueAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_clawWheel.stopClawWheel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use a timeout

    return  (!(m_claw.m_coralDist.getDistance().getValueAsDouble()<=kCoralDist));
  }
}
