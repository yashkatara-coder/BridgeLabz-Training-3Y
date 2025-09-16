

class Device {
    String deviceId;
    String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    public void displayStatus() {
        System.out.println("--- Thermostat Status ---");
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thermostat livingRoomThermo = new Thermostat("TH-LR-01", "Active", 22.5);
        livingRoomThermo.displayStatus();
    }
}
