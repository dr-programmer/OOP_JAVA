import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MyFunctionalInterface<String> test = x -> x.contains("test");
        System.out.println(test.test("false"));

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        for(Integer i : arrayList) {
            if(i % 3 == 0) {
                System.out.println(i);
            }
        }

        arrayList.forEach(x -> {
            if(x % 3 == 0) {
                System.out.println(x);
            }
        });

        arrayList.forEach(x -> System.out.println(x));

        arrayList.stream().forEach(x -> System.out.println(x));

        Set<Integer> set = arrayList
                .stream()
                .filter(x -> x % 3 == 0)
                .collect(Collectors.toSet());

        // List<?> list1 = new ArrayList<>();

        System.out.println(arrayList);
        System.out.println(set);

        List<String> strings = arrayList
                .stream()
                .map(x -> "Value: " + x.toString())
                .collect(Collectors.toList());
        System.out.println(strings);

        List<String> names = List.of("Ivan", "Ivanka", "Mimi", "Mimi"); // Unmodifiable
        Map<String, Long> map = names
                .stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map);

        Map<Boolean, Long> map2 = names.stream()
                .collect(Collectors.partitioningBy(x -> x.equals("Ivan"), Collectors.counting()));
        System.out.println(map2);

        // Not possible map.stream()
        map.values().stream().forEach(System.out::println);
    }
}