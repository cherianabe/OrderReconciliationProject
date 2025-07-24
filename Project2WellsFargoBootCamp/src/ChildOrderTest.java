package tradereconciliation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChildOrderTest {

    @Test
    public void testChildOrderFields() {
        ChildOrder child = new ChildOrder("CH1", "C1", "AAPL", "BUY", 300, 150);
        assertEquals("CH1", child.getChildOrderId());
        assertEquals("C1", child.getParentId());
        assertEquals("AAPL", child.getSymbol());
        assertEquals("BUY", child.getSide());
        assertEquals(300, child.getQuantity());
        assertEquals(150, child.getFilledQuantity());
    }
}
