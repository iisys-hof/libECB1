package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerConfig.Type;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerConfig.Vendor;
import java.util.Arrays;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns list of electric vehicle charging controllers.
  */
@Path("/chargecontrols")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllers implements ECB1Api {

    /**
     * Reference to {@link Vendor}.<br>
     * Contains Enumeration, which consists of vendors. Used as a filter to get
     * the current state of the charging controllers of the eCB1 charging
     * points.
     */
    @QueryParam("vendor")
    private Vendor vendor;

    /**
     * Reference to {@link Type}.<br>
     * Contains Enumeration, which consists of types.<br>
     * Used as a filter to get the current state of the charging controllers of
     * the eCB1 charging points.
     */
    @QueryParam("type")
    private Type type;

    /**
     * Array reference to {@link ChargeControllerConfig}.<br>
     * Contains charging controller settings.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "chargecontrols", required = true)
    private ChargeControllerConfig[] chargeControls;

    /**
     * Default constructor
     */
    public ChargeControllers() {
    }

    /**
     * Initializes {@link #vendor} and {@link #type} of
     * {@link ChargeControllers} with the given vendor and type object.
     *
     * @param vendor the vendors of the charge controller
     * @param type the types of the charge controller
     */
    public ChargeControllers(Vendor vendor, Type type) {
        this.vendor = vendor;
        this.type = type;
    }

    public ChargeControllerConfig[] getChargeControls() {
        return chargeControls;
    }

    @Override
    public String toString() {
        return "ChargeControllers{" + "chargeControls=" + Arrays.toString(chargeControls) + '}';
    }

}
