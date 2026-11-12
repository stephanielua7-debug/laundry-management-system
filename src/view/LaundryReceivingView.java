
package view;

import model.LaundryOrder;
import model.LaundryService;
import java.util.Collection;

public class LaundryReceivingView {

    public void displayServices(Collection<LaundryService> services) {

        System.out.println("\n========== AVAILABLE SERVICES ==========");

        if (services.isEmpty()) {
            System.out.println("No laundry services available.");
            return;
        }

        for (LaundryService service : services) {
            System.out.println(service);
        }
    }

    public void displayOrder(LaundryOrder order) {

        System.out.println("\n========== LAUNDRY RECEIPT ==========");

        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer ID: " + order.getCustomerId());
        System.out.println("Service ID: " + order.getServiceId());
        System.out.println("Laundry Weight: " + order.getWeightKg() + " kg");

        System.out.printf("Total Amount: PHP %.2f%n",
                order.getTotalAmount());

        System.out.println("Received Date: " + order.getReceivedDate());
        System.out.println("Due Date: " + order.getDueDate());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Payment: " + order.getPaymentStatus());

        System.out.println("=====================================");
    }
}
