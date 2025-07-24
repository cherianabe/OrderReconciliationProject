package tradereconciliation;

//Custom exception for handling invalid trade scenarios
public class InvalidTradeException extends Exception 
{
    public InvalidTradeException(String message) 
    {
        super(message);
    }
}
