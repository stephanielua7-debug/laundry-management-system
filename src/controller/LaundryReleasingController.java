
package controller;

import service.LaundryReleasingService;
import repository.LaundryOrderRepository;
import view.LaundryProcessingView;
import view.LaundryReleasingView;
import util.ConsoleHelper;

public class LaundryReleasingController {

    private LaundryReleasingService releasingService;
    private LaundryOrderRepository orderRepository;
    private LaundryProcessingView processingView;
    private LaundryReleasingView releasingView;

    public LaundryReleasingController(
            LaundryReleasingService releasingService,
            LaundryOrderRepository orderRepository,
            LaundryReleasingView releasingView) {

        this.releasingService = releasingService;
        this.orderRepository = orderRepository;
        this.releasingView = releasingView;
        this.processingView = new LaundryProcessingView();
    }

    public void releaseLaundry() {

        processingView.displayOrders(
                orderRepository.findAll());

        String orderId = ConsoleHelper.readString("Enter Order ID to Release: ");

        try {

            releasingService.releaseLaundry(orderId);

            releasingView.displayReleaseSuccess(orderId);

        } catch (Exception e) {

            releasingView.displayMessage(
                    "Error: " + e.getMessage());
        }

        ConsoleHelper.pause();
    }
}
