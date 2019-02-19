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
 * RFID-Tag.
  */
@Path("/rfidtags/{uid}")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@XmlRootElement
public class RFIDTagConfig implements ECB1Api {

    /**
     * Enumeration, which consists of the type of the RFID.
     */
    @XmlEnum
    public enum Type {
        @XmlEnumValue("base")
        BASE,
        @XmlEnumValue("1")
        ONE,
        @XmlEnumValue("2")
        TWO,
        @XmlEnumValue("3")
        THREE,
        @XmlEnumValue("vip")
        VIP,
        @XmlEnumValue("disabled")
        DISABLED,
    }

    /**
     * The uid of the RFID.<br>
     * Needed as a path parameter for the RESTful Web Service.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "uid", required = true)
    @PathParam("uid")
    private String uid;

    /**
     * Reference to {@link Type}.<br>
     * Contains RFID types.
     */
    @XmlElement(name = "type")
    @FormParam("type")
    private Type type;

    /**
     * The RFID description.
     */
    @XmlElement(name = "description")
    @FormParam("description")
    private String description;

    /**
     * The date-time of creation.
     */
    @XmlElement(name = "created")
    @FormParam("created")
    private String created;

    /**
     * The date-time of last RFID modification.
     */
    @XmlElement(name = "modified")
    @FormParam("modified")
    private String modified;

    /**
     * Default constructor.
     */
    public RFIDTagConfig() {
    }

    /**
     * Initializes {@link #uid}, {@link #type}, {@link #description},
     * {@link #created} and {@link #modified} from {@link RFIDTagConfig} with
     * the given uid, type, description, created and modified parameters.
     *
     * @param uid the uid of the RFID
     * @param type the type of the RFID
     * @param description the description of the RFID
     * @param created the date-time of creation
     * @param modified the date-time of last modification
     */
    public RFIDTagConfig(String uid, Type type, String description, String created, String modified) {
        this.uid = uid;
        this.type = type;
        this.description = description;
        this.created = created;
        this.modified = modified;
    }

    public String getUid() {
        return uid;
    }

    /**
     * Get the RFID {@link Type}.
     *
     * @return a {@link #type} response
     * @see #type
     */
    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    @Override
    public String toString() {
        return "RFIDTagConfig{" + "uid=" + uid + ", type=" + type + ", description=" + description + ", created=" + created + ", modified=" + modified + '}';
    }

}
