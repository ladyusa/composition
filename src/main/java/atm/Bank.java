package atm;

import java.util.Map;

public class Bank {
    // attribute
    private String name;

    // composition
    private Map<Integer,Customer> customers;
    private DataSourceFile dataSource;

    public Bank(String name) {
        this.name = name;
        this.dataSource = new DataSourceFile("customers.txt");
        this.customers = dataSource.readCustomers();
    }

    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer validateCustomer(int id, int pin) {
        Customer customer = customers.get(id);
        if (customer != null) {
            if (customer.checkPin(pin))
                return customer;
        }
        return null;
    }

    Customer findCustomer(int id) {
        return customers.get(id);
    }
}
