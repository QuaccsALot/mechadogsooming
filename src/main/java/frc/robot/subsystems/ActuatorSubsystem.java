package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController; // replace with your motor type
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; // example PWM motor

public class ActuatorSubsystem extends SubsystemBase {
  
  private final MotorController actuator1 = new PWMVictorSPX(0); // PWM port 0
  private final MotorController actuator2 = new PWMVictorSPX(1); // PWM port 1

  public ActuatorSubsystem() {
    // invert second motor if needed
    actuator2.setInverted(false);
  }

  /** 
   * Run both actuators at the same speed. 
   * Positive = extend, Negative = retract
   */
  public void runActuators(double speed) {
    actuator1.set(speed);
    actuator2.set(speed); // flip sign if second actuator needs inversion
  }

  /** Stop both actuators */
  public void stopActuators() {
    actuator1.set(0);
    actuator2.set(0);
  }
}