package AbstractFactory.LG;

import AbstractFactory.SmartThermostat;

public class LGThermostat implements SmartThermostat {
    @Override
    public void setTemperature(int temp) {
        System.out.println("Temperature set to " + temp);

    }
}
