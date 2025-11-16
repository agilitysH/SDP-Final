package Observer;

public class TemperatureSensor implements Sensor {
    @Override
    public void update(Event event) {
        System.out.println("[Temperature Sensor] Event: " + event.getMessage());
    }

    @Override
    public String getName() {
        return "Temperature Sensor";
    }
}
