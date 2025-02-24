public class Main {
    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();

        Order order = new Order.OrderBuilder().setMainDish("asd").build();

        PaymentProcessor paymentProcessor = new PaymentAdapter(new LegacyPaymentSystem());
        paymentProcessor.processPayment(60);

        DateConvertor dc = DateConvertor.getInstance();
        System.out.println(dc.convertStringToLocalDateTime("20/02/2025"));
    }
}