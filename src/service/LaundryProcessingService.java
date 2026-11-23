
package service;

import model.LaundryOrder;
import repository.LaundryOrderRepository;
import util.ExceptionMessage;

public class LaundryProcessingService {

    private LaundryOrderRepository repository;

    private final String[] statuses = {
            "Pending",
            "Washing",
            "Drying",
            "Folding",
            "Ready for Pickup"
    };

    public LaundryProcessingService(
            LaundryOrderRepository repository) {

        this.repository = repository;
    }

    // UPDATE LAUNDRY STATUS
    public void updateLaundryStatus(String orderId, int choice) {

        LaundryOrder order = repository.findById(orderId.trim());

        if (order == null) {
            throw new IllegalArgumentException(
                    ExceptionMessage.ORDER_NOT_FOUND);
        }

        if (choice < 1 || choice > statuses.length) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_STATUS);
        }

        order.setOrderStatus(statuses[choice - 1]);
    }
}
