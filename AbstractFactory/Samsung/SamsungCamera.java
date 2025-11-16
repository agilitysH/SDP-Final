package AbstractFactory.Samsung;
import AbstractFactory.SmartCamera;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;
public class SamsungCamera implements SmartCamera, DeviceBase {
    private String name = "Samsung Camera";
    private int power = 50;

    @Override
    public void turnOn() {
        System.out.println(name + " is recording now");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " stopped recording now");
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
