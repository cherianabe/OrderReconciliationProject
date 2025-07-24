package tradereconciliation;

public class ChildOrder 
{
	//Instance Variables for ChildOrder Class
    private String childOrderId;
    private String parentId;
    private String symbol;
    private String side;
    private int quantity;
    private int filledQuantity;

    //ChildOrder Constructor
    public ChildOrder(String childOrderId, String parentId, String symbol, String side, int quantity, int filledQuantity) 
    {
        this.childOrderId = childOrderId;
        this.parentId = parentId;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.filledQuantity = filledQuantity;
    }
    
    
    //Getters for Instance Variables
    public String getChildOrderId() 
    {
        return childOrderId;
    }

    public String getParentId() 
    {
        return parentId;
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
}


