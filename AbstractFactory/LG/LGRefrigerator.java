package AbstractFactory.LG;

import AbstractFactory.Device;

public class LGRefrigerator implements Device {
    private final int powerConsumption = 150;
    private boolean isOn = false;
    @Override 
    public int getPowerConsumption() {
        return isOn ? powerConsumption : 0;
    }
    @Override
    public String getName() {
        return "LG Refrigerator";
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }
}
