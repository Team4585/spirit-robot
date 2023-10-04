package frc.robot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.huskylib.src.RoboDevice;


public class PneumaticsCompressorVictor extends RoboDevice{
    private VictorSPX compressor_motor; 
    VictorSPXControlMode controlMode;
    public PneumaticsCompressorVictor(String deviceName) {
        super("Victor-Driven Compressor for the T-Shirt Cannon");
        //compressor_motor = new VictorSPX(WiringConnections.THE_COMPRESSOR_ID);
    }
    public void Initialize(){

    }
    public void fire(){
        compressor_motor.set(controlMode, 1);
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



