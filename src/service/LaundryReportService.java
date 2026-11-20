package service;

// Imports all classes from the model package
import model.*;

// Imports all classes from the repository package
import repository.*;

// Imports Collection for handling groups of records
import java.util.Collection;

public class LaundryReportService {

    // Repository for accessing laundry orders
    private LaundryOrderRepository orderRepository;

    // Repository for accessing customer records
    private CustomerRepository customerRepository;

    // Repository for accessing laundry service records
    private LaundryServiceRepository serviceRepository;

    // Constructor that receives the required repositories
    public LaundryReportService(
            LaundryOrderRepository orderRepository,
            CustomerRepository customerRepository,
            LaundryServiceRepository serviceRepository) {

        // Assigns the received repositories to the class variables
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    // Retrieves all laundry orders
    public Collection<LaundryOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    // Retrieves customer information using the Customer ID
    public Customer getCustomer(String customerId) {
        return customerRepository.findById(customerId);
    }

    // Retrieves laundry service information using the Service ID
    public LaundryService getService(String serviceId) {
        return serviceRepository.findById(serviceId);
    }

    // Counts the total number of laundry orders
    public int getTotalOrders() {
        return orderRepository.findAll().size();
    }

    // Calculates the total amount from all paid orders
    public double getTotalPaid() {

        // Initializes the total amount to zero
        double total = 0;

        // Loops through all saved laundry orders
        for (LaundryOrder order : orderRepository.findAll()) {

            // Checks if the payment status is Paid
            if (order.getPaymentStatus().equals("Paid")) {

                // Adds the order amount to the total
                total += order.getTotalAmount();
            }
        }

        // Returns the total amount collected from paid orders
        return total;
    }
}
