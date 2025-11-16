package AbstractFactory.decorators;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;
public abstract class DeviceBaseDecorator implements DeviceBase {
    protected DeviceBase decoratedDevice;
    public DeviceBaseDecorator(DeviceBase decoratedDevice) {
        this.decoratedDevice = decoratedDevice;
    }
    @Override
    public void turnOn() {decoratedDevice.turnOn();}
    @Override
    public void turnOff() {decoratedDevice.turnOff();}
    @Override
    public String getName() {return decoratedDevice.getName();}
    @Override
    public int getPowerConsumption() {return decoratedDevice.getPowerConsumption();}
    @Override
    public void accept(DeviceVisitor visitor) {decoratedDevice.accept(visitor);}
}