package service;

// Imports the LaundryOrder class
import model.LaundryOrder;

// Imports the LaundryOrderRepository class
import repository.LaundryOrderRepository;

public class LaundryProcessingService {

    // Creates a reference to LaundryOrderRepository
    // to access and manage saved laundry orders.
    private LaundryOrderRepository repository;

    // Stores the available laundry processing statuses.
    private final String[] statuses = {
            "Pending",
            "Washing",
            "Drying",
            "Folding",
            "Ready for Pickup"
    };

    // Constructor that receives the LaundryOrderRepository.
    // This allows the service to access the order records.
    public LaundryProcessingService(
            LaundryOrderRepository repository) {
        this.repository = repository;
    }

    // Updates the status of a laundry order using its Order ID
    // and the selected status number.
    public void updateLaundryStatus(String orderId, int choice) {

        // Searches for the laundry order using its Order ID.
        LaundryOrder order = repository.findById(orderId);

        // Checks if the order exists.
        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        // Checks if the selected status number is valid.
        if (choice < 1 || choice > statuses.length) {
            throw new IllegalArgumentException("Invalid status choice!");
        }

        // Updates the laundry order with the selected status.
        order.setStatus(statuses[choice - 1]);
    }
}
