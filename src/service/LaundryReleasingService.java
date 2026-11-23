package service;

import model.LaundryOrder;
import repository.LaundryOrderRepository;
import util.ExceptionMessage;

public class LaundryReleasingService {

    private LaundryOrderRepository repository;

    public LaundryReleasingService(
            LaundryOrderRepository repository) {

        this.repository = repository;
    }

    // RELEASE LAUNDRY ORDER
    public void releaseLaundry(String orderId) {

        LaundryOrder order = repository.findById(orderId.trim());

        // Check if order exists
        if (order == null) {
            throw new IllegalArgumentException(
                    ExceptionMessage.ORDER_NOT_FOUND);
        }

        // Check if laundry is ready
        if (!order.getOrderStatus().equals("Ready for Pickup")) {
            throw new IllegalArgumentException(
                    ExceptionMessage.NOT_READY_FOR_PICKUP);
        }

        // Check if payment is completed
        if (!order.getPaymentStatus().equals("Paid")) {
            throw new IllegalArgumentException(
                    ExceptionMessage.PAYMENT_REQUIRED);
        }

        // Update status
        order.setOrderStatus("Claimed");

        System.out.println("Laundry successfully released!");
    }
}
