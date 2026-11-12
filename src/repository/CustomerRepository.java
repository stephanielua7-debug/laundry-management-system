
package repository;

import model.Customer;
import java.util.*;

public class CustomerRepository {

    private Map<String, Customer> customers = new LinkedHashMap<>();

    public void save(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    public Customer findById(String customerId) {
        return customers.get(customerId);
    }

    public Collection<Customer> findAll() {
        return customers.values();
    }
}
