import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product p;

    @BeforeEach
    void setUp() {
        p = new Product("Ice Cream", "Vanilla", "P001", 5.99);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("P001", p.getID());
        assertEquals("Ice Cream", p.getName());
        assertEquals("Vanilla", p.getDescription());
        assertEquals(5.99, p.getCost());
    }

    @Test
    void testSetters() {
        p.setName("Cone");
        p.setDescription("Waffle cone");
        p.setCost(2.49);

        assertEquals("Cone", p.getName());
        assertEquals("Waffle cone", p.getDescription());
        assertEquals(2.49, p.getCost());
    }

    @Test
    void testToString() {
        String s = p.toString();
        assertTrue(s.contains("P001"));
        assertTrue(s.contains("Ice Cream"));
        assertTrue(s.contains("Vanilla"));
        assertTrue(s.contains("5.99"));
    }

    @Test
    void testToCSVDataString() {
        String csv = p.toCSVDataString();
        assertEquals("P001,Ice Cream,Vanilla,5.99", csv);
    }

    @Test
    void testToJSONDataString() {
        String json = p.toJSONDataString();
        assertTrue(json.startsWith("{"));
        assertTrue(json.contains("\"ID\":\"P001\""));
        assertTrue(json.contains("\"name\":\"Ice Cream\""));
        assertTrue(json.contains("\"description\":\"Vanilla\""));
        assertTrue(json.contains("\"cost\":5.99"));
        assertTrue(json.endsWith("}"));
    }

    @Test
    void testToXMLDataString() {
        String xml = p.toXMLDataString();
        assertTrue(xml.startsWith("<Product>"));
        assertTrue(xml.contains("<ID>P001</ID>"));
        assertTrue(xml.contains("<name>Ice Cream</name>"));
        assertTrue(xml.contains("<description>Vanilla</description>"));
        assertTrue(xml.contains("<cost>5.99</cost>"));
        assertTrue(xml.endsWith("</Product>"));
    }

}