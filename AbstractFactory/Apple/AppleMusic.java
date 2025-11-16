package AbstractFactory.Apple;

import AbstractFactory.SmartMusic;
import AbstractFactory.DeviceBase;

public class AppleMusic implements SmartMusic, DeviceBase {

    private String name = "Apple Music";
    private int power = 30;

    @Override
    public void turnOn() {
        System.out.println(name + " is playing on");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is playing off");
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
