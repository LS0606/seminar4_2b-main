package se.kth.iv1350.pos.model;

import java.util.List;

/**
 * Represents a receipt that is printed for the sale.
 */
public class Receipt {
    private final Sale sale;

    public Receipt(Sale sale) {
        this.sale = sale;
    }

    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--- RECEIPT --- \n");
        builder.append("Time of Sale: ").append(sale.getTimeOfSale()).append("\n");

        List<ItemDTO> items = sale.getSoldItems();
        for (ItemDTO item : items) {
            builder.append(item.getName())
                    .append(" 1 x ")
                    .append(String.format("%.2f", item.getPrice()))
                    .append(" = ")
                    .append(String.format("%.2f", item.getPrice()))
                    .append("  SEK \n");
        }

        builder.append("\nTotal Cost: ")
                .append(String.format("%.2f", sale.getTotalCostAfterDiscount()))
                .append(" SEK \n");
        builder.append("\nTotal VAT: ")
                .append(String.format("%.2f", sale.getTotalVat()))
                .append(" SEK \n");

        builder.append("\nCash: 100,00 SEK\n");
        builder.append("Change: ")
                .append(String.format("%.2f", 100.00 - sale.getTotalCostAfterDiscount()))
                .append(" SEK\n");

        builder.append("--- END RECEIPT ---\n");
        return builder.toString();
    }
}
