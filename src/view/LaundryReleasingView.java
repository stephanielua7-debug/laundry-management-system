package view;

// Handles the display of laundry releasing messages.
public class LaundryReleasingView {

    // Displays a successful laundry release message.
    public void displayReleaseSuccess(String orderId) {

        // Displays the release confirmation.
        System.out.println("\n==================================");
        System.out.println("       LAUNDRY RELEASED!");
        System.out.println("==================================");

        // Displays the order ID and status.
        System.out.println("Order ID: " + orderId);
        System.out.println("Status: Claimed");

        // Displays a thank-you message.
        System.out.println("Thank you for choosing our service!");
        System.out.println("==================================");
    }

    // Displays a general message.
    public void displayMessage(String message) {
        System.out.println(message);
    }
}