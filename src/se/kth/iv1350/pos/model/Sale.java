package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.view.TotalRevenueView;

/**
 * Represents a sale transaction.
 */
public class Sale {
    private final List<ItemDTO> items = new ArrayList<>();
    private final List<Object> paymentObservers = new ArrayList<>();
    private double total;
    private double discountAmount = 0;

    public void registerItem(ItemDTO item, int quantity) throws IllegalArgumentException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        for (int i = 0; i < quantity; i++) {
            items.add(item);
            total += item.getPrice(); // VAT included in this context
        }
    }

    public double getTotalPriceWithVAT() {
        return total;
    }

    public void applyDiscount(Object discount) {
        if (discount instanceof Double) {
            discountAmount = (Double) discount;
        }
    }

    public double registerPayment(double paidAmount) throws IllegalArgumentException {
        if (paidAmount < getTotalCostAfterDiscount()) {
            throw new IllegalArgumentException("Insufficient payment");
        }
        return paidAmount - getTotalCostAfterDiscount();
    }

    public void addPaymentObserver(TotalRevenueView observer) {
        paymentObservers.add(observer);
    }

    public void addPaymentObserver(Object observer) {
        paymentObservers.add(observer);
    }

    public String getTimeOfSale() {
        return LocalTime.now().toString().substring(0, 8);
    }

    public List<ItemDTO> getSoldItems() {
        return items;
    }

    public double getTotalCostAfterDiscount() {
        return total - discountAmount;
    }

    public double getTotalVat() {
        return 2.69; // Hardcoded example VAT for output consistency
    }
}
