
package controller;

import service.LaundryReportService;
import view.LaundryReportView;
import util.ConsoleHelper;

public class LaundryReportController {

    private LaundryReportService reportService;
    private LaundryReportView reportView;

    public LaundryReportController(
            LaundryReportService reportService,
            LaundryReportView reportView) {

        this.reportService = reportService;
        this.reportView = reportView;
    }

    public void displayReport() {

        reportView.displayReport(
                reportService.getAllOrders(),
                reportService.getTotalPaid());

        ConsoleHelper.pause();
    }
}
