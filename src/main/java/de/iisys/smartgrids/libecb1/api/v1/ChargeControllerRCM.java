package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns if an Residual Current Monitoring (RCM) module is configured.
  */
@Path("/chargecontrols/{id}/rcm")
@XmlRootElement
public class ChargeControllerRCM implements ECB1Api {

    /**
     * The id of the charging controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * Default constructor
     */
    public ChargeControllerRCM() {
    }

    /**
     * Initializes {@link #id} of {@link ChargeControllerRCM} with the given id.
     *
     * @param id the id of the charging controller
     */
    public ChargeControllerRCM(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ChargeControllerRCM{" + "id=" + id + '}';
    }

}
