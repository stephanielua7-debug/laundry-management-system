package view;

import model.LaundryOrder;
import java.util.Collection;

public class LaundryProcessingView {

    public void displayOrders(Collection<LaundryOrder> orders) {

        System.out.println("\n========== LAUNDRY ORDERS ==========");

        if (orders.isEmpty()) {
            System.out.println("No laundry orders found.");
            return;
        }

        for (LaundryOrder order : orders) {
            System.out.println(order);
        }

        System.out.println("====================================");
    }

    public void displayStatusOptions() {

        System.out.println("\n========== UPDATE LAUNDRY STATUS ==========");
        System.out.println("1. Pending");
        System.out.println("2. Washing");
        System.out.println("3. Drying");
        System.out.println("4. Folding");
        System.out.println("5. Ready for Pickup");
        System.out.println("===========================================");
    }
}
