package AbtractFactory;

public class LGRefrigerator implements Device {
    @Override
    public String getName() {
        return "LG Refrigerator";
    }

    @Override
    public void turnOn() {
        System.out.println("LG Refrigerator started");
    }

    @Override
    public void turnOff() {
        System.out.println("LG Refrigerator stopped");
    }
}
