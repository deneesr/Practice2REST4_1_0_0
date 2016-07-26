package ua.com.as.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.as.model.Execution;
import ua.com.as.servlet.HandlerControllerImpl;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * The {@code HandlerMapper} class implements object that contain HandlerController.
 *
 * @author Denis Rogovskiy
 */
public class HandlerMapper {

    private static final Logger LOG = LoggerFactory.getLogger(HandlerMapper.class);

    private HandlerMapper() {
    }

    /**
     * This method returns Execution of XMl document.
     *
     * @param request HttpServletRequest.
     * @return execution
     */
    public static Execution getExecution(HttpServletRequest request) {

        String httpMethod = request.getMethod();
        String path = request.getPathInfo();
        LOG.debug("String httpMethod: {} and String path {}", httpMethod, path);


        Execution execution = ConfigurationManager.instance.getExecution(path, httpMethod);

        return execution;
    }

    /**
     * This method returns HandlerController.
     *
     * @param execution execution.
     * @return HandlerControllerImpl.
     */
    public static HandlerControllerImpl getHandlerController(Execution execution) {
        HandlerControllerImpl handlerController = new HandlerControllerImpl();
        Class c = null;
        String controllerName = execution.getClassPackage();
        try {
            c = Class.forName(controllerName);
            LOG.debug("Class c: {}", c.getCanonicalName());
            Object target = c.newInstance();
            handlerController.setTarget(target);
            LOG.debug("handlerController Target: {}", handlerController.getTarget());

            String methodName = execution.getMethodName();
            Method method = target.getClass().getMethod(methodName, HttpServletRequest.class);
            handlerController.setMethod(method);
            LOG.debug("handlerController Method: {}", handlerController.getMethod());

            return handlerController;

        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
