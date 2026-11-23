
package model;

// Import LocalDateTime and DateUtil.
import java.time.LocalDateTime;
import util.DateUtil;

// Stores the payment details of a laundry order.
public class LaundryPayment {

    // Payment information.
    private String paymentId;
    private String orderId;
    private double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;

    // Initializes the payment details.
    public LaundryPayment(String paymentId, String orderId,
            double amount, String paymentMethod) {

        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;

        // Records the current payment date and time.
        this.paymentDate = DateUtil.getCurrentDateTime();
    }

    // Returns the payment ID.
    public String getPaymentId() {
        return paymentId;
    }

    // Returns the order ID.
    public String getOrderId() {
        return orderId;
    }

    // Returns the payment amount.
    public double getAmount() {
        return amount;
    }

    // Returns the payment method.
    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Returns the payment date and time.
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    // Displays payment details in a readable format.
    @Override
    public String toString() {
        return paymentId + " | Order: " + orderId
                + " | PHP " + String.format("%.2f", amount)
                + " | " + paymentMethod
                + " | " + DateUtil.formatDateTime(paymentDate);
    }
}
