package AbstractFactory.Xiaomi;

import AbstractFactory.Device;

public class XiaomiTV implements Device {
    private final int powerConsumption = 120;
    private boolean isOn = false;
    @Override
    public int getPowerConsumption() {
        return isOn ? powerConsumption : 0;
    }
    @Override
    public String getName() {
        return "Xiaomi TV";
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
