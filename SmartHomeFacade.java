import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import AbstractFactory.Factory.*;
import AbstractFactory.*;
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
    private Strategy deviceStrategy;
    private int powerLimit = 1000;

    public SmartHomeFacade() {
        this.samsungFactory = new SamsungFactory();
        this.lgFactory = new LGFactory();
        this.appleFactory = new AppleFactory();
        this.xiaomiFactory = new XiaomiFactory();

        this.observerManager = new ObserverManager();
        this.deviceStrategy = new DefaultDeviceStrategy();
    }

    public void initializeHome() {
        System.out.println("Welcome, please, enter your name");
        OwnerBuilder ownerBuilder = new OwnerBuilder();
        ownerBuilder.name(scanner.nextLine());

        System.out.println("Please, enter your age");
        ownerBuilder.age(Integer.parseInt(scanner.nextLine()));

        this.owner = ownerBuilder.build();
        System.out.println("Creating smart home for " + owner.getName());

        mainMenu();
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Sensor");
            System.out.println("2. Add Device");
            System.out.println("3. Turn ON Device");
            System.out.println("4. Turn OFF Device");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: addSensorMenu(); break;
                case 2: addDeviceMenu(); break;
                case 3: turnOnDeviceMenu(); break;
                case 4: turnOffDeviceMenu(); break;
                case 5: return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private void addSensorMenu() {
        System.out.println("Add Sensor:");
        System.out.println("1. Temperature Sensor");
        System.out.println("2. Motion Sensor");
        System.out.println("3. Energy Sensor");

        int choice = Integer.parseInt(scanner.nextLine());
        Sensor sensor = null;

        switch (choice) {
            case 1: sensor = new TemperatureSensor(); break;
            case 2: sensor = new MotionSensor(); break;
            case 3: sensor = new EnergySensor(devices, powerLimit); break;
            default: System.out.println("Invalid choice"); return;
        }

        observerManager.registerSensor(sensor);
        System.out.println("Sensor added: " + sensor.getName());
    }

    public void addDeviceMenu() {
        System.out.println("Which company device you want to add?");
        System.out.println("1. Samsung");
        System.out.println("2. LG");
        System.out.println("3. Apple");
        System.out.println("4. Xiaomi");

        int choice = Integer.parseInt(scanner.nextLine());
        Company company = null;

        switch (choice) {
            case 1: company = samsungFactory; break;
            case 2: company = lgFactory; break;
            case 3: company = appleFactory; break;
            case 4: company = xiaomiFactory; break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        DeviceBase device = createDevice(company);

        if (device != null) {
            devices.add(device);
            System.out.println("Device added: " + device.getName());
        }
    }

    public DeviceBase createDevice(Company company) {
        System.out.println("Select device type to add:");
        System.out.println("1. Smart Camera");
        System.out.println("2. Smart Light");
        System.out.println("3. Smart Music");
        System.out.println("4. Smart Thermostat");
        System.out.println("5. Smart Lock");

        int deviceChoice = Integer.parseInt(scanner.nextLine());

        switch (deviceChoice) {
            case 1: return company.createCamera();
            case 2: return company.createLight();
            case 3: return company.createMusic();
            case 4: return company.createThermostat();
            case 5: return company.createLock();
            default:
                System.out.println("Invalid choice");
                return null;
        }
    }

    private void turnOnDeviceMenu() {
        if (devices.isEmpty()) {
            System.out.println("No devices available!");
            return;
        }

        System.out.println("Choose device to turn ON:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName());
        }

        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice < 0 || choice >= devices.size()) {
            System.out.println("Invalid choice");
            return;
        }

        DeviceBase device = devices.get(choice);
        device.turnOn();
        notifyEvent(new Event(device.getName() + " turned ON"));
        System.out.println(device.getName() + " is now ON");
    }

    private void turnOffDeviceMenu() {
        if (devices.isEmpty()) {
            System.out.println("No devices available!");
            return;
        }

        System.out.println("Choose device to turn OFF:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getName());
        }

        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice < 0 || choice >= devices.size()) {
            System.out.println("Invalid choice");
            return;
        }

        DeviceBase device = devices.get(choice);
        device.turnOff();
        notifyEvent(new Event(device.getName() + " turned OFF"));
        System.out.println(device.getName() + " is now OFF");
    }

    public void applyDecorator() {
        for (DeviceBase device : devices) {
            System.out.println("Apply special functionality to " + device.getName() + "? (yes/no)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Select what you wish to apply:");
                System.out.println("1. Energy Saver");
                System.out.println("2. Voice Control");

                int decoratorChoice = Integer.parseInt(scanner.nextLine());

                switch (decoratorChoice) {
                    case 1: device = new EnergySaverDecorator(device); break;
                    case 2: device = new VoiceControlDecorator(device); break;
                    default: System.out.println("Invalid choice"); return;
                }

                System.out.println("Decorator applied to " + device.getName());
            }
        }
    }

    public void applyStrategy() {
        deviceStrategy.execute();
    }

    public void notifyEvent(Event event) {
        observerManager.notifyObservers(event);
    }

    public void shutdownHome() { }
}
