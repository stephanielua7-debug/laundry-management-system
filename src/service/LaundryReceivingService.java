package service;

// Imports all classes from the model package
import model.*;

// Imports all classes from the repository package
import repository.*;

// Imports the utility class for generating unique IDs
import util.IdGenerator;

// Imports LocalDate for handling due dates
import java.time.LocalDate;

// Imports List for handling laundry items
import java.util.List;

public class LaundryReceivingService {

    // Repository for storing and retrieving laundry orders
    private LaundryOrderRepository orderRepository;

    // Repository for accessing customer records
    private CustomerRepository customerRepository;

    // Repository for accessing available laundry services
    private LaundryServiceRepository serviceRepository;

    // Constructor that receives the required repositories
    public LaundryReceivingService(
            LaundryOrderRepository orderRepository,
            CustomerRepository customerRepository,
            LaundryServiceRepository serviceRepository) {

        // Assigns the received repositories to the class variables
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    // Receives laundry information and creates a new laundry order
    public LaundryOrder receiveLaundry(
            String customerId,
            String serviceId,
            double weight,
            LocalDate dueDate,
            List<LaundryItem> items) {

        // Checks if the customer exists in the repository
        if (customerRepository.findById(customerId) == null) {
            throw new IllegalArgumentException("Customer not found!");
        }

        // Searches for the selected laundry service
        LaundryService service = serviceRepository.findById(serviceId);

        // Checks if the selected service exists
        if (service == null) {
            throw new IllegalArgumentException("Service not found!");
        }

        // Checks if the laundry weight is valid
        if (weight <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be greater than zero!");
        }

        // Checks if the due date is valid
        if (dueDate == null || dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Due date cannot be in the past!");
        }

        // Calculates the total amount based on weight and service price
        double totalAmount = weight * service.getPricePerKg();

        // Creates a new laundry order with the generated Order ID
        LaundryOrder order = new LaundryOrder(
                IdGenerator.generateOrderId(),
                customerId,
                serviceId,
                weight,
                totalAmount,
                dueDate,
                items);

        // Saves the newly created order in the repository
        orderRepository.save(order);

        // Returns the created laundry order
        return order;
    }
}