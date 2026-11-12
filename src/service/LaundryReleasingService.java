
package service;

import model.LaundryOrder;
import repository.LaundryOrderRepository;

public class LaundryReleasingService {

    private LaundryOrderRepository repository;

    public LaundryReleasingService(LaundryOrderRepository repository) {
        this.repository = repository;
    }

    public void releaseLaundry(String orderId) {

        LaundryOrder order = repository.findById(orderId);

        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        if (!order.getStatus().equals("Ready for Pickup")) {
            throw new IllegalArgumentException("Laundry is not ready for pickup!");
        }

        if (!order.getPaymentStatus().equals("Paid")) {
            throw new IllegalArgumentException("Please complete payment first!");
        }

        order.setStatus("Claimed");
    }
}
