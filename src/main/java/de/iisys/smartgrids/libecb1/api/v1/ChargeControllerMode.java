package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns and sets current charging mode.
  */
@Path("/chargecontrols/{id}/mode")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllerMode implements ECB1Api {

    /**
     * Enumeration, which consists of charging point modes.
     */
    @XmlEnum
    public enum Mode {
        @XmlEnumValue("eco")
        ECO,
        @XmlEnumValue("quick")
        QUICK,
        @XmlEnumValue("manual")
        MANUAL,
    }

    /**
     * The id of the charging point.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * Reference to {@link Mode}.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @FormParam("mode")
    @XmlElement(name = "mode")
    private Mode mode;

    /**
     * Default constructor
     */
    public ChargeControllerMode() {
    }

    /**
     * Initializes {@link #id} of {@link ChargeControllerMode} with the given
     * id.
     *
     * @param id the id of the charging point
     */
    public ChargeControllerMode(int id) {
        this.id = id;
    }

    /**
     * Initializes {@link #id} and {@link #mode} of {@link ChargeControllerMode}
     * with the given id and mode.
     *
     * @param id the id of the charging point
     * @param mode the mode of the charging point
     */
    public ChargeControllerMode(int id, Mode mode) {
        this.id = id;
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }

    @Override
    public String toString() {
        return "ChargeControllerMode{" + "mode=" + mode + '}';
    }

}
