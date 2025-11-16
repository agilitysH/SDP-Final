package AbstractFactory.Samsung;

import AbstractFactory.SmartThermostat;

public class SamsungThermostat implements SmartThermostat {
    @Override
    public void setTemperature(int temp) {
        System.out.println("Temperature set to " + temp);
    }
}
