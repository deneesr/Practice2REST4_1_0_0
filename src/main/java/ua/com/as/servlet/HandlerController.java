package ua.com.as.servlet;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * The {@code HandlerController} interface provides that classes have to make implementation
 * for the inputted HttpServletRequest and returned String for HttpServletResponse.
 *
 * @author Denis Rogovskiy
 */
public interface HandlerController {

    /**
     * This method returns the result of the controller method through reflection.
     *
     * @param request HttpServletRequest.
     * @return String for HttpServletResponse.
     * @throws InvocationTargetException throws InvocationTargetException.
     * @throws IllegalAccessException    throws IllegalAccessException.
     */

    String run(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException;
}
