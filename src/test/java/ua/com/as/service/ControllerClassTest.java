package ua.com.as.service;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class ControllerClassTest {

    public String getTest(HttpServletRequest request){
        Class<ControllerClassTest> controllerClassTestClazz = ControllerClassTest.class;
        return controllerClassTestClazz.getCanonicalName();
    }
    public String postTest(HttpServletRequest request){
        Class<ControllerClassTest> controllerClassTestClazz = ControllerClassTest.class;
        return controllerClassTestClazz.getCanonicalName();
    }
    public String putTest(HttpServletRequest request){
        Class<ControllerClassTest> controllerClassTestClazz = ControllerClassTest.class;
        return controllerClassTestClazz.getCanonicalName();
    }
    public String deleteTest(HttpServletRequest request){
        Class<ControllerClassTest> controllerClassTestClazz = ControllerClassTest.class;
        return controllerClassTestClazz.getCanonicalName();
    }
}
