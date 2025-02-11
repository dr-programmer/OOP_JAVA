import java.util.Date;

public abstract class Product implements Comparable<Product> {
    private Integer id;
    private String name;
    private Double price;
    private Date expirationDate;

    public Product(Integer id, String name, Double price, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public abstract boolean isSuitable(Double currentTemp, Double currentMoisture);

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id == null) throw new NullPointerException("id is null");
        if(id < 0) throw new IllegalArgumentException("id is negative");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) throw new NullPointerException("name is null");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price == null) throw new NullPointerException("price is null");
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        if(expirationDate == null) throw new NullPointerException("expirationDate is null");
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        int compare = this.price.compareTo(o.price);
        if(compare != 0) return compare;
        return this.name.compareTo(o.name);
    }

    public abstract static class ProductBuilder {
        protected Integer id;
        protected String name;
        protected Double price;
        protected Date expirationDate;

        public ProductBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder expirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public abstract Product build();
    }
}
