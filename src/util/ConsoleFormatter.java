
package util;

public class ConsoleFormatter {

    private static final int WIDTH = 42;

    // DISPLAY MAIN HEADER
    public static void printHeader(String title) {

        System.out.println();
        printLine("=");
        System.out.printf("%" + ((WIDTH + title.length()) / 2)
                + "s%n", title);
        printLine("=");
    }

    // DISPLAY SECTION HEADER
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

    // DISPLAY SUCCESS MESSAGE
    public static void printSuccess(String message) {

        System.out.println("\n[SUCCESS] " + message);
    }

    // DISPLAY ERROR MESSAGE
    public static void printError(String message) {

        System.out.println("\n[ERROR] " + message);
    }

    // DISPLAY INFORMATION MESSAGE
    public static void printInfo(String message) {

        System.out.println("\n[INFO] " + message);
    }

    // DISPLAY FOOTER
    public static void printFooter() {

        printLine("=");
    }
}
