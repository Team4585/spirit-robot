package frc.robot;

public class SpiritRobotTeleopDecisionMaker {
  private SpiritRobotJoystick m_TheJoystick = new SpiritRobotJoystick();
  private WeaponsJoystick m_weaponsJoystick = new WeaponsJoystick();


  private SpiritRobotChassis m_Chassis;
  private TShirtCannonMotor cannon;
  private PneumaticsCompressorVictor victor;




  SpiritRobotTeleopDecisionMaker(){

  }

  public void initialize(){
  }

  public void doDecisions(){

    // System.out.println("-- F/B: " + m_TheJoystick.getForwardBackwardValue() + 
    //                    "   S/S: " + m_TheJoystick.getSideToSideValue() + 
    //                    "   Rot: " + m_TheJoystick.getTwistValue());

      m_Chassis.setTargForwardBack(m_TheJoystick.getForwardBackwardValue());
      m_Chassis.setTargRotation(m_TheJoystick.getTwistValue());
      if (m_weaponsJoystick.button2Pushed()){
        cannon.fire();
      }
      if (m_weaponsJoystick.button3Pushed()){
        victor.fire();
      }


  }

  public void setChassis(SpiritRobotChassis TheChassis){
    m_Chassis = TheChassis;
  }


}
