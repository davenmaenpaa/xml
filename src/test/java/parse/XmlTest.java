package parse;

import model.ObjectFactory;
import model.Shiporder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlTest {
    private Xml xml = new Xml();
    private Shiporder expectedOrder;

    @BeforeEach
    void setUp() {
        Shiporder.Shipto shipto = new ObjectFactory().createShiporderShipto();
        shipto.setName("Daven Mäenpää");
        shipto.setAddress("Kulfångsgatan 4");
        shipto.setCity("Stockholm");
        shipto.setCountry("Sweden");

        expectedOrder = new ObjectFactory().createShiporder();
        expectedOrder.setShipto(shipto);
        expectedOrder.setOrderid("1");
        expectedOrder.setOrderperson("Daven Mäenpää");

        Shiporder.Item item = new ObjectFactory().createShiporderItem();
        item.setTitle("Tandkräm");
        item.setNote("100 ml");
        item.setQuantity(new BigInteger("10"));
        item.setPrice(new BigDecimal("25"));

        Shiporder.Item item1 = new ObjectFactory().createShiporderItem();
        item1.setTitle("Tandborste");
        item1.setNote("100 ml");
        item1.setQuantity(new BigInteger("1000"));
        item1.setPrice(new BigDecimal("10"));

        expectedOrder.getItem().add(item);
        expectedOrder.getItem().add(item1);
    }

    @DisplayName("Testing method converting XML to object")
    @Test
    void toObject() {
        Shiporder.Item item = new ObjectFactory().createShiporderItem();
        item.setTitle("Tandtråd");
        item.setNote("100 st");
        item.setQuantity(new BigInteger("55"));
        item.setPrice(new BigDecimal("30"));

        expectedOrder.getItem().add(item);

        Shiporder actual = (Shiporder) xml.toObject("xmlToObject.xml", Shiporder.class);

        assertEquals(expectedOrder, actual);
    }

    @DisplayName("Testing method converting object to XML")
    @Test
    void toFile() throws IOException {
        String testPath = "objectToXml.xml";
        xml.toFile(testPath, expectedOrder);

        String actual = new String(Files.readAllBytes(Paths.get(testPath)));
        String expected = new String(Files.readAllBytes(Paths.get("facit.xml")));

        assertEquals(expected, actual);

        new File(testPath).delete();
    }


}
