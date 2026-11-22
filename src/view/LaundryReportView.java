
package view;

import model.*;
import java.util.Collection;

// Handles the display of laundry reports.
public class LaundryReportView {

        // Displays the laundry report and payment summary.
        public void displayReport(
                        Collection<LaundryOrder> orders,
                        double totalPaid) {

                // Displays the report heading.
                System.out.println("\n==============================================");
                System.out.println("             LAUNDRY REPORT");
                System.out.println("==============================================");

                // Initializes the order counters.
                int totalOrders = 0;
                int claimedOrders = 0;
                int pendingOrders = 0;

                // Loops through all laundry orders.
                for (LaundryOrder order : orders) {

                        // Counts the total number of orders.
                        totalOrders++;

                        // Counts claimed orders.
                        if (order.getOrderStatus().equals("Claimed")) {
                                claimedOrders++;
                        }

                        // Counts pending orders.
                        if (order.getOrderStatus().equals("Pending")) {
                                pendingOrders++;
                        }
                }

                // Displays the order summary.
                System.out.println("Total Laundry Orders: " + totalOrders);
                System.out.println("Claimed Orders: " + claimedOrders);
                System.out.println("Pending Orders: " + pendingOrders);

                // Displays total payments received.
                System.out.printf(
                                "Total Payments Received: PHP %.2f%n",
                                totalPaid);

                // Displays the bottom border.
                System.out.println("==============================================");
        }
}
