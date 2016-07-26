package ua.com.as.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.as.exception.ConfigurationException;
import ua.com.as.jaxb.Controller;
import ua.com.as.jaxb.Controllers;
import ua.com.as.jaxb.Rest;
import ua.com.as.model.Execution;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton for ConfigurationManager.
 */
public enum ConfigurationManager {
    /**
     * name of singleton.
     */
    instance;

    private Map<String, Map<String, Execution>> map;
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationManager.class);

    /**
     * Method allows check if instance null and create instance of controllers.
     *
     * @param controllers data about controllers.
     */
    public void saveControllersConfiguration(Controllers controllers) {
        if (map != null) {
            throw new IllegalStateException("Already instantiated");
        }
        map = new HashMap<>();
        for (Controller controller : controllers.getControllers()) {
            for (Rest rest : controller.getRests()) {
                Map<String, Execution> actionExecutionMap = map.get(rest.getPath());
                if (actionExecutionMap == null) {
                    actionExecutionMap = new HashMap<>();
                    map.put(rest.getPath(), actionExecutionMap);
                }
                Execution execution = new Execution(controller.getClassName(), controller.getClassPackage(),
                        rest.getMethod().getName());
                actionExecutionMap.put(rest.getAction(), execution);
            }
        }
    }

    /**
     * Method allows to get execution by path and action.
     * @param path - rest;
     * @param action - http method;
     * @return execution ;
     */
    public Execution getExecution(String path, String action) {
        LOG.debug("try to find execution with path " + path + " and action " + action);
        Map<String, Execution> executionMap = map.get(path);
        if (executionMap == null) {
            throw new ConfigurationException("No actions for such path");
        }
        Execution execution = executionMap.get(action);
        if (execution == null) {
            throw new ConfigurationException("No executions for such path and action");
        }
        return execution;
    }
}
