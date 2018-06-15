package parse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public final class Xml {
    private final Logger LOGGER = Logger.getLogger(Xml.class.getName());

    public Object parseFrom(String path, Class<?> c) {
        Object order = null;

        try {

            File file = new File(path);

            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            order = (c.cast(jaxbUnmarshaller.unmarshal(file)));

        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }

        return order;
    }


    public void parseTo(Object object, String path) {
        try {

            File file = new File(path);

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);
            jaxbMarshaller.marshal(object, System.out);

        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE,e.toString());
        }
    }
}
