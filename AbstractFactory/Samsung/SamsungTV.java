package AbstractFactory.Samsung;

import AbstractFactory.Device;

public class SamsungTV implements Device {
    private final int powerConsumption = 120;
    private boolean isOn = false;
    @Override
    public int getPowerConsumption() {
        return isOn ? powerConsumption : 0;
    }
    @Override
    public String getName() {
        return "Samsung TV";
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
