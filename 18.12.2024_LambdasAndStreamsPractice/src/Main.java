import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> function = x -> x % 2 == 0;
        System.out.println(function.test(5));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        Stream<Integer> stream = list.stream();
//        stream.forEach(System.out::println);

        list
                .stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        List<Deer> deers = new ArrayList<>();
        deers.add(new Deer("Rudolf", 12));
        deers.add(new Deer("Kon", 13));
        deers.add(new Deer("Myaou", 14));
        deers.add(new Deer("Bambi", 15));

        Set<Elf> elves = deers
                .stream()
                .map(x -> new Elf(x.getAge(), (long)x.getName().length()))
                .collect(Collectors.toCollection(TreeSet::new));

        elves.forEach(System.out::println);
    }
}