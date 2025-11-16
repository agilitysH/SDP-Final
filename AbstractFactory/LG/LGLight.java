package AbstractFactory.LG;

import AbstractFactory.SmartLight;

public class LGLight implements SmartLight {
    public void turnOn() {
        System.out.println("LG Light is on");
    }

    @Override
    public void turnOff() {
        System.out.println("LG Light is off");
    }
}
