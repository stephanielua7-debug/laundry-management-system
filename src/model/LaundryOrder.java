
package model;

import java.util.ArrayList;
import java.util.List;

public class LaundryOrder {

    private String orderId;
    private Customer customer;
    private List<LaundryItem> laundryItems;

    private double weight;
    private String serviceName;
    private double pricePerKg;
    private double totalAmount;

    private String paymentStatus;
    private String orderStatus;

    // CONSTRUCTOR
    public LaundryOrder(
            String orderId,
            Customer customer,
            double weight,
            String serviceName,
            double pricePerKg) {

        this.orderId = orderId;
        this.customer = customer;
        this.weight = weight;
        this.serviceName = serviceName;
        this.pricePerKg = pricePerKg;

        this.totalAmount = weight * pricePerKg;

        this.laundryItems = new ArrayList<>();

        this.paymentStatus = "Unpaid";
        this.orderStatus = "Pending";
    }

    // ADD LAUNDRY ITEM
    public void addLaundryItem(LaundryItem item) {
        laundryItems.add(item);
    }

    // GETTERS
    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<LaundryItem> getLaundryItems() {
        return laundryItems;
    }

    public double getWeight() {
        return weight;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // SETTERS
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
