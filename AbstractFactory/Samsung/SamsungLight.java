package AbstractFactory.Samsung;

import AbstractFactory.SmartLight;

public class SamsungLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("Samsung Light is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung Light is turned off");
    }
}
