import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Enter a text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.split("[,\\.\\s]");
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);

        Set<Character> set = new HashSet<>();
        System.out.print("Enter a word: ");
        String word = sc.nextLine();
        sc.close();
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            set.add(c);
        }
        System.out.println(set);
    }
}