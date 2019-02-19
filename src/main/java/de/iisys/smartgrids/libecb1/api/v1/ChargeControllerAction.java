package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Start or permit charging of connected electric vehicle on this socket.
  */
@Path("/chargecontrols/{id}/{action}")
@XmlRootElement
public class ChargeControllerAction implements ECB1Api {

    /**
     * Enumeration, which consists of actions on the charging controller.
     */
    @XmlEnum
    public enum Action {
        @XmlEnumValue("start")
        START,
        @XmlEnumValue("stop")
        STOP,
    }

    /**
     * The id of the charge controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * The action to perform on the charging controller.<br>
     * Reference to {@link Action}.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("action")
    private Action action;

    /**
     * Default constructor.
     */
    public ChargeControllerAction() {
    }

    /**
     * Initializes {@link #id} and {@link #action} of
     * {@link ChargeControllerAction} with the given id and action.
     *
     * @param id the id of the charging controller
     * @param action the action to perform
     */
    public ChargeControllerAction(int id, Action action) {
        this.id = id;
        this.action = action;
    }

    @Override
    public String toString() {
        return "ChargeControllerAction{" + '}';
    }

}
