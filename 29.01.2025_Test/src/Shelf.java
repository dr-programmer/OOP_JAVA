import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Shelf implements Comparable<Shelf> {
    private Double currentTemp;
    private Double currentMoisture;
    private Set<Product> products;

    public Shelf() {
        currentTemp = 0.0;
        currentMoisture = 0.0;
        products = new TreeSet<>();
    }
    public Shelf(Double currentTemp, Double currentMoisture, Set<Product> products) {
        this.currentTemp = currentTemp;
        this.currentMoisture = currentMoisture;
        this.products = products;
    }

    boolean isSuitableForAll() {
        return products.stream().anyMatch(x -> !x.isSuitable(currentTemp, currentMoisture));
    }

    void removeUnsuitable() {
        products.removeIf(x -> !x.isSuitable(currentTemp, currentMoisture));
    }

    Double removeExpired(Date currentDate) {
        if(currentDate == null) throw new NullPointerException("currentDate parameter can't be null");
        double priceSum = 0.0;
        for(Product p : products) {
            if(currentDate.compareTo(p.getExpirationDate()) > 1) {
                priceSum += p.getPrice();
                products.remove(p);
            }
        }
        return priceSum;
    }

    Double averagePrice() {
        return products.stream().map(Product::getPrice).reduce(0.0, Double::sum) / products.size();
    }

    Double getTotalShelfValue() {
        return products.stream().map(Product::getPrice).reduce(0.0, Double::sum);
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp) {
        if(currentTemp == null) throw new NullPointerException("Current temp is null");
        this.currentTemp = currentTemp;
    }

    public Double getCurrentMoisture() {
        return currentMoisture;
    }

    public void setCurrentMoisture(Double currentMoisture) {
        if(currentMoisture == null) throw new NullPointerException("moisture is null");
        if(currentMoisture < 0 || currentMoisture > 100)
            throw new IllegalArgumentException("moisture is out of range");
        this.currentMoisture = currentMoisture;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        if(products == null) throw new NullPointerException("products is null");
        if(!(products instanceof TreeSet))
            throw new IllegalArgumentException("products is not a TreeSet - therefore not sorted by default");
        this.products = products;
    }

    @Override
    public int compareTo(Shelf o) {
        return this.averagePrice().compareTo(o.averagePrice());
    }
}
