package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns power offset in watt for controll of eco mode.
  */
@Path("/chargecontrol/mode/eco/poweroffset")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllerModeEcoPowerOffset implements ECB1Api {

    /**
     * Power offset in watt for controll of eco mode.<br>
     * Needed as a path parameter for the RESTful Web Service.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "poweroffset", required = true)
    @FormParam("poweroffset")
    private int powerOffset;

    /**
     * Default constructor.
     */
    public ChargeControllerModeEcoPowerOffset() {
    }

    /**
     * Initializes {@link #powerOffset} of
     * {@link ChargeControllerModeEcoPowerOffset} with the given powerOffset
     * value.
     *
     * @param powerOffset
     */
    public ChargeControllerModeEcoPowerOffset(int powerOffset) {
        this.powerOffset = powerOffset;
    }

    public int getPowerOffset() {
        return powerOffset;
    }

    @Override
    public String toString() {
        return "ChargeControllerModeEcoPowerOffset{" + "powerOffset=" + powerOffset + '}';
    }

}
