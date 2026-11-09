package controller;

import service.ReportService;
import view.ReportView;

public class ReportController {

    private ReportService service = new ReportService();

    private ReportView view = new ReportView();

    public void run() {

        view.displayReport(
                service.getTotalOrders(),
                service.getTotalSales(),
                service.getTotalPayments(),
                service.getTotalBalance());
    }
}