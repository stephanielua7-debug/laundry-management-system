package repository;

import model.LaundryOrder;
import java.util.*;

public class LaundryOrderRepository {

    private Map<String, LaundryOrder> orders = new LinkedHashMap<>();

    // Save laundry order
    public void save(LaundryOrder order) {
        orders.put(order.getOrderId().trim(), order);
    }

    // Find laundry order using Order ID
    public LaundryOrder findById(String orderId) {

        if (orderId == null) {
            return null;
        }

        return orders.get(orderId.trim());
    }

    // Get all laundry orders
    public Collection<LaundryOrder> findAll() {
        return orders.values();
    }
}