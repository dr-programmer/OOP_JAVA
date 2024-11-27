import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(); // Possible without the type in the constructor
        list.add(1);
        list.add(2);
        list.add(3);
        for(int i: list) {
            System.out.println(i);
        }

        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        for(int i: array) {
            System.out.println("Array: " + i);
        }

        List<Integer> immutableList = List.of(1, 2, 3, 10);
        Integer v1 = immutableList.get(1);
        v1 = 5;
        // immutableList.set(1, v1); Cannot be done because it is immutable

        List<String> arr = new ArrayList<>();
        arr.add("A");
        arr.add("B");
        arr.add("C");
        for(String s: arr) {
            System.out.println(s);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(6);
        stack.push(7);
        stack.pop();
        System.out.println(stack.peek());
    }
}