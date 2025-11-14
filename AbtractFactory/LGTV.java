package AbtractFactory;

public class LGTV implements Device {
    @Override
    public String getName() {
        return "LG TV";
    }

    @Override
    public void turnOn() {
        System.out.println("LG TV turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LG TV turned OFF");
    }
}
