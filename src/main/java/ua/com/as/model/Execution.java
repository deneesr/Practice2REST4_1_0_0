package ua.com.as.model;

/**
 *
 */
public class Execution {
    private String className;
    private String classPackage;
    private String methodName;

    /**
     * Class constructor.
     * @param className - name of class;
     * @param classPackage - name of package;
     * @param methodName - name of method;
     */
    public Execution(String className, String classPackage, String methodName) {
        this.className = className;
        this.classPackage = classPackage;
        this.methodName = methodName;
    }

    /**
     * Getter.
     * @return className;
     */
    public String getClassName() {
        return className;
    }

    /**
     * Setter.
     * @param className set new parameter;
     */

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Getter.
     * @return class package;
     */
    public String getClassPackage() {
        return classPackage;
    }

    /**
     * Setter.
     * @param classPackage set new parameter;
     */
    public void setClassPackage(String classPackage) {
        this.classPackage = classPackage;
    }

    /**
     * Getter.
     * @return method name;
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Setter.
     * @param methodName set new parameter;
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
