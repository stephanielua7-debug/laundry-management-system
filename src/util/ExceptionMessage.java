
package util;

public class ExceptionMessage {

    // GENERAL VALIDATION
    public static final String REQUIRED_FIELD = " cannot be empty!";

    public static final String INVALID_VALUE = "Value must be greater than zero!";

    // LAUNDRY ORDER
    public static final String ORDER_NOT_FOUND = "Order not found!";

    // LAUNDRY PROCESSING
    public static final String INVALID_STATUS = "Invalid status choice!";

    // PAYMENT
    public static final String ALREADY_PAID = "This order is already paid!";

    public static final String PAYMENT_METHOD_REQUIRED = "Payment method is required!";

    // LAUNDRY RELEASING
    public static final String NOT_READY_FOR_PICKUP = "Laundry is not ready for pickup!";

    public static final String PAYMENT_REQUIRED = "Please complete payment first!";

    // REQUIRED FIELD MESSAGE
    public static String requiredField(String field) {
        return field + REQUIRED_FIELD;
    }
}
