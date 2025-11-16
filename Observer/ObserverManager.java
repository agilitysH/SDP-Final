package Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager {
    private final List<Sensor> sensors = new ArrayList<>();

    public void registerSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public void notifyObservers(Event event) {
        for (Sensor sensor : sensors) {
            sensor.update(event);
        }
    }
}
