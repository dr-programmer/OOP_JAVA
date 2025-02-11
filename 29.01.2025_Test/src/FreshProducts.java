import java.util.Date;

public class FreshProducts extends Product {
    private Double moisture;

    public FreshProducts(int id, String name, double price, Date expirationDate) {
        super(id, name, price, expirationDate);
    }

    public FreshProducts(FreshProductBuilder builder) {
        super(builder.id, builder.name, builder.price, builder.expirationDate);
        this.moisture = builder.moisture;
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

    public static class FreshProductBuilder extends ProductBuilder {
        private Double moisture;

        public FreshProductBuilder moisture(Double moisture) {
            this.moisture = moisture;
            return this;
        }

        @Override
        public Product build() {
            return new FreshProducts(this);
        }
    }
}
