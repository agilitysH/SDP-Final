package AbstractFactory.visitors;

import AbstractFactory.DeviceBase;
import AbstractFactory.SmartCamera;
import AbstractFactory.SmartLight;
import AbstractFactory.SmartLock;
import AbstractFactory.SmartMusic;
import AbstractFactory.SmartThermostat;

public class MaintenanceVisitor implements DeviceVisitor {

    @Override
    public void visit(DeviceBase device) {
        System.out.println("🛠️ MAINTENANCE: " + device.getName());
        System.out.println("   ✅ Electronics check... COMPLETED");
        System.out.println("   ✅ Function test... COMPLETED");
        System.out.println("   ✅ Software update... COMPLETED");
    }

    @Override
    public void visit(SmartCamera camera) {
        System.out.println("🛠️ CAMERA MAINTENANCE: " + camera.getName());
        System.out.println("   ✅ Lens cleaning... COMPLETED");
        System.out.println("   ✅ Sensor calibration... COMPLETED");
        System.out.println("   ✅ Firmware update... COMPLETED");
        System.out.println("   ✅ Recording test... COMPLETED");
    }

    @Override
    public void visit(SmartLight light) {
        System.out.println("🛠️ LIGHT MAINTENANCE: " + light.getName());
        System.out.println("   ✅ LED check... COMPLETED");
        System.out.println("   ✅ Brightness calibration... COMPLETED");
        System.out.println("   ✅ Shade cleaning... COMPLETED");
        System.out.println("   ✅ Color test... COMPLETED");
    }

    @Override
    public void visit(SmartLock lock) {
        System.out.println("🛠️ LOCK MAINTENANCE: " + lock.getName());
        System.out.println("   ✅ Mechanism lubrication... COMPLETED");
        System.out.println("   ✅ Battery check... COMPLETED");
        System.out.println("   ✅ Electronics test... COMPLETED");
        System.out.println("   ✅ Sensor calibration... COMPLETED");
    }

    @Override
    public void visit(SmartMusic music) {
        System.out.println("🛠️ AUDIO SYSTEM MAINTENANCE: " + music.getName());
        System.out.println("   ✅ Sound calibration... COMPLETED");
        System.out.println("   ✅ Library update... COMPLETED");
        System.out.println("   ✅ Speaker cleaning... COMPLETED");
        System.out.println("   ✅ Connection test... COMPLETED");
    }

    @Override
    public void visit(SmartThermostat thermostat) {
        System.out.println("🛠️ THERMOSTAT MAINTENANCE: " + thermostat.getName());
        System.out.println("   ✅ Sensor calibration... COMPLETED");
        System.out.println("   ✅ Filter cleaning... COMPLETED");
        System.out.println("   ✅ Connection check... COMPLETED");
        System.out.println("   ✅ Heating/cooling test... COMPLETED");
    }
}