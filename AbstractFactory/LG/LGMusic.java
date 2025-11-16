package AbstractFactory.LG;

import AbstractFactory.SmartMusic;

public class LGMusic implements SmartMusic {
    @Override
    public void turnOn() {
        System.out.println("LG Music is playing on");
    }

    @Override
    public void turnOff() {
        System.out.println("LG Music is playing off");
    }
}
