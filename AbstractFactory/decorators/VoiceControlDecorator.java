package AbstractFactory.decorators;
import AbstractFactory.DeviceBase;
import AbstractFactory.visitors.DeviceVisitor;
import java.util.Scanner;
public class VoiceControlDecorator extends DeviceBaseDecorator {
    private Scanner voiceScanner;

    public VoiceControlDecorator(DeviceBase decoratedDevice) {
        super(decoratedDevice);
        this.voiceScanner = new Scanner(System.in);
    }
    @Override
    public void turnOn() {
        System.out.println("🎤 Voice command: turn on " + getName());
        super.turnOn();
    }
    @Override
    public void turnOff() {
        System.out.println("🎤 Voice command: turn off " + getName());
        super.turnOff();
    }
    public void listenForCommand() {
        System.out.println("\n🎤 I listen to voice commands for " + getName() + "...");
        System.out.println("Available commands: 'on', 'off', 'status', 'exit'");

        while (true) {
            System.out.print("🎤 Say the command:");
            String command = voiceScanner.nextLine().toLowerCase().trim();

            if (command.equals("exit")) {
                System.out.println("🎤 Voice control is complete");
                break;
            }

            processVoiceCommand(command);
        }
    }
    private void processVoiceCommand(String command) {
        switch (command) {
            case "on":
                turnOn();
                System.out.println("✅ Completed: the device is turned on");
                break;
            case "off":
                turnOff();
                System.out.println("✅ Completed: the device is turned on");
                break;
            case "status":
                System.out.println("📊 Status " + getName() + ": " +
                        (getPowerConsumption() > 0 ? "ON" : "OFF"));
                break;
            default:
                System.out.println("❌ Did not recognize the command: '" + command + "'");
                System.out.println("💡 Try: 'on', 'off', 'status'");
        }
    }
    @Override
    public String getName() {
        return decoratedDevice.getName() + " (Voice control)";
    }
}