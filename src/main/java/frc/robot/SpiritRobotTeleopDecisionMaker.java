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
  private double speed = 0.1;

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
      //System.out.println(m_limelight.isTargetFound());

      //Demo - rotate robot to target angle from Limelight
      
      targetHeading = m_limelight.getDegHorizontalFromTarget();
      //System.out.println("Deg. horizontal: " + m_limelight.getDegHorizontalFromTarget());
      //System.out.println(targetHeading);
      
      if (m_limelight.isTargetFound()){
        targetHeading = m_limelight.getDegHorizontalFromTarget();
        //System.out.println("Deg. horizontal: " + m_limelight.getDegHorizontalFromTarget());
        //System.out.println(targetHeading);
      }

      if (m_TheJoystick.triggerPushed()){
        if (Math.abs(navX.getHeading() - targetHeading) > acceptableRange){
          System.out.println(targetHeading / 100);
          //System.out.println(-Math.max(-10, Math.min(navX.getHeading() / 10, 10)) * speed);
          m_Chassis.setTargRotation(targetHeading / 100);
          //m_Chassis.setTargRotation(-Math.max(-1, Math.min(navX.getHeading() * speed / 10, 1)));
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
