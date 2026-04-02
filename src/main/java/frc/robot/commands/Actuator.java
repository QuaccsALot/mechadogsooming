// package frc.robot.commands;

// import frc.robot.subsystems.ShooterSubsystem;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.Command;

// public class Actuator extends Command {
//   private final ShooterSubsystem plow;
//   private final Timer timer = new Timer();
//   // private final double distance;
//   // private double encoderSetpoint;

// public Actuator(ShooterSubsystem plow, double distance) {
//   this.plow = plow;
//   // this.distance = distance;
// //   addRequirements(plow);
// }

// @Override
// public void initialize() {
//   timer.reset();
//   timer.start();
// // encoderSetpoint = drive.getEncoderMeters() + distance;
// }

// @Override
// public void execute() {
//   plow.runIntake(1);
// }

// @Override
// public void end(boolean interrupted) {
//   plow.runIntake(0.0);
// }

// @Override
// public boolean isFinished() {
//   // if (drive.getEncoderMeters() >= encoderSetpoint) {
//   //   return true;
//   // else
//   return timer.get() > 2.0;
// }
// }

// //actually connect to the actuator, have to change actuator to motor instead of pwm

