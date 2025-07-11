package July11FinishedBuild;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class OrderReader {
    private static final Logger logger = Logger.getLogger(OrderReader.class.getName());

    public static List<ClientOrder> readClientOrders(String filePath) throws IOException {
        List<ClientOrder> clientOrders = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            try {
                String id = parts[0].trim();
                String symbol = parts[1].trim();
                String side = parts[2].trim();
                int quantity = Integer.parseInt(parts[3].trim());
                if (quantity <= 0) {
                    throw new InvalidTradeException("Client Order " + id + " has invalid quantity: " + quantity);
                }
                clientOrders.add(new ClientOrder(id, symbol, side, quantity));
            } catch (InvalidTradeException e) {
                logger.warning("Skipping client order line: " + line + " Reason: " + e.getMessage());
            }
        }
        br.close();
        return clientOrders;
    }

    public static List<ChildOrder> readChildOrders(String filePath) throws IOException {
        List<ChildOrder> childOrders = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            try {
                String id = parts[0].trim();
                String parentId = parts[1].trim();
                String symbol = parts[2].trim();
                String side = parts[3].trim();
                int quantity = Integer.parseInt(parts[4].trim());
                int filledQuantity = Integer.parseInt(parts[5].trim());
                if (quantity <= 0 || filledQuantity < 0) {
                    throw new InvalidTradeException("Child Order " + id + " has invalid quantities.");
                }
                childOrders.add(new ChildOrder(id, parentId, symbol, side, quantity, filledQuantity));
            } catch (InvalidTradeException e) {
                logger.warning("Skipping child order line: " + line + " Reason: " + e.getMessage());
            }
        }
        br.close();
        return childOrders;
    }
}

