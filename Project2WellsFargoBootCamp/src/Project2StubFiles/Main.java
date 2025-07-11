package July11FinishedBuild;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String clientFile = "client_order.csv";
            String childFile = "child_order.csv";

            List<ClientOrder> clientOrders = OrderReader.readClientOrders("client_order.csv");
            List<ChildOrder> childOrders = OrderReader.readChildOrders("child_order.csv");

            OrderReconciler.reconcile(clientOrders, childOrders);

            ReportGenerator.generateReport(clientOrders);

        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}
