
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LaundryOrder {

    private String orderId;
    private String customerId;
    private String serviceId;
    private double weightKg;
    private double totalAmount;
    private LocalDate receivedDate;
    private LocalDate dueDate;
    private String status;
    private String paymentStatus;

    private List<LaundryItem> items;

    public LaundryOrder(String orderId, String customerId,
            String serviceId, double weightKg,
            double totalAmount, LocalDate dueDate,
            List<LaundryItem> items) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.weightKg = weightKg;
        this.totalAmount = totalAmount;

        this.receivedDate = LocalDate.now();
        this.dueDate = dueDate;

        this.status = "Pending";
        this.paymentStatus = "Unpaid";

        this.items = new ArrayList<>(items);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public List<LaundryItem> getItems() {
        return items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId
                + " | Customer ID: " + customerId
                + " | Weight: " + weightKg + " kg"
                + " | Total: PHP " + String.format("%.2f", totalAmount)
                + " | Status: " + status
                + " | Payment: " + paymentStatus
                + " | Due Date: " + dueDate;
    }
}
