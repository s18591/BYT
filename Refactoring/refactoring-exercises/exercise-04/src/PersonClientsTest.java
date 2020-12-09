import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

//Long method(Extract)

public class PersonClientsTest {

    private Person bobSmith;
    private Person jennyJJones;

    @Before
    public void setUp() {
        bobSmith = new Person("Smith", "Bob", null);
        jennyJJones = new Person("Jones", "Jenny", "J");
    }

    @Test
    public void testToString() {
        assertEquals("Bob, Smith", bobSmith.toString());
        assertEquals("Jenny, Jones J", jennyJJones.toString());
    }

    @Test
    public void printTest() throws IOException {
        StringWriter out = new StringWriter();
        bobSmith.printPerson(out);
        assertEquals("Bob Smith", out.toString());

        out = new StringWriter();
        jennyJJones.printPerson(out);
        assertEquals("Jenny J Jones", out.toString());
    }

    @Test
    public void formatTest() {
        StringWriter out;

        assertEquals("Smith, Bob", bobSmith.formatPerson());
        assertEquals("Jones, Jenny J", jennyJJones.formatPerson());
    }

    @Test
    public void displayTest() throws IOException {
        StringWriter out;

        out = new StringWriter();
        bobSmith.display(out);
        assertEquals("Smith, Bob", out.toString());

        out = new StringWriter();
        jennyJJones.display(out);
        assertEquals("Jones, Jenny J", out.toString());
    }
}
