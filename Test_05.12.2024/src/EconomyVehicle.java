public class EconomyVehicle extends AbstractVehicle {

    private double fuelEfficiency;
    private boolean hasEcoMode;
    private double economyDiscount;

    public EconomyVehicle(String id, String brand, String model, double basePrice, int passengerCapacity, double maxFuelCapacity) {
        super(id, brand, model, basePrice, passengerCapacity, maxFuelCapacity);
    }

    @Override
    double calculateMaintenanceCost() {
        return (1 - economyDiscount) * 300;
    }

    @Override
    double calculateDepreciationRate() {
        return 1 / fuelEfficiency;
    }

    @Override
    public double calculateDailyRate() {
        if(hasEcoMode) {
            return getBasePrice() - 100;
        }
        return getBasePrice();
    }
}
