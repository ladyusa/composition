package atmwithgeneralization;

public class SavingsAccount extends BankAccount {

    private double interest;

    public SavingsAccount(int id, String name, double interest) {
        super(id, name);
        this.interest = interest;
    }

    public SavingsAccount(int id, String name, double initialBalance, double interest) {
        super(id, name, initialBalance);
        this.interest = interest;
    }

    public void addInterest() {
        double interestAmount = getBalance() * interest;
        deposit(interest);
    }

}
