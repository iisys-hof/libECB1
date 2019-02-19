package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns maximum current in ampere on the main supply.
  */
@Path("/chargecontrol/mainsupply/maxcurrent")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllerMainSupplyMaxCurrent implements ECB1Api {

    /**
     * Maximum current in ampere in the main supply.<br>
     * Needed as a path parameter for the RESTful Web Service.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "maxcurrent", required = true)
    @FormParam("maxcurrent")
    private int maxCurrent;

    /**
     * Default constructor
     */
    public ChargeControllerMainSupplyMaxCurrent() {
    }

    /**
     * Initializes {@link #maxCurrent} of
     * {@link ChargeControllerMainSupplyMaxCurrent} with the given maxCurrent
     * value.
     *
     * @param maxCurrent maximum current in ampere in the main supply
     */
    public ChargeControllerMainSupplyMaxCurrent(int maxCurrent) {
        this.maxCurrent = maxCurrent;
    }

    public int getMaxCurrent() {
        return maxCurrent;
    }

    @Override
    public String toString() {
        return "ChargeControllerMainSupplyMaxCurrent{" + "maxCurrent=" + maxCurrent + '}';
    }

}
