// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.LiftConstants.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.Constants.LiftConstants;

public class PID_SetLiftPosition extends Command {
  LiftSubsystem m_lift;
  double setpoint;
  double error;
  boolean inAuto;


  /** Creates a new Command. */
  public PID_SetLiftPosition(LiftSubsystem lift, double setpoint, boolean inAuto) {
    m_lift = lift;
    this.setpoint = setpoint;
    this.inAuto = inAuto;

    //means this command will take priority over others using same subsystem
    addRequirements(m_lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    
    
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Relative Lift Pos", m_lift.m_liftLeader.getPosition().getValueAsDouble());

    double maxSpeed;
      error = setpoint - m_lift.m_liftLeader.getPosition().getValueAsDouble();

      if (error > 0)
      {
        maxSpeed = kLiftRaiseSpeed;
      }
      else
      {
        maxSpeed = kLiftLowerSpeed;
      }
      double slowDown = kLiftSlowDown;

      double kp = 1/slowDown;
      double speedPercent = kp*error;
      double setSpeed = speedPercent*maxSpeed;
      
      if (Math.abs(setSpeed) > maxSpeed)
      {
        setSpeed = maxSpeed*Math.signum(setSpeed);
      }

      m_lift.m_liftLeader.set(setSpeed);
    }
      

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_lift.stopLift();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use a timeout
    
    //return (m_lift.m_liftLeader.getPosition().getValueAsDouble() < setpoint + kEps_claw)&&(m_lift.m_liftLeader.getPosition().getValueAsDouble() > setpoint - kEps_claw);
    
    return ((m_lift.m_liftLeader.getPosition().getValueAsDouble() < setpoint + LiftConstants.kEps_lift)&&(m_lift.m_liftLeader.getPosition().getValueAsDouble() > setpoint - LiftConstants.kEps_lift)&&inAuto);
  }
}
