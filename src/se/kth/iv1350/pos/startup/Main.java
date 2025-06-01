package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.model.TotalRevenueFileOutput;

/**
 * Starts the application.
 */
public class Main {

    /**
     * The main method that starts the application.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Accounting accounting = new Accounting();
        DiscountDatabase discountDatabase = new DiscountDatabase();
        TotalRevenueFileOutput revenueLog = new TotalRevenueFileOutput();

        Controller controller = new Controller(inventory, accounting, discountDatabase, revenueLog);
        View view = new View(controller);
        view.runFakeExecution();
    }
}
