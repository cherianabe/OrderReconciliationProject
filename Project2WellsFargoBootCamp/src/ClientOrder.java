package tradereconciliation;

public class ClientOrder 
{
	//Instance Variables for Client Order
    private String clientOrderId;
    private String symbol;
    private String side;
    private int quantity;
    private int filledQuantity;

    //ClientOrder Constructor
    public ClientOrder(String clientOrderId, String symbol, String side, int quantity) 
    {
        this.clientOrderId = clientOrderId;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.filledQuantity = 0;
    }

    //ClientOrder Getters
    public String getClientOrderId() 
    {
        return clientOrderId;
    }

    public String getSymbol() 
    {
        return symbol;
    }

    public String getSide() 
    {
        return side;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public int getFilledQuantity() 
    {
        return filledQuantity;
    }

    //Method to add the filled quantity from the Child Order
    public void addFilledQuantity(int amount) 
    {
        this.filledQuantity += amount;
    }

    //Reports back the status of the order
    public String getStatus() 
    {
        if (filledQuantity == 0) 
        {
            return "Unfilled";
        } else if (filledQuantity < quantity) 
        {
            return "Partially Filled";
        } else if (filledQuantity == quantity) 
        {
            return "Fully Filled";
        } else 
        {
            return "OVERFILLED";
        }
    }
}