
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

    public LaundryOrder(String orderId, Customer customer,
            double weight, String serviceName,
            double pricePerKg) {

        this.orderId = orderId;
        this.customer = customer;
        this.weight = weight;
        this.serviceName = serviceName;
        this.pricePerKg = pricePerKg;
        this.totalAmount = weight * pricePerKg;

        this.laundryItems = new ArrayList<>();
    }

    public void addLaundryItem(LaundryItem item) {
        laundryItems.add(item);
    }

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
}
