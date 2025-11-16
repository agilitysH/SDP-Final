package AbstractFactory.Xiaomi;

import AbstractFactory.SmartLight;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;  // ← Импорт

public class XiaomiLight implements SmartLight, DeviceBase {

    private String name = "Xiaomi Light";
    private int power = 20;

    @Override
    public void turnOn() {
        System.out.println(name + " is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is turned off");
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
