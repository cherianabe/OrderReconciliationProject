
ClientOrder.java
package Project2StubFiles;

public class ClientOrder {
    private String id, symbol, side;
    private int quantity, filledQuantity;

    // Constructor (initializes with filled quantity = 0)
    public ClientOrder(String id, String symbol, String side, int quantity) {
        this.id = id;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.filledQuantity = 0;
    }

    public String getID() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSide() {
        return side;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFilledQuantity() {
        return filledQuantity;
    }

    // Setter method to update filled quantity
    public void setFilledQuantity(int filledQuantity) {
        this.filledQuantity = filledQuantity;
    }

    // ADDED: Increases filled quantity by a given amount
    public void increaseFilledQuantity(int amount) {
        this.filledQuantity += amount;
    }

    // ADDED: Returns order status based on how much is filled
    public String getStatus() {
        if (filledQuantity == 0) return "UNFILLED";
        else if (filledQuantity >= quantity) return "FULLY FILLED";
        else return "PARTIALLY FILLED";
    }

    // ADDED: Returns filled percentage as a decimal
    public double getFillPercentage() {
        return (double) filledQuantity / quantity;
    }

    public String toString() {
        return "ID: " + id + " Symbol: " + symbol + " Side: " + side +
               " Quantity: " + quantity + " Filled Quantity: " + filledQuantity;
    }
}
