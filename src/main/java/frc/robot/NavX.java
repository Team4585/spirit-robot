package frc.robot;

import javax.sound.sampled.SourceDataLine;

import com.kauailabs.navx.frc.AHRS;

//import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.SerialPort.Port;
import frc.robot.huskylib.src.RoboDevice;

/** Add your docs here. */
public class NavX extends RoboDevice{
    AHRS m_TheGyro = new AHRS(Port.kMXP);
    private double heading = getHeading();

    /**
     * @return
     */
    public double getHeading(){
        return m_TheGyro.getAngle();
    }
    
    public void print(){
        System.out.println(heading);
    }
    public void Initialize(){

    }
  
    
    public NavX(){
      super("NavX Sub System");
    }
  
    @Override
    public void doGatherInfo() {
      super.doGatherInfo();
  
    }
  
  
    @Override
    public void doActions() {
      super.doActions();
    }
  
}