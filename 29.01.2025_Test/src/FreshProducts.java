import java.util.Date;

public class FreshProducts extends Product {
    private Double moisture;

    public FreshProducts(int id, String name, double price, Date expirationDate) {
        super(id, name, price, expirationDate);
    }

    public Double getMoisture() {
        return moisture;
    }

    public void setMoisture(Double moisture) {
        if(moisture == null) throw new NullPointerException("moisture is null");
        if(moisture < 0 || moisture > 100) throw new IllegalArgumentException("moisture is out of range");
        this.moisture = moisture;
    }

    @Override
    public boolean isSuitable(Double currentTemp, Double currentMoisture) {
        if(this.getMoisture() > currentMoisture) {
            return false;
        }
        return true;
    }
}
