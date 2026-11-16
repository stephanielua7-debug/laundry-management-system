
package service;

// Import the Customer model class.
import model.Customer;

// Import the CustomerRepository class.
import repository.CustomerRepository;

// Import utility classes for generating IDs and validating input.
import util.IdGenerator;
import util.InputValidator;

// Import Collection to handle multiple customer records.
import java.util.Collection;

public class CustomerService {

    // Repository used to store and retrieve customer records.
    private CustomerRepository repository;

    // Constructor: receives the CustomerRepository object.
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Adds a new customer to the system.
    public Customer addCustomer(String name, String phone) {

        // Validate the customer's name.
        name = InputValidator.validateRequired(name, "Name");

        // Validate the customer's phone number.
        phone = InputValidator.validateRequired(phone, "Phone");

        // Generate a unique customer ID.
        String id = IdGenerator.generateCustomerId();

        // Create a new Customer object.
        Customer customer = new Customer(id, name, phone);

        // Save the customer using the repository.
        repository.save(customer);

        // Return the newly created customer.
        return customer;
    }

    // Finds a customer using their customer ID.
    public Customer findCustomer(String id) {
        return repository.findById(id);
    }

    // Retrieves all customer records.
    public Collection<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
