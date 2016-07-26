package ua.com.as.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import ua.com.as.jaxb.Controllers;
import ua.com.as.model.Execution;
import ua.com.as.servlet.HandlerControllerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import java.io.File;
import java.net.URISyntaxException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 */
public class HandlerMapperTest {

    private static final String METHOD_GET = "GET";
    private static final String PATH = "/getTest";
    private static final String TEST_CONFIGURATION_XML = "/configurationTest.xml";
    private File testXml = getFileFromResources(TEST_CONFIGURATION_XML);
    private static final String TEST_CLASS_NAME = "ControllerClassTest";
    private static final String TEST_CLASS_PACKAGE = "ua.com.as.service.ControllerClassTest";
    private static final String TEST_METHOD_NAME = "getTest";

    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);

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
    public void testGetExecution() throws Exception {
        when(request.getMethod()).thenReturn(METHOD_GET);
        when(request.getPathInfo()).thenReturn(PATH);
        Controllers testСontrollers = XmlParser.parseXml(testXml);

        Execution execution = HandlerMapper.getExecution(request);

        Assert.assertNotNull(execution);

    }

    @Test
    public void testGetHandlerController() {
        Execution testExecution = new Execution(TEST_CLASS_NAME, TEST_CLASS_PACKAGE, TEST_METHOD_NAME);
        HandlerControllerImpl handlerController = HandlerMapper.getHandlerController(testExecution);

        Assert.assertNotNull(handlerController);

    }
}