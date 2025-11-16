package Observer;

import java.util.List;

import AbstractFactory.Device;

public class EnergySensor implements Sensor {
    private List<Device> devices;
    private int powerLimit;

    public EnergySensor(List<Device> devices, int powerLimit) {
        this.devices = devices;
        this.powerLimit = powerLimit;
    }

    @Override
    public void update(Event event) {
        int total = 0;

        for (Device device : devices) {
            total += device.getPowerConsumption();
        }

        System.out.println("[Energy Sensor] Event: " + event.getMessage());
        System.out.println("[Energy Sensor] Current power usage: " + total + "W");

        if (total > powerLimit) {
            System.out.println("[Energy Sensor] WARNING: Power usage exceeded limit!");
        }
    }

    @Override
    public String getName() {
        return "Energy Sensor";
    }
}
