package AbstractFactory.Samsung;

import AbstractFactory.SmartMusic;

public class SamsungMusic implements SmartMusic {
    @Override
    public void turnOn() {
        System.out.println("Samsung Music is playing now");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung Music is off");
    }
}
