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
 * Returns whether charging mode eco automatic charging start and stop is
 * enabled (AI-mode).
  */
@Path("/chargecontrols/{id}/mode/eco/startstop")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllerModeEcoStartStop implements ECB1Api {

    /**
     * The id of the charging controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * Contains whether charging mode eco automatic charging start and stop is
     * enabled (AI-mode).<br>
     * Needed as a path parameter for the RESTful Web Service.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "autostartstop", required = true)
    @FormParam("autostartstop")
    private boolean autoStartStop;

    /**
     * Default constructor.
     */
    public ChargeControllerModeEcoStartStop() {
    }

    /**
     * Initializes {@link #id} of {@link ChargeControllerModeEcoStartStop} with
     * the given id.
     *
     * @param id the id of the charging controller
     */
    public ChargeControllerModeEcoStartStop(int id) {
        this.id = id;
    }

    /**
     * Initializes {@link #id} and {@link #autoStartStop} of
     * {@link ChargeControllerModeEcoStartStop} with the given id and
     * autoStartStop value.
     *
     * @param id the id of the charging controller
     * @param autoStartStop Contains whether charging mode eco automatic
     * charging start and stop is enabled (AI-mode)
     */
    public ChargeControllerModeEcoStartStop(int id, boolean autoStartStop) {
        this.id = id;
        this.autoStartStop = autoStartStop;
    }

    public int getId() {
        return id;
    }

    public boolean isAutoStartStop() {
        return autoStartStop;
    }

    @Override
    public String toString() {
        return "ChargeControllerModeEcoStartStop{" + "id=" + id + ", autoStartStop=" + autoStartStop + '}';
    }

}
