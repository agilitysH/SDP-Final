package AbstractFactory.decorators;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;
public class SmartScheduleDecorator extends DeviceBaseDecorator {
    private String scheduleOn;
    private String scheduleOff;
    public SmartScheduleDecorator(DeviceBase decoratedDevice) {
        super(decoratedDevice);
    }
    @Override
    public void turnOn() {
        System.out.println("⏰ " + getName() + " enabled on schedule");
        super.turnOn();
    }
    @Override
    public void turnOff() {
        System.out.println("⏰ " + getName() + " turned off according to schedule");
        super.turnOff();
    }
    public void setSchedule(String onTime, String offTime) {
        this.scheduleOn = onTime;
        this.scheduleOff = offTime;
        System.out.println("📅 Schedule for" + getName() + ": ON for " + onTime + ", OFF by " + offTime);
    }

    public void checkSchedule(String currentTime) {
        if (currentTime.equals(scheduleOn)) {
            System.out.println("🕒 " + currentTime + " - time to turn on" + getName());
            turnOn();
        } else if (currentTime.equals(scheduleOff)) {
            System.out.println("🕒 " + currentTime + " - time to turn off " + getName());
            turnOff();
        }
    }

    public String getSchedule() {
        return "ON: " + (scheduleOn != null ? scheduleOn : "not installed") +
                ", OFF: " + (scheduleOff != null ? scheduleOff : "not installed");
    }

    @Override
    public String getName() {
        return decoratedDevice.getName() + " (Smart Schedule)";
    }
}