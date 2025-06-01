package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.TotalRevenueView;

/**
 * This class is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private final Inventory inventory;
    private final Accounting accounting;
    private final DiscountDatabase discountDatabase;
    private final TotalRevenueFileOutput revenueLog;

    public Controller(Inventory inventory, Accounting accounting,
                      DiscountDatabase discountDatabase, TotalRevenueFileOutput revenueLog) {
        this.inventory = inventory;
        this.accounting = accounting;
        this.discountDatabase = discountDatabase;
        this.revenueLog = revenueLog;
    }

    public void startSale() {
        sale = new Sale();
        sale.addPaymentObserver(new TotalRevenueView());
        sale.addPaymentObserver(revenueLog);
    }

    public ItemDTO registerItem(int itemID, int quantity)
            throws ItemNotFoundException, InventoryDatabaseException {
        ItemDTO foundItem = inventory.fetchItem(String.valueOf(itemID));
        sale.registerItem(foundItem, quantity);
        return foundItem;
    }

    public double endSale() {
        return sale.getTotalPriceWithVAT();
    }

    public void requestDiscount(int customerID) throws IllegalArgumentException {
        sale.applyDiscount(discountDatabase.fetchDiscount(customerID));
    }

    public double pay(double paidAmount) {
        double change = sale.registerPayment(paidAmount);
        accounting.updateSale(sale);
        inventory.updateInventory(sale);
        return change;
    }

    public Sale getSale() {
        return this.sale;
    }
}
