package AbstractFactory.visitors;

import AbstractFactory.DeviceBase;
import AbstractFactory.SmartCamera;
import AbstractFactory.SmartLight;
import AbstractFactory.SmartLock;
import AbstractFactory.SmartMusic;
import AbstractFactory.SmartThermostat;

public class DiagnosticVisitor implements DeviceVisitor {

    @Override
    public void visit(DeviceBase device) {
        System.out.println("🔍 diagnostics: " + device.getName());
        System.out.println("   📊 Consumption: " + device.getPowerConsumption() + "W");
        System.out.println("   🟢 Status: " + (device.getPowerConsumption() > 0 ? "Active" : "Not Active"));
        System.out.println("   🏷️  Type: Basic Device");
    }

    @Override
    public void visit(SmartCamera camera) {
        System.out.println("📷 CAMERA DIAGNOSTICS: " + camera.getName());
        System.out.println("   📊 Consumption: " + camera.getPowerConsumption() + "W");
        System.out.println("   🟢 Status: " + (camera.getPowerConsumption() > 0 ? "Recording" : "Waiting"));
        System.out.println("   📹 Quality: 1080p HD");
        System.out.println("   🌙 Night vision: YES");
    }

    @Override
    public void visit(SmartLight light) {
        System.out.println("💡 DIAGNOSIS OF LIGHT: " + light.getName());
        System.out.println("   📊 Consumption: " + light.getPowerConsumption() + "W");
        System.out.println("   🟢 Status: " + (light.getPowerConsumption() > 0 ? "ON" : "OFF"));
        System.out.println("   💡 Brightness: 80%");
        System.out.println("   🎨 Color temperature: 4000K");
    }

    @Override
    public void visit(SmartLock lock) {
        System.out.println("🔒 SMART LOCK DIAGNOSTICS: " + lock.getName());
        System.out.println("   📊 Power Consumption: " + lock.getPowerConsumption() + "W");
        System.out.println("   🟢 Status: " + (lock.getPowerConsumption() > 0 ? "LOCKED" : "UNLOCKED"));
        System.out.println("   🔋 Battery: 85%");
        System.out.println("   🔐 Security Level: HIGH");
    }

    @Override
    public void visit(SmartMusic music) {
        System.out.println("🎵 AUDIO SYSTEM DIAGNOSTICS: " + music.getName());
        System.out.println("   📊 Power Consumption: " + music.getPowerConsumption() + "W");
        System.out.println("   🟢 Status: " + (music.getPowerConsumption() > 0 ? "PLAYING" : "PAUSED"));
        System.out.println("   🔊 Volume: 60%");
        System.out.println("   🎶 Source: Spotify");
    }

    @Override
    public void visit(SmartThermostat thermostat) {
        System.out.println("🌡️ THERMOSTAT DIAGNOSTICS: " + thermostat.getName());
        System.out.println("   📊 Power Consumption: " + thermostat.getPowerConsumption() + "W");
        System.out.println("   🟢 Status: " + (thermostat.getPowerConsumption() > 0 ? "ACTIVE" : "STANDBY"));
        System.out.println("   🌡️ Current Temperature: 22°C");
        System.out.println("   🎯 Target Temperature: 21°C");
    }
}