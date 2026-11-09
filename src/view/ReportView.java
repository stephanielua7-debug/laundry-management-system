package view;

public class ReportView {

    public void displayReport(
            int totalOrders,
            double totalSales,
            double totalPayments,
            double totalBalance) {

        System.out.println("\n========== BUSINESS REPORT ==========");

        System.out.println(
                "Total Orders: " + totalOrders);

        System.out.printf(
                "Total Sales: PHP %.2f%n", totalSales);

        System.out.printf(
                "Total Payments: PHP %.2f%n", totalPayments);

        System.out.printf(
                "Outstanding Balance: PHP %.2f%n",
                totalBalance);

        System.out.println("=====================================");
    }
}
