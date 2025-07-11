package July11FinishedBuild;

import java.io.*;
import java.util.*;
public class ReportExport implements Runnable {
    private final List<ClientOrder> clientOrders;
    private final String outputFile;
    public ReportExport(List<ClientOrder> clientOrders, String outputFile)
    {
        this.clientOrders = clientOrders;
        this.outputFile = outputFile;
    }
    @Override
    public void run()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile)))
        {
            writer.println("ClientOrderId,Symbol,Side,Quantity,FilledQuantity"); //writes the header row
            for (ClientOrder order : clientOrders)
            {
                writer.printf("%s,%s,%s,%d,%d,%n",
                        order.getClientOrderId(),
                        order.getSymbol(),
                        order.getSide(),
                        order.getQuantity(),
                        order.getFilledQuantity());
            }
            System.out.println("Report exported successfully to: " + outputFile);
        }
        catch (IOException e)
        {
            System.out.println("Failed to export report: " + e.getMessage());
        }
    }
}
