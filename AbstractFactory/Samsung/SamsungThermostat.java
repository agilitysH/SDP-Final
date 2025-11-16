package AbstractFactory.Samsung;

import AbstractFactory.SmartThermostat;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;

public class SamsungThermostat implements SmartThermostat, DeviceBase {

    private String name = "Samsung Thermostat";
    private int power = 10;
    private int temperature = 22;

    @Override
    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println(name + " temperature set to " + temperature);
    }

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
