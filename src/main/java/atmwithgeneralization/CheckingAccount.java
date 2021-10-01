package atmwithgeneralization;

public class CheckingAccount extends BankAccount {

    private static final double FEE = 10;

    private int transactionNumber = 0;

    public CheckingAccount(int id, String name) {
        super(id, name);
    }

    public CheckingAccount(int id, String name, double initialBalance) {
        super(id, name, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        double fee = 0;
        if (transactionNumber >= 5) {
            fee = FEE;
        }
        super.withdraw(amount + fee);
        transactionNumber++;
    }
}
