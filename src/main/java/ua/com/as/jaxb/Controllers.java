package ua.com.as.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Controllers objects that need to convert from xml file.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Controllers implements Cloneable {

    @XmlElement(name = "controller")
    private List<Controller> controllers;

    /**
     * Getter.
     * @return list of controller.
     */
    public List<Controller> getControllers() {
        return controllers;
    }

    /**
     * Setter.
     * @param controllers set new parameter.
     */
    public void setControllers(List<Controller> controllers) {
        this.controllers = controllers;
    }

    /**
     * Method create a clone of controllers.
     * @return clone
     */
    public Controllers clone() {
        try {
            return (Controllers) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
