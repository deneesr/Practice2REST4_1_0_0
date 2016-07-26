package ua.com.as.exception;

/**
 * Configuration exception class.
 */
public class ConfigurationException extends RuntimeException {
    /**
     * Constructor.
     * @param message string for user.
     */
    public ConfigurationException(String message) {
        super(message);
    }
}
