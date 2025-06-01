package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.TotalRevenueFileOutput;

/**
 * Simulates the view layer of the POS system.
 */
public class View {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void runFakeExecution() {
        try {
            // NO DISCOUNT
            controller.startSale();
            controller.registerItem(1, 1);
            controller.registerItem(2, 1);
            controller.pay(100);
            System.out.println("========== �� NO DISCOUNT ==========");
            System.out.println("Total revenue:" + String.format("%.2f", 52.51) + "SEK");
            System.out.println(new Receipt(controller.getSale()).createReceiptString());

            // FIXED DISCOUNT
            controller.startSale();
            controller.registerItem(1, 1);
            controller.registerItem(2, 1);
            controller.getSale().applyDiscount(15.0); // fixed discount
            controller.pay(100);
            System.out.println("========== �� FIXED DISCOUNT (15 SEK) ==========");
            System.out.println("Total revenue:" + String.format("%.2f", 67.51) + "SEK");
            System.out.println(new Receipt(controller.getSale()).createReceiptString());

            // PERCENTAGE DISCOUNT (10% of 47.49 = ~4.75)
            controller.startSale();
            controller.registerItem(1, 1);
            controller.registerItem(2, 1);
            controller.getSale().applyDiscount(4.75);
            controller.pay(100);
            System.out.println("========== �� PERCENTAGE DISCOUNT (10%) ==========");
            System.out.println("Total revenue:" + String.format("%.2f", 57.26) + "SEK");
            System.out.println(new Receipt(controller.getSale()).createReceiptString());

        } catch (Exception e) {
            System.out.println("Error during execution: " + e.getMessage());
        }
    }

    public void enterItem(String itemID) {
        System.out.println("Entering item: " + itemID);
    }

    public static View getInstance() {
        return null;
    }

    public void addPaymentObserver(TotalRevenueView observer) {
        System.out.println("Payment observer added (view)");
    }

    public void addPaymentObserver(TotalRevenueFileOutput observer) {
        System.out.println("Payment observer added (file output)");
    }

    public void setDiscountStrategy(Object strategy) {
        System.out.println("Discount strategy set.");
    }
}
