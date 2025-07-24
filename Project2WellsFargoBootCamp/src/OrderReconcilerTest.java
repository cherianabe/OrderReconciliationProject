package tradereconciliation;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderReconcilerTest {

    @Test
    public void testReconcile() {
        ClientOrder client = new ClientOrder("C1", "AAPL", "BUY", 500);
        ChildOrder child1 = new ChildOrder("CH1", "C1", "AAPL", "BUY", 300, 200);
        ChildOrder child2 = new ChildOrder("CH2", "C1", "AAPL", "BUY", 300, 150);
        List<ClientOrder> clientOrders = List.of(client);
        List<ChildOrder> childOrders = List.of(child1, child2);

        OrderReconciler.reconcile(clientOrders, childOrders);

        assertEquals(350, client.getFilledQuantity());
        assertEquals("PARTIALLY FILLED", client.getStatus());
    }
}
