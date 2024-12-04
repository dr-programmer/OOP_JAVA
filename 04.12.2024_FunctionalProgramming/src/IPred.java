import java.util.function.Predicate;

public class IPred implements Predicate<Integer> {
    @Override
    public boolean test(Integer i) {
        return i < 10;
    }
}
