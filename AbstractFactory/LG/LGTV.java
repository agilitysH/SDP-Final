package AbstractFactory.LG;

import AbstractFactory.Device;

public class LGTV implements Device {
    private final int powerConsumption = 100;
    private boolean isOn = false;
    @Override 
    public int getPowerConsumption() {
        return isOn ? powerConsumption : 0;
    }
    @Override
    public String getName() {
        return "LG TV";
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("LG TV turned OFF");
    }
}
