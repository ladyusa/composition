package atmwithgeneralization;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("My Bank", new DataSourceFile("customers.txt"));
        ATM atm = new ATM(bank);
        AtmUI atmUI = new AtmUI(atm);
        atmUI.run();
    }
}
