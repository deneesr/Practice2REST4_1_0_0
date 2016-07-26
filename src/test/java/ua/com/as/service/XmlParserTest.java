package ua.com.as.service;

import org.junit.Assert;
import org.junit.Test;
import ua.com.as.jaxb.Controller;
import ua.com.as.jaxb.Controllers;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;


public class XmlParserTest {

    private static final String TEST_CONFIGURATION_XML = "/configurationTest.xml";
    private static final String TEST_WRONG_XML = "/wrongTest.xml";
    private static final int TEST_SIZE_CONTROLLERS = 1;
    public static final String TEST_CLASS = "ControllerTestClass";

    private File getFileFromResources(String path) {
        try {
            File file = new File(this.getClass().getResource(path).toURI());
            return file;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testParseXml() throws Exception{
        File file = getFileFromResources(TEST_CONFIGURATION_XML);
        Controllers controllers = XmlParser.parseXml(file);
        Assert.assertNotNull(controllers);
        Assert.assertEquals(controllers.getControllers().size(), TEST_SIZE_CONTROLLERS);
        Controller controller = controllers.getControllers().get(0);
        Assert.assertEquals(controller.getClassName(), TEST_CLASS);
        Assert.assertEquals(controller.getRests().size(), 4);
        Assert.assertEquals(controller.getRests().get(0).getPath(), "/getTest");

    }

    @Test (expected = JAXBException.class)
    public void testUnmarshalling () throws Exception{
        File file = getFileFromResources(TEST_WRONG_XML);
        Controllers controllers = XmlParser.parseXml(file);
    }

    @Test
    public void privateConstructor() throws Exception{
        Constructor<XmlParser> constructor = XmlParser.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}