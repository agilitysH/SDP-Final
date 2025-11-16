package AbstractFactory.Xiaomi;

import AbstractFactory.SmartCamera;
import AbstractFactory.DeviceBase;

public class XiaomiCamera implements SmartCamera, DeviceBase {

    private String name = "Xiaomi Camera";
    private int power = 50;

    @Override
    public void turnOn() {
        System.out.println(name + " is recording now");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " stopped recording");
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
