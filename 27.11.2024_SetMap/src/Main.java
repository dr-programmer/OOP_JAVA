import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list); // .toString() is called implicitly

        // Set

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        for(Integer i : set) {
            System.out.println(i);
        }

        System.out.println(set); // toString() is called implicitly

        Set<Double> doubleSet = new TreeSet<>();
        doubleSet.add(5.0);
        doubleSet.add(2.0);
        doubleSet.add(-3.0);

        System.out.println(doubleSet); // The values are implicitly sorted

        Set<String> stringSet = new TreeSet<>();
        stringSet.add("1");
        stringSet.add("hello");
        stringSet.add("WORLD");
        System.out.println(stringSet);
        Iterator<String> iterator = stringSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for(String s : stringSet) {
            System.out.println(s);
        }
//        for(int i = 0; i < stringSet.size(); i++) {
//            System.out.println(stringSet.remove(i));
//        }

        stringSet.forEach(System.out::println);
        stringSet.forEach((x) -> System.out.println(x));

        // Map

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(1, "hello1"); // Overrides the existing value for 1
        map.put(2, "world");
        map.put(3, "how");
        map.put(-10, "are you");
        System.out.println(map);
        for(String s : map.values()) {
            System.out.println(s);
        }
        System.out.println(map.containsKey(6));
        System.out.println(map.containsValue("test"));
        System.out.println(map.get(5));
        System.out.println(map.get(-10));

        System.out.println(map.remove(5));
        System.out.println(map.remove(-10, "temp"));
        System.out.println(map.remove(-10));

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getKey() == 1) entry.setValue("Promeneno");
        }
        for(Integer i : map.keySet()) {
            System.out.println(i);
        }
        for(String s : map.values()) {
            System.out.println(s);
        }
        System.out.println(map);

        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1000);
        treeMap.put(-2, 2000);
        treeMap.put(30, 3000);
        System.out.println(treeMap);
    }
}