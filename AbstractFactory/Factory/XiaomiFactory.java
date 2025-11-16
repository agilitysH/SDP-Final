package AbstractFactory.Factory;

import AbstractFactory.*;
import AbstractFactory.Samsung.*;
import AbstractFactory.Xiaomi.*;

public class XiaomiFactory implements Company {
    @Override
    public Device createTV() {
        return new XiaomiTV();
    }

    @Override
    public Device createRefrigerator() {
        return new XiaomiRefrigerator();
    }

    @Override
    public SmartThermostat createThermostat() {
        return new XiaomiThermostat();
    }

    @Override
    public SmartMusic createMusic() {
        return new XiaomiMusic();
    }

    @Override
    public SmartLock createLock() {
        return new XiaomiLock();
    }

    @Override
    public SmartLight createLight() {
        return new XiaomiLight();
    }

    @Override
    public SmartCamera createCamera() {
        return new XiaomiCamera();
    }

}
