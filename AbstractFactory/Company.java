package AbstractFactory;

public interface Company {
    Device createTV();
    Device createRefrigerator();
    SmartCamera createCamera();
    SmartLight createLight();
    SmartThermostat createThermostat();
    SmartMusic createMusic();
    SmartLock createLock();

}
