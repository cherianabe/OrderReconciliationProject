package July11FinishedBuild;

public class ClientOrder {
    private String clientOrderId;
    private String symbol;
    private String side;
    private int quantity;
    private int filledQuantity;

    public ClientOrder(String clientOrderId, String symbol, String side, int quantity) {
        this.clientOrderId = clientOrderId;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.filledQuantity = 0;
    }

    public String getClientOrderId() {
        return clientOrderId;
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

    public void addFilledQuantity(int amount) {
        this.filledQuantity += amount;
    }

    public String getStatus() {
        if (filledQuantity == 0) {
            return "UNFILLED";
        } else if (filledQuantity < quantity) {
            return "PARTIALLY FILLED";
        } else if (filledQuantity == quantity) {
            return "FULLY FILLED";
        } else {
            return "OVERFILLED";
        }
    }
}

