
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

    public static LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "Invalid date! Use YYYY-MM-DD format.");
        }
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now(ZoneId.of("Asia/Manila"));
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(ZoneId.of("Asia/Manila"));
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DATE_TIME_FORMAT);
    }
}
