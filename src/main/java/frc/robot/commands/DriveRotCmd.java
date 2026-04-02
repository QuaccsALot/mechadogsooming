package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveRotCmd extends Command {
  private final DriveSubsystem drive;
  private final Timer timer = new Timer();

public DriveRotCmd(DriveSubsystem drive) {
  this.drive = drive;
  addRequirements(drive);
}

@Override
public void initialize() {
  timer.reset();
  timer.start();
}

@Override
public void execute() {
  drive.tankDrive(0.5, -0.5);
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

// The same as DriveFwdCmd, should be deprecated in favor of timer w/ rotation ingrained using DriveFwdCmd.java