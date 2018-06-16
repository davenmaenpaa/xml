package model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation 
 * for Xml content. The Java representation of Xml
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public final class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Shiporder }
     * 
     */
    public Shiporder createShiporder() {
        return new Shiporder();
    }

    /**
     * Create an instance of {@link Shiporder.Shipto }
     * 
     */
    public Shiporder.Shipto createShiporderShipto() {
        return new Shiporder.Shipto();
    }

    /**
     * Create an instance of {@link Shiporder.Item }
     * 
     */
    public Shiporder.Item createShiporderItem() {
        return new Shiporder.Item();
    }

}
