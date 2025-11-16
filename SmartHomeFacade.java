import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import AbstractFactory.Factory.*;
import AbstractFactory.*;
import AbstractFactory.decorators.EnergySaverDecorator;
import AbstractFactory.decorators.SmartScheduleDecorator;
import AbstractFactory.decorators.VoiceControlDecorator;
import AbstractFactory.visitors.DiagnosticVisitor;
import AbstractFactory.visitors.EnergyReportVisitor;
import AbstractFactory.visitors.MaintenanceVisitor;
import Observer.*;
import Builder.*;

public class SmartHomeFacade {

    private List<DeviceBase> devices = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Owner owner;

    private SamsungFactory samsungFactory;
    private LGFactory lgFactory;
    private AppleFactory appleFactory;
    private XiaomiFactory xiaomiFactory;

    private ObserverManager observerManager;
    private int powerLimit = 1000;

    public SmartHomeFacade() {
        this.samsungFactory = new SamsungFactory();
        this.lgFactory = new LGFactory();
        this.appleFactory = new AppleFactory();
        this.xiaomiFactory = new XiaomiFactory();

        this.observerManager = new ObserverManager();
    }

    public void initializeHome() {
        System.out.println("Welcome, please enter your name");
        OwnerBuilder ownerBuilder = new OwnerBuilder();
        ownerBuilder.name(scanner.nextLine());

        System.out.println("Please enter your age");
        ownerBuilder.age(Integer.parseInt(scanner.nextLine()));

        this.owner = ownerBuilder.build();
        System.out.println("Creating smart home for " + owner.getName());

        mainMenu();
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\n🏠 SMART HOME MAIN MENU:");
            System.out.println("1. 📡 Add sensor");
            System.out.println("2. 💡 Add device");
            System.out.println("3. 🔌 Turn on device");
            System.out.println("4. 🔴 Turn off device");
            System.out.println("5. 🎨 Apply decorator to device");
            System.out.println("6. 🩺 Run device diagnostics");
            System.out.println("7. 📊 Generate energy report");
            System.out.println("8. 🛠️ Perform maintenance");
            System.out.println("9. 🚪 Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: addSensorMenu(); break;
                case 2: addDeviceMenu(); break;
                case 3: turnOnDeviceMenu(); break;
                case 4: turnOffDeviceMenu(); break;
                case 5: applyDecorator(); break;
                case 6: runDiagnostics(); break;
                case 7: generateEnergyReport(); break;
                case 8: performMaintenance(); break;
                case 9:
                    System.out.println("👋 Goodbye!");
                    return;
                default: System.out.println("❌ Invalid choice");
            }
        }
    }

    private void addSensorMenu() {
        System.out.println("\n📡 SELECT SENSOR TYPE:");
        System.out.println("1. 🌡️ Temperature sensor");
        System.out.println("2. 🏃‍♂️ Motion sensor");
        System.out.println("3. ⚡ Energy sensor");

        int choice = Integer.parseInt(scanner.nextLine());
        Sensor sensor = null;

        switch (choice) {
            case 1:
                sensor = new TemperatureSensor();
                break;
            case 2:
                sensor = new MotionSensor();
                break;
            case 3:
                sensor = new EnergySensor(devices, powerLimit);
                break;
            default:
                System.out.println("❌ Invalid choice");
                return;
        }

        observerManager.registerSensor(sensor);
        System.out.println("✅ Sensor added: " + sensor.getName());
    }

    public void addDeviceMenu() {
        System.out.println("\n🏭 SELECT MANUFACTURER:");
        System.out.println("1. 📱 Samsung");
        System.out.println("2. 🔵 LG");
        System.out.println("3. 🍎 Apple");
        System.out.println("4. 🔴 Xiaomi");

        int choice = Integer.parseInt(scanner.nextLine());
        Company company = null;

        switch (choice) {
            case 1: company = samsungFactory; break;
            case 2: company = lgFactory; break;
            case 3: company = appleFactory; break;
            case 4: company = xiaomiFactory; break;
            default:
                System.out.println("❌ Invalid choice");
                return;
        }

        DeviceBase device = createDevice(company);

        if (device != null) {
            devices.add(device);
            System.out.println("✅ Device added: " + device.getName());
        }
    }

    public DeviceBase createDevice(Company company) {
        System.out.println("\n💡 SELECT DEVICE TYPE:");
        System.out.println("1. 📷 Smart camera");
        System.out.println("2. 💡 Smart light");
        System.out.println("3. 🎵 Smart music");
        System.out.println("4. 🌡️ Smart thermostat");
        System.out.println("5. 🔒 Smart lock");

        int deviceChoice = Integer.parseInt(scanner.nextLine());

        switch (deviceChoice) {
            case 1: return company.createCamera();
            case 2: return company.createLight();
            case 3: return company.createMusic();
            case 4: return company.createThermostat();
            case 5: return company.createLock();
            default:
                System.out.println("❌ Invalid choice");
                return null;
        }
    }

    private void turnOnDeviceMenu() {
        if (devices.isEmpty()) {
            System.out.println("❌ No devices available!");
            return;
        }

        System.out.println("\n🔌 SELECT DEVICE TO TURN ON:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName());
        }

        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice < 0 || choice >= devices.size()) {
            System.out.println("❌ Invalid choice");
            return;
        }

        DeviceBase device = devices.get(choice);
        device.turnOn();
        notifyEvent(new Event(device.getName() + " turned ON"));
        System.out.println("✅ " + device.getName() + " is now ON");
    }

    private void turnOffDeviceMenu() {
        if (devices.isEmpty()) {
            System.out.println("❌ No devices available!");
            return;
        }

        System.out.println("\n🔴 SELECT DEVICE TO TURN OFF:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName());
        }

        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice < 0 || choice >= devices.size()) {
            System.out.println("❌ Invalid choice");
            return;
        }

        DeviceBase device = devices.get(choice);
        device.turnOff();
        notifyEvent(new Event(device.getName() + " turned OFF"));
        System.out.println("✅ " + device.getName() + " is now OFF");
    }

    public void applyDecorator() {
        if (devices.isEmpty()) {
            System.out.println("❌ No devices available!");
            return;
        }

        System.out.println("\n🎨 SELECT DEVICE TO ENHANCE:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName());
        }

        int deviceChoice = Integer.parseInt(scanner.nextLine()) - 1;
        if (deviceChoice < 0 || deviceChoice >= devices.size()) {
            System.out.println("❌ Invalid choice");
            return;
        }

        DeviceBase selectedDevice = devices.get(deviceChoice);

        System.out.println("\n🔧 SELECT ENHANCEMENT FOR " + selectedDevice.getName() + ":");
        System.out.println("1. 🎤 Voice control");
        System.out.println("2. ⏰ Smart schedule");
        System.out.println("3. 🌿 Energy saving mode");

        int decoratorChoice = Integer.parseInt(scanner.nextLine());

        DeviceBase decoratedDevice = selectedDevice;

        switch (decoratorChoice) {
            case 1:
                decoratedDevice = new VoiceControlDecorator(selectedDevice);
                System.out.println("✅ Voice control applied!");
                ((VoiceControlDecorator) decoratedDevice).listenForCommand();
                break;

            case 2:
                decoratedDevice = new SmartScheduleDecorator(selectedDevice);
                System.out.print("⏰ Enter turn-on time (e.g., 08:00): ");
                String onTime = scanner.nextLine();
                System.out.print("⏰ Enter turn-off time (e.g., 23:00): ");
                String offTime = scanner.nextLine();
                ((SmartScheduleDecorator) decoratedDevice).setSchedule(onTime, offTime);
                break;

            case 3:
                decoratedDevice = new EnergySaverDecorator(selectedDevice);
                ((EnergySaverDecorator) decoratedDevice).autoOptimize();
                break;

            default:
                System.out.println("❌ Invalid choice");
                return;
        }

        devices.set(deviceChoice, decoratedDevice);
        System.out.println("🎉 Enhancement applied to: " + decoratedDevice.getName());
        notifyEvent(new Event("Decorator applied to " + decoratedDevice.getName()));
    }

    public void runDiagnostics() {
        if (devices.isEmpty()) {
            System.out.println("❌ No devices for diagnostics!");
            return;
        }

        System.out.println("\n🩺 RUNNING DIAGNOSTICS FOR ALL DEVICES...");
        System.out.println("=====================================");

        DiagnosticVisitor diagnostic = new DiagnosticVisitor();
        for (DeviceBase device : devices) {
            device.accept(diagnostic);
            System.out.println("---");
        }
        System.out.println("✅ Diagnostics completed!");
    }

    public void generateEnergyReport() {
        if (devices.isEmpty()) {
            System.out.println("❌ No devices for analysis!");
            return;
        }

        System.out.println("\n📊 GENERATING ENERGY REPORT...");
        System.out.println("====================================");

        EnergyReportVisitor energyReport = new EnergyReportVisitor();
        for (DeviceBase device : devices) {
            device.accept(energyReport);
        }
        energyReport.printReport();
    }

    public void performMaintenance() {
        if (devices.isEmpty()) {
            System.out.println("❌ No devices for maintenance!");
            return;
        }

        System.out.println("\n🛠️ PERFORMING MAINTENANCE...");
        System.out.println("========================================");

        MaintenanceVisitor maintenance = new MaintenanceVisitor();
        for (DeviceBase device : devices) {
            device.accept(maintenance);
            System.out.println("---");
        }
        System.out.println("✅ Maintenance completed!");
    }

    public void notifyEvent(Event event) {
        observerManager.notifyObservers(event);
    }

    public void shutdownHome() {
        System.out.println("🔴 Shutting down smart home...");
        for (DeviceBase device : devices) {
            device.turnOff();
        }
        System.out.println("✅ All devices turned off");
    }
}