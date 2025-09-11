// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
  // Maximum speed of the robot in meters per second, used to limit acceleration.

//  public static final class AutonConstants
//  {
//
//    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.7, 0, 0);
//    public static final PIDConstants ANGLE_PID       = new PIDConstants(0.4, 0, 0.01);
//  }

  public static final class DrivebaseConstants
  {
    public static final int kPigeon2ID = 13;
    // Hold time on motor brakes when disabled
  }

  public static class LiftConstants
  {
    public static final int kLift1ID = 17;
    public static final int kLift2ID = 18;
    public static final double kLiftRaiseSpeed = 0.65;
    public static final double kLiftLowerSpeed = 0.4;
    public static final double kLiftHangSpeed = 0.5;

    //Coral setpoints
    public static final double kLiftSetpoint1 = 0;
    public static final double kLiftSetpoint2 = 9.75;
    public static final double kLiftSetpoint3 = 22;
    public static final double kLiftSetpoint4 = 41.3;

    //Algae setpoints
    public static final double kAlgaeSetpoint1 = 16.5;
    public static final double kAlgaeSetpoint2 = 31;
    public static final double kAlgaeSetpoint3 = 45;


    public static final double kEps_lift = 2;
    public static final double kLiftSlowDown = 18;
  
    public static final int actuatorPWMID = 0;
  }

  public static class ClawConstants
  {
    public static final int kRotationalMotorID = 15;
    public static final int kWheelMotorID = 16;
    public static final int kCoralSensorID = 14;
    public static final int kClawEncoderID = 19;
    
    public static final double kRotationalSpeed = 0.3;
    public static final double kRotationalShootSpeed = 0.5;
    public static final double kWheelShootSpeed = 0.8;
    public static final double kWheelSpeed = 0.175;
    public static final double kEps_claw = 3;
    public static final double kAngleSlowDown = 3;

    public static final double kClawSetpoint1 = 0;
    public static final double kClawSetpoint2 = 4;
    public static final double kClawSetpoint5 = 6;
    public static final double kClawSetpoint3 = 19;
    public static final double kClawSetpoint4 = 0;

    public static final double kCoralDist = 0.055;
    public static final double kAddedRotations = 3.5;
  }

  public static class HangConstants
  {
    public static final int kHangMotorID = 19;
    public static final double kHangSpeed = -0.3;
    public static final int kLimitSwitchID = 0;
  }
}
