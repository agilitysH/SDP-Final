package AbstractFactory.Samsung;

import AbstractFactory.SmartMusic;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;

public class SamsungMusic implements SmartMusic, DeviceBase {

    private String name = "Samsung Music";
    private int power = 30;

    @Override
    public void turnOn() {
        System.out.println(name + " is playing now");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is off");
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
