package service;

import model.Order;
import model.Payment;
import java.util.ArrayList;

public class ReportService {

    private OrderService orderService = new OrderService();

    private PaymentService paymentService = new PaymentService();

    public int getTotalOrders() {

        return orderService.getAllOrders().size();
    }

    public double getTotalSales() {

        double total = 0;

        for (Order order : orderService.getAllOrders()) {

            if (!order.getStatus().equals("CANCELLED")) {
                total += order.getTotalAmount();
            }
        }

        return total;
    }

    public double getTotalPayments() {

        double total = 0;

        for (Payment payment : paymentService.getAllPayments()) {

            total += payment.getAmount();
        }

        return total;
    }

    public double getTotalBalance() {

        double balance = 0;

        for (Order order : orderService.getAllOrders()) {

            if (!order.getStatus().equals("CANCELLED")) {

                double paid = paymentService.getTotalPaid(
                        order.getId());

                balance += order.getTotalAmount() - paid;
            }
        }

        return balance;
    }

    public ArrayList<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
