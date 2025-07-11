package July11FinishedBuild;

import java.util.*;

public class ReportGenerator {
    public static void generateReport(List<ClientOrder> clientOrders) {
        clientOrders.sort((a, b) -> Double.compare(
            (double)b.getFilledQuantity() / b.getQuantity(),
            (double)a.getFilledQuantity() / a.getQuantity()
        ));

        for (ClientOrder client : clientOrders) {
            System.out.println("Client Order " + client.getClientOrderId()
                + " | Symbol: " + client.getSymbol()
                + " | Filled: " + client.getFilledQuantity() + " / " + client.getQuantity()
                + " | Status: " + client.getStatus());
        }
    }
}
