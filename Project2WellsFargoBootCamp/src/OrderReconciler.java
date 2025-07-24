package tradereconciliation;

import java.util.List;

public class OrderReconciler 
{
	//Static method which reconciles filled quantities from child orders to their
	//corresponding client orders
    public static void reconcile(List<ClientOrder> clientOrders, List<ChildOrder> childOrders) 
    {
    	//Iterating through each element of clientOrders
        for (ClientOrder client : clientOrders) 
        {
        	//Iterating through each element of childOrders
            for (ChildOrder child : childOrders) 
            {
            	//Matching the ID from the client order to the child parent order ID
                if (child.getParentId().equals(client.getClientOrderId())) 
                {
                	//Checks for mismatch in symbols
                    if (!child.getSymbol().equals(client.getSymbol()) || !child.getSide().equals(client.getSide())) 
                    {
                        System.out.println("Symbol or side mismatch for child order " + child.getChildOrderId());
                        continue;
                    }
                    //Calling the method to add the quantity from the child order to the client order
                    //If the IDs match
                    client.addFilledQuantity(child.getFilledQuantity());
                }
            }
        }
    }
}

