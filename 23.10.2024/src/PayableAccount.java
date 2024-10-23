public class PayableAccount extends BankAccount{

    private final int limit = 100;


    @Override
    protected boolean isAmountValid(int amount) {
        return amount <= limit;
    }
}
