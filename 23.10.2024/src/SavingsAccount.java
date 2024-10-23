public class SavingsAccount extends BankAccount {

    @Override
    protected boolean isAmountValid(int amount) {
        return true;
    }
}
