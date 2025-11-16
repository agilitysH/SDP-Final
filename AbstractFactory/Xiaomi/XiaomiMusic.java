package AbstractFactory.Xiaomi;

import AbstractFactory.SmartMusic;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;

public class XiaomiMusic implements SmartMusic, DeviceBase {

    private String name = "Xiaomi Music";
    private int power = 30;

    @Override
    public void turnOn() {
        System.out.println(name + " is playing on");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is playing off");
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
