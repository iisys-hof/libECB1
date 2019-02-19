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
 * Returns authentication method of this socket.
  */
@Path("/chargecontrols/{id}/authentication")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class ChargeControllerAuthentication implements ECB1Api {

    /**
     * Enumeration, which consists of the authentification method of the
     * charging controller.
     */
    @XmlEnum
    public enum Authentication {
        @XmlEnumValue("none")
        NONE,
        @XmlEnumValue("rfid")
        RFID,
    }

    /**
     * The id of the charging controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * Reference to {@link Authentication}.<br>
     * Needed as a path parameter for the RESTful Web Service.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "authentication", required = true)
    @FormParam("authentication")
    private Authentication authentication;

    /**
     * Default constructor.
     */
    public ChargeControllerAuthentication() {
    }

    /**
     * Initializes {@link #id} of {@link ChargeControllerAuthentication} with
     * the given id.
     *
     * @param id the id of the charging controller
     */
    public ChargeControllerAuthentication(int id) {
        this.id = id;
    }

    /**
     * Initializes {@link #id} and {@link #authentication} of
     * {@link ChargeControllerAuthentication} with the given id and
     * authentication.
     *
     * @param id the id of the charging controller
     * @param authentication the type of authentification
     */
    public ChargeControllerAuthentication(int id, Authentication authentication) {
        this.id = id;
        this.authentication = authentication;
    }

    public int getId() {
        return id;
    }

    /**
     * get the current authentification method of the charging controller
     *
     * @return authentication the authentification method of the charging
     * controller
     */
    public Authentication getAuthentication() {
        return authentication;
    }

    @Override
    public String toString() {
        return "ChargeControllerAuthentication{" + "id=" + id + ", authentication=" + authentication + '}';
    }

}
