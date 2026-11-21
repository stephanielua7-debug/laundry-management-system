package service;

// Imports the LaundryOrder class
import model.LaundryOrder;

// Imports the LaundryOrderRepository class
import repository.LaundryOrderRepository;

public class LaundryReleasingService {

    // Creates a reference to LaundryOrderRepository
    private LaundryOrderRepository repository;

    // Constructor
    public LaundryReleasingService(LaundryOrderRepository repository) {
        this.repository = repository;
    }

    // Releases a laundry order using its Order ID
    public void releaseLaundry(String orderId) {

        // Searches for the laundry order
        LaundryOrder order = repository.findById(orderId);

        // Checks if the order exists
        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        // Checks if laundry is ready for pickup
        if (!order.getOrderStatus().equals("Ready for Pickup")) {
            throw new IllegalArgumentException(
                    "Laundry is not ready for pickup!");
        }

        // Checks if payment is completed
        if (!order.getPaymentStatus().equals("Paid")) {
            throw new IllegalArgumentException(
                    "Please complete payment first!");
        }

        // Updates laundry status to Claimed
        order.setOrderStatus("Claimed");

        System.out.println("Laundry successfully released!");
    }
}
