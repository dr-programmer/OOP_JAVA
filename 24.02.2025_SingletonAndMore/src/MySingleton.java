public class MySingleton {
    private MySingleton() {}

    static MySingleton instance = new MySingleton();
    public static MySingleton getInstance() {
        return instance;
    }
}
