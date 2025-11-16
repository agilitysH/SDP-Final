package AbstractFactory.Apple;

import AbstractFactory.SmartMusic;

public class AppleMusic implements SmartMusic {
    @Override
    public void turnOn() {
        System.out.println("Apple Music is playing on");
    }

    @Override
    public void turnOff() {
        System.out.println("Apple Music is playing off");
    }
}
