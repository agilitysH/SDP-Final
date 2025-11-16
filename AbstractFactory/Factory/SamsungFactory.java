package AbstractFactory.Factory;

import AbstractFactory.*;
import AbstractFactory.Samsung.*;

public class SamsungFactory implements Company {
    @Override
    public Device createTV() {
        return new SamsungTV();
    }

    @Override
    public Device createRefrigerator() {
        return new SamsungRefrigerator();
    }

    @Override
    public SmartCamera createCamera() {
        return new SamsungCamera();
    }

    @Override
    public SmartLock createLock() {
        return new SamsungLock();
    }

    @Override
    public SmartMusic createMusic() {
        return new SamsungMusic();
    }

    @Override
    public SmartLight createLight() {
        return new SamsungLight();
    }

    @Override
    public SmartThermostat createThermostat() {
        return new SamsungThermostat();
    }
}
