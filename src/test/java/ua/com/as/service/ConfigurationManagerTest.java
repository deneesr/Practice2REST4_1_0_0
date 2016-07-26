package ua.com.as.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.as.exception.ConfigurationException;
import ua.com.as.jaxb.Controller;
import ua.com.as.jaxb.Controllers;
import ua.com.as.model.Execution;

import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class ConfigurationManagerTest {

    private static final String TEST_CONFIGURATION_XML = "/configurationTest.xml";
    private static final String TEST_ACTION = "GET";
    private static final String TEST_PATH = "/rest/getTest";
    private static final String TEST_CLASS_NAME = "TestClass";
    private static final String TEST_CLASS_PACKAGE = "com.test.TestClass";
    private static final String TEST_METHOD_NAME = "getTest";
    private static final String TEST_WRONG_PATH = "/rest/wrongPath";
    private static final String TEST_WRONG_ACTION = "wrongAcion";
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



    @Test
    public void testSaveControllersConfiguration() throws Exception {

    }

    @Test (expected = ConfigurationException.class)
    public void testGetExecution() throws Exception {
        Controllers testСontrollers = XmlParser.parseXml(testXml);
        ConfigurationManager.instance.saveControllersConfiguration(testСontrollers);
        Execution testExecution = new Execution(TEST_CLASS_NAME, TEST_CLASS_PACKAGE, TEST_METHOD_NAME);
        Execution execution = ConfigurationManager.instance.getExecution(TEST_PATH, TEST_ACTION);
        Assert.assertNotNull(execution);
        Assert.assertEquals(execution.getClassName(),testExecution.getClassName());
        Execution testWrongPath = ConfigurationManager.instance.getExecution(TEST_WRONG_PATH, TEST_ACTION);
        Execution testWrongAction = ConfigurationManager.instance.getExecution(TEST_PATH, TEST_WRONG_ACTION);
    }


}