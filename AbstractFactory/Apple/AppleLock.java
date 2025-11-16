package AbstractFactory.Apple;

import AbstractFactory.SmartLock;
import AbstractFactory.DeviceBase;

public class AppleLock implements SmartLock, DeviceBase {

    private String name = "Apple Lock";
    private int power = 5;

    @Override
    public void open() {
        System.out.println(name + " is opened");
    }

    @Override
    public void closed() {
        System.out.println(name + " is closed");
    }


    @Override
    public void turnOn() {
        System.out.println(name + " is activated");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is deactivated");
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
