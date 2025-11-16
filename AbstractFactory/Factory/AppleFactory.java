package AbstractFactory.Factory;

import AbstractFactory.*;
import AbstractFactory.Apple.*;

public class AppleFactory implements Company {
    @Override
    public Device createTV() {
        return new AppleTV();
    }

    @Override
    public Device createRefrigerator() {
        return new AppleRefrigerator();
    }

    @Override
    public SmartThermostat createThermostat() {
        return new AppleThermostat();
    }

    @Override
    public SmartMusic createMusic() {
        return new AppleMusic();
    }

    @Override
    public SmartLock createLock() {
        return new AppleLock();
    }

    @Override
    public SmartLight createLight() {
        return new AppleLight();
    }

    @Override
    public SmartCamera createCamera() {
        return new AppleCamera();
    }
}
