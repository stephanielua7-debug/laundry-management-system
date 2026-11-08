package util;

public class IdGenerator {

    private static int customerId = 1;
    private static int orderId = 1;
    private static int serviceId = 1;
    private static int paymentId = 1;
    private static int inventoryId = 1;

    public static int generateCustomerId() {
        return customerId++;
    }

    public static int generateOrderId() {
        return orderId++;
    }

    public static int generateServiceId() {
        return serviceId++;
    }

    public static int generatePaymentId() {
        return paymentId++;
    }

    public static int generateInventoryId() {
        return inventoryId++;
    }
}
