package tradereconciliation;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class OrderReader 
{
	//Logger to record any issues encountered while reading order files
    private static final Logger logger = Logger.getLogger(OrderReader.class.getName());

    //Static method that reads client orders from a CSV file and returns a list of ClientOrder objects
    public static List<ClientOrder> readClientOrders(String filePath) throws IOException 
    {
        List<ClientOrder> clientOrders = new ArrayList<>();
        //Creating a BufferedReader instance to parse the Client Order file.
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        br.readLine(); // skip header row
       
        //Read each line, parse the values, and add valid ClientOrder objects to the list
        while ((line = br.readLine()) != null) 
        {
            String[] parts = line.split(",");
            try 
            {
                String id = parts[0].trim();
                String symbol = parts[1].trim();
                String side = parts[2].trim();
                int quantity = Integer.parseInt(parts[3].trim());
                if (quantity <= 0) 
                {
                    throw new InvalidTradeException("Client Order " + id + " has invalid quantity: " + quantity);
                }
                clientOrders.add(new ClientOrder(id, symbol, side, quantity));
            } catch (InvalidTradeException e) 
            {
            	//Log and skip invalid client orders
                logger.warning("Skipping client order line: " + line + " Reason: " + e.getMessage());
            }
        }
        br.close();
        return clientOrders;
    }

    //Static method that reads child orders from a CSV file and returns a list of ChildOrder objects
    public static List<ChildOrder> readChildOrders(String filePath) throws IOException 
    {
        List<ChildOrder> childOrders = new ArrayList<>();
        //Creating a BufferedReader instance to parse through the Child Order file.
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        br.readLine(); // skip header row
     
        //Read each line, parse the values, and add valid ChildOrder objects to the list
        while ((line = br.readLine()) != null) 
        {
            String[] parts = line.split(",");
            try 
            {
                String id = parts[0].trim();
                String parentId = parts[1].trim();
                String symbol = parts[2].trim();
                String side = parts[3].trim();
                int quantity = Integer.parseInt(parts[4].trim());
                int filledQuantity = Integer.parseInt(parts[5].trim());
                if (quantity <= 0 || filledQuantity < 0) 
                {
                    throw new InvalidTradeException("Child Order " + id + " has invalid quantities.");
                }
                childOrders.add(new ChildOrder(id, parentId, symbol, side, quantity, filledQuantity));
            } catch (InvalidTradeException e) 
            {
            	//Log and skip invalid child orders
                logger.warning("Skipping child order line: " + line + " Reason: " + e.getMessage());
            }
        }
        br.close();
        return childOrders;
    }
}
