
package service;

// Imports all classes from the model package
import model.*;

// Imports all classes from the repository package
import repository.*;

// Imports Collection for handling groups of records
import java.util.Collection;

public class LaundryReportService {

    // Repository for accessing laundry orders
    private final LaundryOrderRepository orderRepository;

    // Repository for accessing customer records
    private final CustomerRepository customerRepository;

    // Repository for accessing laundry service records
    private final LaundryServiceRepository serviceRepository;

    // Constructor
    public LaundryReportService(
            LaundryOrderRepository orderRepository,
            CustomerRepository customerRepository,
            LaundryServiceRepository serviceRepository) {

        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    // Retrieves all laundry orders
    public Collection<LaundryOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    // Retrieves customer information using Customer ID
    public Customer getCustomer(String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    // Retrieves laundry service information using Service ID
    public LaundryService getService(String serviceId) {
        return serviceRepository.findById(serviceId);
    }

    // Counts total laundry orders
    public int getTotalOrders() {
        return orderRepository.findAll().size();
    }

    // Calculates total amount from paid orders
    public double getTotalPaid() {

        double total = 0;

        for (LaundryOrder order : orderRepository.findAll()) {

            if (order.getPaymentStatus().equals("Paid")) {
                total += order.getTotalAmount();
            }
        }

        return total;
    }
}
