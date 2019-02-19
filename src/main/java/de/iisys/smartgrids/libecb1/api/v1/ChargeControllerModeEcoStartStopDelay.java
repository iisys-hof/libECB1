package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns delay for automatic charging start and stop.
  */
@Path("/chargecontrols/{id}/mode/eco/startstop/delay")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllerModeEcoStartStopDelay implements ECB1Api {

    /**
     * The id of the charging controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * The delay value for automatic charging start and stop.<br>
     * Needed as a path parameter for the RESTful Web Service.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "delay", required = true)
    @FormParam("delay")
    private double delay;

    /**
     * Default constructor.
     */
    public ChargeControllerModeEcoStartStopDelay() {
    }

    /**
     * Initializes {@link #id} of {@link ChargeControllerModeEcoStartStopDelay}
     * with the given id.
     *
     * @param id the id of the charging controller
     */
    public ChargeControllerModeEcoStartStopDelay(int id) {
        this.id = id;
    }

    /**
     * Initializes {@link #id} and {@link delay} of
     * {@link ChargeControllerModeEcoStartStopDelay} with the given id and delay
     * value.
     *
     * @param id the id of the charging controller
     * @param delay delay for automatic charging start and stop.
     */
    public ChargeControllerModeEcoStartStopDelay(int id, double delay) {
        this.id = id;
        this.delay = delay;
    }

    public int getId() {
        return id;
    }

    public double getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return "ChargeControllerModeEcoStartStop{" + "id=" + id + ", delay=" + delay + '}';
    }

}
