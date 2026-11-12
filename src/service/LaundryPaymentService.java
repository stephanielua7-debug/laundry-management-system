
package service;

import model.*;
import repository.*;
import util.IdGenerator;

import java.util.Collection;

public class LaundryPaymentService {

    private LaundryOrderRepository orderRepository;
    private LaundryPaymentRepository paymentRepository;

    public LaundryPaymentService(
            LaundryOrderRepository orderRepository,
            LaundryPaymentRepository paymentRepository) {

        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    public LaundryPayment payLaundry(
            String orderId, String paymentMethod) {

        LaundryOrder order = orderRepository.findById(orderId);

        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        if (order.getPaymentStatus().equals("Paid")) {
            throw new IllegalArgumentException(
                    "This order is already paid!");
        }

        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Payment method is required!");
        }

        LaundryPayment payment = new LaundryPayment(
                IdGenerator.generatePaymentId(),
                orderId,
                order.getTotalAmount(),
                paymentMethod);

        paymentRepository.save(payment);

        order.setPaymentStatus("Paid");

        return payment;
    }

    public Collection<LaundryPayment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
