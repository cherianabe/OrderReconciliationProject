ChildOrder.java
package Project2StubFiles;

public class ChildOrder {
    public String id, parentID, symbol, side;
    public int quantity, filledQuantity;

    // Constructor initializes all fields when an object is created
    public ChildOrder(String id, String parentID, String symbol, String side, int quantity, int filledQuantity) {
        this.id = id;
        this.parentID = parentID;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.filledQuantity = filledQuantity;
    }

    // Getter for child order ID
    public String getID() {
        return id;
    }

    // Getter for parent (client) order ID
    public String getParentID() {
        return parentID;
    }

    // Getter for stock symbol
    public String getSymbol() {
        return symbol;
    }

    // Getter for side (BUY or SELL)
    public String getSide() {
        return side;
    }

    // Getter for order quantity
    public int getQuantity() {
        return quantity;
    }

    // Getter for how much quantity has been filled
    public int getFilledQuantity() {
        return filledQuantity;
    }

    // Converts object to readable string
    public String toString() {
        return "ID: " + id + " ParentID: " + parentID + " Symbol: " + symbol + 
               " Side: " + side + " Quantity: " + quantity + " Filled Quantity: " + filledQuantity;
    }
}

