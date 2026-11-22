
package repository;

// Imports the LaundryOrder class
import model.LaundryOrder;

// Imports Java utility classes such as Map, LinkedHashMap, and Collection
import java.util.*;

public class LaundryOrderRepository {

    // Creates a LinkedHashMap to store laundry orders.
    // String represents the Order ID.
    // LaundryOrder represents the order information.
    private Map<String, LaundryOrder> orders = new LinkedHashMap<>();

    // Saves a new laundry order or updates an existing one.
    public void save(LaundryOrder order) {
        orders.put(order.getOrderId(), order);
    }

    // Searches for a laundry order using its Order ID.
    // Returns the order if found; otherwise, returns null.
    public LaundryOrder findById(String orderId) {
        return orders.get(orderId);
    }

    // Retrieves and returns all saved laundry orders.
    public Collection<LaundryOrder> findAll() {
        return orders.values();
    }

}
