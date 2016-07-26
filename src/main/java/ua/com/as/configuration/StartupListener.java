package ua.com.as.configuration;

import ua.com.as.jaxb.Controllers;
import ua.com.as.service.ConfigurationManager;
import ua.com.as.service.XmlParser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Listen when servlet is called and read file of configuration.
 */
public class StartupListener implements ServletContextListener {

    private static final String XML_CONFIG_FILE = "/config/configuration.xml";
    private static final String XML_CONFIG_FOLDER = "WEB-INF";


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String webInfPath = servletContextEvent.getServletContext().getRealPath(XML_CONFIG_FOLDER);
        Controllers controllers = null;
        File configFile = new File(webInfPath + XML_CONFIG_FILE);
        try {
            controllers = XmlParser.parseXml(configFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        ConfigurationManager.instance.saveControllersConfiguration(controllers);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
