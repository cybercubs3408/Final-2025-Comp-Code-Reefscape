// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.HangConstants.*;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangSubsystem extends SubsystemBase {
  public SparkMax m_HangMotor;
  public DigitalInput limitSwitch;

  public HangSubsystem() 
  {
    m_HangMotor = new SparkMax(kHangMotorID, MotorType.kBrushless);
    limitSwitch = new DigitalInput(kLimitSwitchID);
  }

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands. 
   */

  public Command hangCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setSpeed(kHangSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }

  public void setSpeed(double speed) {
    m_HangMotor.set(speed);
  }

  public void stop() {
    m_HangMotor.set(0);
  }
        
}
