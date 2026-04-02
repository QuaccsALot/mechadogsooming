package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class Climber extends Command {
  private final ShooterSubsystem climb;
  private final Timer timer = new Timer();
  // private final double distance;
  // private double encoderSetpoint;

public Climber(ShooterSubsystem climb) {
  this.climb = climb;
  // this.distance = distance;
//  addRequirements(climb);
}

@Override
public void initialize() {
  timer.reset();
  timer.start();
// encoderSetpoint = drive.getEncoderMeters() + distance;
}

@Override
public void execute() {
  climb.runClimber(0.6);
}

@Override
public void end(boolean interrupted) {
  climb.runClimber(0.0);
}

@Override
public boolean isFinished() {
  // if (drive.getEncoderMeters() >= encoderSetpoint) {
  //   return true;
  // else
  return timer.get() > 2.0;
}
}