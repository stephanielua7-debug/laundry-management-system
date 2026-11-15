
package util;

public class IdGenerator {

    private static int customerCounter = 1;
    private static int orderCounter = 1;
    private static int serviceCounter = 1;
    private static int paymentCounter = 1;

    public static String generateCustomerId() {
        return String.format("CUS%04d", customerCounter++);
    }

    public static String generateOrderId() {
        return String.format("LND%04d", orderCounter++);
    }

    public static String generateServiceId() {
        return String.format("SRV%03d", serviceCounter++);
    }

    public static String generatePaymentId() {
        return String.format("PAY%04d", paymentCounter++);
    }
}
