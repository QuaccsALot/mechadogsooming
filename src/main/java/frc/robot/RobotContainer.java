package frc.robot;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Autos;
import edu.wpi.first.wpilibj.PS4Controller;


public class RobotContainer {

  private final SendableChooser<Command> autoChooser = new SendableChooser<>();
  private final DriveSubsystem drive = new DriveSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public DriveSubsystem getDrive() {
    return drive;
  }



  // private boolean cintake = false;
  // private boolean pcIntake = false;

  // private boolean crintake = false;
  // private boolean pcrIntake = false;
private int intakeState = 0; // 1 = forward, -1 = reverse, 0 = off
private boolean pcIntake = false;
private boolean pcrIntake = false;

  private final PS4Controller controller =
      new PS4Controller(Constants.ControllerConstants.DRIVER_PORT);

  public void teleopPeriodic() {

    // drive.arcadeDrive(
    //     controller.getLeftY(),
    //     controller.getRightX()
    // );
table.getEntry("pipeline").setNumber(0); // your AprilTag pipeline
table.getEntry("ledMode").setNumber(3);  // force LEDs on
table.getEntry("camMode").setNumber(0);  // vision mode


double tx = table.getEntry("tx").getDouble(0.0);
  double ty = table.getEntry("ty").getDouble(0.0);
  double ta = table.getEntry("ta").getDouble(0.0);
  double tv = table.getEntry("tv").getDouble(0.0);

  SmartDashboard.putNumber("Limelight X", tx);
  SmartDashboard.putNumber("Limelight Y", ty);
  SmartDashboard.putNumber("Limelight Area", ta);
  SmartDashboard.putNumber("Limelight Detection", tv);
  
  
  shooter.runShooter(controller.getR2Axis());

  drive.tankDrive(
    controller.getLeftY(),
    controller.getRightY()
  );

  if (controller.getL1Button()) {
    shooter.runClimber(0.5);
  } else if (controller.getR1Button()) {
    shooter.runClimber(-0.5);
  } else {
    shooter.runClimber(0.0);
  }

// GPT code start =========================================================================================

  boolean tCircle = controller.getCircleButton();
boolean tCross = controller.getCrossButton();

// Toggle forward (Circle)
if (tCircle && !pcIntake) {
  if (intakeState == 1) {
    intakeState = 0;   // turn off
  } else {
    intakeState = 1;   // forward
  }
}

// Toggle reverse (Cross)
if (tCross && !pcrIntake) {
  if (intakeState == -1) {
    intakeState = 0;   // turn off
  } else {
    intakeState = -1;  // reverse
  }
}

// Save previous states
pcIntake = tCircle;
pcrIntake = tCross;

// Apply motor output
if (intakeState == 1) {
  shooter.runIntake(1.0);
} else if (intakeState == -1) {
  shooter.runIntake(-1.0);
} else {
  shooter.runIntake(0.0);
}


//gpt code end ==========================================================================================



//   boolean tCircleIntake = controller.getCircleButton();

//   if (tCircleIntake && !pcIntake) {
//     cintake = !cintake;
//   }

//   pcIntake = tCircleIntake;

//   if (cintake == true) {
//     shooter.runIntake(1.0);
//   } else if (cintake == false) {
//     shooter.runIntake(0.0);
//   }

// boolean tCrossIntake = controller.getCrossButton();

//   if (tCrossIntake && !pcrIntake) {
//     crintake = !crintake;
//   }

//   pcrIntake = tCrossIntake;

//   if (crintake == true) {
//     shooter.runIntake(-1.0);
//   } else if (crintake == false) {
//     shooter.runIntake(0.0);
//   }


  // Put autochoosers and smartdashboard into constructor, not into here
   autoChooser.setDefaultOption("Drive and Shoot", new Autos(drive, shooter));
  autoChooser.addOption("Do Nothing", null);
  SmartDashboard.putData("Auto Modes", autoChooser);
  


    // shooter.runPositionMotor(controller.getR1Button());
  }
}