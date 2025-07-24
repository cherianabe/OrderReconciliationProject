package tradereconciliation;

import java.io.*;
import java.util.*;

//Implements Runnable to allow multithreaded execution
public class ReportExport implements Runnable 
{
	//List to store all client orders that will be written to report
    private final List<ClientOrder> clientOrders;
    //Output file name where the report will be saved
    private final String outputFile;
    
    //ReportExport Constructor to initialize the data and output file name
    public ReportExport(List<ClientOrder> clientOrders, String outputFile)
    {
        this.clientOrders = clientOrders;
        this.outputFile = outputFile;
    }
    
    //Method which runs when thread is started
    @Override
    public void run()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile)))
        {
            writer.println("ClientOrderId,Symbol,Side,Quantity,FilledQuantity"); //writes the header row
            
            //Iterate through each client order and write its data to the file
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
