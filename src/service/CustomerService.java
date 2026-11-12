
package service;

import model.Customer;
import repository.CustomerRepository;
import util.IdGenerator;
import util.InputValidator;
import java.util.Collection;

public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer addCustomer(String name, String phone) {

        name = InputValidator.validateRequired(name, "Name");
        phone = InputValidator.validateRequired(phone, "Phone");

        String id = IdGenerator.generateCustomerId();

        Customer customer = new Customer(id, name, phone);

        repository.save(customer);

        return customer;
    }

    public Customer findCustomer(String id) {
        return repository.findById(id);
    }

    public Collection<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
