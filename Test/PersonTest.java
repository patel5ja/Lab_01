import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person p;

    @BeforeEach
    void setUp(){
        p = new Person ("0000A", "Bilbo", "Baggins", "Mr.", 1950);
    }


    @Test
    void testToString() {
        String s = p.toString();
        assertTrue(s.contains("Bilbo"));
        assertTrue(s.contains("Baggins"));
        assertTrue(s.contains("1950"));
        assertTrue(s.contains("0000A"));


    }

    @Test
    void setIDNum() {
        p.setIDNum("0000B");
        assertEquals("0000B", p.getIDNum());
    }

    @Test
    void setFirstName() {
        p.setFirstName("Frodo");
        assertEquals("Frodo", p.getFirstName());
    }

    @Test
    void setLastName() {
        p.setLastName("Gamgee");
        assertEquals("Gamgee", p.getLastName());
    }

    @Test
    void setTitle() {
        p.setTitle("Dr.");
        assertEquals("Dr.", p.getTitle());
    }

    @Test
    void setYOB() {
        p.setYOB(1999);
        assertEquals(1999, p.getYOB());
    }

    @Test
    void toCSVDataString() {
        String csv = p.toCSVDataString();
        assertEquals("0000A,Bilbo,Baggins,Mr.,1950", csv);
    }

    @Test
    void toJSONDataString() {
        String json = p.toJSONDataString();
        assertTrue(json.startsWith("{"));
        assertTrue(json.contains("\"IDNum\":\"0000A\""));
        assertTrue(json.contains("\"firstName\":\"Bilbo\""));
        assertTrue(json.contains("\"lastName\":\"Baggins\""));
        assertTrue(json.contains("\"title\":\"Mr.\""));
        assertTrue(json.contains("\"YOB\":1950"));
        assertTrue(json.endsWith("}"));

    }

    @Test
    void toXMLDataString() {
        String xml = p.toXMLDataString();
        assertTrue(xml.startsWith("<Person>"));
        assertTrue(xml.contains("<IDNum>0000A</IDNum>"));
        assertTrue(xml.contains("<firstName>Bilbo</firstName>"));
        assertTrue(xml.contains("<lastName>Baggins</lastName>"));
        assertTrue(xml.contains("<title>Mr.</title>"));
        assertTrue(xml.contains("<YOB>1950</YOB>"));
        assertTrue(xml.endsWith("</Person>"));

    }
    @Test
    void testEquals() {
        Person same = new Person("0000A", "Bilbo", "Baggins", "Mr.", 1950);
        Person diff = new Person("0000B", "Frodo", "Baggins", "Mr.", 1960);
        assertEquals(p, same);
        assertNotEquals(p, diff);
    }




}