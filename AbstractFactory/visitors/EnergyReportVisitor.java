package AbstractFactory.visitors;

import AbstractFactory.DeviceBase;
import AbstractFactory.SmartCamera;
import AbstractFactory.SmartLight;
import AbstractFactory.SmartLock;
import AbstractFactory.SmartMusic;
import AbstractFactory.SmartThermostat;

public class EnergyReportVisitor implements DeviceVisitor {
    private int totalEnergy = 0;
    private int deviceCount = 0;

    @Override
    public void visit(DeviceBase device) {
        int energy = device.getPowerConsumption();
        totalEnergy += energy;
        deviceCount++;
        System.out.println("📊 " + device.getName() + ": " + energy + "W" + getEnergyStatus(energy));
    }

    @Override
    public void visit(SmartCamera camera) {
        visit((DeviceBase) camera);
    }

    @Override
    public void visit(SmartLight light) {
        visit((DeviceBase) light);
    }

    @Override
    public void visit(SmartLock lock) {
        visit((DeviceBase) lock);
    }

    @Override
    public void visit(SmartMusic music) {
        visit((DeviceBase) music);
    }

    @Override
    public void visit(SmartThermostat thermostat) {
        visit((DeviceBase) thermostat);
    }

    private String getEnergyStatus(int energy) {
        if (energy == 0) return " 🟢 (OFF)";
        if (energy < 50) return " 🟡 (LOW)";
        if (energy < 100) return " 🟠 (MEDIUM)";
        return " 🔴 (HIGH)";
    }

    public void printReport() {
        System.out.println("\n📈 ENERGY REPORT:");
        System.out.println("==========================");
        System.out.println("📟 Total devices: " + deviceCount);
        System.out.println("⚡ Total consumption: " + totalEnergy + "W");
        System.out.println("📊 Average per device: " + (deviceCount > 0 ? totalEnergy/deviceCount : 0) + "W");

        if (totalEnergy > 500) {
            System.out.println("⚠️  WARNING: High energy consumption!");
        } else if (totalEnergy == 0) {
            System.out.println("💡 Excellent! All devices are turned off");
        } else {
            System.out.println("✅ Energy consumption is normal");
        }
    }

    public void reset() {
        totalEnergy = 0;
        deviceCount = 0;
    }
}