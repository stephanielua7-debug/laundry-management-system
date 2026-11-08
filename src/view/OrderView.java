package view;

import model.Order;
import java.util.ArrayList;

public class OrderView {

    public void displayOrders(ArrayList<Order> orders) {

        System.out.println("\nORDER LIST");
        System.out.println("--------------------------------");

        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
