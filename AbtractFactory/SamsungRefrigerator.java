package AbtractFactory;

public class SamsungRefrigerator implements Device {
    @Override
    public String getName() {
        return "Samsung Refrigerator";
    }

    @Override
    public void turnOn() {
        System.out.println("Samsung Refrigerator started");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung Refrigerator stopped");
    }
}
