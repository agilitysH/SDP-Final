package AbstractFactory.Samsung;

import AbstractFactory.SmartCamera;

public class SamsungCamera implements SmartCamera {
    @Override
    public void turnOn() {
        System.out.println("Samsung Camera is recording now");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung Camera is stopped recording now");
    }
}
