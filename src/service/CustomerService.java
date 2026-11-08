package service;

import model.Customer;
import repository.CustomerRepository;
import java.util.ArrayList;
import util.IdGenerator;

public class CustomerService {

    private CustomerRepository repository = new CustomerRepository();

    public void addCustomer(
            String name, String phone, String address) {

        int id = IdGenerator.generateCustomerId();

        Customer customer = new Customer(id, name, phone, address);

        repository.add(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return repository.getAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id);
    }

    public boolean updateCustomer(
            int id, String name,
            String phone, String address) {

        Customer customer = new Customer(
                id, name, phone, address);

        return repository.update(customer);
    }

    public boolean deleteCustomer(int id) {
        return repository.delete(id);
    }
}
