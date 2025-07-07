package Project2StubFiles;

import java.util.List;

public class OrderReconciler {

    public void reconcile(List<ClientOrder> clientOrders, List<ChildOrder> childOrders) {
        for (ClientOrder client : clientOrders) {
            int totalFilled = 0;

            for (ChildOrder child : childOrders) {
                if (child.getParentId().equals(client.getClientOrderID())) {
                    totalFilled += child.getFilledQuantity();
                }
            }

            client.increaseFilledQuantity(totalFilled);

            if (client.getFilledQuantity() > client.getQuantity()) {
                System.out.println("Overfill detected for Client Order " + client.getClientOrderID()
                        + " | Filled: " + client.getFilledQuantity() + " / " + client.getQuantity());
            }
        }
    }
}
