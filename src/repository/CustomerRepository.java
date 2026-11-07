package repository;

import model.Customer;
import java.util.ArrayList;

public class CustomerRepository {

    private static ArrayList<Customer> customers = new ArrayList<>();

    public void add(Customer customer) {
        customers.add(customer);
    }

    public ArrayList<Customer> getAll() {
        return new ArrayList<>(customers);
    }

    public Customer findById(int id) {

        for (Customer customer : customers) {

            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }

    public boolean update(Customer updatedCustomer) {

        Customer customer = findById(updatedCustomer.getId());

        if (customer != null) {

            customer.setName(updatedCustomer.getName());
            customer.setPhone(updatedCustomer.getPhone());
            customer.setAddress(updatedCustomer.getAddress());

            return true;
        }

        return false;
    }

    public boolean delete(int id) {

        Customer customer = findById(id);

        if (customer != null) {
            customers.remove(customer);
            return true;
        }

        return false;
    }
}