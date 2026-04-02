package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveFwdCmd extends Command {
  private final DriveSubsystem drive;
  private final Timer timer = new Timer();

  // Adding in all the variables (not important)

public DriveFwdCmd(DriveSubsystem drive) {
  this.drive = drive;
  addRequirements(drive);
}

// 

@Override
public void initialize() {
  timer.reset();
  timer.start();
// encoderSetpoint = drive.getAverageEncoder() + distance;
}

@Override
public void execute() {
  if (timer.get() < 1.0) {
    drive.tankDrive(-0.5, -0.5);
  } else {
     drive.tankDrive(0, 0);
  }
}

@Override
public void end(boolean interrupted) {
  drive.stop();
}

@Override
public boolean isFinished() {
  if (timer.get() > 2.0) {
    return true;
  } else {
  return false;
}
}
}

// Generally done, only need to reconfigure with encoders during robotics

