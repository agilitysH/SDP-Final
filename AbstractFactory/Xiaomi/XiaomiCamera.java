package AbstractFactory.Xiaomi;

import AbstractFactory.SmartCamera;

public class XiaomiCamera implements SmartCamera {
    @Override
    public void turnOn() {
        System.out.println("Xiaomi camera is recording now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Xiaomi camera is stopped recording");
    }
}
