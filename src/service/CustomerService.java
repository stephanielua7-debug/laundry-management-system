
package service;

import model.Customer;
import repository.CustomerRepository;

import java.util.Collection;

public class CustomerService {

    private CustomerRepository repository;
    private int customerCounter = 1001;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // ADD CUSTOMER
    public Customer addCustomer(String name, String phone) {

        String customerId = "CUS-" + customerCounter++;

        Customer customer = new Customer(
                customerId,
                name,
                phone);

        repository.save(customer);

        return customer;
    }

    // GET ALL CUSTOMERS
    public Collection<Customer> getAllCustomers() {
        return repository.findAll();
    }

    // FIND CUSTOMER BY ID
    public Customer findCustomerById(String customerId) {
        return repository.findById(customerId);
    }
}
