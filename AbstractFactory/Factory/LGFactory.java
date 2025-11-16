package AbstractFactory.Factory;

import AbstractFactory.*;
import AbstractFactory.LG.*;

public class LGFactory implements Company {
    @Override
    public Device createTV() {
        return new LGTV();
    }

    @Override
    public Device createRefrigerator() {
        return new LGRefrigerator();
    }

    @Override
    public SmartThermostat createThermostat() {
        return new LGThermostat();
    }

    @Override
    public SmartCamera createCamera() {
        return new LGCamera();

    }

    @Override
    public SmartLight createLight() {
        return new LGLight();

    }

    @Override
    public SmartMusic createMusic() {
        return new LGMusic();
    }

    @Override
    public SmartLock createLock() {
        return new LGLock();
    }
}
