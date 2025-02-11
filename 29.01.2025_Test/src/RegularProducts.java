import java.util.Date;

public class RegularProducts extends Product {
    private PackageType packageType;

    public RegularProducts(int id, String name, double price, Date expirationDate) {
        super(id, name, price, expirationDate);
    }

    public RegularProducts(RegularProductBuilder builder) {
        super(builder.id, builder.name, builder.price, builder.expirationDate);
        this.packageType = builder.packageType;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        if(packageType == null) throw new NullPointerException("Package type cannot be null");
        this.packageType = packageType;
    }

    @Override
    public boolean isSuitable(Double currentTemp, Double currentMoisture) {
        return true;
    }

    public static class RegularProductBuilder extends ProductBuilder {
        private PackageType packageType;

        public RegularProductBuilder packageType(PackageType packageType) {
            this.packageType = packageType;
            return this;
        }

        @Override
        public Product build() {
            return new RegularProducts(this);
        }
    }
}
