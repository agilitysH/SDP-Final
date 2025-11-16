package AbstractFactory.decorators;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;
public class EnergySaverDecorator extends DeviceBaseDecorator {
    private boolean energySaverEnabled = true;
    public EnergySaverDecorator(DeviceBase decoratedDevice) {
        super(decoratedDevice);
    }
    @Override
    public void turnOn() {
        if (energySaverEnabled) {
            System.out.println("🌿 EnergySaver mode is active for " + getName());
            System.out.println("💡 Device is working with optimal energy");
        }
        super.turnOn();
    }

    @Override
    public int getPowerConsumption() {
        int baseConsumption = super.getPowerConsumption();
        if (energySaverEnabled && baseConsumption > 0) {
            return (int)(baseConsumption * 0.75);
        }
        return baseConsumption;
    }
    public void enableEnergySaver(boolean enable) {
        this.energySaverEnabled = enable;
        System.out.println("🌿EnergySaver mode " + getName() + ": " +
                (enable ? "ON" : "OFF"));

        if (enable) {
            System.out.println("📊 Current consumption: " + getPowerConsumption() + "W");
        }
    }
    public boolean isEnergySaverEnabled() {
        return energySaverEnabled;
    }
    public void autoOptimize() {
        System.out.println("🔍 " + getName() + ":  Automatic optimization of energy consumption...");
        if (getPowerConsumption() > 100) {
            enableEnergySaver(true);
            System.out.println("✅ The energy saving mode is turned on automatically");
        }
    }
    @Override
    public String getName() {
        return decoratedDevice.getName() + " (Energy saving mode)";
    }
}