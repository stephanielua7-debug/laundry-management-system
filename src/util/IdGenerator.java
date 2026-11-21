
package util;

public class IdGenerator {

    private static int customerCounter = 1;
    private static int orderCounter = 1;
    private static int serviceCounter = 1;
    private static int paymentCounter = 1;

    // Generates customer ID (1, 2, 3...)
    public static String generateCustomerId() {
        return String.valueOf(customerCounter++);
    }

    // Generates order ID (1, 2, 3...)
    public static String generateOrderId() {
        return String.valueOf(orderCounter++);
    }

    // Generates service ID (1, 2, 3...)
    public static String generateServiceId() {
        return String.valueOf(serviceCounter++);
    }

    // Generates payment ID (1, 2, 3...)
    public static String generatePaymentId() {
        return String.valueOf(paymentCounter++);
    }
}
