
package service;

import model.LaundryOrder;
import repository.LaundryOrderRepository;

public class LaundryProcessingService {

    private LaundryOrderRepository repository;

    private final String[] statuses = { "Pending", "Washing", "Drying", "Folding", "Ready for Pickup"
    };

    public LaundryProcessingService(
            LaundryOrderRepository repository) {
        this.repository = repository;
    }

    public void updateLaundryStatus(String orderId, int choice) {

        LaundryOrder order = repository.findById(orderId);

        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        if (choice < 1 || choice > statuses.length) {
            throw new IllegalArgumentException("Invalid status choice!");
        }

        order.setStatus(statuses[choice - 1]);
    }
}
