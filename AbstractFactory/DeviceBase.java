package AbstractFactory;

import AbstractFactory.visitors.DeviceVisitor;

public interface DeviceBase {
    void turnOn();
    void turnOff();
    String getName();
    int getPowerConsumption();
    void accept(DeviceVisitor visitor);
}