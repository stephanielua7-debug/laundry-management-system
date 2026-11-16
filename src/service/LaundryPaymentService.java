package service;

import model.*;
import repository.*;
import util.IdGenerator;

import java.util.Collection;

public class LaundryPaymentService {

    // Repositories used to access laundry orders and payment records
    private LaundryOrderRepository orderRepository;
    private LaundryPaymentRepository paymentRepository;

    // Constructor: receives the required repositories
    public LaundryPaymentService(
            LaundryOrderRepository orderRepository,
            LaundryPaymentRepository paymentRepository) {

        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    // Processes payment for a laundry order
    public LaundryPayment payLaundry(
            String orderId, String paymentMethod) {

        // Find the laundry order using its ID
        LaundryOrder order = orderRepository.findById(orderId);

        // Check if the order exists
        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        // Check if the order has already been paid
        if (order.getPaymentStatus().equals("Paid")) {
            throw new IllegalArgumentException(
                    "This order is already paid!");
        }

        // Check if the payment method is empty
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Payment method is required!");
        }

        // Create a new payment record
        LaundryPayment payment = new LaundryPayment(
                IdGenerator.generatePaymentId(),
                orderId,
                order.getTotalAmount(),
                paymentMethod);

        // Save the payment record
        paymentRepository.save(payment);

        // Update the order's payment status
        order.setPaymentStatus("Paid");

        // Return the payment information
        return payment;
    }

    // Returns all payment records
    public Collection<LaundryPayment> getAllPayments() {
        return paymentRepository.findAll();
    }
}