package se.kth.iv1350.pos.model;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Logs the total revenue to a file.
 */
public class TotalRevenueFileOutput {

    private final String logFile = "totalRevenue.txt";

    /**
     * Writes the total revenue to a file.
     *
     * @param amount The total revenue to log.
     */
    public void logRevenue(double amount) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write("Total revenue: " + amount + "\\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}
