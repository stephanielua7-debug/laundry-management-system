
package util;

public class InputValidator {

    public static String validateRequired(String value, String field) {

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    field + " cannot be empty!");
        }

        return value.trim();
    }

    public static double validatePositive(double value) {

        if (value <= 0) {
            throw new IllegalArgumentException(
                    "Value must be greater than zero!");
        }

        return value;
    }
}
