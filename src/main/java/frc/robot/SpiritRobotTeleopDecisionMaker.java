package frc.robot;

public class SpiritRobotTeleopDecisionMaker {
  private SpiritRobotJoystick m_TheJoystick = new SpiritRobotJoystick();
  private WeaponsJoystick m_weaponsJoystick = new WeaponsJoystick();


  private SpiritRobotChassis m_Chassis;
  private TShirtCannonMotor cannon;
  private PneumaticsCompressorVictor victor;

  private NavX navX = new NavX();
  private Limelight m_limelight = new Limelight();


  //Demo - rotate robot to angle
  private double targetHeading = 0;
  private double acceptableRange = 0.1;
  private double speed = 0.05;

  SpiritRobotTeleopDecisionMaker(){

  }

  public void initialize(){
    
  }

  public void doDecisions(){

    // System.out.println("-- F/B: " + m_TheJoystick.getForwardBackwardValue() + 
    //                    "   S/S: " + m_TheJoystick.getSideToSideValue() + 
    //                    "   Rot: " + m_TheJoystick.getTwistValue());

      
      if (m_weaponsJoystick.button2Pushed()){
        cannon.fire();
      }
      if (m_weaponsJoystick.button3Pushed()){
        victor.fire();
      }

      //System.out.println(navX.getHeading());
      System.out.printf("Deg. horizontal: %d\n", m_limelight.getDegHorizontalFromTarget());


      //Demo - rotate robot to target angle
      if (m_TheJoystick.triggerPushed()){
        if (Math.abs(navX.getHeading()) > acceptableRange){
          m_Chassis.setTargRotation(-Math.max(-10, Math.min(navX.getHeading() / 10, 10)) * speed);
        }
      } else {
        m_Chassis.setTargForwardBack(m_TheJoystick.getForwardBackwardValue());
        m_Chassis.setTargRotation(m_TheJoystick.getTwistValue());  
      }
  }

  public void setChassis(SpiritRobotChassis TheChassis){
    m_Chassis = TheChassis;
  }


}
