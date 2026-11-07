package model;

import java.time.LocalDate;

public class Payment {

    private int id;
    private int orderId;
    private double amount;
    private String method;
    private LocalDate paymentDate;

    public Payment(int id, int orderId,
            double amount, String method,
            LocalDate paymentDate) {

        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Payment ID: " + id +
                " | Order ID: " + orderId +
                " | Amount: PHP " + amount +
                " | Method: " + method +
                " | Date: " + paymentDate;
    }
}