import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testToCSV() {
        Product product = new Product("101", "Laptop", "Gaming laptop", 1499.99);
        assertEquals("101,Laptop,Gaming laptop,1499.99", product.toCSV());
    }
}
