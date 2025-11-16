package AbstractFactory.LG;

import AbstractFactory.SmartCamera;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;

public class LGCamera implements SmartCamera, DeviceBase {

    private String name = "LG Camera";
    private int power = 50;

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
