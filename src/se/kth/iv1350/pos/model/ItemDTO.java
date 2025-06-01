package se.kth.iv1350.pos.model;

/**
 * A DTO representing an item in the system.
 */
public class ItemDTO {
    private final String itemID;
    private final String name;
    private final String description;
    private final double price;
    private final double vat;
    private final int quantity;

    /**
     * Creates an instance of ItemDTO.
     *
     * @param itemID The item identifier.
     * @param name The name of the item.
     * @param description A description of the item.
     * @param price The price of the item (excluding VAT).
     * @param vat The VAT rate for the item.
     * @param quantity The quantity in stock.
     */
    public ItemDTO(String itemID, String name, String description, double price, double vat, int quantity) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
    }

    public String getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getVAT() {
        return vat;
    }

    public int getQuantity() {
        return quantity;
    }
}
