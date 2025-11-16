package AbstractFactory.LG;

import AbstractFactory.SmartCamera;

public class LGCamera implements SmartCamera {
    @Override
    public void turnOn() {
        System.out.println("LGCamera is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("LGCamera is turned off");
    }
}
