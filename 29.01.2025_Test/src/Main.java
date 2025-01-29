import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("Hello");
        Set<Shelf> shelves = shop.getShelves();
    }
}