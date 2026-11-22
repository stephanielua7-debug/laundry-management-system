
package view;

import model.LaundryOrder;
import model.LaundryItem;

import java.util.Collection;

public class LaundryProcessingView {

    // Displays all laundry orders.
    public void displayOrders(Collection<LaundryOrder> orders) {

        System.out.println("\n========== LAUNDRY ORDERS ==========");

        // Checks if there are no orders.
        if (orders.isEmpty()) {
            System.out.println("No laundry orders found.");
            System.out.println("====================================");
            return;
        }

        // Displays each laundry order.
        for (LaundryOrder order : orders) {

            System.out.println("\n------------------------------------");

            System.out.println("Order ID: " + order.getOrderId());

            System.out.println("Customer: "
                    + order.getCustomer().getCustomerName());

            System.out.println("Contact Number: "
                    + order.getCustomer().getContactNumber());

            System.out.println("\nLaundry Items:");

            int totalPieces = 0;

            for (LaundryItem item : order.getLaundryItems()) {

                System.out.println("- " + item.getItemName()
                        + " x " + item.getQuantity());

                totalPieces += item.getQuantity();
            }

            System.out.println("\nTotal Pieces: " + totalPieces);

            System.out.println("Weight: "
                    + order.getWeight() + " kg");

            System.out.println("Service: "
                    + order.getServiceName());

            System.out.printf("Price per KG: PHP %.2f%n",
                    order.getPricePerKg());

            System.out.printf("Total Amount: PHP %.2f%n",
                    order.getTotalAmount());

            System.out.println("Order Status: "
                    + order.getOrderStatus());

            System.out.println("Payment Status: "
                    + order.getPaymentStatus());

            System.out.println("------------------------------------");
        }

        System.out.println("====================================");
    }

    // Displays available laundry status options.
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
