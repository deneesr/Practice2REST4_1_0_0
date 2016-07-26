package ua.com.as.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import ua.com.as.exception.ConfigurationException;
import ua.com.as.jaxb.Controllers;
import ua.com.as.model.Execution;
import ua.com.as.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 */
public class DispatcherServletTest {

    private static final String METHOD_GET = "GET";
    private static final String PATH_GET = "/getTest";
    private static final String METHOD_POST = "POST";
    private static final String PATH_POST = "/postTest";
    private static final String METHOD_PUT = "PUT";
    private static final String PATH_PUT = "/putTest";
    private static final String METHOD_DELETE = "DELETE";
    private static final String PATH_DELETE = "/deleteTest";


    private static final String TEST_CONFIGURATION_XML = "/dispatcherTest.xml";
    private File testXml = getFileFromResources(TEST_CONFIGURATION_XML);



    private File getFileFromResources(String path) {
        try {
            File file = new File(this.getClass().getResource(path).toURI());
            return file;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Mock
    HttpServletRequest request = mock(HttpServletRequest.class);

    @Mock
    HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    PrintWriter printWriter = mock(PrintWriter.class);

    @Test
    public void testDoGet() throws Exception {
        when(request.getMethod()).thenReturn(METHOD_GET);
        when(request.getPathInfo()).thenReturn(PATH_GET);
        when(response.getWriter()).thenReturn(printWriter);
        Controllers testСontrollers = XmlParser.parseXml(testXml);
        Execution execution = HandlerMapper.getExecution(request);
        new DispatcherServlet().doGet(request, response);
        Assert.assertNotNull(response);
        Assert.assertNotNull(request);
    }

    @Test
    public void testDoPost() throws Exception {
        when(request.getMethod()).thenReturn(METHOD_POST);
        when(request.getPathInfo()).thenReturn(PATH_POST);
        when(response.getWriter()).thenReturn(printWriter);
        Controllers testСontrollers = XmlParser.parseXml(testXml);
        Execution execution = HandlerMapper.getExecution(request);
        new DispatcherServlet().doPost(request, response);
        Assert.assertNotNull(response);
        Assert.assertNotNull(request);
    }
    @Test
    public void testDoPut() throws Exception {
        when(request.getMethod()).thenReturn(METHOD_PUT);
        when(request.getPathInfo()).thenReturn(PATH_PUT);
        when(response.getWriter()).thenReturn(printWriter);
        Controllers testСontrollers = XmlParser.parseXml(testXml);
        Execution execution = HandlerMapper.getExecution(request);
        new DispatcherServlet().doPut(request, response);
        Assert.assertNotNull(response);
        Assert.assertNotNull(request);
    }
    @Test
    public void testDoDelete() throws Exception {
        when(request.getMethod()).thenReturn(METHOD_DELETE);
        when(request.getPathInfo()).thenReturn(PATH_DELETE);
        when(response.getWriter()).thenReturn(printWriter);
        Controllers testСontrollers = XmlParser.parseXml(testXml);
        Execution execution = HandlerMapper.getExecution(request);
        new DispatcherServlet().doDelete(request, response);
        Assert.assertNotNull(response);
        Assert.assertNotNull(request);
    }
}
