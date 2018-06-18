package parse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generic XML to object- and object to XML-converter.
 */
public final class Xml {
    private final Logger LOGGER = Logger.getLogger(Xml.class.getName());

    /**
     * Returns a generic object from a XML-file.
     *
     * @param path  path to the file to convert from
     * @param type  object type to derive from the XML-file
     * @return      object obtained from the XML-file
     */
    public Object toObject(String path, Class<?> type) {
        Object object = null;

        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(type);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }

        return object;
    }
    
    /**
     * Converts a generic object to a file in XML-format and prints the result in the console.
     *
     * @param object    object to be converted
     * @param path      output path for the file
     * @param <T>       type of the object to convert
     */
    public <T> void toFile(String path, T object) {
        try {

            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);
            jaxbMarshaller.marshal(object, System.out);

        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
    }
}
