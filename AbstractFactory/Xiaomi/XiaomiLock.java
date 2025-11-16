package AbstractFactory.Xiaomi;

import AbstractFactory.SmartLock;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;  // ← Импорт

public class XiaomiLock implements SmartLock, DeviceBase {

    private String name = "Xiaomi Lock";
    private int power = 5;

    @Override
    public void open() {
        System.out.println(name + " is open");
    }

    @Override
    public void closed() {
        System.out.println(name + " is closed");
    }

    @Override
    public void turnOn() {
        System.out.println(name + " is activated");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is deactivated");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPowerConsumption() {
        return power;
    }
    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
