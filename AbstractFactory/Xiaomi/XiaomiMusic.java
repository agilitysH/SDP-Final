package AbstractFactory.Xiaomi;

import AbstractFactory.SmartMusic;

public class XiaomiMusic implements SmartMusic {
    @Override
    public void turnOn() {
        System.out.println("Xiaomi Music is playing on");
    }
    @Override
    public void turnOff() {
        System.out.println("Xiaomi Music is playing off");
    }
}
