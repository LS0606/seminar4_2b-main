package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Sale;

/**
 * Handles accounting operations.
 */
public class Accounting {

    /**
     * Updates the accounting records with a completed sale.
     *
     * @param sale The completed sale.
     * @throws NullPointerException if sale is null.
     */
    public void updateSale(Sale sale) throws NullPointerException {
        if (sale == null) {
            throw new NullPointerException("Sale cannot be null");
        }
    }
}
