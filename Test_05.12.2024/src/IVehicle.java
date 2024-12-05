import java.util.List;

public interface IVehicle {
    String getId();
    String getBrand();
    String getModel();
    double getBasePrice();
    double calculateDailyRate();
    boolean isAvailable();
    void startMaintenance();
    void endMaintenance(String description);
    List<String> getServiceHistory();
    int getPassengerCapacity();
    double getFuelLevel();
    void refuel(double amount);
}
