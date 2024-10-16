public class Hash {
    public static String hash(String str) {
        String[] split = str.split(" ");
        StringBuilder hash = new StringBuilder();
        for (String s : split) {
            hash.append(s.charAt(0));
            hash.append(s.length());
            hash.append(" ");
        }
        hash.deleteCharAt(hash.length() - 1);
        return hash.toString();
    }

    public static boolean validate(String hash, String str) {
        String newHash = hash(str);
        return newHash.equals(hash);
    }

    public static void main(String[] args) {
        System.out.println(Hash.hash("I love OOP in JAVA"));
        String test = Hash.hash("I love OOP in JAVA");
        System.out.println(Hash.validate(test, "I love OOP in JAVA"));
    }
}
