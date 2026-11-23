
package service;

import model.*;
import repository.*;
import util.IdGenerator;
import util.ExceptionMessage;

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

    // PROCESS LAUNDRY PAYMENT
    public LaundryPayment payLaundry(
            String orderId, String paymentMethod) {

        LaundryOrder order = orderRepository.findById(orderId.trim());

        if (order == null) {
            throw new IllegalArgumentException(
                    ExceptionMessage.ORDER_NOT_FOUND);
        }

        if ("Paid".equals(order.getPaymentStatus())) {
            throw new IllegalArgumentException(
                    ExceptionMessage.ALREADY_PAID);
        }

        if (paymentMethod == null
                || paymentMethod.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    ExceptionMessage.PAYMENT_METHOD_REQUIRED);
        }

        LaundryPayment payment = new LaundryPayment(
                IdGenerator.generatePaymentId(),
                orderId.trim(),
                order.getTotalAmount(),
                paymentMethod.trim());

        paymentRepository.save(payment);

        order.setPaymentStatus("Paid");

        return payment;
    }

    // GET ALL PAYMENTS
    public Collection<LaundryPayment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
