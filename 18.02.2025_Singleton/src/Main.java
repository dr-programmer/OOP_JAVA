public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
        s1.setId(1);
        s2.setFirstName("John");`
        s2.setLastName("Doe");

        System.out.println(s1);
        System.out.println(s2);
    }
}