package service;

import model.Payment;
import model.Order;
import repository.PaymentRepository;
import repository.OrderRepository;
import java.util.ArrayList;
import util.IdGenerator;
import java.time.LocalDate;

public class PaymentService {

    private PaymentRepository paymentRepository = new PaymentRepository();

    private OrderRepository orderRepository = new OrderRepository();

    public boolean addPayment(
            int orderId, double amount, String method) {

        Order order = orderRepository.findById(orderId);

        if (order == null || amount <= 0) {
            return false;
        }

        double alreadyPaid = 0;

        for (Payment payment : paymentRepository.findByOrderId(orderId)) {

            alreadyPaid += payment.getAmount();
        }

        double balance = order.getTotalAmount() - alreadyPaid;

        if (amount > balance) {
            return false;
        }

        int id = IdGenerator.generatePaymentId();

        Payment payment = new Payment(
                id,
                orderId,
                amount,
                method,
                LocalDate.now());

        paymentRepository.add(payment);

        return true;
    }

    public ArrayList<Payment> getAllPayments() {
        return paymentRepository.getAll();
    }

    public ArrayList<Payment> getPaymentsByOrderId(
            int orderId) {

        return paymentRepository.findByOrderId(orderId);
    }

    public boolean deletePayment(int id) {
        return paymentRepository.delete(id);
    }

    public double getTotalPaid(int orderId) {

        double total = 0;

        for (Payment payment : paymentRepository.findByOrderId(orderId)) {

            total += payment.getAmount();
        }

        return total;
    }
}
