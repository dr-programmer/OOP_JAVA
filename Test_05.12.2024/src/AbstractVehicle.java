import java.util.ArrayList;
import java.util.List;

public abstract class AbstractVehicle implements IVehicle {
    private String id;
    private String brand;
    private String model;
    private double basePrice;
    private boolean isAvailable;
    private List<String> serviceHistory;
    private int passengerCapacity;
    private double maxFuelCapacity;
    private double fuelLevel;

    public AbstractVehicle(String id, String brand, String model, double basePrice, int passengerCapacity, double maxFuelCapacity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.basePrice = basePrice;
        this.passengerCapacity = passengerCapacity;
        this.maxFuelCapacity = maxFuelCapacity;
        this.isAvailable = true;
        this.serviceHistory = new ArrayList<>();
        this.fuelLevel = 1;
    }

    abstract double calculateMaintenanceCost();
    abstract double calculateDepreciationRate();

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public List<String> getServiceHistory() {
        return serviceHistory;
    }

    public void appendServiceHistory(String description) {
        serviceHistory.add(description);
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    public void setMaxFuelCapacity(double maxFuelCapacity) {
        this.maxFuelCapacity = maxFuelCapacity;
    }

    @Override
    public void startMaintenance() {
        setAvailable(false);
    }

    @Override
    public void endMaintenance(String description) {
        appendServiceHistory(description);
        setAvailable(true);
    }

    @Override
    public void refuel(double amount) {
        if(amount + getFuelLevel() > getMaxFuelCapacity()) {
            setFuelLevel(getMaxFuelCapacity());
        }
        else {
            setFuelLevel(getFuelLevel() + amount);
        }
    }
}
