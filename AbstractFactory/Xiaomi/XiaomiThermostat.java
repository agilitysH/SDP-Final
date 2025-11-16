package AbstractFactory.Xiaomi;

import AbstractFactory.SmartThermostat;

public class XiaomiThermostat implements SmartThermostat {
    public void setTemperature(int temp) {
        System.out.println("Temperature set to " + temp);
    }
}
