import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testFullName() {
        Person person = new Person("001", "John", "Doe", "Mr.", 1995);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testToCSV() {
        Person person = new Person("002", "Jane", "Smith", "Dr.", 1980);
        assertEquals("002,Jane,Smith,Dr.,1980", person.toCSV());
    }
}
