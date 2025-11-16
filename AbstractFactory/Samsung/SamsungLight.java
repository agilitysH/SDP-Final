package AbstractFactory.Samsung;

import AbstractFactory.SmartLight;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;

public class SamsungLight implements SmartLight, DeviceBase {

    private String name = "Samsung Light";
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
