
package model;

import java.time.LocalDateTime;

public class LaundryPayment {
    private String paymentId;
    private String orderId;
    private double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;

    public LaundryPayment(String paymentId, String orderId,
            double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDateTime.now();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return paymentId + " | Order: " + orderId
                + " | PHP " + String.format("%.2f", amount)
                + " | " + paymentMethod
                + " | " + paymentDate;
    }
}
