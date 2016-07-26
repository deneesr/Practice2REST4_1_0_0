package ua.com.as.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The {@code HandlerControllerImpl} class implements object that contain Object target
 * and Method method for run method of controller.
 *
 * @author Denis Rogovskiy
 */
public class HandlerControllerImpl implements HandlerController {

    private static final Logger LOG = LoggerFactory.getLogger(HandlerControllerImpl.class);

    private Object target;
    private Method method;

    @Override
    public String run(HttpServletRequest request)  {
        Object temp = null;
        try {
            temp = method.invoke(target, request);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return (String) temp;
    }

    /**
     * @return Object target
     */

    public Object getTarget() {
        return target;
    }

    /**
     * @param target Object target.
     */

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * @return Method method.
     */
    public Method getMethod() {
        return method;
    }

    /**
     * @param method Method method.
     */
    public void setMethod(Method method) {
        this.method = method;
    }
}
