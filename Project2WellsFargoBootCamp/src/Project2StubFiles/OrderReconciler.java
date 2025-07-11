package July11FinishedBuild;

import java.util.*;

public class OrderReconciler {
    public static void reconcile(List<ClientOrder> clientOrders, List<ChildOrder> childOrders) {
        for (ClientOrder client : clientOrders) {
            for (ChildOrder child : childOrders) {
                if (child.getParentId().equals(client.getClientOrderId())) {
                    if (!child.getSymbol().equals(client.getSymbol()) || !child.getSide().equals(client.getSide())) {
                        System.out.println("Symbol or side mismatch for child order " + child.getChildOrderId());
                        continue;
                    }
                    client.addFilledQuantity(child.getFilledQuantity());
                }
            }
        }
    }
}

