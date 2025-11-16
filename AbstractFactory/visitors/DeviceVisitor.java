package AbstractFactory.visitors;

import AbstractFactory.DeviceBase;
import AbstractFactory.SmartCamera;
import AbstractFactory.SmartLight;
import AbstractFactory.SmartLock;
import AbstractFactory.SmartMusic;
import AbstractFactory.SmartThermostat;

public interface DeviceVisitor {
    void visit(DeviceBase device);
    void visit(SmartCamera camera);
    void visit(SmartLight light);
    void visit(SmartLock lock);
    void visit(SmartMusic music);
    void visit(SmartThermostat thermostat);
}