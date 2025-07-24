package tradereconciliation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientOrderTest {

    @Test
    public void testAddFilledQuantity() {
        ClientOrder order = new ClientOrder("C1", "AAPL", "BUY", 500);
        order.addFilledQuantity(200);
        assertEquals(200, order.getFilledQuantity());
    }

    @Test
    public void testGetStatus() {
        ClientOrder order = new ClientOrder("C1", "AAPL", "BUY", 500);
        assertEquals("UNFILLED", order.getStatus());
        order.addFilledQuantity(200);
        assertEquals("PARTIALLY FILLED", order.getStatus());
        order.addFilledQuantity(300);
        assertEquals("FULLY FILLED", order.getStatus());
    }
}
