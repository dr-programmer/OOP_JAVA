public class StringUtils {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            count[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean isPalindrome(String input) {
        if (input.isEmpty()) return true;
        String reversed = reverse(input);
        return input.equals(reversed);
    }

    public static String removeLeadingAndTrailingZeros(String input) {
        if (input.isEmpty()) return input;
        String temp = input.replaceAll("^0*", "");
        temp = temp.replaceAll("0*$", "");
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(reverse("listen"));
        System.out.println(removeLeadingAndTrailingZeros("0000listen0000"));
    }
}
