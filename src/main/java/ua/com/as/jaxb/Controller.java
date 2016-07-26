package ua.com.as.jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Controller object that need to convert from xml file.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Controller {

    @XmlAttribute
    private String className;

    @XmlAttribute
    private String classPackage;

    @XmlElement(name = "rest")
    private List<Rest> rests;


    private Map<String, Rest> restMap;

    /**
     * Getter.
     * @return field className.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Setter.
     * @param className set a new className.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Getter.
     * @return classPackage.
     */
    public String getClassPackage() {
        return classPackage;
    }

    /**
     *  Setter.
     * @param classPackage set new classPackage.
     */
    public void setClassPackage(String classPackage) {
        this.classPackage = classPackage;
    }

    /**
     *Getter.
     * @return list of rest methods.
     */
    public List<Rest> getRests() {
        return rests;
    }

    /**
     * Setter.
     * @param rests set new list.
     */
    public void setRests(List<Rest> rests) {
        this.rests = rests;
    }
}
