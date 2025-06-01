package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.ItemDTO;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles inventory operations.
 */
public class Inventory {
    private final Map<String, ItemDTO> items = new HashMap<>();

    public Inventory() {
        items.put("1", new ItemDTO("1", "YouGOGo Blueberry", "Energy bar", 14.90, 0.12, 1));
        items.put("2", new ItemDTO("2", "BigWheel Oatmeal", "Cereal", 29.90, 0.06, 1));
    }

    public ItemDTO fetchItem(String itemID) throws ItemNotFoundException, InventoryDatabaseException {
        if (itemID == null) {
            throw new InventoryDatabaseException("Null item ID");
        }

        ItemDTO item = items.get(itemID);
        if (item == null) {
            throw new ItemNotFoundException("Item not found: " + itemID);
        }

        return item;
    }

    public void updateInventory(Object sale) {
        // Dummy logic
    }
}
