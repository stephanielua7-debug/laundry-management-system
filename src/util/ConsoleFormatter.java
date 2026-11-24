package util;

public class ConsoleFormatter {

    private static final int WIDTH = 42;

    // MAIN HEADER
    public static void printHeader(String title) {
        System.out.println();
        printLine("=");

        int spaces = Math.max(0, (WIDTH - title.length()) / 2);
        System.out.println(" ".repeat(spaces) + title);

        printLine("=");
    }

    // SECTION HEADER
    public static void printSection(String title) {
        System.out.println();
        printLine("-");
        System.out.println(" " + title);
        printLine("-");
    }

    // DISPLAY DIVIDER
    public static void printLine(String symbol) {
        System.out.println(symbol.repeat(WIDTH));
    }

    // SUCCESS MESSAGE
    public static void printSuccess(String message) {
        System.out.println("\n[SUCCESS] " + message);
    }

    // ERROR MESSAGE
    public static void printError(String message) {
        System.out.println("\n[ERROR] " + message);
    }

    // INFORMATION MESSAGE
    public static void printInfo(String message) {
        System.out.println("\n[INFO] " + message);
    }

    // FOOTER
    public static void printFooter() {
        printLine("=");
    }
}
