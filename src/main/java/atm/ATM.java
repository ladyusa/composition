package atm;

public class ATM {

    // composition
    private Bank bank;
    private Customer loginCustomer;

    public ATM(Bank bank) {
        this.bank = bank;
        this.loginCustomer = null;
    }

    public boolean validateCustomer(int id, int pin) {
        // delegation : มอยหมายงานให้ object อื่นช่วยทำงานแทนให้
        loginCustomer = bank.validateCustomer(id, pin);
        if (loginCustomer != null)
            return true;
        return false;
    }

    public void deposit(double amount) {
        // delegation
        loginCustomer.getAccount().deposit(amount);
    }

    public void withdraw(double amount) {
        // delegation
        loginCustomer.getAccount().withdraw(amount);
    }

    public double getBalance() {
        // delegation
        return loginCustomer.getAccount().getBalance();
    }

    public void transfer(int receiverId, double amount) {
        Customer receiver = bank.findCustomer(receiverId);
        if (receiver != null) {
            loginCustomer.getAccount().withdraw(amount);
            receiver.getAccount().deposit(amount);
        }
    }

    public void end() {
        loginCustomer = null;
    }

    public String getCustomerName() {
        return loginCustomer.getName();
    }
}
