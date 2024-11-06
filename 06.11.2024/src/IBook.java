public interface IBook {
    static public String t = "";
    void printBook();

    default void printSomething() {
        System.out.println("something");
    }
}
