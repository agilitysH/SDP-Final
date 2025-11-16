package AbstractFactory.Apple;

import AbstractFactory.SmartLight;

public class AppleLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("Apple Light is on");
    }

    @Override
    public void turnOff() {
        System.out.println("Apple Light is off");
    }
}
