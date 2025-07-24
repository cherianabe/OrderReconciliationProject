package tradereconciliation;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class OrderReaderTest 
{
    @TempDir
    Path tempDir;
    @Test
    void testReadClientOrdersvalidFile() throws IOException 
    {
        Path file = tempDir.resolve("client.csv");
        String csv = String.join("\n",
            "id,symbol,side,quantity",
            "C1,ABC,BUY,100",
            "C2,XYZ,SELL,50"
        );
        Files.writeString(file, csv);
        List<ClientOrder> orders = OrderReader.readClientOrders(file.toString());
        assertEquals(2, orders.size());
        assertEquals("C1", orders.get(0).getClientOrderId());
        assertEquals("ABC", orders.get(0).getSymbol());
        assertEquals("C2", orders.get(1).getClientOrderId());
    }
    @Test
    void testReadClientOrdersNegativeQuantity() throws IOException 
    {
        Path file = tempDir.resolve("client_invalid.csv");
        String csv = String.join("\n",
            "id,symbol,side,quantity",
            "C1,ABC,BUY,100",
            "C2,XYZ,SELL,-10"
        );
        Files.writeString(file, csv);
        List<ClientOrder> orders = OrderReader.readClientOrders(file.toString());
        assertEquals(1, orders.size(), "Negative‐quantity order should be skipped");
        assertEquals("C1", orders.get(0).getClientOrderId());
    }
    @Test
    void testReadChildOrdersvalidFile() throws IOException 
    {
        Path file = tempDir.resolve("child.csv");
        String csv = String.join("\n",
            "id,parentId,symbol,side,quantity,filledQuantity",
            "CH1,P1,ABC,BUY,100,0",
            "CH2,P1,XYZ,SELL,50,25"
        );
        Files.writeString(file, csv);
        List<ChildOrder> orders = OrderReader.readChildOrders(file.toString());
        assertEquals(2, orders.size());
        assertEquals("CH1", orders.get(0).getChildOrderId());
        assertEquals(25, orders.get(1).getFilledQuantity());
    }
    @Test
    void testReadChildOrdersNegativeQuantities() throws IOException 
    {
        Path file = tempDir.resolve("child_invalid.csv");
        String csv = String.join("\n",
            "id,parentId,symbol,side,quantity,filledQuantity",
            "CH1,P1,ABC,BUY,100,0",
            "CH2,P1,XYZ,SELL,-5,10",
            "CH3,P1,XYZ,SELL,50,-1"
        );
        Files.writeString(file, csv);
        List<ChildOrder> orders = OrderReader.readChildOrders(file.toString());
        assertEquals(1, orders.size(), "Only the first valid child order should be read");
        assertEquals("CH1", orders.get(0).getChildOrderId());
    }
}
