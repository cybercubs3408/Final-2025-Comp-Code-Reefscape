// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.ClawConstants.*;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.hardware.CANrange;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSubsystem extends SubsystemBase {
  public TalonFX m_RotationalMotor;

  //public SparkAbsoluteEncoder m_clawPosition;
  public CANrange m_coralDist;

  public ClawSubsystem() {
    m_RotationalMotor = new TalonFX(kRotationalMotorID);

    // m_clawPosition = new SparkAbsoluteEncoder(kClawEncoderID);
    m_coralDist = new CANrange(kCoralSensorID);
    

    //right is the leader, left is the follower
  }

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands. 
   */

  public Command raiseClaw() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setClawRotationSpeed(-kRotationalSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stopClawRotation();
        });
  }

  public Command lowerClaw() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setClawRotationSpeed(kRotationalSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stopClawRotation();
        });
  }

  // An accessor method to set the speed (technically the output percentage) of the launch wheel
  public void setClawRotationSpeed(double speed) {
    m_RotationalMotor.set(speed);
  }

  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stopClawRotation() {
    m_RotationalMotor.set(0);
  }   
}
