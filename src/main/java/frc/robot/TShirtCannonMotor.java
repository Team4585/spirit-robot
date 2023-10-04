package frc.robot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.huskylib.src.RoboDevice;


public class TShirtCannonMotor extends RoboDevice{

    private VictorSPX firing_motor; 
    VictorSPXControlMode controlMode;

    public TShirtCannonMotor(String deviceName) {
        super("Pneumatics Firing Mechanism Subsystem For the T-Shirt Cannon");
        
        
        //firing_motor = new VictorSPX(WiringConnections.THE_CANNON_ID);
    
    
    }
        
    public void Initialize(){

    }
    public void fire(){
        firing_motor.set(controlMode, 1);
    }
    @Override
    public void doGatherInfo(){
        super.doGatherInfo();
    }

    @Override
    public void doActions(){
        super.doActions();
    }
    

}



