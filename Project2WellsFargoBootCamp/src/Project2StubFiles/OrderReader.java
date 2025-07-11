package July11FinishedBuild;

import java.io.*;
import java.util.*;

public class OrderReader {
    public static List<ClientOrder> readClientOrders(String filePath) throws IOException {
        List<ClientOrder> clientOrders = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String clientOrderId = parts[0].trim();
            String symbol = parts[1].trim();
            String side = parts[2].trim();
            int quantity = Integer.parseInt(parts[3].trim());
            clientOrders.add(new ClientOrder(clientOrderId, symbol, side, quantity));
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
            String childOrderId = parts[0].trim();
            String parentId = parts[1].trim();
            String symbol = parts[2].trim();
            String side = parts[3].trim();
            int quantity = Integer.parseInt(parts[4].trim());
            int filledQuantity = Integer.parseInt(parts[5].trim());
            childOrders.add(new ChildOrder(childOrderId, parentId, symbol, side, quantity, filledQuantity));
        }
        br.close();
        return childOrders;
    }
}

