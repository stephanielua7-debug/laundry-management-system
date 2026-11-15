
package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateUtil {

    public static LocalDate parseDate(String date) {

        try {
            return LocalDate.parse(date);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "Invalid date! Use YYYY-MM-DD format.");
        }
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
