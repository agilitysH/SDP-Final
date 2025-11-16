package Observer;

public class MotionSensor implements Sensor {
    @Override
    public void update(Event event) {
        System.out.println("[Motion Sensor] Event: " + event.getMessage());
    }

    @Override
    public String getName() {
        return "Motion Sensor";
    }
}
