package tradereconciliation;

import java.util.List;

public class ReportGenerator 
{
	//Static method which takes ArrayList clientOrders
    public static void generateReport(List<ClientOrder> clientOrders) 
    {
    	//Sorts the client orders by fill percentage in descending order
    	//Lambda expression compares the fill ratio: filledQuantity / totalQuantity
        clientOrders.sort((a, b) -> Double.compare(
            (double)b.getFilledQuantity() / b.getQuantity(),
            (double)a.getFilledQuantity() / a.getQuantity()
        ));

        //Iterates through the sorted client orders and prints their details
        for (ClientOrder client : clientOrders) 
        {
            System.out.println("Client Order " + client.getClientOrderId()
                + " - Symbol: " + client.getSymbol()
                + " - Filled: " + client.getFilledQuantity() + " / " + client.getQuantity()
                + " - Status: " + client.getStatus());
        }
    }
}
