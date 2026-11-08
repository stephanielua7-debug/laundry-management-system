package repository;

import model.Order;
import java.util.ArrayList;

public class OrderRepository {

    private static ArrayList<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getAll() {
        return new ArrayList<>(orders);
    }

    public Order findById(int id) {

        for (Order order : orders) {

            if (order.getId() == id) {
                return order;
            }
        }

        return null;
    }

    public boolean update(Order updatedOrder) {

        Order order = findById(updatedOrder.getId());

        if (order != null) {

            order.setStatus(updatedOrder.getStatus());

            return true;
        }

        return false;
    }

    public boolean delete(int id) {

        Order order = findById(id);

        if (order != null) {
            orders.remove(order);
            return true;
        }

        return false;
    }
}
