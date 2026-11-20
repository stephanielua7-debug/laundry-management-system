package repository;

// Import the Customer class
import model.Customer;

// Import Java utility classes such as Map, LinkedHashMap, and Collection
import java.util.*;

public class CustomerRepository {

    // Creates a LinkedHashMap to store customer records.
    // String represents the Customer ID.
    // Customer represents the customer's information.
    // LinkedHashMap maintains the order in which customers are added.
    private Map<String, Customer> customers = new LinkedHashMap<>();

    // Saves a new customer or updates an existing customer.
    public void save(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    // Searches for a customer using their Customer ID.
    // Returns the customer if found; otherwise, returns null.
    public Customer findById(String customerId) {
        return customers.get(customerId);
    }

    // Retrieves and returns all registered customers.
    public Collection<Customer> findAll() {
        return customers.values();
    }
}