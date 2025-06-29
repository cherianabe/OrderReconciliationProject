package Project2StubFiles;

public class ClientOrder {
	private String id, symbol, side;
	private int quantity, filledQuantity;
	
	//constructor to initialize an object!
	
	public ClientOrder(String id, String symbol, String side, int quantity, int filledQuantity)
	{
		this.id = id;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.filledQuantity = filledQuantity;
	}
	
	//getters for all fields
	
	public String getID()
	{
		return id;
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
	
	//one setter for this class; providing setters for other fields
	//could lead to wrong assumptions in code later on!
	
	public void setFilledQuantity(int filledQuantity)
	{
		this.filledQuantity = filledQuantity;
	}
	
	//toString to show all fields from the object
	
	public String toString()
	{
		return "ID: "+ id+ " Symbol: "+symbol+ " Side: "+side+" Quantity: "+quantity+ " Filled Quantity: "+filledQuantity;
	}
	
	//IMPORTANT. FOR FUTURE ITERATION:
	//getStatus() METHOD
	//getFillPercentage() METHOD

}
