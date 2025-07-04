package Project2StubFiles;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderReader {

    public List<ClientOrder> readClientOrders(String filePath) {
        List<ClientOrder> clientOrders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String symbol = parts[1];
                String side = parts[2];
                int quantity = Integer.parseInt(parts[3]);

                ClientOrder order = new ClientOrder(id, symbol, side, quantity);
                clientOrders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientOrders;
    }

    public List<ChildOrder> readChildOrders(String filePath) {
        List<ChildOrder> childOrders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String childId = parts[0];
                String parentId = parts[1];
                String symbol = parts[2];
                String side = parts[3];
                int quantity = Integer.parseInt(parts[4]);
                int filledQuantity = Integer.parseInt(parts[5]);

                ChildOrder child = new ChildOrder(parentId, symbol, side, quantity, filledQuantity);
                childOrders.add(child);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return childOrders;
    }
}




/* catch exceptions for each of the values.
 * 
 */
 * 
