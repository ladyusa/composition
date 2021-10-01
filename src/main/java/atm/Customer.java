package atm;

public class Customer {
    // attribute, field
    private int id;
    private String name;
    private int pin;

    // composition
    private BankAccount account;

    public Customer(int id, String name, int pin) {
        this(id, name, pin, 0);
    }

    public Customer(int id, String name, int pin, double balance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.account = new BankAccount(balance);
    }

    public boolean checkPin(int inputPin) {
        return pin == inputPin;
    }

    public void setPin(int existingPin, int newPin, int confirmedPin) {
        if (this.pin != existingPin)
            return;
        if (newPin == confirmedPin)
            this.pin = newPin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount getAccount() {
        return account;
    }
}
