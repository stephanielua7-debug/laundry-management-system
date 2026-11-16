package model;

// Import LocalDateTime to handle the payment date and time.
import java.time.LocalDateTime;

// LaundryPayment class belongs to the model package.
public class LaundryPayment {

    // Private attributes to store payment information.
    private String paymentId;
    private String orderId;
    private double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;

    // Constructor: initializes payment information
    // whenever a new LaundryPayment object is created.
    public LaundryPayment(String paymentId, String orderId,
            double amount, String paymentMethod) {

        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;

        // Automatically records the current date and time
        // when the payment object is created.
        this.paymentDate = LocalDateTime.now();
    }

    // Getter: returns the payment ID.
    public String getPaymentId() {
        return paymentId;
    }

    // Getter: returns the order ID.
    public String getOrderId() {
        return orderId;
    }

    // Getter: returns the payment amount.
    public double getAmount() {
        return amount;
    }

    // Getter: returns the payment method.
    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Getter: returns the payment date and time.
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    // toString(): displays payment information
    // in a readable format.
    @Override
    public String toString() {
        return paymentId + " | Order: " + orderId
                + " | PHP " + String.format("%.2f", amount)
                + " | " + paymentMethod
                + " | " + paymentDate;
    }
}
