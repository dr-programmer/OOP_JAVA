import java.util.Date;

public class FrozenProducts extends Product {
    private Double temp;

    public FrozenProducts(int id, String name, double price, Date expirationDate) {
        super(id, name, price, expirationDate);
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        if(temp == null) throw new NullPointerException("temp is null");
        this.temp = temp;
    }

    @Override
    public boolean isSuitable(Double currentTemp, Double currentMoisture) {
        if(this.getTemp() < currentTemp) {
            return false;
        }
        return true;
    }
}
