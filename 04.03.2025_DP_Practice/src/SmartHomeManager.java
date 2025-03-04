import java.util.ArrayList;
import java.util.List;

public class SmartHomeManager {
    private static SmartHomeManager instance = new SmartHomeManager();

    List<SmartDevice> devices = new ArrayList<>();

    private SmartHomeManager() {}
    public static SmartHomeManager getInstance() {
        return instance;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void showDevices() {
        devices.forEach(System.out::println);
    }
}
