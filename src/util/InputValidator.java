package util;

public class InputValidator {

    // Checks if the required input is not empty or null.
    public static String validateRequired(String value, String field) {

        // Checks if the input is null or contains only spaces.
        if (value == null || value.trim().isEmpty()) {

            // Throws an error if the field is empty.
            throw new IllegalArgumentException(
                    field + " cannot be empty!");
        }

        // Returns the input without extra spaces.
        return value.trim();
    }

    // Checks if a number is greater than zero.
    public static double validatePositive(double value) {

        // Rejects zero and negative values.
        if (value <= 0) {
            throw new IllegalArgumentException(
                    "Value must be greater than zero!");
        }

        // Returns the valid number.
        return value;
    }
}
