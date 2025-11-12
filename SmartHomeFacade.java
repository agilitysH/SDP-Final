import java.util.List;
import java.util.Scanner;

public class SmartHomeFacade {
    private SmartHome smartHome;
    private List<Device> devices = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Owner owner;
    private SamsungCompany samsungFactory;
    private LGCompany lgFactory;
    private ObserverManager observerManager;
    private Strategy deviceStrategy;
    private Sensor futureSensor; 
    private Sensor futureSensor; 

    public SmartHomeFacade() {
        this.samsungFactory = new SamsungFactory();
        this.lgFactory = new LGFactory();
        this.observerManager = new ObserverManager();
        this.deviceStrategy = new DefaultDeviceStrategy(); // example default strategy
    }

    public void initializeHome() {
        System.out.println("Welcome, please, enter your name");
        OwnerBuilder ownerBuilder = new OwnerBuilder();
        String name = scanner.nextLine();
        ownerBuilder.name(name);
        System.out.println("Please, enter your age");
        int age = Integer.parseInt(scanner.nextLine());
        ownerBuilder.age(age);
        this.owner = ownerBuilder.build();
        System.out.println("Creating smart home for " + owner.getName());
        mainMenu();
    }

    public void addSensor(Sensor sensor) {
        observerManager.registerSensor(sensor);
    }

    public void addDeviceMenu() {
        System.out.println("Which company device you want to add?");
        System.out.println("1. Samsung");
        System.out.println("2. LG");
        int choice = Integer.parseInt(scanner.nextLine());
        Device device = null;
        if (choice == 1) {
            device = createDevice(SamsungCompany samsungFactory);
        } else if (choice == 2) {
            device = createDevice(LGCompany lgFactory);
        } else {
            System.out.println("Invalid choice");
            addDeviceMenu();
        }
        if(device){
            devices.add(device);
            System.out.println("Device added: " + device.getName());
        }
    }
    public Device createDevice(Company company) {
        System.out.println("Select device type to add:");
        System.out.println("1. TV");
        System.out.println("2. Refrigerator");
        int deviceChoice = Integer.parseInt(scanner.nextLine());
        Device device = null;
        switch (deviceChoice) {
            case 1:
                device = company.createTV();
                break;
            case 2:
                device = company.createRefrigerator();
                break;
            default:
                System.out.println("Invalid choice");
                createDevice(company);
                return;
        }
        return device;
    }


    public void applyDecorator() {
        for (Device device : devices) {
            System.out.println("Apply special functionality to " + device.getName() + "? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Select what you wish to apply:");
                System.out.println("1. Energy Saver");
                System.out.println("2. Voice Control");
                int decoratorChoice = Integer.parseInt(scanner.nextLine());
                switch (decoratorChoice) {
                    case 1:
                        device = new EnergySaverDecorator(device);
                        break;
                    case 2:
                        device = new VoiceControlDecorator(device);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        applyDecorators();
                        return;
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

    public void shutdownHome() {
    }
}
