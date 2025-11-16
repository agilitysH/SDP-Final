package AbstractFactory;

public class SamsungRefrigerator implements Device {
    private final int powerConsumption = 200;
    private boolean isOn = false;
    @Override
    public int getPowerConsumption() {
        return isOn ? powerConsumption : 0;
    }
    @Override
    public String getName() {
        return "Samsung Refrigerator";
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }
}
