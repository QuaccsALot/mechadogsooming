package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Autos extends SequentialCommandGroup {

  public Autos(DriveSubsystem drive, ShooterSubsystem shooter) {

    addCommands(
      new DriveFwdCmd(drive),
//  Just drives forward for a second, will wait for a second before the shooter command starts
      new Shooter(shooter)
      // Shoots for 5 seconds, ends and Robot will wait until teleop starts
    );
  }
}

/* Autonomous plan
First: Start at Placement 1 or 5
- Identify (AprilTag) viewable from Trench
 -> Engage autonomous code to move forward an turn
  -> Identify (AprilTag) to determine distance forward
    -> Rotate relative to AprilTag
      -> Move through Trench, Identify apirltag, rotate and shoot
 */