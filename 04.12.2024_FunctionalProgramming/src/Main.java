import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Lambdas

        Predicate<Integer> predicate = x -> x < 10;
        System.out.println(predicate.test(5));

        // Own test
        IPred ipred = new IPred();
        System.out.println(ipred.test(100));

        // Our own functional interface
        MyConsumer<String> myConsumer = (x) -> System.out.println(x);
        myConsumer.accept("Hello");

        // Java's consumer interface
        Consumer<String> consumer = x -> System.out.println(x);

        // Consumer with more complex lambda with a body
        Consumer<String> test = name -> {
            name = name.concat("END");
            System.out.println(name);
        };
        test.accept("Hello");
    }
}


























