package AbstractFactory.Apple;

import AbstractFactory.SmartThermostat;

public class AppleThermostat implements SmartThermostat {
    @Override
    public void setTemperature(int temp) {
        System.out.println("Temperature set to " + temp);
    }
}
