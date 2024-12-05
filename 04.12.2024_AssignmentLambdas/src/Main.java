import java.util.ArrayList;
import java.util.List;

interface MyFunction<T, R> {
    R apply(T t);
}
interface MyBiFunction<T, U, R> {
    R apply(T t, U u);
}

public class Main {
    public static void main(String[] args) {
        MyBiFunction<Double, Double, Float> biFunction = (x, y) -> (float)(x + y);
        System.out.println(biFunction.apply(2.0, 3.0));
        biFunction = (x, y) -> (float)(x - y);
        System.out.println(biFunction.apply(2.0, 3.0));
        biFunction = (x, y) -> (float)(x * y);
        System.out.println(biFunction.apply(2.0, 3.0));
        biFunction = (x, y) -> (float)(x / y);
        System.out.println(biFunction.apply(2.0, 3.0));

        MyFunction<List<Integer>, Long> listFunction = x -> {
            Long result = 0L;
            for(Integer i : x) {
                result += i;
            }
            return result;
        };
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(listFunction.apply(list));

        MyFunction<Integer, Integer> intFunction = x -> x++;
        System.out.println(intFunction.apply(2));
        intFunction = x -> ++x;
        System.out.println(intFunction.apply(2));

        MyBiFunction<String, String, String> stringFunction = (x, y) -> x + y;
        System.out.println(stringFunction.apply("abc", "def"));
    }
}