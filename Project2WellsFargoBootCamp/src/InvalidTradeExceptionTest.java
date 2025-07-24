package tradereconciliation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvalidTradeExceptionTest {

    @Test
    public void testExceptionMessage() {
        InvalidTradeException e = new InvalidTradeException("Invalid quantity");
        assertEquals("Invalid quantity", e.getMessage());
    }
} 
