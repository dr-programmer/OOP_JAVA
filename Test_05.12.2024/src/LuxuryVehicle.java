import java.util.List;

public class LuxuryVehicle extends AbstractVehicle {

    private float premiumRate;
    private List<String> luxuryFeatures;
    private boolean hasChaufer;

    public LuxuryVehicle(String id, String brand, String model, double basePrice, int passengerCapacity, double maxFuelCapacity) {
        super(id, brand, model, basePrice, passengerCapacity, maxFuelCapacity);
    }

    @Override
    double calculateMaintenanceCost() {
        return premiumRate * 300;
    }

    @Override
    double calculateDepreciationRate() {
        return 1 / premiumRate;
    }

    @Override
    public double calculateDailyRate() {
        if(hasChaufer) {
            return getBasePrice() + premiumRate + 500;
        }
        return getBasePrice() + premiumRate;
    }

    public float getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(float premiumRate) {
        this.premiumRate = premiumRate;
    }

    public List<String> getLuxuryFeatures() {
        return luxuryFeatures;
    }

    public void setLuxuryFeatures(List<String> luxuryFeatures) {
        this.luxuryFeatures = luxuryFeatures;
    }

    public boolean isHasChaufer() {
        return hasChaufer;
    }

    public void setHasChaufer(boolean hasChaufer) {
        this.hasChaufer = hasChaufer;
    }
}
