package ua.com.as.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.as.model.Execution;
import ua.com.as.service.HandlerMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/**
 *
 */
public class DispatcherServlet extends HttpServlet {


    private static final Logger LOG = LoggerFactory.getLogger(DispatcherServlet.class);
    private static final int PAGE_OK = 200;


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("Method doGet. HttpServletRequest: Request PathInfo {}", req.getPathInfo());

        Execution execution = HandlerMapper.getExecution(req);
        LOG.debug("Execution MethodName: {}", execution.getMethodName());

        HandlerControllerImpl handlerController = HandlerMapper.getHandlerController(execution);
        LOG.debug("HandlerControllerImpl getMethod: {}", handlerController.getMethod());
        try {
            String result = handlerController.run(req);

            resp.setStatus(PAGE_OK);
            PrintWriter printWriter = resp.getWriter();
            LOG.debug("Response print write:{}", printWriter);
            LOG.debug("Response:{}", resp.toString());
            resp.getWriter().print(result);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Execution execution = HandlerMapper.getExecution(req);
        HandlerControllerImpl handlerController = HandlerMapper.getHandlerController(execution);
        try {
            String result = handlerController.run(req);
            resp.getWriter().write(result);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Execution execution = HandlerMapper.getExecution(req);
        HandlerControllerImpl handlerController = HandlerMapper.getHandlerController(execution);
        try {
            String result = handlerController.run(req);
            resp.getWriter().write(result);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Execution execution = HandlerMapper.getExecution(req);
        HandlerControllerImpl handlerController = HandlerMapper.getHandlerController(execution);
        try {
            String result = handlerController.run(req);
            resp.getWriter().write(result);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
