public abstract class BankAccount implements IDepositableAccount, IWithdrawableAccount {

    protected int balance = 0;

    @Override
    public void deposit(int amount) {
        if(amount <= 0) {
            System.out.println("You can't deposit negative amount");
        }
        else {
            balance += amount;
        }
    }

    @Override
    public int withdraw(int amount) {
        if(amount > 0 && amount <= balance && isAmountValid(amount)) {
            balance -= amount;
        }
        else {
            System.out.println("Insufficient balance");
        }
        return balance;
    }

    protected abstract boolean isAmountValid(int amount);
}
