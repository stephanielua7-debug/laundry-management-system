
package service;

import model.Customer;
import repository.CustomerRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // REGISTER CUSTOMER
    public Customer register(String name, String phone, String email) {

        Customer customer = new Customer(
                repository.nextId(),
                name,
                phone,
                email);

        repository.add(customer);

        return customer;
    }

    // FIND CUSTOMER BY ID
    public Optional<Customer> find(String customerId) {
        return repository.findById(customerId);
    }

    // GET ALL CUSTOMERS
    public List<Customer> listAll() {
        return repository.findAll();
    }

    // UPDATE CUSTOMER
    public boolean update(String customerId, String name,
            String phone, String email) {

        Optional<Customer> found = repository.findById(customerId);

        if (found.isEmpty()) {
            return false;
        }

        Customer customer = found.get();

        customer.setCustomerName(name);
        customer.setContactNumber(phone);
        customer.setEmail(email);

        return true;
    }

    // DELETE CUSTOMER
    public boolean delete(String customerId) {
        return repository.remove(customerId);
    }

    // BACKWARD COMPATIBILITY
    // For existing Laundry modules

    public Collection<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer findCustomerById(String customerId) {
        return repository.findById(customerId).orElse(null);
    }

}
