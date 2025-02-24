public class LegacyPaymentSystem implements LegacySystem {
    @Override
    public void process(double amount) {
        System.out.println("Processing " + amount + " payment");
    }
}
