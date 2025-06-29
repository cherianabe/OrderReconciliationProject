package Project2StubFiles;

public class ChildOrder {
	public String id, parentID, symbol, side;
	public int quantity, filledQuantity;
	
	//constructor to set all fields!
	//may need change to access parentID string... don't know right now. further implementation
	
	public ChildOrder(String id, String parentID, String symbol, String side, int quantity, int filledQuantity)
	{
		this.id = id;
		this.parentID = parentID;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.filledQuantity = filledQuantity;
	}
	
	//getters for all fields!
	public String getID()
	{
		return id;
	}
	
	public String getParentID()
	{
		return parentID;
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
	
	//toString to print the fields
	public String toString()
	{
		return "ID: " +id+ " ParentID: "+parentID+" Symbol: "+symbol+" Side: " +side+ " Quantity: "+quantity+" Filled Quantity: "+filledQuantity;
	}

}
