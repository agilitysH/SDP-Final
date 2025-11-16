package AbstractFactory.Apple;

import AbstractFactory.SmartLight;
import AbstractFactory.DeviceBase;

public class AppleLight implements SmartLight, DeviceBase {

    private String name = "Apple Light";
    private int power = 20;

    @Override
    public void turnOn() {
        System.out.println(name + " is on");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is off");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPowerConsumption() {
        return power;
    }
}
