
package view;

import model.*;
import java.util.Collection;

public class LaundryReportView {

        public void displayReport(
                        Collection<LaundryOrder> orders,
                        double totalPaid) {

                System.out.println("\n==============================================");
                System.out.println("             LAUNDRY REPORT");
                System.out.println("==============================================");

                int totalOrders = 0;
                int claimedOrders = 0;
                int pendingOrders = 0;

                for (LaundryOrder order : orders) {

                        totalOrders++;

                        if (order.getStatus().equals("Claimed")) {
                                claimedOrders++;
                        }

                        if (order.getStatus().equals("Pending")) {
                                pendingOrders++;
                        }

                        System.out.println(order);
                }

                System.out.println("----------------------------------------------");
                System.out.println("Total Laundry Orders: " + totalOrders);
                System.out.println("Claimed Orders: " + claimedOrders);
                System.out.println("Pending Orders: " + pendingOrders);

                System.out.printf("Total Payments Received: PHP %.2f%n",
                                totalPaid);

                System.out.println("==============================================");
        }
}
