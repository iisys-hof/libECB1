package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns rfid tag by uid.
  */
@Path("/rfidtags/{uid}")
@XmlRootElement
public class RFIDTag implements ECB1Api {

    /**
     * The RFID uid.
     */
    @PathParam("uid")
    private int uid;

    /**
     * The RFID tag.
     */
    @XmlElement(name = "tag")
    private RFIDTagConfig tag;

    /**
     * Default constructor.
     */
    public RFIDTag() {
    }

    /**
     * Initializes {@link #uid} of {@link RFIDTag} with the given uid.
     *
     * @param uid the id of the charging controller
     */
    public RFIDTag(int uid) {
        this.uid = uid;
    }

    /**
     * Get the RFID Tag.
     *
     * @return {@link #tag}
     * @see #tag
     */
    public RFIDTagConfig getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "RFIDTag{" + "tag=" + tag + '}';
    }

}
