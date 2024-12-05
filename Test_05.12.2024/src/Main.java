import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AbstractVehicle> cars = new LinkedList<>();
        cars.add(new LuxuryVehicle("123", "Merc", "AMG", 100000, 4, 100));
        cars.add(new LuxuryVehicle("192", "BMW", "X", 100200, 4, 130));
        cars.add(new EconomyVehicle("329", "Skoda", "Octavia", 60000, 4, 90));
        for(AbstractVehicle car : cars) {
            System.out.println("Car: " + car.getId() + " " + car.getBrand() + " " + car.getModel());
        }

        cars.getFirst().startMaintenance();
        cars.getFirst().endMaintenance("We did something!");
        cars.getFirst().startMaintenance();
        cars.getFirst().endMaintenance("We did something again!");
        System.out.println(cars.getFirst().getServiceHistory().getFirst());
        System.out.println(cars.getFirst().getServiceHistory().getLast());
    }
}