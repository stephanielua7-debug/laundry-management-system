
package repository;

import model.Customer;
import java.util.*;

public class CustomerRepository {

    private Map<String, Customer> customers = new LinkedHashMap<>();

    // Save customer
    public void save(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    // Find customer by ID
    public Customer findById(String customerId) {
        return customers.get(customerId);
    }

    // Get all customers
    public Collection<Customer> findAll() {
        return customers.values();
    }
}
