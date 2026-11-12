
package repository;

import model.LaundryOrder;
import java.util.*;

public class LaundryOrderRepository {

    private Map<String, LaundryOrder> orders = new LinkedHashMap<>();

    public void save(LaundryOrder order) {
        orders.put(order.getOrderId(), order);
    }

    public LaundryOrder findById(String orderId) {
        return orders.get(orderId);
    }

    public Collection<LaundryOrder> findAll() {
        return orders.values();
    }
}
