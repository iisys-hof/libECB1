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
 * Returns and sets maximum ampere in case of charging mode manual
  */
@Path("/chargecontrols/{id}/mode/manual/ampere")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllerModeManualAmpere implements ECB1Api {

    /**
     * The id of the charging controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * The maximum ampere value in case of charging mode manual.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @FormParam("manualmodeamp")
    @XmlElement(name = "manualmodeamp")
    private double manualModeAmp;

    /**
     * Default constructor.
     */
    public ChargeControllerModeManualAmpere() {
    }

    /**
     * Initializes {@link #id} of {@link ChargeControllerModeManualAmpere} with
     * the given id.
     *
     * @param id the id of the charging controller
     */
    public ChargeControllerModeManualAmpere(int id) {
        this.id = id;
    }

    /**
     * Initializes {@link #id} and {@link #manualModeAmp} of
     * {@link ChargeControllerModeManualAmpere} with the given id and
     * manualModeAmp value.
     *
     * @param id the id of the charging controller
     * @param manualModeAmp the maximum ampere value in case of charging mode
     * manual
     */
    public ChargeControllerModeManualAmpere(int id, double manualModeAmp) {
        this.id = id;
        this.manualModeAmp = manualModeAmp;
    }

    public double getManualModeAmp() {
        return manualModeAmp;
    }

    @Override
    public String toString() {
        return "ChargeControllerModeManualAmpere{" + "manualModeAmp=" + manualModeAmp + '}';
    }

}
