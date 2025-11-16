package AbstractFactory.Xiaomi;

import AbstractFactory.SmartLight;

public class XiaomiLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("Xiaomi Light is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Xiaomi Light is turned off");
    }
}
