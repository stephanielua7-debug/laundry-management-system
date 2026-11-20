package service;

// Imports the LaundryOrder class
import model.LaundryOrder;

// Imports the LaundryOrderRepository class
import repository.LaundryOrderRepository;

public class LaundryReleasingService {

    // Creates a reference to LaundryOrderRepository
    // to access saved laundry orders.
    private LaundryOrderRepository repository;

    // Constructor that receives the LaundryOrderRepository.
    public LaundryReleasingService(LaundryOrderRepository repository) {
        this.repository = repository;
    }

    // Releases a laundry order using its Order ID.
    public void releaseLaundry(String orderId) {

        // Searches for the laundry order using its Order ID.
        LaundryOrder order = repository.findById(orderId);

        // Checks if the order exists.
        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        // Checks if the laundry is ready for pickup.
        if (!order.getStatus().equals("Ready for Pickup")) {
            throw new IllegalArgumentException("Laundry is not ready for pickup!");
        }

        // Checks if the customer has completed the payment.
        if (!order.getPaymentStatus().equals("Paid")) {
            throw new IllegalArgumentException("Please complete payment first!");
        }

        // Updates the laundry status to Claimed.
        order.setStatus("Claimed");
    }
}