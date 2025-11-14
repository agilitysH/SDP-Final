package AbtractFactory;

public class SamsungTV implements Device {
    @Override
    public String getName() {
        return "Samsung TV";
    }

    @Override
    public void turnOn() {
        System.out.println("Samsung TV turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung TV turned off");
    }
}
