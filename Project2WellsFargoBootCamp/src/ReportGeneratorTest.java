package tradereconciliation;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReportGeneratorTest {

    @Test
    public void testGenerateReport() {
        ClientOrder client = new ClientOrder("C1", "AAPL", "BUY", 500);
        client.addFilledQuantity(300);
        List<ClientOrder> clients = List.of(client);
        assertEquals("PARTIALLY FILLED", client.getStatus());
    }
}
