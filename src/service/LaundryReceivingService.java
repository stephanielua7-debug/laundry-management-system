
package service;

import model.Customer;
import model.LaundryItem;
import model.LaundryOrder;

import repository.LaundryOrderRepository;

import java.util.Collection;

public class LaundryReceivingService {

    private int orderCounter = 1;

    private CustomerService customerService;
    private LaundryOrderRepository orderRepository;

    public LaundryReceivingService(
            CustomerService customerService,
            LaundryOrderRepository orderRepository) {

        this.customerService = customerService;
        this.orderRepository = orderRepository;
    }

    // Retrieve registered customers
    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Find selected customer
    public Customer findCustomer(String customerId) {
        return customerService.findCustomerById(customerId);
    }

    // Create laundry order
    public LaundryOrder createOrder(
            Customer customer,
            double weight,
            String serviceName,
            double pricePerKg) {

        String orderId = " " + orderCounter++;

        return new LaundryOrder(
                orderId,
                customer,
                weight,
                serviceName,
                pricePerKg);
    }

    // Add laundry item
    public void addLaundryItem(
            LaundryOrder order,
            String itemName,
            int quantity) {

        LaundryItem item = new LaundryItem(itemName, quantity);

        order.addLaundryItem(item);
    }

    // Save laundry order
    public void saveOrder(LaundryOrder order) {
        orderRepository.save(order);
    }
}
