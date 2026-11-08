package util;

import java.util.Scanner;

public class InputValidator {

    public static int getInt(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            try {

                int value = Integer.parseInt(
                        scanner.nextLine());

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Enter a whole number.");
            }
        }
    }

    public static double getDouble(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            try {

                double value = Double.parseDouble(
                        scanner.nextLine());

                if (Double.isFinite(value)) {
                    return value;
                }

            } catch (NumberFormatException e) {
                // Show validation message below.
            }

            System.out.println(
                    "Invalid input! Enter a valid number.");
        }
    }

    public static String getString(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty!");
        }
    }

    public static double getPositiveDouble(
            Scanner scanner, String message) {

        while (true) {

            double value = getDouble(scanner, message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than zero.");
        }
    }

    public static double getNonNegativeDouble(
            Scanner scanner, String message) {

        while (true) {

            double value = getDouble(scanner, message);

            if (value >= 0) {
                return value;
            }

            System.out.println(
                    "Value cannot be negative.");
        }
    }
}
