import java.util.Set;
import java.util.TreeSet;

public class Shop {
    private String address;
    private Set<Shelf> shelves;

    public Shop(String address) {
        this.address = address;
        shelves = new TreeSet<>();
    }

    Double getTotalShopValue() {
        double total = 0.0;
        for (Shelf s : shelves) {
            total += s.getTotalShelfValue();
        }
        return total;
    }

    public Set<Shelf> getShelves() {
        return shelves;
    }
}
