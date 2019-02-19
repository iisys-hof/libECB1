package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns and sets current PV charging mode.
  */
@Path("/pvmode")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class PVMode implements ECB1Api {

    /**
     * Enumeration, which consists of charging modes.<br>
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
     * Charging {@link Mode} reference.
     */
    @FormParam("pvmode")
    @XmlElement(name = "pvmode")
    private Mode pvMode;

    /**
     * Default constructor.
     */
    public PVMode() {
    }

    /**
     * Initializes {@link #pvMode} of {@link Mode} with the given pvMode mode.
     *
     * @param pvMode the pv charging mode
     */
    public PVMode(Mode pvMode) {
        this.pvMode = pvMode;
    }

    /**
     * Get the current PV charging {@link Mode}.
     *
     * @return an {@link #pvMode} response
     * @see #pvMode
     */
    public Mode getPVMode() {
        return pvMode;
    }

    @Override
    public String toString() {
        return "PVMode{" + "pvMode=" + pvMode + '}';
    }

}
