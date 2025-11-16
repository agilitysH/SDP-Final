package AbstractFactory.Apple;

import AbstractFactory.SmartCamera;

public class AppleCamera implements SmartCamera {
    @Override
    public void turnOn() {
        System.out.println("Apple Camera is recording now");

    }

    @Override
    public void turnOff() {
        System.out.println("Apple Camera is stopped recording now");
    }
}
