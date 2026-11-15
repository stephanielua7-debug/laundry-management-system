
package view;

public class LaundryReleasingView {

    public void displayReleaseSuccess(String orderId) {

        System.out.println("\n==================================");
        System.out.println("       LAUNDRY RELEASED!");
        System.out.println("==================================");
        System.out.println("Order ID: " + orderId);
        System.out.println("Status: Claimed");
        System.out.println("Thank you for choosing our service!");
        System.out.println("==================================");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
