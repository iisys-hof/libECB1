package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns electric vehicle charging controller by id.
  */
@Path("/chargecontrols/{id}")
@XmlRootElement
public class ChargeController implements ECB1Api {

    /**
     * The id of the charge controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * Reference to {@link ChargeControllerConfig}.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "chargecontrol", required = true)
    private ChargeControllerConfig chargeControl;

    /**
     * Default Constructor
     */
    public ChargeController() {
    }

    /**
     * Initializes the id of {@link ChargeController by the given id.
     *
     * @param id the id of the charger controller @see #id
     */
    public ChargeController(int id) {
        this.id = id;
    }

    /**
     * get the current {@link ChargeControllerConfig}.
     *
     * @return {@link #chargeControl}
     * @see #chargeControl
     */
    public ChargeControllerConfig getChargeControl() {
        return chargeControl;
    }

    @Override
    public String toString() {
        return "ChargeController{" + "chargeControl=" + chargeControl + '}';
    }

}
