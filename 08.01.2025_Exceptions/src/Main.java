import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of products: ");
        try {
            if(sc.hasNextInt()) {
                int num = sc.nextInt();
                sc.nextLine();
                try {
                    for (int i = 0; i < num; i++) {
                        String line = sc.nextLine();
                        String[] split = line.split(",");
                        String name = split[0];
                        double quantity;
                        try {
                            quantity = Double.parseDouble(split[1]);
                        } catch (NumberFormatException e) {
                            throw new MyException(e.getMessage());
                        }
                        String type = split[2];
                        products.add(new Product(quantity, type, name));
                    }
                }
                catch (Exception e) {
                    throw new MyException(e.getMessage());
                }
                Comparator<Product> compareByQuantity = new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if(o1.getQuantity() > o2.getQuantity())
                            return 1;
                        if(o1.getQuantity() < o2.getQuantity())
                            return -1;
                        return 0;
                    }
                };
                try {
                    Product maxQuantity = products.stream().max(compareByQuantity).get();
                    System.out.println(maxQuantity.getName());
                }
                catch (Exception e) {
                    throw new MyException(e.getMessage());
                }
                try {
                    Product maxQuantityWithMinName = products
                            .stream()
                            .filter(product -> product.getName().toLowerCase().contains("m"))
                            .max(compareByQuantity).get();
                    System.out.println(maxQuantityWithMinName.getName());
                }
                catch (Exception e) {
                    throw new MyException(e.getMessage());
                }
            }
            else {
                throw new MyException("Wrong number of products!");
            }
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}