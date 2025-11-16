package AbstractFactory.LG;

import AbstractFactory.SmartThermostat;
import AbstractFactory.DeviceBase;

public class LGThermostat implements SmartThermostat, DeviceBase {

    private String name = "LG Thermostat";
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
}
