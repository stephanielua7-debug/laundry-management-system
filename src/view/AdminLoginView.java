package view;

import java.util.Scanner;

public class AdminLoginView {

    private Scanner scanner;

    public AdminLoginView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUsername() {
        System.out.print("Enter Username: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Enter Password: ");
        return scanner.nextLine();
    }

    public void displayLoginHeader() {
        System.out.println("\n=================================");
        System.out.println("     LAUNDRY MANAGEMENT SYSTEM");
        System.out.println("             ADMIN LOGIN");
        System.out.println("=================================");
    }

    public void displayLoginSuccess() {
        System.out.println("\nLogin successful! Welcome, Admin.");
    }

    public void displayLoginFailed() {
        System.out.println("\nInvalid username or password!");
        System.out.println("Please try again.\n");
    }
}
