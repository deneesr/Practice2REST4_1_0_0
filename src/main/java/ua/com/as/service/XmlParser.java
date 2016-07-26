package ua.com.as.service;

import ua.com.as.jaxb.Controllers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Class present method for parsing xml file.
 */
public class XmlParser {

    private XmlParser() {
    }

    /**
     * @param file - file to be read.
     * @return controllers that were read from xml file.
     * @throws JAXBException;
     */
    public static Controllers parseXml(File file) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Controllers.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Controllers controllers = (Controllers) jaxbUnmarshaller.unmarshal(file);
        return controllers;


    }

}
