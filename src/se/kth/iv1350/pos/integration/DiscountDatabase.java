package se.kth.iv1350.pos.integration;

/**
 * Provides discount information based on customer ID.
 */
public class DiscountDatabase {

    /**
     * Fetches discount data for a given customer.
     *
     * @param customerID The ID of the customer.
     * @return A discount object (mocked as Object here).
     * @throws IllegalArgumentException if customer ID is invalid.
     */
    public Object fetchDiscount(int customerID) throws IllegalArgumentException {
        if (customerID < 0) {
            throw new IllegalArgumentException("Invalid customer ID");
        }
        return null; // Replace with real discount
    }
}
