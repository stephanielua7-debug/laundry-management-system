
package util;

public class InputValidator {

    // Checks if required input is not empty.
    public static String validateRequired(
            String value, String field) {

        if (value == null || value.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    ExceptionMessage.requiredField(field));
        }

        return value.trim();
    }

    // Checks if a number is greater than zero.
    public static double validatePositive(double value) {

        if (value <= 0) {

            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_VALUE);
        }

        return value;
    }
}
