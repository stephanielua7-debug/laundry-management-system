
package repository;

import model.Customer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerRepository {

    private final Map<String, Customer> customers = new LinkedHashMap<>();

    private int nextId = 1001;

    // Generate Customer ID
    public String nextId() {
        return "CUS-" + nextId++;
    }

    // Add customer
    public void add(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    // Find customer by ID
    public Optional<Customer> findById(String customerId) {
        return Optional.ofNullable(customers.get(customerId));
    }

    // Get all customers
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    // Delete customer
    public boolean remove(String customerId) {
        return customers.remove(customerId) != null;
    }
}
