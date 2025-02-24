public class PaymentAdapter implements PaymentProcessor {
    LegacyPaymentSystem legacyPaymentSystem;

    public PaymentAdapter(LegacyPaymentSystem legacySystem) {
        legacyPaymentSystem = legacySystem;
    }


    @Override
    public void processPayment(double amount) {
        legacyPaymentSystem.process(amount);
    }
}
