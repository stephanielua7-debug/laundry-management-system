package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {

    private int id;
    private int customerId;
    private int serviceId;

    private double weightKg;
    private double totalAmount;

    private String status;
    private LocalDate orderDate;

    public Order(int id, int customerId,
            int serviceId, double weightKg,
            double totalAmount, String status,
            LocalDate orderDate) {

        this.id = id;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.weightKg = weightKg;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order ID: " + id +
                " | Customer ID: " + customerId +
                " | Service ID: " + serviceId +
                " | Weight: " + weightKg + " kg" +
                " | Total: PHP " + totalAmount +
                " | Status: " + status +
                " | Date: " + orderDate;
    }
}